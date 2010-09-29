package org.eclipse.uml2.diagram.statemachine.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.uml2.diagram.statemachine.edit.commands.DoActivityCreateCommand;
import org.eclipse.uml2.diagram.statemachine.edit.commands.EntryActivityCreateCommand;
import org.eclipse.uml2.diagram.statemachine.edit.commands.ExitActivityCreateCommand;
import org.eclipse.uml2.diagram.statemachine.providers.UMLElementTypes;

/**
 * @generated
 */

public class SubmachineState_InternalActivitiesItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public SubmachineState_InternalActivitiesItemSemanticEditPolicy() {
		super(UMLElementTypes.State_3016);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (UMLElementTypes.Behavior_3019 == req.getElementType()) {
			return getGEFWrapper(new EntryActivityCreateCommand(req));
		}
		if (UMLElementTypes.Behavior_3020 == req.getElementType()) {
			return getGEFWrapper(new ExitActivityCreateCommand(req));
		}
		if (UMLElementTypes.Behavior_3021 == req.getElementType()) {
			return getGEFWrapper(new DoActivityCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
