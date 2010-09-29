package org.eclipse.uml2.diagram.deploy.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.uml2.diagram.deploy.edit.commands.Artifact4CreateCommand;
import org.eclipse.uml2.diagram.deploy.edit.commands.DeploymentSpecification2CreateCommand;
import org.eclipse.uml2.diagram.deploy.providers.UMLElementTypes;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */

public class ArtifactArtifactFigure_contents3ItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ArtifactArtifactFigure_contents3ItemSemanticEditPolicy() {
		super(UMLElementTypes.Artifact_2006);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (UMLElementTypes.Artifact_3008 == req.getElementType()) {
			return getGEFWrapper(new Artifact4CreateCommand(req));
		}
		if (UMLElementTypes.DeploymentSpecification_3009 == req.getElementType()) {
			return getGEFWrapper(new DeploymentSpecification2CreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
