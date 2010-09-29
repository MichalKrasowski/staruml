package org.eclipse.uml2.diagram.usecase.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.uml2.diagram.usecase.edit.commands.ExtensionPointCreateCommand;
import org.eclipse.uml2.diagram.usecase.providers.UMLElementTypes;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class UseCasePointsItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public UseCasePointsItemSemanticEditPolicy() {
		super(UMLElementTypes.UseCase_3006);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (UMLElementTypes.ExtensionPoint_3002 == req.getElementType()) {
			return getGEFWrapper(new ExtensionPointCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
