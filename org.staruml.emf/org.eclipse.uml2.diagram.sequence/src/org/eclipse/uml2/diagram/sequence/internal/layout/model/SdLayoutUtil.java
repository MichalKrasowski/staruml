package org.eclipse.uml2.diagram.sequence.internal.layout.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsNode;
import org.eclipse.uml2.diagram.sequence.internal.missed.MissedMethods;


/**
 * 
 */
class SdLayoutUtil {
	static void assertCorrectSubList(List list, List subList) {
		Iterator it = list.iterator();
		Iterator subIt = subList.iterator();
		
		mainCycle:
		while (subIt.hasNext()) {
			Object o1 = subIt.next();
			
			while (it.hasNext()) {
				Object o2 = it.next();
				if (o2 == o1) {
					continue mainCycle;
				}
			}
			throw new RuntimeException("Cannot find element "+o1+" from subList "+subList+" in list "+list); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		}
	}
	
	/**
	 * @return "oldIndexList"
	 */
	static List<Integer> getReorderAgainstModel(List<LMBracketContainer> elements, View containerView) {
		LinkedHashMap<EObject,Integer> entity2bracketIndex = new LinkedHashMap<EObject,Integer>();
		
		int index = 0;
		for (Iterator<LMBracketContainer> it=elements.iterator(); it.hasNext(); ) {
			LMBracketContainer bracket1 = it.next();
			AbsNode node1 = bracket1.getGdeNode();
			EObject nodeEntity1 = node1.getModelEntity();
			Integer anotherBracketIndex = entity2bracketIndex.put(nodeEntity1, index);
			if (anotherBracketIndex != null) {
				throw new RuntimeException("In container 2 brackets are associated with one entity"); //$NON-NLS-1$
			}
			index ++;
		}

		List<Integer> oldIndexList = new ArrayList<Integer>(elements.size());
		
		for (EObject nextEntity : MissedMethods._arcasMetamodelSpecific().getArcasMetamodelChildren(containerView)) {						
			Integer oldIndex = entity2bracketIndex.remove(nextEntity);
			if (oldIndex != null) {
				oldIndexList.add(oldIndex);
			}
		}
		oldIndexList.addAll(entity2bracketIndex.values());
		
		return oldIndexList;
	}

	static <T> void reorderList(List<Integer> oldIndexList, List<T> myList) {
		if (myList.size() != oldIndexList.size()) {
			throw new RuntimeException("Wrong number of elements to replace"); //$NON-NLS-1$
		}
		
		List<T> newBracketsList = new ArrayList<T>(myList.size());
		
		for (Iterator<Integer> it = oldIndexList.iterator(); it.hasNext(); ) {
			Integer oldIndex = it.next();
			int index = oldIndex.intValue();
			newBracketsList.add(myList.get(index));
		}
		
		myList.clear();
		myList.addAll(newBracketsList);
	}
}
