package org.star.uml.designer.application;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;

import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;

public class ApplicationActionBarAdvisor extends ActionBarAdvisor {
	
	private IWorkbenchAction saveAction;
	
    public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
        super(configurer);
    }

    protected void makeActions(IWorkbenchWindow window) {
    	saveAction = ActionFactory.SAVE.create(window); 
    	register(saveAction); 
    }

    protected void fillMenuBar(IMenuManager menuBar) {
    	menuBar.removeAll();
    	// 파일 메뉴를 생성한다.
    	MenuManager fileMenu = new MenuManager("&File", "File"); 
    	fileMenu.add(saveAction); // 저장 메뉴를 추가한다.
    	menuBar.add(fileMenu); //파일 메뉴를 추가한다.
    }
    
}
