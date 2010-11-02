package org.eclipse.uml2.diagram.common.async;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.ITreeViewerListener;
import org.eclipse.jface.viewers.TreeExpansionEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.dialogs.PatternFilter;
import org.eclipse.uml2.diagram.common.Messages;

public class SyncModelUI {

	private SyncModelNode myRootNode;

	private final SyncModelLabelProvider myLabelProvider;

	private CheckboxTreeViewer myTreeViewer;

	private CheckListener myCheckListener;

	private CheckStateInitializer myCheckStateInitializer;

	public SyncModelUI(Composite parent, SyncModelLabelProvider labelProvider) {
		myLabelProvider = labelProvider;
		createContents(parent);
	}

	private void createContents(Composite composite) {
		CheckboxFilteredTree filterTree = new CheckboxFilteredTree(composite, SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER, new PatternFilter());
		myTreeViewer = filterTree.getCheckboxTreeViewer();
		myLabelProvider.hookTreeViewer(myTreeViewer);

		GridData layoutData = new GridData(GridData.FILL_BOTH);
		layoutData.heightHint = 300;
		layoutData.widthHint = 300;
		myTreeViewer.getTree().setLayoutData(layoutData);
		myTreeViewer.setContentProvider(new SyncModelContentProvider());
		myTreeViewer.setLabelProvider(myLabelProvider);
		myTreeViewer.setComparator(new ViewerComparator());

		myCheckStateInitializer = new CheckStateInitializer(myTreeViewer);
		myTreeViewer.addTreeListener(myCheckStateInitializer);
		myCheckListener = new CheckListener(myTreeViewer);
		myTreeViewer.addCheckStateListener(myCheckListener);

		new MenuBuilder(myTreeViewer).attachMenu();
	}

	public void setRootNode(SyncModelNode rootNode) {
		myRootNode = rootNode;
		myTreeViewer.setInput(new SyncModelNode[] { rootNode });
		if (myCheckListener != null) {
			myCheckListener.setAlwaysChecked(rootNode);
		}
		myTreeViewer.setGrayChecked(rootNode, true);
	}

	public void revealRootChildren() {
		if (myRootNode != null) {
			myTreeViewer.expandToLevel(2);
			TreeExpansionEvent expandEvent = new TreeExpansionEvent(myTreeViewer, myRootNode);
			myCheckStateInitializer.treeExpanded(expandEvent);
		}
	}

	public SyncModelNode getRootSyncNode() {
		return myRootNode;
	}

	public CheckboxTreeViewer getUI() {
		return myTreeViewer;
	}

	private static class CheckStateInitializer implements ITreeViewerListener {

		private final List<Object> myExpandedNodes = new ArrayList<Object>();

		private final CheckboxTreeViewer myViewer;

		public CheckStateInitializer(CheckboxTreeViewer viewer) {
			myViewer = viewer;
		}

		public void treeCollapsed(TreeExpansionEvent event) {
			// 
		}

		public void treeExpanded(TreeExpansionEvent event) {
			Object expanded = event.getElement();
			if (myExpandedNodes.contains(expanded)) {
				return; // only first expand is interesting
			}

			myExpandedNodes.add(expanded);
			for (Object nextChild : getTreeContentProvider().getChildren(expanded)) {
				if (nextChild instanceof SyncModelNode) {
					SyncModelNode node = (SyncModelNode) nextChild;
					myViewer.setChecked(node, node.isChecked());
				}
			}
		}

		private ITreeContentProvider getTreeContentProvider() {
			return (ITreeContentProvider) myViewer.getContentProvider();
		}
	}

	private static class CheckListener implements ICheckStateListener {

		private final CheckboxTreeViewer myViewer;

		private SyncModelNode myAlwaysChecked;

		public CheckListener(CheckboxTreeViewer viewer) {
			myViewer = viewer;
		}

		public void setAlwaysChecked(SyncModelNode root) {
			myAlwaysChecked = root;
		}

		public void checkStateChanged(CheckStateChangedEvent event) {
			Object subject = event.getElement();
			if (myAlwaysChecked != null && subject == myAlwaysChecked) {
				// roll back, its always checked
				myViewer.setChecked(subject, true);
				return;
			}
			if (false == subject instanceof SyncModelNode) {
				return;
			}
			SyncModelNode node = (SyncModelNode) subject;
			node.setChecked(event.getChecked());

			boolean refreshNeeded = false;
			if (event.getChecked()) {
				for (SyncModelNode next = node.getParent(); next != null; next = next.getParent()) {
					refreshNeeded |= !next.isChecked();
					next.setChecked(true);
					myViewer.setChecked(next, true);
				}
				if (node.isAutoSynchronized()) {
					for (SyncModelNode nextChild : node.getChildren()) {
						refreshNeeded |= nextChild.isChecked();
						nextChild.setChecked(true);
						myViewer.setChecked(nextChild, true);
					}
				}
			} else {
				SyncModelNode parent = node.getParent();
				refreshNeeded = parent.isAutoSynchronized();
				parent.setAutoSynchronized(false);

				for (SyncModelNode nextChild : node.getChildren()) {
					refreshNeeded |= nextChild.isChecked();
					nextChild.setChecked(false);
					myViewer.setChecked(nextChild, false);
				}
			}

			if (refreshNeeded) {
				myViewer.refresh(true);
			}
		}
	}

	private static class MenuBuilder implements IMenuListener {

		private final CheckboxTreeViewer myViewer;

		private final SyncModelUIAction mySwitchSyncAction;

		private final SyncModelUIAction mySelectAllChildrenAction;

		private final SyncModelUIAction myUnselectAllChildrenAction;

		public MenuBuilder(CheckboxTreeViewer viewer) {
			myViewer = viewer;
			mySwitchSyncAction = new SwitchSynchronizationAction(viewer);
			mySelectAllChildrenAction = new BulkSelectAction(viewer, true);
			myUnselectAllChildrenAction = new BulkSelectAction(viewer, false);

			mySelectAllChildrenAction.setText(Messages.SyncModelUI_action_select_all_children);
			myUnselectAllChildrenAction.setText(Messages.SyncModelUI_action_unselect_all_children);
		}

		public void attachMenu() {
			MenuManager menuManager = new MenuManager();
			menuManager.addMenuListener(this);
			menuManager.add(mySwitchSyncAction);
			menuManager.add(mySelectAllChildrenAction);
			menuManager.add(myUnselectAllChildrenAction);

			myViewer.getTree().setMenu(menuManager.createContextMenu(myViewer.getTree()));
		}

		public void removeMenu() {
			myViewer.getTree().setMenu(null);
		}

		public void menuAboutToShow(IMenuManager manager) {
			mySwitchSyncAction.update(myViewer);
			mySelectAllChildrenAction.update(myViewer);
			myUnselectAllChildrenAction.update(myViewer);
		}

	}

	private static abstract class SyncModelUIAction extends Action {

		public abstract void update(CheckboxTreeViewer syncModelUI);
	}

	private static class SwitchSynchronizationAction extends SyncModelUIAction {

		private final CheckboxTreeViewer mySyncModelUI;

		private SyncModelNode mySelected;

		public SwitchSynchronizationAction(CheckboxTreeViewer syncModelUI) {
			mySyncModelUI = syncModelUI;
		}

		@Override
		public void update(CheckboxTreeViewer viewer) {
			mySelected = null;
			IStructuredSelection selection = (IStructuredSelection) viewer.getSelection();
			setEnabled(selection.size() == 1);
			if (selection.size() != 1) {
				return;
			}

			mySelected = (SyncModelNode) selection.getFirstElement();
			if (mySelected.isAutoSynchronized()) {
				setText(Messages.SyncModelUI_action_disable_sync);
			} else {
				setText(Messages.SyncModelUI_action_enable_sync);
			}
		}

		@Override
		public void run() {
			if (mySelected.isAutoSynchronized()) {
				mySelected.setAutoSynchronized(false);
			} else {
				mySelected.setAutoSynchronized(true);
				for (SyncModelNode nextDirectChild : mySelected.getChildren()) {
					nextDirectChild.setChecked(true);
					mySyncModelUI.setChecked(nextDirectChild, true);
				}
			}
			mySyncModelUI.refresh(mySelected);
		}
	}

	private static class BulkSelectAction extends SyncModelUIAction {

		private final boolean mySelectNotUnselect;

		private final CheckboxTreeViewer mySyncModelUI;

		private SyncModelNode mySelected;

		public BulkSelectAction(CheckboxTreeViewer syncModelUI, boolean selectNotUnselect) {
			mySyncModelUI = syncModelUI;
			mySelectNotUnselect = selectNotUnselect;
		}

		public void update(CheckboxTreeViewer viewer) {
			mySelected = null;
			IStructuredSelection selection = (IStructuredSelection) viewer.getSelection();
			setEnabled(selection.size() == 1);
			if (selection.size() != 1) {
				return;
			}
			mySelected = (SyncModelNode) selection.getFirstElement();
			setEnabled(!mySelected.isKnownLeaf() && !mySelected.getChildren().isEmpty());
		}

		@Override
		public void run() {
			for (SyncModelNode nextDirectChild : mySelected.getChildren()) {
				if (!isFiltered(mySelected, nextDirectChild)) {
					nextDirectChild.setChecked(mySelectNotUnselect);
					mySyncModelUI.setChecked(nextDirectChild, mySelectNotUnselect);
				}
			}
			if (!mySelectNotUnselect) {
				mySelected.setAutoSynchronized(false);
			}
			mySyncModelUI.refresh(mySelected);
		}

		private boolean isFiltered(SyncModelNode parent, SyncModelNode child) {
			for (ViewerFilter nextFilter : mySyncModelUI.getFilters()) {
				if (!nextFilter.select(mySyncModelUI, parent, child)) {
					return true;
				}
			}
			return false;
		}
	}

	private class CheckboxFilteredTree extends FilteredTree {

		public CheckboxFilteredTree(Composite parent, int treeStyle, PatternFilter filter) {
			super(parent, treeStyle, filter, true);
		}

		@Override
		protected TreeViewer doCreateTreeViewer(Composite parent, int style) {
			return new CheckboxTreeViewer(parent, style);
		}

		public CheckboxTreeViewer getCheckboxTreeViewer() {
			return (CheckboxTreeViewer) getViewer();
		}

	}

}
