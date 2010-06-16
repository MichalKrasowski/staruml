package enkisoft.sobis.staruml.ui;

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

import enkisoft.sobis.staruml.ui.layout.console.DebugConsole;

public class ApplicationWorkbenchAdvisor extends WorkbenchAdvisor {

	private static final String PERSPECTIVE_ID = "enkisoft.sobis.staruml.ui.perspective";

    public WorkbenchWindowAdvisor createWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
        return new ApplicationWorkbenchWindowAdvisor(configurer);
    }

	public String getInitialWindowPerspectiveId() {
		return PERSPECTIVE_ID;
	}
	
	public void initialize(IWorkbenchConfigurer configurer) {
		configurer.setSaveAndRestore(true);
		PlatformUI.getPreferenceStore().setValue(IWorkbenchPreferenceConstants.SHOW_TRADITIONAL_STYLE_TABS, false);
		ConsolePlugin.getDefault().getConsoleManager().addConsoles(new IConsole[] { new DebugConsole() });
		
		WorkbenchAdapterBuilder.registerAdapters();
		// ������Ʈ ���� �� ����� �������� �����Ѵ�.
		setProjectIcon(configurer);
	}
	
	private void setProjectIcon(IWorkbenchConfigurer configurer){
		// �÷����� �����ϱ� ���� ������ �����´�.
		Bundle ideBundle = Platform.getBundle(IDEWorkbenchPlugin.IDE_WORKBENCH);
		// ������Ʈ �������� ��ġ�� URL��ü�� ��ȯ�Ѵ�.
		URL close_icon = ideBundle.getEntry(CommonConstants.IMG_PROJECT_CLOSEED);
		URL open_icon = ideBundle.getEntry(CommonConstants.IMG_PROJECT_OPEN);
		// URL�� ���Ͽ� �̹��� ��ü�� ���´�.
		ImageDescriptor close_img = ImageDescriptor.createFromURL(close_icon);
		ImageDescriptor open_img = ImageDescriptor.createFromURL(open_icon);
		// RCP ���� �̹����� ����Ѵ�.
		configurer.declareImage(IDE.SharedImages.IMG_OBJ_PROJECT, open_img, true);
		configurer.declareImage(IDE.SharedImages.IMG_OBJ_PROJECT_CLOSED, close_img, true);
	}
}
