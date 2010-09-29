package org.eclipse.uml2.diagram.statemachine.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.uml2.diagram.statemachine.edit.commands.InternalTransitionCreateCommand;
import org.eclipse.uml2.diagram.statemachine.providers.UMLElementTypes;

/**
 * @generated
 */

public class SubmachineState_InternalTransitionsItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public SubmachineState_InternalTransitionsItemSemanticEditPolicy() {
		super(UMLElementTypes.State_3016);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (UMLElementTypes.Transition_3022 == req.getElementType()) {
			return getGEFWrapper(new InternalTransitionCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
