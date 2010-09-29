package org.eclipse.uml2.diagram.sequence.internal.layout.model;


import java.awt.Color;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsElementPropertyAccess;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsNode;


/**
 * 
 */
public abstract class LMLifeLineBracket extends LMBracketContainer {
    LMLifeLineBracket(AbsNode gdeBracketNode, BracketMetaObject bracketMetaObject, LmOwner lmOwner) {
		super(gdeBracketNode, lmOwner);
		myBracketMetaObject = bracketMetaObject;
		myEntity = gdeBracketNode.getModelEntity();
        myBracketHorizontalLayouter = AbsElementPropertyAccess.getInstance().getLifelineBracketHorizontalLayouter(gdeBracketNode);
	}
    
    public interface LifelineBracketHorizontalLayouter {
        void setHorizontalPositions(int x, int paintableWidth, int containerWidth);
    }
    
    public LifelineBracketHorizontalLayouter getBracketHorizontalLayouter() {
        return myBracketHorizontalLayouter;
    }
    
    LMLifeLineBracket getCreationCandidate() {
        return this;
    }
    
    LMLifeLineBracket getDestructionCandidateInCallOccurence() {
        return null;
    }
    
    LMGenCallOccurence getContainingCallOccurence() {
        if (myContainer == null) {
            throw new RuntimeException("Has no container"); //$NON-NLS-1$
        }
        return myContainer.getContainingCallOccurence();
    }
    
    LMFrame getContainingFrame() {
        return getContainer().getContainingFrame();
    }
        
	LMLifeLineBracket createChildBracketInstance(AbsNode gdeNode, View reference) {
		BracketMetaObject bracketMetaObject = myBracketMetaObject.getChildBracketMetaObject(reference);
		if (bracketMetaObject == null) {
			return null;
		}
		return bracketMetaObject.createChildBracket(gdeNode, getLmOwner());
	}  
	
	LMBracketContainer getContainer() {
		return myContainer;
	}
	BracketMetaObject getBracketMetaObject() {
		return myBracketMetaObject;
	}
	
	public LMLifeLine getLifeLine() {
		if (myContainer == null) {
			throw new RuntimeException("Has no container"); //$NON-NLS-1$
		}
		return myContainer.getLifeLine();
	}
	
	public abstract boolean isLimitedHorizontally();

	void setContainer(LMBracketContainer container) {
		myContainer = container;
		if (container == null) {
			myClueValue = null;
		} else {
			int parentClueValue = container.getClueValue().intValue();
			int newClueValue;
			if (parentClueValue > VerticalClue.BRACKET_MIN_CLUE.intValue()) {
				newClueValue = parentClueValue-1;
			} else {
				newClueValue = parentClueValue;
			}
			myClueValue = new Integer(newClueValue);
		}
	}
	
	public abstract SDVerticalLayoutInputImpl.NullFreeIterator verticalLayoutElements();
	public abstract void setHorizontalPosition(int newPos);

	protected Integer getClueValue() {
		return myClueValue;
	}
	
	EObject getEntity() {
		return myEntity;
	}
    
    protected boolean calculateIsBracketConsistent() {
        return true;
    }
    
    /**
     * Called from horizontal layout once for a layout session
     */
    public void updateBracketConsistentState() {
        boolean violated = !calculateIsBracketConsistent();
        
        if (myHasColorBeforeViolated == null && violated) {
            myHasColorBeforeViolated = setErrorDisplayColor(Color.RED);
        } else if (myHasColorBeforeViolated != null && !violated) {
            setErrorDisplayColor(myHasColorBeforeViolated);
            myHasColorBeforeViolated = null;
        }
    }
    
    abstract Color setErrorDisplayColor(Color color);
    
    private Color myHasColorBeforeViolated = null;
	private LMBracketContainer myContainer = null;
	private Integer myClueValue = null;
	private final BracketMetaObject myBracketMetaObject;
	private final EObject myEntity;
    private final LifelineBracketHorizontalLayouter myBracketHorizontalLayouter;
}