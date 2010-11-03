package org.eclipse.uml2.diagram.extension.imple;

import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.diagram.common.extension.StarUMLExtension;
import org.star.uml.designer.base.constance.GlobalConstants;
import org.star.uml.designer.ui.diagram.action.ActorCreateAction;
import org.star.uml.designer.ui.diagram.action.ModelCreateAction;
import org.star.uml.designer.ui.views.StarPMSModelView;
import org.star.uml.designer.ui.views.StarPMSModelView.TreeParent;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class StarUMLExtensionImple implements StarUMLExtension{

	@Override
	public void diagramSave(HashMap map) {
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
