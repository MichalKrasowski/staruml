package org.eclipse.uml2.diagram.sequence.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.uml2.diagram.sequence.edit.policies.UMLBaseItemSemanticEditPolicy;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.Message;

/**
 * @generated
 */
public class MessageReorientCommand extends EditElementCommand {

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
	public MessageReorientCommand(ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		reorientDirection = request.getDirection();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	 * @generated
	 */
	public boolean canExecute() {
		if (false == getElementToEdit() instanceof Message) {
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
	 * @generated NOT
	 */
	protected boolean canReorientSource() {
		return false;
	}

	/**
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
	 * @generated NOT
	 */
	protected CommandResult reorientSource() throws ExecutionException {
		throw new UnsupportedOperationException("Not yet implemented");
	}

	/**
	 * @generated NOT
	 */
	protected CommandResult reorientTarget() throws ExecutionException {
		throw new UnsupportedOperationException("Not yet implemented");
	}

	/**
	 * @generated
	 */
	protected Message getLink() {
		return (Message) getElementToEdit();
	}

	/**
	 * @generated
	 */
	protected Element getOldSource() {
		return (Element) oldEnd;
	}

	/**
	 * @generated
	 */
	protected Element getNewSource() {
		return (Element) newEnd;
	}

	/**
	 * @generated
	 */
	protected Element getOldTarget() {
		return (Element) oldEnd;
	}

	/**
	 * @generated
	 */
	protected Element getNewTarget() {
		return (Element) newEnd;
	}
}
