package org.eclipse.uml2.diagram.common.editpolicies;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.AbstractEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.common.genapi.IDiagramUpdater;

public class UpdateDescriptionEditPolicy extends AbstractEditPolicy {
	public static final String ROLE = UpdateDescriptionEditPolicy.class.getName();
	private final IDiagramUpdater myUpdater;
	private final boolean myRegisterSemanticElement;
	
	public UpdateDescriptionEditPolicy(IDiagramUpdater updater, boolean registerSemanticElement){
		myUpdater = updater;
		myRegisterSemanticElement = registerSemanticElement;
	}

	@Override
	public boolean understandsRequest(Request req) {
		return UpdateDescriptionRequest.TYPE.equals(req.getType());
	}

	@Override
	public Command getCommand(Request request) {
		//as it is common among GMF edit-policies, we are not going to make a command, 
		//purpose of this request is fill the request with data
		if (understandsRequest(request)) {
			describeUpdate((UpdateDescriptionRequest) request);
			redirectToChildren(request);
			return COMMAND;
		}
		return super.getCommand(request);
	}
	
	protected final IGraphicalEditPart getHostImpl() {
		return (IGraphicalEditPart)getHost();
	}

	protected void describeUpdate(UpdateDescriptionRequest request){
		UpdateDescriptionRequest.Descriptor desc = request.registerDescription(getHostImpl(), myRegisterSemanticElement);
		View view = getHostImpl().getNotationView();
		
		desc.addContainedChildren(myUpdater.getSemanticChildren(view));
		desc.addContainedLinks(myUpdater.getContainedLinks(view));
		desc.addOutgoingLinks(myUpdater.getOutgoingLinks(view));
	}

	private void redirectToChildren(Request request) {
		for (Object next : getHost().getChildren()) {
			EditPart nextEP = (EditPart) next;
			nextEP.getCommand(request); //we are not interested in result
		}
	}
	
	private static final Command COMMAND = new Command() {
	};
}
