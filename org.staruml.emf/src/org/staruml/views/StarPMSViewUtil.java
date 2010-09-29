package org.staruml.views;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.osgi.framework.Bundle;
import org.staruml.views.StarPMSView.TreeObject;
import org.staruml.views.StarPMSView.TreeParent;

import org_.staruml.Activator;

public class StarPMSViewUtil {
	
	public static Action makeLoginAction(){
		Action loginAction = new Action() {
			public void run() {
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
			    
			    final Button buttonLogin = new Button(shell, SWT.PUSH);
			    buttonLogin.setText("접속");
			    buttonLogin.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_END));
			    buttonLogin.addListener(SWT.Selection, new Listener() {
			        public void handleEvent(Event event) {
			          shell.setVisible(false);
			          StarPMSViewUtil.openProjectDialog(shell);
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
		};
		loginAction.setText("Login Repository");
		loginAction.setToolTipText("Login Repository Model tooltip");
		loginAction.setImageDescriptor(Activator.getImageDescriptor("/icons/login.gif"));
		return loginAction;
	}
	
	public static void openProjectDialog(final Shell parentShell){
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
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView("org.staruml.views.StarPMSRequestTableView");
			} catch (PartInitException e) {
				e.printStackTrace();
			}
	          shell.dispose();
	          parentShell.dispose();
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
	
	public static Action makeLogoutAction(){
		Action logoutAction = new Action() {
			public void run() {
				
			}
		};
		logoutAction.setText("Logout Repository");
		logoutAction.setToolTipText("Login Repository tooltip");
		logoutAction.setImageDescriptor(Activator.getImageDescriptor("/icons/logout.gif"));
		logoutAction.setEnabled(false);
		return logoutAction;
	}

	public static Action makeAnalysisUsecaseAction(final Composite parent,final ISelection selection,final StarPMSView starPMSView){
		Action analysisAction = new Action() {
			public void run() {
//				org.staruml.wizard.clazz.SorceCodeGeneration wiazrd = new org.staruml.wizard.clazz.SorceCodeGeneration();
				org.eclipse.uml2.diagram.usecase.part.UMLCreationWizard wiazrd = new org.eclipse.uml2.diagram.usecase.part.UMLCreationWizard();
				wiazrd.init(PlatformUI.getWorkbench(), (IStructuredSelection) selection);
				WizardDialog dlg = new WizardDialog(parent.getShell(),wiazrd);
				int resultInt = dlg.open();
				if(resultInt == 0){
					TreeSelection treeSelection = (TreeSelection)selection;
					TreeParent parent = (TreeParent)treeSelection.getFirstElement();
					Bundle bundle = Platform.getBundle("org.StarUML");
					FileInputStream in = null;
					String fileName = "";
					try {
						URL fileURL = bundle.getEntry("properties/temp.properties"); 
						File file = new File(FileLocator.resolve(fileURL).toURI());  
						in = new FileInputStream(file);
						Properties props = new Properties();
						props.load(in);
						fileName = props.getProperty("diagramName");
						fileName = fileName.substring(0, fileName.lastIndexOf("."));
					} catch (Exception e) {
						e.printStackTrace();
					}finally{
						try {
							in.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					String parentPath = (String)parent.getData("path");
					System.out.println(parentPath+"/diagram");
					parent.appendChield(parent,fileName,parentPath+"/diagram");
				}
			}
		};
		analysisAction.setText("Create Usecase Diagram");
		analysisAction.setImageDescriptor(Activator.getImageDescriptor("/icons/login.gif"));
		return analysisAction;
	}
	
	public static Action makeAnalysisUseCaseDiagramAction(final Composite parent,final ISelection selection,final StarPMSView starPMSView){
		Action analysisAction = new Action() {
			public void run() {
				try{
				org.eclipse.uml2.diagram.sequence.part.UMLCreationWizard wiazrd = new org.eclipse.uml2.diagram.sequence.part.UMLCreationWizard();
				wiazrd.init(PlatformUI.getWorkbench(), (IStructuredSelection) selection);
				WizardDialog dlg = new WizardDialog(parent.getShell(),wiazrd);
				int resultInt = dlg.open();
				System.out.println("resultInt : "+resultInt);
				if(resultInt == 0){
					TreeSelection treeSelection = (TreeSelection)selection;
					TreeObject chield = (TreeObject)treeSelection.getFirstElement();
					TreeParent anlaysisTree = chield.getParent().getParent();
					TreeParent parent = (TreeParent)anlaysisTree.getChildren()[1];
					System.out.println("parent : "+parent);
					Bundle bundle = Platform.getBundle("org.StarUML");
					FileInputStream in = null;
					String fileName = "";
					try {
						URL fileURL = bundle.getEntry("properties/temp.properties"); 
						File file = new File(FileLocator.resolve(fileURL).toURI());  
						in = new FileInputStream(file);
						Properties props = new Properties();
						props.load(in);
						fileName = props.getProperty("diagramName");
						fileName = fileName.substring(0, fileName.lastIndexOf("."));
					} catch (Exception e) {
						e.printStackTrace();
					}finally{
						try {
							in.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					String parentPath = (String)parent.getData("path");
					parent.appendChield(parent,fileName,parentPath+"/diagram");
				}
				}catch(Exception e){
					e.printStackTrace();
				}
			}
				
		};
		analysisAction.setText("Create Sequence Diagram");
		analysisAction.setImageDescriptor(Activator.getImageDescriptor("/icons/login.gif"));
		return analysisAction;
	}

	public static Action makeSequenceDiagramAction(final Composite parent,final ISelection selection){
		Action analysisAction = new Action() {
			public void run() {
				try{
				org.eclipse.uml2.diagram.clazz.part.UMLCreationWizard wiazrd = new org.eclipse.uml2.diagram.clazz.part.UMLCreationWizard();
				wiazrd.init(PlatformUI.getWorkbench(), (IStructuredSelection) selection);
				WizardDialog dlg = new WizardDialog(parent.getShell(),wiazrd);
				int resultInt = dlg.open();
				if(resultInt == 0){
					TreeSelection treeSelection = (TreeSelection)selection;
					TreeObject chield = (TreeObject)treeSelection.getFirstElement();
					TreeParent projectTree = chield.getParent().getParent().getParent();
					TreeParent ImplementationParent = (TreeParent)projectTree.getChildren()[2];
					TreeParent parent = (TreeParent)ImplementationParent.getChildren()[0];
					Bundle bundle = Platform.getBundle("org.StarUML");
					FileInputStream in = null;
					String fileName = "";
					try {
						URL fileURL = bundle.getEntry("properties/temp.properties"); 
						File file = new File(FileLocator.resolve(fileURL).toURI());  
						in = new FileInputStream(file);
						Properties props = new Properties();
						props.load(in);
						fileName = props.getProperty("diagramName");
						fileName = fileName.substring(0, fileName.lastIndexOf("."));
					} catch (Exception e) {
						e.printStackTrace();
					}finally{
						try {
							in.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					String parentPath = (String)parent.getData("path");
					parent.appendChield(parent,fileName,parentPath+"/diagram");
				}
				}catch(Exception e){
					e.printStackTrace();
				}
			}
				
		};
		analysisAction.setText("Create Class Diagram");
		analysisAction.setImageDescriptor(Activator.getImageDescriptor("/icons/login.gif"));
		return analysisAction;
	}
	
	public static Action makeDesignAction(final Composite parent,final ISelection selection){
		Action designAction = new Action() {
			public void run() {
				org.eclipse.uml2.diagram.clazz.part.UMLCreationWizard wiazrd = new org.eclipse.uml2.diagram.clazz.part.UMLCreationWizard();
				wiazrd.init(PlatformUI.getWorkbench(), (IStructuredSelection) selection);
				WizardDialog dlg = new WizardDialog(parent.getShell(),wiazrd);
				System.out.println(dlg.open());
			}
		};
		designAction.setText("Create Class Diagram");
		designAction.setImageDescriptor(Activator.getImageDescriptor("/icons/login.gif"));
		return designAction;
	}
	
	public static Action makeImplemetationClassDiagramAction(final Composite parent,final ISelection selection){
		Action implrmrnysyionAction = new Action() {
			public void run() {
				org.staruml.wizard.clazz.SorceCodeGeneration wiazrd = new org.staruml.wizard.clazz.SorceCodeGeneration();
				wiazrd.init(PlatformUI.getWorkbench(), (IStructuredSelection) selection);
				WizardDialog dlg = new WizardDialog(parent.getShell(),wiazrd);
				System.out.println(dlg.open());
			}
		};
		implrmrnysyionAction.setText("Generate Source Code");
		implrmrnysyionAction.setImageDescriptor(Activator.getImageDescriptor("/icons/login.gif"));
		return implrmrnysyionAction;
	}
	
}
