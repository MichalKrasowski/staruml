package co.staruml.awt;


import java.util.Stack;

import co.staruml.graphics.*;

public class CanvasAWT extends AbstractCanvas {

	private static final float[] dotPattern = new float[] {1};
	private static final float[] dashPattern = new float[] {3};

	private static java.awt.Color toAWTColor(Color color, int alpha) {
		return new java.awt.Color(
				color.getRed(), color.getGreen(), color.getBlue(), alpha);
	}
	
	private static Color toAbstractColor(java.awt.Color color) {
		return new Color(
				color.getRed(), color.getGreen(), color.getBlue());
	}
	
	private static java.awt.Font toAWTFont(Font font) {
		return new java.awt.Font(
				font.getName(), font.getStyle(),
				Math.round(font.getSize() * 1.375f));
	}
	
	private static Font toAbstractFont(java.awt.Font font) {
		return new Font(font.getName(), font.getStyle(),
				Math.round(font.getSize() * 0.72727f));
	}
	
	private static final java.awt.Paint toAWTPattern(Pattern pattern, int alpha) {
		if (pattern instanceof GradientPattern) {
			GradientPattern gp = (GradientPattern) pattern;
			return new java.awt.GradientPaint(
					gp.getX1(), gp.getY1(), toAWTColor(gp.getColor1(), alpha),
					gp.getX2(), gp.getY2(), toAWTColor(gp.getColor2(), alpha));
		}
		return null;
	}
	
	private static final Pattern toAbstractPattern(java.awt.Paint pattern) {
		if (pattern instanceof java.awt.GradientPaint) {
			java.awt.GradientPaint gp = (java.awt.GradientPaint) pattern;
			return new GradientPattern(
					(int) gp.getPoint1().getX(),
					(int) gp.getPoint1().getY(),
					(int) gp.getPoint2().getX(),
					(int) gp.getPoint2().getY(),
					toAbstractColor(gp.getColor1()),
					toAbstractColor(gp.getColor2()));
		}
		return null;
	}
	
	// basic stroke instances
	private static final java.awt.BasicStroke strokeSolid1 = 
		new java.awt.BasicStroke(1, java.awt.BasicStroke.CAP_BUTT, 
				java.awt.BasicStroke.JOIN_BEVEL, 0, null, 0);
	private static final java.awt.BasicStroke strokeSolid2 = 
		new java.awt.BasicStroke(2, java.awt.BasicStroke.CAP_BUTT, 
				java.awt.BasicStroke.JOIN_BEVEL, 0, null, 0);
	private static final java.awt.BasicStroke strokeSolid3 = 
		new java.awt.BasicStroke(3, java.awt.BasicStroke.CAP_BUTT, 
				java.awt.BasicStroke.JOIN_BEVEL, 0, null, 0);
	private static final java.awt.BasicStroke strokeDot1 = 
		new java.awt.BasicStroke(1, java.awt.BasicStroke.CAP_BUTT, 
				java.awt.BasicStroke.JOIN_BEVEL, 0, dotPattern, 0);
	private static final java.awt.BasicStroke strokeDot2 = 
		new java.awt.BasicStroke(2, java.awt.BasicStroke.CAP_BUTT, 
				java.awt.BasicStroke.JOIN_BEVEL, 0, dotPattern, 0);
	private static final java.awt.BasicStroke strokeDot3 = 
		new java.awt.BasicStroke(3, java.awt.BasicStroke.CAP_BUTT, 
				java.awt.BasicStroke.JOIN_BEVEL, 0, dotPattern, 0);
	private static final java.awt.BasicStroke strokeDash1 = 
		new java.awt.BasicStroke(1, java.awt.BasicStroke.CAP_BUTT, 
				java.awt.BasicStroke.JOIN_BEVEL, 0, dashPattern, 0);
	private static final java.awt.BasicStroke strokeDash2 = 
		new java.awt.BasicStroke(2, java.awt.BasicStroke.CAP_BUTT, 
				java.awt.BasicStroke.JOIN_BEVEL, 0, dashPattern, 0);
	private static final java.awt.BasicStroke strokeDash3 = 
		new java.awt.BasicStroke(3, java.awt.BasicStroke.CAP_BUTT, 
				java.awt.BasicStroke.JOIN_BEVEL, 0, dashPattern, 0);

	private Stack<CanvasAWTState> stateStack;
	private java.awt.Graphics2D g;
	private Point penPosition;
	private java.awt.Color color;
	private java.awt.Color fillColor;
	private java.awt.Color fontColor;
	private java.awt.Font font;
	private int lineWidth;
	private int lineStyle;
	private boolean xorMode;
	private int antialias;
	private int textAntialias;
	private int alpha;
	private java.awt.Paint pattern;
	
	public CanvasAWT() {
		stateStack = new Stack<CanvasAWTState>();
		g = null;
		penPosition = new Point(0, 0);
		color = java.awt.Color.BLACK;
		fillColor = java.awt.Color.WHITE;
		fontColor = java.awt.Color.BLACK;
		font = new java.awt.Font("Arial", java.awt.Font.PLAIN, 10);
		lineWidth = 1;
		lineStyle = LS_SOLID;
		xorMode = false;
		antialias = AS_DEFAULT;
		textAntialias = AS_DEFAULT;
		alpha = 255;
		pattern = null;
	}
	
	private float[] getPattern(int lineStyle) {
		switch (lineStyle) {
		case LS_SOLID: return null;
		case LS_DOT: return dotPattern;
		case LS_DASH: return dashPattern;
		}
		return null;
	}
	
	private java.awt.Stroke getStrokeInstance() {
		switch (lineStyle) {
		case LS_SOLID:
			if (lineWidth == 1) return strokeSolid1;
			else if (lineWidth == 2) return strokeSolid2;
			else if (lineWidth == 3) return strokeSolid3;
			break;
		case LS_DOT:
			if (lineWidth == 1) return strokeDot1;
			else if (lineWidth == 2) return strokeDot2;
			else if (lineWidth == 3) return strokeDot3;
			break;
		case LS_DASH:
			if (lineWidth == 1) return strokeDash1;
			else if (lineWidth == 2) return strokeDash2;
			else if (lineWidth == 3) return strokeDash3;
		}
		return new java.awt.BasicStroke(lineWidth, java.awt.BasicStroke.CAP_BUTT,
				java.awt.BasicStroke.JOIN_BEVEL, 0, getPattern(lineStyle), 0);
	}
	
	private void updateContext() {
		if (g != null) {
			g.setColor(color);
			g.setFont(font);
			g.setStroke(getStrokeInstance());			
			if (xorMode) g.setXORMode(java.awt.Color.WHITE);
			setAlpha(alpha);
			setAntialias(antialias);
			setTextAntialias(textAntialias);
			g.setPaint(pattern);
		}
	}

	public void storeState() {
		CanvasAWTState state = new CanvasAWTState();
		state.g = g;
		state.penPosition = penPosition;
		state.color = color;
		state.fillColor = fillColor;
		state.fontColor = fontColor;
		state.font = font;
		state.lineWidth = lineWidth;
		state.lineStyle = lineStyle;
		state.xorMode = xorMode;
		state.antialias = antialias;
		state.textAntialias = textAntialias;
		state.alpha = alpha;
		state.pattern = pattern;
		stateStack.push(state);
	}
	
	public void restoreState() {
		CanvasAWTState state = stateStack.pop();
		if (state != null) {
			g = state.g;
			penPosition = state.penPosition;
			color = state.color;
			fillColor = state.fillColor;
			fontColor = state.fontColor;
			font = state.font;
			lineWidth = state.lineWidth;
			lineStyle = state.lineStyle;
			xorMode = state.xorMode;
			antialias = state.antialias;
			textAntialias = state.textAntialias;
			alpha = state.alpha;
			pattern = state.pattern;
		}
		updateContext();
	}

	public void setGraphics(java.awt.Graphics2D g) {
		this.g = g;
		updateContext();
	}
	
	public java.awt.Graphics2D getGraphics() {
		return g;
	}
	
	public Color getColor() {
		return toAbstractColor(color);
	}
	
	public void setColor(Color c) {
		color = toAWTColor(c, alpha);
		if (g != null)
			g.setColor(color);
	}
	
	public Color getFillColor() {
		return toAbstractColor(fillColor);
	}
	
	public void setFillColor(Color c) {
		fillColor = toAWTColor(c, alpha);
	}
	
	public Color getFontColor() {
		return toAbstractColor(fontColor);
	}
	
	public void setFontColor(Color c) {
		fontColor = toAWTColor(c, alpha);
	}
	
	public Font getFont() {
		return toAbstractFont(font);
	}
	
	public void setFont(Font f) {
		font = toAWTFont(f);
		if (g != null)
			g.setFont(font);
	}

	public int getLineWidth() {
		return lineWidth;
	}

	public void setLineWidth(int lineWidth) {
		this.lineWidth = lineWidth;
		if (g != null)
			g.setStroke(getStrokeInstance());
	}
	
	public int getLineStyle() {
		return lineStyle;
	}

	public void setLineStyle(int lineStyle) {
		this.lineStyle = lineStyle;
		if (g != null)
			g.setStroke(getStrokeInstance());
	}
	
	public boolean getXORMode() {
		return xorMode;
	}
	
	public void setXORMode(boolean xor) {
		xorMode = xor;
		if (g != null) {
			if (xorMode)
				g.setXORMode(java.awt.Color.WHITE);
		}
	}
	
	public int getAntialias() {
		return antialias;
	}

	public void setAntialias(int antialias) {
		this.antialias = antialias;
		if (g != null) {
			switch (this.antialias) {
			case AS_DEFAULT:
				g.setRenderingHint(
						java.awt.RenderingHints.KEY_ANTIALIASING, 
						java.awt.RenderingHints.VALUE_ANTIALIAS_DEFAULT);
				break;
			case AS_ON: 
				g.setRenderingHint(
						java.awt.RenderingHints.KEY_ANTIALIASING, 
						java.awt.RenderingHints.VALUE_ANTIALIAS_ON);
				break;
			case AS_OFF: 
				g.setRenderingHint(
						java.awt.RenderingHints.KEY_ANTIALIASING, 
						java.awt.RenderingHints.VALUE_ANTIALIAS_OFF);
			}
		}
	}

	public int getTextAntialias() {
		return textAntialias;
	}

	public void setTextAntialias(int textAntialias) {
		this.textAntialias = textAntialias;
		if (g != null) {
			switch (this.textAntialias) {
			case AS_DEFAULT:
				g.setRenderingHint(
						java.awt.RenderingHints.KEY_TEXT_ANTIALIASING, 
						java.awt.RenderingHints.VALUE_TEXT_ANTIALIAS_DEFAULT);
				break;
			case AS_ON: 
				g.setRenderingHint(
						java.awt.RenderingHints.KEY_TEXT_ANTIALIASING, 
						java.awt.RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
				break;
			case AS_OFF: 
				g.setRenderingHint(
						java.awt.RenderingHints.KEY_TEXT_ANTIALIASING, 
						java.awt.RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
			}
		}
	}

	public int getAlpha() {
		return alpha;
	}

	public void setAlpha(int alpha) {
		this.alpha = alpha;
		color = new java.awt.Color(
				color.getRed(), color.getGreen(), color.getBlue(), alpha);
		fillColor = new java.awt.Color(
				fillColor.getRed(), fillColor.getGreen(), fillColor.getBlue(), alpha);
		fontColor = new java.awt.Color(
				fontColor.getRed(), fontColor.getGreen(), fontColor.getBlue(), alpha);
	}
	
	/*
	public Color getBackground() {
		return toAbstractColor(g.getBackground());
	}

	public void setBackground(Color color) {
		if (g != null)
			g.setBackground(toAWTColor(color, alpha));
	}
	*/
	
	public Pattern getPattern() {
		return toAbstractPattern(pattern);
	}

	public void setPattern(Pattern pattern) {
		this.pattern = toAWTPattern(pattern, alpha);
		if (g != null)
			g.setPaint(this.pattern);
	}
	
	public void putPixel(int x, int y, Color c) {
		Point p = new Point(x, y);
		if (coordTransformApplied)
			Coord.coordTransform(zoomFactor, GridFactor.NO_GRID, p);
		g.setColor(toAWTColor(c, alpha));
		g.drawLine(p.getX(), p.getY(), p.getX(), p.getY());
	}
	
	public void moveTo(int x, int y) {
		Point p = new Point(x, y);
		if (coordTransformApplied)
			Coord.coordTransform(zoomFactor, GridFactor.NO_GRID, p);
		p.add(origin);
		penPosition = p;
	}
	
	public void lineTo(int x, int y) {
		Point p = new Point(x, y);
		if (coordTransformApplied)
			Coord.coordTransform(zoomFactor, GridFactor.NO_GRID, p);
		p.add(origin);
		g.setColor(color);
		g.drawLine(penPosition.getX(), penPosition.getY(), p.getX(), p.getY());
		penPosition = p;
	}
	
	public void line(int x1, int y1, int x2, int y2) {
		Point p1 = new Point(x1, y1);
		Point p2 = new Point(x2, y2);
		if (coordTransformApplied) {
			Coord.coordTransform(zoomFactor, GridFactor.NO_GRID, p1);
			Coord.coordTransform(zoomFactor, GridFactor.NO_GRID, p2);
		}
		p1.add(origin);
		p2.add(origin);
		g.setColor(color);
		g.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
	}

	public void rectangle(int x1, int y1, int x2, int y2) {
		Point p1 = new Point(x1, y1);
		Point p2 = new Point(x2, y2);
		if (coordTransformApplied) {
			Coord.coordTransform(zoomFactor, GridFactor.NO_GRID, p1);
			Coord.coordTransform(zoomFactor, GridFactor.NO_GRID, p2);
		}
		int x = origin.getX() + ((p1.getX() < p2.getX()) ? p1.getX() : p2.getX());
		int y = origin.getY() + ((p1.getY() < p2.getY()) ? p1.getY() : p2.getY());
		int width = Math.abs(p2.getX() - p1.getX());
		int height = Math.abs(p2.getY() - p1.getY());
		g.setColor(color);
		g.drawRect(x, y, width, height);
	}
	
	public void fillRect(int x1, int y1, int x2, int y2) {
		Point p1 = new Point(x1, y1);
		Point p2 = new Point(x2, y2);
		if (coordTransformApplied) {
			Coord.coordTransform(zoomFactor, GridFactor.NO_GRID, p1);
			Coord.coordTransform(zoomFactor, GridFactor.NO_GRID, p2);
		}
		int x = origin.getX() + ((p1.getX() < p2.getX()) ? p1.getX() : p2.getX());
		int y = origin.getY() + ((p1.getY() < p2.getY()) ? p1.getY() : p2.getY());
		int width = Math.abs(p2.getX() - p1.getX());
		int height = Math.abs(p2.getY() - p1.getY());
		g.setColor(fillColor);
		g.setPaint(pattern);
		g.fillRect(x, y, width, height);
	}
	
	public void ellipse(int x1, int y1, int x2, int y2) {
		Point p1 = new Point(x1, y1);
		Point p2 = new Point(x2, y2);
		if (coordTransformApplied) {
			Coord.coordTransform(zoomFactor, GridFactor.NO_GRID, p1);
			Coord.coordTransform(zoomFactor, GridFactor.NO_GRID, p2);
		}
		int x = origin.getX() + ((p1.getX() < p2.getX()) ? p1.getX() : p2.getX());
		int y = origin.getY() + ((p1.getY() < p2.getY()) ? p1.getY() : p2.getY());
		int width = Math.abs(p2.getX() - p1.getX());
		int height = Math.abs(p2.getY() - p1.getY());
		g.setColor(color);
		g.drawOval(x, y, width, height);
	}
	
	public void fillEllipse(int x1, int y1, int x2, int y2) {
		Point p1 = new Point(x1, y1);
		Point p2 = new Point(x2, y2);
		if (coordTransformApplied) {
			Coord.coordTransform(zoomFactor, GridFactor.NO_GRID, p1);
			Coord.coordTransform(zoomFactor, GridFactor.NO_GRID, p2);
		}
		int x = origin.getX() + ((p1.getX() < p2.getX()) ? p1.getX() : p2.getX());
		int y = origin.getY() + ((p1.getY() < p2.getY()) ? p1.getY() : p2.getY());
		int width = Math.abs(p2.getX() - p1.getX());
		int height = Math.abs(p2.getY() - p1.getY());
		g.setColor(fillColor);
		g.setPaint(pattern);
		g.fillOval(x, y, width, height);
	}

	
	public void polyline(Point[] points) {
		int[] xPoints = new int[points.length];
		int[] yPoints = new int[points.length];
		Point t = new Point();
		for (int i = 0; i < points.length; i++) {
			t.setPoint(points[i]);
			if (coordTransformApplied)
				Coord.coordTransform(zoomFactor, GridFactor.NO_GRID, t);
			xPoints[i] = t.getX() + origin.getX();
			yPoints[i] = t.getY() + origin.getY();
		}
		g.setColor(color);
		g.drawPolyline(xPoints, yPoints, points.length);
	}

	public void polygon(Point[] points) {
		int[] xPoints = new int[points.length];
		int[] yPoints = new int[points.length];
		Point t = new Point();
		for (int i = 0; i < points.length; i++) {
			t.setPoint(points[i]);
			if (coordTransformApplied)
				Coord.coordTransform(zoomFactor, GridFactor.NO_GRID, t);
			xPoints[i] = t.getX() + origin.getX();
			yPoints[i] = t.getY() + origin.getY();
		}
		g.setColor(color);
		g.drawPolygon(xPoints, yPoints, points.length);
	}
	
	public void fillPolygon(Point[] points) {
		int[] xPoints = new int[points.length];
		int[] yPoints = new int[points.length];
		Point t = new Point();
		for (int i = 0; i < points.length; i++) {
			t.setPoint(points[i]);
			if (coordTransformApplied)
				Coord.coordTransform(zoomFactor, GridFactor.NO_GRID, t);
			xPoints[i] = t.getX() + origin.getX();
			yPoints[i] = t.getY() + origin.getY();
		}
		g.setColor(fillColor);
		g.setPaint(pattern);
		g.fillPolygon(xPoints, yPoints, points.length);
	}
	
	public void drawImage(int x, int y, Image image) {
		java.awt.Image img = ((ImageAWT) image).getImage();
		g.drawImage(img, x, y, null);
	}
	
	public void textOut(int x, int y, String text) {
		Rect r = new Rect(x, y, x, y);
		textOut(r, text, Canvas.AL_LEFT, Canvas.AL_TOP);
	}

	public void textOut(Rect rect, String text, int horizontalAlignment, int verticalAlignment) {
		Rect r = new Rect(rect);
		if (coordTransformApplied)
			Coord.coordTransform(zoomFactor, GridFactor.NO_GRID, r);
		java.awt.Font fon = new java.awt.Font(font.getName(), font.getStyle(),
				Coord.valueTranform(zoomFactor, font.getSize()));
		r.add(origin);
		g.setColor(fontColor);
		g.setFont(fon);
		if (text != null) {
			text = text.trim();
			String lines[] = text.split("\n");
			int lineHeight = textExtent("^_").getY();
			int wholeHeight = lineHeight * lines.length;
			int baseY = 0;
			// calculate base Y position. 
			switch (verticalAlignment) {
			case AL_TOP:
				baseY = r.getY1();
				break;
			case AL_BOTTOM:
				baseY = (r.getY2() - wholeHeight);
				break;
			case AL_MIDDLE:
				float f = ((r.getY1() + r.getY2()) / 2.0f) - (wholeHeight / 2.0f);
				baseY = Math.round(f);
				break;
			}
			// output each lines
			for (int i = 0; i < lines.length; i++) {
				String line = lines[i].trim();
				int lineWidth = textExtent(line).getX();
				int x = 0;
				switch (horizontalAlignment) {
				case AL_LEFT:
					x = r.getX1();
					break;
				case AL_RIGHT:
					x = (r.getX2() - lineWidth);
					break;
				case AL_CENTER:
					float f = ((r.getX1() + r.getX2()) / 2.0f) - (lineWidth / 2.0f);
					x = Math.round(f);
					break;
				}
				g.drawString(line, x, baseY + lineHeight);
				baseY = baseY + lineHeight;
			}
		}
	}
	
	public Point textExtent(String text) {
		java.awt.FontMetrics fm = g.getFontMetrics();
		if (text != null) {
			String[] lines = text.trim().split("\n");
			int maxWidth = 0;
			int maxHeight = 0;
			int lineHeight = (int) fm.getStringBounds("^_", g).getHeight();
			for (int i = 0; i < lines.length; i++) {
				String line = lines[i].trim();
				int lineWidth = (int) fm.getStringBounds(line, g).getWidth();
				if (lineWidth > maxWidth) maxWidth = lineWidth;
				maxHeight = maxHeight + lineHeight;
			}
			return new Point(maxWidth, maxHeight);
		}
		return new Point(0, 0);
	}
}
