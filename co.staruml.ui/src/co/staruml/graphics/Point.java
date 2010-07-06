package co.staruml.graphics;

public class Point {
	
	private int x;
	private int y;
	
	public Point() {
		this.x = 0;
		this.y = 0;
	}
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Point(Point p) {
		this.x = p.getX();
		this.y = p.getY();
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void setPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void setPoint(Point p) {
		this.x = p.getX();
		this.y = p.getY();
	}
	
	public void add(int x, int y) {
		this.x = this.x + x;
		this.y = this.y + y;
	}
	
	public void add(Point p) {
		add(p.getX(), p.getY());
	}
	
	public String toString() {
		return "[" + x + ","+ y + "]";
	}
}
