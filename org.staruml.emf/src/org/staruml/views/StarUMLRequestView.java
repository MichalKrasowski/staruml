package org.staruml.views;

import java.util.ArrayList;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.*;
import org.eclipse.jface.viewers.*;
import org.eclipse.swt.graphics.Image;
import org.eclipse.jface.action.*;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.*;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.SWT;
import org.eclipse.core.runtime.IAdaptable;


/**
 * This sample class demonstrates how to plug-in a new
 * workbench view. The view shows data obtained from the
 * model. The sample creates a dummy model on the fly,
 * but a real implementation would connect to the model
 * available either in this or another plug-in (e.g. the workspace).
 * The view is connected to the model using a content provider.
 * <p>
 * The view uses a label provider to define how model
 * objects should be presented in the view. Each
 * view can present the same model objects using
 * different labels and icons, if needed. Alternatively,
 * a single label provider can be shared between views
 * in order to ensure that objects of the same type are
 * presented in the same way everywhere.
 * <p>
 */

public class StarUMLRequestView extends ViewPart {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "org.staruml.views.StarUMLRequestView";

	private TreeViewer viewer;
	private DrillDownAdapter drillDownAdapter;
	private Action action1;
	private Action action2;
	private Action doubleClickAction;

	/*
	 * The content provider class is responsible for
	 * providing objects to the view. It can wrap
	 * existing objects in adapters or simply return
	 * objects as-is. These objects may be sensitive
	 * to the current input of the view, or ignore
	 * it and always show the same content 
	 * (like Task List, for example).
	 */
	 
	class TreeObject implements IAdaptable {
		private String name;
		private TreeParent parent;
		
		public TreeObject(String name) {
			this.name = name;
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
				if (invisibleRoot==null) initialize();
				return getChildren(invisibleRoot);
			}
			return getChildren(parent);
		}
		public Object getParent(Object child) {
			if (child instanceof TreeObject) {
				return ((TreeObject)child).getParent();
			}
			return null;
		}
		public Object [] getChildren(Object parent) {
			if (parent instanceof TreeParent) {
				return ((TreeParent)parent).getChildren();
			}
			return new Object[0];
		}
		public boolean hasChildren(Object parent) {
			if (parent instanceof TreeParent)
				return ((TreeParent)parent).hasChildren();
			return false;
		}
/*
 * We will set up a dummy model to initialize tree heararchy.
 * In a real code, you will connect to a real model and
 * expose its hierarchy.
 */
		private void initialize() {
			TreeParent root = new TreeParent("192.168.10.102:1521/StarPMS");
			TreeParent project = new TreeParent("�����̻���� �ý���");
			root.addChild(project);

			TreeParent step_1 = new TreeParent("�䱸����");
			project.addChild(step_1);

			TreeParent step_1_task_1 = new TreeParent("��ǥ�Է� ��� �����");
			step_1.addChild(step_1_task_1);

			TreeParent step_1_task_1_main_1 = new TreeParent("��ǥ�Է� ����");
			step_1_task_1.addChild(step_1_task_1_main_1);

			TreeObject step_1_task_1_main_1_sub_1 = new TreeObject("��ǥ�Է� ���");
			step_1_task_1_main_1.addChild(step_1_task_1_main_1_sub_1);

			TreeObject step_1_task_1_main_1_sub_2 = new TreeObject("��ǥ�Է� ����");
			step_1_task_1_main_1.addChild(step_1_task_1_main_1_sub_2);

			TreeParent step_1_task_1_main_2 = new TreeParent("��ǥ���� ���");
			step_1_task_1.addChild(step_1_task_1_main_2);

			TreeObject step_1_task_1_main_2_sub_1 = new TreeObject("�ǽð�������ȸ �����");
			step_1_task_1_main_2.addChild(step_1_task_1_main_2_sub_1);

			TreeObject step_1_task_1_main_2_sub_2 = new TreeObject("������ȸ �����");
			step_1_task_1_main_2.addChild(step_1_task_1_main_2_sub_2);

			TreeParent step_1_task_2 = new TreeParent("�ǽð��� ������ ����");
			step_1.addChild(step_1_task_2);

			TreeParent step_1_task_2_main_1 = new TreeParent("�������� ���� ����");
			step_1_task_2.addChild(step_1_task_2_main_1);

			TreeObject step_1_task_2_main_1_sub_1 = new TreeObject("������ǥ ����");
			step_1_task_2_main_1.addChild(step_1_task_2_main_1_sub_1);

			TreeObject step_1_task_2_main_1_sub_2 = new TreeObject("���Ž��� �ݿ�");
			step_1_task_2_main_1.addChild(step_1_task_2_main_1_sub_2);

			TreeParent step_1_task_2_main_2 = new TreeParent("�������� ����");
			step_1_task_2.addChild(step_1_task_2_main_2);

			TreeObject step_1_task_2_main_2_sub_1 = new TreeObject("�̻�߻� �� �˸� ���");
			step_1_task_2_main_2.addChild(step_1_task_2_main_2_sub_1);

			TreeObject step_1_task_2_main_2_sub_2 = new TreeObject("���� �� ��ȸ ����");
			step_1_task_2_main_2.addChild(step_1_task_2_main_2_sub_2);

			TreeParent step_2 = new TreeParent("�䱸���� �м�");
			project.addChild(step_2);

			TreeParent step_2_task_1 = new TreeParent("��ǥ�Է� ��� �����");
			step_2_task_1.addChild(step_2_task_1);

			TreeParent step_2_task_1_main_1 = new TreeParent("��ǥ�Է� ����");
			step_2_task_1.addChild(step_2_task_1_main_1);

			TreeObject step_2_task_1_main_1_sub_1 = new TreeObject("��ǥ�Է� ���");
			step_2_task_1_main_1.addChild(step_2_task_1_main_1_sub_1);

			TreeObject step_2_task_1_main_1_sub_2 = new TreeObject("��ǥ�Է� ����");
			step_2_task_1_main_1.addChild(step_2_task_1_main_1_sub_2);

			TreeParent step_2_task_1_main_2 = new TreeParent("��ǥ���� ���");
			step_2_task_1.addChild(step_2_task_1_main_2);

			TreeObject step_2_task_1_main_2_sub_1 = new TreeObject("�ǽð�������ȸ �����");
			step_2_task_1_main_2.addChild(step_2_task_1_main_2_sub_1);

			TreeObject step_2_task_1_main_2_sub_2 = new TreeObject("������ȸ �����");
			step_2_task_1_main_2.addChild(step_2_task_1_main_2_sub_2);

			TreeParent step_2_task_2 = new TreeParent("�ǽð��� ������ ����");
			step_2.addChild(step_2_task_2);

			TreeParent step_2_task_2_main_1 = new TreeParent("�������� ���� ����");
			step_2_task_2.addChild(step_2_task_2_main_1);

			TreeObject  step_2_task_2_main_1_sub_1 = new TreeObject("������ǥ ����");
			step_2_task_2_main_1.addChild(step_2_task_2_main_1_sub_1);

			TreeObject step_2_task_2_main_1_sub_2 = new TreeObject("���Ž��� �ݿ�");
			step_2_task_2_main_1.addChild(step_2_task_2_main_1_sub_2);

			TreeParent step_2_task_2_main_2 = new TreeParent("�������� ����");
			step_2_task_2.addChild(step_2_task_2_main_2);

			TreeObject step_2_task_2_main_2_sub_1 = new TreeObject("�̻�߻� �� �˸� ���");
			step_2_task_2_main_2.addChild(step_2_task_2_main_2_sub_1);

			TreeObject step_2_task_2_main_2_sub_2 = new TreeObject("���� �� ��ȸ ����");
			step_2_task_2_main_2.addChild(step_2_task_2_main_2_sub_2);

			invisibleRoot = new TreeParent("");
			invisibleRoot.addChild(root);
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
	public StarUMLRequestView() {
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
		hookContextMenu();
		hookDoubleClickAction();
		contributeToActionBars();
	}

	private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				StarUMLRequestView.this.fillContextMenu(manager);
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

	private void fillContextMenu(IMenuManager manager) {
		manager.add(action1);
		manager.add(action2);
		manager.add(new Separator());
		drillDownAdapter.addNavigationActions(manager);
		// Other plug-ins can contribute there actions here
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}
	
	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(action1);
		manager.add(action2);
		manager.add(new Separator());
		drillDownAdapter.addNavigationActions(manager);
	}

	private void makeActions() {
		action1 = new Action() {
			public void run() {
				showMessage("Action 1 executed");
			}
		};
		action1.setText("Action 1");
		action1.setToolTipText("Action 1 tooltip");
		action1.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
			getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
		
		action2 = new Action() {
			public void run() {
				showMessage("Action 2 executed");
			}
		};
		action2.setText("Action 2");
		action2.setToolTipText("Action 2 tooltip");
		action2.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
				getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
		doubleClickAction = new Action() {
			public void run() {
				ISelection selection = viewer.getSelection();
				Object obj = ((IStructuredSelection)selection).getFirstElement();
				showMessage("Double-click detected on "+obj.toString());
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
			"StarUML Request View",
			message);
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		viewer.getControl().setFocus();
	}
}