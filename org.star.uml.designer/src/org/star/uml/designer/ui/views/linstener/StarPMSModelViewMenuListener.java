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
import org.star.uml.designer.ui.views.policy.StarPMSModelViewPopupPolicy;

public class StarPMSModelViewMenuListener implements IMenuListener{
	
	public StarPMSModelViewMenuListener() {
		super();
	}
	@Override
	public void menuAboutToShow(IMenuManager manager) {
		try{
		IViewPart view_part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView("org.star.uml.designer.ui.views.StarPMSModelView");
		StarPMSModelView modelView = (StarPMSModelView)view_part;
		TreeSelection treeSelection = (TreeSelection)modelView.viewer.getSelection();
		HashMap actionMap = modelView.getActionMap();
		if(!treeSelection.isEmpty()){
			// Login , Logout 상태를 확인한다.
			StarPMSModelViewPopupPolicy.applyPolicy(GlobalConstants.StarPMSModelViewPopupPolicy.POLICY_1, actionMap);
			if(modelView.getLoginFlag()){
				StarPMSModelViewPopupPolicy.applyPolicy(GlobalConstants.StarPMSModelViewPopupPolicy.POLICY_3, actionMap);
			}else{
				StarPMSModelViewPopupPolicy.applyPolicy(GlobalConstants.StarPMSModelViewPopupPolicy.POLICY_2, actionMap);
			}
			// Root 노드인지 확인 한다.
			if(treeSelection.getPaths()[0].getParentPath().getFirstSegment() == null){
				
			}else{
				
			}
		}else{
			StarPMSModelViewPopupPolicy.applyPolicy(GlobalConstants.StarPMSModelViewPopupPolicy.POLICY_1, actionMap);
		}
		
		for(int i=0 ; i < treeSelection.getPaths().length; i++){
			System.out.println(treeSelection.getPaths()[i].getFirstSegment());
			System.out.println(treeSelection.getPaths()[i].getParentPath().getFirstSegment());
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
