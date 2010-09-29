package org.eclipse.uml2.diagram.sequence.providers;

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
import org.eclipse.uml2.diagram.sequence.edit.parts.ActionExecutionLabelEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.CombinedFragmentInteractionOperatorEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.InteractionNameEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.InteractionUseSignatureEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.LifelineNameEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.MessageNameEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.StateInvariantLabelEditPart;
import org.eclipse.uml2.diagram.sequence.parsers.MessageFormatParser;
import org.eclipse.uml2.diagram.sequence.parsers.MessageNumberParser;
import org.eclipse.uml2.diagram.sequence.part.UMLVisualIDRegistry;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */

public class UMLParserProvider extends AbstractProvider implements IParserProvider {

	/**
	 * @generated
	 */
	private IParser interactionName_5002Parser;

	/**
	 * @generated
	 */
	private IParser getInteractionName_5002Parser() {
		if (interactionName_5002Parser == null) {
			interactionName_5002Parser = createInteractionName_5002Parser();
		}
		return interactionName_5002Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createInteractionName_5002Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser interactionUseName_5007Parser;

	/**
	 * @generated
	 */
	private IParser getInteractionUseName_5007Parser() {
		if (interactionUseName_5007Parser == null) {
			interactionUseName_5007Parser = createInteractionUseName_5007Parser();
		}
		return interactionUseName_5007Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createInteractionUseName_5007Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser combinedFragmentInteractionOperator_5010Parser;

	/**
	 * @generated
	 */
	private IParser getCombinedFragmentInteractionOperator_5010Parser() {
		if (combinedFragmentInteractionOperator_5010Parser == null) {
			combinedFragmentInteractionOperator_5010Parser = createCombinedFragmentInteractionOperator_5010Parser();
		}
		return combinedFragmentInteractionOperator_5010Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createCombinedFragmentInteractionOperator_5010Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getCombinedFragment_InteractionOperator() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser lifelineName_5001Parser;

	/**
	 * @generated
	 */
	private IParser getLifelineName_5001Parser() {
		if (lifelineName_5001Parser == null) {
			lifelineName_5001Parser = createLifelineName_5001Parser();
		}
		return lifelineName_5001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createLifelineName_5001Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser actionExecutionSpecificationName_5003Parser;

	/**
	 * @generated
	 */
	private IParser getActionExecutionSpecificationName_5003Parser() {
		if (actionExecutionSpecificationName_5003Parser == null) {
			actionExecutionSpecificationName_5003Parser = createActionExecutionSpecificationName_5003Parser();
		}
		return actionExecutionSpecificationName_5003Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createActionExecutionSpecificationName_5003Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser stateInvariantName_5004Parser;

	/**
	 * @generated
	 */
	private IParser getStateInvariantName_5004Parser() {
		if (stateInvariantName_5004Parser == null) {
			stateInvariantName_5004Parser = createStateInvariantName_5004Parser();
		}
		return stateInvariantName_5004Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createStateInvariantName_5004Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser messageName_6001Parser;

	/**
	 * @generated
	 */
	private IParser getMessageName_6001Parser() {
		if (messageName_6001Parser == null) {
			messageName_6001Parser = createMessageName_6001Parser();
		}
		return messageName_6001Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createMessageName_6001Parser() {
		return new MessageNumberParser();
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case InteractionNameEditPart.VISUAL_ID:
			return getInteractionName_5002Parser();
		case InteractionUseSignatureEditPart.VISUAL_ID:
			return getInteractionUseName_5007Parser();
		case CombinedFragmentInteractionOperatorEditPart.VISUAL_ID:
			return getCombinedFragmentInteractionOperator_5010Parser();
		case LifelineNameEditPart.VISUAL_ID:
			return getLifelineName_5001Parser();
		case ActionExecutionLabelEditPart.VISUAL_ID:
			return getActionExecutionSpecificationName_5003Parser();
		case StateInvariantLabelEditPart.VISUAL_ID:
			return getStateInvariantName_5004Parser();
		case MessageNameEditPart.VISUAL_ID:
			return getMessageName_6001Parser();
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
