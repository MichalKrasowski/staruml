package org.eclipse.uml2.diagram.sequence.internal.layout.vertical.input;

import java.util.Enumeration;

/**
 * 
 */
public interface LifeLineElement {
    void optimizeSize();
    
	int getPointOffset();
	int getSize();

	HorizontalConstraint getHorizontalConstraint();

	Enumeration<OrderingConstraint> beforeConstraints();
	Enumeration<OrderingConstraint> afterConstraints();

    LifeLine getLifeLine();

    Position getPosition();

    interface Position {
		int getPositionValue();
		void setPositionValue(int pos);
	    
	    /**
	     * Virtual position means, that after setting its value, get value may
	     * return some other number. E.g. fake lifeline is used to stretch other
	     * lifelines 300 pixels minimum, but it never save its own positions 
	     */
	    boolean isVirtual();

	    boolean isFirstPrioritedPosition();
	    boolean isLastPrioritedPosition();
	}
}
