package org.star.uml.designer.ui.views.linstener;

import java.util.HashMap;

import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PlatformUI;
import org.star.uml.designer.base.constance.GlobalConstants;
import org.star.uml.designer.base.utils.EclipseUtile;
import org.star.uml.designer.ui.diagram.action.ActorCreateAction;
import org.star.uml.designer.ui.diagram.action.ActorInsertAction;
import org.star.uml.designer.ui.diagram.action.ClassModelInsertAction;
import org.star.uml.designer.ui.diagram.action.InterfaceModelInsertAction;
import org.star.uml.designer.ui.diagram.action.PackageModelCreateAction;
import org.star.uml.designer.ui.diagram.action.PackageModelInsertAction;
import org.star.uml.designer.ui.diagram.action.UsecaseDiagramCreateAction;
import org.star.uml.designer.ui.diagram.action.UsecaseModelInsertAction;
import org.star.uml.designer.ui.diagram.action.interfaces.IStarUMLDiagramAction;
import org.star.uml.designer.ui.views.StarPMSModelView;
import org.star.uml.designer.ui.views.StarPMSModelView.TreeObject;


public class StarPMSModelViewMenuDoubleClickListener implements IDoubleClickListener{

	@Override
	public void doubleClick(DoubleClickEvent event) {
		// 모델 Tree에 다이어그램을 추가한다.
		IViewPart view_part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
								.findView(GlobalConstants.PluinID.STAR_PMS_MODEL_VIEW);
		StarPMSModelView modelView = (StarPMSModelView)view_part;
		// Action이 저장 된 Map를 가져온다.
		HashMap actionMap = modelView.getActionMap();
		// 선택된 Tree를 가져온다.
		TreeSelection treeSelection = (TreeSelection)modelView.getTreeViewer().getSelection();
		TreeObject treeObject = (TreeObject)treeSelection.getFirstElement();
		String catetory = (String)treeObject.getData(GlobalConstants.StarMoedl.STAR_MODEL_CATEGORY);
		String extension = (String)treeObject.getData(GlobalConstants.StarMoedl.STAR_MODEL_EXTENSION);
		String fileName = (String)treeObject.getData(GlobalConstants.StarMoedl.STAR_MODEL_FILE);
		System.out.println(extension+" ; "+InterfaceModelInsertAction.ACTION_TYPE);
		if(catetory.equals(GlobalConstants.StarMoedl.STAR_CATEGORY_DIAGRAM)){ // 다이어그램일 경우 파일을 연다.
			EclipseUtile.openDiagram("/Root/" + fileName+"."+extension,extension);
		}else if(catetory.equals(GlobalConstants.StarMoedl.STAR_CATEGORY_DIAGRAM_MODEL)){ 
			// 모델일 경우 다이어그램에 모델을 추가한다.
			if(extension.equals(ActorInsertAction.ACTION_TYPE)){ // Actor 추가
				ActorInsertAction action2 = new ActorInsertAction();
				action2.run();
			}else if(extension.equals(UsecaseModelInsertAction.ACTION_TYPE)){// UseCase 추가
				UsecaseModelInsertAction action2 = new UsecaseModelInsertAction();
				action2.run();
			}else if(extension.equals(PackageModelCreateAction.ACTION_TYPE)){// Package 추가
				PackageModelInsertAction action2 = new PackageModelInsertAction();
				action2.run();
			}else if(extension.equals(ClassModelInsertAction.ACTION_TYPE)){// Class 추가
				ClassModelInsertAction action2 = new ClassModelInsertAction();
				action2.run();
			}else if(extension.equals(InterfaceModelInsertAction.ACTION_TYPE)){// Interface 추가
				InterfaceModelInsertAction action2 = new InterfaceModelInsertAction();
				action2.run();
			}
		}
	}
	
	
}
