package org.star.uml.designer.ui.action;

import java.net.URL;

import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PlatformUI;
import org.osgi.framework.Bundle;
import org.star.uml.designer.application.Activator;
import org.star.uml.designer.ui.views.StarPMSModelView;
import org.star.uml.designer.ui.views.StarPMSRequestTableView;

public class PMSLogoutAction extends Action {
	
	public static final String ACTION_ID = "PMS_LOGOUT";
	public static final String ACTION_URI = "org.star.uml.designer.ui.action.PMSLogoutAction";
	public static final String ACTION_TITLE ="Logout Repository";
	public static final String ICON_PATH = "/icons/login.gif";
	
	public PMSLogoutAction() {
		super();
		this.setText(ACTION_TITLE);
		this.setImageDescriptor(getImageDescriptor());
	}
	@Override
	public void run() {
		super.run();
		IViewPart view_part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView("org.star.uml.designer.ui.views.StarPMSRequestTableView");
        StarPMSRequestTableView tableView = (StarPMSRequestTableView)view_part;
        tableView.removeTable();
        
        IViewPart request_view = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView("org.star.uml.designer.ui.views.StarPMSModelView");
        StarPMSModelView requestView = (StarPMSModelView)request_view;
        requestView.removeTree();
        
        StarPMSModelView modelView = (StarPMSModelView)request_view;
    	modelView.setLoginFlag(false);
	}
	
	public URL getImageURL(){
		Bundle bundle = Platform.getBundle(Activator.PLUGIN_ID);
		return bundle.getEntry(ICON_PATH);
	}
	
	public ImageDescriptor getImageDescriptor(){
		return Activator.getImageDescriptor(ICON_PATH);
	}
}
