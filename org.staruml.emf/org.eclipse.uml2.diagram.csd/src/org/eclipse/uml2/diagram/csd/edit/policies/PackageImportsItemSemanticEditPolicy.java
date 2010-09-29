package org.eclipse.uml2.diagram.csd.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.uml2.diagram.csd.edit.commands.ElementImportCreateCommand;
import org.eclipse.uml2.diagram.csd.providers.UMLElementTypes;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class PackageImportsItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public PackageImportsItemSemanticEditPolicy() {
		super(UMLElementTypes.Package_2003);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (UMLElementTypes.ElementImport_3004 == req.getElementType()) {
			return getGEFWrapper(new ElementImportCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
