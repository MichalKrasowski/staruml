package org.eclipse.uml2.diagram.csd.providers;

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
import org.eclipse.uml2.diagram.common.parser.association.AssociationInstanceParser;
import org.eclipse.uml2.diagram.common.parser.association.end.AssociationEndApplyStrategy;
import org.eclipse.uml2.diagram.common.parser.association.end.AssociationEndParser;
import org.eclipse.uml2.diagram.common.parser.association.end.AssociationEndToString;
import org.eclipse.uml2.diagram.common.parser.association.name.AssociationNameParser;
import org.eclipse.uml2.diagram.common.parser.association.name.AssociationNameToString;
import org.eclipse.uml2.diagram.common.parser.imports.ElementImportParser;
import org.eclipse.uml2.diagram.common.parser.instance.InstanceSpecificationParser;
import org.eclipse.uml2.diagram.common.parser.instance.InstanceSpecificationToString;
import org.eclipse.uml2.diagram.common.parser.port.PortParser;
import org.eclipse.uml2.diagram.common.parser.port.PortToString;
import org.eclipse.uml2.diagram.common.parser.property.PropertyParser;
import org.eclipse.uml2.diagram.common.parser.property.PropertyToString;
import org.eclipse.uml2.diagram.common.parser.slot.SlotLookupSuite;
import org.eclipse.uml2.diagram.common.parser.slot.SlotParser;
import org.eclipse.uml2.diagram.common.parser.slot.SlotToString;
import org.eclipse.uml2.diagram.common.parser.stereotype.ClassifierAppliedStereotypeParser;
import org.eclipse.uml2.diagram.common.parser.stereotype.PackageAppliedStereotypeParser;
import org.eclipse.uml2.diagram.common.parser.valuespec.ConstraintLanguageParser;
import org.eclipse.uml2.diagram.common.parser.valuespec.ValueSpecificationParser;
import org.eclipse.uml2.diagram.csd.edit.parts.AssociationInstanceSourceEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.AssociationInstanceTargetEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.AssociationName2EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.AssociationName3EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.AssociationName4EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.AssociationName5EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.AssociationName6EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.AssociationName7EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.AssociationNameEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.ClassName2EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.ClassNameEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.ClassStereoEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.CollaborationNameEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.CollaborationStereoEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.CollaborationUseName2EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.CollaborationUseStereoEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.CommentBodyEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.ConnectorName2EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.ConnectorName3EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.ConnectorName4EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.ConnectorName5EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.ConnectorName6EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.ConnectorName7EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.ConnectorNameEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.ConstraintLanguageEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.ConstraintNameEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.DependencyNameEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.ElementImportEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.InstanceSpecificationNameEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.InstanceSpecificationStereoEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.InterfaceNameEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.OperationEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.PackageNameEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.PackageStereo2EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.PortIsBehavior2EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.PortIsBehaviorEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.PortName2EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.PortName3EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.PortNameEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.Property2EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.PropertyName2EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.PropertyNameEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.SlotEditPart;
import org.eclipse.uml2.diagram.csd.expressions.UMLOCLFactory;
import org.eclipse.uml2.diagram.csd.parser.collaborationuse.CollaborationUseParser;
import org.eclipse.uml2.diagram.csd.parser.connector.ConnectorNameParser;
import org.eclipse.uml2.diagram.csd.parser.connector.ConnectorParser;
import org.eclipse.uml2.diagram.csd.parsers.MessageFormatParser;
import org.eclipse.uml2.diagram.csd.part.UMLVisualIDRegistry;
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
	 * @NOT-generated
	 */
	public static final OCLLookup<Type> TYPE_LOOKUP = new OCLLookup<Type>(//
			UMLOCLFactory.getOCLLookupExpression(DefaultOclLookups.DEFAULT_TYPE_LOOKUP, UMLPackage.eINSTANCE.getNamedElement()), // 
			new IElementType[] { //
			});

	/**
	 * @generated
	 */
	private IParser collaborationName_5009Parser;

	/**
	 * @generated
	 */
	private IParser getCollaborationName_5009Parser() {
		if (collaborationName_5009Parser == null) {
			collaborationName_5009Parser = createCollaborationName_5009Parser();
		}
		return collaborationName_5009Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createCollaborationName_5009Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private ClassifierAppliedStereotypeParser collaborationQualifiedName_5030Parser;

	/**
	 * @generated
	 */
	private IParser getCollaborationQualifiedName_5030Parser() {
		if (collaborationQualifiedName_5030Parser == null) {
			collaborationQualifiedName_5030Parser = new ClassifierAppliedStereotypeParser();
		}
		return collaborationQualifiedName_5030Parser;
	}

	/**
	 * @generated
	 */
	private IParser className_5013Parser;

	/**
	 * @generated
	 */
	private IParser getClassName_5013Parser() {
		if (className_5013Parser == null) {
			className_5013Parser = createClassName_5013Parser();
		}
		return className_5013Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createClassName_5013Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private ClassifierAppliedStereotypeParser classQualifiedName_5014Parser;

	/**
	 * @generated
	 */
	private IParser getClassQualifiedName_5014Parser() {
		if (classQualifiedName_5014Parser == null) {
			classQualifiedName_5014Parser = new ClassifierAppliedStereotypeParser();
		}
		return classQualifiedName_5014Parser;
	}

	/**
	 * @generated
	 */
	private IParser packageName_5006Parser;

	/**
	 * @generated
	 */
	private IParser getPackageName_5006Parser() {
		if (packageName_5006Parser == null) {
			packageName_5006Parser = createPackageName_5006Parser();
		}
		return packageName_5006Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createPackageName_5006Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private PackageAppliedStereotypeParser packageQualifiedName_5033Parser;

	/**
	 * @generated
	 */
	private IParser getPackageQualifiedName_5033Parser() {
		if (packageQualifiedName_5033Parser == null) {
			packageQualifiedName_5033Parser = new PackageAppliedStereotypeParser();
		}
		return packageQualifiedName_5033Parser;
	}

	/**
	 * @generated
	 */
	private IParser className_5018Parser;

	/**
	 * @generated
	 */
	private IParser getClassName_5018Parser() {
		if (className_5018Parser == null) {
			className_5018Parser = createClassName_5018Parser();
		}
		return className_5018Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createClassName_5018Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser interfaceName_5020Parser;

	/**
	 * @generated
	 */
	private IParser getInterfaceName_5020Parser() {
		if (interfaceName_5020Parser == null) {
			interfaceName_5020Parser = createInterfaceName_5020Parser();
		}
		return interfaceName_5020Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createInterfaceName_5020Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser instanceSpecificationName_5022Parser;

	/**
	 * @generated
	 */
	private IParser getInstanceSpecificationName_5022Parser() {
		if (instanceSpecificationName_5022Parser == null) {
			instanceSpecificationName_5022Parser = createInstanceSpecificationName_5022Parser();
		}
		return instanceSpecificationName_5022Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createInstanceSpecificationName_5022Parser() {
		LookupSuiteImpl lookupSuite = new LookupSuiteImpl();
		lookupSuite.addLookup(Type.class, TYPE_LOOKUP);
		return new SemanticParserAdapter(new InstanceSpecificationParser(lookupSuite), new BasicApplyStrategy(), new InstanceSpecificationToString.VIEW(), new InstanceSpecificationToString.EDIT());
	}

	/**
	 * @generated
	 */
	private ClassifierAppliedStereotypeParser instanceSpecificationQualifiedName_5031Parser;

	/**
	 * @generated
	 */
	private IParser getInstanceSpecificationQualifiedName_5031Parser() {
		if (instanceSpecificationQualifiedName_5031Parser == null) {
			instanceSpecificationQualifiedName_5031Parser = new ClassifierAppliedStereotypeParser();
		}
		return instanceSpecificationQualifiedName_5031Parser;
	}

	/**
	 * @generated
	 */
	private IParser constraintName_5024Parser;

	/**
	 * @generated
	 */
	private IParser getConstraintName_5024Parser() {
		if (constraintName_5024Parser == null) {
			constraintName_5024Parser = createConstraintName_5024Parser();
		}
		return constraintName_5024Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createConstraintName_5024Parser() {
		return new ValueSpecificationParser.ConstraintParser();
	}

	/**
	 * @generated
	 */
	private ConstraintLanguageParser constraintLanguage_5034Parser;

	/**
	 * @generated
	 */
	private IParser getConstraintLanguage_5034Parser() {
		if (constraintLanguage_5034Parser == null) {
			constraintLanguage_5034Parser = new ConstraintLanguageParser();
		}
		return constraintLanguage_5034Parser;
	}

	/**
	 * @generated
	 */
	private IParser commentBody_5032Parser;

	/**
	 * @generated
	 */
	private IParser getCommentBody_5032Parser() {
		if (commentBody_5032Parser == null) {
			commentBody_5032Parser = createCommentBody_5032Parser();
		}
		return commentBody_5032Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createCommentBody_5032Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getComment_Body() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser collaborationUseName_5002Parser;

	/**
	 * @generated
	 */
	private IParser getCollaborationUseName_5002Parser() {
		if (collaborationUseName_5002Parser == null) {
			collaborationUseName_5002Parser = createCollaborationUseName_5002Parser();
		}
		return collaborationUseName_5002Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createCollaborationUseName_5002Parser() {
		return new CollaborationUseParser();
	}

	/**
	 * @generated
	 */
	private ClassifierAppliedStereotypeParser collaborationUseQualifiedName_5029Parser;

	/**
	 * @generated
	 */
	private IParser getCollaborationUseQualifiedName_5029Parser() {
		if (collaborationUseQualifiedName_5029Parser == null) {
			collaborationUseQualifiedName_5029Parser = new ClassifierAppliedStereotypeParser();
		}
		return collaborationUseQualifiedName_5029Parser;
	}

	/**
	 * @generated
	 */
	private IParser propertyName_5011Parser;

	/**
	 * @generated
	 */
	private IParser getPropertyName_5011Parser() {
		if (propertyName_5011Parser == null) {
			propertyName_5011Parser = createPropertyName_5011Parser();
		}
		return propertyName_5011Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createPropertyName_5011Parser() {
		return createPropertyParser();
	}

	/**
	 * @NOT-generated
	 */
	private IParser createPropertyParser() {
		LookupSuiteImpl lookupSuite = new LookupSuiteImpl();
		lookupSuite.addLookup(Type.class, TYPE_LOOKUP);
		return new SemanticParserAdapter(new PropertyParser(lookupSuite), new BasicApplyStrategy(), new PropertyToString.VIEW(), new PropertyToString.EDIT());
	}

	/**
	 * @generated
	 */
	private IParser property_3008Parser;

	/**
	 * @generated
	 */
	private IParser getProperty_3008Parser() {
		if (property_3008Parser == null) {
			property_3008Parser = createProperty_3008Parser();
		}
		return property_3008Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createProperty_3008Parser() {
		return createPropertyParser();
	}

	/**
	 * @generated
	 */
	private IParser operation_3009Parser;

	/**
	 * @generated
	 */
	private IParser getOperation_3009Parser() {
		if (operation_3009Parser == null) {
			operation_3009Parser = createOperation_3009Parser();
		}
		return operation_3009Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createOperation_3009Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser portName_5012Parser;

	/**
	 * @generated
	 */
	private IParser getPortName_5012Parser() {
		if (portName_5012Parser == null) {
			portName_5012Parser = createPortName_5012Parser();
		}
		return portName_5012Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createPortName_5012Parser() {
		return createPortNameParser();
	}

	/**
	 * @generated
	 */
	private IParser portIsBehavior_5026Parser;

	/**
	 * @generated
	 */
	private IParser getPortIsBehavior_5026Parser() {
		if (portIsBehavior_5026Parser == null) {
			portIsBehavior_5026Parser = createPortIsBehavior_5026Parser();
		}
		return portIsBehavior_5026Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createPortIsBehavior_5026Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getPort_IsBehavior() };
		MessageFormatParser parser = new MessageFormatParser(features);
		parser.setViewPattern(" "); //$NON-NLS-1$
		parser.setEditorPattern(" "); //$NON-NLS-1$
		parser.setEditPattern(" "); //$NON-NLS-1$
		return parser;
	}

	/**
	 * @NOT-generated
	 */
	private IParser createPortNameParser() {
		LookupSuiteImpl lookupSuite = new LookupSuiteImpl();
		lookupSuite.addLookup(Type.class, TYPE_LOOKUP);
		return new SemanticParserAdapter(new PortParser(lookupSuite), new BasicApplyStrategy(), new PortToString());
	}

	/**
	 * @generated
	 */

	private IParser elementImport_3004Parser;

	/**
	 * @generated
	 */
	private IParser getElementImport_3004Parser() {
		if (elementImport_3004Parser == null) {
			elementImport_3004Parser = createElementImport_3004Parser();
		}
		return elementImport_3004Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createElementImport_3004Parser() {
		return new ElementImportParser();
	}

	/**
	 * @generated
	 */
	private IParser propertyName_5017Parser;

	/**
	 * @generated
	 */
	private IParser getPropertyName_5017Parser() {
		if (propertyName_5017Parser == null) {
			propertyName_5017Parser = createPropertyName_5017Parser();
		}
		return propertyName_5017Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createPropertyName_5017Parser() {
		return createPropertyParser();
	}

	/**
	 * @generated
	 */
	private IParser portName_5025Parser;

	/**
	 * @generated
	 */
	private IParser getPortName_5025Parser() {
		if (portName_5025Parser == null) {
			portName_5025Parser = createPortName_5025Parser();
		}
		return portName_5025Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createPortName_5025Parser() {
		return createPortNameParser();
	}

	/**
	 * @generated
	 */
	private IParser portName_5027Parser;

	/**
	 * @generated
	 */
	private IParser getPortName_5027Parser() {
		if (portName_5027Parser == null) {
			portName_5027Parser = createPortName_5027Parser();
		}
		return portName_5027Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createPortName_5027Parser() {
		return createPortNameParser();
	}

	/**
	 * @generated
	 */
	private IParser portIsBehavior_5028Parser;

	/**
	 * @generated
	 */
	private IParser getPortIsBehavior_5028Parser() {
		if (portIsBehavior_5028Parser == null) {
			portIsBehavior_5028Parser = createPortIsBehavior_5028Parser();
		}
		return portIsBehavior_5028Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createPortIsBehavior_5028Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getPort_IsBehavior() };
		MessageFormatParser parser = new MessageFormatParser(features);
		parser.setViewPattern(" "); //$NON-NLS-1$
		parser.setEditorPattern(" "); //$NON-NLS-1$
		parser.setEditPattern(" "); //$NON-NLS-1$
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser slot_3015Parser;

	/**
	 * @generated
	 */
	private IParser getSlot_3015Parser() {
		if (slot_3015Parser == null) {
			slot_3015Parser = createSlot_3015Parser();
		}
		return slot_3015Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createSlot_3015Parser() {
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
	 * @generated
	 */
	private IParser connectorName_6009Parser;

	/**
	 * @generated
	 */
	private IParser getConnectorName_6009Parser() {
		if (connectorName_6009Parser == null) {
			connectorName_6009Parser = createConnectorName_6009Parser();
		}
		return connectorName_6009Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createConnectorName_6009Parser() {
		return new ConnectorNameParser();
	}

	/**
	 * @generated
	 */
	private IParser connectorName_6010Parser;

	/**
	 * @generated
	 */
	private IParser getConnectorName_6010Parser() {
		if (connectorName_6010Parser == null) {
			connectorName_6010Parser = createConnectorName_6010Parser();
		}
		return connectorName_6010Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createConnectorName_6010Parser() {
		return createConnectorRoleParser(true);
	}

	/**
	 * @generated
	 */
	private IParser connectorName_6011Parser;

	/**
	 * @generated
	 */
	private IParser getConnectorName_6011Parser() {
		if (connectorName_6011Parser == null) {
			connectorName_6011Parser = createConnectorName_6011Parser();
		}
		return connectorName_6011Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createConnectorName_6011Parser() {
		return createConnectorRoleParser(false);
	}

	/**
	 * @generated
	 */
	private IParser connectorName_6012Parser;

	/**
	 * @generated
	 */
	private IParser getConnectorName_6012Parser() {
		if (connectorName_6012Parser == null) {
			connectorName_6012Parser = createConnectorName_6012Parser();
		}
		return connectorName_6012Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createConnectorName_6012Parser() {
		return createConnectorMultiplicityParser(true);
	}

	/**
	 * @generated
	 */
	private IParser connectorName_6013Parser;

	/**
	 * @generated
	 */
	private IParser getConnectorName_6013Parser() {
		if (connectorName_6013Parser == null) {
			connectorName_6013Parser = createConnectorName_6013Parser();
		}
		return connectorName_6013Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createConnectorName_6013Parser() {
		return createConnectorMultiplicityParser(false);
	}

	/**
	 * @generated
	 */
	private IParser connectorName_6014Parser;

	/**
	 * @generated
	 */
	private IParser getConnectorName_6014Parser() {
		if (connectorName_6014Parser == null) {
			connectorName_6014Parser = createConnectorName_6014Parser();
		}
		return connectorName_6014Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createConnectorName_6014Parser() {
		return createConnectorModifiersParser(true);
	}

	/**
	 * @generated
	 */
	private IParser connectorName_6015Parser;

	/**
	 * @generated
	 */
	private IParser getConnectorName_6015Parser() {
		if (connectorName_6015Parser == null) {
			connectorName_6015Parser = createConnectorName_6015Parser();
		}
		return connectorName_6015Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createConnectorName_6015Parser() {
		return createConnectorModifiersParser(false);
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
	 * @NOT-GENERATED
	 */
	private IParser createAssocationInstanceRoleParser(boolean sourceNotTarget) {
		return new AssociationInstanceParser.ROLE_PARSER(sourceNotTarget);
	}

	/**
	 * @generated
	 */
	private IParser associationName_6002Parser;

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
	 * @NOT-GENERATED
	 */
	private IParser createConnectorRoleParser(boolean sourceNotTarget) {
		return new ConnectorParser.ROLE_PARSER(sourceNotTarget);
	}

	/**
	 * @NOT-GENERATED
	 */
	private IParser createConnectorModifiersParser(boolean sourceNotTarget) {
		return new ConnectorParser.MODIFIERS_PARSER(sourceNotTarget);
	}

	/**
	 * @NOT-GENERATED
	 */
	protected IParser createConnectorMultiplicityParser(boolean sourceNotTarget) {
		return new ConnectorParser.MULTIPLICITY_PARSER(sourceNotTarget);
	}

	/**
	 * @generated NOT
	 */
	protected IParser createAssociationName_6002Parser() {
		LookupSuite lookupSuite = LookupSuite.NULL_SUITE;
		return new ParserAdapter(new AssociationNameParser(lookupSuite), new BasicApplyStrategy(), new AssociationNameToString.VIEW(), new AssociationNameToString.EDIT());
	}

	/**
	 * @generated NOT
	 */
	protected IParser createAssociationName_6003Parser() {
		return createAssocationRoleParser(true);
	}

	/**
	 * @generated NOT
	 */
	protected IParser createAssociationName_6004Parser() {
		return createAssocationRoleParser(false);
	}

	/**
	 * @generated NOT
	 */
	protected IParser createAssociationName_6005Parser() {
		return createAssocationModifiersParser(true);
	}

	/**
	 * @generated NOT
	 */
	protected IParser createAssociationName_6006Parser() {
		return createAssocationModifiersParser(false);
	}

	/**
	 * @generated NOT
	 */
	protected IParser createAssociationName_6007Parser() {
		return createAssocationMultiplicityParser(true);
	}

	/**
	 * @generated NOT
	 */
	protected IParser createAssociationName_6008Parser() {
		return createAssocationMultiplicityParser(false);
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
		return createAssocationInstanceRoleParser(true);
	}

	/**
	 * @generated
	 */
	private IParser slotLabel_6017Parser;

	/**
	 * @generated
	 */
	private IParser getSlotLabel_6017Parser() {
		if (slotLabel_6017Parser == null) {
			slotLabel_6017Parser = createSlotLabel_6017Parser();
		}
		return slotLabel_6017Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createSlotLabel_6017Parser() {
		return createAssocationInstanceRoleParser(false);
	}

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
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case CollaborationNameEditPart.VISUAL_ID:
			return getCollaborationName_5009Parser();
		case CollaborationStereoEditPart.VISUAL_ID:
			return getCollaborationQualifiedName_5030Parser();
		case ClassNameEditPart.VISUAL_ID:
			return getClassName_5013Parser();
		case ClassStereoEditPart.VISUAL_ID:
			return getClassQualifiedName_5014Parser();
		case PackageNameEditPart.VISUAL_ID:
			return getPackageName_5006Parser();
		case PackageStereo2EditPart.VISUAL_ID:
			return getPackageQualifiedName_5033Parser();
		case ClassName2EditPart.VISUAL_ID:
			return getClassName_5018Parser();
		case InterfaceNameEditPart.VISUAL_ID:
			return getInterfaceName_5020Parser();
		case InstanceSpecificationNameEditPart.VISUAL_ID:
			return getInstanceSpecificationName_5022Parser();
		case InstanceSpecificationStereoEditPart.VISUAL_ID:
			return getInstanceSpecificationQualifiedName_5031Parser();
		case ConstraintNameEditPart.VISUAL_ID:
			return getConstraintName_5024Parser();
		case ConstraintLanguageEditPart.VISUAL_ID:
			return getConstraintLanguage_5034Parser();
		case CommentBodyEditPart.VISUAL_ID:
			return getCommentBody_5032Parser();
		case CollaborationUseName2EditPart.VISUAL_ID:
			return getCollaborationUseName_5002Parser();
		case CollaborationUseStereoEditPart.VISUAL_ID:
			return getCollaborationUseQualifiedName_5029Parser();
		case PropertyNameEditPart.VISUAL_ID:
			return getPropertyName_5011Parser();
		case Property2EditPart.VISUAL_ID:
			return getProperty_3008Parser();
		case OperationEditPart.VISUAL_ID:
			return getOperation_3009Parser();
		case PortNameEditPart.VISUAL_ID:
			return getPortName_5012Parser();
		case PortIsBehaviorEditPart.VISUAL_ID:
			return getPortIsBehavior_5026Parser();
		case ElementImportEditPart.VISUAL_ID:
			return getElementImport_3004Parser();
		case PropertyName2EditPart.VISUAL_ID:
			return getPropertyName_5017Parser();
		case PortName2EditPart.VISUAL_ID:
			return getPortName_5025Parser();
		case PortName3EditPart.VISUAL_ID:
			return getPortName_5027Parser();
		case PortIsBehavior2EditPart.VISUAL_ID:
			return getPortIsBehavior_5028Parser();
		case SlotEditPart.VISUAL_ID:
			return getSlot_3015Parser();
		case ConnectorNameEditPart.VISUAL_ID:
			return getConnectorName_6009Parser();
		case ConnectorName2EditPart.VISUAL_ID:
			return getConnectorName_6010Parser();
		case ConnectorName3EditPart.VISUAL_ID:
			return getConnectorName_6011Parser();
		case ConnectorName4EditPart.VISUAL_ID:
			return getConnectorName_6012Parser();
		case ConnectorName5EditPart.VISUAL_ID:
			return getConnectorName_6013Parser();
		case ConnectorName6EditPart.VISUAL_ID:
			return getConnectorName_6014Parser();
		case ConnectorName7EditPart.VISUAL_ID:
			return getConnectorName_6015Parser();
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
		case AssociationInstanceSourceEditPart.VISUAL_ID:
			return getSlotLabel_6016Parser();
		case AssociationInstanceTargetEditPart.VISUAL_ID:
			return getSlotLabel_6017Parser();
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

		/**
		 * @generated
		 */
		private final IElementType elementType;

		/**
		 * @generated
		 */
		public HintAdapter(IElementType type, EObject object, String parserHint) {
			super(object, parserHint);
			assert type != null;
			elementType = type;
		}

		/**
		 * @generated
		 */
		public Object getAdapter(Class adapter) {
			if (IElementType.class.equals(adapter)) {
				return elementType;
			}
			return super.getAdapter(adapter);
		}
	}

}
