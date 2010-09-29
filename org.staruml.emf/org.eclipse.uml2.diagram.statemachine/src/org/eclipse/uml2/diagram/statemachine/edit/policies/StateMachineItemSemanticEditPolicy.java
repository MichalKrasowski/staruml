package org.eclipse.uml2.diagram.statemachine.edit.policies;

import java.util.Iterator;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.common.core.command.ICompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.statemachine.edit.commands.EntryPointPseudostateCreateCommand;
import org.eclipse.uml2.diagram.statemachine.edit.commands.ExitPointPseudostateCreateCommand;
import org.eclipse.uml2.diagram.statemachine.edit.commands.StateMachine_RegionCreateCommand;
import org.eclipse.uml2.diagram.statemachine.edit.parts.EntryPointPseudostateEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.ExitPointPseudostateEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.StateMachine_RegionEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.TransitionEditPart;
import org.eclipse.uml2.diagram.statemachine.part.UMLVisualIDRegistry;
import org.eclipse.uml2.diagram.statemachine.providers.UMLElementTypes;

/**
 * @generated
 */

public class StateMachineItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public StateMachineItemSemanticEditPolicy() {
		super(UMLElementTypes.StateMachine_2005);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (UMLElementTypes.Region_3013 == req.getElementType()) {
			return getGEFWrapper(new StateMachine_RegionCreateCommand(req));
		}
		if (UMLElementTypes.Pseudostate_3014 == req.getElementType()) {
			return getGEFWrapper(new EntryPointPseudostateCreateCommand(req));
		}
		if (UMLElementTypes.Pseudostate_3015 == req.getElementType()) {
			return getGEFWrapper(new ExitPointPseudostateCreateCommand(req));
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
			case StateMachine_RegionEditPart.VISUAL_ID:
				cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), node.getElement(), false))); // directlyOwned: true
				// don't need explicit deletion of node as parent's view deletion would clean child views as well 
				// cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), node));
				break;
			case EntryPointPseudostateEditPart.VISUAL_ID:
				for (Iterator it = node.getTargetEdges().iterator(); it.hasNext();) {
					Edge incomingLink = (Edge) it.next();
					if (UMLVisualIDRegistry.getVisualID(incomingLink) == TransitionEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
				}
				for (Iterator it = node.getSourceEdges().iterator(); it.hasNext();) {
					Edge outgoingLink = (Edge) it.next();
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == TransitionEditPart.VISUAL_ID) {
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
			case ExitPointPseudostateEditPart.VISUAL_ID:
				for (Iterator it = node.getTargetEdges().iterator(); it.hasNext();) {
					Edge incomingLink = (Edge) it.next();
					if (UMLVisualIDRegistry.getVisualID(incomingLink) == TransitionEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
				}
				for (Iterator it = node.getSourceEdges().iterator(); it.hasNext();) {
					Edge outgoingLink = (Edge) it.next();
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == TransitionEditPart.VISUAL_ID) {
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

}
