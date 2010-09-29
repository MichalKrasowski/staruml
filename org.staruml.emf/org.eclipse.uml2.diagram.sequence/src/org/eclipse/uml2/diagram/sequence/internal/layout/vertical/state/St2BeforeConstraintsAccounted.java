package org.eclipse.uml2.diagram.sequence.internal.layout.vertical.state;

import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.input.HorizontalConstraint;

public class St2BeforeConstraintsAccounted {

    public static HorizontalConstraint getHorizontalConstraint(LifelineState lifelineState) {
        assert St2BeforeConstraintsAccounted.class == lifelineState.getState() : "Wrong state"; //$NON-NLS-1$
        
        return lifelineState.getHorizontalConstraint();
    }

    public static int getBeforeConstraintPos(LifelineState lifelineState) {
        assert St2BeforeConstraintsAccounted.class == lifelineState.getState() : "Wrong state "+lifelineState.getState(); //$NON-NLS-1$
        
        return lifelineState.getBeforeConstraintPos();
    }

    public static int getCurrentPos(LifelineState lifelineState) {
        assert St2BeforeConstraintsAccounted.class == lifelineState.getState() : "Wrong state"; //$NON-NLS-1$
        
        return lifelineState.getCurrentPos();
    }

    public static boolean isPrioritedPosition(LifelineState lifelineState) {
        assert St2BeforeConstraintsAccounted.class == lifelineState.getState() : "Wrong state"; //$NON-NLS-1$
        
        return lifelineState.isPrioritedPosition();
    }

    /**
     * -> PositionIsSet
     */
    public static void setPos(LifelineState lifelineState, int pos) {
        assert St2BeforeConstraintsAccounted.class == lifelineState.getState() : "Wrong state"; //$NON-NLS-1$
        
        lifelineState.setCurrentPos(pos);
        
        lifelineState.addEncounteredAfterConstraints();
        
        lifelineState.dismissRequiredHorizontalConstraint();
        
        lifelineState.setState(St3PositionIsSet.class);
    }
}
