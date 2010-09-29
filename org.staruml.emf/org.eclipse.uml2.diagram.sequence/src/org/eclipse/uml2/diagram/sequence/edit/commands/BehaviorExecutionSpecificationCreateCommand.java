package org.eclipse.uml2.diagram.sequence.edit.commands;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.uml2.uml.BehaviorExecutionSpecification;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated NOT
 */
public class BehaviorExecutionSpecificationCreateCommand extends AbstractCreateFragmentCommand {

	/**
	 * @generated
	 */
	public BehaviorExecutionSpecificationCreateCommand(CreateElementRequest req) {
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
		BehaviorExecutionSpecification newElement = (BehaviorExecutionSpecification) super.doDefaultElementCreation();
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
		BehaviorExecutionSpecification spec = (BehaviorExecutionSpecification) createdFragment;
		Lifeline lifeline = getLifeline();
		Interaction interaction = getInteraction();

		MessageOccurrenceSpecification start = (MessageOccurrenceSpecification) interaction.createFragment("start", UMLPackage.eINSTANCE.getMessageOccurrenceSpecification());
		MessageOccurrenceSpecification finish = (MessageOccurrenceSpecification) interaction.createFragment("finish", UMLPackage.eINSTANCE.getMessageOccurrenceSpecification());

		start.getCovereds().add(lifeline);
		finish.getCovereds().add(lifeline);

		spec.setStart(start);
		spec.setFinish(finish);
	}

}
