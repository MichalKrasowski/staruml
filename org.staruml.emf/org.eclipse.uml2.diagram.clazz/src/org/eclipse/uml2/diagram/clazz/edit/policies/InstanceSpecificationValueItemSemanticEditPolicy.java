package org.eclipse.uml2.diagram.clazz.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.uml2.diagram.clazz.edit.commands.ExpressionCreateCommand;
import org.eclipse.uml2.diagram.clazz.edit.commands.LiteralStringCreateCommand;
import org.eclipse.uml2.diagram.clazz.providers.UMLElementTypes;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */

public class InstanceSpecificationValueItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public InstanceSpecificationValueItemSemanticEditPolicy() {
		super(UMLElementTypes.InstanceSpecification_2017);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (UMLElementTypes.LiteralString_3038 == req.getElementType()) {
			return getGEFWrapper(new LiteralStringCreateCommand(req));
		}
		if (UMLElementTypes.Expression_3040 == req.getElementType()) {
			return getGEFWrapper(new ExpressionCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
