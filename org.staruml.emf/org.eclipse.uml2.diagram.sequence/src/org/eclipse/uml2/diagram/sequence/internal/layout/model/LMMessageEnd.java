package org.eclipse.uml2.diagram.sequence.internal.layout.model;

import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.input.LifeLineElement;
import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.input.OrderingConstraint;

/**
 * 
 */
public interface LMMessageEnd {
	void addMessage(LMMessage lmMessage);
	void removeMessage(LMMessage lmMessage);
	
	
    void messageIsJustReshaped(LMMessage lmMessage, JustReshapedState justReshapedState);

    LMFrame getContainingFrame();
    
	Positioning getPositioning();
    
	interface Positioning {
	}
	
	interface OnLifeLinePositioning extends Positioning {
		LMLifeLine getLifeLine();
	}
	
	interface ConnectableLifeLineElement extends LifeLineElement {
		void addBeforeConstraint(OrderingConstraint orderingConstraint);
		void removeBeforeConstraint(OrderingConstraint orderingConstraint);
		void addAfterConstraint(OrderingConstraint orderingConstraint);
		void removeAfterConstraint(OrderingConstraint orderingConstraint);
	}
	
	interface VerticalConstraintedPositioning extends OnLifeLinePositioning {
		boolean canSetMessageAsHorizontalConstraint(LMCallMessageSynch lmCallMessageSynch);
		void setMessageAsHorizontalConstraint(LMCallMessageSynch lmCallMessageSynch, boolean isConstraint);
		boolean hasMessageAsHorizontalConstraint(LMCallMessageSynch lmCallMessageSynch);
		
		ConnectableLifeLineElement getTopLifeLineElement();
		/**
		 * @return may be null (i.e. this end is not aligned by (invisible ) return link)
		 */
		LifeLineElement getBottomLifeLineElement();
	}
	
	interface FloatingPositioning extends Positioning {
		int getXPos();
		void setXPos(int xPos);
		void setYPos(int yPos);
	}
}
