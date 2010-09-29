package org.eclipse.uml2.diagram.clazz.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.uml2.diagram.clazz.edit.commands.EnumerationLiteralCreateCommand;
import org.eclipse.uml2.diagram.clazz.providers.UMLElementTypes;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class EnumerationLiterals2ItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public EnumerationLiterals2ItemSemanticEditPolicy() {
		super(UMLElementTypes.Enumeration_3034);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (UMLElementTypes.EnumerationLiteral_3016 == req.getElementType()) {
			return getGEFWrapper(new EnumerationLiteralCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
