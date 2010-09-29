package org.eclipse.uml2.diagram.sequence.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;
import org.eclipse.uml2.diagram.common.part.LinkToolEntry;
import org.eclipse.uml2.diagram.common.part.NodeToolEntry;
import org.eclipse.uml2.diagram.sequence.edit.create.CreateCombinedFragmentTool;
import org.eclipse.uml2.diagram.sequence.edit.create.CreateInteractionUseTool;
import org.eclipse.uml2.diagram.sequence.edit.create.CreateLifeLineTool;
import org.eclipse.uml2.diagram.sequence.edit.create.CreateStateInvariantTool;
import org.eclipse.uml2.diagram.sequence.providers.UMLElementTypes;

/**
 * XXX: generate custom tool from SD-Creation suite
 * @generated
 */
public class UMLPaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createElements1Group());
	}

	/**
	 * Creates "Elements" palette tool group
	 * @generated
	 */
	private PaletteContainer createElements1Group() {
		PaletteGroup paletteContainer = new PaletteGroup(Messages.Elements1Group_title);
		paletteContainer.setId("createElements1Group"); //$NON-NLS-1$
		paletteContainer.setDescription(Messages.Elements1Group_desc);
		paletteContainer.add(createInteraction1CreationTool());
		paletteContainer.add(createLifeline2CreationTool());
		paletteContainer.add(createMessage3CreationTool());
		paletteContainer.add(createStateInvariant4CreationTool());
		paletteContainer.add(createActionExecution5CreationTool());
		paletteContainer.add(createInteractionUse6CreationTool());
		paletteContainer.add(createCombinedFragment7CreationTool());
		paletteContainer.add(createGate8CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createInteraction1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Interaction_2001);
		NodeToolEntry entry = new NodeToolEntry(Messages.Interaction1CreationTool_title, Messages.Interaction1CreationTool_desc, types);
		entry.setId("createInteraction1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Interaction_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated NOT
	 */
	private ToolEntry createLifeline2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Lifeline_3001);
		NodeToolEntry entry = new NodeToolEntry(Messages.Lifeline2CreationTool_title, Messages.Lifeline2CreationTool_desc, types) {

			@Override
			public Tool createTool() {
				Tool result = new CreateLifeLineTool();
				result.setProperties(getToolProperties());
				return result;
			}
		};
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Lifeline_3001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createMessage3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Message_4001);
		LinkToolEntry entry = new LinkToolEntry(Messages.Message3CreationTool_title, Messages.Message3CreationTool_desc, types);
		entry.setId("createMessage3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Message_4001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated NOT
	 */
	private ToolEntry createStateInvariant4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.StateInvariant_3003);
		NodeToolEntry entry = new NodeToolEntry(Messages.StateInvariant4CreationTool_title, Messages.StateInvariant4CreationTool_desc, types) {

			@Override
			public Tool createTool() {
				Tool result = new CreateStateInvariantTool();
				result.setProperties(getToolProperties());
				return result;
			}
		};

		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.StateInvariant_3003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createActionExecution5CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.ActionExecutionSpecification_3002);
		NodeToolEntry entry = new NodeToolEntry(Messages.ActionExecution5CreationTool_title, Messages.ActionExecution5CreationTool_desc, types);
		entry.setId("createActionExecution5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.ActionExecutionSpecification_3002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createGate8CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Gate_3005);
		NodeToolEntry entry = new NodeToolEntry(Messages.Gate8CreationTool_title, Messages.Gate8CreationTool_desc, types);
		entry.setId("createGate8CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Gate_3005));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated NOT
	 */
	private ToolEntry createInteractionUse6CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.InteractionUse_3007);
		NodeToolEntry entry = new NodeToolEntry(Messages.InteractionUse6CreationTool_title, Messages.InteractionUse6CreationTool_desc, types) {

			@Override
			public Tool createTool() {
				Tool result = new CreateInteractionUseTool();
				result.setProperties(getToolProperties());
				return result;
			}
		};
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.InteractionUse_3007));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated NOT
	 */
	private ToolEntry createCombinedFragment7CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.CombinedFragment_3008);
		NodeToolEntry entry = new NodeToolEntry(Messages.CombinedFragment7CreationTool_title, Messages.CombinedFragment7CreationTool_desc, types) {

			public Tool createTool() {
				Tool result = new CreateCombinedFragmentTool();
				result.setProperties(getToolProperties());
				return result;
			}
		};
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.CombinedFragment_3008));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}
}
