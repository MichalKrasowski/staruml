package org.eclipse.uml2.diagram.common.async;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.impl.ShapeImpl;
import org.eclipse.uml2.diagram.common.Messages;
import org.eclipse.uml2.uml.internal.impl.ActorImpl;
import org.eclipse.uml2.uml.internal.impl.PackageImpl;

public class ApplySynchronizationCommand extends AbstractTransactionalCommand {
	private final SyncModelNode mySyncRoot;
	private final ArrayList<View> myAddedTopLevelViews = new ArrayList<View>();

	public ApplySynchronizationCommand(SyncModelNode syncRoot) {
		super(syncRoot.getContext().getDomain(), Messages.ApplySynchronizationCommand_command_apply_synchronization, getWorkspaceFiles(syncRoot.getDiagramView()));
		assert (syncRoot.getDiagramView() != null);
		mySyncRoot = syncRoot;
	}
	
	public ArrayList<View> getAddedTopLevelViews() {
		return myAddedTopLevelViews;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		LinkedList<SyncModelNode> queue = new LinkedList<SyncModelNode>();
		queue.add(mySyncRoot);
		while (!queue.isEmpty()){
			SyncModelNode next = queue.removeFirst();
			syncNode(next, queue);
		}
		return CommandResult.newOKCommandResult(myAddedTopLevelViews);
	}

	private void syncNode(SyncModelNode node, List<SyncModelNode> queue) {
		View diagramView = node.getDiagramView();
		assert (diagramView != null);
		if (!node.isRoot() && !node.isChecked()) {
			removeView(diagramView);
			return;
		}

		node.applyCanonicalStyle();

		for (SyncModelNode nextSyncChild : node.getChildren()) {
			if (nextSyncChild.isChecked()) {
				forceHasDiagramView(nextSyncChild);
				queue.add(nextSyncChild);
			} else {
				if (nextSyncChild.getDiagramView() != null) {
					queue.add(nextSyncChild); //diagram view will be removed at next step
				}
			}
		}
	}

	private void forceHasDiagramView(SyncModelNode node) {
		if (node.getDiagramView() != null) {
			return;
		}

		SyncModelNode parent = node.getParent();
		View diagramParent = parent.getDiagramView();
		if (node.isInCompartment()) {
			View syncCompartment = node.getSyncModelCompartment();
			View diagramCompartment = SyncModelNode.findCounterpart(syncCompartment, node.getParent().getDiagramView());
			if (diagramCompartment == null) {
				throw new IllegalStateException(//
						"Can't find diagram compartment for sync-model compartment: " + syncCompartment + //  //$NON-NLS-1$
								", sync-model parent: " + node.getSyncModelView() + // //$NON-NLS-1$
								", diagram parent: " + node.getDiagramView()); //$NON-NLS-1$
			}
			diagramParent = diagramCompartment;
		}
		
		View copy = ViewService.createNode(diagramParent, node.getSyncModelView().getElement(), node.getSyncModelView().getType(), mySyncRoot.getContext().getPreferencesHint());
		assert copy != null;
		
		if (diagramParent instanceof Diagram){
			myAddedTopLevelViews.add(copy);
		}
		
		node.associateWithDiagramView(copy);
		node.applyCanonicalStyle();
	}
	
	private void removeView(View view) {
		ViewUtil.destroy(view);
	}

}
