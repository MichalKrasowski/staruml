package co.staruml.ui.editors;


import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
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
import org.eclipse.swt.widgets.Shell;
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
import co.staruml.handler.SelectHandler;
import co.staruml.handler.SelectHandlerListener;
import co.staruml.swt.DiagramControlSWT;
import co.staruml.uml.UMLIconLoader;
import co.staruml.views.UMLClassView;


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
	private DiagramControl editor;
	private ImageManager imageManager;
	private ScrolledComposite composite;
	

	public UMLEditor() {
		super();
		ResourcesPlugin.getWorkspace().addResourceChangeListener(this);
	}
	
	void createPage0() {

	
		UMLClassView nodeView3 = new UMLClassView();
		nodeView3.initialize(null, 210, 20, 310, 120);
//		nodeView3.setSelected(true);

		diagramView = new DiagramView();
		diagramView.addOwnedView(nodeView3);

		SelectHandler handler = new SelectHandler();
		handler.setSelectHandlerListener(this);
		
		composite = new ScrolledComposite(
	    		this.getContainer(), SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		
		editor = new DiagramControlSWT(composite, SWT.NONE);
		editor.setDiagramView(diagramView);
		editor.getCanvas().setGridFactor(new GridFactor(4, 4));
		editor.getCanvas().setZoomFactor(new ZoomFactor(2, 2));
		editor.getCanvas().setAntialias(Canvas.AS_ON);
		editor.getCanvas().setTextAntialias(Canvas.AS_ON);
		editor.setHandler(handler);
		editor.setSize(1215, 684);
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
		System.out.println("resourceChanged");
	}
	
	public void selectArea(int x1, int y1, int x2, int y2) {
		System.out.println("selectArea");
		
		diagramView.deselectAll();
		diagramView.selectArea(editor.getCanvas(), x1, y1, x2, y2);
		editor.repaint();
	}

	public void deselectView(View view) {
		System.out.println("deselectView");
	}

	public void changeSelectedViewsContainer(int dx, int dy, View containerView) {
		System.out.println("changeSelectedViewsContainer");
	}

	public void changeViewContainer(View view, int dx, int dy,View containerView) {
		System.out.println("changeViewContainer");
	}

	public void moveSelectedViews(int dx, int dy) {
		System.out.println("moveSelectedViews");
		for (View v : diagramView.getSelectedViews()) {
			v.move(editor.getCanvas(), dx, dy);
		}
		editor.repaint();
	}

	public void moveView(View view, int dx, int dy) {
		System.out.println("moveView");
		view.move(editor.getCanvas(), dx, dy);
		editor.repaint();
	}

	public void selectAdditionalView(View view) {
		System.out.println("selectAdditionalView");
		view.setSelected(true);
		editor.repaint();
	}

	public void selectView(View view) {
		System.out.println("selectView");
		diagramView.deselectAll();
		view.setSelected(true);
		editor.repaint();
	}

	public void resizeNode(NodeView node, int left, int top, int right, int bottom) {
		System.out.println("resizeNode");
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
		System.out.println("modifyEdge");
		edge.getPoints().assign(points);
		editor.repaint();
	}

	public void reconnectEdge(EdgeView edge, Points points,View newParticipant, boolean isTailSide) {
		System.out.println("modifyEdge");
	}
}
