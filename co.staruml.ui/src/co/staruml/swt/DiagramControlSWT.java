package co.staruml.swt;

import java.util.HashMap;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;

import co.staruml.core.Cursor;
import co.staruml.core.DiagramControl;
import co.staruml.core.DiagramView;
import co.staruml.core.EdgeView;
import co.staruml.graphics.*;
import co.staruml.handler.Handler;
import co.staruml.handler.MouseEvent;


public class DiagramControlSWT extends org.eclipse.swt.widgets.Canvas implements 
		DiagramControl, PaintListener, MouseListener, MouseMoveListener , KeyListener{

	private Handler handler;
	private CanvasSWT canvas;
	private DiagramView diagramView;
	private org.eclipse.swt.graphics.Color backgroundColor;
	private boolean showGrid;
	
	private Image imageBuffer = null;
	private GC imageBufferGC = null;
	private GC perm_gc;
	private Image backgroundImage = null;
	public HashMap<String,Handler> handerMap;

	// ------------------------------------------------------------------------
	
	private static final org.eclipse.swt.graphics.Cursor 
			toSWTCursor(Device device, Cursor cursor) {
		int type = 0;
		switch (cursor.getType()) {
		case Cursor.DEFAULT: type = SWT.CURSOR_ARROW; break;
		case Cursor.CROSSHAIR: type = SWT.CURSOR_CROSS; break; 
		case Cursor.TEXT: type = SWT.CURSOR_IBEAM; break;
		case Cursor.WAIT: type = SWT.CURSOR_WAIT; break;
		case Cursor.SW_RESIZE: type = SWT.CURSOR_SIZESW; break;
		case Cursor.SE_RESIZE: type = SWT.CURSOR_SIZESE; break;
		case Cursor.NW_RESIZE: type = SWT.CURSOR_SIZENW; break;
		case Cursor.NE_RESIZE: type = SWT.CURSOR_SIZENE; break;
		case Cursor.N_RESIZE: type = SWT.CURSOR_SIZEN; break;
		case Cursor.S_RESIZE: type = SWT.CURSOR_SIZES; break;
		case Cursor.W_RESIZE: type = SWT.CURSOR_SIZEW; break;
		case Cursor.E_RESIZE: type = SWT.CURSOR_SIZEE; break;
		case Cursor.HAND: type = SWT.CURSOR_HAND; break;
		case Cursor.MOVE: type = SWT.CURSOR_SIZEALL; break;
		}
		return new org.eclipse.swt.graphics.Cursor(device, type);
	}
	
	private static final MouseEvent toAbstractMouseEvent(
			org.eclipse.swt.events.MouseEvent e) {
		int x = e.x;
		int y = e.y;
		int button = e.button;
		int count = e.count;
		boolean shiftDown = ((e.stateMask & SWT.SHIFT) != 0);
		boolean altDown = ((e.stateMask & SWT.ALT) != 0);
		boolean ctrlDown = ((e.stateMask & SWT.CTRL) != 0);
		return new MouseEvent(x, y, button, count, 
				shiftDown, altDown, ctrlDown);
	}
	
	// ------------------------------------------------------------------------
	
	private void drawBackground(GC gc) {
		if (backgroundImage == null) {
			backgroundImage = new Image(getDisplay(), getDiagramWidth(), getDiagramHeight());
			GC igc = new GC(backgroundImage);
			igc.setBackground(backgroundColor);
			igc.fillRectangle(0, 0, getDiagramWidth(), getDiagramHeight());
			org.eclipse.swt.graphics.Color gridColor = 
				new org.eclipse.swt.graphics.Color(igc.getDevice(), 235, 235, 235);
			igc.setForeground(gridColor);
			GridFactor gf = canvas.getGridFactor();
			int xc = getDiagramWidth() / gf.getWidth();
			int yc = getDiagramHeight() / gf.getHeight();
			for (int i = 0; i < xc; i++)
				for (int j = 0; j < yc; j++)
					igc.drawPoint(i * gf.getWidth(), j * gf.getHeight());
			igc.dispose();
		}
		gc.drawImage(backgroundImage, 0, 0);
	}
	
	private void redrawArea(int x1, int y1, int x2, int y2) {
		Rect r = new Rect(x1, y1, x2, y2);
		Coord.normalizeRect(r);
		x1 = r.getX1();
		y1 = r.getY1();
		x2 = r.getX2();
		y2 = r.getY2();
		if (imageBuffer == null) {
			imageBuffer = new org.eclipse.swt.graphics.Image(getDisplay(), 
					getDiagramWidth(), getDiagramHeight());
			imageBufferGC = new GC(imageBuffer);
		}
		// GC gc = new GC(imageBuffer);
		imageBufferGC.setClipping(x1 - 1, y1 - 1, x2 - x1 + 2, y2 - y1 + 2);
		// gc.setBackground(gc.getDevice().getSystemColor(SWT.COLOR_WHITE));
		// gc.fillRectangle(x1 - 1, y1 - 1, x2 - x1 + 2, y2 - y1 + 2);
		drawBackground(imageBufferGC);
		
		GC gc_backup = canvas.getGC();
		
		canvas.setGC(imageBufferGC);
		diagramView.drawDiagram(canvas);
		imageBufferGC.setClipping(this.getBounds());

		// gc.dispose();
		canvas.setGC(gc_backup);
		
		GC gc2 = canvas.getGC(); // new GC(this);
		gc2.setClipping(x1 - 1, y1 - 1, x2 - x1 + 2, y2 - y1 + 2);
		gc2.drawImage(imageBuffer, 0, 0);
		gc2.setClipping(this.getBounds());
		// gc2.dispose();
	}

	// ------------------------------------------------------------------------

	public DiagramControlSWT(Composite parent, int style,HashMap<String,Handler> handerMap) {
		super(parent, style | SWT.DOUBLE_BUFFERED);
		perm_gc = new GC(this);
		canvas = new CanvasSWT(perm_gc);
		backgroundColor = perm_gc.getDevice().getSystemColor(SWT.COLOR_WHITE);
		// gc.dispose();
		showGrid = true;
		addMouseListener(this);
		addMouseMoveListener(this);
		addPaintListener(this);
		addKeyListener(this);
		this.handerMap = handerMap;
	}

	public Handler getHandler() {
		return handler;
	}
	
	public void setHandler(Handler h) {
		this.handler = h;
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
	
	public void repaint() {
		redraw();
	}
	
	public int getDiagramWidth() {
		org.eclipse.swt.graphics.Point p = this.getSize();
		return p.x;
	}
	
	public int getDiagramHeight() {
		org.eclipse.swt.graphics.Point p = this.getSize();
		return p.y;
	}
	
	public ZoomFactor getZoomFactor() {
		return canvas.getZoomFactor();
	}
	
	public GridFactor getGridFactor() {
		return canvas.getGridFactor();
	}

	public void setCursor(Cursor cursor) {
		this.setCursor(toSWTCursor(getDisplay(), cursor));
	}
	
	public void drawRubberband(int x1, int y1, int x2, int y2) {
		canvas.storeState();
		canvas.setXORMode(true);
		canvas.setColor(Color.BLACK);
		canvas.setFillColor(Color.WHITE);
		canvas.rectangle(x1, y1, x2, y2);
		canvas.restoreState();
	}
	
	public void eraseRubberband(int x1, int y1, int x2, int y2) {
		canvas.storeState();
		canvas.setXORMode(true);
		canvas.setColor(Color.BLACK);
		canvas.setFillColor(Color.WHITE);
		canvas.rectangle(x1, y1, x2, y2);
		canvas.restoreState();
		
		// redrawArea(x1, y1, x2, y2);
	}

	public void drawRubberlines(Points points) {
		canvas.storeState();
		canvas.setColor(Color.LIGHT_GRAY);
		canvas.setLineStyle(Canvas.LS_DOT);
		canvas.polyline(points.toArray());
		canvas.restoreState();
	}
	
	public void eraseRubberlines(Points points) {
		Rect r = points.getBoundingRect();
		redrawArea(r.getX1(), r.getY1(), r.getX2(), r.getY2());
	}
	
	public void paintControl(PaintEvent e) {
		canvas.setGC(e.gc);
		drawBackground(e.gc);
		
		// canvas.setColor(Color.WHITE);
		// canvas.setFillColor(Color.WHITE);
		// canvas.fillRect(0, 0, getDiagramWidth(), getDiagramHeight());
		diagramView.drawDiagram(canvas);
	}

	// ------------------------------------------------------------------------
	
	public void mouseDoubleClick(org.eclipse.swt.events.MouseEvent e) {
	}

	public void mouseDown(org.eclipse.swt.events.MouseEvent e) {
		if (handler != null) {
			GC gc = new GC(this);
			canvas.setGC(gc);
			// canvas.setGC(perm_gc);
			handler.mousePressed(this, canvas, toAbstractMouseEvent(e));
			gc.dispose();
		}
	}

	public void mouseUp(org.eclipse.swt.events.MouseEvent e) {
		if (handler != null) {
			GC gc = new GC(this);
			canvas.setGC(gc);
			handler.mouseReleased(this, canvas, toAbstractMouseEvent(e));
			gc.dispose();
		}
	}

	public void mouseMove(org.eclipse.swt.events.MouseEvent e) {
		if (handler != null) {
			GC gc = new GC(this);
			canvas.setGC(gc);
			// canvas.setGC(perm_gc);
			if ((e.stateMask & SWT.BUTTON1) != 0)
				handler.mouseDragged(this, canvas, toAbstractMouseEvent(e));
			else
				handler.mouseMoved(this, canvas, toAbstractMouseEvent(e));
			gc.dispose();
		}
	}

	public void keyPressed(KeyEvent e) {
		if (handler != null) {
			GC gc = new GC(this);
			canvas.setGC(gc);
			// canvas.setGC(perm_gc);
			handler.keyPressed(this, canvas, e);
			gc.dispose();
		}
	}

	public void keyReleased(KeyEvent e) {
		
	}

}
