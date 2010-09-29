package org.eclipse.uml2.diagram.sequence.internal.layout;
//package com.borland.tg.uml20.interaction.internal.layout;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.Collections;
//import java.util.HashSet;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Set;
//
//import org.eclipse.gef.EditPart;
//
//import com.borland.diagram.layout.LayoutAccess;
//import com.borland.diagram.layout.LayoutUtil;
//import com.borland.diagram.layout.graph.Edge;
//import com.borland.diagram.layout.graph.GraphElement;
//import com.borland.diagram.layout.graph.GraphElementFactory;
//import com.borland.diagram.layout.graph.Vertex;
//import com.borland.tg.gde.DiagramViewer;
//import com.borland.tg.gde.GdeElementEditPart;
//import com.borland.tg.gde.GdeLinkEditPart;
//import com.borland.tg.gde.GdeNodeEditPart;
//import com.borland.tg.gde.internal.layoutbridge.DefaultGdeLayout;
//import com.borland.tg.gde.internal.layoutbridge.converter.LinkConverterImpl;
//import com.borland.tg.gde.internal.layoutbridge.converter.NodeConverterImpl;
//import com.borland.tg.gde.layout.GdeLayout;
//
///**
// * 
// */
//public class GdeLayoutForCommunicationDiagram extends DefaultGdeLayout {
//    
//    public static class Factory implements GdeLayout.Factory {
//        public GdeLayout createLayoutManager(DiagramViewer viewer) {
//            return new GdeLayoutForCommunicationDiagram(viewer);
//        }
//    };
//
//    public GdeLayoutForCommunicationDiagram(DiagramViewer viewer) {
//        super(viewer);
//    }
//    
//    public Collection elementsReshaped(Collection reshaped) {
//    	Collection result = super.elementsReshaped(reshaped);
//    	correctLinksToLabels(result);
//		return result;
//    }
//  
//    public void elementAdded(GdeElementEditPart part) {
//        super.elementAdded(part);
//        myAddedParts.add(part);
//    }
//    
//    public void elementRemoved(GdeElementEditPart part) {
//        super.elementRemoved(part);
//    }
//    
//    public void flushScheduled() {
//        super.flushScheduled();
//        for (Iterator it = myAddedParts.iterator(); it.hasNext();) {
//            correctLinkToLabel(it.next());                    
//        }
//        myAddedParts.clear();
//    }
//    
//    public void elementsProperlyReshaped(Collection parts) {
//        super.elementsProperlyReshaped(parts);
//        correctLinksToLabels(parts);
//    }
//    
//    private Set correctLinksToLabels(Collection eps){
//    	Set modified = null;
//    	for(Iterator epsIt = eps.iterator(); epsIt.hasNext();){
//    		Object ep = epsIt.next();
//    		if(correctLinkToLabel(ep)){
//    			if(modified == null){
//    				modified = new HashSet();
//    			}
//    			modified.add(ep);
//    		}
//    	}
//    	return modified == null ? Collections.EMPTY_SET : modified;
//    }
//    
//    private boolean correctLinkToLabel(Object ep) {
//		if(!(ep instanceof GdeLinkEditPart)){
//			return false;
//		}
//		GdeLinkEditPart link = (GdeLinkEditPart) ep;
//		EditPart source = link.getSource();
//		EditPart target = link.getTarget();
//		GdeNodeEditPart label = null;
//		EditPart anotherEnd = null;
//		boolean sourceIsSubstituted = false;
//        if (source == null || target == null) {
//            return false;
//        }
//		if(source.getParent() instanceof GdeLinkEditPart){
//			label = (GdeNodeEditPart) source;
//			anotherEnd = target;
//			sourceIsSubstituted = true;
//		}else if(target.getParent() instanceof GdeLinkEditPart){
//			label = (GdeNodeEditPart) target;
//			anotherEnd = source;
//			sourceIsSubstituted = false;
//		}
//		if(label == null){
//			return false;
//		}
//		LayoutUtil layoutUtil = LayoutAccess.getUtilManager().getLayoutUtil();
//		GraphElementFactory gef = LayoutAccess.getFactoryStorage().getGraphElementFactory();
//		LinkConverterImpl linkConverter = getBridge().getLinkConverterImpl();
//		NodeConverterImpl nodeConverter = getBridge().getNodeConverterImpl();
//		
//		Edge.Info mainEdge = gef.createEdgeInfo(null);
//		linkConverter.convertToLayout(link, mainEdge);
//		mainEdge.setId(null);
//		mainEdge.setStartElementId(null);
//		mainEdge.setEndElementId(null);
//
//		Vertex.Info substitute = gef.createVertexInfo(null);
//		nodeConverter.convertToLayout(label, substitute, null);
//		substitute.setId(null);
//
//		GraphElement.Info another;
//		if(anotherEnd instanceof GdeLinkEditPart){
//			Edge.Info anotherE = gef.createEdgeInfo(null);
//			linkConverter.convertToLayout((GdeLinkEditPart)anotherEnd, anotherE);
//			anotherE.setId(null);
//			anotherE.setStartElementId(null);
//			anotherE.setEndElementId(null);
//			another = anotherE;
//		}else{
//			Vertex.Info anotherV = gef.createVertexInfo(null);
//			nodeConverter.convertToLayout((GdeNodeEditPart)anotherEnd, anotherV, null);
//			anotherV.setId(null);
//			another = anotherV;
//		}
//		Edge.Info result = layoutUtil.layoutEdge(mainEdge, 
//					sourceIsSubstituted ? substitute : another,
//				    sourceIsSubstituted ? another : substitute, null);		
//		linkConverter.convertToGde(link, result);
//		return true;
//	}
//    private List myAddedParts = new ArrayList();
//}
