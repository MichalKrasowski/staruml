package org.star.uml.designer.ui.views;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.image.ImageFileFormat;
import org.eclipse.gmf.runtime.diagram.ui.render.clipboard.DiagramGenerator;
import org.eclipse.gmf.runtime.diagram.ui.render.clipboard.DiagramImageGenerator;
import org.eclipse.gmf.runtime.diagram.ui.render.internal.DiagramUIRenderPlugin;
import org.eclipse.gmf.runtime.diagram.ui.render.internal.DiagramUIRenderStatusCodes;
import org.eclipse.gmf.runtime.diagram.ui.render.internal.l10n.DiagramUIRenderMessages;
import org.eclipse.gmf.runtime.diagram.ui.render.util.CopyToImageUtil;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.ContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
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
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.osgi.framework.Bundle;
import org.star.uml.designer.Activator;
import org.star.uml.designer.base.utils.EclipseUtile;
import org.star.uml.designer.service.dao.PmsDao;
import org.star.uml.designer.ui.action.ModelDeleteAction;
import org.star.uml.designer.ui.action.PMSLoginAction;
import org.star.uml.designer.ui.action.PMSLogoutAction;
import org.star.uml.designer.ui.diagram.action.ActorCreateAction;
import org.star.uml.designer.ui.diagram.action.UsecaseDiagramCreateAction;
import org.star.uml.designer.ui.newWiazrds.ClassSorceCodeGeneration;
import org.star.uml.designer.ui.views.StarPMSModelView.TreeObject;
import org.star.uml.designer.ui.views.StarPMSModelView.TreeParent;

public class StarPMSModelViewUtil {
	
	public static Action makeLoginAction(final IMenuManager manager){
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
			          try{
				          IContributionItem[] item = manager.getItems();
				          for(int i = 0; i < item.length; i++){
				        	  if(item[i] instanceof ActionContributionItem){
				        		  ActionContributionItem a = (ActionContributionItem)item[i];
				        		  if(a.getId() != null && a.getId().equals("login")){
				        			  IAction s = a.getAction();
				        			  s.setEnabled(false);
				        		  }else if(a.getId() != null && a.getId().equals("logout")){
				        			  IAction s = a.getAction();
				        			  s.setEnabled(true);
				        		  }
				        	  }
				          }
			          }catch(Exception e){
			        	  e.printStackTrace();
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
		};
		loginAction.setId("login");
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
	            	PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView("org.star.uml.designer.ui.views.StarPMSRequestTableView");	
	            	IViewPart view_part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView("org.star.uml.designer.ui.views.StarPMSRequestTableView");
					StarPMSRequestTableView tableView = (StarPMSRequestTableView)view_part;
					tableView.loadTable();
					//Load Model View
	            	IViewPart model_part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView("org.star.uml.designer.ui.views.StarPMSModelView");
	            	StarPMSModelView modelView = (StarPMSModelView)model_part;
	            	modelView.loadModel();
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
	
	public static Action makeLogoutAction(final IMenuManager manager){
		Action logoutAction = new Action() {
			public void run() {
				try{
			          IContributionItem[] item = manager.getItems();
			          for(int i = 0; i < item.length; i++){
			        	  if(item[i] instanceof ActionContributionItem){
			        		  ActionContributionItem a = (ActionContributionItem)item[i];
			        		  if(a.getId() != null && a.getId().equals("login")){
			        			  IAction s = a.getAction();
			        			  s.setEnabled(true);
			        		  }else if(a.getId() != null && a.getId().equals("logout")){
			        			  IAction s = a.getAction();
			        			  s.setEnabled(false);
			        		  }
			        	  }
			          }
			          //StarPMSRequestTableView stv = new StarPMSRequestTableView();
			          //stv.removeTable();
			          IViewPart view_part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView("org.star.uml.designer.ui.views.StarPMSRequestTableView");
			          StarPMSRequestTableView tableView = (StarPMSRequestTableView)view_part;
			          tableView.removeTable();
			          
			          IViewPart request_view = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView("org.star.uml.designer.ui.views.StarPMSModelView");
			          StarPMSModelView requestView = (StarPMSModelView)request_view;
			          requestView.removeTree();
			          //requestView
			          
		          }catch(Exception e){
		        	  e.printStackTrace();
		          }
			}
		};
		logoutAction.setId("logout");
		logoutAction.setText("Logout Repository");
		logoutAction.setToolTipText("Login Repository tooltip");
		logoutAction.setImageDescriptor(Activator.getImageDescriptor("/icons/logout.gif"));
		logoutAction.setEnabled(false);
		return logoutAction;
	}

	public static Action makeAnalysisUsecaseAction(final Composite parent,final ISelection selection,final StarPMSModelView starPMSView){
		Action analysisAction = new Action() {
			public void run() {
				UsecaseDiagramCreateAction aaa = new UsecaseDiagramCreateAction();
//				EclipseUtile.createDiagram("Root","umlusc");
//				IProject projectHandle =  ResourcesPlugin.getWorkspace().getRoot().getProject("Root");
//				IFile file = projectHandle.getFile("custom-messages.properties");
//				Properties props = new Properties();
//				try {
//					projectHandle.refreshLocal(IProject.DEPTH_INFINITE, null);
//					props.load(file.getContents());
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//				String fullFileName = props.getProperty("diagramName");
//				String fileName = fullFileName.substring(0, fullFileName.lastIndexOf("."));
//				
//				TreeSelection treeSelection = (TreeSelection)selection;
//				TreeParent parent = (TreeParent)treeSelection.getFirstElement();
//				String parentPath = (String)parent.getData("path");
//				HashMap map = new HashMap();
//				map.put("path",parent.toString()+"/diagram");
//				IViewPart view_part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView("org.star.uml.designer.ui.views.StarPMSModelView");
//				StarPMSModelView modelView = (StarPMSModelView)view_part;
//				modelView.addChildXml("packagedElement",parent.getData("key").toString(),fileName);
//				parent.appendChield(parent, fileName, map);
				
//				org.eclipse.uml2.diagram.usecase.part.UMLCreationWizard wiazrd = new org.eclipse.uml2.diagram.usecase.part.UMLCreationWizard();
//				wiazrd.init(PlatformUI.getWorkbench(), (IStructuredSelection) selection);
//				WizardDialog dlg = new WizardDialog(parent.getShell(),wiazrd);
//				int resultInt = dlg.open();
//				if(resultInt == 0){
//					TreeSelection treeSelection = (TreeSelection)selection;
//					TreeParent parent = (TreeParent)treeSelection.getFirstElement();
//					
//					Bundle bundle = Platform.getBundle("org.star.uml.designer");
//					FileInputStream in = null;
//					String fileName = "";
//					try {
//						URL fileURL = bundle.getEntry("properties/temp.properties"); 
//						File file = new File(FileLocator.resolve(fileURL).toURI());  
//						in = new FileInputStream(file);
//						Properties props = new Properties();
//						props.load(in);
//						fileName = props.getProperty("diagramName");
//						fileName = fileName.substring(0, fileName.lastIndexOf("."));
//					} catch (Exception e) {
//						e.printStackTrace();
//					}finally{
//						try {
//							in.close();
//						} catch (IOException e) {
//							e.printStackTrace();
//						}
//					}
//					String parentPath = (String)parent.getData("path");
//					HashMap map = new HashMap();
//					map.put("path",parent.toString()+"/diagram");
//					IViewPart view_part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView("org.star.uml.designer.ui.views.StarPMSModelView");
//					StarPMSModelView modelView = (StarPMSModelView)view_part;
//					modelView.addChildXml("packagedElement",parent.getData("key").toString(),fileName);
//					parent.appendChield(parent, fileName, map);
//				}
			}
		};
		analysisAction.setText("Create Usecase Diagram");
		analysisAction.setImageDescriptor(Activator.getImageDescriptor("/icons/login.gif"));
		return analysisAction;
	}
	
	public static Action makeAnalysisUseCaseDiagramAction(final Composite parent,final ISelection selection,final StarPMSModelView starPMSView){
		Action analysisAction = new Action() {
			public void run() {
				HashMap inputData = new HashMap();
				IViewPart view_part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView("org.star.uml.designer.ui.views.StarPMSRequestTableView");
				StarPMSRequestTableView tableView = (StarPMSRequestTableView)view_part;
				Table table = tableView.getTable();
				int flagCnt = 0;
				for(int i=0; i<table.getItemCount(); i++){
        			 TableItem item = table.getItem(i);
        			 if(item.getChecked()){
        				 String req_usecase_seq = (String)item.getData("seq");
        				 inputData.put("req_usecase_seq", req_usecase_seq);
        				 flagCnt++;
        			 }
        		 }
				 if(flagCnt == 0){
					 MessageDialog.openInformation(parent.getShell(),"다이어그램 저장","Request Table에서 저장될 항목을 선택 해 주세요");
					 return;
				 }
				try{
				org.eclipse.uml2.diagram.sequence.part.UMLCreationWizard wiazrd = new org.eclipse.uml2.diagram.sequence.part.UMLCreationWizard();
				wiazrd.init(PlatformUI.getWorkbench(), (IStructuredSelection) selection);
				WizardDialog dlg = new WizardDialog(parent.getShell(),wiazrd);
				int resultInt = dlg.open();
				if(resultInt == 0){
					TreeSelection treeSelection = (TreeSelection)selection;
					TreeObject chield = (TreeObject)treeSelection.getFirstElement();
					TreeParent anlaysisTree = chield.getParent().getParent();
					TreeParent parent = (TreeParent)anlaysisTree.getChildren()[0];
					Bundle bundle = Platform.getBundle("org.star.uml.designer");
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
					inputData.put("path",parent.toString()+"/diagram");
					parent.appendChield(parent,fileName, inputData);
					
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
	
	public static Action makeAnalysisUseCaseDiagramSaveAction(final Composite parent,final ISelection selection){
		Action analysisAction = new Action() {
			public void run() {
				IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		        if(page.getActiveEditor() !=null && page.getActiveEditor() instanceof org.eclipse.uml2.diagram.usecase.part.UMLDiagramEditor){
		        	Map inputData = new HashMap();
	            	IViewPart view_part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView("org.star.uml.designer.ui.views.StarPMSRequestTableView");
					StarPMSRequestTableView tableView = (StarPMSRequestTableView)view_part;
					Table table = tableView.getTable();
					int flagCnt = 0;
					for(int i=0; i<table.getItemCount(); i++){
	        			 TableItem item = table.getItem(i);
	        			 if(item.getChecked()){
	        				 String seq = (String)item.getData("seq");
	        				 String name =  item.getText(2);
	        				 inputData.put("parentSeq", seq);
	        				 inputData.put("name", name);
	        				 flagCnt++;
	        			 }
	        		 }
					 if(flagCnt == 0){
						 MessageDialog.openInformation(parent.getShell(),"다이어그램 저장","Request Table에서 저장될 항목을 선택 해 주세요");
						 return;
					 }
		        	final MultiStatus status = new MultiStatus(DiagramUIRenderPlugin
		    				.getPluginId(), DiagramUIRenderStatusCodes.OK,
		    				DiagramUIRenderMessages.CopyToImageAction_Label, null);
		        	IRunnableWithProgress runnable = createRunnable(status);
			    	try {
			    		ProgressMonitorDialog progressMonitorDialog = new ProgressMonitorDialog(
			    				Display.getCurrent().getActiveShell());
			    		progressMonitorDialog.run(false, true, runnable);
			    		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView("org.star.uml.designer.ui.views.StarPMSRequestTableView");
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					String folderPaht = ResourcesPlugin.getWorkspace().getRoot().getProject("Root").getLocation().toString();
					File img = new File(folderPaht + "/default.png");
					PmsDao pd = new PmsDao();
					
					inputData.put("img", img);
					try{
						pd.diragramUpdate(inputData);
					}catch(Exception e){
						e.printStackTrace();
					}
		        }
			}
		};
		analysisAction.setText("Save Diagram");
		analysisAction.setImageDescriptor(Activator.getImageDescriptor("/icons/login.gif"));
		return analysisAction;
	}
	
	public static Action makeAnalysisSequenceDiagramSaveAction(final Composite parent,final ISelection selection){
		Action analysisAction = new Action() {
			public void run() {
				IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				if(page.getActiveEditor() !=null && page.getActiveEditor() instanceof org.eclipse.uml2.diagram.sequence.part.UMLDiagramEditor){
		        	final MultiStatus status = new MultiStatus(DiagramUIRenderPlugin
		    				.getPluginId(), DiagramUIRenderStatusCodes.OK,
		    				DiagramUIRenderMessages.CopyToImageAction_Label, null);
		        	IRunnableWithProgress runnable = createRunnable(status);
			    	try {
			    		ProgressMonitorDialog progressMonitorDialog = new ProgressMonitorDialog(
			    				Display.getCurrent().getActiveShell());
			    		progressMonitorDialog.run(false, true, runnable);
			    		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView("org.star.uml.designer.ui.views.StarPMSRequestTableView");
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					String folderPaht = ResourcesPlugin.getWorkspace().getRoot().getProject("Root").getLocation().toString();
					File img = new File(folderPaht + "/default.png");
					PmsDao pd = new PmsDao();
					
					TreeSelection treeSelection = (TreeSelection)selection;
		        	TreeObject chield = (TreeObject)treeSelection.getFirstElement();
		        	String  req_usecase_seq = (String)chield.getData("req_usecase_seq");
		        	Map inputData = new HashMap();
		        	inputData.put("REQ_USECASE_SEQ", req_usecase_seq);
					inputData.put("img", img);
					inputData.put("name", "시퀸스 다이어 그램");
					try{
						pd.analysis_insert(inputData);
						pd.analysisUpdate(inputData);
					}catch(Exception e){
						e.printStackTrace();
					}
		        }
			}
		};
		analysisAction.setText("Save Diagram");
		analysisAction.setImageDescriptor(Activator.getImageDescriptor("/icons/login.gif"));
		return analysisAction;
	}
	
	private static IRunnableWithProgress createRunnable(final MultiStatus status) {
		return new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) {
				try {
					IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
					DiagramDocumentEditor editor = null;
					if(page.getActiveEditor() instanceof org.eclipse.uml2.diagram.usecase.part.UMLDiagramEditor){
						editor = (org.eclipse.uml2.diagram.usecase.part.UMLDiagramEditor)page.getActiveEditor();
					}else if(page.getActiveEditor() instanceof org.eclipse.uml2.diagram.sequence.part.UMLDiagramEditor){
						editor = (org.eclipse.uml2.diagram.sequence.part.UMLDiagramEditor)page.getActiveEditor();
					}
					
		        	DiagramEditPart diagramEditPart = editor.getDiagramEditPart();
		        	EditPart focusEdit = diagramEditPart.getViewer().getFocusEditPart();
					CopyToImageUtil  copyToImageUtil = new CopyToImageUtil();
					String folderPaht = ResourcesPlugin.getWorkspace().getRoot().getProject("Root").getLocation().toString();
					IPath path = new Path(folderPaht+"/default.png");
			    	ImageFileFormat format = ImageFileFormat.resolveImageFormat(5);
			    	DiagramGenerator gen = new DiagramImageGenerator(diagramEditPart);
			    	monitor.beginTask("", 6); 
					monitor.worked(1);
					copyToImageUtil.copyToImage(diagramEditPart, path, format,monitor);
				} catch (CoreException e) {
					e.printStackTrace();
					status.add(e.getStatus());
				} finally {
					monitor.done();
				}
			}
		};
	}
	
	public static Action makeUsecaseReportAction(final Composite parent,final ISelection selection){
		Action analysisAction = new Action() {
			public void run() {
				TreeSelection treeSelection = (TreeSelection)selection;
	        	TreeObject chield = (TreeObject)treeSelection.getFirstElement();
	        	String  req_usecase_seq = (String)chield.getData("req_usecase_seq");
				IViewPart view_part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView("org.star.uml.designer.ui.views.StarPMSBrowersView");
	            StarPMSBrowersView brower = (StarPMSBrowersView)view_part;
	            String url = "http://192.168.10.193:8080/starPMS/processMgt/viewUseCaseReportSimple.do?usecaseSeq=";
	            brower.setURL(url+req_usecase_seq);
	            try {
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView("org.star.uml.designer.ui.views.StarPMSBrowersView");
				} catch (PartInitException e) {
					e.printStackTrace();
				}
			}
		};
		analysisAction.setText("View Usecase Report");
		analysisAction.setImageDescriptor(Activator.getImageDescriptor("/icons/login.gif"));
		return analysisAction;
	}
	
	public static Action makeImplemetationClassDiagramAction(final Composite parent,final ISelection selection){
		Action implrmrnysyionAction = new Action() {
			public void run() {
				ClassSorceCodeGeneration wiazrd = new ClassSorceCodeGeneration();
				wiazrd.init(PlatformUI.getWorkbench(), (IStructuredSelection) selection);
				WizardDialog dlg = new WizardDialog(parent.getShell(),wiazrd);
			}
		};
		implrmrnysyionAction.setText("Generate Source Code");
		implrmrnysyionAction.setImageDescriptor(Activator.getImageDescriptor("/icons/login.gif"));
		return implrmrnysyionAction;
	}
	
	public static void initContextMenu(MenuManager menuMgr){
		PMSLoginAction login = new PMSLoginAction();
		PMSLogoutAction logout = new PMSLogoutAction();
		ModelDeleteAction delete = new ModelDeleteAction();
		
		MenuManager diagramGroup = new MenuManager("Diagram");
		UsecaseDiagramCreateAction usecaseDiagram = new UsecaseDiagramCreateAction();
		
		MenuManager modelGroup = new MenuManager("Model");
		ActorCreateAction actor = new ActorCreateAction();
		
		menuMgr.add(login);
		menuMgr.add(logout);
		menuMgr.add(new Separator());
		menuMgr.add(delete);
		menuMgr.add(new Separator());
		menuMgr.add(diagramGroup);
		menuMgr.add(modelGroup);
		
		
		diagramGroup.add(usecaseDiagram);
		
		modelGroup.add(actor);
		
	}
	
}
