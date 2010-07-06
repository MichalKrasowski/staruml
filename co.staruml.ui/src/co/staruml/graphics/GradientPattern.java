package co.staruml.graphics;

public class GradientPattern extends Pattern {
	
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private Color color1;
	private Color color2;
	
	public GradientPattern(int x1, int y1, int x2, int y2, Color c1, Color c2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.color1 = c1;
		this.color2 = c2;
	}

	public int getX1() {
		return x1;
	}

	public int getY1() {
		return y1;
	}

	public int getX2() {
		return x2;
	}

	public int getY2() {
		return y2;
	}

	public Color getColor1() {
		return color1;
	}

	public Color getColor2() {
		return color2;
	}
	
	
}
