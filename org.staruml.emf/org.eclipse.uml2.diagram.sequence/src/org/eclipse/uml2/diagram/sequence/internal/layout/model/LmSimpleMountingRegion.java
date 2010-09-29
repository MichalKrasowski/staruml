package org.eclipse.uml2.diagram.sequence.internal.layout.model;

import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsNode;

/**
 * 
 */
class LmSimpleMountingRegion extends LMMountingRegion {
	LmSimpleMountingRegion(AbsNode gdeBracketNode, BracketMetaObject bracketMetaObject, LmOwner lmOwner) {
		super(gdeBracketNode, bracketMetaObject, lmOwner);
		myTopLifeLineElement = new MountingRegionLifelineElementImpl(bracketMetaObject.getTopOutSpace(), bracketMetaObject.getTopOutSpace()+bracketMetaObject.getTopInSpace()
				, new MountingRegionTopPosition()
	            , this
			);
			myBottomLifeLineElement = new MountingRegionLifelineElementImpl(bracketMetaObject.getBottomInSpace(), bracketMetaObject.getBottomInSpace()+bracketMetaObject.getBottomOutSpace() 
					, new MountingRegionBottomPosition()
	                , this
				);
	}
	
	public SDVerticalLayoutInputImpl.NullFreeIterator verticalLayoutElements() {
		//// assert
		//{
		//	assertChildBracketsInCorrectOrder();
		//}
		return new SDVerticalLayoutInputImpl.NullFreeIteratorForArray(5) {
			protected Object get(int pos) {
				switch (pos) {
					case 0: return myTopLifeLineElement;
					case 1: return getClueValue();
					case 2: return new LMBracketContainer.ChildBracketsNFIterator();
					case 3: return getClueValue();
					case 4: return myBottomLifeLineElement;
				}
				throw new IndexOutOfBoundsException();
			}
		};
	}

	public LmBracketsList getChildBracketsList() {
		return myChildBracketsList;
	}
    
    void setYAndHeightFromFrame(int y, int height, JustReshapedState justReshapedState) {
        setJustReshaped(justReshapedState);
        
        AbsNode gdeNode = getGdeNode();
        gdeNode.setY(y);
        gdeNode.setHeight(height);
    }
    
	
	void setMountLink(LMMountingLink mountingLink) {
		super.setMountLink(mountingLink);
		
		if (mountingLink == null) {
			myTopLifeLineElement.setHorizontalConstraint(null);
			myBottomLifeLineElement.setHorizontalConstraint(null);
		} else {
			LMFrame frame = mountingLink.getFrame();
			myTopLifeLineElement.setHorizontalConstraint(frame.getTopConstraint());
			myBottomLifeLineElement.setHorizontalConstraint(frame.getBottomConstraint());
		}
	}
	
	MountingRegionLifelineElement getTopLifeLineElementForConstraint() {
		return myTopLifeLineElement;
	}
	MountingRegionLifelineElement getBottomLifeLineElementForConstraint() {
		return myBottomLifeLineElement;
	}
	

	private final LmBracketsList myChildBracketsList = new LmBracketsListSimple();
	private final MountingRegionLifelineElementImpl myTopLifeLineElement;
	private final MountingRegionLifelineElementImpl myBottomLifeLineElement;
    
    private class MountingRegionLifelineElementImpl extends SDVerticalLayoutInputImpl.LifeLineElementGenAdapter implements MountingRegionLifelineElement {
        MountingRegionLifelineElementImpl(int pointOffset, int size,
                Position position, LMLifeLineBracket lifeLineBracket) {
            super(pointOffset, size, position, lifeLineBracket);
        }
        
        public void setConstraintInvalid(boolean isInvalid) {
            LmSimpleMountingRegion.this.getMountingLink().setInvalid(isInvalid);
        }
    }
}
