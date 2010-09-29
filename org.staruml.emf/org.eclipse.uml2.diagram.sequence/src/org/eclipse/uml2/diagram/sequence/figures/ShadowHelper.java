package org.eclipse.uml2.diagram.sequence.figures;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Layer;
import org.eclipse.draw2d.LayeredPane;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.uml2.diagram.sequence.draw2d.layouts.FillingBorderLayout;
import org.eclipse.uml2.diagram.sequence.draw2d.shadow.ShadowLayer;



public class ShadowHelper {
    public static Layer addChildrenShadowLayer(IFigure content, final String debugKey) {
        //ChildrenContainerFigure is used instead of more simple Layer descendant because it 
        //is responsible for propagating figure figure bounds changes to constraints of AbsoluteXYLayout  
        Layer childrenContainer = new DebugChildrenContainerFigure(debugKey);
        childrenContainer.setOpaque(false);
        //childrenContainer.setLayoutManager(new AbsoluteXYLayout());
        childrenContainer.setLayoutManager(new XYLayout());
        LayeredPane pane = addShadowLayer(childrenContainer);
        content.setLayoutManager(new FillingBorderLayout());
        content.add(pane, FillingBorderLayout.CENTER);
        return childrenContainer;
    }
      
    public static LayeredPane addShadowLayer(IFigure container) {
  		LayeredPane pane = new LayeredPane();
  		ShadowLayer shadowLayer = new ShadowLayer();
  		shadowLayer.addClient(container);
  		pane.add(shadowLayer);
  		pane.add(container);
  		return pane;
  	}
    
    private static class DebugChildrenContainerFigure extends ChildrenContainerFigure {
    	private final String myDebugKey;

		public DebugChildrenContainerFigure(String debugKey){
			myDebugKey = debugKey;
    	}
		
    	@Override
    	public String toString() {
    		return "DebugChildrenContainerFigure for : " + myDebugKey + " - " + System.identityHashCode(this);
    	}
    }

}
