package org.eclipse.uml2.diagram.component.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.uml2.diagram.common.links.PortOperationsExt;
import org.eclipse.uml2.diagram.common.links.RequiredInterfaceLink;
import org.eclipse.uml2.diagram.component.providers.UMLElementTypes;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Port;

/**
 * @generated
 */
public class PortRequiredItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public PortRequiredItemSemanticEditPolicy() {
		super(UMLElementTypes.PortRequired_4004);
	}

	/**
	 * @generated NOT
	 */
	protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {
		Port port = (Port) req.getContainer();
		Interface requiredInterface = (Interface) req.getReferencedObject();
		RequiredInterfaceLink link = PortOperationsExt.getRequireds(port, requiredInterface);
		return getGEFWrapper(new DestroyElementCommand(new DestroyElementRequest(link.getLink(), req.isConfirmationRequired())));
	}

}
