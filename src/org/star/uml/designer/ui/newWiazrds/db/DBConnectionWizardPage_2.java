package org.star.uml.designer.ui.newWiazrds.db;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.star.uml.designer.base.constance.CustomMessages;


public class DBConnectionWizardPage_2 extends WizardPage {

	private Button testButton;
	private StyledText textArea;

	public boolean finishFlag;

	protected DBConnectionWizardPage_2() {
		super(CustomMessages.WIZARD_DB_CONNECTION_PAGE_2);

		// 마법사 Title 및 단계 설명
		setTitle(CustomMessages.WIZARD_DB_CONNECTION_PAGE_2);
		setDescription(CustomMessages.WIZARD_DB_CONNECTION_PAGE_2_DESC);

	}

	public void createControl(Composite parent) {

		// 객체들이 위치할 Container 생성
		Composite container = new Composite(parent, SWT.NULL);

		// 화면을 Grid 형태로 배치하기 위해 Gride 생성
		GridLayout gridLayout = new GridLayout();

		// 화면을 크게 칼럼 3개로 나눈다.
		gridLayout.numColumns = 1;

		// Container에 Gride를 설정한다.
		container.setLayout(gridLayout);

		setControl(container);

		// 1열 1줄 버튼 설정
		testButton = new Button(container, SWT.NONE);
		// 버튼이 클릭될 경우 액션 설정
		testButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				connectionTest();
			}
		});
		testButton.setText(CustomMessages.TEST_CONNECTION);

		// 2열1줄 버튼 설정
		Label status_label = new Label(container, SWT.NONE);
		GridData gridData = new GridData();
		gridData.horizontalSpan = 2;
		status_label.setText(CustomMessages.RESULT);

		// 3열1줄 Connection Test 정보 출력
		textArea = new StyledText(container, SWT.BORDER | SWT.MULTI
				| SWT.V_SCROLL | SWT.H_SCROLL);
		textArea.setLayoutData(new GridData(GridData.FILL_BOTH
				| GridData.GRAB_HORIZONTAL | GridData.GRAB_VERTICAL));

		initContents();
	}

	private void initContents() {
	}

	/**
	 * 전화 면에서 등록된 정보를 가지고와서 Test를 실시한다.
	 */
	public void connectionTest() {

		DBConnectionWizardPage_1 connectionWizardPage_1 = (DBConnectionWizardPage_1) this
				.getPreviousPage();

		String connectionName = connectionWizardPage_1.getConnectionName();
		String connectionType = connectionWizardPage_1.getConnectionType()
				.getText();
		String userName = connectionWizardPage_1.getUserName();
		String password = connectionWizardPage_1.getPassword();
		String driverType = connectionWizardPage_1.getDriver().getText();
		String driverClassName = (String) connectionWizardPage_1
				.getDatabaseType().getData(
						connectionWizardPage_1.getDatabaseType().getText());
		String hostName = connectionWizardPage_1.getHostName();
		String jdbcPort = connectionWizardPage_1.getJdbcPort();
		String sid = connectionWizardPage_1.getSid();
		String serviceName = connectionWizardPage_1.getServiceName();
		sid = (sid == null || sid.equals("")) ? serviceName : sid;

		// Db Connection Start
		TestConnection adapter = new TestConnection();
		adapter.setConnectionType(connectionType);
		adapter.setDbVendor(driverClassName);
		adapter.setDriver("oracle:" + driverType);
		adapter.setHostName(hostName);
		adapter.setPassword(password);
		adapter.setPort(jdbcPort);
		adapter.setSid_serviceName(sid);
		adapter.setUserName(userName);
		adapter.setConnectionName(connectionName);

		String message = adapter.testConnection();

		// Result Message Display
		textArea.setText(message);

		if (adapter.isSuccessed()) {
			enabledFinishButton(true);
		} else {
			enabledFinishButton(false);
		}

	}

	public void enabledFinishButton(boolean flag) {
		DBConnectionWizard dbAdapterthis = (DBConnectionWizard) this
				.getWizard();
		dbAdapterthis.finishFlag = flag;
		dbAdapterthis.getContainer().updateButtons();
	}

	public void init(IStructuredSelection selection) {
	}

	public StyledText getTextArea() {
		return textArea;
	}

	public void setTextArea(StyledText textArea) {
		this.textArea = textArea;
	}

}
