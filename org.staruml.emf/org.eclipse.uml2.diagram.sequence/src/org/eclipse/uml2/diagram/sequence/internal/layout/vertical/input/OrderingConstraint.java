package org.eclipse.uml2.diagram.sequence.internal.layout.vertical.input;

/**
 * 
 */
public interface OrderingConstraint {
	LifeLineElement getBeforeElement();
	LifeLineElement getAfterElement();
	
	int getMinSlopeValue();
	
	/**
	 * Layout calls this method once for every constraint during layout session
	 */
	void setInvalid(boolean invalid);
}
