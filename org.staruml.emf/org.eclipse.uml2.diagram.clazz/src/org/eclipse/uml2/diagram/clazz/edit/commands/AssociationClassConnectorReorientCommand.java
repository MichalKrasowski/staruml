package org.eclipse.uml2.diagram.clazz.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.uml2.diagram.clazz.edit.policies.UMLBaseItemSemanticEditPolicy;
import org.eclipse.uml2.uml.AssociationClass;
import org.eclipse.uml2.uml.CollaborationUse;
import org.eclipse.uml2.uml.Package;

/**
 * @generated
 */

public class AssociationClassConnectorReorientCommand extends EditElementCommand {

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
	public AssociationClassConnectorReorientCommand(ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		reorientDirection = request.getDirection();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	 * @generated
	 */
	public boolean canExecute() {
		if (false == getElementToEdit() instanceof AssociationClass) {
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
		if (!(oldEnd instanceof CollaborationUse && newEnd instanceof CollaborationUse)) {
			return false;
		}
		if (getLink().getCollaborationUses().size() != 1) {
			return false;
		}
		CollaborationUse target = (CollaborationUse) getLink().getCollaborationUses().get(0);
		if (!(getLink().eContainer() instanceof Package)) {
			return false;
		}
		Package container = (Package) getLink().eContainer();
		return UMLBaseItemSemanticEditPolicy.LinkConstraints.canExistAssociationClass_4014(container, getNewSource(), target);
	}

	/**
	 * @generated
	 */
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof CollaborationUse && newEnd instanceof CollaborationUse)) {
			return false;
		}
		if (getLink().getCollaborationUses().size() != 1) {
			return false;
		}
		CollaborationUse source = (CollaborationUse) getLink().getCollaborationUses().get(0);
		if (!(getLink().eContainer() instanceof Package)) {
			return false;
		}
		Package container = (Package) getLink().eContainer();
		return UMLBaseItemSemanticEditPolicy.LinkConstraints.canExistAssociationClass_4014(container, source, getNewTarget());
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
		getLink().getCollaborationUses().remove(getOldSource());
		getLink().getCollaborationUses().add(getNewSource());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated
	 */
	protected CommandResult reorientTarget() throws ExecutionException {
		getLink().getCollaborationUses().remove(getOldTarget());
		getLink().getCollaborationUses().add(getNewTarget());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated
	 */
	protected AssociationClass getLink() {
		return (AssociationClass) getElementToEdit();
	}

	/**
	 * @generated
	 */
	protected CollaborationUse getOldSource() {
		return (CollaborationUse) oldEnd;
	}

	/**
	 * @generated
	 */
	protected CollaborationUse getNewSource() {
		return (CollaborationUse) newEnd;
	}

	/**
	 * @generated
	 */
	protected CollaborationUse getOldTarget() {
		return (CollaborationUse) oldEnd;
	}

	/**
	 * @generated
	 */
	protected CollaborationUse getNewTarget() {
		return (CollaborationUse) newEnd;
	}
}
