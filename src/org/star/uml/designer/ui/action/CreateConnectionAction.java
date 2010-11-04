package org.star.uml.designer.ui.action;

import java.net.URL;

import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.Display;
import org.osgi.framework.Bundle;
import org.star.uml.designer.application.Activator;
import org.star.uml.designer.ui.newWiazrds.db.ConnectionCreateDialog;

public class CreateConnectionAction extends Action{
	
	public static final String ACTION_ID = "CREATE_PMS_CONNECTION";
	public static final String ACTION_URI = "org.star.uml.designer.action.CreateConnectionAction";
	public static final String ACTION_TITLE ="Create PMS Connection";
	public static final String ICON_PATH = "/icons/login.gif";
	
	public CreateConnectionAction() {
		this.setId("connection");
		this.setToolTipText("Create Connection tooltip");
		this.setImageDescriptor(Activator.getImageDescriptor("/icons/login.gif"));
	}
	
	public void run() {
		ConnectionCreateDialog connectionDialog = new ConnectionCreateDialog(Display.getCurrent().getActiveShell());
		connectionDialog.open();
	}
	
	public URL getImageURL(){
		Bundle bundle = Platform.getBundle(Activator.PLUGIN_ID);
		return bundle.getEntry(ICON_PATH);
	}
	
	public ImageDescriptor getImageDescriptor(){
		return Activator.getImageDescriptor(ICON_PATH);
	}
}
