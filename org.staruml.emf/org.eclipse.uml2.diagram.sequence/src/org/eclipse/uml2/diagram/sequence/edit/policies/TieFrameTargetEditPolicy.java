package org.eclipse.uml2.diagram.sequence.edit.policies;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.GraphicalEditPolicy;


public class TieFrameTargetEditPolicy extends GraphicalEditPolicy {
    public static final String ROLE = "TieFrameTargetEditPolicy"; //$NON-NLS-1$

    public TieFrameTargetEditPolicy () {
        myTargetFeedbackHelper = new TargetFeedbackHelper(this);
    }
    
    public Command getCommand(Request request) {
        if (request instanceof TieFrameRequest) {
            TieFrameRequest r = (TieFrameRequest)request;
            return r.getCurrentCommandByTool();
        }
        return null;
    }
    
    
    
    public void showTargetFeedback(Request request) {
        if (request instanceof TieFrameRequest) {
            myTargetFeedbackHelper.showFeedback(request);
        }
    }
    
    public void eraseTargetFeedback(Request request) {
        if (request instanceof TieFrameRequest) {
            myTargetFeedbackHelper.eraseFeedback();
        }
    }
    
    @Override
    public EditPart getTargetEditPart(Request request) {
    	if (understandsRequest(request)){
    		return getHost();
    	}
    	return super.getTargetEditPart(request);
    }

    public boolean understandsRequest(Request req) {
        return (req instanceof TieFrameRequest);
    }
    
    private final TargetFeedbackHelper myTargetFeedbackHelper;
}

