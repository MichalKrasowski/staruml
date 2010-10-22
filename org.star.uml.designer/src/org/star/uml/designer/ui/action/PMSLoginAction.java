package org.star.uml.designer.ui.action;

import java.net.URL;

import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.osgi.framework.Bundle;
import org.star.uml.designer.Activator;
import org.star.uml.designer.service.dao.PmsDao;
import org.star.uml.designer.ui.views.StarPMSModelViewUtil;

public class PMSLoginAction extends Action {
	
	public static final String ACTION_ID = "PMS_LOGIN";
	public static final String ACTION_URI = "org.star.uml.designer.ui.action.PMSLoginAction";
	public static final String ACTION_TITLE ="Login Repository";
	public static final String ICON_PATH = "/icons/login.gif";
	
	public PMSLoginAction() {
		super();
		this.setText(ACTION_TITLE);
		this.setImageDescriptor(getImageDescriptor());
	}
	@Override
	public void run() {
		super.run();
		final Shell shell = new Shell(SWT.TITLE | SWT.BORDER | SWT.APPLICATION_MODAL);
		shell.setText("StarPMS Login");
		GridData gridData = new GridData();
		GridLayout layout = new GridLayout(2, true);
	    shell.setLayout(layout);
	    shell.setLayoutData(gridData);
	    shell.setBounds(500, 200,200, 125);
	    
	    Label labelUser = new Label(shell, SWT.NULL);
	    labelUser.setText("사용자 아이디 : ");
	    final Text textUser = new Text(shell, SWT.SINGLE | SWT.BORDER);
	    Label labelPass = new Label(shell, SWT.NULL);
	    labelPass.setText("사용자 암호 : " );
	    final Text textPass = new Text(shell, SWT.SINGLE | SWT.BORDER);
	    
	    textUser.setText("041986");
	    textPass.setText("1234");
	    
	    final Button buttonLogin = new Button(shell, SWT.PUSH);
	    buttonLogin.setText("접속");
	    buttonLogin.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_END));
	    buttonLogin.addListener(SWT.Selection, new Listener() {
	        public void handleEvent(Event event) {
	          shell.setVisible(false);
	          PmsDao pd = new PmsDao();
	          Boolean loginFlag = pd.loginValidation(textUser.getText(),textPass.getText());
	          if(!loginFlag){
	        	  MessageDialog.openInformation(shell.getShell(),"StarUML View","사용자 ID와 암호를 확인하여 주시기 바랍니다");
	        	  return;  
	          }
	          StarPMSModelViewUtil.openProjectDialog(shell);			          
	        }
	      });
	    
	    Button buttonClose = new Button(shell, SWT.PUSH);
	    buttonClose.setText("닫기");
	    shell.open();
	    buttonClose.addListener(SWT.Selection, new Listener() {
	        public void handleEvent(Event event) {
	          shell.dispose();
	        }
	      });
	}
	
	public URL getImageURL(){
		Bundle bundle = Platform.getBundle(Activator.PLUGIN_ID);
		return bundle.getEntry(ICON_PATH);
	}
	
	public ImageDescriptor getImageDescriptor(){
		return Activator.getImageDescriptor(ICON_PATH);
	}
}
