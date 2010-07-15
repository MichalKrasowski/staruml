package co.staruml.handler;

import co.staruml.core.DiagramControl;
import co.staruml.core.EdgeView;
import co.staruml.core.View;
import co.staruml.graphics.*;

public abstract class Manipulator {

	protected SelectHandler handler;
	protected boolean dragged;
	protected Point f1, f2;
	
	protected abstract void beginManipulate(DiagramControl diagramControl, Canvas canvas, View view, int x, int y);
	protected abstract void drawSkeleton(DiagramControl diagramControl, Canvas canvas);
	protected abstract void eraseSkeleton(DiagramControl diagramControl, Canvas canvas);
	protected abstract void moveSkeleton(DiagramControl diagramControl, Canvas canvas, View view, Point delta);
	protected abstract void endManipulate(DiagramControl diagramControl, Canvas canvas, View view, int dx, int dy);
	
	public void mousePressed(DiagramControl diagramControl, Canvas canvas, View view, MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		beginManipulate(diagramControl, canvas, view, x, y);
		dragged = false;
		Point z = new Point(x, y);
		Coord.coordRevTransform(canvas.getZoomFactor(), GridFactor.NO_GRID, z);
		f1 = new Point(z); f2 = new Point(z);
	}

	public void mouseReleased(DiagramControl diagramControl, Canvas canvas, View view, MouseEvent e) {
		if (dragged) {
			// erase skeleton
			eraseSkeleton(diagramControl, canvas);
		}
		endManipulate(diagramControl, canvas, view, f2.getX() - f1.getX(), f2.getY() - f1.getY());
	}

	public void mouseDragged(DiagramControl diagramControl, Canvas canvas, View view, MouseEvent e) {
		Point z = new Point(e.getX(), e.getY());
		Coord.coordRevTransform(canvas.getZoomFactor(), GridFactor.NO_GRID, z);
		Point delta = new Point(z.getX() - f2.getX(), z.getY() - f2.getY());
		if (dragged) {
			// erase skeleton
			eraseSkeleton(diagramControl, canvas);
		} else {
			if ((delta.getX() != 0) || (delta.getY() != 0)) dragged = true;
		}
		moveSkeleton(diagramControl, canvas, view, delta);
		f2.setX(f2.getX() + delta.getX());
		f2.setY(f2.getY() + delta.getY());
		if (dragged) {
			// draw skeleton
			drawSkeleton(diagramControl, canvas);
		}
	}

}
