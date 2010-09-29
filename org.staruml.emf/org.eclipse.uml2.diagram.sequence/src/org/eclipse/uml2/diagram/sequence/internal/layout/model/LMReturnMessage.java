package org.eclipse.uml2.diagram.sequence.internal.layout.model;

import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsLink;

/**
 * 
 */
public class LMReturnMessage extends LMInterLifeLineMessage {
	public LMReturnMessage(AbsLink gdeLink, boolean isAsynchronous) {
		super(gdeLink);
		myIsAsynchronous = isAsynchronous;
	}
    
	boolean isFromSendToReceive() {
		return false;
	}
	
	LMReceiveMessageEnd getReceiveMessageEnd() {
		return myReceiveMessageEnd;
	}
	protected void setReceiveMessageEnd(LMReceiveMessageEnd receiveMessageEnd, LMReceiveMessageEnd.HorizontalPositioning receiveEndPositioning) {
		myReceiveMessageEnd = receiveMessageEnd;
		myReceivePositioning = receiveEndPositioning;
        
        sourceOrDestinationChanged();
	}
	LMSendMessageEnd getSendMessageEnd() {
		return mySendMessageEnd;
	}
	protected void setSendMessageEnd(LMSendMessageEnd sendMessageEnd, LMSendMessageEnd.HorizontalPositioning sendEndPositioning) {
		mySendMessageEnd = sendMessageEnd;
		mySendPositioning = sendEndPositioning;
        
        sourceOrDestinationChanged();
	}
    
	protected LMSendMessageEnd.HorizontalPositioning getSendMessageHorizontalPositioning() {
		return mySendPositioning;
	}

	protected LMReceiveMessageEnd.HorizontalPositioning getReceiveMessageHorizontalPositioning() {
		return myReceivePositioning;
	}
    protected int getReceiveEndXPos(boolean toRightNotLeft) {
        if (myIsAsynchronous) {
            return myReceivePositioning.getReceiveEndXPos(toRightNotLeft);
        }
        return myReceivePositioning.getReceiveEndXPosForSynchReturnNotCallLink(toRightNotLeft);
    }
    
	void resetSendMessageEnd() {
		mySendMessageEnd = null;
		mySendPositioning = null;
        
        sourceOrDestinationChanged();
	}
	void resetReceiveMessageEnd() {
		myReceiveMessageEnd = null;
		myReceivePositioning = null;
        
        sourceOrDestinationChanged();
	}
	boolean isAsynchronous() {
		return myIsAsynchronous;
	}
    void becomeLayoutConstraint(boolean on) {
    }

    boolean isLayoutConstraint() {
        return false;
    }

	private LMReceiveMessageEnd myReceiveMessageEnd;
	private LMSendMessageEnd mySendMessageEnd;
	private LMSendMessageEnd.HorizontalPositioning mySendPositioning;
	private LMReceiveMessageEnd.HorizontalPositioning myReceivePositioning;
	private final boolean myIsAsynchronous;
}
