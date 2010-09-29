package org.eclipse.uml2.diagram.sequence.internal.layout.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsElementPropertyAccess;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsNode;
import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.input.HorizontalConstraint;
import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.input.LifeLineElement;


/**
 * 
 */
public abstract class LMFrame extends LMFrameContainer implements LmReshapable {
    protected LMFrame(AbsNode gdeNode) {
		myGdeNode = gdeNode;
        myBackgroundLayouter = AbsElementPropertyAccess.getInstance().getBackgroundLayouter(gdeNode);
	}
    
    public interface BackgroundLayouter {
        void setX(int x);
        void setY(int pos);
        void setHeight(int height);
        void setWidth(int width);
    }
	
	public AbsNode getGdeNode() {
		return myGdeNode;
	}
	
	public LMFrameContainer getContainer() {
		if (myContainerFriendly == null) {
			return null;
		}
		return myContainerFriendly.getLMFrameContainer();
	}
	
	public abstract int getInnerHorizontalPadding();
	public abstract int getOuterHorizontalPadding();
	
    public int getTopInnerPadding() {
        return getInnerHorizontalPadding();
    }
    public int getBottomInnerPadding() {
        return getInnerHorizontalPadding();
    }
    
	/**
	 * Called from horizontal layout once for a layout session
	 */
	public void checkConsistancy() {
	}
    
    public abstract void setLeftBorderPosByTool(int pos);
    
    public abstract void setRightBorderPosByTool(int pos);

	public abstract void setLeftBorderPosByLayout(int pos);
	
	public abstract void setRightBorderPosByLayout(int pos);
	
	abstract boolean hasVisibleMountingLinks(); 
	
	void setTopBorderPosFromMountingLink(int pos) {
        setTopBorderPos(pos);
        
        int untiedFramesAreaTopPos = getTopBorderPos()+getTopInnerPadding();
        layoutVerticallyUtiedFrames(untiedFramesAreaTopPos);
	}
    
    boolean tryToUseAsPositionResponsibleLink(LMMountingLink link) {
        //PositionResponsibleLink is first valid link which asks.
        //=> if all mounting links on one lifeline are valid then
        //corresponding frames top positions will be set in order
        //from outermost to innermost frame. And inner frames won't
        //be shifted because of parent frame shift on position setting.
        if (myPositionResponsibleLink == null) {
            if (link.isValid()) {
                myPositionResponsibleLink = link;
            }
        }
        return myPositionResponsibleLink == link;
    }
    void flushPositionResponsibleLink() {
        myPositionResponsibleLink = null;
    }
    private LMMountingLink myPositionResponsibleLink;
    

    /**
     * Untied frame needn't layout inner frames 
     */
    public void setTopBorderPos(int pos) {
        //System.out.println("[LMFrame.setTopBorderPos] set y to "+pos+" for "+this);
        myGdeNode.setY(pos);
        
        if (myBackgroundLayouter != null) {
            myBackgroundLayouter.setY(pos);
        }
    }
	public void setBottomBorderPos(int pos) {
		int newHeight = pos - myGdeNode.getY();
		//System.out.println("[LMFrame.setTopBorderPos] set height to "+newHeight+" for "+this);
		myGdeNode.setHeight(newHeight);
        
        if (myBackgroundLayouter != null) {
            myBackgroundLayouter.setHeight(newHeight);
        }
	}
    int getTopBorderPos() {
        //System.out.println("[LMFrame.setTopBorderPos] set y to "+pos+" for "+this);
        return myGdeNode.getY();
    }
    int getBottomBorderPos() {
        return myGdeNode.getY() + myGdeNode.getHeight();
    }
	
	protected void setX(int x) {
		//System.out.println("[LMFrame.setX] set x="+x+" to "+this);
        
		myGdeNode.setX(x);
        if (myBackgroundLayouter != null) {
            myBackgroundLayouter.setX(x);
        }
	}
	protected void setWidth(int width) {
		//System.out.println("[LMFrame.setX] set width="+width+" to "+this);
		myGdeNode.setWidth(width);
        
        if (myBackgroundLayouter != null) {
            myBackgroundLayouter.setWidth(width);
        }
	}
	
	
	HorizontalConstraintImpl getBottomConstraint() {
		return myBottomConstraint;
	}
	HorizontalConstraintImpl getTopConstraint() {
		return myTopConstraint;
	}
	
	void addMountingLink(LMMountingLink mountingLink) {
		myMountingLinks.add(mountingLink);
	}
	void removeMountingLink(LMMountingLink mountingLink) {
		myMountingLinks.remove(mountingLink);
	}

	public boolean hasAnyMountingLinks() {
		return !myMountingLinks.isEmpty();
	}
	Enumeration mountingLinks() {
		return Collections.enumeration(myMountingLinks);
	}
	List getMountingLinksList() {
		return myMountingLinks;
	}


	void delete() {
		setContainer(null);
	}
	
	void setContainer(LMFrameContainer.ContainerFriendly containerFriendly) {
		if (containerFriendly == null) {
			if (myContainerFriendly != null) {
				myContainerFriendly.childRemove(this);
				myContainerFriendly = null;
			}
		} else {
			if (myContainerFriendly != null) {
				throw new IllegalStateException("Parent already set");  //$NON-NLS-1$
			}
			myContainerFriendly = containerFriendly;
		}
	}
	
	public String toString() {
		EObject entity = myGdeNode.getModelEntity();
		return "Frame$"+entity; //$NON-NLS-1$
	}
    

    public void setJustReshaped(JustReshapedState justReshapedState) {
        myJustReshapedState = justReshapedState;
        //System.out.println("[LMFrame.setJustReshaped] for "+this);
        int y = myGdeNode.getY();
        int height = myGdeNode.getHeight();
        for (Iterator it = myMountingLinks.iterator(); it.hasNext(); ) {
            LMMountingLink mountingLink = (LMMountingLink) it.next();
            LMMountingRegion mountingRegion = mountingLink.getMountingRegion();
            
            //System.out.println("[LMFrame.setJustReshaped] call "+mountingRegion);
            mountingRegion.setYAndHeightFromFrame(y, height, justReshapedState);
        }
    }
    
    public boolean isJustReshaped() {
        if (myJustReshapedState == null) {
            return false;
        }
        return myJustReshapedState.isStillJustReshaped();
    }
    private JustReshapedState myJustReshapedState = null;
    
	
	
	private final AbsNode myGdeNode;
	private LMFrameContainer.ContainerFriendly myContainerFriendly;
	private final List myMountingLinks = new ArrayList(3);
	private final BackgroundLayouter myBackgroundLayouter;
	
	private abstract class HorizontalConstraintImpl implements HorizontalConstraint {
		public List getLifeLineElementsList() {
			//System.out.println("[LMCombinedFragment.getLifeLineElementsList] myMountingLinks="+myMountingLinks);
			List result = new ArrayList(myMountingLinks.size());
			for (int i=0; i<myMountingLinks.size(); i++) {
				LifeLineElement element1 = getLifeLineElement((LMMountingLink)myMountingLinks.get(i));
				if (element1 != null) {
					result.add(element1);
				}
			}
			//System.out.println("[LMCombinedFragment.getLifeLineElementsList] result="+Arrays.asList(result));
			return result;
		}
		public void elementIsResolved(LifeLineElement lifeLineElement) {
		}
		public void elementIsViolated(LifeLineElement lifeLineElement) {
		}
		protected abstract LifeLineElement getLifeLineElement(LMMountingLink lmMountingLink);
	}
	
	private final HorizontalConstraintImpl myTopConstraint = new HorizontalConstraintImpl() {
		protected LifeLineElement getLifeLineElement(LMMountingLink lmMountingLink) {
			return lmMountingLink.getMountingRegion().getTopLifeLineElementForConstraint();
		}
		public void elementIsResolved(LifeLineElement lifeLineElement) {
            if (lifeLineElement instanceof LMMountingRegion.MountingRegionLifelineElement == false) {
                throw new RuntimeException("Unknown type of lifeline element "+lifeLineElement); //$NON-NLS-1$
            }
            LMMountingRegion.MountingRegionLifelineElement mountingRegionLifelineElement = (LMMountingRegion.MountingRegionLifelineElement)lifeLineElement;
            mountingRegionLifelineElement.setConstraintInvalid(false);
		}
		public void elementIsViolated(LifeLineElement lifeLineElement) {
            if (lifeLineElement instanceof LMMountingRegion.MountingRegionLifelineElement == false) {
                throw new RuntimeException("Unknown type of lifeline element "+lifeLineElement); //$NON-NLS-1$
            }
            LMMountingRegion.MountingRegionLifelineElement mountingRegionLifelineElement = (LMMountingRegion.MountingRegionLifelineElement)lifeLineElement;
            mountingRegionLifelineElement.setConstraintInvalid(true);
		}
        public String toString() {
            return "TopMountingConstraint of "+LMFrame.this; //$NON-NLS-1$
        }
	};
	private final HorizontalConstraintImpl myBottomConstraint = new HorizontalConstraintImpl() {
		protected LifeLineElement getLifeLineElement(LMMountingLink lmMountingLink) {
			return lmMountingLink.getMountingRegion().getBottomLifeLineElementForConstraint();
		}
        public String toString() {
            return "BottomMountingConstraint of "+LMFrame.this; //$NON-NLS-1$
        }
	};
}
