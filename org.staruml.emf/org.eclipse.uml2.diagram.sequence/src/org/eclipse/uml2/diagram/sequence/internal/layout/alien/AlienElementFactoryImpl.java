package org.eclipse.uml2.diagram.sequence.internal.layout.alien;

import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsLink;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsNode;
import org.eclipse.uml2.diagram.sequence.internal.layout.model.LmAlienElement;


/**
 * 
 */
public class AlienElementFactoryImpl implements LmAlienElement.Factory {
    public LmAlienElement createAlienNode(AbsNode gdeNode) {
        return new AlienNode(gdeNode);
    }
    public LmAlienElement createAlienLink(AbsLink gdeLink) {
        return new AlienLink(gdeLink);
    }
}
