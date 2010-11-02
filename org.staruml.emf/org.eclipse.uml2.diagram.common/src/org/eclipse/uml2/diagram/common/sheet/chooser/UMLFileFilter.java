package org.eclipse.uml2.diagram.common.sheet.chooser;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;


public class UMLFileFilter extends ViewerFilter {

	private static final String UML_FILE_EXTENSION = "uml"; //$NON-NLS-1$
	
	private final String myFileExtension;
	
	public UMLFileFilter(String fileExtension) {
		myFileExtension = fileExtension;
	}

	public UMLFileFilter() {
		this(UML_FILE_EXTENSION);
	}

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		if (element instanceof IFile) {
			IFile file = (IFile) element;
			String fileExtension = file.getFullPath().getFileExtension();
			return myFileExtension.equals(fileExtension); //$NON-NLS-1$
		}
		if (element instanceof Resource) {
			Resource res = (Resource) element;
			String fileExtension = res.getURI().fileExtension();
			return myFileExtension.equals(fileExtension); //$NON-NLS-1$
		}
		return true;
	}

}
