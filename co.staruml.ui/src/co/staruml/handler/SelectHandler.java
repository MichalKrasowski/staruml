package co.staruml.handler;

import java.util.Vector;

import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.KeyEvent;

import co.staruml.core.DiagramControl;
import co.staruml.core.DiagramView;
import co.staruml.core.EdgeView;
import co.staruml.core.NodeView;
import co.staruml.core.View;
import co.staruml.graphics.*;
import co.staruml.swt.DiagramControlSWT;
import co.staruml.ui.editors.SWTCompositeUtil;

/*
 * (Notice) Choice of coordinates in SelectHandler
 * -------------------------------------------------
 * 1. Seleting behavior
 *    - Zoom only applied coordinate
 *    - Use f1, f2 variable
 * 2. Moving behavior with multiple selected views
 *    - Zoom and grid applied coordinate
 *    - Use g1, g2 variable
 * 3. Manipulating behavior with one selected view
 *    - Propagate coordinate to PManipulator as it is
 *    - Convert in PManipulator or it's subclasses
 */

public class SelectHandler extends Handler {

	private static final int
		SM_NONE = 0,
		SM_SELECT_AREA = 1,
		SM_INDIVIDUAL = 2,
		SM_ADDITIONAL = 3,
		SM_GROUPING = 4;

	private boolean dragged;
	private boolean doubleClicked;
	private int mode;
	private Point f1, f2; // for selection (zoom, no grid)
	private Point g1, g2; // for moving selected views (zoom, grid)
	private Rect boundingBox;
	private SelectHandlerListener listener;
	private View view;

	protected Manipulator manipulator;
	protected ManipulatorBinder manipulatorBinder;
	protected ManipulatableNotifier manipulatableNotifier;
	protected ContainmentHandlingProxy containmentHandlingProxy; 
	
	private ScrolledComposite rightComposite;
	private DiagramControlSWT editor;
	
	public SelectHandler() {
		mode = SM_NONE;
		f1 = new Point(0, 0);
		f2 = new Point(0, 0);
		g1 = new Point(0, 0);
		g2 = new Point(0, 0);
		manipulatorBinder = new ManipulatorBinder(this);
		manipulatableNotifier = new ManipulatableNotifier();
		containmentHandlingProxy = new ContainmentHandlingProxy();
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
	
	private void drawRubberband(DiagramControl diagramControl, Canvas canvas, int x1, int y1, int x2, int y2) {
		diagramControl.drawRubberband(x1, y1, x2, y2);
		// Toolkit.drawRange(canvas, x1, y1, x2, y2);		
	}
	
	private void eraseRubberband(DiagramControl diagramControl, Canvas canvas, int x1, int y1, int x2, int y2) {
		diagramControl.eraseRubberband(x1, y1, x2, y2);
		// Toolkit.drawRange(canvas, x1, y1, x2, y2);		
	}
	
	public void mousePressed(DiagramControl diagramControl, Canvas canvas, MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		Point z = new Point(x, y); // point to be applied zoom only.
		Coord.coordRevTransform(canvas.getZoomFactor(), GridFactor.NO_GRID, z);
		Point b = new Point(x, y); // point to be applied zoom and grid.
		Coord.coordRevTransform(canvas.getZoomFactor(), canvas.getGridFactor(), b);
		f1.setPoint(z);
		f2.setPoint(z);
		g1.setPoint(b);
		g2.setPoint(b);
		
		dragged = false;
		doubleClicked = false;
		
		if ((diagramControl.getDiagramView().getSelectedViews().size() == 1) && 
				(isPointInSelectionLine(canvas, diagramControl.getDiagramView().getSelectedViews().firstElement(), x, y))){
			view = diagramControl.getDiagramView().getSelectedViews().firstElement();
		}else{
			view = diagramControl.getDiagramView().getViewAt(canvas, z.getX(), z.getY());
		}
		
		if (e.getButton() == MouseEvent.BUTTON1) { // left button
			if (view == null) {
				mode = SM_SELECT_AREA; 
				// draw first rubber band
				drawRubberband(diagramControl, canvas, f1.getX(), f1.getY(), f2.getX(), f2.getY());
			} else {
				// view selection/deselection
				if (e.isShiftDown()) { // shift + mouse left button pressed
					if (view.isSelected())
						deselectView(view);
					else
						selectAdditionalView(view);
				} else { // only mouse left button pressed
					if (!view.isSelected()) selectView(view);
				}
				// selected views modifying mode
				if ((diagramControl.getDiagramView().getSelectedViews().size() > 0) && e.isShiftDown()) {
					mode = SM_ADDITIONAL;					
				} else if (diagramControl.getDiagramView().getSelectedViews().size() == 1) {
					// one view selected
					mode = SM_INDIVIDUAL;
					if (e.getCount() == 2)
						doubleClicked = true;
					manipulator = manipulatorBinder.bind(view);
					if (manipulator != null)
						manipulator.mousePressed(diagramControl, canvas, view, e);
					// TODO NodeView (662 line of Handlers.pas)
				} else if (diagramControl.getDiagramView().getSelectedViews().size() > 1) {
					mode = SM_GROUPING;
					boundingBox = diagramControl.getDiagramView().getSelectedBoundingBox(canvas);
					//Coord.drawRange(canvas, boundingBox.getX1(), boundingBox.getY1(), 
					//		boundingBox.getX2(), boundingBox.getY2());
					// TODO Container  (671 line of Handlers.pas)
				} else {
					mode = SM_NONE;
				}
			}
		} else if (e.getButton() == MouseEvent.BUTTON3) { // right button
			if (view == null) {
				diagramControl.getDiagramView().deselectAll();
				selectArea(f1.getX(), f1.getY(), f2.getX(), f2.getY());
			} else if (!view.isSelected()) {
				selectView(view);
			}
			mode = SM_NONE;
			// Create pop-up menu
			SWTCompositeUtil.canvasPop(editor,rightComposite,diagramControl, canvas, view, e);
		}
	}
	
	public void mouseDragged(DiagramControl diagramControl, Canvas canvas, MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		Point z = new Point(x, y); // point to be applied zoom only.
		Coord.coordRevTransform(canvas.getZoomFactor(), GridFactor.NO_GRID, z);
		Point b = new Point(x, y); // point to be applied zoom and grid.
		Coord.coordRevTransform(canvas.getZoomFactor(), canvas.getGridFactor(), b);
		
		if (mode == SM_SELECT_AREA) {
			// erase old rubber band
			eraseRubberband(diagramControl, canvas, f1.getX(), f1.getY(), f2.getX(), f2.getY());
			f2.setPoint(z);
			// correct selection area not to stray from canvas
			if (f2.getX() < 0) f2.setX(0);
			if (f2.getX() > diagramControl.getDiagramWidth()) 
				f2.setX(diagramControl.getDiagramWidth());
			if (f2.getY() < 0) f2.setY(0);
			if (f2.getY() > diagramControl.getDiagramHeight()) 
				f2.setX(diagramControl.getDiagramHeight());
			// draw new rubber band
			drawRubberband(diagramControl, canvas, f1.getX(), f1.getY(), f2.getX(), f2.getY());
			// TODO Scrolled 처리.
		} else {
			if (mode == SM_GROUPING) {
				// multiple views selected mode
				// TODO containment 占�占쏙옙 泥섎━ (739 line of Handlers.pas)
				int dx = b.getX() - g2.getX();
				int dy = b.getY() - g2.getY();
				g2.setPoint(b);
				if (dragged) {
					// erase old rubber band
					eraseRubberband(diagramControl, canvas, boundingBox.getX1(), boundingBox.getY1(), 
							boundingBox.getX2(), boundingBox.getY2());
				} else {
					dragged = true;
				}
				boundingBox.setX1(boundingBox.getX1() + dx);
				boundingBox.setY1(boundingBox.getY1() + dy);
				boundingBox.setX2(boundingBox.getX2() + dx);
				boundingBox.setY2(boundingBox.getY2() + dy);
				// correct bounding box not to stray from canvas
				if (boundingBox.getX1() < 0) {
					g2.setX(b.getX() - boundingBox.getX1());
					boundingBox.setX2(boundingBox.getX2() - boundingBox.getX1());
					boundingBox.setX1(0);
				}
				if (boundingBox.getX2() > diagramControl.getDiagramWidth()) {
					g2.setX(b.getX() - (boundingBox.getX2() - diagramControl.getDiagramWidth()));
					boundingBox.setX1(diagramControl.getDiagramWidth() - (boundingBox.getX2() - boundingBox.getX1()));
					boundingBox.setX2(diagramControl.getDiagramWidth());
				}
				if (boundingBox.getY1() < 0) {
					g2.setY(b.getY() - boundingBox.getY1());
					boundingBox.setY2(boundingBox.getY2() - boundingBox.getY1());
					boundingBox.setY1(0);
				}
				if (boundingBox.getY2() > diagramControl.getDiagramHeight()) {
					g2.setY(b.getY() - (boundingBox.getY2() - diagramControl.getDiagramHeight()));
					boundingBox.setY1(diagramControl.getDiagramHeight() - (boundingBox.getY2() - boundingBox.getY1()));
					boundingBox.setY2(diagramControl.getDiagramHeight());
				}
				// draw new rubber band
				drawRubberband(diagramControl, canvas, boundingBox.getX1(), boundingBox.getY1(), 
						boundingBox.getX2(), boundingBox.getY2());
				// TODO Scrolled 처리 (789 line of Handlers.pas)
			} else if (mode == SM_INDIVIDUAL) {
				// single view selected mode
				if (manipulator != null)
					manipulator.mouseDragged(diagramControl, canvas, view, e);
				// TODO NodeView 처리 (801 line of Handlers.pas)
			}
		}
	}
	
	public void mouseReleased(DiagramControl diagramControl, Canvas canvas, MouseEvent e) {
		if (mode == SM_SELECT_AREA) {
			//erase last rubber band
			eraseRubberband(diagramControl, canvas, f1.getX(), f1.getY(), f2.getX(), f2.getY());
			selectArea(f1.getX(), f1.getY(), f2.getX(), f2.getY());
		} else if (mode == SM_GROUPING) {
			if (dragged) {
				//erase last rubber band
				eraseRubberband(diagramControl, canvas, boundingBox.getX1(), boundingBox.getY1(), 
						boundingBox.getX2(), boundingBox.getY2());
			} else if (!e.isShiftDown()) {
				selectView(view);
			}
			// TODO ContainmentHandlingProxy 처리.
			// selected views moved
			if ((g2.getX() != g1.getX()) || (g2.getY() != g1.getY())) {
				// TODO ContainmentHandlingProxy 처리.
				moveSelectedViews(g2.getX() - g1.getX(), g2.getY() - g1.getY());
			}
			// TODO ContainmentHandlingProxy 처리.
		} else if (mode == SM_INDIVIDUAL) {
			// TODO NodeView 처리 (851 line of Handlers.pas)
			if (manipulator != null)
				manipulator.mouseReleased(diagramControl, canvas, view, e);
			// TODO ContainmentHandlingProxy 처리.
			if (doubleClicked) {
				viewDoubleClicked(diagramControl, canvas, view, e);
			}
			doubleClicked = false;
		}
		mode = SM_NONE;
	}

	public void mouseMoved(DiagramControl diagramControl, Canvas canvas, MouseEvent e) {
		manipulatableNotifier.mouseMoved(diagramControl, canvas, e);
	}

	public SelectHandlerListener getSelectHandlerListener() {
		return listener; 
	}
	
	public void setSelectHandlerListener(SelectHandlerListener listener) {
		this.listener = listener;
	}
	
	// event propagation functions --------------------------------------------

	// view selection events
	public void selectView(View view) {
		if (listener != null)
			listener.selectView(view);
	}
	
	public void deselectView(View view) {
		if (listener != null)
			listener.deselectView(view);
	}
	
	public void selectAdditionalView(View view) {
		if (listener != null)
			listener.selectAdditionalView(view);
	}
	
	public void selectArea(int x1, int y1, int x2, int y2) {
		if (listener != null)
			listener.selectArea(x1, y1, x2, y2);
	}
	
	public void viewDoubleClicked(DiagramControl diagramControl, Canvas canvas, View view, MouseEvent e) {
		if (listener != null)
			listener.viewDoubleClicked(diagramControl,canvas,view,e);
	}
	
	// view modification events
	public void moveView(View view, int dx, int dy) {
		if (listener != null)
			listener.moveView(view, dx, dy);
	}
	
	public void changeViewContainer(View view, int dx, int dy, View containerView) {
		if (listener != null)
			listener.changeViewContainer(view, dx, dy, containerView);
	
	}
	
	public void moveSelectedViews(int dx, int dy) {
		if (listener != null)
			listener.moveSelectedViews(dx, dy);
		
	}
	
	public void changeSelectedViewsContainer(int dx, int dy, View containerView) {
		if (listener != null)
			listener.changeSelectedViewsContainer(dx, dy, containerView);
	}	
	
	public void resizeNode(NodeView node, int left, int top, int right, int bottom) {
		if (listener != null)
			listener.resizeNode(node, left, top, right, bottom);
	}
	
	public void modifyEdge(EdgeView edge, Points points) {
		if (listener != null)
			listener.modifyEdge(edge, points);
	}
	
	public void reconnectEdge(EdgeView edge, Points points, View newParticipant, boolean isTailSide) {
		if (listener != null)
			listener.reconnectEdge(edge, points, newParticipant, isTailSide);
	}

	public void keyPressed(DiagramControl diagramControl, Canvas canvas,
			KeyEvent e) {
		try{
		Vector<View> selectedViews = diagramControl.getDiagramView().getSelectedViews();
		if(selectedViews.size() != 0){
			switch(e.keyCode){
				case 127://delete
					diagramControl.getDiagramView().removeOwnedView(selectedViews.get(0));
				break;
			}
			diagramControl.repaint();
		}
		}catch(Exception ee){
			ee.printStackTrace();
		}
	}
	
	public void setRightComposite(ScrolledComposite rightComposite){
		this.rightComposite = rightComposite;
	}

	public void setDiagramControlSWT(DiagramControlSWT editor){
		this.editor = editor;
	}
}
