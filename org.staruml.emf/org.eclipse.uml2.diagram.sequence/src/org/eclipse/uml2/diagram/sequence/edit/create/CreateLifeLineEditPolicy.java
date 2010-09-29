package org.eclipse.uml2.diagram.sequence.edit.create;

import java.util.Collections;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeRequest;
import org.eclipse.uml2.diagram.sequence.edit.policies.InteractionNestedLayoutRequest;
import org.eclipse.uml2.diagram.sequence.providers.UMLElementTypes;


public class CreateLifeLineEditPolicy extends AbstractCreateSDElementEditPolicy {
	@Override
	public boolean understandsRequest(Request req) {
		if (req instanceof CreateLifeLineRequest){
			return true;
		}	
		return super.understandsRequest(req);
	}
	
	@Override
	public Command getCommand(Request request) {
		if (request instanceof CreateLifeLineRequest){
			return createLifeLine((CreateLifeLineRequest) request);
		}
		return super.getCommand(request);
	}
	
	protected Command createLifeLine(CreateLifeLineRequest request){
		GraphicalEditPart frameEP = getHostImpl();

		CreateUnspecifiedTypeRequest createRequest = new CreateUnspecifiedTypeRequest(Collections.singletonList(UMLElementTypes.Lifeline_3001), getPreferencesHint());
		createRequest.setExtendedData(request.getExtendedData());
		createRequest.setLocation(request.getLocation());
		createRequest.setSize(request.getSize());
		Command creation = frameEP.getCommand(createRequest);
		if (!isValid(creation)){
			return creation;
		}
		InteractionNestedLayoutRequest layoutRequest = new InteractionNestedLayoutRequest();
		Command layoutCommand = getLayoutCommand(layoutRequest);
		
		return postScheduleLayout(creation, layoutCommand);
	}
	
}
