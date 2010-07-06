package co.staruml.awt;

import java.io.IOException;
import java.util.Hashtable;

import co.staruml.graphics.*;


public class ImageManagerAWT extends ImageManager {

	private Hashtable<String, Image> imageTable; 

	public ImageManagerAWT() {
		imageTable = new Hashtable<String, Image>();
	}
	
	public void addImageFromResource(String name, String resourcePath) {
		try {
			Image image = new ImageAWT(getClass().getResource(resourcePath));
			imageTable.put(name, image);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Image getImage(String name) {
		return imageTable.get(name);
	}

}
