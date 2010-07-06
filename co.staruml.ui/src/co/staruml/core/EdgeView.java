package co.staruml.core;

import co.staruml.graphics.*;

public class EdgeView extends View {

	private static final int
			SELF_EDGE_HORIZ_INTERVAL = 30,
			SELF_EDGE_VERTI_INTERVAL = 20;	
	
	private Color BACKGROUND_COLOR = Color.WHITE;
	private View head, tail;
	private int lineMode;
	private int lineStyle;
	private Points points;
	private int headEndStyle, tailEndStyle;

	public EdgeView() {
		head = null; tail = null;
		lineMode = Const.LM_SOLID;
		lineStyle = Const.LS_OBLIQUE;
		points = new Points();
		headEndStyle = Const.ES_FLAT;
		tailEndStyle = Const.ES_FLAT;
	}
	
	public View getHead() {
		return head;
	}

	public void setHead(View head) {
		this.head = head;
	}

	public View getTail() {
		return tail;
	}

	public void setTail(View tail) {
		this.tail = tail;
	}

	public int getLineMode() {
		return lineMode;
	}

	public void setLineMode(int lineMode) {
		this.lineMode = lineMode;
	}

	public int getLineStyle() {
		return lineStyle;
	}

	public void setLineStyle(int lineStyle) {
		this.lineStyle = lineStyle;
	}
	
	public Points getPoints() {
		return points;
	}

	public int getHeadEndStyle() {
		return headEndStyle;
	}

	public void setHeadEndStyle(int headEndStyle) {
		this.headEndStyle = headEndStyle;
	}

	public int getTailEndStyle() {
		return tailEndStyle;
	}

	public void setTailEndStyle(int tailEndStyle) {
		this.tailEndStyle = tailEndStyle;
	}

	protected void reducePoints(Canvas canvas) {
		if (!(tail instanceof EdgeView)) {
			Rect b = tail.getBoundingBox(canvas);
			int i = 1;
			while (i < points.count() - 1) {
				if (Coord.ptInRect(points.getPoint(i), b)) {
					for (int j = 1; j <= i; j++)
						points.remove(1);
					i = 1;
				} else {
					i++;
				}
			}
		}
		if (!(head instanceof EdgeView)) {
			Rect b = head.getBoundingBox(canvas);
			int i = 1;
			while (i < points.count() - 1) {
				if (Coord.ptInRect(points.getPoint(i), b)) {
					for (int j = 1; j <= (points.count() - i - 1); j++)
						points.remove(i);
				} else {
					i++;
				}
			}
		}
	}
	
	protected void recalcOblique(Canvas canvas) {
		reducePoints(canvas);
		Rect tb, hb;
		int i;
		if (!(tail instanceof EdgeView)) {
			tb = tail.getBoundingBox(canvas);
		} else {
			Points tailPoints = ((EdgeView) tail).points;
			i = (tailPoints.count() - 1) / 2;
			tb = new Rect(tailPoints.getPoint(i).getX(), tailPoints.getPoint(i).getY(),
					tailPoints.getPoint(i+1).getX(), tailPoints.getPoint(i+1).getY());
		}
		points.setPoint(0, Coord.getCenter(tb));
		if (!(head instanceof EdgeView)) {
			hb = head.getBoundingBox(canvas);
		} else {
			Points headPoints = ((EdgeView) head).points;
			i = (headPoints.count() - 1) / 2;
			hb = new Rect(headPoints.getPoint(i).getX(), headPoints.getPoint(i).getY(),
					headPoints.getPoint(i+1).getX(), headPoints.getPoint(i+1).getY());
		}
		tb.expand(1); hb.expand(1); // to avoid overlapping edge head with boundary of node 
		points.setPoint(points.count() - 1, Coord.getCenter(hb));
		if (!(tail instanceof EdgeView))
			points.setPoint(0, 
					Coord.junction(tb, points.getPoint(1)));
		if (!(head instanceof EdgeView))
			points.setPoint(points.count() - 1, 
					Coord.junction(hb, points.getPoint(points.count() - 2)));
	}
	
	protected void recalcRectilinear(Canvas canvas) {
		if (head == tail) {
			if (points.count() <= 3) {
				points.clear();
				Rect bb = head.getBoundingBox(canvas);
				int w = bb.getX2() - bb.getX1();
				int h = bb.getY2() - bb.getY1();
				points.add(Coord.getCenter(bb));
				points.add(new Point(
						points.getPoint(0).getX(),
						points.getPoint(0).getY() - (h / 2) - SELF_EDGE_VERTI_INTERVAL));
				points.add(new Point(
						points.getPoint(0).getX() + (w / 2) + SELF_EDGE_HORIZ_INTERVAL,
						points.getPoint(0).getY() - (h / 2) - SELF_EDGE_VERTI_INTERVAL));
				points.add(new Point(
						points.getPoint(0).getX() + (w / 2) + SELF_EDGE_HORIZ_INTERVAL,
						points.getPoint(0).getY()));
				points.add(Coord.getCenter(bb));
			}
		}
		// Estimate bounding coordinates of HeadView and TailView
		Rect bt, bh;
		int i;
		if (!(tail instanceof EdgeView)) {
			bt = tail.getBoundingBox(canvas);
		} else {
			Points tps = ((EdgeView) tail).points;
			i = (tps.count() - 1) / 2;
			bt = new Rect(tps.getPoint(i), tps.getPoint(i+1));
			bt.setRect(Coord.getCenter(bt), Coord.getCenter(bt));
		}
		if (!(head instanceof EdgeView)) {
			bh = head.getBoundingBox(canvas);
		} else {
			Points hps = ((EdgeView) head).points;
			i = (hps.count() - 1) / 2;
			bh = new Rect(hps.getPoint(i), hps.getPoint(i+1));
			bh.setRect(Coord.getCenter(bh), Coord.getCenter(bh));
		}
		bt.expand(1); bh.expand(1); // to avoid overlapping edge head with boundary of node
		
	    // Add new point, if have not enough points.
		Point p;
		if (points.count() == 2) {
			p = Coord.orthoJunction(bt, points.getPoint(1));
			if ((p.getX() == -100) && (p.getY() == -100))
				points.insert(0, Coord.orthoJunction(bt, points.getPoint(0)));
			else
				points.setPoint(0, p);
			p = Coord.orthoJunction(bh, points.getPoint(points.count() - 2));
			if ((p.getX() == -100) && (p.getY() == -100))
				points.add(Coord.orthoJunction(bh, points.getPoint(points.count() - 1)));
			else
				points.setPoint(points.count() - 1, p);
		}
		
	    // Replace 0-indexed point with junction point to TailView
		p = Coord.orthoJunction(bt, points.getPoint(1));
		if ((p.getX() == -100) && (p.getY() == -100)) {
			if (points.getPoint(1).getY() == points.getPoint(2).getY())
				points.setPoint(1, 
						new Point(Coord.getCenter(bt).getX(), points.getPoint(1).getY()));
			else
				points.setPoint(1, 
						new Point(points.getPoint(1).getX(), Coord.getCenter(bt).getY()));
		}
		points.setPoint(0, Coord.orthoJunction(bt, points.getPoint(1)));
		
	    // Replace highest-indexed point with junction point to HeadView
		p = Coord.orthoJunction(bh, points.getPoint(points.count() - 2));
		if ((p.getX() == -100) && (p.getY() == -100)) {
			if (points.getPoint(points.count() - 2).getY() == points.getPoint(points.count() - 3).getY())
				points.setPoint(points.count() - 2, 
						new Point(Coord.getCenter(bh).getX(), points.getPoint(points.count() - 2).getY()));
			else
				points.setPoint(points.count() - 2, 
						new Point(points.getPoint(points.count() - 2).getX(), Coord.getCenter(bh).getY()));
		}
		points.setPoint(points.count() - 1, Coord.orthoJunction(bh, points.getPoint(points.count() - 2)));
		
	    // Must be removed, and calculate this in another module (Handlers)
	    // FitToGrid(GraphicClasses.GridFactor(5, 5));
		points.reduceOrthoLine();
		reducePoints(canvas);
		
		p = new Point(points.getPoint(0));
		points.setPoint(0, Coord.orthoJunction(bt, points.getPoint(1)));
		if ((points.getPoint(0).getX() == -100) || (points.getPoint(0).getY() == -100))
			points.setPoint(0, p);
		
		p = new Point(points.getPoint(points.count() - 1));
		points.setPoint(points.count() - 1, Coord.orthoJunction(bh, points.getPoint(points.count() - 2)));
		if ((points.getPoint(points.count() - 1).getX() == -100) || (points.getPoint(points.count() - 1).getY() == -100))
			points.setPoint(points.count() - 1, p);
	}

	protected void drawLineEnd(Canvas canvas, int edgeEndStyle, boolean isHead) {
		if (edgeEndStyle != Const.ES_FLAT) {
			Rect rt = new Rect();
			if (isHead) {
				rt.setRect(points.getPoint(points.count() - 1).getX(),
						points.getPoint(points.count() - 1).getY(), 
						points.getPoint(points.count() - 2).getX(),
						points.getPoint(points.count() - 2).getY());
			} else {
				rt.setRect(points.getPoint(0).getX(),
						points.getPoint(0).getY(), 
						points.getPoint(1).getX(),
						points.getPoint(1).getY());
			}
			double a = (double) rt.getY2() - rt.getY1();
			double b = (double) rt.getX2() - rt.getX1();
			double th = Math.atan(a / b);
			if (((a < 0) && (b < 0)) || ((a > 0) && (b < 0)) || ((a == 0) && (b < 0)))
				th = th + 3.141592d;
			double th1 = th - 3.141592d / 8;
			double th2 = th + 3.141592d / 8;
			
			/*
			Point p0 = new Point(rt.getX1(), rt.getY1());
			Point p1 = new Point(
					(int) Math.floor(c1 * Math.cos(th1)) + rt.getX1(), 
					(int) Math.floor(c1 * Math.sin(th1)) + rt.getY1());
			Point p2 = new Point(
					(int) Math.floor(c1 * Math.cos(th2)) + rt.getX1(), 
					(int) Math.floor(c1 * Math.sin(th2)) + rt.getY1());
			Point p3 = new Point(
					(int) Math.floor(c2 * Math.cos(th)) + rt.getX1(), 
					(int) Math.floor(c2 * Math.sin(th)) + rt.getY1());
			Point p4 = new Point(
					(int) Math.floor(c2 * Math.cos(th1)) + rt.getX1(), 
					(int) Math.floor(c2 * Math.sin(th1)) + rt.getY1());
			Point p5 = new Point(
					(int) Math.floor(c2 * Math.cos(th2)) + rt.getX1(), 
					(int) Math.floor(c2 * Math.sin(th2)) + rt.getY1());
			Point p6 = new Point(
					(int) Math.floor(c1 * Math.cos(th1)) + p3.getX(), 
					(int) Math.floor(c1 * Math.sin(th1)) + p3.getY());
			Point p7 = new Point(
					(int) Math.floor(c1 * Math.cos(th2)) + p3.getX(), 
					(int) Math.floor(c1 * Math.sin(th2)) + p3.getY());
			*/
			int c1 = 11, c2 = c1 * 2;
			Point p0 = new Point(rt.getX1(), rt.getY1());
			Point p1 = new Point(
					(int) Math.round(c1 * Math.cos(th1)) + rt.getX1(), 
					(int) Math.round(c1 * Math.sin(th1)) + rt.getY1());
			Point p2 = new Point(
					(int) Math.round(c1 * Math.cos(th2)) + rt.getX1(), 
					(int) Math.round(c1 * Math.sin(th2)) + rt.getY1());
			Point p3 = new Point(
					(int) Math.round(c2 * Math.cos(th)) + rt.getX1(), 
					(int) Math.round(c2 * Math.sin(th)) + rt.getY1());
			Point p4 = new Point(
					(int) Math.round(c2 * Math.cos(th1)) + rt.getX1(), 
					(int) Math.round(c2 * Math.sin(th1)) + rt.getY1());
			Point p5 = new Point(
					(int) Math.round(c2 * Math.cos(th2)) + rt.getX1(), 
					(int) Math.round(c2 * Math.sin(th2)) + rt.getY1());
			Point p6 = new Point(
					(int) Math.round(c1 * Math.cos(th1)) + p3.getX(), 
					(int) Math.round(c1 * Math.sin(th1)) + p3.getY());
			Point p7 = new Point(
					(int) Math.round(c1 * Math.cos(th2)) + p3.getX(), 
					(int) Math.round(c1 * Math.sin(th2)) + p3.getY());
			
			canvas.setColor(lineColor);
			canvas.setFillColor(Color.WHITE);
			canvas.setLineStyle(Canvas.LS_SOLID);
			switch (edgeEndStyle) {
			case Const.ES_STICK_ARROW:
				canvas.polyline(new Point[] {p1, p0, p2});
				break;
			case Const.ES_SOLID_ARROW:
				canvas.setFillColor(lineColor);
				canvas.fillPolygon(new Point[] {p1, p0, p2});
				canvas.polygon(new Point[] {p1, p0, p2});
				break;
			case Const.ES_TRIANGLE:
				canvas.fillPolygon(new Point[] {p4, p0, p5});
				canvas.polygon(new Point[] {p4, p0, p5});
				break;
			case Const.ES_FILLED_TRIANGLE:
				canvas.setFillColor(lineColor);
				canvas.fillPolygon(new Point[] {p4, p0, p5});
				break;
			case Const.ES_DIAMOND:
				canvas.fillPolygon(new Point[] {p1, p0, p2, p3});
				canvas.polygon(new Point[] {p1, p0, p2, p3});
				break;
			case Const.ES_FILLED_DIAMOND:
				canvas.setFillColor(lineColor);
				canvas.fillPolygon(new Point[] {p1, p0, p2, p3});
				canvas.polygon(new Point[] {p1, p0, p2, p3});
				break;
			case Const.ES_ARROW_DIAMOND:
				canvas.fillPolygon(new Point[] {p1, p0, p2, p3});
				canvas.polygon(new Point[] {p1, p0, p2, p3});
				canvas.polyline(new Point[] {p6, p3, p7});
				break;
			case Const.ES_ARROW_FILLED_DIAMOND:
				canvas.setFillColor(lineColor);
				canvas.fillPolygon(new Point[] {p1, p0, p2, p3});
				canvas.polygon(new Point[] {p1, p0, p2, p3});
				canvas.polyline(new Point[] {p6, p3, p7});
			}
		}
	}

	protected void arrangeObject(Canvas canvas) {
		if (head == tail)
			lineStyle = Const.LS_RECTILINEAR;
		if (lineStyle == Const.LS_OBLIQUE)
			recalcOblique(canvas);
		else
			recalcRectilinear(canvas);
	}

	protected void drawObject(Canvas canvas) {
		assignStyleToCanvas(canvas);
		if (lineMode == Const.LM_SOLID)
			canvas.setLineStyle(Canvas.LS_SOLID);
		else
			canvas.setLineStyle(Canvas.LS_DOT);
		canvas.setFillColor(BACKGROUND_COLOR);
		canvas.polyline(points.toArray());
		canvas.setLineStyle(Canvas.LS_SOLID);
		drawLineEnd(canvas, headEndStyle, true);
		drawLineEnd(canvas, tailEndStyle, false);
	}

	protected void drawSelection(Canvas canvas) {
		for (int i = 0; i < points.count(); i++)
			Toolkit.drawHighlighter(canvas, 
					points.getPoint(i).getX(), 
					points.getPoint(i).getY(), 
					Toolkit.DEFAULT_HALF_HIGHLIGHTER_SIZE, true, 
					Toolkit.SELECTION_COLOR);
	}

	protected void movePosition(Canvas canvas, int dx, int dy) {
		for (int i = 0; i < points.count(); i++) {
			Point p = points.getPoint(i);
			p.setPoint(p.getX() + dx, p.getY() + dy);
		}
	}
	
	public void initialize(Canvas canvas, int x1, int y1, int x2, int y2) {
		points.clear();
		points.add(Coord.junction(tail.getBoundingBox(canvas), 
				Coord.getCenter(head.getBoundingBox(canvas))));
		points.add(Coord.junction(head.getBoundingBox(canvas),
				Coord.getCenter(tail.getBoundingBox(canvas))));
		if (lineStyle == Const.LS_RECTILINEAR)
			points.convObliqueToRectilinear();
	}
	
	public void recalcPoints(Canvas canvas) {
		if (lineStyle == Const.LS_OBLIQUE)
			recalcOblique(canvas);
		else
			recalcRectilinear(canvas);
	}
	
	public Rect getBoundingBox(Canvas canvas) {
		Rect r = points.getBoundingRect(); 
		for (int i = 0; i < subViews.size(); i++) {
			if (subViews.elementAt(i).isVisible())
				r.setRect(Coord.unionRect(r, 
						subViews.elementAt(i).getBoundingBox(canvas)));
		}
		return r;
	}
	
	public boolean containsPoint(Canvas canvas, int x, int y) {
		if (containedIndex(canvas, new Point(x, y)) > -1)
			return true;
		return false;
	}
	
	private double disToPoint(Point p1, Point p2) {
		return Math.sqrt(Coord.sqr(p1.getX() - p2.getX()) + Coord.sqr(p1.getY() - p2.getY()));
	}
	
	private double disToOrthoLine(Point lh, Point lt, Point p) {
		Point l1 = new Point();
		Point l2 = new Point();
		if (lh.getY() == lt.getY()) {
			// horizontal line
			if (lh.getX() > lt.getX()) {
				l1.setPoint(lt);
				l2.setPoint(lh);
			} else {
				l1.setPoint(lh);
				l2.setPoint(lt);
			}
			if (p.getX() > l2.getX()) {
				return disToPoint(p, l2);
			} else if (p.getX() < l1.getX()) {
				return disToPoint(p, l1);
			} else {
				return Math.abs(p.getY() - l1.getY());
			}
		} else {
			// vertical line (i.e. LH.X = LT.X)
			if (lh.getY() > lt.getY()) {
				l1.setPoint(lt);
				l2.setPoint(lh);
			} else {
				l1.setPoint(lh);
				l2.setPoint(lt);
			}
			if (p.getY() > l2.getY()) {
				return disToPoint(p, l2); 
			} else if (p.getY() < l1.getY()) {
				return disToPoint(p, l1);
			} else {
				return Math.abs(p.getX() - l1.getX());
			}
		}
	}
	
	public int containedIndex(Canvas canvas, Point p) {
		int result = -1;
		Point pt = new Point();
		Point ph = new Point();
		if (lineStyle == Const.LS_RECTILINEAR) {
			int RECOG_MIN_DIS = 5;
			double minDis = RECOG_MIN_DIS;
			int minDisIndex = -1;
			for (int i = 0; i <= points.count() - 2; i++) {
				pt.setPoint(points.getPoint(i));
				ph.setPoint(points.getPoint(i + 1));
				double d = disToOrthoLine(ph, pt, p);
				if (d <= minDis) {
					minDis = d;
					minDisIndex = i;
				}
			}
			result = minDisIndex;
		} else { // Oblique
			result = -1;
			for (int i = 0; i <= points.count() - 2; i++) {
				pt.setPoint(points.getPoint(i));
				ph.setPoint(points.getPoint(i + 1));
				if (Coord.ptInLine(new Rect(pt, ph), p))
					result = i;
			}
		}
		return result;
	}
	
	public int selectedPoint(Canvas canvas, Point p) {
		int result = -1;
		for (int i = 0; i < points.count(); i++)
			if (Coord.equalPt(points.getPoint(i), p))
				result = i;
		return result;
	}
}
