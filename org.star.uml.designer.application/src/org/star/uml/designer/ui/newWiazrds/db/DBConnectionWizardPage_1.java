package org.star.uml.designer.ui.newWiazrds.db;


import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.star.uml.designer.base.constance.CustomMessages;


public class DBConnectionWizardPage_1 extends WizardPage implements
		FocusListener {

	private Text connectionNameField;
	private Text userNameField;
	private Text passwordField;
	private Text hostNameField;
	private Text jdbcPortField;
	private Text sidField;
	private Text serviceNameField;
	private Combo connectionTypeCombo;
	private Combo databaseTypeCombo;
	private Combo driverCombo;
	private Button sidServiceName;

	protected DBConnectionWizardPage_1() {

		super(CustomMessages.WIZARD_DB_CONNECTION_PAGE_1);
		// 마법사 Title 및 단계 설명
		setTitle(CustomMessages.WIZARD_DB_CONNECTION_PAGE_1);
		setDescription(CustomMessages.WIZARD_DB_CONNECTION_PAGE_1_DESC);
		setPageComplete(true);

	}

	public void createControl(Composite parent) {
		try {
			// 객체들이 위치할 Container 생성
			Composite container = new Composite(parent, SWT.NULL);

			// 화면을 Grid 형태로 배치하기 위해 Gride 생성
			GridLayout gridLayout = new GridLayout();

			// 화면을 크게 칼럼 3개로 나눈다.
			gridLayout.numColumns = 2;

			// Container에 Gride를 설정한다.
			container.setLayout(gridLayout);
			setControl(container);

			// Connection Name 설정
			Label connection_label = new Label(container, SWT.NONE);
			connection_label.setText("Connection  Name : ");
			connectionNameField = new Text(container, SWT.BORDER);
//			connectionNameField.setText("Test");
			connectionNameField.setLayoutData(new GridData(
					GridData.FILL_HORIZONTAL));

			// Connection Type 설정
			// JDBC
			Label connectionType_label = new Label(container, SWT.NONE);
			connectionType_label.setText("Connection  Type : ");
			connectionTypeCombo = new Combo(container, SWT.READ_ONLY);
			for (int i = 0; i < CustomMessages.DATABASE_CONNECTION_TYPE.split("#").length; i++) {
				connectionTypeCombo.add(CustomMessages.DATABASE_CONNECTION_TYPE
						.split("#")[i]);
			}
			connectionTypeCombo.setLayoutData(new GridData(
					GridData.FILL_HORIZONTAL));
			connectionTypeCombo.select(0);

			// Database Type 설정
			// ORACLE,MYSQL
			// driver Name
			Label databaseType_label = new Label(container, SWT.NONE);
			databaseType_label.setText("Database  Type : ");
			databaseTypeCombo = new Combo(container, SWT.READ_ONLY);

			for (int i = 0; i < CustomMessages.DATABASE_TYPE.split("#").length; i++) {
				databaseTypeCombo.add(CustomMessages.DATABASE_TYPE.split("#")[i]);
				databaseTypeCombo.setData(CustomMessages.DATABASE_TYPE.split("#")[i],
						CustomMessages.DATABASE_DRIVER_CLASS.split("#")[i]);
			}

			databaseTypeCombo.setLayoutData(new GridData(
					GridData.FILL_HORIZONTAL));
			databaseTypeCombo.select(0);

			// UserName 설정
			Label userName_label = new Label(container, SWT.NONE);
			userName_label.setText("User  Name : ");
			userNameField = new Text(container, SWT.BORDER);
			userNameField.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
//			userNameField.setText("star_pms");

			// Password 설정
			Label password_label = new Label(container, SWT.NONE);
			password_label.setText("Password : ");
			passwordField = new Text(container, SWT.BORDER | SWT.PASSWORD);
			passwordField.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
//			passwordField.setText("sjdznf");

			// Driver 설정
			// thin,oci8
			Label driver_label = new Label(container, SWT.NONE);
			driver_label.setText("Driver : ");
			driverCombo = new Combo(container, SWT.READ_ONLY);
			for (int i = 0; i < CustomMessages.DATABASE_TYPE.split("#").length; i++) {
				driverCombo.add(CustomMessages.DATABASE_DRIVER_TYPE.split("#")[i]);
			}
			driverCombo.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			driverCombo.select(0);

			// Host 설정
			Label host_label = new Label(container, SWT.NONE);
			host_label.setText("Host  Name : ");
			hostNameField = new Text(container, SWT.BORDER);
			hostNameField.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
//			hostNameField.setText("192.168.10.62");

			// port 설정
			Label jdbc_label = new Label(container, SWT.NONE);
			jdbc_label.setText("JDBC Port : ");
			jdbcPortField = new Text(container, SWT.BORDER);
			jdbcPortField.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
//			jdbcPortField.setText("1522");

			// SID 설정
			sidServiceName = new Button(container, SWT.RADIO);
			sidServiceName.setText("SID : ");
			sidServiceName.addFocusListener(this);
			sidField = new Text(container, SWT.BORDER);
			sidField.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
//			sidField.setText("orcl10g");

			// ServiceName 설정
			sidServiceName = new Button(container, SWT.RADIO);
			sidServiceName.setText("Service Name : ");
			sidServiceName.addFocusListener(this);
			serviceNameField = new Text(container, SWT.BORDER);
			serviceNameField.setLayoutData(new GridData(
					GridData.FILL_HORIZONTAL));
			serviceNameField.addFocusListener(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
		initContents();
	}

	private void initContents() {
	}

	public String getConnectionName() {
		return this.connectionNameField.getText();
	}

	public String getUserName() {
		return this.userNameField.getText();
	}

	public String getPassword() {
		return this.passwordField.getText();
	}

	public String getHostName() {
		return this.hostNameField.getText();
	}

	public String getJdbcPort() {
		return this.jdbcPortField.getText();
	}

	public String getSid() {
		return this.sidField.getText();
	}

	public String getServiceName() {
		return this.serviceNameField.getText();
	}

	public Combo getConnectionType() {
		return this.connectionTypeCombo;
	}

	public Combo getDriver() {
		return this.driverCombo;
	}

	public Combo getDatabaseType() {
		return databaseTypeCombo;
	}

	public void focusLost(FocusEvent e) {
	}

	public void focusGained(FocusEvent e) {

		Button source = (Button) e.getSource();

		if (source.getText().equals("SID : ")) {
			sidField.setEnabled(true);
			serviceNameField.setEnabled(false);
		} else {
			sidField.setEnabled(false);
			serviceNameField.setEnabled(true);
		}

	}

	public void init(IStructuredSelection selection) {
	}

	@Override
	public boolean canFlipToNextPage() {

		((DBConnectionWizardPage_2) getNextPage()).getTextArea().setText("");

		return super.canFlipToNextPage();
	}

}
