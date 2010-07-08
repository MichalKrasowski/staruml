package co.staruml.ui.editors;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

import co.staruml.core.DiagramControl;

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
	public static void addSelectListener(ToolItem dropdown,ToolBar leftToolBar,DiagramControl editor){
		DropdownSelectionListener listener = new DropdownSelectionListener(dropdown,leftToolBar,editor);
		dropdown.addSelectionListener(listener);
	}
}
