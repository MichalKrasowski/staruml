package org.eclipse.uml2.diagram.common.pathmap;

import java.util.Collection;

import org.eclipse.emf.common.util.URI;


public class PathMapService {
	
	private static PathMapService oursPathMapService = new PathMapService();
	private PathMapResolver myFolderResolver = new FolderPathMapResolver();
	private PathMapResolver myArchiveResolver = new ArchivePathMapResolver();
	private PathMapResolver myPlatformresourceResolver = new PlatformResourcePathMapResolver();
	private PathMapService() {
	}
	
	public static PathMapService getInstance() {
		return oursPathMapService;
	}
	
	public Collection<String> getProfiles(String varName, String varValue) throws Exception {
		URI uri = URI.createURI(varValue);
		if (myFolderResolver.isApplicable(uri)) {
			return myFolderResolver.getProfiles(uri, varName);
		}
		if (myArchiveResolver.isApplicable(uri)) {
			return myArchiveResolver.getProfiles(uri, varName);
		}
		if (myPlatformresourceResolver.isApplicable(uri)) {
			return myPlatformresourceResolver.getProfiles(uri, varName);
		}
		return null;
	}
}
