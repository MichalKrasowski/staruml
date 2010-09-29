package org.eclipse.uml2.diagram.sequence.internal.layout.model;

import java.awt.Point;

import org.eclipse.uml2.diagram.sequence.internal.layout.GeometryConstants;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsLink;


/**
 * 
 */
class LMFoundMessage extends LMMessage {
	LMFoundMessage(AbsLink gdeLink, boolean isFromSendToReceive) {
		super(gdeLink);
		myIsFromSendToReceive = isFromSendToReceive;
	}

	boolean isFromSendToReceive() {
		return myIsFromSendToReceive;
	}

	public void layoutHorizontally(boolean fullLayout) {
		if (mySendPositioning == null) {
			throw new RuntimeException("No send message positioning"); //$NON-NLS-1$
		}
		if (myReceivePositioning == null) {
			throw new RuntimeException("No receive message positioning"); //$NON-NLS-1$
		}
		
        int endMiddleXPos = myReceivePositioning.getReceiveMiddleXPos();
        
        int startXPos;
        if (fullLayout) {
            startXPos = endMiddleXPos-GeometryConstants.Message.MIN_FOUND_MESSAGE_LENGTH;
        } else {
            startXPos = mySendPositioning.getXPos();
        }
		
		boolean goesFromRight = startXPos >= endMiddleXPos;
        int endXPos = myReceivePositioning.getReceiveEndXPos(goesFromRight);
        
		if (goesFromRight) {
            int limit1 = endMiddleXPos + GeometryConstants.Message.MIN_FOUND_MESSAGE_LENGTH;
            int limit2 = endMiddleXPos + GeometryConstants.Message.MAX_FOUND_MESSAGE_LENGTH;
            if (startXPos < limit1) {
                startXPos = limit1; 
            }
            if (startXPos > limit2) {
                startXPos = limit2; 
            }
        } else {
            int limit1 = endMiddleXPos - GeometryConstants.Message.MIN_FOUND_MESSAGE_LENGTH;
			int limit2 = endMiddleXPos - GeometryConstants.Message.MAX_FOUND_MESSAGE_LENGTH;
			if (startXPos > limit1) {
				startXPos = limit1; 
			}
			if (startXPos < limit2) {
				startXPos = limit2; 
			}
		}
        
		if (myIsFromSendToReceive) {
			mySendPositioning.setXPos(startXPos);
			startXPos = mySendPositioning.getXPos();
		}
		
        //Reply message start and end points should be swapped
        if (! myIsFromSendToReceive) {
            int t = startXPos;
            startXPos = endXPos;
            endXPos = t;
        }
        
		Point [] linkPoints = getGdeLink().getLinkPoints();
		int endYPos;

		if (linkPoints.length < 1) {
			endYPos = 0;
		} else {
			endYPos = linkPoints[linkPoints.length-1].y;
		}
		
		Point [] newPoints = { new Point(startXPos, endYPos), new Point(endXPos, endYPos) };

		//System.out.println("[LMLifeLineBracket.setLMMessageEndHorizontalPosition] from "+java.util.Arrays.asList(linkPoints)+" to "+java.util.Arrays.asList(newPoints));
		getGdeLink().setLinkPoints(newPoints);
		
		MessageLabelLayouter.layoutMessageLabelsHorizontally(getGdeLink(), startXPos, endXPos, fullLayout);
	}

	void setLMMessageEndVerticalPosition(int pos, boolean sourceNotDestination, int siblingNumber) {
		LMFoundInvocationOccurence foundInvocationOccurence = (LMFoundInvocationOccurence) getSendMessageEnd();
		if (foundInvocationOccurence == null) {
			throw new RuntimeException("No send message end"); //$NON-NLS-1$
		}
		
		LMReceiveMessageEnd receiveMessageEnd = getReceiveMessageEnd();
		if (receiveMessageEnd == null) {
			throw new RuntimeException("No receive message end"); //$NON-NLS-1$
		}
		
		Point [] linkPoints = getGdeLink().getLinkPoints();
		int startXPos;
		int endXPos;

		if (linkPoints.length < 1) {
			startXPos = 10;
			endXPos = 10;
		} else {
			startXPos = linkPoints[0].x;
			endXPos = linkPoints[linkPoints.length-1].x;
		}

		int receiveY = pos;
		int sendY = pos + siblingNumber * GeometryConstants.Message.FOUND_MESSAGE_SIBLING_VERTICAL_DISTANCE;
		
		Point [] newPoints = { new Point(startXPos, sendY), new Point(endXPos, receiveY) };

		//System.out.println("[LMLifeLineBracket.setLMMessageEndHorizontalPosition] from "+java.util.Arrays.asList(linkPoints)+" to "+java.util.Arrays.asList(newPoints));
		getGdeLink().setLinkPoints(newPoints);
		
		if (myIsFromSendToReceive) {
			mySendPositioning.setYPos(sendY);
		}
		
		MessageLabelLayouter.layoutMessageLabelsVertically(getGdeLink(), sendY);
	}
	LMSendMessageEnd getSendMessageEnd() {
		return mySendMessageEnd;
	}
	LMReceiveMessageEnd getReceiveMessageEnd() {
		return myReceiveMessageEnd;
	}

	protected void setSendMessageEnd(LMSendMessageEnd sendMessageEnd, LMMessageEnd.FloatingPositioning sendEndPositioning) {
		mySendMessageEnd = sendMessageEnd;
		mySendPositioning = sendEndPositioning;
        
        sourceOrDestinationChanged();
	}
	protected void setReceiveMessageEnd(LMReceiveMessageEnd receiveMessageEnd, LMReceiveMessageEnd.HorizontalPositioning receiveEndPositioning) {
		myReceiveMessageEnd = receiveMessageEnd;
		myReceivePositioning = receiveEndPositioning;
        
        sourceOrDestinationChanged();
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
    
    void becomeLayoutConstraint(boolean on) {
    }

    boolean isLayoutConstraint() {
        return false;
    }
    
	private LMReceiveMessageEnd myReceiveMessageEnd;
	private LMSendMessageEnd mySendMessageEnd;
	private LMMessageEnd.FloatingPositioning mySendPositioning;
	private LMReceiveMessageEnd.HorizontalPositioning myReceivePositioning;
	private final boolean myIsFromSendToReceive;
}
