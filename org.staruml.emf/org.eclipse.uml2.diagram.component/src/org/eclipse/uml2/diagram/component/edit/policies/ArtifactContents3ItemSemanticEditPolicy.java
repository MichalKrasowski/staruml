package org.eclipse.uml2.diagram.component.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.uml2.diagram.component.edit.commands.Artifact3CreateCommand;
import org.eclipse.uml2.diagram.component.providers.UMLElementTypes;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */

public class ArtifactContents3ItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ArtifactContents3ItemSemanticEditPolicy() {
		super(UMLElementTypes.Artifact_2002);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (UMLElementTypes.Artifact_3016 == req.getElementType()) {
			return getGEFWrapper(new Artifact3CreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
