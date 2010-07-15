package co.staruml.core;

import java.util.HashMap;
import java.util.Vector;

import co.staruml.graphics.*;
import co.staruml.handler.Handler;


/**
 * DiagramView is a logical composite of views
 * @author Minkyu Lee
 *
 */

public class DiagramView extends View {
	
	protected Vector<View> ownedViews;
	protected Vector<View> selectedViews;

	public DiagramView() {
		ownedViews = new Vector<View>();
		selectedViews = new Vector<View>();
	}
	
	private void selectView(Canvas canvas, View v, Rect r) {
		if (v.isVisible() && v.isEnabled() && v.isSelectable()) {
			if (v.overlapRect(canvas, r))
				v.setSelected(true);
		}
		for (View sub: v.subViews)
			selectView(canvas, sub, r);
	}
	
	private void selectView(View v) {
		if (v.isVisible() && v.isEnabled() && v.isSelectable())
			v.setSelected(true);
		for (View sub: v.subViews)
			selectView(sub);
	}
	
	protected void arrangeObject(Canvas canvas) {
	}

	protected void drawObject(Canvas canvas) {
		if (visible) {
			for (View v: ownedViews)
				v.arrange(canvas);
		}
	}

	protected void drawSelection(Canvas canvas) {
	}

	protected void movePosition(Canvas canvas, int dx, int dy) {
	}
	
	public void draw(Canvas canvas) {
		if (visible) {
			arrange(canvas);
			drawObject(canvas);
			for (View v: ownedViews)
				v.draw(canvas);
		}
	}
	
	public void drawDiagram(Canvas canvas) {
		if (visible) {
			draw(canvas);
			
			// TEST
			for (View v : ownedViews)
				if (v.isSelected())
					v.drawSelection(canvas);
			// TEST
			
		}
	}

	public void addOwnedView(View view) {
		ownedViews.add(view);
		view.ownerDiagramView = this;
	}
	
	public void removeOwnedView(View view) {
		ownedViews.remove(view);
		view.ownerDiagramView = null;
	}
	
	public Vector<View> getOwnedViews() {
		return ownedViews;
	}
	
	public Vector<View> getSelectedViews() {
		return selectedViews;
	}
	
	public View getViewAt(Canvas canvas, int x, int y) {
		for (View v : ownedViews) {
			if(v instanceof EdgeView){
				EdgeView view = (EdgeView)v;
			}
			if (v.isVisible() && v.isSelectable()) {
				View view = v.getViewAt(canvas, x, y);
				if (view != null) return view;
			}
		}
		if (containsPoint(canvas, x, y))
			return this;
		return null;
	}
	
	public View getBottomViewAt(Canvas canvas, int x, int y) {
		for (int i = ownedViews.size() - 1; i >= 0; i--) {
			View v = ownedViews.elementAt(i);
			if (v.isVisible() && v.isSelectable() && v.containsPoint(canvas, x, y))
				return v;
		}
		if (containsPoint(canvas, x, y))
			return this;
		return null;
	}
	
	public Rect getSelectedBoundingBox(Canvas canvas) {
		Rect r = new Rect(10000, 10000, -10000, -10000);
		for (View v : selectedViews)
			r = Coord.unionRect(r, v.getBoundingBox(canvas));
		return r;
	}
	
	public void selectArea(Canvas canvas, int x1, int y1, int x2, int y2) {
		Rect r = new Rect(x1, y1, x2, y2);
		Coord.normalizeRect(r);
		for (View v: ownedViews)
			selectView(canvas, v, r);
	}
	
	public void selectAll() {
		for (View v: selectedViews)
			selectView(v);
	}
	
	public void deselectAll() {
		for (View v: selectedViews)
			v.selected = false;
		selectedViews.clear();
	}
	
}
