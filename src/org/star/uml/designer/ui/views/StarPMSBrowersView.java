package org.star.uml.designer.ui.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;


public class StarPMSBrowersView extends ViewPart {

public static final String ID = "org.star.uml.designer.ui.views.StarPMSBrowersView";
	
	private Browser browser;
	
	public StarPMSBrowersView() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {
		browser = new Browser(parent, SWT.NONE);
	}

	@Override
	public void setFocus() {
	}
	
	public void setURL(String url){
		browser.setUrl(url);
	}

}
