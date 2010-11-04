package org.eclipse.uml2.diagram.component.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.uml2.diagram.component.edit.commands.Class3CreateCommand;
import org.eclipse.uml2.diagram.component.edit.commands.Component3CreateCommand;
import org.eclipse.uml2.diagram.component.providers.UMLElementTypes;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class PackageClassifiersItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public PackageClassifiersItemSemanticEditPolicy() {
		super(UMLElementTypes.Package_2006);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (UMLElementTypes.Class_3009 == req.getElementType()) {
			return getGEFWrapper(new Class3CreateCommand(req));
		}
		if (UMLElementTypes.Component_3010 == req.getElementType()) {
			return getGEFWrapper(new Component3CreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
