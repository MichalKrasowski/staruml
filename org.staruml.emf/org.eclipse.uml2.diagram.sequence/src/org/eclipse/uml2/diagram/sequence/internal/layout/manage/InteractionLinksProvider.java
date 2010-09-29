package org.eclipse.uml2.diagram.sequence.internal.layout.manage;

import java.util.Iterator;

/**
 * 
 */
public interface InteractionLinksProvider {
    /**
     * @return all links between nodes inside controlled interaction. 
     */
    Iterator/*<com.borland.tg.gde.GdeLinkEditPart>*/ linkEditParts();
}
