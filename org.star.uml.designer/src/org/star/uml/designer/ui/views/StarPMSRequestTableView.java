package org.star.uml.designer.ui.views;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.image.ImageFileFormat;
import org.eclipse.gmf.runtime.diagram.ui.render.clipboard.DiagramGenerator;
import org.eclipse.gmf.runtime.diagram.ui.render.clipboard.DiagramImageGenerator;
import org.eclipse.gmf.runtime.diagram.ui.render.internal.DiagramUIRenderPlugin;
import org.eclipse.gmf.runtime.diagram.ui.render.internal.DiagramUIRenderStatusCodes;
import org.eclipse.gmf.runtime.diagram.ui.render.internal.l10n.DiagramUIRenderMessages;
import org.eclipse.gmf.runtime.diagram.ui.render.util.CopyToImageUtil;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDiagramDocument;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.impl.DiagramImpl;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.UseCaseEditPart;
import org.eclipse.uml2.diagram.usecase.navigator.UMLNavigatorItem;
import org.eclipse.uml2.uml.internal.impl.PackageImpl;
import org.star.uml.designer.Activator;
import org.star.uml.designer.base.utils.EclipseUtile;
import org.star.uml.designer.service.dao.PmsDao;

public class StarPMSRequestTableView extends ViewPart {
	                                 
	public static final String ID = "org.star.uml.designer.ui.views.StarPMSRequestTableView";
	private Composite shell;
	private Table table;
	private java.util.List<TableEditor> editors = new ArrayList<TableEditor>();
	private java.util.List<Button> btns = new ArrayList<Button>();
	public StarPMSRequestTableView() {
	}

	public void createPartControl(Composite shell) {
		shell.setLayout(new FillLayout());
		table = makeTable(shell);
		this.shell = shell;
	}
	
	public void loadTable(){
		PmsDao pd = new PmsDao();
		
	    List projectList = pd.usecaseList();
	    for(int i = 0; i < projectList.size(); i++){
	    	Map data = (HashMap)projectList.get(i);
	    		    	
	    	TableItem body = new TableItem(table, SWT.NONE);
	    	body.setData("seq", data.get("REQ_USECASE_SEQ").toString());
	    	
	    	TableEditor editor = new TableEditor(table);
	    	Button button = new Button(table, SWT.PUSH);
	    	button.setData("eventSrc", "model");
		    button.setText("모델 등록");
		    button.setData("row", body);
		    addButtonListener(button);
		    editor.grabHorizontal = true;
		    editor.setEditor(button, body, 4);
		    
		    body.setText(0, "요구사항");
		    body.setText(1, data.get("REQUIREMENT_NAME").toString());
		    body.setText(2, data.get("USECASE_NAME").toString());
		    body.setText(3, data.get("USECASE_NAME").toString().equals("")? "미등록" : "등록");
		    editors.add(editor);
		    btns.add(button);
	    }
	}
	
	public void removeTable(){
		for(int i = editors.size() - 1; i >= 0; i--){
			TableEditor editor = editors.get(i);
			editor.dispose();
			editors.remove(i);
			
			Button button = btns.get(i);
			button.dispose();
			btns.remove(i);
		}
		table.removeAll();
		
	}
	public static Action makeBrowerAction(){
		Action BrowerAction = new Action() {
			public void run() {
			}
		};
		BrowerAction.setText("상세보기");
		BrowerAction.setToolTipText("상세보기 tooltip");
		BrowerAction.setImageDescriptor(Activator.getImageDescriptor("/icons/logout.gif"));
		return BrowerAction;
	}
	
	public Table makeTable(Composite shell){
		final Table table = new Table(shell, SWT.BORDER|SWT.CHECK);
		try{
			
		    table.setHeaderVisible(true);
		    table.setLinesVisible(true);
		    
		    TableColumn headerCoulumn1 = new TableColumn(table, SWT.CENTER);
		    TableColumn headerCoulumn2 = new TableColumn(table, SWT.CENTER);
		    TableColumn headerCoulumn3 = new TableColumn(table, SWT.CENTER);
		    TableColumn headerCoulumn4 = new TableColumn(table, SWT.CENTER);
		    TableColumn headerCoulumn5 = new TableColumn(table, SWT.CENTER);
		    TableColumn headerCoulumn6 = new TableColumn(table, SWT.CENTER);
		    headerCoulumn1.setText("단계");
		    headerCoulumn1.setWidth(100);
		    headerCoulumn2.setText("항목");
		    headerCoulumn2.setWidth(400);
		    headerCoulumn3.setText("모델 명");
		    headerCoulumn3.setWidth(200);
		    headerCoulumn4.setText("모델 등록 여부");
		    headerCoulumn4.setWidth(150);
		    headerCoulumn5.setText("모델 등록");
		    headerCoulumn5.setWidth(150);
	    
	    table.addListener(SWT.MeasureItem, new Listener() {
    	   public void handleEvent(Event event) {
    	      event.height = 25;
    	   }
    	});
	    
	    table.addListener(SWT.Selection, new Listener() {
	       public void handleEvent(Event event) {
	         if (event.detail == SWT.CHECK) {
	        	 TableItem eventItem = (TableItem)event.item;
	        	 if(eventItem.getChecked()){
	        		 Table table = eventItem.getParent();
	        		 for(int i=0; i<table.getItemCount(); i++){
	        			 TableItem item = table.getItem(i);
	        			 if(item.getChecked() && eventItem != item){
	        				 item.setChecked(false);
	        			 }
	        		 }
	        	 }
	         } 
	       }
	     });

	    table.addListener(SWT.MouseDown, new Listener() {
	    	public void handleEvent(Event event) {
	    		Point pt = new Point(event.x, event.y);
		        int index = table.getTopIndex();
		        MenuManager popupMenu = new MenuManager();
		        while (index < table.getItemCount()) {
		        	TableItem item = table.getItem(index);
		          
		        	for (int i = 0; i < 4; i++) {
		        		Rectangle rect = item.getBounds(i);
		        		if (rect.contains(pt)) {
		        			if(i == 1){
		        				IViewPart view_part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView("org.star.uml.designer.ui.views.StarPMSBrowersView");
		        				StarPMSBrowersView brower = (StarPMSBrowersView)view_part;
		        				brower.setURL("http://192.168.10.193:8080/starPMS/processMgt/requirementsInfoSimple.do?usecaseSeq=" + item.getData("seq"));
		        				try {
		        					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView("org.star.uml.designer.ui.views.StarPMSBrowersView");
		        				} catch (PartInitException e) {
		        					e.printStackTrace();
		        				}
		        				return;
		        			}
		        		}
		        	}
		        	index++;
		        }
	    	}
	    });
	    
		}catch(Exception e){
			e.printStackTrace();
		}
		return table;
	}

	public void addButtonListener(Button button){
		button.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent event) {
				Button srcBtuuton = (Button)event.getSource();
	        
				IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				if(page.getActiveEditor() !=null && page.getActiveEditor() instanceof org.eclipse.uml2.diagram.usecase.part.UMLDiagramEditor){
					org.eclipse.uml2.diagram.usecase.part.UMLDiagramEditor editor = 
						(org.eclipse.uml2.diagram.usecase.part.UMLDiagramEditor)page.getActiveEditor();
					DiagramEditPart diagramEditPart = editor.getDiagramEditPart();
					
					EditPart focusEdit = diagramEditPart.getViewer().getFocusEditPart();
					org.eclipse.draw2d.geometry.Point point = null;
	        	if(focusEdit instanceof UseCaseEditPart){
	        		final MultiStatus status = new MultiStatus(DiagramUIRenderPlugin
	        				.getPluginId(), DiagramUIRenderStatusCodes.OK,
	        				DiagramUIRenderMessages.CopyToImageAction_Label, null);
	            	IRunnableWithProgress runnable = EclipseUtile.createImageRunnable(status);
	            	try {
	            		ProgressMonitorDialog progressMonitorDialog = new ProgressMonitorDialog(
	            				Display.getCurrent().getActiveShell());
	            		progressMonitorDialog.run(false, true, runnable);
	            		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView("org.star.uml.designer.ui.views.StarPMSRequestTableView");
	        		} catch (Exception e) {
	        			e.printStackTrace();
	        		}
	        		
	        		UseCaseEditPart useCaseEditPart = (UseCaseEditPart)focusEdit;
	        		org.eclipse.gmf.runtime.notation.impl.ShapeImpl shape = (org.eclipse.gmf.runtime.notation.impl.ShapeImpl)useCaseEditPart.getModel();
	        		org.eclipse.uml2.uml.internal.impl.UseCaseImpl useCase = (org.eclipse.uml2.uml.internal.impl.UseCaseImpl)shape.basicGetElement();
	        		
	        		TableItem srcTableItem = (TableItem)srcBtuuton.getData("row");
					PmsDao pd = new PmsDao();
					Map inputData = new HashMap();
					String folderPaht = ResourcesPlugin.getWorkspace().getRoot().getProject("Root").getLocation().toString();
					File img = new File(folderPaht + "/default.png");
					inputData.put("img", img);
					inputData.put("seq", srcTableItem.getData("seq").toString());
					inputData.put("name", useCase.getName());
					try{
						pd.projectUpdate(inputData);
					}catch(Exception e){
						e.printStackTrace();
					}
			        srcTableItem.setText(2, useCase.getName());
			        srcTableItem.setText(3, "등록");
	        	}
	        	
	        }
	      }
	      public void widgetDefaultSelected(SelectionEvent event) {
	    	  System.out.println("No widgetDefaultSelected!");
	      }
	    });
	}
	
	public Table getTable(){
		return table;
	}
	
	@Override
	public void setFocus() {}

}
