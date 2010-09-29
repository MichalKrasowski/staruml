package org.eclipse.uml2.diagram.csd.part;

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
import org.eclipse.uml2.diagram.common.part.LinkToolEntry;
import org.eclipse.uml2.diagram.common.part.NodeToolEntry;
import org.eclipse.uml2.diagram.csd.providers.UMLElementTypes;

/**
 * @generated
 */
public class UMLPaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createNodes1Group());
		paletteRoot.add(createChildren2Group());
		paletteRoot.add(createLinks3Group());
	}

	/**
	 * Creates "Nodes" palette tool group
	 * @generated
	 */
	private PaletteContainer createNodes1Group() {
		PaletteGroup paletteContainer = new PaletteGroup(Messages.Nodes1Group_title);
		paletteContainer.setId("createNodes1Group"); //$NON-NLS-1$
		paletteContainer.setDescription(Messages.Nodes1Group_desc);
		paletteContainer.add(createCollaboration1CreationTool());
		paletteContainer.add(createClass2CreationTool());
		paletteContainer.add(createInterface3CreationTool());
		paletteContainer.add(createInstanceSpecification4CreationTool());
		paletteContainer.add(createConstraint5CreationTool());
		paletteContainer.add(createComment6CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Children" palette tool group
	 * @generated
	 */
	private PaletteContainer createChildren2Group() {
		PaletteGroup paletteContainer = new PaletteGroup(Messages.Children2Group_title);
		paletteContainer.setId("createChildren2Group"); //$NON-NLS-1$
		paletteContainer.setDescription(Messages.Children2Group_desc);
		paletteContainer.add(createElementImport1CreationTool());
		paletteContainer.add(createAttribute2CreationTool());
		paletteContainer.add(createOperation3CreationTool());
		paletteContainer.add(createPort4CreationTool());
		paletteContainer.add(createCollaborationUse5CreationTool());
		paletteContainer.add(createSlot6CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Links" palette tool group
	 * @generated
	 */
	private PaletteContainer createLinks3Group() {
		PaletteGroup paletteContainer = new PaletteGroup(Messages.Links3Group_title);
		paletteContainer.setId("createLinks3Group"); //$NON-NLS-1$
		paletteContainer.setDescription(Messages.Links3Group_desc);
		paletteContainer.add(createConnector1CreationTool());
		paletteContainer.add(createRoleBinding2CreationTool());
		paletteContainer.add(createProvidedInterface3CreationTool());
		paletteContainer.add(createRequiredInterface4CreationTool());
		paletteContainer.add(createAssociation5Group());
		paletteContainer.add(createConstrainedElement6CreationTool());
		paletteContainer.add(createAnnotatedElement7CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Association" palette tool group
	 * @generated
	 */
	private PaletteContainer createAssociation5Group() {
		PaletteStack paletteContainer = new PaletteStack(Messages.Association5Group_title, null, null);
		paletteContainer.setId("createAssociation5Group"); //$NON-NLS-1$
		paletteContainer.setDescription(Messages.Association5Group_desc);
		paletteContainer.add(createAssociation1CreationTool());
		paletteContainer.add(createSharedAssociation2CreationTool());
		paletteContainer.add(createCompositeAssociation3CreationTool());
		paletteContainer.add(createNavigableAssociation4CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createElementImport1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.ElementImport_3004);
		NodeToolEntry entry = new NodeToolEntry(Messages.ElementImport1CreationTool_title, Messages.ElementImport1CreationTool_desc, types);
		entry.setId("createElementImport1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.ElementImport_3004));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAttribute2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(3);
		types.add(UMLElementTypes.Property_3007);
		types.add(UMLElementTypes.Property_3008);
		types.add(UMLElementTypes.Property_3014);
		NodeToolEntry entry = new NodeToolEntry(Messages.Attribute2CreationTool_title, Messages.Attribute2CreationTool_desc, types);
		entry.setId("createAttribute2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Property_3007));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createOperation3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Operation_3009);
		NodeToolEntry entry = new NodeToolEntry(Messages.Operation3CreationTool_title, Messages.Operation3CreationTool_desc, types);
		entry.setId("createOperation3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Operation_3009));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createPort4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(UMLElementTypes.Port_3011);
		types.add(UMLElementTypes.Port_3017);
		NodeToolEntry entry = new NodeToolEntry(Messages.Port4CreationTool_title, Messages.Port4CreationTool_desc, types);
		entry.setId("createPort4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Port_3011));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createCollaborationUse5CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.CollaborationUse_3002);
		NodeToolEntry entry = new NodeToolEntry(Messages.CollaborationUse5CreationTool_title, Messages.CollaborationUse5CreationTool_desc, types);
		entry.setId("createCollaborationUse5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.CollaborationUse_3002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSlot6CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Slot_3015);
		NodeToolEntry entry = new NodeToolEntry(Messages.Slot6CreationTool_title, Messages.Slot6CreationTool_desc, types);
		entry.setId("createSlot6CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Slot_3015));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createCollaboration1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Collaboration_2005);
		NodeToolEntry entry = new NodeToolEntry(Messages.Collaboration1CreationTool_title, Messages.Collaboration1CreationTool_desc, types);
		entry.setId("createCollaboration1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Collaboration_2005));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createClass2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(UMLElementTypes.Class_2006);
		types.add(UMLElementTypes.Class_3010);
		NodeToolEntry entry = new NodeToolEntry(Messages.Class2CreationTool_title, Messages.Class2CreationTool_desc, types);
		entry.setId("createClass2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Class_2006));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createInterface3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Interface_2009);
		NodeToolEntry entry = new NodeToolEntry(Messages.Interface3CreationTool_title, Messages.Interface3CreationTool_desc, types);
		entry.setId("createInterface3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Interface_2009));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createInstanceSpecification4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.InstanceSpecification_2011);
		NodeToolEntry entry = new NodeToolEntry(Messages.InstanceSpecification4CreationTool_title, Messages.InstanceSpecification4CreationTool_desc, types);
		entry.setId("createInstanceSpecification4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.InstanceSpecification_2011));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createConstraint5CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Constraint_2012);
		NodeToolEntry entry = new NodeToolEntry(Messages.Constraint5CreationTool_title, Messages.Constraint5CreationTool_desc, types);
		entry.setId("createConstraint5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Constraint_2012));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createComment6CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Comment_2013);
		NodeToolEntry entry = new NodeToolEntry(Messages.Comment6CreationTool_title, Messages.Comment6CreationTool_desc, types);
		entry.setId("createComment6CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Comment_2013));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createConnector1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Connector_4005);
		LinkToolEntry entry = new LinkToolEntry(Messages.Connector1CreationTool_title, Messages.Connector1CreationTool_desc, types);
		entry.setId("createConnector1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Connector_4005));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createRoleBinding2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Dependency_4006);
		LinkToolEntry entry = new LinkToolEntry(Messages.RoleBinding2CreationTool_title, Messages.RoleBinding2CreationTool_desc, types);
		entry.setId("createRoleBinding2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Dependency_4006));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createProvidedInterface3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(UMLElementTypes.InterfaceRealization_4007);
		types.add(UMLElementTypes.PortProvided_4010);
		LinkToolEntry entry = new LinkToolEntry(Messages.ProvidedInterface3CreationTool_title, Messages.ProvidedInterface3CreationTool_desc, types);
		entry.setId("createProvidedInterface3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.InterfaceRealization_4007));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createRequiredInterface4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(UMLElementTypes.Usage_4008);
		types.add(UMLElementTypes.PortRequired_4014);
		LinkToolEntry entry = new LinkToolEntry(Messages.RequiredInterface4CreationTool_title, Messages.RequiredInterface4CreationTool_desc, types);
		entry.setId("createRequiredInterface4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Usage_4008));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createConstrainedElement6CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.ConstraintConstrainedElement_4012);
		LinkToolEntry entry = new LinkToolEntry(Messages.ConstrainedElement6CreationTool_title, Messages.ConstrainedElement6CreationTool_desc, types);
		entry.setId("createConstrainedElement6CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.ConstraintConstrainedElement_4012));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAnnotatedElement7CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.CommentAnnotatedElement_4016);
		LinkToolEntry entry = new LinkToolEntry(Messages.AnnotatedElement7CreationTool_title, Messages.AnnotatedElement7CreationTool_desc, types);
		entry.setId("createAnnotatedElement7CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.CommentAnnotatedElement_4016));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAssociation1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(UMLElementTypes.Association_4011);
		types.add(UMLElementTypes.Slot_4015);
		LinkToolEntry entry = new LinkToolEntry(Messages.Association1CreationTool_title, Messages.Association1CreationTool_desc, types);
		entry.setId("createAssociation1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Association_4011));
		entry.setLargeIcon(entry.getSmallIcon());
		entry.setToolClass(CreateAssociationLinkTool.NONE.class);
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSharedAssociation2CreationToolGen() {
		ToolEntry entry = new ToolEntry(Messages.SharedAssociation2CreationTool_title, Messages.SharedAssociation2CreationTool_desc, null, null) {
		};
		entry.setId("createSharedAssociation2CreationTool"); //$NON-NLS-1$
		entry.setToolClass(CreateAssociationLinkTool.SHARED.class);
		return entry;
	}

	/**
	 * @generated NOT
	 */
	private ToolEntry createSharedAssociation2CreationTool() {
		ToolEntry entry = createSharedAssociation2CreationToolGen();
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Association_4011));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createCompositeAssociation3CreationToolGen() {
		ToolEntry entry = new ToolEntry(Messages.CompositeAssociation3CreationTool_title, Messages.CompositeAssociation3CreationTool_desc, null, null) {
		};
		entry.setId("createCompositeAssociation3CreationTool"); //$NON-NLS-1$
		entry.setToolClass(CreateAssociationLinkTool.COMPOSITE.class);
		return entry;
	}

	/**
	 * @generated NOT
	 */
	private ToolEntry createCompositeAssociation3CreationTool() {
		ToolEntry entry = createCompositeAssociation3CreationToolGen();
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Association_4011));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createNavigableAssociation4CreationToolGen() {
		ToolEntry entry = new ToolEntry(Messages.NavigableAssociation4CreationTool_title, Messages.NavigableAssociation4CreationTool_desc, null, null) {
		};
		entry.setId("createNavigableAssociation4CreationTool"); //$NON-NLS-1$
		entry.setToolClass(CreateAssociationLinkTool.NAVIGABLE.class);
		return entry;
	}

	/**
	 * @generated NOT
	 */
	private ToolEntry createNavigableAssociation4CreationTool() {
		ToolEntry entry = createNavigableAssociation4CreationToolGen();
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Association_4011));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}
}
