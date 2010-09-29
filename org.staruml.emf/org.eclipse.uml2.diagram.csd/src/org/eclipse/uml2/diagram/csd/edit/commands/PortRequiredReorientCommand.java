package org.eclipse.uml2.diagram.csd.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.uml2.diagram.common.commands.RequiredPortLinkHelper;
import org.eclipse.uml2.diagram.csd.edit.policies.UMLBaseItemSemanticEditPolicy;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Port;

/**
 * @generated
 */
public class PortRequiredReorientCommand extends EditElementCommand {

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
	 * @NOT-generated
	 */
	private final RequiredPortLinkHelper myLinkHelper;

	/**
	 * @generated NOT
	 */
	public PortRequiredReorientCommand(ReorientReferenceRelationshipRequest request) {
		super(request.getLabel(), null, request);
		reorientDirection = request.getDirection();
		referenceOwner = request.getReferenceOwner();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
		myLinkHelper = new RequiredPortLinkHelper((AdapterFactoryEditingDomain) getEditingDomain(), referenceOwner, oldEnd);
	}

	/**
	 * @generated
	 */
	public boolean canExecute() {
		if (false == referenceOwner instanceof Port) {
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
	protected boolean canReorientSourceGen() {
		if (!(oldEnd instanceof Interface && newEnd instanceof Port)) {
			return false;
		}
		return UMLBaseItemSemanticEditPolicy.LinkConstraints.canExistPortRequired_4014(getNewSource(), getOldTarget());
	}

	/**
	 * @generated NOT
	 */
	protected boolean canReorientSource() {
		return canReorientSourceGen() && myLinkHelper.canReorientSource(getNewSource());
	}

	/**
	 * @generated
	 */
	protected boolean canReorientTargetGen() {
		if (!(oldEnd instanceof Interface && newEnd instanceof Interface)) {
			return false;
		}
		return UMLBaseItemSemanticEditPolicy.LinkConstraints.canExistPortRequired_4014(getOldSource(), getNewTarget());
	}

	/**
	 * @generated NOT
	 */
	protected boolean canReorientTarget() {
		return canReorientTargetGen() && myLinkHelper.canReorientTarget(getNewTarget());
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
		myLinkHelper.reorientSource(getNewSource());
		return CommandResult.newOKCommandResult(referenceOwner);
	}

	/**
	 * @generated NOT
	 */
	protected CommandResult reorientTarget() throws ExecutionException {
		myLinkHelper.reorientTarget(getNewTarget());
		return CommandResult.newOKCommandResult(referenceOwner);
	}

	/**
	 * @generated
	 */
	protected Port getOldSource() {
		return (Port) referenceOwner;
	}

	/**
	 * @generated
	 */
	protected Port getNewSource() {
		return (Port) newEnd;
	}

	/**
	 * @generated
	 */
	protected Interface getOldTarget() {
		return (Interface) oldEnd;
	}

	/**
	 * @generated
	 */
	protected Interface getNewTarget() {
		return (Interface) newEnd;
	}
}
