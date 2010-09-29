package org.eclipse.uml2.diagram.sequence.internal.layout.vertical.state;

public class St3PositionIsSet {
    /**
     * -> LifelineFinished or MinPosIsCalculated
     * @param lifelineState
     */
    public static void nextStep(LifelineState lifelineState) {
        assert St3PositionIsSet.class == lifelineState.getState() : "Wrong state"; //$NON-NLS-1$
        
        lifelineState.nextStep();
        
        if (lifelineState.isFinished()) {
            lifelineState.setState(St9LifelineFinished.class);
        } else {
            lifelineState.setState(St1MinPosIsCalculated.class);
        }
    }
}
