package org.eclipse.uml2.diagram.common.pathmap;

import java.io.File;
import java.net.URL;
import java.util.Collection;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.emf.common.util.URI;


public class PlatformResourcePathMapResolver extends PathMapResolver {

	@Override
	public Collection<String> getProfiles(URI uri, String pathmapVarName) throws Exception {
		URL url = new URL(uri.toString());
		URL resolvedURL = FileLocator.resolve(url);
		File folder = new File(resolvedURL.getFile());
		return getProfilesFromFolder(folder, pathmapVarName);
	}

	@Override
	public boolean isApplicable(URI uri) {
		return uri.isPlatformResource();
	}

}
