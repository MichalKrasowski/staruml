package org.eclipse.uml2.diagram.common.pathmap;

import java.net.JarURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.eclipse.emf.common.util.URI;
import org.eclipse.osgi.util.NLS;


public class ArchivePathMapResolver extends PathMapResolver {

	@Override
	public Collection<String> getProfiles(URI uri, String pathmapVarName) throws Exception {
		URL url = new URL(uri.toString());
		JarURLConnection urlConnection = (JarURLConnection) url.openConnection();
		JarFile jarFile = urlConnection.getJarFile();
		JarEntry pathmapEntry = urlConnection.getJarEntry();
		if (!pathmapEntry.isDirectory()) {
			return Collections.emptyList();
		}
		List<String> pathmaps = new ArrayList<String>();
		String pathmapEntryName = pathmapEntry.getName();
		for (Enumeration<?> entries = jarFile.entries(); entries.hasMoreElements();) {
			JarEntry entry = (JarEntry) entries.nextElement();
			String entryName = entry.getName();
			if (entryName.startsWith(pathmapEntryName) && isProfileFile(entryName)) {
				String profileName = entryName;
				profileName = profileName.substring(pathmapEntryName.length());
				String pathmap = NLS.bind(PATHMAP_FORMAT, new Object[] { pathmapVarName, profileName});
				pathmaps.add(pathmap);
			}
		}
		return pathmaps;
	}

	@Override
	public boolean isApplicable(URI uri) {
		return uri.isArchive();
	}

}
