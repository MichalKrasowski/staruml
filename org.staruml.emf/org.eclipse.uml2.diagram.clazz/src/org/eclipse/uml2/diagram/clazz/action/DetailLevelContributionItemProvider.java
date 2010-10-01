package org.eclipse.uml2.diagram.clazz.action;

import org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.AbstractContributionItemProvider;
import org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor;
import org.eclipse.gmf.runtime.common.core.service.IProvider;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.uml2.diagram.clazz.details.UMLDetailLevel;
import org.eclipse.uml2.diagram.clazz.details.UMLDetailLevelService;
import org.eclipse.uml2.diagram.clazz.part.CustomMessages;

public class DetailLevelContributionItemProvider extends AbstractContributionItemProvider implements IProvider {

	protected IAction createAction(String actionId, IWorkbenchPartDescriptor partDescriptor) {
		IWorkbenchPage workbenchPage = partDescriptor.getPartPage();
		UMLDetailLevel level = UMLDetailLevelService.getLevel(actionId);
		if (false == UMLDetailLevelService.EMPTY_LEVEL.equals(level)) {
			return new ChangeDetailLevel(workbenchPage, level);
		}
		return super.createAction(actionId, partDescriptor);
	}

	protected IMenuManager createMenuManager(String menuId, IWorkbenchPartDescriptor partDescriptor) {
		if (menuId.equals(MENU_DETAIL_LEVEL_GROUP))
			return new MenuManager(LABEL_DETAIL_LEVEL_GROUP, MENU_DETAIL_LEVEL_GROUP);
		if (menuId.equals(MENU_DETAIL_LEVEL))
			return new MenuManager(LABEL_DETAIL_LEVEL, MENU_DETAIL_LEVEL);
		return super.createMenuManager(menuId, partDescriptor);
	}

	public static final String MENU_DETAIL_LEVEL = "DetailLevelMenu"; //$NON-NLS-1$

	public static final String LABEL_DETAIL_LEVEL = CustomMessages.DetailLevelContributionItemProvider_detail_level;

	public static final String MENU_DETAIL_LEVEL_GROUP = "DetailLevelGroup"; //$NON-NLS-1$

	public static final String LABEL_DETAIL_LEVEL_GROUP = CustomMessages.DetailLevelContributionItemProvider_detail_level_group;
}
