package org.eclipse.uml2.diagram.sequence.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.UMLPackage;


public abstract class SetupFragmentWithLifeLineCommand extends EditElementCommand {
	public SetupFragmentWithLifeLineCommand(CreateElementRequest req){
		super("Attaching fragment to lifeline", null, req);
		setEClass(UMLPackage.eINSTANCE.getLifeline());
	}
	
	@Override
	public boolean canExecute() {
		if (!super.canExecute()){
			return false;
		}
		CreateElementRequest req = getCreateElementRequest();
		if (false == req.getContainer() instanceof Lifeline){
			return false;
		}
		Lifeline lifeline = (Lifeline)req.getContainer();
		return lifeline.getInteraction() != null;
	}
	
	@Override
	protected EObject getElementToEdit() {
		EObject container = ((CreateElementRequest) getRequest()).getContainer();
		if (container instanceof View) {
			container = ((View) container).getElement();
		}
		return container;
	}
	
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		CreateElementRequest req = getCreateElementRequest();
		if (false == req.getNewElement() instanceof InteractionFragment){
			throw new IllegalStateException("InteractionFragment expected: " + req.getNewElement());
		}
		
		InteractionFragment newFragment = (InteractionFragment) req.getNewElement();
		Lifeline lifeline = getLifeline();
		newFragment.getCovereds().add(lifeline);
		
		return CommandResult.newOKCommandResult();
	}
	
	protected CreateElementRequest getCreateElementRequest(){
		return (CreateElementRequest)getRequest();
	}

	protected Lifeline getLifeline(){
		return (Lifeline) getElementToEdit();
	}
	
	protected Interaction getInteraction(){
		return getLifeline().getInteraction();
	}
	
	protected InteractionFragment getCreatedFragment(){
		return (InteractionFragment) getCreateElementRequest().getNewElement();
	}
}
