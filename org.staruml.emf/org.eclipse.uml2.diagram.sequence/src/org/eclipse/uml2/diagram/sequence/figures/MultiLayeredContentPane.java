package org.eclipse.uml2.diagram.sequence.figures;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Layer;
import org.eclipse.draw2d.LayeredPane;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.uml2.diagram.common.layered.MultiLayeredContainer;

public class MultiLayeredContentPane extends LayeredPane implements MultiLayeredContainer {
    private final Layer myDefaultLayerContentPane;
    private final Map<String, Layer> myLayerKeyToContentPane = new HashMap<String, Layer>(3);

    public MultiLayeredContentPane () {
        setBorder(new MarginBorder(5));
        setOpaque(false);
        
        setLayoutManager(new DebugStackLayout());
        
        //setBackgroundColor(ColorConstants.yellow);
        
        addLayer(BACKGROUND_LAYER); 
        myDefaultLayerContentPane = addLayer(MIDDLE_LAYER);
        addLayer(FOREGROUND_LAYER);
    }
    
    private Layer addLayer(String key) {
        Layer layer = new LayerWithKey(key);
        layer.setOpaque(false);
        
        if (MIDDLE_LAYER.equals(key)){
        	layer.setOpaque(true);
        }
        
        add(layer, key);
        
        Layer contentPane = ShadowHelper.addChildrenShadowLayer(layer, key);
        contentPane.setLayoutManager(new InteractionContentsLayout());
        myLayerKeyToContentPane.put(key, contentPane);
        return contentPane;
    }
    
    protected void paintFigure(Graphics graphics) {
    	//
    }
    
    public Layer getLayerContentPane(String key) {
        return myLayerKeyToContentPane.get(key);
    }
    
    public Layer getDefaultLayerContentPane() {
        return myDefaultLayerContentPane;
    }
    
    private static class LayerWithKey extends Layer {
    	private final String myDebugKey;

		public LayerWithKey(String debugKey){
			myDebugKey = debugKey;
    	}

    	@Override
    	public String toString() {
    		return "Layer: [" + myDebugKey + "]";
    	}
    }
    
    private static class DebugStackLayout extends StackLayout {
    	@Override
    	public void layout(IFigure figure) {
    		super.layout(figure);
    	}
    }
    
    
}
