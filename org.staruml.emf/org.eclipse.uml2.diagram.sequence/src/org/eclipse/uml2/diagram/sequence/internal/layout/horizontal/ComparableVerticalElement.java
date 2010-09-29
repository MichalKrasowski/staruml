package org.eclipse.uml2.diagram.sequence.internal.layout.horizontal;

import java.util.Comparator;

/**
 * 
 */
interface ComparableVerticalElement {
	int getX();
	int getWidth();
    boolean hasNoBounds();
	
	final static Comparator COMPARATOR = new Comparator() {
		public int compare(Object arg1, Object arg2) {
			int x1 = getLifeLineMiddlePosition((ComparableVerticalElement)arg1);
			int x2 = getLifeLineMiddlePosition((ComparableVerticalElement)arg2);
			
			if (x1 == x2) {
				return 0;
			} else if (x1 > x2) {
				return 1;
			} else {
				return -1;
			}
		}
		private int getLifeLineMiddlePosition(ComparableVerticalElement sortableElement) {
			int x = sortableElement.getX();
			if (sortableElement.hasNoBounds() || x == 0) {
				// element with null position probably is just created; 
				// it should be placed after all other (already layouted) lifelines
				return Integer.MAX_VALUE;
			}
			return x + sortableElement.getWidth()/2;
		}

	};
}