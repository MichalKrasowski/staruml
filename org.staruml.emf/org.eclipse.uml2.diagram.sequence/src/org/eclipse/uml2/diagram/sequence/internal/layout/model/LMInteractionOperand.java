package org.eclipse.uml2.diagram.sequence.internal.layout.model;

import org.eclipse.uml2.diagram.sequence.internal.layout.GeometryConstants;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsElementPropertyAccess;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsNode;


/**
 * 
 */
public class LMInteractionOperand extends LMFrame {
    LMInteractionOperand(AbsNode gdeNode) {
		super(gdeNode);
		//String debugText = (String) gdeNode.getProperty("hello");
		//if (debugText == null) {
		//	throw new RuntimeException("Cannot find debug property in "+gdeNode);
		//}
        myDelimitLineLayouter = AbsElementPropertyAccess.getInstance().getDelimitLineLayouter(gdeNode);
	}
	
    public interface DelimitLineLayouter {
        void setX(int x);
        void setY(int pos);
        void setHeight(int height);
        void setWidth(int width);
    }
    
	public int getInnerHorizontalPadding() {
		return GeometryConstants.Frames.INTERATCTION_OPERAND_INNER_SPACE_HORIZONTAL;
	}
	public int getOuterHorizontalPadding() {
		return 0;
	}
    
	boolean hasVisibleMountingLinks() {
		return false;
	}
    
    public void setLeftBorderPosByTool(int pos) {
        // CombinedFragment should manage my position
    }
    public void setRightBorderPosByTool(int pos) {
        // CombinedFragment should manage my position
    }
    
	public void setLeftBorderPosByLayout(int pos) {
		// CombinedFragment should manage my position
	}
	public void setRightBorderPosByLayout(int pos) {
		// CombinedFragment should manage my position
	}
	
	protected void setWidth(int width) {
		super.setWidth(width);
		myDelimitLineLayouter.setWidth(width);
		//System.out.println("[LMInteractionOperand.setTopBorderPos] x="+myDelimitLineGdeNode.getX()+", width="+myDelimitLineGdeNode.getWidth()+", y="+myDelimitLineGdeNode.getY()+", height="+myDelimitLineGdeNode.getHeight());
	}
	protected void setX(int x) {
		super.setX(x);
		myDelimitLineLayouter.setX(x);
	}
	
	public void setTopBorderPos(int pos) {
		if (isFirst()) {
            myDelimitLineLayouter.setHeight(0);
		} else {
            myDelimitLineLayouter.setHeight(1);
		}
        super.setTopBorderPos(pos);
        myDelimitLineLayouter.setY(pos);
	}
    
    private boolean isFirst() {
        return getContainer().getChildList().get(0) == this;
    }
    
    private final DelimitLineLayouter myDelimitLineLayouter;
}
