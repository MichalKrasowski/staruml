package org.eclipse.uml2.diagram.deploy.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.uml2.diagram.deploy.edit.commands.PropertyCreateCommand;
import org.eclipse.uml2.diagram.deploy.providers.UMLElementTypes;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */

public class DeploymentSpecificationProperties2ItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public DeploymentSpecificationProperties2ItemSemanticEditPolicy() {
		super(UMLElementTypes.DeploymentSpecification_3009);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (UMLElementTypes.Property_3003 == req.getElementType()) {
			return getGEFWrapper(new PropertyCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
