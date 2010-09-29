package org.eclipse.uml2.diagram.csd.action;

import org.eclipse.gmf.runtime.common.core.service.IProvider;
import org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.AbstractContributionItemProvider;
import org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.ui.IWorkbenchPage;

public class ShowPropertyParametersItemProvider extends AbstractContributionItemProvider implements IProvider {
	
	public ShowPropertyParametersItemProvider() {
	}

	@Override
	protected IAction createAction(String actionId, IWorkbenchPartDescriptor partDescriptor) {
		IWorkbenchPage workbenchPage = partDescriptor.getPartPage();

		if (ShowPropertyParametersAction.ACTION_ID.equals(actionId)) {
			return new ShowPropertyParametersAction(workbenchPage);
		}

		return super.createAction(actionId, partDescriptor);
	}

	@Override
	protected IMenuManager createMenuManager(String menuId, IWorkbenchPartDescriptor partDescriptor) {
		if (menuId.equals(GROUP_ID))
			return new MenuManager(GROUP_LABEL, GROUP_ID);
		return super.createMenuManager(menuId, partDescriptor);
	}

	public static final String GROUP_ID = "ShowPropertyParametersGroup"; //$NON-NLS-1$

	public static final String GROUP_LABEL = "ShowPropertyParametersGroup";
}
