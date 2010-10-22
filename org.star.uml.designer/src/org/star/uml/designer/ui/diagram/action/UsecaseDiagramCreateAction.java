package org.star.uml.designer.ui.diagram.action;

import java.net.URL;
import java.util.HashMap;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.MetamodelType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.diagram.usecase.edit.commands.ActorCreateCommand;
import org.eclipse.uml2.diagram.usecase.edit.helpers.ActorEditHelper;
import org.eclipse.uml2.diagram.usecase.edit.helpers.UMLBaseEditHelper;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.internal.impl.ActorImpl;
import org.eclipse.uml2.uml.internal.impl.UMLFactoryImpl;
import org.osgi.framework.Bundle;
import org.star.uml.designer.Activator;
import org.star.uml.designer.base.constance.GlobalConstants;
import org.star.uml.designer.base.utils.EclipseUtile;
import org.star.uml.designer.ui.factory.StarUMLCommandFactory;
import org.star.uml.designer.ui.factory.StarUMLEditHelperFactory;
import org.star.uml.designer.ui.views.StarPMSModelView;
import org.star.uml.designer.ui.views.StarPMSModelViewUtil;
import org.star.uml.designer.ui.views.StarPMSModelView.TreeObject;
import org.star.uml.designer.ui.views.StarPMSModelView.TreeParent;

public class UsecaseDiagramCreateAction extends Action{
	public static final String ACTION_ID = "USECASE_DIAGRAM";
	public static final String ACTION_URI = "org.eclipse.uml2.diagram.usecase.UsecaseDiagram";
	public static final String ACTION_TITLE ="Create UsecaseDiagram";
	public static final String ICON_PATH = "/icons/login.gif";
	public IViewPart view = null;
	
	public UsecaseDiagramCreateAction() {
		super();
		this.setText(ACTION_TITLE);
		this.setImageDescriptor(getImageDescriptor());
	}
	
	@Override
	public void run() {
		// "default" 다이어그램을 생성하기 위해 기존 "default" 이름을 사용하는 파일이 있는지 확인 한 후 
		// Index를 +1 해서 다이어 그램을 생성한다.  
		String fileName = "default"+EclipseUtile.getDefaultUMLIdx();
		String fileFullName = "default"+EclipseUtile.getDefaultUMLIdx()+"."
								+GlobalConstants.USECASE_DIAGRAM_EXTENSION;
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
		String id = (String)parent.getData(GlobalConstants.StarMoedl.STAR_MODEL_ID);
		HashMap map = new HashMap();
		// 추가된 Node에 필요한 값들을 설정한다.
		parent.appendChield(parent,fileName);
		parent.setData(GlobalConstants.StarMoedl.STAR_MODEL_FILE, fileName);
		parent.setData(GlobalConstants.StarMoedl.STAR_MODEL_EXTENSION, GlobalConstants.USECASE_DIAGRAM_EXTENSION);
		// 모델 파일에 추가된 다이어 그램을 추가한다.
		StarPMSModelViewUtil.addDiagramToModel("Root",id,fileName,GlobalConstants.USECASE_DIAGRAM_EXTENSION,
							  				   GlobalConstants.StarMoedl.STAR_CATEGORY_DIAGRAM_MODEL);
	}
	
	public URL getImageURL(){
		Bundle bundle = Platform.getBundle(Activator.PLUGIN_ID);
		return bundle.getEntry(ICON_PATH);
	}
	
	public ImageDescriptor getImageDescriptor(){
		return Activator.getImageDescriptor(ICON_PATH);
	}
	
	
}
