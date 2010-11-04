package org.eclipse.uml2.diagram.profile.action;

import org.eclipse.gmf.runtime.common.core.service.IProvider;
import org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.AbstractContributionItemProvider;
import org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.uml2.diagram.profile.part.CustomMessages;


public class DefineProfileItemProvider extends AbstractContributionItemProvider implements IProvider  {
	
	protected IAction createAction(String actionId,
			IWorkbenchPartDescriptor partDescriptor) {
		IWorkbenchPage workbenchPage = partDescriptor.getPartPage();	
		if (ACTION_DEFINE_PROFILE.equals(actionId)) {
			return new DefineProfileAction(workbenchPage);
		}
		return super.createAction(actionId, partDescriptor);
	}
	
	protected IMenuManager createMenuManager(
			String menuId,
			IWorkbenchPartDescriptor partDescriptor) {
			if (menuId.equals(MENU_PROFILE))
				return new MenuManager(LABEL_PROFILE_MENU, MENU_PROFILE);
			if (menuId.equals(MENU_PROFILE_GROUP))
				return new MenuManager(LABEL_PROFILE_GROUP, MENU_PROFILE_GROUP);
			return super.createMenuManager(menuId, partDescriptor);
	}

	public static final String MENU_PROFILE = "ProfileMenu";	 //$NON-NLS-1$
	public static final String LABEL_PROFILE_MENU = CustomMessages.DefineProfileItemProvider_profile_menu;

	public static final String MENU_PROFILE_GROUP = "ProfileGroup"; //$NON-NLS-1$
	public static final String LABEL_PROFILE_GROUP = CustomMessages.DefineProfileItemProvider_profile_group; 
	
	public static final String ACTION_DEFINE_PROFILE = "define_profile"; //$NON-NLS-1$

}
