package org.eclipse.uml2.diagram.sequence.internal.layout.vertical.state;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.input.HorizontalConstraint;
import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.input.LifeLine;
import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.input.LifeLineElement;
import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.input.LifeLineIterator;
import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.input.OrderingConstraint;


/**
 * Most of methods are package-local. All actual work should be done via St* classes to enforce using class
 * in correct state only.
 * 
 */
public class LifelineState {
    private static final boolean DEBUG_SAVE_POS = false;
    private static final boolean DEBUG_LOAD_POS = false;
    
    public LifelineState(LifeLine lifeLine, int topPos, boolean resetPositions, Set brokenOrderingConstraints) {
        myLifeLine = lifeLine;
        myBase = topPos;
        myWrapperList = new ArrayList();
        myBrokenOrderingConstraints = brokenOrderingConstraints;
        
        int priorityCounter = 0;
        for (LifeLineIterator it = lifeLine.iterator(); it.hasNext(); ) {
            it.nextClueValue();
            LifeLineElement element = it.nextElement();
            
            if (resetPositions) {
                element.optimizeSize();
            }
            
            if (element.getPosition().isFirstPrioritedPosition()) {
                priorityCounter++;
            }
            myWrapperList.add(new ElementWrapper(element, priorityCounter > 0));
            if (element.getPosition().isLastPrioritedPosition()) {
                priorityCounter--;
            }
        }
        
        myIndex = -1;
        
        if (resetPositions) {
            resetPositions(topPos);
        } else {
            loadPositions(topPos);
        }
        
        nextStep();
        
        if (isFinished()) {
            myState = St9LifelineFinished.class;
        } else {
            myState = St1MinPosIsCalculated.class;
        }
        
    }
    
    public String getStateStringDebug() {
        return "element="+myCurrentWrapper.getElement(); //$NON-NLS-1$
    }

    public String toString() {
        return "LifelineState<"+myLifeLine+">"; //$NON-NLS-1$ //$NON-NLS-2$
    }
    
    private void loadPositions(int topPos) {
        if (DEBUG_LOAD_POS) {
            System.out.println("[LifelineState] loadPositions>>>>>: "+this); //$NON-NLS-1$
        }
        ElementWrapper firstElementWrapper = (ElementWrapper) myWrapperList.get(0);
        firstElementWrapper.setPos(topPos);
        for (int i=1; i<myWrapperList.size(); i++) {
            ElementWrapper elementWrapper = (ElementWrapper) myWrapperList.get(i);
            elementWrapper.loadPos();
            if (DEBUG_LOAD_POS) {
                System.out.println("[LifelineState] loadPositions: "+elementWrapper.getElement()+ "  pos = "+elementWrapper.getPos()); //$NON-NLS-1$ //$NON-NLS-2$
            }
        }
        if (DEBUG_LOAD_POS) {
            System.out.println("[LifelineState] loadPositions<<<<<<<<< "); //$NON-NLS-1$
        }
    }
    private void resetPositions(int topPos) {
        for (int i=0; i<myWrapperList.size(); i++) {
            ElementWrapper elementWrapper = (ElementWrapper) myWrapperList.get(i);
            elementWrapper.setPos(topPos);
        }
    }
    
    public void savePositions() {
        assert checkPositionsMonotonous();
        
        if (DEBUG_SAVE_POS) {
            System.out.println("[LifelineState] savePositions----------->>>>: "+this); //$NON-NLS-1$
        }
        
        for (int i=0; i<myWrapperList.size(); i++) {
            ElementWrapper elementWrapper = (ElementWrapper) myWrapperList.get(i);
            elementWrapper.savePos();
            if (DEBUG_SAVE_POS) {
                System.out.println("[LifelineState] savePositions: "+elementWrapper.getElement()+ "  pos = "+elementWrapper.getPos());  //$NON-NLS-1$//$NON-NLS-2$
            }
        }
        
        assert checkPositionsSaved();
        if (DEBUG_SAVE_POS) {
            System.out.println("[LifelineState] savePositions-----------<<<<<: "+this); //$NON-NLS-1$
        }
    }
    
    private boolean checkPositionsMonotonous() {
        ElementWrapper firstElementWrapper = (ElementWrapper) myWrapperList.get(0);
        LifeLineElement firstElement = firstElementWrapper.getElement();
        int base = firstElementWrapper.getPos() - firstElement.getPointOffset() + firstElement.getSize();
        for (int i=1; i<myWrapperList.size(); i++) {
            ElementWrapper elementWrapper = (ElementWrapper) myWrapperList.get(i);
            LifeLineElement element = elementWrapper.getElement();
            int pos = elementWrapper.getPos();
            if (pos < base) {
                throw new RuntimeException(pos + " < " + base); //$NON-NLS-1$
            }
            base = pos - element.getPointOffset() + element.getSize();
        }
        return true;
    }
    private boolean checkPositionsSaved() {
        for (int i=0; i<myWrapperList.size(); i++) {
            ElementWrapper elementWrapper = (ElementWrapper) myWrapperList.get(i);
            elementWrapper.assertSaved();
        }
        return true;
    }
    
    void nextStep() {
        if (hasRequired()) {
            throw new IllegalStateException("Lifeline is blocked"); //$NON-NLS-1$
        }
        
        if (myCurrentWrapper != null) {
            goodbyeElement();
        }
        
        if (myIndex+1 >= myWrapperList.size()) {
            myCurrentWrapper = null;
            return;
        }
        
        myIndex++;
        myCurrentWrapper = (ElementWrapper) myWrapperList.get(myIndex);
        
        hoorayElement();
    }
    /**
     * @return true, if some 'after' constraints were found
     */
    private void goodbyeElement() {
        myBeforeConstraintPos = 0;
    }
    private void hoorayElement() {
        for (Enumeration constrEnum = myCurrentWrapper.getElement().beforeConstraints(); constrEnum.hasMoreElements(); ) {
            OrderingConstraint constraint = (OrderingConstraint) constrEnum.nextElement();
            myRequiredOrderingConstraints.add(constraint);
        }
    }
    
    public Class getState() {
        return myState;
    }
    void setState(Class state) {
        myState = state;
    }
    
    boolean isFinished() {
        return myCurrentWrapper == null;
    }
    HorizontalConstraint getHorizontalConstraint() {
        assert myHorizontalConstraintCalculated;
        return myRequiredHorizontalConstraint;
    }
    
    Set getRequiredOrderingConstraints() {
        return myRequiredOrderingConstraints;
    }
    public Map getEncounteredOrderingConstraints2Pos() {
        return myEncounteredOrderingConstraints2Pos;
    }

    private boolean hasRequired() {
        return myHorizontalConstraintCalculated || !myRequiredOrderingConstraints.isEmpty();
    }
    void setCurrentPos(int pos) {
        if (pos < getMinPos()) {
            throw new IllegalArgumentException("pos is too small"); //$NON-NLS-1$
        }
//        if (pos < 0) {
//            throw new IllegalArgumentException("pos < 0"); //$NON-NLS-1$
//        }
        myCurrentWrapper.setPos(pos);
        myBase = pos + myCurrentWrapper.getPostSize();
    }
    int getMinPos() {
        return myBase + myCurrentWrapper.getPreSize();
    }
    int getCurrentPos() {
        if (myCurrentWrapper.isVirtual()) {
            return getMinPos();
        } else {
            int result = myCurrentWrapper.getPos();
            return result;
        }
    }
    int getBase() {
        return myBase;
    }
    boolean isPrioritedPosition() {
        return myCurrentWrapper.isPriorited();
    }
    void addEncounteredAfterConstraints() {
        for (Enumeration constrEnum = myCurrentWrapper.getElement().afterConstraints(); constrEnum.hasMoreElements(); ) {
            OrderingConstraint constraint = (OrderingConstraint) constrEnum.nextElement();
            if (myBrokenOrderingConstraints.remove(constraint)) {
                // OK, now we can forget about this constraint
            } else { 
                myEncounteredOrderingConstraints2Pos.put(constraint, new Integer(myCurrentWrapper.getPos()));
            }
        }
    }

    public void dismissRequiredHorizontalConstraint() {
        myHorizontalConstraintCalculated = false;
        myRequiredHorizontalConstraint = null;
    }
    
    public void addBrokenHorizontalConstraints(HorizontalConstraint constraint) {
        Counter counter = (Counter) myBrokenHorizontalConstraints2Counter.get(constraint);
        if (counter == null) {
            counter = new Counter();
            myBrokenHorizontalConstraints2Counter.put(constraint, counter);
        }
        counter.increase();
    }
    
    int getBeforeConstraintPos() {
        return myBeforeConstraintPos;
    }

    void setBeforeConstraintPos(int beforeConstraintPos) {
        myBeforeConstraintPos = beforeConstraintPos;
    }
    public LifeLineElement getCurrentElement() {
        return myCurrentWrapper.getElement();
    }
    void prepareHorizontalConstraint() {
        assert !myHorizontalConstraintCalculated;
        
        myRequiredHorizontalConstraint =  myCurrentWrapper.getElement().getHorizontalConstraint();
        if (myRequiredHorizontalConstraint != null) {
            Counter counter = (Counter) myBrokenHorizontalConstraints2Counter.get(myRequiredHorizontalConstraint);
            if (counter != null && counter.getCount() > 0) {
                myRequiredHorizontalConstraint = null;
                counter.decrease();
            }
        }
        myHorizontalConstraintCalculated = true;
    }
    
    
    private final LifeLine myLifeLine;
    private int myBase;
    private HorizontalConstraint myRequiredHorizontalConstraint;
    private boolean myHorizontalConstraintCalculated = false;
    private final Set myRequiredOrderingConstraints = new HashSet(3);
    private final Map myEncounteredOrderingConstraints2Pos = new HashMap(3);
    private ElementWrapper myCurrentWrapper;
    private final List myWrapperList;
    private int myIndex;
    private final Map myBrokenHorizontalConstraints2Counter = new HashMap(2);
    private final Set myBrokenOrderingConstraints;
    private Class myState;
    private int myBeforeConstraintPos;
    
    static class ElementWrapper {
        ElementWrapper(LifeLineElement element, boolean isPriorited) {
            myElement = element;
            myIsPriorited = isPriorited;
        }
        void loadPos() {
            myPos = myElement.getPosition().getPositionValue();
        }
        void savePos() {
            myElement.getPosition().setPositionValue(myPos);
        }
        void assertSaved() {
            assert isVirtual() || myElement.getPosition().getPositionValue() == myPos;
        }
        boolean isVirtual() {
            return myElement.getPosition().isVirtual();
        }
        int getPreSize() {
            return myElement.getPointOffset();
        }
        int getPostSize() {
            return myElement.getSize() - myElement.getPointOffset();
        }
        int getPos() {
            return myPos;
        }
        void setPos(int pos) {
            myPos = pos;
        }
        boolean isPriorited() {
            return myIsPriorited;
        }
        LifeLineElement getElement() {
            return myElement;
        }
        private final LifeLineElement myElement;
        private final boolean myIsPriorited;
        private int myPos;
    }
    
    private static class Counter {
        void increase() {
            myInt++;
        }
        void decrease() {
            myInt--;
        }
        int getCount() {
            return myInt;
        }
        int myInt = 0;
    }
}