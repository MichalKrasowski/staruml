package org.eclipse.uml2.diagram.component.edit.policies;

import java.util.Iterator;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.component.edit.commands.AssociationCreateCommand;
import org.eclipse.uml2.diagram.component.edit.commands.AssociationReorientCommand;
import org.eclipse.uml2.diagram.component.edit.commands.CommentAnnotatedElementCreateCommand;
import org.eclipse.uml2.diagram.component.edit.commands.CommentAnnotatedElementReorientCommand;
import org.eclipse.uml2.diagram.component.edit.commands.ComponentRequiredCreateCommand;
import org.eclipse.uml2.diagram.component.edit.commands.ComponentRequiredReorientCommand;
import org.eclipse.uml2.diagram.component.edit.commands.DependencyCreateCommand;
import org.eclipse.uml2.diagram.component.edit.commands.DependencyReorientCommand;
import org.eclipse.uml2.diagram.component.edit.commands.InterfaceRealizationCreateCommand;
import org.eclipse.uml2.diagram.component.edit.commands.InterfaceRealizationReorientCommand;
import org.eclipse.uml2.diagram.component.edit.commands.PortProvidedCreateCommand;
import org.eclipse.uml2.diagram.component.edit.commands.PortProvidedReorientCommand;
import org.eclipse.uml2.diagram.component.edit.commands.PortRequiredCreateCommand;
import org.eclipse.uml2.diagram.component.edit.commands.PortRequiredReorientCommand;
import org.eclipse.uml2.diagram.component.edit.parts.AssociationEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ComponentRequiredEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.DependencyEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.InterfaceRealizationEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.PortProvidedEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.PortRequiredEditPart;
import org.eclipse.uml2.diagram.component.part.UMLVisualIDRegistry;
import org.eclipse.uml2.diagram.component.providers.UMLElementTypes;

/**
 * @generated
 */
public class InterfaceItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public InterfaceItemSemanticEditPolicy() {
		super(UMLElementTypes.Interface_3005);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		View view = (View) getHost().getModel();
		CompositeTransactionalCommand cmd = new CompositeTransactionalCommand(getEditingDomain(), null);
		cmd.setTransactionNestingEnabled(false);
		for (Iterator it = view.getTargetEdges().iterator(); it.hasNext();) {
			Edge incomingLink = (Edge) it.next();
			if (UMLVisualIDRegistry.getVisualID(incomingLink) == InterfaceRealizationEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (UMLVisualIDRegistry.getVisualID(incomingLink) == PortProvidedEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null, incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (UMLVisualIDRegistry.getVisualID(incomingLink) == PortRequiredEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null, incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (UMLVisualIDRegistry.getVisualID(incomingLink) == ComponentRequiredEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null, incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (UMLVisualIDRegistry.getVisualID(incomingLink) == DependencyEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (UMLVisualIDRegistry.getVisualID(incomingLink) == AssociationEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (UMLVisualIDRegistry.getVisualID(incomingLink) == CommentAnnotatedElementEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null, incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
		}
		for (Iterator it = view.getSourceEdges().iterator(); it.hasNext();) {
			Edge outgoingLink = (Edge) it.next();
			if (UMLVisualIDRegistry.getVisualID(outgoingLink) == DependencyEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (UMLVisualIDRegistry.getVisualID(outgoingLink) == AssociationEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
		}
		EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
		if (annotation == null) {
			// there are indirectly referenced children, need extra commands: false
			addDestroyShortcutsCommand(cmd, view);
			// delete host element
			cmd.add(new DestroyElementCommand(req));
		} else {
			cmd.add(new DeleteCommand(getEditingDomain(), view));
		}
		return getGEFWrapper(cmd.reduce());
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
		if (UMLElementTypes.InterfaceRealization_4001 == req.getElementType()) {
			return null;
		}
		if (UMLElementTypes.PortProvided_4006 == req.getElementType()) {
			return null;
		}
		if (UMLElementTypes.PortRequired_4004 == req.getElementType()) {
			return null;
		}
		if (UMLElementTypes.ComponentRequired_4007 == req.getElementType()) {
			return null;
		}
		if (UMLElementTypes.Dependency_4009 == req.getElementType()) {
			return getGEFWrapper(new DependencyCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Association_4011 == req.getElementType()) {
			return getGEFWrapper(new AssociationCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.CommentAnnotatedElement_4012 == req.getElementType()) {
			return null;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (UMLElementTypes.InterfaceRealization_4001 == req.getElementType()) {
			return getGEFWrapper(new InterfaceRealizationCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.PortProvided_4006 == req.getElementType()) {
			return getGEFWrapper(new PortProvidedCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.PortRequired_4004 == req.getElementType()) {
			return getGEFWrapper(new PortRequiredCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.ComponentRequired_4007 == req.getElementType()) {
			return getGEFWrapper(new ComponentRequiredCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Dependency_4009 == req.getElementType()) {
			return getGEFWrapper(new DependencyCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Association_4011 == req.getElementType()) {
			return getGEFWrapper(new AssociationCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.CommentAnnotatedElement_4012 == req.getElementType()) {
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
		case InterfaceRealizationEditPart.VISUAL_ID:
			return getGEFWrapper(new InterfaceRealizationReorientCommand(req));
		case DependencyEditPart.VISUAL_ID:
			return getGEFWrapper(new DependencyReorientCommand(req));
		case AssociationEditPart.VISUAL_ID:
			return getGEFWrapper(new AssociationReorientCommand(req));
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
		case PortProvidedEditPart.VISUAL_ID:
			return getGEFWrapper(new PortProvidedReorientCommand(req));
		case PortRequiredEditPart.VISUAL_ID:
			return getGEFWrapper(new PortRequiredReorientCommand(req));
		case ComponentRequiredEditPart.VISUAL_ID:
			return getGEFWrapper(new ComponentRequiredReorientCommand(req));
		case CommentAnnotatedElementEditPart.VISUAL_ID:
			return getGEFWrapper(new CommentAnnotatedElementReorientCommand(req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
