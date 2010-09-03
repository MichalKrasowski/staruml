package co.staruml.ui.editors;


import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.io.StringWriter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FontDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.ui.*;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.MultiPageEditorPart;
import org.eclipse.ui.ide.IDE;

import co.staruml.awt.DiagramControlAWT;
import co.staruml.awt.ImageManagerAWT;
import co.staruml.core.Const;
import co.staruml.core.DiagramControl;
import co.staruml.core.DiagramView;
import co.staruml.core.EdgeView;
import co.staruml.core.NodeView;
import co.staruml.core.View;
import co.staruml.graphics.Canvas;
import co.staruml.graphics.GridFactor;
import co.staruml.graphics.ImageManager;
import co.staruml.graphics.Points;
import co.staruml.graphics.ZoomFactor;
import co.staruml.handler.CreatetHandler;
import co.staruml.handler.MouseEvent;
import co.staruml.handler.SelectHandler;
import co.staruml.handler.SelectHandlerListener;
import co.staruml.swt.DiagramControlSWT;
import co.staruml.uml.UMLIconLoader;
import co.staruml.util.SWTResourceManager;
import co.staruml.views.UMLClassView;
import co.staruml.handler.Handler;


/**
 * An example showing how to create a multi-page editor.
 * This example has 3 pages:
 * <ul>
 * <li>page 0 contains a nested text editor.
 * <li>page 1 allows you to change the font used in page 2
 * <li>page 2 shows the words in page 0 in sorted order
 * </ul>
 */
public class UMLEditor extends MultiPageEditorPart implements IResourceChangeListener, SelectHandlerListener{

	private DiagramView diagramView;
	private DiagramControlSWT editor;
	private ImageManager imageManager;
	private ScrolledComposite rightComposite;
	private Composite leftComposite;
	private HashMap<String,Handler> handerMap;

	public UMLEditor() {
		super();
		ResourcesPlugin.getWorkspace().addResourceChangeListener(this);
	}
	
	void createPage0() {
		// 2-column layout configuration left : palate , right : canvas
		GridLayout mainGridLayout = new GridLayout(3, false);
		Composite mainComposite = new Composite(this.getContainer(),SWT.NORMAL);
		mainComposite.setLayout(mainGridLayout);
		leftComposite = new Composite(mainComposite, SWT.BORDER);
		rightComposite = new ScrolledComposite(mainComposite, SWT.BORDER |SWT.H_SCROLL | SWT.V_SCROLL);
		handerMap = new HashMap<String,Handler>();
		// Creates an object that implements the Canvas to draw a diagram
		editor = new DiagramControlSWT(rightComposite, SWT.NONE , handerMap);
		
		// Handler Setting
		SelectHandler selectHandler = new SelectHandler();
		selectHandler.setSelectHandlerListener(this);
		selectHandler.setRightComposite(rightComposite);
		selectHandler.setDiagramControlSWT(editor);
		CreatetHandler createHandler = new CreatetHandler();
		// HandlerMap Setting
		handerMap.put("selectHandler", selectHandler);
		handerMap.put("createHandler", createHandler);
		
		/*************************************************************************
		 *                           Start left layout                           *
		 *************************************************************************/
		// Left Palette layout configuration 
		leftComposite.setBackground(SWTResourceManager.getColor((SWT.COLOR_GRAY)));
		GridData leftGridData = new GridData(SWT.LEFT, SWT.TOP, false, true, 1, 1);
		//Set size
		leftGridData.widthHint = 130;
		leftGridData.heightHint = 568;
		leftComposite.setLayoutData(leftGridData);
		//Set Left Title
		Label lblToolbox = new Label(leftComposite, SWT.HORIZONTAL | SWT.CENTER);
		lblToolbox.setFont(SWTResourceManager.getFont("맑은 고딕", 10, SWT.BOLD));
		lblToolbox.setAlignment(SWT.CENTER);
		lblToolbox.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		lblToolbox.setBounds(0, 0, 130, 15);
		lblToolbox.setText("Toolbox");
		//Set ToolBar
		ToolBar leftToolBar = new ToolBar(leftComposite, SWT.FLAT | SWT.LEFT | SWT.VERTICAL);
		leftToolBar.setFont(SWTResourceManager.getFont("맑은 고딕", 9, SWT.BOLD));
		leftToolBar.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		leftToolBar.setBounds(0, 21, 130, 500);
		// Seperator
		SWTCompositeUtil.addSeperator(leftToolBar, 0, 0, 130, 2);
		// Set Annoation DropDown item
		ToolItem annoationDroupDown = SWTCompositeUtil.addToolItem(leftToolBar,"Annoation             ",SWT.PUSH);
		// Add Annoation DropDown Listener
		SWTCompositeUtil.addSelectListener(annoationDroupDown,leftToolBar,editor,handerMap);
		// Seperator
		SWTCompositeUtil.addSeperator(leftToolBar,0, 29, 130, 2);
		// Set Class DropDown item
	    ToolItem classDroupDown = SWTCompositeUtil.addToolItem(leftToolBar,"Class Diagram       ",SWT.PUSH);
		// Add Class DropDown Listener
	    SWTCompositeUtil.addSelectListener(classDroupDown,leftToolBar,editor,handerMap);
		// Seperator
	    SWTCompositeUtil.addSeperator(leftToolBar,0, 60, 130, 2);
	    // Temp use for SWT.PUSH height bug
	    ToolItem temp = SWTCompositeUtil.addToolItem(leftToolBar,"Temp                  ",SWT.DROP_DOWN);
	    temp.dispose();
		
		/*************************************************************************
		 *                           Start right layout                          *
		 *************************************************************************/
	   
		GridData rightGridData = new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1);
		rightComposite.setLayoutData(rightGridData);
	    rightComposite.setFont(SWTResourceManager.getFont("맑은 고딕", 8, SWT.NORMAL));
//	    Set size
		rightGridData.widthHint = 955;
		rightGridData.heightHint = 557;	    
//		
		diagramView = new DiagramView();
//		Add a view
		editor.setDiagramView(diagramView);
		editor.getCanvas().setGridFactor(new GridFactor(4, 4));
		editor.getCanvas().setZoomFactor(new ZoomFactor(2, 2));
		editor.getCanvas().setAntialias(Canvas.AS_ON);
		editor.getCanvas().setTextAntialias(Canvas.AS_ON);
		editor.setHandler(selectHandler);
		editor.setSize(3000, 3000);
		editor.repaint();
		rightComposite.setContent(editor);
		
		/*************************************************************************
		 *                           End right layout                            *
		 *************************************************************************/
		
		int index = addPage(mainComposite);
		setPageText(index, "diagram");
	}
	
	protected void createPages() {
		createPage0();
	}
	
	public void dispose() {
		ResourcesPlugin.getWorkspace().removeResourceChangeListener(this);
		super.dispose();
	}
	
	public void doSave(IProgressMonitor monitor) {
		getEditor(0).doSave(monitor);
	}
	
	public void doSaveAs() {
		IEditorPart editor = getEditor(0);
		editor.doSaveAs();
		setPageText(0, editor.getTitle());
		setInput(editor.getEditorInput());
	}
	
	public void init(IEditorSite site, IEditorInput editorInput)
		throws PartInitException {
		if (!(editorInput instanceof IFileEditorInput))
			throw new PartInitException("Invalid Input: Must be IFileEditorInput");
		super.init(site, editorInput);
	}
	
	public boolean isSaveAsAllowed() {
		return true;
	}
	
	public void resourceChanged(final IResourceChangeEvent event){
	}
	
	public void selectArea(int x1, int y1, int x2, int y2) {
		
		diagramView.deselectAll();
		diagramView.selectArea(editor.getCanvas(), x1, y1, x2, y2);
		editor.repaint();
	}

	public void deselectView(View view) {
	}

	public void changeSelectedViewsContainer(int dx, int dy, View containerView) {
	}

	public void changeViewContainer(View view, int dx, int dy,View containerView) {
	}

	public void moveSelectedViews(int dx, int dy) {
		for (View v : diagramView.getSelectedViews()) {
			v.move(editor.getCanvas(), dx, dy);
		}
		editor.repaint();
	}

	public void moveView(View view, int dx, int dy) {
		view.move(editor.getCanvas(), dx, dy);
		editor.repaint();
	}

	public void selectAdditionalView(View view) {
		view.setSelected(true);
		editor.repaint();
	}

	public void selectView(View view) {
		diagramView.deselectAll();
		view.setSelected(true);
		editor.repaint();
	}

	public void resizeNode(NodeView node, int left, int top, int right, int bottom) {
		node.setLeft(left);
		node.setTop(top);
		node.setRight(right);
		node.setBottom(bottom);
		editor.repaint();
	}

	public void viewDoubleClicked(DiagramControl diagramControl, Canvas canvas, View view, MouseEvent e) {
		if(view != null){
			if(view instanceof UMLClassView){
				int area = SWTCompositeUtil.getSelcetedViewArea(canvas, view, e);
				switch(area){
					case UMLClassView.CLASS_NAME_AREA:
//						SWTCompositeUtil.drawTextArea(rightComposite,diagramControl,canvas,view,e);
						System.out.println("CLASS_NAME_AREA ");
					break;
					case UMLClassView.CLASS_ATTRIBUTE_AREA:
						System.out.println("CLASS_ATTRIBUTE_AREA ");
					break;
					case UMLClassView.CLASS_OPERATION_AREA:
						System.out.println("CLASS_OPERATION_AREA ");
					break;
					default:
						System.out.println("default ");
				}
			}else if(view instanceof EdgeView){
				System.out.println("EdgeView : "+view);
			}
		}
	}

	public void modifyEdge(EdgeView edge, Points points) {
		edge.getPoints().assign(points);
		editor.repaint();
	}

	public void reconnectEdge(EdgeView edge, Points points,View newParticipant, boolean isTailSide) {
		edge.setLineStyle(Const.LS_RECTILINEAR);
		if(isTailSide){
			edge.setTail(newParticipant);
		}else{
			edge.setHead(newParticipant);
		}
		editor.repaint();
	}
	
}
