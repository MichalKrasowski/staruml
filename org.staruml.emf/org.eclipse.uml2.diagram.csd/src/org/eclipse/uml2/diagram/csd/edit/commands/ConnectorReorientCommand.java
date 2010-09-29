package org.eclipse.uml2.diagram.csd.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.uml2.diagram.common.conventions.ConnectorEndConvention;
import org.eclipse.uml2.diagram.csd.edit.policies.UMLBaseItemSemanticEditPolicy;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
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
	 * @generated NOT
	 */
	protected boolean canReorientSource() {
		if (!(oldEnd instanceof ConnectableElement && newEnd instanceof ConnectableElement)) {
			return false;
		}
		ConnectableElement target = ConnectorEndConvention.getSourceEnd(getLink()).getRole();
		if (!(getLink().eContainer() instanceof StructuredClassifier)) {
			return false;
		}
		StructuredClassifier container = (StructuredClassifier) getLink().eContainer();
		return UMLBaseItemSemanticEditPolicy.LinkConstraints.canExistConnector_4005(container, getNewSource(), target);
	}

	/**
	 * @generated NOT
	 */
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof ConnectableElement && newEnd instanceof ConnectableElement)) {
			return false;
		}
		ConnectableElement source = ConnectorEndConvention.getTargetEnd(getLink()).getRole();
		if (!(getLink().eContainer() instanceof StructuredClassifier)) {
			return false;
		}
		StructuredClassifier container = (StructuredClassifier) getLink().eContainer();
		return UMLBaseItemSemanticEditPolicy.LinkConstraints.canExistConnector_4005(container, source, getNewTarget());
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
	 * [209651] clear partWithPort
	 * 
	 * @generated NOT
	 */
	protected CommandResult reorientSource() throws ExecutionException {
		ConnectorEnd ce = ConnectorEndConvention.getSourceEnd(getLink());
		ce.setRole(getNewSource());
		if (ce.getPartWithPort() != null) {
			ce.setPartWithPort(null);
		}
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * [209651] clear partWithPort
	 * 
	 * @generated NOT
	 */
	protected CommandResult reorientTarget() throws ExecutionException {
		ConnectorEnd ce = ConnectorEndConvention.getTargetEnd(getLink());
		ce.setRole(getNewTarget());
		if (ce.getPartWithPort() != null) {
			ce.setPartWithPort(null);
		}
		return CommandResult.newOKCommandResult(getLink());
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
