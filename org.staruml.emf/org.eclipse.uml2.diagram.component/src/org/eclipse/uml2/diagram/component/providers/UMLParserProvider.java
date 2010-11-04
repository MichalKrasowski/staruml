package org.eclipse.uml2.diagram.component.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserService;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.common.parser.association.end.AssociationEndApplyStrategy;
import org.eclipse.uml2.diagram.common.parser.association.end.AssociationEndParser;
import org.eclipse.uml2.diagram.common.parser.association.end.AssociationEndToString;
import org.eclipse.uml2.diagram.common.parser.association.name.AssociationNameParser;
import org.eclipse.uml2.diagram.common.parser.association.name.AssociationNameToString;
import org.eclipse.uml2.diagram.common.parser.imports.ElementImportParser;
import org.eclipse.uml2.diagram.common.parser.operation.OperationInplaceApplier;
import org.eclipse.uml2.diagram.common.parser.operation.OperationParser;
import org.eclipse.uml2.diagram.common.parser.operation.OperationToString;
import org.eclipse.uml2.diagram.common.parser.port.PortParser;
import org.eclipse.uml2.diagram.common.parser.port.PortToString;
import org.eclipse.uml2.diagram.common.parser.property.PropertyParser;
import org.eclipse.uml2.diagram.common.parser.property.PropertyToString;
import org.eclipse.uml2.diagram.common.parser.stereotype.AppliedStereotypeParser;
import org.eclipse.uml2.diagram.common.parser.stereotype.ClassifierAppliedStereotypeParser;
import org.eclipse.uml2.diagram.common.parser.stereotype.PackageAppliedStereotypeParser;
import org.eclipse.uml2.diagram.component.edit.parts.ArtifactName2EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ArtifactName3EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ArtifactNameEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ArtifactStereo2EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ArtifactStereo3EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ArtifactStereoEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.AssociationName2EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.AssociationName3EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.AssociationName4EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.AssociationName5EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.AssociationName6EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.AssociationName7EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.AssociationNameEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.Class3EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ClassDiagramNotationClassNameEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ClassDiagramNotationClassStereotypeEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ClassDiagramNotationInnerClassEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ClassDiagramNotationOperationEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ClassDiagramNotationPropertyEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ClassName2EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ClassNameEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.CommentBodyEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.Component3EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ComponentName2EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ComponentNameEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ComponentStereo2EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ComponentStereoEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.DependencyNameEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ElementImportEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.InterfaceName2EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.InterfaceNameEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.Package4EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.PackageName2EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.PackageNameEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.PackageStereo2EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.PortName2EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.PortNameEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.PropertyNameEditPart;
import org.eclipse.uml2.diagram.component.expressions.UMLOCLFactory;
import org.eclipse.uml2.diagram.component.parsers.MessageFormatParser;
import org.eclipse.uml2.diagram.component.part.UMLVisualIDRegistry;
import org.eclipse.uml2.diagram.parser.BasicApplyStrategy;
import org.eclipse.uml2.diagram.parser.ParserAdapter;
import org.eclipse.uml2.diagram.parser.SemanticParserAdapter;
import org.eclipse.uml2.diagram.parser.lookup.DefaultOclLookups;
import org.eclipse.uml2.diagram.parser.lookup.LookupSuite;
import org.eclipse.uml2.diagram.parser.lookup.LookupSuiteImpl;
import org.eclipse.uml2.diagram.parser.lookup.OCLLookup;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class UMLParserProvider extends AbstractProvider implements IParserProvider {

	/**
	 * @generated
	 */
	private IParser componentName_5001Parser;

	/**
	 * @generated
	 */
	private IParser getComponentName_5001Parser() {
		if (componentName_5001Parser == null) {
			componentName_5001Parser = createComponentName_5001Parser();
		}
		return componentName_5001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createComponentName_5001Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private ClassifierAppliedStereotypeParser componentQualifiedName_5020Parser;

	/**
	 * @generated
	 */
	private IParser getComponentQualifiedName_5020Parser() {
		if (componentQualifiedName_5020Parser == null) {
			componentQualifiedName_5020Parser = new ClassifierAppliedStereotypeParser();
		}
		return componentQualifiedName_5020Parser;
	}

	/**
	 * @generated
	 */
	private IParser artifactName_5004Parser;

	/**
	 * @generated
	 */
	private IParser getArtifactName_5004Parser() {
		if (artifactName_5004Parser == null) {
			artifactName_5004Parser = createArtifactName_5004Parser();
		}
		return artifactName_5004Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createArtifactName_5004Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private ClassifierAppliedStereotypeParser artifactQualifiedName_5021Parser;

	/**
	 * @generated
	 */
	private IParser getArtifactQualifiedName_5021Parser() {
		if (artifactQualifiedName_5021Parser == null) {
			artifactQualifiedName_5021Parser = new ClassifierAppliedStereotypeParser();
		}
		return artifactQualifiedName_5021Parser;
	}

	/**
	 * @generated
	 */
	private IParser interfaceName_5005Parser;

	/**
	 * @generated
	 */
	private IParser getInterfaceName_5005Parser() {
		if (interfaceName_5005Parser == null) {
			interfaceName_5005Parser = createInterfaceName_5005Parser();
		}
		return interfaceName_5005Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createInterfaceName_5005Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser className_5008Parser;

	/**
	 * @generated
	 */
	private IParser getClassName_5008Parser() {
		if (className_5008Parser == null) {
			className_5008Parser = createClassName_5008Parser();
		}
		return className_5008Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createClassName_5008Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser packageName_5011Parser;

	/**
	 * @generated
	 */
	private IParser getPackageName_5011Parser() {
		if (packageName_5011Parser == null) {
			packageName_5011Parser = createPackageName_5011Parser();
		}
		return packageName_5011Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createPackageName_5011Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private PackageAppliedStereotypeParser packageQualifiedName_5023Parser;

	/**
	 * @generated
	 */
	private IParser getPackageQualifiedName_5023Parser() {
		if (packageQualifiedName_5023Parser == null) {
			packageQualifiedName_5023Parser = new PackageAppliedStereotypeParser();
		}
		return packageQualifiedName_5023Parser;
	}

	/**
	 * @generated
	 */
	private IParser packageName_5012Parser;

	/**
	 * @generated
	 */
	private IParser getPackageName_5012Parser() {
		if (packageName_5012Parser == null) {
			packageName_5012Parser = createPackageName_5012Parser();
		}
		return packageName_5012Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createPackageName_5012Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser className_5014Parser;

	/**
	 * @generated
	 */
	private IParser getClassName_5014Parser() {
		if (className_5014Parser == null) {
			className_5014Parser = createClassName_5014Parser();
		}
		return className_5014Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createClassName_5014Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private ClassifierAppliedStereotypeParser classQualifiedName_5015Parser;

	/**
	 * @generated
	 */
	private IParser getClassQualifiedName_5015Parser() {
		if (classQualifiedName_5015Parser == null) {
			classQualifiedName_5015Parser = new ClassifierAppliedStereotypeParser();
		}
		return classQualifiedName_5015Parser;
	}

	/**
	 * @generated
	 */
	private IParser commentBody_5022Parser;

	/**
	 * @generated
	 */
	private IParser getCommentBody_5022Parser() {
		if (commentBody_5022Parser == null) {
			commentBody_5022Parser = createCommentBody_5022Parser();
		}
		return commentBody_5022Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createCommentBody_5022Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getComment_Body() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * XXX: Misleading name of the method. The only way to fix it is custom template 
	 * @generated NOT
	 */
	protected IParser createClassQualifiedName_5015Parser() {
		return new AppliedStereotypeParser();
	}

	/**
	 * @generated
	 */
	private IParser componentName_5002Parser;

	/**
	 * @generated
	 */
	private IParser getComponentName_5002Parser() {
		if (componentName_5002Parser == null) {
			componentName_5002Parser = createComponentName_5002Parser();
		}
		return componentName_5002Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createComponentName_5002Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private ClassifierAppliedStereotypeParser componentQualifiedName_5019Parser;

	/**
	 * @generated
	 */
	private IParser getComponentQualifiedName_5019Parser() {
		if (componentQualifiedName_5019Parser == null) {
			componentQualifiedName_5019Parser = new ClassifierAppliedStereotypeParser();
		}
		return componentQualifiedName_5019Parser;
	}

	/**
	 * @generated
	 */
	private IParser portName_5003Parser;

	/**
	 * @generated
	 */
	private IParser getPortName_5003Parser() {
		if (portName_5003Parser == null) {
			portName_5003Parser = createPortName_5003Parser();
		}
		return portName_5003Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createPortName_5003Parser() {
		return createPortParser();
	}

	/**
	 * @generated
	 */
	private IParser artifactName_5006Parser;

	/**
	 * @generated
	 */
	private IParser getArtifactName_5006Parser() {
		if (artifactName_5006Parser == null) {
			artifactName_5006Parser = createArtifactName_5006Parser();
		}
		return artifactName_5006Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createArtifactName_5006Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private ClassifierAppliedStereotypeParser artifactQualifiedName_5018Parser;

	/**
	 * @generated
	 */
	private IParser getArtifactQualifiedName_5018Parser() {
		if (artifactQualifiedName_5018Parser == null) {
			artifactQualifiedName_5018Parser = new ClassifierAppliedStereotypeParser();
		}
		return artifactQualifiedName_5018Parser;
	}

	/**
	 * @generated
	 */
	private IParser artifactName_5016Parser;

	/**
	 * @generated
	 */
	private IParser getArtifactName_5016Parser() {
		if (artifactName_5016Parser == null) {
			artifactName_5016Parser = createArtifactName_5016Parser();
		}
		return artifactName_5016Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createArtifactName_5016Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private ClassifierAppliedStereotypeParser artifactQualifiedName_5017Parser;

	/**
	 * @generated
	 */
	private IParser getArtifactQualifiedName_5017Parser() {
		if (artifactQualifiedName_5017Parser == null) {
			artifactQualifiedName_5017Parser = new ClassifierAppliedStereotypeParser();
		}
		return artifactQualifiedName_5017Parser;
	}

	/**
	 * @generated
	 */
	private IParser className_5007Parser;

	/**
	 * @generated
	 */
	private IParser getClassName_5007Parser() {
		if (className_5007Parser == null) {
			className_5007Parser = createClassName_5007Parser();
		}
		return className_5007Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createClassName_5007Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser interfaceName_5009Parser;

	/**
	 * @generated
	 */
	private IParser getInterfaceName_5009Parser() {
		if (interfaceName_5009Parser == null) {
			interfaceName_5009Parser = createInterfaceName_5009Parser();
		}
		return interfaceName_5009Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createInterfaceName_5009Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser propertyName_5010Parser;

	/**
	 * @generated
	 */
	private IParser getPropertyName_5010Parser() {
		if (propertyName_5010Parser == null) {
			propertyName_5010Parser = createPropertyName_5010Parser();
		}
		return propertyName_5010Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createPropertyName_5010Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser elementImport_3007Parser;

	/**
	 * @generated
	 */
	private IParser getElementImport_3007Parser() {
		if (elementImport_3007Parser == null) {
			elementImport_3007Parser = createElementImport_3007Parser();
		}
		return elementImport_3007Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createElementImport_3007Parser() {
		return new ElementImportParser();
	}

	/**
	 * @generated
	 */
	private IParser package_3008Parser;

	/**
	 * @generated
	 */
	private IParser getPackage_3008Parser() {
		if (package_3008Parser == null) {
			package_3008Parser = createPackage_3008Parser();
		}
		return package_3008Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createPackage_3008Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser class_3009Parser;

	/**
	 * @generated
	 */
	private IParser getClass_3009Parser() {
		if (class_3009Parser == null) {
			class_3009Parser = createClass_3009Parser();
		}
		return class_3009Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createClass_3009Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser component_3010Parser;

	/**
	 * @generated
	 */
	private IParser getComponent_3010Parser() {
		if (component_3010Parser == null) {
			component_3010Parser = createComponent_3010Parser();
		}
		return component_3010Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createComponent_3010Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser property_3011Parser;

	/**
	 * @generated
	 */
	private IParser getProperty_3011Parser() {
		if (property_3011Parser == null) {
			property_3011Parser = createProperty_3011Parser();
		}
		return property_3011Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createProperty_3011Parser() {
		LookupSuiteImpl lookupSuite = new LookupSuiteImpl();
		lookupSuite.addLookup(Type.class, TYPE_LOOKUP);
		return new SemanticParserAdapter(new PropertyParser(lookupSuite), new BasicApplyStrategy(), new PropertyToString.VIEW(), new PropertyToString.EDIT());
	}

	/**
	 * @generated
	 */
	private IParser operation_3012Parser;

	/**
	 * @generated
	 */
	private IParser getOperation_3012Parser() {
		if (operation_3012Parser == null) {
			operation_3012Parser = createOperation_3012Parser();
		}
		return operation_3012Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createOperation_3012Parser() {
		LookupSuiteImpl lookupSuite = new LookupSuiteImpl();
		lookupSuite.addLookup(Type.class, TYPE_LOOKUP);
		return new SemanticParserAdapter(new OperationParser(lookupSuite), new OperationInplaceApplier(), new OperationToString.VIEW(), new OperationToString.EDIT());
	}

	/**
	 * @generated
	 */
	private IParser class_3013Parser;

	/**
	 * @generated
	 */
	private IParser getClass_3013Parser() {
		if (class_3013Parser == null) {
			class_3013Parser = createClass_3013Parser();
		}
		return class_3013Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createClass_3013Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser portName_5013Parser;

	/**
	 * @generated
	 */
	private IParser getPortName_5013Parser() {
		if (portName_5013Parser == null) {
			portName_5013Parser = createPortName_5013Parser();
		}
		return portName_5013Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createPortName_5013Parser() {
		return createPortParser();
	}

	private IParser createPortParser() {
		LookupSuiteImpl lookupSuite = new LookupSuiteImpl();
		lookupSuite.addLookup(Type.class, TYPE_LOOKUP);
		return new SemanticParserAdapter(new PortParser(lookupSuite), new BasicApplyStrategy(), new PortToString());
	}

	/**
	 * @generated
	 */
	private IParser dependencyName_6001Parser;

	/**
	 * @NOT-GENERATED
	 * Different view's but shared common edit.
	 */
	private IParser createAssocationRoleParser(boolean sourceNotTarget) {
		LookupSuite lookupSuite = getAssociationLookupSuite();
		return new SemanticParserAdapter(new AssociationEndParser(lookupSuite), new AssociationEndApplyStrategy(sourceNotTarget), new AssociationEndToString.ROLE_VIEW(sourceNotTarget),
				new AssociationEndToString.EDIT(sourceNotTarget));
	}

	/**
	 * @NOT-GENERATED
	 */
	private IParser createAssocationModifiersParser(boolean sourceNotTarget) {
		LookupSuite lookupSuite = getAssociationLookupSuite();
		return new SemanticParserAdapter(new AssociationEndParser(lookupSuite), new AssociationEndApplyStrategy(sourceNotTarget), new AssociationEndToString.MODIFIERS_VIEW(sourceNotTarget),
				new AssociationEndToString.EDIT(sourceNotTarget));
	}

	/**
	 * @NOT-GENERATED
	 */
	protected IParser createAssocationMultiplicityParser(boolean sourceNotTarget) {
		LookupSuite lookupSuite = getAssociationLookupSuite();
		return new SemanticParserAdapter(new AssociationEndParser(lookupSuite), new AssociationEndApplyStrategy(sourceNotTarget), new AssociationEndToString.MULTIPLICITY_VIEW(sourceNotTarget),
				new AssociationEndToString.EDIT(sourceNotTarget));
	}

	/**
	 * @NOT-GENERATED
	 */
	private LookupSuite getAssociationLookupSuite() {
		return LookupSuite.NULL_SUITE;
	}

	/**
	 * @generated
	 */
	private IParser getDependencyName_6001Parser() {
		if (dependencyName_6001Parser == null) {
			dependencyName_6001Parser = createDependencyName_6001Parser();
		}
		return dependencyName_6001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createDependencyName_6001Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser associationName_6002Parser;

	/**
	 * @generated
	 */
	private IParser getAssociationName_6002Parser() {
		if (associationName_6002Parser == null) {
			associationName_6002Parser = createAssociationName_6002Parser();
		}
		return associationName_6002Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createAssociationName_6002Parser() {
		LookupSuite lookupSuite = LookupSuite.NULL_SUITE;
		return new ParserAdapter(new AssociationNameParser(lookupSuite), new BasicApplyStrategy(), new AssociationNameToString.VIEW(), new AssociationNameToString.EDIT());
	}

	/**
	 * @generated
	 */
	private IParser associationName_6003Parser;

	/**
	 * @generated
	 */
	private IParser getAssociationName_6003Parser() {
		if (associationName_6003Parser == null) {
			associationName_6003Parser = createAssociationName_6003Parser();
		}
		return associationName_6003Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createAssociationName_6003Parser() {
		return createAssocationRoleParser(true);
	}

	/**
	 * @generated
	 */
	private IParser associationName_6004Parser;

	/**
	 * @generated
	 */
	private IParser getAssociationName_6004Parser() {
		if (associationName_6004Parser == null) {
			associationName_6004Parser = createAssociationName_6004Parser();
		}
		return associationName_6004Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createAssociationName_6004Parser() {
		return createAssocationRoleParser(false);
	}

	/**
	 * @generated
	 */
	private IParser associationName_6005Parser;

	/**
	 * @generated
	 */
	private IParser getAssociationName_6005Parser() {
		if (associationName_6005Parser == null) {
			associationName_6005Parser = createAssociationName_6005Parser();
		}
		return associationName_6005Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createAssociationName_6005Parser() {
		return createAssocationModifiersParser(true);
	}

	/**
	 * @generated
	 */
	private IParser associationName_6006Parser;

	/**
	 * @generated
	 */
	private IParser getAssociationName_6006Parser() {
		if (associationName_6006Parser == null) {
			associationName_6006Parser = createAssociationName_6006Parser();
		}
		return associationName_6006Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createAssociationName_6006Parser() {
		return createAssocationModifiersParser(false);
	}

	/**
	 * @generated
	 */
	private IParser associationName_6007Parser;

	/**
	 * @generated
	 */
	private IParser getAssociationName_6007Parser() {
		if (associationName_6007Parser == null) {
			associationName_6007Parser = createAssociationName_6007Parser();
		}
		return associationName_6007Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createAssociationName_6007Parser() {
		return createAssocationMultiplicityParser(true);
	}

	/**
	 * @generated
	 */
	private IParser associationName_6008Parser;

	/**
	 * @generated
	 */
	private IParser getAssociationName_6008Parser() {
		if (associationName_6008Parser == null) {
			associationName_6008Parser = createAssociationName_6008Parser();
		}
		return associationName_6008Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createAssociationName_6008Parser() {
		return createAssocationMultiplicityParser(false);
	}

	public static final OCLLookup<Type> TYPE_LOOKUP = new OCLLookup<Type>(//
			UMLOCLFactory.getOCLLookupExpression(DefaultOclLookups.DEFAULT_TYPE_LOOKUP, UMLPackage.eINSTANCE.getNamedElement()), // 
			new IElementType[] { //
			/*
			 UMLElementTypes.Class_2004, // 
			 */
			});

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case ComponentName2EditPart.VISUAL_ID:
			return getComponentName_5001Parser();
		case ComponentStereoEditPart.VISUAL_ID:
			return getComponentQualifiedName_5020Parser();
		case ArtifactName2EditPart.VISUAL_ID:
			return getArtifactName_5004Parser();
		case ArtifactStereoEditPart.VISUAL_ID:
			return getArtifactQualifiedName_5021Parser();
		case InterfaceName2EditPart.VISUAL_ID:
			return getInterfaceName_5005Parser();
		case ClassName2EditPart.VISUAL_ID:
			return getClassName_5008Parser();
		case PackageNameEditPart.VISUAL_ID:
			return getPackageName_5011Parser();
		case PackageStereo2EditPart.VISUAL_ID:
			return getPackageQualifiedName_5023Parser();
		case PackageName2EditPart.VISUAL_ID:
			return getPackageName_5012Parser();
		case ClassDiagramNotationClassNameEditPart.VISUAL_ID:
			return getClassName_5014Parser();
		case ClassDiagramNotationClassStereotypeEditPart.VISUAL_ID:
			return getClassQualifiedName_5015Parser();
		case CommentBodyEditPart.VISUAL_ID:
			return getCommentBody_5022Parser();
		case ComponentNameEditPart.VISUAL_ID:
			return getComponentName_5002Parser();
		case ComponentStereo2EditPart.VISUAL_ID:
			return getComponentQualifiedName_5019Parser();
		case PortNameEditPart.VISUAL_ID:
			return getPortName_5003Parser();
		case ArtifactNameEditPart.VISUAL_ID:
			return getArtifactName_5006Parser();
		case ArtifactStereo2EditPart.VISUAL_ID:
			return getArtifactQualifiedName_5018Parser();
		case ArtifactName3EditPart.VISUAL_ID:
			return getArtifactName_5016Parser();
		case ArtifactStereo3EditPart.VISUAL_ID:
			return getArtifactQualifiedName_5017Parser();
		case ClassNameEditPart.VISUAL_ID:
			return getClassName_5007Parser();
		case InterfaceNameEditPart.VISUAL_ID:
			return getInterfaceName_5009Parser();
		case PropertyNameEditPart.VISUAL_ID:
			return getPropertyName_5010Parser();
		case ElementImportEditPart.VISUAL_ID:
			return getElementImport_3007Parser();
		case Package4EditPart.VISUAL_ID:
			return getPackage_3008Parser();
		case Class3EditPart.VISUAL_ID:
			return getClass_3009Parser();
		case Component3EditPart.VISUAL_ID:
			return getComponent_3010Parser();
		case ClassDiagramNotationPropertyEditPart.VISUAL_ID:
			return getProperty_3011Parser();
		case ClassDiagramNotationOperationEditPart.VISUAL_ID:
			return getOperation_3012Parser();
		case ClassDiagramNotationInnerClassEditPart.VISUAL_ID:
			return getClass_3013Parser();
		case PortName2EditPart.VISUAL_ID:
			return getPortName_5013Parser();
		case DependencyNameEditPart.VISUAL_ID:
			return getDependencyName_6001Parser();
		case AssociationNameEditPart.VISUAL_ID:
			return getAssociationName_6002Parser();
		case AssociationName2EditPart.VISUAL_ID:
			return getAssociationName_6003Parser();
		case AssociationName3EditPart.VISUAL_ID:
			return getAssociationName_6004Parser();
		case AssociationName4EditPart.VISUAL_ID:
			return getAssociationName_6005Parser();
		case AssociationName5EditPart.VISUAL_ID:
			return getAssociationName_6006Parser();
		case AssociationName6EditPart.VISUAL_ID:
			return getAssociationName_6007Parser();
		case AssociationName7EditPart.VISUAL_ID:
			return getAssociationName_6008Parser();
		}
		return null;
	}

	/**
	 * Utility method that consults ParserService
	 * @generated
	 */
	public static IParser getParser(IElementType type, EObject object, String parserHint) {
		return ParserService.getInstance().getParser(new HintAdapter(type, object, parserHint));
	}

	/**
	 * @generated
	 */
	public IParser getParser(IAdaptable hint) {
		String vid = (String) hint.getAdapter(String.class);
		if (vid != null) {
			return getParser(UMLVisualIDRegistry.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(UMLVisualIDRegistry.getVisualID(view));
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (UMLElementTypes.getElement(hint) == null) {
				return false;
			}
			return getParser(hint) != null;
		}
		return false;
	}

	/**
	 * @generated
	 */
	private static class HintAdapter extends ParserHintAdapter {

		private final IElementType elementType;

		public HintAdapter(IElementType type, EObject object, String parserHint) {
			super(object, parserHint);
			assert type != null;
			elementType = type;
		}

		public Object getAdapter(Class adapter) {
			if (IElementType.class.equals(adapter)) {
				return elementType;
			}
			return super.getAdapter(adapter);
		}
	}
}
