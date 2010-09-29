package org.eclipse.uml2.diagram.sequence.internal.layout.vertical;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.input.HorizontalConstraint;
import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.input.LifeLine;
import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.input.LifeLineElement;
import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.input.OrderingConstraint;
import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.state.LifelineState;
import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.state.St1MinPosIsCalculated;
import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.state.St2BeforeConstraintsAccounted;
import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.state.St3PositionIsSet;
import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.state.St9LifelineFinished;


public class NewLayoutSession {
    
    private static final boolean debug_print = false; 
    
    /**
     * @throws IllegalArgumentException if lifelines is empty
     * 
     */
    public NewLayoutSession(LifeLine [] lifeLines, boolean fullLayout, int topPos) {
        if (lifeLines.length == 0) {
            throw new IllegalArgumentException("No lifelines are specified"); //$NON-NLS-1$
        }
        if (false) {
            new InputAsserter(lifeLines);
        }
        
        myLifeline2State = new LinkedHashMap(lifeLines.length);
        
        for (int i=0; i<lifeLines.length; i++) {
            LifeLine lifeLine = lifeLines[i];
            LifelineState lifelineState = new LifelineState(lifeLine, topPos, fullLayout, myBrokenOrderingConstraints);
            myLifeline2State.put(lifeLine, lifelineState);
        }
    }
    
    public int go() {
        if (debug_print) {
            System.out.println("\n\n"); //$NON-NLS-1$
            System.out.println("[NewLayoutSession.go] >>> "+myLifeline2State.size()+" lifelines"); //$NON-NLS-1$ //$NON-NLS-2$
        }
        try {
            for (Iterator it = myLifeline2State.values().iterator(); it.hasNext(); ) {
                LifelineState lifelineState = (LifelineState) it.next();
                
                if (lifelineState.getState() != St9LifelineFinished.class) {
                    processLifeline(lifelineState);
                }
            }
            
            for (Iterator it = myLifeline2State.values().iterator(); it.hasNext(); ) {
                LifelineState lifelineState = (LifelineState) it.next();
                lifelineState.savePositions();
            }
            
            LifelineState firstLifelineState = (LifelineState) myLifeline2State.values().iterator().next();
            return St9LifelineFinished.getBase(firstLifelineState);
        } catch (RuntimeException e) {
            if (debug_print) {
                new Exception("Exception caught", e).printStackTrace(System.out); //$NON-NLS-1$
            }
            throw e;
        } finally {
            if (debug_print) {
                System.out.println("[NewLayoutSession.go] <<<"); //$NON-NLS-1$
                System.out.println("\n\n\n"); //$NON-NLS-1$
            }
        }
    }
    
    void processLifeline(LifelineState lifelineState) {
        if (debug_print) {
            System.out.println("[NewLayoutSession.processLifeline] >>> lifelineState="+lifelineState); //$NON-NLS-1$
        }
        try {
    

            boolean available = myCycleWatcher.requireLifeline(lifelineState);
            if (!available) {
                throw new IllegalStateException("Lifeline is locked somehow"); //$NON-NLS-1$
            }

            try {

                processLifelineAlreadyLocked(lifelineState, NOT_REQUIRED_CONSTRAINT);
                
            } finally {
                myCycleWatcher.releaseLifeline(lifelineState);
            }
            
        } finally {
            if (debug_print) {
                System.out.println("[NewLayoutSession.processLifeline] <<<"); //$NON-NLS-1$
            }
        }
    }

    /**
     * @return pos of top element
     */
    int processLifeline(LifelineState lifelineState, OrderingConstraint requiredConstraint) throws LifelineBlockedException {
        if (debug_print) {
            System.out.println("[NewLayoutSession.processLifeline] >>> lifelineState="+lifelineState+" requiredConstraint="+requiredConstraint); //$NON-NLS-1$ //$NON-NLS-2$
        }
        try {
    
            
            Integer pos = (Integer) lifelineState.getEncounteredOrderingConstraints2Pos().remove(requiredConstraint); 
            if (pos != null) {
                if (debug_print) {
                    System.out.println("[NewLayoutSession.processLifeline] required constraint found in encountered after constraints"); //$NON-NLS-1$
                }
                return pos.intValue();
            }
            
            
            lockAndProcessLifeline(lifelineState, requiredConstraint);
            myCycleWatcher.releaseLifeline(lifelineState);
            
            pos = (Integer) lifelineState.getEncounteredOrderingConstraints2Pos().remove(requiredConstraint); 
            if (pos == null) {
                throw new RuntimeException("Failed to get position of top element"); //$NON-NLS-1$
            }
            return pos.intValue();
        } finally {
            if (debug_print) {
                System.out.println("[NewLayoutSession.processLifeline] <<<"); //$NON-NLS-1$
            }
        }
    }
    void processLifeline(LifelineState lifelineState, HorizontalConstraint requiredConstraint) throws LifelineBlockedException {
        if (debug_print) {
            System.out.println("[NewLayoutSession.processLifeline] >>> lifelineState="+lifelineState+" requiredConstraint="+requiredConstraint); //$NON-NLS-1$ //$NON-NLS-2$
        }
        try {
            
            lockAndProcessLifeline(lifelineState, requiredConstraint);
            
        } finally {
            if (debug_print) {
                System.out.println("[NewLayoutSession.processLifeline] <<<"); //$NON-NLS-1$
            }
        }
    }
    
    void lockAndProcessLifeline(LifelineState lifelineState, Object requiredConstraint) throws LifelineBlockedException {
        boolean available = myCycleWatcher.requireLifeline(lifelineState);
        if (!available) {
            if (debug_print) {
                System.out.println("[NewLayoutSession.processLifeline] lifeline is blocked"); //$NON-NLS-1$
            }
            throw new LifelineBlockedException();
        }

        processLifelineAlreadyLocked(lifelineState, requiredConstraint);
    }
    
    /*
     * States per element:
     * 1. minPos is calculated
     * 2. "before ordering" position constraint is calculated
     * 3. pos is set according to horizontal constraint 
     * 4.(hidden) encountered "after ordering" are accounted
     * 
     * 5. lifeline is finished
     * 
     * @return in St2BeforeConstraintsAccounted, St9LifelineFinished or St3PositionIsSet if for OrderingConstraint
     */
    void processLifelineAlreadyLocked(LifelineState lifelineState, Object requiredConstraint) {
        
        if (lifelineState.getState() == St3PositionIsSet.class) {
            if (debug_print) {
                System.out.println("[NewLayoutSession.processLifelineAlreadyLocked] current element is "+lifelineState.getStateStringDebug()); //$NON-NLS-1$
                System.out.println("[NewLayoutSession.processLifelineAlreadyLocked] position is already set"); //$NON-NLS-1$
            }
            St3PositionIsSet.nextStep(lifelineState);
        }
        
        while (lifelineState.getState() != St9LifelineFinished.class) {
             // must be in MinPosIsCalculated
            
            
             if (debug_print) {
                 System.out.println("[NewLayoutSession.processLifelineAlreadyLocked] current element is "+lifelineState.getStateStringDebug()); //$NON-NLS-1$
             }
             
             
             int elementMinPos = St1MinPosIsCalculated.getMinPos(lifelineState);
             
             for (Iterator beforeConstraintIt = St1MinPosIsCalculated.getRequiredOrderingConstraints(lifelineState); beforeConstraintIt.hasNext(); ) {
                 OrderingConstraint beforeConstraint = (OrderingConstraint) beforeConstraintIt.next();
                 
                 if (debug_print) {
                     System.out.println("[NewLayoutSession.processLifeline] beforeConstraint="+beforeConstraint); //$NON-NLS-1$
                 }
                 
                 LifelineState otherLifelineState = getLifelineState(beforeConstraint.getBeforeElement().getLifeLine());
                 
                 if (debug_print) {
                     System.out.println("[NewLayoutSession.processLifeline] otherLifelineState="+otherLifelineState); //$NON-NLS-1$
                 }
                 
                 try {
                     int otherPos = processLifeline(otherLifelineState, beforeConstraint);
                 
                     beforeConstraint.setInvalid(false);
                     int resultMinPos = otherPos + beforeConstraint.getMinSlopeValue();
                     elementMinPos = Math.max(elementMinPos, resultMinPos);
                     
                 } catch (LifelineBlockedException e) {
                     if (debug_print) {
                         System.out.println("[NewLayoutSession.processLifeline] lifeline is not available"); //$NON-NLS-1$
                     }
                     beforeConstraint.setInvalid(true);
                     myBrokenOrderingConstraints.add(beforeConstraint);
                 }
                 
             }
             St1MinPosIsCalculated.beforeConstraintsAccounted(lifelineState, elementMinPos);

             // in BeforeConstraintsAccounted state
             
             HorizontalConstraint horizontalConstraint = St2BeforeConstraintsAccounted.getHorizontalConstraint(lifelineState);
             
             if (debug_print) {
                 System.out.println("[NewLayoutSession.processLifeline] horizontalConstraint="+horizontalConstraint); //$NON-NLS-1$
             }
             
             if (horizontalConstraint == requiredConstraint) {
                 if (debug_print) {
                     System.out.println("[NewLayoutSession.processLifeline] required constraint found"); //$NON-NLS-1$
                 }
                 return;
             }
             
             if (horizontalConstraint == null) {
                 elementMinPos = Math.max(elementMinPos, St2BeforeConstraintsAccounted.getCurrentPos(lifelineState));
             } else {
                 
                 Set badElementsSet = (Set) myBlockedHorizontal2BadElements.get(horizontalConstraint);
                 
                 if (badElementsSet == null) {
                     
                     badElementsSet = new HashSet(0);
                     
                     myBlockedHorizontal2BadElements.put(horizontalConstraint, badElementsSet);
                     
                     try {
                         
                         List elements = horizontalConstraint.getLifeLineElementsList();
                         
                         if (debug_print) {
                             System.out.println("[NewLayoutSession.processLifeline] constrained elements "+elements); //$NON-NLS-1$
                         }
                         
                         boolean prioritedCoordinateFound = false;
                         int constraintMinPos = Integer.MIN_VALUE;
                         int constraintCurPos = Integer.MIN_VALUE;
                         
                         List resolvedOtherLifelines = new ArrayList(elements.size());
                         
                         for (Iterator it = elements.iterator(); it.hasNext(); ) {
                             LifeLineElement element = (LifeLineElement) it.next();
                             
                             LifelineState otherLifelineState = getLifelineState(element.getLifeLine());
                             
                             if (debug_print) {
                                 System.out.println("[NewLayoutSession.processLifeline] element="+element+", on lifeline="+otherLifelineState); //$NON-NLS-1$ //$NON-NLS-2$
                             }
                             
                             if (lifelineState.getCurrentElement() == element) {
                                 horizontalConstraint.elementIsResolved(element);
                             } else if (badElementsSet.contains(element)) {
                                 horizontalConstraint.elementIsViolated(element);
                                 continue;
                             } else {
                                 if (debug_print) {
                                     System.out.println("[NewLayoutSession.processLifeline] non-current"); //$NON-NLS-1$
                                 }
        
                                 try {
                                     processLifeline(otherLifelineState, horizontalConstraint);
                                 } catch (LifelineBlockedException e) {
                                     if (debug_print) {
                                         System.out.println("[NewLayoutSession.processLifeline] lifeline is blocked"); //$NON-NLS-1$
                                     }
                                     
                                     horizontalConstraint.elementIsViolated(element);
                                     
                                     otherLifelineState.addBrokenHorizontalConstraints(horizontalConstraint);
                                     
                                     continue;
                                 }
                                 
                                 horizontalConstraint.elementIsResolved(element);
                                 
                                 resolvedOtherLifelines.add(otherLifelineState);
                             }
                             
                             int minPos = St2BeforeConstraintsAccounted.getBeforeConstraintPos(otherLifelineState); 
                             
                             int curPos = St2BeforeConstraintsAccounted.getCurrentPos(otherLifelineState);
                             
                             if (constraintMinPos < minPos) {
                                 constraintMinPos = minPos;
                             }
                             if (!prioritedCoordinateFound) {
                                 constraintCurPos = curPos;
                                 prioritedCoordinateFound  = St2BeforeConstraintsAccounted.isPrioritedPosition(otherLifelineState);
                             }
                         }
                         
                         int constraintPos = Math.max(constraintCurPos, constraintMinPos);
                         
                         for (int i=0; i<resolvedOtherLifelines.size(); i++) {
                             LifelineState state = (LifelineState) resolvedOtherLifelines.get(i);
                             St2BeforeConstraintsAccounted.setPos(state, constraintPos);
                             myCycleWatcher.releaseLifeline(state);
                         }
                         elementMinPos = constraintPos;
                     } finally {
                         myBlockedHorizontal2BadElements.remove(horizontalConstraint);
                     }
                 } else {
                     
                     badElementsSet.add(lifelineState.getCurrentElement());
                     
                 }
             }
             
             St2BeforeConstraintsAccounted.setPos(lifelineState, elementMinPos);
             
             // now in St3PositionIsSet state
             
             if (lifelineState.getEncounteredOrderingConstraints2Pos().containsKey(requiredConstraint)) {
                 return;
             }

             St3PositionIsSet.nextStep(lifelineState);
         }
         
         if (debug_print) {
             System.out.println("[NewLayoutSession.processLifeline] lifeline is finished"); //$NON-NLS-1$
         }
         
         if (requiredConstraint != NOT_REQUIRED_CONSTRAINT) {
             throw new RuntimeException("Failed to find required constraint "+requiredConstraint+" on lifeline "+lifelineState); //$NON-NLS-1$ //$NON-NLS-2$
         }
    }
    
    private static class LifelineBlockedException extends Exception {
    }
    
    private LifelineState getLifelineState(LifeLine lifeLine) {
        LifelineState result = (LifelineState) myLifeline2State.get(lifeLine);
        if (result == null) {
            throw new RuntimeException("Failed to find state for lifeline"); //$NON-NLS-1$
        }
        return result;
    }
    
    private final Map myLifeline2State;
    private final CycleWatcher myCycleWatcher = new CycleWatcher();
    private final Set myBrokenOrderingConstraints = new HashSet(2);
    private final Map myBlockedHorizontal2BadElements = new HashMap(3);
    
    private static final Object NOT_REQUIRED_CONSTRAINT = new Object();
    
    private static class CycleWatcher {
        boolean requireLifeline(LifelineState lifelineState) {
            return myLifelineStates.add(lifelineState);
        }
        void releaseLifeline(LifelineState lifelineState) {
            myLifelineStates.remove(lifelineState);
        }
        private final HashSet myLifelineStates = new HashSet();
    }

}
