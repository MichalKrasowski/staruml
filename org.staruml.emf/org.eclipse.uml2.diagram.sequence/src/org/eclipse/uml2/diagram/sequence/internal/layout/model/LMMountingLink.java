package org.eclipse.uml2.diagram.sequence.internal.layout.model;

import java.awt.Color;
import java.awt.Point;

import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsLink;


/**
 * 
 */
public class LMMountingLink {
	LMMountingLink(AbsLink gdeLink) {
		myGdeLink = gdeLink;
	}
	
	AbsLink getGdeLink() {
		return myGdeLink;
	}
	
	public LMFrame getFrame() {
		return myFrame;
	}
	void setFrame(LMFrame frame) {
		myFrame = frame;
	}
	LMMountingRegion getMountingRegion() {
		return myMountingRegion;
	}
	void setMountingRegion(LMMountingRegion mountingRegion) {
		myMountingRegion = mountingRegion;
	}

	void setXPosition(int newPos) {
		Point firstOldPoint = getFirstLinkPoint();
		setLinkPoints(newPos, firstOldPoint.y);
	}
	
	void setFrameTopPosition(int pos) {
		if (mySavedValidColor == null && myFrame.tryToUseAsPositionResponsibleLink(this)) {
		    myFrame.setTopBorderPosFromMountingLink(pos);
		}
		
		Point firstOldPoint = getFirstLinkPoint();
		setLinkPoints(firstOldPoint.x, pos);
	}
	void setFrameBottomPosition(int pos) {
		if (mySavedValidColor != null) {
			// because we are invalid
			return;
		}
        if (! myFrame.tryToUseAsPositionResponsibleLink(this)) {
            return;
        }
		myFrame.setBottomBorderPos(pos);
	}
	private Point getFirstLinkPoint() {
		Point [] points = getGdeLink().getLinkPoints();
		if (points.length==0) {
			return new Point(0,0);
		} else {
			return points[0];
		}
	}
	private void setLinkPoints(int x, int y) {
		if (getFrame() instanceof LMVisibleFrameWithPentagon) {
			getGdeLink().setLinkPoints(new Point [] { new Point(x, y), new Point(x, y) } );
		}
//        else {
//			getGdeLink().setLinkPoints(new Point [] {} );
//		}
	}
    
	boolean isValid() {
        return mySavedValidColor == null;
    }
	
	void setInvalid(boolean invalid) {
		if (mySavedValidColor == null && invalid) {
			mySavedValidColor = myGdeLink.getForeground(); 
			myGdeLink.setForeground(Color.RED);
		} else if (mySavedValidColor != null && !invalid) {
			myGdeLink.setForeground(mySavedValidColor);
			mySavedValidColor = null;
		}
        
        if (! invalid) {
            myFrame.flushPositionResponsibleLink();
        }
	}
	private LMFrame myFrame;
	private LMMountingRegion myMountingRegion;
	private final AbsLink myGdeLink;
	private Color mySavedValidColor = null;
}
