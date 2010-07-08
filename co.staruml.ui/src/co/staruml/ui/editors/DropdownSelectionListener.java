package co.staruml.ui.editors;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

import co.staruml.core.DiagramControl;

public class DropdownSelectionListener extends SelectionAdapter {
	  private ToolItem dropdown;
	  private ToolBar leftToolBar;
	  private DiagramControl editor;
	  private String secondWidget;
	  private String thirdWidget;

	  public DropdownSelectionListener(ToolItem dropdown,ToolBar leftToolBar,DiagramControl editor) {
	    this.dropdown = dropdown;
	    this.leftToolBar = leftToolBar;
	    this.editor = editor;
	  }

	  public void widgetSelected(SelectionEvent event) {
		String widgetName = dropdown.getText().trim();
		if(widgetName.equals("Annoation")){
			setAnnoationPlate();
		}else if(widgetName.equals("Class")){
			setClassPlate();
		}
	  }
	  
	  private void setAnnoationPlate(){
		  secondWidget = leftToolBar.getItem(1).getText().trim();
		  if(leftToolBar.getItemCount() <= 2){
			  leftToolBar.getItems()[1].dispose();
			  leftToolBar.getChildren()[2].dispose();
			  ToolItem selectItem = SWTCompositeUtil.addToolItem(leftToolBar,    "Select             ",SWT.NONE);
			  ToolItem textItem = SWTCompositeUtil.addToolItem(leftToolBar,      "Text               ",SWT.NONE);
			  ToolItem noteItem = SWTCompositeUtil.addToolItem(leftToolBar,      "Note              ",SWT.NONE);
			  ToolItem noteLinkItem = SWTCompositeUtil.addToolItem(leftToolBar,  "NoteLink        ",SWT.NONE);
			  ToolItem rectangleItem = SWTCompositeUtil.addToolItem(leftToolBar, "Rectangle       ",SWT.NONE);
			  ToolItem eclipseItem = SWTCompositeUtil.addToolItem(leftToolBar,   "Eclipse           ",SWT.NONE);
			  // Seperator
		      SWTCompositeUtil.addSeperator(leftToolBar,0, 216, 130, 2);
			  ToolItem classDroupDown = SWTCompositeUtil.addToolItem(leftToolBar,"Class                    ",SWT.PUSH);
			  // Add Class DropDown Listener
		      SWTCompositeUtil.addSelectListener(classDroupDown,leftToolBar,editor);
		      // Seperator
		      SWTCompositeUtil.addSeperator(leftToolBar,0, 245, 130, 2);
		      // Temp use for SWT.PUSH height bug
		      ToolItem temp = SWTCompositeUtil.addToolItem(leftToolBar,"Temp                  ",SWT.DROP_DOWN);
		      temp.dispose();
		  }else{
			  thirdWidget = leftToolBar.getItem(2).getText().trim();
			  if(thirdWidget.equals("Select") ){
				  setClassPlate();
				  setAnnoationPlate();
			  }else{
				  leftToolBar.getChildren()[3].dispose(); //delete Seperator
				  leftToolBar.getChildren()[2].dispose(); //delete Seperator
				  leftToolBar.getItem(7).dispose(); //delete Class
				  leftToolBar.getItem(6).dispose(); //delete Eclipse
				  leftToolBar.getItem(5).dispose(); //delete Rectangle
				  leftToolBar.getItem(4).dispose(); //delete NoteLink
				  leftToolBar.getItem(3).dispose(); //delete Note
				  leftToolBar.getItem(2).dispose(); //delete Text
				  leftToolBar.getItem(1).dispose(); //delete Select
				  ToolItem classDroupDown = SWTCompositeUtil.addToolItem(leftToolBar,"Class                    ",SWT.PUSH);
				  // Add Class DropDown Listener
			      SWTCompositeUtil.addSelectListener(classDroupDown,leftToolBar,editor);
				  // Seperator
			      SWTCompositeUtil.addSeperator(leftToolBar,0, 60, 130, 2);
			      // Temp use for SWT.PUSH height bug
			      ToolItem temp = SWTCompositeUtil.addToolItem(leftToolBar,"Temp                  ",SWT.DROP_DOWN);
			      temp.dispose();
			  }
		  }
	  }
	  
	  private void setClassPlate(){
		  secondWidget = leftToolBar.getItem(1).getText().trim();
		  if(leftToolBar.getItemCount() <= 2){
			  if(secondWidget.equals("Class")){
				  ToolItem selectItem = SWTCompositeUtil.addToolItem(leftToolBar,    "Select             ",SWT.NONE);
				  ToolItem textItem = SWTCompositeUtil.addToolItem(leftToolBar,      "Class               ",SWT.NONE);
				  ToolItem noteItem = SWTCompositeUtil.addToolItem(leftToolBar,      "Composition    ",SWT.NONE);
				  ToolItem noteLinkItem = SWTCompositeUtil.addToolItem(leftToolBar,  "Generalization ",SWT.NONE);
				  // Seperator
			      SWTCompositeUtil.addSeperator(leftToolBar,0, 185, 130, 2);
			      // Temp use for SWT.PUSH height bug
			      ToolItem temp = SWTCompositeUtil.addToolItem(leftToolBar,"Temp                  ",SWT.DROP_DOWN);
			      temp.dispose();
			  }
		  }else{
			  thirdWidget = leftToolBar.getItem(2).getText().trim();
			  if(thirdWidget.equals("Select") ){
				  leftToolBar.getChildren()[3].dispose(); //delete Seperator
				  leftToolBar.getItem(5).dispose(); //delete Generalization
				  leftToolBar.getItem(4).dispose(); //delete Composition
				  leftToolBar.getItem(3).dispose(); //delete Class
				  leftToolBar.getItem(2).dispose(); //delete Select
			  }else if(thirdWidget.equals("Text")){
				  secondWidget="";
				  setAnnoationPlate();
				  secondWidget="Class";
				  setClassPlate();
			  }
		  }
		 
	  }
}