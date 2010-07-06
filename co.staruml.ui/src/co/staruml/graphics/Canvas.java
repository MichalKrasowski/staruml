package co.staruml.graphics;

// TODO setXORMode ?�수�??�애�? Rubberband, Rubberline ?�위???�수�?DiagramEditor??추�??�야 ??�?같다. 

public interface Canvas {

	// constants for lineStyle
	public static final int
			LS_SOLID = 0,
			LS_DOT = 1,
			LS_DASH = 2;
	
	// constants for antialias and textAntialias
	public static final int
			AS_DEFAULT = 0,
			AS_ON = 1,
			AS_OFF = 2;
	
	// constants for vertical, horizontal alignment
	public static final int
			AL_LEFT = 0,
			AL_RIGHT = 1,
			AL_CENTER = 2,
			AL_TOP = 3,
			AL_BOTTOM = 4,
			AL_MIDDLE = 5;
	
	public void storeState();
	public void restoreState();
	public ImageManager getImageManager();
	public void setImageManager(ImageManager imageManager);

	public Point getOrigin();
	public void setOrigin(Point origin);
	public ZoomFactor getZoomFactor();
	public void setZoomFactor(ZoomFactor zoomFactor);
	public GridFactor getGridFactor();
	public void setGridFactor(GridFactor gridFactor);
	public boolean isCoordTransformApplied();
	public void setCoordTransformApplied(boolean value);

	public Color getColor();
	public void setColor(Color c);
	public Color getFillColor();
	public void setFillColor(Color c);
	public Color getFontColor();
	public void setFontColor(Color c);
	public int getLineWidth();
	public void setLineWidth(int lineWidth);
	public int getLineStyle();
	public void setLineStyle(int lineStyle);
	public Font getFont();
	public void setFont(Font f);
	public boolean getXORMode();
	public void setXORMode(boolean xor);
	public int getAntialias();
	public void setAntialias(int antialias);
	public int getTextAntialias();
	public void setTextAntialias(int textAntialias);
	public int getAlpha();
	public void setAlpha(int alpha);
	public Pattern getPattern();
	public void setPattern(Pattern pattern);
	
	public void putPixel(int x, int y, Color c);
	public void moveTo(int x, int y);
	public void lineTo(int x, int y);
	public void line(int x1, int y1, int x2, int y2);
	public void rectangle(int x1, int y1, int x2, int y2);
	public void fillRect(int x1, int y1, int x2, int y2);
	public void ellipse(int x1, int y1, int x2, int y2);
	public void fillEllipse(int x1, int y1, int x2, int y2);
	public void polyline(Point[] points);
	public void polygon(Point[] points);
	public void fillPolygon(Point[] points);
	public void drawImage(int x, int y, Image image);
	public void drawImage(int x, int y, String imageName);
	public void textOut(int x, int y, String text);
	public void textOut(Rect rect, String text, int horizontalAlignment, int verticalAlignment);
	public Point textExtent(String text);
	
}
