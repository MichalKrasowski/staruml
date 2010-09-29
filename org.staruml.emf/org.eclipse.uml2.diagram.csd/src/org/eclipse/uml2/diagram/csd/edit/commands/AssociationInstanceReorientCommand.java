package org.eclipse.uml2.diagram.csd.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.uml2.diagram.csd.edit.policies.UMLBaseItemSemanticEditPolicy;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.ValueSpecification;

/**
 * @generated
 */

public class AssociationInstanceReorientCommand extends EditElementCommand {

	/**
	 * @generated
	 */
	private final int reorientDirection;

	/**
	 * @generated
	 */
	private final EObject oldEnd;

	/**
	 * @generated
	 */
	private final EObject newEnd;

	/**
	 * @generated
	 */
	public AssociationInstanceReorientCommand(ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		reorientDirection = request.getDirection();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	 * @generated
	 */
	public boolean canExecute() {
		if (false == getElementToEdit() instanceof Slot) {
			return false;
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
			return canReorientSource();
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
			return canReorientTarget();
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean canReorientSource() {
		if (!(oldEnd instanceof InstanceSpecification && newEnd instanceof InstanceSpecification)) {
			return false;
		}
		InstanceSpecification target = getLink().getOwningInstance();
		if (!(getLink().eContainer() instanceof InstanceSpecification)) {
			return false;
		}
		InstanceSpecification container = (InstanceSpecification) getLink().eContainer();
		return UMLBaseItemSemanticEditPolicy.LinkConstraints.canExistSlot_4015(container, getNewSource(), target);
	}

	/**
	 * @generated
	 */
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof InstanceSpecification && newEnd instanceof InstanceSpecification)) {
			return false;
		}
		InstanceSpecification source = getLink().getOwningInstance();
		if (!(getLink().eContainer() instanceof InstanceSpecification)) {
			return false;
		}
		InstanceSpecification container = (InstanceSpecification) getLink().eContainer();
		return UMLBaseItemSemanticEditPolicy.LinkConstraints.canExistSlot_4015(container, source, getNewTarget());
	}

	/**
	 * @generated
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if (!canExecute()) {
			throw new ExecutionException("Invalid arguments in reorient link command"); //$NON-NLS-1$
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
			return reorientSource();
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
			return reorientTarget();
		}
		throw new IllegalStateException();
	}

	/**
	 * @generated
	 */
	protected CommandResult reorientSource() throws ExecutionException {
		getLink().setOwningInstance(getNewSource());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated NOT
	 */
	protected CommandResult reorientTarget() throws ExecutionException {
		Slot slot = getLink();
		InstanceValue valueForOldTarget = null;
		for (ValueSpecification next : slot.getValues()) {
			if (next instanceof InstanceValue) {
				InstanceValue nextValue = (InstanceValue) next;
				if (getOldTarget().equals(nextValue.getInstance())) {
					valueForOldTarget = nextValue;
					break;
				}
			}
		}

		if (valueForOldTarget == null) {
			//strange, but we will create one
			valueForOldTarget = UMLFactory.eINSTANCE.createInstanceValue();
			slot.getValues().add(valueForOldTarget);
		}

		valueForOldTarget.setInstance(getNewTarget());

		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated
	 */
	protected Slot getLink() {
		return (Slot) getElementToEdit();
	}

	/**
	 * @generated
	 */
	protected InstanceSpecification getOldSource() {
		return (InstanceSpecification) oldEnd;
	}

	/**
	 * @generated
	 */
	protected InstanceSpecification getNewSource() {
		return (InstanceSpecification) newEnd;
	}

	/**
	 * @generated
	 */
	protected InstanceSpecification getOldTarget() {
		return (InstanceSpecification) oldEnd;
	}

	/**
	 * @generated
	 */
	protected InstanceSpecification getNewTarget() {
		return (InstanceSpecification) newEnd;
	}
}
