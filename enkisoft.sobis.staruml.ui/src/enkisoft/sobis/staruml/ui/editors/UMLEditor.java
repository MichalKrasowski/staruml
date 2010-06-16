package enkisoft.sobis.staruml.ui.editors;

import java.io.StringWriter;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

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
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.*;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.MultiPageEditorPart;
import org.eclipse.ui.ide.IDE;

import enkisoft.sobis.staruml.awt.DiagramControlAWT;
import enkisoft.sobis.staruml.awt.ImageManagerAWT;
import enkisoft.sobis.staruml.core.Const;
import enkisoft.sobis.staruml.core.DiagramControl;
import enkisoft.sobis.staruml.core.DiagramView;
import enkisoft.sobis.staruml.core.EdgeView;
import enkisoft.sobis.staruml.core.NodeView;
import enkisoft.sobis.staruml.core.View;
import enkisoft.sobis.staruml.graphics.Canvas;
import enkisoft.sobis.staruml.graphics.GridFactor;
import enkisoft.sobis.staruml.graphics.ImageManager;
import enkisoft.sobis.staruml.graphics.Points;
import enkisoft.sobis.staruml.graphics.ZoomFactor;
import enkisoft.sobis.staruml.handler.SelectHandler;
import enkisoft.sobis.staruml.handler.SelectHandlerListener;
import enkisoft.sobis.staruml.uml.UMLIconLoader;
import enkisoft.sobis.staruml.views.UMLClassView;
import enkisoft.sobis.staruml.swt.DiagramControlSWT;

/**
 * An example showing how to create a multi-page editor.
 * This example has 3 pages:
 * <ul>
 * <li>page 0 contains a nested text editor.
 * <li>page 1 allows you to change the font used in page 2
 * <li>page 2 shows the words in page 0 in sorted order
 * </ul>
 */
public class UMLEditor extends MultiPageEditorPart implements IResourceChangeListener , SelectHandlerListener{

	private DiagramView diagramView;
	private DiagramControl editor;
	private ImageManager imageManager;
	

	public UMLEditor() {
		super();
		ResourcesPlugin.getWorkspace().addResourceChangeListener(this);
	}
	
	void createPage0() {
		NodeView nodeView1 = new NodeView();
		nodeView1.initialize(null, 20, 20, 120, 120);
		//nodeView1.setSelected(true);

		NodeView nodeView2 = new NodeView();
		nodeView2.initialize(null, 110, 200, 210, 300);
		//nodeView2.setSelected(true);
		
		UMLClassView nodeView3 = new UMLClassView();
		nodeView3.initialize(null, 210, 20, 310, 120);
		//nodeView2.setSelected(true);

		EdgeView edgeView1 = new EdgeView();
		edgeView1.setTail(nodeView1);
		edgeView1.setHead(nodeView2);
		edgeView1.setHeadEndStyle(Const.ES_ARROW_DIAMOND);
		edgeView1.setTailEndStyle(Const.ES_ARROW_FILLED_DIAMOND);
		edgeView1.setLineStyle(Const.LS_RECTILINEAR);
		// edgeView1.setLineColor(Color.LIGHT_GRAY);
		edgeView1.initialize(null, 30, 30, 210, 210);

		EdgeView edgeView2 = new EdgeView();
		edgeView2.setTail(nodeView2);
		edgeView2.setHead(nodeView3);
		edgeView2.setHeadEndStyle(Const.ES_FLAT);
		edgeView2.setTailEndStyle(Const.ES_TRIANGLE);
		edgeView2.setLineStyle(Const.LS_OBLIQUE);
		// edgeView1.setLineColor(Color.LIGHT_GRAY);
		edgeView2.initialize(null, 30, 30, 210, 210);
		
		diagramView = new DiagramView();
		diagramView.addOwnedView(nodeView1);
		diagramView.addOwnedView(nodeView2);
		diagramView.addOwnedView(nodeView3);
		diagramView.addOwnedView(edgeView1);
		diagramView.addOwnedView(edgeView2);

		SelectHandler handler = new SelectHandler();
		handler.setSelectHandlerListener(this);
		
	    ScrolledComposite composite = new ScrolledComposite(
	    		getContainer(), SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		
		editor = new DiagramControlSWT(composite, SWT.NONE);
		editor.setDiagramView(diagramView);
		editor.getCanvas().setGridFactor(new GridFactor(4, 4));
		editor.getCanvas().setZoomFactor(new ZoomFactor(2, 2));
		editor.getCanvas().setAntialias(Canvas.AS_ON);
		editor.getCanvas().setTextAntialias(Canvas.AS_ON);
		editor.setHandler(handler);
		editor.setSize(2000, 2000);
		editor.repaint();

		composite.setContent((DiagramControlSWT) editor);
		int index = addPage(composite);
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

	public void changeViewContainer(View view, int dx, int dy,
			View containerView) {
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

	public void viewDoubleClicked(View view) {
		System.out.println("View double clicked : " + view);
	}

	public void modifyEdge(EdgeView edge, Points points) {
		edge.getPoints().assign(points);
		editor.repaint();
	}

	public void reconnectEdge(EdgeView edge, Points points,
			View newParticipant, boolean isTailSide) {
		// TODO Auto-generated method stub
		
	}
}
