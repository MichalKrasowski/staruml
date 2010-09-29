package org.eclipse.uml2.diagram.csd.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.uml2.diagram.csd.edit.commands.SlotCreateCommand;
import org.eclipse.uml2.diagram.csd.providers.UMLElementTypes;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class InstanceSpecificationSlotsItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public InstanceSpecificationSlotsItemSemanticEditPolicy() {
		super(UMLElementTypes.InstanceSpecification_2011);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (UMLElementTypes.Slot_3015 == req.getElementType()) {
			return getGEFWrapper(new SlotCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
