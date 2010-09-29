package org.eclipse.uml2.diagram.sequence.edit.policies;

import java.util.Collections;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartListener;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.NodeListener;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.AbstractEditPolicy;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.ArrangeRequest;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.sequence.edit.parts.InteractionEditPart;
import org.eclipse.uml2.diagram.sequence.internal.layout.manage.SdLayoutAsInnerLayout;



public class InteractionNestedLayoutEditPolicy extends AbstractEditPolicy {
	private SdLayoutAsInnerLayout mySdLayout;
	private EditPartTracker myEditPartTracker;
	
	@Override
	public void activate() {
		reinitSDLayout();
		
		try {
			InteractionNestedLayoutRequest req = new InteractionNestedLayoutRequest();
			//req.setRepeatSessionsCount(2);
			getHostImpl().getDiagramEditDomain().getDiagramCommandStack().execute(getCommand(req));
		} catch (RuntimeException e){
			e.printStackTrace();
			throw e;
		}
	}
	
	private void reinitSDLayout(){
		myEditPartTracker = new EditPartTracker();
		mySdLayout = new SdLayoutAsInnerLayout(getHostImpl());
		getHost().addEditPartListener(myEditPartTracker);
		setupNodesTree(getHostImpl());
		setupLinksTree(getHostImpl());
	}
	
	private void setupNodesTree(EditPart treeRoot){
		for (Object next : treeRoot.getChildren()){
			EditPart nextEP = (EditPart)next;
			addToLayout(nextEP);
			nextEP.addEditPartListener(myEditPartTracker);
			if (nextEP instanceof NodeEditPart){
				((NodeEditPart)nextEP).addNodeListener(myEditPartTracker);
			}
			setupNodesTree(nextEP);
		}
	}
	
	private void setupLinksTree(EditPart treeRoot){
		for (Object next : treeRoot.getChildren()){
			if (next instanceof NodeEditPart){
				NodeEditPart nextEP = (NodeEditPart)next;			
				for (Object nextLink : nextEP.getSourceConnections()){
					if (nextLink instanceof ConnectionEditPart){
						addToLayout((ConnectionEditPart)nextLink);
					}
				}
			}
			setupLinksTree((EditPart)next);
		}
	}
	
	@Override
	public void deactivate() {
		mySdLayout = null;
		getHost().removeEditPartListener(myEditPartTracker);
	}
	
	@Override
	public boolean understandsRequest(Request req) {
		if (req instanceof ArrangeRequest){
			return true; //temporary to allow execution from "Arrange Selected"
		}
		return req instanceof InteractionNestedLayoutRequest;
	}
	
	@Override
	public Command getCommand(Request request) {
		if (request instanceof ArrangeRequest){
			return getNestedLayoutCommand(new InteractionNestedLayoutRequest());
		}
		if (request instanceof InteractionNestedLayoutRequest){
			return getNestedLayoutCommand((InteractionNestedLayoutRequest)request);
		}
		return null;
	}
	
	protected Command getNestedLayoutCommand(final InteractionNestedLayoutRequest request){
		AbstractTransactionalCommand result = new AbstractTransactionalCommand(getHostImpl().getEditingDomain(), "Layouting", Collections.singletonList(WorkspaceSynchronizer.getFile(getHostImpl().getNotationView().eResource()))){
			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				
				if (request.isTotalLayout()){
					mySdLayout = null;
					reinitSDLayout();
				}
				
				for (IAdaptable nextViewAdapter : request.getViewAdapters()){
					View view = (View) nextViewAdapter.getAdapter(View.class);
					if (view == null){
						System.err.println("There are no View adapters in: " + nextViewAdapter);
						continue;
					}
					EditPart nextEditPart = (EditPart) getHost().getViewer().getEditPartRegistry().get(view);
					if (nextEditPart == null){
						System.err.println("There are no EditPart registered for view: " + view);
						continue;
					}	
					
					addToLayout(nextEditPart);
				}
				
				for (IGraphicalEditPart nextReshaped : request.getReshapedElements()){
					mySdLayout.elementReshaped(nextReshaped);
				}
				
				for (int i = 0; i < request.getSessionsCount(); i++){
					mySdLayout.performLayout();	
				}
				return CommandResult.newOKCommandResult();
			}
		};
		return new ICommandProxy(result);
	}
	
	private InteractionEditPart getHostImpl(){
		return (InteractionEditPart) getHost();
	}
	
	private void addToLayout(EditPart editPart){
		if (editPart instanceof ITextAwareEditPart){
			return;
		}
		//System.err.println("Adding to layout: " + editPart);
		if (editPart instanceof ConnectionEditPart){
			mySdLayout.linkAdded((ConnectionEditPart)editPart);
			return;
		}
		if (editPart instanceof GraphicalEditPart){
			mySdLayout.nodeAdded((GraphicalEditPart)editPart);
		}
	}
	
	private void removeFromLayout(EditPart editPart){
		if (editPart instanceof ITextAwareEditPart){
			return;
		}
		if (editPart instanceof ConnectionEditPart){
			mySdLayout.linkRemoved((ConnectionEditPart)editPart);
			return;
		}
		if (editPart instanceof GraphicalEditPart){
			mySdLayout.nodeRemoved((GraphicalEditPart)editPart);
		}
	}	
	
	private class EditPartTracker extends EditPartListener.Stub implements NodeListener {
		public void childAdded(EditPart child, int index) {
			addToLayout(child);
			child.addEditPartListener(this);
			if (child instanceof NodeEditPart){
				((NodeEditPart)child).addNodeListener(this);
				for (Object next : ((NodeEditPart)child).getSourceConnections()){
					org.eclipse.gef.ConnectionEditPart nextLink = (org.eclipse.gef.ConnectionEditPart)next;
					//if (nextLink.getTarget() != null){
						addToLayout(nextLink);
					//}
				}
			}
			setupNodesTree(child);
		}
		
		@Override
		public void removingChild(EditPart child, int index) {
			child.removeEditPartListener(this);
			if (child instanceof NodeEditPart){
				((NodeEditPart)child).removeNodeListener(this);
			}
			removeFromLayout(child);
		}

		public void removingSourceConnection(org.eclipse.gef.ConnectionEditPart connection, int index) {
			removeFromLayout(connection);
		}
		
		public void removingTargetConnection(org.eclipse.gef.ConnectionEditPart connection, int index) {
			// TODO Auto-generated method stub
		}
		
		public void sourceConnectionAdded(org.eclipse.gef.ConnectionEditPart connection, int index) {
			addToLayout(connection);
		}
		
		public void targetConnectionAdded(org.eclipse.gef.ConnectionEditPart connection, int index) {
			//
		}
	}
	
}
