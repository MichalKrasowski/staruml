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
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
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
import org.star.uml.designer.application.Activator;
import org.star.uml.designer.base.constance.GlobalConstants;
import org.star.uml.designer.base.utils.CommonUtil;
import org.star.uml.designer.base.utils.EclipseUtile;
import org.star.uml.designer.base.utils.XmlUtil;
import org.star.uml.designer.command.InsertActionCommand;
import org.star.uml.designer.ui.action.CreateConnectionAction;
import org.star.uml.designer.ui.diagram.action.UsecaseDiagramCreateAction;
import org.star.uml.designer.ui.factory.StarUMLActionFactory;
import org.star.uml.designer.ui.factory.StarUMLImageCreateFactory;
import org.star.uml.designer.ui.model.initialization.DefaultModel;
import org.star.uml.designer.ui.model.initialization.DefaultUML;
import org.star.uml.designer.ui.views.linstener.StarPMSModelViewMenuDoubleClickListener;
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
	private Boolean loginFlag = false;
	private HashMap actionMap;
	private TreeViewer viewer;
	private TreeParent root;
	private TreeParent invisibleRoot;
	Action createConnectionAction = null;
	
	
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
		public void setName(String name){
			this.name = name;
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
			viewer.refresh();
		}
		public TreeObject [] getChildren() {
			return (TreeObject [])children.toArray(new TreeObject[children.size()]);
		}
		public boolean hasChildren() {
			return children.size()>0;
		}
		public void appendChield(TreeParent parent, String name) {
			TreeObject chield = new TreeObject(name);
//			chield.setData("path", (String)data.get("path"));
//			chield.setData("req_usecase_seq", (String)data.get("req_usecase_seq"));
			addChild(chield);
			viewer.refresh();
		}
		public TreeObject appendChield(TreeParent parent, String name, String key, String value) {
			TreeObject chield = new TreeObject(name);
			chield.setData(key, value);
			addChild(chield);
			return chield;
		}
	}

	class ViewLabelProvider extends LabelProvider {
		public String getText(Object obj) {
			return obj.toString();
		}
		public Image getImage(Object obj) {
			String imageKey = null;
			if (obj instanceof TreeParent){
			   imageKey = ISharedImages.IMG_OBJ_FOLDER;
			}else{
				TreeObject treeObj = (TreeObject)obj;
				String category = (String)treeObj.getData(GlobalConstants.StarMoedl.STAR_MODEL_CATEGORY);
				String extension = (String)treeObj.getData(GlobalConstants.StarMoedl.STAR_MODEL_EXTENSION);
				return StarUMLImageCreateFactory.getImage(category, extension);
//				imageKey = ISharedImages.IMG_OBJ_ELEMENT;
			}
			return PlatformUI.getWorkbench().getSharedImages().getImage(imageKey);
		}
	}
	class NameSorter extends ViewerSorter {
		public NameSorter() {
			super();
		}
		@Override
		public int compare(Viewer viewer, Object e1, Object e2) {
			int rusltint = 0;
			if(e1 instanceof StarPMSModelView.TreeObject){
				TreeObject object1 = (TreeObject)e1;
				TreeObject object2 = (TreeObject)e2;
				String object1_org = object1.getName();
				String object2_org = object2.getName();
				String category1 = (String)object1.getData(GlobalConstants.StarMoedl.STAR_MODEL_CATEGORY);
				String extension1 = (String)object1.getData(GlobalConstants.StarMoedl.STAR_MODEL_EXTENSION);
				String file1 = (String)object1.getData(GlobalConstants.StarMoedl.STAR_MODEL_FILE);
				String type1 = (String)object1.getData(GlobalConstants.StarMoedl.STAR_MODEL_FILE);
				String category2 = (String)object2.getData(GlobalConstants.StarMoedl.STAR_MODEL_CATEGORY);
				String extension2 = (String)object2.getData(GlobalConstants.StarMoedl.STAR_MODEL_EXTENSION);
				String file2 = (String)object2.getData(GlobalConstants.StarMoedl.STAR_MODEL_FILE);
				String type2 = (String)object2.getData(GlobalConstants.StarMoedl.STAR_MODEL_FILE);
				String object1_name = category1+"_"+extension1+"_"+type1+"_"+file1;
				String object2_name = category2+"_"+extension2+"_"+type2+"_"+file1;
				object1.setName(object1_name);
				object2.setName(object2_name);
				rusltint = super.compare(viewer, e1, e2);
				object1.setName(object1_org);
				object2.setName(object2_org);
			}
			return rusltint;
		}
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
		createToolBar();
		closeEditor();
	}
	
	/**
	 * 로드 될때 다이어그램이 열려있을 경우 닫는다.
	 */
	public void closeEditor(){
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(page != null && page.getActiveEditor() !=null && page.getActiveEditor() instanceof DiagramDocumentEditor){
			page.closeAllEditors(false);
		}
	}
	
	private void createToolBar() {
		IToolBarManager mgr = getViewSite().getActionBars().getToolBarManager();
		createConnectionAction = new CreateConnectionAction();
		mgr.add(createConnectionAction);
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

	private void hookDoubleClickAction() {
		StarPMSModelViewMenuDoubleClickListener lisnener = 
			new StarPMSModelViewMenuDoubleClickListener();
		viewer.addDoubleClickListener(lisnener);
	}
	
	private void showMessage(String message) {
		MessageDialog.openInformation(
			viewer.getControl().getShell(),
			"StarUML View",
			message);
	}

	public void setFocus() { viewer.getControl().setFocus(); }
	
	public HashMap getActionMap(){
		return actionMap;
	}
	
	public boolean getLoginFlag(){
		return loginFlag;
	}
	
	public void setLoginFlag(boolean loginFlag){
		this.loginFlag = loginFlag;
	}
	
	public TreeViewer getTreeViewer(){
		return viewer;
	}
	
	public TreeParent getTreeParent(){
		return root;
	}
	
	public void setTreeParent(TreeParent root){
		this.root=root;
	}
	
	public TreeParent getInvisibleRoot(){
		return invisibleRoot;
	}
	
	public TreeParent createTreeParent(String name){
		return new TreeParent(name);
	}
	
	public TreeObject createTreeObject(String name){
		return new TreeObject(name);
	}
	
	class ViewContentProvider implements IStructuredContentProvider,ITreeContentProvider {
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
		
		public void initialize() {
//			root = new TreeParent("192.168.10.102:1521/StarPMS");
//			root.setData(GlobalConstants.TREE_PATH, "root");
			invisibleRoot = new TreeParent("");
//			invisibleRoot.addChild(root);
		}
		
	}

}
