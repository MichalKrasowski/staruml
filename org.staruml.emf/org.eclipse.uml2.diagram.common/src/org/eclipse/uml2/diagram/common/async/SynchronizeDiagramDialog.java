package org.eclipse.uml2.diagram.common.async;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.diagram.common.Messages;
import org.eclipse.uml2.diagram.common.async.SyncModelLabelProvider;
import org.eclipse.uml2.diagram.common.async.SyncModelNode;
import org.eclipse.uml2.diagram.common.async.SyncModelUI;

public class SynchronizeDiagramDialog extends Dialog {
	private final ILabelProvider myPluginSpecificLabelProvider;
	private SyncModelUI mySyncUI;
	private final SyncModelNode myRootNode;
	private final List<ViewerFilter> myViewerFilters = new LinkedList<ViewerFilter>();
	
	public SynchronizeDiagramDialog(Shell shell, SyncModelNode rootNode, ILabelProvider pluginSpecificLableProvider){
		super(shell);
		myRootNode = rootNode;
		myPluginSpecificLabelProvider = pluginSpecificLableProvider;
		setShellStyle(getShellStyle() | SWT.RESIZE);
		setBlockOnOpen(true);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);
		getShell().setText(Messages.SynchronizeDiagramDialog_dialog_choose_synchronization_mode);
		mySyncUI = new SyncModelUI(composite, new SyncModelLabelProvider(myPluginSpecificLabelProvider));
		mySyncUI.setRootNode(getRootSyncNode());
		for (ViewerFilter nextFilter : myViewerFilters){
			mySyncUI.getUI().addFilter(nextFilter);
		}
		mySyncUI.revealRootChildren();
		return composite;
	}
	
	protected void addFilter(ViewerFilter filter){
		if (mySyncUI == null || mySyncUI.getUI() == null){
			myViewerFilters.add(filter);
		} else {
			mySyncUI.getUI().addFilter(filter);	
		}
	}

	@Override
	protected Control createButtonBar(Composite parent) {
		Control buttonBar = super.createButtonBar(parent);
		setOkButtonEnabled(true);
		return buttonBar;
	}
	
	private void setOkButtonEnabled(boolean enabled) {
		getButton(IDialogConstants.OK_ID).setEnabled(enabled);
	}
	
	public SyncModelNode getRootSyncNode(){
		return myRootNode;
	}
	
	protected SyncModelUI getSyncUI() {
		return mySyncUI;
	}
	
}
