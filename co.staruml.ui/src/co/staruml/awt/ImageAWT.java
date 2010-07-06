package co.staruml.awt;

import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

import co.staruml.graphics.*;


public class ImageAWT extends Image {

	private java.awt.Image image;
	
	public ImageAWT(URL url) throws IOException {
		image = ImageIO.read(url);
	}
	
	public java.awt.Image getImage() {
		return image;
	}
	
	public int getWidth() {
		return image.getWidth(null);
	}

	public int getHeight() {
		return image.getHeight(null);
	}

}
