package org.eclipse.uml2.diagram.deploy.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.uml2.diagram.deploy.edit.policies.UMLBaseItemSemanticEditPolicy;
import org.eclipse.uml2.uml.Artifact;
import org.eclipse.uml2.uml.Manifestation;
import org.eclipse.uml2.uml.PackageableElement;

/**
 * @generated
 */
public class ManifestationReorientCommand extends EditElementCommand {

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
	public ManifestationReorientCommand(ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		reorientDirection = request.getDirection();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	 * @generated
	 */
	public boolean canExecute() {
		if (false == getElementToEdit() instanceof Manifestation) {
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
		if (!(oldEnd instanceof Artifact && newEnd instanceof Artifact)) {
			return false;
		}
		PackageableElement target = getLink().getUtilizedElement();
		return UMLBaseItemSemanticEditPolicy.LinkConstraints.canExistManifestation_4002(getNewSource(), target);
	}

	/**
	 * @generated
	 */
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof PackageableElement && newEnd instanceof PackageableElement)) {
			return false;
		}
		if (!(getLink().eContainer() instanceof Artifact)) {
			return false;
		}
		Artifact source = (Artifact) getLink().eContainer();
		return UMLBaseItemSemanticEditPolicy.LinkConstraints.canExistManifestation_4002(source, getNewTarget());
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
		getOldSource().getManifestations().remove(getLink());
		getNewSource().getManifestations().add(getLink());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated
	 */
	protected CommandResult reorientTarget() throws ExecutionException {
		getLink().setUtilizedElement(getNewTarget());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated
	 */
	protected Manifestation getLink() {
		return (Manifestation) getElementToEdit();
	}

	/**
	 * @generated
	 */
	protected Artifact getOldSource() {
		return (Artifact) oldEnd;
	}

	/**
	 * @generated
	 */
	protected Artifact getNewSource() {
		return (Artifact) newEnd;
	}

	/**
	 * @generated
	 */
	protected PackageableElement getOldTarget() {
		return (PackageableElement) oldEnd;
	}

	/**
	 * @generated
	 */
	protected PackageableElement getNewTarget() {
		return (PackageableElement) newEnd;
	}
}
