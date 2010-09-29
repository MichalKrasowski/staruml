package org.eclipse.uml2.diagram.sequence.internal.layout.horizontal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsNode;
import org.eclipse.uml2.diagram.sequence.internal.layout.model.LMFrame;
import org.eclipse.uml2.diagram.sequence.internal.layout.model.LMLifeLine;

/**
 * 
 */
public class LifelineCoveringFramesCache {
    public interface LifelineCoveringFramesMover {
        void lifelineMoved(int horizontalDelta);
    }
    
    public LifelineCoveringFramesMover getLifelineCoveringFramesMover(AbsNode lifelineAbsNode) {
        return (LifelineCoveringFramesMover)myLifelineAbsNodeToCoveringLmFrames.get(lifelineAbsNode);
    }
    
    void setFrameOutermostLifelines(LMFrame lmFrame, LMLifeLine leftmost, LMLifeLine rightmost) {
        CoveringFramesMoverImpl leftListener = getOrCreateCoveringFramesMover(leftmost);
        leftListener.setLeftmostFor(lmFrame);
        
        CoveringFramesMoverImpl rightListener = getOrCreateCoveringFramesMover(rightmost);
        rightListener.setRightmostFor(lmFrame);
    }
    
    private CoveringFramesMoverImpl getOrCreateCoveringFramesMover(LMLifeLine lifeline) {
        AbsNode key = lifeline.getGdeNode();
        CoveringFramesMoverImpl result = (CoveringFramesMoverImpl)myLifelineAbsNodeToCoveringLmFrames.get(key);
        if (result==null) {
            result = new CoveringFramesMoverImpl();
            myLifelineAbsNodeToCoveringLmFrames.put(key, result);
        }
        return result;
    }
    
    private final Map myLifelineAbsNodeToCoveringLmFrames = new HashMap();

    private static class CoveringFramesMoverImpl implements LifelineCoveringFramesCache.LifelineCoveringFramesMover {
        public void lifelineMoved(int horizontalDelta) {
            if (horizontalDelta < 0) {
                if (myRight == null) {
                    return;
                }
                for (int i = 0; i<myRight.size(); i++) {
                    LMFrame next = (LMFrame)myRight.get(i);
                    int newPos = next.getGdeNode().getX() + next.getGdeNode().getWidth() + horizontalDelta;
                    next.setRightBorderPosByTool(newPos);
                }
            } else if (horizontalDelta > 0) {
                if (myLeft == null) {
                    return;
                }
                for (int i = 0; i<myLeft.size(); i++) {
                    LMFrame next = (LMFrame)myLeft.get(i);
                    int newPos = next.getGdeNode().getX() + horizontalDelta;
                    next.setLeftBorderPosByTool(newPos);
                }
            }
        }

        void setLeftmostFor(LMFrame lmFrame) {
            if (myLeft == null) {
                myLeft = new ArrayList();
            }
            myLeft.add(lmFrame);
        }
        
        void setRightmostFor(LMFrame lmFrame) {
            if (myRight == null) {
                myRight = new ArrayList();
            }
            myRight.add(lmFrame);
        }
        
        private List myLeft;
        private List myRight;
    }
}
