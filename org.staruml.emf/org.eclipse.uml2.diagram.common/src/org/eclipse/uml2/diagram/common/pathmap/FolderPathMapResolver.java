package org.eclipse.uml2.diagram.common.pathmap;

import java.io.File;
import java.util.Collection;

import org.eclipse.emf.common.util.URI;


public class FolderPathMapResolver extends PathMapResolver {

	@Override
	public Collection<String> getProfiles(URI uri, String pathmapVarName) throws Exception {
		File folder = new File(uri.toFileString());
		return getProfilesFromFolder(folder, pathmapVarName);
	}

	@Override
	public boolean isApplicable(URI uri) {
		return uri.isFile();
	}
	
}
