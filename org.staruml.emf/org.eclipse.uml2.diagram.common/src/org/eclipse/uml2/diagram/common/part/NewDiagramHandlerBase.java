package org.eclipse.uml2.diagram.common.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.uml2.diagram.common.Messages;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;

public abstract class NewDiagramHandlerBase extends AbstractHandler {

	private final TransactionalEditingDomain myEditingDomain = GMFEditingDomainFactory.INSTANCE.createEditingDomain();

	protected abstract Wizard getNewDiagramWizard(Package diagramRoot);

	protected abstract Wizard getNewSemiSyncDiagramWizard(Package diagramRoot, List<PackageableElement> selectedElements);
	
	protected abstract void runWizard(Wizard w, Shell s);

	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchPart part = HandlerUtil.getActivePartChecked(event);
		List<PackageableElement> selectedElements = getSelectedElements(getStructuredSelection(event));
		Package diagramRoot = getDiagramRoot(selectedElements);
		Wizard wizard = null;
		if (selectedElements.size() == 1 && diagramRoot.equals(selectedElements.get(0)) ) {
			wizard = getNewDiagramWizard(diagramRoot);
		} else {
			wizard = getNewSemiSyncDiagramWizard(diagramRoot, selectedElements);
		}
		if (wizard == null) {
			return null;
		}
		wizard.setWindowTitle(Messages.NewDiagramHandlerBase_wizard_initialize_new_diagram);
		runWizard(wizard, part.getSite().getShell());
		return null;
	}

	protected TransactionalEditingDomain getEditingDomain() {
		return myEditingDomain;
	}

	private IStructuredSelection getStructuredSelection(ExecutionEvent event) throws ExecutionException {
		IEditorPart diagramEditor = HandlerUtil.getActiveEditorChecked(event);
		assert diagramEditor instanceof DiagramEditor;
		ISelection selection = HandlerUtil.getCurrentSelectionChecked(event);
		if (selection instanceof IStructuredSelection) {
			return (IStructuredSelection) selection;
		}
		return null;
	}

	private List<PackageableElement> getSelectedElements(IStructuredSelection ss) throws ExecutionException {
		List<PackageableElement> selectedElements = new ArrayList<PackageableElement>();
		for (Object next : ss.toArray()) {
			PackageableElement pe = getValidElement(next);
			if (pe != null) {
				selectedElements.add(pe);
			}
		}
		return selectedElements;
	}

	private PackageableElement getValidElement(Object element) {
		if (element instanceof IGraphicalEditPart) {
			element = ((IGraphicalEditPart) element).getNotationView().getElement();
		}
		if (element instanceof PackageableElement) {
			return (PackageableElement) element;
		}
		return null;
	}

	private Package getDiagramRoot(List<PackageableElement> selected) {
		if (selected == null || selected.size() == 0) {
			return null;
		}
		for (PackageableElement next : selected) {
			Package pakkage = next.getNearestPackage();
			if (pakkage != null) {
				return pakkage;
			}
		}
		return null;
	}
	
	protected URI getDiagramFileURI(org.eclipse.uml2.uml.Package diagramRoot) {
		return diagramRoot.eResource().getURI();
	}

}
