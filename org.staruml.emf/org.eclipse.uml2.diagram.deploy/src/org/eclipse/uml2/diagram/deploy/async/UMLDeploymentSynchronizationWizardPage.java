package org.eclipse.uml2.diagram.deploy.async;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.uml2.diagram.common.async.NewDiagramSyncHelper;
import org.eclipse.uml2.diagram.common.async.NewDiagramSynchronizationWizardPage;
import org.eclipse.uml2.diagram.common.async.SyncModelContext;
import org.eclipse.uml2.diagram.common.async.SyncModelUI;
import org.eclipse.uml2.diagram.deploy.edit.parts.PackageEditPart;
import org.eclipse.uml2.diagram.deploy.navigator.UMLNavigatorLabelProvider;
import org.eclipse.uml2.diagram.deploy.part.ModelElementSelectionPage;
import org.eclipse.uml2.diagram.deploy.part.UMLDiagramEditorPlugin;
import org.eclipse.uml2.diagram.deploy.part.UMLDiagramUpdater;
import org.eclipse.uml2.diagram.deploy.part.UMLVisualIDRegistry;

/**
 * @generated
 */
public class UMLDeploymentSynchronizationWizardPage extends NewDiagramSynchronizationWizardPage {

	/**
	 * @generated
	 */
	public UMLDeploymentSynchronizationWizardPage(String pageName, TransactionalEditingDomain domain) {
		super(pageName, domain, new UMLNavigatorLabelProvider());
	}

	/**
	 * @generated
	 */
	@Override
	protected NewDiagramSyncHelper createNewDiagramSyncHelper(TransactionalEditingDomain domain) {
		SyncModelContext context = new SyncModelContext(//
				UMLDiagramUpdater.TYPED_ADAPTER, // 
				UMLVisualIDRegistry.TYPED_ADAPTER, //
				UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT, //
				domain, true);
		return new NewDiagramSyncHelper(context, PackageEditPart.MODEL_ID);
	}

	/**
	 * @generated
	 */
	@Override
	protected EObject getWizardSemanticRoot() {
		ModelElementSelectionPage prevPageImpl = (ModelElementSelectionPage) getPreviousPage();
		return prevPageImpl.getModelElement();
	}

	/**
	 * @generated
	 */
	@Override
	protected void addViewerFilters(SyncModelUI syncModelUI) {
		syncModelUI.getUI().addFilter(new UMLDeploymentDiagramHeaderFilter());
	}

}
