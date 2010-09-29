package org.eclipse.uml2.diagram.deploy.part;

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
import org.eclipse.uml2.diagram.deploy.providers.UMLElementTypes;

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
		paletteContainer.add(createArtifact1CreationTool());
		paletteContainer.add(createDevice2CreationTool());
		paletteContainer.add(createNode3CreationTool());
		paletteContainer.add(createEnvironment4CreationTool());
		paletteContainer.add(createSpecification5CreationTool());
		paletteContainer.add(createComment6CreationTool());
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
		paletteContainer.add(createManifestation1CreationTool());
		paletteContainer.add(createDeployment2CreationTool());
		paletteContainer.add(createSpecificationLink3CreationTool());
		paletteContainer.add(createCommunicationPath4CreationTool());
		paletteContainer.add(createDependency5CreationTool());
		paletteContainer.add(createAnnotatedElement6CreationTool());
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
		paletteContainer.add(createProperty2CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createArtifact1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(4);
		types.add(UMLElementTypes.Artifact_3002);
		types.add(UMLElementTypes.Artifact_3008);
		types.add(UMLElementTypes.Artifact_3006);
		types.add(UMLElementTypes.Artifact_2006);
		NodeToolEntry entry = new NodeToolEntry(Messages.Artifact1CreationTool_title, Messages.Artifact1CreationTool_desc, types);
		entry.setId("createArtifact1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Artifact_3002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createDevice2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(UMLElementTypes.Device_2003);
		types.add(UMLElementTypes.Device_3004);
		NodeToolEntry entry = new NodeToolEntry(Messages.Device2CreationTool_title, Messages.Device2CreationTool_desc, types);
		entry.setId("createDevice2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Device_2003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createNode3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(UMLElementTypes.Node_3007);
		types.add(UMLElementTypes.Node_2004);
		NodeToolEntry entry = new NodeToolEntry(Messages.Node3CreationTool_title, Messages.Node3CreationTool_desc, types);
		entry.setId("createNode3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Node_3007));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEnvironment4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(UMLElementTypes.ExecutionEnvironment_3005);
		types.add(UMLElementTypes.ExecutionEnvironment_2005);
		NodeToolEntry entry = new NodeToolEntry(Messages.Environment4CreationTool_title, Messages.Environment4CreationTool_desc, types);
		entry.setId("createEnvironment4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.ExecutionEnvironment_3005));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSpecification5CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(UMLElementTypes.DeploymentSpecification_3009);
		types.add(UMLElementTypes.DeploymentSpecification_2007);
		NodeToolEntry entry = new NodeToolEntry(Messages.Specification5CreationTool_title, Messages.Specification5CreationTool_desc, types);
		entry.setId("createSpecification5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.DeploymentSpecification_3009));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createComment6CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Comment_2008);
		NodeToolEntry entry = new NodeToolEntry(Messages.Comment6CreationTool_title, Messages.Comment6CreationTool_desc, types);
		entry.setId("createComment6CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Comment_2008));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createManifestation1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Manifestation_4002);
		LinkToolEntry entry = new LinkToolEntry(Messages.Manifestation1CreationTool_title, Messages.Manifestation1CreationTool_desc, types);
		entry.setId("createManifestation1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Manifestation_4002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createDeployment2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Deployment_4001);
		LinkToolEntry entry = new LinkToolEntry(Messages.Deployment2CreationTool_title, Messages.Deployment2CreationTool_desc, types);
		entry.setId("createDeployment2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Deployment_4001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSpecificationLink3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.DeploymentConfiguration_4003);
		LinkToolEntry entry = new LinkToolEntry(Messages.SpecificationLink3CreationTool_title, Messages.SpecificationLink3CreationTool_desc, types);
		entry.setId("createSpecificationLink3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.DeploymentConfiguration_4003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createCommunicationPath4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.CommunicationPath_4004);
		LinkToolEntry entry = new LinkToolEntry(Messages.CommunicationPath4CreationTool_title, Messages.CommunicationPath4CreationTool_desc, types);
		entry.setId("createCommunicationPath4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.CommunicationPath_4004));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createDependency5CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Dependency_4005);
		LinkToolEntry entry = new LinkToolEntry(Messages.Dependency5CreationTool_title, Messages.Dependency5CreationTool_desc, types);
		entry.setId("createDependency5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Dependency_4005));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAnnotatedElement6CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.CommentAnnotatedElement_4006);
		LinkToolEntry entry = new LinkToolEntry(Messages.AnnotatedElement6CreationTool_title, Messages.AnnotatedElement6CreationTool_desc, types);
		entry.setId("createAnnotatedElement6CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.CommentAnnotatedElement_4006));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createElementImport1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.ElementImport_3001);
		NodeToolEntry entry = new NodeToolEntry(Messages.ElementImport1CreationTool_title, Messages.ElementImport1CreationTool_desc, types);
		entry.setId("createElementImport1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.ElementImport_3001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createProperty2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Property_3003);
		NodeToolEntry entry = new NodeToolEntry(Messages.Property2CreationTool_title, Messages.Property2CreationTool_desc, types);
		entry.setId("createProperty2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Property_3003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}
}
