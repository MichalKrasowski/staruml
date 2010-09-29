package org.eclipse.uml2.diagram.sequence.part;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.Properties;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.uml2.diagram.common.part.UMLModelWizardInitialObjectCreationPage;
import org.osgi.framework.Bundle;

/**
 * @generated
 */

public class UMLCreationWizard extends Wizard implements INewWizard {

	/**
	 * @generated
	 */
	private IWorkbench workbench;

	/**
	 * @generated
	 */
	protected IStructuredSelection selection;

	/**
	 * @generated
	 */
	protected UMLCreationWizardPage diagramModelFilePage;

	/**
	 * @generated
	 */
	protected UMLCreationWizardPage domainModelFilePage;

	/**
	 * @generated
	 */
	private UMLModelWizardInitialObjectCreationPage initialObjectCreationPage;

	/**
	 * @generated
	 */
	protected Resource diagram;

	/**
	 * @generated
	 */
	private boolean openNewlyCreatedDiagramEditor = true;

	/**
	 * @generated
	 */
	public IWorkbench getWorkbench() {
		return workbench;
	}

	/**
	 * @generated
	 */
	public IStructuredSelection getSelection() {
		return selection;
	}

	/**
	 * @generated
	 */
	public final Resource getDiagram() {
		return diagram;
	}

	/**
	 * @generated
	 */
	public final boolean isOpenNewlyCreatedDiagramEditor() {
		return openNewlyCreatedDiagramEditor;
	}

	/**
	 * @generated
	 */
	public void setOpenNewlyCreatedDiagramEditor(boolean openNewlyCreatedDiagramEditor) {
		this.openNewlyCreatedDiagramEditor = openNewlyCreatedDiagramEditor;
	}

	/**
	 * @generated
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;
		setWindowTitle(Messages.UMLCreationWizardTitle);
		setDefaultPageImageDescriptor(UMLDiagramEditorPlugin.getBundledImageDescriptor("icons/wizban/NewUMLWizard.gif")); //$NON-NLS-1$
		setNeedsProgressMonitor(true);
	}

	/**
	 * @generated
	 */
	public void addPages() {
		diagramModelFilePage = new UMLCreationWizardPage("DiagramModelFile", getSelection(), "umlseq"); //$NON-NLS-1$ //$NON-NLS-2$
		diagramModelFilePage.setTitle(Messages.UMLCreationWizard_DiagramModelFilePageTitle);
		diagramModelFilePage.setDescription(Messages.UMLCreationWizard_DiagramModelFilePageDescription);
		addPage(diagramModelFilePage);

		domainModelFilePage = new UMLCreationWizardPage("DomainModelFile", getSelection(), "uml"); //$NON-NLS-1$ //$NON-NLS-2$
		domainModelFilePage.setTitle(Messages.UMLCreationWizard_DomainModelFilePageTitle);
		domainModelFilePage.setDescription(Messages.UMLCreationWizard_DomainModelFilePageDescription);
		addPage(domainModelFilePage);
	}

	/**
	 * @generated
	 */
	public boolean performFinish() {
		IRunnableWithProgress op = new WorkspaceModifyOperation(null) {

			protected void execute(IProgressMonitor monitor) throws CoreException, InterruptedException {
				diagram = UMLDiagramEditorUtil.createDiagram(diagramModelFilePage.getURI(), domainModelFilePage.getURI(), monitor);
				if (isOpenNewlyCreatedDiagramEditor() && diagram != null) {
					try {
						UMLDiagramEditorUtil.openDiagram(diagram);
					} catch (PartInitException e) {
						ErrorDialog.openError(getContainer().getShell(), Messages.UMLCreationWizardOpenEditorError, null, e.getStatus());
					}
				}
			}
		};
		try {
			getContainer().run(false, true, op);
		} catch (InterruptedException e) {
			return false;
		} catch (InvocationTargetException e) {
			if (e.getTargetException() instanceof CoreException) {
				ErrorDialog.openError(getContainer().getShell(), Messages.UMLCreationWizardCreationError, null, ((CoreException) e.getTargetException()).getStatus());
			} else {
				UMLDiagramEditorPlugin.getInstance().logError("Error creating diagram", e.getTargetException()); //$NON-NLS-1$
			}
			return false;
		}
		//Enkisoft 2010-09-11 Park Yong Cheon
		Bundle bundle = Platform.getBundle("org.StarUML");
		if(bundle !=null){
			UMLCreationWizardPage wizPate = (UMLCreationWizardPage)this.getPages()[0];
			FileInputStream in = null;
			FileOutputStream out = null;
			try {
				URL fileURL = bundle.getEntry("properties/temp.properties"); 
				File file = new File(FileLocator.resolve(fileURL).toURI());  
				System.out.println(file.exists());
				in = new FileInputStream(file);
				Properties props = new Properties();
				props.load(in);
				props.put("diagramName", wizPate.getFileName());
				out = new FileOutputStream(file);
				props.store(out, "");
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {
					in.close();
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return diagram != null;
	}
}
