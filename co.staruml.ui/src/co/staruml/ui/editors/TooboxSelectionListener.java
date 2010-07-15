package co.staruml.ui.editors;

import java.util.HashMap;

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
import co.staruml.handler.CreatetHandler;
import co.staruml.handler.Handler;
import co.staruml.handler.MouseEvent;
import co.staruml.handler.SelectHandler;

public class TooboxSelectionListener extends SelectionAdapter {
	  private ToolItem dropdown;
	  private ToolBar leftToolBar;
	  private DiagramControl editor;
	  private String secondWidget; // Use for draw plate
	  private String thirdWidget;  // Use for draw plate
	  private HashMap<String,Handler> handerMap;

	  public TooboxSelectionListener(ToolItem dropdown,ToolBar leftToolBar,DiagramControl editor,HashMap<String,Handler> handerMap) {
	    this.dropdown = dropdown;
	    this.leftToolBar = leftToolBar;
	    this.editor = editor;
	    this.handerMap = handerMap;
	  }

	  public void widgetSelected(SelectionEvent event) {
		String widgetName = dropdown.getText().trim();
		// Depending on the type of widget to handle the action.
		if(widgetName.equals("Annoation")){ // Drop Down plate menu
			setAnnoationPlate();
		}else if(widgetName.equals("Class Diagram")){// Drop Down plate menu
			setClassPlate();
		}else if(widgetName.equals("Class")){ //create Class UML
			CreatetHandler createHandler = (CreatetHandler)handerMap.get("createHandler");
			createHandler.setType("Class");
			editor.setHandler(createHandler);
		}else if(widgetName.equals("Select")){ //Change handler
			SelectHandler selectHandler = (SelectHandler)handerMap.get("selectHandler");
			editor.setHandler(selectHandler);
		}else if(widgetName.equals("Composition")){ //Change handler
			CreatetHandler createHandler = (CreatetHandler)handerMap.get("createHandler");
			createHandler.setType("Composition");
			editor.setHandler(createHandler);
		}else if(widgetName.equals("Generalization")){ //Generalization handler
			CreatetHandler createHandler = (CreatetHandler)handerMap.get("createHandler");
			createHandler.setType("Generalization");
			editor.setHandler(createHandler);
		}
		
		
	  }
	  
	  /*
	   * Plate can spread is only one item at a time.
	   */
	  private void setAnnoationPlate(){
		  secondWidget = leftToolBar.getItem(1).getText().trim(); 
		  // If these two items is the initial state.
		  // Class, Seperator item to delete and add Annoation related items.
		  if(leftToolBar.getItemCount() <= 2){
			  leftToolBar.getItems()[1].dispose();
			  leftToolBar.getChildren()[2].dispose();
			  ToolItem selectItem = SWTCompositeUtil.addToolItem(leftToolBar,    "Select             ",SWT.NONE);
		      SWTCompositeUtil.addSelectListener(selectItem,leftToolBar,editor,handerMap);
			  ToolItem textItem = SWTCompositeUtil.addToolItem(leftToolBar,      "Text               ",SWT.NONE);
			  ToolItem noteItem = SWTCompositeUtil.addToolItem(leftToolBar,      "Note              ",SWT.NONE);
			  ToolItem noteLinkItem = SWTCompositeUtil.addToolItem(leftToolBar,  "NoteLink        ",SWT.NONE);
			  ToolItem rectangleItem = SWTCompositeUtil.addToolItem(leftToolBar, "Rectangle       ",SWT.NONE);
			  ToolItem eclipseItem = SWTCompositeUtil.addToolItem(leftToolBar,   "Eclipse           ",SWT.NONE);
			  // Seperator
		      SWTCompositeUtil.addSeperator(leftToolBar,0, 216, 130, 2);
			  ToolItem classDroupDown = SWTCompositeUtil.addToolItem(leftToolBar,"Class Diagram       ",SWT.PUSH);
			  // Add Class Listener
		      SWTCompositeUtil.addSelectListener(classDroupDown,leftToolBar,editor,handerMap);
		      
		      // Seperator
		      SWTCompositeUtil.addSeperator(leftToolBar,0, 245, 130, 2);
		      // Temp use for SWT.PUSH height bug
		      ToolItem temp = SWTCompositeUtil.addToolItem(leftToolBar,"Temp                  ",SWT.DROP_DOWN);
		      temp.dispose();
		  }else{
			  thirdWidget = leftToolBar.getItem(2).getText().trim();
			  // If the open ClassDiagram ClassDiagram to initialize.
			  // Add Annoation related items
			  if(thirdWidget.equals("Select") ){
				  setClassPlate();
				  setAnnoationPlate();
			  }else{
				  // If the open Annoation then initialize
				  leftToolBar.getChildren()[3].dispose(); //delete Seperator
				  leftToolBar.getChildren()[2].dispose(); //delete Seperator
				  leftToolBar.getItem(7).dispose(); //delete Class
				  leftToolBar.getItem(6).dispose(); //delete Eclipse
				  leftToolBar.getItem(5).dispose(); //delete Rectangle
				  leftToolBar.getItem(4).dispose(); //delete NoteLink
				  leftToolBar.getItem(3).dispose(); //delete Note
				  leftToolBar.getItem(2).dispose(); //delete Text
				  leftToolBar.getItem(1).dispose(); //delete Select
				  ToolItem classDroupDown = SWTCompositeUtil.addToolItem(leftToolBar,"Class Diagram       ",SWT.PUSH);
				  // Add Listener
			      SWTCompositeUtil.addSelectListener(classDroupDown,leftToolBar,editor,handerMap);
				  // Seperator
			      SWTCompositeUtil.addSeperator(leftToolBar,0, 60, 130, 2);
			      // Temp use for SWT.PUSH height bug
			      ToolItem temp = SWTCompositeUtil.addToolItem(leftToolBar,"Temp                  ",SWT.DROP_DOWN);
			      temp.dispose();
			  }
		  }
	  }
	  
	  /*
	   * Plate can spread is only one item at a time.
	   */
	  private void setClassPlate(){
		  secondWidget = leftToolBar.getItem(1).getText().trim();
		  // If these two items is the initial state.
		  // Add ClassDiagram related items.
		  if(leftToolBar.getItemCount() <= 2){
			  if(secondWidget.equals("Class Diagram")){
				  ToolItem selectItem = SWTCompositeUtil.addToolItem(leftToolBar,    "Select             ",SWT.NONE);
			      SWTCompositeUtil.addSelectListener(selectItem,leftToolBar,editor,handerMap);
				  
			      ToolItem classItem = SWTCompositeUtil.addToolItem(leftToolBar,      "Class               ",SWT.NONE);
				  SWTCompositeUtil.addSelectListener(classItem,leftToolBar,editor,handerMap);
				  
				  ToolItem compositionItem = SWTCompositeUtil.addToolItem(leftToolBar,      "Composition    ",SWT.NONE);
				  SWTCompositeUtil.addSelectListener(compositionItem,leftToolBar,editor,handerMap);
				  
				  ToolItem generalizationItem = SWTCompositeUtil.addToolItem(leftToolBar,  "Generalization ",SWT.NONE);
				  SWTCompositeUtil.addSelectListener(generalizationItem,leftToolBar,editor,handerMap);
				  
			      SWTCompositeUtil.addSeperator(leftToolBar,0, 185, 130, 2);
			      // Temp use for SWT.PUSH height bug
			      ToolItem temp = SWTCompositeUtil.addToolItem(leftToolBar,"Temp                  ",SWT.DROP_DOWN);
			      temp.dispose();
			  }
		  }else{
			  thirdWidget = leftToolBar.getItem(2).getText().trim();
			  // If the open ClassDiagram ClassDiagram to initialize.
			  if(thirdWidget.equals("Select") ){
				  leftToolBar.getChildren()[3].dispose(); //delete Seperator
				  leftToolBar.getItem(5).dispose(); //delete Generalization
				  leftToolBar.getItem(4).dispose(); //delete Composition
				  leftToolBar.getItem(3).dispose(); //delete Class
				  leftToolBar.getItem(2).dispose(); //delete Select
			  // If the open Annoation then initializ Annoation.
			  // Add ClassDiagram related items.
			  }else if(thirdWidget.equals("Text")){
				  secondWidget="";
				  setAnnoationPlate();
				  secondWidget="Class";
				  setClassPlate();
			  }
		  }
	  }
}