package org.eclipse.uml2.diagram.sequence.internal.layout.horizontal;

/**
 * I.e. space for frames of combined fragments
 * 
 */
interface LifeLineDress {
	int getLeftMinSpace();
	int getRightMinSpace();

    void setMinLeftAndCenter(int minLeft, int center);
    void setMaxRight(int center, int maxRight);
    
	void layout(int center);
}