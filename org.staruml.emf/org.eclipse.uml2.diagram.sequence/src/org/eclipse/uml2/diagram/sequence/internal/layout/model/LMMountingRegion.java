package org.eclipse.uml2.diagram.sequence.internal.layout.model;

import java.awt.Color;
import java.util.Iterator;

import org.eclipse.uml2.diagram.sequence.internal.layout.GeometryConstants;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsNode;
import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.input.LifeLineElement;
import org.eclipse.uml2.diagram.sequence.internal.missed.ReverseListIterator;


/**
 * 
 */
public abstract class LMMountingRegion extends LMLifeLineBracket {
	LMMountingRegion(AbsNode gdeBracketNode, BracketMetaObject bracketMetaObject, LmOwner lmOwner) {
		super(gdeBracketNode, bracketMetaObject, lmOwner);
	}

	public boolean isLimitedHorizontally() {
		return false;
	}
    
    LMLifeLineBracket getCreationCandidate() {
        if (getChildBracketsList().isEmpty()) {
            return null;
        }
        for (Iterator it = getChildBracketsList().iterator(); it.hasNext(); ) {
            LMLifeLineBracket next = (LMLifeLineBracket) it.next();
            LMLifeLineBracket result = next.getCreationCandidate();
            if (result != null) {
                return result;
            }
        }
        return null;
    }
    
    LMLifeLineBracket getDestructionCandidate() {
        if (getChildBracketsList().isEmpty()) {
            return null;
        }
        for (Iterator it = new ReverseListIterator(getChildBracketsList().getListView()); it.hasNext(); ) {
            LMLifeLineBracket nextBracket = (LMLifeLineBracket) it.next();
            LMLifeLineBracket lifelineBracket = nextBracket.getDestructionCandidate();
            if (lifelineBracket != null) {
                return lifelineBracket;
            }
        }
        return null;
    }
    
    LMFrame getContainingFrame() {
        LMMountingLink mountingLink = getMountingLink();
        if (mountingLink == null) {
            return null;
        } 
        return mountingLink.getFrame();
    }

	void setMountLink(LMMountingLink mountingLink) {
		if (myMountingLink != null && mountingLink != null) {
			throw new IllegalStateException("mounting link already set"); //$NON-NLS-1$
		}
		myMountingLink = mountingLink;
	}
	
	public LMMountingLink getMountingLink() {
		return myMountingLink;
	}
	public void setHorizontalPosition(int newPos) {
		getGdeNode().setX(newPos);
		
		if (myMountingLink != null) {
			myMountingLink.setXPosition(newPos + GeometryConstants.Execution.HORIZONTAL_OFFSET);
		}
	}
	
	abstract void setYAndHeightFromFrame(int y, int height, JustReshapedState justReshapedState);
	
	private LMMountingLink myMountingLink;

    interface MountingRegionPosition extends LifeLineElement.Position {
        void setPositionValue(int pos, boolean doNotReshapeFrame);
    }
	class MountingRegionTopPosition extends BracketTopPosition implements MountingRegionPosition {
        public int getPositionValue() {
            if (!getGdeNode().isUserResized()) {
                LMFrame frame = getLmFrame();
                if (frame != null) {
                    int framePos = frame.getTopBorderPos();
                    return framePosToRegionPos(framePos);
                }
            }
            return super.getPositionValue();
		}
        public void setPositionValue(int pos) {
            setPositionValue(pos, false);
        }
        /**
         * @param pos  is always region top pos
         */
		public void setPositionValue(int pos, boolean doNotReshapeFrame) {
			super.setPositionValue(pos);
            getGdeNode().markUserResized();//mark that the region has been layouted
            if (!doNotReshapeFrame) {
    			if (getMountingLink() != null) {
                    int framePos = regionPosToFramePos(pos);
                	getMountingLink().setFrameTopPosition(framePos);
                }
            }
		}
        
        int regionPosToFramePos(int regionPos) {
            return regionPos;
        }
        
        int framePosToRegionPos(int framePos) {
            return framePos;
        }
	}
	class MountingRegionBottomPosition extends BracketBottomPosition implements MountingRegionPosition {
        public int getPositionValue() {
            if (!getGdeNode().isUserResized()) {
                LMFrame frame = getLmFrame();
                if (frame != null) {
                    return frame.getBottomBorderPos();
                }
            }
            return super.getPositionValue();
        }
        
        public void setPositionValue(int pos) {
            setPositionValue(pos, false);
        }
        public void setPositionValue(int pos, boolean doNotReshapeFrame) {
            super.setPositionValue(pos);
            if (!doNotReshapeFrame) {
                if (getMountingLink() != null) {
                    getMountingLink().setFrameBottomPosition(pos);
                }
            }
        }
	}
    private LMFrame getLmFrame() {
        LMMountingLink mountingLink = getMountingLink();
        if (mountingLink == null) {
            return null;
        }
        return mountingLink.getFrame();
    }
    
	abstract MountingRegionLifelineElement getTopLifeLineElementForConstraint();

	abstract MountingRegionLifelineElement getBottomLifeLineElementForConstraint();
    
    interface MountingRegionLifelineElement extends LifeLineElement {
        void setConstraintInvalid(boolean isInvalid);
    }
    
    protected boolean calculateIsBracketConsistent() {
        if (!super.calculateIsBracketConsistent()) {
            return false;
        }
        if (myMountingLink == null) {
            return false;
        }
        if (myMountingLink.getFrame() == null) {
            return false;
        }
        return true;
    }
    
    Color setErrorDisplayColor(Color color) {
        Color oldColor = getGdeNode().getBackground();
        getGdeNode().setBackground(color);
        return oldColor;
    }
}
