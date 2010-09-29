package org.eclipse.uml2.diagram.csd.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.uml2.diagram.csd.edit.commands.CollaborationUse2CreateCommand;
import org.eclipse.uml2.diagram.csd.edit.commands.PropertyCreateCommand;
import org.eclipse.uml2.diagram.csd.providers.UMLElementTypes;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class CollaborationContentsItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public CollaborationContentsItemSemanticEditPolicy() {
		super(UMLElementTypes.Collaboration_2005);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (UMLElementTypes.CollaborationUse_3002 == req.getElementType()) {
			return getGEFWrapper(new CollaborationUse2CreateCommand(req));
		}
		if (UMLElementTypes.Property_3007 == req.getElementType()) {
			return getGEFWrapper(new PropertyCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
