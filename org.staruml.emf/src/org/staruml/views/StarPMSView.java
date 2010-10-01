package org.staruml.views;

import java.io.File;
import java.io.FileNotFoundException;
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
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdaptable;
import org.osgi.framework.Bundle;
import org.xml.sax.InputSource;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Path;
import org_.staruml.Activator;
import org.eclipse.swt.widgets.TreeItem;

import java.io.FileInputStream;

public class StarPMSView extends ViewPart {

	public static final String ID = "org.staruml.views.StarUMLView";

	private TreeViewer viewer;
	private DrillDownAdapter drillDownAdapter;
	private Action action1,action2,action3,action4;
	private Action doubleClickAction;
	
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
		public void appendChield(TreeParent parent, String string, String path) {
			TreeObject chield = new TreeObject(string);
			chield.setData("path", path);
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
	public StarPMSView() {
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
		PlatformUI.getWorkbench().getHelpSystem().setHelp(viewer.getControl(), "org.StarUML.viewer");
		makeActions();
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
					System.out.println(nodeText+" : "+nodePath);
					if(nodeText.equals("[192.168.10.102:1521/StarPMS]")){
						StarPMSView.this.fillLoginContextMenu(manager);
					}else if(nodePath != null && nodeText.equals("[<<designModel>>Design Model]")){
						StarPMSView.this.fillDesignContextMenu(manager,parent,selection);
					}else if(nodePath != null && nodePath.equals("Implementation/Class/diagram")){
						StarPMSView.this.fillImplementationClassDiagramContextMenu(manager,parent,selection);
					}else if(nodePath != null && nodePath.equals("Analysis/Sequence/diagram")){
						StarPMSView.this.fillSequenceDiagramContextMenu(manager,parent,selection);
					}else if(nodePath != null && nodePath.equals("Analysis/Usecase")){
						StarPMSView.this.fillAnalysisUseCaseContextMenu(manager,parent,selection);
					}else if(nodePath != null && nodePath.equals("Analysis/Usecase/diagram")){
						StarPMSView.this.fillAnalysisUseCaseDiagramContextMenu(manager,parent,selection);
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
		fillLocalPullDown(bars.getMenuManager());
		fillLocalToolBar(bars.getToolBarManager());
	}

	private void fillLocalPullDown(IMenuManager manager) {
		manager.add(action1);
		manager.add(new Separator());
		manager.add(action2);
	}
	
	private void fillAnalysisUseCaseContextMenu(IMenuManager manager,Composite parent,ISelection selection) {
		Action analysisAction = StarPMSViewUtil.makeAnalysisUsecaseAction(parent,selection,this);
		manager.add(analysisAction);
	}
	
	private void fillAnalysisUseCaseDiagramContextMenu(IMenuManager manager,Composite parent,ISelection selection) {
		Action analysisAction = StarPMSViewUtil.makeAnalysisUseCaseDiagramAction(parent,selection,this);
		manager.add(analysisAction);
	}
	
	private void fillSequenceDiagramContextMenu(IMenuManager manager,Composite parent,ISelection selection) {
		Action deploymentAction = StarPMSViewUtil.makeSequenceDiagramAction(parent,selection);
		Action usecaseReportAction = new Action() {
			public void run() {
				IViewPart view_part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView("org.staruml.views.StarPMSBrowersView");
	            StarPMSBrowersView brower = (StarPMSBrowersView)view_part;
	            brower.setURL("http://192.168.10.193:8080/starPMS/processMgt/viewUseCaseReportSimple.do");
	            try {
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView("org.staruml.views.StarPMSBrowersView");
				} catch (PartInitException e) {
					e.printStackTrace();
				}
			}
		};
		usecaseReportAction.setText("View Usecase Report");
		usecaseReportAction.setImageDescriptor(Activator.getImageDescriptor("/icons/login.gif"));
		manager.add(deploymentAction);
		manager.add(usecaseReportAction);
	}
	
	private void fillDesignContextMenu(IMenuManager manager,Composite parent,ISelection selection) {
		Action designAction = StarPMSViewUtil.makeDesignAction(parent,selection);
		manager.add(designAction);
	}
	
	private void fillImplementationClassDiagramContextMenu(IMenuManager manager,Composite parent,ISelection selection) {
		Action implementationAction = StarPMSViewUtil.makeImplemetationClassDiagramAction(parent,selection);
		manager.add(implementationAction);
	}
	
	
	private void fillLoginContextMenu(IMenuManager manager) {
		Action loginAction = StarPMSViewUtil.makeLoginAction();
		Action logoutAction =StarPMSViewUtil.makeLogoutAction();
		manager.add(loginAction);
		manager.add(logoutAction);
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
	
	private void fillLocalToolBar(IToolBarManager manager) {
		drillDownAdapter.addNavigationActions(manager);
		manager.add(new Separator());
		manager.add(action1);
		manager.add(action2);
		manager.add(action3);
		manager.add(new Separator());
		manager.add(action4);
	}

	private void makeActions() {
		action1 = new Action() {
			public void run() {
				ISelection selection = viewer.getSelection();
				Object obj = ((IStructuredSelection)selection).getFirstElement();
				if(obj.toString().equals("목표입력 권한")){
					showMessage("");
				}
			}
		};
		action1.setText("View Model");
		action1.setToolTipText("View Model tooltip");
		action1.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
			getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
		
		action2 = new Action() {
			public void run() {
				ISelection selection = viewer.getSelection();
				Object obj = ((IStructuredSelection)selection).getFirstElement();
				showMessage(obj.toString()+"에 다이어그램이 삭제되었습니다.");
			}
		};
		action2.setText("Delete Model");
		action2.setToolTipText("Delete Model tooltip");
		action2.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
				getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
		
		action3 = new Action() {
			public void run() {
				ISelection selection = viewer.getSelection();
				Object obj = ((IStructuredSelection)selection).getFirstElement();
				showMessage(obj.toString()+"에 다이어그램이 저장되었습니다.");
			}
		};
		action3.setText("Link Model");
		action3.setToolTipText("저장하기 tooltip");
		action3.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
				getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
		
		action4 = new Action() {
			public void run() {
				ISelection selection = viewer.getSelection();
				Object obj = ((IStructuredSelection)selection).getFirstElement();
				showMessage(obj.toString()+"에 다이어그램이 저장되었습니다.");
			}
		};
		action4.setText("Properties");
		action4.setToolTipText("Properties tooltip");
		action4.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
				getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
		
		
		doubleClickAction = new Action() {
			public void run() {
				ISelection selection = viewer.getSelection();
				Object obj = ((IStructuredSelection)selection).getFirstElement();
				Bundle bundle = Platform.getBundle("org.StarUML");
				String bundleDir = bundle.getLocation();
				String diagramDir = bundleDir+"diagram/";
				File diagramFile = new File(diagramDir+"p1_1.uml");
				
				if(obj.toString().equals("목표입력 권한")){
					showMessage("");
				}
			}
		};
	}

	private void hookDoubleClickAction() {
		viewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				doubleClickAction.run();
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
			TreeParent root = new TreeParent("192.168.10.102:1521/StarPMS");
			TreeParent project = new TreeParent("회의실 예약 관리 시스템");
			root.addChild(project);

			TreeParent diagram_2 = new TreeParent("<<analysisModel>>Analysis Model");
			project.addChild(diagram_2);
			TreeParent diagram_2_1 = new TreeParent("Usecase Diagram");
			diagram_2.addChild(diagram_2_1);
			diagram_2_1.setData("path", "Analysis/Usecase");
			TreeParent diagram_2_2 = new TreeParent("Sequence Diagram");
			diagram_2.addChild(diagram_2_2);
			diagram_2_2.setData("path", "Analysis/Sequence");
			
			TreeParent diagram_3 = new TreeParent("<<designModel>>Design Model");
			project.addChild(diagram_3);
			
			TreeParent diagram_4 = new TreeParent("<<implementationModel>>Implementation Model");
			TreeParent diagram_4_1 = new TreeParent("Class Diagram");
			diagram_4.addChild(diagram_4_1);
			diagram_4_1.setData("path", "Implementation/Class");
			project.addChild(diagram_4);
			
			TreeParent diagram_5 = new TreeParent("<<deploymentModel>>Deployment Model");
			project.addChild(diagram_5);

			invisibleRoot = new TreeParent("");
			invisibleRoot.addChild(root);
		}
	}
	
}