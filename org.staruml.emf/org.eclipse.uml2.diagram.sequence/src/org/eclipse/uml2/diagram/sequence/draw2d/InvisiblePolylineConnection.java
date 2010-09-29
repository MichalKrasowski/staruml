package org.eclipse.uml2.diagram.sequence.draw2d;

import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;


public class InvisiblePolylineConnection extends PolylineConnectionEx {
	public InvisiblePolylineConnection(){
		super.setVisible(false);
	}
	
	@Override
	public void setVisible(boolean visible) {
		// ignore, I am never visible
	}

}
