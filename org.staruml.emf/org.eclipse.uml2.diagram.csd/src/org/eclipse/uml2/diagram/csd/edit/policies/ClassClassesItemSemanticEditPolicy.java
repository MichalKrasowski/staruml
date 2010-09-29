package org.eclipse.uml2.diagram.csd.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.uml2.diagram.csd.edit.commands.Class2CreateCommand;
import org.eclipse.uml2.diagram.csd.providers.UMLElementTypes;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class ClassClassesItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ClassClassesItemSemanticEditPolicy() {
		super(UMLElementTypes.Class_2006);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (UMLElementTypes.Class_3010 == req.getElementType()) {
			return getGEFWrapper(new Class2CreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
