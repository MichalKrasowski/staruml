package org.eclipse.uml2.diagram.sequence.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.uml2.uml.Action;
import org.eclipse.uml2.uml.ActionExecutionSpecification;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.UMLPackage;


public class SetupActionExecutionSpecification extends SetupFragmentWithLifeLineCommand {

	public SetupActionExecutionSpecification(CreateElementRequest req) {
		super(req);
	}
	
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		CommandResult basicSetup = super.doExecuteWithResult(monitor, info);
		if (basicSetup.getStatus().isOK()){
			ActionExecutionSpecification newElement = (ActionExecutionSpecification) getCreatedFragment();
			Interaction interaction = getInteraction();
			if (newElement.getAction() == null){
				Action action = interaction.createAction("Action", UMLPackage.eINSTANCE.getOpaqueAction());
				newElement.setAction(action);
			}
		}
		return basicSetup;
	}
	

}
