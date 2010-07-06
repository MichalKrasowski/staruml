package co.staruml.graphics;

public class Coord {
	
	public static int valueTranform(ZoomFactor zf, int value) {
		double f = ((double) zf.getNumer()) / zf.getDenom();
		return (int) Math.round(f * value);
	}
	
	public static void coordTransform(ZoomFactor zf, GridFactor gf, Point p) {
		int x = p.getX();
		int y = p.getY();
		// fit to grid
		x = x - (x % gf.getWidth());
		y = y - (y % gf.getHeight());
		// zoom
		double f = ((double) zf.getNumer()) / zf.getDenom();
		x = (int) Math.round(f * x);
		y = (int) Math.round(f * y);
		p.setPoint(x, y);
	}
	
	public static void coordTransform(ZoomFactor zf, GridFactor gf, Rect r) {
		Point p1 = new Point(r.getX1(), r.getY1());
		Point p2 = new Point(r.getX2(), r.getY2());
		coordTransform(zf, gf, p1);
		coordTransform(zf, gf, p2);
		r.setRect(p1.getX(), p1.getY(), p2.getX(), p2.getY());
	}
	
	public static void coordRevTransform(ZoomFactor zf, GridFactor gf, Point p) {
		int x = p.getX();
		int y = p.getY();
		// zoom
		double f = ((double) zf.getNumer()) / zf.getDenom();
		x = (int) Math.round(x / f);
		y = (int) Math.round(y / f);
		// fit to grid
		x = x - (x % gf.getWidth());
		y = y - (y % gf.getHeight());
		p.setPoint(x, y);
	}
	
	public static double sqr(double value) {
		return (value * value);
	}
	
	public static boolean ptInRect(int x, int y, Rect rect) {
		normalizeRect(rect);
		boolean b = ((rect.getX1() <= x) && (x <= rect.getX2()))
				&& ((rect.getY1() <= y) && (y <= rect.getY2()));
		return b;
	}
	
	public static boolean ptInRect(Point p, Rect rect) {
		return ptInRect(p.getX(), p.getY(), rect);
	}
	
	public static boolean ptInLine(Rect line, Point p) {
		boolean result = false;
		double left = Math.min(line.getX1(), line.getX2()) - 5;
		double right = Math.max(line.getX1(), line.getX2()) + 5;
		double top = Math.min(line.getY1(), line.getY2()) - 5;
		double bottom = Math.max(line.getY1(), line.getY2()) + 5;
		if ((left <= p.getX()) && (right >= p.getX()) 
				&& (top <= p.getY()) && (bottom >= p.getY())) {
			double a = line.getX2() - line.getX1();
			double b = line.getY2() - line.getY1();
			double r = Math.sqrt(a * a + b * b + 0.000001);
			double c = b / r;
			double s = a / r;
			double ox = p.getX() - line.getX1();
			double oy = p.getY() - line.getY1();
			double tx = c * ox - s * oy;
			double ty = s * ox + c * oy;
			double x1 = -5;
			double x2 = 5;
			double y1 = -5;
			double y2 = r + 5;
			if ((x1 <= tx) && (x2 >= tx) && (y1 <= ty) && (y2 >= ty))
				result = true;
			else
				result = false;
		}
		return result;
	}
	
	public static boolean ptsInLine(Point p1, Point p2, Point p3) {
		if (ptInLine(new Rect(p1, p3), p2) 
				|| ptInLine(new Rect(p1, p2), p3) 
				|| ptInLine(new Rect(p2, p3), p1))
			return true;
		else
			return false;
	}
	
	public static boolean rectInRect(Rect rect1, Rect rect2) {
		java.awt.Rectangle r1 = rect1.getRectangle();
		java.awt.Rectangle r2 = rect2.getRectangle();
		return r1.intersects(r2);
	}
	
	public static Point getCenter(Rect rect) {
		return new Point((rect.getX1() + rect.getX2()) / 2,
				(rect.getY1() + rect.getY2()) / 2);
	}
	
	public static boolean equalRect(Rect r1, Rect r2) {
		return ((r1.getX1() == r2.getX1()) 
				&& (r1.getY1() == r2.getY1()) 
				&& (r1.getX2() == r2.getX2()) 
				&& (r1.getY2() == r2.getY2()));
	}
	
	public static boolean equalPt(Point p1, Point p2) {
		return equalPt(p1, p2, 5);
	}
	
	public static boolean equalPt(Point p1, Point p2, int d) {
		return ptInRect(p2.getX(), p2.getY(), 
				new Rect(p1.getX() - d, p1.getY() - d, p1.getX() + d, p1.getY() + d));
	}
	
	public static void normalizeRect(Rect rect) {
		int x1, y1, x2, y2;
		if (rect.getX1() < rect.getX2()) {
			x1 = rect.getX1();
			x2 = rect.getX2();
		} else {
			x1 = rect.getX2();
			x2 = rect.getX1();
		}
		if (rect.getY1() < rect.getY2()) {
			y1 = rect.getY1();
			y2 = rect.getY2();
		} else {
			y1 = rect.getY2();
			y2 = rect.getY1();
		}
		rect.setRect(x1, y1, x2, y2);
	}
	
	public static void normalizeRect(Point p1, Point p2) {
		Rect r = new Rect(p1, p2);
		normalizeRect(r);
		p1.setPoint(r.getX1(), r.getY1());
		p2.setPoint(r.getX2(), r.getY2());
	}
	
	public static Rect unionRect(Rect r1, Rect r2) {
		Rect r = new Rect(r1);
		if (r2.getX1() < r.getX1()) r.setX1(r2.getX1());
		if (r2.getY1() < r.getY1()) r.setY1(r2.getY1());
		if (r2.getX2() > r.getX2()) r.setX2(r2.getX2());
		if (r2.getY2() > r.getY2()) r.setY2(r2.getY2());
		return r;
	}
	
	public static Point junction(Rect r, Point pt) {
		Point p = new Point(pt);
		Point c = new Point((r.getX1() + r.getX2()) / 2, 
				(r.getY1() + r.getY2()) / 2);
		if ((c.getX() == p.getX()) || (c.getY() == p.getY()))
			return orthoJunction(r, p);
		double lean = ((double) (p.getY() - c.getY())) / (p.getX() - c.getX());
		Point[] ps = new Point[5]; // simulate array[1..4]. (ps[0] will not be used)
		ps[1] = new Point(r.getX1(), 
				(int) Math.round(lean * (r.getX1() - c.getX()) + c.getY()));
		ps[2] = new Point(r.getX2(),
				(int) Math.round(lean * (r.getX2() - c.getX()) + c.getY()));
		ps[3] = new Point(
				(int) Math.round((r.getY1() - c.getY()) / lean + c.getX()),	r.getY1());
		ps[4] = new Point(
				(int) Math.round((r.getY2() - c.getY()) / lean + c.getX()), r.getY2());
		normalizeRect(c, p);
		int i = 0;
		do {
			i++;
			if (i > 4) break;
		} while (!(((r.getX1() <= ps[i].getX()) && (ps[i].getX() <= r.getX2())
				&& (r.getY1() <= ps[i].getY()) && (ps[i].getY() <= r.getY2()) 
				&& (c.getX() <= ps[i].getX()) && (ps[i].getX() <= p.getX()) 
				&& (c.getY() <= ps[i].getY()) && (ps[i].getY() <= p.getY())) 
				|| (i > 4)));
		if (i > 4) {
			return new Point((r.getX1() + r.getX2()) / 2, (r.getY1() + r.getY2()) / 2);
		} else {
			return ps[i];
		}
	}
	
	public static Point orthoJunction(Rect r, Point p) {
		if ((r.getX1() < p.getX()) && (p.getX() < r.getX2())) {
			if (r.getY1() >= p.getY())
				return new Point(p.getX(), r.getY1());
			else
				return new Point(p.getX(), r.getY2());
		} else if ((r.getY1() < p.getY()) && (p.getY() < r.getY2())) {
			if (r.getX1() >= p.getX())
				return new Point(r.getX1(), p.getY());
			else
				return new Point(r.getX2(), p.getY());
		} else if ((r.getX1() == p.getX()) || (r.getX2() == p.getX())) {
			if (r.getY1() >= p.getY())
				return new Point(p.getX(), r.getY1());
			else
				return new Point(p.getX(), r.getY2());
		} else if ((r.getY1() == p.getX()) || (r.getY2() == p.getY())) {
			if (r.getX1() >= p.getX())
				return new Point(r.getX1(), p.getY());
			else
				return new Point(r.getX2(), p.getY());
		} else {
			return new Point(-100, -100);
		}
	}
	
	public static Point makeOrthoPt(Point p1, Point p2) {
		Point result = new Point(p1.getX(), Math.max(p1.getY(), p2.getY()));
		if (result.getY() == p1.getY())
			result.setX(p2.getX());
		return result;
	}
	
}
