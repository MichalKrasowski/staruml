package co.staruml.core;

import co.staruml.graphics.*;

public class NodeView extends View {
	
	protected int left;
	protected int top;
	protected int width;
	protected int height;
	protected int minWidth;
	protected int minHeight;
	protected int sizable;
	protected int movable;
	protected boolean autoResize;
	
	public NodeView() {
		left = 0; top = 0; width = 100; height = 100;
		minWidth = 5; minHeight = 5;
		movable = Const.MM_FREE;
		sizable = Const.SZ_FREE;
		autoResize = false;
	}
	
	public int getLeft() {
		return left;
	}

	public void setLeft(int left) {
		this.left = left;
	}

	public int getTop() {
		return top;
	}

	public void setTop(int top) {
		this.top = top;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public int getMinWidth() {
		return minWidth;
	}

	public void setMinWidth(int minWidth) {
		this.minWidth = minWidth;
	}

	public int getMinHeight() {
		return minHeight;
	}

	public void setMinHeight(int minHeight) {
		this.minHeight = minHeight;
	}

	public int getSizable() {
		return sizable;
	}

	public void setSizable(int sizable) {
		this.sizable = sizable;
	}

	public int getMovable() {
		return movable;
	}

	public void setMovable(int movable) {
		this.movable = movable;
	}

	public boolean isAutoResize() {
		return autoResize;
	}

	public void setAutoResize(boolean autoResize) {
		this.autoResize = autoResize;
	}

	public int getRight() {
		return left + width - 1;
	}
	
	public void setRight(int right) {
		width = right - left + 1;
	}
	
	public int getBottom() {
		return top + height - 1;
	}
	
	public void setBottom(int bottom) {
		height = bottom - top + 1;
	}

	protected void arrangeObject(Canvas canvas) {
		if (autoResize) {
			width = minWidth;
			height = minHeight;
		}
		if (width < minWidth) width = minWidth;
		if (height < minHeight) height = minHeight;
	}

	protected void drawObject(Canvas canvas) {
		canvas.setColor(Color.BLACK);
		canvas.setFillColor(Color.WHITE);
		canvas.fillRect(left, top, getRight(), getBottom());
		canvas.rectangle(left, top, getRight(), getBottom());
	}

	protected void drawSelection(Canvas canvas) {
		boolean retouch = !((sizable == Const.SZ_FREE) || (sizable == Const.SZ_RATIO));
		int x1, y1, x2, y2;
		// draw top line
		x1 = left - 1; y1 = top - 1; x2 = getRight(); y2 = top - 1;
		Toolkit.drawSelectionLine(canvas, x1, y1, x2, y2, 
				Toolkit.DEFAULT_SELECTIONLINE_WIDTH, Toolkit.NWSE_N, retouch);
		// draw left line
		x1 = left - 1; y1 = top - 1; x2 = left - 1; y2 = getBottom();
		Toolkit.drawSelectionLine(canvas, x1, y1, x2, y2, 
				Toolkit.DEFAULT_SELECTIONLINE_WIDTH, Toolkit.NWSE_W, retouch);
		// draw right line
		x1 = getRight(); y1 = top - 1; x2 = getRight(); y2 = getBottom();
		Toolkit.drawSelectionLine(canvas, x1, y1, x2, y2, 
				Toolkit.DEFAULT_SELECTIONLINE_WIDTH, Toolkit.NWSE_E, retouch);
		// draw bottom line
		x1 = left - 1; y1 = getBottom(); x2 = getRight(); y2 = getBottom();
		Toolkit.drawSelectionLine(canvas, x1, y1, x2, y2, 
				Toolkit.DEFAULT_SELECTIONLINE_WIDTH, Toolkit.NWSE_S, retouch);
		
		if (sizable == Const.SZ_NONE) {
			// no draw highlighter
		} else {
			if ((sizable == Const.SZ_FREE) || (sizable == Const.SZ_RATIO)) {
				Toolkit.drawHighlighter2(canvas, left, top, getRight(), getBottom(), Toolkit.DEFAULT_HIGHLIGHTER_SIZE, Toolkit.CT_LT, true, Toolkit.SELECTION_COLOR);
				Toolkit.drawHighlighter2(canvas, left, top, getRight(), getBottom(), Toolkit.DEFAULT_HIGHLIGHTER_SIZE, Toolkit.CT_RT, true, Toolkit.SELECTION_COLOR);
				Toolkit.drawHighlighter2(canvas, left, top, getRight(), getBottom(), Toolkit.DEFAULT_HIGHLIGHTER_SIZE, Toolkit.CT_LB, true, Toolkit.SELECTION_COLOR);
				Toolkit.drawHighlighter2(canvas, left, top, getRight(), getBottom(), Toolkit.DEFAULT_HIGHLIGHTER_SIZE, Toolkit.CT_RB, true, Toolkit.SELECTION_COLOR);
			}
			if ((sizable == Const.SZ_FREE) || (sizable == Const.SZ_VERT)) {
				Toolkit.drawHighlighter2(canvas, left, top, getRight(), getBottom(), Toolkit.DEFAULT_HIGHLIGHTER_SIZE, Toolkit.CT_MT, true, Toolkit.SELECTION_COLOR);
				Toolkit.drawHighlighter2(canvas, left, top, getRight(), getBottom(), Toolkit.DEFAULT_HIGHLIGHTER_SIZE, Toolkit.CT_MB, true, Toolkit.SELECTION_COLOR);
			}
			if ((sizable == Const.SZ_FREE) || (sizable == Const.SZ_HORZ)) {
				Toolkit.drawHighlighter2(canvas, left, top, getRight(), getBottom(), Toolkit.DEFAULT_HIGHLIGHTER_SIZE, Toolkit.CT_LM, true, Toolkit.SELECTION_COLOR);
				Toolkit.drawHighlighter2(canvas, left, top, getRight(), getBottom(), Toolkit.DEFAULT_HIGHLIGHTER_SIZE, Toolkit.CT_RM, true, Toolkit.SELECTION_COLOR);
			}
		}
	}

	protected void movePosition(Canvas canvas, int dx, int dy) {
		if ((dx != 0) || (dy != 0)) {
			left = left + dx;
			top = top + dy;
		}
	}
	
	public Rect getBoundingBox(Canvas canvas) {
		return new Rect(left, top, getRight(), getBottom());
	}
	
	public void initialize(Canvas canvas, int x1, int y1, int x2, int y2) {
		Rect r = new Rect(x1, y1, x2, y2);
		Coord.normalizeRect(r);
		left = r.getX1();
		top = r.getY1();
		width = Math.max(minWidth, r.getX2() - r.getX1());
		height = Math.max(minHeight, r.getY2() - r.getY1());
	}
}
