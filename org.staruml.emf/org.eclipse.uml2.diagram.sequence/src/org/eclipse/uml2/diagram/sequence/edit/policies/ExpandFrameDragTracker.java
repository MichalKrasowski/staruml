package org.eclipse.uml2.diagram.sequence.edit.policies;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;


public class ExpandFrameDragTracker extends org.eclipse.gef.tools.DragEditPartsTracker { 
    private final IFigure myHandle;
    private final int myExpandDirection;
    
    public ExpandFrameDragTracker(GraphicalEditPart owner, int expandDirection, IFigure handle) {
        super(owner);
        myHandle = handle;
        myExpandDirection = expandDirection;
    }
    
    public void activate() {
        super.activate();
        myHandle.setVisible(false);
    }
    public void deactivate() {
        myHandle.setVisible(true);
        super.deactivate();
    }
    
    protected Request createTargetRequest() {
        TieFrameRequest request = new TieFrameRequest(this);
        request.setResizeDirection(myExpandDirection);
        return request;
    }
    
    protected String getCommandName() {
        return TieFrameRequest.REQ_TYPE;
    }
    
    protected Command getCommand() {
    	System.out.println("ExpandFrameDragTracker.getCommand(): STARTED");
        EditPart editPart = getTargetEditPart();
        if (editPart == getSourceEditPart()){
        	return null;
        }
        if (!(editPart instanceof GraphicalEditPart)) {
            return null;
        }
        
        System.out.println("ExpandFrameDragTracker.getCommand(): OK-1");
        TieFrameRequest.Completed completedRequest = new TieFrameRequest.Completed((TieFrameRequest)getTargetRequest(), (GraphicalEditPart)getSourceEditPart());
        Command command = editPart.getCommand(completedRequest);
        System.out.println("ExpandFrameDragTracker.getCommand(): " + command);
        return command;
    }
    
    @Override
    protected void setTargetEditPart(EditPart editpart) {
    	super.setTargetEditPart(editpart);
    }
    
}
