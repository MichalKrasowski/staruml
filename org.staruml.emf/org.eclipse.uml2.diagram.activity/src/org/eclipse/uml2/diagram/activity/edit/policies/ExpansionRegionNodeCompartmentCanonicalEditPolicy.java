package org.eclipse.uml2.diagram.activity.edit.policies;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
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
import org.eclipse.uml2.diagram.activity.edit.parts.CreateObjectActionEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.CreateObjectAction_OutputPinEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.DataStoreNodeEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.DecisionNodeEditPart;
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
import org.eclipse.uml2.diagram.activity.edit.parts.OpaqueActionEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.OpaqueAction_InputPinEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.OpaqueAction_OutputPinEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.OpaqueBehaviorEditPart;
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
import org.eclipse.uml2.diagram.activity.part.UMLDiagramEditorPlugin;
import org.eclipse.uml2.diagram.activity.part.UMLDiagramUpdater;
import org.eclipse.uml2.diagram.activity.part.UMLVisualIDRegistry;
import org.eclipse.uml2.diagram.common.genapi.IUpdaterNodeDescriptor;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */

public class ExpansionRegionNodeCompartmentCanonicalEditPolicy extends CanonicalEditPolicy {

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
		for (Iterator it = UMLDiagramUpdater.getExpansionRegionExpansionRegionNodeCompartment_7021SemanticChildren(viewObject).iterator(); it.hasNext();) {
			result.add(((IUpdaterNodeDescriptor) it.next()).getModelElement());
		}
		return result;
	}

	/**
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	protected boolean isOrphaned(Collection semanticChildren, final View view) {
		int visualID = UMLVisualIDRegistry.getVisualID(view);
		switch (visualID) {
		case ActivityEditPart.VISUAL_ID:
		case LocalPreconditionEditPart.VISUAL_ID:
		case LocalPostconditionEditPart.VISUAL_ID:
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
		case ParameterSetEditPart.VISUAL_ID:
		case ParameterEditPart.VISUAL_ID:
		case ValueSpecificationActionEditPart.VISUAL_ID:
		case LocalPrecondition_LiteralStringEditPart.VISUAL_ID:
		case LocalPostcondition_LiteralStringEditPart.VISUAL_ID:
			return true;
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
		case ExpansionNodeEditPart.VISUAL_ID:
			if (!semanticChildren.contains(view.getElement())) {
				return true;
			}
			EObject domainModelElement = view.getElement();
			if (visualID != UMLVisualIDRegistry.getNodeVisualID((View) getHost().getModel(), domainModelElement)) {
				List createdViews = createViews(Collections.singletonList(domainModelElement));
				assert createdViews.size() == 1;
				final View createdView = (View) ((IAdaptable) createdViews.get(0)).getAdapter(View.class);
				if (createdView != null) {
					try {
						new AbstractEMFOperation(host().getEditingDomain(), StringStatics.BLANK, Collections.singletonMap(Transaction.OPTION_UNPROTECTED, Boolean.TRUE)) {

							protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
								populateViewProperties(view, createdView);
								return Status.OK_STATUS;
							}
						}.execute(new NullProgressMonitor(), null);
					} catch (ExecutionException e) {
						UMLDiagramEditorPlugin.getInstance().logError("Error while copyign view information to newly created view", e); //$NON-NLS-1$
					}
				}
				deleteViews(Collections.singletonList(view).iterator());
			}
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
			myFeaturesToSynchronize.add(UMLPackage.eINSTANCE.getStructuredActivityNode_Node());
		}
		return myFeaturesToSynchronize;
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
