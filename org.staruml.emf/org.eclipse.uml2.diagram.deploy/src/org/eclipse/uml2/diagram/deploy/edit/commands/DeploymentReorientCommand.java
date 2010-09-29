package org.eclipse.uml2.diagram.deploy.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.uml2.diagram.deploy.edit.policies.UMLBaseItemSemanticEditPolicy;
import org.eclipse.uml2.uml.DeployedArtifact;
import org.eclipse.uml2.uml.Deployment;
import org.eclipse.uml2.uml.DeploymentTarget;

/**
 * @generated
 */
public class DeploymentReorientCommand extends EditElementCommand {

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
	public DeploymentReorientCommand(ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		reorientDirection = request.getDirection();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	 * @generated
	 */
	public boolean canExecute() {
		if (false == getElementToEdit() instanceof Deployment) {
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
		if (!(oldEnd instanceof DeploymentTarget && newEnd instanceof DeploymentTarget)) {
			return false;
		}
		if (getLink().getDeployedArtifacts().size() != 1) {
			return false;
		}
		DeployedArtifact target = (DeployedArtifact) getLink().getDeployedArtifacts().get(0);
		if (!(getLink().eContainer() instanceof DeploymentTarget)) {
			return false;
		}
		DeploymentTarget container = (DeploymentTarget) getLink().eContainer();
		return UMLBaseItemSemanticEditPolicy.LinkConstraints.canExistDeployment_4001(container, getNewSource(), target);
	}

	/**
	 * @generated
	 */
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof DeployedArtifact && newEnd instanceof DeployedArtifact)) {
			return false;
		}
		DeploymentTarget source = getLink().getLocation();
		if (!(getLink().eContainer() instanceof DeploymentTarget)) {
			return false;
		}
		DeploymentTarget container = (DeploymentTarget) getLink().eContainer();
		return UMLBaseItemSemanticEditPolicy.LinkConstraints.canExistDeployment_4001(container, source, getNewTarget());
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
		getLink().setLocation(getNewSource());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated
	 */
	protected CommandResult reorientTarget() throws ExecutionException {
		getLink().getDeployedArtifacts().remove(getOldTarget());
		getLink().getDeployedArtifacts().add(getNewTarget());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated
	 */
	protected Deployment getLink() {
		return (Deployment) getElementToEdit();
	}

	/**
	 * @generated
	 */
	protected DeploymentTarget getOldSource() {
		return (DeploymentTarget) oldEnd;
	}

	/**
	 * @generated
	 */
	protected DeploymentTarget getNewSource() {
		return (DeploymentTarget) newEnd;
	}

	/**
	 * @generated
	 */
	protected DeployedArtifact getOldTarget() {
		return (DeployedArtifact) oldEnd;
	}

	/**
	 * @generated
	 */
	protected DeployedArtifact getNewTarget() {
		return (DeployedArtifact) newEnd;
	}
}
