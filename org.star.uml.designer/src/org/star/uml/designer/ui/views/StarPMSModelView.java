package org.star.uml.designer.ui.views;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.part.*;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.*;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.jface.action.*;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.*;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.SWT;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdaptable;
import org.osgi.framework.Bundle;
import org.star.uml.designer.base.utils.CommonUtil;
import org.star.uml.designer.base.utils.EclipseUtile;
import org.star.uml.designer.base.utils.XmlUtil;
import org.star.uml.designer.ui.model.initialization.DefaultModel;
import org.star.uml.designer.ui.model.initialization.DefaultUML;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Path;
import org.eclipse.swt.widgets.TreeItem;

import java.io.FileInputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

public class StarPMSModelView extends ViewPart {

	public static final String ID = "org.star.uml.designer.ui.views.StarPMSModelView";

	private TreeViewer viewer;
	private DrillDownAdapter drillDownAdapter;
	private Action action1,action2,action3,action4;
	private Action doubleClickAction;
	private TreeParent root;
	private Boolean flag = true;
	Action loginAction = null;
	Action logoutAction = null;
	class TreeObject implements IAdaptable {
		private String name;
		private TreeParent parent;
		private HashMap data;
		
		public TreeObject(String name) {
			this.name = name;
			data = new HashMap();
		}
		public String getName() {
			return name;
		}
		public void setParent(TreeParent parent) {
			this.parent = parent;
		}
		public TreeParent getParent() {
			return parent;
		}
		public String toString() {
			return getName();
		}
		public Object getAdapter(Class key) {
			return null;
		}
		public void setData(String key,Object value){
			data.put(key, value);
		}
		public Object getData(String key){
			return data.get(key);
		}
	}
	
	class TreeParent extends TreeObject {
		private ArrayList children;
		public TreeParent(String name) {
			super(name);
			children = new ArrayList();
		}
		public void addChild(TreeObject child) {
			children.add(child);
			child.setParent(this);
		}
		public void removeChild(TreeObject child) {
			children.remove(child);
			child.setParent(null);
		}
		public TreeObject [] getChildren() {
			return (TreeObject [])children.toArray(new TreeObject[children.size()]);
		}
		public boolean hasChildren() {
			return children.size()>0;
		}
		public void appendChield(TreeParent parent, String string, HashMap data) {
			TreeObject chield = new TreeObject(string);
			chield.setData("path", (String)data.get("path"));
			chield.setData("req_usecase_seq", (String)data.get("req_usecase_seq"));
			addChild(chield);
			viewer.refresh();
		}
	}

	class ViewLabelProvider extends LabelProvider {

		public String getText(Object obj) {
			return obj.toString();
		}
		public Image getImage(Object obj) {
			String imageKey = ISharedImages.IMG_OBJ_ELEMENT;
			if (obj instanceof TreeParent)
			   imageKey = ISharedImages.IMG_OBJ_FOLDER;
			return PlatformUI.getWorkbench().getSharedImages().getImage(imageKey);
		}
	}
	class NameSorter extends ViewerSorter {
	}

	/**
	 * The constructor.
	 */
	public StarPMSModelView() {
	}
	
	public void removeTree(){
		TreeObject[] t = root.getChildren();
		for(int i = 0; i < t.length; i++){
			TreeObject s = t[i];
			root.removeChild(s);
		}
		
		viewer.refresh();
	}
	
	/**
	 * This is a callback that will allow us
	 * to create the viewer and initialize it.
	 */
	public void createPartControl(Composite parent) {
		viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		drillDownAdapter = new DrillDownAdapter(viewer);
		viewer.setContentProvider(new ViewContentProvider());
		viewer.setLabelProvider(new ViewLabelProvider());
		viewer.setSorter(new NameSorter());
		viewer.setInput(getViewSite());
		// Create the help context id for the viewer's control
		PlatformUI.getWorkbench().getHelpSystem().setHelp(viewer.getControl(), "org.star.uml.designer");
		hookContextMenu(parent);
		hookDoubleClickAction();
		contributeToActionBars();
	}

	private void hookContextMenu(final Composite parent) {
		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				TreeSelection selection = (TreeSelection)viewer.getSelection();
				if(!selection.isEmpty()){
					TreeObject treeObject = (TreeObject)selection.getFirstElement();
					String nodeText = selection.toString();
					String nodePath = (String)treeObject.getData("path");
					if(nodeText.equals("[192.168.10.102:1521/StarPMS]")){
						StarPMSModelView.this.fillLoginContextMenu(manager);
					}else if(nodeText != null && nodeText.equals("[Userecase Diagram]")){
						StarPMSModelView.this.fillAnalysisUseCaseContextMenu(manager,parent,selection);
					}else{
						StarPMSModelView.this.removeContextMenu(manager,parent,selection);
					}
					
					if(nodePath != null && nodePath.equals("Class Diagram/diagram")){
						StarPMSModelView.this.fillImplementationClassDiagramContextMenu(manager,parent,selection);
					}else if(nodePath != null && nodePath.equals("Userecase Diagram/diagram")){
						StarPMSModelView.this.fillAnalysisUseCaseDiagramContextMenu(manager,parent,selection);
					}else if(nodePath != null && nodePath.equals("Sequence Diagram/diagram")){
						StarPMSModelView.this.fillSequenceDiagramContextMenu(manager,parent,selection);
					}
				}
			}
		});
		Menu menu = menuMgr.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, viewer);
	}

	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
	}
	
	private void removeContextMenu(IMenuManager manager,Composite parent,ISelection selection) {
		manager.removeAll();
	}

	private void fillAnalysisUseCaseContextMenu(IMenuManager manager,Composite parent,ISelection selection) {
		Action analysisAction = StarPMSModelViewUtil.makeAnalysisUsecaseAction(parent,selection,this);
		manager.add(analysisAction);
	}
	
	private void fillAnalysisUseCaseDiagramContextMenu(IMenuManager manager,Composite parent,ISelection selection) {
		Action analysisAction = StarPMSModelViewUtil.makeAnalysisUseCaseDiagramAction(parent,selection,this);
		Action analysisSaveAction =StarPMSModelViewUtil.makeAnalysisUseCaseDiagramSaveAction(parent,selection); 
		manager.add(analysisAction);
		manager.add(analysisSaveAction);
	}
	
	private void fillSequenceDiagramContextMenu(IMenuManager manager,Composite parent,ISelection selection) {
		Action analysisSaveAction =StarPMSModelViewUtil.makeAnalysisSequenceDiagramSaveAction(parent,selection); 
		Action usecaseReportAction =StarPMSModelViewUtil.makeUsecaseReportAction(parent,selection); 
		manager.add(usecaseReportAction);
		manager.add(analysisSaveAction);
	}
	
	private void fillImplementationClassDiagramContextMenu(IMenuManager manager,Composite parent,ISelection selection) {
		Action implementationAction = StarPMSModelViewUtil.makeImplemetationClassDiagramAction(parent,selection);
		manager.add(implementationAction);
	}
	
	private void fillLoginContextMenu(IMenuManager manager) {
		
		if(flag){
			loginAction = StarPMSModelViewUtil.makeLoginAction(manager);
			logoutAction = StarPMSModelViewUtil.makeLogoutAction(manager);
			flag = false;
		}else{
			manager.add(loginAction);
			manager.add(logoutAction);
		}
	}

	private void fillContextMenu(IMenuManager manager) {
		drillDownAdapter.addNavigationActions(manager);
		manager.add(new Separator());
		manager.add(action1);
		manager.add(action2);
		manager.add(action3);
		manager.add(new Separator());
		manager.add(action4);
		// Other plug-ins can contribute there actions here
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}
	
	private void hookDoubleClickAction() {
		viewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				TreeSelection selection = (TreeSelection)viewer.getSelection();
				TreeObject treeObject = (TreeObject)selection.getFirstElement();
				String nodeText = selection.toString();
				String exetension = (String)treeObject.getData("star:exetension");
				EclipseUtile.openDiagram("/Root/" + treeObject.getName() + exetension);
//				doubleClickAction.run();
			}
		});
	}
	private void showMessage(String message) {
		MessageDialog.openInformation(
			viewer.getControl().getShell(),
			"StarUML View",
			message);
	}

	public void setFocus() {
		viewer.getControl().setFocus();
	}
	
	public void addChildXml(String eName, String key, String name){
		//Userecase Diagram
		IProject rootProject = ResourcesPlugin.getWorkspace().getRoot().getProject("Root");
		Document modelDoc = null;
		try{
			String projectPath = rootProject.getLocation().toOSString();
			String domStr = XmlUtil.getXmlFileToString(projectPath+File.separator+"model.xml");
			modelDoc = XmlUtil.getStringToDocument(domStr);
			NodeList n = modelDoc.getDocumentElement().getElementsByTagName("packagedElement");
			for(int i = 0; i < n.getLength(); i++){
				Node node = n.item(i);
				NamedNodeMap attrMap = node.getAttributes();
				if(attrMap.getNamedItem("xmi:id") != null && attrMap.getNamedItem("xmi:id").getNodeValue().equals(key)){
					Element newNode = modelDoc.createElement(eName);
					newNode.setAttribute("xmi:id", "_" + CommonUtil.randomKey() + "-GMK-em0Iv_Q");
					newNode.setAttribute("star:category", "diagram");
					newNode.setAttribute("path", "diagram");
					newNode.setAttribute("xmi:type", "uml:Package");
					newNode.setAttribute("name", name);
					node.appendChild(newNode);
					XmlUtil.writeXmlFile(modelDoc, projectPath+File.separator+"model.xml");
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void loadModel(){
		IProject rootProject = ResourcesPlugin.getWorkspace().getRoot().getProject("Root");
		Document modelDoc = null;
		if(rootProject.exists()){
			try {
				String projectPath = rootProject.getLocation().toOSString();
				String domStr = XmlUtil.getXmlFileToString(projectPath+File.separator+"model.xml");
				modelDoc = XmlUtil.getStringToDocument(domStr);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			try {
				modelDoc = XmlUtil.getStringToDocument(DefaultModel.getXML());
				Document umlDoc = XmlUtil.getStringToDocument(DefaultUML.getXML());
				IProject newProjectHandle = EclipseUtile.createNewProject("Root",modelDoc,umlDoc);
				String projectPath = newProjectHandle.getLocation().toOSString();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		Node rootNode = modelDoc.getChildNodes().item(0);
		Node subPkgNode = rootNode.getChildNodes().item(9);
		setTreeFormXML(subPkgNode,root);
		viewer.refresh();
	}
	
	public void setTreeFormXML(Node pkgeElement,TreeParent parent){
		for(int i=0; i<pkgeElement.getChildNodes().getLength(); i++){
			Node subPkg = pkgeElement.getChildNodes().item(i);
			if(subPkg.getNodeName().equals("packagedElement")){
				String attrName = subPkg.getAttributes().getNamedItem("name").getNodeValue();
				TreeParent project = new TreeParent(attrName);
				if(subPkg.getAttributes().getNamedItem("xmi:id") != null){
					project.setData("key", subPkg.getAttributes().getNamedItem("xmi:id").getNodeValue());
				}
				
				if(subPkg.getAttributes().getNamedItem("star:category") != null && subPkg.getAttributes().getNamedItem("star:category").getNodeValue().equals("diagram")){
					TreeObject projectObject = new TreeObject(attrName);
					projectObject.setData("star:exetension", ".umlusc");
					projectObject.setData("star:category", ".umlusc");
					projectObject.setData("path",parent.toString()+"/diagram");
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
	
	class ViewContentProvider implements IStructuredContentProvider,
			ITreeContentProvider {
		private TreeParent invisibleRoot;

		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
		}

		public void dispose() {
		}

		public Object[] getElements(Object parent) {
			if (parent.equals(getViewSite())) {
				if (invisibleRoot == null)
					initialize();
				return getChildren(invisibleRoot);
			}
			return getChildren(parent);
		}

		public Object getParent(Object child) {
			if (child instanceof TreeObject) {
				return ((TreeObject) child).getParent();
			}
			return null;
		}

		public Object[] getChildren(Object parent) {
			if (parent instanceof TreeParent) {
				return ((TreeParent) parent).getChildren();
			}
			return new Object[0];
		}

		public boolean hasChildren(Object parent) {
			if (parent instanceof TreeParent)
				return ((TreeParent) parent).hasChildren();
			return false;
		}
		
		private void initialize() {
			root = new TreeParent("192.168.10.102:1521/StarPMS");
			invisibleRoot = new TreeParent("");
			invisibleRoot.addChild(root);
		}
		
	}

}
