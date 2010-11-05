package org.star.uml.designer.ui.newWiazrds.db;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IWorkbench;
import org.star.uml.designer.base.constance.CustomMessages;

public class DBConnectionWizard extends Wizard {

	// 위자트 ID 설정
	public static final String ID = "sobis.enkisoft.bpmn.designer.wizard.db.dbConnection";
	private Dialog parentDialog;
	// Connection 위자드 첫번째 페이지
	public DBConnectionWizardPage_1 dbConnectionWizardPage_1;
	// Connection 위자드 두번째 페이지
	private DBConnectionWizardPage_2 dbConnectionWizardPage_2;
	private IStructuredSelection initialSelection;
	public boolean finishFlag;

	public DBConnectionWizard() {
		finishFlag = false;
	}

	@Override
	public boolean performFinish() {
		addConnection();
		ConnectionCreateDialog dialog = (ConnectionCreateDialog) parentDialog;
		dialog.reLoadConnection();
		this.getContainer().getShell().close();
		return true;
	}

	public void addConnection() {

		try {

			DBConnectionWizardPage_1 connectionWizardPage_1 = (DBConnectionWizardPage_1) this
					.getPage(CustomMessages.WIZARD_DB_CONNECTION_PAGE_1);

			String connectionName = connectionWizardPage_1.getConnectionName();
			String connectionType = connectionWizardPage_1.getConnectionType()
					.getText();
			String databaseType = connectionWizardPage_1.getDatabaseType()
					.getText();
			String driverClass = (String) connectionWizardPage_1
					.getDatabaseType().getData(databaseType);
			String userName = connectionWizardPage_1.getUserName();
			String password = connectionWizardPage_1.getPassword();
			String driver = connectionWizardPage_1.getDriver().getText();
			String hostName = connectionWizardPage_1.getHostName();
			String jdbcPort = connectionWizardPage_1.getJdbcPort();
			String sid = connectionWizardPage_1.getSid();
			String serviceName = connectionWizardPage_1.getServiceName();
			String connectionUrl = "";

			if (databaseType.equals("ORACLE")) {
				StringBuffer br = new StringBuffer();
				br.append(connectionType + ":" + databaseType + ":" + driver);
				br.append(":@" + hostName + ":" + jdbcPort + ":");
				br.append((sid == "" || sid == null) ? serviceName : sid);
				connectionUrl = br.toString();
			} else {
				StringBuffer br = new StringBuffer();
				br.append(connectionType + ":" + databaseType + ":" + driver);
				br.append(":@" + hostName + ":" + jdbcPort + ":");
				br.append((sid == "" || sid == null) ? serviceName : sid);
				connectionUrl = br.toString();
			}

			GenerateXMLDBInfo addDatabaseConnection = new GenerateXMLDBInfo();
			addDatabaseConnection.addConnection(connectionName, connectionType,
					userName, password, driver, hostName, jdbcPort, sid,
					serviceName, connectionUrl, driverClass, databaseType);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean canFinish() {
		return finishFlag;
	}

	public Dialog getParentDialog() {
		return parentDialog;
	}

	public void setParentDialog(Dialog parentDialog) {
		this.parentDialog = parentDialog;
	}

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		initialSelection = selection;
	}

	public void addPages() {
		setWindowTitle(CustomMessages.WIZARD_DB_CONNECTION_TITLE);
		dbConnectionWizardPage_1 = new DBConnectionWizardPage_1();
		addPage(dbConnectionWizardPage_1);
		dbConnectionWizardPage_2 = new DBConnectionWizardPage_2();
		addPage(dbConnectionWizardPage_2);
		dbConnectionWizardPage_1.init(initialSelection);

	}

}
