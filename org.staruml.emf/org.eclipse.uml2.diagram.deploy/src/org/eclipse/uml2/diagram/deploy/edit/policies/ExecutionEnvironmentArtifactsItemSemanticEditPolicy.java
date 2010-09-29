package org.eclipse.uml2.diagram.deploy.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.uml2.diagram.deploy.edit.commands.Artifact3CreateCommand;
import org.eclipse.uml2.diagram.deploy.providers.UMLElementTypes;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class ExecutionEnvironmentArtifactsItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ExecutionEnvironmentArtifactsItemSemanticEditPolicy() {
		super(UMLElementTypes.ExecutionEnvironment_2005);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (UMLElementTypes.Artifact_3006 == req.getElementType()) {
			return getGEFWrapper(new Artifact3CreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
