package co.staruml.graphics;

import java.util.*;

public class Points {

	private Vector<Point> points;
	
	public Points() {
		points = new Vector<Point>();
	}
	
	public void clear() {
		points.clear();
	}
	
	public void assign(Points pts) {
		points.clear();
		for (int i = 0; i < pts.count(); i++)
			points.add(new Point(pts.getPoint(i)));
	}
	
	public void add(Point p) {
		points.add(p);
	}
	
	public void insert(int index, Point p) {
		points.insertElementAt(p, index);
	}
	
	public void remove(int index) {
		points.remove(index);
	}

	public void setPoint(int index, Point p) {
		points.set(index, p);
	}
	
	public void setPoint(int index, int x, int y) {
		points.elementAt(index).setPoint(x, y);
	}
	
	public Point getPoint(int index) {
		return points.elementAt(index);
	}
	
	public int[] getXPoints() {
		int[] xs = new int[points.size()];
		for (int i = 0; i < points.size(); i++)
			xs[i] = points.elementAt(i).getX();
		return xs;
	}
	
	public int[] getYPoints() {
		int[] ys = new int[points.size()];
		for (int i = 0; i < points.size(); i++)
			ys[i] = points.elementAt(i).getY();
		return ys;
	}
	
	public int count() {
		return points.size();
	}
	
	public Point[] toArray() {
		return points.toArray(new Point[0]);
	}
	
	public void reduceOrthoLine() {
		int i = 0;
		while (i < points.size() - 2) {
			Point p1 = new Point(getPoint(i));
			Point p2 = new Point(getPoint(i + 1));
			Point p3 = new Point(getPoint(i + 2));
			if ((p1.getX() == p2.getX()) && (p1.getY() == p2.getY())) {
				remove(i);
			} else if (((p1.getX() == p2.getX()) && (p2.getX() == p3.getX())) 
					|| ((p1.getY() == p2.getY()) && (p2.getY() == p3.getY()))) {
				remove(i + 1);
			} else {
				i++;
			}
		}
	}
	
	public void reduceLine() {
		int i = 0;
		while (i < (points.size() - 2)) {
			Point p1 = new Point(getPoint(i));
			Point p2 = new Point(getPoint(i + 1));
			Point p3 = new Point(getPoint(i + 2));
			if (Coord.equalPt(p1, p2))
				remove(i);
			else if (Coord.ptsInLine(p1, p2, p3))
				remove(i + 1);
			else
				i++;
		}
	}
	
	public void convObliqueToRectilinear() {
		int i = 0;
		while (i < count() - 1) {
			insert(i + 1, Coord.makeOrthoPt(getPoint(i), getPoint(i + 1)));
			i = i + 2;
		}
	}
	
	public Rect getBoundingRect() {
		Rect r = new Rect(getPoint(0), getPoint(0));
		for (int i = 1; i < count(); i++) {
			r.setRect(Coord.unionRect(r, 
					new Rect(getPoint(i).getX(), getPoint(i).getY(),
							getPoint(i).getX() + 1, getPoint(i).getY() + 1)));
		}
		return r;
	}
	
}
