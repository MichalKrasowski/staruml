package org.eclipse.uml2.diagram.component.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.uml2.diagram.component.edit.policies.UMLBaseItemSemanticEditPolicy;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;

/**
 * We have changed logic completely, and some of the methods should not be called. 
 * It would be better to remove them, but generator will add them, again and again.
 * So, we just throwing IllegalStateException from all of the generated but not actually supported methods.
 * @generated
 */
public class AssemblyConnectorEndRoleReorientCommand extends EditElementCommand {

	/**
	 * @generated
	 */
	private final int reorientDirection;

	/**
	 * @generated
	 */
	private final EObject referenceOwner;

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
	public AssemblyConnectorEndRoleReorientCommand(ReorientReferenceRelationshipRequest request) {
		super(request.getLabel(), null, request);
		reorientDirection = request.getDirection();
		referenceOwner = request.getReferenceOwner();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	 * @generated NOT
	 */
	public boolean canExecute() {
		if (false == referenceOwner instanceof Connector) {
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
	 * @generated NOT -- source is fixed
	 */
	protected boolean canReorientSource() {
		return false;
	}

	/**
	 * @generated NOT
	 */
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof ConnectableElement && newEnd instanceof ConnectableElement)) {
			return false;
		}
		return findConectorEnd((ConnectableElement) oldEnd) != null;
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
		throw new IllegalStateException("Source is fixed");
	}

	/**
	 * @generated NOT
	 */
	protected CommandResult reorientTarget() throws ExecutionException {
		ConnectorEnd end = findConectorEnd(getOldTarget());
		end.setRole(getNewTarget());
		return CommandResult.newOKCommandResult(referenceOwner);
	}

	/**
	 * @generated NOT
	 */
	protected ConnectorEnd getOldSource() {
		throw new IllegalStateException();
	}

	/**
	 * @generated
	 */
	protected ConnectorEnd getNewSource() {
		return (ConnectorEnd) newEnd;
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

	private Connector getAssemblyConnector() {
		return (Connector) referenceOwner;
	}

	private ConnectorEnd findConectorEnd(ConnectableElement diagramEnd) {
		for (ConnectorEnd nextEnd : getAssemblyConnector().getEnds()) {
			if (diagramEnd.equals(nextEnd.getRole())) {
				return nextEnd;
			}
		}
		return null;
	}

}
