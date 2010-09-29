package org.eclipse.uml2.diagram.sequence.internal.layout.vertical.input;

/**
 * 
 */
public interface LifeLineIterator {
	Integer nextClueValue();
	LifeLineElement nextElement();
	/**
	 * Always first element is a clue, second is element, next is clue etc. Last iterated is
	 * element. This method should be called before <code>nextClueValue</code> call.
	 */
	boolean hasNext();
    
    Integer NULL_CLUE = new Integer(0);
}
