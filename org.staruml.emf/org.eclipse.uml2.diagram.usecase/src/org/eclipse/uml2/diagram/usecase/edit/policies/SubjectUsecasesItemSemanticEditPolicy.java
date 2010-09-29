package org.eclipse.uml2.diagram.usecase.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.uml2.diagram.usecase.edit.commands.InnerUseCaseCreateCommand;
import org.eclipse.uml2.diagram.usecase.providers.UMLElementTypes;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class SubjectUsecasesItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public SubjectUsecasesItemSemanticEditPolicy() {
		super(UMLElementTypes.Component_2006);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (UMLElementTypes.UseCase_3004 == req.getElementType()) {
			return getGEFWrapper(new InnerUseCaseCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
