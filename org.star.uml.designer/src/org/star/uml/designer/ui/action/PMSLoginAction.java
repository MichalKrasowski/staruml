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
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PlatformUI;
import org.osgi.framework.Bundle;
import org.star.uml.designer.Activator;
import org.star.uml.designer.service.dao.PmsDao;
import org.star.uml.designer.ui.views.StarPMSModelView;
import org.star.uml.designer.ui.views.StarPMSModelViewUtil;
import org.star.uml.designer.ui.views.StarPMSRequestTableView;

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
		GridLayout layout = new GridLayout(2, true);
		GridData gridData = new GridData(400, 150);
	    shell.setLayout(layout);
	    shell.setLayoutData(gridData);
	    shell.setBounds(500, 200,200, 150);
	    
	    Label labelUser = new Label(shell, SWT.NONE);
	    labelUser.setText("사용자 아이디");
	    gridData = new GridData(GridData.FILL, GridData.FILL, true, false);
	    gridData.widthHint = 50;
	    labelUser.setLayoutData(gridData);
	    
	    final Text textUser = new Text(shell, SWT.BORDER);
	    gridData = new GridData(GridData.FILL, GridData.FILL, true, false);
	    gridData.widthHint = 100;
	    //gridData.horizontalSpan = 2;
	    textUser.setLayoutData(gridData);
	    
	    
	    Label labelPass = new Label(shell, SWT.NONE);
	    labelPass.setText("사용자 암호");
	    gridData = new GridData(GridData.FILL, GridData.FILL,false, false);
	    gridData.widthHint = 50;
	    labelPass.setLayoutData(gridData);
	    
	    final Text textPass = new Text(shell, SWT.BORDER | SWT.PASSWORD);
	    gridData = new GridData(GridData.FILL, GridData.FILL, true, false);
	    gridData.widthHint = 100;
		textPass.setLayoutData(gridData);
		
		textUser.setText("041986");
		textPass.setText("1234");
		
		Label empty = new Label(shell, SWT.NONE);
	    gridData = new GridData(GridData.FILL, GridData.FILL, true, false);
		gridData.horizontalSpan = 2;
		empty.setText("");
		empty.setLayoutData(gridData);
		
		Label empty1 = new Label(shell, SWT.NONE);
	    gridData = new GridData(GridData.FILL, GridData.FILL, true, false);
		gridData.horizontalSpan = 2;
		empty1.setText("");
		empty1.setLayoutData(gridData);
		
	    final Button buttonLogin = new Button(shell, SWT.NONE);
	    //buttonLogin.setSize(100,100);
	    buttonLogin.setText("접속");
	    
	    gridData = new GridData(GridData.HORIZONTAL_ALIGN_END);
	    
	    //gridData.verticalAlignment = SWT.CENTER; 
	    
	    gridData.widthHint = 80;
	    gridData.heightHint = 20;
	    buttonLogin.setLayoutData(gridData);
	    buttonLogin.addListener(SWT.Selection, new Listener() {
	        public void handleEvent(Event event) {
	          shell.setVisible(false);
	          PmsDao pd = new PmsDao();
	          Boolean loginFlag = pd.loginValidation(textUser.getText(),textPass.getText());
	          if(!loginFlag){
	        	  MessageDialog.openInformation(shell.getShell(),"StarUML View","사용자 ID와 암호를 확인하여 주시기 바랍니다");
	        	  return;  
	          }
	          //openProjectDialog(shell);	
	          
	          IViewPart view_part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView("org.star.uml.designer.ui.views.StarPMSRequestTableView");
	          StarPMSRequestTableView tableView = (StarPMSRequestTableView)view_part;
	          tableView.loadTable();
				//Load Model View
	          StarPMSModelViewUtil.loadModel("Root", textUser.getText());
	          IViewPart model_part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView("org.star.uml.designer.ui.views.StarPMSModelView");
	          StarPMSModelView modelView = (StarPMSModelView)model_part;
	          modelView.setLoginFlag(true);
	          //parentShell.dispose();
		        
	        }
	      });
	    
	    
	    Button buttonClose = new Button(shell, SWT.PUSH);
	    //buttonClose.setSize(100, 100);
	    buttonClose.setText("닫기");
	    gridData = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
	    gridData.widthHint = 80;
	    gridData.heightHint = 20;
	    gridData.verticalAlignment = SWT.BOTTOM; 
	    buttonClose.setLayoutData(gridData);
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
	
	/*
	public void openProjectDialog(final Shell parentShell){
		final Shell shell = new Shell(SWT.TITLE | SWT.BORDER | SWT.APPLICATION_MODAL);
		shell.setText("Select StarPMS Project");
		GridData gridData = new GridData();
		GridLayout layout = new GridLayout(2, false);
	    shell.setLayout(layout);
	    shell.setLayoutData(gridData);
	    shell.setBounds(500, 200,240, 100);
	    
	    Label labelProject = new Label(shell, SWT.NULL);
	    labelProject.setText("프로젝트 : ");
	    final Combo combo = new Combo(shell, SWT.DROP_DOWN |SWT.READ_ONLY );
	    combo.add("실적이상관리 시스템");
        combo.add("회의실 예약 관리 시스템");
	    
	    final Button buttonLogin = new Button(shell, SWT.PUSH);
	    buttonLogin.setText("접속");
	    buttonLogin.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_END));
	    buttonLogin.addListener(SWT.Selection, new Listener() {
	        public void handleEvent(Event event) {
	            try {
	            	PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView("org.star.uml.designer.ui.views.StarPMSRequestTableView");	
	            	IViewPart view_part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView("org.star.uml.designer.ui.views.StarPMSRequestTableView");
					StarPMSRequestTableView tableView = (StarPMSRequestTableView)view_part;
					tableView.loadTable();
					//Load Model View
					StarPMSModelViewUtil.loadModel("Root");
	            	IViewPart model_part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView("org.star.uml.designer.ui.views.StarPMSModelView");
	            	StarPMSModelView modelView = (StarPMSModelView)model_part;
	            	modelView.setLoginFlag(true);
					shell.dispose();
			        parentShell.dispose();
				} catch (Exception e) {
					e.printStackTrace();
				}
	        }
	      });
	    
	    Button buttonClose = new Button(shell, SWT.PUSH);
	    buttonClose.setText("닫기");
	    buttonClose.addListener(SWT.Selection, new Listener() {
	        public void handleEvent(Event event) {
	          parentShell.setVisible(true);
	          shell.dispose();
	        }
	      });
	    
	    shell.open();
	}
	*/
}
