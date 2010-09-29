package org.eclipse.uml2.diagram.usecase.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.uml2.diagram.usecase.edit.commands.ActorInPackageCreateCommand;
import org.eclipse.uml2.diagram.usecase.edit.commands.UseCaseinPackageCreateCommand;
import org.eclipse.uml2.diagram.usecase.providers.UMLElementTypes;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class PackageFramecontentsItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public PackageFramecontentsItemSemanticEditPolicy() {
		super(UMLElementTypes.Package_2007);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (UMLElementTypes.Actor_3005 == req.getElementType()) {
			return getGEFWrapper(new ActorInPackageCreateCommand(req));
		}
		if (UMLElementTypes.UseCase_3006 == req.getElementType()) {
			return getGEFWrapper(new UseCaseinPackageCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
