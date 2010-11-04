package org.eclipse.uml2.diagram.extension.imple;

import java.util.HashMap;

import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.diagram.common.extension.StarUMLExtension;
import org.star.uml.designer.base.constance.GlobalConstants;
import org.star.uml.designer.ui.diagram.action.ClazzDiagramSaveAction;
import org.star.uml.designer.ui.diagram.action.ModelCreateAction;
import org.star.uml.designer.ui.diagram.action.SequenceDiagramSaveAction;
import org.star.uml.designer.ui.views.StarPMSModelView;

public class StarUMLExtensionImple implements StarUMLExtension{

	@Override
	public void diagramSave(HashMap map) {
		String fileName = (String)map.get("fileName");
		if(fileName.substring(fileName.lastIndexOf(".")+1).equals(GlobalConstants.StarMoedl.STAR_EXTENSION_SEQUENCE_DIAGRAM)){
			SequenceDiagramSaveAction dg = new SequenceDiagramSaveAction();
			dg.map = map;
			dg.run();
		}else if(fileName.substring(fileName.lastIndexOf(".")+1).equals(GlobalConstants.StarMoedl.STAR_EXTENSION_CLASS_DIAGRAM)){
			ClazzDiagramSaveAction cg = new ClazzDiagramSaveAction();
			cg.map = map;
			cg.run();
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
				// 다이어 그램이 속한 부모를 가져온다.
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
