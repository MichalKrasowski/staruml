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
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Usage;

/**
 * @generated
 */
public class ComponentRequiredReorientCommand extends EditElementCommand {

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
	public ComponentRequiredReorientCommand(ReorientReferenceRelationshipRequest request) {
		super(request.getLabel(), null, request);
		reorientDirection = request.getDirection();
		referenceOwner = request.getReferenceOwner();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	 * @generated
	 */
	public boolean canExecute() {
		if (false == referenceOwner instanceof Component) {
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
		if (!(oldEnd instanceof Interface && newEnd instanceof Component)) {
			return false;
		}
		return UMLBaseItemSemanticEditPolicy.LinkConstraints.canExistComponentRequired_4007(getNewSource(), getOldTarget());
	}

	/**
	 * @generated NOT
	 */
	protected boolean canReorientSource() {
		boolean result = canReorientSourceGen();
		if (result) {
			// in addition to the basic checks, we can not handle the deep
			// usages derived from realizing classifiers, but we handle the
			// usages of the component itself.
			// Other required's links will be shown on diagram (say, after
			// initialization) but won't be reroutable
			result = findUsage(getOldSource(), getOldTarget()) != null;
		}
		return result;
	}

	/**
	 * @generated
	 */
	protected boolean canReorientTargetGen() {
		if (!(oldEnd instanceof Interface && newEnd instanceof Interface)) {
			return false;
		}
		return UMLBaseItemSemanticEditPolicy.LinkConstraints.canExistComponentRequired_4007(getOldSource(), getNewTarget());
	}

	/**
	 * @generated NOT
	 */
	protected boolean canReorientTarget() {
		boolean result = canReorientTargetGen();
		if (result) {
			// in addition to the basic checks, we can not handle the deep
			// usages derived from realizing classifiers, but we handle the
			// usages of the component itself.
			// Other required's links will be shown on diagram (say, after
			// initialization) but won't be reroutable
			result = findUsage(getOldSource(), getOldTarget()) != null;
		}
		return result;
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
		Usage usage = findUsage(getOldSource(), getOldTarget());
		if (usage != null) {
			usage.getClients().remove(getOldSource());
			usage.getClients().add(getNewSource());
		}
		return CommandResult.newOKCommandResult(referenceOwner);
	}

	/**
	 * @generated NOT
	 */
	protected CommandResult reorientTarget() throws ExecutionException {
		Component component = getOldSource();
		Usage usage = findUsage(component, getOldTarget());
		if (usage != null) {
			usage.getSuppliers().remove(getOldTarget());
			usage.getSuppliers().add(getNewTarget());
		}
		return CommandResult.newOKCommandResult(referenceOwner);
	}

	/**
	 * @generated
	 */
	protected Component getOldSource() {
		return (Component) referenceOwner;
	}

	/**
	 * @generated
	 */
	protected Component getNewSource() {
		return (Component) newEnd;
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

	private Usage findUsage(Component component, Interface required) {
		for (Dependency next : component.getClientDependencies()) {
			if (next instanceof Usage && next.getSuppliers().contains(required)) {
				return (Usage) next;
			}
		}
		return null;
	}
}
