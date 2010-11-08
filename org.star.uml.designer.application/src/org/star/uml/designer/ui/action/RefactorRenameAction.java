package org.star.uml.designer.ui.action;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDiagramDocument;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.MetamodelType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.impl.DiagramImpl;
import org.eclipse.gmf.runtime.notation.impl.ShapeImpl;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
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
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.diagram.usecase.edit.helpers.UMLBaseEditHelper;
import org.eclipse.uml2.diagram.usecase.navigator.UMLNavigatorItem;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.VisibilityKind;
import org.eclipse.uml2.uml.internal.impl.ActorImpl;
import org.eclipse.uml2.uml.internal.impl.PackageImpl;
import org.eclipse.uml2.uml.internal.impl.UMLFactoryImpl;
import org.osgi.framework.Bundle;
import org.star.uml.designer.application.Activator;
import org.star.uml.designer.base.constance.GlobalConstants;
import org.star.uml.designer.base.utils.CommonUtil;
import org.star.uml.designer.base.utils.EclipseUtile;
import org.star.uml.designer.base.utils.XmlUtil;
import org.star.uml.designer.service.dao.PmsDao;
import org.star.uml.designer.ui.diagram.action.interfaces.IStarUMLModelAction;
import org.star.uml.designer.ui.factory.StarUMLCommandFactory;
import org.star.uml.designer.ui.factory.StarUMLEditHelperFactory;
import org.star.uml.designer.ui.views.StarPMSModelView;
import org.star.uml.designer.ui.views.StarPMSModelViewUtil;
import org.star.uml.designer.ui.views.StarPMSRequestTableView;
import org.star.uml.designer.ui.views.StarPMSModelView.TreeObject;
import org.star.uml.designer.ui.views.StarPMSModelView.TreeParent;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

public class RefactorRenameAction extends Action{
	public static final String ACTION_ID = "REFACTOR_RENAME";
	public static final String ACTION_URI = "org.star.uml.designer.ui.action.RefactorRenameAction";
	public static final String ACTION_TITLE ="Rename Resource";
	public static final String ICON_PATH = "/icons/alt_window_16.gif";
	
	public RefactorRenameAction() {
		super();
		this.setText(ACTION_TITLE);
		this.setImageDescriptor(getImageDescriptor());
	}
	
	@Override
	public void run() {
		super.run();
		IViewPart view_part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
		.findView(GlobalConstants.PluinID.STAR_PMS_MODEL_VIEW);
		StarPMSModelView modelView = (StarPMSModelView)view_part;
		// 선택된 Tree를 가져온다.
		TreeSelection treeSelection = (TreeSelection)modelView.getTreeViewer().getSelection();
		final TreeObject object = (TreeObject)treeSelection.getFirstElement();
		
		final String readName = object.getName().substring(object.getName().lastIndexOf("("));
		final String editName = object.getName().substring(0,object.getName().lastIndexOf("("));
		
		final Shell shell = new Shell(SWT.TITLE | SWT.BORDER | SWT.APPLICATION_MODAL);
		
		shell.setText(ACTION_TITLE);
		
		GridLayout layout = new GridLayout(3, false);
		GridData gridData = new GridData(400, 150);
	    shell.setLayout(layout);
	    shell.setLayoutData(gridData);
	    shell.setBounds(500, 200,450, 150);
	    
	    Label labelDiagramName = new Label(shell, SWT.NONE);
	    labelDiagramName.setText("New name: ");
	    gridData = new GridData(GridData.END, GridData.CENTER,false, false);
	    labelDiagramName.setLayoutData(gridData);
	    
	    final Text textDiagramName = new Text(shell, SWT.BORDER);
	    gridData = new GridData(GridData.FILL, GridData.FILL, true, false);
	    gridData.horizontalSpan = 2;
	    textDiagramName.setLayoutData(gridData);
		
	    textDiagramName.setText(editName);
		
		Label empty = new Label(shell, SWT.NONE);
	    gridData = new GridData(GridData.FILL, GridData.FILL, true, false);
		gridData.horizontalSpan = 3;
		empty.setText("");
		empty.setLayoutData(gridData);
		
		Label empty1 = new Label(shell, SWT.NONE);
	    gridData = new GridData(GridData.FILL, GridData.FILL, true, false);
		gridData.horizontalSpan = 3;
		empty1.setText("");
		empty1.setLayoutData(gridData);
		
		Label empty2 = new Label(shell, SWT.NONE);
	    gridData = new GridData(GridData.FILL, GridData.FILL, true, false);
		gridData.horizontalSpan = 3;
		empty2.setText("");
		empty2.setLayoutData(gridData);
		
	    final Button buttonLogin = new Button(shell, SWT.NONE);
	    //buttonLogin.setSize(100,100);
	    buttonLogin.setText("OK");
	    
	    gridData = new GridData(GridData.END, GridData.CENTER,true, false);
	    gridData.horizontalSpan = 2;
	    gridData.widthHint = 80;
	    //gridData.heightHint = 25;
	    buttonLogin.setLayoutData(gridData);
	    buttonLogin.addListener(SWT.Selection, new Listener() {
	        public void handleEvent(Event event) {
	        	shell.setVisible(false);
	        	IViewPart model_part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView("org.star.uml.designer.ui.views.StarPMSModelView");
	        	StarPMSModelView modelView = (StarPMSModelView)model_part;
	        	
    			String modelDomStr = null;
    			Document modelDoc = null;
    			
    			String defaultDomStr = null;
    			Document defaultDoc = null;
    			
    			String folderPaht = "";
    			
				try{
	    			folderPaht = ResourcesPlugin.getWorkspace().getRoot().getProject("Root").getLocation().toString();
	    			modelDomStr = XmlUtil.getXmlFileToString(folderPaht+File.separator+GlobalConstants.DEFAULT_VIEW_MODEL_FILE);
	    			modelDoc = XmlUtil.getStringToDocument(modelDomStr);
				}catch(Exception e){
					e.printStackTrace();
				}
				
    			NodeList modelNodes = modelDoc.getElementsByTagName("packagedElement");
    			for(int i = 0; i < modelNodes.getLength(); i++){
    				NamedNodeMap modelAttMap = modelNodes.item(i).getAttributes();
    				if(modelAttMap.getNamedItem(GlobalConstants.StarMoedl.STAR_MODEL_ID) != null 
    						&& modelAttMap.getNamedItem(GlobalConstants.StarMoedl.STAR_MODEL_ID).getNodeValue().equals(object.getData(GlobalConstants.StarMoedl.STAR_MODEL_ID))){
    					
    					File diagram = new File(folderPaht + "/" + object.getData(GlobalConstants.StarMoedl.STAR_MODEL_FILE) + "." + object.getData(GlobalConstants.StarMoedl.STAR_MODEL_EXTENSION));
    					if(diagram.isFile()){
    						diagram.renameTo(new File(folderPaht + "/" + textDiagramName.getText()  + "." + object.getData(GlobalConstants.StarMoedl.STAR_MODEL_EXTENSION)));
    					}
    					
    					modelAttMap.getNamedItem(GlobalConstants.StarMoedl.STAR_MODEL_NAME).setNodeValue(textDiagramName.getText() + readName);
    					modelAttMap.getNamedItem(GlobalConstants.StarMoedl.STAR_MODEL_FILE).setNodeValue(textDiagramName.getText());
    					
    					//모델인 경우 default.uml 수정
    					if(modelAttMap.getNamedItem(GlobalConstants.StarMoedl.STAR_MODEL_CATEGORY) != null 
        						&& modelAttMap.getNamedItem(GlobalConstants.StarMoedl.STAR_MODEL_CATEGORY).getNodeValue().equals(GlobalConstants.StarMoedl.STAR_CATEGORY_DIAGRAM_MODEL)){
    						try{
	    						defaultDomStr = XmlUtil.getXmlFileToString(folderPaht+File.separator+GlobalConstants.DEFAULT_MODEL_FILE);
	    						defaultDoc = XmlUtil.getStringToDocument(defaultDomStr);
	    						
	    						NodeList defaultNodes = defaultDoc.getElementsByTagName("packagedElement");
	    						for(int d = 0; d < defaultNodes.getLength(); d++){
	    							NamedNodeMap defaultAttMap = defaultNodes.item(d).getAttributes();
	    							if(defaultAttMap.getNamedItem(GlobalConstants.StarMoedl.STAR_MODEL_ID) != null 
	    		    						&& defaultAttMap.getNamedItem(GlobalConstants.StarMoedl.STAR_MODEL_ID).getNodeValue().equals(object.getData(GlobalConstants.StarMoedl.STAR_MODEL_ID))){
	    								defaultAttMap.getNamedItem(GlobalConstants.StarMoedl.STAR_MODEL_NAME).setNodeValue(textDiagramName.getText());
	    							}
	    						}
    						}catch(Exception e){
    							e.printStackTrace();
    						}
        				}
    				}
    				
    				
    			}
    			
    			
    			try {
    				XmlUtil.writeXmlFile(modelDoc, folderPaht+File.separator+GlobalConstants.DEFAULT_VIEW_MODEL_FILE);
    				if(defaultDoc != null){
    					XmlUtil.writeXmlFile(defaultDoc, folderPaht+File.separator+GlobalConstants.DEFAULT_MODEL_FILE);
    				}
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
    			object.setData(GlobalConstants.StarMoedl.STAR_MODEL_FILE, textDiagramName.getText());
	        	object.setName(textDiagramName.getText() + readName);
	        	EclipseUtile.refreshProject("Root");
	        	modelView.getTreeViewer().refresh();
	        }
	    });
	    
	    
	    Button buttonClose = new Button(shell, SWT.PUSH);
	    //buttonClose.setSize(100, 100);
	    buttonClose.setText("Cancle");
	    gridData = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
	    gridData.widthHint = 80;
	    //gridData.heightHint = 25;
	    //gridData.verticalAlignment = SWT.BOTTOM; 
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

}
