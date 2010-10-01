package org.eclipse.uml2.diagram.activity.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.PaletteStack;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;
import org.eclipse.uml2.diagram.activity.providers.UMLElementTypes;
import org.eclipse.uml2.diagram.common.part.LinkToolEntry;
import org.eclipse.uml2.diagram.common.part.NodeToolEntry;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class UMLPaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createActivities1Group());
		paletteRoot.add(createActions2Group());
		paletteRoot.add(createControlNodes3Group());
		paletteRoot.add(createStructuredActivities4Group());
		paletteRoot.add(createObjects5Group());
		paletteRoot.add(createEdges6Group());
	}

	/**
	 * Creates "Activities" palette tool group
	 * @generated
	 */
	private PaletteContainer createActivities1Group() {
		PaletteGroup paletteContainer = new PaletteGroup(Messages.Activities1Group_title);
		paletteContainer.setId("createActivities1Group"); //$NON-NLS-1$
		paletteContainer.setDescription(Messages.Activities1Group_desc);
		paletteContainer.add(createActivity1CreationTool());
		paletteContainer.add(createParameterSet2CreationTool());
		paletteContainer.add(createParameter3CreationTool());
		paletteContainer.add(createActivityParameterNode4CreationTool());
		paletteContainer.add(createActivityPartition5CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Actions" palette tool group
	 * @generated
	 */
	private PaletteContainer createActions2Group() {
		PaletteGroup paletteContainer = new PaletteGroup(Messages.Actions2Group_title);
		paletteContainer.setId("createActions2Group"); //$NON-NLS-1$
		paletteContainer.setDescription(Messages.Actions2Group_desc);
		paletteContainer.add(createAcceptEventAction1Group());
		paletteContainer.add(createAddFeatureValueAction2CreationTool());
		paletteContainer.add(createCallBehaviorAction3CreationTool());
		paletteContainer.add(createCallOperationAction4CreationTool());
		paletteContainer.add(createCreateObjectAction5CreationTool());
		paletteContainer.add(createOpaqueAction6CreationTool());
		paletteContainer.add(createSendSignalAction7CreationTool());
		paletteContainer.add(createOpaqueBehavior8CreationTool());
		paletteContainer.add(createValueSpecificationAction9CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Control Nodes" palette tool group
	 * @generated
	 */
	private PaletteContainer createControlNodes3Group() {
		PaletteGroup paletteContainer = new PaletteGroup(Messages.ControlNodes3Group_title);
		paletteContainer.setId("createControlNodes3Group"); //$NON-NLS-1$
		paletteContainer.setDescription(Messages.ControlNodes3Group_desc);
		paletteContainer.add(createActivityInitialNode1CreationTool());
		paletteContainer.add(createActivityFinalNode2CreationTool());
		paletteContainer.add(createFlowFinalNode3CreationTool());
		paletteContainer.add(createMergeDecisionNode4Group());
		paletteContainer.add(createForkJoinNode5Group());
		return paletteContainer;
	}

	/**
	 * Creates "Structured Activities" palette tool group
	 * @generated
	 */
	private PaletteContainer createStructuredActivities4Group() {
		PaletteGroup paletteContainer = new PaletteGroup(Messages.StructuredActivities4Group_title);
		paletteContainer.setId("createStructuredActivities4Group"); //$NON-NLS-1$
		paletteContainer.setDescription(Messages.StructuredActivities4Group_desc);
		paletteContainer.add(createConditionalNode1CreationTool());
		paletteContainer.add(createExpansionRegion2CreationTool());
		paletteContainer.add(createLoopNode3CreationTool());
		paletteContainer.add(createStructuredActivityNode4CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Objects" palette tool group
	 * @generated
	 */
	private PaletteContainer createObjects5Group() {
		PaletteGroup paletteContainer = new PaletteGroup(Messages.Objects5Group_title);
		paletteContainer.setId("createObjects5Group"); //$NON-NLS-1$
		paletteContainer.setDescription(Messages.Objects5Group_desc);
		paletteContainer.add(createCentralBuffer1CreationTool());
		paletteContainer.add(createDatastore2CreationTool());
		paletteContainer.add(createExpansionNode3CreationTool());
		paletteContainer.add(createPin4Group());
		paletteContainer.add(createSelection5CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Edges" palette tool group
	 * @generated
	 */
	private PaletteContainer createEdges6Group() {
		PaletteGroup paletteContainer = new PaletteGroup(Messages.Edges6Group_title);
		paletteContainer.setId("createEdges6Group"); //$NON-NLS-1$
		paletteContainer.setDescription(Messages.Edges6Group_desc);
		paletteContainer.add(createControlFlow1CreationTool());
		paletteContainer.add(createObjectFlow2CreationTool());
		paletteContainer.add(createExceptionHandlerLink3CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Accept Event Action" palette tool group
	 * @generated
	 */
	private PaletteContainer createAcceptEventAction1Group() {
		PaletteStack paletteContainer = new PaletteStack(Messages.AcceptEventAction1Group_title, null, null);
		paletteContainer.setId("createAcceptEventAction1Group"); //$NON-NLS-1$
		paletteContainer.setDescription(Messages.AcceptEventAction1Group_desc);
		paletteContainer.add(createAcceptEventAction1CreationTool());
		paletteContainer.add(createAcceptTimeEventAction2CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Merge/Decision Node" palette tool group
	 * @generated
	 */
	private PaletteContainer createMergeDecisionNode4Group() {
		PaletteStack paletteContainer = new PaletteStack(Messages.MergeDecisionNode4Group_title, null, null);
		paletteContainer.setId("createMergeDecisionNode4Group"); //$NON-NLS-1$
		paletteContainer.setDescription(Messages.MergeDecisionNode4Group_desc);
		paletteContainer.add(createMergeNode1CreationTool());
		paletteContainer.add(createDecisionNode2CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Fork/Join Node" palette tool group
	 * @generated
	 */
	private PaletteContainer createForkJoinNode5Group() {
		PaletteStack paletteContainer = new PaletteStack(Messages.ForkJoinNode5Group_title, null, null);
		paletteContainer.setId("createForkJoinNode5Group"); //$NON-NLS-1$
		paletteContainer.setDescription(Messages.ForkJoinNode5Group_desc);
		paletteContainer.add(createForkNode1CreationTool());
		paletteContainer.add(createJoinNode2CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Pin" palette tool group
	 * @generated
	 */
	private PaletteContainer createPin4Group() {
		PaletteStack paletteContainer = new PaletteStack(Messages.Pin4Group_title, null, null);
		paletteContainer.setId("createPin4Group"); //$NON-NLS-1$
		paletteContainer.setDescription(Messages.Pin4Group_desc);
		paletteContainer.add(createPin1CreationTool());
		paletteContainer.add(createInputPin2CreationTool());
		paletteContainer.add(createOutputPin3CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createActivity1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Activity_2026);
		NodeToolEntry entry = new NodeToolEntry(Messages.Activity1CreationTool_title, Messages.Activity1CreationTool_desc, types);
		entry.setId("createActivity1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Activity_2026));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createParameterSet2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.ParameterSet_3086);
		NodeToolEntry entry = new NodeToolEntry(Messages.ParameterSet2CreationTool_title, Messages.ParameterSet2CreationTool_desc, types);
		entry.setId("createParameterSet2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.ParameterSet_3086));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createParameter3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Parameter_3087);
		NodeToolEntry entry = new NodeToolEntry(Messages.Parameter3CreationTool_title, Messages.Parameter3CreationTool_desc, types);
		entry.setId("createParameter3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Parameter_3087));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createActivityParameterNode4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.ActivityParameterNode_3052);
		NodeToolEntry entry = new NodeToolEntry(Messages.ActivityParameterNode4CreationTool_title, Messages.ActivityParameterNode4CreationTool_desc, types);
		entry.setId("createActivityParameterNode4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.ActivityParameterNode_3052));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createActivityPartition5CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(UMLElementTypes.ActivityPartition_3056);
		types.add(UMLElementTypes.ActivityPartition_3057);
		NodeToolEntry entry = new NodeToolEntry(Messages.ActivityPartition5CreationTool_title, Messages.ActivityPartition5CreationTool_desc, types);
		entry.setId("createActivityPartition5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.ActivityPartition_3056));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAddFeatureValueAction2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(3);
		types.add(UMLElementTypes.AddStructuralFeatureValueAction_3043);
		types.add(UMLElementTypes.AddStructuralFeatureValueAction_3023);
		types.add(UMLElementTypes.AddStructuralFeatureValueAction_3073);
		NodeToolEntry entry = new NodeToolEntry(Messages.AddFeatureValueAction2CreationTool_title, Messages.AddFeatureValueAction2CreationTool_desc, types);
		entry.setId("createAddFeatureValueAction2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.AddStructuralFeatureValueAction_3043));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createCallBehaviorAction3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(3);
		types.add(UMLElementTypes.CallBehaviorAction_3044);
		types.add(UMLElementTypes.CallBehaviorAction_3019);
		types.add(UMLElementTypes.CallBehaviorAction_3074);
		NodeToolEntry entry = new NodeToolEntry(Messages.CallBehaviorAction3CreationTool_title, Messages.CallBehaviorAction3CreationTool_desc, types);
		entry.setId("createCallBehaviorAction3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.CallBehaviorAction_3044));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createCallOperationAction4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(3);
		types.add(UMLElementTypes.CallOperationAction_3045);
		types.add(UMLElementTypes.CallOperationAction_3020);
		types.add(UMLElementTypes.CallOperationAction_3075);
		NodeToolEntry entry = new NodeToolEntry(Messages.CallOperationAction4CreationTool_title, Messages.CallOperationAction4CreationTool_desc, types);
		entry.setId("createCallOperationAction4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.CallOperationAction_3045));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createCreateObjectAction5CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(3);
		types.add(UMLElementTypes.CreateObjectAction_3042);
		types.add(UMLElementTypes.CreateObjectAction_3018);
		types.add(UMLElementTypes.CreateObjectAction_3072);
		NodeToolEntry entry = new NodeToolEntry(Messages.CreateObjectAction5CreationTool_title, Messages.CreateObjectAction5CreationTool_desc, types);
		entry.setId("createCreateObjectAction5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.CreateObjectAction_3042));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createOpaqueAction6CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(3);
		types.add(UMLElementTypes.OpaqueAction_3029);
		types.add(UMLElementTypes.OpaqueAction_3011);
		types.add(UMLElementTypes.OpaqueAction_3067);
		NodeToolEntry entry = new NodeToolEntry(Messages.OpaqueAction6CreationTool_title, Messages.OpaqueAction6CreationTool_desc, types);
		entry.setId("createOpaqueAction6CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.OpaqueAction_3029));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSendSignalAction7CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(UMLElementTypes.SendSignalAction_3053);
		types.add(UMLElementTypes.SendSignalAction_3077);
		NodeToolEntry entry = new NodeToolEntry(Messages.SendSignalAction7CreationTool_title, Messages.SendSignalAction7CreationTool_desc, types);
		entry.setId("createSendSignalAction7CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.SendSignalAction_3053));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createOpaqueBehavior8CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.OpaqueBehavior_3047);
		NodeToolEntry entry = new NodeToolEntry(Messages.OpaqueBehavior8CreationTool_title, Messages.OpaqueBehavior8CreationTool_desc, types);
		entry.setId("createOpaqueBehavior8CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.OpaqueBehavior_3047));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createValueSpecificationAction9CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(UMLElementTypes.ValueSpecificationAction_3088);
		types.add(UMLElementTypes.ValueSpecificationAction_3089);
		NodeToolEntry entry = new NodeToolEntry(Messages.ValueSpecificationAction9CreationTool_title, Messages.ValueSpecificationAction9CreationTool_desc, types);
		entry.setId("createValueSpecificationAction9CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.ValueSpecificationAction_3088));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createActivityInitialNode1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(3);
		types.add(UMLElementTypes.InitialNode_3035);
		types.add(UMLElementTypes.InitialNode_3093);
		types.add(UMLElementTypes.InitialNode_3064);
		NodeToolEntry entry = new NodeToolEntry(Messages.ActivityInitialNode1CreationTool_title, Messages.ActivityInitialNode1CreationTool_desc, types);
		entry.setId("createActivityInitialNode1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.InitialNode_3035));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createActivityFinalNode2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(3);
		types.add(UMLElementTypes.ActivityFinalNode_3032);
		types.add(UMLElementTypes.ActivityFinalNode_3014);
		types.add(UMLElementTypes.ActivityFinalNode_3061);
		NodeToolEntry entry = new NodeToolEntry(Messages.ActivityFinalNode2CreationTool_title, Messages.ActivityFinalNode2CreationTool_desc, types);
		entry.setId("createActivityFinalNode2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.ActivityFinalNode_3032));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAcceptEventAction1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(3);
		types.add(UMLElementTypes.AcceptEventAction_3030);
		types.add(UMLElementTypes.AcceptEventAction_3012);
		types.add(UMLElementTypes.AcceptEventAction_3059);
		NodeToolEntry entry = new NodeToolEntry(Messages.AcceptEventAction1CreationTool_title, Messages.AcceptEventAction1CreationTool_desc, types);
		entry.setId("createAcceptEventAction1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.AcceptEventAction_3030));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAcceptTimeEventAction2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(3);
		types.add(UMLElementTypes.AcceptEventAction_3031);
		types.add(UMLElementTypes.AcceptEventAction_3013);
		types.add(UMLElementTypes.AcceptEventAction_3060);
		NodeToolEntry entry = new NodeToolEntry(Messages.AcceptTimeEventAction2CreationTool_title, Messages.AcceptTimeEventAction2CreationTool_desc, types);
		entry.setId("createAcceptTimeEventAction2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.AcceptEventAction_3031));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createMergeNode1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(UMLElementTypes.MergeNode_3034);
		types.add(UMLElementTypes.MergeNode_3063);
		NodeToolEntry entry = new NodeToolEntry(Messages.MergeNode1CreationTool_title, Messages.MergeNode1CreationTool_desc, types);
		entry.setId("createMergeNode1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.MergeNode_3034));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createDecisionNode2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(3);
		types.add(UMLElementTypes.DecisionNode_3033);
		types.add(UMLElementTypes.DecisionNode_3015);
		types.add(UMLElementTypes.DecisionNode_3062);
		NodeToolEntry entry = new NodeToolEntry(Messages.DecisionNode2CreationTool_title, Messages.DecisionNode2CreationTool_desc, types);
		entry.setId("createDecisionNode2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.DecisionNode_3033));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createForkNode1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(3);
		types.add(UMLElementTypes.ForkNode_3039);
		types.add(UMLElementTypes.ForkNode_3021);
		types.add(UMLElementTypes.ForkNode_3069);
		NodeToolEntry entry = new NodeToolEntry(Messages.ForkNode1CreationTool_title, Messages.ForkNode1CreationTool_desc, types);
		entry.setId("createForkNode1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.ForkNode_3039));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createJoinNode2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(3);
		types.add(UMLElementTypes.JoinNode_3040);
		types.add(UMLElementTypes.JoinNode_3022);
		types.add(UMLElementTypes.JoinNode_3070);
		NodeToolEntry entry = new NodeToolEntry(Messages.JoinNode2CreationTool_title, Messages.JoinNode2CreationTool_desc, types);
		entry.setId("createJoinNode2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.JoinNode_3040));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createPin1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(3);
		types.add(UMLElementTypes.Pin_3041);
		types.add(UMLElementTypes.Pin_3017);
		types.add(UMLElementTypes.Pin_3071);
		NodeToolEntry entry = new NodeToolEntry(Messages.Pin1CreationTool_title, Messages.Pin1CreationTool_desc, types);
		entry.setId("createPin1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Pin_3041));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createInputPin2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(8);
		types.add(UMLElementTypes.InputPin_3094);
		types.add(UMLElementTypes.InputPin_3003);
		types.add(UMLElementTypes.InputPin_3004);
		types.add(UMLElementTypes.InputPin_3005);
		types.add(UMLElementTypes.InputPin_3007);
		types.add(UMLElementTypes.InputPin_3008);
		types.add(UMLElementTypes.InputPin_3054);
		types.add(UMLElementTypes.InputPin_3080);
		NodeToolEntry entry = new NodeToolEntry(Messages.InputPin2CreationTool_title, Messages.InputPin2CreationTool_desc, types);
		entry.setId("createInputPin2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.InputPin_3094));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createOutputPin3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(6);
		types.add(UMLElementTypes.OutputPin_3001);
		types.add(UMLElementTypes.OutputPin_3002);
		types.add(UMLElementTypes.OutputPin_3006);
		types.add(UMLElementTypes.OutputPin_3055);
		types.add(UMLElementTypes.OutputPin_3081);
		types.add(UMLElementTypes.OutputPin_3090);
		NodeToolEntry entry = new NodeToolEntry(Messages.OutputPin3CreationTool_title, Messages.OutputPin3CreationTool_desc, types);
		entry.setId("createOutputPin3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.OutputPin_3001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createFlowFinalNode3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(3);
		types.add(UMLElementTypes.FlowFinalNode_3038);
		types.add(UMLElementTypes.FlowFinalNode_3016);
		types.add(UMLElementTypes.FlowFinalNode_3068);
		NodeToolEntry entry = new NodeToolEntry(Messages.FlowFinalNode3CreationTool_title, Messages.FlowFinalNode3CreationTool_desc, types);
		entry.setId("createFlowFinalNode3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.FlowFinalNode_3038));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createConditionalNode1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(3);
		types.add(UMLElementTypes.ConditionalNode_3092);
		types.add(UMLElementTypes.ConditionalNode_3083);
		types.add(UMLElementTypes.ConditionalNode_3082);
		NodeToolEntry entry = new NodeToolEntry(Messages.ConditionalNode1CreationTool_title, Messages.ConditionalNode1CreationTool_desc, types);
		entry.setId("createConditionalNode1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.ConditionalNode_3092));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createExpansionRegion2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(UMLElementTypes.ExpansionRegion_3085);
		types.add(UMLElementTypes.ExpansionRegion_3084);
		NodeToolEntry entry = new NodeToolEntry(Messages.ExpansionRegion2CreationTool_title, Messages.ExpansionRegion2CreationTool_desc, types);
		entry.setId("createExpansionRegion2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.ExpansionRegion_3085));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createLoopNode3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(UMLElementTypes.LoopNode_3078);
		types.add(UMLElementTypes.LoopNode_3058);
		NodeToolEntry entry = new NodeToolEntry(Messages.LoopNode3CreationTool_title, Messages.LoopNode3CreationTool_desc, types);
		entry.setId("createLoopNode3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.LoopNode_3078));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createStructuredActivityNode4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(4);
		types.add(UMLElementTypes.StructuredActivityNode_3046);
		types.add(UMLElementTypes.StructuredActivityNode_3009);
		types.add(UMLElementTypes.StructuredActivityNode_3076);
		types.add(UMLElementTypes.StructuredActivityNode_3079);
		NodeToolEntry entry = new NodeToolEntry(Messages.StructuredActivityNode4CreationTool_title, Messages.StructuredActivityNode4CreationTool_desc, types);
		entry.setId("createStructuredActivityNode4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.StructuredActivityNode_3046));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createCentralBuffer1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(3);
		types.add(UMLElementTypes.CentralBufferNode_3037);
		types.add(UMLElementTypes.CentralBufferNode_3025);
		types.add(UMLElementTypes.CentralBufferNode_3066);
		NodeToolEntry entry = new NodeToolEntry(Messages.CentralBuffer1CreationTool_title, Messages.CentralBuffer1CreationTool_desc, types);
		entry.setId("createCentralBuffer1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.CentralBufferNode_3037));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createDatastore2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(3);
		types.add(UMLElementTypes.DataStoreNode_3036);
		types.add(UMLElementTypes.DataStoreNode_3024);
		types.add(UMLElementTypes.DataStoreNode_3065);
		NodeToolEntry entry = new NodeToolEntry(Messages.Datastore2CreationTool_title, Messages.Datastore2CreationTool_desc, types);
		entry.setId("createDatastore2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.DataStoreNode_3036));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createExpansionNode3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.ExpansionNode_3091);
		NodeToolEntry entry = new NodeToolEntry(Messages.ExpansionNode3CreationTool_title, Messages.ExpansionNode3CreationTool_desc, types);
		entry.setId("createExpansionNode3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.ExpansionNode_3091));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSelection5CreationToolGen() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.ObjectNodeSelection_4004);
		LinkToolEntry entry = new LinkToolEntry(Messages.Selection5CreationTool_title, Messages.Selection5CreationTool_desc, types);
		entry.setId("createSelection5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.ObjectNodeSelection_4004));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated NOT
	 */
	private ToolEntry createSelection5CreationTool() {
		ToolEntry entry = createSelection5CreationToolGen();
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLPackage.eINSTANCE.getStateMachine()));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createControlFlow1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.ControlFlow_4001);
		LinkToolEntry entry = new LinkToolEntry(Messages.ControlFlow1CreationTool_title, Messages.ControlFlow1CreationTool_desc, types);
		entry.setId("createControlFlow1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.ControlFlow_4001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createObjectFlow2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.ObjectFlow_4002);
		LinkToolEntry entry = new LinkToolEntry(Messages.ObjectFlow2CreationTool_title, Messages.ObjectFlow2CreationTool_desc, types);
		entry.setId("createObjectFlow2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.ObjectFlow_4002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createExceptionHandlerLink3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.ExceptionHandler_4005);
		LinkToolEntry entry = new LinkToolEntry(Messages.ExceptionHandlerLink3CreationTool_title, null, types);
		entry.setId("createExceptionHandlerLink3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.ExceptionHandler_4005));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}
}
