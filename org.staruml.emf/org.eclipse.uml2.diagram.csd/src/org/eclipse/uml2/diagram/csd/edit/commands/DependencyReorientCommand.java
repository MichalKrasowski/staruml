package org.eclipse.uml2.diagram.csd.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.uml2.diagram.csd.edit.policies.UMLBaseItemSemanticEditPolicy;
import org.eclipse.uml2.uml.CollaborationUse;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.NamedElement;

/**
 * @generated
 */
public class DependencyReorientCommand extends EditElementCommand {

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
	public DependencyReorientCommand(ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		reorientDirection = request.getDirection();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	 * @generated
	 */
	public boolean canExecute() {
		if (false == getElementToEdit() instanceof Dependency) {
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
		if (!(oldEnd instanceof NamedElement && newEnd instanceof NamedElement)) {
			return false;
		}
		if (getLink().getSuppliers().size() != 1) {
			return false;
		}
		NamedElement target = (NamedElement) getLink().getSuppliers().get(0);
		if (!(getLink().eContainer() instanceof CollaborationUse)) {
			return false;
		}
		CollaborationUse container = (CollaborationUse) getLink().eContainer();
		return UMLBaseItemSemanticEditPolicy.LinkConstraints.canExistDependency_4006(container, getNewSource(), target);
	}

	/**
	 * @generated
	 */
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof NamedElement && newEnd instanceof NamedElement)) {
			return false;
		}
		if (getLink().getClients().size() != 1) {
			return false;
		}
		NamedElement source = (NamedElement) getLink().getClients().get(0);
		if (!(getLink().eContainer() instanceof CollaborationUse)) {
			return false;
		}
		CollaborationUse container = (CollaborationUse) getLink().eContainer();
		return UMLBaseItemSemanticEditPolicy.LinkConstraints.canExistDependency_4006(container, source, getNewTarget());
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
		getLink().getClients().remove(getOldSource());
		getLink().getClients().add(getNewSource());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated
	 */
	protected CommandResult reorientTarget() throws ExecutionException {
		getLink().getSuppliers().remove(getOldTarget());
		getLink().getSuppliers().add(getNewTarget());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated
	 */
	protected Dependency getLink() {
		return (Dependency) getElementToEdit();
	}

	/**
	 * @generated
	 */
	protected NamedElement getOldSource() {
		return (NamedElement) oldEnd;
	}

	/**
	 * @generated
	 */
	protected NamedElement getNewSource() {
		return (NamedElement) newEnd;
	}

	/**
	 * @generated
	 */
	protected NamedElement getOldTarget() {
		return (NamedElement) oldEnd;
	}

	/**
	 * @generated
	 */
	protected NamedElement getNewTarget() {
		return (NamedElement) newEnd;
	}
}
