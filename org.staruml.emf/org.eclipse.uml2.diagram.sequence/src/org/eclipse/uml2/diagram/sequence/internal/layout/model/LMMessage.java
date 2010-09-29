package org.eclipse.uml2.diagram.sequence.internal.layout.model;

import java.awt.Color;
import java.awt.Point;

import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsLink;


/**
 * 
 */
public abstract class LMMessage implements LmReshapable {
	public LMMessage(AbsLink gdeLink) {
		myGdeLink = gdeLink;
	}
	
	abstract LMReceiveMessageEnd getReceiveMessageEnd();
	abstract LMSendMessageEnd getSendMessageEnd();
	
	abstract void resetReceiveMessageEnd();
	abstract void resetSendMessageEnd();
	
	AbsLink getGdeLink() {
		return myGdeLink;
	}
	
	abstract boolean isFromSendToReceive();

	public abstract void layoutHorizontally(boolean fullLayout);

    abstract void becomeLayoutConstraint(boolean on);
    abstract boolean isLayoutConstraint();
    

    
    
    public void setJustReshaped(JustReshapedState justReshapedState) {
        getSendMessageEnd().messageIsJustReshaped(this, justReshapedState);
        getReceiveMessageEnd().messageIsJustReshaped(this, justReshapedState);
	}

	/**
	 * @param siblingNumber normally should be 0. Still can be 1, 2 etc on bad diagrams
	 */
	abstract void setLMMessageEndVerticalPosition(int pos, boolean sourceNotDestination, int siblingNumber);
    
    int getLMMessageEndVerticalPosition(boolean sourceNotDestination) {
        Point [] linkPoints = getGdeLink().getLinkPoints();
        if (linkPoints.length < 1) {
            throw new RuntimeException("Bad link positions"); //$NON-NLS-1$
        }
        if (sourceNotDestination) {
            return linkPoints[0].y;
        } else {
            return linkPoints[linkPoints.length-1].y;
        }
    }

    /**
     * Invoked, when layout model is build. 
     */
    protected boolean calculateIsMessageViolated() {
        if (!myMessageIsCrossFramedCalculated) {
            LMFrame sourceFrame = getMessageEndFrame(getSendMessageEnd());
            LMFrame destinationFrame = getMessageEndFrame(getReceiveMessageEnd());
            
            myMessageIsCrossFramed = sourceFrame != destinationFrame;
            myMessageIsCrossFramedCalculated = true;
        }
        return myMessageIsCrossFramed;
    }
    
    protected void sourceOrDestinationChanged() {
        myMessageIsCrossFramedCalculated = false;
    }
    
    protected void updateMessageViolationState() {
        boolean violated = calculateIsMessageViolated();
        
        if (myHasColorBeforeViolated == null && violated) {
            myHasColorBeforeViolated = getGdeLink().getForeground();
            getGdeLink().setForeground(Color.RED);
        } else if (myHasColorBeforeViolated != null && !violated) {
            getGdeLink().setForeground(myHasColorBeforeViolated);
            myHasColorBeforeViolated = null;
        }
    }
    
    private Color myHasColorBeforeViolated;

	private final AbsLink myGdeLink;
    private boolean myMessageIsCrossFramed;
    private boolean myMessageIsCrossFramedCalculated = false;
    
    private static LMFrame getMessageEndFrame(LMMessageEnd messageEnd) {
        if (messageEnd == null) {
            return null;
        }
        return messageEnd.getContainingFrame();
    }
}
