package org.eclipse.uml2.diagram.sequence.internal.layout.model;

import java.awt.Color;
import java.util.Enumeration;

import org.eclipse.uml2.diagram.sequence.internal.layout.GeometryConstants;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsNode;
import org.eclipse.uml2.diagram.sequence.internal.layout.model.SDVerticalLayoutInputImpl.NullFreeIterator;
import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.input.HorizontalConstraint;
import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.input.LifeLine;
import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.input.LifeLineElement;
import org.eclipse.uml2.diagram.sequence.internal.missed.EmptyEnumeration;


/**
 * 
 */
public class LMSimpleLifeLineBracket extends LMLifeLineBracket {
	LMSimpleLifeLineBracket(AbsNode gdeBracketNode, BracketMetaObject bracketMetaObject, LmOwner lmOwner, boolean isResizableVertically) {
		super(gdeBracketNode, bracketMetaObject, lmOwner);
        myIsResizableVertically = isResizableVertically;
	}

    LMLifeLineBracket getDestructionCandidate() {
        return this;
    }

	public NullFreeIterator verticalLayoutElements() {
		return new NullFreeIterator() {
			public Object next() {
				if (myHasNext) {
					myHasNext = false;
					return myLifeLineElement;
				} else {
					return null;
				}
			}
			private boolean myHasNext = true;
		};
	}

	public void setHorizontalPosition(int newPos) {
	}
	public int getPreferedWidth() {
        int result = getGdeNode().getPreferredSize().width;
        return Math.max(GeometryConstants.SimpleBracket.MIN_WIDTH, result);
	}
	
	public boolean isLimitedHorizontally() {
		return false;
	}
	public LmBracketsList getChildBracketsList() {
		return myChildBracketsList;
	}
    
    Color setErrorDisplayColor(Color color) {
        return null;
    }
    
    private int getMinimumHeight() {
        int result = getGdeNode().getPreferredSize().height;
        return Math.max(result, GeometryConstants.SimpleBracket.MIN_HEIGHT);
    }

    private int getPreferredHeight() {
        int result = getMinimumHeight();
        if (! myIsResizableVertically) {
            return result;
        }
        return Math.max(result, getGdeNode().getHeight());
    }    
	
	private final LmBracketsList myChildBracketsList = new LmBracketsListSimple();
    private final boolean myIsResizableVertically;

	private final LifeLineElement.Position myLifeLineElementPosition = new LifeLineElement.Position() {
		public int getPositionValue() {
			return getGdeNode().getY();
		}
		public void setPositionValue(int pos) {
			getGdeNode().setY(pos);
            
            int height = getPreferredHeight();
            getGdeNode().setHeight(height);
		}
		public boolean isVirtual() {
			return false;
		}
		public boolean isFirstPrioritedPosition() {
			return isJustReshaped();
		}
		public boolean isLastPrioritedPosition() {
			return isJustReshaped();
		}
	};
	private final LifeLineElement myLifeLineElement = new LifeLineElement() {
        public void optimizeSize() {
            if (myIsResizableVertically) {
                int height = getMinimumHeight();
                getGdeNode().setHeight(height);
            }
        }
        
		public int getPointOffset() {
			return getBracketMetaObject().getTopOutSpace();
		}
		public int getSize() {
            int realSize = getPreferredHeight() + getBracketMetaObject().getTopOutSpace() + getBracketMetaObject().getBottomOutSpace();
			return realSize;
		}
		public HorizontalConstraint getHorizontalConstraint() {
			return null;
		}
		public Enumeration beforeConstraints() {
			return EmptyEnumeration.getEnumeration();
		}
		public Enumeration afterConstraints() {
			return EmptyEnumeration.getEnumeration();
		}

        public LifeLine getLifeLine() {
            LMLifeLine lmLifeLine = LMSimpleLifeLineBracket.this.getLifeLine();
            return lmLifeLine.getVerticalLayoutLifeLine();
        }

		public Position getPosition() {
			return myLifeLineElementPosition;
		}
	};
}
