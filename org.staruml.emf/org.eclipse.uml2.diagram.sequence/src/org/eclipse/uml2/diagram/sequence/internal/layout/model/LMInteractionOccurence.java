package org.eclipse.uml2.diagram.sequence.internal.layout.model;

import org.eclipse.uml2.diagram.sequence.internal.layout.GeometryConstants;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsElementPropertyAccess;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsNode;


/**
 * 
 */
public class LMInteractionOccurence extends LMVisibleFrameWithPentagon {
    LMInteractionOccurence(AbsNode gdeNode) {
		super(gdeNode);
        myInteractionUseLayouter = AbsElementPropertyAccess.getInstance().getInteractionUseLayouter(gdeNode);
	}
    
    public interface InteractionUseLayouter {
        int getPreferredWidth();
        int getPreferredHeight();
    }
	
	boolean hasVisibleMountingLinks() {
		return true;
	}
	
	public int getInnerHorizontalPadding() {
		return GeometryConstants.Frames.INTERACTION_OCCURENCE_INNER_SPACE_HORIZONTAL;
	}
	public int getOuterHorizontalPadding() {
		return GeometryConstants.Frames.INTERACTION_OCCURENCE_OUTER_SPACE_HORIZONTAL;
	}

	protected int getPentagonOffset() {
		return 0;
	}
    
    public int getPreferredWidth() {
        int pentagonWidth = super.getPreferredWidth();
        int textWidth = myInteractionUseLayouter.getPreferredWidth();
        return Math.max(pentagonWidth, textWidth);
    }

    public int getPreferredHeight() {
        int pentagonHeight = getPentagonPreferredHeight();
        int textHeight = myInteractionUseLayouter.getPreferredHeight();
        return 2*pentagonHeight + textHeight;
    }
    
    private final InteractionUseLayouter myInteractionUseLayouter;
}
