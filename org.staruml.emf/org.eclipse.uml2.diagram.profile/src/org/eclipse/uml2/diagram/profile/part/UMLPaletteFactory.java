package org.eclipse.uml2.diagram.profile.part;

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
import org.eclipse.uml2.diagram.profile.providers.UMLElementTypes;

/**
 * @generated
 */
public class UMLPaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createProfiles1Group());
		paletteRoot.add(createUML2Group());
	}

	/**
	 * Creates "Profiles" palette tool group
	 * @generated
	 */
	private PaletteContainer createProfiles1Group() {
		PaletteGroup paletteContainer = new PaletteGroup(Messages.Profiles1Group_title);
		paletteContainer.setId("createProfiles1Group"); //$NON-NLS-1$
		paletteContainer.add(createProfile1CreationTool());
		paletteContainer.add(createStereotype2CreationTool());
		paletteContainer.add(createMetaclass3CreationTool());
		paletteContainer.add(createExtension4CreationTool());
		paletteContainer.add(createImage5CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "UML" palette tool group
	 * @generated
	 */
	private PaletteContainer createUML2Group() {
		PaletteGroup paletteContainer = new PaletteGroup(Messages.UML2Group_title);
		paletteContainer.setId("createUML2Group"); //$NON-NLS-1$
		paletteContainer.add(createEnumeration1CreationTool());
		paletteContainer.add(createGeneralization2CreationTool());
		paletteContainer.add(createProperty3CreationTool());
		paletteContainer.add(createOCLConstraint4CreationTool());
		paletteContainer.add(createLiteral5CreationTool());
		paletteContainer.add(createElementImport6CreationTool());
		paletteContainer.add(createConstrainedElement7CreationTool());
		paletteContainer.add(createComment8CreationTool());
		paletteContainer.add(createAnnotatedElement9CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createProfile1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Profile_2002);
		NodeToolEntry entry = new NodeToolEntry(Messages.Profile1CreationTool_title, Messages.Profile1CreationTool_desc, types);
		entry.setId("createProfile1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Profile_2002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createStereotype2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(UMLElementTypes.Stereotype_2001);
		types.add(UMLElementTypes.Stereotype_3003);
		NodeToolEntry entry = new NodeToolEntry(Messages.Stereotype2CreationTool_title, Messages.Stereotype2CreationTool_desc, types);
		entry.setId("createStereotype2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Stereotype_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createMetaclass3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.ElementImport_2006);
		NodeToolEntry entry = new NodeToolEntry(Messages.Metaclass3CreationTool_title, Messages.Metaclass3CreationTool_desc, types);
		entry.setId("createMetaclass3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.ElementImport_2006));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createExtension4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Extension_4002);
		LinkToolEntry entry = new LinkToolEntry(Messages.Extension4CreationTool_title, Messages.Extension4CreationTool_desc, types);
		entry.setId("createExtension4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Extension_4002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createImage5CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Image_3010);
		NodeToolEntry entry = new NodeToolEntry(Messages.Image5CreationTool_title, Messages.Image5CreationTool_desc, types);
		entry.setId("createImage5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Image_3010));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEnumeration1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Enumeration_2003);
		NodeToolEntry entry = new NodeToolEntry(Messages.Enumeration1CreationTool_title, Messages.Enumeration1CreationTool_desc, types);
		entry.setId("createEnumeration1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Enumeration_2003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createGeneralization2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Generalization_4001);
		LinkToolEntry entry = new LinkToolEntry(Messages.Generalization2CreationTool_title, Messages.Generalization2CreationTool_desc, types);
		entry.setId("createGeneralization2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Generalization_4001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createProperty3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Property_3001);
		NodeToolEntry entry = new NodeToolEntry(Messages.Property3CreationTool_title, Messages.Property3CreationTool_desc, types);
		entry.setId("createProperty3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Property_3001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createOCLConstraint4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(UMLElementTypes.Constraint_3008);
		types.add(UMLElementTypes.Constraint_2008);
		NodeToolEntry entry = new NodeToolEntry(Messages.OCLConstraint4CreationTool_title, Messages.OCLConstraint4CreationTool_desc, types);
		entry.setId("createOCLConstraint4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Constraint_3008));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createLiteral5CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.EnumerationLiteral_3005);
		NodeToolEntry entry = new NodeToolEntry(Messages.Literal5CreationTool_title, Messages.Literal5CreationTool_desc, types);
		entry.setId("createLiteral5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.EnumerationLiteral_3005));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createElementImport6CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.ElementImport_3009);
		NodeToolEntry entry = new NodeToolEntry(Messages.ElementImport6CreationTool_title, Messages.ElementImport6CreationTool_desc, types);
		entry.setId("createElementImport6CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.ElementImport_3009));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createConstrainedElement7CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.ConstraintConstrainedElement_4003);
		LinkToolEntry entry = new LinkToolEntry(Messages.ConstrainedElement7CreationTool_title, Messages.ConstrainedElement7CreationTool_desc, types);
		entry.setId("createConstrainedElement7CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.ConstraintConstrainedElement_4003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createComment8CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.Comment_2009);
		NodeToolEntry entry = new NodeToolEntry(Messages.Comment8CreationTool_title, Messages.Comment8CreationTool_desc, types);
		entry.setId("createComment8CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Comment_2009));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAnnotatedElement9CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UMLElementTypes.CommentAnnotatedElement_4004);
		LinkToolEntry entry = new LinkToolEntry(Messages.AnnotatedElement9CreationTool_title, Messages.AnnotatedElement9CreationTool_desc, types);
		entry.setId("createAnnotatedElement9CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.CommentAnnotatedElement_4004));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}
}
