package org.eclipse.uml2.diagram.sequence.edit.create;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.uml2.diagram.sequence.edit.helpers.CoveredLifelineConfigurer;
import org.eclipse.uml2.diagram.sequence.edit.policies.InteractionNestedLayoutRequest;
import org.eclipse.uml2.diagram.sequence.providers.UMLElementTypes;


public class CreateStateInvariantEditPolicy extends AbstractCreateSDElementEditPolicy {
	
	@Override
	public boolean understandsRequest(Request req) {
		if (req instanceof CreateStateInvariantRequest){
			return true;
		}	
		return super.understandsRequest(req);
	}
	
	@Override
	public Command getCommand(Request request) {
		if (request instanceof CreateStateInvariantRequest){
			return createStateInvariant((CreateStateInvariantRequest)request);
		}
		return super.getCommand(request);
	}
	
	protected Command createStateInvariant(CreateStateInvariantRequest request){
		GraphicalEditPart bracketEP = getHostImpl();
		CoveredLifelineConfigurer.setCoveredLifeLines(request, findLifeLineEditPart(bracketEP));
		Helper helper = getHelper(request);
		CreateViewAndElementRequest semanticAndNodeInFrameRequest = helper.createNodeAndElement(UMLElementTypes.StateInvariant_3003);
		Command semanticAndNodeInFrameCommand = bracketEP.getCommand(semanticAndNodeInFrameRequest);
		if (!isValid(semanticAndNodeInFrameCommand)){
			return UnexecutableCommand.INSTANCE;
		}
		return postScheduleLayout(semanticAndNodeInFrameCommand, getLayoutCommand(new InteractionNestedLayoutRequest()));
	}
		
}
