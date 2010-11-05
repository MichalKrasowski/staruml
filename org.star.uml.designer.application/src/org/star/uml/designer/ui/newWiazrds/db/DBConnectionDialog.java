package org.star.uml.designer.ui.newWiazrds.db;

import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.star.uml.designer.base.constance.CustomMessages;


public class DBConnectionDialog extends WizardDialog {

	private DBConnectionWizard dbConnectionWizard = null;
	private ConnectionCreateDialog parent;

	public DBConnectionDialog(Shell parentShell, IWizard newWizard) {

		super(parentShell, newWizard);

		try {

			dbConnectionWizard = (DBConnectionWizard) newWizard;
			parent = (ConnectionCreateDialog) dbConnectionWizard.getParentDialog();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	protected void nextPressed() {

		MessageBox messageBox = new MessageBox(this.getShell());

		IWizardPage page = dbConnectionWizard.getContainer().getCurrentPage();

		// First Page
		if (page.getName().equals(CustomMessages.WIZARD_DB_CONNECTION_PAGE_1)) {

			DBConnectionWizardPage_1 page_1 = (DBConnectionWizardPage_1) page;

			String connectionName = page_1.getConnectionName();
			String hostName = page_1.getHostName();
			String jdbcPort = page_1.getJdbcPort();
			String password = page_1.getPassword();
			String userName = page_1.getUserName();

			if (connectionName.isEmpty() || hostName.isEmpty()
					|| jdbcPort.isEmpty() || password.isEmpty()
					|| userName.isEmpty()) {

				messageBox.setMessage(CustomMessages.WIZARD_DB_ALERT);
				messageBox.setText(CustomMessages.WIZARD_DB_ALERT);
				messageBox.open();

				return;
			}

			String[] connectionList = parent.getRepositoryText().getItems();

			for (int i = 0; i < connectionList.length; i++) {
				if (connectionList[i] != null) {
					if (connectionList[i].equals(connectionName)) {

						messageBox
								.setMessage(CustomMessages.WIZARD_DB_CONNECTION_DUPLICATE_ALERT);
						messageBox.setText(CustomMessages.WIZARD_DB_INFO_ALERT);
						messageBox.open();

						return;
					}
				}
			}

		}

		super.nextPressed();
	}

}
