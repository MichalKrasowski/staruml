package org.star.uml.designer.ui.factory;

import org.eclipse.swt.graphics.Image;
import org.star.uml.designer.Activator;
import org.star.uml.designer.base.constance.GlobalConstants;
import org.star.uml.designer.ui.diagram.action.ActorCreateAction;
import org.star.uml.designer.ui.diagram.action.UsecaseDiagramCreateAction;

public class StarUMLImageCreateFactory {
	
	public static Image getImage(String category,String extension){
		if(category.equals(GlobalConstants.StarMoedl.STAR_CATEGORY_DIAGRAM)){
			if(extension.equals(UsecaseDiagramCreateAction.DIAGRAM_EXTENSION) ){
				return Activator.getImageDescriptor(UsecaseDiagramCreateAction.ICON_PATH).createImage();
			}
		}else if(category.equals(GlobalConstants.StarMoedl.STAR_CATEGORY_DIAGRAM_MODEL)){
			if(extension.equals(ActorCreateAction.ACTION_ID)){
				return Activator.getImageDescriptor(ActorCreateAction.ICON_PATH).createImage();
			}
		}
		return null;
	}
}
