package org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.gef;
//package com.borland.tg.uml20.interaction.internal.layout.abstractgde.gef;
//
//import org.eclipse.draw2d.geometry.Point;
//import org.eclipse.draw2d.geometry.Rectangle;
//import org.eclipse.gef.EditPartViewer;
//
//import com.borland.diagram.layout.LayoutManager;
//import com.borland.diagram.layout.graph.Edge;
//import com.borland.diagram.layout.graph.Vertex;
//import com.borland.tg.gde.layoutbridge.LayoutBridge;
//import com.borland.tg.gde.layoutbridge.LayoutBridgeAccess;
//import com.borland.tg.gde.layoutbridge.LayoutBridgeUtil;
//import com.borland.tg.uml20.interaction.internal.layout.abstractgde.AbsLink;
//import com.borland.tg.uml20.interaction.internal.layout.abstractgde.AbsLayoutAccess;
//import com.borland.tg.uml20.interaction.internal.layout.abstractgde.AbsNode;
//import com.borland.tg.gde.GdeLinkEditPart;
//import com.borland.tg.gde.GdeNodeEditPart;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * 
// * [U2T] disabled
// */
//public class AbsLayoutAccessGef implements AbsLayoutAccess {
//    public AbsLayoutAccessGef(EditPartViewer diagramViewer) {
//        myLayoutUtil = LayoutBridgeAccess.getBridge(diagramViewer).getUtil();
//        myLayoutBridge = LayoutBridgeAccess.getBridge(diagramViewer);
//    }
//    
//    
//    public void layoutLink(AbsLink absLink) {
//        GdeLinkEditPart linkEditPart = getLinkEditPart(absLink);
//        
//        LinkPointsChecker linkPointsChecker = new LinkPointsChecker(linkEditPart);
//        
//        myLayoutUtil.layoutLink(linkEditPart);
//        
//        if (linkPointsChecker.pointsDiffer(linkEditPart)) {
//            ((AbsLinkGef) absLink).pointsAreChanged();
//        }
//    }
//
//    public void totalDiscardLinkPositions(AbsLink absLink) {
//        GdeLinkEditPart linkEditPart = getLinkEditPart(absLink);
//        LayoutBridgeUtil.totalDiscardLinkPositions(linkEditPart);
//    }
//    
//    
//    public Vertex.Info convertToInfo(AbsNode absNode) {
//        GdeNodeEditPart nodeEditPart = getNodeEditPart(absNode);
//        return myLayoutUtil.createVertexInfo(nodeEditPart);
//    }
//    
//    public Edge.Info convertToInfo(AbsLink absLink) {
//        GdeLinkEditPart linkEditPart = getLinkEditPart(absLink);
//        return myLayoutUtil.createEdgeInfo(linkEditPart);
//    }
//    
//    public void convertToGde(Vertex.Info vertexInfo, AbsNode absNode) {
//        GdeNodeEditPart nodeEditPart = getNodeEditPart(absNode);
//        Rectangle oldBounds = nodeEditPart.getBounds().getCopy();
//        myLayoutBridge.getNodeConverter().convertToGde(nodeEditPart, vertexInfo);
//        if (! oldBounds.equals(nodeEditPart.getBounds())) {
//            ((AbsNodeGef) absNode).boundsAreChanged(AbsDiagramGef.ChangePositionWatcher.ChangePositionListener.ALL);
//        }
//    }
//
//    public void convertToGde(Edge.Info linkInfo, AbsLink absLink) {
//        GdeLinkEditPart linkEditPart = getLinkEditPart(absLink);
//        
//        LinkPointsChecker linkPointsChecker = new LinkPointsChecker(linkEditPart);
//        
//        myLayoutBridge.getLinkConverter().convertToGde(linkEditPart, linkInfo);
//        
//        if (linkPointsChecker.pointsDiffer(linkEditPart)) {
//            ((AbsLinkGef) absLink).pointsAreChanged();
//        }
//    }
//    
//    public LayoutManager getLayoutManager() {
//        return myLayoutBridge.getLayoutManager();
//    }
//    
//    private static GdeNodeEditPart getNodeEditPart(AbsNode absNode) {
//        return (GdeNodeEditPart)((AbsNodeGef)absNode).getEditPart();
//    }
//    
//    private static GdeLinkEditPart getLinkEditPart(AbsLink absLink) {
//        return (GdeLinkEditPart)((AbsLinkGef)absLink).getEditPart();
//    }
//    
//    private final LayoutBridgeUtil myLayoutUtil;
//    private final LayoutBridge myLayoutBridge;
//    
//    private static class LinkPointsChecker {
//        LinkPointsChecker(GdeLinkEditPart linkEditPart) {
//            myOldSource = linkEditPart.getSourcePoint().getCopy();
//            myOldTarget = linkEditPart.getTargetPoint().getCopy();
//            
//            List bendpoints = linkEditPart.getBendpoints();
//            myOldBendpoints = new ArrayList(bendpoints.size());
//            for (int i = 0; i<bendpoints.size(); i++) {
//                Point next = (Point)bendpoints.get(i);
//                myOldBendpoints.add(next.getCopy());
//            }
//        }
//        
//        boolean pointsDiffer(GdeLinkEditPart linkEditPart) {
//            return  ! myOldSource.equals(linkEditPart.getSourcePoint()) ||
//                    ! myOldTarget.equals(linkEditPart.getTargetPoint()) ||
//                    ! myOldBendpoints.equals(linkEditPart.getBendpoints());
//        }
//        
//        private final Point myOldSource;
//        private final Point myOldTarget;
//        private final List myOldBendpoints;
//    }
//}
