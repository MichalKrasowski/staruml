package org.eclipse.uml2.diagram.deploy.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.uml2.diagram.deploy.edit.commands.ElementImportCreateCommand;
import org.eclipse.uml2.diagram.deploy.providers.UMLElementTypes;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class PackageImportsItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public PackageImportsItemSemanticEditPolicy() {
		super(UMLElementTypes.Package_2001);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (UMLElementTypes.ElementImport_3001 == req.getElementType()) {
			return getGEFWrapper(new ElementImportCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
