package org.eclipse.uml2.diagram.common.stereo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.common.core.service.IProvider;
import org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.AbstractContributionItemProvider;
import org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.uml2.diagram.common.Messages;
import org.eclipse.uml2.diagram.common.stereo.ProfileRegistry.ProfileInfo;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.UMLPlugin;

public class ApplicableProfilesItemProvider extends AbstractContributionItemProvider implements IProvider {

	public static final String MENU_APPLY_PROFILE = "menu_apply_unapply_profile"; //$NON-NLS-1$

	@Override
	protected IMenuManager createMenuManager(String menuId, IWorkbenchPartDescriptor partDescriptor) {
		if (!MENU_APPLY_PROFILE.equals(menuId)) {
			return super.createMenuManager(menuId, partDescriptor);
		}
		MenuManager menuManager = new MenuManager(Messages.ApplicableProfilesItemProvider_apply_profile_menu);
		MenuBuilder builder = new MenuBuilder(partDescriptor);
		// XXX: build initial content -- otherwise menu is never shown
		builder.buildMenu(menuManager);

		menuManager.addMenuListener(builder);
		return menuManager;
	}

	private class MenuBuilder implements IMenuListener {

		private final IWorkbenchPartDescriptor myWorkbenchPart;

		public MenuBuilder(IWorkbenchPartDescriptor workbenchPart) {
			myWorkbenchPart = workbenchPart;
		}

		public void menuAboutToShow(IMenuManager manager) {
			buildMenu(manager);
		}

		public void buildMenu(IMenuManager manager) {
			manager.removeAll();
			GraphicalEditPart selected = (GraphicalEditPart) getSelectedObject(myWorkbenchPart);

			org.eclipse.uml2.uml.Package package_ = (org.eclipse.uml2.uml.Package) selected.getNotationView().getElement();
			loadProfilesFromUML2Registry(package_);

			List<Profile> profiles = getProfiles(package_);
			for (Profile profile : profiles) {
				// no much sense to cache dynamic target specific actions
				ApplyProfileAction action = new ApplyProfileAction(getWorkbenchPage(), package_, profile);
				action.init();
				manager.add(action);
			}
			
			Collection<ProfileInfo> profilesFromRegistry = getProfilesFromRegistry(package_);
			List<String> loadedProfileUris = new ArrayList<String>(profiles.size());
			for (Profile profile: profiles) {
				loadedProfileUris.add(EcoreUtil.getURI(profile).toString());
			}
			for (ProfileInfo profileInfo : profilesFromRegistry) {
				// filter profiles, that have already been loaded
				if (loadedProfileUris.contains(profileInfo.uri)) {
					continue;
				}
				ApplyProfileInfoAction action = new ApplyProfileInfoAction(getWorkbenchPage(), package_, profileInfo);
				action.init();
				manager.add(action);
			}
		}

		private void loadProfilesFromUML2Registry(org.eclipse.uml2.uml.Package package_) {
			ResourceSet resourceSet = package_.eResource().getResourceSet();
			for (URI profileURI : UMLPlugin.getEPackageNsURIToProfileLocationMap().values()) {
				try {
					resourceSet.getResource(profileURI.trimFragment(), true);
				} catch (Exception e) { // ignore
				}
			}
		}

		private IWorkbenchPage getWorkbenchPage() {
			return myWorkbenchPart.getPartPage();
		}
	}

	private List<Profile> getProfiles(final org.eclipse.uml2.uml.Package package_) {
		// copy of code from
		// org.eclipse.uml2.uml.editor.actions.ApplyProfileAction
		final List<Profile> choiceOfValues = new ArrayList<Profile>();

		ResourceSet resourceSet = package_.eResource().getResourceSet();

		for (Resource resource : resourceSet.getResources()) {
			Profile profile = ProfileUtil.getProfile(resource);
			if (profile != null) {
				choiceOfValues.add(profile);
			}
		}
		return choiceOfValues;

	}

	private Collection<ProfileInfo> getProfilesFromRegistry(org.eclipse.uml2.uml.Package package_) {
		return ProfileRegistry.getInstance().getProfiles();
	}

}
