package org.eclipse.uml2.diagram.common.links;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.uml2.diagram.common.preferences.UMLPreferencesConstants;

/*
 * This class is to get rid of litter Required Interface links. One RequiredInterface link can be shown on the diagram several times - the Genuine(original) 
 * going out of Classifier and Derived, which is got by Port#getRequireds(), going out of Port. 
 * We call links that are not RequiredInterface links Regular, they are untouched by our algorithm.   
 * This class allows user to manage such links. Either genuine, or derived, or both genuine and derived links can be hidden. 
 * Genuine links are hidden only if its derived exists on the diagram.    
 */
public class InterfaceLinkManager<T> {

	protected static boolean ourHideReferencedGenuine;

	protected static boolean ourHideDerived;
	
	protected final List<InterfaceLinkFilter<T>> myLinkManagers = new ArrayList<InterfaceLinkFilter<T>>(3);

	public InterfaceLinkManager(Collection<T> linkDescriptors, IPreferenceStore store) {
		refreshOptions(store);
		buildTable(linkDescriptors);		
	}

	public Collection<T> getFilteredLinkDescriptors() {
		Collection<T> result = new ArrayList<T>();
		for (InterfaceLinkFilter<T> manager: myLinkManagers) {
			result.addAll(manager.getFilteredLinks());
		}
		return result;
	}
	
	protected void initFilters() {
//		myLinkManagers.add(new RequiredInterfaceLinkFilter(ourHideDerived, ourHideReferencedGenuine));
//		myLinkManagers.add(new ProvidedInterfaceLinkFilter(ourHideDerived, ourHideReferencedGenuine));
//		myLinkManagers.add(new RegularLinkFilter(ourHideDerived, ourHideReferencedGenuine));
	}

	private static void refreshOptions(IPreferenceStore store) {
		ourHideDerived = store.getBoolean(UMLPreferencesConstants.PREF_MANAGE_REQUIRED_LINKS_HIDE_DERIVED);
		ourHideReferencedGenuine = store.getBoolean(UMLPreferencesConstants.PREF_MANAGE_REQUIRED_LINKS_HIDE_GENUINE);
	}

	private void buildTable(Collection<T> linkDescriptors) {
		initFilters();
		for (T next : linkDescriptors) {
			for (InterfaceLinkFilter<T> manager: myLinkManagers) {
				manager.visit(next);
			}
		}
	}

}
