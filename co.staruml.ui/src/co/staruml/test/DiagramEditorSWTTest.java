package co.staruml.test;

import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

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
import co.staruml.handler.Handler;
import co.staruml.handler.MouseEvent;
import co.staruml.handler.SelectHandler;
import co.staruml.handler.SelectHandlerListener;
import co.staruml.swt.*;
import co.staruml.uml.UMLIconLoader;
import co.staruml.views.UMLClassView;


public class DiagramEditorSWTTest implements SelectHandlerListener {
	
	private DiagramView diagramView;
	private DiagramControl editor;
	private ImageManager imageManager;
	
	public DiagramEditorSWTTest() {
	}
	
	public void test() {
		
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
		
	    /*Display display = new Display ();
	    Shell shell = new Shell (display);
	    shell.setLayout(new FillLayout());
	    ScrolledComposite sc = new ScrolledComposite(
	    		shell, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		
		editor = new DiagramControlSWT(sc, SWT.NONE);
		editor.setDiagramView(diagramView);
		editor.getCanvas().setGridFactor(new GridFactor(4, 4));
		editor.getCanvas().setZoomFactor(new ZoomFactor(2, 2));
		editor.getCanvas().setAntialias(Canvas.AS_ON);
		editor.getCanvas().setTextAntialias(Canvas.AS_ON);
		editor.setHandler(handler);
		editor.setSize(2000, 2000);
		editor.repaint();

	    sc.setContent((DiagramControlSWT) editor);
	    shell.setSize(800, 600);
	    shell.open ();
	    while (!shell.isDisposed ()) {
	        if (!display.readAndDispatch ()) display.sleep ();
	    }
	    display.dispose ();*/
		
		
		imageManager = new ImageManagerAWT();
		UMLIconLoader.loadIcons(imageManager);
		editor = new DiagramControlAWT(imageManager);
		editor.setDiagramView(diagramView);
		editor.getCanvas().setGridFactor(new GridFactor(4, 4));
		editor.getCanvas().setZoomFactor(new ZoomFactor(2, 2));
		editor.getCanvas().setAntialias(Canvas.AS_ON);
		editor.getCanvas().setTextAntialias(Canvas.AS_ON);
		editor.setHandler(handler);
		editor.setSize(2000, 2000);
		editor.repaint();
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		java.awt.Container container = frame.getContentPane();
		JPanel panel = new JPanel();
		
		panel.setLayout(new java.awt.BorderLayout());
		JScrollPane scroll = new JScrollPane(((DiagramControlAWT) editor));
		panel.add(scroll, java.awt.BorderLayout.CENTER);
		container.setLayout(new java.awt.BorderLayout());
		container.add(panel, java.awt.BorderLayout.NORTH);
		
		((DiagramControlAWT) editor).setPreferredSize(new java.awt.Dimension(1000, 1000));
		frame.setSize(800, 600);
		frame.setVisible(true);
		frame.repaint();
		editor.repaint();
	}

	
	public static void main(String[] args) {
		DiagramEditorSWTTest test = new DiagramEditorSWTTest();
		test.test();
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

	public void viewDoubleClicked(DiagramControl diagramControl, Canvas canvas, View view, MouseEvent e) {
		System.out.println("View double clicked : " + view);
	}

	public void modifyEdge(EdgeView edge, Points points) {
		edge.getPoints().assign(points);
		editor.repaint();
	}

	public void reconnectEdge(EdgeView edge, Points points,View newParticipant, boolean isTailSide) {
		
	}

}
