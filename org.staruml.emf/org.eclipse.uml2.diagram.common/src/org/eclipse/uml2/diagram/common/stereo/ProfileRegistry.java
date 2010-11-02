package org.eclipse.uml2.diagram.common.stereo;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.osgi.util.NLS;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.WorkbenchException;
import org.eclipse.ui.XMLMemento;
import org.eclipse.uml2.diagram.common.UMLCommonPlugin;
import org.eclipse.uml2.diagram.common.preferences.UMLPreferencesConstants;
import org.eclipse.uml2.uml.Profile;

public class ProfileRegistry {

	private static ProfileRegistry myInstance;

	private final IPreferenceStore preferences;

	private static final String ELEMENT_PROFILE_REGISTRY = "profileRegistry"; //$NON-NLS-1$

	private static final String ELEMENT_PROFILE = "profile"; //$NON-NLS-1$

	private static final String ATTR_NAME = "name"; //$NON-NLS-1$

	private static final String ATTR_URI = "uri"; //$NON-NLS-1$

	private static final String ATTR_IS_BROKEN = "isBroken"; //$NON-NLS-1$

	private ProfileRegistry() {
		preferences = UMLCommonPlugin.getInstance().getPreferenceStore();
	}

	public static ProfileRegistry getInstance() {
		if (myInstance == null) {
			myInstance = new ProfileRegistry();
		}
		return myInstance;
	}

	public List<ProfileInfo> getProfiles() {
		XMLMemento rootMemento = getRootMemento();
		if (rootMemento == null) {
			return Collections.emptyList();
		}
		List<ProfileInfo> result = new ArrayList<ProfileInfo>();
		for (IMemento childMemento : rootMemento.getChildren(ELEMENT_PROFILE)) {
			ProfileInfo info = getProfileInfo(childMemento);
			if (info!=null) {
				result.add(info);
			}
		}
		return result;

	}

	public void addProfile(Profile profile) {
		XMLMemento rootMemento = getOrCreateRootMemento();
		IMemento memento = getMementoForProfile(rootMemento, getKey(profile));
		if (memento != null) {
			storeProfileInMemento(profile, memento);
		}
		String str = getXMLString(rootMemento);
		saveInPreferences(str);
	}
	
	public String getPreferencesString(ProfileInfo... profiles) {
		XMLMemento root = createRootMenu();
		if (profiles != null) {
			for (ProfileInfo profileInfo: profiles) {
				IMemento child = root.createChild(ELEMENT_PROFILE, profileInfo.uri);
				storeProfileInfoInMemento(profileInfo, child);
			}
		}
		return getXMLString(root);
	}

	private void markAsBroken(ProfileInfo info) {
		XMLMemento rootMemento = getOrCreateRootMemento();
		markMementoAsBroken(getMementoForProfile(rootMemento, info.uri));
		String str = getXMLString(rootMemento);
		saveInPreferences(str);
	}

	private String getXMLString(XMLMemento rootMemento) {
		StringWriter writer = new StringWriter();
		try {
			rootMemento.save(writer);
			return writer.toString();
		} catch (IOException e) {
			logError("Couldn't save Profile to Registry ", e); //$NON-NLS-1$
			return null;
		}
	}

	private IMemento getMementoForProfile(IMemento containerMemento, String profileKey) {
		IMemento[] childMementos = containerMemento.getChildren(ELEMENT_PROFILE);
		for (IMemento child : childMementos) {
			if (profileKey.equals(child.getString(ATTR_URI))) {
				return child;
			}
		}
		IMemento child = containerMemento.createChild(ELEMENT_PROFILE, profileKey);
		child.putString(ATTR_URI, profileKey);
		return child;
	}

	private XMLMemento getRootMemento() {
		String str = getRegistryFromPreferences();
		if (str == null || "".equals(str)) { //$NON-NLS-1$
			return null;
		}
		try {
			XMLMemento rootMemento = XMLMemento.createReadRoot(new StringReader(str));
			return rootMemento;
		} catch (WorkbenchException e) {
			logError("Couldn't get ProfileRegistry ", e); //$NON-NLS-1$
		}
		return null;
	}

	private XMLMemento getOrCreateRootMemento() {
		XMLMemento rootMemento = getRootMemento();
		if (rootMemento == null) {
			rootMemento = createRootMenu();
		}
		return rootMemento;
	}

	private XMLMemento createRootMenu() {
		return XMLMemento.createWriteRoot(ELEMENT_PROFILE_REGISTRY);
	}

	private void storeProfileInMemento(Profile profile, IMemento memento) {
		memento.putString(ATTR_URI, EcoreUtil.getURI(profile).toString());
		memento.putString(ATTR_NAME, profile.getName());
		memento.putBoolean(ATTR_IS_BROKEN, false);
	}

	private void storeProfileInfoInMemento(ProfileInfo profile, IMemento memento) {
		memento.putString(ATTR_URI, profile.uri);
		memento.putString(ATTR_NAME, profile.name);
		memento.putBoolean(ATTR_IS_BROKEN, profile.isBroken);
	}

	private void markMementoAsBroken(IMemento memento) {
		memento.putBoolean(ATTR_IS_BROKEN, true);
	}

	private ProfileInfo getProfileInfo(IMemento memento) {
		return new ProfileInfo(memento.getString(ATTR_URI), memento.getString(ATTR_NAME), memento.getBoolean(ATTR_IS_BROKEN));
	}

	private String getRegistryFromPreferences() {
		return preferences.getString(UMLPreferencesConstants.PREF_PROFILE_REGISTRY);
	}

	private void saveInPreferences(String str) {
		preferences.setValue(UMLPreferencesConstants.PREF_PROFILE_REGISTRY, str);
	}

	private String getKey(Profile profile) {
		return EcoreUtil.getURI(profile).toString();
	}
	
	private static void logError(String message, Throwable e) {
		UMLCommonPlugin.getInstance().getLog().log(new Status(IStatus.ERROR, UMLCommonPlugin.getPluginId(), message, e));
	}

	private static void logWarning(String message, Throwable e) {
		UMLCommonPlugin.getInstance().getLog().log(new Status(IStatus.WARNING, UMLCommonPlugin.getPluginId(), message, e));
	}
	
	public static class ProfileInfo {

		public final String uri;

		public final String name;
		
		public final boolean isBroken;
		
		private ProfileInfo(String uri, String name, boolean isBroken) {
			this.uri = uri;
			this.name = name;
			this.isBroken = isBroken;
		}
		
		public ProfileInfo(String uri, String name) {
			this.uri = uri;
			this.name = name;
			this.isBroken = false;
		}
		
		public final Profile getProfile(Resource resource) {
			try {
				return (Profile)resource.getResourceSet().getEObject(URI.createURI(uri), true);
			} catch (Exception e) {
				ProfileRegistry.getInstance().markAsBroken(this);
				logWarning(NLS.bind("Couldn't load {1} for URI {0}", new Object[]{name, uri}), e); //$NON-NLS-1$
			}
			return null; 
		}

	}

}
