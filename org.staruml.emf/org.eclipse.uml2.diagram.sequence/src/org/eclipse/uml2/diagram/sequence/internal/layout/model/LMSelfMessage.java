package org.eclipse.uml2.diagram.sequence.internal.layout.model;

import java.awt.Point;

import org.eclipse.uml2.diagram.sequence.internal.layout.GeometryConstants;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsLink;
import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.input.LifeLineElement;
import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.input.OrderingConstraint;


/**
 * 
 */
public class LMSelfMessage extends LMMessage {
	LMSelfMessage(AbsLink gdeLink, boolean isFromSendToReceive, boolean isAsynchronous) {
		super(gdeLink);
		myIsFromSendToReceive = isFromSendToReceive;
        myIsAsynchronous = isAsynchronous;
	}
	
	boolean isFromSendToReceive() {
		return myIsFromSendToReceive;
	}
    
    boolean isAsynchronous() {
        return myIsAsynchronous;
    }
	
	public void layoutHorizontally(boolean fullLayout) {
        
        Point [] newPoints = getHorizontalLayout(fullLayout); 

		getGdeLink().setLinkPoints(newPoints);
		
        int startXPos = newPoints[0].x;
		MessageLabelLayouter.layoutMessageLabelsHorizontally(getGdeLink(), startXPos, startXPos + 1, fullLayout);
	}
    
    public Point [] getHorizontalLayout(boolean fullLayout) {
        int startXPos = mySendHorizontalPositioning.getSendEndXPos(true);  
        int endXPos = myReceiveHorizontalPositioning.getReceiveEndXPos(true);
        //Reply message start and end points should be swapped
        if (! isFromSendToReceive()) {
            int t = startXPos;
            startXPos = endXPos;
            endXPos = t;
        }

        Point [] linkPoints = getGdeLink().getLinkPoints();
        
        Point [] newPoints = { 
                getPointFromArray(linkPoints, 0), 
                getPointFromArray(linkPoints, 1), 
                getPointFromArray(linkPoints, -2), 
                getPointFromArray(linkPoints, -1), 
            };
        
        
        int xPosMin = (startXPos > endXPos ? startXPos : endXPos) +  + GeometryConstants.Message.SELF_MESSAGE_HORIZONTAL_INDENT;
        
        if (isFromSendToReceive()) {
            xPosMin += GeometryConstants.Message.SELF_RETURN_MESSAGE_HORIZONTAL_OFFSET;
        }
        
        int xPosMax = xPosMin + GeometryConstants.Message.SELF_MESSAGE_HORIZONTAL_RANGE;

        int middleSegmentX;
        if (fullLayout) {
            middleSegmentX = 0;
        } else {
            middleSegmentX = getPointFromArray(linkPoints, 1).x;
        }
        
        if (middleSegmentX < xPosMin) {
            middleSegmentX = xPosMin;
        }
        if (middleSegmentX > xPosMax) {
            middleSegmentX = xPosMax;
        }
        
        newPoints[0].x = startXPos;
        newPoints[1].x = middleSegmentX; 
        newPoints[2].x = middleSegmentX;
        newPoints[3].x = endXPos; 

        return newPoints;
    }

	void setLMMessageEndVerticalPosition(int pos, boolean sourceNotDestination, int siblingNumber) {
		//new Exception("pos="+pos).printStackTrace(System.out);
		Point [] linkPoints = getGdeLink().getLinkPoints();
		
		Point [] newPoints = { 
				getPointFromArray(linkPoints, 0), 
				getPointFromArray(linkPoints, 1), 
				getPointFromArray(linkPoints, -2), 
				getPointFromArray(linkPoints, -1), 
			};
		
                
        boolean changeSourceNotDestinaction = sourceNotDestination ^ !isFromSendToReceive();
        if (myIsAsynchronous) {
            int slopeSign = isFromSendToReceive() ? 1 : -1;
            if (changeSourceNotDestinaction) {
                newPoints[0].y = pos;
                newPoints[1].y = pos + slopeSign * GeometryConstants.Message.ASYNCHRONOUS_SELF_MESSAGE_VERTICAL_SLOPE; 
            } else {
                newPoints[2].y = pos - slopeSign * GeometryConstants.Message.ASYNCHRONOUS_SELF_MESSAGE_VERTICAL_SLOPE; 
                newPoints[3].y = pos; 
            }
        } else {   
            if (changeSourceNotDestinaction) {
                newPoints[0].y = pos;
                newPoints[1].y = pos; 
            } else {
                newPoints[2].y = pos; 
                newPoints[3].y = pos; 
            }
        }
        

		getGdeLink().setLinkPoints(newPoints);
		//System.out.println("[LMLifeLineBracket.setLMMessageEndVerticalPosition] from "+java.util.Arrays.asList(linkPoints)+" to "+java.util.Arrays.asList(newPoints));

        if (sourceNotDestination) {
        //if (! sourceNotDestination ^ isFromSendToReceive()) {
			
			MessageLabelLayouter.layoutMessageLabelsVertically(getGdeLink(), pos);
		}
		
	}
	
	private Point getPointFromArray(Point [] points, int index) {
		if (points == null || points.length == 0) {
			return new Point();
		} else {
			Point foundPoint;
			if (index >= 0) {
				int halfIndex = (points.length-1) / 2;
				if (index > halfIndex) {
					index = halfIndex;
				}
				foundPoint = points[index];
			} else {
				int halfIndex = points.length / 2;
				index = points.length + index;
				if (index < halfIndex) {
					index = halfIndex;
				}
				foundPoint = points[index];
			}
			if (foundPoint == null) {
				return new Point();
			} else {
				return new Point(foundPoint);
			}
		}
		
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
    
    void becomeLayoutConstraint(boolean on) {
        
        if (! (myIsAsynchronous && myIsFromSendToReceive) ) {
            return;
        }
        
        final LMMessageEnd.ConnectableLifeLineElement sendElement = mySendVerticalPositioning.getTopLifeLineElement();
        final LMMessageEnd.ConnectableLifeLineElement receiveElement = myReceiveVerticalPositioning.getTopLifeLineElement();
        
        if (on) {
            myOrderingConstraint = new OrderingConstraint() {
                public LifeLineElement getBeforeElement() {
                    return sendElement; 
                }

                public LifeLineElement getAfterElement() {
                    return receiveElement; 
                }

                public void setInvalid(boolean invalid) {
                    LMSelfMessage.this.setVerticalConstraintViolationState(invalid);
                }

                public int getMinSlopeValue() {
                    return GeometryConstants.Message.MIN_ASYNCHRONOUS_SLOPE_VALUE;
                }
            };
            
            sendElement.addAfterConstraint(myOrderingConstraint); 
            receiveElement.addBeforeConstraint(myOrderingConstraint); 
        } else {
            sendElement.removeAfterConstraint(myOrderingConstraint); 
            receiveElement.removeBeforeConstraint(myOrderingConstraint);
            myOrderingConstraint = null;
        }
    }

    boolean isLayoutConstraint() {
        return myOrderingConstraint != null;
    }
    
    protected boolean calculateIsMessageViolated() {
        return myIsVerticalConstraintViolated || super.calculateIsMessageViolated();
    }
    
    protected void setVerticalConstraintViolationState(boolean violated) {
        myIsVerticalConstraintViolated = violated;
        updateMessageViolationState();
    }    
    
    
	private final boolean myIsFromSendToReceive;
    private final boolean myIsAsynchronous;
	private LMReceiveMessageEnd myReceiveMessageEnd;
	private LMSendMessageEnd mySendMessageEnd;
    private LMMessageEnd.VerticalConstraintedPositioning mySendVerticalPositioning;
    private LMMessageEnd.VerticalConstraintedPositioning myReceiveVerticalPositioning;
    private LMSendMessageEnd.HorizontalPositioning mySendHorizontalPositioning;
    private LMReceiveMessageEnd.HorizontalPositioning myReceiveHorizontalPositioning;
    private OrderingConstraint myOrderingConstraint = null;
    private boolean myIsVerticalConstraintViolated;
}
