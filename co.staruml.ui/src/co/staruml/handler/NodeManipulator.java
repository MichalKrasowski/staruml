package co.staruml.handler;

import co.staruml.core.Const;
import co.staruml.core.Cursor;
import co.staruml.core.DiagramControl;
import co.staruml.core.NodeView;
import co.staruml.core.View;
import co.staruml.graphics.*;

public class NodeManipulator extends Manipulator {

	private int minX, minY;
	private int movable;
	private int sizable;
	private int left, top, right, bottom;
	private Rect minRect, originRect;
	private double ratio;
	private int selectedPtType;
	
	public NodeManipulator(Handler handler) {
		this.handler = (SelectHandler)handler;
	}
	
	private int gridFitX(Canvas canvas, int x) {
		return x - (x % canvas.getGridFactor().getWidth());
	}
	
	private int gridFitY(Canvas canvas, int y) {
		return y - (y % canvas.getGridFactor().getHeight());
	}
	
	private void resizeSkeletonLeft(Canvas canvas, Point delta) {
		if ((left + delta.getX()) >= minRect.getX1()) {
			// if move over the minimum left boundary
			delta.setX(minRect.getX1() - left);
			left = minRect.getX1();
		} else if (((left + delta.getX()) >= originRect.getX1()) 
				&& ((left + delta.getX()) <= (gridFitX(canvas, originRect.getX1()) + canvas.getGridFactor().getWidth()))) {
		    // if move in original left line
			delta.setX(originRect.getX1() - left);
			left = originRect.getX1();
		} else {
			delta.setX(delta.getX() - ((left + delta.getX()) - gridFitX(canvas, left + delta.getX())));
			left = gridFitX(canvas, left + delta.getX());
		}
	}
	
	private void resizeSkeletonRight(Canvas canvas, Point delta) {
		if (((right + delta.getX()) <= minRect.getX2()) || 
				(gridFitX(canvas, right + delta.getX()) <= minRect.getX2())) {
		    // if move over the minimum right boundary
			delta.setX(minRect.getX2() - right);
			right = minRect.getX2();
		} else if (((right + delta.getX()) >= originRect.getX2()) && 
				((right + delta.getX()) <= gridFitX(canvas, originRect.getX2()) + canvas.getGridFactor().getWidth())) {
		    // if move in original right line
			delta.setX(originRect.getX2() - right);
			right = originRect.getX2();
		} else {
			delta.setX(delta.getX() - ((right + delta.getX()) - gridFitX(canvas, right + delta.getX())));
			right = gridFitX(canvas, right + delta.getX());
		}
	}
	
	private void resizeSkeletonTop(Canvas canvas, Point delta) {
		if ((top + delta.getY()) >= minRect.getY1()) {
		    // if move over the minimum top boundary
			delta.setY(minRect.getY1() - top);
			top = minRect.getY1();
		} else if ((top + delta.getY() >= originRect.getY1()) && 
				(top + delta.getY() <= gridFitY(canvas, originRect.getY1()) + canvas.getGridFactor().getHeight())) {
		    // if move in original top line
			delta.setY(originRect.getY1() - top);
			top = originRect.getY1();
		} else {
			delta.setY(delta.getY() - ((top + delta.getY()) - gridFitY(canvas, top + delta.getY())));
			top = gridFitY(canvas, top + delta.getY());
		}
	}
	
	private void resizeSkeletonBottom(Canvas canvas, Point delta) {
		if ((bottom + delta.getY() <= minRect.getY2()) ||
				(gridFitY(canvas, bottom + delta.getY()) <= minRect.getY2())) {
			delta.setY(minRect.getY2() - bottom);
			bottom = minRect.getY2();
		} else if ((bottom + delta.getY() >= originRect.getY2()) && 
				(bottom + delta.getY() <= gridFitY(canvas, originRect.getY2()) + canvas.getGridFactor().getHeight())) {
			delta.setY(originRect.getY2() - bottom);
			bottom = originRect.getY2();
		} else {
			delta.setY(delta.getY() - ((bottom + delta.getY()) - gridFitY(canvas, bottom + delta.getY())));
			bottom = gridFitY(canvas, bottom + delta.getY());
		}
	}
	
	private void moveSkeletonHorz(Canvas canvas, Point delta) {
		if (((left + delta.getX()) >= originRect.getX1()) && 
				((left + delta.getX()) <= (gridFitX(canvas, originRect.getX1()) + canvas.getGridFactor().getWidth()))) {
			delta.setX(originRect.getX1() - left);
			left = originRect.getX1();
			right = originRect.getX2();
		} else {
			delta.setX(delta.getX() - ((left + delta.getX()) - gridFitX(canvas, left + delta.getX())));
			left = gridFitX(canvas, left + delta.getX());
			right = left + (originRect.getX2() - originRect.getX1());
		}
	}
	
	private void moveSkeletonVert(Canvas canvas, Point delta) {
		if ((top + delta.getY() >= originRect.getY1()) && 
				(top + delta.getY() <= gridFitY(canvas, originRect.getY1()) + canvas.getGridFactor().getHeight())) {
			delta.setY(originRect.getY1() - top);
			top = originRect.getY1();
			bottom = originRect.getY2();
		} else {
			delta.setY(delta.getY() - ((top + delta.getY()) - gridFitY(canvas, top + delta.getY())));
			top = gridFitY(canvas, top + delta.getY());
			bottom = top + (originRect.getY2() - originRect.getY1());
		}
	}
	
	private void restrictNode(Rect rect) {
		if (selectedPtType == Toolkit.CT_ELSE) {
			if (left < rect.getX1()) {
				right = right + rect.getX1() - left;
				left = rect.getX1();
			} else if (right > rect.getX2()) {
				left = left + rect.getX2() - right;
				right = rect.getX2();
			}
			if (top < rect.getY1()) {
				bottom = bottom + rect.getY1() - top;
				top = rect.getY1();
			} else if (bottom > rect.getY2()) {
				top = top + rect.getY2() - bottom;
				bottom = rect.getY2();
			}
		} else {
			if (left < rect.getX1()) left = rect.getX1();
			if (right > rect.getX2()) right = rect.getX2();
			if (top < rect.getY1()) top = rect.getY1();
			if (bottom > rect.getY2()) bottom = rect.getY2();
		}
	}
	
	protected Rect getPermittedRegion(DiagramControl diagramControl, Canvas canvas, View view) {
		return new Rect(0, 0, diagramControl.getDiagramWidth(), diagramControl.getDiagramHeight());
	}
	
	protected void beginManipulate(DiagramControl diagramControl, Canvas canvas, View view, int x, int y) {
		NodeView nodeView = (NodeView) view;
		minX = nodeView.getMinWidth();
		minY = nodeView.getMinHeight();
		if (nodeView.isAutoResize())
			sizable = Const.SZ_NONE;
		else
			sizable = nodeView.getSizable();
		movable = nodeView.getMovable();
		
		Point z = new Point(x, y);
		Coord.coordTransform(canvas.getZoomFactor(), GridFactor.NO_GRID, z);
		
		Rect r = nodeView.getBoundingBox(canvas);
		originRect = new Rect(r);
		left = r.getX1(); top = r.getY1();
		right = r.getX2(); bottom = r.getY2();
		
		if (sizable == Const.SZ_RATIO)
			ratio = ((double) (r.getX2() - r.getX1())) / (r.getY2() - r.getY1());
		Point p = new Point(x, y);
		Rect zr = new Rect(r);
		Coord.coordTransform(canvas.getZoomFactor(), GridFactor.NO_GRID, zr);
		int middleX = (zr.getX1() + zr.getX2()) / 2;
		int middleY = (zr.getY1() + zr.getY2()) / 2;
		
		selectedPtType = Toolkit.CT_ELSE;
		if ((movable != Const.MM_NONE) && Coord.ptInRect(p, new Rect(
					zr.getX1() - Toolkit.DEFAULT_SELECTIONLINE_WIDTH, 
					zr.getY1() - Toolkit.DEFAULT_SELECTIONLINE_WIDTH, 
					zr.getX2() + Toolkit.DEFAULT_SELECTIONLINE_WIDTH, 
					zr.getY2() + Toolkit.DEFAULT_SELECTIONLINE_WIDTH))) {
			selectedPtType = Toolkit.CT_AREA;
		}
		
		switch (sizable) {
		case Const.SZ_NONE:
			selectedPtType = Toolkit.CT_ELSE;
			break;
		case Const.SZ_FREE:
		case Const.SZ_RATIO:
			if (Coord.equalPt(
					new Point(zr.getX1() - Toolkit.DEFAULT_HALF_HIGHLIGHTER_SIZE, 
							zr.getY1() - Toolkit.DEFAULT_HALF_HIGHLIGHTER_SIZE), 
					p, Toolkit.DEFAULT_HALF_HIGHLIGHTER_SIZE)) {
				selectedPtType = Toolkit.CT_LT;
			} else if (Coord.equalPt(
					new Point(zr.getX2() + Toolkit.DEFAULT_HALF_HIGHLIGHTER_SIZE, 
							zr.getY1() - Toolkit.DEFAULT_HALF_HIGHLIGHTER_SIZE), 
					p, Toolkit.DEFAULT_HALF_HIGHLIGHTER_SIZE)) {
				selectedPtType = Toolkit.CT_RT;
			} else if (Coord.equalPt(
					new Point(zr.getX1() - Toolkit.DEFAULT_HALF_HIGHLIGHTER_SIZE, 
							zr.getY2() + Toolkit.DEFAULT_HALF_HIGHLIGHTER_SIZE), 
					p, Toolkit.DEFAULT_HALF_HIGHLIGHTER_SIZE)) {
				selectedPtType = Toolkit.CT_LB;
			} else if (Coord.equalPt(
					new Point(zr.getX2() + Toolkit.DEFAULT_HALF_HIGHLIGHTER_SIZE, 
							zr.getY2() + Toolkit.DEFAULT_HALF_HIGHLIGHTER_SIZE), 
					p, Toolkit.DEFAULT_HALF_HIGHLIGHTER_SIZE)) {
				selectedPtType = Toolkit.CT_RB;
			} else if (Coord.equalPt(
					new Point(zr.getX1() - Toolkit.DEFAULT_HALF_HIGHLIGHTER_SIZE, middleY), 
					p, Toolkit.DEFAULT_HALF_HIGHLIGHTER_SIZE)) {
				selectedPtType = Toolkit.CT_LM;
			} else if (Coord.equalPt(
					new Point(zr.getX2() + Toolkit.DEFAULT_HALF_HIGHLIGHTER_SIZE, middleY), 
					p, Toolkit.DEFAULT_HALF_HIGHLIGHTER_SIZE)) {
				selectedPtType = Toolkit.CT_RM;
			} else if (Coord.equalPt(
					new Point(middleX, zr.getY1() - Toolkit.DEFAULT_HALF_HIGHLIGHTER_SIZE), 
					p, Toolkit.DEFAULT_HALF_HIGHLIGHTER_SIZE)) {
				selectedPtType = Toolkit.CT_MT;
			} else if (Coord.equalPt(
					new Point(middleX, zr.getY2() + Toolkit.DEFAULT_HALF_HIGHLIGHTER_SIZE), 
					p, Toolkit.DEFAULT_HALF_HIGHLIGHTER_SIZE)) {
				selectedPtType = Toolkit.CT_MB;
			}
			break;
		case Const.SZ_HORZ:
			if (Coord.equalPt(
					new Point(zr.getX1() - Toolkit.DEFAULT_HALF_HIGHLIGHTER_SIZE, middleY), 
					p, Toolkit.DEFAULT_HALF_HIGHLIGHTER_SIZE)) {
				selectedPtType = Toolkit.CT_LM;
			} else if (Coord.equalPt(
					new Point(zr.getX2() + Toolkit.DEFAULT_HALF_HIGHLIGHTER_SIZE, middleY), 
					p, Toolkit.DEFAULT_HALF_HIGHLIGHTER_SIZE)) {
				selectedPtType = Toolkit.CT_RM;
			}
			break;
		case Const.SZ_VERT:
			if (Coord.equalPt(
					new Point(middleX, zr.getY1() - Toolkit.DEFAULT_HALF_HIGHLIGHTER_SIZE), 
					p, Toolkit.DEFAULT_HALF_HIGHLIGHTER_SIZE)) {
				selectedPtType = Toolkit.CT_MT;
			} else if (Coord.equalPt(
					new Point(middleX, zr.getY2() + Toolkit.DEFAULT_HALF_HIGHLIGHTER_SIZE), 
					p, Toolkit.DEFAULT_HALF_HIGHLIGHTER_SIZE)) {
				selectedPtType = Toolkit.CT_MB;
			}
			break;
		}
		switch (selectedPtType) {
		case Toolkit.CT_AREA: break;
		case Toolkit.CT_LT: 
		case Toolkit.CT_MT:
		case Toolkit.CT_LM:
			minRect = new Rect(right - minX + 1, bottom - minY + 1, right, bottom);
			break;
		case Toolkit.CT_RB: 
		case Toolkit.CT_MB: 
		case Toolkit.CT_RM: 
			minRect = new Rect(left, top, left + minX - 1, top + minY - 1);
			break;
		case Toolkit.CT_RT: 
			minRect = new Rect(left, bottom - minY + 1, left + minX - 1, bottom);
			break;
		case Toolkit.CT_LB: 
			minRect = new Rect(right - minX + 1, top, right, top + minY - 1);
			break;
		}
		// set cursor type
		switch (selectedPtType) {
		case Toolkit.CT_LT:
			diagramControl.setCursor(Cursor.PREDEFINED_NW_RESIZE);
			break;
		case Toolkit.CT_RB:
			diagramControl.setCursor(Cursor.PREDEFINED_NW_RESIZE);
			break;
		case Toolkit.CT_RT:
			diagramControl.setCursor(Cursor.PREDEFINED_NE_RESIZE);
			break;
		case Toolkit.CT_LB:
			diagramControl.setCursor(Cursor.PREDEFINED_NE_RESIZE);
			break;
		case Toolkit.CT_MT:
		case Toolkit.CT_MB:
			diagramControl.setCursor(Cursor.PREDEFINED_N_RESIZE);
			break;
		case Toolkit.CT_LM:
		case Toolkit.CT_RM:
			diagramControl.setCursor(Cursor.PREDEFINED_E_RESIZE);
			break;
		case Toolkit.CT_AREA:
			diagramControl.setCursor(Cursor.PREDEFINED_MOVE);
			break;
		case Toolkit.CT_ELSE:
			diagramControl.setCursor(Cursor.PREDEFINED_DEFAULT);
		}
	}

	protected void drawSkeleton(DiagramControl diagramControl, Canvas canvas) {
		if ((movable != Const.MM_NONE) || (sizable != Const.SZ_NONE))
			// Toolkit.drawRange(canvas, left, top, right, bottom);
			diagramControl.drawRubberband(left, top, right, bottom);
	}

	protected void eraseSkeleton(DiagramControl diagramControl, Canvas canvas) {
		if ((movable != Const.MM_NONE) || (sizable != Const.SZ_NONE))
			// Toolkit.drawRange(canvas, left, top, right, bottom);
			diagramControl.eraseRubberband(left, top, right, bottom);
	}
	
	protected void moveSkeleton(DiagramControl diagramControl, Canvas canvas, View view, Point delta) {
		boolean horzSizable = (sizable == Const.SZ_HORZ) || 
				(sizable == Const.SZ_RATIO) || (sizable == Const.SZ_FREE);
		boolean vertSizable = (sizable == Const.SZ_VERT) || 
				(sizable == Const.SZ_RATIO) || (sizable == Const.SZ_FREE);
		switch (selectedPtType) {
		case Toolkit.CT_LT:
			if (horzSizable) resizeSkeletonLeft(canvas, delta);
			if (vertSizable) resizeSkeletonTop(canvas, delta);
			break;
		case Toolkit.CT_RT:
			if (horzSizable) resizeSkeletonRight(canvas, delta);
			if (vertSizable) resizeSkeletonTop(canvas, delta);
			break;
		case Toolkit.CT_LB:
			if (horzSizable) resizeSkeletonLeft(canvas, delta);
			if (vertSizable) resizeSkeletonBottom(canvas, delta);
			break;
		case Toolkit.CT_RB:
			if (horzSizable) resizeSkeletonRight(canvas, delta);
			if (vertSizable) resizeSkeletonBottom(canvas, delta);
			break;
		case Toolkit.CT_LM:
			if (horzSizable) resizeSkeletonLeft(canvas, delta);
			break;
		case Toolkit.CT_RM:
			if (horzSizable) resizeSkeletonRight(canvas, delta);
			break;
		case Toolkit.CT_MT:
			if (vertSizable) resizeSkeletonTop(canvas, delta);
			break;
		case Toolkit.CT_MB:
			if (vertSizable) resizeSkeletonBottom(canvas, delta);
			break;
		case Toolkit.CT_AREA:
		case Toolkit.CT_ELSE:
			switch (movable) {
			case Const.MM_HORZ:
				moveSkeletonHorz(canvas, delta);
				break;
			case Const.MM_VERT:
				moveSkeletonVert(canvas, delta);
				break;
			case Const.MM_FREE:
				moveSkeletonHorz(canvas, delta);
				moveSkeletonVert(canvas, delta);
			}
		}
		restrictNode(getPermittedRegion(diagramControl, canvas, view));
	}

	protected void endManipulate(DiagramControl diagramControl, Canvas canvas, View view, int dx, int dy) {
		if ((movable != Const.MM_NONE) || (sizable != Const.SZ_NONE)) {
			restrictNode(getPermittedRegion(diagramControl, canvas, view));
			if ((selectedPtType == Toolkit.CT_ELSE) || (selectedPtType == Toolkit.CT_AREA)) {
				Rect r = view.getBoundingBox(canvas);
				dx = left - r.getX1();
				dy = top - r.getY1();
				if (handler != null) {
					View c = handler.containmentHandlingProxy.getContainerView();
					if (view.isContainerChangeable() && (view.getContainerView() != c)) {
						switch (movable) {
						case Const.MM_HORZ:
							if (dx != 0) handler.changeViewContainer(view, dx, 0, c); break;
						case Const.MM_VERT:
							if (dy != 0) handler.changeViewContainer(view, 0, dy, c); break;
						case Const.MM_FREE:
							if ((dx != 0) || (dy != 0)) handler.changeViewContainer(view, dx, dy, c);
						}
					} else {
						switch (movable) {
						case Const.MM_HORZ:
							if (dx != 0) handler.moveView(view, dx, 0); break;
						case Const.MM_VERT:
							if (dy != 0) handler.moveView(view, 0, dy); break;
						case Const.MM_FREE:
							if ((dx != 0) || (dy != 0)) handler.moveView(view, dx, dy);
						}
					}
				}
			} else {
				if (handler != null)
					handler.resizeNode((NodeView) view, left, top, right, bottom);
			}
		}
		diagramControl.setCursor(Cursor.PREDEFINED_DEFAULT);
	}

}
