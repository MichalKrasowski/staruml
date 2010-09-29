package org.eclipse.uml2.diagram.sequence.internal.layout.model;

import java.util.Iterator;
import java.util.List;

/**
 * 
 */
public interface LmBracketsList {
	List getListView();
	
	Iterator iterator();

	int size();

	void reorderList(List oldIndexList);

	void add(LMLifeLineBracket lifeLineBracket);

	void remove(LMLifeLineBracket lifeLineBracket);

	boolean isEmpty();

	void removeAll();
}
