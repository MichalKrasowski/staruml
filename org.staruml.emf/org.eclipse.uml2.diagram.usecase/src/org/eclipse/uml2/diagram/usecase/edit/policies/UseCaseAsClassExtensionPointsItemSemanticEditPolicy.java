package org.eclipse.uml2.diagram.usecase.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.uml2.diagram.usecase.edit.commands.ExtensionPoint2CreateCommand;
import org.eclipse.uml2.diagram.usecase.providers.UMLElementTypes;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class UseCaseAsClassExtensionPointsItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public UseCaseAsClassExtensionPointsItemSemanticEditPolicy() {
		super(UMLElementTypes.UseCase_2004);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (UMLElementTypes.ExtensionPoint_3003 == req.getElementType()) {
			return getGEFWrapper(new ExtensionPoint2CreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
