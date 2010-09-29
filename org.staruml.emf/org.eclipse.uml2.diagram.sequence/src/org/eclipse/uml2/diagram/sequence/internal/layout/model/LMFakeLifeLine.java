package org.eclipse.uml2.diagram.sequence.internal.layout.model;

import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.input.LifeLine;
import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.input.LifeLineElement;
import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.input.LifeLineIterator;

/**
 * 
 */
public class LMFakeLifeLine implements SDVerticalLayoutInputImpl.LifeLineSupply {
	LMFakeLifeLine(int height) {
		myFirstLifeLineElement = new SDVerticalLayoutInputImpl.LifeLineElementGenAdapter(0, 0, DUMB_POSITION, this) {
            public String toString() {
                return "FakeLifelineElement:Top"; //$NON-NLS-1$
            }
        };
		myLastLifeLineElement = new SDVerticalLayoutInputImpl.LifeLineElementGenAdapter(0, 0, DUMB_POSITION, this) {
            public String toString() {
                return "FakeLifelineElement:Bottom"; //$NON-NLS-1$
            }
        };
		
		myPseudoObjectElement = new SDVerticalLayoutInputImpl.LifeLineElementGenAdapter(0, height, DUMB_POSITION, this);
	}
	
	private SDVerticalLayoutInputImpl.NullFreeIterator verticalLayoutElements() {
		return new SDVerticalLayoutInputImpl.NullFreeIteratorForArray(3) {
			protected Object get(int pos) {
				switch (pos) {
					case 0: return myFirstLifeLineElement;
					case 1: return myPseudoObjectElement;
					case 2: return myLastLifeLineElement;
				}
				throw new IndexOutOfBoundsException();
			}
		};
	}

    public LifeLine getVerticalLayoutLifeLine() {
        return myVerticalLayoutLifeLine;
    }

	SDVerticalLayoutInputImpl.LifeLineElementGen getFirstLifeLineElement() {
		return myFirstLifeLineElement;
	}
	SDVerticalLayoutInputImpl.LifeLineElementGen getLastLifeLineElement() {
		return myLastLifeLineElement;
	}
    
    public String toString() {
        return "LMFakeLifeline"; //$NON-NLS-1$
    }
	
	private final SDVerticalLayoutInputImpl.LifeLineElementGen myPseudoObjectElement;
	private final SDVerticalLayoutInputImpl.LifeLineElementGen myFirstLifeLineElement;
	private final SDVerticalLayoutInputImpl.LifeLineElementGen myLastLifeLineElement;
    private final LifeLine myVerticalLayoutLifeLine = new LifeLine() {
            public LifeLineIterator iterator() {
                return new SDVerticalLayoutInputImpl.LifeLineIteratorImpl(verticalLayoutElements());
            }
            public String toString() {
                return "LL:" + LMFakeLifeLine.this; //$NON-NLS-1$
            }
        };
        
    private final static LifeLineElement.Position DUMB_POSITION = new LifeLineElement.Position() {
		public int getPositionValue() {
			return 0;
		}
		public void setPositionValue(int pos) {
		}
		public boolean isVirtual() {
			return true;
		}
		public boolean isFirstPrioritedPosition() {
			return false;
		}
		public boolean isLastPrioritedPosition() {
			return false;
		}
    };
}
