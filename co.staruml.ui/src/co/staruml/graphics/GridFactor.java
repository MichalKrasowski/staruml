package co.staruml.graphics;

public class GridFactor {

	public static final GridFactor NO_GRID = new GridFactor(1, 1);
	private int width;
	private int height;
	
	public GridFactor(int width, int height) {
		setGridFactor(width, height);
	}
	
	public void setGridFactor(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
}
