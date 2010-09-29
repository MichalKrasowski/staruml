package org.eclipse.uml2.diagram.sequence.internal.layout.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * 
 */
public class LmBracketsListSimple implements LmBracketsList {
	public Iterator iterator() {
		return myUnmodifableList.iterator();
	}

	public int size() {
		return myList.size();
	}

	public void reorderList(List oldIndexList) {
		if (myList.size() != oldIndexList.size()) {
			throw new RuntimeException("Wrong number of elements to replace"); //$NON-NLS-1$
		}
		
		List newBracketsList = new ArrayList(myList.size());
		
		for (Iterator it = oldIndexList.iterator(); it.hasNext(); ) {
			Integer oldIndex = (Integer) it.next();
			int index = oldIndex.intValue();
			newBracketsList.add(myList.get(index));
		}
		
		myList.clear();
		myList.addAll(newBracketsList);
	}
	public void add(LMLifeLineBracket lifeLineBracket) {
		myList.add(lifeLineBracket);
	}

	public void remove(LMLifeLineBracket lifeLineBracket) {
		boolean res = myList.remove(lifeLineBracket);
		if (!res) {
			throw new RuntimeException("Failed to remove bracket from list"); //$NON-NLS-1$
		}
	}

	public boolean isEmpty() {
		return myList.isEmpty();
	}

	public void removeAll() {
		myList.clear();
	}
	
	public List getListView() {
		return myUnmodifableList;
	}
	
	private final List myList = new ArrayList();
	private final List myUnmodifableList = Collections.unmodifiableList(myList);
}
