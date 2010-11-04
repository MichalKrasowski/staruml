package org.eclipse.uml2.diagram.component.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.common.genapi.IVisualIDRegistry;
import org.eclipse.uml2.diagram.component.edit.parts.Artifact2EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.Artifact3EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ArtifactContents2EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ArtifactContents3EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ArtifactContentsEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ArtifactEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ArtifactName2EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ArtifactName3EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ArtifactNameEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ArtifactStereo2EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ArtifactStereo3EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ArtifactStereoEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.AssemblyConnectorCircleEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.AssociationEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.AssociationName2EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.AssociationName3EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.AssociationName4EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.AssociationName5EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.AssociationName6EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.AssociationName7EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.AssociationNameEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.Class2EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.Class3EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ClassAttributesEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ClassClassesEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ClassDiagramNotationClassEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ClassDiagramNotationClassNameEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ClassDiagramNotationClassStereotypeEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ClassDiagramNotationInnerClassEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ClassDiagramNotationOperationEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ClassDiagramNotationPropertyEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ClassEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ClassName2EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ClassNameEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ClassOperationsEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.CommentBodyEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.CommentEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.Component2EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.Component3EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ComponentContents2EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ComponentContentsEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ComponentEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ComponentName2EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ComponentNameEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ComponentStereo2EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ComponentStereoEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ConnectorEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.DependencyEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.DependencyNameEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ElementImportEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.Interface2EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.InterfaceEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.InterfaceName2EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.InterfaceNameEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.InterfaceRealizationEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.Package2EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.Package3EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.Package4EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.PackageClassifiersEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.PackageEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.PackageImportsEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.PackageName2EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.PackageNameEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.PackagePackagesEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.PackageStereo2EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.PortEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.PortName2EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.PortNameEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.PortOnClassEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.PropertyEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.PropertyNameEditPart;
import org.eclipse.uml2.diagram.component.expressions.UMLAbstractExpression;
import org.eclipse.uml2.diagram.component.expressions.UMLOCLFactory;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.InterfaceRealization;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented
 * by a domain model object.
 * 
 * @generated
 */
public class UMLVisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = "org.eclipse.uml2.diagram.component/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private static UMLAbstractExpression Class_2004_Constraint;

	/**
	 * @generated
	 */
	private static UMLAbstractExpression Class_2007_Constraint;

	/**
	 * @generated
	 */
	private static UMLAbstractExpression Class_3004_Constraint;

	/**
	 * @generated
	 */
	private static UMLAbstractExpression Property_3006_Constraint;

	/**
	 * @generated
	 */
	private static UMLAbstractExpression Connector_3015_Constraint;

	/**
	 * @generated
	 */
	private static UMLAbstractExpression Class_3009_Constraint;

	/**
	 * @generated
	 */
	private static UMLAbstractExpression Property_3011_Constraint;

	/**
	 * @generated
	 */
	private static UMLAbstractExpression InterfaceRealization_4001_Constraint;

	/**
	 * @generated
	 */
	private static UMLAbstractExpression Connector_4008_Constraint;

	/**
	 * @generated
	 */
	private static UMLAbstractExpression Dependency_4009_Constraint;

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (PackageEditPart.MODEL_ID.equals(view.getType())) {
				return PackageEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return org.eclipse.uml2.diagram.component.part.UMLVisualIDRegistry.getVisualID(view.getType());
	}

	/**
	 * @generated
	 */
	public static String getModelID(View view) {
		View diagram = view.getDiagram();
		while (view != diagram) {
			EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
			if (annotation != null) {
				return (String) annotation.getDetails().get("modelID"); //$NON-NLS-1$
			}
			view = (View) view.eContainer();
		}
		return diagram != null ? diagram.getType() : null;
	}

	/**
	 * @generated
	 */
	public static int getVisualID(String type) {
		try {
			return Integer.parseInt(type);
		} catch (NumberFormatException e) {
			if (Boolean.TRUE.toString().equalsIgnoreCase(Platform.getDebugOption(DEBUG_KEY))) {
				UMLDiagramEditorPlugin.getInstance().logError("Unable to parse view type as a visualID number: " + type);
			}
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static String getType(int visualID) {
		return String.valueOf(visualID);
	}

	/**
	 * @generated
	 */
	public static int getDiagramVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (UMLPackage.eINSTANCE.getPackage().isSuperTypeOf(domainElement.eClass()) && isDiagram((Package) domainElement)) {
			return PackageEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static int getNodeVisualID(View containerView, EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		String containerModelID = org.eclipse.uml2.diagram.component.part.UMLVisualIDRegistry.getModelID(containerView);
		if (!PackageEditPart.MODEL_ID.equals(containerModelID) && !"UMLComponent".equals(containerModelID)) { //$NON-NLS-1$
			return -1;
		}
		int containerVisualID;
		if (PackageEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.eclipse.uml2.diagram.component.part.UMLVisualIDRegistry.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = PackageEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case ComponentEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getPort().isSuperTypeOf(domainElement.eClass())) {
				return PortEditPart.VISUAL_ID;
			}
			break;
		case Class2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getPort().isSuperTypeOf(domainElement.eClass())) {
				return PortEditPart.VISUAL_ID;
			}
			break;
		case ClassDiagramNotationClassEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getPort().isSuperTypeOf(domainElement.eClass())) {
				return PortOnClassEditPart.VISUAL_ID;
			}
			break;
		case Component2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getPort().isSuperTypeOf(domainElement.eClass())) {
				return PortEditPart.VISUAL_ID;
			}
			break;
		case ClassEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getPort().isSuperTypeOf(domainElement.eClass())) {
				return PortEditPart.VISUAL_ID;
			}
			break;
		case ComponentContentsEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getComponent().isSuperTypeOf(domainElement.eClass())) {
				return Component2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getArtifact().isSuperTypeOf(domainElement.eClass())) {
				return ArtifactEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass()) && isClass_3004((Class) domainElement)) {
				return ClassEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getInterface().isSuperTypeOf(domainElement.eClass())) {
				return InterfaceEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass()) && isProperty_3006((Property) domainElement)) {
				return PropertyEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getConnector().isSuperTypeOf(domainElement.eClass()) && isConnector_3015((Connector) domainElement)) {
				return AssemblyConnectorCircleEditPart.VISUAL_ID;
			}
			break;
		case ComponentContents2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getComponent().isSuperTypeOf(domainElement.eClass())) {
				return Component2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getArtifact().isSuperTypeOf(domainElement.eClass())) {
				return ArtifactEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass()) && isClass_3004((Class) domainElement)) {
				return ClassEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getInterface().isSuperTypeOf(domainElement.eClass())) {
				return InterfaceEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass()) && isProperty_3006((Property) domainElement)) {
				return PropertyEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getConnector().isSuperTypeOf(domainElement.eClass()) && isConnector_3015((Connector) domainElement)) {
				return AssemblyConnectorCircleEditPart.VISUAL_ID;
			}
			break;
		case ArtifactContentsEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getArtifact().isSuperTypeOf(domainElement.eClass())) {
				return Artifact3EditPart.VISUAL_ID;
			}
			break;
		case ArtifactContents2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getArtifact().isSuperTypeOf(domainElement.eClass())) {
				return Artifact3EditPart.VISUAL_ID;
			}
			break;
		case ArtifactContents3EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getArtifact().isSuperTypeOf(domainElement.eClass())) {
				return Artifact3EditPart.VISUAL_ID;
			}
			break;
		case PackageImportsEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getElementImport().isSuperTypeOf(domainElement.eClass())) {
				return ElementImportEditPart.VISUAL_ID;
			}
			break;
		case PackagePackagesEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getPackage().isSuperTypeOf(domainElement.eClass())) {
				return Package4EditPart.VISUAL_ID;
			}
			break;
		case PackageClassifiersEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass()) && isClass_3009((Class) domainElement)) {
				return Class3EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getComponent().isSuperTypeOf(domainElement.eClass())) {
				return Component3EditPart.VISUAL_ID;
			}
			break;
		case ClassAttributesEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass()) && isProperty_3011((Property) domainElement)) {
				return ClassDiagramNotationPropertyEditPart.VISUAL_ID;
			}
			break;
		case ClassOperationsEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getOperation().isSuperTypeOf(domainElement.eClass())) {
				return ClassDiagramNotationOperationEditPart.VISUAL_ID;
			}
			break;
		case ClassClassesEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass())) {
				return ClassDiagramNotationInnerClassEditPart.VISUAL_ID;
			}
			break;
		case PackageEditPart.VISUAL_ID:
			// We want to additionally show the Canvas Semantical Element in the auxiliary 
			// org.eclipse.uml2.diagram.component.edit.parts.Package2EditPart (that serves as a pure visual container for children). 
			// To do this, we modified CanonicalEditPolicy to add the Canvas semantic Element into the children 
			// list. The only remaining part is to return correct VID for this special case.

			if (containerView instanceof Diagram && domainElement != null && domainElement.equals(containerView.getElement())) {
				return Package2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getComponent().isSuperTypeOf(domainElement.eClass())) {
				return ComponentEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getArtifact().isSuperTypeOf(domainElement.eClass())) {
				return Artifact2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getInterface().isSuperTypeOf(domainElement.eClass())) {
				return Interface2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass()) && isClass_2004((Class) domainElement)) {
				return Class2EditPart.VISUAL_ID;
			}
			// Diagram header is already processed above
			if (UMLPackage.eINSTANCE.getPackage().isSuperTypeOf(domainElement.eClass())) {
				return Package3EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass()) && isClass_2007((Class) domainElement)) {
				return ClassDiagramNotationClassEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())) {
				return CommentEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = org.eclipse.uml2.diagram.component.part.UMLVisualIDRegistry.getModelID(containerView);
		if (!PackageEditPart.MODEL_ID.equals(containerModelID) && !"UMLComponent".equals(containerModelID)) { //$NON-NLS-1$
			return false;
		}
		int containerVisualID;
		if (PackageEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.eclipse.uml2.diagram.component.part.UMLVisualIDRegistry.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = PackageEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case ComponentEditPart.VISUAL_ID:
			if (ComponentName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ComponentStereoEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ComponentContentsEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PortEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Artifact2EditPart.VISUAL_ID:
			if (ArtifactName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ArtifactStereoEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ArtifactContents3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Interface2EditPart.VISUAL_ID:
			if (InterfaceName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Class2EditPart.VISUAL_ID:
			if (ClassName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PortEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Package2EditPart.VISUAL_ID:
			if (PackageNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PackageStereo2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PackageImportsEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Package3EditPart.VISUAL_ID:
			if (PackageName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PackagePackagesEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PackageClassifiersEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ClassDiagramNotationClassEditPart.VISUAL_ID:
			if (ClassDiagramNotationClassNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ClassDiagramNotationClassStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ClassAttributesEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ClassOperationsEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ClassClassesEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PortOnClassEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case CommentEditPart.VISUAL_ID:
			if (CommentBodyEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Component2EditPart.VISUAL_ID:
			if (ComponentNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ComponentStereo2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ComponentContents2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PortEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PortEditPart.VISUAL_ID:
			if (PortNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ArtifactEditPart.VISUAL_ID:
			if (ArtifactNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ArtifactStereo2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ArtifactContentsEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Artifact3EditPart.VISUAL_ID:
			if (ArtifactName3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ArtifactStereo3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ArtifactContents2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ClassEditPart.VISUAL_ID:
			if (ClassNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PortEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InterfaceEditPart.VISUAL_ID:
			if (InterfaceNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PropertyEditPart.VISUAL_ID:
			if (PropertyNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PortOnClassEditPart.VISUAL_ID:
			if (PortName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ComponentContentsEditPart.VISUAL_ID:
			if (Component2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ArtifactEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ClassEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InterfaceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PropertyEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AssemblyConnectorCircleEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ComponentContents2EditPart.VISUAL_ID:
			if (Component2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ArtifactEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ClassEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InterfaceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PropertyEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AssemblyConnectorCircleEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ArtifactContentsEditPart.VISUAL_ID:
			if (Artifact3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ArtifactContents2EditPart.VISUAL_ID:
			if (Artifact3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ArtifactContents3EditPart.VISUAL_ID:
			if (Artifact3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PackageImportsEditPart.VISUAL_ID:
			if (ElementImportEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PackagePackagesEditPart.VISUAL_ID:
			if (Package4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PackageClassifiersEditPart.VISUAL_ID:
			if (Class3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Component3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ClassAttributesEditPart.VISUAL_ID:
			if (ClassDiagramNotationPropertyEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ClassOperationsEditPart.VISUAL_ID:
			if (ClassDiagramNotationOperationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ClassClassesEditPart.VISUAL_ID:
			if (ClassDiagramNotationInnerClassEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PackageEditPart.VISUAL_ID:
			if (ComponentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Artifact2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Interface2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Class2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Package2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Package3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ClassDiagramNotationClassEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CommentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DependencyEditPart.VISUAL_ID:
			if (DependencyNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case AssociationEditPart.VISUAL_ID:
			if (AssociationNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AssociationName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AssociationName3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AssociationName4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AssociationName5EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AssociationName6EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AssociationName7EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static int getLinkWithClassVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (UMLPackage.eINSTANCE.getInterfaceRealization().isSuperTypeOf(domainElement.eClass()) && isInterfaceRealization_4001((InterfaceRealization) domainElement)) {
			return InterfaceRealizationEditPart.VISUAL_ID;
		}
		if (UMLPackage.eINSTANCE.getConnector().isSuperTypeOf(domainElement.eClass()) && isConnector_4008((Connector) domainElement)) {
			return ConnectorEditPart.VISUAL_ID;
		}
		if (UMLPackage.eINSTANCE.getDependency().isSuperTypeOf(domainElement.eClass()) && isDependency_4009((Dependency) domainElement)) {
			return DependencyEditPart.VISUAL_ID;
		}
		if (UMLPackage.eINSTANCE.getAssociation().isSuperTypeOf(domainElement.eClass())) {
			return AssociationEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static boolean isDiagram(Package element) {
		return true;
	}

	/**
	 * @generated
	 */
	private static boolean isClass_2004(Class domainElement) {
		if (Class_2004_Constraint == null) { // lazy initialization
			Class_2004_Constraint = UMLOCLFactory.getExpression("self.oclIsKindOf(uml::Class)", UMLPackage.eINSTANCE.getClass_()); //$NON-NLS-1$
		}
		Object result = Class_2004_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isClass_2007(Class domainElement) {
		if (Class_2007_Constraint == null) { // lazy initialization
			Class_2007_Constraint = UMLOCLFactory.getExpression("not oclIsKindOf(uml::AssociationClass) and not oclIsKindOf(uml::StateMachine)", UMLPackage.eINSTANCE.getClass_()); //$NON-NLS-1$
		}
		Object result = Class_2007_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isClass_3004(Class domainElement) {
		if (Class_3004_Constraint == null) { // lazy initialization
			Class_3004_Constraint = UMLOCLFactory.getExpression("self.oclIsKindOf(uml::Class)", UMLPackage.eINSTANCE.getClass_()); //$NON-NLS-1$
		}
		Object result = Class_3004_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isProperty_3006(Property domainElement) {
		if (Property_3006_Constraint == null) { // lazy initialization
			Property_3006_Constraint = UMLOCLFactory.getExpression("not oclIsKindOf(uml::Port) and self.association = null", UMLPackage.eINSTANCE.getProperty()); //$NON-NLS-1$
		}
		Object result = Property_3006_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isConnector_3015(Connector domainElement) {
		if (Connector_3015_Constraint == null) { // lazy initialization
			Connector_3015_Constraint = UMLOCLFactory.getExpression("kind =ConnectorKind::assembly", UMLPackage.eINSTANCE.getConnector()); //$NON-NLS-1$
		}
		Object result = Connector_3015_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isClass_3009(Class domainElement) {
		if (Class_3009_Constraint == null) { // lazy initialization
			Class_3009_Constraint = UMLOCLFactory.getExpression("not oclIsTypeOf(uml::Component)", UMLPackage.eINSTANCE.getClass_()); //$NON-NLS-1$
		}
		Object result = Class_3009_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isProperty_3011(Property domainElement) {
		if (Property_3011_Constraint == null) { // lazy initialization
			Property_3011_Constraint = UMLOCLFactory.getExpression("not oclIsKindOf(uml::Port) and self.association = null", UMLPackage.eINSTANCE.getProperty()); //$NON-NLS-1$
		}
		Object result = Property_3011_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isInterfaceRealization_4001(InterfaceRealization domainElement) {
		if (InterfaceRealization_4001_Constraint == null) { // lazy initialization
			InterfaceRealization_4001_Constraint = UMLOCLFactory.getExpression("self.implementingClassifier.oclIsKindOf(uml::Component)", UMLPackage.eINSTANCE.getInterfaceRealization()); //$NON-NLS-1$
		}
		Object result = InterfaceRealization_4001_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isConnector_4008(Connector domainElement) {
		if (Connector_4008_Constraint == null) { // lazy initialization
			Connector_4008_Constraint = UMLOCLFactory.getExpression("kind =ConnectorKind::delegation", UMLPackage.eINSTANCE.getConnector()); //$NON-NLS-1$
		}
		Object result = Connector_4008_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isDependency_4009(Dependency domainElement) {
		if (Dependency_4009_Constraint == null) { // lazy initialization
			Dependency_4009_Constraint = UMLOCLFactory
					.getExpression(
							"(self.oclIsTypeOf(uml::Dependency) or self.oclIsTypeOf(uml::Abstraction) or self.oclIsTypeOf(uml::Substitution) or self.oclIsTypeOf(uml::Usage)) and self.supplier->size() = 1 and self.client->size() = 1 and self.supplier->forAll(e|not e.oclIsKindOf(uml::Interface))", UMLPackage.eINSTANCE.getDependency()); //$NON-NLS-1$
		}
		Object result = Dependency_4009_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	protected static boolean hasViewChild(View containerView, EObject domainElement, int visualId) {
		if (containerView == null) {
			return false;
		}
		if (domainElement == null) {
			return false;
		}
		for (Object next : containerView.getChildren()) {
			View nextView = (View) next;
			if (domainElement.equals(nextView.getElement()) && getType(visualId).equals(nextView.getType())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static int getChildDescriptorVisualID(UMLNodeDescriptor container, EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		switch (container.getVisualID()) {
		case ComponentEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getPort().isSuperTypeOf(domainElement.eClass())) {
				return PortEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getComponent().isSuperTypeOf(domainElement.eClass())) {
				return Component2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getArtifact().isSuperTypeOf(domainElement.eClass())) {
				return ArtifactEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass()) && isClass_3004((Class) domainElement)) {
				return ClassEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getInterface().isSuperTypeOf(domainElement.eClass())) {
				return InterfaceEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass()) && isProperty_3006((Property) domainElement)) {
				return PropertyEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getConnector().isSuperTypeOf(domainElement.eClass()) && isConnector_3015((Connector) domainElement)) {
				return AssemblyConnectorCircleEditPart.VISUAL_ID;
			}
			break;
		case Artifact2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getArtifact().isSuperTypeOf(domainElement.eClass())) {
				return Artifact3EditPart.VISUAL_ID;
			}
			break;
		case Class2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getPort().isSuperTypeOf(domainElement.eClass())) {
				return PortEditPart.VISUAL_ID;
			}
			break;
		case Package2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getElementImport().isSuperTypeOf(domainElement.eClass())) {
				return ElementImportEditPart.VISUAL_ID;
			}
			break;
		case Package3EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getPackage().isSuperTypeOf(domainElement.eClass())) {
				return Package4EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass()) && isClass_3009((Class) domainElement)) {
				return Class3EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getComponent().isSuperTypeOf(domainElement.eClass())) {
				return Component3EditPart.VISUAL_ID;
			}
			break;
		case ClassDiagramNotationClassEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getPort().isSuperTypeOf(domainElement.eClass())) {
				return PortOnClassEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass()) && isProperty_3011((Property) domainElement)) {
				return ClassDiagramNotationPropertyEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getOperation().isSuperTypeOf(domainElement.eClass())) {
				return ClassDiagramNotationOperationEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass())) {
				return ClassDiagramNotationInnerClassEditPart.VISUAL_ID;
			}
			break;
		case Component2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getPort().isSuperTypeOf(domainElement.eClass())) {
				return PortEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getComponent().isSuperTypeOf(domainElement.eClass())) {
				return Component2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getArtifact().isSuperTypeOf(domainElement.eClass())) {
				return ArtifactEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass()) && isClass_3004((Class) domainElement)) {
				return ClassEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getInterface().isSuperTypeOf(domainElement.eClass())) {
				return InterfaceEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass()) && isProperty_3006((Property) domainElement)) {
				return PropertyEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getConnector().isSuperTypeOf(domainElement.eClass()) && isConnector_3015((Connector) domainElement)) {
				return AssemblyConnectorCircleEditPart.VISUAL_ID;
			}
			break;
		case ArtifactEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getArtifact().isSuperTypeOf(domainElement.eClass())) {
				return Artifact3EditPart.VISUAL_ID;
			}
			break;
		case Artifact3EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getArtifact().isSuperTypeOf(domainElement.eClass())) {
				return Artifact3EditPart.VISUAL_ID;
			}
			break;
		case ClassEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getPort().isSuperTypeOf(domainElement.eClass())) {
				return PortEditPart.VISUAL_ID;
			}
			break;
		case PackageEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getComponent().isSuperTypeOf(domainElement.eClass())) {
				return ComponentEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getArtifact().isSuperTypeOf(domainElement.eClass())) {
				return Artifact2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getInterface().isSuperTypeOf(domainElement.eClass())) {
				return Interface2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass()) && isClass_2004((Class) domainElement)) {
				return Class2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPackage().isSuperTypeOf(domainElement.eClass())) {
				return Package3EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass()) && isClass_2007((Class) domainElement)) {
				return ClassDiagramNotationClassEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())) {
				return CommentEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	protected static boolean canSubstitute(int visualId, int substituteCandidate) {
		if (visualId == substituteCandidate) {
			return true;
		}
		switch (visualId) {
		case Class2EditPart.VISUAL_ID:
			return (substituteCandidate == ClassDiagramNotationClassEditPart.VISUAL_ID);
		case ClassDiagramNotationClassEditPart.VISUAL_ID:
			return (substituteCandidate == Class2EditPart.VISUAL_ID);

		default:
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static boolean checkNodeVisualID(View containerView, EObject domainElement, int candidate) {
		if (candidate == -1) {
			//unrecognized id is always bad
			return false;
		}
		int basic = getNodeVisualID(containerView, domainElement);
		return basic == candidate || canSubstitute(basic, candidate);
	}

	/**
	 * @generated
	 */
	public static boolean isCompartmentVisualID(int visualID) {
		switch (visualID) {
		case ComponentContentsEditPart.VISUAL_ID:
		case ComponentContents2EditPart.VISUAL_ID:
		case ArtifactContentsEditPart.VISUAL_ID:
		case ArtifactContents2EditPart.VISUAL_ID:
		case ArtifactContents3EditPart.VISUAL_ID:
		case PackageImportsEditPart.VISUAL_ID:
		case PackagePackagesEditPart.VISUAL_ID:
		case PackageClassifiersEditPart.VISUAL_ID:
		case ClassAttributesEditPart.VISUAL_ID:
		case ClassOperationsEditPart.VISUAL_ID:
		case ClassClassesEditPart.VISUAL_ID:
			return true;
		default:
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static boolean isSemanticLeafVisualID(int visualID) {
		switch (visualID) {
		case Interface2EditPart.VISUAL_ID:
		case CommentEditPart.VISUAL_ID:
		case PortEditPart.VISUAL_ID:
		case InterfaceEditPart.VISUAL_ID:
		case PropertyEditPart.VISUAL_ID:
		case AssemblyConnectorCircleEditPart.VISUAL_ID:
		case ElementImportEditPart.VISUAL_ID:
		case Package4EditPart.VISUAL_ID:
		case Class3EditPart.VISUAL_ID:
		case Component3EditPart.VISUAL_ID:
		case ClassDiagramNotationPropertyEditPart.VISUAL_ID:
		case ClassDiagramNotationOperationEditPart.VISUAL_ID:
		case ClassDiagramNotationInnerClassEditPart.VISUAL_ID:
		case PortOnClassEditPart.VISUAL_ID:
			return true;
		default:
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static final IVisualIDRegistry TYPED_ADAPTER = new IVisualIDRegistry() {

		/**
		 * @generated
		 */
		public String getModelID(View view) {
			return org.eclipse.uml2.diagram.component.part.UMLVisualIDRegistry.getModelID(view);
		}

		/**
		 * @generated
		 */
		public int getVisualID(View view) {
			return org.eclipse.uml2.diagram.component.part.UMLVisualIDRegistry.getVisualID(view);
		}

		/**
		 * @generated
		 */
		public int getNodeVisualID(View containerView, EObject domainElement) {
			return org.eclipse.uml2.diagram.component.part.UMLVisualIDRegistry.getNodeVisualID(containerView, domainElement);
		}

		/**
		 * @generated
		 */
		public boolean checkNodeVisualID(View containerView, EObject domainElement, int candidate) {
			return org.eclipse.uml2.diagram.component.part.UMLVisualIDRegistry.checkNodeVisualID(containerView, domainElement, candidate);
		}

		/**
		 * @generated
		 */
		public boolean isCompartmentVisualID(int visualID) {
			return org.eclipse.uml2.diagram.component.part.UMLVisualIDRegistry.isCompartmentVisualID(visualID);
		}

		/**
		 * @generated
		 */
		public boolean isSemanticLeafVisualID(int visualID) {
			return org.eclipse.uml2.diagram.component.part.UMLVisualIDRegistry.isSemanticLeafVisualID(visualID);
		}

		/**
		 * @generated
		 */
		public boolean isShortcutDescendant(View view) {
			return org.eclipse.uml2.diagram.component.part.UMLVisualIDRegistry.isShortcutDescendant(view);
		}

	};

	/**
	 * @generated
	 */
	public static boolean isShortcutDescendant(View view) {
		View diagram = view.getDiagram();
		while (view != diagram && view != null) {
			EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
			if (annotation != null) {
				return true;
			}
			view = (View) view.eContainer();
		}
		return false;
	}

}
