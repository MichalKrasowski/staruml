package org.eclipse.uml2.diagram.activity.navigator;

import org.eclipse.gmf.runtime.common.ui.services.parser.CommonParserHint;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ITreePathLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.ViewerLabel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;
import org.eclipse.uml2.diagram.activity.edit.parts.*;
import org.eclipse.uml2.diagram.activity.part.UMLDiagramEditorPlugin;
import org.eclipse.uml2.diagram.activity.part.UMLVisualIDRegistry;
import org.eclipse.uml2.diagram.activity.providers.UMLElementTypes;
import org.eclipse.uml2.diagram.activity.providers.UMLParserProvider;
import org.eclipse.uml2.uml.ActivityFinalNode;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.DecisionNode;
import org.eclipse.uml2.uml.FlowFinalNode;
import org.eclipse.uml2.uml.ForkNode;
import org.eclipse.uml2.uml.InitialNode;
import org.eclipse.uml2.uml.JoinNode;
import org.eclipse.uml2.uml.MergeNode;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterSet;

/**
 * @generated
 */

public class UMLNavigatorLabelProvider extends LabelProvider implements ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		UMLDiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		UMLDiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof UMLNavigatorItem && !isOwnView(((UMLNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if (element instanceof UMLNavigatorGroup) {
			UMLNavigatorGroup group = (UMLNavigatorGroup) element;
			return UMLDiagramEditorPlugin.getInstance().getBundledImage(group.getIcon());
		}

		if (element instanceof UMLNavigatorItem) {
			UMLNavigatorItem navigatorItem = (UMLNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return super.getImage(element);
			}
			return getImage(navigatorItem.getView());
		}

		return super.getImage(element);
	}

	/**
	 * @generated
	 */
	public Image getImage(View view) {
		switch (UMLVisualIDRegistry.getVisualID(view)) {
		case PackageEditPart.VISUAL_ID:
			return getImage("Navigator?Diagram?http://www.eclipse.org/uml2/3.0.0/UML?Package", UMLElementTypes.Package_1000); //$NON-NLS-1$
		case ActivityEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/3.0.0/UML?Activity", UMLElementTypes.Activity_2026); //$NON-NLS-1$
		case LocalPreconditionEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/3.0.0/UML?Constraint", UMLElementTypes.Constraint_2027); //$NON-NLS-1$
		case LocalPostconditionEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/3.0.0/UML?Constraint", UMLElementTypes.Constraint_2028); //$NON-NLS-1$
		case AcceptEventActionEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?AcceptEventAction", UMLElementTypes.AcceptEventAction_3030); //$NON-NLS-1$
		case AcceptTimeEventActionEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?AcceptEventAction", UMLElementTypes.AcceptEventAction_3031); //$NON-NLS-1$
		case ActivityFinalNodeEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?ActivityFinalNode", UMLElementTypes.ActivityFinalNode_3032); //$NON-NLS-1$
		case DecisionNodeEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?DecisionNode", UMLElementTypes.DecisionNode_3033); //$NON-NLS-1$
		case MergeNodeEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?MergeNode", UMLElementTypes.MergeNode_3034); //$NON-NLS-1$
		case InitialNodeEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?InitialNode", UMLElementTypes.InitialNode_3035); //$NON-NLS-1$
		case DataStoreNodeEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?DataStoreNode", UMLElementTypes.DataStoreNode_3036); //$NON-NLS-1$
		case CentralBufferNodeEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?CentralBufferNode", UMLElementTypes.CentralBufferNode_3037); //$NON-NLS-1$
		case OpaqueActionEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?OpaqueAction", UMLElementTypes.OpaqueAction_3029); //$NON-NLS-1$
		case OpaqueAction_OutputPinEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?OutputPin", UMLElementTypes.OutputPin_3001); //$NON-NLS-1$
		case OpaqueAction_InputPinEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?InputPin", UMLElementTypes.InputPin_3094); //$NON-NLS-1$
		case FlowFinalNodeEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?FlowFinalNode", UMLElementTypes.FlowFinalNode_3038); //$NON-NLS-1$
		case ForkNodeEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?ForkNode", UMLElementTypes.ForkNode_3039); //$NON-NLS-1$
		case JoinNodeEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?JoinNode", UMLElementTypes.JoinNode_3040); //$NON-NLS-1$
		case PinEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Pin", UMLElementTypes.Pin_3041); //$NON-NLS-1$
		case CreateObjectActionEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?CreateObjectAction", UMLElementTypes.CreateObjectAction_3042); //$NON-NLS-1$
		case CreateObjectAction_OutputPinEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?OutputPin", UMLElementTypes.OutputPin_3002); //$NON-NLS-1$
		case AddStructuralFeatureValueActionEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?AddStructuralFeatureValueAction", UMLElementTypes.AddStructuralFeatureValueAction_3043); //$NON-NLS-1$
		case AddStructuralFeatureValueAction_insertAt_InputPinEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?InputPin", UMLElementTypes.InputPin_3003); //$NON-NLS-1$
		case AddStructuralFeatureValueAction_value_InputPinEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?InputPin", UMLElementTypes.InputPin_3004); //$NON-NLS-1$
		case AddStructuralFeatureValueAction_object_InputPinEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?InputPin", UMLElementTypes.InputPin_3005); //$NON-NLS-1$
		case CallBehaviorActionEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?CallBehaviorAction", UMLElementTypes.CallBehaviorAction_3044); //$NON-NLS-1$
		case CallAction_OutputPinEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?OutputPin", UMLElementTypes.OutputPin_3006); //$NON-NLS-1$
		case CallAction_InputPinEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?InputPin", UMLElementTypes.InputPin_3007); //$NON-NLS-1$
		case CallOperationActionEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?CallOperationAction", UMLElementTypes.CallOperationAction_3045); //$NON-NLS-1$
		case CallOperationAction_InputPinEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?InputPin", UMLElementTypes.InputPin_3008); //$NON-NLS-1$
		case StructuredActivityNodeEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?StructuredActivityNode", UMLElementTypes.StructuredActivityNode_3046); //$NON-NLS-1$
		case StructuredActivityNode_StructuredActivityNodeEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?StructuredActivityNode", UMLElementTypes.StructuredActivityNode_3009); //$NON-NLS-1$
		case StructuredActivityNode_OpaqueActionEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?OpaqueAction", UMLElementTypes.OpaqueAction_3011); //$NON-NLS-1$
		case StructuredActivityNode_AcceptEventActionEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?AcceptEventAction", UMLElementTypes.AcceptEventAction_3012); //$NON-NLS-1$
		case StructuredActivityNode_AcceptTimeEventActionEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?AcceptEventAction", UMLElementTypes.AcceptEventAction_3013); //$NON-NLS-1$
		case StructuredActivityNode_ActivityFinalNodeEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?ActivityFinalNode", UMLElementTypes.ActivityFinalNode_3014); //$NON-NLS-1$
		case StructuredActivityNode_DecisionNodeEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?DecisionNode", UMLElementTypes.DecisionNode_3015); //$NON-NLS-1$
		case StructuredActivityNode_FlowFinalNodeEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?FlowFinalNode", UMLElementTypes.FlowFinalNode_3016); //$NON-NLS-1$
		case StructuredActivityNode_PinEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Pin", UMLElementTypes.Pin_3017); //$NON-NLS-1$
		case StructuredActivityNode_CreateObjectActionEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?CreateObjectAction", UMLElementTypes.CreateObjectAction_3018); //$NON-NLS-1$
		case StructuredActivityNode_CallBehaviorActionEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?CallBehaviorAction", UMLElementTypes.CallBehaviorAction_3019); //$NON-NLS-1$
		case StructuredActivityNode_CallOperationActionEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?CallOperationAction", UMLElementTypes.CallOperationAction_3020); //$NON-NLS-1$
		case StructuredActivityNode_ForkNodeEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?ForkNode", UMLElementTypes.ForkNode_3021); //$NON-NLS-1$
		case StructuredActivityNode_JoinNodeEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?JoinNode", UMLElementTypes.JoinNode_3022); //$NON-NLS-1$
		case StructuredActivityNode_AddStructuralFeatureValueActionEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?AddStructuralFeatureValueAction", UMLElementTypes.AddStructuralFeatureValueAction_3023); //$NON-NLS-1$
		case StructuredActivityNode_DataStoreNodeEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?DataStoreNode", UMLElementTypes.DataStoreNode_3024); //$NON-NLS-1$
		case StructuredActivityNode_CentralBufferNodeEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?CentralBufferNode", UMLElementTypes.CentralBufferNode_3025); //$NON-NLS-1$
		case StructuredActivityNode_InputPinEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?InputPin", UMLElementTypes.InputPin_3054); //$NON-NLS-1$
		case StructuredActivityNode_OutputPinEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?OutputPin", UMLElementTypes.OutputPin_3055); //$NON-NLS-1$
		case StructuredActivityNode_ConditionalNodeEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?ConditionalNode", UMLElementTypes.ConditionalNode_3092); //$NON-NLS-1$
		case StructuredActivityNode_InitialNodeEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?InitialNode", UMLElementTypes.InitialNode_3093); //$NON-NLS-1$
		case OpaqueBehaviorEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?OpaqueBehavior", UMLElementTypes.OpaqueBehavior_3047); //$NON-NLS-1$
		case ActivityParameterNodeEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?ActivityParameterNode", UMLElementTypes.ActivityParameterNode_3052); //$NON-NLS-1$
		case SendSignalActionEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?SendSignalAction", UMLElementTypes.SendSignalAction_3053); //$NON-NLS-1$
		case ActivityPartitionEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?ActivityPartition", UMLElementTypes.ActivityPartition_3056); //$NON-NLS-1$
		case ActivityPartition_ActivityPartitionEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?ActivityPartition", UMLElementTypes.ActivityPartition_3057); //$NON-NLS-1$
		case ActivityPartition_AcceptEventActionEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?AcceptEventAction", UMLElementTypes.AcceptEventAction_3059); //$NON-NLS-1$
		case ActivityPartition_AcceptTimeEventActionEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?AcceptEventAction", UMLElementTypes.AcceptEventAction_3060); //$NON-NLS-1$
		case ActivityPartition_ActivityFinalNodeEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?ActivityFinalNode", UMLElementTypes.ActivityFinalNode_3061); //$NON-NLS-1$
		case ActivityPartition_DecisionNodeEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?DecisionNode", UMLElementTypes.DecisionNode_3062); //$NON-NLS-1$
		case ActivityPartition_MergeNodeEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?MergeNode", UMLElementTypes.MergeNode_3063); //$NON-NLS-1$
		case ActivityPartition_InitialNodeEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?InitialNode", UMLElementTypes.InitialNode_3064); //$NON-NLS-1$
		case ActivityPartition_DataStoreNodeEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?DataStoreNode", UMLElementTypes.DataStoreNode_3065); //$NON-NLS-1$
		case ActivityPartition_CentralBufferNodeEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?CentralBufferNode", UMLElementTypes.CentralBufferNode_3066); //$NON-NLS-1$
		case ActivityPartition_OpaqueActionEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?OpaqueAction", UMLElementTypes.OpaqueAction_3067); //$NON-NLS-1$
		case ActivityPartition_FlowFinalNodeEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?FlowFinalNode", UMLElementTypes.FlowFinalNode_3068); //$NON-NLS-1$
		case ActivityPartition_ForkNodeEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?ForkNode", UMLElementTypes.ForkNode_3069); //$NON-NLS-1$
		case ActivityPartition_JoinNodeEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?JoinNode", UMLElementTypes.JoinNode_3070); //$NON-NLS-1$
		case ActivityPartition_PinEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Pin", UMLElementTypes.Pin_3071); //$NON-NLS-1$
		case ActivityPartition_CreateObjectActionEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?CreateObjectAction", UMLElementTypes.CreateObjectAction_3072); //$NON-NLS-1$
		case ActivityPartition_AddStructuralFeatureValueActionEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?AddStructuralFeatureValueAction", UMLElementTypes.AddStructuralFeatureValueAction_3073); //$NON-NLS-1$
		case ActivityPartition_CallBehaviorActionEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?CallBehaviorAction", UMLElementTypes.CallBehaviorAction_3074); //$NON-NLS-1$
		case ActivityPartition_CallOperationActionEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?CallOperationAction", UMLElementTypes.CallOperationAction_3075); //$NON-NLS-1$
		case ActivityPartition_StructuredActivityNodeEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?StructuredActivityNode", UMLElementTypes.StructuredActivityNode_3076); //$NON-NLS-1$
		case ActivityPartition_StructuredActivityNode_StructuredActivityNodeEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?StructuredActivityNode", UMLElementTypes.StructuredActivityNode_3079); //$NON-NLS-1$
		case StructuredActivityNode_StructuredActivityNode_InputPinEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?InputPin", UMLElementTypes.InputPin_3080); //$NON-NLS-1$
		case StructuredActivityNode_StructuredActivityNode_OutputPinEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?OutputPin", UMLElementTypes.OutputPin_3081); //$NON-NLS-1$
		case ActivityPartition_SendSignalActionEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?SendSignalAction", UMLElementTypes.SendSignalAction_3077); //$NON-NLS-1$
		case ActivityPartition_LoopNodeEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?LoopNode", UMLElementTypes.LoopNode_3078); //$NON-NLS-1$
		case ActivityPartition_ConditionalNodeEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?ConditionalNode", UMLElementTypes.ConditionalNode_3083); //$NON-NLS-1$
		case ActivityPartition_ExpansionRegionEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?ExpansionRegion", UMLElementTypes.ExpansionRegion_3085); //$NON-NLS-1$
		case ActivityPartition_ValueSpecificationActionEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?ValueSpecificationAction", UMLElementTypes.ValueSpecificationAction_3088); //$NON-NLS-1$
		case ValueSpecificationAction_OutputPinEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?OutputPin", UMLElementTypes.OutputPin_3090); //$NON-NLS-1$
		case LoopNodeEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?LoopNode", UMLElementTypes.LoopNode_3058); //$NON-NLS-1$
		case ConditionalNodeEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?ConditionalNode", UMLElementTypes.ConditionalNode_3082); //$NON-NLS-1$
		case ExpansionRegionEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?ExpansionRegion", UMLElementTypes.ExpansionRegion_3084); //$NON-NLS-1$
		case ExpansionNodeEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?ExpansionNode", UMLElementTypes.ExpansionNode_3091); //$NON-NLS-1$
		case ParameterSetEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?ParameterSet", UMLElementTypes.ParameterSet_3086); //$NON-NLS-1$
		case ParameterEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Parameter", UMLElementTypes.Parameter_3087); //$NON-NLS-1$
		case ValueSpecificationActionEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?ValueSpecificationAction", UMLElementTypes.ValueSpecificationAction_3089); //$NON-NLS-1$
		case LocalPrecondition_LiteralStringEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?LiteralString", UMLElementTypes.LiteralString_3049); //$NON-NLS-1$
		case LocalPostcondition_LiteralStringEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?LiteralString", UMLElementTypes.LiteralString_3051); //$NON-NLS-1$
		case ControlFlowEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/3.0.0/UML?ControlFlow", UMLElementTypes.ControlFlow_4001); //$NON-NLS-1$
		case ObjectFlowEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/3.0.0/UML?ObjectFlow", UMLElementTypes.ObjectFlow_4002); //$NON-NLS-1$
		case ActionLocalPreconditionEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/3.0.0/UML?Action?localPrecondition", UMLElementTypes.ActionLocalPrecondition_4003); //$NON-NLS-1$
		case ActionLocalPostconditionEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/3.0.0/UML?Action?localPostcondition", UMLElementTypes.ActionLocalPostcondition_4006); //$NON-NLS-1$
		case ObjectNodeSelectionEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/3.0.0/UML?ObjectNode?selection", UMLElementTypes.ObjectNodeSelection_4004); //$NON-NLS-1$
		case ExceptionHandlerEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/3.0.0/UML?ExceptionHandler", UMLElementTypes.ExceptionHandler_4005); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = UMLDiagramEditorPlugin.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null && UMLElementTypes.isKnownElementType(elementType)) {
			image = UMLElementTypes.getImage(elementType);
			imageRegistry.put(key, image);
		}

		if (image == null) {
			image = imageRegistry.get("Navigator?ImageNotFound"); //$NON-NLS-1$
			imageRegistry.put(key, image);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public String getText(Object element) {
		if (element instanceof UMLNavigatorGroup) {
			UMLNavigatorGroup group = (UMLNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof UMLNavigatorItem) {
			UMLNavigatorItem navigatorItem = (UMLNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return null;
			}
			return getText(navigatorItem.getView());
		}

		return super.getText(element);
	}

	/**
	 * @generated
	 */
	public String getText(View view) {
		if (view.getElement() != null && view.getElement().eIsProxy()) {
			return getUnresolvedDomainElementProxyText(view);
		}
		switch (UMLVisualIDRegistry.getVisualID(view)) {
		case PackageEditPart.VISUAL_ID:
			return getPackage_1000Text(view);
		case ActivityEditPart.VISUAL_ID:
			return getActivity_2026Text(view);
		case LocalPreconditionEditPart.VISUAL_ID:
			return getConstraint_2027Text(view);
		case LocalPostconditionEditPart.VISUAL_ID:
			return getConstraint_2028Text(view);
		case AcceptEventActionEditPart.VISUAL_ID:
			return getAcceptEventAction_3030Text(view);
		case AcceptTimeEventActionEditPart.VISUAL_ID:
			return getAcceptEventAction_3031Text(view);
		case ActivityFinalNodeEditPart.VISUAL_ID:
			return getActivityFinalNode_3032Text(view);
		case DecisionNodeEditPart.VISUAL_ID:
			return getDecisionNode_3033Text(view);
		case MergeNodeEditPart.VISUAL_ID:
			return getMergeNode_3034Text(view);
		case InitialNodeEditPart.VISUAL_ID:
			return getInitialNode_3035Text(view);
		case DataStoreNodeEditPart.VISUAL_ID:
			return getDataStoreNode_3036Text(view);
		case CentralBufferNodeEditPart.VISUAL_ID:
			return getCentralBufferNode_3037Text(view);
		case OpaqueActionEditPart.VISUAL_ID:
			return getOpaqueAction_3029Text(view);
		case OpaqueAction_OutputPinEditPart.VISUAL_ID:
			return getOutputPin_3001Text(view);
		case OpaqueAction_InputPinEditPart.VISUAL_ID:
			return getInputPin_3094Text(view);
		case FlowFinalNodeEditPart.VISUAL_ID:
			return getFlowFinalNode_3038Text(view);
		case ForkNodeEditPart.VISUAL_ID:
			return getForkNode_3039Text(view);
		case JoinNodeEditPart.VISUAL_ID:
			return getJoinNode_3040Text(view);
		case PinEditPart.VISUAL_ID:
			return getPin_3041Text(view);
		case CreateObjectActionEditPart.VISUAL_ID:
			return getCreateObjectAction_3042Text(view);
		case CreateObjectAction_OutputPinEditPart.VISUAL_ID:
			return getOutputPin_3002Text(view);
		case AddStructuralFeatureValueActionEditPart.VISUAL_ID:
			return getAddStructuralFeatureValueAction_3043Text(view);
		case AddStructuralFeatureValueAction_insertAt_InputPinEditPart.VISUAL_ID:
			return getInputPin_3003Text(view);
		case AddStructuralFeatureValueAction_value_InputPinEditPart.VISUAL_ID:
			return getInputPin_3004Text(view);
		case AddStructuralFeatureValueAction_object_InputPinEditPart.VISUAL_ID:
			return getInputPin_3005Text(view);
		case CallBehaviorActionEditPart.VISUAL_ID:
			return getCallBehaviorAction_3044Text(view);
		case CallAction_OutputPinEditPart.VISUAL_ID:
			return getOutputPin_3006Text(view);
		case CallAction_InputPinEditPart.VISUAL_ID:
			return getInputPin_3007Text(view);
		case CallOperationActionEditPart.VISUAL_ID:
			return getCallOperationAction_3045Text(view);
		case CallOperationAction_InputPinEditPart.VISUAL_ID:
			return getInputPin_3008Text(view);
		case StructuredActivityNodeEditPart.VISUAL_ID:
			return getStructuredActivityNode_3046Text(view);
		case StructuredActivityNode_StructuredActivityNodeEditPart.VISUAL_ID:
			return getStructuredActivityNode_3009Text(view);
		case StructuredActivityNode_OpaqueActionEditPart.VISUAL_ID:
			return getOpaqueAction_3011Text(view);
		case StructuredActivityNode_AcceptEventActionEditPart.VISUAL_ID:
			return getAcceptEventAction_3012Text(view);
		case StructuredActivityNode_AcceptTimeEventActionEditPart.VISUAL_ID:
			return getAcceptEventAction_3013Text(view);
		case StructuredActivityNode_ActivityFinalNodeEditPart.VISUAL_ID:
			return getActivityFinalNode_3014Text(view);
		case StructuredActivityNode_DecisionNodeEditPart.VISUAL_ID:
			return getDecisionNode_3015Text(view);
		case StructuredActivityNode_FlowFinalNodeEditPart.VISUAL_ID:
			return getFlowFinalNode_3016Text(view);
		case StructuredActivityNode_PinEditPart.VISUAL_ID:
			return getPin_3017Text(view);
		case StructuredActivityNode_CreateObjectActionEditPart.VISUAL_ID:
			return getCreateObjectAction_3018Text(view);
		case StructuredActivityNode_CallBehaviorActionEditPart.VISUAL_ID:
			return getCallBehaviorAction_3019Text(view);
		case StructuredActivityNode_CallOperationActionEditPart.VISUAL_ID:
			return getCallOperationAction_3020Text(view);
		case StructuredActivityNode_ForkNodeEditPart.VISUAL_ID:
			return getForkNode_3021Text(view);
		case StructuredActivityNode_JoinNodeEditPart.VISUAL_ID:
			return getJoinNode_3022Text(view);
		case StructuredActivityNode_AddStructuralFeatureValueActionEditPart.VISUAL_ID:
			return getAddStructuralFeatureValueAction_3023Text(view);
		case StructuredActivityNode_DataStoreNodeEditPart.VISUAL_ID:
			return getDataStoreNode_3024Text(view);
		case StructuredActivityNode_CentralBufferNodeEditPart.VISUAL_ID:
			return getCentralBufferNode_3025Text(view);
		case StructuredActivityNode_InputPinEditPart.VISUAL_ID:
			return getInputPin_3054Text(view);
		case StructuredActivityNode_OutputPinEditPart.VISUAL_ID:
			return getOutputPin_3055Text(view);
		case StructuredActivityNode_ConditionalNodeEditPart.VISUAL_ID:
			return getConditionalNode_3092Text(view);
		case StructuredActivityNode_InitialNodeEditPart.VISUAL_ID:
			return getInitialNode_3093Text(view);
		case OpaqueBehaviorEditPart.VISUAL_ID:
			return getOpaqueBehavior_3047Text(view);
		case ActivityParameterNodeEditPart.VISUAL_ID:
			return getActivityParameterNode_3052Text(view);
		case SendSignalActionEditPart.VISUAL_ID:
			return getSendSignalAction_3053Text(view);
		case ActivityPartitionEditPart.VISUAL_ID:
			return getActivityPartition_3056Text(view);
		case ActivityPartition_ActivityPartitionEditPart.VISUAL_ID:
			return getActivityPartition_3057Text(view);
		case ActivityPartition_AcceptEventActionEditPart.VISUAL_ID:
			return getAcceptEventAction_3059Text(view);
		case ActivityPartition_AcceptTimeEventActionEditPart.VISUAL_ID:
			return getAcceptEventAction_3060Text(view);
		case ActivityPartition_ActivityFinalNodeEditPart.VISUAL_ID:
			return getActivityFinalNode_3061Text(view);
		case ActivityPartition_DecisionNodeEditPart.VISUAL_ID:
			return getDecisionNode_3062Text(view);
		case ActivityPartition_MergeNodeEditPart.VISUAL_ID:
			return getMergeNode_3063Text(view);
		case ActivityPartition_InitialNodeEditPart.VISUAL_ID:
			return getInitialNode_3064Text(view);
		case ActivityPartition_DataStoreNodeEditPart.VISUAL_ID:
			return getDataStoreNode_3065Text(view);
		case ActivityPartition_CentralBufferNodeEditPart.VISUAL_ID:
			return getCentralBufferNode_3066Text(view);
		case ActivityPartition_OpaqueActionEditPart.VISUAL_ID:
			return getOpaqueAction_3067Text(view);
		case ActivityPartition_FlowFinalNodeEditPart.VISUAL_ID:
			return getFlowFinalNode_3068Text(view);
		case ActivityPartition_ForkNodeEditPart.VISUAL_ID:
			return getForkNode_3069Text(view);
		case ActivityPartition_JoinNodeEditPart.VISUAL_ID:
			return getJoinNode_3070Text(view);
		case ActivityPartition_PinEditPart.VISUAL_ID:
			return getPin_3071Text(view);
		case ActivityPartition_CreateObjectActionEditPart.VISUAL_ID:
			return getCreateObjectAction_3072Text(view);
		case ActivityPartition_AddStructuralFeatureValueActionEditPart.VISUAL_ID:
			return getAddStructuralFeatureValueAction_3073Text(view);
		case ActivityPartition_CallBehaviorActionEditPart.VISUAL_ID:
			return getCallBehaviorAction_3074Text(view);
		case ActivityPartition_CallOperationActionEditPart.VISUAL_ID:
			return getCallOperationAction_3075Text(view);
		case ActivityPartition_StructuredActivityNodeEditPart.VISUAL_ID:
			return getStructuredActivityNode_3076Text(view);
		case ActivityPartition_StructuredActivityNode_StructuredActivityNodeEditPart.VISUAL_ID:
			return getStructuredActivityNode_3079Text(view);
		case StructuredActivityNode_StructuredActivityNode_InputPinEditPart.VISUAL_ID:
			return getInputPin_3080Text(view);
		case StructuredActivityNode_StructuredActivityNode_OutputPinEditPart.VISUAL_ID:
			return getOutputPin_3081Text(view);
		case ActivityPartition_SendSignalActionEditPart.VISUAL_ID:
			return getSendSignalAction_3077Text(view);
		case ActivityPartition_LoopNodeEditPart.VISUAL_ID:
			return getLoopNode_3078Text(view);
		case ActivityPartition_ConditionalNodeEditPart.VISUAL_ID:
			return getConditionalNode_3083Text(view);
		case ActivityPartition_ExpansionRegionEditPart.VISUAL_ID:
			return getExpansionRegion_3085Text(view);
		case ActivityPartition_ValueSpecificationActionEditPart.VISUAL_ID:
			return getValueSpecificationAction_3088Text(view);
		case ValueSpecificationAction_OutputPinEditPart.VISUAL_ID:
			return getOutputPin_3090Text(view);
		case LoopNodeEditPart.VISUAL_ID:
			return getLoopNode_3058Text(view);
		case ConditionalNodeEditPart.VISUAL_ID:
			return getConditionalNode_3082Text(view);
		case ExpansionRegionEditPart.VISUAL_ID:
			return getExpansionRegion_3084Text(view);
		case ExpansionNodeEditPart.VISUAL_ID:
			return getExpansionNode_3091Text(view);
		case ParameterSetEditPart.VISUAL_ID:
			return getParameterSet_3086Text(view);
		case ParameterEditPart.VISUAL_ID:
			return getParameter_3087Text(view);
		case ValueSpecificationActionEditPart.VISUAL_ID:
			return getValueSpecificationAction_3089Text(view);
		case LocalPrecondition_LiteralStringEditPart.VISUAL_ID:
			return getLiteralString_3049Text(view);
		case LocalPostcondition_LiteralStringEditPart.VISUAL_ID:
			return getLiteralString_3051Text(view);
		case ControlFlowEditPart.VISUAL_ID:
			return getControlFlow_4001Text(view);
		case ObjectFlowEditPart.VISUAL_ID:
			return getObjectFlow_4002Text(view);
		case ActionLocalPreconditionEditPart.VISUAL_ID:
			return getActionLocalPrecondition_4003Text(view);
		case ActionLocalPostconditionEditPart.VISUAL_ID:
			return getActionLocalPostcondition_4006Text(view);
		case ObjectNodeSelectionEditPart.VISUAL_ID:
			return getObjectNodeSelection_4004Text(view);
		case ExceptionHandlerEditPart.VISUAL_ID:
			return getExceptionHandler_4005Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getPackage_1000Text(View view) {
		Package domainModelElement = (Package) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 1000); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getActivity_2026Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Activity_2026, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(ActivityNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5030); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getConstraint_2027Text(View view) {
		Constraint domainModelElement = (Constraint) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 2027); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getConstraint_2028Text(View view) {
		Constraint domainModelElement = (Constraint) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 2028); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getAcceptEventAction_3030Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.AcceptEventAction_3030, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(AcceptEventActionNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5040); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getAcceptEventAction_3031Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.AcceptEventAction_3031, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(AcceptTimeEventActionNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5042); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getActivityFinalNode_3032Text(View view) {
		ActivityFinalNode domainModelElement = (ActivityFinalNode) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3032); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getDecisionNode_3033Text(View view) {
		DecisionNode domainModelElement = (DecisionNode) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3033); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getMergeNode_3034Text(View view) {
		MergeNode domainModelElement = (MergeNode) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3034); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getInitialNode_3035Text(View view) {
		InitialNode domainModelElement = (InitialNode) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3035); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getDataStoreNode_3036Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.DataStoreNode_3036, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(DataStoreNodeNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5034); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getCentralBufferNode_3037Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.CentralBufferNode_3037, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(CentralBufferNodeNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5032); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getOpaqueAction_3029Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.OpaqueAction_3029, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(OpaqueActionNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5023); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getOutputPin_3001Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.OutputPin_3001, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(OpaqueAction_OutputPinNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getInputPin_3094Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.InputPin_3094, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(OpaqueAction_InputPinNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5149); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getFlowFinalNode_3038Text(View view) {
		FlowFinalNode domainModelElement = (FlowFinalNode) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3038); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getForkNode_3039Text(View view) {
		ForkNode domainModelElement = (ForkNode) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3039); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getJoinNode_3040Text(View view) {
		JoinNode domainModelElement = (JoinNode) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3040); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getPin_3041Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Pin_3041, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(PinNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5024); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getCreateObjectAction_3042Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.CreateObjectAction_3042, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(CreateObjectActionNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5025); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getOutputPin_3002Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.OutputPin_3002, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(CreateObjectAction_OutputPinNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5004); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getAddStructuralFeatureValueAction_3043Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.AddStructuralFeatureValueAction_3043, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(AddStructuralFeatureValueActionNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5026); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getInputPin_3003Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.InputPin_3003, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(AddStructuralFeatureValueAction_insertAt_InputPinNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5006); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getInputPin_3004Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.InputPin_3004, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(AddStructuralFeatureValueAction_value_InputPinNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5007); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getInputPin_3005Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.InputPin_3005, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(AddStructuralFeatureValueAction_object_InputPinNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5008); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getCallBehaviorAction_3044Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.CallBehaviorAction_3044, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(CallBehaviorActionNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5027); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getOutputPin_3006Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.OutputPin_3006, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(CallAction_OutputPinNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5010); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getInputPin_3007Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.InputPin_3007, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(CallAction_InputPinNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5011); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getCallOperationAction_3045Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.CallOperationAction_3045, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(CallOperationActionNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5028); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getInputPin_3008Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.InputPin_3008, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(CallOperationAction_InputPinNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5013); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getStructuredActivityNode_3046Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.StructuredActivityNode_3046, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(StructuredActivityNodeNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5090); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getStructuredActivityNode_3009Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.StructuredActivityNode_3009, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(StructuredActivityNode_StructuredActivityNodeNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5089); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getOpaqueAction_3011Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.OpaqueAction_3011, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(StructuredActivityNode_OpaqueActionNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5015); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getAcceptEventAction_3012Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.AcceptEventAction_3012, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(StructuredActivityNode_AcceptEventActionNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5041); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getAcceptEventAction_3013Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.AcceptEventAction_3013, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(StructuredActivityNode_AcceptTimeEventActionNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5043); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getActivityFinalNode_3014Text(View view) {
		ActivityFinalNode domainModelElement = (ActivityFinalNode) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3014); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getDecisionNode_3015Text(View view) {
		DecisionNode domainModelElement = (DecisionNode) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3015); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getFlowFinalNode_3016Text(View view) {
		FlowFinalNode domainModelElement = (FlowFinalNode) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3016); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getPin_3017Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Pin_3017, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(StructuredActivityNode_PinNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5016); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getCreateObjectAction_3018Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.CreateObjectAction_3018, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(StructuredActivityNode_CreateObjectActionNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5017); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getCallBehaviorAction_3019Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.CallBehaviorAction_3019, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(StructuredActivityNode_CallBehaviorActionNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5018); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getCallOperationAction_3020Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.CallOperationAction_3020, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(StructuredActivityNode_CallOperationActionNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5019); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getForkNode_3021Text(View view) {
		ForkNode domainModelElement = (ForkNode) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3021); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getJoinNode_3022Text(View view) {
		JoinNode domainModelElement = (JoinNode) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3022); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getAddStructuralFeatureValueAction_3023Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.AddStructuralFeatureValueAction_3023, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(StructuredActivityNode_AddStructuralFeatureValueActionNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5020); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getDataStoreNode_3024Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.DataStoreNode_3024, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(StructuredActivityNode_DataStoreNodeNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5035); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getCentralBufferNode_3025Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.CentralBufferNode_3025, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(StructuredActivityNode_CentralBufferNodeNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5033); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getInputPin_3054Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.InputPin_3054, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(StructuredActivityNode_InputPinNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5047); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getOutputPin_3055Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.OutputPin_3055, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(StructuredActivityNode_OutputPinNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5048); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getConditionalNode_3092Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.ConditionalNode_3092, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(StructuredActivityNode_ConditionalNodeNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5147); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getInitialNode_3093Text(View view) {
		InitialNode domainModelElement = (InitialNode) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3093); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getOpaqueBehavior_3047Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.OpaqueBehavior_3047, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(OpaqueBehaviorNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5029); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getActivityParameterNode_3052Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.ActivityParameterNode_3052, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(ActivityParameterNodeNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5031); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getSendSignalAction_3053Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.SendSignalAction_3053, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(SendSignalActionNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5044); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getActivityPartition_3056Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.ActivityPartition_3056, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(ActivityPartitionNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5045); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getActivityPartition_3057Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.ActivityPartition_3057, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(ActivityPartition_ActivityPartitionNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5046); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getAcceptEventAction_3059Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.AcceptEventAction_3059, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(ActivityPartition_AcceptEventActionNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5065); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getAcceptEventAction_3060Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.AcceptEventAction_3060, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(ActivityPartition_AcceptTimeEventActionNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5066); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getActivityFinalNode_3061Text(View view) {
		ActivityFinalNode domainModelElement = (ActivityFinalNode) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3061); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getDecisionNode_3062Text(View view) {
		DecisionNode domainModelElement = (DecisionNode) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3062); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getMergeNode_3063Text(View view) {
		MergeNode domainModelElement = (MergeNode) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3063); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getInitialNode_3064Text(View view) {
		InitialNode domainModelElement = (InitialNode) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3064); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getDataStoreNode_3065Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.DataStoreNode_3065, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(ActivityPartition_DataStoreNodeNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5067); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getCentralBufferNode_3066Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.CentralBufferNode_3066, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(ActivityPartition_CentralBufferNodeNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5070); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getOpaqueAction_3067Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.OpaqueAction_3067, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(ActivityPartition_OpaqueActionNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5073); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getFlowFinalNode_3068Text(View view) {
		FlowFinalNode domainModelElement = (FlowFinalNode) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3068); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getForkNode_3069Text(View view) {
		ForkNode domainModelElement = (ForkNode) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3069); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getJoinNode_3070Text(View view) {
		JoinNode domainModelElement = (JoinNode) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3070); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getPin_3071Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Pin_3071, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(ActivityPartition_PinNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5074); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getCreateObjectAction_3072Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.CreateObjectAction_3072, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(ActivityPartition_CreateObjectActionNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5076); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getAddStructuralFeatureValueAction_3073Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.AddStructuralFeatureValueAction_3073, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(ActivityPartition_AddStructuralFeatureValueActionNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5077); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getCallBehaviorAction_3074Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.CallBehaviorAction_3074, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(ActivityPartition_CallBehaviorActionNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5078); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getCallOperationAction_3075Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.CallOperationAction_3075, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(ActivityPartition_CallOperationActionNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5079); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getStructuredActivityNode_3076Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.StructuredActivityNode_3076, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(ActivityPartition_StructuredActivityNodeNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5122); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getStructuredActivityNode_3079Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.StructuredActivityNode_3079, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(ActivityPartition_StructuredActivityNode_StructuredActivityNodeStereotypeEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5121); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getInputPin_3080Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.InputPin_3080, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(StructuredActivityNode_StructuredActivityNode_InputPinNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5081); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getOutputPin_3081Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.OutputPin_3081, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(StructuredActivityNode_StructuredActivityNode_OutputPinNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5083); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getSendSignalAction_3077Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.SendSignalAction_3077, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(ActivityPartition_SendSignalActionNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5080); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getLoopNode_3078Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.LoopNode_3078, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(ActivityPartition_LoopNodeNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5117); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getConditionalNode_3083Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.ConditionalNode_3083, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(ActivityPartition_ConditionalNodeNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5115); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getExpansionRegion_3085Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.ExpansionRegion_3085, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(ActivityPartition_ExpansionRegionModeEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5088); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getValueSpecificationAction_3088Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.ValueSpecificationAction_3088, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(ActivityPartition_ValueSpecificationActionNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5133); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getOutputPin_3090Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.OutputPin_3090, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(ValueSpecificationAction_OutputPinNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5137); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getLoopNode_3058Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.LoopNode_3058, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry.getType(LoopNodeNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5091); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getConditionalNode_3082Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.ConditionalNode_3082, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(ConditionalNodeNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5092); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getExpansionRegion_3084Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.ExpansionRegion_3084, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(ExpansionRegionModeEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5087); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getExpansionNode_3091Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.ExpansionNode_3091, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(ExpansionNodeNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5143); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getParameterSet_3086Text(View view) {
		ParameterSet domainModelElement = (ParameterSet) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3086); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getParameter_3087Text(View view) {
		Parameter domainModelElement = (Parameter) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3087); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getValueSpecificationAction_3089Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.ValueSpecificationAction_3089, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(ValueSpecificationActionNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5135); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getLiteralString_3049Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.LiteralString_3049, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(LocalPrecondition_LiteralStringEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 3049); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getLiteralString_3051Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.LiteralString_3051, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(LocalPostcondition_LiteralStringEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 3051); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getControlFlow_4001Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.ControlFlow_4001, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(ControlFlowNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getObjectFlow_4002Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.ObjectFlow_4002, view.getElement() != null ? view.getElement() : view, UMLVisualIDRegistry
				.getType(ObjectFlowNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6004); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getActionLocalPrecondition_4003Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getActionLocalPostcondition_4006Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getObjectNodeSelection_4004Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getExceptionHandler_4005Text(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.ExceptionHandler_4005, view.getElement() != null ? view.getElement() : view, CommonParserHint.DESCRIPTION);
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getUnknownElementText(View view) {
		return "<UnknownElement Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	private String getUnresolvedDomainElementProxyText(View view) {
		return "<Unresolved domain element Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	 * @generated
	 */
	public void restoreState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public void saveState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public String getDescription(Object anElement) {
		return null;
	}

	/**
	 * @generated
	 */
	private boolean isOwnView(View view) {
		return PackageEditPart.MODEL_ID.equals(UMLVisualIDRegistry.getModelID(view));
	}

}
