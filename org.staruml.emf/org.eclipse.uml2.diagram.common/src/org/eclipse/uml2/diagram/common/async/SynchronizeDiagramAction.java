package org.eclipse.uml2.diagram.common.async;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.uml2.diagram.common.genapi.IDiagramUpdater;
import org.eclipse.uml2.diagram.common.genapi.IVisualIDRegistry;

public class SynchronizeDiagramAction implements IObjectActionDelegate {

	private final IVisualIDRegistry myVisualIDRegistry;

	private final IDiagramUpdater myDiagramUpdater;

	private final ILabelProvider myDiagramSpecificLabelProvider;

	private IWorkbenchPart targetPart;

	private View myRootDiagramView;

	private PreferencesHint myPreferencesHint;

	public SynchronizeDiagramAction(IDiagramUpdater diagramUpdater, IVisualIDRegistry visualIDRegistry, ILabelProvider diagramSpecificLabelProvider) {
		myDiagramUpdater = diagramUpdater;
		myVisualIDRegistry = visualIDRegistry;
		myDiagramSpecificLabelProvider = diagramSpecificLabelProvider;
	}

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		this.targetPart = targetPart;
	}

	public void selectionChanged(IAction action, ISelection selection) {
		action.setEnabled(false);
		if (selection instanceof IStructuredSelection == false || selection.isEmpty()) {
			return;
		}
		Object firstSelected = ((IStructuredSelection) selection).getFirstElement();
		myRootDiagramView = null;
		myPreferencesHint = null;
		if (firstSelected instanceof IGraphicalEditPart) {
			IGraphicalEditPart ep = (IGraphicalEditPart) firstSelected;
			View view = ep.getNotationView();
			int visualId = myVisualIDRegistry.getVisualID(view);
			if (visualId > 0) {
				if (myVisualIDRegistry.isCompartmentVisualID(visualId)) {
					view = (View) view.eContainer();
				}
				myRootDiagramView = view;
				myPreferencesHint = ep.getDiagramPreferencesHint();
			}
		}
		action.setEnabled(myRootDiagramView != null);
	}

	private Shell getShell() {
		return targetPart.getSite().getShell();
	}

	public void run(IAction action) {
		SyncModelContext context = createContext();
		try {
			SyncModelNode root = createRootNode(context);
			SynchronizeDiagramDialog dialog = new SynchronizeDiagramDialog(getShell(), root, myDiagramSpecificLabelProvider);
			for (ViewerFilter filter : createViewerFilters()) {
				dialog.addFilter(filter);
			}
			if (dialog.open() == Dialog.OK) {
				applySynchronization(dialog.getRootSyncNode());
			}
		} finally {
			context.dispose();
		}
	}

	protected List<ViewerFilter> createViewerFilters() {
		return Collections.emptyList();
	}

	private void applySynchronization(SyncModelNode syncRoot) {
		SyncModelContext context = syncRoot.getContext();
		ApplySynchronizationCommand applyCommand = new ApplySynchronizationCommand(syncRoot);
		context.runCommand(applyCommand);
		performCanonicalUpdate(syncRoot.getDiagramView().getDiagram().getElement());
		context.dispose();
	}

	private SyncModelNode createRootNode(SyncModelContext context) {
		final Resource syncModelResource = context.getSyncModelResource();
		final Diagram syncDiagram = ViewService.createDiagram(myRootDiagramView.getDiagram().getElement(), myVisualIDRegistry.getModelID(myRootDiagramView), myPreferencesHint);
		View syncRoot;
		if (myRootDiagramView instanceof Diagram) {
			syncRoot = syncDiagram;
		} else {
			syncRoot = ViewService.createNode(syncDiagram, myRootDiagramView.getElement(), myRootDiagramView.getType(), myPreferencesHint);
		}
		context.runCommand(new Runnable() {

			public void run() {
				syncModelResource.getContents().add(syncDiagram);
			}
		});
		SyncModelNode result = new SyncModelNode(syncRoot, myRootDiagramView, context);
		return result;
	}

	private SyncModelContext createContext() {
		TransactionalEditingDomain editingDomain = GMFEditingDomainFactory.INSTANCE.getEditingDomain(myRootDiagramView.eResource().getResourceSet());
		return new SyncModelContext(myDiagramUpdater, myVisualIDRegistry, myPreferencesHint, editingDomain);
	}

	private static void performCanonicalUpdate(EObject modelElement) {
		if (modelElement == null) {
			return;
		}
		List<?> editPolicies = CanonicalEditPolicy.getRegisteredEditPolicies(modelElement);
		for (Iterator<?> it = editPolicies.iterator(); it.hasNext();) {
			CanonicalEditPolicy nextEditPolicy = (CanonicalEditPolicy) it.next();
			nextEditPolicy.refresh();
		}
	}

}
