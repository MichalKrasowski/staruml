package org.eclipse.uml2.diagram.sequence.edit.commands;

import java.util.ListIterator;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.common.editpolicies.U2TCreateParameters;
import org.eclipse.uml2.diagram.sequence.edit.policies.SDCreationEditPolicy;
import org.eclipse.uml2.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.StateInvariant;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * @generated
 */

public class StateInvariantCreateCommand extends EditElementCommand {

	/**
	 * @generated
	 */
	public StateInvariantCreateCommand(CreateElementRequest req) {
		super(req.getLabel(), null, req);
	}

	/**
	 * FIXME: replace with setElementToEdit()
	 * @generated
	 */
	protected EObject getElementToEdit() {
		EObject container = ((CreateElementRequest) getRequest()).getContainer();
		if (container instanceof View) {
			container = ((View) container).getElement();
		}
		return container;
	}

	/**
	 * @generated NOT
	 */
	public boolean canExecute() {
		return getLifeline() != null //
				&& getInteraction() != null // 
				&& getRequest().getParameter(SDCreationEditPolicy.KEY_U2T_EXTENDED_PARAMETERS) instanceof U2TCreateParameters;
	}

	/**
	 * @generated NOT
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		StateInvariant newElement = UMLFactory.eINSTANCE.createStateInvariant();

		Lifeline lifeline = getLifeline();
		Interaction owner = getInteraction();

		U2TCreateParameters anchorData = (U2TCreateParameters) getRequest().getParameter(SDCreationEditPolicy.KEY_U2T_EXTENDED_PARAMETERS);
		ThePastImpl thePast = new ThePastImpl(anchorData);
		ListIterator<InteractionFragment> appendPosition = thePast.getAfterThePastPosition(owner);
		appendPosition.add(newElement);

		lifeline.getCoveredBys().add(newElement);

		UMLElementTypes.init_StateInvariant_3003(newElement);

		doConfigure(newElement, monitor, info);

		((CreateElementRequest) getRequest()).setNewElement(newElement);
		return CommandResult.newOKCommandResult(newElement);
	}

	/**
	 * @generated
	 */
	protected void doConfigureGen(StateInvariant newElement, IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		IElementType elementType = ((CreateElementRequest) getRequest()).getElementType();
		ConfigureRequest configureRequest = new ConfigureRequest(getEditingDomain(), newElement, elementType);
		configureRequest.setClientContext(((CreateElementRequest) getRequest()).getClientContext());
		configureRequest.addParameters(getRequest().getParameters());
		ICommand configureCommand = elementType.getEditCommand(configureRequest);
		if (configureCommand != null && configureCommand.canExecute()) {
			configureCommand.execute(monitor, info);
		}
	}

	/**
	 * @generated NOT
	 */
	protected void doConfigure(StateInvariant newElement, IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		doConfigureGen(newElement, monitor, info);
		if (newElement.getInvariant() == null) {
			newElement.createInvariant("State");
		}
	}

	protected Lifeline getLifeline() {
		EObject container = ((CreateElementRequest) getRequest()).getContainer();
		if (container instanceof View) {
			container = ((View) container).getElement();
		}
		if (container instanceof Lifeline) {
			return (Lifeline) container;
		}

		if (container instanceof InteractionFragment) {
			InteractionFragment fragment = (InteractionFragment) container;
			if (fragment.getCovereds().size() == 1) {
				return fragment.getCovereds().get(0);
			}
		}
		return null;
	}

	protected Interaction getInteraction() {
		return getLifeline().getInteraction();
	}
}
