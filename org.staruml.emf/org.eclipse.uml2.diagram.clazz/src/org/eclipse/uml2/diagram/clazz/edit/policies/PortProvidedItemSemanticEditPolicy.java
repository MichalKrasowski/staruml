package org.eclipse.uml2.diagram.clazz.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.uml2.diagram.clazz.providers.UMLElementTypes;
import org.eclipse.uml2.diagram.common.links.PortOperationsExt;
import org.eclipse.uml2.diagram.common.links.ProvidedInterfaceLink;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class PortProvidedItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public PortProvidedItemSemanticEditPolicy() {
		super(UMLElementTypes.PortProvided_4017);
	}

	/**
	 * @generated NOT
	 */
	protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {
		Port port = (Port) req.getContainer();
		// 
		if (port.getType() != null && port.getType().equals(req.getReferencedObject())) {
			return getGEFWrapper(new DestroyReferenceCommand(new DestroyReferenceRequest(port, UMLPackage.eINSTANCE.getTypedElement_Type(), req.getReferencedObject(), req.isConfirmationRequired())));
		}
		Interface providedInterface = (Interface) req.getReferencedObject();
		ProvidedInterfaceLink link = PortOperationsExt.getProvideds(port, providedInterface);
		return getGEFWrapper(new DestroyElementCommand(new DestroyElementRequest(link.getRealization(), req.isConfirmationRequired())));
	}

}
