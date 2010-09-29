package org.eclipse.uml2.diagram.deploy.providers;

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
import org.eclipse.uml2.diagram.deploy.edit.parts.Artifact2EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.Artifact3EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.Artifact4EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.ArtifactEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.CommentEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.CommunicationPathEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.DependencyEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.DeploymentConfigurationEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.DeploymentEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.DeploymentSpecification2EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.DeploymentSpecificationEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.Device2EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.DeviceEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.ElementImportEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.ExecutionEnvironment2EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.ExecutionEnvironmentEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.ManifestationEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.Node2EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.NodeEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.Package2EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.PackageEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.PropertyEditPart;
import org.eclipse.uml2.diagram.deploy.part.UMLDiagramEditorPlugin;
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
	public static final IHintedType Package_1000 = (IHintedType) getElementType("org.eclipse.uml2.diagram.deploy.Package_1000"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Package_2001 = (IHintedType) getElementType("org.eclipse.uml2.diagram.deploy.Package_2001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Device_2003 = (IHintedType) getElementType("org.eclipse.uml2.diagram.deploy.Device_2003"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Node_2004 = (IHintedType) getElementType("org.eclipse.uml2.diagram.deploy.Node_2004"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType ExecutionEnvironment_2005 = (IHintedType) getElementType("org.eclipse.uml2.diagram.deploy.ExecutionEnvironment_2005"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Artifact_2006 = (IHintedType) getElementType("org.eclipse.uml2.diagram.deploy.Artifact_2006"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType DeploymentSpecification_2007 = (IHintedType) getElementType("org.eclipse.uml2.diagram.deploy.DeploymentSpecification_2007"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Comment_2008 = (IHintedType) getElementType("org.eclipse.uml2.diagram.deploy.Comment_2008"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType ElementImport_3001 = (IHintedType) getElementType("org.eclipse.uml2.diagram.deploy.ElementImport_3001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Device_3004 = (IHintedType) getElementType("org.eclipse.uml2.diagram.deploy.Device_3004"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Artifact_3002 = (IHintedType) getElementType("org.eclipse.uml2.diagram.deploy.Artifact_3002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Artifact_3008 = (IHintedType) getElementType("org.eclipse.uml2.diagram.deploy.Artifact_3008"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType DeploymentSpecification_3009 = (IHintedType) getElementType("org.eclipse.uml2.diagram.deploy.DeploymentSpecification_3009"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType ExecutionEnvironment_3005 = (IHintedType) getElementType("org.eclipse.uml2.diagram.deploy.ExecutionEnvironment_3005"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Artifact_3006 = (IHintedType) getElementType("org.eclipse.uml2.diagram.deploy.Artifact_3006"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Node_3007 = (IHintedType) getElementType("org.eclipse.uml2.diagram.deploy.Node_3007"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Property_3003 = (IHintedType) getElementType("org.eclipse.uml2.diagram.deploy.Property_3003"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Deployment_4001 = (IHintedType) getElementType("org.eclipse.uml2.diagram.deploy.Deployment_4001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Manifestation_4002 = (IHintedType) getElementType("org.eclipse.uml2.diagram.deploy.Manifestation_4002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType DeploymentConfiguration_4003 = (IHintedType) getElementType("org.eclipse.uml2.diagram.deploy.DeploymentConfiguration_4003"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType CommunicationPath_4004 = (IHintedType) getElementType("org.eclipse.uml2.diagram.deploy.CommunicationPath_4004"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Dependency_4005 = (IHintedType) getElementType("org.eclipse.uml2.diagram.deploy.Dependency_4005"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType CommentAnnotatedElement_4006 = (IHintedType) getElementType("org.eclipse.uml2.diagram.deploy.CommentAnnotatedElement_4006"); //$NON-NLS-1$

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

			elements.put(Package_2001, UMLPackage.eINSTANCE.getPackage());

			elements.put(Device_2003, UMLPackage.eINSTANCE.getDevice());

			elements.put(Node_2004, UMLPackage.eINSTANCE.getNode());

			elements.put(ExecutionEnvironment_2005, UMLPackage.eINSTANCE.getExecutionEnvironment());

			elements.put(Artifact_2006, UMLPackage.eINSTANCE.getArtifact());

			elements.put(DeploymentSpecification_2007, UMLPackage.eINSTANCE.getDeploymentSpecification());

			elements.put(Comment_2008, UMLPackage.eINSTANCE.getComment());

			elements.put(ElementImport_3001, UMLPackage.eINSTANCE.getElementImport());

			elements.put(Device_3004, UMLPackage.eINSTANCE.getDevice());

			elements.put(Artifact_3002, UMLPackage.eINSTANCE.getArtifact());

			elements.put(Artifact_3008, UMLPackage.eINSTANCE.getArtifact());

			elements.put(DeploymentSpecification_3009, UMLPackage.eINSTANCE.getDeploymentSpecification());

			elements.put(Property_3003, UMLPackage.eINSTANCE.getProperty());

			elements.put(ExecutionEnvironment_3005, UMLPackage.eINSTANCE.getExecutionEnvironment());

			elements.put(Artifact_3006, UMLPackage.eINSTANCE.getArtifact());

			elements.put(Node_3007, UMLPackage.eINSTANCE.getNode());

			elements.put(Deployment_4001, UMLPackage.eINSTANCE.getDeployment());

			elements.put(Manifestation_4002, UMLPackage.eINSTANCE.getManifestation());

			elements.put(DeploymentConfiguration_4003, UMLPackage.eINSTANCE.getDeployment_Configuration());

			elements.put(CommunicationPath_4004, UMLPackage.eINSTANCE.getCommunicationPath());

			elements.put(Dependency_4005, UMLPackage.eINSTANCE.getDependency());

			elements.put(CommentAnnotatedElement_4006, UMLPackage.eINSTANCE.getComment_AnnotatedElement());
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
			KNOWN_ELEMENT_TYPES.add(Package_2001);
			KNOWN_ELEMENT_TYPES.add(Device_2003);
			KNOWN_ELEMENT_TYPES.add(Node_2004);
			KNOWN_ELEMENT_TYPES.add(ExecutionEnvironment_2005);
			KNOWN_ELEMENT_TYPES.add(Artifact_2006);
			KNOWN_ELEMENT_TYPES.add(DeploymentSpecification_2007);
			KNOWN_ELEMENT_TYPES.add(Comment_2008);
			KNOWN_ELEMENT_TYPES.add(ElementImport_3001);
			KNOWN_ELEMENT_TYPES.add(Device_3004);
			KNOWN_ELEMENT_TYPES.add(Artifact_3002);
			KNOWN_ELEMENT_TYPES.add(Artifact_3008);
			KNOWN_ELEMENT_TYPES.add(DeploymentSpecification_3009);
			KNOWN_ELEMENT_TYPES.add(Property_3003);
			KNOWN_ELEMENT_TYPES.add(ExecutionEnvironment_3005);
			KNOWN_ELEMENT_TYPES.add(Artifact_3006);
			KNOWN_ELEMENT_TYPES.add(Node_3007);
			KNOWN_ELEMENT_TYPES.add(Deployment_4001);
			KNOWN_ELEMENT_TYPES.add(Manifestation_4002);
			KNOWN_ELEMENT_TYPES.add(DeploymentConfiguration_4003);
			KNOWN_ELEMENT_TYPES.add(CommunicationPath_4004);
			KNOWN_ELEMENT_TYPES.add(Dependency_4005);
			KNOWN_ELEMENT_TYPES.add(CommentAnnotatedElement_4006);
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
		case Package2EditPart.VISUAL_ID:
			return Package_2001;
		case DeviceEditPart.VISUAL_ID:
			return Device_2003;
		case NodeEditPart.VISUAL_ID:
			return Node_2004;
		case ExecutionEnvironmentEditPart.VISUAL_ID:
			return ExecutionEnvironment_2005;
		case Artifact2EditPart.VISUAL_ID:
			return Artifact_2006;
		case DeploymentSpecificationEditPart.VISUAL_ID:
			return DeploymentSpecification_2007;
		case CommentEditPart.VISUAL_ID:
			return Comment_2008;
		case ElementImportEditPart.VISUAL_ID:
			return ElementImport_3001;
		case Device2EditPart.VISUAL_ID:
			return Device_3004;
		case ArtifactEditPart.VISUAL_ID:
			return Artifact_3002;
		case Artifact4EditPart.VISUAL_ID:
			return Artifact_3008;
		case DeploymentSpecification2EditPart.VISUAL_ID:
			return DeploymentSpecification_3009;
		case PropertyEditPart.VISUAL_ID:
			return Property_3003;
		case ExecutionEnvironment2EditPart.VISUAL_ID:
			return ExecutionEnvironment_3005;
		case Artifact3EditPart.VISUAL_ID:
			return Artifact_3006;
		case Node2EditPart.VISUAL_ID:
			return Node_3007;
		case DeploymentEditPart.VISUAL_ID:
			return Deployment_4001;
		case ManifestationEditPart.VISUAL_ID:
			return Manifestation_4002;
		case DeploymentConfigurationEditPart.VISUAL_ID:
			return DeploymentConfiguration_4003;
		case CommunicationPathEditPart.VISUAL_ID:
			return CommunicationPath_4004;
		case DependencyEditPart.VISUAL_ID:
			return Dependency_4005;
		case CommentAnnotatedElementEditPart.VISUAL_ID:
			return CommentAnnotatedElement_4006;
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
