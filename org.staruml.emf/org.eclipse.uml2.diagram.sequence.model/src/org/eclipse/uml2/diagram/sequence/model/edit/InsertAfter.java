package org.eclipse.uml2.diagram.sequence.model.edit;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;


public class InsertAfter<T> {
	private final List<T> myPast = new ArrayList<T>(5);
	
	public final ListIterator<T> getAfterThePastPosition(List<T> list) {
		if (myPast.isEmpty()) {
			return list.listIterator();
		}

		HashSet<T> notFound = new HashSet<T>();
		for (T next : myPast) {
			if (next == null) {
				continue;
			}
			notFound.add(next);
		}

		ListIterator<T> result = list.listIterator();
		while (!notFound.isEmpty() && result.hasNext()) {
			T next = result.next();
			notFound.remove(next);
		}
		return result;
	}

	public final void considerAsPast(T past) {
		if (past != null) {
			myPast.add(past);
		}
	}
}
