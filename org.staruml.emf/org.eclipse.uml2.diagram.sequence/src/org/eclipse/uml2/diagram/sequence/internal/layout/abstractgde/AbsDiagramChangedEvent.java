package org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde;

import java.util.List;

/**
 * 
 */
public interface AbsDiagramChangedEvent {
    List getRemovedLinks();
    List getRemovedNodes();
    
    List getAddedNodes();
    List getAddedLinks();
}
