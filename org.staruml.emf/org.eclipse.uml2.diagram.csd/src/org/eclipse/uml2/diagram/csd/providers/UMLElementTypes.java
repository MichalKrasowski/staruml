package org.eclipse.uml2.diagram.csd.providers;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.diagram.csd.edit.parts.AssociationEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.AssociationInstanceEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.Class2EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.Class3EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.ClassEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.CollaborationEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.CollaborationUse2EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.CommentEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.ConnectorEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.ConstraintConstrainedElementEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.ConstraintEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.DependencyEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.ElementImportEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.InstanceSpecificationEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.InterfaceEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.InterfaceRealizationEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.OperationEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.Package2EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.PackageEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.Port2EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.Port3EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.PortEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.PortProvidedEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.PortRequiredEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.Property2EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.Property3EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.PropertyEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.SlotEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.UsageEditPart;
import org.eclipse.uml2.diagram.csd.part.UMLDiagramEditorPlugin;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class UMLElementTypes extends ElementInitializers {

	/**
	 * @generated
	 */
	private UMLElementTypes() {
	}

	/**
	 * @generated
	 */
	private static Map elements;

	/**
	 * @generated
	 */
	private static ImageRegistry imageRegistry;

	/**
	 * @generated
	 */
	private static Set KNOWN_ELEMENT_TYPES;

	/**
	 * @generated
	 */
	public static final IHintedType Package_1000 = (IHintedType) getElementType("org.eclipse.uml2.diagram.csd.Package_1000"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Collaboration_2005 = (IHintedType) getElementType("org.eclipse.uml2.diagram.csd.Collaboration_2005"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Class_2006 = (IHintedType) getElementType("org.eclipse.uml2.diagram.csd.Class_2006"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Package_2003 = (IHintedType) getElementType("org.eclipse.uml2.diagram.csd.Package_2003"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Class_2007 = (IHintedType) getElementType("org.eclipse.uml2.diagram.csd.Class_2007"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Interface_2009 = (IHintedType) getElementType("org.eclipse.uml2.diagram.csd.Interface_2009"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType InstanceSpecification_2011 = (IHintedType) getElementType("org.eclipse.uml2.diagram.csd.InstanceSpecification_2011"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Constraint_2012 = (IHintedType) getElementType("org.eclipse.uml2.diagram.csd.Constraint_2012"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Comment_2013 = (IHintedType) getElementType("org.eclipse.uml2.diagram.csd.Comment_2013"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType CollaborationUse_3002 = (IHintedType) getElementType("org.eclipse.uml2.diagram.csd.CollaborationUse_3002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Property_3007 = (IHintedType) getElementType("org.eclipse.uml2.diagram.csd.Property_3007"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Property_3008 = (IHintedType) getElementType("org.eclipse.uml2.diagram.csd.Property_3008"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Operation_3009 = (IHintedType) getElementType("org.eclipse.uml2.diagram.csd.Operation_3009"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Class_3010 = (IHintedType) getElementType("org.eclipse.uml2.diagram.csd.Class_3010"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Port_3011 = (IHintedType) getElementType("org.eclipse.uml2.diagram.csd.Port_3011"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType ElementImport_3004 = (IHintedType) getElementType("org.eclipse.uml2.diagram.csd.ElementImport_3004"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Property_3014 = (IHintedType) getElementType("org.eclipse.uml2.diagram.csd.Property_3014"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Port_3016 = (IHintedType) getElementType("org.eclipse.uml2.diagram.csd.Port_3016"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Port_3017 = (IHintedType) getElementType("org.eclipse.uml2.diagram.csd.Port_3017"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Slot_3015 = (IHintedType) getElementType("org.eclipse.uml2.diagram.csd.Slot_3015"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Connector_4005 = (IHintedType) getElementType("org.eclipse.uml2.diagram.csd.Connector_4005"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Dependency_4006 = (IHintedType) getElementType("org.eclipse.uml2.diagram.csd.Dependency_4006"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType InterfaceRealization_4007 = (IHintedType) getElementType("org.eclipse.uml2.diagram.csd.InterfaceRealization_4007"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Usage_4008 = (IHintedType) getElementType("org.eclipse.uml2.diagram.csd.Usage_4008"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType PortProvided_4010 = (IHintedType) getElementType("org.eclipse.uml2.diagram.csd.PortProvided_4010"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Association_4011 = (IHintedType) getElementType("org.eclipse.uml2.diagram.csd.Association_4011"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType ConstraintConstrainedElement_4012 = (IHintedType) getElementType("org.eclipse.uml2.diagram.csd.ConstraintConstrainedElement_4012"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType PortRequired_4014 = (IHintedType) getElementType("org.eclipse.uml2.diagram.csd.PortRequired_4014"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Slot_4015 = (IHintedType) getElementType("org.eclipse.uml2.diagram.csd.Slot_4015"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType CommentAnnotatedElement_4016 = (IHintedType) getElementType("org.eclipse.uml2.diagram.csd.CommentAnnotatedElement_4016"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	private static ImageRegistry getImageRegistry() {
		if (imageRegistry == null) {
			imageRegistry = new ImageRegistry();
		}
		return imageRegistry;
	}

	/**
	 * @generated
	 */
	private static String getImageRegistryKey(ENamedElement element) {
		return element.getName();
	}

	/**
	 * @generated
	 */
	private static ImageDescriptor getProvidedImageDescriptor(ENamedElement element) {
		if (element instanceof EStructuralFeature) {
			EStructuralFeature feature = ((EStructuralFeature) element);
			EClass eContainingClass = feature.getEContainingClass();
			EClassifier eType = feature.getEType();
			if (eContainingClass != null && !eContainingClass.isAbstract()) {
				element = eContainingClass;
			} else if (eType instanceof EClass && !((EClass) eType).isAbstract()) {
				element = eType;
			}
		}
		if (element instanceof EClass) {
			EClass eClass = (EClass) element;
			if (!eClass.isAbstract()) {
				return UMLDiagramEditorPlugin.getInstance().getItemImageDescriptor(eClass.getEPackage().getEFactoryInstance().create(eClass));
			}
		}
		// TODO : support structural features
		return null;
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(ENamedElement element) {
		String key = getImageRegistryKey(element);
		ImageDescriptor imageDescriptor = getImageRegistry().getDescriptor(key);
		if (imageDescriptor == null) {
			imageDescriptor = getProvidedImageDescriptor(element);
			if (imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			getImageRegistry().put(key, imageDescriptor);
		}
		return imageDescriptor;
	}

	/**
	 * @generated
	 */
	public static Image getImage(ENamedElement element) {
		String key = getImageRegistryKey(element);
		Image image = getImageRegistry().get(key);
		if (image == null) {
			ImageDescriptor imageDescriptor = getProvidedImageDescriptor(element);
			if (imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			getImageRegistry().put(key, imageDescriptor);
			image = getImageRegistry().get(key);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if (element == null) {
			return null;
		}
		return getImageDescriptor(element);
	}

	/**
	 * @generated
	 */
	public static Image getImage(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if (element == null) {
			return null;
		}
		return getImage(element);
	}

	/**
	 * Returns 'type' of the ecore object associated with the hint.
	 * 
	 * @generated
	 */
	public static ENamedElement getElement(IAdaptable hint) {
		Object type = hint.getAdapter(IElementType.class);
		if (elements == null) {
			elements = new IdentityHashMap();

			elements.put(Package_1000, UMLPackage.eINSTANCE.getPackage());

			elements.put(Collaboration_2005, UMLPackage.eINSTANCE.getCollaboration());

			elements.put(Class_2006, UMLPackage.eINSTANCE.getClass_());

			elements.put(Package_2003, UMLPackage.eINSTANCE.getPackage());

			elements.put(Class_2007, UMLPackage.eINSTANCE.getClass_());

			elements.put(Interface_2009, UMLPackage.eINSTANCE.getInterface());

			elements.put(InstanceSpecification_2011, UMLPackage.eINSTANCE.getInstanceSpecification());

			elements.put(Constraint_2012, UMLPackage.eINSTANCE.getConstraint());

			elements.put(Comment_2013, UMLPackage.eINSTANCE.getComment());

			elements.put(CollaborationUse_3002, UMLPackage.eINSTANCE.getCollaborationUse());

			elements.put(Property_3007, UMLPackage.eINSTANCE.getProperty());

			elements.put(Property_3008, UMLPackage.eINSTANCE.getProperty());

			elements.put(Operation_3009, UMLPackage.eINSTANCE.getOperation());

			elements.put(Class_3010, UMLPackage.eINSTANCE.getClass_());

			elements.put(Port_3011, UMLPackage.eINSTANCE.getPort());

			elements.put(ElementImport_3004, UMLPackage.eINSTANCE.getElementImport());

			elements.put(Property_3014, UMLPackage.eINSTANCE.getProperty());

			elements.put(Port_3016, UMLPackage.eINSTANCE.getPort());

			elements.put(Port_3017, UMLPackage.eINSTANCE.getPort());

			elements.put(Slot_3015, UMLPackage.eINSTANCE.getSlot());

			elements.put(Connector_4005, UMLPackage.eINSTANCE.getConnector());

			elements.put(Dependency_4006, UMLPackage.eINSTANCE.getDependency());

			elements.put(InterfaceRealization_4007, UMLPackage.eINSTANCE.getInterfaceRealization());

			elements.put(Usage_4008, UMLPackage.eINSTANCE.getUsage());

			elements.put(PortProvided_4010, UMLPackage.eINSTANCE.getPort_Provided());

			elements.put(Association_4011, UMLPackage.eINSTANCE.getAssociation());

			elements.put(ConstraintConstrainedElement_4012, UMLPackage.eINSTANCE.getConstraint_ConstrainedElement());

			elements.put(PortRequired_4014, UMLPackage.eINSTANCE.getPort_Required());

			elements.put(Slot_4015, UMLPackage.eINSTANCE.getSlot());

			elements.put(CommentAnnotatedElement_4016, UMLPackage.eINSTANCE.getComment_AnnotatedElement());
		}
		return (ENamedElement) elements.get(type);
	}

	/**
	 * @generated
	 */
	private static IElementType getElementType(String id) {
		return ElementTypeRegistry.getInstance().getType(id);
	}

	/**
	 * @generated
	 */
	public static boolean isKnownElementType(IElementType elementType) {
		if (KNOWN_ELEMENT_TYPES == null) {
			KNOWN_ELEMENT_TYPES = new HashSet();
			KNOWN_ELEMENT_TYPES.add(Package_1000);
			KNOWN_ELEMENT_TYPES.add(Collaboration_2005);
			KNOWN_ELEMENT_TYPES.add(Class_2006);
			KNOWN_ELEMENT_TYPES.add(Package_2003);
			KNOWN_ELEMENT_TYPES.add(Class_2007);
			KNOWN_ELEMENT_TYPES.add(Interface_2009);
			KNOWN_ELEMENT_TYPES.add(InstanceSpecification_2011);
			KNOWN_ELEMENT_TYPES.add(Constraint_2012);
			KNOWN_ELEMENT_TYPES.add(Comment_2013);
			KNOWN_ELEMENT_TYPES.add(CollaborationUse_3002);
			KNOWN_ELEMENT_TYPES.add(Property_3007);
			KNOWN_ELEMENT_TYPES.add(Property_3008);
			KNOWN_ELEMENT_TYPES.add(Operation_3009);
			KNOWN_ELEMENT_TYPES.add(Class_3010);
			KNOWN_ELEMENT_TYPES.add(Port_3011);
			KNOWN_ELEMENT_TYPES.add(ElementImport_3004);
			KNOWN_ELEMENT_TYPES.add(Property_3014);
			KNOWN_ELEMENT_TYPES.add(Port_3016);
			KNOWN_ELEMENT_TYPES.add(Port_3017);
			KNOWN_ELEMENT_TYPES.add(Slot_3015);
			KNOWN_ELEMENT_TYPES.add(Connector_4005);
			KNOWN_ELEMENT_TYPES.add(Dependency_4006);
			KNOWN_ELEMENT_TYPES.add(InterfaceRealization_4007);
			KNOWN_ELEMENT_TYPES.add(Usage_4008);
			KNOWN_ELEMENT_TYPES.add(PortProvided_4010);
			KNOWN_ELEMENT_TYPES.add(Association_4011);
			KNOWN_ELEMENT_TYPES.add(ConstraintConstrainedElement_4012);
			KNOWN_ELEMENT_TYPES.add(PortRequired_4014);
			KNOWN_ELEMENT_TYPES.add(Slot_4015);
			KNOWN_ELEMENT_TYPES.add(CommentAnnotatedElement_4016);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case PackageEditPart.VISUAL_ID:
			return Package_1000;
		case CollaborationEditPart.VISUAL_ID:
			return Collaboration_2005;
		case ClassEditPart.VISUAL_ID:
			return Class_2006;
		case Package2EditPart.VISUAL_ID:
			return Package_2003;
		case Class3EditPart.VISUAL_ID:
			return Class_2007;
		case InterfaceEditPart.VISUAL_ID:
			return Interface_2009;
		case InstanceSpecificationEditPart.VISUAL_ID:
			return InstanceSpecification_2011;
		case ConstraintEditPart.VISUAL_ID:
			return Constraint_2012;
		case CommentEditPart.VISUAL_ID:
			return Comment_2013;
		case CollaborationUse2EditPart.VISUAL_ID:
			return CollaborationUse_3002;
		case PropertyEditPart.VISUAL_ID:
			return Property_3007;
		case Property2EditPart.VISUAL_ID:
			return Property_3008;
		case OperationEditPart.VISUAL_ID:
			return Operation_3009;
		case Class2EditPart.VISUAL_ID:
			return Class_3010;
		case PortEditPart.VISUAL_ID:
			return Port_3011;
		case ElementImportEditPart.VISUAL_ID:
			return ElementImport_3004;
		case Property3EditPart.VISUAL_ID:
			return Property_3014;
		case Port2EditPart.VISUAL_ID:
			return Port_3016;
		case Port3EditPart.VISUAL_ID:
			return Port_3017;
		case SlotEditPart.VISUAL_ID:
			return Slot_3015;
		case ConnectorEditPart.VISUAL_ID:
			return Connector_4005;
		case DependencyEditPart.VISUAL_ID:
			return Dependency_4006;
		case InterfaceRealizationEditPart.VISUAL_ID:
			return InterfaceRealization_4007;
		case UsageEditPart.VISUAL_ID:
			return Usage_4008;
		case PortProvidedEditPart.VISUAL_ID:
			return PortProvided_4010;
		case AssociationEditPart.VISUAL_ID:
			return Association_4011;
		case ConstraintConstrainedElementEditPart.VISUAL_ID:
			return ConstraintConstrainedElement_4012;
		case PortRequiredEditPart.VISUAL_ID:
			return PortRequired_4014;
		case AssociationInstanceEditPart.VISUAL_ID:
			return Slot_4015;
		case CommentAnnotatedElementEditPart.VISUAL_ID:
			return CommentAnnotatedElement_4016;
		}
		return null;
	}

	/**
	 * @generated
	 */
	public static void refreshImageRegistry() {
		if (imageRegistry != null) {
			imageRegistry.dispose();
			imageRegistry = null;
		}
		imageRegistry = new ImageRegistry();
	}

}
