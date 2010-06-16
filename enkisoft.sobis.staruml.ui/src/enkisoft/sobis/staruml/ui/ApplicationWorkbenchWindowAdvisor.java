package enkisoft.sobis.staruml.ui;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

public class ApplicationWorkbenchWindowAdvisor extends WorkbenchWindowAdvisor {

    public ApplicationWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
        super(configurer);
    }

    public ActionBarAdvisor createActionBarAdvisor(IActionBarConfigurer configurer) {
        return new ApplicationActionBarAdvisor(configurer);
    }
    
    public void preWindowOpen() {
        IWorkbenchWindowConfigurer configurer = getWindowConfigurer();
        configurer.setInitialSize(new Point(400, 300));
        configurer.setShowCoolBar(false);
        configurer.setShowStatusLine(false);
        configurer.setShowMenuBar(false);
        configurer.setTitle("SoBiS Star UML");
    }
    
    public void createWindowContents(Shell shell) {
    	super.createWindowContents(shell);
    	// �ε�� Full Screen ó��
    	shell.setMaximized(true);
    }
    
    @Override
    public void postWindowOpen() {
    	super.postWindowOpen();
    	// �ε�� Full Screen ó��
    	final IWorkbenchWindow window = getWindowConfigurer().getWindow();
    	Shell shell = window.getShell();
    	shell.setMaximized( true );

    }
}
