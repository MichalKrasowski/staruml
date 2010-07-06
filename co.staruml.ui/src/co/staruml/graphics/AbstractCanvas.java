package co.staruml.graphics;

public abstract class AbstractCanvas implements Canvas {

	protected ImageManager imageManager;
	protected Point origin;
	protected ZoomFactor zoomFactor;
	protected GridFactor gridFactor;
	protected boolean coordTransformApplied;
	
	public AbstractCanvas() {
		origin = new Point(0, 0);
		zoomFactor = new ZoomFactor(1, 1);
		gridFactor = new GridFactor(1, 1);
		coordTransformApplied = true;
	}
	
	public ImageManager getImageManager() {
		return imageManager;
	}
	
	public void setImageManager(ImageManager imageManager) {
		this.imageManager = imageManager;
	}

	public Point getOrigin() {
		return origin;
	}
	
	public void setOrigin(Point origin) {
		this.origin = origin;
	}

	public ZoomFactor getZoomFactor() {
		return zoomFactor;
	}

	public void setZoomFactor(ZoomFactor zoomFactor) {
		this.zoomFactor = zoomFactor;
	}
	
	public GridFactor getGridFactor() {
		return gridFactor;
	}

	public void setGridFactor(GridFactor gridFactor) {
		this.gridFactor = gridFactor;
	}
	
	public boolean isCoordTransformApplied() {
		return coordTransformApplied;
	}
	
	public void setCoordTransformApplied(boolean value) {
		coordTransformApplied = value;
	}
	
	public void drawImage(int x, int y, String imageName) {
		if (imageManager != null)
			drawImage(x, y, imageManager.getImage(imageName));
	}

	
}
