package org.eclipse.uml2.diagram.common.async;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.uml2.diagram.common.Messages;

public abstract class NewDiagramSynchronizationWizardPage extends WizardPage {

	private final TransactionalEditingDomain myDomain;
	
	private final ILabelProvider myDiagramSpecificLabelProvider;

	private NewDiagramSyncHelper myNewDiagramSyncHelper;

	private SyncModelUI mySyncUI;
	
	private boolean myWasVisible;
	
	protected abstract void addViewerFilters(SyncModelUI syncModelUI);
	
	protected abstract NewDiagramSyncHelper createNewDiagramSyncHelper(TransactionalEditingDomain domain);
	
	protected abstract EObject getWizardSemanticRoot();

	public NewDiagramSynchronizationWizardPage(String pageName, TransactionalEditingDomain domain, ILabelProvider diagramSpecificLabelProvider) {
		super(pageName);
		myDomain = domain;
		myDiagramSpecificLabelProvider = diagramSpecificLabelProvider;
	}

	public void createControl(Composite parent) {
		initializeDialogUnits(parent);

		Composite plate = new Composite(parent, SWT.NONE);
		plate.setLayoutData(new GridData(GridData.FILL_BOTH));
		GridLayout layout = new GridLayout();
		layout.marginWidth = 0;
		plate.setLayout(layout);
		setControl(plate);

		Label label = new Label(plate, SWT.NONE);
		label.setText(getSelectionTitle());
		label.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING));

		mySyncUI = new SyncModelUI(plate, new SyncModelLabelProvider(myDiagramSpecificLabelProvider));
		GridData layoutData = new GridData(GridData.FILL_BOTH);
		layoutData.heightHint = 300;
		layoutData.widthHint = 300;
		mySyncUI.getUI().getControl().setLayoutData(layoutData);
		addViewerFilters(mySyncUI);

		setPageComplete(true);
	}
	
	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		if (visible) {
			myWasVisible = true;
			EObject newRoot = getWizardSemanticRoot();
			myDomain.getResourceSet().getResource(newRoot.eResource().getURI(), true);
			
			if (myNewDiagramSyncHelper == null){
				myNewDiagramSyncHelper = createNewDiagramSyncHelper(myDomain);
			}

			myNewDiagramSyncHelper.setSemanticRoot(newRoot);
			mySyncUI.setRootNode(myNewDiagramSyncHelper.getSyncRoot());
			mySyncUI.revealRootChildren();
		}
	}
	
	public boolean wasVisible(){
		return myWasVisible;
	}

	public Diagram getDiagram() {
		return myNewDiagramSyncHelper == null ? null : myNewDiagramSyncHelper.getNewDiagram();
	}

	public SyncModelNode getSyncRoot() {
		return myNewDiagramSyncHelper == null ? null : myNewDiagramSyncHelper.getSyncRoot();
	}

	@Override
	public void dispose() {
		if (myNewDiagramSyncHelper != null){
			myNewDiagramSyncHelper.dispose();
			myNewDiagramSyncHelper = null;
		}
		super.dispose();
	}

	private String getSelectionTitle() {
		return Messages.NewDiagramSynchronizationWizardPage_selection_title;
	}

}
