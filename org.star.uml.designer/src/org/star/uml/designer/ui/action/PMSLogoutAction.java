package org.star.uml.designer.ui.action;

import java.net.URL;

import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.osgi.framework.Bundle;
import org.star.uml.designer.Activator;

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
	}
	
	public URL getImageURL(){
		Bundle bundle = Platform.getBundle(Activator.PLUGIN_ID);
		return bundle.getEntry(ICON_PATH);
	}
	
	public ImageDescriptor getImageDescriptor(){
		return Activator.getImageDescriptor(ICON_PATH);
	}
}
