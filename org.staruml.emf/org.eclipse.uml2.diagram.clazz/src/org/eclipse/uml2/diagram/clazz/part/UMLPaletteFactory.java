package org.eclipse.uml2.diagram.clazz.part;

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
import org.eclipse.uml2.diagram.clazz.providers.UMLElementTypes;
import org.eclipse.uml2.diagram.common.part.LinkToolEntry;
import org.eclipse.uml2.diagram.common.part.NodeToolEntry;

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
		paletteRoot.add(createInstances4Group());
	}

	/**
	 * Creates "Nodes" palette tool group
	 * @generated
	 */
	private PaletteContainer createNodes1Group() {
		PaletteGroup paletteContainer = new PaletteGroup(Messages.Nodes1Group_title);
		paletteContainer.setId("createNodes1Group"); //$NON-NLS-1$
		paletteContainer.setDescription(Messages.Nodes1Group_desc);
		paletteContainer.add(createClass1CreationTool());
		paletteContainer.add(createPackage2CreationTool());
		paletteContainer.add(createEnumeration3CreationTool());
		paletteContainer.add(createDataType4CreationTool());
		paletteContainer.add(createPrimitiveType5CreationTool());
		paletteContainer.add(createConstraint6CreationTool());
		paletteContainer.add(createAssociationClass7CreationTool());
		paletteContainer.add(createInterface8CreationTool());
		paletteContainer.add(createComment9CreationTool());
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
		paletteContainer.add(createAttribute1CreationTool());
		paletteContainer.add(createOperation2CreationTool());
		paletteContainer.add(createEnumLiteral3CreationTool());
		paletteContainer.add(createPort4CreationTool());
		paletteContainer.add(createTemplateSignature5CreationTool());
		paletteContainer.add(createElementImport6CreationTool());
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
		paletteContainer.add(createAssociation1Group());
		paletteContainer.add(createDependency2Group());
		paletteContainer.add(createGeneralization3CreationTool());
		paletteContainer.add(createProvidedInterface4CreationTool());
		paletteContainer.add(createRequiredInterface5CreationTool());
		paletteContainer.add(createConstrainedElement6CreationTool());
		paletteContainer.add(createNAryDependencyTarget7CreationTool());
		paletteContainer.add(createNAryDependencySource8CreationTool());
		paletteContainer.add(createAssociationEnd9CreationTool());
		paletteContainer.add(createRealization10CreationTool());
		paletteContainer.add(createTemplateBinding11CreationTool());
		paletteContainer.add(createAnnotatedElement12CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Instances" palette tool group
	 * @generated
	 */
	private PaletteContainer createInstances4Group() {
		PaletteGroup paletteContainer = new PaletteGroup(Messages.Instances4Group_title);
		paletteContainer.setId("createInstances4Group"); //$NON-NLS-1$
		paletteContainer.setDescription(Messages.Instances4Group_desc);
		paletteContainer.add(createInstanceSpecification1CreationTool());
		paletteContainer.add(createSlot2CreationTool());
		paletteContainer.add(createValueSpecification3Group());
		return paletteContainer;
	}

	/**
	 * Creates "Association" palette tool group
	 * @generated
	 */
	private PaletteContainer createAssociation1Group() {
		PaletteStack paletteContainer = new PaletteStack(Messages.Association1Group_title, null, null);
		paletteContainer.setId("createAssociation1Group"); //$NON-NLS-1$
		paletteContainer.setDescription(Messages.Association1Group_desc);
		paletteContainer.add(createAssociation1CreationTool());
		paletteContainer.add(createSharedAggregation2CreationTool());
		paletteContainer.add(createCompositeAggregation3CreationTool());
		paletteContainer.add(createNavigableAssociation4CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Dependency" palette tool group
	 * @generated
	 */
	private PaletteContainer createDependency2Group() {
		PaletteStack paletteContainer = new PaletteStack(Messages.Dependency2Group_title, null, null);
		paletteContainer.setId("createDependency2Group"); //$NON-NLS-1$
		paletteContainer.setDescription(Messages.Dependency2Group_desc);
		paletteContainer.add(createDependency1CreationTool());
		paletteContainer.add(createAbstraction2CreationTool());
		paletteContainer.add(createUsage3CreationTool());
		paletteContainer.add(createSubstitution4CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Value Specification" palette tool group
	 * @generated
	 */
	private PaletteContainer createValueSpecification3Group() {
		PaletteStack paletteContainer = new PaletteStack(Messages.ValueSpecification3Group_title, null, null);
		paletteContainer.setId("createValueSpecification3Group"); //$NON-NLS-1$
		paletteContainer.setDescription(Messages.ValueSpecification3Group_desc);
		paletteContainer.add(createLiteralString1CreationTool());
		paletteContainer.add(createLiteralInteger2CreationTool());
		paletteContainer.add(createExpression3CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createClass1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(5);
		types.add(UMLElementTypes.Class_3007);
		types.add(UMLElementTypes.Class_2001);
		types.add(UMLElementTypes.Class_3003);
		types.add(UMLElementTypes.Class_3030);
		types.add(UMLElementTypes.Class_3033);
		NodeToolEntry entry = new NodeToolEntry(Messages.Class1CreationTool_title, Messages.Class1CreationTool_desc, types);
		entry.setId("createClass1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Class_3007));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createPackage2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(4);
		types.add(UMLElementTypes.Package_2002);
		types.add(UMLElementTypes.Package_3006);
		types.add(UMLElementTypes.Package_2016);
		types.add(UMLElementTypes.Package_3032);
		NodeToolEntry entry = new NodeToolEntry(Messages.Package2CreationTool_title, Messages.Package2CreationTool_desc, types);
		entry.setId("createPackage2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Package_2002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEnumeration3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(3);
		types.add(UMLElementTypes.Enumeration_3011);
		types.add(UMLElementTypes.Enumeration_2003);
		types.add(UMLElementTypes.Enumeration_3034);
		NodeToolEntry entry = new NodeToolEntry(Messages.Enumeration3CreationTool_title, Messages.Enumeration3CreationTool_desc, types);
		entry.setId("createEnumeration3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Enumeration_3011));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createDataType4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(3);
		types.add(UMLElementTypes.DataType_3008);
		types.add(UMLElementTypes.DataType_2004);
		types.add(UMLElementTypes.DataType_3036);
		NodeToolEntry entry = new NodeToolEntry(Messages.DataType4CreationTool_title, Messages.DataType4CreationTool_desc, types);
		entry.setId("createDataType4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.DataType_3008));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createPrimitiveType5CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(3);
		types.add(UMLElementTypes.PrimitiveType_3009);
		types.add(UMLElementTypes.PrimitiveType_2005);
		types.add(UMLElementTypes.PrimitiveType_3037);
		NodeToolEntry entry = new NodeToolEntry(Messages.PrimitiveType5CreationTool_title, Messages.PrimitiveType5CreationTool_desc, types);
		entry.setId("createPrimitiveType5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.PrimitiveType_3009));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createConstraint6CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Constraint_2006);
		NodeToolEntry entry = new NodeToolEntry(Messages.Constraint6CreationTool_title, Messages.Constraint6CreationTool_desc, types);
		entry.setId("createConstraint6CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Constraint_2006));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAssociationClass7CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(UMLElementTypes.AssociationClass_3012);
		types.add(UMLElementTypes.AssociationClass_2007);
		NodeToolEntry entry = new NodeToolEntry(Messages.AssociationClass7CreationTool_title, Messages.AssociationClass7CreationTool_desc, types);
		entry.setId("createAssociationClass7CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.AssociationClass_3012));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createInterface8CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(3);
		types.add(UMLElementTypes.Interface_3041);
		types.add(UMLElementTypes.Interface_2010);
		types.add(UMLElementTypes.Interface_2013);
		NodeToolEntry entry = new NodeToolEntry(Messages.Interface8CreationTool_title, Messages.Interface8CreationTool_desc, types);
		entry.setId("createInterface8CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Interface_3041));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createComment9CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Comment_2018);
		NodeToolEntry entry = new NodeToolEntry(Messages.Comment9CreationTool_title, Messages.Comment9CreationTool_desc, types);
		entry.setId("createComment9CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Comment_2018));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAttribute1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(6);
		types.add(UMLElementTypes.Property_3001);
		types.add(UMLElementTypes.Property_3019);
		types.add(UMLElementTypes.Property_3014);
		types.add(UMLElementTypes.Property_3021);
		types.add(UMLElementTypes.Property_3023);
		types.add(UMLElementTypes.Property_3028);
		NodeToolEntry entry = new NodeToolEntry(Messages.Attribute1CreationTool_title, Messages.Attribute1CreationTool_desc, types);
		entry.setId("createAttribute1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Property_3001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createOperation2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(6);
		types.add(UMLElementTypes.Operation_3002);
		types.add(UMLElementTypes.Operation_3020);
		types.add(UMLElementTypes.Operation_3015);
		types.add(UMLElementTypes.Operation_3022);
		types.add(UMLElementTypes.Operation_3024);
		types.add(UMLElementTypes.Operation_3029);
		NodeToolEntry entry = new NodeToolEntry(Messages.Operation2CreationTool_title, Messages.Operation2CreationTool_desc, types);
		entry.setId("createOperation2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Operation_3002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEnumLiteral3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.EnumerationLiteral_3016);
		NodeToolEntry entry = new NodeToolEntry(Messages.EnumLiteral3CreationTool_title, Messages.EnumLiteral3CreationTool_desc, types);
		entry.setId("createEnumLiteral3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.EnumerationLiteral_3016));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createPort4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Port_3025);
		NodeToolEntry entry = new NodeToolEntry(Messages.Port4CreationTool_title, Messages.Port4CreationTool_desc, types);
		entry.setId("createPort4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Port_3025));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createTemplateSignature5CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.RedefinableTemplateSignature_3027);
		NodeToolEntry entry = new NodeToolEntry(Messages.TemplateSignature5CreationTool_title, Messages.TemplateSignature5CreationTool_desc, types);
		entry.setId("createTemplateSignature5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.RedefinableTemplateSignature_3027));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createElementImport6CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.ElementImport_3031);
		NodeToolEntry entry = new NodeToolEntry(Messages.ElementImport6CreationTool_title, Messages.ElementImport6CreationTool_desc, types);
		entry.setId("createElementImport6CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.ElementImport_3031));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated NOT
	 */
	private ToolEntry createGeneralization3CreationTool() {
		ToolEntry entry = new ToolEntry(Messages.Generalization3CreationTool_title, Messages.Generalization3CreationTool_desc, null, null) {
		};
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Generalization_4001));
		entry.setLargeIcon(entry.getSmallIcon());
		entry.setToolClass(CreateGeneralizationLinkTool.class);
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createProvidedInterface4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(UMLElementTypes.InterfaceRealization_4008);
		types.add(UMLElementTypes.PortProvided_4017);
		LinkToolEntry entry = new LinkToolEntry(Messages.ProvidedInterface4CreationTool_title, Messages.ProvidedInterface4CreationTool_desc, types);
		entry.setId("createProvidedInterface4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.InterfaceRealization_4008));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createRequiredInterface5CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(UMLElementTypes.Usage_4013);
		types.add(UMLElementTypes.PortRequired_4018);
		LinkToolEntry entry = new LinkToolEntry(Messages.RequiredInterface5CreationTool_title, Messages.RequiredInterface5CreationTool_desc, types);
		entry.setId("createRequiredInterface5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Usage_4013));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createConstrainedElement6CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.ConstraintConstrainedElement_4004);
		LinkToolEntry entry = new LinkToolEntry(Messages.ConstrainedElement6CreationTool_title, Messages.ConstrainedElement6CreationTool_desc, types);
		entry.setId("createConstrainedElement6CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.ConstraintConstrainedElement_4004));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createNAryDependencyTarget7CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.DependencySupplier_4006);
		LinkToolEntry entry = new LinkToolEntry(Messages.NAryDependencyTarget7CreationTool_title, Messages.NAryDependencyTarget7CreationTool_desc, types);
		entry.setId("createNAryDependencyTarget7CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.DependencySupplier_4006));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createNAryDependencySource8CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.DependencyClient_4007);
		LinkToolEntry entry = new LinkToolEntry(Messages.NAryDependencySource8CreationTool_title, Messages.NAryDependencySource8CreationTool_desc, types);
		entry.setId("createNAryDependencySource8CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.DependencyClient_4007));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAssociationEnd9CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Property_4003);
		LinkToolEntry entry = new LinkToolEntry(Messages.AssociationEnd9CreationTool_title, Messages.AssociationEnd9CreationTool_desc, types);
		entry.setId("createAssociationEnd9CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Property_4003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createRealization10CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Realization_4010);
		LinkToolEntry entry = new LinkToolEntry(Messages.Realization10CreationTool_title, Messages.Realization10CreationTool_desc, types);
		entry.setId("createRealization10CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Realization_4010));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createTemplateBinding11CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.TemplateBinding_4016);
		LinkToolEntry entry = new LinkToolEntry(Messages.TemplateBinding11CreationTool_title, Messages.TemplateBinding11CreationTool_desc, types);
		entry.setId("createTemplateBinding11CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.TemplateBinding_4016));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAnnotatedElement12CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.CommentAnnotatedElement_4019);
		LinkToolEntry entry = new LinkToolEntry(Messages.AnnotatedElement12CreationTool_title, Messages.AnnotatedElement12CreationTool_desc, types);
		entry.setId("createAnnotatedElement12CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.CommentAnnotatedElement_4019));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createInstanceSpecification1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(3);
		types.add(UMLElementTypes.InstanceSpecification_3013);
		types.add(UMLElementTypes.InstanceSpecification_2008);
		types.add(UMLElementTypes.InstanceSpecification_3035);
		NodeToolEntry entry = new NodeToolEntry(Messages.InstanceSpecification1CreationTool_title, Messages.InstanceSpecification1CreationTool_desc, types);
		entry.setId("createInstanceSpecification1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.InstanceSpecification_3013));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSlot2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Slot_3017);
		NodeToolEntry entry = new NodeToolEntry(Messages.Slot2CreationTool_title, Messages.Slot2CreationTool_desc, types);
		entry.setId("createSlot2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Slot_3017));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAssociation1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(UMLElementTypes.Association_4005);
		types.add(UMLElementTypes.Slot_4015);
		LinkToolEntry entry = new LinkToolEntry(Messages.Association1CreationTool_title, Messages.Association1CreationTool_desc, types);
		entry.setId("createAssociation1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Association_4005));
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
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Association_4005));
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
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Association_4005));
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
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Association_4005));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createDependency1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Dependency_4002);
		LinkToolEntry entry = new LinkToolEntry(Messages.Dependency1CreationTool_title, Messages.Dependency1CreationTool_desc, types);
		entry.setId("createDependency1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Dependency_4002));
		entry.setLargeIcon(entry.getSmallIcon());
		entry.setToolClass(CreateDependencyLinkTool.DEPENDENCY.class);
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAbstraction2CreationToolGen() {
		ToolEntry entry = new ToolEntry(Messages.Abstraction2CreationTool_title, Messages.Abstraction2CreationTool_desc, null, null) {
		};
		entry.setId("createAbstraction2CreationTool"); //$NON-NLS-1$
		entry.setToolClass(CreateDependencyLinkTool.ABSTRACTION.class);
		return entry;
	}

	/**
	 * @generated NOT
	 */
	private ToolEntry createAbstraction2CreationTool() {
		ToolEntry entry = createAbstraction2CreationToolGen();
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Dependency_4002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createUsage3CreationToolGen() {
		ToolEntry entry = new ToolEntry(Messages.Usage3CreationTool_title, Messages.Usage3CreationTool_desc, null, null) {
		};
		entry.setId("createUsage3CreationTool"); //$NON-NLS-1$
		entry.setToolClass(CreateDependencyLinkTool.USAGE.class);
		return entry;
	}

	/**
	 * @generated NOT
	 */
	private ToolEntry createUsage3CreationTool() {
		ToolEntry entry = createUsage3CreationToolGen();
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Dependency_4002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSubstitution4CreationToolGen() {
		ToolEntry entry = new ToolEntry(Messages.Substitution4CreationTool_title, Messages.Substitution4CreationTool_desc, null, null) {
		};
		entry.setId("createSubstitution4CreationTool"); //$NON-NLS-1$
		entry.setToolClass(CreateDependencyLinkTool.SUBSTITUTION.class);
		return entry;
	}

	/**
	 * @generated NOT
	 */
	private ToolEntry createSubstitution4CreationTool() {
		ToolEntry entry = createSubstitution4CreationToolGen();
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Dependency_4002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createLiteralString1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.LiteralString_3038);
		NodeToolEntry entry = new NodeToolEntry(Messages.LiteralString1CreationTool_title, Messages.LiteralString1CreationTool_desc, types);
		entry.setId("createLiteralString1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.LiteralString_3038));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createLiteralInteger2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.LiteralInteger_3039);
		NodeToolEntry entry = new NodeToolEntry(Messages.LiteralInteger2CreationTool_title, Messages.LiteralInteger2CreationTool_desc, types);
		entry.setId("createLiteralInteger2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.LiteralInteger_3039));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createExpression3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Expression_3040);
		NodeToolEntry entry = new NodeToolEntry(Messages.Expression3CreationTool_title, Messages.Expression3CreationTool_desc, types);
		entry.setId("createExpression3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Expression_3040));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

}
