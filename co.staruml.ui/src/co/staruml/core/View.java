package co.staruml.core;

import java.util.*;

import co.staruml.graphics.*;


public abstract class View {

	protected View parent;
	protected Vector<View> subViews;
	protected View containerView;
	protected Vector<View> containedViews;
	protected DiagramView ownerDiagramView;
	protected boolean visible;
	protected boolean enabled;
	protected boolean selected;
	protected boolean selectable;
	protected Color lineColor;
	protected Color fillColor;
	protected Color fontColor;
	protected Font font;
	protected boolean containerChangeable;
	
	public View() {
		subViews = new Vector<View>();
		containedViews = new Vector<View>();
		visible = true;
		enabled = true;
		selected = false;
		selectable = true;
		lineColor = Color.BLACK;
		fillColor = Color.WHITE;
		fontColor = Color.BLACK;
		font = new Font();
	}
	
	protected void assignStyleToCanvas(Canvas canvas) {
		canvas.setColor(lineColor);
		canvas.setFillColor(fillColor);
		canvas.setFontColor(fontColor);
		canvas.setFont(font);
	}
	
	protected abstract void drawObject(Canvas canvas);
	protected abstract void drawSelection(Canvas canvas);
	protected abstract void movePosition(Canvas canvas, int dx, int dy);
	protected abstract void arrangeObject(Canvas canvas);

	public View getParent() {
		return parent;
	}
	
	public View getContainerView() {
		return containerView;
	}
	
	public DiagramView getOwnerDiagramView() {
		return ownerDiagramView;
	}
	
	public boolean isVisible() {
		return visible;
	}
	
	public void setVisible(boolean value) {
		visible = value;
	}

	public boolean isEnabled() {
		return enabled;
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public boolean isSelected() {
		return selected;
	}
	
	public void setSelected(boolean selected) {
		if (selectable)
			if (this.selected != selected) {
				DiagramView dv = getDiagramView();
				if (dv != null) {
					if (selected)
						dv.selectedViews.add(this);
					else
						dv.selectedViews.remove(this);
				}
				this.selected = selected;
			}
	}
	
	public boolean isSelectable() {
		return selectable;
	}
	
	public void setSelectable(boolean selectable) {
		this.selectable = selectable;
	}
	
	public Color getLineColor() {
		return lineColor;
	}

	public void setLineColor(Color lineColor) {
		this.lineColor = lineColor;
	}
	
	public Color getFillColor() {
		return fillColor;
	}
	
	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
	}
	
	public Color getFontColor() {
		return fontColor;
	}
	
	public void setFontColor(Color fontColor) {
		this.fontColor = fontColor;
	}
	
	public Font getFont() {
		return font;
	}
	
	public void setFont(Font f) {
		this.font = f;
	}
	
	public boolean isContainerChangeable() {
		return containerChangeable;
	}

	public void setContainerChangeable(boolean containerChangeable) {
		this.containerChangeable = containerChangeable;
	}

	public void initialize(Canvas canvas, int x1, int y1, int x2, int y2) {
		// no implementation.
	}

	public void draw(Canvas canvas) {
		if (visible) {
			arrange(canvas);
			drawObject(canvas);
			for (View v : subViews)
				v.draw(canvas);
		}
	}
	
	public void move(Canvas canvas, int dx, int dy) {
		if ((dx != 0) || (dy != 0)) {
			movePosition(canvas, dx, dy);
			for (View v : subViews)
				v.move(canvas, dx, dy);
		}
	}
	
	public void arrange(Canvas canvas) {
		for (View v : subViews)
			v.arrange(canvas);
		arrangeObject(canvas);
	}
	
	public View getViewAt(Canvas canvas, int x, int y) {
		for (int i = subViews.size() - 1; i >= 0; i--) {
			View v = subViews.elementAt(i);
			if (v.isVisible() && v.isSelectable()) {
				View sub = v.getViewAt(canvas, x, y);
				if (sub != null)
					return sub;
			}
		}
		if (containsPoint(canvas, x, y))
			return this;
		return null;
	}
	
	public DiagramView getDiagramView() {
		if (ownerDiagramView != null)
			return ownerDiagramView;
		if (parent != null)
			return parent.getDiagramView();
		return null;
	}
	
	public Rect getBoundingBox(Canvas canvas) {
		Rect rect = new Rect(-1, -1, 0, 0);
		return rect;
	}
	
	public boolean containsPoint(Canvas canvas, int x, int y) {
		Rect r = getBoundingBox(canvas);
		if (selected) {
			Rect zr = r;
			Point zp = new Point(x, y);
			Coord.coordTransform(canvas.getZoomFactor(), GridFactor.NO_GRID, zr);
			zr.setRect(zr.getX1() - Toolkit.DEFAULT_HIGHLIGHTER_SIZE,
					zr.getY1() - Toolkit.DEFAULT_HIGHLIGHTER_SIZE,
					zr.getX2() + Toolkit.DEFAULT_HIGHLIGHTER_SIZE,
					zr.getY2() + Toolkit.DEFAULT_HIGHLIGHTER_SIZE);
			Coord.coordTransform(canvas.getZoomFactor(), GridFactor.NO_GRID, zp);
			return Coord.ptInRect(zp.getX(), zp.getY(), zr);
		}
		return Coord.ptInRect(x, y, r);
	}
	
	public boolean overlapRect(Canvas canvas, Rect rect) {
		Rect bound = getBoundingBox(canvas);
		if (selected) {
			bound.setRect(bound.getX1() - 5, bound.getY1() - 5,
					bound.getX2() + 5, bound.getY2() + 5);
		}
		return Coord.rectInRect(rect, bound);
	}
	
	public void addSubView(View view) {
		subViews.add(view);
		view.parent = this;
	}
	
	public void removeSubView(View view) {
		subViews.remove(view);
		view.parent = null;
	}
	
	public void addContainedView(View view) {
		containedViews.add(view);
		view.containerView = this;
	}
	
	public void removeContainedView(View view) {
		containedViews.remove(view);
		view.containerView = null;
	}
}
