package co.staruml.handler;

import java.util.HashMap;

import org.eclipse.swt.events.KeyEvent;

import co.staruml.core.Const;
import co.staruml.core.DiagramControl;
import co.staruml.core.EdgeView;
import co.staruml.core.NodeView;
import co.staruml.core.View;
import co.staruml.graphics.*;
import co.staruml.swt.DiagramControlSWT;
import co.staruml.views.UMLClassView;

public class CreatetHandler extends Handler {

	private Point f1, f2; // for selection (zoom, no grid)
	private Point g1, g2; // for moving selected views (zoom, grid)\
	private String type;
	private View view;

	public CreatetHandler() {
		f1 = new Point(0, 0);
		f2 = new Point(0, 0);
		g1 = new Point(0, 0);
		g2 = new Point(0, 0);
		this.type = type;
	}

	public void mousePressed(DiagramControl diagramControl, Canvas canvas, MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		Point z = new Point(x, y); // point to be create class.
		
		// make sure the selected view.
		if ((diagramControl.getDiagramView().getSelectedViews().size() == 1) && 
				(isPointInSelectionLine(canvas, diagramControl.getDiagramView().getSelectedViews().firstElement(), x, y)))
			view = diagramControl.getDiagramView().getSelectedViews().firstElement();
		else
			view = diagramControl.getDiagramView().getViewAt(canvas, z.getX(), z.getY());
		// Class Create
		if(type.equals("Class")){
			UMLClassView nodeView = new UMLClassView();
			nodeView.initialize(null, x, y, x+110, y+80);
			diagramControl.getDiagramView().addOwnedView(nodeView);
		// Composition , Generalization Create
		}else if(type.equals("Composition") || type.equals("Generalization")){
			if(view != null){
				int width = view.getBoundingBox(canvas).getWidth();
				int height = view.getBoundingBox(canvas).getHeight();
				int x1 = view.getBoundingBox(canvas).getX1();
				int x2 = view.getBoundingBox(canvas).getX2();
				int y1 = view.getBoundingBox(canvas).getY1();
				int y2 = view.getBoundingBox(canvas).getY2();
				
				EdgeView edgeView = new EdgeView();
				edgeView.setTail(view);
				edgeView.setHead(view);
				edgeView.setHeadEndStyle(Const.ES_ARROW_FILLED_DIAMOND);
				edgeView.setTailEndStyle(Const.ES_FLAT);
				edgeView.setLineStyle(Const.LS_RECTILINEAR);
				// Set head style
				if(type.equals("Composition")){
					edgeView.setHeadEndStyle(Const.ES_ARROW_FILLED_DIAMOND);
				}else if(type.equals("Generalization")){
					edgeView.setHeadEndStyle(Const.ES_TRIANGLE);
				}
				
				// edgeView1.setLineColor(Color.LIGHT_GRAY);
				edgeView.initialize(canvas, x1+width/2, y1 , x2, y1+height/2);
				diagramControl.getDiagramView().addOwnedView(edgeView);
			}
		}
		diagramControl.repaint();
		DiagramControlSWT swt = ((DiagramControlSWT)diagramControl);
		diagramControl.setHandler(swt.handerMap.get("selectHandler"));
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
	
	private boolean isPointInSelectionLine(Canvas canvas, View view, int x, int y) {
		if (view == null)
			return false;
		if (!view.isSelected())
			return false;
		Point z = new Point(x, y);
		Coord.coordRevTransform(canvas.getZoomFactor(), GridFactor.NO_GRID, z);
		if (view instanceof NodeView) {
			Rect zr = view.getBoundingBox(canvas);
			Coord.coordTransform(canvas.getZoomFactor(), GridFactor.NO_GRID, zr);
			if (!Coord.ptInRect(x, y, zr) && 
					(view.containsPoint(canvas, z.getX(), z.getY())))
				return true;
		} else if (view instanceof EdgeView) {
			return view.containsPoint(canvas, z.getX(), z.getY());
		}
		return false;
	}

	@Override
	public void keyPressed(DiagramControl diagramControl, Canvas canvas,
			KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
