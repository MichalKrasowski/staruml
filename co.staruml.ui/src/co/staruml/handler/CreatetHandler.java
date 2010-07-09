package co.staruml.handler;

import co.staruml.core.DiagramControl;
import co.staruml.core.EdgeView;
import co.staruml.core.NodeView;
import co.staruml.core.View;
import co.staruml.graphics.*;
import co.staruml.views.UMLClassView;

public class CreatetHandler extends Handler {

	private Point f1, f2; // for selection (zoom, no grid)
	private Point g1, g2; // for moving selected views (zoom, grid)\
	private String type;
	private DiagramControl editor;

	public CreatetHandler(DiagramControl editor) {
		f1 = new Point(0, 0);
		f2 = new Point(0, 0);
		g1 = new Point(0, 0);
		g2 = new Point(0, 0);
		this.type = type;
		this.editor = editor;
	}


	public void mousePressed(DiagramControl diagramControl, Canvas canvas, MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		Point z = new Point(x, y); // point to be create class.
		if(type.equals("Class")){
			UMLClassView nodeView = new UMLClassView();
			nodeView.initialize(null, x, y, x+200, y+200);
			diagramControl.getDiagramView().addOwnedView(nodeView);
			editor.repaint();
		}
	}
	
	public void setType(String type){
		this.type = type;
	}
	
	public void mouseDragged(DiagramControl diagramControl, Canvas canvas, MouseEvent e) {
		
	}
	
	public void mouseReleased(DiagramControl diagramControl, Canvas canvas, MouseEvent e) {
		
	}

	public void mouseMoved(DiagramControl diagramControl, Canvas canvas, MouseEvent e) {
	}

}
