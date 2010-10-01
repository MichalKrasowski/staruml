package org.staruml.wizard.clazz;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org_.staruml.Activator;

public class SorceCodeGeneration extends Wizard implements INewWizard {

	public SorceCodeGeneration() {
		super();
		System.out.println("SorceCodeGeneration()");
	}

	@Override
	public boolean performFinish() {
		showMessage("소스코드가 생성되었습니다.");
		return true;
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		setWindowTitle("ClassDiagram Wizard");
	}
	
	public void addPages() {
	    addPage(new SorceCodeGenerationPage("Source Code Generation"));
	}
	
	private void showMessage(String message) {
		MessageDialog.openInformation(getShell(),"StarUML View",message);
	}
}
