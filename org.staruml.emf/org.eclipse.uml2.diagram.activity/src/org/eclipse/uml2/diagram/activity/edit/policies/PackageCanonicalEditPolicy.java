package org.eclipse.uml2.diagram.activity.edit.policies;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.DeferredLayoutCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalConnectionEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.Ratio;
import org.eclipse.gmf.runtime.notation.Size;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.activity.edit.parts.AcceptEventActionEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.AcceptTimeEventActionEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ActivityEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ActivityFinalNodeEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ActivityParameterNodeEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ActivityPartitionEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ActivityPartition_AcceptEventActionEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ActivityPartition_AcceptTimeEventActionEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ActivityPartition_ActivityFinalNodeEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ActivityPartition_ActivityPartitionEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ActivityPartition_AddStructuralFeatureValueActionEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ActivityPartition_CallBehaviorActionEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ActivityPartition_CallOperationActionEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ActivityPartition_CentralBufferNodeEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ActivityPartition_ConditionalNodeEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ActivityPartition_CreateObjectActionEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ActivityPartition_DataStoreNodeEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ActivityPartition_DecisionNodeEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ActivityPartition_ExpansionRegionEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ActivityPartition_FlowFinalNodeEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ActivityPartition_ForkNodeEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ActivityPartition_InitialNodeEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ActivityPartition_JoinNodeEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ActivityPartition_LoopNodeEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ActivityPartition_MergeNodeEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ActivityPartition_OpaqueActionEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ActivityPartition_PinEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ActivityPartition_SendSignalActionEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ActivityPartition_StructuredActivityNodeEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ActivityPartition_StructuredActivityNode_StructuredActivityNodeEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ActivityPartition_ValueSpecificationActionEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.AddStructuralFeatureValueActionEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.AddStructuralFeatureValueAction_insertAt_InputPinEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.AddStructuralFeatureValueAction_object_InputPinEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.AddStructuralFeatureValueAction_value_InputPinEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.CallAction_InputPinEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.CallAction_OutputPinEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.CallBehaviorActionEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.CallOperationActionEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.CallOperationAction_InputPinEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.CentralBufferNodeEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ConditionalNodeEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ControlFlowEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.CreateObjectActionEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.CreateObjectAction_OutputPinEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.DataStoreNodeEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.DecisionNodeEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ExceptionHandlerEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ExpansionNodeEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ExpansionRegionEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.FlowFinalNodeEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ForkNodeEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.InitialNodeEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.JoinNodeEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.LocalPostconditionEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.LocalPostcondition_LiteralStringEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.LocalPreconditionEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.LocalPrecondition_LiteralStringEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.LoopNodeEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.MergeNodeEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ObjectFlowEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.OpaqueActionEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.OpaqueAction_InputPinEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.OpaqueAction_OutputPinEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.OpaqueBehaviorEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.PackageEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ParameterEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ParameterSetEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.PinEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.SendSignalActionEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.StructuredActivityNodeEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.StructuredActivityNode_AcceptEventActionEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.StructuredActivityNode_AcceptTimeEventActionEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.StructuredActivityNode_ActivityFinalNodeEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.StructuredActivityNode_AddStructuralFeatureValueActionEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.StructuredActivityNode_CallBehaviorActionEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.StructuredActivityNode_CallOperationActionEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.StructuredActivityNode_CentralBufferNodeEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.StructuredActivityNode_ConditionalNodeEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.StructuredActivityNode_CreateObjectActionEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.StructuredActivityNode_DataStoreNodeEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.StructuredActivityNode_DecisionNodeEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.StructuredActivityNode_FlowFinalNodeEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.StructuredActivityNode_ForkNodeEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.StructuredActivityNode_InitialNodeEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.StructuredActivityNode_InputPinEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.StructuredActivityNode_JoinNodeEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.StructuredActivityNode_OpaqueActionEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.StructuredActivityNode_OutputPinEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.StructuredActivityNode_PinEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.StructuredActivityNode_StructuredActivityNodeEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.StructuredActivityNode_StructuredActivityNode_InputPinEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.StructuredActivityNode_StructuredActivityNode_OutputPinEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ValueSpecificationActionEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ValueSpecificationAction_OutputPinEditPart;
import org.eclipse.uml2.diagram.activity.part.UMLDiagramUpdater;
import org.eclipse.uml2.diagram.activity.part.UMLVisualIDRegistry;
import org.eclipse.uml2.diagram.common.editpolicies.UpdateDescriptionRequest;
import org.eclipse.uml2.diagram.common.genapi.IUpdaterLinkDescriptor;
import org.eclipse.uml2.diagram.common.genapi.IUpdaterNodeDescriptor;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */

public class PackageCanonicalEditPolicy extends CanonicalConnectionEditPolicy {

	/**
	 * @generated
	 */
	Set myFeaturesToSynchronize;

	/**
	 * @generated
	 */
	protected List getSemanticChildrenList() {
		View viewObject = (View) getHost().getModel();
		List result = new LinkedList();
		for (Iterator it = UMLDiagramUpdater.getPackage_1000SemanticChildren(viewObject).iterator(); it.hasNext();) {
			result.add(((IUpdaterNodeDescriptor) it.next()).getModelElement());
		}
		return result;
	}

	/**
	 * @generated
	 */
	protected boolean shouldDeleteView(View view) {
		return true;
	}

	/**
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	protected boolean isOrphaned(Collection semanticChildren, final View view) {
		int visualID = UMLVisualIDRegistry.getVisualID(view);
		int suggestedID = UMLVisualIDRegistry.getNodeVisualID((View) getHost().getModel(), view.getElement());
		switch (visualID) {
		case AcceptEventActionEditPart.VISUAL_ID:
		case AcceptTimeEventActionEditPart.VISUAL_ID:
		case ActivityFinalNodeEditPart.VISUAL_ID:
		case DecisionNodeEditPart.VISUAL_ID:
		case MergeNodeEditPart.VISUAL_ID:
		case InitialNodeEditPart.VISUAL_ID:
		case DataStoreNodeEditPart.VISUAL_ID:
		case CentralBufferNodeEditPart.VISUAL_ID:
		case OpaqueActionEditPart.VISUAL_ID:
		case OpaqueAction_OutputPinEditPart.VISUAL_ID:
		case OpaqueAction_InputPinEditPart.VISUAL_ID:
		case FlowFinalNodeEditPart.VISUAL_ID:
		case ForkNodeEditPart.VISUAL_ID:
		case JoinNodeEditPart.VISUAL_ID:
		case PinEditPart.VISUAL_ID:
		case CreateObjectActionEditPart.VISUAL_ID:
		case CreateObjectAction_OutputPinEditPart.VISUAL_ID:
		case AddStructuralFeatureValueActionEditPart.VISUAL_ID:
		case AddStructuralFeatureValueAction_insertAt_InputPinEditPart.VISUAL_ID:
		case AddStructuralFeatureValueAction_value_InputPinEditPart.VISUAL_ID:
		case AddStructuralFeatureValueAction_object_InputPinEditPart.VISUAL_ID:
		case CallBehaviorActionEditPart.VISUAL_ID:
		case CallAction_OutputPinEditPart.VISUAL_ID:
		case CallAction_InputPinEditPart.VISUAL_ID:
		case CallOperationActionEditPart.VISUAL_ID:
		case CallOperationAction_InputPinEditPart.VISUAL_ID:
		case StructuredActivityNodeEditPart.VISUAL_ID:
		case StructuredActivityNode_StructuredActivityNodeEditPart.VISUAL_ID:
		case StructuredActivityNode_OpaqueActionEditPart.VISUAL_ID:
		case StructuredActivityNode_AcceptEventActionEditPart.VISUAL_ID:
		case StructuredActivityNode_AcceptTimeEventActionEditPart.VISUAL_ID:
		case StructuredActivityNode_ActivityFinalNodeEditPart.VISUAL_ID:
		case StructuredActivityNode_DecisionNodeEditPart.VISUAL_ID:
		case StructuredActivityNode_FlowFinalNodeEditPart.VISUAL_ID:
		case StructuredActivityNode_PinEditPart.VISUAL_ID:
		case StructuredActivityNode_CreateObjectActionEditPart.VISUAL_ID:
		case StructuredActivityNode_CallBehaviorActionEditPart.VISUAL_ID:
		case StructuredActivityNode_CallOperationActionEditPart.VISUAL_ID:
		case StructuredActivityNode_ForkNodeEditPart.VISUAL_ID:
		case StructuredActivityNode_JoinNodeEditPart.VISUAL_ID:
		case StructuredActivityNode_AddStructuralFeatureValueActionEditPart.VISUAL_ID:
		case StructuredActivityNode_DataStoreNodeEditPart.VISUAL_ID:
		case StructuredActivityNode_CentralBufferNodeEditPart.VISUAL_ID:
		case StructuredActivityNode_InputPinEditPart.VISUAL_ID:
		case StructuredActivityNode_OutputPinEditPart.VISUAL_ID:
		case StructuredActivityNode_ConditionalNodeEditPart.VISUAL_ID:
		case StructuredActivityNode_InitialNodeEditPart.VISUAL_ID:
		case OpaqueBehaviorEditPart.VISUAL_ID:
		case ActivityParameterNodeEditPart.VISUAL_ID:
		case SendSignalActionEditPart.VISUAL_ID:
		case ActivityPartitionEditPart.VISUAL_ID:
		case ActivityPartition_ActivityPartitionEditPart.VISUAL_ID:
		case ActivityPartition_AcceptEventActionEditPart.VISUAL_ID:
		case ActivityPartition_AcceptTimeEventActionEditPart.VISUAL_ID:
		case ActivityPartition_ActivityFinalNodeEditPart.VISUAL_ID:
		case ActivityPartition_DecisionNodeEditPart.VISUAL_ID:
		case ActivityPartition_MergeNodeEditPart.VISUAL_ID:
		case ActivityPartition_InitialNodeEditPart.VISUAL_ID:
		case ActivityPartition_DataStoreNodeEditPart.VISUAL_ID:
		case ActivityPartition_CentralBufferNodeEditPart.VISUAL_ID:
		case ActivityPartition_OpaqueActionEditPart.VISUAL_ID:
		case ActivityPartition_FlowFinalNodeEditPart.VISUAL_ID:
		case ActivityPartition_ForkNodeEditPart.VISUAL_ID:
		case ActivityPartition_JoinNodeEditPart.VISUAL_ID:
		case ActivityPartition_PinEditPart.VISUAL_ID:
		case ActivityPartition_CreateObjectActionEditPart.VISUAL_ID:
		case ActivityPartition_AddStructuralFeatureValueActionEditPart.VISUAL_ID:
		case ActivityPartition_CallBehaviorActionEditPart.VISUAL_ID:
		case ActivityPartition_CallOperationActionEditPart.VISUAL_ID:
		case ActivityPartition_StructuredActivityNodeEditPart.VISUAL_ID:
		case ActivityPartition_StructuredActivityNode_StructuredActivityNodeEditPart.VISUAL_ID:
		case StructuredActivityNode_StructuredActivityNode_InputPinEditPart.VISUAL_ID:
		case StructuredActivityNode_StructuredActivityNode_OutputPinEditPart.VISUAL_ID:
		case ActivityPartition_SendSignalActionEditPart.VISUAL_ID:
		case ActivityPartition_LoopNodeEditPart.VISUAL_ID:
		case ActivityPartition_ConditionalNodeEditPart.VISUAL_ID:
		case ActivityPartition_ExpansionRegionEditPart.VISUAL_ID:
		case ActivityPartition_ValueSpecificationActionEditPart.VISUAL_ID:
		case ValueSpecificationAction_OutputPinEditPart.VISUAL_ID:
		case LoopNodeEditPart.VISUAL_ID:
		case ConditionalNodeEditPart.VISUAL_ID:
		case ExpansionRegionEditPart.VISUAL_ID:
		case ExpansionNodeEditPart.VISUAL_ID:
		case ParameterSetEditPart.VISUAL_ID:
		case ParameterEditPart.VISUAL_ID:
		case ValueSpecificationActionEditPart.VISUAL_ID:
		case LocalPrecondition_LiteralStringEditPart.VISUAL_ID:
		case LocalPostcondition_LiteralStringEditPart.VISUAL_ID:
			return true;
		case ActivityEditPart.VISUAL_ID:
			if (!semanticChildren.contains(view.getElement())) {
				return true;
			}
			break;
		case LocalPreconditionEditPart.VISUAL_ID:
			if (!semanticChildren.contains(view.getElement())) {
				return true;
			}
			return (visualID != suggestedID) && (suggestedID != LocalPostconditionEditPart.VISUAL_ID);
		case LocalPostconditionEditPart.VISUAL_ID:
			if (!semanticChildren.contains(view.getElement())) {
				return true;
			}
			return (visualID != suggestedID) && (suggestedID != LocalPreconditionEditPart.VISUAL_ID);
		}
		return false;
	}

	/**
	 * @generated
	 */
	private void populateViewProperties(View oldView, View newView) {
		if (oldView instanceof Node && newView instanceof Node) {
			Node oldNode = (Node) oldView;
			Node newNode = (Node) newView;
			if (oldNode.getLayoutConstraint() instanceof Location && newNode.getLayoutConstraint() instanceof Location) {
				((Location) newNode.getLayoutConstraint()).setX(((Location) oldNode.getLayoutConstraint()).getX());
				((Location) newNode.getLayoutConstraint()).setY(((Location) oldNode.getLayoutConstraint()).getY());
			}
			if (oldNode.getLayoutConstraint() instanceof Size && newNode.getLayoutConstraint() instanceof Size) {
				((Size) newNode.getLayoutConstraint()).setWidth(((Size) oldNode.getLayoutConstraint()).getWidth());
				((Size) newNode.getLayoutConstraint()).setHeight(((Size) oldNode.getLayoutConstraint()).getHeight());
			}
			if (oldNode.getLayoutConstraint() instanceof Ratio && newNode.getLayoutConstraint() instanceof Ratio) {
				((Ratio) newNode.getLayoutConstraint()).setValue(((Ratio) oldNode.getLayoutConstraint()).getValue());
			}
			newNode.persist();
		}
	}

	/**
	 * @generated
	 */
	protected String getDefaultFactoryHint() {
		return null;
	}

	/**
	 * @generated
	 */
	protected Set getFeaturesToSynchronize() {
		if (myFeaturesToSynchronize == null) {
			myFeaturesToSynchronize = new HashSet();
			myFeaturesToSynchronize.add(UMLPackage.eINSTANCE.getPackage_PackagedElement());
		}
		return myFeaturesToSynchronize;
	}

	/**
	 * @generated
	 */
	protected List getSemanticConnectionsList() {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	protected EObject getSourceElement(EObject relationship) {
		return null;
	}

	/**
	 * @generated
	 */
	protected EObject getTargetElement(EObject relationship) {
		return null;
	}

	/**
	 * @generated
	 */
	protected boolean shouldIncludeConnection(Edge connector, Collection children) {
		return false;
	}

	/**
	 * @generated
	 */
	protected void refreshSemantic() {
		List createdViews = new LinkedList();
		createdViews.addAll(refreshSemanticChildren());
		List createdConnectionViews = new LinkedList();
		createdConnectionViews.addAll(refreshSemanticConnections());
		createdConnectionViews.addAll(refreshConnections());

		if (createdViews.size() > 1) {
			// perform a layout of the container
			DeferredLayoutCommand layoutCmd = new DeferredLayoutCommand(host().getEditingDomain(), createdViews, host());
			executeCommand(new ICommandProxy(layoutCmd));
		}

		createdViews.addAll(createdConnectionViews);
		makeViewsImmutable(createdViews);
	}

	/**
	 * @generated
	 */
	private Diagram getDiagram() {
		return ((View) getHost().getModel()).getDiagram();
	}

	/**
	 * @generated
	 */
	private Collection refreshConnections() {
		Domain2Notation domain2NotationMap = new Domain2Notation();
		Collection linkDescriptors = collectAllLinks(getDiagram(), domain2NotationMap);
		Collection existingLinks = new LinkedList(getDiagram().getEdges());
		for (Iterator linksIterator = existingLinks.iterator(); linksIterator.hasNext();) {
			Edge nextDiagramLink = (Edge) linksIterator.next();
			int diagramLinkVisualID = UMLVisualIDRegistry.getVisualID(nextDiagramLink);
			if (diagramLinkVisualID == -1) {
				if (nextDiagramLink.getSource() != null && nextDiagramLink.getTarget() != null) {
					linksIterator.remove();
				}
				continue;
			}
			//don't remove notation-only links 
			if (isNotationOnlyEdge(nextDiagramLink)) {
				linksIterator.remove();
				continue;
			}
			EObject diagramLinkObject = nextDiagramLink.getElement();
			EObject diagramLinkSrc = nextDiagramLink.getSource().getElement();
			EObject diagramLinkDst = nextDiagramLink.getTarget().getElement();
			boolean existingLinkRemoved = false;
			for (Iterator LinkDescriptorsIterator = linkDescriptors.iterator(); LinkDescriptorsIterator.hasNext();) {
				IUpdaterLinkDescriptor nextLinkDescriptor = (IUpdaterLinkDescriptor) LinkDescriptorsIterator.next();
				if (diagramLinkObject == nextLinkDescriptor.getModelElement() && diagramLinkSrc == nextLinkDescriptor.getSource() && diagramLinkDst == nextLinkDescriptor.getDestination()
						&& diagramLinkVisualID == nextLinkDescriptor.getVisualID()) {
					if (!existingLinkRemoved) {
						linksIterator.remove();
						existingLinkRemoved = true;
					}
					LinkDescriptorsIterator.remove();
				}
			}
		}
		deleteViews(existingLinks.iterator());
		return createConnections(linkDescriptors, domain2NotationMap);
	}

	/**
	 * @generated
	 */
	private Collection collectAllLinks(View view, Domain2Notation domain2NotationMap) {
		if (UMLVisualIDRegistry.isShortcutDescendant(view)) {
			return collectLinksOutgoingFromShortcut(view, domain2NotationMap);
		}
		Collection result = new LinkedList();
		switch (UMLVisualIDRegistry.getVisualID(view)) {
		case PackageEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getPackage_1000ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case ActivityEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getActivity_2026ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case LocalPreconditionEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getConstraint_2027ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case LocalPostconditionEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getConstraint_2028ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case AcceptEventActionEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getAcceptEventAction_3030ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case AcceptTimeEventActionEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getAcceptEventAction_3031ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case ActivityFinalNodeEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getActivityFinalNode_3032ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case DecisionNodeEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getDecisionNode_3033ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case MergeNodeEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getMergeNode_3034ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case InitialNodeEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getInitialNode_3035ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case DataStoreNodeEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getDataStoreNode_3036ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case CentralBufferNodeEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getCentralBufferNode_3037ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case OpaqueActionEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getOpaqueAction_3029ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case OpaqueAction_OutputPinEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getOutputPin_3001ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case OpaqueAction_InputPinEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getInputPin_3094ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case FlowFinalNodeEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getFlowFinalNode_3038ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case ForkNodeEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getForkNode_3039ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case JoinNodeEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getJoinNode_3040ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case PinEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getPin_3041ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case CreateObjectActionEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getCreateObjectAction_3042ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case CreateObjectAction_OutputPinEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getOutputPin_3002ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case AddStructuralFeatureValueActionEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getAddStructuralFeatureValueAction_3043ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case AddStructuralFeatureValueAction_insertAt_InputPinEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getInputPin_3003ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case AddStructuralFeatureValueAction_value_InputPinEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getInputPin_3004ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case AddStructuralFeatureValueAction_object_InputPinEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getInputPin_3005ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case CallBehaviorActionEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getCallBehaviorAction_3044ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case CallAction_OutputPinEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getOutputPin_3006ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case CallAction_InputPinEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getInputPin_3007ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case CallOperationActionEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getCallOperationAction_3045ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case CallOperationAction_InputPinEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getInputPin_3008ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case StructuredActivityNodeEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getStructuredActivityNode_3046ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case StructuredActivityNode_StructuredActivityNodeEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getStructuredActivityNode_3009ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case StructuredActivityNode_OpaqueActionEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getOpaqueAction_3011ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case StructuredActivityNode_AcceptEventActionEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getAcceptEventAction_3012ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case StructuredActivityNode_AcceptTimeEventActionEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getAcceptEventAction_3013ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case StructuredActivityNode_ActivityFinalNodeEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getActivityFinalNode_3014ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case StructuredActivityNode_DecisionNodeEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getDecisionNode_3015ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case StructuredActivityNode_FlowFinalNodeEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getFlowFinalNode_3016ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case StructuredActivityNode_PinEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getPin_3017ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case StructuredActivityNode_CreateObjectActionEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getCreateObjectAction_3018ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case StructuredActivityNode_CallBehaviorActionEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getCallBehaviorAction_3019ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case StructuredActivityNode_CallOperationActionEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getCallOperationAction_3020ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case StructuredActivityNode_ForkNodeEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getForkNode_3021ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case StructuredActivityNode_JoinNodeEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getJoinNode_3022ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case StructuredActivityNode_AddStructuralFeatureValueActionEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getAddStructuralFeatureValueAction_3023ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case StructuredActivityNode_DataStoreNodeEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getDataStoreNode_3024ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case StructuredActivityNode_CentralBufferNodeEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getCentralBufferNode_3025ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case StructuredActivityNode_InputPinEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getInputPin_3054ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case StructuredActivityNode_OutputPinEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getOutputPin_3055ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case StructuredActivityNode_ConditionalNodeEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getConditionalNode_3092ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case StructuredActivityNode_InitialNodeEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getInitialNode_3093ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case OpaqueBehaviorEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getOpaqueBehavior_3047ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case ActivityParameterNodeEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getActivityParameterNode_3052ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case SendSignalActionEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getSendSignalAction_3053ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case ActivityPartitionEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getActivityPartition_3056ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case ActivityPartition_ActivityPartitionEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getActivityPartition_3057ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case ActivityPartition_AcceptEventActionEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getAcceptEventAction_3059ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case ActivityPartition_AcceptTimeEventActionEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getAcceptEventAction_3060ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case ActivityPartition_ActivityFinalNodeEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getActivityFinalNode_3061ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case ActivityPartition_DecisionNodeEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getDecisionNode_3062ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case ActivityPartition_MergeNodeEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getMergeNode_3063ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case ActivityPartition_InitialNodeEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getInitialNode_3064ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case ActivityPartition_DataStoreNodeEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getDataStoreNode_3065ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case ActivityPartition_CentralBufferNodeEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getCentralBufferNode_3066ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case ActivityPartition_OpaqueActionEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getOpaqueAction_3067ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case ActivityPartition_FlowFinalNodeEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getFlowFinalNode_3068ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case ActivityPartition_ForkNodeEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getForkNode_3069ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case ActivityPartition_JoinNodeEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getJoinNode_3070ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case ActivityPartition_PinEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getPin_3071ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case ActivityPartition_CreateObjectActionEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getCreateObjectAction_3072ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case ActivityPartition_AddStructuralFeatureValueActionEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getAddStructuralFeatureValueAction_3073ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case ActivityPartition_CallBehaviorActionEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getCallBehaviorAction_3074ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case ActivityPartition_CallOperationActionEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getCallOperationAction_3075ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case ActivityPartition_StructuredActivityNodeEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getStructuredActivityNode_3076ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case ActivityPartition_StructuredActivityNode_StructuredActivityNodeEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getStructuredActivityNode_3079ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case StructuredActivityNode_StructuredActivityNode_InputPinEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getInputPin_3080ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case StructuredActivityNode_StructuredActivityNode_OutputPinEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getOutputPin_3081ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case ActivityPartition_SendSignalActionEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getSendSignalAction_3077ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case ActivityPartition_LoopNodeEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getLoopNode_3078ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case ActivityPartition_ConditionalNodeEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getConditionalNode_3083ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case ActivityPartition_ExpansionRegionEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getExpansionRegion_3085ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case ActivityPartition_ValueSpecificationActionEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getValueSpecificationAction_3088ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case ValueSpecificationAction_OutputPinEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getOutputPin_3090ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case LoopNodeEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getLoopNode_3058ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case ConditionalNodeEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getConditionalNode_3082ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case ExpansionRegionEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getExpansionRegion_3084ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case ExpansionNodeEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getExpansionNode_3091ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case ParameterSetEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getParameterSet_3086ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case ParameterEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getParameter_3087ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case ValueSpecificationActionEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getValueSpecificationAction_3089ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case LocalPrecondition_LiteralStringEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getLiteralString_3049ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case LocalPostcondition_LiteralStringEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getLiteralString_3051ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case ControlFlowEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getControlFlow_4001ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case ObjectFlowEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getObjectFlow_4002ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case ExceptionHandlerEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getExceptionHandler_4005ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		}
		for (Iterator children = view.getChildren().iterator(); children.hasNext();) {
			result.addAll(collectAllLinks((View) children.next(), domain2NotationMap));
		}
		for (Iterator edges = view.getSourceEdges().iterator(); edges.hasNext();) {
			result.addAll(collectAllLinks((View) edges.next(), domain2NotationMap));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection createConnections(Collection linkDescriptors, Domain2Notation domain2NotationMap) {
		List adapters = new LinkedList();
		for (Iterator linkDescriptorsIterator = linkDescriptors.iterator(); linkDescriptorsIterator.hasNext();) {
			final IUpdaterLinkDescriptor nextLinkDescriptor = (IUpdaterLinkDescriptor) linkDescriptorsIterator.next();
			EditPart sourceEditPart = getSourceEditPart(nextLinkDescriptor, domain2NotationMap);
			EditPart targetEditPart = getTargetEditPart(nextLinkDescriptor, domain2NotationMap);
			if (sourceEditPart == null || targetEditPart == null) {
				continue;
			}
			CreateConnectionViewRequest.ConnectionViewDescriptor descriptor = new CreateConnectionViewRequest.ConnectionViewDescriptor(nextLinkDescriptor.getSemanticAdapter(), UMLVisualIDRegistry
					.getType(nextLinkDescriptor.getVisualID()), ViewUtil.APPEND, false, ((IGraphicalEditPart) getHost()).getDiagramPreferencesHint());
			CreateConnectionViewRequest ccr = new CreateConnectionViewRequest(descriptor);
			ccr.setType(RequestConstants.REQ_CONNECTION_START);
			ccr.setSourceEditPart(sourceEditPart);
			sourceEditPart.getCommand(ccr);
			ccr.setTargetEditPart(targetEditPart);
			ccr.setType(RequestConstants.REQ_CONNECTION_END);
			Command cmd = targetEditPart.getCommand(ccr);
			if (cmd != null && cmd.canExecute()) {
				executeCommand(cmd);
				IAdaptable viewAdapter = (IAdaptable) ccr.getNewObject();
				if (viewAdapter != null) {
					adapters.add(viewAdapter);
				}
			}
		}
		return adapters;
	}

	/**
	 * @generated
	 */
	private EditPart getEditPart(EObject domainModelElement, Domain2Notation domain2NotationMap) {
		View view = (View) domain2NotationMap.get(domainModelElement);
		if (view != null) {
			return (EditPart) getHost().getViewer().getEditPartRegistry().get(view);
		}
		return null;
	}

	/**
	 * @generated
	 */
	private EditPart getSourceEditPart(IUpdaterLinkDescriptor descriptor, Domain2Notation domain2NotationMap) {
		return getEditPart(descriptor.getSource(), domain2NotationMap);
	}

	/**
	 * @generated
	 */
	private EditPart getTargetEditPart(IUpdaterLinkDescriptor descriptor, Domain2Notation domain2NotationMap) {
		return getEditPart(descriptor.getDestination(), domain2NotationMap);
	}

	/**
	 * @generated
	 */
	protected final EditPart getHintedEditPart(EObject domainModelElement, Domain2Notation domain2NotationMap, int hintVisualId) {
		View view = (View) domain2NotationMap.getHinted(domainModelElement, UMLVisualIDRegistry.getType(hintVisualId));
		if (view != null) {
			return (EditPart) getHost().getViewer().getEditPartRegistry().get(view);
		}
		return null;
	}

	/**
	 * @generated
	 */
	private boolean isNotationOnlyEdge(Edge edge) {
		return false;
	}

	/**
	 * @generated
	 */
	private Collection<IUpdaterLinkDescriptor> collectLinksOutgoingFromShortcut(View view, Domain2Notation domain2NotationMap) {
		EditPart ep = (EditPart) getHost().getViewer().getEditPartRegistry().get(view);
		if (false == ep instanceof IGraphicalEditPart) {
			return Collections.emptyList();
		}
		IGraphicalEditPart editPart = (IGraphicalEditPart) ep;
		UpdateDescriptionRequest request = new UpdateDescriptionRequest();
		//we are not using the result command -- each editpart from the tree 
		//is required to push data into the request
		editPart.getCommand(request);

		Set<IUpdaterLinkDescriptor> linksToFromShortcuts = new HashSet<IUpdaterLinkDescriptor>();
		for (UpdateDescriptionRequest.Descriptor next : request.getDescriptions()) {
			linksToFromShortcuts.addAll(next.getContainedLinks());
			linksToFromShortcuts.addAll(next.getOutgoingLinks());

			if (next.getSemanticElement() != null) {
				domain2NotationMap.put(next.getSemanticElement(), next.getProvider().getNotationView());
			}

		}

		return linksToFromShortcuts;
	}

	/**
	 * @generated
	 */
	private static class Domain2Notation {

		/**
		 * @generated
		 */
		private final HashMap myMap = new HashMap();

		/**
		 * @generated
		 */
		public boolean containsDomainElement(EObject domainElement) {
			return myMap.containsKey(domainElement);
		}

		/**
		 * @generated
		 */
		public boolean containsKey(EObject domainElement) {
			return containsDomainElement(domainElement);
		}

		/**
		 * @generated
		 */
		public void put(EObject domainElement, View view) {
			Object viewOrList = myMap.get(domainElement);
			if (viewOrList instanceof View) {
				myMap.remove(domainElement);
				List<View> list = new LinkedList<View>();
				list.add((View) viewOrList);
				myMap.put(domainElement, list);
				list.add(view);
			} else if (viewOrList instanceof List) {
				((List) viewOrList).add(view);
			} else {
				myMap.put(domainElement, view);
			}
		}

		/**
		 * @generated
		 */
		public View get(EObject domainEObject) {
			Object viewOrList = myMap.get(domainEObject);
			if (viewOrList instanceof View) {
				return (View) viewOrList;
			}
			if (viewOrList instanceof List) {
				// preferring not-shortcut to shortcut -- important for cases when links arr to/from 
				// the element that is additionally shortcutted to the same diagram
				for (Object next : (List) viewOrList) {
					View nextView = (View) next;
					if (nextView.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
						return nextView;
					}
				}
				return (View) ((List) viewOrList).get(0);
			}
			return null;
		}

		/**
		 * @generated
		 */
		public View getHinted(EObject domainEObject, String hint) {
			if (hint == null) {
				return get(domainEObject);
			}
			Object viewOrList = myMap.get(domainEObject);
			if (viewOrList instanceof View) {
				//no choice, will return what we have
				return (View) viewOrList;
			}
			if (viewOrList instanceof List) {
				for (Object next : (List) viewOrList) {
					View nextView = (View) next;
					if (hint.equals(nextView.getType())) {
						return nextView;
					}
				}
				//hint not found -- return what we have
				return (View) ((List) viewOrList).get(0);
			}
			return null;
		}

	}

	/**
	 * @generated
	 */
	@Override
	protected String getFactoryHint(IAdaptable elementAdapter) {
		EObject domainModelElment = (EObject) elementAdapter.getAdapter(EObject.class);
		View containerView = ((IGraphicalEditPart) getHost()).getNotationView();
		int hint = UMLVisualIDRegistry.getNodeVisualID(containerView, domainModelElment);
		return (hint != -1) ? UMLVisualIDRegistry.getType(hint) : super.getFactoryHint(elementAdapter);
	}

}
