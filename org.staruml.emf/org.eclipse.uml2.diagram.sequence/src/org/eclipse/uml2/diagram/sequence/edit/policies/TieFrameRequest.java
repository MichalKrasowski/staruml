package org.eclipse.uml2.diagram.sequence.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.uml2.diagram.sequence.edit.create.CreateSDElementRequest;

/**
 * @author Michael Golubev
 */
public class TieFrameRequest extends ChangeBoundsRequest {
    static final String REQ_TYPE = "tie frame"; //$NON-NLS-1$
    
    public TieFrameRequest(ExpandFrameDragTracker tracker) {
        super(REQ_TYPE);
        myTracker = tracker;
    }
    
    /*
     * Allows TieFrameTargetEditPolicy to use
     * FrameResizeEditPolicy.ExpandFrameDragTracker to evaluate
     * tie command and not to do the same job once again.
     */
    Command getCurrentCommandByTool() {
        return myTracker.getCommand();
    }

    private final ExpandFrameDragTracker myTracker;
    
    public static class Completed extends CreateSDElementRequest {
    	private final GraphicalEditPart mySubjectFrameEP;
		private final TieFrameRequest myOriginalTieRequest;

		public Completed(TieFrameRequest originalTieRequest, GraphicalEditPart subjectFrameEP){
			super(subjectFrameEP.getDiagramPreferencesHint());
			myOriginalTieRequest = originalTieRequest;
			mySubjectFrameEP = subjectFrameEP;
			setLocation(originalTieRequest.getLocation());
			setExtendedData(originalTieRequest.getExtendedData());
    	}
		
		public GraphicalEditPart getSubjectFrameEditPart() {
			return mySubjectFrameEP;
		}
		
		public TieFrameRequest getOriginalTieRequest() {
			return myOriginalTieRequest;
		}
    }
}
