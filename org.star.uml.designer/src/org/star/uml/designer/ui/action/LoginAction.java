package org.star.uml.designer.ui.action;

import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.star.uml.designer.Activator;
import org.star.uml.designer.service.dao.PmsDao;
import org.star.uml.designer.ui.views.StarPMSModelView;
import org.star.uml.designer.ui.views.StarPMSModelViewUtil;


public class LoginAction implements IViewActionDelegate{
	public final String Action_ID = "LoginAction";
	public final String Action_URI = "org.star.uml.designer.ui.action.LoginAction";
	public final String Action_Title ="Login Action";
	private StarPMSModelView view;
    private IStructuredSelection sel;
    private Boolean loginFlag = false; 
	@Override
	public void init(IViewPart view) {
		this.view = (StarPMSModelView)view;
		
	}

	@Override
	public void run(IAction action) {
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
	          loginFlag = pd.loginValidation(textUser.getText(),textPass.getText());
	          if(!loginFlag){
	        	  MessageDialog.openInformation(shell.getShell(),"StarUML View","사용자 ID와 암호를 확인하여 주시기 바랍니다");
	        	  return;  
	          }
	          
	          //StarPMSModelViewUtil.openProjectDialog(shell);			          
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

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		System.out.println("loginFlag ======= " + loginFlag);
		System.out.println("action ======= " + action.getId());
		if(loginFlag){
			System.out.println("selection ======= " + loginFlag);
			action.setEnabled(false);
		}else{
			action.setEnabled(true);
		}
		sel = (IStructuredSelection)selection;
		
		
	}
}
