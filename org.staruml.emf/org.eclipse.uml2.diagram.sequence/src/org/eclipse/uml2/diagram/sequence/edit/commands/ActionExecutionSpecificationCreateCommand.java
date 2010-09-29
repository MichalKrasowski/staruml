package org.eclipse.uml2.diagram.sequence.edit.commands;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.uml2.uml.Action;
import org.eclipse.uml2.uml.ActionExecutionSpecification;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated NOT
 */
public class ActionExecutionSpecificationCreateCommand extends AbstractCreateFragmentCommand {

	/**
	 * @generated
	 */
	public ActionExecutionSpecificationCreateCommand(CreateElementRequest req) {
		super(req);
	}

	/**
	 * @generated NOT
	 */
	protected EObject getElementToEdit() {
		return super.getElementToEdit();
	}

	/**
	 * @generated
	 */
	protected EClass getEClassToEdit() {
		return UMLPackage.eINSTANCE.getInteraction();
	}

	@Override
	protected void afterDefaultElementCreation(InteractionFragment createdFragment) {
		ActionExecutionSpecification execution = (ActionExecutionSpecification) createdFragment;
		Interaction interaction = getInteraction();
		if (execution.getAction() == null) {
			Action action = interaction.createAction("Action", UMLPackage.eINSTANCE.getOpaqueAction());
			execution.setAction(action);
		}
	}

}
