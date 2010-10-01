package org.eclipse.uml2.diagram.clazz.providers;

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
import org.eclipse.uml2.diagram.clazz.edit.parts.AssociationClassEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.AssociationClassNameEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.AssociationClassStereotypeEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.AssociationInstanceSourceEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.AssociationInstanceTargetEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.AssociationName2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.AssociationName3EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.AssociationName4EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.AssociationName5EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.AssociationName6EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.AssociationName7EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.AssociationNameEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.AssociationStereotypeEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Class3EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Class4EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.ClassEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.ClassName2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.ClassNameEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.ClassStereotype2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.ClassStereotypeEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.CommentBodyEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.ConstraintLanguageEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.ConstraintNameEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.DataTypeEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.DataTypeName2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.DataTypeNameEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.DataTypeStereotype2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.DataTypeStereotypeEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.DependencyName2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.DependencyName3EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.DependencyNameEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.ElementImportEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.EnumerationEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.EnumerationLiteralEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.EnumerationName2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.EnumerationNameEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.EnumerationStereotype2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.EnumerationStereotypeEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.ExpressionEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.GeneralizationSetIsCoveringIsDisjointEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.GeneralizationSetNameEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.GeneralizationStereotype2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.GeneralizationStereotypeEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.InstanceSpecificationEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.InstanceSpecificationName2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.InstanceSpecificationName3EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.InstanceSpecificationNameEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.InstanceSpecificationStereo2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.InstanceSpecificationStereoEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Interface3EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.InterfaceName2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.InterfaceNameEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.InterfaceRealizationStereotypeEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.InterfaceStereotypeEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.LiteralIntegerEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.LiteralStringEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Operation2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Operation3EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Operation4EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Operation5EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Operation6EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.OperationEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Package3EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.PackageName2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.PackageName3EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.PackageName4EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.PackageNameEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.PackageStereo2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.PortNameEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.PrimitiveTypeEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.PrimitiveTypeName2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.PrimitiveTypeNameEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.PrimitiveTypeStereotype2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.PrimitiveTypeStereotypeEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Property2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Property3EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Property4EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Property5EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Property6EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.PropertyEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.PropertyName2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.PropertyName3EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.PropertyNameEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.RealizationNameEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.RealizationStereotypeEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.SlotEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.TemplateBindingStereotypeEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.UsageStereotypeEditPart;
import org.eclipse.uml2.diagram.clazz.expressions.UMLOCLFactory;
import org.eclipse.uml2.diagram.clazz.parser.GeneralizationSetParser;
import org.eclipse.uml2.diagram.clazz.parser.InstanceSpecificationValueParser;
import org.eclipse.uml2.diagram.clazz.parser.NamedElementParser;
import org.eclipse.uml2.diagram.clazz.parser.dependency.DependencyTypeParser;
import org.eclipse.uml2.diagram.clazz.parsers.MessageFormatParser;
import org.eclipse.uml2.diagram.clazz.part.UMLVisualIDRegistry;
import org.eclipse.uml2.diagram.common.parser.association.AssociationInstanceParser;
import org.eclipse.uml2.diagram.common.parser.association.end.AssociationEndApplyStrategy;
import org.eclipse.uml2.diagram.common.parser.association.end.AssociationEndParser;
import org.eclipse.uml2.diagram.common.parser.association.end.AssociationEndToString;
import org.eclipse.uml2.diagram.common.parser.association.name.AssociationNameParser;
import org.eclipse.uml2.diagram.common.parser.association.name.AssociationNameToString;
import org.eclipse.uml2.diagram.common.parser.imports.ElementImportParser;
import org.eclipse.uml2.diagram.common.parser.instance.InstanceSpecificationParser;
import org.eclipse.uml2.diagram.common.parser.instance.InstanceSpecificationToString;
import org.eclipse.uml2.diagram.common.parser.operation.OperationSemanticParser;
import org.eclipse.uml2.diagram.common.parser.port.PortParser;
import org.eclipse.uml2.diagram.common.parser.port.PortToString;
import org.eclipse.uml2.diagram.common.parser.property.PropertySemanticParser;
import org.eclipse.uml2.diagram.common.parser.slot.SlotLookupSuite;
import org.eclipse.uml2.diagram.common.parser.slot.SlotParser;
import org.eclipse.uml2.diagram.common.parser.slot.SlotToString;
import org.eclipse.uml2.diagram.common.parser.stereotype.AppliedStereotypeParser;
import org.eclipse.uml2.diagram.common.parser.stereotype.ClassifierAppliedStereotypeParser;
import org.eclipse.uml2.diagram.common.parser.stereotype.DependencyAppliedStereotypeParser;
import org.eclipse.uml2.diagram.common.parser.stereotype.PackageAppliedStereotypeParser;
import org.eclipse.uml2.diagram.common.parser.valuespec.ConstraintLanguageParser;
import org.eclipse.uml2.diagram.common.parser.valuespec.ValueSpecificationParser;
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
	private IParser packageName_5004Parser;

	/**
	 * @generated
	 */
	private IParser getPackageName_5004Parser() {
		if (packageName_5004Parser == null) {
			packageName_5004Parser = createPackageName_5004Parser();
		}
		return packageName_5004Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createPackageName_5004Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser className_5003Parser;

	/**
	 * @generated
	 */
	private IParser getClassName_5003Parser() {
		if (className_5003Parser == null) {
			className_5003Parser = createClassName_5003Parser();
		}
		return className_5003Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createClassName_5003Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private ClassifierAppliedStereotypeParser classQualifiedName_5019Parser;

	/**
	 * @generated
	 */
	private IParser getClassQualifiedName_5019Parser() {
		if (classQualifiedName_5019Parser == null) {
			classQualifiedName_5019Parser = new ClassifierAppliedStereotypeParser();
		}
		return classQualifiedName_5019Parser;
	}

	/**
	 * @generated
	 */
	private IParser associationClassName_5009Parser;

	/**
	 * @generated
	 */
	private IParser getAssociationClassName_5009Parser() {
		if (associationClassName_5009Parser == null) {
			associationClassName_5009Parser = createAssociationClassName_5009Parser();
		}
		return associationClassName_5009Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createAssociationClassName_5009Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private ClassifierAppliedStereotypeParser associationClassQualifiedName_5031Parser;

	/**
	 * @generated
	 */
	private IParser getAssociationClassQualifiedName_5031Parser() {
		if (associationClassQualifiedName_5031Parser == null) {
			associationClassQualifiedName_5031Parser = new ClassifierAppliedStereotypeParser();
		}
		return associationClassQualifiedName_5031Parser;
	}

	/**
	 * @generated
	 */
	private IParser dataTypeName_5006Parser;

	/**
	 * @generated
	 */
	private IParser getDataTypeName_5006Parser() {
		if (dataTypeName_5006Parser == null) {
			dataTypeName_5006Parser = createDataTypeName_5006Parser();
		}
		return dataTypeName_5006Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createDataTypeName_5006Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private ClassifierAppliedStereotypeParser dataTypeQualifiedName_5032Parser;

	/**
	 * @generated
	 */
	private IParser getDataTypeQualifiedName_5032Parser() {
		if (dataTypeQualifiedName_5032Parser == null) {
			dataTypeQualifiedName_5032Parser = new ClassifierAppliedStereotypeParser();
		}
		return dataTypeQualifiedName_5032Parser;
	}

	/**
	 * @generated
	 */
	private IParser primitiveTypeName_5007Parser;

	/**
	 * @generated
	 */
	private IParser getPrimitiveTypeName_5007Parser() {
		if (primitiveTypeName_5007Parser == null) {
			primitiveTypeName_5007Parser = createPrimitiveTypeName_5007Parser();
		}
		return primitiveTypeName_5007Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createPrimitiveTypeName_5007Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private ClassifierAppliedStereotypeParser primitiveTypeQualifiedName_5033Parser;

	/**
	 * @generated
	 */
	private IParser getPrimitiveTypeQualifiedName_5033Parser() {
		if (primitiveTypeQualifiedName_5033Parser == null) {
			primitiveTypeQualifiedName_5033Parser = new ClassifierAppliedStereotypeParser();
		}
		return primitiveTypeQualifiedName_5033Parser;
	}

	/**
	 * @generated
	 */
	private IParser enumerationName_5005Parser;

	/**
	 * @generated
	 */
	private IParser getEnumerationName_5005Parser() {
		if (enumerationName_5005Parser == null) {
			enumerationName_5005Parser = createEnumerationName_5005Parser();
		}
		return enumerationName_5005Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEnumerationName_5005Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private ClassifierAppliedStereotypeParser enumerationQualifiedName_5034Parser;

	/**
	 * @generated
	 */
	private IParser getEnumerationQualifiedName_5034Parser() {
		if (enumerationQualifiedName_5034Parser == null) {
			enumerationQualifiedName_5034Parser = new ClassifierAppliedStereotypeParser();
		}
		return enumerationQualifiedName_5034Parser;
	}

	/**
	 * @generated
	 */
	private IParser interfaceName_5012Parser;

	/**
	 * @generated
	 */
	private IParser getInterfaceName_5012Parser() {
		if (interfaceName_5012Parser == null) {
			interfaceName_5012Parser = createInterfaceName_5012Parser();
		}
		return interfaceName_5012Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createInterfaceName_5012Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser constraintName_5008Parser;

	/**
	 * @generated
	 */
	private IParser getConstraintName_5008Parser() {
		if (constraintName_5008Parser == null) {
			constraintName_5008Parser = createConstraintName_5008Parser();
		}
		return constraintName_5008Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createConstraintName_5008Parser() {
		return new ValueSpecificationParser.ConstraintParser();
	}

	/**
	 * @generated
	 */
	private ConstraintLanguageParser constraintLanguage_5042Parser;

	/**
	 * @generated
	 */
	private IParser getConstraintLanguage_5042Parser() {
		if (constraintLanguage_5042Parser == null) {
			constraintLanguage_5042Parser = new ConstraintLanguageParser();
		}
		return constraintLanguage_5042Parser;
	}

	/**
	 * @generated
	 */
	private IParser instanceSpecificationName_5010Parser;

	/**
	 * @generated
	 */
	private IParser getInstanceSpecificationName_5010Parser() {
		if (instanceSpecificationName_5010Parser == null) {
			instanceSpecificationName_5010Parser = createInstanceSpecificationName_5010Parser();
		}
		return instanceSpecificationName_5010Parser;
	}

	/**
	 * @generated
	 */
	private IParser dependencyName_5011Parser;

	/**
	 * @generated
	 */
	private IParser getDependencyName_5011Parser() {
		if (dependencyName_5011Parser == null) {
			dependencyName_5011Parser = createDependencyName_5011Parser();
		}
		return dependencyName_5011Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createDependencyName_5011Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser generalizationSetIsCoveringIsDisjoint_5016Parser;

	/**
	 * @generated
	 */
	private IParser getGeneralizationSetIsCoveringIsDisjoint_5016Parser() {
		if (generalizationSetIsCoveringIsDisjoint_5016Parser == null) {
			generalizationSetIsCoveringIsDisjoint_5016Parser = createGeneralizationSetIsCoveringIsDisjoint_5016Parser();
		}
		return generalizationSetIsCoveringIsDisjoint_5016Parser;
	}

	/**
	 * @generated
	 */
	private IParser generalizationSetName_5017Parser;

	/**
	 * @generated
	 */
	private IParser getGeneralizationSetName_5017Parser() {
		if (generalizationSetName_5017Parser == null) {
			generalizationSetName_5017Parser = createGeneralizationSetName_5017Parser();
		}
		return generalizationSetName_5017Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createGeneralizationSetName_5017Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		parser.setViewPattern(":{0}"); //$NON-NLS-1$
		parser.setEditorPattern(":{0}"); //$NON-NLS-1$
		parser.setEditPattern(":{0}"); //$NON-NLS-1$
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser interfaceName_5018Parser;

	/**
	 * @generated
	 */
	private IParser getInterfaceName_5018Parser() {
		if (interfaceName_5018Parser == null) {
			interfaceName_5018Parser = createInterfaceName_5018Parser();
		}
		return interfaceName_5018Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createInterfaceName_5018Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private ClassifierAppliedStereotypeParser interfaceQualifiedName_5035Parser;

	/**
	 * @generated
	 */
	private IParser getInterfaceQualifiedName_5035Parser() {
		if (interfaceQualifiedName_5035Parser == null) {
			interfaceQualifiedName_5035Parser = new ClassifierAppliedStereotypeParser();
		}
		return interfaceQualifiedName_5035Parser;
	}

	/**
	 * @generated
	 */
	private IParser packageName_5020Parser;

	/**
	 * @generated
	 */
	private IParser getPackageName_5020Parser() {
		if (packageName_5020Parser == null) {
			packageName_5020Parser = createPackageName_5020Parser();
		}
		return packageName_5020Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createPackageName_5020Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private PackageAppliedStereotypeParser packageQualifiedName_5041Parser;

	/**
	 * @generated
	 */
	private IParser getPackageQualifiedName_5041Parser() {
		if (packageQualifiedName_5041Parser == null) {
			packageQualifiedName_5041Parser = new PackageAppliedStereotypeParser();
		}
		return packageQualifiedName_5041Parser;
	}

	/**
	 * @generated
	 */
	private IParser packageName_5026Parser;

	/**
	 * @generated
	 */
	private IParser getPackageName_5026Parser() {
		if (packageName_5026Parser == null) {
			packageName_5026Parser = createPackageName_5026Parser();
		}
		return packageName_5026Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createPackageName_5026Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser instanceSpecificationName_5029Parser;

	/**
	 * @generated
	 */
	private IParser getInstanceSpecificationName_5029Parser() {
		if (instanceSpecificationName_5029Parser == null) {
			instanceSpecificationName_5029Parser = createInstanceSpecificationName_5029Parser();
		}
		return instanceSpecificationName_5029Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createInstanceSpecificationName_5029Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser commentBody_5030Parser;

	/**
	 * @generated
	 */
	private IParser getCommentBody_5030Parser() {
		if (commentBody_5030Parser == null) {
			commentBody_5030Parser = createCommentBody_5030Parser();
		}
		return commentBody_5030Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createCommentBody_5030Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getComment_Body() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createInstanceSpecificationLabel_5030Parser() {
		return new InstanceSpecificationValueParser();
	}

	/**
	 * @generated
	 */
	private IParser package_3006Parser;

	/**
	 * @generated
	 */
	private IParser getPackage_3006Parser() {
		if (package_3006Parser == null) {
			package_3006Parser = createPackage_3006Parser();
		}
		return package_3006Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createPackage_3006Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser class_3007Parser;

	/**
	 * @generated
	 */
	private IParser getClass_3007Parser() {
		if (class_3007Parser == null) {
			class_3007Parser = createClass_3007Parser();
		}
		return class_3007Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createClass_3007Parser() {
		return new NamedElementParser();
	}

	/**
	 * @generated
	 */
	private IParser dataType_3008Parser;

	/**
	 * @generated
	 */
	private IParser getDataType_3008Parser() {
		if (dataType_3008Parser == null) {
			dataType_3008Parser = createDataType_3008Parser();
		}
		return dataType_3008Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createDataType_3008Parser() {
		return new NamedElementParser();
	}

	/**
	 * @generated
	 */
	private IParser primitiveType_3009Parser;

	/**
	 * @generated
	 */
	private IParser getPrimitiveType_3009Parser() {
		if (primitiveType_3009Parser == null) {
			primitiveType_3009Parser = createPrimitiveType_3009Parser();
		}
		return primitiveType_3009Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createPrimitiveType_3009Parser() {
		return new NamedElementParser();
	}

	/**
	 * @generated
	 */
	private IParser enumeration_3011Parser;

	/**
	 * @generated
	 */
	private IParser getEnumeration_3011Parser() {
		if (enumeration_3011Parser == null) {
			enumeration_3011Parser = createEnumeration_3011Parser();
		}
		return enumeration_3011Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createEnumeration_3011Parser() {
		return new NamedElementParser();
	}

	/**
	 * @generated
	 */
	private IParser associationClass_3012Parser;

	/**
	 * @generated
	 */
	private IParser getAssociationClass_3012Parser() {
		if (associationClass_3012Parser == null) {
			associationClass_3012Parser = createAssociationClass_3012Parser();
		}
		return associationClass_3012Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createAssociationClass_3012Parser() {
		return new NamedElementParser();
	}

	/**
	 * @generated
	 */
	private IParser interface_3041Parser;

	/**
	 * @generated
	 */
	private IParser getInterface_3041Parser() {
		if (interface_3041Parser == null) {
			interface_3041Parser = createInterface_3041Parser();
		}
		return interface_3041Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createInterface_3041Parser() {
		return new NamedElementParser();
	}

	/**
	 * @generated
	 */
	private IParser instanceSpecification_3013Parser;

	/**
	 * @generated
	 */
	private IParser getInstanceSpecification_3013Parser() {
		if (instanceSpecification_3013Parser == null) {
			instanceSpecification_3013Parser = createInstanceSpecification_3013Parser();
		}
		return instanceSpecification_3013Parser;
	}

	/**
	 * @generated
	 */
	private IParser property_3001Parser;

	/**
	 * @generated
	 */
	private IParser getProperty_3001Parser() {
		if (property_3001Parser == null) {
			property_3001Parser = createProperty_3001Parser();
		}
		return property_3001Parser;
	}

	/**
	 * @generated
	 */
	private IParser operation_3002Parser;

	/**
	 * @generated
	 */
	private IParser getOperation_3002Parser() {
		if (operation_3002Parser == null) {
			operation_3002Parser = createOperation_3002Parser();
		}
		return operation_3002Parser;
	}

	/**
	 * @generated
	 */
	private IParser class_3003Parser;

	/**
	 * @generated
	 */
	private IParser getClass_3003Parser() {
		if (class_3003Parser == null) {
			class_3003Parser = createClass_3003Parser();
		}
		return class_3003Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createClass_3003Parser() {
		return new NamedElementParser();
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
	 * @generated
	 */
	private IParser property_3019Parser;

	/**
	 * @generated
	 */
	private IParser getProperty_3019Parser() {
		if (property_3019Parser == null) {
			property_3019Parser = createProperty_3019Parser();
		}
		return property_3019Parser;
	}

	/**
	 * @generated
	 */
	private IParser operation_3020Parser;

	/**
	 * @generated
	 */
	private IParser getOperation_3020Parser() {
		if (operation_3020Parser == null) {
			operation_3020Parser = createOperation_3020Parser();
		}
		return operation_3020Parser;
	}

	/**
	 * @generated
	 */
	private IParser property_3014Parser;

	/**
	 * @generated
	 */
	private IParser getProperty_3014Parser() {
		if (property_3014Parser == null) {
			property_3014Parser = createProperty_3014Parser();
		}
		return property_3014Parser;
	}

	/**
	 * @generated
	 */
	private IParser operation_3015Parser;

	/**
	 * @generated
	 */
	private IParser getOperation_3015Parser() {
		if (operation_3015Parser == null) {
			operation_3015Parser = createOperation_3015Parser();
		}
		return operation_3015Parser;
	}

	/**
	 * @generated
	 */
	private IParser property_3021Parser;

	/**
	 * @generated
	 */
	private IParser getProperty_3021Parser() {
		if (property_3021Parser == null) {
			property_3021Parser = createProperty_3021Parser();
		}
		return property_3021Parser;
	}

	/**
	 * @generated
	 */
	private IParser operation_3022Parser;

	/**
	 * @generated
	 */
	private IParser getOperation_3022Parser() {
		if (operation_3022Parser == null) {
			operation_3022Parser = createOperation_3022Parser();
		}
		return operation_3022Parser;
	}

	/**
	 * @generated
	 */
	private IParser enumerationLiteral_3016Parser;

	/**
	 * @generated
	 */
	private IParser getEnumerationLiteral_3016Parser() {
		if (enumerationLiteral_3016Parser == null) {
			enumerationLiteral_3016Parser = createEnumerationLiteral_3016Parser();
		}
		return enumerationLiteral_3016Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEnumerationLiteral_3016Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser property_3023Parser;

	/**
	 * @generated
	 */
	private IParser getProperty_3023Parser() {
		if (property_3023Parser == null) {
			property_3023Parser = createProperty_3023Parser();
		}
		return property_3023Parser;
	}

	/**
	 * @generated
	 */
	private IParser operation_3024Parser;

	/**
	 * @generated
	 */
	private IParser getOperation_3024Parser() {
		if (operation_3024Parser == null) {
			operation_3024Parser = createOperation_3024Parser();
		}
		return operation_3024Parser;
	}

	/**
	 * @generated
	 */
	private IParser slot_3017Parser;

	/**
	 * @generated
	 */
	private IParser getSlot_3017Parser() {
		if (slot_3017Parser == null) {
			slot_3017Parser = createSlot_3017Parser();
		}
		return slot_3017Parser;
	}

	/**
	 * @generated
	 */
	private IParser property_3028Parser;

	/**
	 * @generated
	 */
	private IParser getProperty_3028Parser() {
		if (property_3028Parser == null) {
			property_3028Parser = createProperty_3028Parser();
		}
		return property_3028Parser;
	}

	/**
	 * @generated
	 */
	private IParser operation_3029Parser;

	/**
	 * @generated
	 */
	private IParser getOperation_3029Parser() {
		if (operation_3029Parser == null) {
			operation_3029Parser = createOperation_3029Parser();
		}
		return operation_3029Parser;
	}

	/**
	 * @generated
	 */
	private IParser class_3030Parser;

	/**
	 * @generated
	 */
	private IParser getClass_3030Parser() {
		if (class_3030Parser == null) {
			class_3030Parser = createClass_3030Parser();
		}
		return class_3030Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createClass_3030Parser() {
		return new NamedElementParser();
	}

	/**
	 * @generated
	 */
	private IParser elementImport_3031Parser;

	/**
	 * @generated
	 */
	private IParser getElementImport_3031Parser() {
		if (elementImport_3031Parser == null) {
			elementImport_3031Parser = createElementImport_3031Parser();
		}
		return elementImport_3031Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createElementImport_3031Parser() {
		return new ElementImportParser();
	}

	/**
	 * @generated
	 */
	private IParser packageName_5025Parser;

	/**
	 * @generated
	 */
	private IParser getPackageName_5025Parser() {
		if (packageName_5025Parser == null) {
			packageName_5025Parser = createPackageName_5025Parser();
		}
		return packageName_5025Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createPackageName_5025Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser className_5021Parser;

	/**
	 * @generated
	 */
	private IParser getClassName_5021Parser() {
		if (className_5021Parser == null) {
			className_5021Parser = createClassName_5021Parser();
		}
		return className_5021Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createClassName_5021Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private ClassifierAppliedStereotypeParser classQualifiedName_5022Parser;

	/**
	 * @generated
	 */
	private IParser getClassQualifiedName_5022Parser() {
		if (classQualifiedName_5022Parser == null) {
			classQualifiedName_5022Parser = new ClassifierAppliedStereotypeParser();
		}
		return classQualifiedName_5022Parser;
	}

	/**
	 * @generated
	 */
	private IParser enumerationName_5023Parser;

	/**
	 * @generated
	 */
	private IParser getEnumerationName_5023Parser() {
		if (enumerationName_5023Parser == null) {
			enumerationName_5023Parser = createEnumerationName_5023Parser();
		}
		return enumerationName_5023Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEnumerationName_5023Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private ClassifierAppliedStereotypeParser enumerationQualifiedName_5036Parser;

	/**
	 * @generated
	 */
	private IParser getEnumerationQualifiedName_5036Parser() {
		if (enumerationQualifiedName_5036Parser == null) {
			enumerationQualifiedName_5036Parser = new ClassifierAppliedStereotypeParser();
		}
		return enumerationQualifiedName_5036Parser;
	}

	/**
	 * @generated
	 */
	private IParser instanceSpecificationName_5024Parser;

	/**
	 * @generated
	 */
	private IParser getInstanceSpecificationName_5024Parser() {
		if (instanceSpecificationName_5024Parser == null) {
			instanceSpecificationName_5024Parser = createInstanceSpecificationName_5024Parser();
		}
		return instanceSpecificationName_5024Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createInstanceSpecificationName_5024Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser instanceSpecificationQualifiedName_5040Parser;

	/**
	 * @generated
	 */
	private IParser getInstanceSpecificationQualifiedName_5040Parser() {
		if (instanceSpecificationQualifiedName_5040Parser == null) {
			instanceSpecificationQualifiedName_5040Parser = new AppliedStereotypeParser();
		}
		return instanceSpecificationQualifiedName_5040Parser;
	}

	/**
	 * @generated
	 */
	private IParser dataTypeName_5027Parser;

	/**
	 * @generated
	 */
	private IParser getDataTypeName_5027Parser() {
		if (dataTypeName_5027Parser == null) {
			dataTypeName_5027Parser = createDataTypeName_5027Parser();
		}
		return dataTypeName_5027Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createDataTypeName_5027Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private ClassifierAppliedStereotypeParser dataTypeQualifiedName_5037Parser;

	/**
	 * @generated
	 */
	private IParser getDataTypeQualifiedName_5037Parser() {
		if (dataTypeQualifiedName_5037Parser == null) {
			dataTypeQualifiedName_5037Parser = new ClassifierAppliedStereotypeParser();
		}
		return dataTypeQualifiedName_5037Parser;
	}

	/**
	 * @generated
	 */
	private IParser primitiveTypeName_5028Parser;

	/**
	 * @generated
	 */
	private IParser getPrimitiveTypeName_5028Parser() {
		if (primitiveTypeName_5028Parser == null) {
			primitiveTypeName_5028Parser = createPrimitiveTypeName_5028Parser();
		}
		return primitiveTypeName_5028Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createPrimitiveTypeName_5028Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private ClassifierAppliedStereotypeParser primitiveTypeQualifiedName_5038Parser;

	/**
	 * @generated
	 */
	private IParser getPrimitiveTypeQualifiedName_5038Parser() {
		if (primitiveTypeQualifiedName_5038Parser == null) {
			primitiveTypeQualifiedName_5038Parser = new ClassifierAppliedStereotypeParser();
		}
		return primitiveTypeQualifiedName_5038Parser;
	}

	/**
	 * @generated
	 */
	private IParser literalString_3038Parser;

	/**
	 * @generated
	 */
	private IParser getLiteralString_3038Parser() {
		if (literalString_3038Parser == null) {
			literalString_3038Parser = createLiteralString_3038Parser();
		}
		return literalString_3038Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createLiteralString_3038Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getLiteralInteger_Value() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser literalInteger_3039Parser;

	/**
	 * @generated
	 */
	private IParser getLiteralInteger_3039Parser() {
		if (literalInteger_3039Parser == null) {
			literalInteger_3039Parser = createLiteralInteger_3039Parser();
		}
		return literalInteger_3039Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createLiteralInteger_3039Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getLiteralInteger_Value() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser expression_3040Parser;

	/**
	 * @generated
	 */
	private IParser getExpression_3040Parser() {
		if (expression_3040Parser == null) {
			expression_3040Parser = createExpression_3040Parser();
		}
		return expression_3040Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createExpression_3040Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getExpression_Symbol() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser generalizationQualifiedName_6018Parser;

	/**
	 * @generated
	 */
	private IParser getGeneralizationQualifiedName_6018Parser() {
		if (generalizationQualifiedName_6018Parser == null) {
			generalizationQualifiedName_6018Parser = new AppliedStereotypeParser();
		}
		return generalizationQualifiedName_6018Parser;
	}

	/**
	 * @generated
	 */
	private IParser dependencyName_6001Parser;

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
	private DependencyAppliedStereotypeParser dependencyName_6010Parser;

	/**
	 * @generated
	 */
	private IParser getDependencyName_6010Parser() {
		if (dependencyName_6010Parser == null) {
			dependencyName_6010Parser = new DependencyAppliedStereotypeParser();
		}
		return dependencyName_6010Parser;
	}

	/**
	 * @generated
	 */
	private IParser propertyName_6002Parser;

	/**
	 * @generated
	 */
	private IParser getPropertyName_6002Parser() {
		if (propertyName_6002Parser == null) {
			propertyName_6002Parser = createPropertyName_6002Parser();
		}
		return propertyName_6002Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createPropertyName_6002Parser() {
		LookupSuite lookupSuite = getAssociationLookupSuite();
		return new SemanticParserAdapter(//
				new AssociationEndParser(lookupSuite, UMLPackage.eINSTANCE.getProperty()), //
				new BasicApplyStrategy(), //
				new AssociationEndToString.ROLE_VIEW(false), //
				new AssociationEndToString.EDIT(false));
	}

	/**
	 * @generated
	 */
	private IParser propertyName_6012Parser;

	/**
	 * @generated
	 */
	private IParser getPropertyName_6012Parser() {
		if (propertyName_6012Parser == null) {
			propertyName_6012Parser = createPropertyName_6012Parser();
		}
		return propertyName_6012Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createPropertyName_6012Parser() {
		LookupSuite lookupSuite = getAssociationLookupSuite();
		return new SemanticParserAdapter(//
				new AssociationEndParser(lookupSuite, UMLPackage.eINSTANCE.getProperty()), //
				new BasicApplyStrategy(), //
				new AssociationEndToString.MULTIPLICITY_VIEW(false), //
				new AssociationEndToString.EDIT(false));
	}

	/**
	 * @generated
	 */
	private IParser propertyName_6017Parser;

	/**
	 * @generated
	 */
	private IParser getPropertyName_6017Parser() {
		if (propertyName_6017Parser == null) {
			propertyName_6017Parser = createPropertyName_6017Parser();
		}
		return propertyName_6017Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createPropertyName_6017Parser() {
		LookupSuite lookupSuite = getAssociationLookupSuite();
		return new SemanticParserAdapter(//
				new AssociationEndParser(lookupSuite, UMLPackage.eINSTANCE.getProperty()), //
				new BasicApplyStrategy(), //
				new AssociationEndToString.MODIFIERS_VIEW(false), //
				new AssociationEndToString.EDIT(false));
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
	 * @generated
	 */
	private IParser associationName_6009Parser;

	/**
	 * @generated
	 */
	private IParser getAssociationName_6009Parser() {
		if (associationName_6009Parser == null) {
			associationName_6009Parser = createAssociationName_6009Parser();
		}
		return associationName_6009Parser;
	}

	/**
	 * @generated
	 */
	private IParser realizationName_6011Parser;

	/**
	 * @generated
	 */
	private IParser getRealizationName_6011Parser() {
		if (realizationName_6011Parser == null) {
			realizationName_6011Parser = createRealizationName_6011Parser();
		}
		return realizationName_6011Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createRealizationName_6011Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser realizationQualifiedName_6021Parser;

	/**
	 * @generated
	 */
	private IParser getRealizationQualifiedName_6021Parser() {
		if (realizationQualifiedName_6021Parser == null) {
			realizationQualifiedName_6021Parser = new AppliedStereotypeParser();
		}
		return realizationQualifiedName_6021Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser generalizationQualifiedName_6022Parser;

	/**
	 * @generated
	 */
	private IParser getGeneralizationQualifiedName_6022Parser() {
		if (generalizationQualifiedName_6022Parser == null) {
			generalizationQualifiedName_6022Parser = new AppliedStereotypeParser();
		}
		return generalizationQualifiedName_6022Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser usageQualifiedName_6023Parser;

	/**
	 * @generated
	 */
	private IParser getUsageQualifiedName_6023Parser() {
		if (usageQualifiedName_6023Parser == null) {
			usageQualifiedName_6023Parser = new AppliedStereotypeParser();
		}
		return usageQualifiedName_6023Parser;
	}

	/**
	 * @generated
	 */
	private IParser slotLabel_6015Parser;

	/**
	 * @generated
	 */
	private IParser getSlotLabel_6015Parser() {
		if (slotLabel_6015Parser == null) {
			slotLabel_6015Parser = createSlotLabel_6015Parser();
		}
		return slotLabel_6015Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createSlotLabel_6015Parser() {
		return createAssocationInstanceRoleParser(true);
	}

	/**
	 * @generated
	 */
	private IParser slotLabel_6016Parser;

	/**
	 * @generated
	 */
	private IParser getSlotLabel_6016Parser() {
		if (slotLabel_6016Parser == null) {
			slotLabel_6016Parser = createSlotLabel_6016Parser();
		}
		return slotLabel_6016Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createSlotLabel_6016Parser() {
		return createAssocationInstanceRoleParser(false);
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser templateBindingQualifiedName_6024Parser;

	/**
	 * @generated
	 */
	private IParser getTemplateBindingQualifiedName_6024Parser() {
		if (templateBindingQualifiedName_6024Parser == null) {
			templateBindingQualifiedName_6024Parser = new AppliedStereotypeParser();
		}
		return templateBindingQualifiedName_6024Parser;
	}

	public static final OCLLookup<Type> TYPE_LOOKUP = new OCLLookup<Type>(//
			UMLOCLFactory.getOCLLookupExpression(DefaultOclLookups.DEFAULT_TYPE_LOOKUP, UMLPackage.eINSTANCE.getNamedElement()), // 
			new IElementType[] { //
			/*
			 UMLElementTypes.Class_2001, // 
			 UMLElementTypes.DataType_2004, // 
			 UMLElementTypes.Enumeration_2003, // 
			 UMLElementTypes.PrimitiveType_2005, //
			 */
			});

	/**
	 * @generated NOT
	 */
	protected IParser createProperty_3001Parser() {
		return createPropertyParser();
	}

	/**
	 * @generated NOT
	 */
	protected IParser createProperty_3019Parser() {
		return createPropertyParser();
	}

	/**
	 * @generated NOT
	 */
	protected IParser createProperty_3014Parser() {
		return createPropertyParser();
	}

	/**
	 * @generated NOT
	 */
	protected IParser createProperty_3021Parser() {
		return createPropertyParser();
	}

	/**
	 * @generated NOT
	 */
	protected IParser createProperty_3023Parser() {
		return createPropertyParser();
	}

	/**
	 * @generated NOT
	 */
	protected IParser createProperty_3028Parser() {
		return createPropertyParser();
	}

	/**
	 * @NOT-GENERATED
	 */
	protected IParser createPropertyParser() {
		LookupSuiteImpl lookupSuite = new LookupSuiteImpl();
		lookupSuite.addLookup(Type.class, TYPE_LOOKUP);
		return new PropertySemanticParser(lookupSuite);
	}

	/**
	 * @generated NOT
	 */
	protected IParser createOperation_3002Parser() {
		return createOperationParser();
	}

	/**
	 * @generated NOT
	 */
	protected IParser createOperation_3020Parser() {
		return createOperationParser();
	}

	/**
	 * @generated NOT
	 */
	protected IParser createOperation_3015Parser() {
		return createOperationParser();
	}

	/**
	 * @generated NOT
	 */
	protected IParser createOperation_3029Parser() {
		return createOperationParser();
	}

	/**
	 * @generated NOT
	 */
	protected IParser createOperation_3022Parser() {
		return createOperationParser();
	}

	/**
	 * @generated NOT
	 */
	protected IParser createOperation_3024Parser() {
		return createOperationParser();
	}

	/**
	 * @NOT-GENERATED
	 */
	protected IParser createOperationParser() {
		LookupSuiteImpl lookupSuite = new LookupSuiteImpl();
		lookupSuite.addLookup(Type.class, TYPE_LOOKUP);

		return new OperationSemanticParser(lookupSuite);
	}

	/**
	 * @generated NOT
	 */
	protected IParser createPortName_5013Parser() {
		LookupSuiteImpl lookupSuite = new LookupSuiteImpl();
		lookupSuite.addLookup(Type.class, TYPE_LOOKUP);

		return new SemanticParserAdapter(new PortParser(lookupSuite), new BasicApplyStrategy(), new PortToString());
	}

	/**
	 * @generated NOT
	 */
	protected IParser createInstanceSpecification_3013Parser() {
		return createInstanceSpecificationParser();
	}

	/**
	 * @generated NOT
	 */
	protected IParser createInstanceSpecificationName_5010Parser() {
		return createInstanceSpecificationParser();
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser instanceSpecificationQualifiedName_5039Parser;

	/**
	 * @generated
	 */
	private IParser getInstanceSpecificationQualifiedName_5039Parser() {
		if (instanceSpecificationQualifiedName_5039Parser == null) {
			instanceSpecificationQualifiedName_5039Parser = new AppliedStereotypeParser();
		}
		return instanceSpecificationQualifiedName_5039Parser;
	}

	/**
	 * @NOT-GENERATED
	 */
	private IParser createInstanceSpecificationParser() {
		LookupSuiteImpl lookupSuite = new LookupSuiteImpl();
		lookupSuite.addLookup(Type.class, TYPE_LOOKUP);
		return new SemanticParserAdapter(new InstanceSpecificationParser(lookupSuite), new BasicApplyStrategy(), new InstanceSpecificationToString.VIEW(), new InstanceSpecificationToString.EDIT());
	}

	/**
	 * @generated NOT
	 */
	protected IParser createSlot_3017Parser() {
		return new SemanticParserAdapter(new SlotParser(new SlotLookupSuite()), new BasicApplyStrategy(), new SlotToString.VIEW(), new SlotToString.EDIT()) {

			@Override
			public String getPrintString(IAdaptable element, int flags) {
				String result = super.getPrintString(element, flags);
				if ("".equals(result)) {
					result = "<enter>";
				}
				return result;
			}
		};
	}

	/**
	 * @generated NOT
	 */
	protected IParser createGeneralizationSetIsCoveringIsDisjoint_5016Parser() {
		return new GeneralizationSetParser();
	}

	/**
	 * @generated NOT
	 */
	protected IParser createDependencyName_6010Parser() {
		return new DependencyTypeParser();
	}

	/**
	 * @NOT-GENERATED
	 */
	private IParser createAssocationInstanceRoleParser(boolean sourceNotTarget) {
		return new AssociationInstanceParser.ROLE_PARSER(sourceNotTarget);
	}

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
	 * @generated NOT
	 */
	protected IParser createAssociationName_6003Parser() {
		LookupSuite lookupSuite = LookupSuite.NULL_SUITE;
		return new ParserAdapter(new AssociationNameParser(lookupSuite), new BasicApplyStrategy(), new AssociationNameToString.VIEW(), new AssociationNameToString.EDIT());
	}

	/**
	 * @generated NOT
	 */
	protected IParser createAssociationName_6004Parser() {
		return createAssocationRoleParser(true);
	}

	/**
	 * @generated NOT
	 */
	protected IParser createAssociationName_6005Parser() {
		return createAssocationRoleParser(false);
	}

	/**
	 * @generated NOT
	 */
	protected IParser createAssociationName_6006Parser() {
		return createAssocationModifiersParser(true);
	}

	/**
	 * @generated NOT
	 */
	protected IParser createAssociationName_6007Parser() {
		return createAssocationModifiersParser(false);
	}

	/**
	 * @generated NOT
	 */
	protected IParser createAssociationName_6008Parser() {
		return createAssocationMultiplicityParser(true);
	}

	/**
	 * @generated NOT
	 */
	protected IParser createAssociationName_6009Parser() {
		return createAssocationMultiplicityParser(false);
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser associationQualifiedName_6019Parser;

	/**
	 * @generated
	 */
	private IParser getAssociationQualifiedName_6019Parser() {
		if (associationQualifiedName_6019Parser == null) {
			associationQualifiedName_6019Parser = new AppliedStereotypeParser();
		}
		return associationQualifiedName_6019Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser interfaceRealizationQualifiedName_6020Parser;

	/**
	 * @generated
	 */
	private IParser getInterfaceRealizationQualifiedName_6020Parser() {
		if (interfaceRealizationQualifiedName_6020Parser == null) {
			interfaceRealizationQualifiedName_6020Parser = new AppliedStereotypeParser();
		}
		return interfaceRealizationQualifiedName_6020Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case PackageNameEditPart.VISUAL_ID:
			return getPackageName_5004Parser();
		case ClassNameEditPart.VISUAL_ID:
			return getClassName_5003Parser();
		case ClassStereotypeEditPart.VISUAL_ID:
			return getClassQualifiedName_5019Parser();
		case AssociationClassNameEditPart.VISUAL_ID:
			return getAssociationClassName_5009Parser();
		case AssociationClassStereotypeEditPart.VISUAL_ID:
			return getAssociationClassQualifiedName_5031Parser();
		case DataTypeNameEditPart.VISUAL_ID:
			return getDataTypeName_5006Parser();
		case DataTypeStereotypeEditPart.VISUAL_ID:
			return getDataTypeQualifiedName_5032Parser();
		case PrimitiveTypeNameEditPart.VISUAL_ID:
			return getPrimitiveTypeName_5007Parser();
		case PrimitiveTypeStereotypeEditPart.VISUAL_ID:
			return getPrimitiveTypeQualifiedName_5033Parser();
		case EnumerationNameEditPart.VISUAL_ID:
			return getEnumerationName_5005Parser();
		case EnumerationStereotypeEditPart.VISUAL_ID:
			return getEnumerationQualifiedName_5034Parser();
		case InterfaceNameEditPart.VISUAL_ID:
			return getInterfaceName_5012Parser();
		case ConstraintNameEditPart.VISUAL_ID:
			return getConstraintName_5008Parser();
		case ConstraintLanguageEditPart.VISUAL_ID:
			return getConstraintLanguage_5042Parser();
		case InstanceSpecificationNameEditPart.VISUAL_ID:
			return getInstanceSpecificationName_5010Parser();
		case InstanceSpecificationStereoEditPart.VISUAL_ID:
			return getInstanceSpecificationQualifiedName_5039Parser();
		case DependencyNameEditPart.VISUAL_ID:
			return getDependencyName_5011Parser();
		case GeneralizationSetIsCoveringIsDisjointEditPart.VISUAL_ID:
			return getGeneralizationSetIsCoveringIsDisjoint_5016Parser();
		case GeneralizationSetNameEditPart.VISUAL_ID:
			return getGeneralizationSetName_5017Parser();
		case InterfaceName2EditPart.VISUAL_ID:
			return getInterfaceName_5018Parser();
		case InterfaceStereotypeEditPart.VISUAL_ID:
			return getInterfaceQualifiedName_5035Parser();
		case PackageName2EditPart.VISUAL_ID:
			return getPackageName_5020Parser();
		case PackageStereo2EditPart.VISUAL_ID:
			return getPackageQualifiedName_5041Parser();
		case PackageName3EditPart.VISUAL_ID:
			return getPackageName_5026Parser();
		case InstanceSpecificationName3EditPart.VISUAL_ID:
			return getInstanceSpecificationName_5029Parser();
		case CommentBodyEditPart.VISUAL_ID:
			return getCommentBody_5030Parser();
		case Package3EditPart.VISUAL_ID:
			return getPackage_3006Parser();
		case ClassEditPart.VISUAL_ID:
			return getClass_3007Parser();
		case DataTypeEditPart.VISUAL_ID:
			return getDataType_3008Parser();
		case PrimitiveTypeEditPart.VISUAL_ID:
			return getPrimitiveType_3009Parser();
		case EnumerationEditPart.VISUAL_ID:
			return getEnumeration_3011Parser();
		case AssociationClassEditPart.VISUAL_ID:
			return getAssociationClass_3012Parser();
		case Interface3EditPart.VISUAL_ID:
			return getInterface_3041Parser();
		case InstanceSpecificationEditPart.VISUAL_ID:
			return getInstanceSpecification_3013Parser();
		case PropertyEditPart.VISUAL_ID:
			return getProperty_3001Parser();
		case OperationEditPart.VISUAL_ID:
			return getOperation_3002Parser();
		case Class3EditPart.VISUAL_ID:
			return getClass_3003Parser();
		case PortNameEditPart.VISUAL_ID:
			return getPortName_5013Parser();
		case Property2EditPart.VISUAL_ID:
			return getProperty_3019Parser();
		case Operation2EditPart.VISUAL_ID:
			return getOperation_3020Parser();
		case Property3EditPart.VISUAL_ID:
			return getProperty_3014Parser();
		case Operation3EditPart.VISUAL_ID:
			return getOperation_3015Parser();
		case Property4EditPart.VISUAL_ID:
			return getProperty_3021Parser();
		case Operation4EditPart.VISUAL_ID:
			return getOperation_3022Parser();
		case EnumerationLiteralEditPart.VISUAL_ID:
			return getEnumerationLiteral_3016Parser();
		case Property5EditPart.VISUAL_ID:
			return getProperty_3023Parser();
		case Operation5EditPart.VISUAL_ID:
			return getOperation_3024Parser();
		case SlotEditPart.VISUAL_ID:
			return getSlot_3017Parser();
		case Property6EditPart.VISUAL_ID:
			return getProperty_3028Parser();
		case Operation6EditPart.VISUAL_ID:
			return getOperation_3029Parser();
		case Class4EditPart.VISUAL_ID:
			return getClass_3030Parser();
		case ElementImportEditPart.VISUAL_ID:
			return getElementImport_3031Parser();
		case PackageName4EditPart.VISUAL_ID:
			return getPackageName_5025Parser();
		case ClassName2EditPart.VISUAL_ID:
			return getClassName_5021Parser();
		case ClassStereotype2EditPart.VISUAL_ID:
			return getClassQualifiedName_5022Parser();
		case EnumerationName2EditPart.VISUAL_ID:
			return getEnumerationName_5023Parser();
		case EnumerationStereotype2EditPart.VISUAL_ID:
			return getEnumerationQualifiedName_5036Parser();
		case InstanceSpecificationName2EditPart.VISUAL_ID:
			return getInstanceSpecificationName_5024Parser();
		case InstanceSpecificationStereo2EditPart.VISUAL_ID:
			return getInstanceSpecificationQualifiedName_5040Parser();
		case DataTypeName2EditPart.VISUAL_ID:
			return getDataTypeName_5027Parser();
		case DataTypeStereotype2EditPart.VISUAL_ID:
			return getDataTypeQualifiedName_5037Parser();
		case PrimitiveTypeName2EditPart.VISUAL_ID:
			return getPrimitiveTypeName_5028Parser();
		case PrimitiveTypeStereotype2EditPart.VISUAL_ID:
			return getPrimitiveTypeQualifiedName_5038Parser();
		case LiteralStringEditPart.VISUAL_ID:
			return getLiteralString_3038Parser();
		case LiteralIntegerEditPart.VISUAL_ID:
			return getLiteralInteger_3039Parser();
		case ExpressionEditPart.VISUAL_ID:
			return getExpression_3040Parser();
		case GeneralizationStereotypeEditPart.VISUAL_ID:
			return getGeneralizationQualifiedName_6018Parser();
		case DependencyName2EditPart.VISUAL_ID:
			return getDependencyName_6001Parser();
		case DependencyName3EditPart.VISUAL_ID:
			return getDependencyName_6010Parser();
		case PropertyNameEditPart.VISUAL_ID:
			return getPropertyName_6002Parser();
		case PropertyName2EditPart.VISUAL_ID:
			return getPropertyName_6012Parser();
		case PropertyName3EditPart.VISUAL_ID:
			return getPropertyName_6017Parser();
		case AssociationNameEditPart.VISUAL_ID:
			return getAssociationName_6003Parser();
		case AssociationName2EditPart.VISUAL_ID:
			return getAssociationName_6004Parser();
		case AssociationName3EditPart.VISUAL_ID:
			return getAssociationName_6005Parser();
		case AssociationName4EditPart.VISUAL_ID:
			return getAssociationName_6006Parser();
		case AssociationName5EditPart.VISUAL_ID:
			return getAssociationName_6007Parser();
		case AssociationName6EditPart.VISUAL_ID:
			return getAssociationName_6008Parser();
		case AssociationName7EditPart.VISUAL_ID:
			return getAssociationName_6009Parser();
		case AssociationStereotypeEditPart.VISUAL_ID:
			return getAssociationQualifiedName_6019Parser();
		case InterfaceRealizationStereotypeEditPart.VISUAL_ID:
			return getInterfaceRealizationQualifiedName_6020Parser();
		case RealizationNameEditPart.VISUAL_ID:
			return getRealizationName_6011Parser();
		case RealizationStereotypeEditPart.VISUAL_ID:
			return getRealizationQualifiedName_6021Parser();
		case GeneralizationStereotype2EditPart.VISUAL_ID:
			return getGeneralizationQualifiedName_6022Parser();
		case UsageStereotypeEditPart.VISUAL_ID:
			return getUsageQualifiedName_6023Parser();
		case AssociationInstanceSourceEditPart.VISUAL_ID:
			return getSlotLabel_6015Parser();
		case AssociationInstanceTargetEditPart.VISUAL_ID:
			return getSlotLabel_6016Parser();
		case TemplateBindingStereotypeEditPart.VISUAL_ID:
			return getTemplateBindingQualifiedName_6024Parser();
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
