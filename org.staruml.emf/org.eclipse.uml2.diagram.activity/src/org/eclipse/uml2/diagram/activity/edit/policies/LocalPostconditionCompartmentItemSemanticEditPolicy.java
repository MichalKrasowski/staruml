package org.eclipse.uml2.diagram.activity.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.uml2.diagram.activity.edit.commands.LocalPostcondition_LiteralStringCreateCommand;
import org.eclipse.uml2.diagram.activity.providers.UMLElementTypes;

/**
 * @generated
 */

public class LocalPostconditionCompartmentItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public LocalPostconditionCompartmentItemSemanticEditPolicy() {
		super(UMLElementTypes.Constraint_2028);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (UMLElementTypes.LiteralString_3051 == req.getElementType()) {
			return getGEFWrapper(new LocalPostcondition_LiteralStringCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
