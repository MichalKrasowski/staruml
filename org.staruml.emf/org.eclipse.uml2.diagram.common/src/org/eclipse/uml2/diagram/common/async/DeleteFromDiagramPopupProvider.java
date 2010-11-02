package org.eclipse.uml2.diagram.common.async;

import org.eclipse.gmf.runtime.common.core.service.IProvider;
import org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.AbstractContributionItemProvider;
import org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor;
import org.eclipse.jface.action.IAction;
import org.eclipse.ui.IWorkbenchPage;

public class DeleteFromDiagramPopupProvider extends AbstractContributionItemProvider implements IProvider {
	public static final String U2T_DELETE_FROM_DIAGRAM = "u2t_deleteFromDiagram";  //$NON-NLS-1$

	@Override
	protected IAction createAction(String actionId, IWorkbenchPartDescriptor partDescriptor) {
		IWorkbenchPage workbenchPage = partDescriptor.getPartPage();
		if (U2T_DELETE_FROM_DIAGRAM.equals(actionId)) {
			return new DeleteFromDiagramAction(workbenchPage);
		}
		return super.createAction(actionId, partDescriptor);
	}

}
