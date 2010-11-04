package org.eclipse.uml2.diagram.profile.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.uml2.diagram.profile.edit.policies.UMLBaseItemSemanticEditPolicy;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.Extension;
import org.eclipse.uml2.uml.ExtensionEnd;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class ExtensionReorientCommand extends EditElementCommand {

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
	public ExtensionReorientCommand(ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		reorientDirection = request.getDirection();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	 * @generated
	 */
	public boolean canExecute() {
		if (false == getElementToEdit() instanceof Extension) {
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
		if (!(oldEnd instanceof Stereotype && newEnd instanceof Stereotype)) {
			return false;
		}
		Stereotype source = (Stereotype) newEnd;
		Profile profile = (Profile) getLink().eContainer();
		Classifier metaclass = getLink().getMetaclass();
		ElementImport target = profile.getElementImport(metaclass, false);
		return UMLBaseItemSemanticEditPolicy.LinkConstraints.canExistExtension_4002(profile, source, target);
	}

	/**
	 * @generated NOT
	 */
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof ElementImport && newEnd instanceof ElementImport)) {
			return false;
		}
		if (!(getLink().eContainer() instanceof Profile)) {
			return false;
		}
		Profile profile = (Profile) getLink().eContainer();
		Stereotype source = getLink().getStereotype();
		ElementImport target = (ElementImport) newEnd;
		return UMLBaseItemSemanticEditPolicy.LinkConstraints.canExistExtension_4002(profile, source, target);
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
		Extension extension = getLink();
		Stereotype oldSource = (Stereotype) oldEnd;
		Stereotype newStereotype = (Stereotype) newEnd;

		replaceStereotype(extension, newStereotype);

		return CommandResult.newOKCommandResult(extension);
	}

	/**
	 * @generated NOT
	 */
	protected CommandResult reorientTarget() throws ExecutionException {
		Extension extension = (Extension) getElementToEdit();
		ElementImport oldTarget = (ElementImport) oldEnd;
		ElementImport newTarget = (ElementImport) newEnd;

		org.eclipse.uml2.uml.Class newMetaclass = (org.eclipse.uml2.uml.Class) newTarget.getImportedElement();
		replaceMetaclass(extension, newMetaclass);

		return CommandResult.newOKCommandResult(extension);
	}

	/**
	 * @NOT-generated
	 */
	private void replaceMetaclass(Extension extension, org.eclipse.uml2.uml.Class newMetaclass) {
		Stereotype stereotype = extension.getStereotype();
		if (stereotype == null) {
			return;
		}
		String newExtensionName = newMetaclass.getName() + "_" + stereotype.getName();
		extension.setName(newExtensionName);

		Property metaclassEnd = extension.metaclassEnd();
		String newPropertyName = Extension.METACLASS_ROLE_PREFIX + newMetaclass.getName();
		if (metaclassEnd == null) {
			Property newMetaclassEnd = stereotype.createOwnedAttribute(newPropertyName, newMetaclass);
		} else {
			metaclassEnd.setName(newPropertyName);
			metaclassEnd.setType(newMetaclass);
		}
	}

	/**
	 * @NOT-generated
	 */
	private void replaceStereotype(Extension extension, Stereotype newStereotype) {
		org.eclipse.uml2.uml.Class metaclass = extension.getMetaclass();
		if (metaclass == null) {
			return;
		}

		Property metaclassEnd = extension.metaclassEnd();
		if (metaclassEnd != null) {
			metaclassEnd.destroy();
		}
		Property newMetaclassEnd = newStereotype.createOwnedAttribute(Extension.METACLASS_ROLE_PREFIX + metaclass.getName(), metaclass);
		newMetaclassEnd.setAssociation(extension);

		String newExtensionName = metaclass.getName() + "_" + newStereotype.getName();
		extension.setName(newExtensionName);

		Property stereotypeEnd = extension.getStereotypeEnd();
		String stereotypeEndName = Extension.STEREOTYPE_ROLE_PREFIX + newStereotype.getName();
		if (stereotypeEnd == null) {
			ExtensionEnd extensionEnd = (ExtensionEnd) extension.createOwnedEnd(stereotypeEndName, newStereotype, UMLPackage.Literals.EXTENSION_END);
			extensionEnd.setAggregation(AggregationKind.COMPOSITE_LITERAL);
		} else {
			stereotypeEnd.setType(newStereotype);
			stereotypeEnd.setName(stereotypeEndName);
		}
	}

	/**
	 * @generated
	 */
	protected Extension getLink() {
		return (Extension) getElementToEdit();
	}

	/**
	 * @generated
	 */
	protected Stereotype getOldSource() {
		return (Stereotype) oldEnd;
	}

	/**
	 * @generated
	 */
	protected Stereotype getNewSource() {
		return (Stereotype) newEnd;
	}

	/**
	 * @generated
	 */
	protected ElementImport getOldTarget() {
		return (ElementImport) oldEnd;
	}

	/**
	 * @generated
	 */
	protected ElementImport getNewTarget() {
		return (ElementImport) newEnd;
	}
}
