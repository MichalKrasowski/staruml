package org.eclipse.uml2.diagram.deploy.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.uml2.diagram.deploy.edit.commands.Artifact3CreateCommand;
import org.eclipse.uml2.diagram.deploy.providers.UMLElementTypes;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class ExecutionEnvironmentArtifacts2ItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ExecutionEnvironmentArtifacts2ItemSemanticEditPolicy() {
		super(UMLElementTypes.ExecutionEnvironment_3005);
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
