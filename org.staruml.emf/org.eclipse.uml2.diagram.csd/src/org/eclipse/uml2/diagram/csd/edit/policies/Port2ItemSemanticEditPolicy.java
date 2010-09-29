package org.eclipse.uml2.diagram.csd.edit.policies;

import java.util.Iterator;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
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
import org.eclipse.uml2.diagram.csd.edit.commands.CommentAnnotatedElementCreateCommand;
import org.eclipse.uml2.diagram.csd.edit.commands.CommentAnnotatedElementReorientCommand;
import org.eclipse.uml2.diagram.csd.edit.commands.ConnectorCreateCommand;
import org.eclipse.uml2.diagram.csd.edit.commands.ConnectorReorientCommand;
import org.eclipse.uml2.diagram.csd.edit.commands.ConstraintConstrainedElementCreateCommand;
import org.eclipse.uml2.diagram.csd.edit.commands.ConstraintConstrainedElementReorientCommand;
import org.eclipse.uml2.diagram.csd.edit.commands.DependencyCreateCommand;
import org.eclipse.uml2.diagram.csd.edit.commands.DependencyReorientCommand;
import org.eclipse.uml2.diagram.csd.edit.commands.PortProvidedCreateCommand;
import org.eclipse.uml2.diagram.csd.edit.commands.PortProvidedReorientCommand;
import org.eclipse.uml2.diagram.csd.edit.commands.PortRequiredCreateCommand;
import org.eclipse.uml2.diagram.csd.edit.commands.PortRequiredReorientCommand;
import org.eclipse.uml2.diagram.csd.edit.commands.UsageCreateCommand;
import org.eclipse.uml2.diagram.csd.edit.commands.UsageReorientCommand;
import org.eclipse.uml2.diagram.csd.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.ConnectorEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.ConstraintConstrainedElementEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.DependencyEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.PortProvidedEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.PortRequiredEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.UsageEditPart;
import org.eclipse.uml2.diagram.csd.part.UMLVisualIDRegistry;
import org.eclipse.uml2.diagram.csd.providers.UMLElementTypes;

/**
 * @generated
 */
public class Port2ItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public Port2ItemSemanticEditPolicy() {
		super(UMLElementTypes.Port_3016);
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
			if (UMLVisualIDRegistry.getVisualID(incomingLink) == ConnectorEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (UMLVisualIDRegistry.getVisualID(incomingLink) == DependencyEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (UMLVisualIDRegistry.getVisualID(incomingLink) == UsageEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (UMLVisualIDRegistry.getVisualID(incomingLink) == ConstraintConstrainedElementEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null, incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
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
			if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ConnectorEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (UMLVisualIDRegistry.getVisualID(outgoingLink) == DependencyEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (UMLVisualIDRegistry.getVisualID(outgoingLink) == UsageEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (UMLVisualIDRegistry.getVisualID(outgoingLink) == PortProvidedEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(outgoingLink.getSource().getElement(), null, outgoingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (UMLVisualIDRegistry.getVisualID(outgoingLink) == PortRequiredEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(outgoingLink.getSource().getElement(), null, outgoingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
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
		if (UMLElementTypes.Connector_4005 == req.getElementType()) {
			return getGEFWrapper(new ConnectorCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Dependency_4006 == req.getElementType()) {
			return getGEFWrapper(new DependencyCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Usage_4008 == req.getElementType()) {
			return getGEFWrapper(new UsageCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.PortProvided_4010 == req.getElementType()) {
			return getGEFWrapper(new PortProvidedCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.ConstraintConstrainedElement_4012 == req.getElementType()) {
			return null;
		}
		if (UMLElementTypes.PortRequired_4014 == req.getElementType()) {
			return getGEFWrapper(new PortRequiredCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.CommentAnnotatedElement_4016 == req.getElementType()) {
			return null;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (UMLElementTypes.Connector_4005 == req.getElementType()) {
			return getGEFWrapper(new ConnectorCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Dependency_4006 == req.getElementType()) {
			return getGEFWrapper(new DependencyCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Usage_4008 == req.getElementType()) {
			return getGEFWrapper(new UsageCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.PortProvided_4010 == req.getElementType()) {
			return null;
		}
		if (UMLElementTypes.ConstraintConstrainedElement_4012 == req.getElementType()) {
			return getGEFWrapper(new ConstraintConstrainedElementCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.PortRequired_4014 == req.getElementType()) {
			return null;
		}
		if (UMLElementTypes.CommentAnnotatedElement_4016 == req.getElementType()) {
			return getGEFWrapper(new CommentAnnotatedElementCreateCommand(req, req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * [209651] prohibit link redirection to 'duplicate' port for now
	 * 
	 * @generated NOT
	 */
	protected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {
		switch (getVisualID(req)) {
		case ConnectorEditPart.VISUAL_ID:
			return UnexecutableCommand.INSTANCE;
		}
		return getReorientRelationshipCommandGen(req);
	}

	/**
	 * Returns command to reorient EClass based link. New link target or source
	 * should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientRelationshipCommandGen(ReorientRelationshipRequest req) {
		switch (getVisualID(req)) {
		case ConnectorEditPart.VISUAL_ID:
			return getGEFWrapper(new ConnectorReorientCommand(req));
		case DependencyEditPart.VISUAL_ID:
			return getGEFWrapper(new DependencyReorientCommand(req));
		case UsageEditPart.VISUAL_ID:
			return getGEFWrapper(new UsageReorientCommand(req));
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
		case ConstraintConstrainedElementEditPart.VISUAL_ID:
			return getGEFWrapper(new ConstraintConstrainedElementReorientCommand(req));
		case PortRequiredEditPart.VISUAL_ID:
			return getGEFWrapper(new PortRequiredReorientCommand(req));
		case CommentAnnotatedElementEditPart.VISUAL_ID:
			return getGEFWrapper(new CommentAnnotatedElementReorientCommand(req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
