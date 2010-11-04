package org.eclipse.uml2.diagram.profile.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.uml2.diagram.profile.edit.commands.CommentAnnotatedElementCreateCommand;
import org.eclipse.uml2.diagram.profile.edit.commands.CommentAnnotatedElementReorientCommand;
import org.eclipse.uml2.diagram.profile.edit.commands.ConstraintConstrainedElementCreateCommand;
import org.eclipse.uml2.diagram.profile.edit.commands.ConstraintConstrainedElementReorientCommand;
import org.eclipse.uml2.diagram.profile.edit.commands.GeneralizationCreateCommand;
import org.eclipse.uml2.diagram.profile.edit.commands.GeneralizationReorientCommand;
import org.eclipse.uml2.diagram.profile.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.ConstraintConstrainedElementEditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.GeneralizationEditPart;
import org.eclipse.uml2.diagram.profile.providers.UMLElementTypes;
import org.eclipse.uml2.uml.Extension;
import org.eclipse.uml2.uml.Property;

/**
 * @generated
 */
public class ExtensionItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ExtensionItemSemanticEditPolicy() {
		super(UMLElementTypes.Extension_4002);
	}

	/**
	 * @generated NOT
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		Extension e = (Extension) req.getElementToDestroy();
		Property end = e.metaclassEnd();
		CompositeCommand cc = new CompositeCommand(req.getLabel());
		cc.add(new DestroyElementCommand(new DestroyElementRequest(end, req.isConfirmationRequired())));
		cc.add(new DestroyElementCommand(req));
		return getGEFWrapper(cc);
	}

	/**
	 * @generated
	 */
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
		Command command = req.getTarget() == null ? getStartCreateRelationshipCommand(req) : getCompleteCreateRelationshipCommand(req);
		return command != null ? command : super.getCreateRelationshipCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (UMLElementTypes.Generalization_4001 == req.getElementType()) {
			return getGEFWrapper(new GeneralizationCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.ConstraintConstrainedElement_4003 == req.getElementType()) {
			return null;
		}
		if (UMLElementTypes.CommentAnnotatedElement_4004 == req.getElementType()) {
			return null;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (UMLElementTypes.Generalization_4001 == req.getElementType()) {
			return getGEFWrapper(new GeneralizationCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.ConstraintConstrainedElement_4003 == req.getElementType()) {
			return getGEFWrapper(new ConstraintConstrainedElementCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.CommentAnnotatedElement_4004 == req.getElementType()) {
			return getGEFWrapper(new CommentAnnotatedElementCreateCommand(req, req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * Returns command to reorient EClass based link. New link target or source
	 * should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {
		switch (getVisualID(req)) {
		case GeneralizationEditPart.VISUAL_ID:
			return getGEFWrapper(new GeneralizationReorientCommand(req));
		}
		return super.getReorientRelationshipCommand(req);
	}

	/**
	 * Returns command to reorient EReference based link. New link target or source
	 * should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest req) {
		switch (getVisualID(req)) {
		case ConstraintConstrainedElementEditPart.VISUAL_ID:
			return getGEFWrapper(new ConstraintConstrainedElementReorientCommand(req));
		case CommentAnnotatedElementEditPart.VISUAL_ID:
			return getGEFWrapper(new CommentAnnotatedElementReorientCommand(req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
