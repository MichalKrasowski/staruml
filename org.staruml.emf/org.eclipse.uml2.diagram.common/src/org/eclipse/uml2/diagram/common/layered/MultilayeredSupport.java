package org.eclipse.uml2.diagram.common.layered;

import org.eclipse.draw2d.IFigure;

/**
 * Parts of this figure could be placed on different 
 * layers of its container.
 * 
 * @author Yury Semikhatsky
 */
public interface MultilayeredSupport {
    /**
     * Should be called when this figure is being added/removed 
     * to/from a layerd container.
     */
    void addToLayers(MultiLayeredContainer container);
    void removeFromLayers(MultiLayeredContainer container);
    /**
     * Used to preserve parent-child relationship corresponding
     * to that of EditParts. 
     * 
     * @return content pane of part of this figure situated on the layer
     * with key <code>layerKey</code>
     */
    IFigure getContentPaneOn(String layerKey);
}
