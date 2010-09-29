package org.eclipse.uml2.diagram.csd.action;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.uml2.diagram.common.parameter.EditPropertyParametersDialog;
import org.eclipse.uml2.diagram.common.parameter.ShowPropertyParametersActionBase;
import org.eclipse.uml2.diagram.csd.part.UMLDiagramEditorPlugin;
import org.eclipse.uml2.uml.Operation;

public class ShowPropertyParametersAction extends ShowPropertyParametersActionBase {
	
	public static final String ACTION_ID = "show_property_parameters_action";//$NON-NLS-1$

	public ShowPropertyParametersAction(IWorkbenchPage workbenchPage) {
		super(workbenchPage);
	}
	
	
	@Override
	protected EditPropertyParametersDialog createDialog(Shell shell, Operation operation) {
		return new EditPropertyParametersDialog(shell, operation, UMLDiagramEditorPlugin.getInstance().getItemProvidersAdapterFactory());
	}

}
