package org.eclipse.uml2.diagram.sequence.internal.layout.vertical.state;

import java.util.Iterator;

public class St1MinPosIsCalculated {

    public static int getMinPos(LifelineState lifelineState) {
        assert St1MinPosIsCalculated.class == lifelineState.getState() : "Wrong state "+lifelineState.getState()+" of "+lifelineState; //$NON-NLS-1$ //$NON-NLS-2$

        return lifelineState.getMinPos();
    }

    public static Iterator getRequiredOrderingConstraints(LifelineState lifelineState) {
        assert St1MinPosIsCalculated.class == lifelineState.getState() : "Wrong state"; //$NON-NLS-1$
        
        return lifelineState.getRequiredOrderingConstraints().iterator();
    }

    /**
     * -> BeforeConstraintsAccounted
     */
    public static void beforeConstraintsAccounted(LifelineState lifelineState, int beforeConstraint) {
        assert St1MinPosIsCalculated.class == lifelineState.getState() : "Wrong state"; //$NON-NLS-1$
        
        lifelineState.getRequiredOrderingConstraints().clear();
        
        lifelineState.setBeforeConstraintPos(beforeConstraint);
        
        lifelineState.prepareHorizontalConstraint();
        
        lifelineState.setState(St2BeforeConstraintsAccounted.class);
    }
}
