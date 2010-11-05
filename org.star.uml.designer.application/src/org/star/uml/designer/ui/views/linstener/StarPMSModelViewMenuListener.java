package org.star.uml.designer.ui.views.linstener;

import java.util.HashMap;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PlatformUI;
import org.star.uml.designer.base.constance.GlobalConstants;
import org.star.uml.designer.base.utils.EclipseUtile;
import org.star.uml.designer.ui.views.StarPMSModelView;
import org.star.uml.designer.ui.views.StarPMSModelView.TreeObject;
import org.star.uml.designer.ui.views.policy.StarPMSModelViewPopupPolicy;

public class StarPMSModelViewMenuListener implements IMenuListener{
	
	public StarPMSModelViewMenuListener() {
		super();
	}
	@Override
	public void menuAboutToShow(IMenuManager manager) {
		try{
		IViewPart view_part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView(GlobalConstants.PluinID.STAR_PMS_MODEL_VIEW);
		StarPMSModelView modelView = (StarPMSModelView)view_part;
		TreeSelection treeSelection = (TreeSelection)modelView.getTreeViewer().getSelection();
		TreeObject treeObject = (TreeObject)treeSelection.getFirstElement();
		HashMap actionMap = modelView.getActionMap();
		if(!treeSelection.isEmpty()){
			String name = (String)treeObject.getData(GlobalConstants.StarMoedl.STAR_MODEL_NAME);
			String id = (String)treeObject.getData(GlobalConstants.StarMoedl.STAR_MODEL_ID);
			String category = (String)treeObject.getData(GlobalConstants.StarMoedl.STAR_MODEL_CATEGORY);
			// Login , Logout 상태를 확인한다.
			StarPMSModelViewPopupPolicy.applyPolicy(GlobalConstants.StarPMSModelViewPopupPolicy.POLICY_1, actionMap);
			if(modelView.getLoginFlag()){
				StarPMSModelViewPopupPolicy.applyPolicy(GlobalConstants.StarPMSModelViewPopupPolicy.POLICY_3, actionMap);
			}else{
				StarPMSModelViewPopupPolicy.applyPolicy(GlobalConstants.StarPMSModelViewPopupPolicy.POLICY_2, actionMap);
			}
			// Category가 "rootModel"인 경우 모델을 생성 할 수 있다.
			if(category != null && category.equals(GlobalConstants.StarMoedl.STAR_CATEGORY_MODEL_ROOT)){
				StarPMSModelViewPopupPolicy.applyPolicy(GlobalConstants.StarPMSModelViewPopupPolicy.POLICY_4, actionMap);
			}
			// Category가 "rootModel"인 경우 각 모델별로 생성할 수 있는 다이어그램이 다르다.
			if(category != null && category.equals(GlobalConstants.StarMoedl.STAR_CATEGORY_MODEL_ROOT)){
				if(name != null && name.equals(GlobalConstants.StarMoedl.STAR_NAME_ANALYSIS_MODEL)){
					StarPMSModelViewPopupPolicy.applyPolicy(GlobalConstants.StarPMSModelViewPopupPolicy.POLICY_7, actionMap);
				}
				
				if(name != null && name.equals(GlobalConstants.StarMoedl.STAR_NAME_DESIGN_MODEL)){
					StarPMSModelViewPopupPolicy.applyPolicy(GlobalConstants.StarPMSModelViewPopupPolicy.POLICY_8, actionMap);
				}
				
				if(name != null && name.equals(GlobalConstants.StarMoedl.STAR_NAME_IMPLEMENTATION_MODEL)){
					StarPMSModelViewPopupPolicy.applyPolicy(GlobalConstants.StarPMSModelViewPopupPolicy.POLICY_9, actionMap);
				}
				
				if(name != null && name.equals(GlobalConstants.StarMoedl.STAR_NAME_DEPLOYMENT_MODEL)){
					StarPMSModelViewPopupPolicy.applyPolicy(GlobalConstants.StarPMSModelViewPopupPolicy.POLICY_10, actionMap);
				}
			}
			// Category가 "diagramModel"인 경우 모델을 삭제할 수 있다. 모델 명을 변경할 수 있다.
			if(category != null && category.equals(GlobalConstants.StarMoedl.STAR_CATEGORY_DIAGRAM_MODEL)){
				StarPMSModelViewPopupPolicy.applyPolicy(GlobalConstants.StarPMSModelViewPopupPolicy.POLICY_5, actionMap);
			}
			// Category가 "diagram"인 경우 다이어그램을 삭제할 수 있다. 다이어그램 명을 변경 할 수 있다.
			if(category != null && category.equals(GlobalConstants.StarMoedl.STAR_CATEGORY_DIAGRAM)){
				StarPMSModelViewPopupPolicy.applyPolicy(GlobalConstants.StarPMSModelViewPopupPolicy.POLICY_6, actionMap);
			}
			// Category가 "diagram"인 경우 다이어 그램의 종류에 따라 연관된 다이어 그램을 생성 할 수 있다
			if(category != null && category.equals(GlobalConstants.StarMoedl.STAR_CATEGORY_DIAGRAM)){
				String extension = (String)treeObject.getData(GlobalConstants.StarMoedl.STAR_MODEL_EXTENSION);
				if(extension != null && extension.equals(GlobalConstants.StarMoedl.STAR_EXTENSION_SEQUENCE_DIAGRAM)){
					StarPMSModelViewPopupPolicy.applyPolicy(GlobalConstants.StarPMSModelViewPopupPolicy.POLICY_11, actionMap);
				}
			}
			
			
		}else{
			StarPMSModelViewPopupPolicy.applyPolicy(GlobalConstants.StarPMSModelViewPopupPolicy.POLICY_1, actionMap);
		}
		
		}catch(Exception e){e.printStackTrace();}
//		menuMgr.addMenuListener(new IMenuListener() {
//		public void menuAboutToShow(IMenuManager manager) {
//			TreeSelection selection = (TreeSelection)viewer.getSelection();
//			if(!selection.isEmpty()){
//				TreeObject treeObject = (TreeObject)selection.getFirstElement();
//				String nodeText = selection.toString();
//				String nodePath = (String)treeObject.getData("path");
//				if(nodeText.equals("[192.168.10.102:1521/StarPMS]")){
//					StarPMSModelView.this.fillLoginContextMenu(manager);
//				}else if(nodeText != null && nodeText.equals("[Userecase Diagram]")){
//					StarPMSModelView.this.fillAnalysisUseCaseContextMenu(manager,parent,selection);
//				}else{
//					StarPMSModelView.this.removeContextMenu(manager,parent,selection);
//				}
//				
//				if(nodePath != null && nodePath.equals("Class Diagram/diagram")){
//					StarPMSModelView.this.fillImplementationClassDiagramContextMenu(manager,parent,selection);
//				}else if(nodePath != null && nodePath.equals("Userecase Diagram/diagram")){
//					StarPMSModelView.this.fillAnalysisUseCaseDiagramContextMenu(manager,parent,selection);
//				}else if(nodePath != null && nodePath.equals("Sequence Diagram/diagram")){
//					StarPMSModelView.this.fillSequenceDiagramContextMenu(manager,parent,selection);
//				}
//			}else{
//				menuMgr.removeAll();
//			}
//		}
//	});
	}
	
}
