package co.staruml.awt;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import co.staruml.core.Cursor;
import co.staruml.core.DiagramControl;
import co.staruml.core.DiagramView;
import co.staruml.graphics.*;
import co.staruml.handler.Handler;
import co.staruml.handler.MouseEvent;



public class DiagramControlAWT extends Component 
		implements DiagramControl, MouseListener, MouseMotionListener {

	private static final long serialVersionUID = -8428629581765608447L;
	
	private static final MouseEvent toAbstractMouseEvent(
			java.awt.event.MouseEvent e) {
		return new MouseEvent(e.getX(), e.getY(), e.getButton(), e.getClickCount(), 
				e.isShiftDown(), e.isAltDown(), e.isControlDown());
	}
	
	private Handler handler;
	private CanvasAWT canvas;
	private DiagramView diagramView;
	private java.awt.Color backgroundColor;
	private BufferedImage backgroundImage;

	private java.awt.Cursor toAWTCursor(Cursor cursor) {
		return java.awt.Cursor.getPredefinedCursor(cursor.getType());
	}
	
	public DiagramControlAWT(ImageManager imageManager) {
		canvas = new CanvasAWT();
		canvas.setImageManager(imageManager);
		backgroundColor = java.awt.Color.WHITE;
		backgroundImage = null;
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	
	private void drawBackground(Graphics2D g) {
		if (backgroundImage == null) {
			int w = getDiagramWidth();
			int h = getDiagramHeight();
			backgroundImage = new BufferedImage(
					w, h, BufferedImage.TYPE_INT_RGB);
			Graphics2D g2 = (Graphics2D) backgroundImage.getGraphics();
			g2.setColor(backgroundColor);
			g2.fillRect(0, 0, w, h);
			g2.setColor(new java.awt.Color(240, 240, 240));
			GridFactor gf = canvas.getGridFactor();
			int xc = w / (gf.getWidth() * 4) + 1;
			int yc = h / (gf.getHeight() * 4) + 1;
			// solid line
			for (int i = 0; i < xc; i++) {
				int x = i * gf.getWidth() * 4;
				g2.drawLine(x, 0, x, h);
			}
			for (int i = 0; i < yc; i++) {
				int y = i * gf.getHeight() * 4;
				g2.drawLine(0, y, h, y);
			}
			// dot line
			java.awt.BasicStroke stroke =
					new java.awt.BasicStroke(1, java.awt.BasicStroke.CAP_BUTT, 
							java.awt.BasicStroke.JOIN_BEVEL, 0, new float[] {1}, 0);
			g2.setStroke(stroke);
			for (int i = 0; i < xc; i++) {
				int x = (i * gf.getWidth() * 4) + (gf.getWidth() * 2);
				g2.drawLine(x, 0, x, h);
			}
			for (int i = 0; i < yc; i++) {
				int y = (i * gf.getHeight() * 4) + (gf.getWidth() * 2);
				g2.drawLine(0, y, h, y);
			}
		}
		g.drawImage(backgroundImage, 0, 0, null);
	}

	public void paint(Graphics g) {
		
		// TEST CODE
		canvas.setGraphics((Graphics2D) g);
		// canvas.setAntialias(Canvas.AS_ON);
		
		drawBackground((Graphics2D) g);
		
		
		// Dimension d = getSize();
		// canvas.setColor(Color.WHITE);
		// canvas.setFillColor(Color.WHITE);
		// canvas.fillRect(0, 0, d.width, d.height);
		// g.clearRect(0, 0, d.width, d.height);
		
		diagramView.drawDiagram(canvas);
		
		// TEST CODE
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler h) {
		handler = h;
	}
	
	public Canvas getCanvas() {
		return canvas;
	}
	
	public DiagramView getDiagramView() {
		return diagramView;
	}
	
	public void setDiagramView(DiagramView diagramView) {
		this.diagramView = diagramView;
	}
	
	public int getDiagramWidth() {
		return getWidth();
	}
	
	public int getDiagramHeight() {
		return getHeight();
	}
	
	public ZoomFactor getZoomFactor() {
		return canvas.getZoomFactor();
	}
	
	public GridFactor getGridFactor() {
		return canvas.getGridFactor();
	}

	public void setCursor(Cursor cursor) {
		setCursor(toAWTCursor(cursor));
	}
	
	public void drawRubberband(int x1, int y1, int x2, int y2) {
		Toolkit.drawRange(canvas, x1, y1, x2, y2);
	}
	
	public void eraseRubberband(int x1, int y1, int x2, int y2) {
		Toolkit.drawRange(canvas, x1, y1, x2, y2);
	}
	
	public void drawRubberlines(Points points) {
		Toolkit.drawDottedLine(canvas, points);
	}
	
	public void eraseRubberlines(Points points) {
		Toolkit.drawDottedLine(canvas, points);
	}
	
	public void mouseClicked(java.awt.event.MouseEvent e) {
	}

	public void mouseEntered(java.awt.event.MouseEvent e) {
	}

	public void mouseExited(java.awt.event.MouseEvent e) {
	}

	public void mousePressed(java.awt.event.MouseEvent e) {
		if (handler != null) {
			((CanvasAWT) canvas).setGraphics((Graphics2D) getGraphics());
			handler.mousePressed(this, canvas, toAbstractMouseEvent(e));
		}
	}

	public void mouseReleased(java.awt.event.MouseEvent e) {
		if (handler != null)
			handler.mouseReleased(this, canvas, toAbstractMouseEvent(e));
	}

	public void mouseDragged(java.awt.event.MouseEvent e) {
		if (handler != null) {
			((CanvasAWT) canvas).setGraphics((Graphics2D) getGraphics());
			handler.mouseDragged(this, canvas, toAbstractMouseEvent(e));
		}
	}

	public void mouseMoved(java.awt.event.MouseEvent e) {
		if (handler != null)
			handler.mouseMoved(this, canvas, toAbstractMouseEvent(e));
	}

}
