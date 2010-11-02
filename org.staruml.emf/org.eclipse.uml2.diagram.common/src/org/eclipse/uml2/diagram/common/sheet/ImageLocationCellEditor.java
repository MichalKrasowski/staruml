package org.eclipse.uml2.diagram.common.sheet;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.ui.dialogs.WorkspaceResourceDialog;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

public class ImageLocationCellEditor extends TextAndDialogCellEditor {

	private static final String[] myImageFileExtensions = new String[] { "svg", "gif", "png", "jpg", "wmf", "bmp", "emf" }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$

	private final ViewerFilter myViewFilter = new ImageFileFilter(myImageFileExtensions);

	private URI myProfileResourceURI;

	public ImageLocationCellEditor(EObject source, Composite composite, ILabelProvider labelProvider) {
		super(composite, labelProvider);
		Resource eResource = source.eResource();
		URIConverter uriConverter = eResource.getResourceSet().getURIConverter();
		myProfileResourceURI = uriConverter.normalize(eResource.getURI());
	}

	@Override
	protected Object openDialogBox(Control cellEditorWindow) {
		String currentLocation = (String) getValue();
		Object[] initialSelection = null;
		if (currentLocation != null) {
			try {
				IFile file = getFileForProfileRelativeLocation(currentLocation);
				if (file != null) {
					initialSelection = new Object[] { file };
				}
			} catch (Exception e) {
				// ignore
			}
		}
		IFile[] files = WorkspaceResourceDialog.openFileSelection(cellEditorWindow.getShell(), null, null, false, initialSelection, Collections.<ViewerFilter> singletonList(myViewFilter));
		if (files != null && files.length > 0) {
			return getRelativeLocationForFile(files[0]);
		}
		return null;
	}

	private IFile getFileForProfileRelativeLocation(String location) {
		URI uri = URI.createURI(location).resolve(myProfileResourceURI);
		IResource workspaceResource = getResource(uri);
		if (workspaceResource != null && workspaceResource instanceof IFile) {
			return (IFile) workspaceResource;
		}
		return null;
	}

	private String getRelativeLocationForFile(IFile file) {
		// we assume, that here file cannot be null, because the Image should be
		// contained in some file
		IProject profileProject = getResource(myProfileResourceURI).getProject();
		IPath filePath = file.getFullPath();
		IPath profilePath = profileProject.getFullPath(); 
		if (profilePath.isPrefixOf(filePath)) {
			return filePath.makeRelativeTo(profilePath).toString();
		}
		return URI.createPlatformResourceURI(filePath.toString(), false).toString();
	}

	private static IResource getResource(URI uri) {
		String fileName = uri.toFileString();
		if (fileName != null) {
			return ResourcesPlugin.getWorkspace().getRoot().getFileForLocation(new Path(fileName));
		}
		if (uri.isPlatformResource()) {
			String path = uri.toPlatformString(false);
			return ResourcesPlugin.getWorkspace().getRoot().findMember(new Path(path));
		}
		return null;
	}

	private class ImageFileFilter extends ViewerFilter {

		private final List<String> myFileExtensions;

		public ImageFileFilter(String... extensions) {
			myFileExtensions = Arrays.asList(extensions);
		}

		@Override
		public boolean select(Viewer viewer, Object parentElement, Object element) {
			if (element instanceof IFile) {
				IFile file = (IFile) element;
				String fileExtension = file.getFullPath().getFileExtension().toLowerCase();
				return myFileExtensions.contains(fileExtension);
			}
			if (element instanceof Resource) {
				Resource res = (Resource) element;
				String fileExtension = res.getURI().fileExtension().toLowerCase();
				return myFileExtensions.contains(fileExtension);
			}
			return true;
		}

	}

}
