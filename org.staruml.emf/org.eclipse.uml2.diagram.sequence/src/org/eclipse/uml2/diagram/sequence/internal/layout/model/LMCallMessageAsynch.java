package org.eclipse.uml2.diagram.sequence.internal.layout.model;

import org.eclipse.uml2.diagram.sequence.internal.layout.GeometryConstants;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsElementPropertyAccess;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsLink;
import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.input.LifeLineElement;
import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.input.OrderingConstraint;


/**
 * 
 */
public class LMCallMessageAsynch extends LMCallMessage {
	public LMCallMessageAsynch(AbsLink gdeLink) {
		super(gdeLink);
	}

	void becomeLayoutConstraint(boolean on) {
		final LMMessageEnd.ConnectableLifeLineElement sendElement = getSendVerticalPositioning().getTopLifeLineElement();
		final LMMessageEnd.ConnectableLifeLineElement receiveElement = getReceiveVerticalPositioning().getTopLifeLineElement();
		
		if (on) {
			myOrderingConstraint = new OrderingConstraint() {
				public LifeLineElement getBeforeElement() {
					return sendElement; 
				}

				public LifeLineElement getAfterElement() {
					return receiveElement; 
				}

				public void setInvalid(boolean invalid) {
					LMCallMessageAsynch.this.setVerticalConstraintViolationState(invalid);
				}

				public int getMinSlopeValue() {
                    if (AbsElementPropertyAccess.getInstance().canAsynchCallBeStraight(getGdeLink())) {
                        return 0;
                    }
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
	
	private OrderingConstraint myOrderingConstraint;
}