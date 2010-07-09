package co.staruml.graphics;

public class Color {
	
	public static final Color BLACK = new Color(0, 0, 0);
	public static final Color WHITE = new Color(255, 255, 255);
	public static final Color DARK_GRAY = new Color(64, 64, 64);
	public static final Color GRAY = new Color(128, 128, 128);
	public static final Color LIGHT_GRAY = new Color(192, 192, 192);
	public static final Color RED = new Color(255, 0, 0);
	public static final Color GREEN = new Color(0, 255, 0);
	public static final Color BLUE = new Color(0, 0, 255);
	public static final Color CYAN = new Color(0, 255, 255);
	public static final Color MAGENTA = new Color(255, 0, 255);
	public static final Color ORANGE = new Color(255, 200, 0);
	public static final Color PINK = new Color(255, 175, 175);
	public static final Color YELLOW = new Color(255, 255, 0);

	
	private int red;
	private int green;
	private int blue;

	public Color(int red, int green, int blue) {
		this.red = red;
		this.green = green;
		this.blue = blue;
	}
	
	public int getRed() {
		return red;
	}
	
	public int getGreen() {
		return green;
	}
	
	public int getBlue() {
		return blue;
	}
	
	public static void main(String[] args) {
		java.awt.Color c = java.awt.Color.LIGHT_GRAY;
	}
}
