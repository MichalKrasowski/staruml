package org.eclipse.uml2.diagram.activity.edit.policies;

import java.util.Iterator;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.activity.edit.commands.AcceptEventActionCreateCommand;
import org.eclipse.uml2.diagram.activity.edit.commands.AcceptTimeEventActionCreateCommand;
import org.eclipse.uml2.diagram.activity.edit.commands.ActivityFinalNodeCreateCommand;
import org.eclipse.uml2.diagram.activity.edit.commands.ActivityParameterNodeCreateCommand;
import org.eclipse.uml2.diagram.activity.edit.commands.ActivityPartitionCreateCommand;
import org.eclipse.uml2.diagram.activity.edit.commands.AddStructuralFeatureValueActionCreateCommand;
import org.eclipse.uml2.diagram.activity.edit.commands.CallBehaviorActionCreateCommand;
import org.eclipse.uml2.diagram.activity.edit.commands.CallOperationActionCreateCommand;
import org.eclipse.uml2.diagram.activity.edit.commands.CentralBufferNodeCreateCommand;
import org.eclipse.uml2.diagram.activity.edit.commands.ConditionalNodeCreateCommand;
import org.eclipse.uml2.diagram.activity.edit.commands.CreateObjectActionCreateCommand;
import org.eclipse.uml2.diagram.activity.edit.commands.DataStoreNodeCreateCommand;
import org.eclipse.uml2.diagram.activity.edit.commands.DecisionNodeCreateCommand;
import org.eclipse.uml2.diagram.activity.edit.commands.ExpansionRegionCreateCommand;
import org.eclipse.uml2.diagram.activity.edit.commands.FlowFinalNodeCreateCommand;
import org.eclipse.uml2.diagram.activity.edit.commands.ForkNodeCreateCommand;
import org.eclipse.uml2.diagram.activity.edit.commands.InitialNodeCreateCommand;
import org.eclipse.uml2.diagram.activity.edit.commands.JoinNodeCreateCommand;
import org.eclipse.uml2.diagram.activity.edit.commands.LoopNodeCreateCommand;
import org.eclipse.uml2.diagram.activity.edit.commands.MergeNodeCreateCommand;
import org.eclipse.uml2.diagram.activity.edit.commands.ObjectNodeSelectionCreateCommand;
import org.eclipse.uml2.diagram.activity.edit.commands.ObjectNodeSelectionReorientCommand;
import org.eclipse.uml2.diagram.activity.edit.commands.OpaqueActionCreateCommand;
import org.eclipse.uml2.diagram.activity.edit.commands.OpaqueBehaviorCreateCommand;
import org.eclipse.uml2.diagram.activity.edit.commands.ParameterSetCreateCommand;
import org.eclipse.uml2.diagram.activity.edit.commands.PinCreateCommand;
import org.eclipse.uml2.diagram.activity.edit.commands.SendSignalActionCreateCommand;
import org.eclipse.uml2.diagram.activity.edit.commands.StructuredActivityNodeCreateCommand;
import org.eclipse.uml2.diagram.activity.edit.commands.ValueSpecificationActionCreateCommand;
import org.eclipse.uml2.diagram.activity.edit.parts.AcceptEventActionEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.AcceptTimeEventActionEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ActionLocalPostconditionEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ActionLocalPreconditionEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ActivityFinalNodeEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ActivityParameterNodeEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ActivityPartitionEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.AddStructuralFeatureValueActionEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.CallBehaviorActionEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.CallOperationActionEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.CentralBufferNodeEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ConditionalNodeEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ControlFlowEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.CreateObjectActionEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.DataStoreNodeEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.DecisionNodeEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ExceptionHandlerEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ExpansionRegionEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.FlowFinalNodeEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ForkNodeEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.InitialNodeEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.JoinNodeEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.LoopNodeEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.MergeNodeEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ObjectFlowEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ObjectNodeSelectionEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.OpaqueActionEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.OpaqueBehaviorEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ParameterSetEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.PinEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.SendSignalActionEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.StructuredActivityNodeEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ValueSpecificationActionEditPart;
import org.eclipse.uml2.diagram.activity.part.UMLVisualIDRegistry;
import org.eclipse.uml2.diagram.activity.providers.UMLElementTypes;

/**
 * @generated
 */

public class ActivityItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ActivityItemSemanticEditPolicy() {
		super(UMLElementTypes.Activity_2026);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (UMLElementTypes.AcceptEventAction_3030 == req.getElementType()) {
			return getGEFWrapper(new AcceptEventActionCreateCommand(req));
		}
		if (UMLElementTypes.AcceptEventAction_3031 == req.getElementType()) {
			return getGEFWrapper(new AcceptTimeEventActionCreateCommand(req));
		}
		if (UMLElementTypes.ActivityFinalNode_3032 == req.getElementType()) {
			return getGEFWrapper(new ActivityFinalNodeCreateCommand(req));
		}
		if (UMLElementTypes.DecisionNode_3033 == req.getElementType()) {
			return getGEFWrapper(new DecisionNodeCreateCommand(req));
		}
		if (UMLElementTypes.MergeNode_3034 == req.getElementType()) {
			return getGEFWrapper(new MergeNodeCreateCommand(req));
		}
		if (UMLElementTypes.InitialNode_3035 == req.getElementType()) {
			return getGEFWrapper(new InitialNodeCreateCommand(req));
		}
		if (UMLElementTypes.DataStoreNode_3036 == req.getElementType()) {
			return getGEFWrapper(new DataStoreNodeCreateCommand(req));
		}
		if (UMLElementTypes.CentralBufferNode_3037 == req.getElementType()) {
			return getGEFWrapper(new CentralBufferNodeCreateCommand(req));
		}
		if (UMLElementTypes.OpaqueAction_3029 == req.getElementType()) {
			return getGEFWrapper(new OpaqueActionCreateCommand(req));
		}
		if (UMLElementTypes.FlowFinalNode_3038 == req.getElementType()) {
			return getGEFWrapper(new FlowFinalNodeCreateCommand(req));
		}
		if (UMLElementTypes.ForkNode_3039 == req.getElementType()) {
			return getGEFWrapper(new ForkNodeCreateCommand(req));
		}
		if (UMLElementTypes.JoinNode_3040 == req.getElementType()) {
			return getGEFWrapper(new JoinNodeCreateCommand(req));
		}
		if (UMLElementTypes.Pin_3041 == req.getElementType()) {
			return getGEFWrapper(new PinCreateCommand(req));
		}
		if (UMLElementTypes.CreateObjectAction_3042 == req.getElementType()) {
			return getGEFWrapper(new CreateObjectActionCreateCommand(req));
		}
		if (UMLElementTypes.AddStructuralFeatureValueAction_3043 == req.getElementType()) {
			return getGEFWrapper(new AddStructuralFeatureValueActionCreateCommand(req));
		}
		if (UMLElementTypes.CallBehaviorAction_3044 == req.getElementType()) {
			return getGEFWrapper(new CallBehaviorActionCreateCommand(req));
		}
		if (UMLElementTypes.CallOperationAction_3045 == req.getElementType()) {
			return getGEFWrapper(new CallOperationActionCreateCommand(req));
		}
		if (UMLElementTypes.StructuredActivityNode_3046 == req.getElementType()) {
			return getGEFWrapper(new StructuredActivityNodeCreateCommand(req));
		}
		if (UMLElementTypes.OpaqueBehavior_3047 == req.getElementType()) {
			return getGEFWrapper(new OpaqueBehaviorCreateCommand(req));
		}
		if (UMLElementTypes.ActivityParameterNode_3052 == req.getElementType()) {
			return getGEFWrapper(new ActivityParameterNodeCreateCommand(req));
		}
		if (UMLElementTypes.SendSignalAction_3053 == req.getElementType()) {
			return getGEFWrapper(new SendSignalActionCreateCommand(req));
		}
		if (UMLElementTypes.ActivityPartition_3056 == req.getElementType()) {
			return getGEFWrapper(new ActivityPartitionCreateCommand(req));
		}
		if (UMLElementTypes.LoopNode_3058 == req.getElementType()) {
			return getGEFWrapper(new LoopNodeCreateCommand(req));
		}
		if (UMLElementTypes.ConditionalNode_3082 == req.getElementType()) {
			return getGEFWrapper(new ConditionalNodeCreateCommand(req));
		}
		if (UMLElementTypes.ExpansionRegion_3084 == req.getElementType()) {
			return getGEFWrapper(new ExpansionRegionCreateCommand(req));
		}
		if (UMLElementTypes.ParameterSet_3086 == req.getElementType()) {
			return getGEFWrapper(new ParameterSetCreateCommand(req));
		}
		if (UMLElementTypes.ValueSpecificationAction_3089 == req.getElementType()) {
			return getGEFWrapper(new ValueSpecificationActionCreateCommand(req));
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
			if (UMLVisualIDRegistry.getVisualID(incomingLink) == ObjectNodeSelectionEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null, incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
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
			case AcceptEventActionEditPart.VISUAL_ID:
				for (Iterator it = node.getTargetEdges().iterator(); it.hasNext();) {
					Edge incomingLink = (Edge) it.next();
					if (UMLVisualIDRegistry.getVisualID(incomingLink) == ControlFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(incomingLink) == ObjectFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(incomingLink) == ExceptionHandlerEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
				}
				for (Iterator it = node.getSourceEdges().iterator(); it.hasNext();) {
					Edge outgoingLink = (Edge) it.next();
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ControlFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ObjectFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ActionLocalPreconditionEditPart.VISUAL_ID) {
						DestroyReferenceRequest r = new DestroyReferenceRequest(outgoingLink.getSource().getElement(), null, outgoingLink.getTarget().getElement(), false);
						cmd.add(new DestroyReferenceCommand(r) {

							protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
								EObject referencedObject = getReferencedObject();
								Resource resource = referencedObject.eResource();
								CommandResult result = super.doExecuteWithResult(progressMonitor, info);
								resource.getContents().add(referencedObject);
								return result;
							}
						});
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ActionLocalPostconditionEditPart.VISUAL_ID) {
						DestroyReferenceRequest r = new DestroyReferenceRequest(outgoingLink.getSource().getElement(), null, outgoingLink.getTarget().getElement(), false);
						cmd.add(new DestroyReferenceCommand(r) {

							protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
								EObject referencedObject = getReferencedObject();
								Resource resource = referencedObject.eResource();
								CommandResult result = super.doExecuteWithResult(progressMonitor, info);
								resource.getContents().add(referencedObject);
								return result;
							}
						});
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ExceptionHandlerEditPart.VISUAL_ID) {
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
			case AcceptTimeEventActionEditPart.VISUAL_ID:
				for (Iterator it = node.getTargetEdges().iterator(); it.hasNext();) {
					Edge incomingLink = (Edge) it.next();
					if (UMLVisualIDRegistry.getVisualID(incomingLink) == ControlFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(incomingLink) == ObjectFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(incomingLink) == ExceptionHandlerEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
				}
				for (Iterator it = node.getSourceEdges().iterator(); it.hasNext();) {
					Edge outgoingLink = (Edge) it.next();
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ControlFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ObjectFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ActionLocalPreconditionEditPart.VISUAL_ID) {
						DestroyReferenceRequest r = new DestroyReferenceRequest(outgoingLink.getSource().getElement(), null, outgoingLink.getTarget().getElement(), false);
						cmd.add(new DestroyReferenceCommand(r) {

							protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
								EObject referencedObject = getReferencedObject();
								Resource resource = referencedObject.eResource();
								CommandResult result = super.doExecuteWithResult(progressMonitor, info);
								resource.getContents().add(referencedObject);
								return result;
							}
						});
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ActionLocalPostconditionEditPart.VISUAL_ID) {
						DestroyReferenceRequest r = new DestroyReferenceRequest(outgoingLink.getSource().getElement(), null, outgoingLink.getTarget().getElement(), false);
						cmd.add(new DestroyReferenceCommand(r) {

							protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
								EObject referencedObject = getReferencedObject();
								Resource resource = referencedObject.eResource();
								CommandResult result = super.doExecuteWithResult(progressMonitor, info);
								resource.getContents().add(referencedObject);
								return result;
							}
						});
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ExceptionHandlerEditPart.VISUAL_ID) {
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
			case ActivityFinalNodeEditPart.VISUAL_ID:
				for (Iterator it = node.getTargetEdges().iterator(); it.hasNext();) {
					Edge incomingLink = (Edge) it.next();
					if (UMLVisualIDRegistry.getVisualID(incomingLink) == ControlFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(incomingLink) == ObjectFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
				}
				for (Iterator it = node.getSourceEdges().iterator(); it.hasNext();) {
					Edge outgoingLink = (Edge) it.next();
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ControlFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ObjectFlowEditPart.VISUAL_ID) {
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
			case DecisionNodeEditPart.VISUAL_ID:
				for (Iterator it = node.getTargetEdges().iterator(); it.hasNext();) {
					Edge incomingLink = (Edge) it.next();
					if (UMLVisualIDRegistry.getVisualID(incomingLink) == ControlFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(incomingLink) == ObjectFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
				}
				for (Iterator it = node.getSourceEdges().iterator(); it.hasNext();) {
					Edge outgoingLink = (Edge) it.next();
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ControlFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ObjectFlowEditPart.VISUAL_ID) {
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
			case MergeNodeEditPart.VISUAL_ID:
				for (Iterator it = node.getTargetEdges().iterator(); it.hasNext();) {
					Edge incomingLink = (Edge) it.next();
					if (UMLVisualIDRegistry.getVisualID(incomingLink) == ControlFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(incomingLink) == ObjectFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
				}
				for (Iterator it = node.getSourceEdges().iterator(); it.hasNext();) {
					Edge outgoingLink = (Edge) it.next();
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ControlFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ObjectFlowEditPart.VISUAL_ID) {
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
			case InitialNodeEditPart.VISUAL_ID:
				for (Iterator it = node.getTargetEdges().iterator(); it.hasNext();) {
					Edge incomingLink = (Edge) it.next();
					if (UMLVisualIDRegistry.getVisualID(incomingLink) == ControlFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(incomingLink) == ObjectFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
				}
				for (Iterator it = node.getSourceEdges().iterator(); it.hasNext();) {
					Edge outgoingLink = (Edge) it.next();
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ControlFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ObjectFlowEditPart.VISUAL_ID) {
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
			case DataStoreNodeEditPart.VISUAL_ID:
				for (Iterator it = node.getTargetEdges().iterator(); it.hasNext();) {
					Edge incomingLink = (Edge) it.next();
					if (UMLVisualIDRegistry.getVisualID(incomingLink) == ControlFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(incomingLink) == ObjectFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
				}
				for (Iterator it = node.getSourceEdges().iterator(); it.hasNext();) {
					Edge outgoingLink = (Edge) it.next();
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ControlFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ObjectFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ObjectNodeSelectionEditPart.VISUAL_ID) {
						DestroyReferenceRequest r = new DestroyReferenceRequest(outgoingLink.getSource().getElement(), null, outgoingLink.getTarget().getElement(), false);
						cmd.add(new DestroyReferenceCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
				}
				cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), node.getElement(), false))); // directlyOwned: true
				// don't need explicit deletion of node as parent's view deletion would clean child views as well 
				// cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), node));
				break;
			case CentralBufferNodeEditPart.VISUAL_ID:
				for (Iterator it = node.getTargetEdges().iterator(); it.hasNext();) {
					Edge incomingLink = (Edge) it.next();
					if (UMLVisualIDRegistry.getVisualID(incomingLink) == ControlFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(incomingLink) == ObjectFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
				}
				for (Iterator it = node.getSourceEdges().iterator(); it.hasNext();) {
					Edge outgoingLink = (Edge) it.next();
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ControlFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ObjectFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ObjectNodeSelectionEditPart.VISUAL_ID) {
						DestroyReferenceRequest r = new DestroyReferenceRequest(outgoingLink.getSource().getElement(), null, outgoingLink.getTarget().getElement(), false);
						cmd.add(new DestroyReferenceCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
				}
				cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), node.getElement(), false))); // directlyOwned: true
				// don't need explicit deletion of node as parent's view deletion would clean child views as well 
				// cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), node));
				break;
			case OpaqueActionEditPart.VISUAL_ID:
				for (Iterator it = node.getTargetEdges().iterator(); it.hasNext();) {
					Edge incomingLink = (Edge) it.next();
					if (UMLVisualIDRegistry.getVisualID(incomingLink) == ControlFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(incomingLink) == ObjectFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(incomingLink) == ExceptionHandlerEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
				}
				for (Iterator it = node.getSourceEdges().iterator(); it.hasNext();) {
					Edge outgoingLink = (Edge) it.next();
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ControlFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ObjectFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ActionLocalPreconditionEditPart.VISUAL_ID) {
						DestroyReferenceRequest r = new DestroyReferenceRequest(outgoingLink.getSource().getElement(), null, outgoingLink.getTarget().getElement(), false);
						cmd.add(new DestroyReferenceCommand(r) {

							protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
								EObject referencedObject = getReferencedObject();
								Resource resource = referencedObject.eResource();
								CommandResult result = super.doExecuteWithResult(progressMonitor, info);
								resource.getContents().add(referencedObject);
								return result;
							}
						});
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ActionLocalPostconditionEditPart.VISUAL_ID) {
						DestroyReferenceRequest r = new DestroyReferenceRequest(outgoingLink.getSource().getElement(), null, outgoingLink.getTarget().getElement(), false);
						cmd.add(new DestroyReferenceCommand(r) {

							protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
								EObject referencedObject = getReferencedObject();
								Resource resource = referencedObject.eResource();
								CommandResult result = super.doExecuteWithResult(progressMonitor, info);
								resource.getContents().add(referencedObject);
								return result;
							}
						});
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ExceptionHandlerEditPart.VISUAL_ID) {
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
			case FlowFinalNodeEditPart.VISUAL_ID:
				for (Iterator it = node.getTargetEdges().iterator(); it.hasNext();) {
					Edge incomingLink = (Edge) it.next();
					if (UMLVisualIDRegistry.getVisualID(incomingLink) == ControlFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(incomingLink) == ObjectFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
				}
				for (Iterator it = node.getSourceEdges().iterator(); it.hasNext();) {
					Edge outgoingLink = (Edge) it.next();
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ControlFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ObjectFlowEditPart.VISUAL_ID) {
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
			case ForkNodeEditPart.VISUAL_ID:
				for (Iterator it = node.getTargetEdges().iterator(); it.hasNext();) {
					Edge incomingLink = (Edge) it.next();
					if (UMLVisualIDRegistry.getVisualID(incomingLink) == ControlFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(incomingLink) == ObjectFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
				}
				for (Iterator it = node.getSourceEdges().iterator(); it.hasNext();) {
					Edge outgoingLink = (Edge) it.next();
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ControlFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ObjectFlowEditPart.VISUAL_ID) {
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
			case JoinNodeEditPart.VISUAL_ID:
				for (Iterator it = node.getTargetEdges().iterator(); it.hasNext();) {
					Edge incomingLink = (Edge) it.next();
					if (UMLVisualIDRegistry.getVisualID(incomingLink) == ControlFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(incomingLink) == ObjectFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
				}
				for (Iterator it = node.getSourceEdges().iterator(); it.hasNext();) {
					Edge outgoingLink = (Edge) it.next();
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ControlFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ObjectFlowEditPart.VISUAL_ID) {
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
			case PinEditPart.VISUAL_ID:
				for (Iterator it = node.getTargetEdges().iterator(); it.hasNext();) {
					Edge incomingLink = (Edge) it.next();
					if (UMLVisualIDRegistry.getVisualID(incomingLink) == ControlFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(incomingLink) == ObjectFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
				}
				for (Iterator it = node.getSourceEdges().iterator(); it.hasNext();) {
					Edge outgoingLink = (Edge) it.next();
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ControlFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ObjectFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ObjectNodeSelectionEditPart.VISUAL_ID) {
						DestroyReferenceRequest r = new DestroyReferenceRequest(outgoingLink.getSource().getElement(), null, outgoingLink.getTarget().getElement(), false);
						cmd.add(new DestroyReferenceCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
				}
				cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), node.getElement(), false))); // directlyOwned: true
				// don't need explicit deletion of node as parent's view deletion would clean child views as well 
				// cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), node));
				break;
			case CreateObjectActionEditPart.VISUAL_ID:
				for (Iterator it = node.getTargetEdges().iterator(); it.hasNext();) {
					Edge incomingLink = (Edge) it.next();
					if (UMLVisualIDRegistry.getVisualID(incomingLink) == ControlFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(incomingLink) == ObjectFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(incomingLink) == ExceptionHandlerEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
				}
				for (Iterator it = node.getSourceEdges().iterator(); it.hasNext();) {
					Edge outgoingLink = (Edge) it.next();
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ControlFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ObjectFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ActionLocalPreconditionEditPart.VISUAL_ID) {
						DestroyReferenceRequest r = new DestroyReferenceRequest(outgoingLink.getSource().getElement(), null, outgoingLink.getTarget().getElement(), false);
						cmd.add(new DestroyReferenceCommand(r) {

							protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
								EObject referencedObject = getReferencedObject();
								Resource resource = referencedObject.eResource();
								CommandResult result = super.doExecuteWithResult(progressMonitor, info);
								resource.getContents().add(referencedObject);
								return result;
							}
						});
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ActionLocalPostconditionEditPart.VISUAL_ID) {
						DestroyReferenceRequest r = new DestroyReferenceRequest(outgoingLink.getSource().getElement(), null, outgoingLink.getTarget().getElement(), false);
						cmd.add(new DestroyReferenceCommand(r) {

							protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
								EObject referencedObject = getReferencedObject();
								Resource resource = referencedObject.eResource();
								CommandResult result = super.doExecuteWithResult(progressMonitor, info);
								resource.getContents().add(referencedObject);
								return result;
							}
						});
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ExceptionHandlerEditPart.VISUAL_ID) {
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
			case AddStructuralFeatureValueActionEditPart.VISUAL_ID:
				for (Iterator it = node.getTargetEdges().iterator(); it.hasNext();) {
					Edge incomingLink = (Edge) it.next();
					if (UMLVisualIDRegistry.getVisualID(incomingLink) == ControlFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(incomingLink) == ObjectFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(incomingLink) == ExceptionHandlerEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
				}
				for (Iterator it = node.getSourceEdges().iterator(); it.hasNext();) {
					Edge outgoingLink = (Edge) it.next();
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ControlFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ObjectFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ActionLocalPreconditionEditPart.VISUAL_ID) {
						DestroyReferenceRequest r = new DestroyReferenceRequest(outgoingLink.getSource().getElement(), null, outgoingLink.getTarget().getElement(), false);
						cmd.add(new DestroyReferenceCommand(r) {

							protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
								EObject referencedObject = getReferencedObject();
								Resource resource = referencedObject.eResource();
								CommandResult result = super.doExecuteWithResult(progressMonitor, info);
								resource.getContents().add(referencedObject);
								return result;
							}
						});
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ActionLocalPostconditionEditPart.VISUAL_ID) {
						DestroyReferenceRequest r = new DestroyReferenceRequest(outgoingLink.getSource().getElement(), null, outgoingLink.getTarget().getElement(), false);
						cmd.add(new DestroyReferenceCommand(r) {

							protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
								EObject referencedObject = getReferencedObject();
								Resource resource = referencedObject.eResource();
								CommandResult result = super.doExecuteWithResult(progressMonitor, info);
								resource.getContents().add(referencedObject);
								return result;
							}
						});
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ExceptionHandlerEditPart.VISUAL_ID) {
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
			case CallBehaviorActionEditPart.VISUAL_ID:
				for (Iterator it = node.getTargetEdges().iterator(); it.hasNext();) {
					Edge incomingLink = (Edge) it.next();
					if (UMLVisualIDRegistry.getVisualID(incomingLink) == ControlFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(incomingLink) == ObjectFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(incomingLink) == ExceptionHandlerEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
				}
				for (Iterator it = node.getSourceEdges().iterator(); it.hasNext();) {
					Edge outgoingLink = (Edge) it.next();
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ControlFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ObjectFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ActionLocalPreconditionEditPart.VISUAL_ID) {
						DestroyReferenceRequest r = new DestroyReferenceRequest(outgoingLink.getSource().getElement(), null, outgoingLink.getTarget().getElement(), false);
						cmd.add(new DestroyReferenceCommand(r) {

							protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
								EObject referencedObject = getReferencedObject();
								Resource resource = referencedObject.eResource();
								CommandResult result = super.doExecuteWithResult(progressMonitor, info);
								resource.getContents().add(referencedObject);
								return result;
							}
						});
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ActionLocalPostconditionEditPart.VISUAL_ID) {
						DestroyReferenceRequest r = new DestroyReferenceRequest(outgoingLink.getSource().getElement(), null, outgoingLink.getTarget().getElement(), false);
						cmd.add(new DestroyReferenceCommand(r) {

							protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
								EObject referencedObject = getReferencedObject();
								Resource resource = referencedObject.eResource();
								CommandResult result = super.doExecuteWithResult(progressMonitor, info);
								resource.getContents().add(referencedObject);
								return result;
							}
						});
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ExceptionHandlerEditPart.VISUAL_ID) {
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
			case CallOperationActionEditPart.VISUAL_ID:
				for (Iterator it = node.getTargetEdges().iterator(); it.hasNext();) {
					Edge incomingLink = (Edge) it.next();
					if (UMLVisualIDRegistry.getVisualID(incomingLink) == ControlFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(incomingLink) == ObjectFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(incomingLink) == ExceptionHandlerEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
				}
				for (Iterator it = node.getSourceEdges().iterator(); it.hasNext();) {
					Edge outgoingLink = (Edge) it.next();
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ControlFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ObjectFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ActionLocalPreconditionEditPart.VISUAL_ID) {
						DestroyReferenceRequest r = new DestroyReferenceRequest(outgoingLink.getSource().getElement(), null, outgoingLink.getTarget().getElement(), false);
						cmd.add(new DestroyReferenceCommand(r) {

							protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
								EObject referencedObject = getReferencedObject();
								Resource resource = referencedObject.eResource();
								CommandResult result = super.doExecuteWithResult(progressMonitor, info);
								resource.getContents().add(referencedObject);
								return result;
							}
						});
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ActionLocalPostconditionEditPart.VISUAL_ID) {
						DestroyReferenceRequest r = new DestroyReferenceRequest(outgoingLink.getSource().getElement(), null, outgoingLink.getTarget().getElement(), false);
						cmd.add(new DestroyReferenceCommand(r) {

							protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
								EObject referencedObject = getReferencedObject();
								Resource resource = referencedObject.eResource();
								CommandResult result = super.doExecuteWithResult(progressMonitor, info);
								resource.getContents().add(referencedObject);
								return result;
							}
						});
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ExceptionHandlerEditPart.VISUAL_ID) {
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
			case StructuredActivityNodeEditPart.VISUAL_ID:
				for (Iterator it = node.getTargetEdges().iterator(); it.hasNext();) {
					Edge incomingLink = (Edge) it.next();
					if (UMLVisualIDRegistry.getVisualID(incomingLink) == ControlFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(incomingLink) == ObjectFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(incomingLink) == ExceptionHandlerEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
				}
				for (Iterator it = node.getSourceEdges().iterator(); it.hasNext();) {
					Edge outgoingLink = (Edge) it.next();
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ControlFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ObjectFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ActionLocalPreconditionEditPart.VISUAL_ID) {
						DestroyReferenceRequest r = new DestroyReferenceRequest(outgoingLink.getSource().getElement(), null, outgoingLink.getTarget().getElement(), false);
						cmd.add(new DestroyReferenceCommand(r) {

							protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
								EObject referencedObject = getReferencedObject();
								Resource resource = referencedObject.eResource();
								CommandResult result = super.doExecuteWithResult(progressMonitor, info);
								resource.getContents().add(referencedObject);
								return result;
							}
						});
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ActionLocalPostconditionEditPart.VISUAL_ID) {
						DestroyReferenceRequest r = new DestroyReferenceRequest(outgoingLink.getSource().getElement(), null, outgoingLink.getTarget().getElement(), false);
						cmd.add(new DestroyReferenceCommand(r) {

							protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
								EObject referencedObject = getReferencedObject();
								Resource resource = referencedObject.eResource();
								CommandResult result = super.doExecuteWithResult(progressMonitor, info);
								resource.getContents().add(referencedObject);
								return result;
							}
						});
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ExceptionHandlerEditPart.VISUAL_ID) {
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
			case OpaqueBehaviorEditPart.VISUAL_ID:
				for (Iterator it = node.getTargetEdges().iterator(); it.hasNext();) {
					Edge incomingLink = (Edge) it.next();
					if (UMLVisualIDRegistry.getVisualID(incomingLink) == ObjectNodeSelectionEditPart.VISUAL_ID) {
						DestroyReferenceRequest r = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null, incomingLink.getTarget().getElement(), false);
						cmd.add(new DestroyReferenceCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
				}
				cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), node.getElement(), false))); // directlyOwned: true
				// don't need explicit deletion of node as parent's view deletion would clean child views as well 
				// cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), node));
				break;
			case ActivityParameterNodeEditPart.VISUAL_ID:
				for (Iterator it = node.getTargetEdges().iterator(); it.hasNext();) {
					Edge incomingLink = (Edge) it.next();
					if (UMLVisualIDRegistry.getVisualID(incomingLink) == ControlFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(incomingLink) == ObjectFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
				}
				for (Iterator it = node.getSourceEdges().iterator(); it.hasNext();) {
					Edge outgoingLink = (Edge) it.next();
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ControlFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ObjectFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ObjectNodeSelectionEditPart.VISUAL_ID) {
						DestroyReferenceRequest r = new DestroyReferenceRequest(outgoingLink.getSource().getElement(), null, outgoingLink.getTarget().getElement(), false);
						cmd.add(new DestroyReferenceCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
				}
				cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), node.getElement(), false))); // directlyOwned: true
				// don't need explicit deletion of node as parent's view deletion would clean child views as well 
				// cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), node));
				break;
			case SendSignalActionEditPart.VISUAL_ID:
				for (Iterator it = node.getTargetEdges().iterator(); it.hasNext();) {
					Edge incomingLink = (Edge) it.next();
					if (UMLVisualIDRegistry.getVisualID(incomingLink) == ControlFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(incomingLink) == ObjectFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(incomingLink) == ExceptionHandlerEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
				}
				for (Iterator it = node.getSourceEdges().iterator(); it.hasNext();) {
					Edge outgoingLink = (Edge) it.next();
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ControlFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ObjectFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ActionLocalPreconditionEditPart.VISUAL_ID) {
						DestroyReferenceRequest r = new DestroyReferenceRequest(outgoingLink.getSource().getElement(), null, outgoingLink.getTarget().getElement(), false);
						cmd.add(new DestroyReferenceCommand(r) {

							protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
								EObject referencedObject = getReferencedObject();
								Resource resource = referencedObject.eResource();
								CommandResult result = super.doExecuteWithResult(progressMonitor, info);
								resource.getContents().add(referencedObject);
								return result;
							}
						});
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ActionLocalPostconditionEditPart.VISUAL_ID) {
						DestroyReferenceRequest r = new DestroyReferenceRequest(outgoingLink.getSource().getElement(), null, outgoingLink.getTarget().getElement(), false);
						cmd.add(new DestroyReferenceCommand(r) {

							protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
								EObject referencedObject = getReferencedObject();
								Resource resource = referencedObject.eResource();
								CommandResult result = super.doExecuteWithResult(progressMonitor, info);
								resource.getContents().add(referencedObject);
								return result;
							}
						});
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ExceptionHandlerEditPart.VISUAL_ID) {
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
			case ActivityPartitionEditPart.VISUAL_ID:
				cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), node.getElement(), false))); // directlyOwned: true
				// don't need explicit deletion of node as parent's view deletion would clean child views as well 
				// cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), node));
				break;
			case LoopNodeEditPart.VISUAL_ID:
				for (Iterator it = node.getTargetEdges().iterator(); it.hasNext();) {
					Edge incomingLink = (Edge) it.next();
					if (UMLVisualIDRegistry.getVisualID(incomingLink) == ControlFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(incomingLink) == ObjectFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(incomingLink) == ExceptionHandlerEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
				}
				for (Iterator it = node.getSourceEdges().iterator(); it.hasNext();) {
					Edge outgoingLink = (Edge) it.next();
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ControlFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ObjectFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ActionLocalPreconditionEditPart.VISUAL_ID) {
						DestroyReferenceRequest r = new DestroyReferenceRequest(outgoingLink.getSource().getElement(), null, outgoingLink.getTarget().getElement(), false);
						cmd.add(new DestroyReferenceCommand(r) {

							protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
								EObject referencedObject = getReferencedObject();
								Resource resource = referencedObject.eResource();
								CommandResult result = super.doExecuteWithResult(progressMonitor, info);
								resource.getContents().add(referencedObject);
								return result;
							}
						});
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ActionLocalPostconditionEditPart.VISUAL_ID) {
						DestroyReferenceRequest r = new DestroyReferenceRequest(outgoingLink.getSource().getElement(), null, outgoingLink.getTarget().getElement(), false);
						cmd.add(new DestroyReferenceCommand(r) {

							protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
								EObject referencedObject = getReferencedObject();
								Resource resource = referencedObject.eResource();
								CommandResult result = super.doExecuteWithResult(progressMonitor, info);
								resource.getContents().add(referencedObject);
								return result;
							}
						});
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ExceptionHandlerEditPart.VISUAL_ID) {
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
			case ConditionalNodeEditPart.VISUAL_ID:
				for (Iterator it = node.getTargetEdges().iterator(); it.hasNext();) {
					Edge incomingLink = (Edge) it.next();
					if (UMLVisualIDRegistry.getVisualID(incomingLink) == ControlFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(incomingLink) == ObjectFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(incomingLink) == ExceptionHandlerEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
				}
				for (Iterator it = node.getSourceEdges().iterator(); it.hasNext();) {
					Edge outgoingLink = (Edge) it.next();
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ControlFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ObjectFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ActionLocalPreconditionEditPart.VISUAL_ID) {
						DestroyReferenceRequest r = new DestroyReferenceRequest(outgoingLink.getSource().getElement(), null, outgoingLink.getTarget().getElement(), false);
						cmd.add(new DestroyReferenceCommand(r) {

							protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
								EObject referencedObject = getReferencedObject();
								Resource resource = referencedObject.eResource();
								CommandResult result = super.doExecuteWithResult(progressMonitor, info);
								resource.getContents().add(referencedObject);
								return result;
							}
						});
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ActionLocalPostconditionEditPart.VISUAL_ID) {
						DestroyReferenceRequest r = new DestroyReferenceRequest(outgoingLink.getSource().getElement(), null, outgoingLink.getTarget().getElement(), false);
						cmd.add(new DestroyReferenceCommand(r) {

							protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
								EObject referencedObject = getReferencedObject();
								Resource resource = referencedObject.eResource();
								CommandResult result = super.doExecuteWithResult(progressMonitor, info);
								resource.getContents().add(referencedObject);
								return result;
							}
						});
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ExceptionHandlerEditPart.VISUAL_ID) {
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
			case ExpansionRegionEditPart.VISUAL_ID:
				for (Iterator it = node.getTargetEdges().iterator(); it.hasNext();) {
					Edge incomingLink = (Edge) it.next();
					if (UMLVisualIDRegistry.getVisualID(incomingLink) == ControlFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(incomingLink) == ObjectFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(incomingLink) == ExceptionHandlerEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
				}
				for (Iterator it = node.getSourceEdges().iterator(); it.hasNext();) {
					Edge outgoingLink = (Edge) it.next();
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ControlFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ObjectFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ActionLocalPreconditionEditPart.VISUAL_ID) {
						DestroyReferenceRequest r = new DestroyReferenceRequest(outgoingLink.getSource().getElement(), null, outgoingLink.getTarget().getElement(), false);
						cmd.add(new DestroyReferenceCommand(r) {

							protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
								EObject referencedObject = getReferencedObject();
								Resource resource = referencedObject.eResource();
								CommandResult result = super.doExecuteWithResult(progressMonitor, info);
								resource.getContents().add(referencedObject);
								return result;
							}
						});
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ActionLocalPostconditionEditPart.VISUAL_ID) {
						DestroyReferenceRequest r = new DestroyReferenceRequest(outgoingLink.getSource().getElement(), null, outgoingLink.getTarget().getElement(), false);
						cmd.add(new DestroyReferenceCommand(r) {

							protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
								EObject referencedObject = getReferencedObject();
								Resource resource = referencedObject.eResource();
								CommandResult result = super.doExecuteWithResult(progressMonitor, info);
								resource.getContents().add(referencedObject);
								return result;
							}
						});
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ExceptionHandlerEditPart.VISUAL_ID) {
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
			case ParameterSetEditPart.VISUAL_ID:
				cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), node.getElement(), false))); // directlyOwned: true
				// don't need explicit deletion of node as parent's view deletion would clean child views as well 
				// cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), node));
				break;
			case ValueSpecificationActionEditPart.VISUAL_ID:
				for (Iterator it = node.getTargetEdges().iterator(); it.hasNext();) {
					Edge incomingLink = (Edge) it.next();
					if (UMLVisualIDRegistry.getVisualID(incomingLink) == ControlFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(incomingLink) == ObjectFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(incomingLink) == ExceptionHandlerEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
				}
				for (Iterator it = node.getSourceEdges().iterator(); it.hasNext();) {
					Edge outgoingLink = (Edge) it.next();
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ControlFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ObjectFlowEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ActionLocalPreconditionEditPart.VISUAL_ID) {
						DestroyReferenceRequest r = new DestroyReferenceRequest(outgoingLink.getSource().getElement(), null, outgoingLink.getTarget().getElement(), false);
						cmd.add(new DestroyReferenceCommand(r) {

							protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
								EObject referencedObject = getReferencedObject();
								Resource resource = referencedObject.eResource();
								CommandResult result = super.doExecuteWithResult(progressMonitor, info);
								resource.getContents().add(referencedObject);
								return result;
							}
						});
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ActionLocalPostconditionEditPart.VISUAL_ID) {
						DestroyReferenceRequest r = new DestroyReferenceRequest(outgoingLink.getSource().getElement(), null, outgoingLink.getTarget().getElement(), false);
						cmd.add(new DestroyReferenceCommand(r) {

							protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
								EObject referencedObject = getReferencedObject();
								Resource resource = referencedObject.eResource();
								CommandResult result = super.doExecuteWithResult(progressMonitor, info);
								resource.getContents().add(referencedObject);
								return result;
							}
						});
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == ExceptionHandlerEditPart.VISUAL_ID) {
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
		if (UMLElementTypes.ObjectNodeSelection_4004 == req.getElementType()) {
			return null;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (UMLElementTypes.ObjectNodeSelection_4004 == req.getElementType()) {
			return getGEFWrapper(new ObjectNodeSelectionCreateCommand(req, req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * Returns command to reorient EReference based link. New link target or source
	 * should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest req) {
		switch (getVisualID(req)) {
		case ObjectNodeSelectionEditPart.VISUAL_ID:
			return getGEFWrapper(new ObjectNodeSelectionReorientCommand(req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
