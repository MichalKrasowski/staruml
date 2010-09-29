package org.eclipse.uml2.diagram.sequence.edit.commands;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.InteractionUse;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated NOT
 */
public class InteractionUseCreateCommand extends AbstractCreateFragmentCommand {

	/**
	 * @generated
	 */
	public InteractionUseCreateCommand(CreateElementRequest req) {
		super(req);
	}

	/**
	 * @generated NOT
	 */
	protected EObject getElementToEdit() {
		return super.getElementToEdit();
	}

	/**
	 * @generated
	 */
	protected EClass getEClassToEdit() {
		return UMLPackage.eINSTANCE.getInteraction();
	}

	/**
	 * @generated
	 */
	protected EObject doDefaultElementCreationGen() {
		InteractionUse newElement = (InteractionUse) super.doDefaultElementCreation();
		if (newElement != null) {
			Lifeline container = (Lifeline) getElementToEdit();
			if (container != null) {
				container.getCoveredBys().add(newElement);
			}
		}
		return newElement;
	}

	@Override
	protected void afterDefaultElementCreation(InteractionFragment createdFragment) {
		// TODO Auto-generated method stub
	}

}
