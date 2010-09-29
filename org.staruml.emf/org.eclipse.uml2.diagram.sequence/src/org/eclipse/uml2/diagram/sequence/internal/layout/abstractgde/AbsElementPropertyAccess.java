package org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde;

import org.eclipse.uml2.diagram.sequence.internal.layout.manage.InteractionLayouter;
import org.eclipse.uml2.diagram.sequence.internal.layout.model.LMFrame;
import org.eclipse.uml2.diagram.sequence.internal.layout.model.LMInteractionOccurence;
import org.eclipse.uml2.diagram.sequence.internal.layout.model.LMInteractionOperand;
import org.eclipse.uml2.diagram.sequence.internal.layout.model.LMLifeLine;
import org.eclipse.uml2.diagram.sequence.internal.layout.model.LMLifeLineBracket;
import org.eclipse.uml2.diagram.sequence.internal.layout.model.LMVisibleFrameWithPentagon;
import org.eclipse.uml2.diagram.sequence.internal.layout.model.MessageLabelLayouter;
import org.eclipse.uml2.diagram.sequence.internal.viewmap.InvocationViewmapOptions;



/**
 * 
 */
public abstract class AbsElementPropertyAccess {
    public static AbsElementPropertyAccess getInstance(){
        assert ourInstance != null;
        return ourInstance;
    }; 
     
    /**
     * @return not null
     */
    public abstract LMLifeLine.DetailsLayouter getLifeLineDetailsLayouter(AbsNode lifelineAbsNode);

    /**
     * @return not null
     */
    public abstract LMFrame.BackgroundLayouter getBackgroundLayouter(AbsNode frameAbsNode);

    /**
     * @return not null
     */
    public abstract LMInteractionOperand.DelimitLineLayouter getDelimitLineLayouter(AbsNode interactionOperandAbsNode);

    /**
     * @return not null
     */
    public abstract LMVisibleFrameWithPentagon.PentagonLayouter getPentagonLayouter(AbsNode gdeNode);
    
    /**
     * @return not null
     */
    public abstract LMInteractionOccurence.InteractionUseLayouter getInteractionUseLayouter(AbsNode interactionUseNode);

    //gdeNode.getProperty(SdLayoutConstants.VIEWMAPPED_AS_ALIEN_SHORTCUT) != null
    public abstract boolean isViewmappedAsAlienShortcut(AbsNode gdeNode);
    
    /**
     * @return not null
     */
    public abstract LMLifeLineBracket.LifelineBracketHorizontalLayouter getLifelineBracketHorizontalLayouter(AbsNode lifelineBracketAbsNode);
    
    /**
     * @param absLink a Message
     * @return not null
     */
    public abstract MessageLabelLayouter.MessageLabel[] getLabels(AbsLink absLink);
    
    public abstract InvocationViewmapOptions getInvocationViewmapOptions(AbsNode gdeNode);
    
    public abstract InteractionLayouter getInteractionLayouter(AbsNode interactionNode);

    public abstract boolean canAsynchCallBeStraight(AbsLink callMessage);
    
    protected  AbsElementPropertyAccess() {
        assert ourInstance == null;
        ourInstance = this;
    }
    
    private static AbsElementPropertyAccess ourInstance = null;

}
