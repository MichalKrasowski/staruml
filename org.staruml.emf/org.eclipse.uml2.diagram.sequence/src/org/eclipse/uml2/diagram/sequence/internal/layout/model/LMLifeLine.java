package org.eclipse.uml2.diagram.sequence.internal.layout.model;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.sequence.internal.layout.GeometryConstants;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsElementPropertyAccess;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsNode;
import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.input.LifeLine;
import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.input.LifeLineElement;
import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.input.LifeLineIterator;


public class LMLifeLine extends LMBracketContainer implements SDVerticalLayoutInputImpl.LifeLineSupply {
		
    LMLifeLine(AbsNode gdeLifeLine, BracketMetaObject pseudoMetaObject, LmOwner lmOwner) {
		super(gdeLifeLine, lmOwner);
		myPseudoMetaObject = pseudoMetaObject;

		LifeLineElement.Position topElementPosition = new LifeLineElement.Position() {
			public int getPositionValue() {
				return getLifeLineGdeTopPos();
			}
			public void setPositionValue(int pos) {
                if (isVirtual()) {
                    return;
                }
				setLifeLineGdeTopPos(pos);
			}
			public boolean isVirtual() {
                return myCreationExecution != null;//execution will provide top pos
			}
			public boolean isFirstPrioritedPosition() {
				return isJustReshaped();
			}
			public boolean isLastPrioritedPosition() {
				return false;
			}
		};
		myFirstLifeLineElement = new SDVerticalLayoutInputImpl.LifeLineElementGenAdapter(GeometryConstants.Lifeline.SKIP_LIFELINE_FROM_TOP, GeometryConstants.Lifeline.SKIP_LIFELINE_FROM_TOP, topElementPosition, this) {
            public String toString() {
                return "Lifeline("+LMLifeLine.this+")top"; //$NON-NLS-1$ //$NON-NLS-2$
            }
        };
		
		LifeLineElement.Position bottomElementPosition = new LifeLineElement.Position() {
			public int getPositionValue() {
				return getLifeLineGdeBottomPos();
			}
			public void setPositionValue(int pos) {
                if (isVirtual()) {
                    return;
                }
				setLifeLineGdeBottomPos(pos);
			}
			public boolean isVirtual() {
                return myDestructionExecution != null;//execution will provide bottom pos
			}
			public boolean isFirstPrioritedPosition() {
				return false;
			}
			public boolean isLastPrioritedPosition() {
				return isJustReshaped();
			}
		};
		myLastLifeLineElement = new SDVerticalLayoutInputImpl.LifeLineElementGenAdapter(20, 20, bottomElementPosition, this) {
            public String toString() {
                return "Lifeline("+LMLifeLine.this+")bottoms"; //$NON-NLS-1$ //$NON-NLS-2$
            }
        };
		
        
        myDetailsLayouter = AbsElementPropertyAccess.getInstance().getLifeLineDetailsLayouter(gdeLifeLine);
        
        myHeadLifeLineElement = new HeadLifeLineElement(myDetailsLayouter.getHeadPreferredHeight());
	}
    
    public void setJustReshaped(JustReshapedState justReshapedState) {
        super.setJustReshaped(justReshapedState);
        if (myBottomPosControoller != null) {
            AbsNode gdeNode = myBottomPosControoller.getGdeNode();
            
            int lifelineBottom = getBracketBottomPos();
            
            int y = gdeNode.getY();
            gdeNode.setHeight(lifelineBottom - y);
        }
        //It is not necessary because on lifeline top pos change all children(including 
        //creation execution) will be translated anyway
//        if (myCreationExecution != null) {
//            AbsNode gdeNode = myCreationExecution.getGdeNode();
//            int creationTop = getBracketTopPos() + getHeadHeight() -1;
//            gdeNode.setY(creationTop);
//        }
    }
    
    void updateCreationDestruction() {
        {
            LMLifeLineBracket firstBracket = getCreationCandidate();
            LMExecutionOccurence creationExecution = null;
            if (firstBracket instanceof LMExecutionOccurence) {
                LMExecutionOccurence e = (LMExecutionOccurence)firstBracket; 
                if (e.isCreationInModel()) {
                    creationExecution = e;
                }
            }
            setCreationExecution(creationExecution);
        }

        {
            LMLifeLineBracket lastBracket = getDestructionCandidate();
            LMExecutionOccurence destructionExecution = null;
            if (lastBracket instanceof LMExecutionOccurence) {
                LMExecutionOccurence e = (LMExecutionOccurence)lastBracket; 
                if (e.isDestructionInModel()) {
                    destructionExecution = e;
                }
            }
            setDestructionExecution(destructionExecution);
        }
    }
    
    private void setCreationExecution(LMExecutionOccurence creationExecution) {
        if (myCreationExecution == creationExecution) {
            return;
        }
        if (myCreationExecution != null) {
            myCreationExecution.setCreatedLifeline(null);
        }
        myCreationExecution = creationExecution;
        if (myCreationExecution != null) {
            myCreationExecution.setCreatedLifeline(this);
        }
    }

    private void setDestructionExecution(LMExecutionOccurence destructionExecution) {
        if (myDestructionExecution == destructionExecution) {
            return;
        }
        if (myDestructionExecution != null) {
            assert myBottomPosControoller != null;
            myDestructionExecution.setDestructedLifeline(null);
            myBottomPosControoller.setLifelineToProvideBottomPos(null);
        }
            
        myDestructionExecution = destructionExecution;
        if (myDestructionExecution != null) {
            myDestructionExecution.setDestructedLifeline(this);
            
            myBottomPosControoller = myDestructionExecution;
            LMGenCallOccurence callOccurence = myDestructionExecution;
            while (callOccurence != null) {
                myBottomPosControoller = callOccurence;
                callOccurence = callOccurence.getContainer().getContainingCallOccurence();
            }
            myBottomPosControoller.setLifelineToProvideBottomPos(this);
        }
    }
    
    LMLifeLineBracket getCreationCandidate() {
        if (getChildBracketsList().isEmpty()) {
            return null;
        }
        LMLifeLineBracket firstBracket = (LMLifeLineBracket) getChildBracketsList().getListView().get(0);
        return firstBracket.getCreationCandidate();
    }

    LMLifeLineBracket getDestructionCandidate() {
        if (getChildBracketsList().isEmpty()) {
            return null;
        }
        List listView = getChildBracketsList().getListView();
        LMLifeLineBracket lastBracket = (LMLifeLineBracket) listView.get(listView.size()-1);
        return lastBracket.getDestructionCandidate();
    }

    LMGenCallOccurence getContainingCallOccurence() {
        return null;
    }
    
    LMFrame getContainingFrame() {
        return null;
    }
    
    int getCreationReceiveEndXPos(boolean toRightNotLeft) {
        int centerPos = getGdeNode().getX() + myDetailsLayouter.getCenterRelativePos();
        if (toRightNotLeft) {
            return centerPos + myDetailsLayouter.getHeadHalfWidth();
        } else {
            return centerPos - myDetailsLayouter.getHeadHalfWidth();
        }
    }

	public interface DetailsLayouter {
        int getHeadPreferredWidth();
        int getHeadPreferredHeight();
        int getHeadTopPos();
        /**
         * Sets tail x-position relative to lifeline x-position and width 
         * of lifeline head. Center position cannot be absolute because it 
         * should take into account translation of parent figures(i.e. 
         * interaction).
         */
        void setHorizontalPositions(int centerRelativePos, int headHalfWidth);
        
        int getCenterRelativePos();
        int getHeadHalfWidth();
    }
	
	private SDVerticalLayoutInputImpl.NullFreeIterator verticalLayoutElements() {
		
		return new SDVerticalLayoutInputImpl.NullFreeIteratorForArray(6) {
			protected Object get(int pos) {
				switch (pos) {
					case 0: return myFirstLifeLineElement;
					case 1: return myHeadLifeLineElement;
					case 2: return getClueValue();
					case 3: return new LMBracketContainer.ChildBracketsNFIterator();
					case 4: return VerticalClue.LIFE_LINE_TAIL_CLUE;
					case 5: return myLastLifeLineElement;
				}
				throw new IndexOutOfBoundsException();
			}
		};
	}

    public LifeLine getVerticalLayoutLifeLine() {
        return myVerticalLayoutLifeLine;
    }

	public String toString() {
		EObject nodeEntity = getGdeNode().getModelEntity();
		return "LmLL-"+nodeEntity; //$NON-NLS-1$
	}
	
	
	SDVerticalLayoutInputImpl.LifeLineElementGen getFirstLifeLineElement() {
		return myFirstLifeLineElement;
	}
	SDVerticalLayoutInputImpl.LifeLineElementGen getLastLifeLineElement() {
		return myLastLifeLineElement;
	}
	
	LMLifeLineBracket createChildBracketInstance(AbsNode gdeNode, View reference) {
		BracketMetaObject bracketMetaObject = myPseudoMetaObject.getChildBracketMetaObject(reference);
		if (bracketMetaObject == null) {
			return null;
		}
		return bracketMetaObject.createChildBracket(gdeNode, getLmOwner());
	}
	
	public int getHeadNameWidth() {
		int result = myDetailsLayouter.getHeadPreferredWidth(); 
		if (result < GeometryConstants.Lifeline.MINIMUM_HEAD_WIDTH) {
			result = GeometryConstants.Lifeline.MINIMUM_HEAD_WIDTH;
		}
		return result;
	}
    public int getHeadHeight() {
        //GeometryConstants.Lifeline.HEIGHT 
        return myDetailsLayouter.getHeadPreferredHeight();
    }
	protected Integer getClueValue() {
		return VerticalClue.BRACKET_MAX_CLUE;
	}
	
	LMLifeLine getLifeLine() {
		return this;
	}
	
	SDVerticalLayoutInputImpl.LifeLineElementGen getObjectHorizontalConstraint() {
		return myHeadLifeLineElement;
	}
	
	/*
	public void setX(int x) {
		getGdeNode().setX(x);
		myHeadElement.setX(x);
	}
	public void setWidth(int width) {
		getGdeNode().setWidth(width);
		myHeadElement.setX(getGdeNode().getX());
		myHeadElement.setWidth(width);
	}
	*/
	
	public void setHorizontalPos(int centerPos, int leftHalfWidth, int rightHalfWidth, int headHalfWidth) {
		int x = centerPos - leftHalfWidth;
		int width = leftHalfWidth + rightHalfWidth;
        
		getGdeNode().setX(x);
		getGdeNode().setWidth(width);
		getGdeNode().markUserResized();		
		myDetailsLayouter.setHorizontalPositions(leftHalfWidth, headHalfWidth);
    } 
	
	public LmBracketsList getChildBracketsList() {
		return myChildBracketsList;
	}
	
	private int getLifeLineGdeTopPos() {
		return getGdeNode().getY();
	}
	void setLifeLineGdeTopPos(int y) {
		getGdeNode().setY(y);
	}
	private int getLifeLineGdeBottomPos() {
		return getGdeNode().getHeight() + getGdeNode().getY();
	}
    void setLifeLineGdeBottomPos(int y) {
		getGdeNode().setHeight(y - getGdeNode().getY());
		//{
		//	int height = y - getLineElement().getY();
		//	// debug!
		//	if (height > 10000) {
		//		throw new RuntimeException("Bad height: "+height);
		//	}
		//}
	}
	
    private final SDVerticalLayoutInputImpl.LifeLineElementGen myFirstLifeLineElement;
	private final SDVerticalLayoutInputImpl.LifeLineElementGen myLastLifeLineElement;
	private final BracketMetaObject myPseudoMetaObject;
	private final HeadLifeLineElement myHeadLifeLineElement;
    private final DetailsLayouter myDetailsLayouter;
    
    private LMExecutionOccurence myCreationExecution;
    private LMExecutionOccurence myDestructionExecution;
    private LMGenCallOccurence myBottomPosControoller;

    private class HeadLifeLineElement extends SDVerticalLayoutInputImpl.LifeLineElementGen implements LifeLineElement.Position {
		public HeadLifeLineElement(int preferredHeight) {
			super(0, preferredHeight/*GeometryConstants.Lifeline.HEIGHT + GeometryConstants.Lifeline.UNDER_HEAD_SPACE*/);
		}
        
        public int getSize() {
            if (myCreationExecution != null) {
                return 0;
            }
            return super.getSize();
        }
        
		public int getPositionValue() {
            return myDetailsLayouter.getHeadTopPos();
		}
		public void setPositionValue(int pos) {
		}
		public boolean isVirtual() {
			return true;
		}
        public LifeLine getLifeLine() {
            return getVerticalLayoutLifeLine();
        }
		public boolean isFirstPrioritedPosition() {
			return false;
		}
		public boolean isLastPrioritedPosition() {
			return false;
		}
		public Position getPosition() {
			return this;
		}
        public String toString() {
            return "Lifeline("+LMLifeLine.this+")head"; //$NON-NLS-1$ //$NON-NLS-2$
        }
	}
    
	private final LmBracketsList myChildBracketsList = new LmBracketsListSimple();
	
    private final LifeLine myVerticalLayoutLifeLine = new LifeLine() {
            public LifeLineIterator iterator() {
                return new SDVerticalLayoutInputImpl.LifeLineIteratorImpl(verticalLayoutElements());
            }
            public String toString() {
                return "LL:" + LMLifeLine.this; //$NON-NLS-1$
            }
        };
}
