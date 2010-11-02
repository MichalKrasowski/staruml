package org.eclipse.uml2.diagram.common.editpolicies;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.common.Messages;
import org.eclipse.uml2.diagram.common.genapi.IVisualIDRegistry;

public class MoveViewCommand extends AbstractTransactionalCommand {

	private final IAdaptable myParent;

	private final IAdaptable myChild;

	private final int myIndex;

	private final PreferencesHint myPreferences;
	
	private IVisualIDRegistry myVisualIDRegistry;

	public MoveViewCommand(TransactionalEditingDomain editingDomain, IAdaptable parent, IAdaptable child, PreferencesHint preferencesHint) {
		this(editingDomain, parent, child, ViewUtil.APPEND, preferencesHint);
	}

	public MoveViewCommand(TransactionalEditingDomain editingDomain, IAdaptable parent, IAdaptable child, int index, PreferencesHint preferences) {
		super(editingDomain, // 
				Messages.MoveViewCommand_command_move_view, null);
		myParent = parent;
		myChild = child;
		myIndex = index;
		myPreferences = preferences;
	}
	
	public void setVisualIDRegistry(IVisualIDRegistry visualIDRegistry) {
		myVisualIDRegistry = visualIDRegistry;
	}

	public List<?> getAffectedFiles() {
		View view = (View) myParent.getAdapter(View.class);
		if (view != null) {
			List<IFile> result = new ArrayList<IFile>();
			IFile file = WorkspaceSynchronizer.getFile(view.eResource());

			if (file != null) {
				result.add(file);
			}
			return result;
		}
		return super.getAffectedFiles();
	}
	
	protected boolean checkCanMoveView(View parentView, View childView, EObject child){
		if (myVisualIDRegistry == null){
			return false;
		}	
		int actualVisualId = myVisualIDRegistry.getVisualID(childView);
		return myVisualIDRegistry.checkNodeVisualID(parentView, child, actualVisualId);
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		View parentView = (View) myParent.getAdapter(View.class);
		View childView = (View) myChild.getAdapter(View.class);
		EObject child = childView.getElement();
		if (child instanceof Edge) {
			justMoveActualView(parentView, childView);
			return CommandResult.newOKCommandResult();
		}

		if (checkCanMoveView(parentView, childView, child)) {
			justMoveActualView(parentView, childView);
		} else {
			createNewView(parentView, childView, child);
		}
		return CommandResult.newOKCommandResult();
	}
	

	/**
	 * Just a hook, default implementation does nothing
	 */
	protected void importStyles(View newView, View childView) {
		//
	}

	protected View basicCreateNewView(View parentView, EObject child) {
		IAdaptable semanticAdapter = new EObjectAdapter(child);
		View result = ViewService.getInstance().createView(//
				Node.class, semanticAdapter, parentView, null, myIndex, true, myPreferences);
		return result;
	}
	
	@SuppressWarnings("unchecked")
	protected View createNewView(View parentView, View oldChildView, EObject child) {
		//unfortunately, we have to reuse childView instance in order to allow command from layout edit policy to set correct bounds
		//in order to do this, we will create the new view using service and then copy all its meaningfull contents 
		//into the original view instance
		View newView = basicCreateNewView(parentView, child);
		if (newView == null){
			return null;
		}
		removeViewFromContainer(newView);
		justMoveActualView(parentView, oldChildView);
		
		oldChildView.getPersistedChildren().clear();
		oldChildView.getTransientChildren().clear();
		oldChildView.getSourceEdges().clear();
		oldChildView.getTargetEdges().clear();
		oldChildView.getStyles().clear();
		
		oldChildView.getStyles().addAll(newView.getStyles());
		oldChildView.getPersistedChildren().addAll(newView.getPersistedChildren());
		oldChildView.getTransientChildren().addAll(newView.getTransientChildren());
		oldChildView.getSourceEdges().addAll(newView.getSourceEdges());
		oldChildView.getTargetEdges().addAll(newView.getTargetEdges());
		
		oldChildView.setType(newView.getType());
		
		return oldChildView;
	}

	private void justMoveActualView(View parentView, View childView) {
		if (myIndex == ViewUtil.APPEND) {
			parentView.insertChild(childView);
		} else {
			parentView.insertChildAt(childView, myIndex);
		}
	}
	
	private void removeViewFromContainer(View view){
		if (view.eContainer() instanceof View){
			((View)view.eContainer()).removeChild(view);
		}
	}

}
