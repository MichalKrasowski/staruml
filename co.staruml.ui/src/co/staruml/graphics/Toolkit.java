package co.staruml.graphics;

public class Toolkit {
	
	// nwse values
	public static final int NWSE_N = 0;
	public static final int NWSE_S = 1;
	public static final int NWSE_W = 2;
	public static final int NWSE_E = 3;

	// corner type values
	public static final int CT_LT = 0;
	public static final int CT_LM = 1;
	public static final int CT_LB = 2;
	public static final int CT_MT = 3;
	public static final int CT_MB = 4;
	public static final int CT_RT = 5;
	public static final int CT_RM = 6;
	public static final int CT_RB = 7;
	public static final int CT_AREA = 8;
	public static final int CT_ELSE = 9;
	
	public static final Color SELECTION_COLOR = Color.BLACK;
	
	public static final int	DEFAULT_HIGHLIGHTER_SIZE = 7;
	public static final int	DEFAULT_HALF_HIGHLIGHTER_SIZE = 3;
	public static final int	DEFAULT_SELECTIONLINE_WIDTH = DEFAULT_HIGHLIGHTER_SIZE - 1;
	
	public static void drawRange(Canvas canvas, int x1, int y1, int x2, int y2) {
		canvas.storeState();
		canvas.setXORMode(true);
		canvas.setColor(Color.DARK_GRAY);
		canvas.setFillColor(Color.WHITE);
		canvas.setLineStyle(Canvas.LS_DOT);
		// canvas.fillRect(x1, y1, x2, y2);
		canvas.rectangle(x1, y1, x2, y2);
		canvas.restoreState();
	}

	public static void drawDottedLine(Canvas canvas, Points points) {
		canvas.storeState();
		// Graphics2D g = canvas.getGraphics();
		// g.setXORMode(g.getBackground());
		canvas.setXORMode(true);
		canvas.setColor(Color.DARK_GRAY);
		// canvas.setFillColor(Color.WHITE);
		// canvas.setLineStyle(Canvas.LS_SOLID);
		// canvas.setLineWidth(1);
		canvas.polyline(points.toArray());
		canvas.restoreState();
	}

	public static void drawSelectionLine(Canvas canvas, int x1, int y1, int x2, int y2, int len, int nwse, boolean retouch) {
		canvas.storeState();
		int ox = canvas.getOrigin().getX();
		int oy = canvas.getOrigin().getY();
		Point r1 = new Point(x1, y1);
		Point r2 = new Point(x2, y2);
		Coord.coordTransform(canvas.getZoomFactor(), GridFactor.NO_GRID, r1);
		Coord.coordTransform(canvas.getZoomFactor(), GridFactor.NO_GRID, r2);
		int rx1 = r1.getX();
		int ry1 = r1.getY();
		int rx2 = r2.getX();
		int ry2 = r2.getY();
		
		if ((retouch) && (((rx1 + ox - len) % 2) == 1))
			rx1 = rx1 + 1;
		if ((retouch) && (((rx2 + ox) % 2) == 1))
			rx2 = rx2 - 1;
		
		Rect r = new Rect();
		switch (nwse) {
		case Toolkit.NWSE_N: r.setRect(rx1 + ox, ry1 + oy - len, rx2 + ox, ry1 + oy); break; 
		case Toolkit.NWSE_W: r.setRect(rx1 + ox - len, ry1 + oy - len, rx1 + ox, ry2 + oy + len); break;
		case Toolkit.NWSE_S: r.setRect(rx1 + ox, ry2 + oy, rx2 + ox, ry2 + oy + len); break;
		case Toolkit.NWSE_E: r.setRect(rx2 + ox, ry1 + oy - len, rx2 + ox + len, ry2 + oy + len); break;
		}
		
		canvas.setAntialias(Canvas.AS_OFF);
		canvas.setCoordTransformApplied(false);
		if (retouch) {
			for (int i = r.getX1(); i <= r.getX2(); i++)
				for (int j = r.getY1(); j <= r.getY2(); j++)
					if ((((i % 4) == 0) && ((j % 2) == 0)) 
							|| (((i % 4) == 2) && ((j % 2) == 1)))
						canvas.putPixel(i, j, Color.DARK_GRAY);
		} else {
			for (int i = r.getX1(); i <= r.getX2(); i++)
				for (int j = r.getY1(); j <= r.getY2(); j++)
					if (((((i - r.getX1()) % 4) == 0) && (((j - r.getY1()) % 2) == 0)) 
							|| ((((i - r.getX1()) % 4) == 2) && (((j - r.getY1()) % 2) == 1)))
						canvas.putPixel(i, j, Color.DARK_GRAY);
		}
		canvas.setCoordTransformApplied(true);
		canvas.restoreState();
	}

	public static void drawHighlighter(Canvas canvas, int x, int y, int size, boolean enabled, Color color) {
		canvas.storeState();
		canvas.setColor(color);
		canvas.setFillColor(color);
		canvas.setLineWidth(1);
		Point p = new Point(x, y);
		Point o = new Point(canvas.getOrigin());
		Coord.coordTransform(canvas.getZoomFactor(), GridFactor.NO_GRID, p);
		/*
		Graphics2D g = canvas.getGraphics();
		g.setColor(canvas.getFillColor());
		g.fillRect(p.getX() + o.getX() - size, p.getY() + o.getY() - size, size * 2, size * 2);
		g.setColor(canvas.getColor());
		g.drawRect(p.getX() + o.getX() - size, p.getY() + o.getY() - size, size * 2, size * 2);
		*/
		canvas.setCoordTransformApplied(false);
		canvas.fillRect(p.getX() + o.getX() - size, p.getY() + o.getY() - size, 
				p.getX() + o.getX() + size, p.getY() + o.getY() + size);
		canvas.setCoordTransformApplied(true);
		canvas.restoreState();
	}

	public static void drawHighlighter2(Canvas canvas, int x1, int y1, int x2, int y2, 
			int width, int cornerType, boolean enabled, Color color) {
		canvas.storeState();
		canvas.setColor(color);
		int ox = canvas.getOrigin().getX();
		int oy = canvas.getOrigin().getY();
		Point p1 = new Point(x1, y1);
		Point p2 = new Point(x2, y2);
		Coord.coordTransform(canvas.getZoomFactor(), GridFactor.NO_GRID, p1);
		Coord.coordTransform(canvas.getZoomFactor(), GridFactor.NO_GRID, p2);
		x1 = p1.getX(); y1 = p1.getY();
		x2 = p2.getX(); y2 = p2.getY();
		Point p = new Point(-100, -100);
		int cx = (x1 + x2) / 2;
		int cy = (y1 + y2) / 2;
		int halfW = width / 2;
		switch (cornerType) {
		case Toolkit.CT_LT: p.setPoint(x1 - width, y1 - width); break;
		case Toolkit.CT_LM: p.setPoint(x1 - width, cy - halfW); break;
		case Toolkit.CT_LB: p.setPoint(x1 - width, y2); break;
		case Toolkit.CT_MT: p.setPoint(cx - halfW, y1 - width); break;
		case Toolkit.CT_MB: p.setPoint(cx - halfW, y2); break;
		case Toolkit.CT_RT: p.setPoint(x2, y1 - width); break;
		case Toolkit.CT_RM: p.setPoint(x2, cy - halfW); break;
		case Toolkit.CT_RB: p.setPoint(x2, y2); break;
		}
		if (enabled)
			canvas.setFillColor(Color.WHITE);
		else
			canvas.setFillColor(new Color(0xD0, 0xD0, 0xD0));
		/*
		Graphics2D g = canvas.getGraphics();
		g.setColor(canvas.getFillColor());
		g.fillRect(p.getX() + ox, p.getY() + oy, width, width);
		g.setColor(canvas.getColor());
		g.drawRect(p.getX() + ox, p.getY() + oy, width, width);
		*/
		canvas.setCoordTransformApplied(false);
		canvas.fillRect(p.getX() + ox, p.getY() + oy, 
				p.getX() + ox + width, p.getY() + oy + width);
		canvas.rectangle(p.getX() + ox, p.getY() + oy, 
				p.getX() + ox + width, p.getY() + oy + width);
		canvas.setCoordTransformApplied(true);
		canvas.restoreState();
	}

	/*
	public static void storeCanvasStatus(Canvas canvas, CanvasState state) {
		state.color = canvas.getColor();
		state.fillColor = canvas.getFillColor();
		state.lineWidth = canvas.getLineWidth();
		state.lineStyle = canvas.getLineStyle();
		state.xorMode = canvas.getXORMode();
		state.antialias = canvas.getAntialias();
		state.textAntialias = canvas.getTextAntialias();
		state.alpha = canvas.getAlpha();
	}

	public static void restoreCanvasStatus(Canvas canvas, CanvasState state) {
		canvas.setColor(state.color);
		canvas.setFillColor(state.fillColor);
		canvas.setLineWidth(state.lineWidth);
		canvas.setLineStyle(state.lineStyle);
		canvas.setXORMode(state.xorMode);
		canvas.setAntialias(state.antialias);
		canvas.setTextAntialias(state.textAntialias);
		canvas.setAlpha(state.alpha);
	}
	*/

}
