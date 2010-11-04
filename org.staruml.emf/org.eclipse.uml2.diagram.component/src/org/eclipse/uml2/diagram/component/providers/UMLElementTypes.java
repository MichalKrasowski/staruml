package org.eclipse.uml2.diagram.component.providers;

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
import org.eclipse.uml2.diagram.component.edit.parts.Artifact2EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.Artifact3EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ArtifactEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.AssemblyConnectorCircleEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.AssemblyConnectorEndRoleEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.AssociationEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.Class2EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.Class3EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ClassDiagramNotationClassEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ClassDiagramNotationInnerClassEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ClassDiagramNotationOperationEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ClassDiagramNotationPropertyEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ClassEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.CommentEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.Component2EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.Component3EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ComponentEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ComponentRequiredEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ConnectorEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.DependencyEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ElementImportEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.Interface2EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.InterfaceEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.InterfaceRealizationEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.Package2EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.Package3EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.Package4EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.PackageEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.PortEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.PortOnClassEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.PortProvidedEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.PortRequiredEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.PropertyEditPart;
import org.eclipse.uml2.diagram.component.part.UMLDiagramEditorPlugin;
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
	public static final IHintedType Package_1000 = (IHintedType) getElementType("org.eclipse.uml2.diagram.component.Package_1000"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Component_2001 = (IHintedType) getElementType("org.eclipse.uml2.diagram.component.Component_2001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Artifact_2002 = (IHintedType) getElementType("org.eclipse.uml2.diagram.component.Artifact_2002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Interface_2003 = (IHintedType) getElementType("org.eclipse.uml2.diagram.component.Interface_2003"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Class_2004 = (IHintedType) getElementType("org.eclipse.uml2.diagram.component.Class_2004"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Package_2005 = (IHintedType) getElementType("org.eclipse.uml2.diagram.component.Package_2005"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Package_2006 = (IHintedType) getElementType("org.eclipse.uml2.diagram.component.Package_2006"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Class_2007 = (IHintedType) getElementType("org.eclipse.uml2.diagram.component.Class_2007"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Comment_2008 = (IHintedType) getElementType("org.eclipse.uml2.diagram.component.Comment_2008"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Component_3001 = (IHintedType) getElementType("org.eclipse.uml2.diagram.component.Component_3001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Port_3002 = (IHintedType) getElementType("org.eclipse.uml2.diagram.component.Port_3002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Artifact_3003 = (IHintedType) getElementType("org.eclipse.uml2.diagram.component.Artifact_3003"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Artifact_3016 = (IHintedType) getElementType("org.eclipse.uml2.diagram.component.Artifact_3016"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Class_3004 = (IHintedType) getElementType("org.eclipse.uml2.diagram.component.Class_3004"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Interface_3005 = (IHintedType) getElementType("org.eclipse.uml2.diagram.component.Interface_3005"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Property_3006 = (IHintedType) getElementType("org.eclipse.uml2.diagram.component.Property_3006"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Connector_3015 = (IHintedType) getElementType("org.eclipse.uml2.diagram.component.Connector_3015"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType ElementImport_3007 = (IHintedType) getElementType("org.eclipse.uml2.diagram.component.ElementImport_3007"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Package_3008 = (IHintedType) getElementType("org.eclipse.uml2.diagram.component.Package_3008"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Class_3009 = (IHintedType) getElementType("org.eclipse.uml2.diagram.component.Class_3009"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Component_3010 = (IHintedType) getElementType("org.eclipse.uml2.diagram.component.Component_3010"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Property_3011 = (IHintedType) getElementType("org.eclipse.uml2.diagram.component.Property_3011"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Operation_3012 = (IHintedType) getElementType("org.eclipse.uml2.diagram.component.Operation_3012"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Class_3013 = (IHintedType) getElementType("org.eclipse.uml2.diagram.component.Class_3013"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Port_3014 = (IHintedType) getElementType("org.eclipse.uml2.diagram.component.Port_3014"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType InterfaceRealization_4001 = (IHintedType) getElementType("org.eclipse.uml2.diagram.component.InterfaceRealization_4001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType PortProvided_4006 = (IHintedType) getElementType("org.eclipse.uml2.diagram.component.PortProvided_4006"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType PortRequired_4004 = (IHintedType) getElementType("org.eclipse.uml2.diagram.component.PortRequired_4004"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType ComponentRequired_4007 = (IHintedType) getElementType("org.eclipse.uml2.diagram.component.ComponentRequired_4007"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Connector_4008 = (IHintedType) getElementType("org.eclipse.uml2.diagram.component.Connector_4008"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Dependency_4009 = (IHintedType) getElementType("org.eclipse.uml2.diagram.component.Dependency_4009"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType ConnectorEndRole_4010 = (IHintedType) getElementType("org.eclipse.uml2.diagram.component.ConnectorEndRole_4010"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Association_4011 = (IHintedType) getElementType("org.eclipse.uml2.diagram.component.Association_4011"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType CommentAnnotatedElement_4012 = (IHintedType) getElementType("org.eclipse.uml2.diagram.component.CommentAnnotatedElement_4012"); //$NON-NLS-1$

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

			elements.put(Component_2001, UMLPackage.eINSTANCE.getComponent());

			elements.put(Artifact_2002, UMLPackage.eINSTANCE.getArtifact());

			elements.put(Interface_2003, UMLPackage.eINSTANCE.getInterface());

			elements.put(Class_2004, UMLPackage.eINSTANCE.getClass_());

			elements.put(Package_2005, UMLPackage.eINSTANCE.getPackage());

			elements.put(Package_2006, UMLPackage.eINSTANCE.getPackage());

			elements.put(Class_2007, UMLPackage.eINSTANCE.getClass_());

			elements.put(Comment_2008, UMLPackage.eINSTANCE.getComment());

			elements.put(Component_3001, UMLPackage.eINSTANCE.getComponent());

			elements.put(Port_3002, UMLPackage.eINSTANCE.getPort());

			elements.put(Artifact_3003, UMLPackage.eINSTANCE.getArtifact());

			elements.put(Artifact_3016, UMLPackage.eINSTANCE.getArtifact());

			elements.put(Class_3004, UMLPackage.eINSTANCE.getClass_());

			elements.put(Interface_3005, UMLPackage.eINSTANCE.getInterface());

			elements.put(Property_3006, UMLPackage.eINSTANCE.getProperty());

			elements.put(Connector_3015, UMLPackage.eINSTANCE.getConnector());

			elements.put(ElementImport_3007, UMLPackage.eINSTANCE.getElementImport());

			elements.put(Package_3008, UMLPackage.eINSTANCE.getPackage());

			elements.put(Class_3009, UMLPackage.eINSTANCE.getClass_());

			elements.put(Component_3010, UMLPackage.eINSTANCE.getComponent());

			elements.put(Property_3011, UMLPackage.eINSTANCE.getProperty());

			elements.put(Operation_3012, UMLPackage.eINSTANCE.getOperation());

			elements.put(Class_3013, UMLPackage.eINSTANCE.getClass_());

			elements.put(Port_3014, UMLPackage.eINSTANCE.getPort());

			elements.put(InterfaceRealization_4001, UMLPackage.eINSTANCE.getInterfaceRealization());

			elements.put(PortProvided_4006, UMLPackage.eINSTANCE.getPort_Provided());

			elements.put(PortRequired_4004, UMLPackage.eINSTANCE.getPort_Required());

			elements.put(ComponentRequired_4007, UMLPackage.eINSTANCE.getComponent_Required());

			elements.put(Connector_4008, UMLPackage.eINSTANCE.getConnector());

			elements.put(Dependency_4009, UMLPackage.eINSTANCE.getDependency());

			elements.put(ConnectorEndRole_4010, UMLPackage.eINSTANCE.getConnectorEnd_Role());

			elements.put(Association_4011, UMLPackage.eINSTANCE.getAssociation());

			elements.put(CommentAnnotatedElement_4012, UMLPackage.eINSTANCE.getComment_AnnotatedElement());
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
			KNOWN_ELEMENT_TYPES.add(Component_2001);
			KNOWN_ELEMENT_TYPES.add(Artifact_2002);
			KNOWN_ELEMENT_TYPES.add(Interface_2003);
			KNOWN_ELEMENT_TYPES.add(Class_2004);
			KNOWN_ELEMENT_TYPES.add(Package_2005);
			KNOWN_ELEMENT_TYPES.add(Package_2006);
			KNOWN_ELEMENT_TYPES.add(Class_2007);
			KNOWN_ELEMENT_TYPES.add(Comment_2008);
			KNOWN_ELEMENT_TYPES.add(Component_3001);
			KNOWN_ELEMENT_TYPES.add(Port_3002);
			KNOWN_ELEMENT_TYPES.add(Artifact_3003);
			KNOWN_ELEMENT_TYPES.add(Artifact_3016);
			KNOWN_ELEMENT_TYPES.add(Class_3004);
			KNOWN_ELEMENT_TYPES.add(Interface_3005);
			KNOWN_ELEMENT_TYPES.add(Property_3006);
			KNOWN_ELEMENT_TYPES.add(Connector_3015);
			KNOWN_ELEMENT_TYPES.add(ElementImport_3007);
			KNOWN_ELEMENT_TYPES.add(Package_3008);
			KNOWN_ELEMENT_TYPES.add(Class_3009);
			KNOWN_ELEMENT_TYPES.add(Component_3010);
			KNOWN_ELEMENT_TYPES.add(Property_3011);
			KNOWN_ELEMENT_TYPES.add(Operation_3012);
			KNOWN_ELEMENT_TYPES.add(Class_3013);
			KNOWN_ELEMENT_TYPES.add(Port_3014);
			KNOWN_ELEMENT_TYPES.add(InterfaceRealization_4001);
			KNOWN_ELEMENT_TYPES.add(PortProvided_4006);
			KNOWN_ELEMENT_TYPES.add(PortRequired_4004);
			KNOWN_ELEMENT_TYPES.add(ComponentRequired_4007);
			KNOWN_ELEMENT_TYPES.add(Connector_4008);
			KNOWN_ELEMENT_TYPES.add(Dependency_4009);
			KNOWN_ELEMENT_TYPES.add(ConnectorEndRole_4010);
			KNOWN_ELEMENT_TYPES.add(Association_4011);
			KNOWN_ELEMENT_TYPES.add(CommentAnnotatedElement_4012);
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
		case ComponentEditPart.VISUAL_ID:
			return Component_2001;
		case Artifact2EditPart.VISUAL_ID:
			return Artifact_2002;
		case Interface2EditPart.VISUAL_ID:
			return Interface_2003;
		case Class2EditPart.VISUAL_ID:
			return Class_2004;
		case Package2EditPart.VISUAL_ID:
			return Package_2005;
		case Package3EditPart.VISUAL_ID:
			return Package_2006;
		case ClassDiagramNotationClassEditPart.VISUAL_ID:
			return Class_2007;
		case CommentEditPart.VISUAL_ID:
			return Comment_2008;
		case Component2EditPart.VISUAL_ID:
			return Component_3001;
		case PortEditPart.VISUAL_ID:
			return Port_3002;
		case ArtifactEditPart.VISUAL_ID:
			return Artifact_3003;
		case Artifact3EditPart.VISUAL_ID:
			return Artifact_3016;
		case ClassEditPart.VISUAL_ID:
			return Class_3004;
		case InterfaceEditPart.VISUAL_ID:
			return Interface_3005;
		case PropertyEditPart.VISUAL_ID:
			return Property_3006;
		case AssemblyConnectorCircleEditPart.VISUAL_ID:
			return Connector_3015;
		case ElementImportEditPart.VISUAL_ID:
			return ElementImport_3007;
		case Package4EditPart.VISUAL_ID:
			return Package_3008;
		case Class3EditPart.VISUAL_ID:
			return Class_3009;
		case Component3EditPart.VISUAL_ID:
			return Component_3010;
		case ClassDiagramNotationPropertyEditPart.VISUAL_ID:
			return Property_3011;
		case ClassDiagramNotationOperationEditPart.VISUAL_ID:
			return Operation_3012;
		case ClassDiagramNotationInnerClassEditPart.VISUAL_ID:
			return Class_3013;
		case PortOnClassEditPart.VISUAL_ID:
			return Port_3014;
		case InterfaceRealizationEditPart.VISUAL_ID:
			return InterfaceRealization_4001;
		case PortProvidedEditPart.VISUAL_ID:
			return PortProvided_4006;
		case PortRequiredEditPart.VISUAL_ID:
			return PortRequired_4004;
		case ComponentRequiredEditPart.VISUAL_ID:
			return ComponentRequired_4007;
		case ConnectorEditPart.VISUAL_ID:
			return Connector_4008;
		case DependencyEditPart.VISUAL_ID:
			return Dependency_4009;
		case AssemblyConnectorEndRoleEditPart.VISUAL_ID:
			return ConnectorEndRole_4010;
		case AssociationEditPart.VISUAL_ID:
			return Association_4011;
		case CommentAnnotatedElementEditPart.VISUAL_ID:
			return CommentAnnotatedElement_4012;
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
