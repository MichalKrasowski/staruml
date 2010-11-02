package org.eclipse.uml2.diagram.common.layered;

import org.eclipse.draw2d.Layer;

/**
 * Represents IFigure which has layered structure.
 * All child figures are placed on the middle layer
 * by default.
 * 
 * @author Yury Semikhatsky 
 */
public interface MultiLayeredContainer {
    Layer getLayerContentPane(String key);
    
    String BACKGROUND_LAYER = "Background layer"; //$NON-NLS-1$
    /**
     * default Layer
     */
    String MIDDLE_LAYER = "Middle layer"; //$NON-NLS-1$
    String FOREGROUND_LAYER = "Foreground layer"; //$NON-NLS-1$
}
