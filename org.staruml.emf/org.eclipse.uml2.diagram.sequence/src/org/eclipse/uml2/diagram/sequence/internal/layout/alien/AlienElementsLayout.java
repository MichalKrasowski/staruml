package org.eclipse.uml2.diagram.sequence.internal.layout.alien;
//package com.borland.tg.uml20.interaction.internal.layout.alien;
//
//import java.awt.Dimension;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//
//import com.borland.tg.uml20.interaction.internal.layout.abstractgde.AbsDiagram;
//import com.borland.tg.uml20.interaction.internal.layout.abstractgde.AbsElement;
//import com.borland.tg.uml20.interaction.internal.layout.abstractgde.AbsLayoutAccess;
//import com.borland.tg.uml20.interaction.internal.layout.abstractgde.AbsLink;
//import com.borland.tg.uml20.interaction.internal.layout.abstractgde.AbsLinkEnumeration;
//import com.borland.tg.uml20.interaction.internal.layout.abstractgde.AbsNode;
//import com.borland.tg.uml20.interaction.internal.layout.abstractgde.AbsNodeEnumeration;
//import com.borland.tg.uml20.interaction.internal.layout.model.LmObjectsResolver;
//import com.borland.tg.uml20.interaction.internal.layout.model.SdLayoutModelAccess;
//
///**
// * 
// */
//public class AlienElementsLayout implements IAlienElementsLayout {
//    public AlienElementsLayout(SdLayoutModelAccess layoutModelAccess, AbsDiagram gdeDiagram, AbsLayoutAccess absLinkLayoutAccess) {
//        myLayoutModelAccess = layoutModelAccess;
//        myGdeDiagram = gdeDiagram;
//        myAbsLinkLayoutAccess = absLinkLayoutAccess; 
//    }
//    
//    public Dimension layoutReshaped(Collection reshapedGdeElements, int clientAreaLeft, int clientAreaTop) {
//        // Here we rely on the fact, that source and destination of GdeLinks cannot be both links at the same time 
//    
//        List sdElementsList = new ArrayList();
//        Set alienLinks = new HashSet();
//        
//        for (Iterator it = reshapedGdeElements.iterator(); it.hasNext(); ) {
//            AbsElement gdeElement = (AbsElement) it.next();
//            
//            if (gdeElement instanceof AbsNode) {
//                sdElementsList.add(gdeElement);
//            } else {
//                AbsLink gdeLink = (AbsLink) gdeElement;
//                
//                Object lmObject = getLmObjectsResolver().getLmObject(gdeElement);
//                
//                if (lmObject instanceof AlienLink) {
//                    alienLinks.add(lmObject);
//                } else {
//                    sdElementsList.add(gdeLink);
//                }
//            }
//        }
//        
//        Set firstOrderAbsLinks = new HashSet();
//        
//        LinksCache linksCache = new LinksCache(myGdeDiagram, getLmObjectsResolver());
//        
//        for (Iterator it = sdElementsList.iterator(); it.hasNext(); ) {
//            AbsElement gdeElement = (AbsElement) it.next();
//            Collection relatedAbsAlienLinks = linksCache.getLinks(gdeElement);
//            
//            firstOrderAbsLinks.addAll(relatedAbsAlienLinks);
//        }
//
//        List alienLinksToLayout = sortGdeLinks(firstOrderAbsLinks, alienLinks, linksCache);
//        
//        Dimension result = placeAllAlienNodesInClientArea(clientAreaLeft, clientAreaTop);
//        layoutLinks(alienLinksToLayout);
//        return result;
//    }
//    
//    public Dimension fullLayout(int alienElementsAreaLeft, int alienElementsAreaTop) {
//        Set allLinks = new HashSet();
//        for (AbsLinkEnumeration linksEnum = myGdeDiagram.links(); linksEnum.hasMoreElements(); ) {
//            AbsLink gdeLink = linksEnum.nextGdeLink();
//            Object lmObject = getLmObjectsResolver().getLmObject(gdeLink);
//            if (lmObject instanceof AlienLink) {
//                allLinks.add(lmObject);
//            }
//        }
//        
//        LinksCache linksCache = new LinksCache(myGdeDiagram, getLmObjectsResolver());
//    
//        List alienLinksToLayout = sortGdeLinks(Collections.EMPTY_SET, allLinks, linksCache);
//        
//        AlienElementsFullLayout fullLayout = new AlienElementsFullLayout(myAbsLinkLayoutAccess, getLmObjectsResolver());
//        fullLayout.readElements(myGdeDiagram, alienLinksToLayout);
//        return fullLayout.layout(alienElementsAreaLeft, alienElementsAreaTop);
//        //layoutLinks(alienLinksToLayout, true);
//    }
//    
//    private List sortGdeLinks(Set firstOrderAbsLinks, Collection alienLinks, LinksCache linksCache) {
//        List resultAbsLinksList = new ArrayList();
//
//        resultAbsLinksList.addAll(firstOrderAbsLinks);
//
//        
//        Collection absLinksWeCanDependOn = new ArrayList(firstOrderAbsLinks.size()+alienLinks.size());
//        absLinksWeCanDependOn.addAll(firstOrderAbsLinks);
//        for (Iterator it = alienLinks.iterator(); it.hasNext(); ) {
//            AlienLink alienLink = (AlienLink) it.next();
//            absLinksWeCanDependOn.add(alienLink.getGdeLink());
//        }
//        
//        List nondependentAlienGdeLinks = new ArrayList(alienLinks.size());
//        
//        for (Iterator it = alienLinks.iterator(); it.hasNext(); ) {
//            AlienLink alienLink = (AlienLink) it.next();
//            
//            AbsLink gdeLink = alienLink.getGdeLink();
//            
//            if (doesDependOnAny(gdeLink, absLinksWeCanDependOn)) {
//                continue;
//            } else {
//                nondependentAlienGdeLinks.add(gdeLink);
//            }
//        }
//        
//        resultAbsLinksList.addAll(nondependentAlienGdeLinks);
//        
//        if (resultAbsLinksList.isEmpty()) {
//            return Collections.EMPTY_LIST;
//        }
//        
//        int size = resultAbsLinksList.size();
//        for (int i=0; i<size; i++) {
//            AbsLink gdeLink = (AbsLink) resultAbsLinksList.get(i);
//            addRelatedLinks(gdeLink, resultAbsLinksList, linksCache);
//        }
//        
//        return resultAbsLinksList;
//    }
//    
//    private boolean doesDependOnAny(AbsLink gdeLink, Collection otherLinks) {
//        AbsElement source = gdeLink.getSource();
//        if (source instanceof AbsLink) {
//            if (otherLinks.contains(source)) {
//                return true;
//            }
//            if (doesDependOnAny((AbsLink)source, otherLinks)) {
//                return true;
//            }
//        }
//        AbsElement destination = gdeLink.getDestination();
//        if (destination instanceof AbsLink) {
//            if (otherLinks.contains(destination)) {
//                return true;
//            }
//            if (doesDependOnAny((AbsLink)destination, otherLinks)) {
//                return true;
//            }
//        }
//        return false;
//    }
//    
//    private void addRelatedLinks(AbsLink gdeLink, List list, LinksCache linksCache) {
//        Collection links = linksCache.getLinks(gdeLink);
//        for (Iterator it = links.iterator(); it.hasNext(); ) {
//            AbsLink relatedLink = (AbsLink) it.next();
//            list.add(relatedLink);
//            addRelatedLinks(relatedLink, list, linksCache);
//        }
//    }
//    
//    protected LmObjectsResolver getLmObjectsResolver() {
//        return myLayoutModelAccess.getLayoutModel().getLmObjectsResolver();
//    }
//    
//    private void layoutLinks(Collection alienAbsLinks) {
//        if (alienAbsLinks == null) {
//            return;
//        }
//        for (Iterator it = alienAbsLinks.iterator(); it.hasNext(); ) {
//            AbsLink gdeLink = (AbsLink) it.next();
//            myAbsLinkLayoutAccess.layoutLink(gdeLink);
//        }
//    }
//    
//    private Dimension placeAllAlienNodesInClientArea(int clientAreaLeft, int clientAreaTop) {
//        Dimension result = new Dimension(0, 0);
//        for (AbsNodeEnumeration nodeEnumeration = myGdeDiagram.getInteractionAbsNode().subnodes(); nodeEnumeration.hasMoreElements(); ) {
//            AbsNode absNode = nodeEnumeration.nextGdeNode();
//            if (! (getLmObjectsResolver().getLmObject(absNode) instanceof AlienNode)) {
//                continue;
//            }
//            //CR#28283
//            if (absNode.isExternal()) {
//                continue;
//            }
//            
//            if (absNode.getX() < clientAreaLeft) {
//                absNode.setX(clientAreaLeft);
//            }
//            if (absNode.getY() < clientAreaTop) {
//                absNode.setY(clientAreaTop);
//            }
//            
//            result.width = Math.max(result.width, absNode.getX()+absNode.getWidth() - clientAreaLeft);
//            result.height = Math.max(result.height, absNode.getY()+absNode.getHeight() - clientAreaTop);
//        }
//        return result;
//    }
//
//    private final AbsDiagram myGdeDiagram;
//    private final SdLayoutModelAccess myLayoutModelAccess;
//    
//    
//    
//    private static class LinksCache {
//        LinksCache(AbsDiagram gdeDiagram, LmObjectsResolver lmObjectsResolver) {
//            for (AbsLinkEnumeration linksEnum = gdeDiagram.links(); linksEnum.hasMoreElements(); ) {
//                AbsLink link1 = linksEnum.nextGdeLink();
//                
//                Object lmObject = lmObjectsResolver.getLmObject(link1);
//                if (lmObject instanceof AlienLink) {
//                    addToMap(link1.getSource(),link1);
//                    addToMap(link1.getDestination(),link1);
//                }
//            }
//        }
//        Collection getLinks(AbsElement gdeElement) {
//            List list = (List) myGdeElement2linksList.get(gdeElement);
//            if (list == null) {
//                return Collections.EMPTY_LIST;
//            } else {
//                return list;
//            }
//        }
//        private void addToMap(AbsElement linkEnd, AbsLink gdeLink) {
//            if (linkEnd == null) {
//                return;
//            }
//            List linksList = (List) myGdeElement2linksList.get(linkEnd);
//            if (linksList == null) {
//                linksList = new ArrayList(3);
//                myGdeElement2linksList.put(linkEnd, linksList);
//            }
//            linksList.add(gdeLink);
//        }
//        private final Map myGdeElement2linksList = new HashMap();
//    }
//
//
//    private final AbsLayoutAccess myAbsLinkLayoutAccess;
//}
