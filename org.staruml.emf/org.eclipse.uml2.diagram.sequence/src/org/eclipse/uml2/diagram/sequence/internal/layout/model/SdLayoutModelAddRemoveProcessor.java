package org.eclipse.uml2.diagram.sequence.internal.layout.model;

import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsLink;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsNode;

/**
 * 
 */
public interface SdLayoutModelAddRemoveProcessor {
    
    boolean processAddedGdeNode(AbsNode gdeNode);
    boolean processRemovedGdeNode(AbsNode gdeNode);
    boolean processAddedGdeLink(AbsLink absLink);
    boolean processRemovedGdeLink(AbsLink absLink);
    
    void finish();
}
