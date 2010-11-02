package org.eclipse.uml2.diagram.common.part;

import java.util.Collections;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.ui.model.WorkbenchContentProvider;

public class ModelElementsContentHelper {

	private static final ITreeContentProvider myWorkbenchContentProvider = new WorkbenchContentProvider();

	public static Object[] getChildren(Object parentElement, AdapterFactoryContentProvider contentProvier, ResourceSet resourceSet) {
		Object[] result = myWorkbenchContentProvider.getChildren(parentElement);
		if (result != null && result.length > 0) {
			return result;
		}
		if (parentElement instanceof IFile) {
			IFile modelFile = (IFile) parentElement;
			IPath resourcePath = modelFile.getFullPath();
			try {
				Resource modelResource = resourceSet.getResource(URI.createPlatformResourceURI(resourcePath.toString(), true), true);
				return contentProvier.getChildren(modelResource);
			} catch (WrappedException e) {
				System.err.println("Failed to get resource for filepath " + resourcePath.toString()); //$NON-NLS-1$
			}
			return Collections.EMPTY_LIST.toArray();
		}
		return contentProvier.getChildren(parentElement);
	}

}
