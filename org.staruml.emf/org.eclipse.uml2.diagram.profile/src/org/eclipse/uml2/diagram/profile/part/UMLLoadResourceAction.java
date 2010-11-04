package org.eclipse.uml2.diagram.profile.part;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.edit.ui.action.LoadResourceAction;
import org.eclipse.emf.edit.ui.action.LoadResourceAction.LoadResourceDialog;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.uml2.diagram.profile.edit.parts.ProfileEditPart;

/**
 * @generated
 */
public class UMLLoadResourceAction extends AbstractHandler {

	/**
	 * @generated
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IEditorPart diagramEditor = HandlerUtil.getActiveEditorChecked(event);
		Shell shell = diagramEditor.getEditorSite().getShell();
		assert diagramEditor instanceof DiagramEditor;
		TransactionalEditingDomain editingDomain = ((DiagramEditor) diagramEditor).getEditingDomain();
		LoadResourceAction.LoadResourceDialog loadResourceDialog = new LoadResourceAction.LoadResourceDialog(shell, editingDomain);
		loadResourceDialog.open();
		return null;
	}

}
