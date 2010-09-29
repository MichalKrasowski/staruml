package org.eclipse.uml2.diagram.csd.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.uml2.diagram.csd.edit.commands.OperationCreateCommand;
import org.eclipse.uml2.diagram.csd.providers.UMLElementTypes;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class ClassOperationsItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ClassOperationsItemSemanticEditPolicy() {
		super(UMLElementTypes.Class_2006);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (UMLElementTypes.Operation_3009 == req.getElementType()) {
			return getGEFWrapper(new OperationCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
