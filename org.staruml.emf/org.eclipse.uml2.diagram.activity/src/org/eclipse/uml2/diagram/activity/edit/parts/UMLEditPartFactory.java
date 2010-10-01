package org.eclipse.uml2.diagram.activity.edit.parts;

import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.uml2.diagram.activity.part.UMLVisualIDRegistry;
import org.eclipse.uml2.diagram.common.draw2d.RotatedImageCellEditorLocator;
import org.eclipse.uml2.diagram.common.draw2d.RotatedImageOfString;

/**
 * @generated
 */

public class UMLEditPartFactory implements EditPartFactory {

	/**
	 * @generated
	 */
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			switch (UMLVisualIDRegistry.getVisualID(view)) {

			case PackageEditPart.VISUAL_ID:
				return new PackageEditPart(view);

			case ActivityEditPart.VISUAL_ID:
				return new ActivityEditPart(view);

			case ActivityNameEditPart.VISUAL_ID:
				return new ActivityNameEditPart(view);

			case ActivityStereotypeEditPart.VISUAL_ID:
				return new ActivityStereotypeEditPart(view);

			case LocalPreconditionEditPart.VISUAL_ID:
				return new LocalPreconditionEditPart(view);

			case LocalPostconditionEditPart.VISUAL_ID:
				return new LocalPostconditionEditPart(view);

			case AcceptEventActionEditPart.VISUAL_ID:
				return new AcceptEventActionEditPart(view);

			case AcceptEventActionNameEditPart.VISUAL_ID:
				return new AcceptEventActionNameEditPart(view);

			case AcceptEventActionStereotypeEditPart.VISUAL_ID:
				return new AcceptEventActionStereotypeEditPart(view);

			case AcceptTimeEventActionEditPart.VISUAL_ID:
				return new AcceptTimeEventActionEditPart(view);

			case AcceptTimeEventActionNameEditPart.VISUAL_ID:
				return new AcceptTimeEventActionNameEditPart(view);

			case ActivityFinalNodeEditPart.VISUAL_ID:
				return new ActivityFinalNodeEditPart(view);

			case DecisionNodeEditPart.VISUAL_ID:
				return new DecisionNodeEditPart(view);

			case MergeNodeEditPart.VISUAL_ID:
				return new MergeNodeEditPart(view);

			case InitialNodeEditPart.VISUAL_ID:
				return new InitialNodeEditPart(view);

			case DataStoreNodeEditPart.VISUAL_ID:
				return new DataStoreNodeEditPart(view);

			case DataStoreNodeNameEditPart.VISUAL_ID:
				return new DataStoreNodeNameEditPart(view);

			case DataStoreNodeInStateEditPart.VISUAL_ID:
				return new DataStoreNodeInStateEditPart(view);

			case DataStoreNodeOrderingEditPart.VISUAL_ID:
				return new DataStoreNodeOrderingEditPart(view);

			case DataStoreNodeStereotypeEditPart.VISUAL_ID:
				return new DataStoreNodeStereotypeEditPart(view);

			case CentralBufferNodeEditPart.VISUAL_ID:
				return new CentralBufferNodeEditPart(view);

			case CentralBufferNodeNameEditPart.VISUAL_ID:
				return new CentralBufferNodeNameEditPart(view);

			case CentralBufferNodeInStateEditPart.VISUAL_ID:
				return new CentralBufferNodeInStateEditPart(view);

			case CentralBufferNodeOrderingEditPart.VISUAL_ID:
				return new CentralBufferNodeOrderingEditPart(view);

			case CentralBufferNodeStereotypeEditPart.VISUAL_ID:
				return new CentralBufferNodeStereotypeEditPart(view);

			case OpaqueActionEditPart.VISUAL_ID:
				return new OpaqueActionEditPart(view);

			case OpaqueActionNameEditPart.VISUAL_ID:
				return new OpaqueActionNameEditPart(view);

			case OpaqueActionStereotypeEditPart.VISUAL_ID:
				return new OpaqueActionStereotypeEditPart(view);

			case OpaqueAction_OutputPinEditPart.VISUAL_ID:
				return new OpaqueAction_OutputPinEditPart(view);

			case OpaqueAction_OutputPinNameEditPart.VISUAL_ID:
				return new OpaqueAction_OutputPinNameEditPart(view);

			case OpaqueAction_OutputPinOrderingEditPart.VISUAL_ID:
				return new OpaqueAction_OutputPinOrderingEditPart(view);

			case OpaqueAction_InputPinEditPart.VISUAL_ID:
				return new OpaqueAction_InputPinEditPart(view);

			case OpaqueAction_InputPinNameEditPart.VISUAL_ID:
				return new OpaqueAction_InputPinNameEditPart(view);

			case OpaqueAction_InputPinOrderingEditPart.VISUAL_ID:
				return new OpaqueAction_InputPinOrderingEditPart(view);

			case FlowFinalNodeEditPart.VISUAL_ID:
				return new FlowFinalNodeEditPart(view);

			case ForkNodeEditPart.VISUAL_ID:
				return new ForkNodeEditPart(view);

			case JoinNodeEditPart.VISUAL_ID:
				return new JoinNodeEditPart(view);

			case PinEditPart.VISUAL_ID:
				return new PinEditPart(view);

			case PinNameEditPart.VISUAL_ID:
				return new PinNameEditPart(view);

			case PinInStateEditPart.VISUAL_ID:
				return new PinInStateEditPart(view);

			case PinOrderingEditPart.VISUAL_ID:
				return new PinOrderingEditPart(view);

			case PinStereotypeEditPart.VISUAL_ID:
				return new PinStereotypeEditPart(view);

			case CreateObjectActionEditPart.VISUAL_ID:
				return new CreateObjectActionEditPart(view);

			case CreateObjectActionNameEditPart.VISUAL_ID:
				return new CreateObjectActionNameEditPart(view);

			case CreateObjectActionStereotypeEditPart.VISUAL_ID:
				return new CreateObjectActionStereotypeEditPart(view);

			case CreateObjectAction_OutputPinEditPart.VISUAL_ID:
				return new CreateObjectAction_OutputPinEditPart(view);

			case CreateObjectAction_OutputPinNameEditPart.VISUAL_ID:
				return new CreateObjectAction_OutputPinNameEditPart(view);

			case CreateObjectAction_OutputPinOrderingEditPart.VISUAL_ID:
				return new CreateObjectAction_OutputPinOrderingEditPart(view);

			case AddStructuralFeatureValueActionEditPart.VISUAL_ID:
				return new AddStructuralFeatureValueActionEditPart(view);

			case AddStructuralFeatureValueActionNameEditPart.VISUAL_ID:
				return new AddStructuralFeatureValueActionNameEditPart(view);

			case AddStructuralFeatureValueActionStereotypeEditPart.VISUAL_ID:
				return new AddStructuralFeatureValueActionStereotypeEditPart(view);

			case AddStructuralFeatureValueAction_insertAt_InputPinEditPart.VISUAL_ID:
				return new AddStructuralFeatureValueAction_insertAt_InputPinEditPart(view);

			case AddStructuralFeatureValueAction_insertAt_InputPinNameEditPart.VISUAL_ID:
				return new AddStructuralFeatureValueAction_insertAt_InputPinNameEditPart(view);

			case AddStructuralFeatureValueAction_insertAt_InputPinOrderingEditPart.VISUAL_ID:
				return new AddStructuralFeatureValueAction_insertAt_InputPinOrderingEditPart(view);

			case AddStructuralFeatureValueAction_value_InputPinEditPart.VISUAL_ID:
				return new AddStructuralFeatureValueAction_value_InputPinEditPart(view);

			case AddStructuralFeatureValueAction_value_InputPinNameEditPart.VISUAL_ID:
				return new AddStructuralFeatureValueAction_value_InputPinNameEditPart(view);

			case AddStructuralFeatureValueAction_value_InputPinOrderingEditPart.VISUAL_ID:
				return new AddStructuralFeatureValueAction_value_InputPinOrderingEditPart(view);

			case AddStructuralFeatureValueAction_object_InputPinEditPart.VISUAL_ID:
				return new AddStructuralFeatureValueAction_object_InputPinEditPart(view);

			case AddStructuralFeatureValueAction_object_InputPinNameEditPart.VISUAL_ID:
				return new AddStructuralFeatureValueAction_object_InputPinNameEditPart(view);

			case AddStructuralFeatureValueAction_object_InputPinOrderingEditPart.VISUAL_ID:
				return new AddStructuralFeatureValueAction_object_InputPinOrderingEditPart(view);

			case CallBehaviorActionEditPart.VISUAL_ID:
				return new CallBehaviorActionEditPart(view);

			case CallBehaviorActionNameEditPart.VISUAL_ID:
				return new CallBehaviorActionNameEditPart(view);

			case CallBehaviorActionStereotypeEditPart.VISUAL_ID:
				return new CallBehaviorActionStereotypeEditPart(view);

			case CallAction_OutputPinEditPart.VISUAL_ID:
				return new CallAction_OutputPinEditPart(view);

			case CallAction_OutputPinNameEditPart.VISUAL_ID:
				return new CallAction_OutputPinNameEditPart(view);

			case CallAction_OutputPinOrderingEditPart.VISUAL_ID:
				return new CallAction_OutputPinOrderingEditPart(view);

			case CallAction_InputPinEditPart.VISUAL_ID:
				return new CallAction_InputPinEditPart(view);

			case CallAction_InputPinNameEditPart.VISUAL_ID:
				return new CallAction_InputPinNameEditPart(view);

			case CallAction_InputPinOrderingEditPart.VISUAL_ID:
				return new CallAction_InputPinOrderingEditPart(view);

			case CallOperationActionEditPart.VISUAL_ID:
				return new CallOperationActionEditPart(view);

			case CallOperationActionNameEditPart.VISUAL_ID:
				return new CallOperationActionNameEditPart(view);

			case CallOperationActionStereotypeEditPart.VISUAL_ID:
				return new CallOperationActionStereotypeEditPart(view);

			case CallOperationAction_InputPinEditPart.VISUAL_ID:
				return new CallOperationAction_InputPinEditPart(view);

			case CallOperationAction_InputPinNameEditPart.VISUAL_ID:
				return new CallOperationAction_InputPinNameEditPart(view);

			case CallOperationAction_InputPinOrderingEditPart.VISUAL_ID:
				return new CallOperationAction_InputPinOrderingEditPart(view);

			case StructuredActivityNodeEditPart.VISUAL_ID:
				return new StructuredActivityNodeEditPart(view);

			case StructuredActivityNodeNameEditPart.VISUAL_ID:
				return new StructuredActivityNodeNameEditPart(view);

			case StructuredActivityNodeStereotypeEditPart.VISUAL_ID:
				return new StructuredActivityNodeStereotypeEditPart(view);

			case StructuredActivityNode_StructuredActivityNodeEditPart.VISUAL_ID:
				return new StructuredActivityNode_StructuredActivityNodeEditPart(view);

			case StructuredActivityNode_StructuredActivityNodeNameEditPart.VISUAL_ID:
				return new StructuredActivityNode_StructuredActivityNodeNameEditPart(view);

			case StructuredActivityNode_StructuredActivityNodeStereotypeEditPart.VISUAL_ID:
				return new StructuredActivityNode_StructuredActivityNodeStereotypeEditPart(view);

			case StructuredActivityNode_OpaqueActionEditPart.VISUAL_ID:
				return new StructuredActivityNode_OpaqueActionEditPart(view);

			case StructuredActivityNode_OpaqueActionNameEditPart.VISUAL_ID:
				return new StructuredActivityNode_OpaqueActionNameEditPart(view);

			case StructuredActivityNode_OpaqueActionStereotypeEditPart.VISUAL_ID:
				return new StructuredActivityNode_OpaqueActionStereotypeEditPart(view);

			case StructuredActivityNode_AcceptEventActionEditPart.VISUAL_ID:
				return new StructuredActivityNode_AcceptEventActionEditPart(view);

			case StructuredActivityNode_AcceptEventActionNameEditPart.VISUAL_ID:
				return new StructuredActivityNode_AcceptEventActionNameEditPart(view);

			case StructuredActivityNode_AcceptEventActionStereotypeEditPart.VISUAL_ID:
				return new StructuredActivityNode_AcceptEventActionStereotypeEditPart(view);

			case StructuredActivityNode_AcceptTimeEventActionEditPart.VISUAL_ID:
				return new StructuredActivityNode_AcceptTimeEventActionEditPart(view);

			case StructuredActivityNode_AcceptTimeEventActionNameEditPart.VISUAL_ID:
				return new StructuredActivityNode_AcceptTimeEventActionNameEditPart(view);

			case StructuredActivityNode_ActivityFinalNodeEditPart.VISUAL_ID:
				return new StructuredActivityNode_ActivityFinalNodeEditPart(view);

			case StructuredActivityNode_DecisionNodeEditPart.VISUAL_ID:
				return new StructuredActivityNode_DecisionNodeEditPart(view);

			case StructuredActivityNode_FlowFinalNodeEditPart.VISUAL_ID:
				return new StructuredActivityNode_FlowFinalNodeEditPart(view);

			case StructuredActivityNode_PinEditPart.VISUAL_ID:
				return new StructuredActivityNode_PinEditPart(view);

			case StructuredActivityNode_PinNameEditPart.VISUAL_ID:
				return new StructuredActivityNode_PinNameEditPart(view);

			case StructuredActivityNode_PinInStateEditPart.VISUAL_ID:
				return new StructuredActivityNode_PinInStateEditPart(view);

			case StructuredActivityNode_PinOrderingEditPart.VISUAL_ID:
				return new StructuredActivityNode_PinOrderingEditPart(view);

			case StructuredActivityNode_PinStereotypeEditPart.VISUAL_ID:
				return new StructuredActivityNode_PinStereotypeEditPart(view);

			case StructuredActivityNode_CreateObjectActionEditPart.VISUAL_ID:
				return new StructuredActivityNode_CreateObjectActionEditPart(view);

			case StructuredActivityNode_CreateObjectActionNameEditPart.VISUAL_ID:
				return new StructuredActivityNode_CreateObjectActionNameEditPart(view);

			case StructuredActivityNode_CreateObjectActionStereotypeEditPart.VISUAL_ID:
				return new StructuredActivityNode_CreateObjectActionStereotypeEditPart(view);

			case StructuredActivityNode_CallBehaviorActionEditPart.VISUAL_ID:
				return new StructuredActivityNode_CallBehaviorActionEditPart(view);

			case StructuredActivityNode_CallBehaviorActionNameEditPart.VISUAL_ID:
				return new StructuredActivityNode_CallBehaviorActionNameEditPart(view);

			case StructuredActivityNode_CallBehaviorActionStereotypeEditPart.VISUAL_ID:
				return new StructuredActivityNode_CallBehaviorActionStereotypeEditPart(view);

			case StructuredActivityNode_CallOperationActionEditPart.VISUAL_ID:
				return new StructuredActivityNode_CallOperationActionEditPart(view);

			case StructuredActivityNode_CallOperationActionNameEditPart.VISUAL_ID:
				return new StructuredActivityNode_CallOperationActionNameEditPart(view);

			case StructuredActivityNode_CallOperationActionStereotypeEditPart.VISUAL_ID:
				return new StructuredActivityNode_CallOperationActionStereotypeEditPart(view);

			case StructuredActivityNode_ForkNodeEditPart.VISUAL_ID:
				return new StructuredActivityNode_ForkNodeEditPart(view);

			case StructuredActivityNode_JoinNodeEditPart.VISUAL_ID:
				return new StructuredActivityNode_JoinNodeEditPart(view);

			case StructuredActivityNode_AddStructuralFeatureValueActionEditPart.VISUAL_ID:
				return new StructuredActivityNode_AddStructuralFeatureValueActionEditPart(view);

			case StructuredActivityNode_AddStructuralFeatureValueActionNameEditPart.VISUAL_ID:
				return new StructuredActivityNode_AddStructuralFeatureValueActionNameEditPart(view);

			case StructuredActivityNode_AddStructuralFeatureValueActionStereotypeEditPart.VISUAL_ID:
				return new StructuredActivityNode_AddStructuralFeatureValueActionStereotypeEditPart(view);

			case StructuredActivityNode_DataStoreNodeEditPart.VISUAL_ID:
				return new StructuredActivityNode_DataStoreNodeEditPart(view);

			case StructuredActivityNode_DataStoreNodeNameEditPart.VISUAL_ID:
				return new StructuredActivityNode_DataStoreNodeNameEditPart(view);

			case StructuredActivityNode_DataStoreNodeInStateEditPart.VISUAL_ID:
				return new StructuredActivityNode_DataStoreNodeInStateEditPart(view);

			case StructuredActivityNode_DataStoreNodeOrderingEditPart.VISUAL_ID:
				return new StructuredActivityNode_DataStoreNodeOrderingEditPart(view);

			case StructuredActivityNode_DataStoreNodeStereotypeEditPart.VISUAL_ID:
				return new StructuredActivityNode_DataStoreNodeStereotypeEditPart(view);

			case StructuredActivityNode_CentralBufferNodeEditPart.VISUAL_ID:
				return new StructuredActivityNode_CentralBufferNodeEditPart(view);

			case StructuredActivityNode_CentralBufferNodeNameEditPart.VISUAL_ID:
				return new StructuredActivityNode_CentralBufferNodeNameEditPart(view);

			case StructuredActivityNode_CentralBufferNodeInStateEditPart.VISUAL_ID:
				return new StructuredActivityNode_CentralBufferNodeInStateEditPart(view);

			case StructuredActivityNode_CentralBufferNodeOrderingEditPart.VISUAL_ID:
				return new StructuredActivityNode_CentralBufferNodeOrderingEditPart(view);

			case StructuredActivityNode_CentralBufferNodeStereotypeEditPart.VISUAL_ID:
				return new StructuredActivityNode_CentralBufferNodeStereotypeEditPart(view);

			case StructuredActivityNode_InputPinEditPart.VISUAL_ID:
				return new StructuredActivityNode_InputPinEditPart(view);

			case StructuredActivityNode_InputPinNameEditPart.VISUAL_ID:
				return new StructuredActivityNode_InputPinNameEditPart(view);

			case StructuredActivityNode_InputPinOrderingEditPart.VISUAL_ID:
				return new StructuredActivityNode_InputPinOrderingEditPart(view);

			case StructuredActivityNode_OutputPinEditPart.VISUAL_ID:
				return new StructuredActivityNode_OutputPinEditPart(view);

			case StructuredActivityNode_OutputPinNameEditPart.VISUAL_ID:
				return new StructuredActivityNode_OutputPinNameEditPart(view);

			case StructuredActivityNode_OutputPinOrderingEditPart.VISUAL_ID:
				return new StructuredActivityNode_OutputPinOrderingEditPart(view);

			case StructuredActivityNode_ConditionalNodeEditPart.VISUAL_ID:
				return new StructuredActivityNode_ConditionalNodeEditPart(view);

			case StructuredActivityNode_ConditionalNodeNameEditPart.VISUAL_ID:
				return new StructuredActivityNode_ConditionalNodeNameEditPart(view);

			case StructuredActivityNode_ConditionalNodeStereotypeEditPart.VISUAL_ID:
				return new StructuredActivityNode_ConditionalNodeStereotypeEditPart(view);

			case StructuredActivityNode_InitialNodeEditPart.VISUAL_ID:
				return new StructuredActivityNode_InitialNodeEditPart(view);

			case OpaqueBehaviorEditPart.VISUAL_ID:
				return new OpaqueBehaviorEditPart(view);

			case OpaqueBehaviorNameEditPart.VISUAL_ID:
				return new OpaqueBehaviorNameEditPart(view);

			case ActivityParameterNodeEditPart.VISUAL_ID:
				return new ActivityParameterNodeEditPart(view);

			case ActivityParameterNodeNameEditPart.VISUAL_ID:
				return new ActivityParameterNodeNameEditPart(view);

			case ActivityParameterNodeStereotypeEditPart.VISUAL_ID:
				return new ActivityParameterNodeStereotypeEditPart(view);

			case SendSignalActionEditPart.VISUAL_ID:
				return new SendSignalActionEditPart(view);

			case SendSignalActionNameEditPart.VISUAL_ID:
				return new SendSignalActionNameEditPart(view);

			case SendSignalActionStereotypeEditPart.VISUAL_ID:
				return new SendSignalActionStereotypeEditPart(view);

			case ActivityPartitionEditPart.VISUAL_ID:
				return new ActivityPartitionEditPart(view);

			case ActivityPartitionNameEditPart.VISUAL_ID:
				return new ActivityPartitionNameEditPart(view);

			case ActivityPartition_ActivityPartitionEditPart.VISUAL_ID:
				return new ActivityPartition_ActivityPartitionEditPart(view);

			case ActivityPartition_ActivityPartitionNameEditPart.VISUAL_ID:
				return new ActivityPartition_ActivityPartitionNameEditPart(view);

			case ActivityPartition_AcceptEventActionEditPart.VISUAL_ID:
				return new ActivityPartition_AcceptEventActionEditPart(view);

			case ActivityPartition_AcceptEventActionNameEditPart.VISUAL_ID:
				return new ActivityPartition_AcceptEventActionNameEditPart(view);

			case ActivityPartition_AcceptEventActionStereotypeEditPart.VISUAL_ID:
				return new ActivityPartition_AcceptEventActionStereotypeEditPart(view);

			case ActivityPartition_AcceptTimeEventActionEditPart.VISUAL_ID:
				return new ActivityPartition_AcceptTimeEventActionEditPart(view);

			case ActivityPartition_AcceptTimeEventActionNameEditPart.VISUAL_ID:
				return new ActivityPartition_AcceptTimeEventActionNameEditPart(view);

			case ActivityPartition_ActivityFinalNodeEditPart.VISUAL_ID:
				return new ActivityPartition_ActivityFinalNodeEditPart(view);

			case ActivityPartition_DecisionNodeEditPart.VISUAL_ID:
				return new ActivityPartition_DecisionNodeEditPart(view);

			case ActivityPartition_MergeNodeEditPart.VISUAL_ID:
				return new ActivityPartition_MergeNodeEditPart(view);

			case ActivityPartition_InitialNodeEditPart.VISUAL_ID:
				return new ActivityPartition_InitialNodeEditPart(view);

			case ActivityPartition_DataStoreNodeEditPart.VISUAL_ID:
				return new ActivityPartition_DataStoreNodeEditPart(view);

			case ActivityPartition_DataStoreNodeNameEditPart.VISUAL_ID:
				return new ActivityPartition_DataStoreNodeNameEditPart(view);

			case ActivityPartition_DataStoreNodeInStateEditPart.VISUAL_ID:
				return new ActivityPartition_DataStoreNodeInStateEditPart(view);

			case ActivityPartition_DataStoreNodeOrderingEditPart.VISUAL_ID:
				return new ActivityPartition_DataStoreNodeOrderingEditPart(view);

			case ActivityPartition_DataStoreNodeStereotypeEditPart.VISUAL_ID:
				return new ActivityPartition_DataStoreNodeStereotypeEditPart(view);

			case ActivityPartition_CentralBufferNodeEditPart.VISUAL_ID:
				return new ActivityPartition_CentralBufferNodeEditPart(view);

			case ActivityPartition_CentralBufferNodeNameEditPart.VISUAL_ID:
				return new ActivityPartition_CentralBufferNodeNameEditPart(view);

			case ActivityPartition_CentralBufferNodeInStateEditPart.VISUAL_ID:
				return new ActivityPartition_CentralBufferNodeInStateEditPart(view);

			case ActivityPartition_CentralBufferNodeOrderingEditPart.VISUAL_ID:
				return new ActivityPartition_CentralBufferNodeOrderingEditPart(view);

			case ActivityPartition_CentralBufferNodeStereotypeEditPart.VISUAL_ID:
				return new ActivityPartition_CentralBufferNodeStereotypeEditPart(view);

			case ActivityPartition_OpaqueActionEditPart.VISUAL_ID:
				return new ActivityPartition_OpaqueActionEditPart(view);

			case ActivityPartition_OpaqueActionNameEditPart.VISUAL_ID:
				return new ActivityPartition_OpaqueActionNameEditPart(view);

			case ActivityPartition_OpaqueActionStereotypeEditPart.VISUAL_ID:
				return new ActivityPartition_OpaqueActionStereotypeEditPart(view);

			case ActivityPartition_FlowFinalNodeEditPart.VISUAL_ID:
				return new ActivityPartition_FlowFinalNodeEditPart(view);

			case ActivityPartition_ForkNodeEditPart.VISUAL_ID:
				return new ActivityPartition_ForkNodeEditPart(view);

			case ActivityPartition_JoinNodeEditPart.VISUAL_ID:
				return new ActivityPartition_JoinNodeEditPart(view);

			case ActivityPartition_PinEditPart.VISUAL_ID:
				return new ActivityPartition_PinEditPart(view);

			case ActivityPartition_PinNameEditPart.VISUAL_ID:
				return new ActivityPartition_PinNameEditPart(view);

			case ActivityPartition_PinInStateEditPart.VISUAL_ID:
				return new ActivityPartition_PinInStateEditPart(view);

			case ActivityPartition_PinOrderingEditPart.VISUAL_ID:
				return new ActivityPartition_PinOrderingEditPart(view);

			case ActivityPartition_PinStereotypeEditPart.VISUAL_ID:
				return new ActivityPartition_PinStereotypeEditPart(view);

			case ActivityPartition_CreateObjectActionEditPart.VISUAL_ID:
				return new ActivityPartition_CreateObjectActionEditPart(view);

			case ActivityPartition_CreateObjectActionNameEditPart.VISUAL_ID:
				return new ActivityPartition_CreateObjectActionNameEditPart(view);

			case ActivityPartition_CreateObjectActionStereotypeEditPart.VISUAL_ID:
				return new ActivityPartition_CreateObjectActionStereotypeEditPart(view);

			case ActivityPartition_AddStructuralFeatureValueActionEditPart.VISUAL_ID:
				return new ActivityPartition_AddStructuralFeatureValueActionEditPart(view);

			case ActivityPartition_AddStructuralFeatureValueActionNameEditPart.VISUAL_ID:
				return new ActivityPartition_AddStructuralFeatureValueActionNameEditPart(view);

			case ActivityPartition_AddStructuralFeatureValueActionStereotypeEditPart.VISUAL_ID:
				return new ActivityPartition_AddStructuralFeatureValueActionStereotypeEditPart(view);

			case ActivityPartition_CallBehaviorActionEditPart.VISUAL_ID:
				return new ActivityPartition_CallBehaviorActionEditPart(view);

			case ActivityPartition_CallBehaviorActionNameEditPart.VISUAL_ID:
				return new ActivityPartition_CallBehaviorActionNameEditPart(view);

			case ActivityPartition_CallBehaviorActionStereotypeEditPart.VISUAL_ID:
				return new ActivityPartition_CallBehaviorActionStereotypeEditPart(view);

			case ActivityPartition_CallOperationActionEditPart.VISUAL_ID:
				return new ActivityPartition_CallOperationActionEditPart(view);

			case ActivityPartition_CallOperationActionNameEditPart.VISUAL_ID:
				return new ActivityPartition_CallOperationActionNameEditPart(view);

			case ActivityPartition_CallOperationActionStereotypeEditPart.VISUAL_ID:
				return new ActivityPartition_CallOperationActionStereotypeEditPart(view);

			case ActivityPartition_StructuredActivityNodeEditPart.VISUAL_ID:
				return new ActivityPartition_StructuredActivityNodeEditPart(view);

			case ActivityPartition_StructuredActivityNodeNameEditPart.VISUAL_ID:
				return new ActivityPartition_StructuredActivityNodeNameEditPart(view);

			case ActivityPartition_StructuredActivityNodeStereotypeEditPart.VISUAL_ID:
				return new ActivityPartition_StructuredActivityNodeStereotypeEditPart(view);

			case ActivityPartition_StructuredActivityNode_StructuredActivityNodeEditPart.VISUAL_ID:
				return new ActivityPartition_StructuredActivityNode_StructuredActivityNodeEditPart(view);

			case ActivityPartition_StructuredActivityNode_StructuredActivityNodeStereotypeEditPart.VISUAL_ID:
				return new ActivityPartition_StructuredActivityNode_StructuredActivityNodeStereotypeEditPart(view);

			case StructuredActivityNodeQualifiedName2EditPart.VISUAL_ID:
				return new StructuredActivityNodeQualifiedName2EditPart(view);

			case StructuredActivityNode_StructuredActivityNode_InputPinEditPart.VISUAL_ID:
				return new StructuredActivityNode_StructuredActivityNode_InputPinEditPart(view);

			case StructuredActivityNode_StructuredActivityNode_InputPinNameEditPart.VISUAL_ID:
				return new StructuredActivityNode_StructuredActivityNode_InputPinNameEditPart(view);

			case StructuredActivityNode_StructuredActivityNode_InputPinOrderingEditPart.VISUAL_ID:
				return new StructuredActivityNode_StructuredActivityNode_InputPinOrderingEditPart(view);

			case StructuredActivityNode_StructuredActivityNode_OutputPinEditPart.VISUAL_ID:
				return new StructuredActivityNode_StructuredActivityNode_OutputPinEditPart(view);

			case StructuredActivityNode_StructuredActivityNode_OutputPinNameEditPart.VISUAL_ID:
				return new StructuredActivityNode_StructuredActivityNode_OutputPinNameEditPart(view);

			case StructuredActivityNode_StructuredActivityNode_OutputPinOrderingEditPart.VISUAL_ID:
				return new StructuredActivityNode_StructuredActivityNode_OutputPinOrderingEditPart(view);

			case ActivityPartition_SendSignalActionEditPart.VISUAL_ID:
				return new ActivityPartition_SendSignalActionEditPart(view);

			case ActivityPartition_SendSignalActionNameEditPart.VISUAL_ID:
				return new ActivityPartition_SendSignalActionNameEditPart(view);

			case ActivityPartition_SendSignalActionStereotypeEditPart.VISUAL_ID:
				return new ActivityPartition_SendSignalActionStereotypeEditPart(view);

			case ActivityPartition_LoopNodeEditPart.VISUAL_ID:
				return new ActivityPartition_LoopNodeEditPart(view);

			case ActivityPartition_LoopNodeNameEditPart.VISUAL_ID:
				return new ActivityPartition_LoopNodeNameEditPart(view);

			case ActivityPartition_LoopNodeStereotypeEditPart.VISUAL_ID:
				return new ActivityPartition_LoopNodeStereotypeEditPart(view);

			case ActivityPartition_ConditionalNodeEditPart.VISUAL_ID:
				return new ActivityPartition_ConditionalNodeEditPart(view);

			case ActivityPartition_ConditionalNodeNameEditPart.VISUAL_ID:
				return new ActivityPartition_ConditionalNodeNameEditPart(view);

			case ActivityPartition_ConditionalNodeStereotypeEditPart.VISUAL_ID:
				return new ActivityPartition_ConditionalNodeStereotypeEditPart(view);

			case ActivityPartition_ExpansionRegionEditPart.VISUAL_ID:
				return new ActivityPartition_ExpansionRegionEditPart(view);

			case ActivityPartition_ExpansionRegionModeEditPart.VISUAL_ID:
				return new ActivityPartition_ExpansionRegionModeEditPart(view);

			case ActivityPartition_ValueSpecificationActionEditPart.VISUAL_ID:
				return new ActivityPartition_ValueSpecificationActionEditPart(view);

			case ActivityPartition_ValueSpecificationActionNameEditPart.VISUAL_ID:
				return new ActivityPartition_ValueSpecificationActionNameEditPart(view);

			case ActivityPartition_ValueSpecificationActionStereotypeEditPart.VISUAL_ID:
				return new ActivityPartition_ValueSpecificationActionStereotypeEditPart(view);

			case ValueSpecificationAction_OutputPinEditPart.VISUAL_ID:
				return new ValueSpecificationAction_OutputPinEditPart(view);

			case ValueSpecificationAction_OutputPinNameEditPart.VISUAL_ID:
				return new ValueSpecificationAction_OutputPinNameEditPart(view);

			case ValueSpecificationAction_OutputPinOrderingEditPart.VISUAL_ID:
				return new ValueSpecificationAction_OutputPinOrderingEditPart(view);

			case LoopNodeEditPart.VISUAL_ID:
				return new LoopNodeEditPart(view);

			case LoopNodeNameEditPart.VISUAL_ID:
				return new LoopNodeNameEditPart(view);

			case LoopNodeStereotypeEditPart.VISUAL_ID:
				return new LoopNodeStereotypeEditPart(view);

			case ConditionalNodeEditPart.VISUAL_ID:
				return new ConditionalNodeEditPart(view);

			case ConditionalNodeNameEditPart.VISUAL_ID:
				return new ConditionalNodeNameEditPart(view);

			case ConditionalNodeStereotypeEditPart.VISUAL_ID:
				return new ConditionalNodeStereotypeEditPart(view);

			case ExpansionRegionEditPart.VISUAL_ID:
				return new ExpansionRegionEditPart(view);

			case ExpansionRegionModeEditPart.VISUAL_ID:
				return new ExpansionRegionModeEditPart(view);

			case ExpansionNodeEditPart.VISUAL_ID:
				return new ExpansionNodeEditPart(view);

			case ExpansionNodeNameEditPart.VISUAL_ID:
				return new ExpansionNodeNameEditPart(view);

			case ExpansionNodeInStateEditPart.VISUAL_ID:
				return new ExpansionNodeInStateEditPart(view);

			case ExpansionNodeOrderingEditPart.VISUAL_ID:
				return new ExpansionNodeOrderingEditPart(view);

			case ExpansionNodeStereotypeEditPart.VISUAL_ID:
				return new ExpansionNodeStereotypeEditPart(view);

			case ParameterSetEditPart.VISUAL_ID:
				return new ParameterSetEditPart(view);

			case ParameterEditPart.VISUAL_ID:
				return new ParameterEditPart(view);

			case ValueSpecificationActionEditPart.VISUAL_ID:
				return new ValueSpecificationActionEditPart(view);

			case ValueSpecificationActionNameEditPart.VISUAL_ID:
				return new ValueSpecificationActionNameEditPart(view);

			case ValueSpecificationActionStereotypeEditPart.VISUAL_ID:
				return new ValueSpecificationActionStereotypeEditPart(view);

			case LocalPrecondition_LiteralStringEditPart.VISUAL_ID:
				return new LocalPrecondition_LiteralStringEditPart(view);

			case LocalPostcondition_LiteralStringEditPart.VISUAL_ID:
				return new LocalPostcondition_LiteralStringEditPart(view);

			case StructuredActivityNodeContentPaneCompartmentEditPart.VISUAL_ID:
				return new StructuredActivityNodeContentPaneCompartmentEditPart(view);

			case StructuredActivityNode_StructuredActivityNodeContentPaneCompartmentEditPart.VISUAL_ID:
				return new StructuredActivityNode_StructuredActivityNodeContentPaneCompartmentEditPart(view);

			case ConditionalNodeConditionalNodeCompartmentEditPart.VISUAL_ID:
				return new ConditionalNodeConditionalNodeCompartmentEditPart(view);

			case ActivityPartition_StructuredActivityNodeContentPaneCompartmentEditPart.VISUAL_ID:
				return new ActivityPartition_StructuredActivityNodeContentPaneCompartmentEditPart(view);

			case ActivityPartition_StructuredActivityNode_StructuredActivityNodeContentPaneCompartmentEditPart.VISUAL_ID:
				return new ActivityPartition_StructuredActivityNode_StructuredActivityNodeContentPaneCompartmentEditPart(view);

			case ActivityPartition_LoopNodeContentPaneCompartmentEditPart.VISUAL_ID:
				return new ActivityPartition_LoopNodeContentPaneCompartmentEditPart(view);

			case ActivityPartition_ConditionalNodeCompartmentEditPart.VISUAL_ID:
				return new ActivityPartition_ConditionalNodeCompartmentEditPart(view);

			case ActivityPartition_ExpansionRegionNodeCompartmentEditPart.VISUAL_ID:
				return new ActivityPartition_ExpansionRegionNodeCompartmentEditPart(view);

			case LoopNodeContentPaneCompartmentEditPart.VISUAL_ID:
				return new LoopNodeContentPaneCompartmentEditPart(view);

			case ConditionalNodeCompartmentEditPart.VISUAL_ID:
				return new ConditionalNodeCompartmentEditPart(view);

			case ExpansionRegionNodeCompartmentEditPart.VISUAL_ID:
				return new ExpansionRegionNodeCompartmentEditPart(view);

			case LocalPreconditionCompartmentEditPart.VISUAL_ID:
				return new LocalPreconditionCompartmentEditPart(view);

			case LocalPostconditionCompartmentEditPart.VISUAL_ID:
				return new LocalPostconditionCompartmentEditPart(view);

			case ControlFlowEditPart.VISUAL_ID:
				return new ControlFlowEditPart(view);

			case ControlFlowNameEditPart.VISUAL_ID:
				return new ControlFlowNameEditPart(view);

			case ControlFlowName2EditPart.VISUAL_ID:
				return new ControlFlowName2EditPart(view);

			case ControlFlowName3EditPart.VISUAL_ID:
				return new ControlFlowName3EditPart(view);

			case ObjectFlowEditPart.VISUAL_ID:
				return new ObjectFlowEditPart(view);

			case ObjectFlowNameEditPart.VISUAL_ID:
				return new ObjectFlowNameEditPart(view);

			case ObjectFlowName2EditPart.VISUAL_ID:
				return new ObjectFlowName2EditPart(view);

			case ObjectFlowName3EditPart.VISUAL_ID:
				return new ObjectFlowName3EditPart(view);

			case ActionLocalPreconditionEditPart.VISUAL_ID:
				return new ActionLocalPreconditionEditPart(view);

			case ActionLocalPostconditionEditPart.VISUAL_ID:
				return new ActionLocalPostconditionEditPart(view);

			case ObjectNodeSelectionEditPart.VISUAL_ID:
				return new ObjectNodeSelectionEditPart(view);

			case ExceptionHandlerEditPart.VISUAL_ID:
				return new ExceptionHandlerEditPart(view);

			case ExceptionHandlerLink_fixed_iconEditPart.VISUAL_ID:
				return new ExceptionHandlerLink_fixed_iconEditPart(view);
			}
		}
		return createUnrecognizedEditPart(context, model);
	}

	/**
	 * @generated
	 */
	private EditPart createUnrecognizedEditPart(EditPart context, Object model) {
		// Handle creation of unrecognized child node EditParts here
		return null;
	}

	/**
	 * @generated
	 */
	public static CellEditorLocator getTextCellEditorLocator(ITextAwareEditPart source) {
		if (source.getFigure() instanceof WrappingLabel) {
			return new TextCellEditorLocator((WrappingLabel) source.getFigure());
		} else if (source.getFigure() instanceof RotatedImageOfString) {
			return new RotatedImageCellEditorLocator((RotatedImageOfString) source.getFigure());
		} else {
			return new LabelCellEditorLocator((Label) source.getFigure());
		}
	}

	/**
	 * @generated
	 */

	static private class TextCellEditorLocator implements CellEditorLocator {

		/**
		 * @generated
		 */
		private WrappingLabel wrapLabel;

		/**
		 * @generated
		 */
		public TextCellEditorLocator(WrappingLabel wrapLabel) {
			this.wrapLabel = wrapLabel;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getWrapLabel() {
			return wrapLabel;
		}

		/**
		 * @generated
		 */
		public void relocate(CellEditor celleditor) {
			Text text = (Text) celleditor.getControl();
			Rectangle rect = getWrapLabel().getTextBounds().getCopy();
			getWrapLabel().translateToAbsolute(rect);
			if (getWrapLabel().isTextWrapOn() && getWrapLabel().getText().length() > 0) {
				rect.setSize(new Dimension(text.computeSize(rect.width, SWT.DEFAULT)));
			} else {
				int avr = FigureUtilities.getFontMetrics(text.getFont()).getAverageCharWidth();
				rect.setSize(new Dimension(text.computeSize(SWT.DEFAULT, SWT.DEFAULT)).expand(avr * 2, 0));
			}
			if (!rect.equals(new Rectangle(text.getBounds()))) {
				text.setBounds(rect.x, rect.y, rect.width, rect.height);
			}
		}
	}

	/**
	 * @generated
	 */

	private static class LabelCellEditorLocator implements CellEditorLocator {

		/**
		 * @generated
		 */
		private Label label;

		/**
		 * @generated
		 */
		public LabelCellEditorLocator(Label label) {
			this.label = label;
		}

		/**
		 * @generated
		 */
		public Label getLabel() {
			return label;
		}

		/**
		 * @generated
		 */
		public void relocate(CellEditor celleditor) {
			Text text = (Text) celleditor.getControl();
			Rectangle rect = getLabel().getTextBounds().getCopy();
			getLabel().translateToAbsolute(rect);
			int avr = FigureUtilities.getFontMetrics(text.getFont()).getAverageCharWidth();
			rect.setSize(new Dimension(text.computeSize(SWT.DEFAULT, SWT.DEFAULT)).expand(avr * 2, 0));
			if (!rect.equals(new Rectangle(text.getBounds()))) {
				text.setBounds(rect.x, rect.y, rect.width, rect.height);
			}
		}
	}

}
