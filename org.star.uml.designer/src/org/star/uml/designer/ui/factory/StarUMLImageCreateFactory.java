package org.star.uml.designer.ui.factory;

import org.eclipse.swt.graphics.Image;
import org.star.uml.designer.Activator;
import org.star.uml.designer.base.constance.GlobalConstants;
import org.star.uml.designer.ui.diagram.action.ActorCreateAction;
import org.star.uml.designer.ui.diagram.action.ClassModelCreateAction;
import org.star.uml.designer.ui.diagram.action.ClazzDiagramCreateAction;
import org.star.uml.designer.ui.diagram.action.InterfaceModelCreateAction;
import org.star.uml.designer.ui.diagram.action.PackageModelCreateAction;
import org.star.uml.designer.ui.diagram.action.PackageModelInsertAction;
import org.star.uml.designer.ui.diagram.action.SequenceDiagramCreateAction;
import org.star.uml.designer.ui.diagram.action.UsecaseModelCreateAction;
import org.star.uml.designer.ui.diagram.action.UsecaseDiagramCreateAction;

public class StarUMLImageCreateFactory {
	
	public static Image getImage(String category,String extension){
		if(category.equals(GlobalConstants.StarMoedl.STAR_CATEGORY_DIAGRAM)){// 다이어그램 이미지 설정
			if(extension.equals(UsecaseDiagramCreateAction.DIAGRAM_EXTENSION) ){
				return Activator.getImageDescriptor(UsecaseDiagramCreateAction.ICON_PATH).createImage();
			}else if(extension.equals(SequenceDiagramCreateAction.DIAGRAM_EXTENSION) ){
				return Activator.getImageDescriptor(SequenceDiagramCreateAction.ICON_PATH).createImage();
			}else if(extension.equals(ClazzDiagramCreateAction.DIAGRAM_EXTENSION) ){
				return Activator.getImageDescriptor(ClazzDiagramCreateAction.ICON_PATH).createImage();
			}
		}else if(category.equals(GlobalConstants.StarMoedl.STAR_CATEGORY_DIAGRAM_MODEL)){// 모델 이미지 설정
			if(extension.equals(ActorCreateAction.ACTION_TYPE)){ // Actor
				return Activator.getImageDescriptor(ActorCreateAction.ICON_PATH).createImage();
			}else if(extension.equals(UsecaseModelCreateAction.ACTION_TYPE)){ // UseCase
				return Activator.getImageDescriptor(UsecaseModelCreateAction.ICON_PATH).createImage();
			}else if(extension.equals(PackageModelInsertAction.ACTION_TYPE)){ // Package
				return Activator.getImageDescriptor(PackageModelCreateAction.ICON_PATH).createImage();
			}else if(extension.equals(ClassModelCreateAction.ACTION_TYPE)){ // Class
				return Activator.getImageDescriptor(ClassModelCreateAction.ICON_PATH).createImage();
			}else if(extension.equals(InterfaceModelCreateAction.ACTION_TYPE)){ // Interface
				return Activator.getImageDescriptor(InterfaceModelCreateAction.ICON_PATH).createImage();
			}
		}
		return null;
	}
}
