package org.eclipse.uml2.diagram.clazz.part;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.clazz.edit.parts.AssociationClass2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.AssociationClassAttributesEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.AssociationClassClassesEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.AssociationClassEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.AssociationClassOperationsEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.AssociationEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Class2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Class3EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Class4EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.ClassAttributesEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.ClassClassesEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.ClassEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.ClassOperationsEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.ConstraintConstrainedElementEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.ConstraintEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.DataType2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.DataTypeAttributesEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.DataTypeEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.DataTypeOperationsEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Dependency2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.DependencyClientEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.DependencyEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.DependencySupplierEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Enumeration2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.EnumerationAttributesEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.EnumerationEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.EnumerationLiteralEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.EnumerationLiteralsEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.EnumerationOperationsEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Generalization2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.GeneralizationEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.GeneralizationGeneralEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.GeneralizationSetEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.InstanceSpecification2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.InstanceSpecificationEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.InstanceSpecificationSlotsEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Interface2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.InterfaceAttributesEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.InterfaceClassesEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.InterfaceEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.InterfaceOperationsEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.InterfaceRealizationEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Operation2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Operation3EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Operation4EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Operation5EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Operation6EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.OperationEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Package2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Package3EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.PackageClassifiersEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.PackageOtherEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.PackagePackagesEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.PortEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.PrimitiveType2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.PrimitiveTypeAttributesEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.PrimitiveTypeEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.PrimitiveTypeOperationsEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Property2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Property3EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Property4EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Property5EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Property6EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Property7EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.PropertyEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.RealizationEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.RedefinableTemplateSignatureEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.SlotEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.UsageEditPart;
import org.eclipse.uml2.diagram.clazz.providers.UMLElementTypes;
import org.eclipse.uml2.diagram.common.conventions.AssociationEndConvention;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.BehavioredClassifier;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.GeneralizationSet;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.InterfaceRealization;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.StructuredClassifier;
import org.eclipse.uml2.uml.TemplateableElement;
import org.eclipse.uml2.uml.TypedElement;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class DiagramContentsInitializer {

	/**
	 * @generated
	 */
	private Collection myLinkDescriptors = new LinkedList();

	/**
	 * @generated
	 */
	private Map myEObject2NodeMap = new HashMap();

	/**
	 * @generated
	 */
	public void initDiagramContents(Diagram diagram, EObject diagramModelObject) {
		createPackage_1000Children(diagram, diagramModelObject);

		createLinks(diagram);
	}

	/**
	 * @generated
	 */
	private void createPackage_2002Children(View viewObject, EObject modelObject) {

		Node nextCompartment = getCompartment(viewObject, UMLVisualIDRegistry.getType(PackagePackagesEditPart.VISUAL_ID));
		if (nextCompartment != null) {
			createPackagePackages_7010Children(nextCompartment, modelObject);
		}
		nextCompartment = getCompartment(viewObject, UMLVisualIDRegistry.getType(PackageClassifiersEditPart.VISUAL_ID));
		if (nextCompartment != null) {
			createPackageClassifiers_7011Children(nextCompartment, modelObject);
		}
		nextCompartment = getCompartment(viewObject, UMLVisualIDRegistry.getType(PackageOtherEditPart.VISUAL_ID));
		if (nextCompartment != null) {
			createPackageOther_7012Children(nextCompartment, modelObject);
		}
		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private void createClass_2001Children(View viewObject, EObject modelObject) {
		EObject nextValue;
		int nodeVID;
		for (Iterator values = ((StructuredClassifier) modelObject).getOwnedAttributes().iterator(); values.hasNext();) {
			nextValue = (EObject) values.next();
			nodeVID = UMLVisualIDRegistry.getNodeVisualID(viewObject, nextValue);
			if (PortEditPart.VISUAL_ID == nodeVID) {
				Node nextNode = ViewService.createNode(viewObject, nextValue, UMLVisualIDRegistry.getType(PortEditPart.VISUAL_ID), UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				myEObject2NodeMap.put(nextValue, nextNode);
				createPort_3025Children(nextNode, nextValue);
			}
		}
		nextValue = ((TemplateableElement) modelObject).getOwnedTemplateSignature();
		nodeVID = UMLVisualIDRegistry.getNodeVisualID(viewObject, nextValue);
		if (RedefinableTemplateSignatureEditPart.VISUAL_ID == nodeVID) {
			Node nextNode = ViewService.createNode(viewObject, nextValue, UMLVisualIDRegistry.getType(RedefinableTemplateSignatureEditPart.VISUAL_ID), UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
			myEObject2NodeMap.put(nextValue, nextNode);
			createRedefinableTemplateSignature_3027Children(nextNode, nextValue);
		}
		Node nextCompartment = getCompartment(viewObject, UMLVisualIDRegistry.getType(ClassAttributesEditPart.VISUAL_ID));
		if (nextCompartment != null) {
			createClassAttributes_7001Children(nextCompartment, modelObject);
		}
		nextCompartment = getCompartment(viewObject, UMLVisualIDRegistry.getType(ClassOperationsEditPart.VISUAL_ID));
		if (nextCompartment != null) {
			createClassOperations_7002Children(nextCompartment, modelObject);
		}
		nextCompartment = getCompartment(viewObject, UMLVisualIDRegistry.getType(ClassClassesEditPart.VISUAL_ID));
		if (nextCompartment != null) {
			createClassClasses_7003Children(nextCompartment, modelObject);
		}
		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private void createAssociationClass_2007Children(View viewObject, EObject modelObject) {
		EObject nextValue;
		int nodeVID;
		nextValue = ((TemplateableElement) modelObject).getOwnedTemplateSignature();
		nodeVID = UMLVisualIDRegistry.getNodeVisualID(viewObject, nextValue);
		if (RedefinableTemplateSignatureEditPart.VISUAL_ID == nodeVID) {
			Node nextNode = ViewService.createNode(viewObject, nextValue, UMLVisualIDRegistry.getType(RedefinableTemplateSignatureEditPart.VISUAL_ID), UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
			myEObject2NodeMap.put(nextValue, nextNode);
			createRedefinableTemplateSignature_3027Children(nextNode, nextValue);
		}
		Node nextCompartment = getCompartment(viewObject, UMLVisualIDRegistry.getType(AssociationClassAttributesEditPart.VISUAL_ID));
		if (nextCompartment != null) {
			createAssociationClassAttributes_7024Children(nextCompartment, modelObject);
		}
		nextCompartment = getCompartment(viewObject, UMLVisualIDRegistry.getType(AssociationClassOperationsEditPart.VISUAL_ID));
		if (nextCompartment != null) {
			createAssociationClassOperations_7025Children(nextCompartment, modelObject);
		}
		nextCompartment = getCompartment(viewObject, UMLVisualIDRegistry.getType(AssociationClassClassesEditPart.VISUAL_ID));
		if (nextCompartment != null) {
			createAssociationClassClasses_7026Children(nextCompartment, modelObject);
		}
		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private void createDataType_2004Children(View viewObject, EObject modelObject) {
		EObject nextValue;
		int nodeVID;
		nextValue = ((TemplateableElement) modelObject).getOwnedTemplateSignature();
		nodeVID = UMLVisualIDRegistry.getNodeVisualID(viewObject, nextValue);
		if (RedefinableTemplateSignatureEditPart.VISUAL_ID == nodeVID) {
			Node nextNode = ViewService.createNode(viewObject, nextValue, UMLVisualIDRegistry.getType(RedefinableTemplateSignatureEditPart.VISUAL_ID), UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
			myEObject2NodeMap.put(nextValue, nextNode);
			createRedefinableTemplateSignature_3027Children(nextNode, nextValue);
		}
		Node nextCompartment = getCompartment(viewObject, UMLVisualIDRegistry.getType(DataTypeAttributesEditPart.VISUAL_ID));
		if (nextCompartment != null) {
			createDataTypeAttributes_7017Children(nextCompartment, modelObject);
		}
		nextCompartment = getCompartment(viewObject, UMLVisualIDRegistry.getType(DataTypeOperationsEditPart.VISUAL_ID));
		if (nextCompartment != null) {
			createDataTypeOperations_7018Children(nextCompartment, modelObject);
		}
		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private void createPrimitiveType_2005Children(View viewObject, EObject modelObject) {
		EObject nextValue;
		int nodeVID;
		nextValue = ((TemplateableElement) modelObject).getOwnedTemplateSignature();
		nodeVID = UMLVisualIDRegistry.getNodeVisualID(viewObject, nextValue);
		if (RedefinableTemplateSignatureEditPart.VISUAL_ID == nodeVID) {
			Node nextNode = ViewService.createNode(viewObject, nextValue, UMLVisualIDRegistry.getType(RedefinableTemplateSignatureEditPart.VISUAL_ID), UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
			myEObject2NodeMap.put(nextValue, nextNode);
			createRedefinableTemplateSignature_3027Children(nextNode, nextValue);
		}
		Node nextCompartment = getCompartment(viewObject, UMLVisualIDRegistry.getType(PrimitiveTypeAttributesEditPart.VISUAL_ID));
		if (nextCompartment != null) {
			createPrimitiveTypeAttributes_7020Children(nextCompartment, modelObject);
		}
		nextCompartment = getCompartment(viewObject, UMLVisualIDRegistry.getType(PrimitiveTypeOperationsEditPart.VISUAL_ID));
		if (nextCompartment != null) {
			createPrimitiveTypeOperations_7021Children(nextCompartment, modelObject);
		}
		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private void createEnumeration_2003Children(View viewObject, EObject modelObject) {
		EObject nextValue;
		int nodeVID;
		nextValue = ((TemplateableElement) modelObject).getOwnedTemplateSignature();
		nodeVID = UMLVisualIDRegistry.getNodeVisualID(viewObject, nextValue);
		if (RedefinableTemplateSignatureEditPart.VISUAL_ID == nodeVID) {
			Node nextNode = ViewService.createNode(viewObject, nextValue, UMLVisualIDRegistry.getType(RedefinableTemplateSignatureEditPart.VISUAL_ID), UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
			myEObject2NodeMap.put(nextValue, nextNode);
			createRedefinableTemplateSignature_3027Children(nextNode, nextValue);
		}
		Node nextCompartment = getCompartment(viewObject, UMLVisualIDRegistry.getType(EnumerationLiteralsEditPart.VISUAL_ID));
		if (nextCompartment != null) {
			createEnumerationLiterals_7013Children(nextCompartment, modelObject);
		}
		nextCompartment = getCompartment(viewObject, UMLVisualIDRegistry.getType(EnumerationAttributesEditPart.VISUAL_ID));
		if (nextCompartment != null) {
			createEnumerationAttributes_7014Children(nextCompartment, modelObject);
		}
		nextCompartment = getCompartment(viewObject, UMLVisualIDRegistry.getType(EnumerationOperationsEditPart.VISUAL_ID));
		if (nextCompartment != null) {
			createEnumerationOperations_7015Children(nextCompartment, modelObject);
		}
		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private void createInterface_2010Children(View viewObject, EObject modelObject) {

		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private void createConstraint_2006Children(View viewObject, EObject modelObject) {

		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private void createInstanceSpecification_2008Children(View viewObject, EObject modelObject) {

		Node nextCompartment = getCompartment(viewObject, UMLVisualIDRegistry.getType(InstanceSpecificationSlotsEditPart.VISUAL_ID));
		if (nextCompartment != null) {
			createInstanceSpecificationSlots_7028Children(nextCompartment, modelObject);
		}
		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private void createDependency_2009Children(View viewObject, EObject modelObject) {

		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private void createGeneralizationSet_2012Children(View viewObject, EObject modelObject) {

		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private void createInterface_2013Children(View viewObject, EObject modelObject) {

		Node nextCompartment = getCompartment(viewObject, UMLVisualIDRegistry.getType(InterfaceAttributesEditPart.VISUAL_ID));
		if (nextCompartment != null) {
			createInterfaceAttributes_7029Children(nextCompartment, modelObject);
		}
		nextCompartment = getCompartment(viewObject, UMLVisualIDRegistry.getType(InterfaceOperationsEditPart.VISUAL_ID));
		if (nextCompartment != null) {
			createInterfaceOperations_7030Children(nextCompartment, modelObject);
		}
		nextCompartment = getCompartment(viewObject, UMLVisualIDRegistry.getType(InterfaceClassesEditPart.VISUAL_ID));
		if (nextCompartment != null) {
			createInterfaceClasses_7031Children(nextCompartment, modelObject);
		}
		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private void createPackage_3006Children(View viewObject, EObject modelObject) {

		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private void createClass_3007Children(View viewObject, EObject modelObject) {

		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private void createDataType_3008Children(View viewObject, EObject modelObject) {

		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private void createPrimitiveType_3009Children(View viewObject, EObject modelObject) {

		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private void createEnumeration_3011Children(View viewObject, EObject modelObject) {

		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private void createAssociationClass_3012Children(View viewObject, EObject modelObject) {

		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private void createInstanceSpecification_3013Children(View viewObject, EObject modelObject) {

		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private void createProperty_3001Children(View viewObject, EObject modelObject) {

		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private void createOperation_3002Children(View viewObject, EObject modelObject) {

		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private void createClass_3003Children(View viewObject, EObject modelObject) {

		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private void createPort_3025Children(View viewObject, EObject modelObject) {

		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private void createRedefinableTemplateSignature_3027Children(View viewObject, EObject modelObject) {

		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private void createProperty_3019Children(View viewObject, EObject modelObject) {

		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private void createOperation_3020Children(View viewObject, EObject modelObject) {

		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private void createProperty_3014Children(View viewObject, EObject modelObject) {

		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private void createOperation_3015Children(View viewObject, EObject modelObject) {

		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private void createProperty_3021Children(View viewObject, EObject modelObject) {

		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private void createOperation_3022Children(View viewObject, EObject modelObject) {

		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private void createEnumerationLiteral_3016Children(View viewObject, EObject modelObject) {

		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private void createProperty_3023Children(View viewObject, EObject modelObject) {

		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private void createOperation_3024Children(View viewObject, EObject modelObject) {

		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private void createSlot_3017Children(View viewObject, EObject modelObject) {

		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private void createProperty_3028Children(View viewObject, EObject modelObject) {

		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private void createOperation_3029Children(View viewObject, EObject modelObject) {

		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private void createClass_3030Children(View viewObject, EObject modelObject) {

		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private void createPackagePackages_7010Children(View viewObject, EObject modelObject) {
		EObject nextValue;
		int nodeVID;
		for (Iterator values = ((Package) modelObject).getNestedPackages().iterator(); values.hasNext();) {
			nextValue = (EObject) values.next();
			nodeVID = UMLVisualIDRegistry.getNodeVisualID(viewObject, nextValue);
			if (Package3EditPart.VISUAL_ID == nodeVID) {
				Node nextNode = ViewService.createNode(viewObject, nextValue, UMLVisualIDRegistry.getType(Package3EditPart.VISUAL_ID), UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				myEObject2NodeMap.put(nextValue, nextNode);
				createPackage_3006Children(nextNode, nextValue);
			}
		}
	}

	/**
	 * @generated
	 */
	private void createPackageClassifiers_7011Children(View viewObject, EObject modelObject) {
		EObject nextValue;
		int nodeVID;
		for (Iterator values = ((Package) modelObject).getOwnedTypes().iterator(); values.hasNext();) {
			nextValue = (EObject) values.next();
			nodeVID = UMLVisualIDRegistry.getNodeVisualID(viewObject, nextValue);
			switch (nodeVID) {
			case ClassEditPart.VISUAL_ID: {
				Node nextNode = ViewService.createNode(viewObject, nextValue, UMLVisualIDRegistry.getType(ClassEditPart.VISUAL_ID), UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				myEObject2NodeMap.put(nextValue, nextNode);
				createClass_3007Children(nextNode, nextValue);
				break;
			}
			case DataTypeEditPart.VISUAL_ID: {
				Node nextNode = ViewService.createNode(viewObject, nextValue, UMLVisualIDRegistry.getType(DataTypeEditPart.VISUAL_ID), UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				myEObject2NodeMap.put(nextValue, nextNode);
				createDataType_3008Children(nextNode, nextValue);
				break;
			}
			case PrimitiveTypeEditPart.VISUAL_ID: {
				Node nextNode = ViewService.createNode(viewObject, nextValue, UMLVisualIDRegistry.getType(PrimitiveTypeEditPart.VISUAL_ID), UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				myEObject2NodeMap.put(nextValue, nextNode);
				createPrimitiveType_3009Children(nextNode, nextValue);
				break;
			}
			case EnumerationEditPart.VISUAL_ID: {
				Node nextNode = ViewService.createNode(viewObject, nextValue, UMLVisualIDRegistry.getType(EnumerationEditPart.VISUAL_ID), UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				myEObject2NodeMap.put(nextValue, nextNode);
				createEnumeration_3011Children(nextNode, nextValue);
				break;
			}
			case AssociationClassEditPart.VISUAL_ID: {
				Node nextNode = ViewService.createNode(viewObject, nextValue, UMLVisualIDRegistry.getType(AssociationClassEditPart.VISUAL_ID), UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				myEObject2NodeMap.put(nextValue, nextNode);
				createAssociationClass_3012Children(nextNode, nextValue);
				break;
			}
			}
		}
	}

	/**
	 * @generated
	 */
	private void createPackageOther_7012Children(View viewObject, EObject modelObject) {
		EObject nextValue;
		int nodeVID;
		for (Iterator values = ((Package) modelObject).getPackagedElements().iterator(); values.hasNext();) {
			nextValue = (EObject) values.next();
			nodeVID = UMLVisualIDRegistry.getNodeVisualID(viewObject, nextValue);
			if (InstanceSpecificationEditPart.VISUAL_ID == nodeVID) {
				Node nextNode = ViewService.createNode(viewObject, nextValue, UMLVisualIDRegistry.getType(InstanceSpecificationEditPart.VISUAL_ID), UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				myEObject2NodeMap.put(nextValue, nextNode);
				createInstanceSpecification_3013Children(nextNode, nextValue);
			}
		}
	}

	/**
	 * @generated
	 */
	private void createClassAttributes_7001Children(View viewObject, EObject modelObject) {
		EObject nextValue;
		int nodeVID;
		for (Iterator values = ((StructuredClassifier) modelObject).getOwnedAttributes().iterator(); values.hasNext();) {
			nextValue = (EObject) values.next();
			nodeVID = UMLVisualIDRegistry.getNodeVisualID(viewObject, nextValue);
			if (PropertyEditPart.VISUAL_ID == nodeVID) {
				Node nextNode = ViewService.createNode(viewObject, nextValue, UMLVisualIDRegistry.getType(PropertyEditPart.VISUAL_ID), UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				myEObject2NodeMap.put(nextValue, nextNode);
				createProperty_3001Children(nextNode, nextValue);
			}
		}
	}

	/**
	 * @generated
	 */
	private void createClassOperations_7002Children(View viewObject, EObject modelObject) {
		EObject nextValue;
		int nodeVID;
		for (Iterator values = ((org.eclipse.uml2.uml.Class) modelObject).getOwnedOperations().iterator(); values.hasNext();) {
			nextValue = (EObject) values.next();
			nodeVID = UMLVisualIDRegistry.getNodeVisualID(viewObject, nextValue);
			if (OperationEditPart.VISUAL_ID == nodeVID) {
				Node nextNode = ViewService.createNode(viewObject, nextValue, UMLVisualIDRegistry.getType(OperationEditPart.VISUAL_ID), UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				myEObject2NodeMap.put(nextValue, nextNode);
				createOperation_3002Children(nextNode, nextValue);
			}
		}
	}

	/**
	 * @generated
	 */
	private void createClassClasses_7003Children(View viewObject, EObject modelObject) {
		EObject nextValue;
		int nodeVID;
		for (Iterator values = ((org.eclipse.uml2.uml.Class) modelObject).getNestedClassifiers().iterator(); values.hasNext();) {
			nextValue = (EObject) values.next();
			nodeVID = UMLVisualIDRegistry.getNodeVisualID(viewObject, nextValue);
			if (Class3EditPart.VISUAL_ID == nodeVID) {
				Node nextNode = ViewService.createNode(viewObject, nextValue, UMLVisualIDRegistry.getType(Class3EditPart.VISUAL_ID), UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				myEObject2NodeMap.put(nextValue, nextNode);
				createClass_3003Children(nextNode, nextValue);
			}
		}
	}

	/**
	 * @generated
	 */
	private void createAssociationClassAttributes_7024Children(View viewObject, EObject modelObject) {
		EObject nextValue;
		int nodeVID;
		for (Iterator values = ((StructuredClassifier) modelObject).getOwnedAttributes().iterator(); values.hasNext();) {
			nextValue = (EObject) values.next();
			nodeVID = UMLVisualIDRegistry.getNodeVisualID(viewObject, nextValue);
			if (Property2EditPart.VISUAL_ID == nodeVID) {
				Node nextNode = ViewService.createNode(viewObject, nextValue, UMLVisualIDRegistry.getType(Property2EditPart.VISUAL_ID), UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				myEObject2NodeMap.put(nextValue, nextNode);
				createProperty_3019Children(nextNode, nextValue);
			}
		}
	}

	/**
	 * @generated
	 */
	private void createAssociationClassOperations_7025Children(View viewObject, EObject modelObject) {
		EObject nextValue;
		int nodeVID;
		for (Iterator values = ((org.eclipse.uml2.uml.Class) modelObject).getOwnedOperations().iterator(); values.hasNext();) {
			nextValue = (EObject) values.next();
			nodeVID = UMLVisualIDRegistry.getNodeVisualID(viewObject, nextValue);
			if (Operation2EditPart.VISUAL_ID == nodeVID) {
				Node nextNode = ViewService.createNode(viewObject, nextValue, UMLVisualIDRegistry.getType(Operation2EditPart.VISUAL_ID), UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				myEObject2NodeMap.put(nextValue, nextNode);
				createOperation_3020Children(nextNode, nextValue);
			}
		}
	}

	/**
	 * @generated
	 */
	private void createAssociationClassClasses_7026Children(View viewObject, EObject modelObject) {
		EObject nextValue;
		int nodeVID;
		for (Iterator values = ((org.eclipse.uml2.uml.Class) modelObject).getNestedClassifiers().iterator(); values.hasNext();) {
			nextValue = (EObject) values.next();
			nodeVID = UMLVisualIDRegistry.getNodeVisualID(viewObject, nextValue);
			if (Class3EditPart.VISUAL_ID == nodeVID) {
				Node nextNode = ViewService.createNode(viewObject, nextValue, UMLVisualIDRegistry.getType(Class3EditPart.VISUAL_ID), UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				myEObject2NodeMap.put(nextValue, nextNode);
				createClass_3003Children(nextNode, nextValue);
			}
		}
	}

	/**
	 * @generated
	 */
	private void createDataTypeAttributes_7017Children(View viewObject, EObject modelObject) {
		EObject nextValue;
		int nodeVID;
		for (Iterator values = ((DataType) modelObject).getOwnedAttributes().iterator(); values.hasNext();) {
			nextValue = (EObject) values.next();
			nodeVID = UMLVisualIDRegistry.getNodeVisualID(viewObject, nextValue);
			if (Property3EditPart.VISUAL_ID == nodeVID) {
				Node nextNode = ViewService.createNode(viewObject, nextValue, UMLVisualIDRegistry.getType(Property3EditPart.VISUAL_ID), UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				myEObject2NodeMap.put(nextValue, nextNode);
				createProperty_3014Children(nextNode, nextValue);
			}
		}
	}

	/**
	 * @generated
	 */
	private void createDataTypeOperations_7018Children(View viewObject, EObject modelObject) {
		EObject nextValue;
		int nodeVID;
		for (Iterator values = ((DataType) modelObject).getOwnedOperations().iterator(); values.hasNext();) {
			nextValue = (EObject) values.next();
			nodeVID = UMLVisualIDRegistry.getNodeVisualID(viewObject, nextValue);
			if (Operation3EditPart.VISUAL_ID == nodeVID) {
				Node nextNode = ViewService.createNode(viewObject, nextValue, UMLVisualIDRegistry.getType(Operation3EditPart.VISUAL_ID), UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				myEObject2NodeMap.put(nextValue, nextNode);
				createOperation_3015Children(nextNode, nextValue);
			}
		}
	}

	/**
	 * @generated
	 */
	private void createPrimitiveTypeAttributes_7020Children(View viewObject, EObject modelObject) {
		EObject nextValue;
		int nodeVID;
		for (Iterator values = ((DataType) modelObject).getOwnedAttributes().iterator(); values.hasNext();) {
			nextValue = (EObject) values.next();
			nodeVID = UMLVisualIDRegistry.getNodeVisualID(viewObject, nextValue);
			if (Property4EditPart.VISUAL_ID == nodeVID) {
				Node nextNode = ViewService.createNode(viewObject, nextValue, UMLVisualIDRegistry.getType(Property4EditPart.VISUAL_ID), UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				myEObject2NodeMap.put(nextValue, nextNode);
				createProperty_3021Children(nextNode, nextValue);
			}
		}
	}

	/**
	 * @generated
	 */
	private void createPrimitiveTypeOperations_7021Children(View viewObject, EObject modelObject) {
		EObject nextValue;
		int nodeVID;
		for (Iterator values = ((DataType) modelObject).getOwnedOperations().iterator(); values.hasNext();) {
			nextValue = (EObject) values.next();
			nodeVID = UMLVisualIDRegistry.getNodeVisualID(viewObject, nextValue);
			if (Operation4EditPart.VISUAL_ID == nodeVID) {
				Node nextNode = ViewService.createNode(viewObject, nextValue, UMLVisualIDRegistry.getType(Operation4EditPart.VISUAL_ID), UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				myEObject2NodeMap.put(nextValue, nextNode);
				createOperation_3022Children(nextNode, nextValue);
			}
		}
	}

	/**
	 * @generated
	 */
	private void createEnumerationLiterals_7013Children(View viewObject, EObject modelObject) {
		EObject nextValue;
		int nodeVID;
		for (Iterator values = ((Enumeration) modelObject).getOwnedLiterals().iterator(); values.hasNext();) {
			nextValue = (EObject) values.next();
			nodeVID = UMLVisualIDRegistry.getNodeVisualID(viewObject, nextValue);
			if (EnumerationLiteralEditPart.VISUAL_ID == nodeVID) {
				Node nextNode = ViewService.createNode(viewObject, nextValue, UMLVisualIDRegistry.getType(EnumerationLiteralEditPart.VISUAL_ID), UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				myEObject2NodeMap.put(nextValue, nextNode);
				createEnumerationLiteral_3016Children(nextNode, nextValue);
			}
		}
	}

	/**
	 * @generated
	 */
	private void createEnumerationAttributes_7014Children(View viewObject, EObject modelObject) {
		EObject nextValue;
		int nodeVID;
		for (Iterator values = ((DataType) modelObject).getOwnedAttributes().iterator(); values.hasNext();) {
			nextValue = (EObject) values.next();
			nodeVID = UMLVisualIDRegistry.getNodeVisualID(viewObject, nextValue);
			if (Property5EditPart.VISUAL_ID == nodeVID) {
				Node nextNode = ViewService.createNode(viewObject, nextValue, UMLVisualIDRegistry.getType(Property5EditPart.VISUAL_ID), UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				myEObject2NodeMap.put(nextValue, nextNode);
				createProperty_3023Children(nextNode, nextValue);
			}
		}
	}

	/**
	 * @generated
	 */
	private void createEnumerationOperations_7015Children(View viewObject, EObject modelObject) {
		EObject nextValue;
		int nodeVID;
		for (Iterator values = ((DataType) modelObject).getOwnedOperations().iterator(); values.hasNext();) {
			nextValue = (EObject) values.next();
			nodeVID = UMLVisualIDRegistry.getNodeVisualID(viewObject, nextValue);
			if (Operation5EditPart.VISUAL_ID == nodeVID) {
				Node nextNode = ViewService.createNode(viewObject, nextValue, UMLVisualIDRegistry.getType(Operation5EditPart.VISUAL_ID), UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				myEObject2NodeMap.put(nextValue, nextNode);
				createOperation_3024Children(nextNode, nextValue);
			}
		}
	}

	/**
	 * @generated
	 */
	private void createInstanceSpecificationSlots_7028Children(View viewObject, EObject modelObject) {
		EObject nextValue;
		int nodeVID;
		for (Iterator values = ((InstanceSpecification) modelObject).getSlots().iterator(); values.hasNext();) {
			nextValue = (EObject) values.next();
			nodeVID = UMLVisualIDRegistry.getNodeVisualID(viewObject, nextValue);
			if (SlotEditPart.VISUAL_ID == nodeVID) {
				Node nextNode = ViewService.createNode(viewObject, nextValue, UMLVisualIDRegistry.getType(SlotEditPart.VISUAL_ID), UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				myEObject2NodeMap.put(nextValue, nextNode);
				createSlot_3017Children(nextNode, nextValue);
			}
		}
	}

	/**
	 * @generated
	 */
	private void createInterfaceAttributes_7029Children(View viewObject, EObject modelObject) {
		EObject nextValue;
		int nodeVID;
		for (Iterator values = ((Interface) modelObject).getOwnedAttributes().iterator(); values.hasNext();) {
			nextValue = (EObject) values.next();
			nodeVID = UMLVisualIDRegistry.getNodeVisualID(viewObject, nextValue);
			if (Property6EditPart.VISUAL_ID == nodeVID) {
				Node nextNode = ViewService.createNode(viewObject, nextValue, UMLVisualIDRegistry.getType(Property6EditPart.VISUAL_ID), UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				myEObject2NodeMap.put(nextValue, nextNode);
				createProperty_3028Children(nextNode, nextValue);
			}
		}
	}

	/**
	 * @generated
	 */
	private void createInterfaceOperations_7030Children(View viewObject, EObject modelObject) {
		EObject nextValue;
		int nodeVID;
		for (Iterator values = ((Interface) modelObject).getOwnedOperations().iterator(); values.hasNext();) {
			nextValue = (EObject) values.next();
			nodeVID = UMLVisualIDRegistry.getNodeVisualID(viewObject, nextValue);
			if (Operation6EditPart.VISUAL_ID == nodeVID) {
				Node nextNode = ViewService.createNode(viewObject, nextValue, UMLVisualIDRegistry.getType(Operation6EditPart.VISUAL_ID), UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				myEObject2NodeMap.put(nextValue, nextNode);
				createOperation_3029Children(nextNode, nextValue);
			}
		}
	}

	/**
	 * @generated
	 */
	private void createInterfaceClasses_7031Children(View viewObject, EObject modelObject) {
		EObject nextValue;
		int nodeVID;
		for (Iterator values = ((Interface) modelObject).getNestedClassifiers().iterator(); values.hasNext();) {
			nextValue = (EObject) values.next();
			nodeVID = UMLVisualIDRegistry.getNodeVisualID(viewObject, nextValue);
			if (Class4EditPart.VISUAL_ID == nodeVID) {
				Node nextNode = ViewService.createNode(viewObject, nextValue, UMLVisualIDRegistry.getType(Class4EditPart.VISUAL_ID), UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				myEObject2NodeMap.put(nextValue, nextNode);
				createClass_3030Children(nextNode, nextValue);
			}
		}
	}

	/**
	 * @generated
	 */
	private void createPackage_1000Children(View viewObject, EObject modelObject) {
		EObject nextValue;
		int nodeVID;
		for (Iterator values = ((Package) modelObject).getNestedPackages().iterator(); values.hasNext();) {
			nextValue = (EObject) values.next();
			nodeVID = UMLVisualIDRegistry.getNodeVisualID(viewObject, nextValue);
			if (Package2EditPart.VISUAL_ID == nodeVID) {
				Node nextNode = ViewService.createNode(viewObject, nextValue, UMLVisualIDRegistry.getType(Package2EditPart.VISUAL_ID), UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				myEObject2NodeMap.put(nextValue, nextNode);
				createPackage_2002Children(nextNode, nextValue);
			}
		}
		for (Iterator values = ((Package) modelObject).getOwnedTypes().iterator(); values.hasNext();) {
			nextValue = (EObject) values.next();
			nodeVID = UMLVisualIDRegistry.getNodeVisualID(viewObject, nextValue);
			switch (nodeVID) {
			case Class2EditPart.VISUAL_ID: {
				Node nextNode = ViewService.createNode(viewObject, nextValue, UMLVisualIDRegistry.getType(Class2EditPart.VISUAL_ID), UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				myEObject2NodeMap.put(nextValue, nextNode);
				createClass_2001Children(nextNode, nextValue);
				break;
			}
			case AssociationClass2EditPart.VISUAL_ID: {
				Node nextNode = ViewService.createNode(viewObject, nextValue, UMLVisualIDRegistry.getType(AssociationClass2EditPart.VISUAL_ID), UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				myEObject2NodeMap.put(nextValue, nextNode);
				createAssociationClass_2007Children(nextNode, nextValue);
				break;
			}
			case DataType2EditPart.VISUAL_ID: {
				Node nextNode = ViewService.createNode(viewObject, nextValue, UMLVisualIDRegistry.getType(DataType2EditPart.VISUAL_ID), UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				myEObject2NodeMap.put(nextValue, nextNode);
				createDataType_2004Children(nextNode, nextValue);
				break;
			}
			case PrimitiveType2EditPart.VISUAL_ID: {
				Node nextNode = ViewService.createNode(viewObject, nextValue, UMLVisualIDRegistry.getType(PrimitiveType2EditPart.VISUAL_ID), UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				myEObject2NodeMap.put(nextValue, nextNode);
				createPrimitiveType_2005Children(nextNode, nextValue);
				break;
			}
			case Enumeration2EditPart.VISUAL_ID: {
				Node nextNode = ViewService.createNode(viewObject, nextValue, UMLVisualIDRegistry.getType(Enumeration2EditPart.VISUAL_ID), UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				myEObject2NodeMap.put(nextValue, nextNode);
				createEnumeration_2003Children(nextNode, nextValue);
				break;
			}
			case InterfaceEditPart.VISUAL_ID: {
				Node nextNode = ViewService.createNode(viewObject, nextValue, UMLVisualIDRegistry.getType(InterfaceEditPart.VISUAL_ID), UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				myEObject2NodeMap.put(nextValue, nextNode);
				createInterface_2010Children(nextNode, nextValue);
				break;
			}
			case Interface2EditPart.VISUAL_ID: {
				Node nextNode = ViewService.createNode(viewObject, nextValue, UMLVisualIDRegistry.getType(Interface2EditPart.VISUAL_ID), UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				myEObject2NodeMap.put(nextValue, nextNode);
				createInterface_2013Children(nextNode, nextValue);
				break;
			}
			}
		}
		for (Iterator values = ((Package) modelObject).getPackagedElements().iterator(); values.hasNext();) {
			nextValue = (EObject) values.next();
			nodeVID = UMLVisualIDRegistry.getNodeVisualID(viewObject, nextValue);
			switch (nodeVID) {
			case ConstraintEditPart.VISUAL_ID: {
				Node nextNode = ViewService.createNode(viewObject, nextValue, UMLVisualIDRegistry.getType(ConstraintEditPart.VISUAL_ID), UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				myEObject2NodeMap.put(nextValue, nextNode);
				createConstraint_2006Children(nextNode, nextValue);
				break;
			}
			case InstanceSpecification2EditPart.VISUAL_ID: {
				Node nextNode = ViewService.createNode(viewObject, nextValue, UMLVisualIDRegistry.getType(InstanceSpecification2EditPart.VISUAL_ID), UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				myEObject2NodeMap.put(nextValue, nextNode);
				createInstanceSpecification_2008Children(nextNode, nextValue);
				break;
			}
			case DependencyEditPart.VISUAL_ID: {
				Node nextNode = ViewService.createNode(viewObject, nextValue, UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID), UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				myEObject2NodeMap.put(nextValue, nextNode);
				createDependency_2009Children(nextNode, nextValue);
				break;
			}
			case GeneralizationSetEditPart.VISUAL_ID: {
				Node nextNode = ViewService.createNode(viewObject, nextValue, UMLVisualIDRegistry.getType(GeneralizationSetEditPart.VISUAL_ID), UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				myEObject2NodeMap.put(nextValue, nextNode);
				createGeneralizationSet_2012Children(nextNode, nextValue);
				break;
			}
			}
		}
		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private Node getCompartment(View node, String name) {
		for (Iterator it = node.getChildren().iterator(); it.hasNext();) {
			View nextView = (View) it.next();
			if (nextView instanceof Node && name.equals(nextView.getType())) {
				return (Node) nextView;
			}
		}
		return null;
	}

	/**
	 *@generated
	 */
	private void storeLinks(EObject container, Diagram diagram) {
		EClass containerMetaclass = container.eClass();
		storeFeatureModelFacetLinks(container, containerMetaclass, diagram);
		storeTypeModelFacetLinks(container, containerMetaclass);
	}

	/**
	 * @generated
	 */
	private void storeTypeModelFacetLinks(EObject container, EClass containerMetaclass) {
		storeTypeModelFacetLinks_Generalization_4001(container, containerMetaclass);
		storeTypeModelFacetLinks_Dependency_4002(container, containerMetaclass);
		storeTypeModelFacetLinks_Property_4003(container, containerMetaclass);
		storeTypeModelFacetLinks_Association_4005(container, containerMetaclass);
		storeTypeModelFacetLinks_InterfaceRealization_4008(container, containerMetaclass);
		storeTypeModelFacetLinks_Realization_4010(container, containerMetaclass);
		storeTypeModelFacetLinks_Generalization_4011(container, containerMetaclass);
		storeTypeModelFacetLinks_Usage_4013(container, containerMetaclass);
	}

	/**
	 * @generated
	 */
	private void storeTypeModelFacetLinks_Generalization_4001(EObject container, EClass containerMetaclass) {
		if (UMLPackage.eINSTANCE.getClassifier().isSuperTypeOf(containerMetaclass)) {
			for (Iterator values = ((Classifier) container).getGeneralizations().iterator(); values.hasNext();) {
				EObject nextValue = ((EObject) values.next());
				int linkVID = UMLVisualIDRegistry.getLinkWithClassVisualID(nextValue);
				if (GeneralizationEditPart.VISUAL_ID == linkVID) {
					Object structuralFeatureResult = ((Generalization) nextValue).getGeneral();
					if (structuralFeatureResult instanceof EObject) {
						EObject dst = (EObject) structuralFeatureResult;
						EObject src = container;
						myLinkDescriptors.add(new LinkDescriptor(src, dst, nextValue, UMLElementTypes.Generalization_4001, linkVID));
					}
				}
			}
		}
	}

	/**
	 * @generated
	 */
	private void storeTypeModelFacetLinks_Dependency_4002(EObject container, EClass containerMetaclass) {
		if (UMLPackage.eINSTANCE.getPackage().isSuperTypeOf(containerMetaclass)) {
			for (Iterator values = ((Package) container).getPackagedElements().iterator(); values.hasNext();) {
				EObject nextValue = ((EObject) values.next());
				int linkVID = UMLVisualIDRegistry.getLinkWithClassVisualID(nextValue);
				if (Dependency2EditPart.VISUAL_ID == linkVID) {
					Object structuralFeatureResult = ((Dependency) nextValue).getSuppliers();
					List targets = (List) structuralFeatureResult;
					structuralFeatureResult = targets.size() == 1 ? targets.get(0) : null;
					if (structuralFeatureResult instanceof EObject) {
						EObject dst = (EObject) structuralFeatureResult;
						structuralFeatureResult = ((Dependency) nextValue).getClients();
						List sources = (List) structuralFeatureResult;
						structuralFeatureResult = sources.size() == 1 ? sources.get(0) : null;
						if (structuralFeatureResult instanceof EObject) {
							EObject src = (EObject) structuralFeatureResult;
							myLinkDescriptors.add(new LinkDescriptor(src, dst, nextValue, UMLElementTypes.Dependency_4002, linkVID));
						}
					}
				}
			}
		}
	}

	/**
	 * @generated
	 */
	private void storeTypeModelFacetLinks_Property_4003(EObject container, EClass containerMetaclass) {
		if (UMLPackage.eINSTANCE.getAssociation().isSuperTypeOf(containerMetaclass)) {
			for (Iterator values = ((Association) container).getOwnedEnds().iterator(); values.hasNext();) {
				EObject nextValue = ((EObject) values.next());
				int linkVID = UMLVisualIDRegistry.getLinkWithClassVisualID(nextValue);
				if (Property7EditPart.VISUAL_ID == linkVID) {
					Object structuralFeatureResult = ((TypedElement) nextValue).getType();
					if (structuralFeatureResult instanceof EObject) {
						EObject dst = (EObject) structuralFeatureResult;
						EObject src = container;
						myLinkDescriptors.add(new LinkDescriptor(src, dst, nextValue, UMLElementTypes.Property_4003, linkVID));
					}
				}
			}
		}
	}

	/**
	 * @generated NOT
	 */
	public void storeTypeModelFacetLinks_Association_4005(EObject container, EClass containerMetaclass) {
		if (UMLPackage.eINSTANCE.getPackage().isSuperTypeOf(containerMetaclass)) {
			for (Iterator values = ((Package) container).getPackagedElements().iterator(); values.hasNext();) {
				EObject nextValue = ((EObject) values.next());
				int linkVID = UMLVisualIDRegistry.getLinkWithClassVisualID(nextValue);
				if (AssociationEditPart.VISUAL_ID == linkVID) {
					Association association = (Association) nextValue;
					if (association.isBinary()) {
						Property sourceEnd = AssociationEndConvention.getSourceEnd(association);
						Property targetEnd = AssociationEndConvention.getTargetEnd(association);
						EObject gmfSource = sourceEnd.getType();
						EObject gmfTarget = targetEnd.getType();
						myLinkDescriptors.add(new LinkDescriptor(gmfSource, gmfTarget, association, UMLElementTypes.Association_4005, linkVID));
					}
				}
			}
		}
	}

	/**
	 * @generated
	 */
	private void storeTypeModelFacetLinks_InterfaceRealization_4008(EObject container, EClass containerMetaclass) {
		if (UMLPackage.eINSTANCE.getBehavioredClassifier().isSuperTypeOf(containerMetaclass)) {
			for (Iterator values = ((BehavioredClassifier) container).getInterfaceRealizations().iterator(); values.hasNext();) {
				EObject nextValue = ((EObject) values.next());
				int linkVID = UMLVisualIDRegistry.getLinkWithClassVisualID(nextValue);
				if (InterfaceRealizationEditPart.VISUAL_ID == linkVID) {
					Object structuralFeatureResult = ((InterfaceRealization) nextValue).getContract();
					if (structuralFeatureResult instanceof EObject) {
						EObject dst = (EObject) structuralFeatureResult;
						structuralFeatureResult = ((InterfaceRealization) nextValue).getImplementingClassifier();
						if (structuralFeatureResult instanceof EObject) {
							EObject src = (EObject) structuralFeatureResult;
							myLinkDescriptors.add(new LinkDescriptor(src, dst, nextValue, UMLElementTypes.InterfaceRealization_4008, linkVID));
						}
					}
				}
			}
		}
	}

	/**
	 * @generated
	 */
	private void storeTypeModelFacetLinks_Realization_4010(EObject container, EClass containerMetaclass) {
		if (UMLPackage.eINSTANCE.getPackage().isSuperTypeOf(containerMetaclass)) {
			for (Iterator values = ((Package) container).getPackagedElements().iterator(); values.hasNext();) {
				EObject nextValue = ((EObject) values.next());
				int linkVID = UMLVisualIDRegistry.getLinkWithClassVisualID(nextValue);
				if (RealizationEditPart.VISUAL_ID == linkVID) {
					Object structuralFeatureResult = ((Dependency) nextValue).getSuppliers();
					List targets = (List) structuralFeatureResult;
					structuralFeatureResult = targets.size() == 1 ? targets.get(0) : null;
					if (structuralFeatureResult instanceof EObject) {
						EObject dst = (EObject) structuralFeatureResult;
						structuralFeatureResult = ((Dependency) nextValue).getClients();
						List sources = (List) structuralFeatureResult;
						structuralFeatureResult = sources.size() == 1 ? sources.get(0) : null;
						if (structuralFeatureResult instanceof EObject) {
							EObject src = (EObject) structuralFeatureResult;
							myLinkDescriptors.add(new LinkDescriptor(src, dst, nextValue, UMLElementTypes.Realization_4010, linkVID));
						}
					}
				}
			}
		}
	}

	/**
	 * @generated
	 */
	private void storeTypeModelFacetLinks_Generalization_4011(EObject container, EClass containerMetaclass) {
		if (UMLPackage.eINSTANCE.getClassifier().isSuperTypeOf(containerMetaclass)) {
			for (Iterator values = ((Classifier) container).getGeneralizations().iterator(); values.hasNext();) {
				EObject nextValue = ((EObject) values.next());
				int linkVID = UMLVisualIDRegistry.getLinkWithClassVisualID(nextValue);
				if (Generalization2EditPart.VISUAL_ID == linkVID) {
					Object structuralFeatureResult = ((Generalization) nextValue).getGeneralizationSets();
					List targets = (List) structuralFeatureResult;
					structuralFeatureResult = targets.size() == 1 ? targets.get(0) : null;
					if (structuralFeatureResult instanceof EObject) {
						EObject dst = (EObject) structuralFeatureResult;
						EObject src = container;
						myLinkDescriptors.add(new LinkDescriptor(src, dst, nextValue, UMLElementTypes.Generalization_4011, linkVID));
					}
				}
			}
		}
	}

	/**
	 * @generated
	 */
	private void storeTypeModelFacetLinks_Usage_4013(EObject container, EClass containerMetaclass) {
		if (UMLPackage.eINSTANCE.getPackage().isSuperTypeOf(containerMetaclass)) {
			for (Iterator values = ((Package) container).getPackagedElements().iterator(); values.hasNext();) {
				EObject nextValue = ((EObject) values.next());
				int linkVID = UMLVisualIDRegistry.getLinkWithClassVisualID(nextValue);
				if (UsageEditPart.VISUAL_ID == linkVID) {
					Object structuralFeatureResult = ((Dependency) nextValue).getSuppliers();
					List targets = (List) structuralFeatureResult;
					structuralFeatureResult = targets.size() == 1 ? targets.get(0) : null;
					if (structuralFeatureResult instanceof EObject) {
						EObject dst = (EObject) structuralFeatureResult;
						structuralFeatureResult = ((Dependency) nextValue).getClients();
						List sources = (List) structuralFeatureResult;
						structuralFeatureResult = sources.size() == 1 ? sources.get(0) : null;
						if (structuralFeatureResult instanceof EObject) {
							EObject src = (EObject) structuralFeatureResult;
							myLinkDescriptors.add(new LinkDescriptor(src, dst, nextValue, UMLElementTypes.Usage_4013, linkVID));
						}
					}
				}
			}
		}
	}

	/**
	 *@generated NOT
	 */
	public void storeFeatureModelFacetLinks(EObject container, EClass containerMetaclass, Diagram diagram) {
		if (UMLPackage.eINSTANCE.getGeneralizationSet().isSuperTypeOf(containerMetaclass)) {
			EList<Generalization> generalizations = ((GeneralizationSet) container).getGeneralizations();
			if (generalizations.size() == 0) {
				return;
			}
			EObject nextDestination = (EObject) generalizations.get(0).getGeneral();
			myLinkDescriptors.add(new LinkDescriptor(container, nextDestination, UMLElementTypes.GeneralizationGeneral_4012, GeneralizationGeneralEditPart.VISUAL_ID));

		}
		storeFeatureModelFacetLinksGen(container, containerMetaclass, diagram);
	}

	/**
	 *@generated
	 */
	public void storeFeatureModelFacetLinksGen(EObject container, EClass containerMetaclass, Diagram diagram) {

		if (UMLPackage.eINSTANCE.getConstraint().isSuperTypeOf(containerMetaclass)) {
			for (Iterator destinations = ((Constraint) container).getConstrainedElements().iterator(); destinations.hasNext();) {
				EObject nextDestination = (EObject) destinations.next();
				myLinkDescriptors.add(new LinkDescriptor(container, nextDestination, UMLElementTypes.ConstraintConstrainedElement_4004, ConstraintConstrainedElementEditPart.VISUAL_ID));

			}
		}

		if (UMLPackage.eINSTANCE.getDependency().isSuperTypeOf(containerMetaclass)) {
			for (Iterator destinations = ((Dependency) container).getSuppliers().iterator(); destinations.hasNext();) {
				EObject nextDestination = (EObject) destinations.next();
				myLinkDescriptors.add(new LinkDescriptor(container, nextDestination, UMLElementTypes.DependencySupplier_4006, DependencySupplierEditPart.VISUAL_ID));

			}
		}
		if (UMLPackage.eINSTANCE.getDependency().isSuperTypeOf(containerMetaclass)) {
			for (Iterator destinations = ((Dependency) container).getClients().iterator(); destinations.hasNext();) {
				EObject nextDestination = (EObject) destinations.next();
				myLinkDescriptors.add(new LinkDescriptor(container, nextDestination, UMLElementTypes.DependencyClient_4007, DependencyClientEditPart.VISUAL_ID));

			}
		}

		if (UMLPackage.eINSTANCE.getGeneralization().isSuperTypeOf(containerMetaclass)) {
			EObject nextDestination = (EObject) ((Generalization) container).getGeneral();
			myLinkDescriptors.add(new LinkDescriptor(container, nextDestination, UMLElementTypes.GeneralizationGeneral_4012, GeneralizationGeneralEditPart.VISUAL_ID));

		}

	}

	/**
	 * @generated
	 */
	private void createLinks(Diagram diagram) {
		for (Iterator it = myLinkDescriptors.iterator(); it.hasNext();) {
			LinkDescriptor nextLinkDescriptor = (LinkDescriptor) it.next();
			Edge edge = (Edge) ViewService.getInstance().createEdge(nextLinkDescriptor.getSemanticAdapter(), diagram, String.valueOf(nextLinkDescriptor.getVisualID()), ViewUtil.APPEND,
					UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
			if (edge != null) {
				edge.setSource((Node) myEObject2NodeMap.get(nextLinkDescriptor.getSource()));
				edge.setTarget((Node) myEObject2NodeMap.get(nextLinkDescriptor.getDestination()));
			}
		}
	}

	/**
	 * @generated
	 */
	private class LinkDescriptor {

		/**
		 * @generated
		 */
		private EObject mySource;

		/**
		 * @generated
		 */
		private EObject myDestination;

		/**
		 * @generated
		 */
		private EObject myLinkElement;

		/**
		 * @generated
		 */
		private int myVisualID;

		/**
		 * @generated
		 */
		private IAdaptable mySemanticAdapter;

		/**
		 * @generated
		 */
		protected LinkDescriptor(EObject source, EObject destination, EObject linkElement, IElementType elementType, int linkVID) {
			this(source, destination, linkVID);
			myLinkElement = linkElement;
			final IElementType elementTypeCopy = elementType;
			mySemanticAdapter = new EObjectAdapter(linkElement) {

				public Object getAdapter(Class adapter) {
					if (IElementType.class.equals(adapter)) {
						return elementTypeCopy;
					}
					return super.getAdapter(adapter);
				}
			};
		}

		/**
		 * @generated
		 */
		protected LinkDescriptor(EObject source, EObject destination, IElementType elementType, int linkVID) {
			this(source, destination, linkVID);
			myLinkElement = null;
			final IElementType elementTypeCopy = elementType;
			mySemanticAdapter = new IAdaptable() {

				public Object getAdapter(Class adapter) {
					if (IElementType.class.equals(adapter)) {
						return elementTypeCopy;
					}
					return null;
				}
			};
		}

		/**
		 * @generated
		 */
		private LinkDescriptor(EObject source, EObject destination, int linkVID) {
			mySource = source;
			myDestination = destination;
			myVisualID = linkVID;
		}

		/**
		 * @generated
		 */
		protected EObject getSource() {
			return mySource;
		}

		/**
		 * @generated
		 */
		protected EObject getDestination() {
			return myDestination;
		}

		/**
		 * @generated
		 */
		protected EObject getLinkElement() {
			return myLinkElement;
		}

		/**
		 * @generated
		 */
		protected int getVisualID() {
			return myVisualID;
		}

		/**
		 * @generated
		 */
		protected IAdaptable getSemanticAdapter() {
			return mySemanticAdapter;
		}
	}
}
