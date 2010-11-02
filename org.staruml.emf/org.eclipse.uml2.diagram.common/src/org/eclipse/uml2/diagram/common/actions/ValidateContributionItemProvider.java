package org.eclipse.uml2.diagram.common.actions;

import org.eclipse.emf.edit.ui.action.ValidateAction;
import org.eclipse.gmf.runtime.common.core.service.IProvider;
import org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.AbstractContributionItemProvider;
import org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.uml2.diagram.common.Messages;

public class ValidateContributionItemProvider extends AbstractContributionItemProvider implements IProvider {

	@Override
	protected IAction createAction(String actionId, IWorkbenchPartDescriptor partDescriptor) {
		if (ACTION_ID.equals(actionId)) {
			ValidateAction validateAction = new GMFValidateAction(partDescriptor.getPartPage());
			validateAction.updateSelection(getStructuredSelection(partDescriptor));
			return validateAction;
		}
		return super.createAction(actionId, partDescriptor);
	}

	@Override
	protected IMenuManager createMenuManager(String menuId, IWorkbenchPartDescriptor partDescriptor) {
		if (menuId.equals(GROUP_ID))
			return new MenuManager(GROUP_LABEL, GROUP_ID);
		return super.createMenuManager(menuId, partDescriptor);
	}
	
	public static final String GROUP_ID = "ValidateMenu"; //$NON-NLS-1$

	public static final String ACTION_ID = "ValidateAction"; //$NON-NLS-1$

	public static final String GROUP_LABEL = Messages.ValidateContributionItemProvider_action_validate;
}
