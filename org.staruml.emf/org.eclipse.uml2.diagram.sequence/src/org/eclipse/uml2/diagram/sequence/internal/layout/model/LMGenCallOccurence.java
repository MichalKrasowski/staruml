package org.eclipse.uml2.diagram.sequence.internal.layout.model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsNode;
import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.input.HorizontalConstraint;
import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.input.LifeLine;
import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.input.LifeLineElement;
import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.input.OrderingConstraint;


/**
 * 
 */
public abstract class LMGenCallOccurence extends LMLifeLineBracket implements LMMessageEnd {
    LMGenCallOccurence(AbsNode gdeBracketNode, BracketMetaObject bracketMetaObject, LmOwner lmOwner) {
		super(gdeBracketNode, bracketMetaObject, lmOwner);
		
		myTopLifeLineElement = new BoundaryLifeLineElement(new BracketTopPosition(), bracketMetaObject.getTopOutSpace(), bracketMetaObject.getTopOutSpace()+bracketMetaObject.getTopInSpace())
		{
			public HorizontalConstraint getHorizontalConstraint() {
				if (myHorizontalConstraintCallMessage == null) {
					return null;
				} else {
					HorizontalConstraint result = myHorizontalConstraintCallMessage.getTopHorizontalConstraint();
					////assert
					//if (!result.getLifeLineElementsList().contains(this)) {
					//	throw new RuntimeException("Cannot find myself in constrained elements");
					//}
					return result;
				}
			}
			public int getSize() {
				return getTopOutSpace() + getTopInSpace();
			}
			public int getPointOffset() {
				return getTopOutSpace();
			}
            int getMessagesVerticalPosOffset() {
                return 0;
            }
            public String toString() {
                return getDebugId()+"-Top"; //$NON-NLS-1$
            }
		};
		myBottomLifeLineElement = new BoundaryLifeLineElement(new BracketBottomPosition(), bracketMetaObject.getBottomInSpace(), bracketMetaObject.getBottomInSpace()+bracketMetaObject.getBottomOutSpace())
		{
			public HorizontalConstraint getHorizontalConstraint() {
				if (myHorizontalConstraintCallMessage == null) {
					return null;
				} else {
					HorizontalConstraint result = myHorizontalConstraintCallMessage.getBottomHorizontalConstraint();
					////assert
					//if (!result.getLifeLineElementsList().contains(this)) {
					//	throw new RuntimeException("Cannot find myself in constrained elements");
					//}
					return result;
				}
			}
            protected void setPositionValue(int pos, boolean doNotReshapeMessages) {
                if (hasNoDuration()) {
                    pos = myTopLifeLineElement.getPositionValue()+getBracketMetaObject().getTopInSpace() + getBracketMetaObject().getBottomInSpace();
                }
                super.setPositionValue(pos, doNotReshapeMessages);
            }
            public boolean isVirtual() {
                return hasNoDuration() ;
            }
            int getMessagesVerticalPosOffset() {
                return -1;
            }
            public String toString() {
                return getDebugId()+"-Bottom"; //$NON-NLS-1$
            }
		};
	}
    
    LMLifeLineBracket getDestructionCandidate() {
        return getDestructionCandidateInCallOccurence();
    }
    LMLifeLineBracket getDestructionCandidateInCallOccurence() {
        if (getChildBracketsList().isEmpty()) {
            return null;
        }
        List listView = getChildBracketsList().getListView();
        LMLifeLineBracket lastBracket = (LMLifeLineBracket) listView.get(listView.size()-1);
        return lastBracket.getDestructionCandidateInCallOccurence();
    }

    void setLifelineToProvideBottomPos(LMLifeLine lifeLine) {
        myLifelineToProvideBottomPos = lifeLine;
    }
    
    public LMFrame getContainingFrame() {
        return super.getContainingFrame();
    }
    
    LMGenCallOccurence getContainingCallOccurence() {
        return this;
    }
    
    protected abstract String getDebugId();

	protected int getTopOutSpace() {
		return getBracketMetaObject().getTopOutSpace();
	}
	protected int getTopInSpace() {
		return getBracketMetaObject().getTopInSpace();
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
	public boolean isLimitedHorizontally() {
		return true;
	}
    protected void setBracketBottomPos(int pos) {
        if (myLifelineToProvideBottomPos != null) {
            myLifelineToProvideBottomPos.setLifeLineGdeBottomPos(pos);
        }
        super.setBracketBottomPos(pos);
    }
	public void addMessage(LMMessage lmMessage) {
		if (isMessageTopNotBottom(lmMessage)) {
			addTopMessage(lmMessage);
		} else {
			addBottomMessage(lmMessage);
		}
	}
	public void removeMessage(LMMessage lmMessage) {
		if (isMessageTopNotBottom(lmMessage)) {
			removeTopMessage(lmMessage);
		} else {
			removeBottomMessage(lmMessage);
		}
	}
    public void messageIsJustReshaped(LMMessage lmMessage, JustReshapedState justReshapedState) {
        boolean sendNotReceive = lmMessage.getSendMessageEnd() == this;
        boolean topNotBottom = isMessageTopNotBottom(lmMessage);
        
        boolean sourceNotDestination = ! sendNotReceive ^ topNotBottom;
        
        BoundaryLifeLineElement position;
        if (topNotBottom) {
            position = getTopBoundaryLifeLineElement(); 
        } else {   
            position = getBottomBoundaryLifeLineElement(); 
        }
        int pos = lmMessage.getLMMessageEndVerticalPosition(sourceNotDestination);

        position.setPositionValueFromMessage(pos);
        
        setJustReshaped(justReshapedState);
    }
	
	public LmBracketsList getChildBracketsList() {
		return myChildBracketsList;
	}
	
	protected boolean isMessageTopNotBottom(LMMessage lmMessage) {
		return lmMessage.isFromSendToReceive();
	}
    
    public boolean hasNoDuration() {
        return myChildBracketsList.isEmpty() && getBracketMetaObject().tieBottomToTop();
    }
	private void addTopMessage(LMMessage lmCallMessage) {
		getTopBoundaryLifeLineElement().getLMMesssagesList().add(lmCallMessage);
	}
	private void addBottomMessage(LMMessage lmReturnMessage) {
		getBottomBoundaryLifeLineElement().getLMMesssagesList().add(lmReturnMessage);
	}
	private void removeTopMessage(LMMessage lmCallMessage) {
		if (myHorizontalConstraintCallMessage == lmCallMessage) {
			throw new IllegalArgumentException("Cannot remove lmCallMessage, before it removed from constraints"); //$NON-NLS-1$
		}
		getTopBoundaryLifeLineElement().getLMMesssagesList().remove(lmCallMessage);
	}
	private void removeBottomMessage(LMMessage lmReturnMessage) {
		getBottomBoundaryLifeLineElement().getLMMesssagesList().remove(lmReturnMessage);
	}
	List getToplMessagesList() {
		return getTopBoundaryLifeLineElement().getLMMesssagesList();
	}
	
	public BoundaryLifeLineElement getBottomBoundaryLifeLineElement() {
		return myBottomLifeLineElement;
	}
	public BoundaryLifeLineElement getTopBoundaryLifeLineElement() {
		return myTopLifeLineElement;
	}

    protected int getBracketTopPos() {
        int result = super.getBracketTopPos();
        if (result == 0) {
            for (Iterator it = getTopBoundaryLifeLineElement().getLMMesssagesList().iterator(); it.hasNext(); ) {
            	LMMessage lmMessage = (LMMessage) it.next(); 
                boolean getGdeStartNotEnd = ! getLMMessageEndSourceNotDestination(lmMessage) ^ lmMessage.isFromSendToReceive();
                
                Point [] points = lmMessage.getGdeLink().getLinkPoints();
                if (points != null && points.length>0) {
                    int y;
                    if (getGdeStartNotEnd) {
                        y = points[0].y;
                    } else {   
                        y = points[points.length-1].y;
                    }
                    if (y != 0) {
                    	result = y;
                        break;
                    }
                }
            }
        }
        return result;
	}
    
	protected abstract boolean getLMMessageEndSourceNotDestination(LMMessage lmMessage);
	
	protected void setLMMessageEndVerticalPosition(LMMessage lmMessage, int pos, int siblingNumber) {
		boolean changeGdeStartNotEnd = ! getLMMessageEndSourceNotDestination(lmMessage) ^ lmMessage.isFromSendToReceive();
		
		lmMessage.setLMMessageEndVerticalPosition(pos, changeGdeStartNotEnd, siblingNumber);
	}
	

	
	public void setHorizontalPosition(int newPos) {
	}
	
	protected abstract class BoundaryLifeLineElement extends SDVerticalLayoutInputImpl.LifeLineElementSizeAdapter implements LifeLineElement.Position, LMMessageEnd.ConnectableLifeLineElement {
		public BoundaryLifeLineElement(LifeLineElement.Position gdeElementPosition, int offset, int size) {
			super(offset, size);
			myGdeElementPosition = gdeElementPosition;
		}
		public int getPositionValue() {
			return myGdeElementPosition.getPositionValue();
		}
        public void setPositionValue(int pos) {
            setPositionValue(pos, false);
        }
        void setPositionValueFromMessage(int messagePos) {
            int pos = messagePos - getMessagesVerticalPosOffset();
            setPositionValue(pos, true);
        }
        
		public boolean isVirtual() {
			return false;
		}
		public boolean isFirstPrioritedPosition() {
			return myGdeElementPosition.isFirstPrioritedPosition();
		}
		public boolean isLastPrioritedPosition() {
			return myGdeElementPosition.isLastPrioritedPosition();
		}

        public LifeLine getLifeLine() {
            LMLifeLine lmLifeLine = LMGenCallOccurence.this.getLifeLine();
            return lmLifeLine.getVerticalLayoutLifeLine();
        }

		public Position getPosition() {
			return this;
		}
		
		List getLMMesssagesList() {
			return myLMMessages;
		}
		
		
		public Enumeration afterConstraints() {
			return myOrderingConstraintHolder.afterConstraints();
		}
		public Enumeration beforeConstraints() {
			return myOrderingConstraintHolder.beforeConstraints();
		}
		
		public void addAfterConstraint(OrderingConstraint orderingConstraint) {
			myOrderingConstraintHolder.addAfterConstraint(orderingConstraint);
		}
		public void addBeforeConstraint(OrderingConstraint orderingConstraint) {
			myOrderingConstraintHolder.addBeforeConstraint(orderingConstraint);
		}
		public void removeAfterConstraint(OrderingConstraint orderingConstraint) {
			myOrderingConstraintHolder
					.removeAfterConstraint(orderingConstraint);
		}
		public void removeBeforeConstraint(OrderingConstraint orderingConstraint) {
			myOrderingConstraintHolder
					.removeBeforeConstraint(orderingConstraint);
		}
        abstract int getMessagesVerticalPosOffset();
		
        protected void setPositionValue(int pos, boolean doNotReshapeMessages) {
            //System.out.println("[LMLifeLineBracket.setPositionValue] to "+pos+", messages="+myLMMessages);
            myGdeElementPosition.setPositionValue(pos);
            if (!doNotReshapeMessages) {
                int posForMessage = pos + getMessagesVerticalPosOffset();
                for (int i=0; i<myLMMessages.size(); i++) {
                    LMMessage lmMessage = (LMMessage) myLMMessages.get(i);
                    setLMMessageEndVerticalPosition(lmMessage, posForMessage, i);
                }
            }
        }
        
		private final LifeLineElement.Position myGdeElementPosition;
		private List myLMMessages = new ArrayList(1);
		private final SDVerticalLayoutInputImpl.OrderingConstraintHolder myOrderingConstraintHolder = new SDVerticalLayoutInputImpl.OrderingConstraintHolder();
	}
	
	private final BoundaryLifeLineElement myTopLifeLineElement;
	private final BoundaryLifeLineElement myBottomLifeLineElement;
	private final LmBracketsList myChildBracketsList = new LmBracketsListSimple();
	
	private LMCallMessageSynch myHorizontalConstraintCallMessage = null;
	
    private LMLifeLine myLifelineToProvideBottomPos;

	protected class PositioningGen implements LMMessageEnd.VerticalConstraintedPositioning {

		public boolean canSetMessageAsHorizontalConstraint(LMCallMessageSynch lmCallMessageSynch) {
			return myHorizontalConstraintCallMessage == null;
		}
		public void setMessageAsHorizontalConstraint(LMCallMessageSynch lmCallMessageSync, boolean isConstraint) {
			if (isConstraint) {
				if (myHorizontalConstraintCallMessage != null) {
					throw new RuntimeException("Horizontal constraint is already set"); //$NON-NLS-1$
				}
				myHorizontalConstraintCallMessage = lmCallMessageSync;
				
				if (false) {
					//assert
					myTopLifeLineElement.getHorizontalConstraint();
					myBottomLifeLineElement.getHorizontalConstraint();
				}
			} else {
				if (myHorizontalConstraintCallMessage != lmCallMessageSync) {
					throw new RuntimeException("Cannot reset ANOTHER horizontal constraint"); //$NON-NLS-1$
				}
				myHorizontalConstraintCallMessage = null;
			}
		}
		
		public boolean hasMessageAsHorizontalConstraint(LMCallMessageSynch lmCallMessageSynch) {
			return myHorizontalConstraintCallMessage == lmCallMessageSynch;
		}

		public LMMessageEnd.ConnectableLifeLineElement getTopLifeLineElement() {
			return getTopBoundaryLifeLineElement();
		}
		public LifeLineElement getBottomLifeLineElement() {
            if (hasNoDuration()) {
                //bottom position is constrained by top position 
                //and cannot participate in horizontal constraints
                return null;                
            }
			return getBottomBoundaryLifeLineElement();
		}

		public LMLifeLine getLifeLine() {
			return LMGenCallOccurence.this.getLifeLine();
		}
	}
    
    protected boolean calculateIsBracketConsistent() {
        return super.calculateIsBracketConsistent() && isIncomingOutgoingMessagesOK();
    }
    
    protected boolean isIncomingOutgoingMessagesOK() {
        List topMessages = getTopBoundaryLifeLineElement().getLMMesssagesList();
        List bottomMessages = getBottomBoundaryLifeLineElement().getLMMesssagesList();
        int sumSize = topMessages.size()+bottomMessages.size();
        if (sumSize==0) {
            return false;
        }
        if (sumSize>2) {
            return false;
        }
        return true;
    }
}
