package org.eclipse.uml2.diagram.common.async;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.diagram.ui.actions.ActionIds;
import org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.diagram.common.Messages;

/**
 * The U2T specific version of DeleteFromDiagramAction that respects the 
 * semi-synchronized diagram mode of U2T structure diagrams.
 * 
 * We would prefer to extend org.eclipse.gmf.runtime.diagram.ui.actions.internal.DeleteFromDiagramAction 
 * but can't do it due to plugin exporting limitations  
 */
public class DeleteFromDiagramAction extends DiagramAction {
	
	public DeleteFromDiagramAction(IWorkbenchPage workbenchPage) {
		super(workbenchPage);		
	}

	/**
	 * Mimic the appearance of default GMF DeleteFromDiagramAction
	 */
	public void init() {
		super.init();
		setId(ActionIds.ACTION_DELETE_FROM_DIAGRAM);
		setText(Messages.DeleteFromDiagramAction_action_delete_from_diagram);
		setToolTipText(Messages.DeleteFromDiagramAction_action_tooltip_delete_from_diagram);
		ISharedImages workbenchImages = PlatformUI.getWorkbench().getSharedImages();
		setHoverImageDescriptor(workbenchImages.getImageDescriptor(ISharedImages.IMG_TOOL_DELETE));
		setImageDescriptor(workbenchImages.getImageDescriptor(ISharedImages.IMG_TOOL_DELETE));
		setDisabledImageDescriptor(workbenchImages.getImageDescriptor(ISharedImages.IMG_TOOL_DELETE_DISABLED));
	}
	
	protected boolean isSelectionListener() {
		return true;
	}
	
	protected Request createTargetRequest(){
		AsyncDiagramDeleteRequest deleteReq = new AsyncDiagramDeleteRequest();
		deleteReq.setKind(AsyncDiagramDeleteRequest.Kind.NOTATION_ONLY);
		return deleteReq;
	}
	
	/**
	 * In addition to default GMF DeleteFromDiagramAction behavior, 
	 * we want to switch container into unsynchronized mode first.  
	 * @return a command to execute
	 */
	protected Command getCommand() {
		@SuppressWarnings("unchecked")
		List<IGraphicalEditPart> objects = createOperationSet();
		if (objects.isEmpty()){
			return null;
		}
		
		for (Object next : objects){
			if (next instanceof ConnectionEditPart){
				//connections are sync'ed in U2T
				return null;
			}
			if (next instanceof DiagramEditPart){
				return null;
			}
		}
		
		CompoundCommand result = new CompoundCommand(getLabel());
		for (IGraphicalEditPart next : objects){
			result.add(next.getCommand(getTargetRequest()));
		}
		return result;
	}
	
	@SuppressWarnings("unchecked")
	protected List createOperationSet() {
		List selection = getSelectedObjects();
		if (selection.isEmpty() || !(selection.get(0) instanceof IGraphicalEditPart)){
			return Collections.emptyList();
		}
		List<IGraphicalEditPart> result = new LinkedList<IGraphicalEditPart>();
		for (Object next : selection){
			if (next instanceof IGraphicalEditPart){
				result.add((IGraphicalEditPart) next);
			}
		}	
		return result;
	}

}
