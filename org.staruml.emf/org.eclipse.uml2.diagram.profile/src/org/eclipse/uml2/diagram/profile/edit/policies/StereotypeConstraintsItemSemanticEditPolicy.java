package org.eclipse.uml2.diagram.profile.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.uml2.diagram.profile.edit.commands.ConstraintCreateCommand;
import org.eclipse.uml2.diagram.profile.providers.UMLElementTypes;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class StereotypeConstraintsItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public StereotypeConstraintsItemSemanticEditPolicy() {
		super(UMLElementTypes.Stereotype_2001);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (UMLElementTypes.Constraint_3008 == req.getElementType()) {
			return getGEFWrapper(new ConstraintCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}
}
