package org.star.uml.designer.ui.newWiazrds;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.FileTransfer;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.internal.ide.IDEWorkbenchMessages;
import org.eclipse.ui.internal.ide.filesystem.FileSystemConfiguration;
import org.eclipse.ui.internal.ide.filesystem.FileSystemSupportRegistry;

public class ClassSorceCodeGenerationPage extends WizardPage {
	
	public static final String PAGE_NAME = "Summary";

	private Label textLabel;
	private Button button;
	private Text text;
	  
	protected ClassSorceCodeGenerationPage(String pageName) {
		super(PAGE_NAME, "Source Code Generation", null);
		setDescription("Generation java source code from Classdiagram.");
	}

	@Override
	public void createControl(final Composite parent) {
		Composite topLevel = new Composite(parent, SWT.NONE);
	    topLevel.setLayout(new GridLayout(3, false));

	    Label l = new Label(topLevel, SWT.CENTER);
	    l.setText("Source code generate loaction : ");
	    
	    text = new Text(topLevel, SWT.SINGLE);
	    text.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	    text.setSize(100, 15);
	    
	    button = new Button(topLevel, SWT.BUTTON1);
	    button.setText("Browser");
	    
	    final String dirName = "";
	    button.addSelectionListener(new SelectionListener() {
	        public void widgetSelected(SelectionEvent e) {
	        	FileSystemConfiguration config = FileSystemSupportRegistry.getInstance().getDefaultConfiguration();
	        	DirectoryDialog dialog = new DirectoryDialog(button.getShell(), SWT.SHEET);
				dialog.setMessage(IDEWorkbenchMessages.ProjectLocationSelectionDialog_directoryLabel);
				dialog.setFilterPath(dirName);
				String selectedDirectory = dialog.open();
				text.setText(selectedDirectory);
	        }
	        public void widgetDefaultSelected(SelectionEvent e) {
	        }
	      });

	    setControl(topLevel);
	    setPageComplete(true);
	}
	
}
