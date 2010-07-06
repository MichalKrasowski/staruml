package co.staruml.core;


import co.staruml.graphics.*;
import co.staruml.handler.*;

public interface DiagramControl {

	public Handler getHandler();
	public void setHandler(Handler h);
	public Canvas getCanvas();
	// public void setCanvas(Canvas canvas);
	public DiagramView getDiagramView();
	public void setDiagramView(DiagramView diagramView);
	public void repaint();
	public int getDiagramWidth();
	public int getDiagramHeight();
	public ZoomFactor getZoomFactor();
	public GridFactor getGridFactor();
	public void setSize(int width, int height);
	public void setCursor(Cursor cursor);
	public void drawRubberband(int x1, int y1, int x2, int y2);
	public void eraseRubberband(int x1, int y1, int x2, int y2);
	public void drawRubberlines(Points points);
	public void eraseRubberlines(Points points);
	
}
