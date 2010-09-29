package org.eclipse.uml2.diagram.sequence.internal.layout.vertical.state;

public class St9LifelineFinished {
    public static int getBase(LifelineState lifelineState) {
        assert St9LifelineFinished.class == lifelineState.getState() : "Wrong state"; //$NON-NLS-1$
        
        return lifelineState.getBase();
    }
}
