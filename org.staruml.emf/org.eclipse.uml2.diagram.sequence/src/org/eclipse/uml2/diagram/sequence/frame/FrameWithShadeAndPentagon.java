package org.eclipse.uml2.diagram.sequence.frame;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Layer;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.uml2.diagram.common.layered.MultiLayeredContainer;
import org.eclipse.uml2.diagram.sequence.figures.ShadowHelper;
import org.eclipse.uml2.diagram.sequence.internal.layout.model.LMFrame;



public class FrameWithShadeAndPentagon extends FrameWithPentagon {
	private final FrameShade myFrameShade;
	private final BackgroundLayouterImpl myBackgroundLayouter;
	
	public FrameWithShadeAndPentagon(){
		super();
		
        getMultilayeredSupportImpl().setLayerToFigure(MultiLayeredContainer.FOREGROUND_LAYER, this);
        getMultilayeredSupportImpl().setLayerToContentPane(MultiLayeredContainer.FOREGROUND_LAYER, this);
        
        myFrameShade = new FrameShade(this);
        Layer childrenContainer = ShadowHelper.addChildrenShadowLayer(myFrameShade, "FrameShade");
        
        myBackgroundLayouter = new BackgroundLayouterImpl(myFrameShade);
       
        getMultilayeredSupportImpl().setLayerToFigure(MultiLayeredContainer.BACKGROUND_LAYER, myFrameShade);
        getMultilayeredSupportImpl().setLayerToContentPane(MultiLayeredContainer.BACKGROUND_LAYER, childrenContainer);
	}
	
	public BackgroundLayouterImpl getBackgroundLayouter() {
		return myBackgroundLayouter;
	}
	
    public static class BackgroundLayouterImpl  implements LMFrame.BackgroundLayouter  {
        BackgroundLayouterImpl(IFigure backgroundFigure) {
            myBackgroundFigure = backgroundFigure;
        }
        
        //LMFrame.BackgroundLayouter methods
        public void setX(int x) {
            Rectangle bounds = myBackgroundFigure.getBounds().getCopy();
            bounds.x = x;
            myBackgroundFigure.setBounds(bounds);
            
            revalidate();
        }
        
        public void setY(int y) {
            Rectangle bounds = myBackgroundFigure.getBounds().getCopy();
            bounds.y = y;
            myBackgroundFigure.setBounds(bounds);
        }
        
        public void setHeight(int height) {
            Rectangle bounds = myBackgroundFigure.getBounds().getCopy();
            bounds.height = height;
            myBackgroundFigure.setBounds(bounds);
        }
        
        public void setWidth(int width) {
            Rectangle bounds = myBackgroundFigure.getBounds().getCopy();
            bounds.width = width;
            myBackgroundFigure.setBounds(bounds);
        }
        
        /**
         * Parent figure may be valid so we should explicitly force this fugure revalidation.
         */
        private void revalidate() {
            myBackgroundFigure.revalidate();
        }
        
        private final IFigure myBackgroundFigure;
    }
}
