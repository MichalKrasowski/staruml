package co.staruml.ui.editors;

import java.util.HashMap;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

import co.staruml.core.DiagramControl;
import co.staruml.core.View;
import co.staruml.graphics.Canvas;
import co.staruml.graphics.Point;
import co.staruml.graphics.Rect;
import co.staruml.handler.Handler;
import co.staruml.handler.MouseEvent;
import co.staruml.swt.DiagramControlSWT;
import co.staruml.views.UMLClassView;

public class SWTCompositeUtil {
	
	/*
	 * Add seperator to ToolBar
	 */
	public static void addSeperator(Composite parent,int x,int y,int width,int height){
		Label label = new Label(parent, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setBounds(x,y,width,height);
	}
	
	/*
	 * Add toolItem to ToolBar
	 */
	public static ToolItem addToolItem(ToolBar parent,String name,int option){
		ToolItem toolItem = new ToolItem(parent, option);
		toolItem.setText(name);
		return toolItem;
	}
	
	/*
	 * Add listener to ToolItem
	 */
	public static void addSelectListener(ToolItem dropdown,ToolBar leftToolBar,DiagramControl editor,HashMap<String,Handler> handerMap){
		TooboxSelectionListener listener = new TooboxSelectionListener(dropdown,leftToolBar,editor,handerMap);
		dropdown.addSelectionListener(listener);
	}
	
	/*
	 * Check area 
	 */
	public static int getSelcetedViewArea(Canvas canvas, View view, MouseEvent e){
		// Check the entire area
		Rect holeRect = view.getBoundingBox(canvas);
		UMLClassView classView = (UMLClassView)view;
		// Check the name area
		Point namePt = classView.getClassAreaPoint(canvas);
		Rect nameRect = new Rect(holeRect.getX1(),holeRect.getY1(),holeRect.getX2(),holeRect.getY1()+namePt.getY());
		// Check whether it belongs to the name rect.
		if(nameRect.isContain(e.getX(), e.getY())){
			return UMLClassView.CLASS_NAME_AREA;
		}
		// Check the attribute area
		int attribute_x1 = holeRect.getX1();
		int attribute_y1 = holeRect.getY1()+namePt.getY();
		int attribute_x2 = holeRect.getX2();
		int attribute_y2 = holeRect.getY1()+namePt.getY()+classView.getAttributereaHeight(canvas);
		Rect attributeRect = new Rect(attribute_x1,attribute_y1,attribute_x2,attribute_y2);
		// Check whether it belongs to the name rect.
		if(attributeRect.isContain(e.getX(), e.getY())){
			return UMLClassView.CLASS_ATTRIBUTE_AREA;
		}
		// other is operation area
		return UMLClassView.CLASS_OPERATION_AREA;
	}
	
	/*
	 * Draw textArea
	 */
	
	public static void canvasPop(DiagramControlSWT editor,ScrolledComposite rightComposite,DiagramControl diagramControl, Canvas canvas, View view, MouseEvent e){
		System.out.println("diagramControl : "+diagramControl);
		System.out.println("canvas : "+canvas);
		System.out.println("view : "+view);
		System.out.println("e : "+e);
		Shell shell = rightComposite.getShell();
		Menu menu = new Menu (editor);
		MenuItem item1 = new MenuItem (menu, SWT.PUSH);
		item1.setText ("Push Item");
		MenuItem item2 = new MenuItem (menu, SWT.CASCADE);
		item2.setText ("Cascade Item");
		Menu subMenu = new Menu (menu);
		item2.setMenu (subMenu);
		MenuItem subItem1 = new MenuItem (subMenu, SWT.PUSH);
		subItem1.setText ("Subitem 1");
		MenuItem subItem2 = new MenuItem (subMenu, SWT.PUSH);
		subItem2.setText ("Subitem 2");
		editor.setMenu (menu);
		shell.setMenu (menu);
	}
}
