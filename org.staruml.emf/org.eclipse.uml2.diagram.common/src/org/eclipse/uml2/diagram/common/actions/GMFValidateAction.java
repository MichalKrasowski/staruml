package org.eclipse.uml2.diagram.common.actions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.action.ValidateAction;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;

public class GMFValidateAction extends ValidateAction {

	public GMFValidateAction(IWorkbenchPage workbenchPage) {
		setActiveWorkbenchPart(workbenchPage.getActivePart());
		IEditorPart activeEditor = workbenchPage.getActiveEditor();
		ISelectionProvider selectionProvider = activeEditor instanceof ISelectionProvider ? (ISelectionProvider) activeEditor : activeEditor.getEditorSite().getSelectionProvider();
		selectionProvider.addSelectionChangedListener(this);
	}

	@Override
	public void setActiveWorkbenchPart(IWorkbenchPart workbenchPart) {
		super.setActiveWorkbenchPart(workbenchPart);
		domain = ((DiagramDocumentEditor) workbenchPart).getEditingDomain();
	}

	@Override
	public boolean updateSelection(IStructuredSelection selection) {
		return super.updateSelection(transformSelection(selection));
	}

	private IStructuredSelection transformSelection(IStructuredSelection selection) {
		List<EObject> elements = new ArrayList<EObject>();
		for (Object next : selection.toList()) {
			EObject transformed = transformSelectedElement(next);
			if (transformed != null) {
				elements.add(transformed);
			}
		}
		return new StructuredSelection(elements);
	}

	private EObject transformSelectedElement(Object next) {
		if (next instanceof IGraphicalEditPart) {
			return ((IGraphicalEditPart) next).getNotationView().getElement();
		} else if (next instanceof EObject) {
			return (EObject) next;
		}
		return null;
	}

}
