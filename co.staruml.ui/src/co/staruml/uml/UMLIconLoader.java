package co.staruml.uml;

import co.staruml.graphics.*;

public class UMLIconLoader {

	public static void loadIcons(ImageManager imageManager) {
		imageManager.addImageFromResource(UML.ICON_CLASS, "/icon/class.gif");
		imageManager.addImageFromResource(UML.ICON_ATTRIBUTE_PUBLIC, "/icon/attribute-public.gif");
		imageManager.addImageFromResource(UML.ICON_OPERATION_PUBLIC, "/icon/operation-public.gif");
	}
	
}
