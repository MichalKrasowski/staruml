package org.eclipse.uml2.diagram.csd.action;

import org.eclipse.gmf.runtime.common.core.service.IProvider;
import org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.AbstractContributionItemProvider;
import org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.uml2.diagram.csd.part.Messages;

/**
 * @generated
 */
public class Class3ContributionItemProvider extends AbstractContributionItemProvider implements IProvider {

	/**
	 * @generated
	 */
	@Override
	protected IAction createAction(String actionId, IWorkbenchPartDescriptor partDescriptor) {
		IWorkbenchPage workbenchPage = partDescriptor.getPartPage();

		if (TurnIntoClassAction.ACTION_ID.equals(actionId)) {
			return new TurnIntoClassAction(workbenchPage, actionId);
		}

		return super.createAction(actionId, partDescriptor);
	}

	/**
	 * @generated
	 */
	@Override
	protected IMenuManager createMenuManager(String menuId, IWorkbenchPartDescriptor partDescriptor) {
		if (menuId.equals(GROUP_ID))
			return new MenuManager(GROUP_LABEL, GROUP_ID);
		if (menuId.equals(MENU_ID))
			return new MenuManager(MENU_LABEL, MENU_ID);
		return super.createMenuManager(menuId, partDescriptor);
	}

	/**
	 * @generated
	 */
	public static final String MENU_ID = "ChangeNotationMenu"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final String MENU_LABEL = Messages.Class3ContributionItemProvider_menu;

	/**
	 * @generated
	 */
	public static final String GROUP_ID = "ChangeNotationGroup"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final String GROUP_LABEL = Messages.Class3ContributionItemProvider_group;
}
