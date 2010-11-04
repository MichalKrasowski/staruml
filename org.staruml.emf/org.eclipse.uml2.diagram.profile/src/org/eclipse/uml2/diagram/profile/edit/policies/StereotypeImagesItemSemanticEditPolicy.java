package org.eclipse.uml2.diagram.profile.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.uml2.diagram.profile.edit.commands.ImageCreateCommand;
import org.eclipse.uml2.diagram.profile.providers.UMLElementTypes;

/**
 * @generated
 */

public class StereotypeImagesItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public StereotypeImagesItemSemanticEditPolicy() {
		super(UMLElementTypes.Stereotype_2001);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (UMLElementTypes.Image_3010 == req.getElementType()) {
			return getGEFWrapper(new ImageCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
