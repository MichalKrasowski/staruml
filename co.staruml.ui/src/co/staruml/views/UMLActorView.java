package co.staruml.views;

import co.staruml.graphics.*;

public class UMLActorView extends UMLGeneralNodeView {

	protected static final int
		ACTOR_RATIO_PERCENT = 48,
		ACTOR_ICONMINHEIGHT = 55,
		ACTOR_ICONMINWIDTH = ACTOR_ICONMINHEIGHT * ACTOR_RATIO_PERCENT / 100;
	
	public UMLActorView() {
	}
	
	protected void drawActor(Canvas canvas, Rect rect) {
		int w = rect.getX2() - rect.getX1();
		int h = rect.getY2() - rect.getY1();
		int xh = w * 16 / 100;
		int xa = w * 14 / 100;
		int yh = rect.getY1() + h * 34 / 100;
		int ya = rect.getY1() + h * 46 / 100;
		int yl = rect.getY1() + h * 66 / 100;
		int cx = rect.getX1() + w / 2;
		// head, body, arm, left leg, right leg
		canvas.ellipse(rect.getX1() + xh, rect.getY1() + 1, rect.getX2() - xh, yh);
		canvas.polyline(new Point[] {new Point(cx, yh), new Point(cx, yl)});
		canvas.polyline(new Point[] {new Point(rect.getX1() + xa, ya), new Point(rect.getX2() - xa, ya)});
		canvas.polyline(new Point[] {new Point(cx, yl), new Point(rect.getX1(), rect.getY2() - 1)});
		canvas.polyline(new Point[] {new Point(cx, yl), new Point(rect.getX2(), rect.getY2() - 1)});
	}
	
	protected void drawNotationIcon(Canvas canvas, Rect rect, int ratioPercent) {
		int rr = rect.getRatioPercent();
		int ir = ratioPercent;
		int x, y, h, w;
		if (rr >= ir) {
			h = rect.getHeight();
			w = h * ir / 100;
			x = rect.getX1() + (rect.getX2() - rect.getX1() - w) / 2;
			y = rect.getY1();
		} else {
			w = rect.getWidth();
			h = w * 100 / ir;
			y = rect.getY1() + (rect.getY2() - rect.getY1() - h) / 2;
			x = rect.getX1();
		}
		drawActor(canvas, new Rect(x, y, x + w, y + h));
	}
	
	protected void drawAsCanonicalForm(Canvas canvas, boolean _showStereotype) {
		Point sz = getNameCompartmentSize(canvas, _showStereotype, showIcon, 
				showNamespace, showProperty, false);
		int icon_w = width;
		int icon_h = height - sz.getY();
		drawNotationIcon(canvas, new Rect(left, top, left + icon_w, top + icon_h), ACTOR_RATIO_PERCENT);
		drawNameCompartment(canvas, left, getRight(), top + icon_h, _showStereotype, 
				showIcon, showNamespace, showProperty, false);
	}

	protected void drawAsDecorationForm(Canvas canvas) {
		super.drawAsDecorationForm(canvas);
	}

	protected void drawAsIconicForm(Canvas canvas) {
		super.drawAsIconicForm(canvas);
	}
	
	protected void arrangeAsCanonicalForm(Canvas canvas, boolean _showStereotype) {
		int w = 0;
		int h = 0;
		w = Math.max(w, ACTOR_ICONMINWIDTH);
		h = Math.max(h, ACTOR_ICONMINHEIGHT);
		Point sz = getNameCompartmentSize(canvas, _showStereotype, showIcon, 
				showNamespace, showProperty, false);
		w = Math.max(w, sz.getX());
		h = h + sz.getY();
		minWidth = w;
		minHeight = h;
	}
	
	protected void arrangeAsDecorationForm(Canvas canvas) {
		super.arrangeAsDecorationForm(canvas);
	}

	protected void arrangeAsIconicForm(Canvas canvas) {
		super.arrangeAsIconicForm(canvas);
	}
}
