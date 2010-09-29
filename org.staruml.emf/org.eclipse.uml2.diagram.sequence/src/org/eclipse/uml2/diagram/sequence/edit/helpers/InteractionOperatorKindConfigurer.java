package org.eclipse.uml2.diagram.sequence.edit.helpers;

import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.InteractionOperatorKind;
import org.eclipse.uml2.uml.UMLPackage;


public class InteractionOperatorKindConfigurer {
	private static final String KEY_OPERATOR_KIND = InteractionOperatorKindConfigurer.class.getCanonicalName() + ".operator-kind";
	
	@SuppressWarnings("unchecked")
	public static void setOperatorKind(Request request, InteractionOperatorKind kind){
		request.getExtendedData().put(KEY_OPERATOR_KIND, kind);
	}
	
	public static InteractionOperatorKind getOperatorKind(IEditCommandRequest request){
		Object value = request.getParameter(KEY_OPERATOR_KIND);
		return value instanceof InteractionOperatorKind ? (InteractionOperatorKind)value : null; 
	}
	
	public static ICommand configure(ConfigureRequest configureRequest){
		if (false == configureRequest.getElementToConfigure() instanceof CombinedFragment){
			return null;
		}
		InteractionOperatorKind kind = getOperatorKind(configureRequest);
		if (kind == null){
			return null;
		}
		
		SetRequest setRequest = new SetRequest(configureRequest.getEditingDomain(), //
				configureRequest.getElementToConfigure(),
				UMLPackage.eINSTANCE.getCombinedFragment_InteractionOperator(),
				kind);
		
		return new SetValueCommand(setRequest);
	}

}
