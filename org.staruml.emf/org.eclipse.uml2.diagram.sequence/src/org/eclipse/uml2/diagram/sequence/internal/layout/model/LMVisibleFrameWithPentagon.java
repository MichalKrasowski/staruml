package org.eclipse.uml2.diagram.sequence.internal.layout.model;

import org.eclipse.uml2.diagram.sequence.internal.layout.GeometryConstants;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsElementPropertyAccess;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsNode;


/**
 * 
 */
public abstract class LMVisibleFrameWithPentagon extends LMFrame {
    LMVisibleFrameWithPentagon(AbsNode gdeNode) {
		super(gdeNode);
        myPentagonLayouter = AbsElementPropertyAccess.getInstance().getPentagonLayouter(gdeNode);
	}
    
    public interface PentagonLayouter {
        int getPreferredWidth();
        int getPreferredHeight();
        void setX(int i);
        void setY(int i);
    }
	
	boolean hasVisibleMountingLinks() {
		return true;
	}
    
    public void setLeftBorderPosByTool(int pos) {
        int curX = getGdeNode().getX();
        int curWidth = getGdeNode().getWidth();
        int newX = pos;
        int newWidth = curWidth + curX - newX;
        setX(newX);
        setWidth(newWidth);
    }
    
    public void setRightBorderPosByTool(int pos) {
        setRightBorderPosByLayout(pos);
    }
	
	public void setLeftBorderPosByLayout(int pos) {
		setX(pos);
	}
    
	public void setRightBorderPosByLayout(int pos) {
		int curX = getGdeNode().getX();
		int newWidth = pos - curX;
		setWidth(newWidth);
		//System.out.println("[SDHorizontalLayout.layout] width="+gdeNode.getWidth());
		//System.out.println("[SDHorizontalLayout.layout] newWidth="+newWidth);
	}
	
	protected abstract int getPentagonOffset();
	
	protected void setX(int x) {
		super.setX(x);
        myPentagonLayouter.setX(x + getPentagonOffset());
	}
	protected void setWidth(int width) {
		super.setWidth(width);
	}
	
	public void setTopBorderPos(int pos) {
		super.setTopBorderPos(pos);
        myPentagonLayouter.setY(pos + getPentagonOffset());
	}
    
    public int getMinimumWidth() {
        return myPentagonLayouter.getPreferredWidth();
    }
    
    public int getPreferredWidth() {
        return myPentagonLayouter.getPreferredWidth();
    }
    public int getPreferredHeight() {
        return myPentagonLayouter.getPreferredHeight() + GeometryConstants.Frames.MINIMAL_SPACE_UNDER_PENTAGON;
    }
    
    final int getPentagonPreferredHeight() {
        return myPentagonLayouter.getPreferredHeight();
    }
    
    private final PentagonLayouter myPentagonLayouter;
}
