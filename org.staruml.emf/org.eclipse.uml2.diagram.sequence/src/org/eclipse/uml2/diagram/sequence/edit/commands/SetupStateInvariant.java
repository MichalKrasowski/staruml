package org.eclipse.uml2.diagram.sequence.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.uml2.uml.StateInvariant;


public class SetupStateInvariant extends SetupFragmentWithLifeLineCommand {

	public SetupStateInvariant(CreateElementRequest req) {
		super(req);
	}
	
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		CommandResult basicSetup = super.doExecuteWithResult(monitor, info);
		if (basicSetup.getStatus().isOK()){
			StateInvariant newElement = (StateInvariant) getCreatedFragment();
			if (newElement.getInvariant() == null){
				newElement.createInvariant("State");
			}
		}
		return basicSetup;
	}
	

}
