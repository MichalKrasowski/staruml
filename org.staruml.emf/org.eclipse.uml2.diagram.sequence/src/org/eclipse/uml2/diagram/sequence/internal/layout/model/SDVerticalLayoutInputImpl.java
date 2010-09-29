package org.eclipse.uml2.diagram.sequence.internal.layout.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;

import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsNode;
import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.input.HorizontalConstraint;
import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.input.LifeLine;
import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.input.LifeLineElement;
import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.input.LifeLineIterator;
import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.input.OrderingConstraint;
import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.input.SDVerticalLayoutInput;
import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.input.LifeLineElement.Position;
import org.eclipse.uml2.diagram.sequence.internal.missed.EmptyEnumeration;


/**
 * 
 */
public class SDVerticalLayoutInputImpl implements SDVerticalLayoutInput {
	interface LifeLineSupply {
        LifeLine getVerticalLayoutLifeLine();
	}
	
	public SDVerticalLayoutInputImpl(SDLayoutModel sdLayoutModel) {
		mySDLayoutModel = sdLayoutModel;
	}
    
    /**
     * Vertical layout input always contain virtual lifeline, which constraints minimum
     * length of other lifelines.
     */
    public boolean doesContainNonvirtual() {
        return mySDLayoutModel.getLifeLinesList().size() != 1;
    }
	
	public Enumeration lifeLines() {
		List lmLifelines = mySDLayoutModel.getLifeLinesList();
		List resultList = new ArrayList(lmLifelines.size());
		for (Iterator it = lmLifelines.iterator(); it.hasNext(); ) {
			
			final LifeLineSupply lifeLineSupply1 = (LifeLineSupply) it.next();

            resultList.add(lifeLineSupply1.getVerticalLayoutLifeLine());

		}
		return Collections.enumeration(resultList);
	}


	public interface NullFreeIterator {
		Object next();
	}

	public static abstract class NullFreeIteratorForArray implements NullFreeIterator {
		protected NullFreeIteratorForArray() {
			this(-1);
		}
		protected NullFreeIteratorForArray(int arraySize) {
			myArraySize = arraySize;
		}
		protected abstract Object get(int pos);
		public Object next() {
			if (myPos == myArraySize) {
				return null;
			}
			Object result = get(myPos);
			if (result != null) {
				myPos++;
			}
			return result;
		}
		private int myPos = 0;
		private final int myArraySize;
	}

	public static class NullFreeIteratorWrapper implements NullFreeIterator {
		protected NullFreeIteratorWrapper(Iterator iterator) {
			myIterator = iterator;
		}
		public Object next() {
			if (myIterator.hasNext()) {
				return myIterator.next();
			} else {
				return null;
			}
		}
		private final Iterator myIterator;
	}
	
	

    static class ContainerPosition implements Position {
        public int getPositionValue() {
            return myValue;
        }
        public void setPositionValue(int pos) {
            myValue = pos;
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
        private int myValue;
    }
	static abstract class ElementTopPosition implements Position {
		public ElementTopPosition(AbsNode gdeNode) {
			myGdeNode = gdeNode;
		}
		public int getPositionValue() {
			return myGdeNode.getY();
		}
		public void setPositionValue(int pos) {
			myGdeNode.setY(pos);
		}
		private final AbsNode myGdeNode;
	}
	static abstract class ElementBottomPosition implements Position {
		public ElementBottomPosition(AbsNode gdeNode) {
			myGdeNode = gdeNode;
		}
		public int getPositionValue() {
			return myGdeNode.getY() + myGdeNode.getHeight();
		}
		public void setPositionValue(int pos) {
			myGdeNode.setHeight(pos - myGdeNode.getY());
		}
		private final AbsNode myGdeNode;
	}

	static abstract class LifeLineElementSizeAdapter implements LifeLineElement {
		public LifeLineElementSizeAdapter(int pointOffset, int size) {
			myPointOffset = pointOffset;
			mySize = size;
		}
        public void optimizeSize() {
            //do nothing by default
        }
		public int getPointOffset() {
			return myPointOffset;
		}
		public int getSize() {
			return mySize;
		}
		public Enumeration beforeConstraints() {
			return EmptyEnumeration.getEnumeration();
		}
		public Enumeration afterConstraints() {
			return EmptyEnumeration.getEnumeration();
		}

		private final int myPointOffset;
		private final int mySize;
	}
	static abstract class LifeLineElementGen extends LifeLineElementSizeAdapter {
		public LifeLineElementGen(int pointOffset, int size) {
			super(pointOffset, size);
		}
		public HorizontalConstraint getHorizontalConstraint() {
			return myHorizontalConstraint;
		}
		public void setHorizontalConstraint(HorizontalConstraint constraint) {
			if (myHorizontalConstraint != null && constraint != null) {
				throw new IllegalStateException("Cannot set horizontal constraint, already has one"); //$NON-NLS-1$
			}
			myHorizontalConstraint = constraint;
		}

		private HorizontalConstraint myHorizontalConstraint = null;
	}
	static class LifeLineElementGenAdapter extends LifeLineElementGen {
        protected LifeLineElementGenAdapter(int pointOffset, int size, LifeLineElement.Position position, final LMLifeLineBracket lifeLineBracket) {
            this(pointOffset
                    , size
                    , position
                    , new LifeLineSupply() { public LifeLine getVerticalLayoutLifeLine() { return lifeLineBracket.getLifeLine().getVerticalLayoutLifeLine(); } }
            );
        }
		protected LifeLineElementGenAdapter(int pointOffset, int size, LifeLineElement.Position position, LifeLineSupply lifeLineSupply) {
			super(pointOffset, size);
			myPosition = position;
            myLifeLineSupply = lifeLineSupply;

		}
        public LifeLine getLifeLine() {
            return myLifeLineSupply.getVerticalLayoutLifeLine();
        }

		public Position getPosition() {
			return myPosition;
		}
		private final LifeLineElement.Position myPosition;
        private final LifeLineSupply myLifeLineSupply;
	}


	static class OrderingConstraintHolder {
		public Enumeration afterConstraints() {
			if (myAfterConstraints == null) {
				return Collections.enumeration(Collections.EMPTY_LIST);
			} else {
				return Collections.enumeration(myAfterConstraints);
			}
		}
		public Enumeration beforeConstraints() {
			if (myBeforeConstraints == null) {
				return Collections.enumeration(Collections.EMPTY_LIST);
			} else {
				return Collections.enumeration(myBeforeConstraints);
			}
		}
		
		public void addAfterConstraint(OrderingConstraint orderingConstraint) {
			if (myAfterConstraints == null) {
				myAfterConstraints = new ArrayList(2);
			}
			myAfterConstraints.add(orderingConstraint);
		}
		public void addBeforeConstraint(OrderingConstraint orderingConstraint) {
			if (myBeforeConstraints == null) {
				myBeforeConstraints = new ArrayList(2);
			}
			myBeforeConstraints.add(orderingConstraint);
		}
		public void removeAfterConstraint(OrderingConstraint orderingConstraint) {
			if (myAfterConstraints == null) {
				throw new RuntimeException("Cannot remove constraint"); //$NON-NLS-1$
			}
			if (!myAfterConstraints.remove(orderingConstraint)) {
				throw new RuntimeException("Cannot remove constraint"); //$NON-NLS-1$
			}
		}
		public void removeBeforeConstraint(OrderingConstraint orderingConstraint) {
			if (myBeforeConstraints == null) {
				throw new RuntimeException("Cannot remove constraint"); //$NON-NLS-1$
			}
			if (!myBeforeConstraints.remove(orderingConstraint)) {
				throw new RuntimeException("Cannot remove constraint"); //$NON-NLS-1$
			}
		}
		private List myBeforeConstraints = null;
		private List myAfterConstraints = null;
	}


	public static class LifeLineIteratorImpl implements LifeLineIterator {
		public LifeLineIteratorImpl(NullFreeIterator nfIterator) {
			myNFIteratorStack.push(nfIterator);
			advance();
		}

		public Integer nextClueValue() {
			if (myNextElement == null) {
				throw new NoSuchElementException();
			}
			if (myClueAsked) {
				throw new IllegalStateException("Element should be asked now"); //$NON-NLS-1$
			}
			myClueAsked = true;
			if (myNextClueValue == null) {
				return our1ClueValue;
			} else {
				return myNextClueValue;
			}
		}
		public LifeLineElement nextElement() {
			if (myNextElement == null) {
				throw new NoSuchElementException();
			}
			if (!myClueAsked) {
				throw new IllegalStateException("Clue should be asked now"); //$NON-NLS-1$
			}
			try {
				return myNextElement;
			} finally {
				advance();
				myClueAsked = false;
			}
		}
		public boolean hasNext() {
			return myNextElement != null;
		}

		private void advance() {
			myNextClueValue = null;
			while (!myNFIteratorStack.empty()) {
				NullFreeIterator it1 = (NullFreeIterator) myNFIteratorStack.peek();
				Object nextObject = it1.next();
				if (nextObject == null) {
					myNFIteratorStack.pop();
				} else if (nextObject instanceof NullFreeIterator) {
					myNFIteratorStack.push(nextObject);
				} else if (nextObject instanceof Integer) {
					Integer nextClueValue = (Integer)nextObject;
					if (myNextClueValue == null || myNextClueValue.intValue()<nextClueValue.intValue()) {
						myNextClueValue = nextClueValue;
					}
				} else {
					myNextElement = (LifeLineElement)nextObject;
				    return;
				}
			}
			myNextElement = null;
		}

		private boolean myClueAsked = false;
		private Integer myNextClueValue;
		private LifeLineElement myNextElement;
		private final Stack myNFIteratorStack = new Stack();

	}


	private final SDLayoutModel mySDLayoutModel;

	private final static Integer our1ClueValue = new Integer(1);

//	private static class HorizontalConstraintImpl implements HorizontalConstraint {
//		public List getLifeLineElementsList() {
//			return myImmutableList;
//		}
//		public List getLifeLineElementsMutableList() {
//			return myElementsList;
//		}
//		public void elementIsViolated(LifeLineElement lifeLineElement) {
//			System.out.println("[SDVerticalLayoutInputImpl] elementIsViolated");
//		}
//		public void elementIsResolved(LifeLineElement lifeLineElement) {
//		}
//
//		private List myElementsList = new ArrayList();
//		private List myImmutableList = Collections.unmodifiableList(myElementsList);
//	}
}
