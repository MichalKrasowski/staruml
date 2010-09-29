package org.eclipse.uml2.diagram.sequence.figures;

import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.Layer;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.uml2.diagram.common.layered.MultiLayeredContainer;
import org.eclipse.uml2.diagram.sequence.draw2d.layouts.FillingBorderLayout;
import org.eclipse.uml2.diagram.sequence.internal.layout.manage.InteractionLayouter;



public class InteractionShape extends InteractionShapeBase implements MultiLayeredContainer {
	private final MultiLayeredContentPane myMultilayeredContentPane = new MultiLayeredContentPane();
	private Label myInteractionNameLabel;
	private boolean myIsFullScreen;
	
	public InteractionShape() {
        createPentagonContent();
        
        add(myMultilayeredContentPane, FillingBorderLayout.CENTER);
//        myMultilayeredContentPane.setOpaque(true);
//        for (Iterator it = myMultilayeredContentPane.getChildren().iterator(); it.hasNext();) {
//            ((IFigure)it.next()).setOpaque(true);
//        }
//        myMultilayeredContentPane.setBackgroundColor(ColorConstants.yellow);
    }
    
	public Label getInteractionNameLabel() {
		return myInteractionNameLabel;
	}
	
	public void setIsFullScreen(boolean isFullScreen){
		myIsFullScreen = isFullScreen;
	}
	
	protected boolean isFullScreen() {
		return myIsFullScreen;
	}
	
	protected MultiLayeredContentPane getMultilayeredContentPane() {
		return myMultilayeredContentPane;
	}

    public Layer getLayerContentPane(String key) {
        return myMultilayeredContentPane.getLayerContentPane(key);
    }
    
    public Layer getDefaultLayerContentPane() {
        return myMultilayeredContentPane.getDefaultLayerContentPane();
    }
    
     public InteractionLayouter getInteractionLayouter() {
        return myInteractionLayouter;
    }
    
    
    private void createPentagonContent() {
        InvisibleRectangle compositeLabel = new InvisibleRectangle();
        compositeLabel.setLayoutManager(new ToolbarLayout(ToolbarLayout.HORIZONTAL));
        
        Label sdLabel = new Label("sd ");
        compositeLabel.add(sdLabel);
        
        myInteractionNameLabel = new Label("");
        compositeLabel.add(myInteractionNameLabel);
        
        setPentagonContent(compositeLabel);
    }

     private final InteractionLayouter myInteractionLayouter = new InteractionLayouter() {
        public boolean isFullScreen() {
            return myIsFullScreen;
        }
        public int getPentagonPreferredHeight() {
            return getPentagonPane().getPreferredSize().height;
            //return myPentagon.getPreferredHeight();
        }
        public int getPentagonPreferredWidth() {
            return getPentagonPane().getPreferredSize().width;
            //return myPentagon.getPreferredWidth();
        }
    };
}
