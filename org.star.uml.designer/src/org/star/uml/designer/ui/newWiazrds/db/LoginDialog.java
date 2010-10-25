package org.star.uml.designer.ui.newWiazrds.db;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.osgi.framework.Bundle;
import org.star.uml.designer.base.constance.CustomMessages;
import org.star.uml.designer.base.db.DBConnectionManager;
import org.star.uml.designer.service.dao.UserMgtDao;
import org.star.uml.designer.service.uvo.LoginInfo;
import org.star.uml.designer.service.uvo.RepositoryDetails;


public class LoginDialog extends Dialog {
	public static final String PLUGIN_ID = "sobis.enkisoft.bpmn.designer";

	// Login Text
	private Combo repositoryText;
	private Text userText;
	private Text passwordText;
	private String connectionName;
	private String userName;
	private String password;
	private String connectionString;
	private String driverClass;

	private static Connection conn;

	public RepositoryDetails repositoryDetails;

	public LoginDialog(Shell parentShell) {
		super(parentShell);
	}

	protected Control createDialogArea(Composite parent) {

		Composite composite = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout(3, false);
		GridData gridData = new GridData(400, 150);

		composite.setLayout(layout);
		composite.setLayoutData(gridData);

		// 저장소
		Label RepositoryLabel = new Label(composite, SWT.NONE);
		RepositoryLabel.setText(CustomMessages.CONNECT_DIALOG_REPOSITORY);
		RepositoryLabel.setLayoutData(new GridData(GridData.END,
				GridData.CENTER, false, false));

		repositoryText = new Combo(composite, SWT.BORDER | SWT.READ_ONLY);
		gridData = new GridData(GridData.FILL_HORIZONTAL);
		repositoryText.setLayoutData(gridData);
		repositoryText.setVisibleItemCount(20);
		repositoryText.add("-------------------------");
		repositoryText.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {

				if (repositoryText.getSelectionIndex() != 0) {
					setCombo();
				}

			}
		});

		// 정보
		Button connectInfo = new Button(composite, SWT.NONE);
		gridData = new GridData(GridData.FILL_HORIZONTAL);
		connectInfo.setLayoutData(gridData);
		connectInfo.setText(CustomMessages.CONNECT_DIALOG_INFO);
		connectInfo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ConnectionInfoDialog dialog = new ConnectionInfoDialog(
						getShell());
				dialog.setConnectionString(connectionString);
				dialog.setDriverClass(driverClass);
				dialog.setPassword(password);
				dialog.setUserName(userName);
				dialog.open();
			}
		});

		// 사용자 아이디
		Label userLabel = new Label(composite, SWT.NONE);
		userLabel.setText(CustomMessages.USER_ID);
		userLabel.setLayoutData(new GridData(GridData.END, GridData.CENTER,
				false, false));

		userText = new Text(composite, SWT.BORDER);
		gridData = new GridData(GridData.FILL, GridData.FILL, true, false);
		gridData.horizontalSpan = 2;
		userText.setLayoutData(gridData);
		userText.setText("admin");

		// 사용자 비밀번호
		Label passwordLabel = new Label(composite, SWT.NONE);
		passwordLabel.setText(CustomMessages.USER_PW);
		passwordLabel.setLayoutData(new GridData(GridData.END, GridData.CENTER,
				false, false));

		passwordText = new Text(composite, SWT.BORDER | SWT.PASSWORD);
		gridData = new GridData(GridData.FILL, GridData.FILL, true, false);
		gridData.horizontalSpan = 2;
		passwordText.setLayoutData(gridData);
		passwordText.setText("admin");

		reLoadConnection();

		getShell().setText(CustomMessages.LOGIN_TITLE);

		Bundle bundle = Platform.getBundle("sobis.bpa.designer");

		ImageDescriptor img = ImageDescriptor.createFromURL(bundle
				.getEntry("icons/64.gif"));

		getShell().setImage(img.createImage());

		// 커서 옮기기
		userText.setFocus();

		return composite;
	}

	// 버튼 넣기
	protected void createButtonsForButtonBar(Composite parent) {

		// CONNECT_DIALOG_CONFIGURATION
		createButton(parent, IDialogConstants.HELP_ID, CustomMessages.CONFIGURATION,
				false);
		((GridLayout) parent.getLayout()).numColumns++;
		Label empyty1 = new Label(parent, SWT.NONE);
		empyty1.setText("");
		empyty1.setSize(30, 20);

		// OK버튼
		createButton(parent, IDialogConstants.OK_ID,
				CustomMessages.CONNECT_DIALOG_OK, true);

		// 취소 버튼
		createButton(parent, IDialogConstants.CANCEL_ID,
				CustomMessages.CONNECT_DIALOG_CANCEL, false);

	}

	protected void buttonPressed(int buttonId) {

		if (IDialogConstants.OK_ID == buttonId) {
			String user = userText.getText();
			String password = passwordText.getText();

			if (user.equals("")) {
				MessageDialog.openWarning(getShell(),
						CustomMessages.LOGIN_INVALID_FIELD_TITLE,
						CustomMessages.LOGIN_INVALID_FIELD_USER_ERR_MESSAGE);
				return;
			}
			if (password.equals("")) {
				MessageDialog.openWarning(getShell(),
						CustomMessages.LOGIN_INVALID_FIELD_TITLE,
						CustomMessages.LOGIN_INVALID_FIELD_PASSWORD_ERR_MESSAGE);
				return;
			}

			if (repositoryText.getSelectionIndex() == 0) {
				MessageDialog.openWarning(getShell(), CustomMessages.DIALOG_WARNING,
						CustomMessages.LOGIN_CHOICE_REPOSITORY);
				return;
			}

			// DB접속
			if (!connectDB()) {
				MessageDialog.openWarning(getShell(), CustomMessages.DIALOG_WARNING,
						CustomMessages.LOGIN_INVALID_FIELD_AUTHENTICATE_ERR_MESSAGE);
				return;
			}

			// Authenticate User Table
			if (!userAuthenticate(user, password)) {
				destroyDB();
				MessageDialog.openWarning(getShell(), CustomMessages.DIALOG_WARNING,
						CustomMessages.LOGIN_USER_PW_WRONG_ERR_MESSAGE);
				return;
			}

		} else if (IDialogConstants.HELP_ID == buttonId) {

			DBConnectionWizard dbConnectionWizard = new DBConnectionWizard();
			dbConnectionWizard.setParentDialog(this);
			dbConnectionWizard.init(null, StructuredSelection.EMPTY);

			DBConnectionDialog myDialog = new DBConnectionDialog(null,
					dbConnectionWizard);
			myDialog.open();

		} else {
			this.cancelPressed();
		}

		super.buttonPressed(buttonId);
	}

	private boolean connectDB() {

		try {
			DBConnectionManager cm = new DBConnectionManager();
			conn = cm.getConnectionDB(driverClass, connectionString, userName,
					password);

			if (conn != null) {
				LoginInfo.conn = conn;
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("오류 발생\r\n" + e.getMessage());
			return false;
		}
	}

	public static void destroyDB() {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("오류 발생\r\n" + e.getMessage());
		}
	}

	private boolean userAuthenticate(String user, String password) {

		UserMgtDao userMgt = new UserMgtDao();

		LoginInfo.userInfo = userMgt.userAuthenticate(conn, user, password);

		if (LoginInfo.userInfo == null) {

			return false;

		} else {

			try {
				// External Files의 폴더 내용을 전부 삭제 시킨다.
				IWorkspace ws = ResourcesPlugin.getWorkspace();

				IProject project = ws.getRoot().getProject("External Files");

				/*File file = new File(ws.getRoot().getLocation().toString()
						+ "\\\\.metadata");

				deleteDirectory(file.getAbsolutePath());*/

				if (!project.exists()) {
					project.create(null);
				}

				/*
				 * else{ project.delete(true, null); project.create(null); }
				 */

				if (!project.isOpen()) {
					project.open(null);
				}

				LoginInfo.path = project.getLocation().toString() + "\\";

			} catch (Exception e) {
				e.printStackTrace();
			}

			File loginInfoProp = new File(LoginInfo.path + "logininfo.prop");

			if(loginInfoProp.exists()){
				loginInfoProp.delete();
			}
			
			Properties properties = new Properties();

			properties.put("userId", LoginInfo.userInfo.getUserId());

			try {
				properties.store(new FileOutputStream(loginInfoProp),
						" Configuration");
			} catch (IOException e) {
				e.printStackTrace();
			}

			LoginInfo.myPolicy = userMgt.getMyPolicy(conn);
			LoginInfo.policy = userMgt.getPolicy(conn);

			return true;
		}

	}

	/**
	 * Connection 정보를 보여준다.
	 */
	@SuppressWarnings("unchecked")
	public void reLoadConnection() {
		// Connection 정보를 담당하는 DatabaseConnection Class 생성
		GenerateXMLDBInfo generateXMLDBInfo = new GenerateXMLDBInfo();

		Map<String, Object> contents = generateXMLDBInfo.getConnections();

		if (contents != null) {

			List<String> connList = (List<String>) contents
					.get("ConnectionName");

			if (connList != null) {

				repositoryText.removeAll();
				repositoryText.setData("list", contents.get("ConnectionList"));
				repositoryText.add("----------------------------------");
				for (int i = 0; i < connList.size(); i++) {
					repositoryText.add((String) connList.get(i));
				}
				repositoryText.select(connList.size());

				if (connList.size() != 0) {
					setCombo();
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	private void setCombo() {

		Map<String, Map<String, String>> listContents = (Map<String, Map<String, String>>) repositoryText
				.getData("list");

		Map<String, String> contents = (Map<String, String>) listContents
				.get(repositoryText.getText());

		connectionName = (String) contents.get("ConnectionName");
		userName = (String) contents.get("UserName");
		password = (String) contents.get("Password");
		connectionString = (String) contents.get("ConnectionUrl");
		driverClass = (String) contents.get("DriverClass");
	}

	public void deleteDirectory(String path) {
		deleteDirectory(new File(path));
	}

	public void deleteDirectory(File file) {

		if (file.exists()) {
			File[] files = file.listFiles();

			for (int i = 0; i < files.length; i++) {
				if (files[i].isDirectory()) {
					deleteDirectory(files[i]);
				} else {
					files[i].delete();
				}
			}

			file.delete();
		} else {
			return;
		}
	}

	public Combo getRepositoryText() {
		return repositoryText;
	}

	public void setRepositoryText(Combo repositoryText) {
		this.repositoryText = repositoryText;
	}

	public String getConnectionName() {
		return connectionName;
	}

	public void setConnectionName(String connectionName) {
		this.connectionName = connectionName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConnectionString() {
		return connectionString;
	}

	public void setConnectionString(String connectionString) {
		this.connectionString = connectionString;
	}

	public String getDriverClass() {
		return driverClass;
	}

	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}

}
