package org.eclipse.uml2.diagram.sequence.internal.layout.vertical;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.input.HorizontalConstraint;
import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.input.LifeLine;
import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.input.LifeLineElement;
import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.input.LifeLineIterator;
import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.input.OrderingConstraint;


class InputAsserter {
    InputAsserter(LifeLine [] lifeLines) {
        for (int i=0; i<lifeLines.length; i++) {
            for (LifeLineIterator it = lifeLines[i].iterator(); it.hasNext(); ) {
                it.nextClueValue();
                LifeLineElement element = it.nextElement();
                registerElement(element);
                HorizontalConstraint horizontalConstraint = element.getHorizontalConstraint();
                if (horizontalConstraint != null) {
                    getHorizontalInfo(horizontalConstraint).addElement(element);
                }
                for (Enumeration beforeEnum = element.beforeConstraints(); beforeEnum.hasMoreElements(); ) {
                    OrderingConstraint orderingConstraint = (OrderingConstraint) beforeEnum.nextElement();
                    getOrderingInfo(orderingConstraint).registerAfter(element);
                }
                for (Enumeration afterEnum = element.afterConstraints(); afterEnum.hasMoreElements(); ) {
                    OrderingConstraint orderingConstraint = (OrderingConstraint) afterEnum.nextElement();
                    getOrderingInfo(orderingConstraint).registerBefore(element);
                }
            }
        }
        for (Iterator it = myHorizontal2Info.values().iterator(); it.hasNext(); ) {
            HorizontalInfo info = (HorizontalInfo) it.next();
            info.checkComplete();
        }
        for (Iterator it = myOrdering2Info.values().iterator(); it.hasNext(); ) {
            OrderingInfo info = (OrderingInfo) it.next();
            info.checkComplete();
        }
    }
    
    private void registerElement(LifeLineElement element) {
        boolean res = myAllElements.add(element);
        if (!res) {
            throw new RuntimeException("Such element already added to set"); //$NON-NLS-1$
        }
    }
    private HorizontalInfo getHorizontalInfo(HorizontalConstraint constraint) {
        HorizontalInfo info = (HorizontalInfo) myHorizontal2Info.get(constraint);
        if (info == null) {
            info = new HorizontalInfo(constraint);
            myHorizontal2Info.put(constraint, info);
        }
        return info;
    }
    private OrderingInfo getOrderingInfo(OrderingConstraint constraint) {
        OrderingInfo info = (OrderingInfo) myOrdering2Info.get(constraint);
        if (info == null) {
            info = new OrderingInfo(constraint);
            myOrdering2Info.put(constraint, info);
        }
        return info;
    }
    
    private final Set myAllElements = new HashSet();
    private final Map myHorizontal2Info = new HashMap();
    private final Map myOrdering2Info = new HashMap();
    
    private static class HorizontalInfo {
        HorizontalInfo(HorizontalConstraint constraint) {
            myExpectedElements = new HashSet(constraint.getLifeLineElementsList());
        }
        
        void addElement(LifeLineElement element) {
            boolean res = myExpectedElements.remove(element);
            if (!res) {
                throw new RuntimeException("Non-expected element"); //$NON-NLS-1$
            }
        }
        void checkComplete() {
            if (!myExpectedElements.isEmpty()) {
                throw new RuntimeException("Not all elements are found"); //$NON-NLS-1$
            }
        }
        
        private final Set myExpectedElements;
    }
    private static class OrderingInfo {
        OrderingInfo(OrderingConstraint constraint) {
            myConstraint = constraint;
        }
        
        void registerBefore(LifeLineElement element) {
            if (myBeforeFound) {
                throw new RuntimeException("Element already registered"); //$NON-NLS-1$
            }
            if (element != myConstraint.getBeforeElement()) {
                throw new RuntimeException("Unexpected 'before' element"); //$NON-NLS-1$
            }
            myBeforeFound = true;
        }
        void registerAfter(LifeLineElement element) {
            if (myAfterFound) {
                throw new RuntimeException("Element already registered"); //$NON-NLS-1$
            }
            if (element != myConstraint.getAfterElement()) {
                throw new RuntimeException("Unexpected 'after' element"); //$NON-NLS-1$
            }
            myAfterFound = true;
        }
        void checkComplete() {
            if (!myBeforeFound) {
                throw new RuntimeException("Before element not found"); //$NON-NLS-1$
            }
            if (!myAfterFound) {
                throw new RuntimeException("After element not found"); //$NON-NLS-1$
            }
        }
        
        private boolean myBeforeFound = false;
        private boolean myAfterFound = false;
        private final OrderingConstraint myConstraint;
    }
}
