package org.eclipse.uml2.diagram.common.pathmap;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.osgi.util.NLS;
import org.eclipse.uml2.uml.resource.UMLResource;

public abstract class PathMapResolver {

	abstract public boolean isApplicable(URI uri);

	abstract public Collection<String> getProfiles(URI uri, String pathmapVarName) throws Exception;

	protected boolean isProfileFile(String fileName) {
		return fileName.endsWith(UMLResource.PROFILE_FILE_EXTENSION);
	}

	protected Collection<String> getProfilesFromFolder(File folder, String pathmapVarName) {
		if (!folder.isDirectory()) {
			return Collections.emptyList();
		}
		List<String> pathmaps = new ArrayList<String>();
		String[] files = folder.list();
		for (int i = 0; i < files.length; i++) {
			String currFile = files[i];
			if (isProfileFile(currFile)) {
				String pathmap = NLS.bind(PATHMAP_FORMAT, new Object[] { pathmapVarName, currFile });
				pathmaps.add(pathmap);
			}
		}
		return pathmaps;
	}

	protected static final String PATHMAP_FORMAT = "pathmap://{0}/{1}"; //$NON-NLS-1$

}
