package org.eclipse.uml2.diagram.component.part;

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
import org.eclipse.uml2.diagram.component.providers.UMLElementTypes;

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
		paletteRoot.add(createChildren3Group());
	}

	/**
	 * Creates "Nodes" palette tool group
	 * @generated
	 */
	private PaletteContainer createNodes1Group() {
		PaletteGroup paletteContainer = new PaletteGroup(Messages.Nodes1Group_title);
		paletteContainer.setId("createNodes1Group"); //$NON-NLS-1$
		paletteContainer.setDescription(Messages.Nodes1Group_desc);
		paletteContainer.add(createComponent1CreationTool());
		paletteContainer.add(createArtifact2CreationTool());
		paletteContainer.add(createInterface3CreationTool());
		paletteContainer.add(createClass4CreationTool());
		paletteContainer.add(createPart5CreationTool());
		paletteContainer.add(createPackage6CreationTool());
		paletteContainer.add(createComment7CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Links" palette tool group
	 * @generated
	 */
	private PaletteContainer createLinks2Group() {
		PaletteGroup paletteContainer = new PaletteGroup(Messages.Links2Group_title);
		paletteContainer.setId("createLinks2Group"); //$NON-NLS-1$
		paletteContainer.setDescription(Messages.Links2Group_desc);
		paletteContainer.add(createProvidedInterface1CreationTool());
		paletteContainer.add(createRequiredInterface2CreationTool());
		paletteContainer.add(createDelegationConnector3CreationTool());
		paletteContainer.add(createDependency4CreationTool());
		paletteContainer.add(createAssemblyConnector5CreationTool());
		paletteContainer.add(createCreateAssociationLink6Group());
		paletteContainer.add(createAnnotatedElement7CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Children" palette tool group
	 * @generated
	 */
	private PaletteContainer createChildren3Group() {
		PaletteGroup paletteContainer = new PaletteGroup(Messages.Children3Group_title);
		paletteContainer.setId("createChildren3Group"); //$NON-NLS-1$
		paletteContainer.setDescription(Messages.Children3Group_desc);
		paletteContainer.add(createElementImport1CreationTool());
		paletteContainer.add(createAttribute2CreationTool());
		paletteContainer.add(createOperation3CreationTool());
		paletteContainer.add(createPort4CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Create Association Link" palette tool group
	 * @generated
	 */
	private PaletteContainer createCreateAssociationLink6Group() {
		PaletteStack paletteContainer = new PaletteStack(Messages.CreateAssociationLink6Group_title, null, null);
		paletteContainer.setId("createCreateAssociationLink6Group"); //$NON-NLS-1$
		paletteContainer.setDescription(Messages.CreateAssociationLink6Group_desc);
		paletteContainer.add(createAssociation1CreationTool());
		paletteContainer.add(createSharedAggregation2CreationTool());
		paletteContainer.add(createCompositeAggregation3CreationTool());
		paletteContainer.add(createNavigableAssociation4CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createComponent1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(3);
		types.add(UMLElementTypes.Component_2001);
		types.add(UMLElementTypes.Component_3001);
		types.add(UMLElementTypes.Component_3010);
		NodeToolEntry entry = new NodeToolEntry(Messages.Component1CreationTool_title, Messages.Component1CreationTool_desc, types);
		entry.setId("createComponent1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Component_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createArtifact2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(3);
		types.add(UMLElementTypes.Artifact_3003);
		types.add(UMLElementTypes.Artifact_3016);
		types.add(UMLElementTypes.Artifact_2002);
		NodeToolEntry entry = new NodeToolEntry(Messages.Artifact2CreationTool_title, Messages.Artifact2CreationTool_desc, types);
		entry.setId("createArtifact2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Artifact_3003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createInterface3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(UMLElementTypes.Interface_3005);
		types.add(UMLElementTypes.Interface_2003);
		NodeToolEntry entry = new NodeToolEntry(Messages.Interface3CreationTool_title, Messages.Interface3CreationTool_desc, types);
		entry.setId("createInterface3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Interface_3005));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createClass4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(4);
		types.add(UMLElementTypes.Class_3004);
		types.add(UMLElementTypes.Class_2004);
		types.add(UMLElementTypes.Class_3009);
		types.add(UMLElementTypes.Class_3013);
		NodeToolEntry entry = new NodeToolEntry(Messages.Class4CreationTool_title, Messages.Class4CreationTool_desc, types);
		entry.setId("createClass4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Class_3004));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createPart5CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Property_3006);
		NodeToolEntry entry = new NodeToolEntry(Messages.Part5CreationTool_title, Messages.Part5CreationTool_desc, types);
		entry.setId("createPart5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Property_3006));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createPackage6CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(UMLElementTypes.Package_2006);
		types.add(UMLElementTypes.Package_3008);
		NodeToolEntry entry = new NodeToolEntry(Messages.Package6CreationTool_title, Messages.Package6CreationTool_desc, types);
		entry.setId("createPackage6CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Package_2006));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createComment7CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Comment_2008);
		NodeToolEntry entry = new NodeToolEntry(Messages.Comment7CreationTool_title, Messages.Comment7CreationTool_desc, types);
		entry.setId("createComment7CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Comment_2008));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createProvidedInterface1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(UMLElementTypes.InterfaceRealization_4001);
		types.add(UMLElementTypes.PortProvided_4006);
		LinkToolEntry entry = new LinkToolEntry(Messages.ProvidedInterface1CreationTool_title, Messages.ProvidedInterface1CreationTool_desc, types);
		entry.setId("createProvidedInterface1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.InterfaceRealization_4001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createRequiredInterface2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(UMLElementTypes.PortRequired_4004);
		types.add(UMLElementTypes.ComponentRequired_4007);
		LinkToolEntry entry = new LinkToolEntry(Messages.RequiredInterface2CreationTool_title, Messages.RequiredInterface2CreationTool_desc, types);
		entry.setId("createRequiredInterface2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.PortRequired_4004));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createDelegationConnector3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Connector_4008);
		LinkToolEntry entry = new LinkToolEntry(Messages.DelegationConnector3CreationTool_title, Messages.DelegationConnector3CreationTool_desc, types);
		entry.setId("createDelegationConnector3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Connector_4008));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createDependency4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Dependency_4009);
		LinkToolEntry entry = new LinkToolEntry(Messages.Dependency4CreationTool_title, Messages.Dependency4CreationTool_desc, types);
		entry.setId("createDependency4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Dependency_4009));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAssemblyConnector5CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.ConnectorEndRole_4010);
		LinkToolEntry entry = new LinkToolEntry(Messages.AssemblyConnector5CreationTool_title, Messages.AssemblyConnector5CreationTool_desc, types);
		entry.setId("createAssemblyConnector5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.ConnectorEndRole_4010));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAnnotatedElement7CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.CommentAnnotatedElement_4012);
		LinkToolEntry entry = new LinkToolEntry(Messages.AnnotatedElement7CreationTool_title, Messages.AnnotatedElement7CreationTool_desc, types);
		entry.setId("createAnnotatedElement7CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.CommentAnnotatedElement_4012));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createElementImport1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.ElementImport_3007);
		NodeToolEntry entry = new NodeToolEntry(Messages.ElementImport1CreationTool_title, Messages.ElementImport1CreationTool_desc, types);
		entry.setId("createElementImport1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.ElementImport_3007));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAttribute2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Property_3011);
		NodeToolEntry entry = new NodeToolEntry(Messages.Attribute2CreationTool_title, Messages.Attribute2CreationTool_desc, types);
		entry.setId("createAttribute2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Property_3011));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createOperation3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Operation_3012);
		NodeToolEntry entry = new NodeToolEntry(Messages.Operation3CreationTool_title, Messages.Operation3CreationTool_desc, types);
		entry.setId("createOperation3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Operation_3012));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createPort4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(UMLElementTypes.Port_3002);
		types.add(UMLElementTypes.Port_3014);
		NodeToolEntry entry = new NodeToolEntry(Messages.Port4CreationTool_title, Messages.Port4CreationTool_desc, types);
		entry.setId("createPort4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Port_3002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAssociation1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Association_4011);
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
	private ToolEntry createSharedAggregation2CreationToolGen() {
		ToolEntry entry = new ToolEntry(Messages.SharedAggregation2CreationTool_title, Messages.SharedAggregation2CreationTool_desc, null, null) {
		};
		entry.setId("createSharedAggregation2CreationTool"); //$NON-NLS-1$
		entry.setToolClass(CreateAssociationLinkTool.SHARED.class);
		return entry;
	}

	/**
	 * @generated NOT
	 */
	private ToolEntry createSharedAggregation2CreationTool() {
		ToolEntry entry = createSharedAggregation2CreationToolGen();
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Association_4011));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createCompositeAggregation3CreationToolGen() {
		ToolEntry entry = new ToolEntry(Messages.CompositeAggregation3CreationTool_title, Messages.CompositeAggregation3CreationTool_desc, null, null) {
		};
		entry.setId("createCompositeAggregation3CreationTool"); //$NON-NLS-1$
		entry.setToolClass(CreateAssociationLinkTool.COMPOSITE.class);
		return entry;
	}

	/**
	 * @generated NOT
	 */
	private ToolEntry createCompositeAggregation3CreationTool() {
		ToolEntry entry = createCompositeAggregation3CreationToolGen();
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
