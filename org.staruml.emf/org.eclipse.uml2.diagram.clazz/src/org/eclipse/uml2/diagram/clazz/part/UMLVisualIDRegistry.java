package org.eclipse.uml2.diagram.clazz.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.clazz.edit.parts.*;
import org.eclipse.uml2.diagram.clazz.expressions.UMLAbstractExpression;
import org.eclipse.uml2.diagram.clazz.expressions.UMLOCLFactory;
import org.eclipse.uml2.diagram.common.genapi.IVisualIDRegistry;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.InterfaceRealization;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Realization;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.Usage;

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
	private static final String DEBUG_KEY = "org.eclipse.uml2.diagram.clazz/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private static UMLAbstractExpression Class_2001_Constraint;

	/**
	 * @generated
	 */
	private static UMLAbstractExpression DataType_2004_Constraint;

	/**
	 * @generated
	 */
	private static UMLAbstractExpression Dependency_2009_Constraint;

	/**
	 * @generated
	 */
	private static UMLAbstractExpression Class_3007_Constraint;

	/**
	 * @generated
	 */
	private static UMLAbstractExpression DataType_3008_Constraint;

	/**
	 * @generated
	 */
	private static UMLAbstractExpression Property_3001_Constraint;

	/**
	 * @generated
	 */
	private static UMLAbstractExpression Class_3003_Constraint;

	/**
	 * @generated
	 */
	private static UMLAbstractExpression Slot_3017_Constraint;

	/**
	 * @generated
	 */
	private static UMLAbstractExpression Property_3028_Constraint;

	/**
	 * @generated
	 */
	private static UMLAbstractExpression Class_3030_Constraint;

	/**
	 * @generated
	 */
	private static UMLAbstractExpression Class_3033_Constraint;

	/**
	 * @generated
	 */
	private static UMLAbstractExpression DataType_3036_Constraint;

	/**
	 * @generated
	 */
	private static UMLAbstractExpression Generalization_4001_Constraint;

	/**
	 * @generated
	 */
	private static UMLAbstractExpression Dependency_4002_Constraint;

	/**
	 * @generated
	 */
	private static UMLAbstractExpression Property_4003_Constraint;

	/**
	 * @generated
	 */
	private static UMLAbstractExpression Association_4005_Constraint;

	/**
	 * @generated
	 */
	private static UMLAbstractExpression InterfaceRealization_4008_Constraint;

	/**
	 * @generated
	 */
	private static UMLAbstractExpression Realization_4010_Constraint;

	/**
	 * @generated
	 */
	private static UMLAbstractExpression Usage_4013_Constraint;

	/**
	 * @generated
	 */
	private static UMLAbstractExpression Slot_4015_Constraint;

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
		return org.eclipse.uml2.diagram.clazz.part.UMLVisualIDRegistry.getVisualID(view.getType());
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
		String containerModelID = org.eclipse.uml2.diagram.clazz.part.UMLVisualIDRegistry.getModelID(containerView);
		if (!PackageEditPart.MODEL_ID.equals(containerModelID) && !"UMLClass".equals(containerModelID)) { //$NON-NLS-1$
			return -1;
		}
		int containerVisualID;
		if (PackageEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.eclipse.uml2.diagram.clazz.part.UMLVisualIDRegistry.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = PackageEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case Class2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getPort().isSuperTypeOf(domainElement.eClass())) {
				return PortEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getRedefinableTemplateSignature().isSuperTypeOf(domainElement.eClass())) {
				return RedefinableTemplateSignatureEditPart.VISUAL_ID;
			}
			break;
		case AssociationClass2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getRedefinableTemplateSignature().isSuperTypeOf(domainElement.eClass())) {
				return RedefinableTemplateSignatureEditPart.VISUAL_ID;
			}
			break;
		case DataType2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getRedefinableTemplateSignature().isSuperTypeOf(domainElement.eClass())) {
				return RedefinableTemplateSignatureEditPart.VISUAL_ID;
			}
			break;
		case PrimitiveType2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getRedefinableTemplateSignature().isSuperTypeOf(domainElement.eClass())) {
				return RedefinableTemplateSignatureEditPart.VISUAL_ID;
			}
			break;
		case Enumeration2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getRedefinableTemplateSignature().isSuperTypeOf(domainElement.eClass())) {
				return RedefinableTemplateSignatureEditPart.VISUAL_ID;
			}
			break;
		case InstanceSpecification4EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getLiteralInteger().isSuperTypeOf(domainElement.eClass())) {
				return LiteralIntegerEditPart.VISUAL_ID;
			}
			break;
		case Class5EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getPort().isSuperTypeOf(domainElement.eClass())) {
				return PortEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getRedefinableTemplateSignature().isSuperTypeOf(domainElement.eClass())) {
				return RedefinableTemplateSignatureEditPart.VISUAL_ID;
			}
			break;
		case Enumeration3EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getRedefinableTemplateSignature().isSuperTypeOf(domainElement.eClass())) {
				return RedefinableTemplateSignatureEditPart.VISUAL_ID;
			}
			break;
		case DataType3EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getRedefinableTemplateSignature().isSuperTypeOf(domainElement.eClass())) {
				return RedefinableTemplateSignatureEditPart.VISUAL_ID;
			}
			break;
		case PrimitiveType3EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getRedefinableTemplateSignature().isSuperTypeOf(domainElement.eClass())) {
				return RedefinableTemplateSignatureEditPart.VISUAL_ID;
			}
			break;
		case PackagePackagesEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getPackage().isSuperTypeOf(domainElement.eClass())) {
				return Package3EditPart.VISUAL_ID;
			}
			break;
		case PackageClassifiersEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass()) && isClass_3007((Class) domainElement)) {
				return ClassEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getDataType().isSuperTypeOf(domainElement.eClass()) && isDataType_3008((DataType) domainElement)) {
				return DataTypeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPrimitiveType().isSuperTypeOf(domainElement.eClass())) {
				return PrimitiveTypeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getEnumeration().isSuperTypeOf(domainElement.eClass())) {
				return EnumerationEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getAssociationClass().isSuperTypeOf(domainElement.eClass())) {
				return AssociationClassEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getInterface().isSuperTypeOf(domainElement.eClass())) {
				return Interface3EditPart.VISUAL_ID;
			}
			break;
		case PackageOtherEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getInstanceSpecification().isSuperTypeOf(domainElement.eClass())) {
				return InstanceSpecificationEditPart.VISUAL_ID;
			}
			break;
		case ClassAttributesEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass()) && isProperty_3001((Property) domainElement)) {
				return PropertyEditPart.VISUAL_ID;
			}
			break;
		case ClassOperationsEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getOperation().isSuperTypeOf(domainElement.eClass())) {
				return OperationEditPart.VISUAL_ID;
			}
			break;
		case ClassClassesEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass()) && isClass_3003((Class) domainElement)) {
				return Class3EditPart.VISUAL_ID;
			}
			break;
		case AssociationClassAttributesEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass())) {
				return Property2EditPart.VISUAL_ID;
			}
			break;
		case AssociationClassOperationsEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getOperation().isSuperTypeOf(domainElement.eClass())) {
				return Operation2EditPart.VISUAL_ID;
			}
			break;
		case AssociationClassClassesEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass()) && isClass_3003((Class) domainElement)) {
				return Class3EditPart.VISUAL_ID;
			}
			break;
		case DataTypeAttributesEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass())) {
				return Property3EditPart.VISUAL_ID;
			}
			break;
		case DataTypeOperationsEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getOperation().isSuperTypeOf(domainElement.eClass())) {
				return Operation3EditPart.VISUAL_ID;
			}
			break;
		case PrimitiveTypeAttributesEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass())) {
				return Property4EditPart.VISUAL_ID;
			}
			break;
		case PrimitiveTypeOperationsEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getOperation().isSuperTypeOf(domainElement.eClass())) {
				return Operation4EditPart.VISUAL_ID;
			}
			break;
		case EnumerationLiteralsEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getEnumerationLiteral().isSuperTypeOf(domainElement.eClass())) {
				return EnumerationLiteralEditPart.VISUAL_ID;
			}
			break;
		case EnumerationAttributesEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass())) {
				return Property5EditPart.VISUAL_ID;
			}
			break;
		case EnumerationOperationsEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getOperation().isSuperTypeOf(domainElement.eClass())) {
				return Operation5EditPart.VISUAL_ID;
			}
			break;
		case InstanceSpecificationSlotsEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getSlot().isSuperTypeOf(domainElement.eClass()) && isSlot_3017((Slot) domainElement)) {
				return SlotEditPart.VISUAL_ID;
			}
			break;
		case InterfaceAttributesEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass()) && isProperty_3028((Property) domainElement)) {
				return Property6EditPart.VISUAL_ID;
			}
			break;
		case InterfaceOperationsEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getOperation().isSuperTypeOf(domainElement.eClass())) {
				return Operation6EditPart.VISUAL_ID;
			}
			break;
		case InterfaceClassesEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass()) && isClass_3030((Class) domainElement)) {
				return Class4EditPart.VISUAL_ID;
			}
			break;
		case PackageImportsEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getElementImport().isSuperTypeOf(domainElement.eClass())) {
				return ElementImportEditPart.VISUAL_ID;
			}
			break;
		case PackageAsFrameContentsEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getPackage().isSuperTypeOf(domainElement.eClass())) {
				return Package6EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass()) && isClass_3033((Class) domainElement)) {
				return Class5EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getEnumeration().isSuperTypeOf(domainElement.eClass())) {
				return Enumeration3EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getInstanceSpecification().isSuperTypeOf(domainElement.eClass())) {
				return InstanceSpecification3EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getDataType().isSuperTypeOf(domainElement.eClass()) && isDataType_3036((DataType) domainElement)) {
				return DataType3EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPrimitiveType().isSuperTypeOf(domainElement.eClass())) {
				return PrimitiveType3EditPart.VISUAL_ID;
			}
			break;
		case PackageAsFrameContents2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getPackage().isSuperTypeOf(domainElement.eClass())) {
				return Package6EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass()) && isClass_3033((Class) domainElement)) {
				return Class5EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getEnumeration().isSuperTypeOf(domainElement.eClass())) {
				return Enumeration3EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getInstanceSpecification().isSuperTypeOf(domainElement.eClass())) {
				return InstanceSpecification3EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getDataType().isSuperTypeOf(domainElement.eClass()) && isDataType_3036((DataType) domainElement)) {
				return DataType3EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPrimitiveType().isSuperTypeOf(domainElement.eClass())) {
				return PrimitiveType3EditPart.VISUAL_ID;
			}
			break;
		case ClassAttributes2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass()) && isProperty_3001((Property) domainElement)) {
				return PropertyEditPart.VISUAL_ID;
			}
			break;
		case ClassOperations2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getOperation().isSuperTypeOf(domainElement.eClass())) {
				return OperationEditPart.VISUAL_ID;
			}
			break;
		case ClassClasses2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass()) && isClass_3003((Class) domainElement)) {
				return Class3EditPart.VISUAL_ID;
			}
			break;
		case EnumerationLiterals2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getEnumerationLiteral().isSuperTypeOf(domainElement.eClass())) {
				return EnumerationLiteralEditPart.VISUAL_ID;
			}
			break;
		case EnumerationAttributes2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass())) {
				return Property5EditPart.VISUAL_ID;
			}
			break;
		case EnumerationOperations2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getOperation().isSuperTypeOf(domainElement.eClass())) {
				return Operation5EditPart.VISUAL_ID;
			}
			break;
		case InstanceSpecificationSlots2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getSlot().isSuperTypeOf(domainElement.eClass()) && isSlot_3017((Slot) domainElement)) {
				return SlotEditPart.VISUAL_ID;
			}
			break;
		case DataTypeAttributes2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass())) {
				return Property3EditPart.VISUAL_ID;
			}
			break;
		case DataTypeOperations2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getOperation().isSuperTypeOf(domainElement.eClass())) {
				return Operation3EditPart.VISUAL_ID;
			}
			break;
		case PrimitiveTypeAttributes2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass())) {
				return Property4EditPart.VISUAL_ID;
			}
			break;
		case PrimitiveTypeOperations2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getOperation().isSuperTypeOf(domainElement.eClass())) {
				return Operation4EditPart.VISUAL_ID;
			}
			break;
		case InstanceSpecificationValueEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getLiteralString().isSuperTypeOf(domainElement.eClass())) {
				return LiteralStringEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getExpression().isSuperTypeOf(domainElement.eClass())) {
				return ExpressionEditPart.VISUAL_ID;
			}
			break;
		case PackageEditPart.VISUAL_ID:
			// We want to additionally show the Canvas Semantical Element in the auxiliary 
			// org.eclipse.uml2.diagram.clazz.edit.parts.Package4EditPart (that serves as a pure visual container for children). 
			// To do this, we modified CanonicalEditPolicy to add the Canvas semantic Element into the children 
			// list. The only remaining part is to return correct VID for this special case.

			if (containerView instanceof Diagram && domainElement != null && domainElement.equals(containerView.getElement())) {
				return Package4EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPackage().isSuperTypeOf(domainElement.eClass())) {
				return Package2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass()) && isClass_2001((Class) domainElement)) {
				return Class2EditPart.VISUAL_ID;
			}
			// there is a group of nodes for single semantic element
			// the group for this element consists of 
			// org.eclipse.uml2.diagram.clazz.edit.parts.AssociationClass2EditPart.VISUAL_ID
			// org.eclipse.uml2.diagram.clazz.edit.parts.AssociationClassRhombEditPart.VISUAL_ID
			// diagram updater is expected to return one node descriptor (and thus one instance of that semantic element) per node in group
			// we need to give other parts a chance to create their views
			if (UMLPackage.eINSTANCE.getAssociationClass().isSuperTypeOf(domainElement.eClass()) && !hasViewChild(containerView, domainElement, AssociationClass2EditPart.VISUAL_ID)) {
				return AssociationClass2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getDataType().isSuperTypeOf(domainElement.eClass()) && isDataType_2004((DataType) domainElement)) {
				return DataType2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPrimitiveType().isSuperTypeOf(domainElement.eClass())) {
				return PrimitiveType2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getEnumeration().isSuperTypeOf(domainElement.eClass())) {
				return Enumeration2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getInterface().isSuperTypeOf(domainElement.eClass())) {
				return InterfaceEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getConstraint().isSuperTypeOf(domainElement.eClass())) {
				return ConstraintEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getInstanceSpecification().isSuperTypeOf(domainElement.eClass())) {
				return InstanceSpecification2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getDependency().isSuperTypeOf(domainElement.eClass()) && isDependency_2009((Dependency) domainElement)) {
				return DependencyEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getGeneralizationSet().isSuperTypeOf(domainElement.eClass())) {
				return GeneralizationSetEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getInterface().isSuperTypeOf(domainElement.eClass())) {
				return Interface2EditPart.VISUAL_ID;
			}
			// Diagram header is already processed above
			// there is a group of nodes for single semantic element
			// the group for this element consists of 
			// org.eclipse.uml2.diagram.clazz.edit.parts.AssociationClassRhombEditPart.VISUAL_ID
			// org.eclipse.uml2.diagram.clazz.edit.parts.AssociationClass2EditPart.VISUAL_ID
			// diagram updater is expected to return one node descriptor (and thus one instance of that semantic element) per node in group
			// we need to give other parts a chance to create their views
			if (UMLPackage.eINSTANCE.getAssociationClass().isSuperTypeOf(domainElement.eClass()) && !hasViewChild(containerView, domainElement, AssociationClassRhombEditPart.VISUAL_ID)) {
				return AssociationClassRhombEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPackage().isSuperTypeOf(domainElement.eClass())) {
				return PackageAsFrameEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getInstanceSpecification().isSuperTypeOf(domainElement.eClass())) {
				return InstanceSpecification4EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())) {
				return CommentEditPart.VISUAL_ID;
			}
			// "escape" for multi-views part : org.eclipse.uml2.diagram.clazz.edit.parts.PackageEditPart.VISUAL_ID -- prevents from removing the whole group from diagram
			if (UMLPackage.eINSTANCE.getAssociationClass().isSuperTypeOf(domainElement.eClass())) {
				return AssociationClass2EditPart.VISUAL_ID;
			}
			// "escape" for multi-views part : org.eclipse.uml2.diagram.clazz.edit.parts.PackageEditPart.VISUAL_ID -- prevents from removing the whole group from diagram
			if (UMLPackage.eINSTANCE.getAssociationClass().isSuperTypeOf(domainElement.eClass())) {
				return AssociationClassRhombEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = org.eclipse.uml2.diagram.clazz.part.UMLVisualIDRegistry.getModelID(containerView);
		if (!PackageEditPart.MODEL_ID.equals(containerModelID) && !"UMLClass".equals(containerModelID)) { //$NON-NLS-1$
			return false;
		}
		int containerVisualID;
		if (PackageEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.eclipse.uml2.diagram.clazz.part.UMLVisualIDRegistry.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = PackageEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case Package2EditPart.VISUAL_ID:
			if (PackageNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PackagePackagesEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PackageClassifiersEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PackageOtherEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Class2EditPart.VISUAL_ID:
			if (ClassNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ClassStereotypeEditPart.VISUAL_ID == nodeVisualID) {
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
			if (PortEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RedefinableTemplateSignatureEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case AssociationClass2EditPart.VISUAL_ID:
			if (AssociationClassNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AssociationClassStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AssociationClassAttributesEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AssociationClassOperationsEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AssociationClassClassesEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RedefinableTemplateSignatureEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DataType2EditPart.VISUAL_ID:
			if (DataTypeNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataTypeStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataTypeAttributesEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataTypeOperationsEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RedefinableTemplateSignatureEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PrimitiveType2EditPart.VISUAL_ID:
			if (PrimitiveTypeNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PrimitiveTypeStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PrimitiveTypeAttributesEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PrimitiveTypeOperationsEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RedefinableTemplateSignatureEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Enumeration2EditPart.VISUAL_ID:
			if (EnumerationNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnumerationStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnumerationLiteralsEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnumerationAttributesEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnumerationOperationsEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RedefinableTemplateSignatureEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InterfaceEditPart.VISUAL_ID:
			if (InterfaceNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ConstraintEditPart.VISUAL_ID:
			if (ConstraintNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ConstraintLanguageEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InstanceSpecification2EditPart.VISUAL_ID:
			if (InstanceSpecificationNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InstanceSpecificationStereoEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InstanceSpecificationSlotsEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DependencyEditPart.VISUAL_ID:
			if (DependencyNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case GeneralizationSetEditPart.VISUAL_ID:
			if (GeneralizationSetIsCoveringIsDisjointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (GeneralizationSetNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Interface2EditPart.VISUAL_ID:
			if (InterfaceName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InterfaceStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InterfaceAttributesEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InterfaceOperationsEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InterfaceClassesEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Package4EditPart.VISUAL_ID:
			if (PackageName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PackageStereo2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PackageImportsEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PackageAsFrameEditPart.VISUAL_ID:
			if (PackageName3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PackageAsFrameContentsEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InstanceSpecification4EditPart.VISUAL_ID:
			if (InstanceSpecificationName3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InstanceSpecificationValueEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LiteralIntegerEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case CommentEditPart.VISUAL_ID:
			if (CommentBodyEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PortEditPart.VISUAL_ID:
			if (PortNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case RedefinableTemplateSignatureEditPart.VISUAL_ID:
			if (TemplateSignatureNode_signatureEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Package6EditPart.VISUAL_ID:
			if (PackageName4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PackageAsFrameContents2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Class5EditPart.VISUAL_ID:
			if (ClassName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ClassStereotype2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ClassAttributes2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ClassOperations2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ClassClasses2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PortEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RedefinableTemplateSignatureEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Enumeration3EditPart.VISUAL_ID:
			if (EnumerationName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnumerationStereotype2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnumerationLiterals2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnumerationAttributes2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnumerationOperations2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RedefinableTemplateSignatureEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InstanceSpecification3EditPart.VISUAL_ID:
			if (InstanceSpecificationName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InstanceSpecificationStereo2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InstanceSpecificationSlots2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DataType3EditPart.VISUAL_ID:
			if (DataTypeName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataTypeStereotype2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataTypeAttributes2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataTypeOperations2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RedefinableTemplateSignatureEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PrimitiveType3EditPart.VISUAL_ID:
			if (PrimitiveTypeName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PrimitiveTypeStereotype2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PrimitiveTypeAttributes2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PrimitiveTypeOperations2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RedefinableTemplateSignatureEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PackagePackagesEditPart.VISUAL_ID:
			if (Package3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PackageClassifiersEditPart.VISUAL_ID:
			if (ClassEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataTypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PrimitiveTypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnumerationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AssociationClassEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Interface3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PackageOtherEditPart.VISUAL_ID:
			if (InstanceSpecificationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ClassAttributesEditPart.VISUAL_ID:
			if (PropertyEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ClassOperationsEditPart.VISUAL_ID:
			if (OperationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ClassClassesEditPart.VISUAL_ID:
			if (Class3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case AssociationClassAttributesEditPart.VISUAL_ID:
			if (Property2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case AssociationClassOperationsEditPart.VISUAL_ID:
			if (Operation2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case AssociationClassClassesEditPart.VISUAL_ID:
			if (Class3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DataTypeAttributesEditPart.VISUAL_ID:
			if (Property3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DataTypeOperationsEditPart.VISUAL_ID:
			if (Operation3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PrimitiveTypeAttributesEditPart.VISUAL_ID:
			if (Property4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PrimitiveTypeOperationsEditPart.VISUAL_ID:
			if (Operation4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EnumerationLiteralsEditPart.VISUAL_ID:
			if (EnumerationLiteralEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EnumerationAttributesEditPart.VISUAL_ID:
			if (Property5EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EnumerationOperationsEditPart.VISUAL_ID:
			if (Operation5EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InstanceSpecificationSlotsEditPart.VISUAL_ID:
			if (SlotEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InterfaceAttributesEditPart.VISUAL_ID:
			if (Property6EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InterfaceOperationsEditPart.VISUAL_ID:
			if (Operation6EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InterfaceClassesEditPart.VISUAL_ID:
			if (Class4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PackageImportsEditPart.VISUAL_ID:
			if (ElementImportEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PackageAsFrameContentsEditPart.VISUAL_ID:
			if (Package6EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Class5EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Enumeration3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InstanceSpecification3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataType3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PrimitiveType3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PackageAsFrameContents2EditPart.VISUAL_ID:
			if (Package6EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Class5EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Enumeration3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InstanceSpecification3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataType3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PrimitiveType3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ClassAttributes2EditPart.VISUAL_ID:
			if (PropertyEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ClassOperations2EditPart.VISUAL_ID:
			if (OperationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ClassClasses2EditPart.VISUAL_ID:
			if (Class3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EnumerationLiterals2EditPart.VISUAL_ID:
			if (EnumerationLiteralEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EnumerationAttributes2EditPart.VISUAL_ID:
			if (Property5EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EnumerationOperations2EditPart.VISUAL_ID:
			if (Operation5EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InstanceSpecificationSlots2EditPart.VISUAL_ID:
			if (SlotEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DataTypeAttributes2EditPart.VISUAL_ID:
			if (Property3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DataTypeOperations2EditPart.VISUAL_ID:
			if (Operation3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PrimitiveTypeAttributes2EditPart.VISUAL_ID:
			if (Property4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PrimitiveTypeOperations2EditPart.VISUAL_ID:
			if (Operation4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InstanceSpecificationValueEditPart.VISUAL_ID:
			if (LiteralStringEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ExpressionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PackageEditPart.VISUAL_ID:
			if (Package2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Class2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AssociationClass2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataType2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PrimitiveType2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Enumeration2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InterfaceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ConstraintEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InstanceSpecification2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DependencyEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (GeneralizationSetEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Interface2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Package4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AssociationClassRhombEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PackageAsFrameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InstanceSpecification4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CommentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case GeneralizationEditPart.VISUAL_ID:
			if (GeneralizationStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Dependency2EditPart.VISUAL_ID:
			if (DependencyName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DependencyName3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Property7EditPart.VISUAL_ID:
			if (PropertyNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PropertyName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PropertyName3EditPart.VISUAL_ID == nodeVisualID) {
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
			if (AssociationStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InterfaceRealizationEditPart.VISUAL_ID:
			if (InterfaceRealizationStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case RealizationEditPart.VISUAL_ID:
			if (RealizationNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RealizationStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Generalization2EditPart.VISUAL_ID:
			if (GeneralizationStereotype2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case UsageEditPart.VISUAL_ID:
			if (UsageStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case AssociationInstanceEditPart.VISUAL_ID:
			if (AssociationInstanceSourceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AssociationInstanceTargetEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case TemplateBindingEditPart.VISUAL_ID:
			if (TemplateBinding_BindLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TemplateParameterSubstitutionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TemplateBindingStereotypeEditPart.VISUAL_ID == nodeVisualID) {
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
		if (UMLPackage.eINSTANCE.getGeneralization().isSuperTypeOf(domainElement.eClass()) && isGeneralization_4001((Generalization) domainElement)) {
			return GeneralizationEditPart.VISUAL_ID;
		}
		if (UMLPackage.eINSTANCE.getDependency().isSuperTypeOf(domainElement.eClass()) && isDependency_4002((Dependency) domainElement)) {
			return Dependency2EditPart.VISUAL_ID;
		}
		if (UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass()) && isProperty_4003((Property) domainElement)) {
			return Property7EditPart.VISUAL_ID;
		}
		if (UMLPackage.eINSTANCE.getAssociation().isSuperTypeOf(domainElement.eClass()) && isAssociation_4005((Association) domainElement)) {
			return AssociationEditPart.VISUAL_ID;
		}
		if (UMLPackage.eINSTANCE.getInterfaceRealization().isSuperTypeOf(domainElement.eClass()) && isInterfaceRealization_4008((InterfaceRealization) domainElement)) {
			return InterfaceRealizationEditPart.VISUAL_ID;
		}
		if (UMLPackage.eINSTANCE.getRealization().isSuperTypeOf(domainElement.eClass()) && isRealization_4010((Realization) domainElement)) {
			return RealizationEditPart.VISUAL_ID;
		}
		if (UMLPackage.eINSTANCE.getGeneralization().isSuperTypeOf(domainElement.eClass())) {
			return Generalization2EditPart.VISUAL_ID;
		}
		if (UMLPackage.eINSTANCE.getUsage().isSuperTypeOf(domainElement.eClass()) && isUsage_4013((Usage) domainElement)) {
			return UsageEditPart.VISUAL_ID;
		}
		if (UMLPackage.eINSTANCE.getAssociationClass().isSuperTypeOf(domainElement.eClass())) {
			return AssociationClassConnectorEditPart.VISUAL_ID;
		}
		if (UMLPackage.eINSTANCE.getSlot().isSuperTypeOf(domainElement.eClass()) && isSlot_4015((Slot) domainElement)) {
			return AssociationInstanceEditPart.VISUAL_ID;
		}
		if (UMLPackage.eINSTANCE.getTemplateBinding().isSuperTypeOf(domainElement.eClass())) {
			return TemplateBindingEditPart.VISUAL_ID;
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
	private static boolean isClass_2001(Class domainElement) {
		if (Class_2001_Constraint == null) { // lazy initialization
			Class_2001_Constraint = UMLOCLFactory.getExpression("not oclIsKindOf(uml::AssociationClass) and not oclIsKindOf(uml::StateMachine)", UMLPackage.eINSTANCE.getClass_()); //$NON-NLS-1$
		}
		Object result = Class_2001_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isDataType_2004(DataType domainElement) {
		if (DataType_2004_Constraint == null) { // lazy initialization
			DataType_2004_Constraint = UMLOCLFactory.getExpression("not oclIsKindOf(uml::PrimitiveType) and not oclIsKindOf(uml::Enumeration)", UMLPackage.eINSTANCE.getDataType()); //$NON-NLS-1$
		}
		Object result = DataType_2004_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isDependency_2009(Dependency domainElement) {
		if (Dependency_2009_Constraint == null) { // lazy initialization
			Dependency_2009_Constraint = UMLOCLFactory.getExpression("self.supplier->size() > 1 or self.client->size() > 1", UMLPackage.eINSTANCE.getDependency()); //$NON-NLS-1$
		}
		Object result = Dependency_2009_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isClass_3007(Class domainElement) {
		if (Class_3007_Constraint == null) { // lazy initialization
			Class_3007_Constraint = UMLOCLFactory.getExpression("not oclIsKindOf(uml::AssociationClass) and not oclIsKindOf(uml::StateMachine)", UMLPackage.eINSTANCE.getClass_()); //$NON-NLS-1$
		}
		Object result = Class_3007_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isDataType_3008(DataType domainElement) {
		if (DataType_3008_Constraint == null) { // lazy initialization
			DataType_3008_Constraint = UMLOCLFactory.getExpression("not oclIsKindOf(uml::PrimitiveType) and not oclIsKindOf(uml::Enumeration)", UMLPackage.eINSTANCE.getDataType()); //$NON-NLS-1$
		}
		Object result = DataType_3008_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isProperty_3001(Property domainElement) {
		if (Property_3001_Constraint == null) { // lazy initialization
			Property_3001_Constraint = UMLOCLFactory.getExpression("not oclIsKindOf(uml::Port) and self.association = null", UMLPackage.eINSTANCE.getProperty()); //$NON-NLS-1$
		}
		Object result = Property_3001_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isClass_3003(Class domainElement) {
		if (Class_3003_Constraint == null) { // lazy initialization
			Class_3003_Constraint = UMLOCLFactory.getExpression("not oclIsKindOf(uml::AssociationClass) and not oclIsKindOf(uml::StateMachine)", UMLPackage.eINSTANCE.getClass_()); //$NON-NLS-1$
		}
		Object result = Class_3003_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isSlot_3017(Slot domainElement) {
		if (Slot_3017_Constraint == null) { // lazy initialization
			Slot_3017_Constraint = UMLOCLFactory
					.getExpression(
							"self.value->size() = 0 or not self.value->exists(v : ValueSpecification | v.oclIsKindOf(InstanceValue) and not v.oclAsType(InstanceValue).oclIsUndefined())", UMLPackage.eINSTANCE.getSlot()); //$NON-NLS-1$
		}
		Object result = Slot_3017_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isProperty_3028(Property domainElement) {
		if (Property_3028_Constraint == null) { // lazy initialization
			Property_3028_Constraint = UMLOCLFactory.getExpression("not oclIsKindOf(uml::Port)", UMLPackage.eINSTANCE.getProperty()); //$NON-NLS-1$
		}
		Object result = Property_3028_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isClass_3030(Class domainElement) {
		if (Class_3030_Constraint == null) { // lazy initialization
			Class_3030_Constraint = UMLOCLFactory.getExpression("not oclIsKindOf(uml::AssociationClass) and not oclIsKindOf(uml::StateMachine)", UMLPackage.eINSTANCE.getClass_()); //$NON-NLS-1$
		}
		Object result = Class_3030_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isClass_3033(Class domainElement) {
		if (Class_3033_Constraint == null) { // lazy initialization
			Class_3033_Constraint = UMLOCLFactory.getExpression("not oclIsKindOf(uml::AssociationClass) and not oclIsKindOf(uml::StateMachine)", UMLPackage.eINSTANCE.getClass_()); //$NON-NLS-1$
		}
		Object result = Class_3033_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isDataType_3036(DataType domainElement) {
		if (DataType_3036_Constraint == null) { // lazy initialization
			DataType_3036_Constraint = UMLOCLFactory.getExpression("not oclIsKindOf(uml::PrimitiveType) and not oclIsKindOf(uml::Enumeration)", UMLPackage.eINSTANCE.getDataType()); //$NON-NLS-1$
		}
		Object result = DataType_3036_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isGeneralization_4001(Generalization domainElement) {
		if (Generalization_4001_Constraint == null) { // lazy initialization
			Generalization_4001_Constraint = UMLOCLFactory.getExpression("self.generalizationSet ->size() = 0", UMLPackage.eINSTANCE.getGeneralization()); //$NON-NLS-1$
		}
		Object result = Generalization_4001_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isDependency_4002(Dependency domainElement) {
		if (Dependency_4002_Constraint == null) { // lazy initialization
			Dependency_4002_Constraint = UMLOCLFactory
					.getExpression(
							"(self.oclIsTypeOf(uml::Dependency) or self.oclIsTypeOf(uml::Abstraction) or self.oclIsTypeOf(uml::Substitution) or self.oclIsTypeOf(uml::Usage)) and self.supplier->size() = 1 and self.client->size() = 1 and self.supplier->forAll(e|not e.oclIsKindOf(uml::Interface))", UMLPackage.eINSTANCE.getDependency()); //$NON-NLS-1$
		}
		Object result = Dependency_4002_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isProperty_4003(Property domainElement) {
		if (Property_4003_Constraint == null) { // lazy initialization
			Property_4003_Constraint = UMLOCLFactory.getExpression("self.association.oclIsTypeOf(uml::AssociationClass)", UMLPackage.eINSTANCE.getProperty()); //$NON-NLS-1$
		}
		Object result = Property_4003_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isAssociation_4005(Association domainElement) {
		if (Association_4005_Constraint == null) { // lazy initialization
			Association_4005_Constraint = UMLOCLFactory.getExpression("not self.oclIsTypeOf(uml::AssociationClass)", UMLPackage.eINSTANCE.getAssociation()); //$NON-NLS-1$
		}
		Object result = Association_4005_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isInterfaceRealization_4008(InterfaceRealization domainElement) {
		if (InterfaceRealization_4008_Constraint == null) { // lazy initialization
			InterfaceRealization_4008_Constraint = UMLOCLFactory.getExpression("self.supplier->forAll(e|e.oclIsKindOf(uml::Interface))", UMLPackage.eINSTANCE.getInterfaceRealization()); //$NON-NLS-1$
		}
		Object result = InterfaceRealization_4008_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isRealization_4010(Realization domainElement) {
		if (Realization_4010_Constraint == null) { // lazy initialization
			Realization_4010_Constraint = UMLOCLFactory.getExpression("self.oclIsTypeOf(uml::Realization)", UMLPackage.eINSTANCE.getRealization()); //$NON-NLS-1$
		}
		Object result = Realization_4010_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isUsage_4013(Usage domainElement) {
		if (Usage_4013_Constraint == null) { // lazy initialization
			Usage_4013_Constraint = UMLOCLFactory.getExpression("self.supplier->forAll(e|e.oclIsKindOf(uml::Interface))", UMLPackage.eINSTANCE.getUsage()); //$NON-NLS-1$
		}
		Object result = Usage_4013_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isSlot_4015(Slot domainElement) {
		if (Slot_4015_Constraint == null) { // lazy initialization
			Slot_4015_Constraint = UMLOCLFactory.getExpression(
					"self.value->exists(v : ValueSpecification | v.oclIsKindOf(InstanceValue) and not v.oclAsType(InstanceValue).oclIsUndefined())", UMLPackage.eINSTANCE.getSlot()); //$NON-NLS-1$
		}
		Object result = Slot_4015_Constraint.evaluate(domainElement);
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
		final View containerView = null;
		if (domainElement == null) {
			return -1;
		}
		switch (container.getVisualID()) {
		case Package2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getPackage().isSuperTypeOf(domainElement.eClass())) {
				return Package3EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass()) && isClass_3007((Class) domainElement)) {
				return ClassEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getDataType().isSuperTypeOf(domainElement.eClass()) && isDataType_3008((DataType) domainElement)) {
				return DataTypeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPrimitiveType().isSuperTypeOf(domainElement.eClass())) {
				return PrimitiveTypeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getEnumeration().isSuperTypeOf(domainElement.eClass())) {
				return EnumerationEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getAssociationClass().isSuperTypeOf(domainElement.eClass())) {
				return AssociationClassEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getInterface().isSuperTypeOf(domainElement.eClass())) {
				return Interface3EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getInstanceSpecification().isSuperTypeOf(domainElement.eClass())) {
				return InstanceSpecificationEditPart.VISUAL_ID;
			}
			break;
		case Class2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getPort().isSuperTypeOf(domainElement.eClass())) {
				return PortEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getRedefinableTemplateSignature().isSuperTypeOf(domainElement.eClass())) {
				return RedefinableTemplateSignatureEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass()) && isProperty_3001((Property) domainElement)) {
				return PropertyEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getOperation().isSuperTypeOf(domainElement.eClass())) {
				return OperationEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass()) && isClass_3003((Class) domainElement)) {
				return Class3EditPart.VISUAL_ID;
			}
			break;
		case AssociationClass2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getRedefinableTemplateSignature().isSuperTypeOf(domainElement.eClass())) {
				return RedefinableTemplateSignatureEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass())) {
				return Property2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getOperation().isSuperTypeOf(domainElement.eClass())) {
				return Operation2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass()) && isClass_3003((Class) domainElement)) {
				return Class3EditPart.VISUAL_ID;
			}
			break;
		case DataType2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getRedefinableTemplateSignature().isSuperTypeOf(domainElement.eClass())) {
				return RedefinableTemplateSignatureEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass())) {
				return Property3EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getOperation().isSuperTypeOf(domainElement.eClass())) {
				return Operation3EditPart.VISUAL_ID;
			}
			break;
		case PrimitiveType2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getRedefinableTemplateSignature().isSuperTypeOf(domainElement.eClass())) {
				return RedefinableTemplateSignatureEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass())) {
				return Property4EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getOperation().isSuperTypeOf(domainElement.eClass())) {
				return Operation4EditPart.VISUAL_ID;
			}
			break;
		case Enumeration2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getRedefinableTemplateSignature().isSuperTypeOf(domainElement.eClass())) {
				return RedefinableTemplateSignatureEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getEnumerationLiteral().isSuperTypeOf(domainElement.eClass())) {
				return EnumerationLiteralEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass())) {
				return Property5EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getOperation().isSuperTypeOf(domainElement.eClass())) {
				return Operation5EditPart.VISUAL_ID;
			}
			break;
		case InstanceSpecification2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getSlot().isSuperTypeOf(domainElement.eClass()) && isSlot_3017((Slot) domainElement)) {
				return SlotEditPart.VISUAL_ID;
			}
			break;
		case Interface2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass()) && isProperty_3028((Property) domainElement)) {
				return Property6EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getOperation().isSuperTypeOf(domainElement.eClass())) {
				return Operation6EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass()) && isClass_3030((Class) domainElement)) {
				return Class4EditPart.VISUAL_ID;
			}
			break;
		case Package4EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getElementImport().isSuperTypeOf(domainElement.eClass())) {
				return ElementImportEditPart.VISUAL_ID;
			}
			break;
		case PackageAsFrameEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getPackage().isSuperTypeOf(domainElement.eClass())) {
				return Package6EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass()) && isClass_3033((Class) domainElement)) {
				return Class5EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getEnumeration().isSuperTypeOf(domainElement.eClass())) {
				return Enumeration3EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getInstanceSpecification().isSuperTypeOf(domainElement.eClass())) {
				return InstanceSpecification3EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getDataType().isSuperTypeOf(domainElement.eClass()) && isDataType_3036((DataType) domainElement)) {
				return DataType3EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPrimitiveType().isSuperTypeOf(domainElement.eClass())) {
				return PrimitiveType3EditPart.VISUAL_ID;
			}
			break;
		case InstanceSpecification4EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getLiteralInteger().isSuperTypeOf(domainElement.eClass())) {
				return LiteralIntegerEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getLiteralString().isSuperTypeOf(domainElement.eClass())) {
				return LiteralStringEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getExpression().isSuperTypeOf(domainElement.eClass())) {
				return ExpressionEditPart.VISUAL_ID;
			}
			break;
		case Package6EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getPackage().isSuperTypeOf(domainElement.eClass())) {
				return Package6EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass()) && isClass_3033((Class) domainElement)) {
				return Class5EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getEnumeration().isSuperTypeOf(domainElement.eClass())) {
				return Enumeration3EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getInstanceSpecification().isSuperTypeOf(domainElement.eClass())) {
				return InstanceSpecification3EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getDataType().isSuperTypeOf(domainElement.eClass()) && isDataType_3036((DataType) domainElement)) {
				return DataType3EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPrimitiveType().isSuperTypeOf(domainElement.eClass())) {
				return PrimitiveType3EditPart.VISUAL_ID;
			}
			break;
		case Class5EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getPort().isSuperTypeOf(domainElement.eClass())) {
				return PortEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getRedefinableTemplateSignature().isSuperTypeOf(domainElement.eClass())) {
				return RedefinableTemplateSignatureEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass()) && isProperty_3001((Property) domainElement)) {
				return PropertyEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getOperation().isSuperTypeOf(domainElement.eClass())) {
				return OperationEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass()) && isClass_3003((Class) domainElement)) {
				return Class3EditPart.VISUAL_ID;
			}
			break;
		case Enumeration3EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getRedefinableTemplateSignature().isSuperTypeOf(domainElement.eClass())) {
				return RedefinableTemplateSignatureEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getEnumerationLiteral().isSuperTypeOf(domainElement.eClass())) {
				return EnumerationLiteralEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass())) {
				return Property5EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getOperation().isSuperTypeOf(domainElement.eClass())) {
				return Operation5EditPart.VISUAL_ID;
			}
			break;
		case InstanceSpecification3EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getSlot().isSuperTypeOf(domainElement.eClass()) && isSlot_3017((Slot) domainElement)) {
				return SlotEditPart.VISUAL_ID;
			}
			break;
		case DataType3EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getRedefinableTemplateSignature().isSuperTypeOf(domainElement.eClass())) {
				return RedefinableTemplateSignatureEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass())) {
				return Property3EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getOperation().isSuperTypeOf(domainElement.eClass())) {
				return Operation3EditPart.VISUAL_ID;
			}
			break;
		case PrimitiveType3EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getRedefinableTemplateSignature().isSuperTypeOf(domainElement.eClass())) {
				return RedefinableTemplateSignatureEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass())) {
				return Property4EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getOperation().isSuperTypeOf(domainElement.eClass())) {
				return Operation4EditPart.VISUAL_ID;
			}
			break;
		case PackageEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getPackage().isSuperTypeOf(domainElement.eClass())) {
				return Package2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass()) && isClass_2001((Class) domainElement)) {
				return Class2EditPart.VISUAL_ID;
			}
			// there is a group of nodes for single semantic element
			// the group for this element consists of 
			// org.eclipse.uml2.diagram.clazz.edit.parts.AssociationClass2EditPart.VISUAL_ID
			// org.eclipse.uml2.diagram.clazz.edit.parts.AssociationClassRhombEditPart.VISUAL_ID
			// diagram updater is expected to return one node descriptor (and thus one instance of that semantic element) per node in group
			// we need to give other parts a chance to create their views
			if (UMLPackage.eINSTANCE.getAssociationClass().isSuperTypeOf(domainElement.eClass()) && !hasViewChild(containerView, domainElement, AssociationClass2EditPart.VISUAL_ID)) {
				return AssociationClass2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getDataType().isSuperTypeOf(domainElement.eClass()) && isDataType_2004((DataType) domainElement)) {
				return DataType2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPrimitiveType().isSuperTypeOf(domainElement.eClass())) {
				return PrimitiveType2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getEnumeration().isSuperTypeOf(domainElement.eClass())) {
				return Enumeration2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getInterface().isSuperTypeOf(domainElement.eClass())) {
				return InterfaceEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getConstraint().isSuperTypeOf(domainElement.eClass())) {
				return ConstraintEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getInstanceSpecification().isSuperTypeOf(domainElement.eClass())) {
				return InstanceSpecification2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getDependency().isSuperTypeOf(domainElement.eClass()) && isDependency_2009((Dependency) domainElement)) {
				return DependencyEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getGeneralizationSet().isSuperTypeOf(domainElement.eClass())) {
				return GeneralizationSetEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getInterface().isSuperTypeOf(domainElement.eClass())) {
				return Interface2EditPart.VISUAL_ID;
			}
			// there is a group of nodes for single semantic element
			// the group for this element consists of 
			// org.eclipse.uml2.diagram.clazz.edit.parts.AssociationClassRhombEditPart.VISUAL_ID
			// org.eclipse.uml2.diagram.clazz.edit.parts.AssociationClass2EditPart.VISUAL_ID
			// diagram updater is expected to return one node descriptor (and thus one instance of that semantic element) per node in group
			// we need to give other parts a chance to create their views
			if (UMLPackage.eINSTANCE.getAssociationClass().isSuperTypeOf(domainElement.eClass()) && !hasViewChild(containerView, domainElement, AssociationClassRhombEditPart.VISUAL_ID)) {
				return AssociationClassRhombEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPackage().isSuperTypeOf(domainElement.eClass())) {
				return PackageAsFrameEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getInstanceSpecification().isSuperTypeOf(domainElement.eClass())) {
				return InstanceSpecification4EditPart.VISUAL_ID;
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
		case Package2EditPart.VISUAL_ID:
			return (substituteCandidate == PackageAsFrameEditPart.VISUAL_ID);
		case AssociationClass2EditPart.VISUAL_ID:
			return (substituteCandidate == AssociationClassRhombEditPart.VISUAL_ID);
		case InterfaceEditPart.VISUAL_ID:
			return (substituteCandidate == Interface2EditPart.VISUAL_ID);
		case InstanceSpecification2EditPart.VISUAL_ID:
			return (substituteCandidate == InstanceSpecification4EditPart.VISUAL_ID);
		case Interface2EditPart.VISUAL_ID:
			return (substituteCandidate == InterfaceEditPart.VISUAL_ID);
		case AssociationClassRhombEditPart.VISUAL_ID:
			return (substituteCandidate == AssociationClass2EditPart.VISUAL_ID);
		case PackageAsFrameEditPart.VISUAL_ID:
			return (substituteCandidate == Package2EditPart.VISUAL_ID);
		case InstanceSpecification4EditPart.VISUAL_ID:
			return (substituteCandidate == InstanceSpecification2EditPart.VISUAL_ID);

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
		case PackagePackagesEditPart.VISUAL_ID:
		case PackageClassifiersEditPart.VISUAL_ID:
		case PackageOtherEditPart.VISUAL_ID:
		case ClassAttributesEditPart.VISUAL_ID:
		case ClassOperationsEditPart.VISUAL_ID:
		case ClassClassesEditPart.VISUAL_ID:
		case AssociationClassAttributesEditPart.VISUAL_ID:
		case AssociationClassOperationsEditPart.VISUAL_ID:
		case AssociationClassClassesEditPart.VISUAL_ID:
		case DataTypeAttributesEditPart.VISUAL_ID:
		case DataTypeOperationsEditPart.VISUAL_ID:
		case PrimitiveTypeAttributesEditPart.VISUAL_ID:
		case PrimitiveTypeOperationsEditPart.VISUAL_ID:
		case EnumerationLiteralsEditPart.VISUAL_ID:
		case EnumerationAttributesEditPart.VISUAL_ID:
		case EnumerationOperationsEditPart.VISUAL_ID:
		case InstanceSpecificationSlotsEditPart.VISUAL_ID:
		case InterfaceAttributesEditPart.VISUAL_ID:
		case InterfaceOperationsEditPart.VISUAL_ID:
		case InterfaceClassesEditPart.VISUAL_ID:
		case PackageImportsEditPart.VISUAL_ID:
		case PackageAsFrameContentsEditPart.VISUAL_ID:
		case PackageAsFrameContents2EditPart.VISUAL_ID:
		case ClassAttributes2EditPart.VISUAL_ID:
		case ClassOperations2EditPart.VISUAL_ID:
		case ClassClasses2EditPart.VISUAL_ID:
		case EnumerationLiterals2EditPart.VISUAL_ID:
		case EnumerationAttributes2EditPart.VISUAL_ID:
		case EnumerationOperations2EditPart.VISUAL_ID:
		case InstanceSpecificationSlots2EditPart.VISUAL_ID:
		case DataTypeAttributes2EditPart.VISUAL_ID:
		case DataTypeOperations2EditPart.VISUAL_ID:
		case PrimitiveTypeAttributes2EditPart.VISUAL_ID:
		case PrimitiveTypeOperations2EditPart.VISUAL_ID:
		case InstanceSpecificationValueEditPart.VISUAL_ID:
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
		case InterfaceEditPart.VISUAL_ID:
		case ConstraintEditPart.VISUAL_ID:
		case DependencyEditPart.VISUAL_ID:
		case GeneralizationSetEditPart.VISUAL_ID:
		case AssociationClassRhombEditPart.VISUAL_ID:
		case CommentEditPart.VISUAL_ID:
		case Package3EditPart.VISUAL_ID:
		case ClassEditPart.VISUAL_ID:
		case DataTypeEditPart.VISUAL_ID:
		case PrimitiveTypeEditPart.VISUAL_ID:
		case EnumerationEditPart.VISUAL_ID:
		case AssociationClassEditPart.VISUAL_ID:
		case Interface3EditPart.VISUAL_ID:
		case InstanceSpecificationEditPart.VISUAL_ID:
		case PropertyEditPart.VISUAL_ID:
		case OperationEditPart.VISUAL_ID:
		case Class3EditPart.VISUAL_ID:
		case PortEditPart.VISUAL_ID:
		case RedefinableTemplateSignatureEditPart.VISUAL_ID:
		case Property2EditPart.VISUAL_ID:
		case Operation2EditPart.VISUAL_ID:
		case Property3EditPart.VISUAL_ID:
		case Operation3EditPart.VISUAL_ID:
		case Property4EditPart.VISUAL_ID:
		case Operation4EditPart.VISUAL_ID:
		case EnumerationLiteralEditPart.VISUAL_ID:
		case Property5EditPart.VISUAL_ID:
		case Operation5EditPart.VISUAL_ID:
		case SlotEditPart.VISUAL_ID:
		case Property6EditPart.VISUAL_ID:
		case Operation6EditPart.VISUAL_ID:
		case Class4EditPart.VISUAL_ID:
		case ElementImportEditPart.VISUAL_ID:
		case LiteralStringEditPart.VISUAL_ID:
		case LiteralIntegerEditPart.VISUAL_ID:
		case ExpressionEditPart.VISUAL_ID:
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
			return org.eclipse.uml2.diagram.clazz.part.UMLVisualIDRegistry.getModelID(view);
		}

		/**
		 * @generated
		 */
		public int getVisualID(View view) {
			return org.eclipse.uml2.diagram.clazz.part.UMLVisualIDRegistry.getVisualID(view);
		}

		/**
		 * @generated
		 */
		public int getNodeVisualID(View containerView, EObject domainElement) {
			return org.eclipse.uml2.diagram.clazz.part.UMLVisualIDRegistry.getNodeVisualID(containerView, domainElement);
		}

		/**
		 * @generated
		 */
		public boolean checkNodeVisualID(View containerView, EObject domainElement, int candidate) {
			return org.eclipse.uml2.diagram.clazz.part.UMLVisualIDRegistry.checkNodeVisualID(containerView, domainElement, candidate);
		}

		/**
		 * @generated
		 */
		public boolean isCompartmentVisualID(int visualID) {
			return org.eclipse.uml2.diagram.clazz.part.UMLVisualIDRegistry.isCompartmentVisualID(visualID);
		}

		/**
		 * @generated
		 */
		public boolean isSemanticLeafVisualID(int visualID) {
			return org.eclipse.uml2.diagram.clazz.part.UMLVisualIDRegistry.isSemanticLeafVisualID(visualID);
		}

		/**
		 * @generated
		 */
		public boolean isShortcutDescendant(View view) {
			return org.eclipse.uml2.diagram.clazz.part.UMLVisualIDRegistry.isShortcutDescendant(view);
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
