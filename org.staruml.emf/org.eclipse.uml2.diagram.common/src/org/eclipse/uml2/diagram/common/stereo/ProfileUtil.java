package org.eclipse.uml2.diagram.common.stereo;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.uml2.uml.Profile;


public class ProfileUtil {

	private static final ResourceSet RESOURCE_SET = new ResourceSetImpl();

	public static Profile getProfile(Resource resource) {
		TreeIterator<EObject> allContents = resource.getAllContents();
		while (allContents.hasNext()) {
			EObject next = allContents.next();
			if (next instanceof Profile){
				return (Profile)next;
			}
		}
		return null;
	}
	
	public static Profile getProfile(IFile file) {
		URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
		return ProfileUtil.getProfile(RESOURCE_SET.getResource(uri, true));
	}

}
