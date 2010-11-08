package org.eclipse.uml2.diagram.extension.imple;

import java.util.HashMap;

import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.diagram.common.extension.StarUMLExtension;
import org.star.uml.designer.base.constance.GlobalConstants;
import org.star.uml.designer.ui.diagram.action.DiagramSaveAction;
import org.star.uml.designer.ui.diagram.action.ModelCreateAction;
import org.star.uml.designer.ui.views.StarPMSModelView;

public class StarUMLExtensionImple implements StarUMLExtension{

	@Override
	public void diagramSave(HashMap map) {
		try{
			// StarPMS Model에 로그인 된 경우에만 실행한다.
			IViewPart view_part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
												.findView(GlobalConstants.PluinID.STAR_PMS_MODEL_VIEW);
			if(view_part != null){
				StarPMSModelView modelView = (StarPMSModelView)view_part;
				// 다이어 그램이 속한 부모를 가있을 경우 로그인 상태로 정의한다.
				if( modelView.getTreeParent() != null){
					DiagramSaveAction dg = new DiagramSaveAction();
					dg.map = map;
					dg.run();
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
			
	}

	@Override
	public void fileSave(HashMap map) {
	}

	@Override
	public void modelAdd(HashMap requestMap) {
		try{
			// StarPMS Model에 로그인 된 경우에만 모델을 추가한다.
			IViewPart view_part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
												.findView(GlobalConstants.PluinID.STAR_PMS_MODEL_VIEW);
			if(view_part != null){
				StarPMSModelView modelView = (StarPMSModelView)view_part;
				// 다이어 그램이 속한 부모를 가있을 경우 로그인 상태로 정의한다.
				if( modelView.getTreeParent() != null){
					ModelCreateAction modelCreateAction = new ModelCreateAction();
					modelCreateAction.setRequestMap(requestMap);
					modelCreateAction.run();
				}
			}

		}catch(Exception e){
			e.printStackTrace();
		}
	}


}
