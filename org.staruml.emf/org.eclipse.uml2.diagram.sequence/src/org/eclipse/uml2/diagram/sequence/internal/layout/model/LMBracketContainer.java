package org.eclipse.uml2.diagram.sequence.internal.layout.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsNode;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsNodeEnumeration;
import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.input.LifeLineElement;
import org.eclipse.uml2.diagram.sequence.internal.missed.MissedMethods;


/**
 * 
 */
public abstract class LMBracketContainer implements LmReshapable, SelfReorderable {
	LMBracketContainer(AbsNode gdeNode, LmOwner lmOwner) {
		myGdeNode = gdeNode;
        myLmOwner = lmOwner;
	}
	
	public abstract LmBracketsList getChildBracketsList();
	
	public AbsNode getGdeNode() {
		return myGdeNode;
	}
	
	abstract LMLifeLine getLifeLine();
    abstract LMFrame getContainingFrame();
    
    abstract LMGenCallOccurence getContainingCallOccurence();

    abstract LMLifeLineBracket getCreationCandidate();
    
    abstract LMLifeLineBracket getDestructionCandidate();
    
	protected class ChildBracketsNFIterator implements SDVerticalLayoutInputImpl.NullFreeIterator {
		private final Iterator myIterator = getChildBracketsList().iterator();
		/*{
			assertChildBracketsInCorrectOrder();
			
			for (Iterator it = getChildBracketsList().iterator(); it.hasNext(); ) {
				LMLifeLineBracket bracket1 = (LMLifeLineBracket) it.next();
				if (bracket1.getContainer() != LMBracketContainer.this) {
					throw new RuntimeException("Bad container of "+bracket1+" : "+bracket1.getContainer()); 
				}
			}
		}
*/		public Object next() {
			if (!myIterator.hasNext()) {
				return null;
			}
			LMLifeLineBracket bracket1 = (LMLifeLineBracket) myIterator.next();
			return bracket1.verticalLayoutElements();
		}
	}
	
	abstract LMLifeLineBracket createChildBracketInstance(AbsNode gdeNode, View reference);
	
	protected abstract Integer getClueValue();
	
	void assertChildBracketsInCorrectOrder() {
		if (myLmOwner.reorderAgainstModelNotGde()) {
		
			assertLmOrderAgainstModel();
			
		} else {
		
			assertGdeOrderAgainstModel();
			assertLmOrderAgainstGde();
		
		}
	}
		
	private void assertGdeOrderAgainstModel() {
		EObject entity = getGdeNode().getModelEntity();
	
        if (entity == null) {
        	return;
        }
        
		List modelChildren = MissedMethods._arcasMetamodelSpecific().getArcasMetamodelChildren(getGdeNode().getReference()); 
		
		Set modelChildrenSet = new HashSet(modelChildren);
		
		List gdeOrderOfModelChildren = new ArrayList();


		
		for (AbsNodeEnumeration gdeNodeEnum = getGdeNode().subnodes(); gdeNodeEnum.hasMoreElements(); ) {
			AbsNode node1 = gdeNodeEnum.nextGdeNode();
			EObject nodeEntity1 = node1.getModelEntity();
			if (modelChildrenSet.contains(nodeEntity1)) {
				gdeOrderOfModelChildren.add(nodeEntity1);
			}
		}
		
		try {
			SdLayoutUtil.assertCorrectSubList(modelChildren, gdeOrderOfModelChildren);
		} catch (RuntimeException e) {
			throw new RuntimeException("Problem asserting order gde-model (updater-gde problem, probably)", e); //$NON-NLS-1$
		}
	}
	
	private void assertLmOrderAgainstModel() {
        EObject entity = getGdeNode().getModelEntity();
        
        if (entity == null) {
        	return;   
        }
        
		List entities = new ArrayList();
		for (Iterator it=getChildBracketsList().iterator(); it.hasNext(); ) {
			LMLifeLineBracket bracket1 = (LMLifeLineBracket) it.next();
			AbsNode node1 = bracket1.getGdeNode();
            EObject nodeEntity1 = node1.getModelEntity();
            if (nodeEntity1 == null) {
            	//throw new RuntimeException("Cannot get model entity from "+bracket1);
                continue;
            }
			entities.add(nodeEntity1);
		}

		List realEntitiesList = MissedMethods._arcasMetamodelSpecific().getArcasMetamodelChildren(getGdeNode().getReference());
		//System.out.println("[LMBracketContainer.assertChildBracketsInCorrectOrder] realEntitiesList="+realEntitiesList);
		//System.out.println("[LMBracketContainer.assertChildBracketsInCorrectOrder] entities="+entities);
		try {
			SdLayoutUtil.assertCorrectSubList(realEntitiesList, entities);
		} catch (RuntimeException e) {
			throw new RuntimeException("Problem asserting order against model (lm reorder problem, probably)", e); //$NON-NLS-1$
		}
	}
	private void assertLmOrderAgainstGde() {
		List gdeNodes = new ArrayList();
		for (Iterator it=getChildBracketsList().iterator(); it.hasNext(); ) {
			LMLifeLineBracket bracket1 = (LMLifeLineBracket) it.next();
			AbsNode node1 = bracket1.getGdeNode();
			gdeNodes.add(node1);
		}

		try {
			SdLayoutUtil.assertCorrectSubList(Collections.list(getGdeNode().subnodes()), gdeNodes);
		} catch (RuntimeException e) {
			throw new RuntimeException("Problem asserting order against gde (our problem, probably)", e); //$NON-NLS-1$
		}
	}
	
	public void reorderChildElements() {
		if (myLmOwner.reorderAgainstModelNotGde()) {
		
			LinkedHashMap entity2bracketIndex = new LinkedHashMap();
	
			List oldGdeOrder = new ArrayList();
			
			int index = 0;
			for (Iterator it=getChildBracketsList().iterator(); it.hasNext(); ) {
				LMLifeLineBracket bracket1 = (LMLifeLineBracket) it.next();
				AbsNode node1 = bracket1.getGdeNode();
				oldGdeOrder.add(node1);
				EObject nodeEntity1 = node1.getModelEntity();
				Integer anotherBracketIndex = (Integer) entity2bracketIndex.put(nodeEntity1, new Integer(index));
				if (anotherBracketIndex != null) {
					throw new RuntimeException("In container 2 brackets are associated with one entity"); //$NON-NLS-1$
				}
				index ++;
			}
	
			List oldIndexList = new ArrayList(getChildBracketsList().size());
			
			View reference = getGdeNode().getReference();
			for (EObject nextEntity : MissedMethods._arcasMetamodelSpecific().getArcasMetamodelChildren(reference)) {
				Integer oldIndex = (Integer) entity2bracketIndex.remove(nextEntity);
				if (oldIndex != null) {
					oldIndexList.add(oldIndex);
				}
			}
			oldIndexList.addAll(entity2bracketIndex.values());
//			List oldOrder = new ArrayList(getChildBracketsList().getListView());
			getChildBracketsList().reorderList(oldIndexList);
//			List newOrder = new ArrayList(getChildBracketsList().getListView());
		
			//assertChildBracketsInCorrectOrder();
		
		} else {
		
			LinkedHashMap gdeNode2bracketIndex = new LinkedHashMap();
	
			int index = 0;
			for (Iterator it=getChildBracketsList().iterator(); it.hasNext(); ) {
				LMLifeLineBracket bracket1 = (LMLifeLineBracket) it.next();
				AbsNode node1 = bracket1.getGdeNode();
				Integer anotherBracketIndex = (Integer) gdeNode2bracketIndex.put(node1, new Integer(index));
				if (anotherBracketIndex != null) {
					throw new RuntimeException("In container 2 brackets are associated with one gde node"); //$NON-NLS-1$
				}
				index ++;
			}
	
			List oldIndexList = new ArrayList(getChildBracketsList().size());
			
			for (AbsNodeEnumeration gdeNodeEnum = getGdeNode().subnodes(); gdeNodeEnum.hasMoreElements(); ) {
				AbsNode gdeNode1 = gdeNodeEnum.nextGdeNode();
				Integer oldIndex = (Integer) gdeNode2bracketIndex.remove(gdeNode1);
				if (oldIndex != null) {
					oldIndexList.add(oldIndex);
				}
			}
			oldIndexList.addAll(gdeNode2bracketIndex.values());
			//List oldOrder = new ArrayList(getChildBracketsList().getListView());
			getChildBracketsList().reorderList(oldIndexList);
			//List newOrder = new ArrayList(getChildBracketsList().getListView());
			//try {
			//assertChildBracketsInCorrectOrder();
			//} catch (RuntimeException e) {
			//	throw new RuntimeException("Problem with reordering,\noldOrder="+oldOrder+",\nnewOrder="+newOrder+",\nreordering indices="+oldIndexList, e);
			//}
			
		}
	
	}

    public void reorderAfterReading() {
        if (myLmOwner.reorderAgainstModelNotGde()) {
            reorderChildElements();
        }
    }

    public void setJustReshaped(JustReshapedState justReshapedState) {
        myJustReshapedState = justReshapedState;
	}
	protected boolean isJustReshaped() {
        if (myJustReshapedState == null) {
        	return false;
        }
		return myJustReshapedState.isStillJustReshaped();
	}
	private JustReshapedState myJustReshapedState = null;
	
	
    protected void setBracketTopPos(int pos) {
        getGdeNode().setY(pos);
    }
    protected void setBracketBottomPos(int pos) {
        getGdeNode().setHeight(pos - getGdeNode().getY());
    }
    protected int getBracketTopPos() {
        return getGdeNode().getY();
    }
    protected int getBracketBottomPos() {
        return getGdeNode().getY() + getGdeNode().getHeight();
    }
    protected LmOwner getLmOwner() {
        return myLmOwner;
    }
	
	private final AbsNode myGdeNode;
    private final LmOwner myLmOwner;
	
	
	
	protected class BracketTopPosition implements LifeLineElement.Position {
		public int getPositionValue() {
			return getBracketTopPos();
		}
		public void setPositionValue(int pos) {
            setBracketTopPos(pos);
		}
		public boolean isVirtual() {
			return false;
		}
		public boolean isFirstPrioritedPosition() {
			return isJustReshaped(); 
		}
		public boolean isLastPrioritedPosition() {
			return false;
		}
	}
	protected class BracketBottomPosition implements LifeLineElement.Position {
		public int getPositionValue() {
			return getBracketBottomPos();
		}
		public void setPositionValue(int pos) {
            setBracketBottomPos(pos);
		}
		public boolean isVirtual() {
			return false;
		}
		public boolean isFirstPrioritedPosition() {
			return false;
		}
		public boolean isLastPrioritedPosition() {
			return isJustReshaped(); 
		}
	}
}
