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
import org.star.uml.designer.ui.action.ViewReportAction;
import org.star.uml.designer.ui.diagram.action.ActorCreateAction;
import org.star.uml.designer.ui.diagram.action.ClazzDiagramCreateAction;
import org.star.uml.designer.ui.diagram.action.DeleteDiagramAction;
import org.star.uml.designer.ui.diagram.action.DeleteFromDiagramAction;
import org.star.uml.designer.ui.diagram.action.DeleteFromModelAction;
import org.star.uml.designer.ui.diagram.action.SequenceDiagramCreateAction;
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

public class StarPMSModelViewUtil_Bak {
	
	public static void loadModel(String project){
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
										 String extension,String category,String diagramName,String objId,String type){
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
	
	public static Action makeAnalysisUsecaseAction(final Composite parent,final ISelection selection,final StarPMSModelView starPMSView){
		Action analysisAction = new Action() {
			public void run() {
				UsecaseDiagramCreateAction aaa = new UsecaseDiagramCreateAction();
//				EclipseUtile.createDiagram("Root","umlusc");
//				IProject projectHandle =  ResourcesPlugin.getWorkspace().getRoot().getProject("Root");
//				IFile file = projectHandle.getFile("custom-messages.properties");
//				Properties props = new Properties();
//				try {
//					projectHandle.refreshLocal(IProject.DEPTH_INFINITE, null);
//					props.load(file.getContents());
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//				String fullFileName = props.getProperty("diagramName");
//				String fileName = fullFileName.substring(0, fullFileName.lastIndexOf("."));
//				
//				TreeSelection treeSelection = (TreeSelection)selection;
//				TreeParent parent = (TreeParent)treeSelection.getFirstElement();
//				String parentPath = (String)parent.getData("path");
//				HashMap map = new HashMap();
//				map.put("path",parent.toString()+"/diagram");
//				IViewPart view_part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView("org.star.uml.designer.ui.views.StarPMSModelView");
//				StarPMSModelView modelView = (StarPMSModelView)view_part;
//				modelView.addChildXml("packagedElement",parent.getData("key").toString(),fileName);
//				parent.appendChield(parent, fileName, map);
				
//				org.eclipse.uml2.diagram.usecase.part.UMLCreationWizard wiazrd = new org.eclipse.uml2.diagram.usecase.part.UMLCreationWizard();
//				wiazrd.init(PlatformUI.getWorkbench(), (IStructuredSelection) selection);
//				WizardDialog dlg = new WizardDialog(parent.getShell(),wiazrd);
//				int resultInt = dlg.open();
//				if(resultInt == 0){
//					TreeSelection treeSelection = (TreeSelection)selection;
//					TreeParent parent = (TreeParent)treeSelection.getFirstElement();
//					
//					Bundle bundle = Platform.getBundle("org.star.uml.designer");
//					FileInputStream in = null;
//					String fileName = "";
//					try {
//						URL fileURL = bundle.getEntry("properties/temp.properties"); 
//						File file = new File(FileLocator.resolve(fileURL).toURI());  
//						in = new FileInputStream(file);
//						Properties props = new Properties();
//						props.load(in);
//						fileName = props.getProperty("diagramName");
//						fileName = fileName.substring(0, fileName.lastIndexOf("."));
//					} catch (Exception e) {
//						e.printStackTrace();
//					}finally{
//						try {
//							in.close();
//						} catch (IOException e) {
//							e.printStackTrace();
//						}
//					}
//					String parentPath = (String)parent.getData("path");
//					HashMap map = new HashMap();
//					map.put("path",parent.toString()+"/diagram");
//					IViewPart view_part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView("org.star.uml.designer.ui.views.StarPMSModelView");
//					StarPMSModelView modelView = (StarPMSModelView)view_part;
//					modelView.addChildXml("packagedElement",parent.getData("key").toString(),fileName);
//					parent.appendChield(parent, fileName, map);
//				}
			}
		};
		analysisAction.setText("Create Usecase Diagram");
		analysisAction.setImageDescriptor(Activator.getImageDescriptor("/icons/login.gif"));
		return analysisAction;
	}
	
	public static Action makeAnalysisUseCaseDiagramAction(final Composite parent,final ISelection selection,final StarPMSModelView starPMSView){
		Action analysisAction = new Action() {
			public void run() {
				HashMap inputData = new HashMap();
				IViewPart view_part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView("org.star.uml.designer.ui.views.StarPMSRequestTableView");
				StarPMSRequestTableView tableView = (StarPMSRequestTableView)view_part;
				Table table = tableView.getTable();
				int flagCnt = 0;
				for(int i=0; i<table.getItemCount(); i++){
        			 TableItem item = table.getItem(i);
        			 if(item.getChecked()){
        				 String req_usecase_seq = (String)item.getData("seq");
        				 inputData.put("req_usecase_seq", req_usecase_seq);
        				 flagCnt++;
        			 }
        		 }
				 if(flagCnt == 0){
					 MessageDialog.openInformation(parent.getShell(),"다이어그램 저장","Request Table에서 저장될 항목을 선택 해 주세요");
					 return;
				 }
				try{
				org.eclipse.uml2.diagram.sequence.part.UMLCreationWizard wiazrd = new org.eclipse.uml2.diagram.sequence.part.UMLCreationWizard();
				wiazrd.init(PlatformUI.getWorkbench(), (IStructuredSelection) selection);
				WizardDialog dlg = new WizardDialog(parent.getShell(),wiazrd);
				int resultInt = dlg.open();
				if(resultInt == 0){
					TreeSelection treeSelection = (TreeSelection)selection;
					TreeObject chield = (TreeObject)treeSelection.getFirstElement();
					TreeParent anlaysisTree = chield.getParent().getParent();
					TreeParent parent = (TreeParent)anlaysisTree.getChildren()[0];
					Bundle bundle = Platform.getBundle("org.star.uml.designer");
					FileInputStream in = null;
					String fileName = "";
					try {
						URL fileURL = bundle.getEntry("properties/temp.properties"); 
						File file = new File(FileLocator.resolve(fileURL).toURI());  
						in = new FileInputStream(file);
						Properties props = new Properties();
						props.load(in);
						fileName = props.getProperty("diagramName");
						fileName = fileName.substring(0, fileName.lastIndexOf("."));
					} catch (Exception e) {
						e.printStackTrace();
					}finally{
						try {
							in.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					String parentPath = (String)parent.getData("path");
					inputData.put("path",parent.toString()+"/diagram");
//					parent.appendChield(parent,fileName, inputData);
					
				}
				}catch(Exception e){
					e.printStackTrace();
				}
			}
				
		};
		analysisAction.setText("Create Sequence Diagram");
		analysisAction.setImageDescriptor(Activator.getImageDescriptor("/icons/login.gif"));
		return analysisAction;
	}
	
	public static Action makeAnalysisUseCaseDiagramSaveAction(final Composite parent,final ISelection selection){
		Action analysisAction = new Action() {
			public void run() {
				IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		        if(page.getActiveEditor() !=null && page.getActiveEditor() instanceof org.eclipse.uml2.diagram.usecase.part.UMLDiagramEditor){
		        	Map inputData = new HashMap();
	            	IViewPart view_part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView("org.star.uml.designer.ui.views.StarPMSRequestTableView");
					StarPMSRequestTableView tableView = (StarPMSRequestTableView)view_part;
					Table table = tableView.getTable();
					int flagCnt = 0;
					for(int i=0; i<table.getItemCount(); i++){
	        			 TableItem item = table.getItem(i);
	        			 if(item.getChecked()){
	        				 String seq = (String)item.getData("seq");
	        				 String name =  item.getText(2);
	        				 inputData.put("parentSeq", seq);
	        				 inputData.put("name", name);
	        				 flagCnt++;
	        			 }
	        		 }
					 if(flagCnt == 0){
						 MessageDialog.openInformation(parent.getShell(),"다이어그램 저장","Request Table에서 저장될 항목을 선택 해 주세요");
						 return;
					 }
		        	final MultiStatus status = new MultiStatus(DiagramUIRenderPlugin
		    				.getPluginId(), DiagramUIRenderStatusCodes.OK,
		    				DiagramUIRenderMessages.CopyToImageAction_Label, null);
		        	IRunnableWithProgress runnable = createRunnable(status);
			    	try {
			    		ProgressMonitorDialog progressMonitorDialog = new ProgressMonitorDialog(
			    				Display.getCurrent().getActiveShell());
			    		progressMonitorDialog.run(false, true, runnable);
			    		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView("org.star.uml.designer.ui.views.StarPMSRequestTableView");
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					String folderPaht = ResourcesPlugin.getWorkspace().getRoot().getProject("Root").getLocation().toString();
					File img = new File(folderPaht + "/default.png");
					PmsDao pd = new PmsDao();
					
					inputData.put("img", img);
					try{
						pd.diragramUpdate(inputData);
					}catch(Exception e){
						e.printStackTrace();
					}
		        }
			}
		};
		analysisAction.setText("Save Diagram");
		analysisAction.setImageDescriptor(Activator.getImageDescriptor("/icons/login.gif"));
		return analysisAction;
	}
	
	public static Action makeAnalysisSequenceDiagramSaveAction(final Composite parent,final ISelection selection){
		Action analysisAction = new Action() {
			public void run() {
				IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				if(page.getActiveEditor() !=null && page.getActiveEditor() instanceof org.eclipse.uml2.diagram.sequence.part.UMLDiagramEditor){
		        	final MultiStatus status = new MultiStatus(DiagramUIRenderPlugin
		    				.getPluginId(), DiagramUIRenderStatusCodes.OK,
		    				DiagramUIRenderMessages.CopyToImageAction_Label, null);
		        	IRunnableWithProgress runnable = createRunnable(status);
			    	try {
			    		ProgressMonitorDialog progressMonitorDialog = new ProgressMonitorDialog(
			    				Display.getCurrent().getActiveShell());
			    		progressMonitorDialog.run(false, true, runnable);
			    		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView("org.star.uml.designer.ui.views.StarPMSRequestTableView");
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					String folderPaht = ResourcesPlugin.getWorkspace().getRoot().getProject("Root").getLocation().toString();
					File img = new File(folderPaht + "/default.png");
					PmsDao pd = new PmsDao();
					
					TreeSelection treeSelection = (TreeSelection)selection;
		        	TreeObject chield = (TreeObject)treeSelection.getFirstElement();
		        	String  req_usecase_seq = (String)chield.getData("req_usecase_seq");
		        	Map inputData = new HashMap();
		        	inputData.put("REQ_USECASE_SEQ", req_usecase_seq);
					inputData.put("img", img);
					inputData.put("name", "시퀸스 다이어 그램");
					try{
						pd.analysis_insert(inputData);
						pd.analysisUpdate(inputData);
					}catch(Exception e){
						e.printStackTrace();
					}
		        }
			}
		};
		analysisAction.setText("Save Diagram");
		analysisAction.setImageDescriptor(Activator.getImageDescriptor("/icons/login.gif"));
		return analysisAction;
	}
	
	private static IRunnableWithProgress createRunnable(final MultiStatus status) {
		return new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) {
				try {
					IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
					DiagramDocumentEditor editor = null;
					if(page.getActiveEditor() instanceof org.eclipse.uml2.diagram.usecase.part.UMLDiagramEditor){
						editor = (org.eclipse.uml2.diagram.usecase.part.UMLDiagramEditor)page.getActiveEditor();
					}else if(page.getActiveEditor() instanceof org.eclipse.uml2.diagram.sequence.part.UMLDiagramEditor){
						editor = (org.eclipse.uml2.diagram.sequence.part.UMLDiagramEditor)page.getActiveEditor();
					}
					
		        	DiagramEditPart diagramEditPart = editor.getDiagramEditPart();
		        	EditPart focusEdit = diagramEditPart.getViewer().getFocusEditPart();
					CopyToImageUtil  copyToImageUtil = new CopyToImageUtil();
					String folderPaht = ResourcesPlugin.getWorkspace().getRoot().getProject("Root").getLocation().toString();
					IPath path = new Path(folderPaht+"/default.png");
			    	ImageFileFormat format = ImageFileFormat.resolveImageFormat(5);
			    	DiagramGenerator gen = new DiagramImageGenerator(diagramEditPart);
			    	monitor.beginTask("", 6); 
					monitor.worked(1);
					copyToImageUtil.copyToImage(diagramEditPart, path, format,monitor);
				} catch (CoreException e) {
					e.printStackTrace();
					status.add(e.getStatus());
				} finally {
					monitor.done();
				}
			}
		};
	}
	
	public static Action makeUsecaseReportAction(final Composite parent,final ISelection selection){
		Action analysisAction = new Action() {
			public void run() {
				TreeSelection treeSelection = (TreeSelection)selection;
	        	TreeObject chield = (TreeObject)treeSelection.getFirstElement();
	        	String  req_usecase_seq = (String)chield.getData("req_usecase_seq");
				IViewPart view_part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView("org.star.uml.designer.ui.views.StarPMSBrowersView");
	            StarPMSBrowersView brower = (StarPMSBrowersView)view_part;
	            String url = "http://192.168.10.193:8080/starPMS/processMgt/viewUseCaseReportSimple.do?usecaseSeq=";
	            brower.setURL(url+req_usecase_seq);
	            try {
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView("org.star.uml.designer.ui.views.StarPMSBrowersView");
				} catch (PartInitException e) {
					e.printStackTrace();
				}
			}
		};
		analysisAction.setText("View Usecase Report");
		analysisAction.setImageDescriptor(Activator.getImageDescriptor("/icons/login.gif"));
		return analysisAction;
	}
	
	public static Action makeImplemetationClassDiagramAction(final Composite parent,final ISelection selection){
		Action implrmrnysyionAction = new Action() {
			public void run() {
				ClassSorceCodeGeneration wiazrd = new ClassSorceCodeGeneration();
				wiazrd.init(PlatformUI.getWorkbench(), (IStructuredSelection) selection);
				WizardDialog dlg = new WizardDialog(parent.getShell(),wiazrd);
			}
		};
		implrmrnysyionAction.setText("Generate Source Code");
		implrmrnysyionAction.setImageDescriptor(Activator.getImageDescriptor("/icons/login.gif"));
		return implrmrnysyionAction;
	}
	
	public static void initContextMenu(MenuManager menuMgr){
		PMSLoginAction login = new PMSLoginAction();
		PMSLogoutAction logout = new PMSLogoutAction();
		DeleteFromDiagramAction delete = new DeleteFromDiagramAction();
		DeleteDiagramAction deleteDiagram = new DeleteDiagramAction();
		MenuManager diagramGroup = new MenuManager("Add Diagram");
		MenuManager viewGroup = new MenuManager("View");
		
		UsecaseDiagramCreateAction usecaseDiagram = new UsecaseDiagramCreateAction();
		SequenceDiagramCreateAction sequenceDiagram = new SequenceDiagramCreateAction();
		ClazzDiagramCreateAction clazzDiagram = new ClazzDiagramCreateAction();
		
		ViewReportAction viewReportAction = new ViewReportAction();
		DeleteFromModelAction deletFromModel = new DeleteFromModelAction();
		
		MenuManager modelGroup = new MenuManager("Add Model");
		ActorCreateAction actor = new ActorCreateAction();
		
		menuMgr.add(login);
		menuMgr.add(logout);
		menuMgr.add(new Separator());
//		menuMgr.add(delete);
		menuMgr.add(deletFromModel);
		menuMgr.add(deleteDiagram);
		menuMgr.add(new Separator());
		menuMgr.add(diagramGroup);
		menuMgr.add(modelGroup);
		
		diagramGroup.add(usecaseDiagram);
		diagramGroup.add(sequenceDiagram);
		diagramGroup.add(clazzDiagram);
		
		modelGroup.add(actor);
		menuMgr.add(new Separator());
		menuMgr.add(viewGroup);
		viewGroup.add(viewReportAction);
		
		
	}

}
