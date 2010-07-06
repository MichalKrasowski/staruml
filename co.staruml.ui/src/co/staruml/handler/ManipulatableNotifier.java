package co.staruml.handler;

import co.staruml.core.Const;
import co.staruml.core.Cursor;
import co.staruml.core.DiagramControl;
import co.staruml.core.EdgeView;
import co.staruml.core.NodeView;
import co.staruml.core.View;
import co.staruml.graphics.*;

public class ManipulatableNotifier {
	public void mouseMoved(DiagramControl diagramControl, Canvas canvas, MouseEvent e) {
		if (diagramControl.getDiagramView().getSelectedViews().size() != 1) {
			diagramControl.setCursor(Cursor.PREDEFINED_DEFAULT);
			return;
		}
		Point z = new Point(e.getX(), e.getY());
		Coord.coordTransform(canvas.getZoomFactor(), GridFactor.NO_GRID, z);
		View v = diagramControl.getDiagramView().getSelectedViews().firstElement();
		Point p = new Point(e.getX(), e.getY());
		if (v instanceof NodeView) {
			NodeView nv = (NodeView) v;
			Rect zr = v.getBoundingBox(canvas);
			Coord.coordTransform(canvas.getZoomFactor(), GridFactor.NO_GRID, zr);
			int middleX = (zr.getX1() + zr.getX2()) / 2;
			int middleY = (zr.getY1() + zr.getY2()) / 2;
			boolean b = true;
			int selectionType = Toolkit.CT_ELSE;
			if ((nv.getSizable() == Const.SZ_NONE) || nv.isAutoResize()) {
				selectionType = Toolkit.CT_ELSE;
				b = false;
			}
			if (b && ((nv.getSizable() == Const.SZ_FREE) || (nv.getSizable() == Const.SZ_RATIO))) {
				if (Coord.equalPt(
						new Point(zr.getX1() - Toolkit.DEFAULT_HALF_HIGHLIGHTER_SIZE, 
								zr.getY1() - Toolkit.DEFAULT_HALF_HIGHLIGHTER_SIZE), 
						p, Toolkit.DEFAULT_HALF_HIGHLIGHTER_SIZE)) {
					selectionType = Toolkit.CT_LT;
					b = false;
				} else if (Coord.equalPt(
						new Point(zr.getX2() + Toolkit.DEFAULT_HALF_HIGHLIGHTER_SIZE, 
								zr.getY1() - Toolkit.DEFAULT_HALF_HIGHLIGHTER_SIZE), 
						p, Toolkit.DEFAULT_HALF_HIGHLIGHTER_SIZE)) {
					selectionType = Toolkit.CT_RT;
					b = false;
				} else if (Coord.equalPt(
						new Point(zr.getX1() - Toolkit.DEFAULT_HALF_HIGHLIGHTER_SIZE, 
								zr.getY2() + Toolkit.DEFAULT_HALF_HIGHLIGHTER_SIZE), 
						p, Toolkit.DEFAULT_HALF_HIGHLIGHTER_SIZE)) {
					selectionType = Toolkit.CT_LB;
					b = false;
				} else if (Coord.equalPt(
						new Point(zr.getX2() + Toolkit.DEFAULT_HALF_HIGHLIGHTER_SIZE, 
								zr.getY2() + Toolkit.DEFAULT_HALF_HIGHLIGHTER_SIZE), 
						p, Toolkit.DEFAULT_HALF_HIGHLIGHTER_SIZE)) {
					selectionType = Toolkit.CT_RB;
					b = false;
				}
			}
			if (b && ((nv.getSizable() == Const.SZ_FREE) || (nv.getSizable() == Const.SZ_VERT))) {
				if (Coord.equalPt(
						new Point(middleX, zr.getY1() - Toolkit.DEFAULT_HALF_HIGHLIGHTER_SIZE), 
						p, Toolkit.DEFAULT_HALF_HIGHLIGHTER_SIZE)) {
					selectionType = Toolkit.CT_MT;
					b = false;
				} else if (Coord.equalPt(
						new Point(middleX, zr.getY2() + Toolkit.DEFAULT_HALF_HIGHLIGHTER_SIZE), 
						p, Toolkit.DEFAULT_HALF_HIGHLIGHTER_SIZE)) {
					selectionType = Toolkit.CT_MB;
					b = false;
				}
			}
			if (b && ((nv.getSizable() == Const.SZ_FREE) || (nv.getSizable() == Const.SZ_HORZ))) {
				if (Coord.equalPt(
						new Point(zr.getX1() - Toolkit.DEFAULT_HALF_HIGHLIGHTER_SIZE, middleY), 
						p, Toolkit.DEFAULT_HALF_HIGHLIGHTER_SIZE)) {
					selectionType = Toolkit.CT_LM;
					b = false;
				} else if (Coord.equalPt(
						new Point(zr.getX2() + Toolkit.DEFAULT_HALF_HIGHLIGHTER_SIZE, middleY), 
						p, Toolkit.DEFAULT_HALF_HIGHLIGHTER_SIZE)) {
					selectionType = Toolkit.CT_RM;
					b = false;
				}
			}
			
			if (b && (Coord.ptInRect(p, new Rect(
					zr.getX1() - Toolkit.DEFAULT_SELECTIONLINE_WIDTH, 
					zr.getY1() - Toolkit.DEFAULT_SELECTIONLINE_WIDTH, 
					zr.getX2() + Toolkit.DEFAULT_SELECTIONLINE_WIDTH, 
					zr.getY2() + Toolkit.DEFAULT_SELECTIONLINE_WIDTH)))) {
				selectionType = Toolkit.CT_AREA;
				b = false;
			}
			
			if (b) selectionType = Toolkit.CT_ELSE;
			// set cursor type
			switch (selectionType) {
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
		} else if (v instanceof EdgeView) {
			// TODO EdgeView??경우 구현...
		}
		
	}
}
