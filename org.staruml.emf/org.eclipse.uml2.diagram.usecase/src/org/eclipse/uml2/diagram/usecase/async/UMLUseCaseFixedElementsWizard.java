package org.eclipse.uml2.diagram.usecase.async;

import java.util.Arrays;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.diagram.common.async.ApplySynchronizationCommand;
import org.eclipse.uml2.diagram.common.async.NewDiagramSyncHelper;
import org.eclipse.uml2.diagram.common.async.SyncModelContext;
import org.eclipse.uml2.diagram.common.async.SyncModelNode;
import org.eclipse.uml2.diagram.common.genapi.IDiagramUpdater;
import org.eclipse.uml2.diagram.common.genapi.IVisualIDRegistry;
import org.eclipse.uml2.diagram.usecase.edit.parts.PackageEditPart;
import org.eclipse.uml2.diagram.usecase.part.UMLCreateShortcutAction;
import org.eclipse.uml2.diagram.usecase.part.UMLDiagramEditorPlugin;
import org.eclipse.uml2.diagram.usecase.part.UMLDiagramUpdater;
import org.eclipse.uml2.diagram.usecase.part.UMLNewDiagramFileWizard;
import org.eclipse.uml2.diagram.usecase.part.UMLVisualIDRegistry;
import org.eclipse.uml2.uml.PackageableElement;

/**
 * @generated
 */
public class UMLUseCaseFixedElementsWizard extends UMLNewDiagramFileWizard {

	/**
	 * @generated
	 */
	private final PackageableElement[] myToSelect;

	/**
	 * @generated
	 */
	private NewDiagramSyncHelperWithFixedElements mySyncHelper;

	/**
	 * @generated
	 */
	public UMLUseCaseFixedElementsWizard(URI domainModelURI, EObject diagramRoot, PackageableElement[] toSelect, TransactionalEditingDomain editingDomain) {
		super(domainModelURI, diagramRoot, editingDomain);
		myToSelect = toSelect;
	}

	/**
	 * @generated
	 */
	@Override
	public void addPages() {
		addPage(getFileCreationPage());
		addPage(getDiagramRootElementSelectionPage());
	}

	/**
	 * @generated
	 */
	@Override
	protected boolean needsLayoutAll() throws ExecutionException {
		return true;
	}

	/**
	 * @generated
	 */
	@Override
	protected void layoutAll() throws ExecutionException {
		createShortcutsIfNeeded();
		super.layoutAll();
	}

	/**
	 * @generated
	 */
	private void createShortcutsIfNeeded() {
		IEditorPart editorPart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		DiagramEditPart diagramEditPart = ((IDiagramWorkbenchPart) editorPart).getDiagramEditPart();
		IOperationHistory history = OperationHistoryFactory.getOperationHistory();
		for (PackageableElement next : myToSelect) {
			if (!canCreateView(next)) {
				UMLCreateShortcutAction.createShortcut(diagramEditPart.getEditingDomain(), history, next, diagramEditPart, editorPart);
			}
		}
	}

	/**
	 * @generated
	 */
	private boolean canCreateView(EObject element) {
		for (Object next : getDiagram().getChildren()) {
			View view = (View) next;
			if (element.equals(view.getElement())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @generated
	 */
	@Override
	protected AbstractTransactionalCommand getApplySynchronizationCommand() {
		EObject semanticRoot = getDiagramRootElementSelectionPage().getModelElement();
		getEditingDomain().getResourceSet().getResource(semanticRoot.eResource().getURI(), true);
		mySyncHelper = new NewDiagramSyncHelperWithFixedElements(createSyncContext(semanticRoot), PackageEditPart.MODEL_ID);
		mySyncHelper.setSemanticRoot(semanticRoot);
		return new ApplySynchronizationCommand(mySyncHelper.getSyncRoot());
	}

	/**
	 * @generated
	 */
	protected SyncModelContextWithFixedElements createSyncContext(EObject semanticRoot) {
		return new SyncModelContextWithFixedElements(//
				UMLDiagramUpdater.TYPED_ADAPTER, // 
				UMLVisualIDRegistry.TYPED_ADAPTER, //
				UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT, //
				getEditingDomain(), myToSelect, true);
	}

	/**
	 * @generated
	 */
	@Override
	protected Diagram getDiagram() {
		return mySyncHelper.getNewDiagram();
	}

	/**
	 * @generated
	 */
	private static class NewDiagramSyncHelperWithFixedElements extends NewDiagramSyncHelper {

		/**
		 * @generated
		 */
		public NewDiagramSyncHelperWithFixedElements(SyncModelContextWithFixedElements contextImpl, String diagramModelId) {
			super(contextImpl, diagramModelId);
		}

		/**
		 * @generated
		 */
		protected SyncModelNode createRootNode(SyncModelContext context, Diagram syncDiagram, Diagram tempDiagram) {
			SyncModelNode result = new SyncModelNodeForInitializedDiagram(syncDiagram, tempDiagram, context);
			return result;
		}
	}

	/**
	 * @generated
	 */
	private static class SyncModelNodeForInitializedDiagram extends SyncModelNode {

		/**
		 * @generated
		 */
		public SyncModelNodeForInitializedDiagram(View syncModelRoot, View diagramRoot, SyncModelContext context) {
			super(syncModelRoot, diagramRoot, context);
		}

		/**
		 * @generated
		 */
		@Override
		public boolean isAutoSynchronized() {
			return false;
		}

		/**
		 * @generated
		 */
		private SyncModelNodeForInitializedDiagram(View syncModelView, SyncModelNode parent) {
			super(syncModelView, parent);
		}

		/**
		 * @generated
		 */
		@Override
		public void initWithDiagramView(View diagramView) {
			super.initWithDiagramView(diagramView);
			setChecked(isInToCreateList() || UMLUseCaseDiagramHeaderFilter.SHARED_INSTANCE.isFilteredVisualId(this));
		}

		/**
		 * @generated
		 */
		private boolean isInToCreateList() {
			PackageableElement[] toSelect = ((SyncModelContextWithFixedElements) getContext()).getElementsToDisplay();
			if (toSelect == null || toSelect.length == 0) {
				return true; //diagram is selected, all diagram contents considered as implicit to-create list  
			}
			return Arrays.asList(toSelect).contains(getSyncModelView().getElement());
		}

		/**
		 * @generated
		 */
		@Override
		protected SyncModelNode doCreateNodeView(View syncModelView, SyncModelNode parent) {
			return new SyncModelNodeForInitializedDiagram(syncModelView, parent);
		}

	}

	/**
	 * @generated
	 */
	protected static class SyncModelContextWithFixedElements extends SyncModelContext {

		/**
		 * @generated
		 */
		private PackageableElement[] myElementsToDisplay;

		/**
		 * @generated
		 */
		public SyncModelContextWithFixedElements(IDiagramUpdater updater, IVisualIDRegistry registry, PreferencesHint preferencesHint, TransactionalEditingDomain domain,
				PackageableElement[] toSelect, boolean isDiagramInit) {

			super(updater, registry, preferencesHint, domain, isDiagramInit);
			myElementsToDisplay = toSelect;
		}

		/**
		 * @generated
		 */
		public PackageableElement[] getElementsToDisplay() {
			return myElementsToDisplay;
		}
	}

}
