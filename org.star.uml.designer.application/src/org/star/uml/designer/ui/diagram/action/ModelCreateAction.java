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
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Platform;
import org.eclipse.draw2d.geometry.Point;
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
import org.star.uml.designer.application.Activator;
import org.star.uml.designer.base.constance.GlobalConstants;
import org.star.uml.designer.base.utils.CommonUtil;
import org.star.uml.designer.base.utils.EclipseUtile;
import org.star.uml.designer.base.utils.XmlUtil;
import org.star.uml.designer.ui.diagram.action.interfaces.IStarUMLModelAction;
import org.star.uml.designer.ui.factory.StarUMLCommandFactory;
import org.star.uml.designer.ui.factory.StarUMLEditHelperFactory;
import org.star.uml.designer.ui.views.StarPMSModelView;
import org.star.uml.designer.ui.views.StarPMSModelViewUtil;
import org.star.uml.designer.ui.views.StarPMSModelView.TreeObject;
import org.star.uml.designer.ui.views.StarPMSModelView.TreeParent;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
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
		// 사용할 파일 정보들을 가져온다.
		String diagramName = (String)requestMap.get("diagramName");
		IProject rootProject = ResourcesPlugin.getWorkspace().getRoot().getProject("Root");
		String projectPath = rootProject.getLocation().toOSString();
		String modelPath = projectPath+File.separator+GlobalConstants.DEFAULT_VIEW_MODEL_FILE;
		String umlPath = projectPath+File.separator+GlobalConstants.DEFAULT_MODEL_FILE;
		String diagramPath = projectPath+File.separator+diagramName;
		
		Document diagramDoc = null;
		Document umlDoc = null;
		Document modelDoc = null;
		
		// 비교할 때 사용된 파일들을 Document로 로드한다.
		try{
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = dbFactory.newDocumentBuilder();
			TransformerFactory fac = TransformerFactory.newInstance();
			Transformer x = fac.newTransformer();
			// 다이어그램 파일을 Document로 로드한다.
			File xmlFile = new File(diagramPath);
	    	StringWriter writer = new StringWriter(); 
			x.transform(new StreamSource(xmlFile), new StreamResult(writer));
			String domStr = writer.toString();
			diagramDoc = builder.parse(new InputSource(new StringReader(domStr)));
			// UML 파일을 Document로 로드한다.
			writer.getBuffer().delete(0, writer.getBuffer().length());
			xmlFile = new File(umlPath);
			x.transform(new StreamSource(xmlFile), new StreamResult(writer));
			domStr = writer.toString();
			umlDoc = builder.parse(new InputSource(new StringReader(domStr)));
			// model.xml 파일을 Document로 로드한다.
			writer.getBuffer().delete(0, writer.getBuffer().length());
			xmlFile = new File(modelPath);
			x.transform(new StreamSource(xmlFile), new StreamResult(writer));
			domStr = writer.toString();
			modelDoc = builder.parse(new InputSource(new StringReader(domStr)));
			writer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		// 다이어그램에 등록된 등록된 모든 엘리먼트를 가져온다.
		NodeList elementNodeList = diagramDoc.getDocumentElement().getElementsByTagName("element");
		// UML에 등록된 모델 정보를 가져온다.
		NodeList umlNodeList = umlDoc.getDocumentElement().getElementsByTagName("packagedElement");
		HashMap<String,Object> diagramNameMap = new HashMap<String,Object>(); // name을 저장한다.
		ArrayList<String> diagramIdArray = new ArrayList<String>(); // id를 저장한다. 추후 비교 값의로 사용한다.
		for(int i=0; i<elementNodeList.getLength(); i++){
			Node elNode = elementNodeList.item(i);
			// href 속성에 등록된 아이디를 가져온다.
			String hrefAttr = elNode.getAttributes().getNamedItem("href").getNodeValue();
			String id = hrefAttr.split("#")[1];
			Element parenetEl = (Element)elNode.getParentNode();
			// "layoutConstraint" Element에 등록된 좌표를 얻어온다. 
			// layoutConstraint 중 xmi:type="notation:Bounds"인 엘리먼트에서 값을 얻어온다. 
			Node layoutNode = null;
			for(int k=0; k<parenetEl.getElementsByTagName("layoutConstraint").getLength(); k++){
				Node tmpNode = parenetEl.getElementsByTagName("layoutConstraint").item(k);
				String tmpType = tmpNode.getAttributes().getNamedItem("xmi:type").getNodeValue();
				if(tmpType.equals("notation:Bounds")){
					layoutNode = tmpNode;
				}
			}
			for(int j=0; j<umlNodeList.getLength(); j++){
				if(umlNodeList.item(j).getAttributes().getNamedItem("name") != null){
					String umlId = umlNodeList.item(j).getAttributes().getNamedItem("xmi:id").getNodeValue();
					String name = umlNodeList.item(j).getAttributes().getNamedItem("name").getNodeValue();
					String type = umlNodeList.item(j).getAttributes().getNamedItem("xmi:type").getNodeValue();
					if(umlId.equals(id)){ // UML ID와 비교하여 이름을 가져온다.
						diagramIdArray.add(umlId);
						diagramNameMap.put(umlId,name);
						diagramNameMap.put(id+"_node",umlNodeList.item(j)); // 수정을 위한 Node를 저장한다.
						diagramNameMap.put(id+"_type",type); // 저장시 구분을 위해 Type를 가져온다.
					}
				}
			}
		}
		
		// Model.xml파일에 있는 있는 Element 중  TagName이 "packagedElement"이고 "star:category" 속성이 "diagramModel"
		// 인것을 가져온다.
		HashMap<String,Object> modelNameMap = new HashMap<String,Object>(); // name을 저장한다.
		ArrayList<String> modelIdArray = new ArrayList<String>(); // id를 저장한다. 추후 비교 값의로 사용한다.
		NodeList pkgNodeList = modelDoc.getDocumentElement().getElementsByTagName("packagedElement");
		for(int i=0; i<pkgNodeList.getLength(); i++){
			Node categoryAttr = pkgNodeList.item(i).getAttributes().getNamedItem("star:category");
			Node idAttr = pkgNodeList.item(i).getAttributes().getNamedItem("xmi:id");
			Node fileAttr = pkgNodeList.item(i).getAttributes().getNamedItem("star:file");
			Node typeAttr = pkgNodeList.item(i).getAttributes().getNamedItem("xmi:type");
			if(categoryAttr != null && fileAttr !=null){
				String id =  idAttr.getNodeValue();
				String name =  fileAttr.getNodeValue();
				String type =  typeAttr.getNodeValue();
				modelNameMap.put(id,name);
				modelNameMap.put(name,id);
				modelNameMap.put(id+"_node",pkgNodeList.item(i));
				modelIdArray.add(id);
			}
		}
		// View에 있는 모델을 수정하기 위한 환경 정보를 가져온다.
		IViewPart view_part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
		.findView(GlobalConstants.PluinID.STAR_PMS_MODEL_VIEW);
		StarPMSModelView modelView = (StarPMSModelView)view_part;
		TreeParent treeRoot = modelView.getTreeParent();
		// 다이어그램에 있는 ID를 기준의로 모델 ID를 비교하고 같은 아이디가 있는 경우에는 이름이 변경되었는지 확인한다.
		for(int i=0; i<diagramIdArray.size(); i++){
			// 같은 아이디가 있는지 검사한다.
			if(modelIdArray.contains(diagramIdArray.get(i))){
				String id = diagramIdArray.get(i);
				// 같은 아이디가 있는 경우 이름이 변경되었는지 비교한다.
				String modelName = (String)modelNameMap.get(id);
				String umlName = (String)diagramNameMap.get(id);
				// 이름이 변경된 경우 Model.xml 파일에 name,star:file 속성을 수정한 후 
				// View에 표시된 이름 및 Data에 등록된 값을 변경한다.
				if(!modelName.equals(umlName)){
					Node node = (Node)modelNameMap.get(id+"_node");
					// 노드 이름을 저장한다.
					String fullname = node.getAttributes().getNamedItem("name").getNodeValue();
					int start = fullname.indexOf("(");
					String partName = fullname.substring(start, fullname.length());
					fullname = umlName+partName;
					node.getAttributes().getNamedItem("star:file").setNodeValue(modelName);
					node.getAttributes().getNamedItem("name").setNodeValue(fullname);
					// View에 있는 Tree를 수정한다.
					for(int k=0; k <treeRoot.getChildren().length; k++){
						TreeObject[] modelTree = ((TreeParent)treeRoot.getChildren()[k]).getChildren();
						for(int j=0; j<modelTree.length; j++){
							TreeObject treeObject = (TreeObject)modelTree[j];
							String file = (String)treeObject.getData(GlobalConstants.StarMoedl.STAR_MODEL_FILE);
							if(file.equals(modelName)){
								treeObject.setData(GlobalConstants.StarMoedl.STAR_MODEL_FILE,modelName);
								treeObject.setName(fullname);
							}
						}
						
					}
				}
			// 같은 아이디가 없을 경우 Model.xml 및 View에 있는 Tree에 세롭게 추가한다.
			}else{ 
				// 추가될 노드의 부모를 변경된 다이어그램의 이름를 통하여 얻어온다.
				TreeParent parent = null;
				for(int h=0; h <treeRoot.getChildren().length; h++){
					TreeObject[] modelTree = ((TreeParent)treeRoot.getChildren()[h]).getChildren();
					for(int j=0; j<modelTree.length; j++){
						TreeObject treeObject = (TreeObject)modelTree[j];
						String file = (String)treeObject.getData(GlobalConstants.StarMoedl.STAR_MODEL_FILE);
						int end = diagramName.lastIndexOf(".");
						if(file.equals(diagramName.substring(0,end))){// 파일명 비교를 위해 확장자를 제거한다.
							parent = treeObject.getParent();
						}
					}
				}
				// 추가된 Node에 필요한 값들을 설정한다.
				String parentId = (String)parent.getData(GlobalConstants.StarMoedl.STAR_MODEL_ID);
				String id = diagramIdArray.get(i);
				String umlName = (String)diagramNameMap.get(id);
				String type = (String)diagramNameMap.get(id+"_type");
				// 트리에 노드를 추가한다.
				TreeObject treeObject = parent.appendChield(parent,umlName+"("+type.substring(4,type.length())+")",
							GlobalConstants.StarMoedl.STAR_MODEL_CATEGORY, 
							GlobalConstants.StarMoedl.STAR_CATEGORY_DIAGRAM_MODEL					);
				treeObject.setData(GlobalConstants.StarMoedl.STAR_MODEL_FILE, umlName);
				treeObject.setData(GlobalConstants.StarMoedl.STAR_MODEL_EXTENSION, type);
				treeObject.setData(GlobalConstants.StarMoedl.STAR_MODEL_ID, id);
				modelView.getTreeViewer().refresh();
				// model.xml에 노드를 추가한다.
				Element newNode = modelDoc.createElement("packagedElement");
				newNode.setAttribute(GlobalConstants.StarMoedl.STAR_MODEL_ID, id);
				newNode.setAttribute(GlobalConstants.StarMoedl.STAR_MODEL_CATEGORY, GlobalConstants.StarMoedl.STAR_CATEGORY_DIAGRAM_MODEL);
				newNode.setAttribute(GlobalConstants.StarMoedl.STAR_MODEL_TYPE, type);
				newNode.setAttribute(GlobalConstants.StarMoedl.STAR_MODEL_NAME, umlName+"("+diagramName+")");
				newNode.setAttribute(GlobalConstants.StarMoedl.STAR_MODEL_FILE, umlName);
				newNode.setAttribute(GlobalConstants.StarMoedl.STAR_MODEL_EXTENSION, type);
				newNode.setAttribute(GlobalConstants.StarMoedl.STAR_MODEL_USECASE_SEQ, "");
				// model.xml에서 새로운 노드를 추가할 부모를 가져온다. 현재 열린 다이어그램이름을 기준의로 찾아온다.
				int end = diagramName.lastIndexOf(".");
				String empId = (String)modelNameMap.get(diagramName.substring(0,end));
				Node currentNode = (Node)modelNameMap.get(empId+"_node");
				currentNode.getParentNode().appendChild(newNode);
			}
		}
		// 완료후 적용을 위해 파일 , View , Project를 리플레쉬한다.
		try {
			XmlUtil.writeXmlFile(modelDoc, modelPath);
			EclipseUtile.refreshProject("Root");
			modelView.getTreeViewer().refresh();
		} catch (Exception e) {
			e.printStackTrace();
		}
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
