/*******************************************************************************
 * Copyright (c) 2010 SeRang Yang and others.
 *  
 * SoBis BPA is an RCP application developed for SOA Tool
 *******************************************************************************/
package org.star.uml.designer.ui.newWiazrds.db;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.star.uml.designer.base.constance.CustomMessages;

public class ConnectionInfoDialog extends Dialog {
	public static final String PLUGIN_ID = "sobis.enkisoft.bpmn.designer";

	// Login Text
	private Group propertyGroup;
	private Label dbClassTextLabel;
	private Label urlDBTextLabel;
	private Label userDBTextLabel;
	private Label passwordDBText;
	private String userName;
	private String password;
	private String connectionString;
	private String driverClass;

	public ConnectionInfoDialog(Shell parentShell) {
		super(parentShell);
	}

	protected Control createDialogArea(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout(2, false);
		composite.setLayout(layout);

		// Group
		propertyGroup = new Group(composite, SWT.SHADOW_ETCHED_IN);
		propertyGroup.setText(CustomMessages.LOGIN_CONNECTION_INFO);
		GridLayout propertyLayout = new GridLayout(2, false);
		GridData data = new GridData();
		data.grabExcessVerticalSpace = false;
		data.grabExcessHorizontalSpace = true;
		data.horizontalAlignment = GridData.FILL;
		data.verticalAlignment = GridData.FILL;
		data.horizontalSpan = 2;
		data.verticalSpan = 1;

		propertyGroup.setLayout(propertyLayout);
		propertyGroup.setLayoutData(data);

		// DB Class
		Label dbClassLabel = new Label(propertyGroup, SWT.NONE);
		dbClassLabel.setText(CustomMessages.LOGIN_CONNECTION_DRIVER);
		dbClassLabel.setLayoutData(new GridData(GridData.END, GridData.CENTER,
				false, false));

		dbClassTextLabel = new Label(propertyGroup, SWT.NONE);
		dbClassTextLabel.setText(driverClass);
		dbClassTextLabel.setLayoutData(new GridData(GridData.FILL,
				GridData.FILL, true, false));

		// DB URL
		Label urlDBLabel = new Label(propertyGroup, SWT.NONE);
		urlDBLabel.setText(CustomMessages.LOGIN_CONNECTION_ADDRESS);
		urlDBLabel.setLayoutData(new GridData(GridData.END, GridData.CENTER,
				false, false));

		urlDBTextLabel = new Label(propertyGroup, SWT.NONE);
		urlDBTextLabel.setText(connectionString);
		urlDBTextLabel.setLayoutData(new GridData(GridData.FILL, GridData.FILL,
				true, false));

		// DB User
		Label userDBLabel = new Label(propertyGroup, SWT.NONE);
		userDBLabel.setText(CustomMessages.USER_ID);
		userDBLabel.setLayoutData(new GridData(GridData.END, GridData.CENTER,
				false, false));

		userDBTextLabel = new Label(propertyGroup, SWT.NONE);
		userDBTextLabel.setText(userName);
		userDBTextLabel.setLayoutData(new GridData(GridData.FILL,
				GridData.FILL, true, false));

		// DB Password
		Label passwordDBLabel = new Label(propertyGroup, SWT.NONE);
		passwordDBLabel.setText(CustomMessages.USER_PW);
		passwordDBLabel.setLayoutData(new GridData(GridData.END,
				GridData.CENTER, false, false));

		passwordDBText = new Label(propertyGroup, SWT.NONE | SWT.PASSWORD);
		passwordDBText.setText(password);
		passwordDBText.setLayoutData(new GridData(GridData.FILL, GridData.FILL,
				true, false));
		
		getShell().setText(CustomMessages.CONNECT_DIALOG_INFO);
		
		return composite;
	}

	// 버튼 넣기
	protected void createButtonsForButtonBar(Composite parent) {
		// OK버튼
		createButton(parent, IDialogConstants.OK_ID, CustomMessages.OK, true);
	}

	protected void buttonPressed(int buttonId) {
		super.buttonPressed(buttonId);
	}

	protected void okPressed() {

		super.okPressed();
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
