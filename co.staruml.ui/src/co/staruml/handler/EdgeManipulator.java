package co.staruml.handler;

import co.staruml.core.Const;
import co.staruml.core.Cursor;
import co.staruml.core.DiagramControl;
import co.staruml.core.EdgeView;
import co.staruml.core.View;
import co.staruml.graphics.*;

public class EdgeManipulator extends Manipulator {
	
	private static final int
			SL_TAIL = 0,
			SL_HEAD = 1,
			SL_LINE = 2;
	
	private Points points;
	private Points originPoints;
	private int style;
	private int selectedIndex;
	private int edgeSelectLocation;
	
	public EdgeManipulator(Handler handler) {
		this.handler = (SelectHandler)handler;
		points = new Points();
		originPoints = new Points();
	}

	protected void beginManipulate(DiagramControl diagramControl, Canvas canvas, View view, int x, int y) {
		Point z = new Point(x, y);
		Coord.coordRevTransform(canvas.getZoomFactor(), GridFactor.NO_GRID, z);
		EdgeView l = (EdgeView) view;
		points.assign(l.getPoints());
		style = l.getLineStyle();
		if (style == Const.LS_RECTILINEAR) {
		    // select point or line
			selectedIndex = l.selectedPoint(canvas, z);
		    // decide location-kind of selected point
			if (selectedIndex == 0) {
				edgeSelectLocation = SL_TAIL;
			} else if (selectedIndex == (points.count() - 1)) {
				edgeSelectLocation = SL_HEAD;
			} else {
				edgeSelectLocation = SL_LINE;
				if (selectedIndex == -1)
					selectedIndex = l.containedIndex(canvas, z);
			}
		} else {
		    // select point or line or add point
			selectedIndex = l.selectedPoint(canvas, z);
			if (selectedIndex != 0)
				points.setPoint(0, Coord.getCenter(l.getTail().getBoundingBox(canvas)));
			if (selectedIndex != (points.count() - 1))
				points.setPoint(points.count() - 1, Coord.getCenter(l.getHead().getBoundingBox(canvas)));
			if (selectedIndex == -1) {
				selectedIndex = l.containedIndex(canvas, z);
				selectedIndex++;
				points.insert(selectedIndex, z);
			}
		    // decide location-kind of selected point
			if (selectedIndex == 0) {
				edgeSelectLocation = SL_TAIL;
			} else if (selectedIndex == (points.count() - 1)) {
				edgeSelectLocation = SL_HEAD;
			} else {
				edgeSelectLocation = SL_LINE;
			}
			// set cursor
			if (edgeSelectLocation == SL_LINE)
				diagramControl.setCursor(Cursor.PREDEFINED_DEFAULT);
			else
				diagramControl.setCursor(Cursor.PREDEFINED_HAND);
		}
		originPoints.assign(points);
	}

	protected void endManipulate(DiagramControl diagramControl, Canvas canvas, View view, int dx, int dy) {
		if ((dx != 0) || (dy != 0)) {
			if (style == Const.LS_RECTILINEAR)
				points.reduceOrthoLine();
			else
				points.reduceLine();
			if (handler != null) {
				if (edgeSelectLocation == SL_LINE) {
					handler.modifyEdge((EdgeView) view, points);
				} else {
					View v = diagramControl.getDiagramView().getBottomViewAt(canvas,
							points.getPoint(selectedIndex).getX(),
							points.getPoint(selectedIndex).getY());
					View oldPart;
					if (edgeSelectLocation == SL_TAIL){
						oldPart = ((EdgeView) view).getTail();
					}else{
						oldPart = ((EdgeView) view).getHead();
					}
					if (v != null) {
						if (v == oldPart)
							handler.modifyEdge((EdgeView) view, points);
						else
							handler.reconnectEdge((EdgeView) view, points, v, edgeSelectLocation == SL_TAIL);
					}
				}
			}
		}
		diagramControl.setCursor(Cursor.PREDEFINED_DEFAULT);
	}
	
	private int gridFitX(Canvas canvas, int x) {
		return x - (x % canvas.getGridFactor().getWidth());
	}
	
	private int gridFitY(Canvas canvas, int y) {
		return y - (y % canvas.getGridFactor().getHeight());
	}
	
	private void putPointBoundsOnCanvas(DiagramControl diagramControl, Point p) {
		if (p.getX() < 0)
			p.setX(0);
		else if (p.getX() > diagramControl.getDiagramWidth())
			p.setX(diagramControl.getDiagramWidth());
		if (p.getY() < 0)
			p.setY(0);
		else if (p.getY() > diagramControl.getDiagramHeight())
			p.setY(diagramControl.getDiagramHeight());
	}

	protected void moveSkeleton(DiagramControl diagramControl, Canvas canvas, View view, Point delta) {
		Point p, p1, p2;
		Point op, op1, op2;

		if (style == Const.LS_RECTILINEAR) {
			// Get points at end of the selected line
			p1 = new Point(points.getPoint(selectedIndex));
			if (edgeSelectLocation == SL_HEAD)
				p2 = new Point(points.getPoint(selectedIndex - 1));
			else
				p2 = new Point(points.getPoint(selectedIndex + 1));
			op1 = new Point(originPoints.getPoint(selectedIndex));
			if (edgeSelectLocation == SL_HEAD)
				op2 = new Point(originPoints.getPoint(selectedIndex - 1));
			else
				op2 = new Point(originPoints.getPoint(selectedIndex + 1));
			// if move front-end or rear-end point
			if ((edgeSelectLocation == SL_TAIL) || (edgeSelectLocation == SL_HEAD)) {
				if ((p1.getX() + delta.getX() >= op1.getX()) && 
						(p1.getX() + delta.getX() <= gridFitX(canvas, op1.getX()) + canvas.getGridFactor().getWidth())) {
					delta.setX(op1.getX() - p1.getX());
					p1.setX(op1.getX());
				} else {
					delta.setX(delta.getX() - ((p1.getX() + delta.getX()) - gridFitX(canvas, p1.getX() + delta.getX())));
					p1.setX(gridFitX(canvas, p1.getX() + delta.getX()));
				}
				if ((p1.getY() + delta.getY() >= op1.getY()) && 
						(p1.getY() + delta.getY() <= gridFitY(canvas, op1.getY()) + canvas.getGridFactor().getHeight())) {
					delta.setY(op1.getY() - p1.getY());
					p1.setY(op1.getY());
				} else {
					delta.setY(delta.getY() - ((p1.getY() + delta.getY()) - gridFitY(canvas, p1.getY() + delta.getY())));
					p1.setY(gridFitY(canvas, p1.getY() + delta.getY()));
				}
				
				if (op1.getX() == op2.getX())
					p2.setX(p1.getX());
				if (op1.getY() == op2.getY())
					p2.setY(p1.getY());
			} else {	// if move line
				if (p1.getX() == p2.getX()) {
					// if vertical line selected, move skeleton
					if ((p1.getX() + delta.getX() >= op1.getX()) && 
							(p1.getX() + delta.getX() <= gridFitX(canvas, op1.getX()) + canvas.getGridFactor().getWidth())) {
						delta.setX(op1.getX() - p1.getX());
						p1.setX(op1.getX());
					} else {
						delta.setX(delta.getX() - ((p1.getX() + delta.getX()) - gridFitX(canvas, p1.getX() + delta.getX())));
						p1.setX(gridFitX(canvas, p1.getX() + delta.getX()));
					}
					p2.setX(p1.getX());
				} else if (p1.getY() == p2.getY()) {
				      // if horizontal line selected, move skeleton
					if ((p1.getY() + delta.getY() >= op1.getY()) && 
							(p1.getY() + delta.getY() <= gridFitY(canvas, op1.getY()) + canvas.getGridFactor().getHeight())) {
						delta.setY(op1.getY() - p1.getY());
						p1.setY(op1.getY());
					} else {
						delta.setY(delta.getY() - ((p1.getY() + delta.getY()) - gridFitY(canvas, p1.getY() + delta.getY())));
						p1.setY(gridFitY(canvas, p1.getY() + delta.getY()));
					}
					p2.setY(p1.getY());
				}
			}
			if (((edgeSelectLocation == SL_LINE) && (selectedIndex == 0)) || 
					((edgeSelectLocation == SL_HEAD) && (points.count() == 2))) {
				points.insert(0, new Point(points.getPoint(0)));
				originPoints.insert(0, new Point(points.getPoint(0)));
				selectedIndex++;
			} else if (((edgeSelectLocation == SL_LINE) && (selectedIndex == (points.count() - 2))) || 
						((edgeSelectLocation == SL_TAIL) && (points.count() == 2))) {
				points.insert(selectedIndex + 1, new Point(points.getPoint(selectedIndex + 1)));
				originPoints.insert(selectedIndex + 1, new Point(points.getPoint(selectedIndex + 1)));
			}
			
			// Modify points not to stray from Canvas
			putPointBoundsOnCanvas(diagramControl, p1);
			putPointBoundsOnCanvas(diagramControl, p2);
			
			// Re-assign selected points to modified.
			points.getPoint(selectedIndex).setPoint(p1);
			if (edgeSelectLocation == SL_HEAD)
				points.getPoint(selectedIndex - 1).setPoint(p2);
			else
				points.getPoint(selectedIndex + 1).setPoint(p2);
		} else {
			// Get selected point
			p = new Point(points.getPoint(selectedIndex));
			op = new Point(originPoints.getPoint(selectedIndex));
		    // Move skeleton
			if ((p.getX() + delta.getX() >= op.getX()) && 
					(p.getX() + delta.getX() <= gridFitX(canvas, op.getX()) + canvas.getGridFactor().getWidth())) {
				delta.setX(op.getX() - p.getX());
				p.setX(op.getX());
			} else {
				delta.setX(delta.getX() - ((p.getX() + delta.getX()) - gridFitX(canvas, p.getX() + delta.getX())));
				p.setX(gridFitX(canvas, p.getX() + delta.getX()));
			}
			if ((p.getY() + delta.getY() >= op.getY()) && 
					(p.getY() + delta.getY() <= gridFitY(canvas, op.getY()) + canvas.getGridFactor().getHeight())) {
				delta.setY(op.getY() - p.getY());
				p.setY(op.getY());
			} else {
				delta.setY(delta.getY() - ((p.getY() + delta.getY()) - gridFitY(canvas, p.getY() + delta.getY())));
				p.setY(gridFitY(canvas, p.getY() + delta.getY()));
			}
			// Modify point not to stray from Canvas
			putPointBoundsOnCanvas(diagramControl, p);
			// Re-assign selected point to modified.
			points.setPoint(selectedIndex, p);
		}
	}

	protected void drawSkeleton(DiagramControl diagramControl, Canvas canvas) {
		// Toolkit.drawDottedLine(canvas, points);
		diagramControl.drawRubberlines(points);
	}

	protected void eraseSkeleton(DiagramControl diagramControl, Canvas canvas) {
		// Toolkit.drawDottedLine(canvas, points);
		diagramControl.eraseRubberlines(points);
	}

}
