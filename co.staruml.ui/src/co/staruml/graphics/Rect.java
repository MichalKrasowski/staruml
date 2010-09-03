package co.staruml.graphics;

public class Rect {
	private int x1;
	private int y1;
	private int x2;
	private int y2;

	public Rect() {
		setRect(0, 0, 0, 0);
	}
	
	public Rect(int x1, int y1, int x2, int y2) {
		setRect(x1, y1, x2, y2);
	}
	
	public Rect(Point p1, Point p2) {
		setRect(p1.getX(), p1.getY(), p2.getX(), p2.getY());
	}
	
	public Rect(Rect r) {
		setRect(r.getX1(), r.getY1(), r.getX2(), r.getY2());
	}
	
	public int getX1() {
		return x1;
	}
	
	public void setX1(int value) {
		x1 = value;
	}
	
	public int getY1() {
		return y1;
	}

	public void setY1(int value) {
		y1 = value;
	}

	public int getX2() {
		return x2;
	}
	
	public void setX2(int value) {
		x2 = value;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int value) {
		y2 = value;
	}
	
	public int getWidth() {
		return Math.abs(x2 - x1);
	}
	
	public int getHeight() {
		return Math.abs(y2 - y1);
	}
	
	public int getRatioPercent() {
		return (getWidth() * 100) / getHeight();
	}
	
	public void setRect(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
	
	public void setRect(Point p1, Point p2) {
		this.x1 = p1.getX();
		this.y1 = p1.getY();
		this.x2 = p2.getX();
		this.y2 = p2.getY();
	}
	
	public void setRect(Rect r) {
		this.x1 = r.getX1();
		this.y1 = r.getY1();
		this.x2 = r.getX2();
		this.y2 = r.getY2();
	}
	
	public void add(int x, int y) {
		this.x1 = this.x1 + x;
		this.x2 = this.x2 + x;
		this.y1 = this.y1 + y;
		this.y2 = this.y2 + y;
	}
	
	public void add(Point p) {
		add(p.getX(), p.getY());
	}
	
	public void expand(int delta) {
		this.x1 = this.x1 - delta;
		this.y1 = this.y1 - delta;
		this.x2 = this.x2 + delta;
		this.y2 = this.y2 + delta;
	}
	
	public java.awt.Rectangle getRectangle() {
		int x = (x1 < x2) ? x1 : x2;
		int y = (y1 < y2) ? y1 : y2;
		int width = Math.abs(x2 - x1);
		int height = Math.abs(y2 - y1);
		return new java.awt.Rectangle(x, y, width, height);
	}
	
	public String toString() {
		return "[" + x1 + "," + y1 + "," + x2 + "," + y2 + "]";
	}
	
	public boolean isContain(int x,int y){
		boolean flag = false;
		if(x1<=x && x2>=x && y1<=y && y2>=y){
			flag = true;
		}
		return flag;
	}
}
