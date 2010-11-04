package org.eclipse.uml2.diagram.component.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.uml2.diagram.component.edit.policies.UMLBaseItemSemanticEditPolicy;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.StructuredClassifier;

/**
 * @generated
 */
public class ConnectorReorientCommand extends EditElementCommand {

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
	public ConnectorReorientCommand(ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		reorientDirection = request.getDirection();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	 * @generated
	 */
	public boolean canExecute() {
		if (false == getElementToEdit() instanceof Connector) {
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
	 * @see #197259
	 * @generated NOT
	 */
	protected boolean canReorientSource() {
		return false;
	}

	/**
	 * @see #197259
	 * @generated NOT
	 */
	protected boolean canReorientTarget() {
		return false;
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
	 * @see #197259
	 * @generated NOT
	 */
	protected CommandResult reorientSource() throws ExecutionException {
		throw new UnsupportedOperationException("See #197259");
	}

	/**
	 * @see #197259
	 * @generated NOT
	 */
	protected CommandResult reorientTarget() throws ExecutionException {
		throw new UnsupportedOperationException("See #197259");
	}

	/**
	 * @generated
	 */
	protected Connector getLink() {
		return (Connector) getElementToEdit();
	}

	/**
	 * @generated
	 */
	protected ConnectableElement getOldSource() {
		return (ConnectableElement) oldEnd;
	}

	/**
	 * @generated
	 */
	protected ConnectableElement getNewSource() {
		return (ConnectableElement) newEnd;
	}

	/**
	 * @generated
	 */
	protected ConnectableElement getOldTarget() {
		return (ConnectableElement) oldEnd;
	}

	/**
	 * @generated
	 */
	protected ConnectableElement getNewTarget() {
		return (ConnectableElement) newEnd;
	}
}
