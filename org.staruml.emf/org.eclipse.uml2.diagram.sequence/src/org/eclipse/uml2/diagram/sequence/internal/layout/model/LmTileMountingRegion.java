package org.eclipse.uml2.diagram.sequence.internal.layout.model;

import org.eclipse.uml2.diagram.sequence.internal.layout.GeometryConstants;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsNode;
import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.input.HorizontalConstraint;


/**
 * 
 */
class LmTileMountingRegion extends LMMountingRegion {
	LmTileMountingRegion(AbsNode gdeBracketNode, BracketMetaObject bracketMetaObject, LmOwner lmOwner) {
		super(gdeBracketNode, bracketMetaObject, lmOwner);
	}
	
	public LmBracketsList getChildBracketsList() {
		return myChildBracketsList;
	}
	
	public SDVerticalLayoutInputImpl.NullFreeIterator verticalLayoutElements() {
		//// assert
		//{
		//	assertChildBracketsInCorrectOrder();
		//}
		return new SDVerticalLayoutInputImpl.NullFreeIteratorForArray(3) {
			protected Object get(int pos) {
				switch (pos) {
					case 0: return getClueValue();
					case 1: return new LMBracketContainer.ChildBracketsNFIterator();
					case 2: return getClueValue();
				}
				throw new IndexOutOfBoundsException();
			}
		};
	}

	BottomHolder getBottomHolder() {
		return myBottomHolder;
	}
	TopHolder getTopHolder() {
		return myTopHolder;
	}
	void setBottomHolder(BottomHolder bottomHolder) {
		if (bottomHolder != null && myBottomHolder != null) {
			throw new RuntimeException("bottom holder already set"); //$NON-NLS-1$
		}
		myBottomHolder = bottomHolder;
	}
	void setTopHolder(TopHolder topHolder) {
		if (topHolder != null && myTopHolder != null) {
			throw new RuntimeException("top holder already set"); //$NON-NLS-1$
		}
		if (myTopHolder != null && myTopHolder.getConstraintedElement() != null) {
			myTopHolder.setHorizontalConstrinat(null);
		}
		if (topHolder != null && topHolder.getConstraintedElement() != null) {
			if (getMountingLink() != null) {
				topHolder.setHorizontalConstrinat(getMountingLink().getFrame().getTopConstraint());
			} 
		}
		myTopHolder = topHolder;
	}
	void setMountLink(LMMountingLink mountingLink) {
		if (myTopHolder != null && myTopHolder.getConstraintedElement() != null) {
			myTopHolder.setHorizontalConstrinat(null);
			if (mountingLink != null) {
				myTopHolder.setHorizontalConstrinat(mountingLink.getFrame().getTopConstraint());
			} 
		}
		super.setMountLink(mountingLink);
	}
	
    TileEdgePosition getBottomPosition() {
		return myBottomPosition;
	}
    TileEdgePosition getTopPosition() {
		return myTopPosition;
	}
    MountingRegionLifelineElement getTopLifeLineElementForConstraint() {
		if (myTopHolder == null) {
			return null;
		}
		return myTopHolder.getConstraintedElement();
	}

    MountingRegionLifelineElement getBottomLifeLineElementForConstraint() {
		return null;
	}
    
    void setYAndHeightFromFrame(int y, int height, JustReshapedState justReshapedState) {
        int regionTopPos = myOrderAwareMountingRegionTopPosition.framePosToRegionPos(y);
        myTopHolder.setVerticalPositionFromFrame(regionTopPos, justReshapedState);
        myBottomHolder.setVerticalPositionFromFrame(y+height, justReshapedState);
    }
    
	private TopHolder myTopHolder;
	private BottomHolder myBottomHolder;
	
	private final LmBracketsList myChildBracketsList = new LmBracketsListSimple();
    private final OrderAwareMountingRegionTopPosition myOrderAwareMountingRegionTopPosition = new OrderAwareMountingRegionTopPosition();
	private final TileEdgePosition myTopPosition = new TileEdgePosition(myOrderAwareMountingRegionTopPosition);
    
    private class OrderAwareMountingRegionTopPosition extends MountingRegionTopPosition {
        int framePosToRegionPos(int framePos) {
            if (isReferencedInteractionOperandFirstInContainer()) {
                return framePos - GeometryConstants.Frames.FIRST_INTERATCTION_OPERAND_TOP_OFFSET;
            }
            return framePos;
        }
        
        int regionPosToFramePos(int regionPos) {
            if (isReferencedInteractionOperandFirstInContainer()) {
                return regionPos + GeometryConstants.Frames.FIRST_INTERATCTION_OPERAND_TOP_OFFSET;
            }
            return regionPos;
        }
        
        private boolean isReferencedInteractionOperandFirstInContainer() {
            if (getMountingLink() != null) {
                LMFrame lmFrame = getMountingLink().getFrame();
                if (lmFrame != null) {
                    return lmFrame.getContainer().getChildList().get(0) == lmFrame;
                }
            }
            return false;
        }
    }
    
	private final TileEdgePosition myBottomPosition = new TileEdgePosition(new MountingRegionBottomPosition());
	
	
	interface TopHolder {
		/**
		@return null, if constraint not supported (for first element)
		*/
        MountingRegionLifelineElement getConstraintedElement();
		void setHorizontalConstrinat(HorizontalConstraint horizontalConstraint);
        void setVerticalPositionFromFrame(int y, JustReshapedState justReshapedState);
	}
	
	interface BottomHolder {	
        void setVerticalPositionFromFrame(int y, JustReshapedState justReshapedState);
	}

    class TileEdgePosition {
		TileEdgePosition(MountingRegionPosition mountingRegionPosition) {
			myMountingRegionPosition = mountingRegionPosition;
		}
		void setPositionValue(int pos, boolean doNotReshapeFrame) {
			myMountingRegionPosition.setPositionValue(pos, doNotReshapeFrame);
        }
		int getPositionValue() {
            return myMountingRegionPosition.getPositionValue();
        }
        private final MountingRegionPosition myMountingRegionPosition;
    }
}
