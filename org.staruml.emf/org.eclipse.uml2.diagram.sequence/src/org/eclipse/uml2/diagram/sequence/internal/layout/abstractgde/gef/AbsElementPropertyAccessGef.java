package org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.gef;
//package com.borland.tg.uml20.interaction.internal.layout.abstractgde.gef;
//
//import org.eclipse.draw2d.IFigure;
//
//import com.borland.tg.gde.GdeElementEditPart;
//import com.borland.tg.gde.draw2d.shadow.ShadowPlate;
//import com.borland.tg.gde.figures.DecorationFigure;
//import com.borland.tg.uml20.interaction.internal.layout.abstractgde.AbsElementPropertyAccess;
//import com.borland.tg.uml20.interaction.internal.layout.abstractgde.AbsLink;
//import com.borland.tg.uml20.interaction.internal.layout.abstractgde.AbsNode;
//import com.borland.tg.uml20.interaction.internal.layout.manage.InteractionLayouter;
//import com.borland.tg.uml20.interaction.internal.layout.model.LMFrame.BackgroundLayouter;
//import com.borland.tg.uml20.interaction.internal.layout.model.LMInteractionOccurence.InteractionUseLayouter;
//import com.borland.tg.uml20.interaction.internal.layout.model.LMInteractionOperand.DelimitLineLayouter;
//import com.borland.tg.uml20.interaction.internal.layout.model.LMLifeLine.DetailsLayouter;
//import com.borland.tg.uml20.interaction.internal.layout.model.LMLifeLineBracket.LifelineBracketHorizontalLayouter;
//import com.borland.tg.uml20.interaction.internal.layout.model.LMVisibleFrameWithPentagon.PentagonLayouter;
//import com.borland.tg.uml20.interaction.internal.layout.model.MessageLabelLayouter.MessageLabel;
//import com.borland.tg.uml20.interaction.internal.preferences.PreferencesAccess;
//import com.borland.tg.uml20.interaction.internal.preferences.SequenceDiagramOptions;
//import com.borland.tg.uml20.interaction.internal.viewmap.ExecutionSpecificationViewMap;
//import com.borland.tg.uml20.interaction.internal.viewmap.FrameViewMap;
//import com.borland.tg.uml20.interaction.internal.viewmap.GdeUtil;
//import com.borland.tg.uml20.interaction.internal.viewmap.InteractionOperandViewMap;
//import com.borland.tg.uml20.interaction.internal.viewmap.InvocationViewmapOptions;
//import com.borland.tg.uml20.interaction.internal.viewmap.LifelineViewMap;
//import com.borland.tg.uml20.interaction.internal.viewmap.MessageViewMap;
//import com.borland.tg.uml20.interaction.internal.viewmap.VisibleInteractionViewMap;
//import com.borland.tg.uml20.interaction.internal.viewmap.FrameViewMap.FrameWithShade;
//import com.borland.tg.uml20.interaction.metainfo.MessageSort;
//import com.togethersoft.modules.uml20.interaction.SD20_Int_CallMessage;
//
///**
// * 
// */
//public class AbsElementPropertyAccessGef extends AbsElementPropertyAccess {
//    public DetailsLayouter getLifeLineDetailsLayouter(AbsNode lifelineAbsNode) {
//        IFigure f = undressFigure(lifelineAbsNode);
//        return ((LifelineViewMap.LifelineShape) f).getLifelineLayout();
//    }
//
//    public BackgroundLayouter getBackgroundLayouter(AbsNode frameAbsNode) {
//        IFigure f = undressFigure(frameAbsNode);
//        FrameViewMap.Frame framePart = (FrameViewMap.Frame)f;
//        if (framePart.getMultilayeredFrame() instanceof FrameWithShade) {
//            FrameViewMap.FrameWithShade frameWithShade = (FrameWithShade)framePart.getMultilayeredFrame();
//            return frameWithShade.getBackgroundLayouter();
//        } else {
//            return null;
//        }
//    }
//
//    public DelimitLineLayouter getDelimitLineLayouter(AbsNode interactionOperandAbsNode) {
//        IFigure f = undressFigure(interactionOperandAbsNode);
//        return ((InteractionOperandViewMap.InteractionOperandShape) f).getDelimitLineLayouter();
//    }
//
//    public PentagonLayouter getPentagonLayouter(AbsNode gdeNode) {
//        IFigure f = undressFigure(gdeNode);
//        return ((FrameViewMap.FrameWithPentagon) f).getPentagonLayouter();
//    }
//
//    public InteractionUseLayouter getInteractionUseLayouter(AbsNode interactionUseNode) {
//        IFigure f = undressFigure(interactionUseNode);
//        return (InteractionUseLayouter) f;
//    }
//
//    public boolean isViewmappedAsAlienShortcut(AbsNode gdeNode) {
//        // TODO Auto-generated method stub
//        return false;
//    }
//
//    public LifelineBracketHorizontalLayouter getLifelineBracketHorizontalLayouter(final AbsNode lifelineBracketAbsNode) {
//        return new LifelineBracketHorizontalLayouter() { 
//            public void setHorizontalPositions(int x, int paintableWidth, int containerWidth) {
//                IFigure f = ((AbsElementGef) lifelineBracketAbsNode).getFigure();
//                f = ((DecorationFigure)f).getChild();
//                ((ExecutionSpecificationViewMap.LifelineBracketContainerShape) f).setPaintableWidth(paintableWidth);
//                
//                lifelineBracketAbsNode.setX(x);
//                lifelineBracketAbsNode.setWidth(containerWidth);
//            }
//        };
//    }
//    
//    public MessageLabel[] getLabels(AbsLink absLink) {
//        IFigure figure = ((AbsLinkGef)absLink).getFigure();
//        //TODO: reply message
//        return ((MessageViewMap.MessageLink) figure).getLabelLayouters();
//    }
//
//    public InvocationViewmapOptions getInvocationViewmapOptions(AbsNode gdeNode) {
//        IFigure f = undressFigure(gdeNode);
//        return (InvocationViewmapOptions) f;
//    }
//    
//    public InteractionLayouter getInteractionLayouter(AbsNode interactionNode) {
//        IFigure f = undressFigure(interactionNode);
//        return ((VisibleInteractionViewMap.VisibleInteractionShape)f).getInteractionLayouter();
//    }
//    
//    @Override
//    public boolean canAsynchCallBeStraight(AbsLink callMessage) {
//        GdeElementEditPart gdeLinkEditPart = ((AbsLinkGef) callMessage).getEditPart();
//        String messageSort = GdeUtil.getEntity(gdeLinkEditPart).getPropertyValue(SD20_Int_CallMessage.MESSAGE_SORT);
//        if ( MessageSort.ASYNCH_CALL.equals(messageSort) || MessageSort.ASYNCH_SIGNAL.equals(messageSort)) {
//            return PreferencesAccess.isOptionEnabled(SequenceDiagramOptions.ALLOW_STRAIGHT_ASYCNH_MESSAGE, gdeLinkEditPart);
//        }
//        return false;
//    }
//    
//    private static IFigure undressFigure(AbsNode gdeNode) {
//        IFigure f = ((AbsElementGef) gdeNode).getFigure();
//        f = ((DecorationFigure)f).getChild();
//        if (f instanceof ShadowPlate) {
//            return ((ShadowPlate) f).getChild();
//        } else {
//            return f;
//        }
//    }
//}
