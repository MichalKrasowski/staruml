package org.eclipse.uml2.diagram.clazz.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.uml2.diagram.clazz.edit.policies.UMLBaseItemSemanticEditPolicy;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.GeneralizationSet;

/**
 * @generated
 */
public class GeneralizationReorientCommand extends EditElementCommand {

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
	public GeneralizationReorientCommand(ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		reorientDirection = request.getDirection();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	 * @generated
	 */
	public boolean canExecute() {
		if (false == getElementToEdit() instanceof Generalization) {
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
		if (!(oldEnd instanceof Classifier && newEnd instanceof Classifier)) {
			return false;
		}
		Classifier target = getLink().getGeneral();
		return UMLBaseItemSemanticEditPolicy.LinkConstraints.canExistGeneralization_4001(getNewSource(), target);
	}

	/**
	 * @generated
	 */
	protected boolean canReorientTargetGen() {
		if (!(oldEnd instanceof Classifier && newEnd instanceof Classifier)) {
			return false;
		}
		if (!(getLink().eContainer() instanceof Classifier)) {
			return false;
		}
		Classifier source = (Classifier) getLink().eContainer();
		return UMLBaseItemSemanticEditPolicy.LinkConstraints.canExistGeneralization_4001(source, getNewTarget());
	}

	/**
	 * @generated NOT
	 * #215340 Generalization redirecting to GeneralizationSet
	 */
	protected boolean canReorientTarget() {
		if (newEnd instanceof GeneralizationSet) {
			return canReorientTarget(oldEnd, getGeneralClassifier((GeneralizationSet) newEnd));
		}
		if (newEnd instanceof Generalization) {
			return canReorientTarget(oldEnd, ((Generalization) newEnd).getGeneral());
		}
		return canReorientTargetGen();
	}

	/**
	 * @NOT-generated
	 * #215340 Generalization redirecting to GeneralizationSet
	 */
	private boolean canReorientTarget(EObject oldTarget, Classifier newTarget) {
		if (newTarget == null) {
			return false;
		}
		if (!(oldTarget instanceof Classifier)) {
			return false;
		}
		if (!(getLink().eContainer() instanceof Classifier)) {
			return false;
		}
		Classifier source = (Classifier) getLink().eContainer();
		return UMLBaseItemSemanticEditPolicy.LinkConstraints.canExistGeneralization_4001(source, newTarget);
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
		getOldSource().getGeneralizations().remove(getLink());
		getNewSource().getGeneralizations().add(getLink());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated NOT
	 * #215340 Generalization redirecting to GeneralizationSet
	 */
	protected CommandResult reorientTarget() throws ExecutionException {
		getLink().setGeneral(getNewTarget());
		if (newEnd instanceof Generalization) {
			GeneralizationSet gs = (GeneralizationSet) getNewTarget().getNearestPackage().createPackagedElement("", org.eclipse.uml2.uml.UMLPackage.eINSTANCE.getGeneralizationSet());
			gs.getGeneralizations().add((Generalization) newEnd);
			gs.getGeneralizations().add(getLink());
		}
		if (newEnd instanceof GeneralizationSet) {
			((GeneralizationSet) newEnd).getGeneralizations().add(getLink());
		}
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated
	 */
	protected Generalization getLink() {
		return (Generalization) getElementToEdit();
	}

	/**
	 * @generated
	 */
	protected Classifier getOldSource() {
		return (Classifier) oldEnd;
	}

	/**
	 * @generated
	 */
	protected Classifier getNewSource() {
		return (Classifier) newEnd;
	}

	/**
	 * @generated
	 */
	protected Classifier getOldTarget() {
		return (Classifier) oldEnd;
	}

	/**
	 * @generated NOT
	 * #215340 Generalization redirecting to GeneralizationSet
	 */
	protected Classifier getNewTarget() {
		if (newEnd instanceof GeneralizationSet) {
			return getGeneralClassifier((GeneralizationSet) newEnd);
		}
		if (newEnd instanceof Generalization) {
			return ((Generalization) newEnd).getGeneral();
		}
		return (Classifier) newEnd;
	}

	/**
	 * @NOT-generated
	 * #215340 Generalization redirecting to GeneralizationSet
	 */
	private Classifier getGeneralClassifier(GeneralizationSet gs) {
		EList<Generalization> generalizations = ((GeneralizationSet) newEnd).getGeneralizations();
		if (generalizations.isEmpty()) {
			return null;
		}
		return generalizations.get(0).getGeneral();
	}
}
