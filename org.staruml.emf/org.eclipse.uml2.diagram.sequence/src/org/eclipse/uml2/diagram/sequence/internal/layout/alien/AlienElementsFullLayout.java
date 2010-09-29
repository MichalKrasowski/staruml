package org.eclipse.uml2.diagram.sequence.internal.layout.alien;
//package com.borland.tg.uml20.interaction.internal.layout.alien;
//
//import com.borland.diagram.layout.LayoutAccess;
//import com.borland.diagram.layout.graph.Edge;
//import com.borland.diagram.layout.graph.Graph;
//import com.borland.diagram.layout.graph.GraphElement;
//import com.borland.diagram.layout.graph.GraphElementFactory;
//import com.borland.diagram.layout.graph.InfoStore;
//import com.borland.diagram.layout.graph.Vertex;
//import com.borland.diagram.layout.identification.GraphElementId;
//import com.borland.diagram.layout.identification.IdGenerator;
//import com.borland.tg.uml20.interaction.internal.layout.abstractgde.AbsDiagram;
//import com.borland.tg.uml20.interaction.internal.layout.abstractgde.AbsLink;
//import com.borland.tg.uml20.interaction.internal.layout.abstractgde.AbsLayoutAccess;
//import com.borland.tg.uml20.interaction.internal.layout.abstractgde.AbsNode;
//import com.borland.tg.uml20.interaction.internal.layout.abstractgde.AbsNodeEnumeration;
//import com.borland.tg.uml20.interaction.internal.layout.model.LmAlienElement;
//import com.borland.tg.uml20.interaction.internal.layout.model.LmObjectsResolver;
//import java.awt.Dimension;
//import java.awt.Rectangle;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.LinkedHashSet;
//import java.util.List;
//import java.util.Map;
//
///**
// * We assume that at least one of link ends is a node.
// * 
// * 
// */
//public class AlienElementsFullLayout {
//    AlienElementsFullLayout (AbsLayoutAccess layoutAccess, LmObjectsResolver lmObjectsResolver) {
//        myLayoutAccess = layoutAccess;
//        myLmObjectResolver = lmObjectsResolver;
//        
//        myGeFactory = LayoutAccess.getFactoryStorage().getGraphElementFactory();
//        IdGenerator idg = myLayoutAccess.getLayoutManager().getIdGenerator();
//        myGraph = myGeFactory.createGraph(idg);
//    }
//    
//    void readElements(AbsDiagram absDiagram, List alienLinksOrderedList) {
//        collectNodes(absDiagram.getInteractionAbsNode().subnodes());
//        collectLinks(alienLinksOrderedList);
//    }
//    
//    Dimension layout(int startX, int startY) {
//        InfoStore layoutResult = layoutGraph(startX, startY);
//        convertToGde(layoutResult);
//        
//        Rectangle area = new Rectangle();
//        LayoutAccess.getUtilManager().getGraphUtil().calculateGraphBounds(myGraph, area);
//        return area.getSize();
//    }
//    
//    private InfoStore layoutGraph(int startX, int startY) {
//        return LayoutAccess.getUtilManager().getLayoutUtil().layoutGraph(myGraph, startX, startY);
//    }
//    
//    private void convertToGde(InfoStore layoutResult) {
//        if(layoutResult == null){
//            return; 
//        }
//        convertNodesToGde(layoutResult);
//        convertLinksToGde(layoutResult);
//    }
//
//    private void convertNodesToGde(InfoStore layoutResult) {
//        Iterator graphNodes = layoutResult.vertexInfos();
//        while (graphNodes.hasNext()) {
//            Vertex.Info vertexInfo = (Vertex.Info) graphNodes.next();
//            
//            AbsNode absNode = (AbsNode)myIdToAbsElement.get(vertexInfo.getId());
//            myLayoutAccess.convertToGde(vertexInfo, absNode);
//        }
//    }
//    
//    private void convertLinksToGde(InfoStore layoutResult) {
//        convertAlienToAlienLinksToGde(layoutResult);
//        convertAlienToNativeLinksToGde();
//    }
//
//    private void convertAlienToAlienLinksToGde(InfoStore layoutResult) {
//        Iterator graphLinks = layoutResult.edgeInfos();
//        while (graphLinks.hasNext()) {
//            Edge.Info edgeInfo = (Edge.Info) graphLinks.next();
//            
//            AbsLink absLink = (AbsLink)myIdToAbsElement.get(edgeInfo.getId());
//            assert ! myAlienToNativeAbsLinks.contains(absLink);
//            myLayoutAccess.convertToGde(edgeInfo, absLink);
//        }
//    }
//
//    private void convertAlienToNativeLinksToGde() {
//        for (Iterator it = myAlienToNativeAbsLinks.iterator(); it.hasNext(); ) {
//            AbsLink next = (AbsLink)it.next();
//            myLayoutAccess.layoutLink(next);
//        }
//    }
//    
//    private void collectLinks(List orderedAlienLinks) {
//        myAlienToNativeAbsLinks = new LinkedHashSet(orderedAlienLinks.size());
//        
//        for (Iterator links = orderedAlienLinks.iterator(); links.hasNext(); ) {
//            AbsLink absLink = (AbsLink)links.next();
//            
//            myLayoutAccess.totalDiscardLinkPositions(absLink);// discard current link positions to perform full layout 
//            
//            Edge.Info edgeInfo = myLayoutAccess.convertToInfo(absLink);
//            
//            GraphElementId edgeId = edgeInfo.getId();
//
//            GraphElement start = myGraph.getElement(edgeInfo.getStartElementId());
//            GraphElement end = myGraph.getElement(edgeInfo.getEndElementId());
//            
//            if (start == null ^ end == null) {
//                myAlienToNativeAbsLinks.add(absLink);
//            }
//            
//            if (start == null || end == null) {
//                assert !(start == null && end == null) : "Native link found while alien is expected"; //$NON-NLS-1$
//                continue;
//            }
//            
//            Edge edge = myGeFactory.createEdge(edgeId, start, end);
//            edge.getDescriptor().readFrom(edgeInfo);
//            
//            myGraph.addEdge(edge);
//            myIdToAbsElement.put(edgeId, absLink);
//        }
//    }
//
//    private void collectNodes(AbsNodeEnumeration nodes) {
//        while (nodes.hasMoreElements()) {
//            AbsNode absNode = nodes.nextGdeNode();
//            if (! isAlienElement(absNode)) {
//                continue;
//            }
//            
//            Vertex.Info vertexInfo = myLayoutAccess.convertToInfo(absNode);
//            
//            GraphElementId originalId =  vertexInfo.getId();// store EditPart in this id
//            
//            Vertex vertex = myGeFactory.createVertex(originalId);
//            vertex.getDescriptor().readFrom(vertexInfo);
//            
//            myGraph.addVertex(vertex);
//            myIdToAbsElement.put(originalId, absNode);
//            
//            collectNodes(absNode.subnodes());
//        }
//    }
//    
//    private boolean isAlienElement(AbsNode absNode) {
//        Object lmObject = myLmObjectResolver.getLmObject(absNode);
//        return (lmObject instanceof LmAlienElement);
//    }
//
//    private final AbsLayoutAccess myLayoutAccess;
//    private final LmObjectsResolver myLmObjectResolver;
//    
//    private final Graph myGraph;
//    private final GraphElementFactory myGeFactory;
//    private final Map myIdToAbsElement = new HashMap();
//    
//    private LinkedHashSet myAlienToNativeAbsLinks;//This links should be layouted after all alien to alien links have been layouted
//}