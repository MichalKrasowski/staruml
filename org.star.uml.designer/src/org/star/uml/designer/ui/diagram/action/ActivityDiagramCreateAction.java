package org.star.uml.designer.ui.diagram.action;

import java.net.URL;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PlatformUI;
import org.osgi.framework.Bundle;
import org.star.uml.designer.Activator;
import org.star.uml.designer.base.constance.GlobalConstants;
import org.star.uml.designer.base.utils.CommonUtil;
import org.star.uml.designer.base.utils.EclipseUtile;
import org.star.uml.designer.ui.diagram.action.interfaces.IStarUMLModelAction;
import org.star.uml.designer.ui.views.StarPMSModelView;
import org.star.uml.designer.ui.views.StarPMSModelViewUtil;
import org.star.uml.designer.ui.views.StarPMSModelView.TreeObject;
import org.star.uml.designer.ui.views.StarPMSModelView.TreeParent;

public class ActivityDiagramCreateAction extends Action implements IStarUMLModelAction{
	public static final String ACTION_ID = "ACTIVITY_DIAGRAM";
	public static final String ACTION_URI = "org.eclipse.uml2.diagram.activity.ActivityDiagram";
	public static final String ACTION_TITLE ="Create Activity Diagram";
	public static final String ICON_PATH = "/icons/16.gif";
	public static final String DIAGRAM_EXTENSION = "umlact";
	public IViewPart view = null;
	
	public ActivityDiagramCreateAction() {
		super();
		this.setText(ACTION_TITLE);
		this.setImageDescriptor(getImageDescriptor());
	}
	
	@Override
	public void run() {
		// "default" 다이어그램을 생성하기 위해 기존 "default" 이름을 사용하는 파일이 있는지 확인 한 후 
		// Index를 +1 해서 다이어 그램을 생성한다.  
		String fileName = "default"+EclipseUtile.getDefaultUMLIdx();
		String fileFullName = "default"+EclipseUtile.getDefaultUMLIdx()+"."+DIAGRAM_EXTENSION;
		URI diagramURI = URI.createDeviceURI(GlobalConstants.PATH_PREFIX+"/Root/"+fileFullName);
		URI modelURI = URI.createDeviceURI(GlobalConstants.PATH_PREFIX+"/Root/"+GlobalConstants.DEFAULT_MODEL_FILE);
		
		EclipseUtile.createDiagram("Root",diagramURI,modelURI,ACTION_ID);
		
		// 모델 Tree에 다이어그램을 추가한다.
		IViewPart view_part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
								.findView(GlobalConstants.PluinID.STAR_PMS_MODEL_VIEW);
		StarPMSModelView modelView = (StarPMSModelView)view_part;
		// 선택된 Tree를 가져온다.
		TreeSelection treeSelection = (TreeSelection)modelView.getTreeViewer().getSelection();
		TreeParent parent = (TreeParent)treeSelection.getFirstElement();
		String parentId = (String)parent.getData(GlobalConstants.StarMoedl.STAR_MODEL_ID);
		// ID를 생성한다.
		String objId = "_" + CommonUtil.randomKey() + "-GMK-em0Iv_Q";
		// 추가된 Node에 필요한 값들을 설정한다.
		TreeObject treeObject = parent.appendChield(parent,fileName+"("+ACTION_ID+")"
								,GlobalConstants.StarMoedl.STAR_MODEL_FILE, fileName);
		treeObject.setData(GlobalConstants.StarMoedl.STAR_MODEL_EXTENSION, DIAGRAM_EXTENSION);
		treeObject.setData(GlobalConstants.StarMoedl.STAR_MODEL_CATEGORY, 
					       GlobalConstants.StarMoedl.STAR_CATEGORY_DIAGRAM);
		treeObject.setData(GlobalConstants.StarMoedl.STAR_MODEL_ID, objId);
		modelView.getTreeViewer().refresh();
		// 모델 파일에 추가된 다이어 그램을 추가한다.
		StarPMSModelViewUtil.addDiagramToModel("Root",parentId,fileName,DIAGRAM_EXTENSION,
							  				   GlobalConstants.StarMoedl.STAR_CATEGORY_DIAGRAM,ACTION_ID,objId);
	}
	
	public URL getImageURL(){
		Bundle bundle = Platform.getBundle(Activator.PLUGIN_ID);
		return bundle.getEntry(ICON_PATH);
	}
	
	public ImageDescriptor getImageDescriptor(){
		return Activator.getImageDescriptor(ICON_PATH);
	}
}
