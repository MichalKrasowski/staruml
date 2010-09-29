package org.eclipse.uml2.diagram.sequence.internal.layout.manage;

import java.util.Collection;
import java.util.HashSet;

import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsElement;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsLink;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsNode;
import org.eclipse.uml2.diagram.sequence.internal.layout.model.SdLayoutModelAddRemoveProcessor;

/**
 * 
 */
public class AlienElementProcessor implements SdLayoutModelAddRemoveProcessor{
    public boolean processRemovedGdeNode(AbsNode gdeNode) {
        return true;
    }
    public boolean processRemovedGdeLink(AbsLink absLink) {
        return true;
    }
    
    public boolean processAddedGdeNode(AbsNode gdeNode) {
        return elementAdded(gdeNode);
    }

    public boolean processAddedGdeLink(AbsLink absLink) {
        return elementAdded(absLink);
    }

    private boolean elementAdded(AbsElement gdeElement) {
        return myReshapedGdeElements.add(gdeElement);
    }

    public void elementReshaped(AbsElement absElement) {
        myReshapedGdeElements.add(absElement);
    }
    
    public void finish() {
    }
    
    public Collection getReshapedGdeElements() {
        return myReshapedGdeElements;
    }
    
    private Collection myReshapedGdeElements = new HashSet();//ArrayList ??

}
