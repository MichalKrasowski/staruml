package org.eclipse.uml2.diagram.csd.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.uml2.diagram.csd.edit.commands.Property3CreateCommand;
import org.eclipse.uml2.diagram.csd.providers.UMLElementTypes;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class ClassClass_contentsItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ClassClass_contentsItemSemanticEditPolicy() {
		super(UMLElementTypes.Class_2007);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (UMLElementTypes.Property_3014 == req.getElementType()) {
			return getGEFWrapper(new Property3CreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
