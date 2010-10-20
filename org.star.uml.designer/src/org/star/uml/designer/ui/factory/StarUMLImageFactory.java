package org.star.uml.designer.ui.factory;

import java.net.URL;

import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;

public class StarUMLImageFactory {
	
	public static URL getImageURL(String actionID){
		Bundle bundle = Platform.getBundle("org.star.uml.designer");
		if(actionID.equals("Actor")){
			return bundle.getEntry("icons/16.gif");
		}
		return null;
	}
}
