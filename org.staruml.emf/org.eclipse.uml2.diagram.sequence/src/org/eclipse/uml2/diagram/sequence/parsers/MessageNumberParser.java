package org.eclipse.uml2.diagram.sequence.parsers;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.uml2.diagram.sequence.model.SDModelAccess;
import org.eclipse.uml2.diagram.sequence.model.sdnotation.SDModelStorageStyle;
import org.eclipse.uml2.diagram.sequence.model.sdnotation.SDNotationPackage;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDAbstractMessage;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDModel;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.UMLPackage;


public class MessageNumberParser implements ISemanticParser {

	public boolean areSemanticElementsAffected(EObject listener, Object notification) {
		if (false == notification instanceof Notification){
			return false;
		}
		Notification change = (Notification)notification;
		Object feature = change.getFeature();
		return isAffectingFeature(feature);
	}

	@SuppressWarnings("unchecked")
	public List getSemanticElementsBeingParsed(EObject element) {
		View view = (View)element;
		Message umlMessage = (Message) view.getElement();
		List result = new LinkedList();
		result.add(umlMessage);
		View interactionView = SDModelAccess.findInteractionView(view);
		if (interactionView != null){
			result.add(interactionView);
			SDModelStorageStyle sdModelAccessor = SDModelAccess.findSDModelAccessor(interactionView);
			if (sdModelAccessor != null){
				result.add(sdModelAccessor);
			}
		}
		return result;
	}

	public String getEditString(IAdaptable element, int flags) {
		return "";
	}

	public ICommand getParseCommand(IAdaptable element, String newString, int flags) {
		return UnexecutableCommand.INSTANCE;
	}

	public String getPrintString(IAdaptable element, int flags) {
		View view = (View) element.getAdapter(View.class);
		if (view == null){
			return "Error";
		}
		Message umlMessage = (Message)view.getElement();
		SDModel sdModel = SDModelAccess.findSDModel(view);
		StringBuilder result = new StringBuilder();
		if (sdModel != null){
			SDAbstractMessage sdMessage = sdModel.getUMLTracing().findMessage(umlMessage);
			if (sdMessage != null){
				String number = sdMessage.getMessageNumber();
				if (number == null){
					number = "(?)";
				}
				result.append(number).append(": ");
			}
		}
		
//		String name = umlMessage.getName(); 
//		if (name == null){
//			name = "";
//		}
//		result.append(name);
		result.append("* ");
		return result.toString();
	}

	public IParserEditStatus isValidEditString(IAdaptable element, String editString) {
		return ParserEditStatus.UNEDITABLE_STATUS;
	}

	public IContentAssistProcessor getCompletionProcessor(IAdaptable element) {
		// TODO Auto-generated method stub
		return null;
	}

	public final boolean isAffectingEvent(Object event, int flags) {
		return isAffectingEvent(event);
	}
	
	protected boolean isAffectingEvent(Object event){
		if (event instanceof Notification) {
			Object feature = ((Notification) event).getFeature();
			return isAffectingFeature(feature);
		}
		return false;
	}
	
	private boolean isAffectingFeature(Object feature){
		return // 
			feature == UMLPackage.eINSTANCE.getNamedElement_Name() || // 
			feature == SDNotationPackage.eINSTANCE.getSDModelStorageStyle_Version() ||
			feature == NotationPackage.eINSTANCE.getView_Styles();
	}

}
