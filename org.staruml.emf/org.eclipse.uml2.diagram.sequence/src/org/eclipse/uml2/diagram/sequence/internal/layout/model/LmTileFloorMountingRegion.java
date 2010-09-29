package org.eclipse.uml2.diagram.sequence.internal.layout.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.diagram.sequence.internal.layout.GeometryConstants;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsNode;
import org.eclipse.uml2.diagram.sequence.internal.layout.model.LmTileMountingRegion.BottomHolder;
import org.eclipse.uml2.diagram.sequence.internal.layout.model.LmTileMountingRegion.TopHolder;
import org.eclipse.uml2.diagram.sequence.internal.layout.model.SDVerticalLayoutInputImpl.NullFreeIterator;
import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.input.HorizontalConstraint;
import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.input.LifeLine;
import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.input.LifeLineElement;


/**
 * 
 */
class LmTileFloorMountingRegion extends LMMountingRegion {
	LmTileFloorMountingRegion(AbsNode gdeBracketNode, BracketMetaObject bracketMetaObject, LmOwner lmOwner) {
		super(gdeBracketNode, bracketMetaObject, lmOwner);
	}
    
	public LmBracketsList getChildBracketsList() {
		return myBracketsList;
	}
	public NullFreeIterator verticalLayoutElements() {
		return new NullFreeIterator() {
			public Object next() {
				switch (myState) {
					case 0:
						if (myBracketsList.isEmpty()) {
							myState = 2;
						} else {
							myState = 1;
							myTileElementsReturned = false;
							myTilePos = 0;
						}
						return myFirstTopHolder;
					case 1:
						if (myTileElementsReturned) {
							myTileElementsReturned = false;
							MiddleLifeLineElement middleLifeLineElement = (MiddleLifeLineElement) myMiddleLifeLineElements.get(myTilePos);
							myTilePos ++;
							return middleLifeLineElement;
						} else {
							if (myTilePos >= myBracketsList.size()-1) {
								myState = 2;
							} else {
								myTileElementsReturned = true;
							}
							LmTileMountingRegion mountingRegion = (LmTileMountingRegion) myBracketsList.getListView().get(myTilePos); 
							return mountingRegion.verticalLayoutElements();
						}
					case 2:
						myState = 3;
						return myLastBottomHolder;
					case 3:
						return null;
				}
				throw new IllegalStateException("state = "+myState); //$NON-NLS-1$
			}
			private int myState = 0;
			private boolean myTileElementsReturned;
			private int myTilePos;
		};
	}
    
	private LmBracketsList myBracketsList = new LmBracketsList() {
		public List getListView() {
			return myUnmodifableList;
		}
		public Iterator iterator() {
			return myUnmodifableList.iterator();
		}
		public int size() {
			return myTilesList.size();
		}
		public void reorderList(List oldIndexList) {
			if (myTilesList.size() != oldIndexList.size()) {
				throw new RuntimeException("Wrong number of elements to replace"); //$NON-NLS-1$
			}
			
			List newList = new ArrayList(myTilesList.size());
			
			for (Iterator it = oldIndexList.iterator(); it.hasNext(); ) {
				Integer oldIndex = (Integer) it.next();
				int index = oldIndex.intValue();
				newList.add(myTilesList.get(index));
			}
			
			for (int i=0; i<myTilesList.size(); i++) {
				LmTileMountingRegion tile = (LmTileMountingRegion) myTilesList.get(i);
				tile.setTopHolder(null);
				tile.setBottomHolder(null);
			}
			
			myTilesList.clear();
			myMiddleLifeLineElements.clear();
			
			myTilesList.addAll(newList);
			
			int listSize = myTilesList.size(); 
			if (listSize == 0) {
			} else {
				LmTileMountingRegion firstTile = (LmTileMountingRegion)myTilesList.get(0);
				myFirstTopHolder.setTileMountingRegion(firstTile);
				firstTile.setTopHolder(myFirstTopHolder);

				for (int i=1; i<listSize; i++) {
					LmTileMountingRegion tile1 = (LmTileMountingRegion) myTilesList.get(i-1);
					LmTileMountingRegion tile2 = (LmTileMountingRegion) myTilesList.get(i);
					
					MiddleLifeLineElement middleLifeLineElement = new MiddleLifeLineElement(tile1, tile2);
					
					myMiddleLifeLineElements.add(middleLifeLineElement);
					
					tile1.setBottomHolder(middleLifeLineElement.getBottomHolder());
					tile2.setTopHolder(middleLifeLineElement.getTopHolder());
				}
				
				LmTileMountingRegion lastTile = (LmTileMountingRegion)myTilesList.get(listSize-1);
				lastTile.setBottomHolder(myLastBottomHolder);
				myLastBottomHolder.setTileMountingRegion(lastTile);
			}
			
			//assertCorrectState();
		}

		public void add(LMLifeLineBracket lifeLineBracket) {
			LmTileMountingRegion tile = (LmTileMountingRegion) lifeLineBracket;
			
			int listSize = myTilesList.size(); 
            
			if (listSize == 0) {
				myFirstTopHolder.setTileMountingRegion(tile);
				tile.setTopHolder(myFirstTopHolder);
			} else {
				LmTileMountingRegion prevTile = (LmTileMountingRegion) myTilesList.get(listSize-1);
				prevTile.setBottomHolder(null);

				MiddleLifeLineElement middleLifeLineElement = new MiddleLifeLineElement(prevTile, tile);
				
				myMiddleLifeLineElements.add(middleLifeLineElement);
				
				prevTile.setBottomHolder(middleLifeLineElement.getBottomHolder());
				tile.setTopHolder(middleLifeLineElement.getTopHolder());
			}
			
			tile.setBottomHolder(myLastBottomHolder);
			myLastBottomHolder.setTileMountingRegion(tile);
			
			myTilesList.add(tile);
			
			
			//assertCorrectState();
		}

		public void remove(LMLifeLineBracket lifeLineBracket) {
			LmTileMountingRegion tile = (LmTileMountingRegion) lifeLineBracket;
			int index = myTilesList.indexOf(tile);
			if (index == -1) {
				throw new RuntimeException("Cannot find tile item in list"); //$NON-NLS-1$
			}
			tile.setTopHolder(null);
			tile.setBottomHolder(null);
			int listSize = myTilesList.size(); 
			if (listSize == 1) {
				myTilesList.clear();
				myFirstTopHolder.setTileMountingRegion(null);
				myLastBottomHolder.setTileMountingRegion(null);
			} else {
				if (index == 0) {
					myMiddleLifeLineElements.remove(0);
					LmTileMountingRegion tile1 = (LmTileMountingRegion)myTilesList.get(1);
					myFirstTopHolder.setTileMountingRegion(tile1);
					tile1.setTopHolder(null);
					tile1.setTopHolder(myFirstTopHolder);
				} else if (index == listSize-1) {
					myMiddleLifeLineElements.remove(listSize-2);
					LmTileMountingRegion tilePre = (LmTileMountingRegion)myTilesList.get(listSize-2);
					myLastBottomHolder.setTileMountingRegion(tilePre);
					tilePre.setBottomHolder(null);
					tilePre.setBottomHolder(myLastBottomHolder);
				} else {
					myMiddleLifeLineElements.remove(index);
					
					LmTileMountingRegion tile1 = (LmTileMountingRegion) myTilesList.get(index-1);
					LmTileMountingRegion tile2 = (LmTileMountingRegion) myTilesList.get(index+1);
					tile1.setBottomHolder(null);
					tile2.setTopHolder(null);
					
					MiddleLifeLineElement middleLifeLineElement = new MiddleLifeLineElement(tile1, tile2);
					myMiddleLifeLineElements.set(index-1, middleLifeLineElement);
					tile1.setBottomHolder(middleLifeLineElement.getBottomHolder());
					tile2.setTopHolder(middleLifeLineElement.getTopHolder());
				}
				myTilesList.remove(index);
			}
			
			//assertCorrectState();
		}
		
		public boolean isEmpty() {
			return myTilesList.isEmpty();
		}

		public void removeAll() {
			myTilesList.clear();
			myMiddleLifeLineElements.clear();
			
			if (false) {
                assert checkCorrectState();
            }
		}
		
		boolean checkCorrectState() {
			if (myTilesList.isEmpty()) {
				if (!myMiddleLifeLineElements.isEmpty()) {
					throw new RuntimeException("bad state"); //$NON-NLS-1$
				}
				return true;
			}
			
			
			int listSize = myTilesList.size();
			
			LmTileMountingRegion firstTile = (LmTileMountingRegion)myTilesList.get(0);
			if (myFirstTopHolder.getTileMountingRegion() != firstTile) {
				throw new RuntimeException("bad state"); //$NON-NLS-1$
			}
			if (firstTile.getTopHolder() != myFirstTopHolder) {
				throw new RuntimeException("bad state"); //$NON-NLS-1$
			}

			for (int i=1; i<listSize; i++) {
				LmTileMountingRegion tile1 = (LmTileMountingRegion) myTilesList.get(i-1);
				LmTileMountingRegion tile2 = (LmTileMountingRegion) myTilesList.get(i);
				
				MiddleLifeLineElement middleLifeLineElement = (MiddleLifeLineElement) myMiddleLifeLineElements.get(i-1);
				
				if (middleLifeLineElement.getTopTile() != tile1) {
					throw new RuntimeException("bad state"); //$NON-NLS-1$
				}
				if (middleLifeLineElement.getBottomTile() != tile2) {
					throw new RuntimeException("bad state"); //$NON-NLS-1$
				}
				
				if (tile1.getBottomHolder() != middleLifeLineElement.getBottomHolder()) {
					throw new RuntimeException("bad state"); //$NON-NLS-1$
				}
				if (tile2.getTopHolder() != middleLifeLineElement.getTopHolder()) {
					throw new RuntimeException("bad state"); //$NON-NLS-1$
				}
			}
			
			LmTileMountingRegion lastTile = (LmTileMountingRegion)myTilesList.get(listSize-1);
			if (myLastBottomHolder.getTileMountingRegion() != lastTile) {
				throw new RuntimeException("bad state"); //$NON-NLS-1$
			}
			if (lastTile.getBottomHolder() != myLastBottomHolder) {
				throw new RuntimeException("bad state"); //$NON-NLS-1$
			}
            return true;
		}
		
		private final List myTilesList = new ArrayList();
		private final List myUnmodifableList = Collections.unmodifiableList(myTilesList);
	};
	
	void setMountLink(LMMountingLink mountingLink) {
		super.setMountLink(mountingLink);
		
		if (mountingLink == null) {
			myFirstTopHolder.setHorizontalConstraint(null);
			myLastBottomHolder.setHorizontalConstraint(null);
		} else {
			LMFrame frame = mountingLink.getFrame();
			myFirstTopHolder.setHorizontalConstraint(frame.getTopConstraint());
			myLastBottomHolder.setHorizontalConstraint(frame.getBottomConstraint());
		}
	}
	MountingRegionLifelineElement getTopLifeLineElementForConstraint() {
		return myFirstTopHolder;
	}
	MountingRegionLifelineElement getBottomLifeLineElementForConstraint() {
		return myLastBottomHolder;
	}
    void setYAndHeightFromFrame(int y, int height, JustReshapedState justReshapedState) {
        //System.out.println("[LmTileFloorMountingRegion.setYAndHeightFromFrame] y="+y);
        //System.out.println("[LmTileFloorMountingRegion.setYAndHeightFromFrame] height="+height);
        setJustReshaped(justReshapedState);
        myFirstTopHolder.setPositionValue(y, true);
        myLastBottomHolder.setPositionValue(y+height, true);
    }
    
	
	private final List myMiddleLifeLineElements = new ArrayList();
	
	private abstract class EdgeTopOrBottomHolder extends SDVerticalLayoutInputImpl.LifeLineElementGen implements LifeLineElement.Position, MountingRegionLifelineElement {
		protected EdgeTopOrBottomHolder(int topOffset, int bottomOffset, MountingRegionPosition floorBracketPosition) {
			super(topOffset, topOffset+bottomOffset);
			myFloorBracketPosition = floorBracketPosition;
		}

		public LifeLine getLifeLine() {
			return LmTileFloorMountingRegion.this.getLifeLine().getVerticalLayoutLifeLine();
		}

		public Position getPosition() {
			return this;
		}
		public int getPositionValue() {
			return myFloorBracketPosition.getPositionValue();
		}
        public void setPositionValue(int pos) {
           setPositionValue(pos, false);
        }
        public void setConstraintInvalid(boolean isInvalid) {
            LmTileFloorMountingRegion.this.getMountingLink().setInvalid(isInvalid);
            if (myTileMountingRegion != null) {
                myTileMountingRegion.getMountingLink().setInvalid(isInvalid);
            }
        }
		void setPositionValue(int pos, boolean doNotReshapeFrame) {
			myFloorBracketPosition.setPositionValue(pos, doNotReshapeFrame);
			if (myTileMountingRegion != null) {
				getTilePosition(myTileMountingRegion).setPositionValue(pos, doNotReshapeFrame);
			}
		}

		public boolean isFirstPrioritedPosition() {
			return myFloorBracketPosition.isFirstPrioritedPosition();
		}
		public boolean isLastPrioritedPosition() {
			return myFloorBracketPosition.isLastPrioritedPosition();
		}
		void setTileMountingRegion(LmTileMountingRegion tileMountingRegion) {
			myTileMountingRegion = tileMountingRegion;
		}
		LmTileMountingRegion getTileMountingRegion() {
			return myTileMountingRegion;
		}
        
        public void setVerticalPositionFromFrame(int y, JustReshapedState justReshapedState) {
            setPositionValue(y, true);
        }
		
		protected abstract LmTileMountingRegion.TileEdgePosition getTilePosition(LmTileMountingRegion tileMountingRegion);

		private LmTileMountingRegion myTileMountingRegion;
		private final MountingRegionPosition myFloorBracketPosition;
	}
	
	private class FirstTopHolder extends EdgeTopOrBottomHolder implements LifeLineElement.Position, LmTileMountingRegion.TopHolder {
		protected FirstTopHolder() {
			super(GeometryConstants.CombinedFragmentMountingPoint.VERTICAL_OUT_SPACE, GeometryConstants.InteractionOpernadMountingPoint.VERTICAL_TOP_IN_SPACE, new MountingRegionTopPosition());
		}
        
		protected LmTileMountingRegion.TileEdgePosition getTilePosition(LmTileMountingRegion tileMountingRegion) {
			return tileMountingRegion.getTopPosition();
		}
		public MountingRegionLifelineElement getConstraintedElement() {
			return null;
		}
		public void setHorizontalConstrinat(HorizontalConstraint horizontalConstraint) {
			throw new UnsupportedOperationException("no constraints here"); //$NON-NLS-1$
		}
		public boolean isVirtual() {
			return false;
		}
        public String toString() {
            EObject nodeEntity = getGdeNode().getModelEntity();
            return "FloorTopElement:"+ nodeEntity; //$NON-NLS-1$
        }
	}
	 
	private class LastBottomHolder extends EdgeTopOrBottomHolder implements LifeLineElement.Position, LmTileMountingRegion.BottomHolder {
		protected LastBottomHolder() {
			super(GeometryConstants.InteractionOpernadMountingPoint.VERTICAL_BOTTOM_IN_SPACE, GeometryConstants.CombinedFragmentMountingPoint.VERTICAL_OUT_SPACE, new MountingRegionBottomPosition());
		}
		protected LmTileMountingRegion.TileEdgePosition getTilePosition(LmTileMountingRegion tileMountingRegion) {
			return tileMountingRegion.getBottomPosition();
		}
		public boolean isVirtual() {
			return false;
		}
        public String toString() {
        	EObject nodeEntity = getGdeNode().getModelEntity();
            return "FloorBottomElement:"+ nodeEntity; //$NON-NLS-1$
        }
	}
	
	private class MiddleLifeLineElement extends SDVerticalLayoutInputImpl.LifeLineElementGen implements LifeLineElement.Position, TopHolder, BottomHolder, MountingRegionLifelineElement {
		MiddleLifeLineElement(LmTileMountingRegion topTile, LmTileMountingRegion bottomTile) {
			super(GeometryConstants.InteractionOpernadMountingPoint.VERTICAL_IN_SPACE, GeometryConstants.InteractionOpernadMountingPoint.VERTICAL_IN_SPACE*2);
			myTopTile = topTile;
			myBottomTile = bottomTile;
		}
		
		LmTileMountingRegion getBottomTile() {
			return myBottomTile;
		}
		LmTileMountingRegion getTopTile() {
			return myTopTile;
		}
		public TopHolder getTopHolder() {
			return this;
		}
		public BottomHolder getBottomHolder() {
			return this;
		}

		public int getPositionValue() {
			return myTopTile.getBottomPosition().getPositionValue();
		}

		public void setPositionValue(int pos) {
            setPositionValue(pos, false);
		}
        void setPositionValue(int pos, boolean doNotReshapeFrame) {
            myTopTile.getBottomPosition().setPositionValue(pos, doNotReshapeFrame);
            myBottomTile.getTopPosition().setPositionValue(pos, doNotReshapeFrame);
        }
		public boolean isVirtual() {
			return false;
		}

		public boolean isFirstPrioritedPosition() {
			return false;
		}
		public boolean isLastPrioritedPosition() {
			return false;
		}

		public LifeLine getLifeLine() {
			return LmTileFloorMountingRegion.this.getLifeLine().getVerticalLayoutLifeLine();
		}

		public Position getPosition() {
			return this;
		}
		public MountingRegionLifelineElement getConstraintedElement() {
			return this;
		}
		public void setHorizontalConstrinat(HorizontalConstraint horizontalConstraint) {
			super.setHorizontalConstraint(horizontalConstraint);
		}
        public void setVerticalPositionFromFrame(int y, JustReshapedState justReshapedState) {
            setPositionValue(y, true);
        }
        public void setConstraintInvalid(boolean isInvalid) {
            LMMountingLink topMountingLink = myTopTile.getMountingLink();
            if (topMountingLink != null) {
                topMountingLink.setInvalid(isInvalid);
            }
            LMMountingLink bottomMountingLink = myBottomTile.getMountingLink();
            if (bottomMountingLink != null) {
                bottomMountingLink.setInvalid(isInvalid);
            }
        }
        public String toString() {
        	EObject nodeEntity = getGdeNode().getModelEntity();
            return "FloorMiddleElement:"+nodeEntity; //$NON-NLS-1$
        }
		
		private final LmTileMountingRegion myTopTile;
		private final LmTileMountingRegion myBottomTile;
	}
    
	private final FirstTopHolder myFirstTopHolder = new FirstTopHolder();
	private final LastBottomHolder myLastBottomHolder = new LastBottomHolder();
}
