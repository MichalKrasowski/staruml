package org.star.uml.designer.application;

import java.net.URL;

import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkbenchPreferenceConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.application.IWorkbenchConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchAdvisor;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.internal.ide.IDEWorkbenchPlugin;
import org.eclipse.ui.internal.ide.model.WorkbenchAdapterBuilder;
import org.osgi.framework.Bundle;
import org.star.uml.designer.base.constance.GlobalConstants;

public class ApplicationWorkbenchAdvisor extends WorkbenchAdvisor {

	private static final String PERSPECTIVE_ID = "org.star.uml.designer.application.perspective";

    public WorkbenchWindowAdvisor createWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
        return new ApplicationWorkbenchWindowAdvisor(configurer);
    }
    
    public void initialize(IWorkbenchConfigurer configurer) {
		configurer.setSaveAndRestore(true);
		PlatformUI.getPreferenceStore().setValue(IWorkbenchPreferenceConstants.SHOW_TRADITIONAL_STYLE_TABS, false);
		WorkbenchAdapterBuilder.registerAdapters();
		setProjectIcon(configurer);
	}
    
    private void setProjectIcon(IWorkbenchConfigurer configurer){
		// 플랫폼에 접근하기 위한 번들을 가져온다.
		Bundle ideBundle = Platform.getBundle(IDEWorkbenchPlugin.IDE_WORKBENCH);
		// 프로잭트 아이콘의 위치를 URL객체로 변환한다.
		URL close_icon = ideBundle.getEntry(GlobalConstants.IMG_PROJECT_CLOSEED);
		URL open_icon = ideBundle.getEntry(GlobalConstants.IMG_PROJECT_OPEN);
		// URL를 통하여 이미지 객체를 얻어온다.
		ImageDescriptor close_img = ImageDescriptor.createFromURL(close_icon);
		ImageDescriptor open_img = ImageDescriptor.createFromURL(open_icon);
		// RCP 공유 이미지에 등록한다.
		configurer.declareImage(IDE.SharedImages.IMG_OBJ_PROJECT, open_img, true);
		configurer.declareImage(IDE.SharedImages.IMG_OBJ_PROJECT_CLOSED, close_img, true);
	}

	public String getInitialWindowPerspectiveId() {
		return PERSPECTIVE_ID;
	}
}
