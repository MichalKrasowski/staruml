package org.eclipse.uml2.diagram.activity.providers;

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
import org.eclipse.uml2.diagram.activity.edit.parts.*;
import org.eclipse.uml2.diagram.activity.parser.ActivityEdgeGuardParser;
import org.eclipse.uml2.diagram.activity.parser.ActivityEdgeWeightParser;
import org.eclipse.uml2.diagram.activity.parser.ExpansionRegionParser;
import org.eclipse.uml2.diagram.activity.parser.ObjectNodeAttributesParser;
import org.eclipse.uml2.diagram.activity.parser.ObjectNodeInStateParser;
import org.eclipse.uml2.diagram.activity.parser.ObjectNodeTypeAndInStateParser;
import org.eclipse.uml2.diagram.activity.parser.ObjectNodeTypeParser;
import org.eclipse.uml2.diagram.activity.parsers.MessageFormatParser;
import org.eclipse.uml2.diagram.activity.part.UMLVisualIDRegistry;
import org.eclipse.uml2.diagram.common.parser.stereotype.AppliedStereotypeParser;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class UMLParserProvider extends AbstractProvider implements IParserProvider {

	/**
	 * @generated
	 */
	private IParser activityName_5030Parser;

	/**
	 * @generated
	 */
	private IParser getActivityName_5030Parser() {
		if (activityName_5030Parser == null) {
			activityName_5030Parser = createActivityName_5030Parser();
		}
		return activityName_5030Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createActivityName_5030Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser activityQualifiedName_5093Parser;

	/**
	 * @generated
	 */
	private IParser getActivityQualifiedName_5093Parser() {
		if (activityQualifiedName_5093Parser == null) {
			activityQualifiedName_5093Parser = new AppliedStereotypeParser();
		}
		return activityQualifiedName_5093Parser;
	}

	/**
	 * @generated
	 */
	private IParser acceptEventActionName_5040Parser;

	/**
	 * @generated
	 */
	private IParser getAcceptEventActionName_5040Parser() {
		if (acceptEventActionName_5040Parser == null) {
			acceptEventActionName_5040Parser = createAcceptEventActionName_5040Parser();
		}
		return acceptEventActionName_5040Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createAcceptEventActionName_5040Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser acceptEventActionQualifiedName_5095Parser;

	/**
	 * @generated
	 */
	private IParser getAcceptEventActionQualifiedName_5095Parser() {
		if (acceptEventActionQualifiedName_5095Parser == null) {
			acceptEventActionQualifiedName_5095Parser = new AppliedStereotypeParser();
		}
		return acceptEventActionQualifiedName_5095Parser;
	}

	/**
	 * @generated
	 */
	private IParser acceptEventActionName_5042Parser;

	/**
	 * @generated
	 */
	private IParser getAcceptEventActionName_5042Parser() {
		if (acceptEventActionName_5042Parser == null) {
			acceptEventActionName_5042Parser = createAcceptEventActionName_5042Parser();
		}
		return acceptEventActionName_5042Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createAcceptEventActionName_5042Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private ObjectNodeTypeParser dataStoreNodeName_5034Parser;

	/**
	 * @generated
	 */
	private IParser getDataStoreNodeName_5034Parser() {
		if (dataStoreNodeName_5034Parser == null) {
			dataStoreNodeName_5034Parser = new ObjectNodeTypeParser();
		}
		return dataStoreNodeName_5034Parser;
	}

	/**
	 * @generated
	 */
	private ObjectNodeInStateParser dataStoreNodeQualifiedName_5036Parser;

	/**
	 * @generated
	 */
	private IParser getDataStoreNodeQualifiedName_5036Parser() {
		if (dataStoreNodeQualifiedName_5036Parser == null) {
			dataStoreNodeQualifiedName_5036Parser = new ObjectNodeInStateParser();
		}
		return dataStoreNodeQualifiedName_5036Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createDataStoreNodeName_5034Parser() {
		return new ObjectNodeTypeParser();
	}

	/**
	 * @generated NOT
	 */
	protected IParser createDataStoreNodeName_5036Parser() {
		return new ObjectNodeInStateParser();
	}

	/**
	 * @generated
	 */
	private ObjectNodeAttributesParser dataStoreNodeOrdering_5051Parser;

	/**
	 * @generated
	 */
	private IParser getDataStoreNodeOrdering_5051Parser() {
		if (dataStoreNodeOrdering_5051Parser == null) {
			dataStoreNodeOrdering_5051Parser = new ObjectNodeAttributesParser();
		}
		return dataStoreNodeOrdering_5051Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser dataStoreNodeQualifiedName_5127Parser;

	/**
	 * @generated
	 */
	private IParser getDataStoreNodeQualifiedName_5127Parser() {
		if (dataStoreNodeQualifiedName_5127Parser == null) {
			dataStoreNodeQualifiedName_5127Parser = new AppliedStereotypeParser();
		}
		return dataStoreNodeQualifiedName_5127Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createDataStoreNodeOrdering_5051Parser() {
		return new ObjectNodeAttributesParser();
	}

	/**
	 * @generated
	 */
	private ObjectNodeTypeParser centralBufferNodeName_5032Parser;

	/**
	 * @generated
	 */
	private IParser getCentralBufferNodeName_5032Parser() {
		if (centralBufferNodeName_5032Parser == null) {
			centralBufferNodeName_5032Parser = new ObjectNodeTypeParser();
		}
		return centralBufferNodeName_5032Parser;
	}

	/**
	 * @generated
	 */
	private ObjectNodeInStateParser centralBufferNodeQualifiedName_5038Parser;

	/**
	 * @generated
	 */
	private IParser getCentralBufferNodeQualifiedName_5038Parser() {
		if (centralBufferNodeQualifiedName_5038Parser == null) {
			centralBufferNodeQualifiedName_5038Parser = new ObjectNodeInStateParser();
		}
		return centralBufferNodeQualifiedName_5038Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createCentralBufferNodeName_5032Parser() {
		return new ObjectNodeTypeParser();
	}

	/**
	 * @generated NOT
	 */
	protected IParser createCentralBufferNodeName_5038Parser() {
		return new ObjectNodeInStateParser();
	}

	/**
	 * @generated
	 */
	private ObjectNodeAttributesParser centralBufferNodeOrdering_5049Parser;

	/**
	 * @generated
	 */
	private IParser getCentralBufferNodeOrdering_5049Parser() {
		if (centralBufferNodeOrdering_5049Parser == null) {
			centralBufferNodeOrdering_5049Parser = new ObjectNodeAttributesParser();
		}
		return centralBufferNodeOrdering_5049Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser centralBufferNodeQualifiedName_5124Parser;

	/**
	 * @generated
	 */
	private IParser getCentralBufferNodeQualifiedName_5124Parser() {
		if (centralBufferNodeQualifiedName_5124Parser == null) {
			centralBufferNodeQualifiedName_5124Parser = new AppliedStereotypeParser();
		}
		return centralBufferNodeQualifiedName_5124Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createCentralBufferNodeOrdering_5049Parser() {
		return new ObjectNodeAttributesParser();
	}

	/**
	 * @generated
	 */
	private IParser opaqueActionName_5023Parser;

	/**
	 * @generated
	 */
	private IParser getOpaqueActionName_5023Parser() {
		if (opaqueActionName_5023Parser == null) {
			opaqueActionName_5023Parser = createOpaqueActionName_5023Parser();
		}
		return opaqueActionName_5023Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createOpaqueActionName_5023Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser opaqueActionQualifiedName_5110Parser;

	/**
	 * @generated
	 */
	private IParser getOpaqueActionQualifiedName_5110Parser() {
		if (opaqueActionQualifiedName_5110Parser == null) {
			opaqueActionQualifiedName_5110Parser = new AppliedStereotypeParser();
		}
		return opaqueActionQualifiedName_5110Parser;
	}

	/**
	 * @generated
	 */
	private ObjectNodeTypeAndInStateParser outputPinName_5003Parser;

	/**
	 * @generated
	 */
	private IParser getOutputPinName_5003Parser() {
		if (outputPinName_5003Parser == null) {
			outputPinName_5003Parser = new ObjectNodeTypeAndInStateParser();
		}
		return outputPinName_5003Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createOutputPinName_5003Parser() {
		return new ObjectNodeTypeAndInStateParser();
	}

	/**
	 * @generated
	 */
	private ObjectNodeAttributesParser outputPinOrdering_5055Parser;

	/**
	 * @generated
	 */
	private IParser getOutputPinOrdering_5055Parser() {
		if (outputPinOrdering_5055Parser == null) {
			outputPinOrdering_5055Parser = new ObjectNodeAttributesParser();
		}
		return outputPinOrdering_5055Parser;
	}

	/**
	 * @generated
	 */
	private IParser inputPinName_5149Parser;

	/**
	 * @generated
	 */
	private IParser getInputPinName_5149Parser() {
		if (inputPinName_5149Parser == null) {
			inputPinName_5149Parser = createInputPinName_5149Parser();
		}
		return inputPinName_5149Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createInputPinName_5149Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private ObjectNodeAttributesParser inputPinOrdering_5150Parser;

	/**
	 * @generated
	 */
	private IParser getInputPinOrdering_5150Parser() {
		if (inputPinOrdering_5150Parser == null) {
			inputPinOrdering_5150Parser = new ObjectNodeAttributesParser();
		}
		return inputPinOrdering_5150Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createOutputPinOrdering_5055Parser() {
		return new ObjectNodeAttributesParser();
	}

	/**
	 * @generated
	 */
	private ObjectNodeTypeParser pinName_5024Parser;

	/**
	 * @generated
	 */
	private IParser getPinName_5024Parser() {
		if (pinName_5024Parser == null) {
			pinName_5024Parser = new ObjectNodeTypeParser();
		}
		return pinName_5024Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createPinName_5024Parser() {
		return new ObjectNodeTypeParser();
	}

	/**
	 * @generated
	 */
	private ObjectNodeInStateParser pinName_5052Parser;

	/**
	 * @generated
	 */
	private IParser getPinName_5052Parser() {
		if (pinName_5052Parser == null) {
			pinName_5052Parser = new ObjectNodeInStateParser();
		}
		return pinName_5052Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createPinName_5052Parser() {
		return new ObjectNodeInStateParser();
	}

	/**
	 * @generated
	 */
	private ObjectNodeAttributesParser pinOrdering_5085Parser;

	/**
	 * @generated
	 */
	private IParser getPinOrdering_5085Parser() {
		if (pinOrdering_5085Parser == null) {
			pinOrdering_5085Parser = new ObjectNodeAttributesParser();
		}
		return pinOrdering_5085Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser pinQualifiedName_5130Parser;

	/**
	 * @generated
	 */
	private IParser getPinQualifiedName_5130Parser() {
		if (pinQualifiedName_5130Parser == null) {
			pinQualifiedName_5130Parser = new AppliedStereotypeParser();
		}
		return pinQualifiedName_5130Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createPinOrdering_5085Parser() {
		return new ObjectNodeAttributesParser();
	}

	/**
	 * @generated
	 */
	private IParser createObjectActionName_5025Parser;

	/**
	 * @generated
	 */
	private IParser getCreateObjectActionName_5025Parser() {
		if (createObjectActionName_5025Parser == null) {
			createObjectActionName_5025Parser = createCreateObjectActionName_5025Parser();
		}
		return createObjectActionName_5025Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createCreateObjectActionName_5025Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser createObjectActionQualifiedName_5107Parser;

	/**
	 * @generated
	 */
	private IParser getCreateObjectActionQualifiedName_5107Parser() {
		if (createObjectActionQualifiedName_5107Parser == null) {
			createObjectActionQualifiedName_5107Parser = new AppliedStereotypeParser();
		}
		return createObjectActionQualifiedName_5107Parser;
	}

	/**
	 * @generated
	 */
	private ObjectNodeTypeAndInStateParser outputPinName_5004Parser;

	/**
	 * @generated
	 */
	private IParser getOutputPinName_5004Parser() {
		if (outputPinName_5004Parser == null) {
			outputPinName_5004Parser = new ObjectNodeTypeAndInStateParser();
		}
		return outputPinName_5004Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createOutputPinName_5004Parser() {
		return new ObjectNodeTypeAndInStateParser();
	}

	/**
	 * @generated
	 */
	private ObjectNodeAttributesParser outputPinOrdering_5056Parser;

	/**
	 * @generated
	 */
	private IParser getOutputPinOrdering_5056Parser() {
		if (outputPinOrdering_5056Parser == null) {
			outputPinOrdering_5056Parser = new ObjectNodeAttributesParser();
		}
		return outputPinOrdering_5056Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createOutputPinOrdering_5056Parser() {
		return new ObjectNodeAttributesParser();
	}

	/**
	 * @generated
	 */
	private IParser addStructuralFeatureValueActionName_5026Parser;

	/**
	 * @generated
	 */
	private IParser getAddStructuralFeatureValueActionName_5026Parser() {
		if (addStructuralFeatureValueActionName_5026Parser == null) {
			addStructuralFeatureValueActionName_5026Parser = createAddStructuralFeatureValueActionName_5026Parser();
		}
		return addStructuralFeatureValueActionName_5026Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createAddStructuralFeatureValueActionName_5026Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser addStructuralFeatureValueActionQualifiedName_5097Parser;

	/**
	 * @generated
	 */
	private IParser getAddStructuralFeatureValueActionQualifiedName_5097Parser() {
		if (addStructuralFeatureValueActionQualifiedName_5097Parser == null) {
			addStructuralFeatureValueActionQualifiedName_5097Parser = new AppliedStereotypeParser();
		}
		return addStructuralFeatureValueActionQualifiedName_5097Parser;
	}

	/**
	 * @generated
	 */
	private ObjectNodeTypeAndInStateParser inputPinName_5006Parser;

	/**
	 * @generated
	 */
	private IParser getInputPinName_5006Parser() {
		if (inputPinName_5006Parser == null) {
			inputPinName_5006Parser = new ObjectNodeTypeAndInStateParser();
		}
		return inputPinName_5006Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createInputPinName_5006Parser() {
		return new ObjectNodeTypeAndInStateParser();
	}

	/**
	 * @generated
	 */
	private ObjectNodeAttributesParser inputPinOrdering_5057Parser;

	/**
	 * @generated
	 */
	private IParser getInputPinOrdering_5057Parser() {
		if (inputPinOrdering_5057Parser == null) {
			inputPinOrdering_5057Parser = new ObjectNodeAttributesParser();
		}
		return inputPinOrdering_5057Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createInputPinOrdering_5057Parser() {
		return new ObjectNodeAttributesParser();
	}

	/**
	 * @generated
	 */
	private ObjectNodeTypeAndInStateParser inputPinName_5007Parser;

	/**
	 * @generated
	 */
	private IParser getInputPinName_5007Parser() {
		if (inputPinName_5007Parser == null) {
			inputPinName_5007Parser = new ObjectNodeTypeAndInStateParser();
		}
		return inputPinName_5007Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createInputPinName_5007Parser() {
		return new ObjectNodeTypeAndInStateParser();
	}

	/**
	 * @generated
	 */
	private ObjectNodeAttributesParser inputPinOrdering_5058Parser;

	/**
	 * @generated
	 */
	private IParser getInputPinOrdering_5058Parser() {
		if (inputPinOrdering_5058Parser == null) {
			inputPinOrdering_5058Parser = new ObjectNodeAttributesParser();
		}
		return inputPinOrdering_5058Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createInputPinOrdering_5058Parser() {
		return new ObjectNodeAttributesParser();
	}

	/**
	 * @generated
	 */
	private ObjectNodeTypeAndInStateParser inputPinName_5008Parser;

	/**
	 * @generated
	 */
	private IParser getInputPinName_5008Parser() {
		if (inputPinName_5008Parser == null) {
			inputPinName_5008Parser = new ObjectNodeTypeAndInStateParser();
		}
		return inputPinName_5008Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createInputPinName_5008Parser() {
		return new ObjectNodeTypeAndInStateParser();
	}

	/**
	 * @generated
	 */
	private ObjectNodeAttributesParser inputPinOrdering_5059Parser;

	/**
	 * @generated
	 */
	private IParser getInputPinOrdering_5059Parser() {
		if (inputPinOrdering_5059Parser == null) {
			inputPinOrdering_5059Parser = new ObjectNodeAttributesParser();
		}
		return inputPinOrdering_5059Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createInputPinOrdering_5059Parser() {
		return new ObjectNodeAttributesParser();
	}

	/**
	 * @generated
	 */
	private IParser callBehaviorActionName_5027Parser;

	/**
	 * @generated
	 */
	private IParser getCallBehaviorActionName_5027Parser() {
		if (callBehaviorActionName_5027Parser == null) {
			callBehaviorActionName_5027Parser = createCallBehaviorActionName_5027Parser();
		}
		return callBehaviorActionName_5027Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createCallBehaviorActionName_5027Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser callBehaviorActionQualifiedName_5099Parser;

	/**
	 * @generated
	 */
	private IParser getCallBehaviorActionQualifiedName_5099Parser() {
		if (callBehaviorActionQualifiedName_5099Parser == null) {
			callBehaviorActionQualifiedName_5099Parser = new AppliedStereotypeParser();
		}
		return callBehaviorActionQualifiedName_5099Parser;
	}

	/**
	 * @generated
	 */
	private ObjectNodeTypeAndInStateParser outputPinName_5010Parser;

	/**
	 * @generated
	 */
	private IParser getOutputPinName_5010Parser() {
		if (outputPinName_5010Parser == null) {
			outputPinName_5010Parser = new ObjectNodeTypeAndInStateParser();
		}
		return outputPinName_5010Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createOutputPinName_5010Parser() {
		return new ObjectNodeTypeAndInStateParser();
	}

	/**
	 * @generated
	 */
	private ObjectNodeAttributesParser outputPinOrdering_5060Parser;

	/**
	 * @generated
	 */
	private IParser getOutputPinOrdering_5060Parser() {
		if (outputPinOrdering_5060Parser == null) {
			outputPinOrdering_5060Parser = new ObjectNodeAttributesParser();
		}
		return outputPinOrdering_5060Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createOutputPinOrdering_5060Parser() {
		return new ObjectNodeAttributesParser();
	}

	/**
	 * @generated
	 */
	private ObjectNodeTypeAndInStateParser inputPinName_5011Parser;

	/**
	 * @generated
	 */
	private IParser getInputPinName_5011Parser() {
		if (inputPinName_5011Parser == null) {
			inputPinName_5011Parser = new ObjectNodeTypeAndInStateParser();
		}
		return inputPinName_5011Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createInputPinName_5011Parser() {
		return new ObjectNodeTypeAndInStateParser();
	}

	/**
	 * @generated
	 */
	private ObjectNodeAttributesParser inputPinOrdering_5061Parser;

	/**
	 * @generated
	 */
	private IParser getInputPinOrdering_5061Parser() {
		if (inputPinOrdering_5061Parser == null) {
			inputPinOrdering_5061Parser = new ObjectNodeAttributesParser();
		}
		return inputPinOrdering_5061Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createInputPinOrdering_5061Parser() {
		return new ObjectNodeAttributesParser();
	}

	/**
	 * @generated
	 */
	private IParser callOperationActionName_5028Parser;

	/**
	 * @generated
	 */
	private IParser getCallOperationActionName_5028Parser() {
		if (callOperationActionName_5028Parser == null) {
			callOperationActionName_5028Parser = createCallOperationActionName_5028Parser();
		}
		return callOperationActionName_5028Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createCallOperationActionName_5028Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser callOperationActionQualifiedName_5101Parser;

	/**
	 * @generated
	 */
	private IParser getCallOperationActionQualifiedName_5101Parser() {
		if (callOperationActionQualifiedName_5101Parser == null) {
			callOperationActionQualifiedName_5101Parser = new AppliedStereotypeParser();
		}
		return callOperationActionQualifiedName_5101Parser;
	}

	/**
	 * @generated
	 */
	private ObjectNodeTypeAndInStateParser inputPinName_5013Parser;

	/**
	 * @generated
	 */
	private IParser getInputPinName_5013Parser() {
		if (inputPinName_5013Parser == null) {
			inputPinName_5013Parser = new ObjectNodeTypeAndInStateParser();
		}
		return inputPinName_5013Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createInputPinName_5013Parser() {
		return new ObjectNodeTypeAndInStateParser();
	}

	/**
	 * @generated
	 */
	private ObjectNodeAttributesParser inputPinOrdering_5062Parser;

	/**
	 * @generated
	 */
	private IParser getInputPinOrdering_5062Parser() {
		if (inputPinOrdering_5062Parser == null) {
			inputPinOrdering_5062Parser = new ObjectNodeAttributesParser();
		}
		return inputPinOrdering_5062Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createInputPinOrdering_5062Parser() {
		return new ObjectNodeAttributesParser();
	}

	/**
	 * @generated
	 */
	private IParser structuredActivityNodeName_5090Parser;

	/**
	 * @generated
	 */
	private IParser getStructuredActivityNodeName_5090Parser() {
		if (structuredActivityNodeName_5090Parser == null) {
			structuredActivityNodeName_5090Parser = createStructuredActivityNodeName_5090Parser();
		}
		return structuredActivityNodeName_5090Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createStructuredActivityNodeName_5090Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser structuredActivityNodeQualifiedName_5120Parser;

	/**
	 * @generated
	 */
	private IParser getStructuredActivityNodeQualifiedName_5120Parser() {
		if (structuredActivityNodeQualifiedName_5120Parser == null) {
			structuredActivityNodeQualifiedName_5120Parser = new AppliedStereotypeParser();
		}
		return structuredActivityNodeQualifiedName_5120Parser;
	}

	/**
	 * @generated
	 */
	private IParser structuredActivityNodeName_5089Parser;

	/**
	 * @generated
	 */
	private IParser getStructuredActivityNodeName_5089Parser() {
		if (structuredActivityNodeName_5089Parser == null) {
			structuredActivityNodeName_5089Parser = createStructuredActivityNodeName_5089Parser();
		}
		return structuredActivityNodeName_5089Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createStructuredActivityNodeName_5089Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser structuredActivityNodeQualifiedName_5119Parser;

	/**
	 * @generated
	 */
	private IParser getStructuredActivityNodeQualifiedName_5119Parser() {
		if (structuredActivityNodeQualifiedName_5119Parser == null) {
			structuredActivityNodeQualifiedName_5119Parser = new AppliedStereotypeParser();
		}
		return structuredActivityNodeQualifiedName_5119Parser;
	}

	/**
	 * @generated
	 */
	private IParser opaqueActionName_5015Parser;

	/**
	 * @generated
	 */
	private IParser getOpaqueActionName_5015Parser() {
		if (opaqueActionName_5015Parser == null) {
			opaqueActionName_5015Parser = createOpaqueActionName_5015Parser();
		}
		return opaqueActionName_5015Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createOpaqueActionName_5015Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser opaqueActionQualifiedName_5111Parser;

	/**
	 * @generated
	 */
	private IParser getOpaqueActionQualifiedName_5111Parser() {
		if (opaqueActionQualifiedName_5111Parser == null) {
			opaqueActionQualifiedName_5111Parser = new AppliedStereotypeParser();
		}
		return opaqueActionQualifiedName_5111Parser;
	}

	/**
	 * @generated
	 */
	private IParser acceptEventActionName_5041Parser;

	/**
	 * @generated
	 */
	private IParser getAcceptEventActionName_5041Parser() {
		if (acceptEventActionName_5041Parser == null) {
			acceptEventActionName_5041Parser = createAcceptEventActionName_5041Parser();
		}
		return acceptEventActionName_5041Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createAcceptEventActionName_5041Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser acceptEventActionQualifiedName_5096Parser;

	/**
	 * @generated
	 */
	private IParser getAcceptEventActionQualifiedName_5096Parser() {
		if (acceptEventActionQualifiedName_5096Parser == null) {
			acceptEventActionQualifiedName_5096Parser = new AppliedStereotypeParser();
		}
		return acceptEventActionQualifiedName_5096Parser;
	}

	/**
	 * @generated
	 */
	private IParser acceptEventActionName_5043Parser;

	/**
	 * @generated
	 */
	private IParser getAcceptEventActionName_5043Parser() {
		if (acceptEventActionName_5043Parser == null) {
			acceptEventActionName_5043Parser = createAcceptEventActionName_5043Parser();
		}
		return acceptEventActionName_5043Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createAcceptEventActionName_5043Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private ObjectNodeTypeParser pinName_5016Parser;

	/**
	 * @generated
	 */
	private IParser getPinName_5016Parser() {
		if (pinName_5016Parser == null) {
			pinName_5016Parser = new ObjectNodeTypeParser();
		}
		return pinName_5016Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createPinName_5016Parser() {
		return new ObjectNodeTypeParser();
	}

	/**
	 * @generated
	 */
	private ObjectNodeInStateParser pinName_5053Parser;

	/**
	 * @generated
	 */
	private IParser getPinName_5053Parser() {
		if (pinName_5053Parser == null) {
			pinName_5053Parser = new ObjectNodeInStateParser();
		}
		return pinName_5053Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createPinName_5053Parser() {
		return new ObjectNodeInStateParser();
	}

	/**
	 * @generated
	 */
	private ObjectNodeAttributesParser pinOrdering_5086Parser;

	/**
	 * @generated
	 */
	private IParser getPinOrdering_5086Parser() {
		if (pinOrdering_5086Parser == null) {
			pinOrdering_5086Parser = new ObjectNodeAttributesParser();
		}
		return pinOrdering_5086Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser pinQualifiedName_5131Parser;

	/**
	 * @generated
	 */
	private IParser getPinQualifiedName_5131Parser() {
		if (pinQualifiedName_5131Parser == null) {
			pinQualifiedName_5131Parser = new AppliedStereotypeParser();
		}
		return pinQualifiedName_5131Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createPinOrdering_5086Parser() {
		return new ObjectNodeAttributesParser();
	}

	/**
	 * @generated
	 */
	private IParser createObjectActionName_5017Parser;

	/**
	 * @generated
	 */
	private IParser getCreateObjectActionName_5017Parser() {
		if (createObjectActionName_5017Parser == null) {
			createObjectActionName_5017Parser = createCreateObjectActionName_5017Parser();
		}
		return createObjectActionName_5017Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createCreateObjectActionName_5017Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser createObjectActionQualifiedName_5108Parser;

	/**
	 * @generated
	 */
	private IParser getCreateObjectActionQualifiedName_5108Parser() {
		if (createObjectActionQualifiedName_5108Parser == null) {
			createObjectActionQualifiedName_5108Parser = new AppliedStereotypeParser();
		}
		return createObjectActionQualifiedName_5108Parser;
	}

	/**
	 * @generated
	 */
	private IParser callBehaviorActionName_5018Parser;

	/**
	 * @generated
	 */
	private IParser getCallBehaviorActionName_5018Parser() {
		if (callBehaviorActionName_5018Parser == null) {
			callBehaviorActionName_5018Parser = createCallBehaviorActionName_5018Parser();
		}
		return callBehaviorActionName_5018Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createCallBehaviorActionName_5018Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser callBehaviorActionQualifiedName_5100Parser;

	/**
	 * @generated
	 */
	private IParser getCallBehaviorActionQualifiedName_5100Parser() {
		if (callBehaviorActionQualifiedName_5100Parser == null) {
			callBehaviorActionQualifiedName_5100Parser = new AppliedStereotypeParser();
		}
		return callBehaviorActionQualifiedName_5100Parser;
	}

	/**
	 * @generated
	 */
	private IParser callOperationActionName_5019Parser;

	/**
	 * @generated
	 */
	private IParser getCallOperationActionName_5019Parser() {
		if (callOperationActionName_5019Parser == null) {
			callOperationActionName_5019Parser = createCallOperationActionName_5019Parser();
		}
		return callOperationActionName_5019Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createCallOperationActionName_5019Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser callOperationActionQualifiedName_5102Parser;

	/**
	 * @generated
	 */
	private IParser getCallOperationActionQualifiedName_5102Parser() {
		if (callOperationActionQualifiedName_5102Parser == null) {
			callOperationActionQualifiedName_5102Parser = new AppliedStereotypeParser();
		}
		return callOperationActionQualifiedName_5102Parser;
	}

	/**
	 * @generated
	 */
	private IParser addStructuralFeatureValueActionName_5020Parser;

	/**
	 * @generated
	 */
	private IParser getAddStructuralFeatureValueActionName_5020Parser() {
		if (addStructuralFeatureValueActionName_5020Parser == null) {
			addStructuralFeatureValueActionName_5020Parser = createAddStructuralFeatureValueActionName_5020Parser();
		}
		return addStructuralFeatureValueActionName_5020Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createAddStructuralFeatureValueActionName_5020Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser addStructuralFeatureValueActionQualifiedName_5098Parser;

	/**
	 * @generated
	 */
	private IParser getAddStructuralFeatureValueActionQualifiedName_5098Parser() {
		if (addStructuralFeatureValueActionQualifiedName_5098Parser == null) {
			addStructuralFeatureValueActionQualifiedName_5098Parser = new AppliedStereotypeParser();
		}
		return addStructuralFeatureValueActionQualifiedName_5098Parser;
	}

	/**
	 * @generated
	 */
	private ObjectNodeTypeParser dataStoreNodeName_5035Parser;

	/**
	 * @generated
	 */
	private IParser getDataStoreNodeName_5035Parser() {
		if (dataStoreNodeName_5035Parser == null) {
			dataStoreNodeName_5035Parser = new ObjectNodeTypeParser();
		}
		return dataStoreNodeName_5035Parser;
	}

	/**
	 * @generated
	 */
	private ObjectNodeInStateParser dataStoreNodeQualifiedName_5037Parser;

	/**
	 * @generated
	 */
	private IParser getDataStoreNodeQualifiedName_5037Parser() {
		if (dataStoreNodeQualifiedName_5037Parser == null) {
			dataStoreNodeQualifiedName_5037Parser = new ObjectNodeInStateParser();
		}
		return dataStoreNodeQualifiedName_5037Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createDataStoreNodeName_5035Parser() {
		return new ObjectNodeTypeParser();
	}

	/**
	 * @generated NOT
	 */
	protected IParser createDataStoreNodeName_5037Parser() {
		return new ObjectNodeInStateParser();
	}

	/**
	 * @generated
	 */
	private ObjectNodeAttributesParser dataStoreNodeOrdering_5054Parser;

	/**
	 * @generated
	 */
	private IParser getDataStoreNodeOrdering_5054Parser() {
		if (dataStoreNodeOrdering_5054Parser == null) {
			dataStoreNodeOrdering_5054Parser = new ObjectNodeAttributesParser();
		}
		return dataStoreNodeOrdering_5054Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser dataStoreNodeQualifiedName_5128Parser;

	/**
	 * @generated
	 */
	private IParser getDataStoreNodeQualifiedName_5128Parser() {
		if (dataStoreNodeQualifiedName_5128Parser == null) {
			dataStoreNodeQualifiedName_5128Parser = new AppliedStereotypeParser();
		}
		return dataStoreNodeQualifiedName_5128Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createDataStoreNodeOrdering_5054Parser() {
		return new ObjectNodeAttributesParser();
	}

	/**
	 * @generated
	 */
	private ObjectNodeTypeParser centralBufferNodeName_5033Parser;

	/**
	 * @generated
	 */
	private IParser getCentralBufferNodeName_5033Parser() {
		if (centralBufferNodeName_5033Parser == null) {
			centralBufferNodeName_5033Parser = new ObjectNodeTypeParser();
		}
		return centralBufferNodeName_5033Parser;
	}

	/**
	 * @generated
	 */
	private ObjectNodeInStateParser centralBufferNodeQualifiedName_5039Parser;

	/**
	 * @generated
	 */
	private IParser getCentralBufferNodeQualifiedName_5039Parser() {
		if (centralBufferNodeQualifiedName_5039Parser == null) {
			centralBufferNodeQualifiedName_5039Parser = new ObjectNodeInStateParser();
		}
		return centralBufferNodeQualifiedName_5039Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createCentralBufferNodeName_5033Parser() {
		return new ObjectNodeTypeParser();
	}

	/**
	 * @generated NOT
	 */
	protected IParser createCentralBufferNodeName_5039Parser() {
		return new ObjectNodeInStateParser();
	}

	/**
	 * @generated
	 */
	private ObjectNodeAttributesParser centralBufferNodeOrdering_5050Parser;

	/**
	 * @generated
	 */
	private IParser getCentralBufferNodeOrdering_5050Parser() {
		if (centralBufferNodeOrdering_5050Parser == null) {
			centralBufferNodeOrdering_5050Parser = new ObjectNodeAttributesParser();
		}
		return centralBufferNodeOrdering_5050Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser centralBufferNodeQualifiedName_5125Parser;

	/**
	 * @generated
	 */
	private IParser getCentralBufferNodeQualifiedName_5125Parser() {
		if (centralBufferNodeQualifiedName_5125Parser == null) {
			centralBufferNodeQualifiedName_5125Parser = new AppliedStereotypeParser();
		}
		return centralBufferNodeQualifiedName_5125Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createCentralBufferNodeOrdering_5050Parser() {
		return new ObjectNodeAttributesParser();
	}

	/**
	 * @generated
	 */
	private ObjectNodeTypeAndInStateParser inputPinName_5047Parser;

	/**
	 * @generated
	 */
	private IParser getInputPinName_5047Parser() {
		if (inputPinName_5047Parser == null) {
			inputPinName_5047Parser = new ObjectNodeTypeAndInStateParser();
		}
		return inputPinName_5047Parser;
	}

	/**
	 * @generated
	 */
	private ObjectNodeAttributesParser inputPinOrdering_5063Parser;

	/**
	 * @generated
	 */
	private IParser getInputPinOrdering_5063Parser() {
		if (inputPinOrdering_5063Parser == null) {
			inputPinOrdering_5063Parser = new ObjectNodeAttributesParser();
		}
		return inputPinOrdering_5063Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createInputPinOrdering_5063Parser() {
		return new ObjectNodeAttributesParser();
	}

	/**
	 * @generated
	 */
	private ObjectNodeTypeAndInStateParser outputPinName_5048Parser;

	/**
	 * @generated
	 */
	private IParser getOutputPinName_5048Parser() {
		if (outputPinName_5048Parser == null) {
			outputPinName_5048Parser = new ObjectNodeTypeAndInStateParser();
		}
		return outputPinName_5048Parser;
	}

	/**
	 * @generated
	 */
	private ObjectNodeAttributesParser outputPinOrdering_5064Parser;

	/**
	 * @generated
	 */
	private IParser getOutputPinOrdering_5064Parser() {
		if (outputPinOrdering_5064Parser == null) {
			outputPinOrdering_5064Parser = new ObjectNodeAttributesParser();
		}
		return outputPinOrdering_5064Parser;
	}

	/**
	 * @generated
	 */
	private IParser conditionalNodeName_5147Parser;

	/**
	 * @generated
	 */
	private IParser getConditionalNodeName_5147Parser() {
		if (conditionalNodeName_5147Parser == null) {
			conditionalNodeName_5147Parser = createConditionalNodeName_5147Parser();
		}
		return conditionalNodeName_5147Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createConditionalNodeName_5147Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser conditionalNodeQualifiedName_5148Parser;

	/**
	 * @generated
	 */
	private IParser getConditionalNodeQualifiedName_5148Parser() {
		if (conditionalNodeQualifiedName_5148Parser == null) {
			conditionalNodeQualifiedName_5148Parser = createConditionalNodeQualifiedName_5148Parser();
		}
		return conditionalNodeQualifiedName_5148Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createConditionalNodeQualifiedName_5148Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_QualifiedName() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createOutputPinOrdering_5064Parser() {
		return new ObjectNodeAttributesParser();
	}

	/**
	 * @generated
	 */
	private IParser opaqueBehaviorName_5029Parser;

	/**
	 * @generated
	 */
	private IParser getOpaqueBehaviorName_5029Parser() {
		if (opaqueBehaviorName_5029Parser == null) {
			opaqueBehaviorName_5029Parser = createOpaqueBehaviorName_5029Parser();
		}
		return opaqueBehaviorName_5029Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createOpaqueBehaviorName_5029Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser activityParameterNodeName_5031Parser;

	/**
	 * @generated
	 */
	private IParser getActivityParameterNodeName_5031Parser() {
		if (activityParameterNodeName_5031Parser == null) {
			activityParameterNodeName_5031Parser = createActivityParameterNodeName_5031Parser();
		}
		return activityParameterNodeName_5031Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createActivityParameterNodeName_5031Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser activityParameterNodeQualifiedName_5094Parser;

	/**
	 * @generated
	 */
	private IParser getActivityParameterNodeQualifiedName_5094Parser() {
		if (activityParameterNodeQualifiedName_5094Parser == null) {
			activityParameterNodeQualifiedName_5094Parser = new AppliedStereotypeParser();
		}
		return activityParameterNodeQualifiedName_5094Parser;
	}

	/**
	 * @generated
	 */
	private IParser sendSignalActionName_5044Parser;

	/**
	 * @generated
	 */
	private IParser getSendSignalActionName_5044Parser() {
		if (sendSignalActionName_5044Parser == null) {
			sendSignalActionName_5044Parser = createSendSignalActionName_5044Parser();
		}
		return sendSignalActionName_5044Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createSendSignalActionName_5044Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser sendSignalActionQualifiedName_5113Parser;

	/**
	 * @generated
	 */
	private IParser getSendSignalActionQualifiedName_5113Parser() {
		if (sendSignalActionQualifiedName_5113Parser == null) {
			sendSignalActionQualifiedName_5113Parser = new AppliedStereotypeParser();
		}
		return sendSignalActionQualifiedName_5113Parser;
	}

	/**
	 * @generated
	 */
	private IParser activityPartitionName_5045Parser;

	/**
	 * @generated
	 */
	private IParser getActivityPartitionName_5045Parser() {
		if (activityPartitionName_5045Parser == null) {
			activityPartitionName_5045Parser = createActivityPartitionName_5045Parser();
		}
		return activityPartitionName_5045Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createActivityPartitionName_5045Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser activityPartitionName_5046Parser;

	/**
	 * @generated
	 */
	private IParser getActivityPartitionName_5046Parser() {
		if (activityPartitionName_5046Parser == null) {
			activityPartitionName_5046Parser = createActivityPartitionName_5046Parser();
		}
		return activityPartitionName_5046Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createActivityPartitionName_5046Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser acceptEventActionName_5065Parser;

	/**
	 * @generated
	 */
	private IParser getAcceptEventActionName_5065Parser() {
		if (acceptEventActionName_5065Parser == null) {
			acceptEventActionName_5065Parser = createAcceptEventActionName_5065Parser();
		}
		return acceptEventActionName_5065Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createAcceptEventActionName_5065Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser acceptEventActionQualifiedName_5105Parser;

	/**
	 * @generated
	 */
	private IParser getAcceptEventActionQualifiedName_5105Parser() {
		if (acceptEventActionQualifiedName_5105Parser == null) {
			acceptEventActionQualifiedName_5105Parser = new AppliedStereotypeParser();
		}
		return acceptEventActionQualifiedName_5105Parser;
	}

	/**
	 * @generated
	 */
	private IParser acceptEventActionName_5066Parser;

	/**
	 * @generated
	 */
	private IParser getAcceptEventActionName_5066Parser() {
		if (acceptEventActionName_5066Parser == null) {
			acceptEventActionName_5066Parser = createAcceptEventActionName_5066Parser();
		}
		return acceptEventActionName_5066Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createAcceptEventActionName_5066Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private ObjectNodeTypeParser dataStoreNodeName_5067Parser;

	/**
	 * @generated
	 */
	private IParser getDataStoreNodeName_5067Parser() {
		if (dataStoreNodeName_5067Parser == null) {
			dataStoreNodeName_5067Parser = new ObjectNodeTypeParser();
		}
		return dataStoreNodeName_5067Parser;
	}

	/**
	 * @generated
	 */
	private ObjectNodeInStateParser dataStoreNodeQualifiedName_5068Parser;

	/**
	 * @generated
	 */
	private IParser getDataStoreNodeQualifiedName_5068Parser() {
		if (dataStoreNodeQualifiedName_5068Parser == null) {
			dataStoreNodeQualifiedName_5068Parser = new ObjectNodeInStateParser();
		}
		return dataStoreNodeQualifiedName_5068Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createDataStoreNodeName_5067Parser() {
		return new ObjectNodeTypeParser();
	}

	/**
	 * @generated NOT
	 */
	protected IParser createDataStoreNodeName_5068Parser() {
		return new ObjectNodeInStateParser();
	}

	/**
	 * @generated
	 */
	private ObjectNodeAttributesParser dataStoreNodeOrdering_5069Parser;

	/**
	 * @generated
	 */
	private IParser getDataStoreNodeOrdering_5069Parser() {
		if (dataStoreNodeOrdering_5069Parser == null) {
			dataStoreNodeOrdering_5069Parser = new ObjectNodeAttributesParser();
		}
		return dataStoreNodeOrdering_5069Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser dataStoreNodeQualifiedName_5129Parser;

	/**
	 * @generated
	 */
	private IParser getDataStoreNodeQualifiedName_5129Parser() {
		if (dataStoreNodeQualifiedName_5129Parser == null) {
			dataStoreNodeQualifiedName_5129Parser = new AppliedStereotypeParser();
		}
		return dataStoreNodeQualifiedName_5129Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createDataStoreNodeOrdering_5069Parser() {
		return new ObjectNodeAttributesParser();
	}

	/**
	 * @generated
	 */
	private ObjectNodeTypeParser centralBufferNodeName_5070Parser;

	/**
	 * @generated
	 */
	private IParser getCentralBufferNodeName_5070Parser() {
		if (centralBufferNodeName_5070Parser == null) {
			centralBufferNodeName_5070Parser = new ObjectNodeTypeParser();
		}
		return centralBufferNodeName_5070Parser;
	}

	/**
	 * @generated
	 */
	private ObjectNodeInStateParser centralBufferNodeQualifiedName_5071Parser;

	/**
	 * @generated
	 */
	private IParser getCentralBufferNodeQualifiedName_5071Parser() {
		if (centralBufferNodeQualifiedName_5071Parser == null) {
			centralBufferNodeQualifiedName_5071Parser = new ObjectNodeInStateParser();
		}
		return centralBufferNodeQualifiedName_5071Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createCentralBufferNodeName_5070Parser() {
		return new ObjectNodeTypeParser();
	}

	/**
	 * @generated NOT
	 */
	protected IParser createCentralBufferNodeName_5071Parser() {
		return new ObjectNodeInStateParser();
	}

	/**
	 * @generated
	 */
	private ObjectNodeAttributesParser centralBufferNodeOrdering_5072Parser;

	/**
	 * @generated
	 */
	private IParser getCentralBufferNodeOrdering_5072Parser() {
		if (centralBufferNodeOrdering_5072Parser == null) {
			centralBufferNodeOrdering_5072Parser = new ObjectNodeAttributesParser();
		}
		return centralBufferNodeOrdering_5072Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser centralBufferNodeQualifiedName_5126Parser;

	/**
	 * @generated
	 */
	private IParser getCentralBufferNodeQualifiedName_5126Parser() {
		if (centralBufferNodeQualifiedName_5126Parser == null) {
			centralBufferNodeQualifiedName_5126Parser = new AppliedStereotypeParser();
		}
		return centralBufferNodeQualifiedName_5126Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createCentralBufferNodeOrdering_5072Parser() {
		return new ObjectNodeAttributesParser();
	}

	/**
	 * @generated
	 */
	private IParser opaqueActionName_5073Parser;

	/**
	 * @generated
	 */
	private IParser getOpaqueActionName_5073Parser() {
		if (opaqueActionName_5073Parser == null) {
			opaqueActionName_5073Parser = createOpaqueActionName_5073Parser();
		}
		return opaqueActionName_5073Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createOpaqueActionName_5073Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser opaqueActionQualifiedName_5112Parser;

	/**
	 * @generated
	 */
	private IParser getOpaqueActionQualifiedName_5112Parser() {
		if (opaqueActionQualifiedName_5112Parser == null) {
			opaqueActionQualifiedName_5112Parser = new AppliedStereotypeParser();
		}
		return opaqueActionQualifiedName_5112Parser;
	}

	/**
	 * @generated
	 */
	private ObjectNodeTypeParser pinName_5074Parser;

	/**
	 * @generated
	 */
	private IParser getPinName_5074Parser() {
		if (pinName_5074Parser == null) {
			pinName_5074Parser = new ObjectNodeTypeParser();
		}
		return pinName_5074Parser;
	}

	/**
	 * @generated
	 */
	private ObjectNodeInStateParser pinName_5075Parser;

	/**
	 * @generated
	 */
	private IParser getPinName_5075Parser() {
		if (pinName_5075Parser == null) {
			pinName_5075Parser = new ObjectNodeInStateParser();
		}
		return pinName_5075Parser;
	}

	/**
	 * @generated
	 */
	private ObjectNodeAttributesParser pinOrdering_5123Parser;

	/**
	 * @generated
	 */
	private IParser getPinOrdering_5123Parser() {
		if (pinOrdering_5123Parser == null) {
			pinOrdering_5123Parser = new ObjectNodeAttributesParser();
		}
		return pinOrdering_5123Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser pinQualifiedName_5132Parser;

	/**
	 * @generated
	 */
	private IParser getPinQualifiedName_5132Parser() {
		if (pinQualifiedName_5132Parser == null) {
			pinQualifiedName_5132Parser = new AppliedStereotypeParser();
		}
		return pinQualifiedName_5132Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createPinName_5074Parser() {
		return new ObjectNodeTypeParser();
	}

	/**
	 * @generated NOT
	 */
	protected IParser createPinOrdering_5075Parser() {
		return new ObjectNodeAttributesParser();
	}

	/**
	 * @generated
	 */
	private IParser createObjectActionName_5076Parser;

	/**
	 * @generated
	 */
	private IParser getCreateObjectActionName_5076Parser() {
		if (createObjectActionName_5076Parser == null) {
			createObjectActionName_5076Parser = createCreateObjectActionName_5076Parser();
		}
		return createObjectActionName_5076Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createCreateObjectActionName_5076Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser createObjectActionQualifiedName_5109Parser;

	/**
	 * @generated
	 */
	private IParser getCreateObjectActionQualifiedName_5109Parser() {
		if (createObjectActionQualifiedName_5109Parser == null) {
			createObjectActionQualifiedName_5109Parser = new AppliedStereotypeParser();
		}
		return createObjectActionQualifiedName_5109Parser;
	}

	/**
	 * @generated
	 */
	private IParser addStructuralFeatureValueActionName_5077Parser;

	/**
	 * @generated
	 */
	private IParser getAddStructuralFeatureValueActionName_5077Parser() {
		if (addStructuralFeatureValueActionName_5077Parser == null) {
			addStructuralFeatureValueActionName_5077Parser = createAddStructuralFeatureValueActionName_5077Parser();
		}
		return addStructuralFeatureValueActionName_5077Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createAddStructuralFeatureValueActionName_5077Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser addStructuralFeatureValueActionQualifiedName_5106Parser;

	/**
	 * @generated
	 */
	private IParser getAddStructuralFeatureValueActionQualifiedName_5106Parser() {
		if (addStructuralFeatureValueActionQualifiedName_5106Parser == null) {
			addStructuralFeatureValueActionQualifiedName_5106Parser = new AppliedStereotypeParser();
		}
		return addStructuralFeatureValueActionQualifiedName_5106Parser;
	}

	/**
	 * @generated
	 */
	private IParser callBehaviorActionName_5078Parser;

	/**
	 * @generated
	 */
	private IParser getCallBehaviorActionName_5078Parser() {
		if (callBehaviorActionName_5078Parser == null) {
			callBehaviorActionName_5078Parser = createCallBehaviorActionName_5078Parser();
		}
		return callBehaviorActionName_5078Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createCallBehaviorActionName_5078Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser callBehaviorActionQualifiedName_5103Parser;

	/**
	 * @generated
	 */
	private IParser getCallBehaviorActionQualifiedName_5103Parser() {
		if (callBehaviorActionQualifiedName_5103Parser == null) {
			callBehaviorActionQualifiedName_5103Parser = new AppliedStereotypeParser();
		}
		return callBehaviorActionQualifiedName_5103Parser;
	}

	/**
	 * @generated
	 */
	private IParser callOperationActionName_5079Parser;

	/**
	 * @generated
	 */
	private IParser getCallOperationActionName_5079Parser() {
		if (callOperationActionName_5079Parser == null) {
			callOperationActionName_5079Parser = createCallOperationActionName_5079Parser();
		}
		return callOperationActionName_5079Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createCallOperationActionName_5079Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser callOperationActionQualifiedName_5104Parser;

	/**
	 * @generated
	 */
	private IParser getCallOperationActionQualifiedName_5104Parser() {
		if (callOperationActionQualifiedName_5104Parser == null) {
			callOperationActionQualifiedName_5104Parser = new AppliedStereotypeParser();
		}
		return callOperationActionQualifiedName_5104Parser;
	}

	/**
	 * @generated
	 */
	private IParser structuredActivityNodeName_5122Parser;

	/**
	 * @generated
	 */
	private IParser getStructuredActivityNodeName_5122Parser() {
		if (structuredActivityNodeName_5122Parser == null) {
			structuredActivityNodeName_5122Parser = createStructuredActivityNodeName_5122Parser();
		}
		return structuredActivityNodeName_5122Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createStructuredActivityNodeName_5122Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser structuredActivityNodeQualifiedName_5140Parser;

	/**
	 * @generated
	 */
	private IParser getStructuredActivityNodeQualifiedName_5140Parser() {
		if (structuredActivityNodeQualifiedName_5140Parser == null) {
			structuredActivityNodeQualifiedName_5140Parser = new AppliedStereotypeParser();
		}
		return structuredActivityNodeQualifiedName_5140Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser structuredActivityNodeName_5121Parser;

	/**
	 * @generated
	 */
	private IParser getStructuredActivityNodeName_5121Parser() {
		if (structuredActivityNodeName_5121Parser == null) {
			structuredActivityNodeName_5121Parser = new AppliedStereotypeParser();
		}
		return structuredActivityNodeName_5121Parser;
	}

	/**
	 * @generated
	 */
	private IParser structuredActivityNodeQualifiedName_5139Parser;

	/**
	 * @generated
	 */
	private IParser getStructuredActivityNodeQualifiedName_5139Parser() {
		if (structuredActivityNodeQualifiedName_5139Parser == null) {
			structuredActivityNodeQualifiedName_5139Parser = createStructuredActivityNodeQualifiedName_5139Parser();
		}
		return structuredActivityNodeQualifiedName_5139Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createStructuredActivityNodeQualifiedName_5139Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_QualifiedName() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private ObjectNodeTypeAndInStateParser inputPinName_5081Parser;

	/**
	 * @generated
	 */
	private IParser getInputPinName_5081Parser() {
		if (inputPinName_5081Parser == null) {
			inputPinName_5081Parser = new ObjectNodeTypeAndInStateParser();
		}
		return inputPinName_5081Parser;
	}

	/**
	 * @generated
	 */
	private ObjectNodeAttributesParser inputPinOrdering_5082Parser;

	/**
	 * @generated
	 */
	private IParser getInputPinOrdering_5082Parser() {
		if (inputPinOrdering_5082Parser == null) {
			inputPinOrdering_5082Parser = new ObjectNodeAttributesParser();
		}
		return inputPinOrdering_5082Parser;
	}

	/**
	 * @generated
	 */
	private ObjectNodeTypeAndInStateParser outputPinName_5083Parser;

	/**
	 * @generated
	 */
	private IParser getOutputPinName_5083Parser() {
		if (outputPinName_5083Parser == null) {
			outputPinName_5083Parser = new ObjectNodeTypeAndInStateParser();
		}
		return outputPinName_5083Parser;
	}

	/**
	 * @generated
	 */
	private ObjectNodeAttributesParser outputPinOrdering_5084Parser;

	/**
	 * @generated
	 */
	private IParser getOutputPinOrdering_5084Parser() {
		if (outputPinOrdering_5084Parser == null) {
			outputPinOrdering_5084Parser = new ObjectNodeAttributesParser();
		}
		return outputPinOrdering_5084Parser;
	}

	/**
	 * @generated
	 */
	private IParser sendSignalActionName_5080Parser;

	/**
	 * @generated
	 */
	private IParser getSendSignalActionName_5080Parser() {
		if (sendSignalActionName_5080Parser == null) {
			sendSignalActionName_5080Parser = createSendSignalActionName_5080Parser();
		}
		return sendSignalActionName_5080Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createSendSignalActionName_5080Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser sendSignalActionQualifiedName_5114Parser;

	/**
	 * @generated
	 */
	private IParser getSendSignalActionQualifiedName_5114Parser() {
		if (sendSignalActionQualifiedName_5114Parser == null) {
			sendSignalActionQualifiedName_5114Parser = new AppliedStereotypeParser();
		}
		return sendSignalActionQualifiedName_5114Parser;
	}

	/**
	 * @generated
	 */
	private IParser loopNodeName_5117Parser;

	/**
	 * @generated
	 */
	private IParser getLoopNodeName_5117Parser() {
		if (loopNodeName_5117Parser == null) {
			loopNodeName_5117Parser = createLoopNodeName_5117Parser();
		}
		return loopNodeName_5117Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createLoopNodeName_5117Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser loopNodeQualifiedName_5141Parser;

	/**
	 * @generated
	 */
	private IParser getLoopNodeQualifiedName_5141Parser() {
		if (loopNodeQualifiedName_5141Parser == null) {
			loopNodeQualifiedName_5141Parser = new AppliedStereotypeParser();
		}
		return loopNodeQualifiedName_5141Parser;
	}

	/**
	 * @generated
	 */
	private IParser conditionalNodeName_5115Parser;

	/**
	 * @generated
	 */
	private IParser getConditionalNodeName_5115Parser() {
		if (conditionalNodeName_5115Parser == null) {
			conditionalNodeName_5115Parser = createConditionalNodeName_5115Parser();
		}
		return conditionalNodeName_5115Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createConditionalNodeName_5115Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser conditionalNodeQualifiedName_5142Parser;

	/**
	 * @generated
	 */
	private IParser getConditionalNodeQualifiedName_5142Parser() {
		if (conditionalNodeQualifiedName_5142Parser == null) {
			conditionalNodeQualifiedName_5142Parser = new AppliedStereotypeParser();
		}
		return conditionalNodeQualifiedName_5142Parser;
	}

	/**
	 * @generated
	 */
	private IParser expansionRegionMode_5088Parser;

	/**
	 * @generated
	 */
	private IParser getExpansionRegionMode_5088Parser() {
		if (expansionRegionMode_5088Parser == null) {
			expansionRegionMode_5088Parser = createExpansionRegionMode_5088Parser();
		}
		return expansionRegionMode_5088Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createExpansionRegionMode_5088Parser() {
		return new ExpansionRegionParser();
	}

	/**
	 * @generated
	 */
	private IParser valueSpecificationActionName_5133Parser;

	/**
	 * @generated
	 */
	private IParser getValueSpecificationActionName_5133Parser() {
		if (valueSpecificationActionName_5133Parser == null) {
			valueSpecificationActionName_5133Parser = createValueSpecificationActionName_5133Parser();
		}
		return valueSpecificationActionName_5133Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createValueSpecificationActionName_5133Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser valueSpecificationActionQualifiedName_5134Parser;

	/**
	 * @generated
	 */
	private IParser getValueSpecificationActionQualifiedName_5134Parser() {
		if (valueSpecificationActionQualifiedName_5134Parser == null) {
			valueSpecificationActionQualifiedName_5134Parser = createValueSpecificationActionQualifiedName_5134Parser();
		}
		return valueSpecificationActionQualifiedName_5134Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createValueSpecificationActionQualifiedName_5134Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_QualifiedName() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private ObjectNodeTypeAndInStateParser outputPinName_5137Parser;

	/**
	 * @generated
	 */
	private IParser getOutputPinName_5137Parser() {
		if (outputPinName_5137Parser == null) {
			outputPinName_5137Parser = new ObjectNodeTypeAndInStateParser();
		}
		return outputPinName_5137Parser;
	}

	/**
	 * @generated
	 */
	private ObjectNodeAttributesParser outputPinOrdering_5138Parser;

	/**
	 * @generated
	 */
	private IParser getOutputPinOrdering_5138Parser() {
		if (outputPinOrdering_5138Parser == null) {
			outputPinOrdering_5138Parser = new ObjectNodeAttributesParser();
		}
		return outputPinOrdering_5138Parser;
	}

	/**
	 * @generated
	 */
	private IParser loopNodeName_5091Parser;

	/**
	 * @generated
	 */
	private IParser getLoopNodeName_5091Parser() {
		if (loopNodeName_5091Parser == null) {
			loopNodeName_5091Parser = createLoopNodeName_5091Parser();
		}
		return loopNodeName_5091Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createLoopNodeName_5091Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser loopNodeQualifiedName_5118Parser;

	/**
	 * @generated
	 */
	private IParser getLoopNodeQualifiedName_5118Parser() {
		if (loopNodeQualifiedName_5118Parser == null) {
			loopNodeQualifiedName_5118Parser = new AppliedStereotypeParser();
		}
		return loopNodeQualifiedName_5118Parser;
	}

	/**
	 * @generated
	 */
	private IParser conditionalNodeName_5092Parser;

	/**
	 * @generated
	 */
	private IParser getConditionalNodeName_5092Parser() {
		if (conditionalNodeName_5092Parser == null) {
			conditionalNodeName_5092Parser = createConditionalNodeName_5092Parser();
		}
		return conditionalNodeName_5092Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createConditionalNodeName_5092Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser conditionalNodeQualifiedName_5116Parser;

	/**
	 * @generated
	 */
	private IParser getConditionalNodeQualifiedName_5116Parser() {
		if (conditionalNodeQualifiedName_5116Parser == null) {
			conditionalNodeQualifiedName_5116Parser = new AppliedStereotypeParser();
		}
		return conditionalNodeQualifiedName_5116Parser;
	}

	/**
	 * @generated
	 */
	private IParser expansionRegionMode_5087Parser;

	/**
	 * @generated
	 */
	private IParser getExpansionRegionMode_5087Parser() {
		if (expansionRegionMode_5087Parser == null) {
			expansionRegionMode_5087Parser = createExpansionRegionMode_5087Parser();
		}
		return expansionRegionMode_5087Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createExpansionRegionMode_5087Parser() {
		return new ExpansionRegionParser();
	}

	/**
	 * @generated
	 */
	private IParser expansionNodeName_5143Parser;

	/**
	 * @generated
	 */
	private IParser getExpansionNodeName_5143Parser() {
		if (expansionNodeName_5143Parser == null) {
			expansionNodeName_5143Parser = createExpansionNodeName_5143Parser();
		}
		return expansionNodeName_5143Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createExpansionNodeName_5143Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private ObjectNodeInStateParser expansionNodeQualifiedName_5144Parser;

	/**
	 * @generated
	 */
	private IParser getExpansionNodeQualifiedName_5144Parser() {
		if (expansionNodeQualifiedName_5144Parser == null) {
			expansionNodeQualifiedName_5144Parser = new ObjectNodeInStateParser();
		}
		return expansionNodeQualifiedName_5144Parser;
	}

	/**
	 * @generated
	 */
	private ObjectNodeAttributesParser expansionNodeOrdering_5145Parser;

	/**
	 * @generated
	 */
	private IParser getExpansionNodeOrdering_5145Parser() {
		if (expansionNodeOrdering_5145Parser == null) {
			expansionNodeOrdering_5145Parser = new ObjectNodeAttributesParser();
		}
		return expansionNodeOrdering_5145Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser expansionNodeQualifiedName_5146Parser;

	/**
	 * @generated
	 */
	private IParser getExpansionNodeQualifiedName_5146Parser() {
		if (expansionNodeQualifiedName_5146Parser == null) {
			expansionNodeQualifiedName_5146Parser = new AppliedStereotypeParser();
		}
		return expansionNodeQualifiedName_5146Parser;
	}

	/**
	 * @generated
	 */
	private IParser valueSpecificationActionName_5135Parser;

	/**
	 * @generated
	 */
	private IParser getValueSpecificationActionName_5135Parser() {
		if (valueSpecificationActionName_5135Parser == null) {
			valueSpecificationActionName_5135Parser = createValueSpecificationActionName_5135Parser();
		}
		return valueSpecificationActionName_5135Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createValueSpecificationActionName_5135Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser valueSpecificationActionQualifiedName_5136Parser;

	/**
	 * @generated
	 */
	private IParser getValueSpecificationActionQualifiedName_5136Parser() {
		if (valueSpecificationActionQualifiedName_5136Parser == null) {
			valueSpecificationActionQualifiedName_5136Parser = createValueSpecificationActionQualifiedName_5136Parser();
		}
		return valueSpecificationActionQualifiedName_5136Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createValueSpecificationActionQualifiedName_5136Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_QualifiedName() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser literalString_3049Parser;

	/**
	 * @generated
	 */
	private IParser getLiteralString_3049Parser() {
		if (literalString_3049Parser == null) {
			literalString_3049Parser = createLiteralString_3049Parser();
		}
		return literalString_3049Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createLiteralString_3049Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getLiteralString_Value() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser literalString_3051Parser;

	/**
	 * @generated
	 */
	private IParser getLiteralString_3051Parser() {
		if (literalString_3051Parser == null) {
			literalString_3051Parser = createLiteralString_3051Parser();
		}
		return literalString_3051Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createLiteralString_3051Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getLiteralString_Value() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser controlFlowName_6003Parser;

	/**
	 * @generated
	 */
	private IParser getControlFlowName_6003Parser() {
		if (controlFlowName_6003Parser == null) {
			controlFlowName_6003Parser = createControlFlowName_6003Parser();
		}
		return controlFlowName_6003Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createControlFlowName_6003Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser controlFlowName_6005Parser;

	/**
	 * @generated
	 */
	private IParser getControlFlowName_6005Parser() {
		if (controlFlowName_6005Parser == null) {
			controlFlowName_6005Parser = createControlFlowName_6005Parser();
		}
		return controlFlowName_6005Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createControlFlowName_6005Parser() {
		return new ActivityEdgeWeightParser();
	}

	/**
	 * @generated
	 */
	private IParser controlFlowName_6007Parser;

	/**
	 * @generated
	 */
	private IParser getControlFlowName_6007Parser() {
		if (controlFlowName_6007Parser == null) {
			controlFlowName_6007Parser = createControlFlowName_6007Parser();
		}
		return controlFlowName_6007Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createControlFlowName_6007Parser() {
		return new ActivityEdgeGuardParser();
	}

	/**
	 * @generated
	 */
	private IParser objectFlowName_6004Parser;

	/**
	 * @generated
	 */
	private IParser getObjectFlowName_6004Parser() {
		if (objectFlowName_6004Parser == null) {
			objectFlowName_6004Parser = createObjectFlowName_6004Parser();
		}
		return objectFlowName_6004Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createObjectFlowName_6004Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser objectFlowName_6006Parser;

	/**
	 * @generated
	 */
	private IParser getObjectFlowName_6006Parser() {
		if (objectFlowName_6006Parser == null) {
			objectFlowName_6006Parser = createObjectFlowName_6006Parser();
		}
		return objectFlowName_6006Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createObjectFlowName_6006Parser() {
		return new ActivityEdgeWeightParser();
	}

	/**
	 * @generated
	 */
	private IParser objectFlowName_6008Parser;

	/**
	 * @generated
	 */
	private IParser getObjectFlowName_6008Parser() {
		if (objectFlowName_6008Parser == null) {
			objectFlowName_6008Parser = createObjectFlowName_6008Parser();
		}
		return objectFlowName_6008Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createObjectFlowName_6008Parser() {
		return new ActivityEdgeGuardParser();
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case ActivityNameEditPart.VISUAL_ID:
			return getActivityName_5030Parser();
		case ActivityStereotypeEditPart.VISUAL_ID:
			return getActivityQualifiedName_5093Parser();
		case AcceptEventActionNameEditPart.VISUAL_ID:
			return getAcceptEventActionName_5040Parser();
		case AcceptEventActionStereotypeEditPart.VISUAL_ID:
			return getAcceptEventActionQualifiedName_5095Parser();
		case AcceptTimeEventActionNameEditPart.VISUAL_ID:
			return getAcceptEventActionName_5042Parser();
		case DataStoreNodeNameEditPart.VISUAL_ID:
			return getDataStoreNodeName_5034Parser();
		case DataStoreNodeInStateEditPart.VISUAL_ID:
			return getDataStoreNodeQualifiedName_5036Parser();
		case DataStoreNodeOrderingEditPart.VISUAL_ID:
			return getDataStoreNodeOrdering_5051Parser();
		case DataStoreNodeStereotypeEditPart.VISUAL_ID:
			return getDataStoreNodeQualifiedName_5127Parser();
		case CentralBufferNodeNameEditPart.VISUAL_ID:
			return getCentralBufferNodeName_5032Parser();
		case CentralBufferNodeInStateEditPart.VISUAL_ID:
			return getCentralBufferNodeQualifiedName_5038Parser();
		case CentralBufferNodeOrderingEditPart.VISUAL_ID:
			return getCentralBufferNodeOrdering_5049Parser();
		case CentralBufferNodeStereotypeEditPart.VISUAL_ID:
			return getCentralBufferNodeQualifiedName_5124Parser();
		case OpaqueActionNameEditPart.VISUAL_ID:
			return getOpaqueActionName_5023Parser();
		case OpaqueActionStereotypeEditPart.VISUAL_ID:
			return getOpaqueActionQualifiedName_5110Parser();
		case OpaqueAction_OutputPinNameEditPart.VISUAL_ID:
			return getOutputPinName_5003Parser();
		case OpaqueAction_OutputPinOrderingEditPart.VISUAL_ID:
			return getOutputPinOrdering_5055Parser();
		case OpaqueAction_InputPinNameEditPart.VISUAL_ID:
			return getInputPinName_5149Parser();
		case OpaqueAction_InputPinOrderingEditPart.VISUAL_ID:
			return getInputPinOrdering_5150Parser();
		case PinNameEditPart.VISUAL_ID:
			return getPinName_5024Parser();
		case PinInStateEditPart.VISUAL_ID:
			return getPinName_5052Parser();
		case PinOrderingEditPart.VISUAL_ID:
			return getPinOrdering_5085Parser();
		case PinStereotypeEditPart.VISUAL_ID:
			return getPinQualifiedName_5130Parser();
		case CreateObjectActionNameEditPart.VISUAL_ID:
			return getCreateObjectActionName_5025Parser();
		case CreateObjectActionStereotypeEditPart.VISUAL_ID:
			return getCreateObjectActionQualifiedName_5107Parser();
		case CreateObjectAction_OutputPinNameEditPart.VISUAL_ID:
			return getOutputPinName_5004Parser();
		case CreateObjectAction_OutputPinOrderingEditPart.VISUAL_ID:
			return getOutputPinOrdering_5056Parser();
		case AddStructuralFeatureValueActionNameEditPart.VISUAL_ID:
			return getAddStructuralFeatureValueActionName_5026Parser();
		case AddStructuralFeatureValueActionStereotypeEditPart.VISUAL_ID:
			return getAddStructuralFeatureValueActionQualifiedName_5097Parser();
		case AddStructuralFeatureValueAction_insertAt_InputPinNameEditPart.VISUAL_ID:
			return getInputPinName_5006Parser();
		case AddStructuralFeatureValueAction_insertAt_InputPinOrderingEditPart.VISUAL_ID:
			return getInputPinOrdering_5057Parser();
		case AddStructuralFeatureValueAction_value_InputPinNameEditPart.VISUAL_ID:
			return getInputPinName_5007Parser();
		case AddStructuralFeatureValueAction_value_InputPinOrderingEditPart.VISUAL_ID:
			return getInputPinOrdering_5058Parser();
		case AddStructuralFeatureValueAction_object_InputPinNameEditPart.VISUAL_ID:
			return getInputPinName_5008Parser();
		case AddStructuralFeatureValueAction_object_InputPinOrderingEditPart.VISUAL_ID:
			return getInputPinOrdering_5059Parser();
		case CallBehaviorActionNameEditPart.VISUAL_ID:
			return getCallBehaviorActionName_5027Parser();
		case CallBehaviorActionStereotypeEditPart.VISUAL_ID:
			return getCallBehaviorActionQualifiedName_5099Parser();
		case CallAction_OutputPinNameEditPart.VISUAL_ID:
			return getOutputPinName_5010Parser();
		case CallAction_OutputPinOrderingEditPart.VISUAL_ID:
			return getOutputPinOrdering_5060Parser();
		case CallAction_InputPinNameEditPart.VISUAL_ID:
			return getInputPinName_5011Parser();
		case CallAction_InputPinOrderingEditPart.VISUAL_ID:
			return getInputPinOrdering_5061Parser();
		case CallOperationActionNameEditPart.VISUAL_ID:
			return getCallOperationActionName_5028Parser();
		case CallOperationActionStereotypeEditPart.VISUAL_ID:
			return getCallOperationActionQualifiedName_5101Parser();
		case CallOperationAction_InputPinNameEditPart.VISUAL_ID:
			return getInputPinName_5013Parser();
		case CallOperationAction_InputPinOrderingEditPart.VISUAL_ID:
			return getInputPinOrdering_5062Parser();
		case StructuredActivityNodeNameEditPart.VISUAL_ID:
			return getStructuredActivityNodeName_5090Parser();
		case StructuredActivityNodeStereotypeEditPart.VISUAL_ID:
			return getStructuredActivityNodeQualifiedName_5120Parser();
		case StructuredActivityNode_StructuredActivityNodeNameEditPart.VISUAL_ID:
			return getStructuredActivityNodeName_5089Parser();
		case StructuredActivityNode_StructuredActivityNodeStereotypeEditPart.VISUAL_ID:
			return getStructuredActivityNodeQualifiedName_5119Parser();
		case StructuredActivityNode_OpaqueActionNameEditPart.VISUAL_ID:
			return getOpaqueActionName_5015Parser();
		case StructuredActivityNode_OpaqueActionStereotypeEditPart.VISUAL_ID:
			return getOpaqueActionQualifiedName_5111Parser();
		case StructuredActivityNode_AcceptEventActionNameEditPart.VISUAL_ID:
			return getAcceptEventActionName_5041Parser();
		case StructuredActivityNode_AcceptEventActionStereotypeEditPart.VISUAL_ID:
			return getAcceptEventActionQualifiedName_5096Parser();
		case StructuredActivityNode_AcceptTimeEventActionNameEditPart.VISUAL_ID:
			return getAcceptEventActionName_5043Parser();
		case StructuredActivityNode_PinNameEditPart.VISUAL_ID:
			return getPinName_5016Parser();
		case StructuredActivityNode_PinInStateEditPart.VISUAL_ID:
			return getPinName_5053Parser();
		case StructuredActivityNode_PinOrderingEditPart.VISUAL_ID:
			return getPinOrdering_5086Parser();
		case StructuredActivityNode_PinStereotypeEditPart.VISUAL_ID:
			return getPinQualifiedName_5131Parser();
		case StructuredActivityNode_CreateObjectActionNameEditPart.VISUAL_ID:
			return getCreateObjectActionName_5017Parser();
		case StructuredActivityNode_CreateObjectActionStereotypeEditPart.VISUAL_ID:
			return getCreateObjectActionQualifiedName_5108Parser();
		case StructuredActivityNode_CallBehaviorActionNameEditPart.VISUAL_ID:
			return getCallBehaviorActionName_5018Parser();
		case StructuredActivityNode_CallBehaviorActionStereotypeEditPart.VISUAL_ID:
			return getCallBehaviorActionQualifiedName_5100Parser();
		case StructuredActivityNode_CallOperationActionNameEditPart.VISUAL_ID:
			return getCallOperationActionName_5019Parser();
		case StructuredActivityNode_CallOperationActionStereotypeEditPart.VISUAL_ID:
			return getCallOperationActionQualifiedName_5102Parser();
		case StructuredActivityNode_AddStructuralFeatureValueActionNameEditPart.VISUAL_ID:
			return getAddStructuralFeatureValueActionName_5020Parser();
		case StructuredActivityNode_AddStructuralFeatureValueActionStereotypeEditPart.VISUAL_ID:
			return getAddStructuralFeatureValueActionQualifiedName_5098Parser();
		case StructuredActivityNode_DataStoreNodeNameEditPart.VISUAL_ID:
			return getDataStoreNodeName_5035Parser();
		case StructuredActivityNode_DataStoreNodeInStateEditPart.VISUAL_ID:
			return getDataStoreNodeQualifiedName_5037Parser();
		case StructuredActivityNode_DataStoreNodeOrderingEditPart.VISUAL_ID:
			return getDataStoreNodeOrdering_5054Parser();
		case StructuredActivityNode_DataStoreNodeStereotypeEditPart.VISUAL_ID:
			return getDataStoreNodeQualifiedName_5128Parser();
		case StructuredActivityNode_CentralBufferNodeNameEditPart.VISUAL_ID:
			return getCentralBufferNodeName_5033Parser();
		case StructuredActivityNode_CentralBufferNodeInStateEditPart.VISUAL_ID:
			return getCentralBufferNodeQualifiedName_5039Parser();
		case StructuredActivityNode_CentralBufferNodeOrderingEditPart.VISUAL_ID:
			return getCentralBufferNodeOrdering_5050Parser();
		case StructuredActivityNode_CentralBufferNodeStereotypeEditPart.VISUAL_ID:
			return getCentralBufferNodeQualifiedName_5125Parser();
		case StructuredActivityNode_InputPinNameEditPart.VISUAL_ID:
			return getInputPinName_5047Parser();
		case StructuredActivityNode_InputPinOrderingEditPart.VISUAL_ID:
			return getInputPinOrdering_5063Parser();
		case StructuredActivityNode_OutputPinNameEditPart.VISUAL_ID:
			return getOutputPinName_5048Parser();
		case StructuredActivityNode_OutputPinOrderingEditPart.VISUAL_ID:
			return getOutputPinOrdering_5064Parser();
		case StructuredActivityNode_ConditionalNodeNameEditPart.VISUAL_ID:
			return getConditionalNodeName_5147Parser();
		case StructuredActivityNode_ConditionalNodeStereotypeEditPart.VISUAL_ID:
			return getConditionalNodeQualifiedName_5148Parser();
		case OpaqueBehaviorNameEditPart.VISUAL_ID:
			return getOpaqueBehaviorName_5029Parser();
		case ActivityParameterNodeNameEditPart.VISUAL_ID:
			return getActivityParameterNodeName_5031Parser();
		case ActivityParameterNodeStereotypeEditPart.VISUAL_ID:
			return getActivityParameterNodeQualifiedName_5094Parser();
		case SendSignalActionNameEditPart.VISUAL_ID:
			return getSendSignalActionName_5044Parser();
		case SendSignalActionStereotypeEditPart.VISUAL_ID:
			return getSendSignalActionQualifiedName_5113Parser();
		case ActivityPartitionNameEditPart.VISUAL_ID:
			return getActivityPartitionName_5045Parser();
		case ActivityPartition_ActivityPartitionNameEditPart.VISUAL_ID:
			return getActivityPartitionName_5046Parser();
		case ActivityPartition_AcceptEventActionNameEditPart.VISUAL_ID:
			return getAcceptEventActionName_5065Parser();
		case ActivityPartition_AcceptEventActionStereotypeEditPart.VISUAL_ID:
			return getAcceptEventActionQualifiedName_5105Parser();
		case ActivityPartition_AcceptTimeEventActionNameEditPart.VISUAL_ID:
			return getAcceptEventActionName_5066Parser();
		case ActivityPartition_DataStoreNodeNameEditPart.VISUAL_ID:
			return getDataStoreNodeName_5067Parser();
		case ActivityPartition_DataStoreNodeInStateEditPart.VISUAL_ID:
			return getDataStoreNodeQualifiedName_5068Parser();
		case ActivityPartition_DataStoreNodeOrderingEditPart.VISUAL_ID:
			return getDataStoreNodeOrdering_5069Parser();
		case ActivityPartition_DataStoreNodeStereotypeEditPart.VISUAL_ID:
			return getDataStoreNodeQualifiedName_5129Parser();
		case ActivityPartition_CentralBufferNodeNameEditPart.VISUAL_ID:
			return getCentralBufferNodeName_5070Parser();
		case ActivityPartition_CentralBufferNodeInStateEditPart.VISUAL_ID:
			return getCentralBufferNodeQualifiedName_5071Parser();
		case ActivityPartition_CentralBufferNodeOrderingEditPart.VISUAL_ID:
			return getCentralBufferNodeOrdering_5072Parser();
		case ActivityPartition_CentralBufferNodeStereotypeEditPart.VISUAL_ID:
			return getCentralBufferNodeQualifiedName_5126Parser();
		case ActivityPartition_OpaqueActionNameEditPart.VISUAL_ID:
			return getOpaqueActionName_5073Parser();
		case ActivityPartition_OpaqueActionStereotypeEditPart.VISUAL_ID:
			return getOpaqueActionQualifiedName_5112Parser();
		case ActivityPartition_PinNameEditPart.VISUAL_ID:
			return getPinName_5074Parser();
		case ActivityPartition_PinInStateEditPart.VISUAL_ID:
			return getPinName_5075Parser();
		case ActivityPartition_PinOrderingEditPart.VISUAL_ID:
			return getPinOrdering_5123Parser();
		case ActivityPartition_PinStereotypeEditPart.VISUAL_ID:
			return getPinQualifiedName_5132Parser();
		case ActivityPartition_CreateObjectActionNameEditPart.VISUAL_ID:
			return getCreateObjectActionName_5076Parser();
		case ActivityPartition_CreateObjectActionStereotypeEditPart.VISUAL_ID:
			return getCreateObjectActionQualifiedName_5109Parser();
		case ActivityPartition_AddStructuralFeatureValueActionNameEditPart.VISUAL_ID:
			return getAddStructuralFeatureValueActionName_5077Parser();
		case ActivityPartition_AddStructuralFeatureValueActionStereotypeEditPart.VISUAL_ID:
			return getAddStructuralFeatureValueActionQualifiedName_5106Parser();
		case ActivityPartition_CallBehaviorActionNameEditPart.VISUAL_ID:
			return getCallBehaviorActionName_5078Parser();
		case ActivityPartition_CallBehaviorActionStereotypeEditPart.VISUAL_ID:
			return getCallBehaviorActionQualifiedName_5103Parser();
		case ActivityPartition_CallOperationActionNameEditPart.VISUAL_ID:
			return getCallOperationActionName_5079Parser();
		case ActivityPartition_CallOperationActionStereotypeEditPart.VISUAL_ID:
			return getCallOperationActionQualifiedName_5104Parser();
		case ActivityPartition_StructuredActivityNodeNameEditPart.VISUAL_ID:
			return getStructuredActivityNodeName_5122Parser();
		case ActivityPartition_StructuredActivityNodeStereotypeEditPart.VISUAL_ID:
			return getStructuredActivityNodeQualifiedName_5140Parser();
		case ActivityPartition_StructuredActivityNode_StructuredActivityNodeStereotypeEditPart.VISUAL_ID:
			return getStructuredActivityNodeName_5121Parser();
		case StructuredActivityNodeQualifiedName2EditPart.VISUAL_ID:
			return getStructuredActivityNodeQualifiedName_5139Parser();
		case StructuredActivityNode_StructuredActivityNode_InputPinNameEditPart.VISUAL_ID:
			return getInputPinName_5081Parser();
		case StructuredActivityNode_StructuredActivityNode_InputPinOrderingEditPart.VISUAL_ID:
			return getInputPinOrdering_5082Parser();
		case StructuredActivityNode_StructuredActivityNode_OutputPinNameEditPart.VISUAL_ID:
			return getOutputPinName_5083Parser();
		case StructuredActivityNode_StructuredActivityNode_OutputPinOrderingEditPart.VISUAL_ID:
			return getOutputPinOrdering_5084Parser();
		case ActivityPartition_SendSignalActionNameEditPart.VISUAL_ID:
			return getSendSignalActionName_5080Parser();
		case ActivityPartition_SendSignalActionStereotypeEditPart.VISUAL_ID:
			return getSendSignalActionQualifiedName_5114Parser();
		case ActivityPartition_LoopNodeNameEditPart.VISUAL_ID:
			return getLoopNodeName_5117Parser();
		case ActivityPartition_LoopNodeStereotypeEditPart.VISUAL_ID:
			return getLoopNodeQualifiedName_5141Parser();
		case ActivityPartition_ConditionalNodeNameEditPart.VISUAL_ID:
			return getConditionalNodeName_5115Parser();
		case ActivityPartition_ConditionalNodeStereotypeEditPart.VISUAL_ID:
			return getConditionalNodeQualifiedName_5142Parser();
		case ActivityPartition_ExpansionRegionModeEditPart.VISUAL_ID:
			return getExpansionRegionMode_5088Parser();
		case ActivityPartition_ValueSpecificationActionNameEditPart.VISUAL_ID:
			return getValueSpecificationActionName_5133Parser();
		case ActivityPartition_ValueSpecificationActionStereotypeEditPart.VISUAL_ID:
			return getValueSpecificationActionQualifiedName_5134Parser();
		case ValueSpecificationAction_OutputPinNameEditPart.VISUAL_ID:
			return getOutputPinName_5137Parser();
		case ValueSpecificationAction_OutputPinOrderingEditPart.VISUAL_ID:
			return getOutputPinOrdering_5138Parser();
		case LoopNodeNameEditPart.VISUAL_ID:
			return getLoopNodeName_5091Parser();
		case LoopNodeStereotypeEditPart.VISUAL_ID:
			return getLoopNodeQualifiedName_5118Parser();
		case ConditionalNodeNameEditPart.VISUAL_ID:
			return getConditionalNodeName_5092Parser();
		case ConditionalNodeStereotypeEditPart.VISUAL_ID:
			return getConditionalNodeQualifiedName_5116Parser();
		case ExpansionRegionModeEditPart.VISUAL_ID:
			return getExpansionRegionMode_5087Parser();
		case ExpansionNodeNameEditPart.VISUAL_ID:
			return getExpansionNodeName_5143Parser();
		case ExpansionNodeInStateEditPart.VISUAL_ID:
			return getExpansionNodeQualifiedName_5144Parser();
		case ExpansionNodeOrderingEditPart.VISUAL_ID:
			return getExpansionNodeOrdering_5145Parser();
		case ExpansionNodeStereotypeEditPart.VISUAL_ID:
			return getExpansionNodeQualifiedName_5146Parser();
		case ValueSpecificationActionNameEditPart.VISUAL_ID:
			return getValueSpecificationActionName_5135Parser();
		case ValueSpecificationActionStereotypeEditPart.VISUAL_ID:
			return getValueSpecificationActionQualifiedName_5136Parser();
		case LocalPrecondition_LiteralStringEditPart.VISUAL_ID:
			return getLiteralString_3049Parser();
		case LocalPostcondition_LiteralStringEditPart.VISUAL_ID:
			return getLiteralString_3051Parser();
		case ControlFlowNameEditPart.VISUAL_ID:
			return getControlFlowName_6003Parser();
		case ControlFlowName2EditPart.VISUAL_ID:
			return getControlFlowName_6005Parser();
		case ControlFlowName3EditPart.VISUAL_ID:
			return getControlFlowName_6007Parser();
		case ObjectFlowNameEditPart.VISUAL_ID:
			return getObjectFlowName_6004Parser();
		case ObjectFlowName2EditPart.VISUAL_ID:
			return getObjectFlowName_6006Parser();
		case ObjectFlowName3EditPart.VISUAL_ID:
			return getObjectFlowName_6008Parser();
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
