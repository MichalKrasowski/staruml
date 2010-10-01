package org.eclipse.uml2.diagram.activity.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.uml2.diagram.activity.edit.commands.LocalPrecondition_LiteralStringCreateCommand;
import org.eclipse.uml2.diagram.activity.providers.UMLElementTypes;

/**
 * @generated
 */

public class LocalPreconditionCompartmentItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public LocalPreconditionCompartmentItemSemanticEditPolicy() {
		super(UMLElementTypes.Constraint_2027);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (UMLElementTypes.LiteralString_3049 == req.getElementType()) {
			return getGEFWrapper(new LocalPrecondition_LiteralStringCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
