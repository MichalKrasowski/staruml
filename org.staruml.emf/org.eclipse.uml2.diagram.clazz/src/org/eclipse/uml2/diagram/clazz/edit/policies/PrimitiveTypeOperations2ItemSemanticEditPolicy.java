package org.eclipse.uml2.diagram.clazz.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.uml2.diagram.clazz.edit.commands.Operation4CreateCommand;
import org.eclipse.uml2.diagram.clazz.providers.UMLElementTypes;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class PrimitiveTypeOperations2ItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public PrimitiveTypeOperations2ItemSemanticEditPolicy() {
		super(UMLElementTypes.PrimitiveType_3037);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (UMLElementTypes.Operation_3022 == req.getElementType()) {
			return getGEFWrapper(new Operation4CreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
