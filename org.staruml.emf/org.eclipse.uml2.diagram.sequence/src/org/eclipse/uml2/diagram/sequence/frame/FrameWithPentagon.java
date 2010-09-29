package org.eclipse.uml2.diagram.sequence.frame;

import org.eclipse.uml2.diagram.sequence.figures.Pentagon;
import org.eclipse.uml2.diagram.sequence.internal.layout.model.LMVisibleFrameWithPentagon;


public class FrameWithPentagon extends Frame {
	private Pentagon myPentagon;
	
	public FrameWithPentagon(){
        myPentagon = new Pentagon();
        myPentagon.setEnablePentagonLayouter(false);
        add(myPentagon); //added while there are no layout set yet
	}
	
     public LMVisibleFrameWithPentagon.PentagonLayouter getPentagonLayouter() {
		return myPentagon;
	}
	
	protected Pentagon getPentagon(){
		return myPentagon;
	}
	
	 
	public int getPreferredWidth() {
	    return getPreferredSize().width;
	}
	
	public int getPreferredHeight() {
	    return getPreferredSize().height;
	}
	
	
}
