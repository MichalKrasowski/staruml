package org.star.uml.designer.ui.diagram.action;

import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDiagramDocument;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.MetamodelType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.impl.DiagramImpl;
import org.eclipse.gmf.runtime.notation.impl.ShapeImpl;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.diagram.usecase.edit.helpers.UMLBaseEditHelper;
import org.eclipse.uml2.diagram.usecase.navigator.UMLNavigatorItem;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.VisibilityKind;
import org.eclipse.uml2.uml.internal.impl.ActorImpl;
import org.eclipse.uml2.uml.internal.impl.PackageImpl;
import org.eclipse.uml2.uml.internal.impl.UMLFactoryImpl;
import org.osgi.framework.Bundle;
import org.star.uml.designer.Activator;
import org.star.uml.designer.base.constance.GlobalConstants;
import org.star.uml.designer.base.utils.CommonUtil;
import org.star.uml.designer.base.utils.EclipseUtile;
import org.star.uml.designer.ui.diagram.action.interfaces.IStarUMLModelAction;
import org.star.uml.designer.ui.factory.StarUMLCommandFactory;
import org.star.uml.designer.ui.factory.StarUMLEditHelperFactory;
import org.star.uml.designer.ui.views.StarPMSModelView;
import org.star.uml.designer.ui.views.StarPMSModelViewUtil;
import org.star.uml.designer.ui.views.StarPMSModelView.TreeObject;
import org.star.uml.designer.ui.views.StarPMSModelView.TreeParent;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class ModelCreateAction extends Action implements IStarUMLModelAction{
	public static final String ACTION_ID = "MODEL_CREAE_ACTION";
	public static final String ACTION_URI = "org.eclipse.uml2.diagram.common.ModelCreateAction";
	public static final String ACTION_TITLE ="Create Model";
	public static final String ICON_PATH = "/icons/diagram/Actor.gif";
	public HashMap requestMap ;
	
	public TransactionalEditingDomain domain = null;
	public DiagramDocumentEditor editor = null;
	public View view = null;
	
	public ModelCreateAction() {
		super();
		this.setText(ACTION_TITLE);
		this.setImageDescriptor(getImageDescriptor());
	}
	
	@Override
	public void run() {
		// default.uml 파일을 읽어드려 새로 추가된 파일의 이름과 ID를 가져온다.
		ArrayList newNameList = (ArrayList)requestMap.get(GlobalConstants.PARAM_NEW_NODE_LIST);
		String diagramName = (String)requestMap.get("diagramName");
		diagramName = diagramName.substring(0,diagramName.indexOf(".uml"));
		IProject rootProject = ResourcesPlugin.getWorkspace().getRoot().getProject("Root");
		Document modelDoc = null;
		try{
			// 파일을 Document로 로드한다.
			String projectPath = rootProject.getLocation().toOSString();
			String modelPath = projectPath+File.separator+"default.uml";
			File xmlFile = new File(modelPath);
	    	StringWriter writer = new StringWriter(); 
			TransformerFactory fac = TransformerFactory.newInstance();
			Transformer x = fac.newTransformer();
			x.transform(new StreamSource(xmlFile), new StreamResult(writer));
			String domStr = writer.toString();
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = dbFactory.newDocumentBuilder();
			modelDoc = builder.parse(new InputSource(new StringReader(domStr)));
		}catch(Exception e){
			e.printStackTrace();
		}
		// Document 있는 Element 중  TagName이 "package"를 가져와서 name들을 저장한다.
		NodeList nodeList = modelDoc.getDocumentElement().getElementsByTagName("packagedElement");
		ArrayList newNodeList = new ArrayList();
		// 새로운 노드와 이름이 일치하면 이름과 아이디를 저장한다.
		ArrayList<HashMap<String,String>> resultList = new ArrayList<HashMap<String,String>>();
		for(int i=0; i<nodeList.getLength(); i++){
			String name = nodeList.item(i).getAttributes().getNamedItem("name").getNodeValue();
			String id = nodeList.item(i).getAttributes().getNamedItem("xmi:id").getNodeValue();
			String type = nodeList.item(i).getAttributes().getNamedItem("xmi:type").getNodeValue();
			if(newNameList.contains(name)){
				HashMap<String,String> resultMap = new HashMap<String,String>();
				resultMap.put("name", name);
				resultMap.put("id", id);
				resultMap.put("type", type);
				resultList.add(resultMap);
			}
		}
		// 모델을 Tree에  추가한다.
		IViewPart view_part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
								.findView(GlobalConstants.PluinID.STAR_PMS_MODEL_VIEW);
		StarPMSModelView modelView = (StarPMSModelView)view_part;
		// 다이어 그램이 속한 부모를 가져온다.
		TreeParent treeRoot = modelView.getTreeParent();
		TreeParent parent = null;
		for(int i=0; i <treeRoot.getChildren().length; i++){
			TreeObject[] modelTree = ((TreeParent)treeRoot.getChildren()[i]).getChildren();
			for(int j=0; j<modelTree.length; j++){
				TreeObject treeObject = (TreeObject)modelTree[j];
				String file = (String)treeObject.getData(GlobalConstants.StarMoedl.STAR_MODEL_FILE);
				if(file.equals(diagramName)){
					parent = treeObject.getParent();
				}
			}
			
		}
		String parentId = (String)parent.getData(GlobalConstants.StarMoedl.STAR_MODEL_ID);
		// 새로운 모델 수 만큼 트리에 추가한다.
		for(int i=0; i<resultList.size(); i++){
			String nodeName = resultList.get(i).get("name");
			String type = resultList.get(i).get("type");
			String objId = resultList.get(i).get("id");
			// 추가된 Node에 필요한 값들을 설정한다.
			TreeObject treeObject = parent.appendChield(parent,nodeName+"("+type.substring(4,type.length())+")",
						GlobalConstants.StarMoedl.STAR_MODEL_CATEGORY, 
						GlobalConstants.StarMoedl.STAR_CATEGORY_DIAGRAM_MODEL					);
			treeObject.setData(GlobalConstants.StarMoedl.STAR_MODEL_FILE, nodeName);
			treeObject.setData(GlobalConstants.StarMoedl.STAR_MODEL_EXTENSION, type);
			treeObject.setData(GlobalConstants.StarMoedl.STAR_MODEL_ID, objId);
			modelView.getTreeViewer().refresh();
			// Model.xml 파일에 노드를 추가한다.
			StarPMSModelViewUtil.addDiagramToModel("Root",parentId,nodeName,type,
								  			       GlobalConstants.StarMoedl.STAR_CATEGORY_DIAGRAM_MODEL,type.substring(4,type.length()),objId,type,"","");
		}
		EclipseUtile.refreshProject("Root");
	}
	
	public void addChild(){
		
	}
	
	public URL getImageURL(){
		Bundle bundle = Platform.getBundle(Activator.PLUGIN_ID);
		return bundle.getEntry(ICON_PATH);
	}
	
	public ImageDescriptor getImageDescriptor(){
		return Activator.getImageDescriptor(ICON_PATH);
	}
	
	public void setRequestMap(HashMap requestMap){
		this.requestMap = requestMap;
	}

}
