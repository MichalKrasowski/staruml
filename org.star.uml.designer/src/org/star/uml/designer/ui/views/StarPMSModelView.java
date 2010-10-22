package org.star.uml.designer.ui.views;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.part.*;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramEditDomain;
import org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDiagramDocument;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.MetamodelType;
import org.eclipse.gmf.runtime.emf.type.core.internal.impl.HintedTypeFactory;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.FontStyle;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.*;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.jface.action.*;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.*;
import org.eclipse.uml2.diagram.usecase.edit.commands.ActorCreateCommand;
import org.eclipse.uml2.diagram.usecase.edit.helpers.ActorEditHelper;
import org.eclipse.uml2.diagram.usecase.edit.parts.ActorEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.ActorNameEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.PackageEditPart;
import org.eclipse.uml2.diagram.usecase.part.UMLDiagramEditor;
import org.eclipse.uml2.diagram.usecase.part.UMLVisualIDRegistry;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.internal.impl.ActorImpl;
import org.eclipse.uml2.uml.internal.impl.UMLFactoryImpl;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.SWT;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdaptable;
import org.osgi.framework.Bundle;
import org.star.uml.designer.base.constance.GlobalConstants;
import org.star.uml.designer.base.utils.CommonUtil;
import org.star.uml.designer.base.utils.EclipseUtile;
import org.star.uml.designer.base.utils.XmlUtil;
import org.star.uml.designer.command.InsertActionCommand;
import org.star.uml.designer.ui.diagram.action.UsecaseDiagramCreateAction;
import org.star.uml.designer.ui.factory.StarUMLActionFactory;
import org.star.uml.designer.ui.model.initialization.DefaultModel;
import org.star.uml.designer.ui.model.initialization.DefaultUML;
import org.star.uml.designer.ui.views.linstener.StarPMSModelViewMenuListener;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Path;
import org.eclipse.swt.widgets.TreeItem;

import java.io.FileInputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

public class StarPMSModelView extends ViewPart {

	public static final String ID = "org.star.uml.designer.ui.views.StarPMSModelView";

	private DrillDownAdapter drillDownAdapter;
	private TreeParent root;
	private Boolean loginFlag = false;
	private HashMap actionMap;
	
	public TreeViewer viewer;
	
	
	public class TreeObject implements IAdaptable {
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
	
	public class TreeParent extends TreeObject {
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
		
		hookContextMenu(parent);
		hookDoubleClickAction();
		contributeToActionBars();
		hookSelectAction();
	}

	private void hookContextMenu(final Composite parent) {
		final MenuManager manager = new MenuManager("#PopupMenu");
//		manager.setRemoveAllWhenShown(true);
		Menu menu = manager.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(manager, viewer);
		StarPMSModelViewUtil.initContextMenu(manager);
		StarPMSModelViewMenuListener menuListener = new StarPMSModelViewMenuListener();
		manager.addMenuListener(menuListener);
		actionMap = EclipseUtile.getActionMap((MenuManager)manager);
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
	
	private void hookDoubleClickAction() {
		viewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				TreeSelection selection = (TreeSelection)viewer.getSelection();
				TreeObject treeObject = (TreeObject)selection.getFirstElement();
				String nodeText = selection.toString();
				String fullName = (String)treeObject.getData("fullName");
				EclipseUtile.openDiagram("/Root/" + fullName);
			}
		});
	}
	
	private void hookSelectAction() {
//		viewer.addSelectionChangedListener(new ISelectionChangedListener(){
//			@Override
//			public void selectionChanged(SelectionChangedEvent event) {
//				TreeSelection selection = (TreeSelection)viewer.getSelection();
//				TreeObject treeObject = (TreeObject)selection.getFirstElement();
//				String nodeText = selection.toString();
//				IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
//				final View view = null;
//				final TransactionalEditingDomain domain= null;
//				IDiagramEditDomain editingDomain= null;
//				if(page.getActiveEditor() !=null && page.getActiveEditor() instanceof org.eclipse.uml2.diagram.usecase.part.UMLDiagramEditor){
//		        	final org.eclipse.uml2.diagram.usecase.part.UMLDiagramEditor editor = 
//		        		(org.eclipse.uml2.diagram.usecase.part.UMLDiagramEditor)page.getActiveEditor();
//		        	Action action = StarUMLActionFactory.getAction(editor, "Actor");
//		        	action.run();
//				}
//			}
//		});
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
	
	public void addChildXml(String eName, String key, String name,String fullName){
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
					newNode.setAttribute("star:fullName", fullName);
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
				for(int y=0; y< subPkg.getAttributes().getLength() ;y++){
					String key = subPkg.getAttributes().item(y).getNodeName();
					String value = subPkg.getAttributes().item(y).getNodeValue();
					project.setData(key, value);
				}
				String category = subPkg.getAttributes().getNamedItem("star:category").getNodeValue();
				if(category.equals("diagram") || category.equals("model")){
					String fullName = subPkg.getAttributes().getNamedItem("star:fullName").getNodeValue();
					TreeObject projectObject = new TreeObject(attrName);
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
	
	public HashMap getActionMap(){
		return actionMap;
	}
	
	public boolean getLoginFlag(){
		return loginFlag;
	}
	
	public void setLoginFlag(boolean loginFlag){
		this.loginFlag = loginFlag;
	}
	
	class ViewContentProvider implements IStructuredContentProvider,ITreeContentProvider {
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
			root.setData(GlobalConstants.TREE_PATH, "root");
			invisibleRoot = new TreeParent("");
			invisibleRoot.addChild(root);
		}
		
	}

}
