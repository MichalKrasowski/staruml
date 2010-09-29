package org.staruml.views;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDiagramDocument;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.impl.DiagramImpl;
import org.eclipse.gmf.runtime.notation.impl.ShapeImpl;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.TableCursor;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.custom.TableTree;
import org.eclipse.swt.custom.TableTreeItem;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.UseCaseEditPart;
import org.eclipse.uml2.diagram.usecase.navigator.UMLNavigatorItem;
import org.eclipse.uml2.uml.internal.impl.PackageImpl;

import org_.staruml.Activator;

public class StarPMSRequestTableView extends ViewPart {

	public static final String ID = "org.staruml.views.StarPMSRequestTableView";

	public StarPMSRequestTableView() {
	}

	public void createPartControl(Composite shell) {
		shell.setLayout(new FillLayout());
		final Table table = makeTable(shell);
	}
	
	public static Action makeBrowerAction(){
		Action BrowerAction = new Action() {
			public void run() {
				System.out.println("1111111111111");
			}
		};
		BrowerAction.setText("상세보기");
		BrowerAction.setToolTipText("상세보기 tooltip");
		BrowerAction.setImageDescriptor(Activator.getImageDescriptor("/icons/logout.gif"));
		return BrowerAction;
	}
	
	public Table makeTable(Composite shell){
		final Table table = new Table(shell, SWT.BORDER);
	    table.setHeaderVisible(true);
	    table.setLinesVisible(true);
	    
	    TableColumn coulumn1 = new TableColumn(table, SWT.CENTER);
	    TableColumn coulumn2 = new TableColumn(table, SWT.CENTER);
	    TableColumn coulumn3 = new TableColumn(table, SWT.CENTER);
	    TableColumn coulumn4 = new TableColumn(table, SWT.CENTER);
	    TableColumn coulumn5 = new TableColumn(table, SWT.CENTER);
	    coulumn1.setText("단계");
	    coulumn1.setWidth(100);
	    coulumn2.setText("항목");
	    coulumn2.setWidth(400);
	    coulumn3.setText("모델 명");
	    coulumn3.setWidth(200);
	    coulumn4.setText("모델 등록 여부");
	    coulumn4.setWidth(150);
	    coulumn5.setText("등록 ");
	    coulumn5.setWidth(150);
        
	    TableItem row1 = new TableItem(table, SWT.NONE);
	    TableEditor editor1 = new TableEditor(table);
	    Button button1 = new Button(table, SWT.PUSH);
	    button1.setText("다이어그램 등록");
	    button1.setData("row", row1);
	    addButtonListener(button1);
	    editor1.grabHorizontal = true;
	    editor1.setEditor(button1, row1, 4);
	    row1.setText(0, "요구사항");
	    row1.setText(1, "사용자 인증을 한다.");
	    row1.setText(2, "미등록");
	    row1.setText(3, "미등록");
	    row1.setData("id", "1");
	    
	    TableItem row2 = new TableItem(table, SWT.NONE);
	    editor1 = new TableEditor(table);
	    Button button2 = new Button(table, SWT.PUSH);
	    button2.setText("다이어그램 등록");
	    editor1.grabHorizontal = true;
	    editor1.setEditor(button2, row2, 4);
	    row2.setText(0, "요구사항");
	    row2.setText(1, "회의실을 예약한다.");
	    row2.setText(2, "미등록");
	    row2.setText(3, "미등록");
	    row2.setData("id", "2");
	    
        TableItem row3 = new TableItem(table, SWT.NONE);
        editor1 = new TableEditor(table);
	    Button button3 = new Button(table, SWT.PUSH);
	    button3.setText("다이어그램 등록");
	    editor1.grabHorizontal = true;
	    editor1.setEditor(button3, row3, 4);
        row3.setText(0, "요구사항");
        row3.setText(1, "회의실 예약을 조회한다.");
        row3.setText(2, "미등록");
        row3.setText(3, "미등록");
        row3.setData("id", "3");
        
        TableItem row4 = new TableItem(table, SWT.NONE);
        editor1 = new TableEditor(table);
	    Button button4 = new Button(table, SWT.PUSH);
	    button4.setText("다이어그램 등록");
	    editor1.grabHorizontal = true;
	    editor1.setEditor(button4, row4, 4);
        row4.setText(0, "요구사항");
        row4.setText(1, "회의실 예약을 취소한다.");
        row4.setText(2, "미등록");
        row4.setText(3, "미등록");
        row4.setData("id", "4");
        
        TableItem row5 = new TableItem(table, SWT.NONE);
        editor1 = new TableEditor(table);
	    Button button5 = new Button(table, SWT.PUSH);
	    button5.setText("다이어그램 등록");
	    editor1.grabHorizontal = true;
	    editor1.setEditor(button5, row5, 4);
        row5.setText(0, "요구사항");
        row5.setText(1, "회의실 예약 요청을 처리한다.");
        row5.setText(2, "미등록");
        row5.setText(3, "미등록");
        row5.setData("id", "5");
        
        TableItem row6 = new TableItem(table, SWT.NONE);
        editor1 = new TableEditor(table);
	    Button button6 = new Button(table, SWT.PUSH);
	    button6.setText("다이어그램 등록");
	    editor1.grabHorizontal = true;
	    editor1.setEditor(button6, row6, 4);
        row6.setText(0, "요구사항");
        row6.setText(1, "회의실 정보를 관리한다.");
        row6.setText(2, "미등록");
        row6.setText(3, "미등록");
        row6.setData("id", "6");
        
        TableItem row7 = new TableItem(table, SWT.NONE);
        editor1 = new TableEditor(table);
	    Button button7 = new Button(table, SWT.PUSH);
	    button6.setText("다이어그램 등록");
	    editor1.grabHorizontal = true;
	    editor1.setEditor(button7, row7, 4);
        row7.setText(0, "요구사항");
        row7.setText(1, "시점비교조회 기준");
        row7.setText(2, "미등록");
        row7.setText(3, "미등록");
        row7.setData("id", "7");
        
        TableItem row8 = new TableItem(table, SWT.NONE);
        editor1 = new TableEditor(table);
	    Button button8 = new Button(table, SWT.PUSH);
	    button8.setText("다이어그램 등록");
	    editor1.grabHorizontal = true;
	    editor1.setEditor(button8, row8, 4);
        row8.setText(0, "요구사항");
        row8.setText(1, "이상발생 시 알림 기능");
        row8.setText(2, "미등록");
        row8.setText(3, "미등록");
        row8.setData("id", "8");
        
	    TableItem row9 = new TableItem(table, SWT.NONE);
	    editor1 = new TableEditor(table);
	    Button button9 = new Button(table, SWT.PUSH);
	    button9.setText("다이어그램 등록");
	    editor1.grabHorizontal = true;
	    editor1.setEditor(button9, row9, 4);
	    row9.setText(0, "요구사항 분석");
	    row9.setText(1, "목표입력 권한");
	    row9.setText(2, "");
	    row9.setText(3, "미등록");
	    row9.setData("id", "9");
        
        TableItem row10 = new TableItem(table, SWT.NONE);
        editor1 = new TableEditor(table);
	    Button button10 = new Button(table, SWT.PUSH);
	    button10.setText("다이어그램 등록");
	    editor1.grabHorizontal = true;
	    editor1.setEditor(button10, row10, 4);
        row10.setText(0, "요구사항 분석");
        row10.setText(1, "목표입력 시점");
        row10.setText(2, "");
        row10.setText(3, "미등록");
        row10.setData("id", "10");
        
        TableItem row11 = new TableItem(table, SWT.NONE);
        editor1 = new TableEditor(table);
	    Button button11 = new Button(table, SWT.PUSH);
	    button11.setText("다이어그램 등록");
	    editor1.grabHorizontal = true;
	    editor1.setEditor(button11, row11, 4);
        row11.setText(0, "요구사항 분석");
        row11.setText(1, "실적조회 사용대상");
        row11.setText(2, "");
        row11.setText(3, "미등록");
        row11.setData("id", "11");
        
        TableItem row12 = new TableItem(table, SWT.NONE);
        editor1 = new TableEditor(table);
	    Button button12 = new Button(table, SWT.PUSH);
	    button12.setText("다이어그램 등록");
	    editor1.grabHorizontal = true;
	    editor1.setEditor(button12, row12, 4);
        row12.setText(0, "요구사항 분석");
        row12.setText(1, "과거실적 반영");
        row12.setText(2, "");
        row12.setText(3, "미등록");
        row12.setData("id", "12");
        
        TableItem row13 = new TableItem(table, SWT.NONE);
        editor1 = new TableEditor(table);
	    Button button13 = new Button(table, SWT.PUSH);
	    button13.setText("다이어그램 등록");
	    editor1.grabHorizontal = true;
	    editor1.setEditor(button13, row13, 4);
        row13.setText(0, "요구사항 분석");
        row13.setText(1, "정형장표 제공");
        row13.setText(2, "");
        row13.setText(3, "미등록");
        row13.setData("id", "13");
        
        TableItem row14 = new TableItem(table, SWT.NONE);
        editor1 = new TableEditor(table);
	    Button button14 = new Button(table, SWT.PUSH);
	    button14.setText("다이어그램 등록");
	    editor1.grabHorizontal = true;
	    editor1.setEditor(button14, row14, 4);
        row14.setText(0, "요구사항 분석");
        row14.setText(1, "시점비교조회 기준");
        row14.setText(2, "");
        row14.setText(3, "미등록");
        row14.setData("id", "14");
        
        TableItem row15 = new TableItem(table, SWT.NONE);
        Button button15 = new Button(table, SWT.PUSH);
        button15.setText("다이어그램 등록");
	    editor1.grabHorizontal = true;
	    editor1.setEditor(button15, row15, 4);
        row15.setText(0, "요구사항 분석");
        row15.setText(1, "이상발생 시 알림 기능");
        row15.setText(2, "");
        row15.setText(3, "미등록");
        row15.setData("id", "15");
        
//	    TableColumn[] columns = table.getColumns();
//	    for (int i = 0, n = columns.length; i < n; i++) {
//	      columns[i].pack();
//	    }
	    
	    table.addListener(SWT.MeasureItem, new Listener() {
    	   public void handleEvent(Event event) {
    	      event.height = 25;
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
		            		System.out.println("Item " + index + "-" + i);
				            System.out.println(item.getData("id"));
				            IViewPart view_part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView("org.staruml.views.StarPMSBrowersView");
				            StarPMSBrowersView brower = (StarPMSBrowersView)view_part;
				            brower.setURL("http://192.168.10.193:8080/starPMS/processMgt/requirementsInfoSimple.do");
				            try {
								PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView("org.staruml.views.StarPMSBrowersView");
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
	    
	    return table;
	}

	public void addButtonListener(Button button){
		button.addSelectionListener(new SelectionListener() {
	      public void widgetSelected(SelectionEvent event) {
	        Button srcBtuuton = (Button)event.getSource();
	        TableItem srcTableItem = (TableItem)srcBtuuton.getData("row");
	        srcTableItem.setText(2, "사용자 인증을 한다.");
	        srcTableItem.setText(3, "등록");
	        IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
	        if(page.getActiveEditor() !=null && page.getActiveEditor() instanceof org.eclipse.uml2.diagram.usecase.part.UMLDiagramEditor){
	        	org.eclipse.uml2.diagram.usecase.part.UMLDiagramEditor editor = 
	        		(org.eclipse.uml2.diagram.usecase.part.UMLDiagramEditor)page.getActiveEditor();
	        	DiagramEditPart diagramEditPart = editor.getDiagramEditPart();
	        	EditPart focusEdit = diagramEditPart.getViewer().getFocusEditPart();
	        	org.eclipse.draw2d.geometry.Point point = null;
	        	if(focusEdit instanceof UseCaseEditPart){
	        		UseCaseEditPart useCaseEditPart = (UseCaseEditPart)focusEdit;
	        		point = useCaseEditPart.getLocation();
	        	}
	        	IDiagramDocument document = editor.getDiagramDocument();
	        	if (document != null) {
	        		Diagram diagram = document.getDiagram();
		    		IFile file = WorkspaceSynchronizer.getFile(diagram.eResource());
		    		if (file != null) {
		    			UMLNavigatorItem item = new UMLNavigatorItem(diagram, file, false);
		    			StructuredSelection selection =  new StructuredSelection(item);
		    			DiagramImpl diagramImpleImple = (DiagramImpl)item.getView();
		    			PackageImpl packageImple = (PackageImpl) diagramImpleImple.getElement();
//		    			System.out.println("selection.getFirstElement() : "+selection.getFirstElement());
//		    			System.out.println("item : "+item);
//		    			System.out.println("item.getView() : "+item.getView());
//		    			System.out.println("diagramImpleImple.getName() : "+diagramImpleImple.getName());
//		    			System.out.println("diagramImpleImple.getType() : "+diagramImpleImple.getType());
//		    			System.out.println("diagramImpleImple.getElement() : "+diagramImpleImple.getElement());
//		    			System.out.println("packageImple.getMembers() : "+packageImple.getMembers());
//		    			System.out.println("packageImple.getMembers() : "+packageImple.getMember("회의실을 예약한다."));
		    			List list = packageImple.getMembers();
		    			for(int i=0; i<list.size(); i++){
		    				if(list.get(i) instanceof org.eclipse.uml2.uml.internal.impl.UseCaseImpl){
		    					org.eclipse.uml2.uml.internal.impl.UseCaseImpl useCase = 
		    						(org.eclipse.uml2.uml.internal.impl.UseCaseImpl)list.get(i);
		    					System.out.println("useCase.getModel() : "+useCase.getMembers().size());
		    				}
		        			System.out.println(i+" : "+list.get(i));
		        		}
		    		}
	    		}
	        }
	      }
	      public void widgetDefaultSelected(SelectionEvent event) {
	    	  System.out.println("No widgetDefaultSelected!");
	      }
	    });
	}
	
	@Override
	public void setFocus() {}
	
}