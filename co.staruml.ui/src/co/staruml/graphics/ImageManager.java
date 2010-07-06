package co.staruml.graphics;

public abstract class ImageManager {

	public abstract Image getImage(String name);
	public abstract void addImageFromResource(String name, String resourcePath);

}
