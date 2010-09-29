package org.eclipse.uml2.diagram.sequence.internal.layout.model;

import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsLink;

/**
 * 
 */
public abstract class LMCallMessage extends LMInterLifeLineMessage {
	public LMCallMessage(AbsLink gdeLink) {
		super(gdeLink);
	}

	boolean isFromSendToReceive() {
		return true;
	}
	
	LMSendMessageEnd getSendMessageEnd() {
		return mySendMessageEnd;
	}
	LMReceiveMessageEnd getReceiveMessageEnd() {
		return myReceiveMessageEnd;
	}
	protected void setSendMessageEnd(LMSendMessageEnd sendMessageEnd, LMMessageEnd.VerticalConstraintedPositioning sendVerticalPositioning, LMSendMessageEnd.HorizontalPositioning sendHorizontalPositioning) {
		mySendMessageEnd = sendMessageEnd;
		mySendVerticalPositioning = sendVerticalPositioning;
		mySendHorizontalPositioning = sendHorizontalPositioning;
        
        sourceOrDestinationChanged();
	}
	protected void setReceiveMessageEnd(LMReceiveMessageEnd receiveMessageEnd, LMMessageEnd.VerticalConstraintedPositioning receiveVerticalPositioning, LMReceiveMessageEnd.HorizontalPositioning receiveHorizontalPositioning) {
		myReceiveMessageEnd = receiveMessageEnd;
		myReceiveVerticalPositioning = receiveVerticalPositioning;
		myReceiveHorizontalPositioning = receiveHorizontalPositioning;
        
        sourceOrDestinationChanged();
	}
	void resetSendMessageEnd() {
		mySendMessageEnd = null;
		mySendVerticalPositioning = null;
		mySendHorizontalPositioning = null;
        
        sourceOrDestinationChanged();
	}
	void resetReceiveMessageEnd() {
		myReceiveMessageEnd = null;
		myReceiveVerticalPositioning = null;
		myReceiveHorizontalPositioning = null;
        
        sourceOrDestinationChanged();
	}
	
	protected LMMessageEnd.VerticalConstraintedPositioning getReceiveVerticalPositioning() {
		return myReceiveVerticalPositioning;
	}
	protected LMMessageEnd.VerticalConstraintedPositioning getSendVerticalPositioning() {
		return mySendVerticalPositioning;
	}
	
	protected LMSendMessageEnd.HorizontalPositioning getSendMessageHorizontalPositioning() {
		return mySendHorizontalPositioning;
	}
	protected LMReceiveMessageEnd.HorizontalPositioning getReceiveMessageHorizontalPositioning() {
		return myReceiveHorizontalPositioning;
	}
    protected int getReceiveEndXPos(boolean toRightNotLeft) {
        return myReceiveHorizontalPositioning.getReceiveEndXPos(toRightNotLeft);
    }
	
	private LMReceiveMessageEnd myReceiveMessageEnd;
	private LMSendMessageEnd mySendMessageEnd;
	private LMMessageEnd.VerticalConstraintedPositioning mySendVerticalPositioning;
	private LMMessageEnd.VerticalConstraintedPositioning myReceiveVerticalPositioning;
	private LMSendMessageEnd.HorizontalPositioning mySendHorizontalPositioning;
	private LMReceiveMessageEnd.HorizontalPositioning myReceiveHorizontalPositioning;
}
