package org.eclipse.uml2.diagram.sequence.internal.layout.model;

import java.awt.Point;

import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsLink;

/**
 * 
 */
public abstract class LMInterLifeLineMessage extends LMMessage {
	public LMInterLifeLineMessage(AbsLink gdeLink) {
		super(gdeLink);
	}
	
	public void layoutHorizontally(boolean fullLayout) {
		int startMiddleXPos = getSendMessageHorizontalPositioning().getSendMiddleXPos();  
		int endMiddleXPos = getReceiveMessageHorizontalPositioning().getReceiveMiddleXPos();
		
		boolean fromLeftToRight = startMiddleXPos < endMiddleXPos;
		
		int startXPos = getSendMessageHorizontalPositioning().getSendEndXPos(fromLeftToRight);
        //CR #27330
		//int endXPos = getReceiveMessageHorizontalPositioning().getReceiveEndXPos(!fromLeftToRight);
        int endXPos = getReceiveEndXPos(!fromLeftToRight);
        //Reply message start and end points should be swapped
        if (! isFromSendToReceive()) {
            int t = startXPos;
            startXPos = endXPos;
            endXPos = t;
        }
		
		Point [] linkPoints = getGdeLink().getLinkPoints();
		int startYPos;
		int endYPos;

		if (linkPoints.length < 1) {
			startYPos = 0;
			endYPos = 0;
		} else {
			startYPos = linkPoints[0].y;
			endYPos = linkPoints[linkPoints.length-1].y;
		}
		
		Point [] newPoints = { new Point(startXPos, startYPos), new Point(endXPos, endYPos) };
        

		//System.out.println("[LMLifeLineBracket.setLMMessageEndHorizontalPosition] from "+java.util.Arrays.asList(linkPoints)+" to "+java.util.Arrays.asList(newPoints));
		getGdeLink().setLinkPoints(newPoints);
		
        if (isFromSendToReceive()) {
            MessageLabelLayouter.layoutMessageLabelsHorizontally(getGdeLink(), startXPos, endXPos, fullLayout);
        } else {
            MessageLabelLayouter.layoutMessageLabelsHorizontally(getGdeLink(), endXPos, startXPos, fullLayout);
            
        }
	}
    

    void setLMMessageEndVerticalPosition(int pos, boolean sourceNotDestination, int siblingNumber) {
		//new Exception("pos="+pos).printStackTrace(System.out);
		Point [] linkPoints = getGdeLink().getLinkPoints();
		Point [] newPoints = new Point [2];
		
		if (linkPoints.length<2) {
			linkPoints = new Point [] { new Point(pos, pos) };
		}
        
        boolean changeSourceNotDestinaction = sourceNotDestination ^ !isFromSendToReceive();
		if (changeSourceNotDestinaction) {
			newPoints[1] = linkPoints[linkPoints.length-1];
			newPoints[0] = new Point(linkPoints[0].x, pos);
		} else {
			newPoints[0] = linkPoints[0];
			newPoints[1] = new Point(linkPoints[linkPoints.length-1].x, pos);
		}
        
		getGdeLink().setLinkPoints(newPoints);
		//System.out.println("[LMLifeLineBracket.setLMMessageEndVerticalPosition] from "+java.util.Arrays.asList(linkPoints)+" to "+java.util.Arrays.asList(newPoints));
		
		if (sourceNotDestination) {
			MessageLabelLayouter.layoutMessageLabelsVertically(getGdeLink(), pos);
		}
	}
    
    public Point[] getPoints() {
        return getGdeLink().getLinkPoints();
    }
    
    
    protected boolean calculateIsMessageViolated() {
        return myIsVerticalConstraintViolated || super.calculateIsMessageViolated();
    }
    
    protected void setVerticalConstraintViolationState(boolean violated) {
        myIsVerticalConstraintViolated = violated;
        updateMessageViolationState();
    }    
    
	protected abstract LMSendMessageEnd.HorizontalPositioning getSendMessageHorizontalPositioning();
	protected abstract LMReceiveMessageEnd.HorizontalPositioning getReceiveMessageHorizontalPositioning();
    protected abstract int getReceiveEndXPos(boolean toRightNotLeft);

    
    private boolean myIsVerticalConstraintViolated;
}
