package org.eclipse.uml2.diagram.sequence.edit.helpers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.UMLPackage;


public class CoveredLifelineConfigurer {
	private static final String KEY_COVERED_LIFELINE = CoveredLifelineConfigurer.class.getCanonicalName() + ".covered-lifeline";
	
	@SuppressWarnings("unchecked")
	public static void setCoveredLifeLines(Request request, Lifeline ...lifelines){
		if (lifelines.length != 0){
			request.getExtendedData().put(KEY_COVERED_LIFELINE, Arrays.asList(lifelines));	
		}
	}
	
	public static void setCoveredLifeLines(Request request, GraphicalEditPart ...lifelineEPs){
		List<Lifeline> lifelines = new LinkedList<Lifeline>();
		for (GraphicalEditPart next : lifelineEPs){
			if (next == null){
				continue;
			}
			EObject nextSemantic = next.resolveSemanticElement();
			if (nextSemantic instanceof Lifeline){
				lifelines.add((Lifeline)nextSemantic);
			}
		}
		if (!lifelines.isEmpty()){
			setCoveredLifeLines(request, lifelines.toArray(new Lifeline[lifelines.size()]));
		}
	}

	@SuppressWarnings("unchecked")
	public static List<Lifeline> getCoveredLifeLines(IEditCommandRequest request){
		Object result = request.getParameter(KEY_COVERED_LIFELINE);
		return result instanceof List ? (List<Lifeline>) result : null;
	}
	
	public static ICommand configure(ConfigureRequest configureRequest){
		if (false == configureRequest.getElementToConfigure() instanceof InteractionFragment){
			return null;
		}
		List<Lifeline> lifelines = getCoveredLifeLines(configureRequest);
		if (lifelines == null || lifelines.isEmpty()){
			return null;
		}
		
		SetRequest setRequest = new SetRequest(configureRequest.getEditingDomain(), //
				configureRequest.getElementToConfigure(),
				UMLPackage.eINSTANCE.getInteractionFragment_Covered(),
				lifelines);
		
		return new SetValueCommand(setRequest);
	}

}
