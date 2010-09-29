package org.eclipse.uml2.diagram.clazz.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.uml2.diagram.clazz.edit.commands.Class3CreateCommand;
import org.eclipse.uml2.diagram.clazz.providers.UMLElementTypes;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class ClassClasses2ItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ClassClasses2ItemSemanticEditPolicy() {
		super(UMLElementTypes.Class_3033);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (UMLElementTypes.Class_3003 == req.getElementType()) {
			return getGEFWrapper(new Class3CreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
