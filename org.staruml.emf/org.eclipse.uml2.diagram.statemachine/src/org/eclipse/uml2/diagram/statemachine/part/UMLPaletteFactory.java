package org.eclipse.uml2.diagram.statemachine.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.PaletteStack;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.uml2.diagram.common.part.LinkToolEntry;
import org.eclipse.uml2.diagram.common.part.NodeToolEntry;
import org.eclipse.uml2.diagram.statemachine.providers.UMLElementTypes;

/**
 * @generated
 */

public class UMLPaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createNodes1Group());
		paletteRoot.add(createLinks2Group());
	}

	/**
	 * Creates "Nodes" palette tool group
	 * @generated
	 */
	private PaletteContainer createNodes1Group() {
		PaletteGroup paletteContainer = new PaletteGroup(Messages.Nodes1Group_title);
		paletteContainer.setId("createNodes1Group"); //$NON-NLS-1$
		paletteContainer.add(createStateMachine1CreationTool());
		paletteContainer.add(createState2Group());
		paletteContainer.add(createRegion3CreationTool());
		paletteContainer.add(createFinalState4CreationTool());
		paletteContainer.add(createInitial5CreationTool());
		paletteContainer.add(createShallowHistory6CreationTool());
		paletteContainer.add(createDeepHistory7CreationTool());
		paletteContainer.add(createFork8CreationTool());
		paletteContainer.add(createJoin9CreationTool());
		paletteContainer.add(createJunction10CreationTool());
		paletteContainer.add(createChoice11CreationTool());
		paletteContainer.add(createTerminate12CreationTool());
		paletteContainer.add(createEntryPoint13CreationTool());
		paletteContainer.add(createExitPoint14CreationTool());
		paletteContainer.add(createEntryConnectionPointReference15CreationTool());
		paletteContainer.add(createExitConnectionPointReference16CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Links" palette tool group
	 * @generated
	 */
	private PaletteContainer createLinks2Group() {
		PaletteGroup paletteContainer = new PaletteGroup(Messages.Links2Group_title);
		paletteContainer.setId("createLinks2Group"); //$NON-NLS-1$
		paletteContainer.add(createTransition1CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "State" palette tool group
	 * @generated
	 */
	private PaletteContainer createState2Group() {
		PaletteStack paletteContainer = new PaletteStack(Messages.State2Group_title, null, null);
		paletteContainer.setId("createState2Group"); //$NON-NLS-1$
		paletteContainer.setDescription(Messages.State2Group_desc);
		paletteContainer.add(createSimpleState1CreationTool());
		paletteContainer.add(createCompositeState2CreationTool());
		paletteContainer.add(createSubmachineState3CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createStateMachine1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.StateMachine_2005);
		NodeToolEntry entry = new NodeToolEntry(Messages.StateMachine1CreationTool_title, Messages.StateMachine1CreationTool_desc, types);
		entry.setId("createStateMachine1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.StateMachine_2005));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createRegion3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(UMLElementTypes.Region_3013);
		types.add(UMLElementTypes.Region_3002);
		NodeToolEntry entry = new NodeToolEntry(Messages.Region3CreationTool_title, Messages.Region3CreationTool_desc, types);
		entry.setId("createRegion3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Region_3013));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createFinalState4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.FinalState_3003);
		NodeToolEntry entry = new NodeToolEntry(Messages.FinalState4CreationTool_title, Messages.FinalState4CreationTool_desc, types);
		entry.setId("createFinalState4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.FinalState_3003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createInitial5CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Pseudostate_3004);
		NodeToolEntry entry = new NodeToolEntry(Messages.Initial5CreationTool_title, Messages.Initial5CreationTool_desc, types);
		entry.setId("createInitial5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Pseudostate_3004));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createShallowHistory6CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Pseudostate_3005);
		NodeToolEntry entry = new NodeToolEntry(Messages.ShallowHistory6CreationTool_title, Messages.ShallowHistory6CreationTool_desc, types);
		entry.setId("createShallowHistory6CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Pseudostate_3005));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createDeepHistory7CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Pseudostate_3006);
		NodeToolEntry entry = new NodeToolEntry(Messages.DeepHistory7CreationTool_title, Messages.DeepHistory7CreationTool_desc, types);
		entry.setId("createDeepHistory7CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Pseudostate_3006));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createFork8CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Pseudostate_3007);
		NodeToolEntry entry = new NodeToolEntry(Messages.Fork8CreationTool_title, Messages.Fork8CreationTool_desc, types);
		entry.setId("createFork8CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Pseudostate_3007));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createJoin9CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Pseudostate_3008);
		NodeToolEntry entry = new NodeToolEntry(Messages.Join9CreationTool_title, Messages.Join9CreationTool_desc, types);
		entry.setId("createJoin9CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Pseudostate_3008));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createJunction10CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Pseudostate_3009);
		NodeToolEntry entry = new NodeToolEntry(Messages.Junction10CreationTool_title, Messages.Junction10CreationTool_desc, types);
		entry.setId("createJunction10CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Pseudostate_3009));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createChoice11CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Pseudostate_3010);
		NodeToolEntry entry = new NodeToolEntry(Messages.Choice11CreationTool_title, Messages.Choice11CreationTool_desc, types);
		entry.setId("createChoice11CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Pseudostate_3010));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createTerminate12CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Pseudostate_3011);
		NodeToolEntry entry = new NodeToolEntry(Messages.Terminate12CreationTool_title, Messages.Terminate12CreationTool_desc, types);
		entry.setId("createTerminate12CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Pseudostate_3011));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEntryPoint13CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Pseudostate_3014);
		NodeToolEntry entry = new NodeToolEntry(Messages.EntryPoint13CreationTool_title, Messages.EntryPoint13CreationTool_desc, types);
		entry.setId("createEntryPoint13CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLDiagramEditorPlugin.findImageDescriptor("/org.eclipse.uml2.uml.edit/icons/full/obj16/Pseudostate_entryPoint.gif")); //$NON-NLS-1$
		entry.setLargeIcon(UMLDiagramEditorPlugin.findImageDescriptor("/org.eclipse.uml2.uml.edit/icons/full/obj16/Pseudostate_entryPoint.gif")); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createExitPoint14CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Pseudostate_3015);
		NodeToolEntry entry = new NodeToolEntry(Messages.ExitPoint14CreationTool_title, Messages.ExitPoint14CreationTool_desc, types);
		entry.setId("createExitPoint14CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLDiagramEditorPlugin.findImageDescriptor("/org.eclipse.uml2.uml.edit/icons/full/obj16/Pseudostate_exitPoint.gif")); //$NON-NLS-1$
		entry.setLargeIcon(UMLDiagramEditorPlugin.findImageDescriptor("/org.eclipse.uml2.uml.edit/icons/full/obj16/Pseudostate_exitPoint.gif")); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEntryConnectionPointReference15CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.ConnectionPointReference_3017);
		NodeToolEntry entry = new NodeToolEntry(Messages.EntryConnectionPointReference15CreationTool_title, Messages.EntryConnectionPointReference15CreationTool_desc, types);
		entry.setId("createEntryConnectionPointReference15CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.ConnectionPointReference_3017));
		entry.setLargeIcon(entry.getSmallIcon());
		entry.setToolClass(CreateEntryConnectionPointReferenceTool.class);
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createExitConnectionPointReference16CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.ConnectionPointReference_3018);
		NodeToolEntry entry = new NodeToolEntry(Messages.ExitConnectionPointReference16CreationTool_title, Messages.ExitConnectionPointReference16CreationTool_desc, types);
		entry.setId("createExitConnectionPointReference16CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.ConnectionPointReference_3018));
		entry.setLargeIcon(entry.getSmallIcon());
		entry.setToolClass(CreateExitConnectionPointReferenceTool.class);
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createTransition1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Transition_4001);
		LinkToolEntry entry = new LinkToolEntry(Messages.Transition1CreationTool_title, Messages.Transition1CreationTool_desc, types);
		entry.setId("createTransition1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Transition_4001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSimpleState1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.State_3001);
		NodeToolEntry entry = new NodeToolEntry(Messages.SimpleState1CreationTool_title, Messages.SimpleState1CreationTool_desc, types);
		entry.setId("createSimpleState1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.State_3001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createCompositeState2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.State_3012);
		NodeToolEntry entry = new NodeToolEntry(Messages.CompositeState2CreationTool_title, Messages.CompositeState2CreationTool_desc, types);
		entry.setId("createCompositeState2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.State_3012));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSubmachineState3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.State_3016);
		NodeToolEntry entry = new NodeToolEntry(Messages.SubmachineState3CreationTool_title, Messages.SubmachineState3CreationTool_desc, types);
		entry.setId("createSubmachineState3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.State_3016));
		entry.setLargeIcon(entry.getSmallIcon());
		entry.setToolClass(CreateSubmachineStateTool.class);
		return entry;
	}

}
