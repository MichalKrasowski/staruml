package org.eclipse.uml2.diagram.sequence.edit.policies;

import java.util.Iterator;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.common.core.command.ICompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.sequence.edit.commands.GateCreateCommand;
import org.eclipse.uml2.diagram.sequence.edit.commands.LayeredCombinedFragmentCreateCommand;
import org.eclipse.uml2.diagram.sequence.edit.commands.LayeredInteractionUseCreateCommand;
import org.eclipse.uml2.diagram.sequence.edit.commands.LifelineCreateCommand;
import org.eclipse.uml2.diagram.sequence.edit.commands.MessageCreateCommand;
import org.eclipse.uml2.diagram.sequence.edit.commands.MessageReorientCommand;
import org.eclipse.uml2.diagram.sequence.edit.parts.GateEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.LayeredCombinedFragmentEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.LayeredInteractionUseEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.MessageEditPart;
import org.eclipse.uml2.diagram.sequence.part.UMLVisualIDRegistry;
import org.eclipse.uml2.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */

public class InteractionItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public InteractionItemSemanticEditPolicy() {
		super(UMLElementTypes.Interaction_2001);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (UMLElementTypes.Gate_3005 == req.getElementType()) {
			return getGEFWrapper(new GateCreateCommand(req));
		}
		if (UMLElementTypes.InteractionUse_3007 == req.getElementType()) {
			return getGEFWrapper(new LayeredInteractionUseCreateCommand(req));
		}
		if (UMLElementTypes.CombinedFragment_3008 == req.getElementType()) {
			return getGEFWrapper(new LayeredCombinedFragmentCreateCommand(req));
		}
		if (UMLElementTypes.Lifeline_3001 == req.getElementType()) {
			return getGEFWrapper(new LifelineCreateCommand(req));
		}
		return super.getCreateCommand(req);
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
			if (UMLVisualIDRegistry.getVisualID(incomingLink) == MessageEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
		}
		for (Iterator it = view.getSourceEdges().iterator(); it.hasNext();) {
			Edge outgoingLink = (Edge) it.next();
			if (UMLVisualIDRegistry.getVisualID(outgoingLink) == MessageEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
		}
		EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
		if (annotation == null) {
			// there are indirectly referenced children, need extra commands: false
			addDestroyChildNodesCommand(cmd);
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
	private void addDestroyChildNodesCommand(ICompositeCommand cmd) {
		View view = (View) getHost().getModel();
		for (Iterator nit = view.getChildren().iterator(); nit.hasNext();) {
			Node node = (Node) nit.next();
			switch (UMLVisualIDRegistry.getVisualID(node)) {
			case GateEditPart.VISUAL_ID:
				for (Iterator it = node.getTargetEdges().iterator(); it.hasNext();) {
					Edge incomingLink = (Edge) it.next();
					if (UMLVisualIDRegistry.getVisualID(incomingLink) == MessageEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
				}
				for (Iterator it = node.getSourceEdges().iterator(); it.hasNext();) {
					Edge outgoingLink = (Edge) it.next();
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == MessageEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
				}
				cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), node.getElement(), false))); // directlyOwned: true
				// don't need explicit deletion of node as parent's view deletion would clean child views as well 
				// cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), node));
				break;
			case LayeredInteractionUseEditPart.VISUAL_ID:
				for (Iterator it = node.getTargetEdges().iterator(); it.hasNext();) {
					Edge incomingLink = (Edge) it.next();
					if (UMLVisualIDRegistry.getVisualID(incomingLink) == MessageEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
				}
				for (Iterator it = node.getSourceEdges().iterator(); it.hasNext();) {
					Edge outgoingLink = (Edge) it.next();
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == MessageEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
				}
				cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), node.getElement(), false))); // directlyOwned: true
				// don't need explicit deletion of node as parent's view deletion would clean child views as well 
				// cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), node));
				break;
			case LayeredCombinedFragmentEditPart.VISUAL_ID:
				for (Iterator it = node.getTargetEdges().iterator(); it.hasNext();) {
					Edge incomingLink = (Edge) it.next();
					if (UMLVisualIDRegistry.getVisualID(incomingLink) == MessageEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
				}
				for (Iterator it = node.getSourceEdges().iterator(); it.hasNext();) {
					Edge outgoingLink = (Edge) it.next();
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == MessageEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
				}
				cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), node.getElement(), false))); // directlyOwned: true
				// don't need explicit deletion of node as parent's view deletion would clean child views as well 
				// cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), node));
				break;
			case LifelineEditPart.VISUAL_ID:
				for (Iterator it = node.getTargetEdges().iterator(); it.hasNext();) {
					Edge incomingLink = (Edge) it.next();
					if (UMLVisualIDRegistry.getVisualID(incomingLink) == MessageEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
				}
				for (Iterator it = node.getSourceEdges().iterator(); it.hasNext();) {
					Edge outgoingLink = (Edge) it.next();
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == MessageEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
				}
				cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), node.getElement(), false))); // directlyOwned: true
				// don't need explicit deletion of node as parent's view deletion would clean child views as well 
				// cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), node));
				break;
			}
		}
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
		if (UMLElementTypes.Message_4001 == req.getElementType()) {
			return getGEFWrapper(new MessageCreateCommand(req, req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (UMLElementTypes.Message_4001 == req.getElementType()) {
			return getGEFWrapper(new MessageCreateCommand(req, req.getSource(), req.getTarget()));
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
		case MessageEditPart.VISUAL_ID:
			return getGEFWrapper(new MessageReorientCommand(req));
		}
		return super.getReorientRelationshipCommand(req);
	}

}
