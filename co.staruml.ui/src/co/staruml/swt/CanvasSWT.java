package co.staruml.swt;

import java.util.Stack;


import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.SWT;

import co.staruml.graphics.*;

public class CanvasSWT extends AbstractCanvas {

	private static final Color toAbstractColor(
			org.eclipse.swt.graphics.Color color) {
		return new Color(color.getRed(), color.getGreen(), color.getBlue());
	}
	
	private static final org.eclipse.swt.graphics.Color 
			toSWTColor(Device device, Color color) {
		return new org.eclipse.swt.graphics.Color(device,
				color.getRed(), color.getGreen(), color.getBlue());
	}
	
	private static final Font toAbstractFont(
			org.eclipse.swt.graphics.Font font) {
		FontData[] fontData = font.getFontData();
		return new Font(fontData[0].getName(), fontData[0].getStyle(), 
				fontData[0].getHeight());
	}
	
	private static final org.eclipse.swt.graphics.Font 
			toSWTFont(Device device, Font font) {
		return new org.eclipse.swt.graphics.Font(device, font.getName(), 
				font.getSize(), font.getStyle());
	}
	
	private static final org.eclipse.swt.graphics.Pattern
			toSWTPattern(Device device, Pattern pattern) {
		if (pattern instanceof GradientPattern) {
			GradientPattern gp = (GradientPattern) pattern;
			return new org.eclipse.swt.graphics.Pattern(device,
					gp.getX1(), gp.getY1(), gp.getX2(), gp.getY2(),
					toSWTColor(device, gp.getColor1()), toSWTColor(device, gp.getColor2()));
		}
		return null;
	}

	private Stack<CanvasSWTState> stateStack;
	private GC gc;
	private Point penPosition;
	private org.eclipse.swt.graphics.Color color;
	private org.eclipse.swt.graphics.Color fillColor;
	private org.eclipse.swt.graphics.Color fontColor;
	private org.eclipse.swt.graphics.Font font;
	private int lineWidth;
	private int lineStyle;
	private boolean xorMode;
	private int antialias;
	private int textAntialias;
	private int alpha;
	private org.eclipse.swt.graphics.Pattern pattern;
	private Pattern abstractPattern;
	
	public CanvasSWT(GC gc) {
		stateStack = new Stack<CanvasSWTState>();
		this.gc = gc;
		penPosition = new Point(0, 0);
		color = gc.getDevice().getSystemColor(SWT.COLOR_BLACK);
		fillColor = gc.getDevice().getSystemColor(SWT.COLOR_WHITE);
		fontColor = gc.getDevice().getSystemColor(SWT.COLOR_BLACK);
		font = new org.eclipse.swt.graphics.Font(gc.getDevice(), "Arial", 10, SWT.NORMAL);
		lineWidth = 1;
		lineStyle = LS_SOLID;
		xorMode = false;
		antialias = AS_DEFAULT;
		textAntialias = AS_DEFAULT;
		alpha = 255;
		pattern = null;
		abstractPattern = null;
	}
	
	private void updateContext() {
		if (gc != null) {
			gc.setAdvanced(true);
			gc.setForeground(color);
			gc.setBackground(fillColor);
			gc.setFont(font);
			setLineStyle(lineStyle);
			gc.setLineWidth(lineWidth);
			gc.setAlpha(alpha);
			setAntialias(antialias);
			setTextAntialias(textAntialias);
			gc.setBackgroundPattern(pattern);
		}
	}

	public void storeState() {
		CanvasSWTState state = new CanvasSWTState();
		state.gc = gc;
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
		state.abstractPattern = abstractPattern;
		stateStack.push(state);
	}
	
	public void restoreState() {
		CanvasSWTState state = stateStack.pop();
		if (state != null) {
			gc = state.gc;
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
			abstractPattern = state.abstractPattern;
		}
		updateContext();
	}

	public GC getGC() {
		return gc;
	}
	
	public void setGC(GC gc) {
		this.gc = gc;
		updateContext();
	}
		
	public Color getColor() {
		return toAbstractColor(color);
	}

	public void setColor(Color c) {
		color = toSWTColor(gc.getDevice(), c);
		if (gc != null)
			gc.setForeground(color);
	}

	public Color getFillColor() {
		return toAbstractColor(fillColor);
	}

	public void setFillColor(Color c) {
		fillColor = toSWTColor(gc.getDevice(), c);
		if (gc != null)
			gc.setBackground(fillColor);
	}

	public Color getFontColor() {
		return toAbstractColor(fontColor);
	}

	public void setFontColor(Color c) {
		fontColor = toSWTColor(gc.getDevice(), c);
	}

	public Font getFont() {
		return toAbstractFont(font);
	}

	public void setFont(Font f) {
		font = toSWTFont(gc.getDevice(), f);
		if (gc != null)
			gc.setFont(font);
	}

	public int getLineStyle() {
		return lineStyle;
	}

	public void setLineStyle(int lineStyle) {
		this.lineStyle = lineStyle;
		int style = 0;
		switch (this.lineStyle) {
		case Canvas.LS_SOLID: style = SWT.LINE_SOLID; break;
		case Canvas.LS_DOT: style = SWT.LINE_DOT; break;
		case Canvas.LS_DASH: style = SWT.LINE_DASH; break;
		}
		if (gc != null)
			gc.setLineStyle(style);
	}

	public int getLineWidth() {
		return lineWidth;
	}

	public void setLineWidth(int lineWidth) {
		this.lineWidth = lineWidth;
		if (gc != null)
			gc.setLineWidth(lineWidth);
	}

	public int getAlpha() {
		return alpha;
	}

	public void setAlpha(int alpha) {
		this.alpha = alpha;
		if (gc != null)
			gc.setAlpha(alpha);
	}

	public int getAntialias() {
		return antialias;
	}

	public void setAntialias(int antialias) {
		this.antialias = antialias;
		int anti = 0;
		switch (this.antialias) {
		case Canvas.AS_DEFAULT: anti = SWT.DEFAULT; break;
		case Canvas.AS_OFF: anti = SWT.OFF; break;
		case Canvas.AS_ON: anti = SWT.ON; break;
		}
		if (gc != null)
			gc.setAntialias(anti);
	}

	public int getTextAntialias() {
		return textAntialias;
	}

	public void setTextAntialias(int textAntialias) {
		this.textAntialias = textAntialias;
		int anti = 0;
		switch (this.textAntialias) {
		case Canvas.AS_DEFAULT: anti = SWT.DEFAULT; break;
		case Canvas.AS_OFF: anti = SWT.OFF; break;
		case Canvas.AS_ON: anti = SWT.ON; break;
		}
		if (gc != null)
			gc.setTextAntialias(anti);
	}

	public boolean getXORMode() {
		return xorMode;
	}

	@SuppressWarnings("deprecation")
	public void setXORMode(boolean xor) {
		xorMode = xor;
		gc.setXORMode(xorMode);
	}

	public Pattern getPattern() {
		return abstractPattern;
	}

	public void setPattern(Pattern pattern) {
		this.pattern = toSWTPattern(gc.getDevice(), pattern);
		this.abstractPattern = pattern;
		if (gc != null)
			gc.setBackgroundPattern(this.pattern);
	}

	public void putPixel(int x, int y, Color c) {
		Color cb = getColor();
		setColor(c);
		Point p = new Point(x, y);
		if (coordTransformApplied)
			Coord.coordTransform(zoomFactor, GridFactor.NO_GRID, p);
		p.add(origin);
		gc.drawPoint(p.getX(), p.getY());
		setColor(cb);
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
		gc.setForeground(color);
		gc.drawLine(penPosition.getX(), penPosition.getY(), p.getX(), p.getY());
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
		gc.setForeground(color);
		gc.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
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
		gc.setForeground(color);
		// gc.setBackground(fillColor);
		gc.drawRectangle(x, y, width, height);
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
		gc.setBackground(fillColor);
		gc.setBackgroundPattern(pattern);
		gc.fillRectangle(x, y, width, height);
		// gc.setForeground(color);
		// gc.drawRectangle(x, y, width, height);
	}
	
	public void ellipse(int x1, int y1, int x2, int y2) {
		// TODO IMPLEMENT THIS!
	}
	
	public void fillEllipse(int x1, int y1, int x2, int y2) {
		// TODO IMPLEMENT THIS!		
	}

	public void polyline(Point[] points) {
		int[] pointArray = new int[points.length * 2];
		Point t = new Point();
		for (int i = 0; i < points.length; i++) {
			t.setPoint(points[i]);
			if (coordTransformApplied)
				Coord.coordTransform(zoomFactor, GridFactor.NO_GRID, t);
			pointArray[i * 2] = t.getX() + origin.getX();
			pointArray[i * 2 + 1] = t.getY() + origin.getY();
		}
		gc.setForeground(color);
		gc.drawPolyline(pointArray);
	}

	public void polygon(Point[] points) {
		int[] pointArray = new int[points.length * 2];
		Point t = new Point();
		for (int i = 0; i < points.length; i++) {
			t.setPoint(points[i]);
			if (coordTransformApplied)
				Coord.coordTransform(zoomFactor, GridFactor.NO_GRID, t);
			pointArray[i * 2] = t.getX() + origin.getX();
			pointArray[i * 2 + 1] = t.getY() + origin.getY();
		}
		gc.setForeground(color);
		gc.drawPolygon(pointArray);
	}
	
	public void fillPolygon(Point[] points) {
		int[] pointArray = new int[points.length * 2];
		Point t = new Point();
		for (int i = 0; i < points.length; i++) {
			t.setPoint(points[i]);
			if (coordTransformApplied)
				Coord.coordTransform(zoomFactor, GridFactor.NO_GRID, t);
			pointArray[i * 2] = t.getX() + origin.getX();
			pointArray[i * 2 + 1] = t.getY() + origin.getY();
		}
		gc.setBackground(fillColor);
		gc.setBackgroundPattern(pattern);
		gc.fillPolygon(pointArray);
		// gc.setForeground(color);
		// gc.drawPolygon(pointArray);
	}

	public void drawImage(int x, int y, Image image) {
		// TODO implement this.
	}

	public void textOut(int x, int y, String text) {
		Point p = new Point(x, y);
		if (coordTransformApplied)
			Coord.coordTransform(zoomFactor, GridFactor.NO_GRID, p);
		// TODO font size has to be coordTransform...
		p.add(origin);
		gc.setForeground(fontColor);
		gc.setFont(font);
		gc.drawText(text, p.getX(), p.getY(), true);
	}
	
	public void textOut(Rect rect, String text, int horizontalAlignment, int verticalAlignment) {
		Rect r = new Rect(rect);
		if (coordTransformApplied)
			Coord.coordTransform(zoomFactor, GridFactor.NO_GRID, r);
		// TODO font size has to be coordTransform...
		r.add(origin);
		gc.setForeground(fontColor);
		gc.setFont(font);
		int x = 0, y = 0;
		switch (horizontalAlignment) {
		case AL_LEFT:
			x = r.getX1();
			break;
		case AL_RIGHT:
			x = (r.getX2() - textExtent(text).getX());
			break;
		case AL_CENTER:
			float f = ((r.getX1() + r.getX2()) / 2.0f) - (textExtent(text).getX() / 2.0f);
			x = Math.round(f);
			break;
		}
		switch (verticalAlignment) {
		case AL_TOP:
			y = r.getY1();
			break;
		case AL_BOTTOM:
			y = (r.getY2() - textExtent(text).getY());
			break;
		case AL_MIDDLE:
			float f = ((r.getY1() + r.getY2()) / 2.0f) - (textExtent(text).getY() / 2.0f);
			y = Math.round(f);
			break;
		}
		gc.drawText(text, x, y, true);
	}
	
	public Point textExtent(String text) {
		gc.setFont(font);
		org.eclipse.swt.graphics.Point p = gc.textExtent(text);
		return new Point(p.x, p.y);
	}

}
