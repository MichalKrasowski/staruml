package org.star.uml.designer.ui.views;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.image.ImageFileFormat;
import org.eclipse.gmf.runtime.diagram.ui.render.clipboard.DiagramGenerator;
import org.eclipse.gmf.runtime.diagram.ui.render.clipboard.DiagramImageGenerator;
import org.eclipse.gmf.runtime.diagram.ui.render.internal.DiagramUIRenderPlugin;
import org.eclipse.gmf.runtime.diagram.ui.render.internal.DiagramUIRenderStatusCodes;
import org.eclipse.gmf.runtime.diagram.ui.render.internal.l10n.DiagramUIRenderMessages;
import org.eclipse.gmf.runtime.diagram.ui.render.util.CopyToImageUtil;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.osgi.framework.Bundle;
import org.star.uml.designer.Activator;
import org.star.uml.designer.base.constance.GlobalConstants;
import org.star.uml.designer.base.utils.EclipseUtile;
import org.star.uml.designer.base.utils.XmlUtil;
import org.star.uml.designer.service.dao.PmsDao;
import org.star.uml.designer.ui.action.PMSLoginAction;
import org.star.uml.designer.ui.action.PMSLogoutAction;
import org.star.uml.designer.ui.action.RefactorRenameAction;
import org.star.uml.designer.ui.action.ViewReportAction;
import org.star.uml.designer.ui.diagram.action.ActorCreateAction;
import org.star.uml.designer.ui.diagram.action.ClassModelCreateAction;
import org.star.uml.designer.ui.diagram.action.ClazzDiagramCreateAction;
import org.star.uml.designer.ui.diagram.action.DeleteDiagramAction;
import org.star.uml.designer.ui.diagram.action.DeleteFromDiagramAction;
import org.star.uml.designer.ui.diagram.action.DeleteFromModelAction;
import org.star.uml.designer.ui.diagram.action.InterfaceModelCreateAction;
import org.star.uml.designer.ui.diagram.action.PackageModelCreateAction;
import org.star.uml.designer.ui.diagram.action.PackageModelInsertAction;
import org.star.uml.designer.ui.diagram.action.SequenceDiagramCreateAction;
import org.star.uml.designer.ui.diagram.action.UsecaseModelCreateAction;
import org.star.uml.designer.ui.diagram.action.UsecaseDiagramCreateAction;
import org.star.uml.designer.ui.model.initialization.DefaultModel;
import org.star.uml.designer.ui.model.initialization.DefaultUML;
import org.star.uml.designer.ui.newWiazrds.ClassSorceCodeGeneration;
import org.star.uml.designer.ui.newWiazrds.db.ConnectionCreateDialog;
import org.star.uml.designer.ui.views.StarPMSModelView.TreeObject;
import org.star.uml.designer.ui.views.StarPMSModelView.TreeParent;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class StarPMSModelViewUtil {
	
	public static void loadModel(String project, String userId){
		// ModelView를 가져온다.
		IViewPart view_part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
								.findView(GlobalConstants.PluinID.STAR_PMS_MODEL_VIEW);
		StarPMSModelView modelView = (StarPMSModelView)view_part;
		// 처음 PMS에 로그인 했을 때 프로젝트가 있을 경우 로드하고 없을 경우 생성해서 로드한다.
		IProject rootProject = ResourcesPlugin.getWorkspace().getRoot().getProject(project);
		Document modelDoc = null;
		// 모델 파일 정보를 가져온다.
		String projectPath = "";
		String modelPath = "";
		if(rootProject.exists()){
			try {
				projectPath = rootProject.getLocation().toOSString();
				modelPath =  projectPath+File.separator+GlobalConstants.DEFAULT_VIEW_MODEL_FILE;
				String domStr = XmlUtil.getXmlFileToString(modelPath);
				modelDoc = XmlUtil.getStringToDocument(domStr);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			try {
				modelDoc = XmlUtil.getStringToDocument(DefaultModel.getXML());
				Document umlDoc = XmlUtil.getStringToDocument(DefaultUML.getXML());
				IProject newProjectHandle = EclipseUtile.createNewProject(project,modelDoc,umlDoc);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// XML를 로드한 후 Import 페키지는 제외하고 루트를 가져온다.
		Node rootNode = modelDoc.getChildNodes().item(0);
		Node subPkgNode = rootNode.getChildNodes().item(9);
		
		setTreeFormXML(subPkgNode,modelView.getTreeParent());
		modelView.getTreeParent().setData(GlobalConstants.STAR_USER_ID, userId);
		modelView.getTreeViewer().refresh();
	}
	
	public static void setTreeFormXML(Node pkgeElement,TreeParent parent){
		// ModelView를 가져온다.
		IViewPart view_part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
								.findView(GlobalConstants.PluinID.STAR_PMS_MODEL_VIEW);
		StarPMSModelView modelView = (StarPMSModelView)view_part;
		for(int i=0; i<pkgeElement.getChildNodes().getLength(); i++){
			Node subPkg = pkgeElement.getChildNodes().item(i);
			if(subPkg.getNodeName().equals("packagedElement")){
				NamedNodeMap attMap = subPkg.getAttributes();
				String attrName = attMap.getNamedItem(GlobalConstants.StarMoedl.STAR_MODEL_NAME).getNodeValue();
				String category = attMap.getNamedItem(GlobalConstants.StarMoedl.STAR_MODEL_CATEGORY).getNodeValue();
				TreeParent project = modelView.createTreeParent(attrName);
				TreeObject projectObject = modelView.createTreeObject(attrName);
				for(int y=0; y< attMap.getLength() ;y++){
					String key = attMap.item(y).getNodeName();
					String value = attMap.item(y).getNodeValue();
					project.setData(key, value);
					projectObject.setData(key, value);
				}
				// 다이어 그램이나 모델인 경우 TreeObject로 추가한다.
				if(category.equals(GlobalConstants.StarMoedl.STAR_CATEGORY_DIAGRAM) || 
				   category.equals(GlobalConstants.StarMoedl.STAR_CATEGORY_DIAGRAM_MODEL)){
					parent.addChild(projectObject);
				}else{
					parent.addChild(project);
				}
				if(subPkg.getChildNodes().getLength()>= 1){
					setTreeFormXML(subPkg,project);
				}
			}
		}
	}
	
	public static void addDiagramToModel(String project,String parentId, String name, 
										 String extension,String category,String diagramName,String objId,String type, String parentSeq, String seq){
		// 모델 파일이 있는 프로젝트를 가져온다.
		IProject rootProject = ResourcesPlugin.getWorkspace().getRoot().getProject(project);
		Document modelDoc = null;
		try{
			// 파일을 Document로 로드한다.
			String projectPath = rootProject.getLocation().toOSString();
			String modelPath = projectPath+File.separator+GlobalConstants.DEFAULT_VIEW_MODEL_FILE;
			String domStr = XmlUtil.getXmlFileToString(modelPath);
			modelDoc = XmlUtil.getStringToDocument(domStr);
			// Document 있는 Element 중  TagName이 "package"를 가져와서 ID를 비교해 부모가 될 Node를 선택한다.
			NodeList n = modelDoc.getDocumentElement().getElementsByTagName("packagedElement");
			for(int i = 0; i < n.getLength(); i++){
				Node node = n.item(i);
				NamedNodeMap attrMap = node.getAttributes();
				String id = attrMap.getNamedItem(GlobalConstants.StarMoedl.STAR_MODEL_ID).getNodeValue();
				if(id.equals(parentId)){
					Element newNode = modelDoc.createElement("packagedElement");
					newNode.setAttribute(GlobalConstants.StarMoedl.STAR_MODEL_ID, objId);
					newNode.setAttribute(GlobalConstants.StarMoedl.STAR_MODEL_CATEGORY, category);
					newNode.setAttribute(GlobalConstants.StarMoedl.STAR_MODEL_TYPE, type);
					newNode.setAttribute(GlobalConstants.StarMoedl.STAR_MODEL_NAME, name+"("+diagramName+")");
					newNode.setAttribute(GlobalConstants.StarMoedl.STAR_MODEL_FILE, name);
					newNode.setAttribute(GlobalConstants.StarMoedl.STAR_MODEL_EXTENSION, extension);
					newNode.setAttribute(GlobalConstants.StarMoedl.STAR_MODEL_USECASE_PARENT_SEQ, parentSeq);
					newNode.setAttribute(GlobalConstants.StarMoedl.STAR_MODEL_USECASE_SEQ, seq);
					node.appendChild(newNode);
					XmlUtil.writeXmlFile(modelDoc, modelPath);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void addModelToUML(String project,String objId, String type, String name){
		// UML 파일이 있는 프로젝트를 가져온다.
		IProject rootProject = ResourcesPlugin.getWorkspace().getRoot().getProject(project);
		Document modelDoc = null;
		try{
			// 파일을 Document로 로드한다.
			String projectPath = rootProject.getLocation().toOSString();
			String modelPath = projectPath+File.separator+GlobalConstants.DEFAULT_MODEL_FILE;
			String domStr = XmlUtil.getXmlFileToString(modelPath);
			modelDoc = XmlUtil.getStringToDocument(domStr);
			NodeList n = modelDoc.getDocumentElement().getElementsByTagName("packagedElement");
			// Document 있는 Element 중  TagName이 "package"를 가져와서 ID를 비교해 부모가 될 Node를 선택한다.
			Node rootEl = modelDoc.getDocumentElement();
			Element newNode = modelDoc.createElement(GlobalConstants.UMLMoedl.UML_TYPE_PACKAGE_Element);
			newNode.setAttribute(GlobalConstants.StarMoedl.STAR_MODEL_ID, objId);
			newNode.setAttribute(GlobalConstants.StarMoedl.STAR_MODEL_TYPE, type);
			newNode.setAttribute(GlobalConstants.StarMoedl.STAR_MODEL_NAME, name);
			rootEl.appendChild(newNode);
			XmlUtil.writeXmlFile(modelDoc, modelPath);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 노드 생성 시 기본 이름을 지정합니다. GlobalConstants.NODE_NAMES를 기준으로 인덱스를 추가하면서 진행합니다.
	 * @param list
	 * @return
	 */
	public static String genNodeName(TreeParent parent){
		TreeObject[] treeObj = parent.getChildren();
		ArrayList<String> namelist = new ArrayList();
		for(int i=0; i<treeObj.length; i++){ // 기존 이름들을 다 가져온다.
			namelist.add((String)treeObj[i].getData(GlobalConstants.StarMoedl.STAR_MODEL_FILE));
		}
		String nodeName = "";
		int nameIdx = 0;
		boolean loofFlag = true;
		while(loofFlag){ // 기존 이름과 기본 이름을 비교하고, 이름에 인덱스를 추가하면서 비교한다.
			for(int i=0; i<GlobalConstants.NODE_NAMES.length; i++){
				if(nameIdx == 0 && !namelist.contains(GlobalConstants.NODE_NAMES[i])){
					nodeName = GlobalConstants.NODE_NAMES[i];
					loofFlag = false;
					break;
				}else if(nameIdx != 0 && !namelist.contains(GlobalConstants.NODE_NAMES[i]+nameIdx)){
					nodeName = GlobalConstants.NODE_NAMES[i]+nameIdx;
					loofFlag = false;
					break;
				}
			}
			nameIdx++;
		}
		return nodeName;
	}
	
	/**
	 *  모델 트리의 컨택스트 메뉴를 생성합니다.
	 * @param menuMgr
	 */
	public static void initContextMenu(MenuManager menuMgr){
		PMSLoginAction login = new PMSLoginAction();// 로그인
		PMSLogoutAction logout = new PMSLogoutAction();// 로그 아웃

		DeleteFromDiagramAction delete = new DeleteFromDiagramAction(); // 다이어그램에서 모델 삭제
		DeleteDiagramAction deleteDiagram = new DeleteDiagramAction();  // 다이어그램 파일 삭제
		DeleteFromModelAction deletFromModel = new DeleteFromModelAction(); // 모델파일에서 모델 삭제
		
		MenuManager diagramGroup = new MenuManager("Add Diagram"); // 다이어그램 생성 그룹
		UsecaseDiagramCreateAction usecaseDiagram = new UsecaseDiagramCreateAction(); // 유스케이스 다이어그램 생성
		SequenceDiagramCreateAction sequenceDiagram = new SequenceDiagramCreateAction(); // 시퀸스 다이어그램 생성
		ClazzDiagramCreateAction clazzDiagram = new ClazzDiagramCreateAction(); // 클래스 다이어그램 생성
		
		MenuManager modelGroup = new MenuManager("Add Model"); // 모델 그룹
		ActorCreateAction actor = new ActorCreateAction(); // Actor 생성
		UsecaseModelCreateAction usecase = new UsecaseModelCreateAction(); // Usecase 생성
		PackageModelCreateAction packageModel = new PackageModelCreateAction(); // Package 생성
		ClassModelCreateAction classModel = new ClassModelCreateAction(); // Class 생성
		InterfaceModelCreateAction interfaceModel = new InterfaceModelCreateAction(); // interface 생성
		
		MenuManager viewGroup = new MenuManager("View"); // 뷰그룹
		ViewReportAction viewReportAction = new ViewReportAction(); // 유스케이스 레포트 보기
		
		MenuManager refactorGroup = new MenuManager("Refactor"); // 리펙토링 그룹
		RefactorRenameAction reName = new RefactorRenameAction(); // 이름 변경
		
		// 로그인 그룹 설정
		menuMgr.add(login);
		menuMgr.add(logout);
		menuMgr.add(new Separator());
//		menuMgr.add(delete);
		
		// 삭제 그룹 설정
		menuMgr.add(deletFromModel);
		menuMgr.add(deleteDiagram);
		menuMgr.add(new Separator());
		
		// 다이어그램 그릅 설정
		menuMgr.add(diagramGroup);
		diagramGroup.add(usecaseDiagram);
		diagramGroup.add(sequenceDiagram);
		diagramGroup.add(clazzDiagram);
		menuMgr.add(new Separator());
		
		// 모델 그릅 설정
		menuMgr.add(modelGroup);
		modelGroup.add(packageModel);
		modelGroup.add(new Separator());
//		modelGroup.add(classModel);
//		modelGroup.add(interfaceModel);
		modelGroup.add(usecase);
		modelGroup.add(actor);
		menuMgr.add(new Separator());
		
		// 뷰 그룹 설정
		menuMgr.add(viewGroup);
		viewGroup.add(viewReportAction);
		menuMgr.add(new Separator());
		
		// 리펙토링 그룹 설정
		menuMgr.add(refactorGroup);
		refactorGroup.add(reName);
		
	}

}
