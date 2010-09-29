package org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.gef;

import org.eclipse.uml2.diagram.common.editparts.PrimaryShapeEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.InteractionEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.LayeredInteractionUseEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.LayeredOperandEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.uml2.diagram.sequence.figures.LifelineBracketContainerShape;
import org.eclipse.uml2.diagram.sequence.frame.FrameWithPentagon;
import org.eclipse.uml2.diagram.sequence.frame.FrameWithShadeAndPentagon;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsElementPropertyAccess;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsLink;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsNode;
import org.eclipse.uml2.diagram.sequence.internal.layout.manage.InteractionLayouter;
import org.eclipse.uml2.diagram.sequence.internal.layout.model.LMFrame.BackgroundLayouter;
import org.eclipse.uml2.diagram.sequence.internal.layout.model.LMInteractionOccurence.InteractionUseLayouter;
import org.eclipse.uml2.diagram.sequence.internal.layout.model.LMInteractionOperand.DelimitLineLayouter;
import org.eclipse.uml2.diagram.sequence.internal.layout.model.LMLifeLine.DetailsLayouter;
import org.eclipse.uml2.diagram.sequence.internal.layout.model.LMLifeLineBracket.LifelineBracketHorizontalLayouter;
import org.eclipse.uml2.diagram.sequence.internal.layout.model.LMVisibleFrameWithPentagon.PentagonLayouter;
import org.eclipse.uml2.diagram.sequence.internal.layout.model.MessageLabelLayouter.MessageLabel;
import org.eclipse.uml2.diagram.sequence.internal.viewmap.InvocationViewmapOptions;


public class AbsElementPropertyAccessU2T extends AbsElementPropertyAccess {
    public DetailsLayouter getLifeLineDetailsLayouter(AbsNode lifelineAbsNode) {
    	AbsElementGef absNodeImpl = (AbsElementGef)lifelineAbsNode;
    	LifelineEditPart editPart = (LifelineEditPart)absNodeImpl.getEditPart();
    	return editPart.getPrimaryShape().getLifelineLayout();
    }

    public BackgroundLayouter getBackgroundLayouter(AbsNode frameAbsNode) {
    	AbsElementGef absNodeImpl = (AbsElementGef)frameAbsNode;
    	PrimaryShapeEditPart editPart = (PrimaryShapeEditPart)absNodeImpl.getEditPart();
    	if (editPart.getPrimaryShape() instanceof FrameWithShadeAndPentagon){
    		FrameWithShadeAndPentagon figureImpl = (FrameWithShadeAndPentagon) editPart.getPrimaryShape();
    		return figureImpl.getBackgroundLayouter();
    	} else {
    		System.err.println("FrameNode without a frame: AbsNode: " + frameAbsNode + ", EP: " + editPart);
    		return null;
    	}
    }

    public DelimitLineLayouter getDelimitLineLayouter(AbsNode interactionOperandAbsNode) {
    	AbsElementGef absNodeImpl = (AbsElementGef)interactionOperandAbsNode;
    	LayeredOperandEditPart editPartImpl = (LayeredOperandEditPart)absNodeImpl.getEditPart();
        return editPartImpl.getPrimaryShape().getDelimitLineLayouter();
    }

    public PentagonLayouter getPentagonLayouter(AbsNode gdeNode) {
    	AbsElementGef absNodeImpl = (AbsElementGef)gdeNode;
    	PrimaryShapeEditPart editPartImpl = (PrimaryShapeEditPart)absNodeImpl.getEditPart();
    	FrameWithPentagon pentagonOwner = (FrameWithPentagon) editPartImpl.getPrimaryShape();
    	return pentagonOwner.getPentagonLayouter();
    }

    public InteractionUseLayouter getInteractionUseLayouter(AbsNode interactionUseNode) {
    	AbsElementGef absNodeImpl = (AbsElementGef)interactionUseNode;
    	LayeredInteractionUseEditPart editPartImpl = (LayeredInteractionUseEditPart)absNodeImpl.getEditPart();
        return editPartImpl.getPrimaryShape();
    }

    public boolean isViewmappedAsAlienShortcut(AbsNode gdeNode) {
        // TODO Auto-generated method stub
        return false;
    }

    public LifelineBracketHorizontalLayouter getLifelineBracketHorizontalLayouter(final AbsNode lifelineBracketAbsNode) {
        return new LifelineBracketHorizontalLayouter() { 
            public void setHorizontalPositions(int x, int paintableWidth, int containerWidth) {
            	AbsElementGef absNodeImpl = (AbsElementGef)lifelineBracketAbsNode;
            	PrimaryShapeEditPart editPartImpl = (PrimaryShapeEditPart)absNodeImpl.getEditPart();
            	LifelineBracketContainerShape figureImpl = (LifelineBracketContainerShape) editPartImpl.getPrimaryShape();
                figureImpl.setPaintableWidth(paintableWidth);
                
                lifelineBracketAbsNode.setX(x);
                lifelineBracketAbsNode.setWidth(containerWidth);
            }
        };
    }
    
    public MessageLabel[] getLabels(AbsLink absLink) {
    	return new MessageLabel[0];
    }
    
    private static final InvocationViewmapOptions DUMMY_OPTIONS = new InvocationViewmapOptions(){
		
		public boolean isOnLifeline() {
			return true;
		}
	
		public boolean isInvocationVisible() {
			return true;
		}
	};

    public InvocationViewmapOptions getInvocationViewmapOptions(AbsNode gdeNode) {
    	return DUMMY_OPTIONS;
    }
    
    public InteractionLayouter getInteractionLayouter(AbsNode interactionNode) {
    	AbsElementGef absNodeImpl = (AbsElementGef)interactionNode;
    	InteractionEditPart editPartImpl = (InteractionEditPart)absNodeImpl.getEditPart();
        return editPartImpl.getPrimaryShape().getInteractionLayouter();
    }
    
    @Override
    public boolean canAsynchCallBeStraight(AbsLink callMessage) {
    	if (false){
    		throw new UnsupportedOperationException();	
    	}
        return false;
    }
    
}
