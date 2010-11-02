package org.eclipse.uml2.diagram.common.draw2d;

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.swt.graphics.Image;


public class StereotypeLabel2 extends WrappingLabel {
	private boolean myNeverHide;
	
	public StereotypeLabel2() {
		setTextPlacement(PositionConstants.EAST);
		setIconAlignment(PositionConstants.BOTTOM);
		setTextAlignment(PositionConstants.BOTTOM);
		setAlignment(PositionConstants.CENTER);
	}
	
	public boolean hasText(){
		String text = getText();
		return text != null && text.trim().length() > 0;
	}
	
	@Override
	public boolean hasIcons() {
		return super.hasIcons();
	}

	@Override
	public void setText(String text) {
		super.setText(text);
		hideIfEmpty();
	}
	
	@Override
	public void setIcon(Image image, int index) {
		super.setIcon(image, index);
		hideIfEmpty();
	}
	
	public void setNeverHide(boolean neverHide){
		if (myNeverHide == neverHide){
			return;
		}
		myNeverHide = neverHide;
		if (!neverHide){
			hideIfEmpty();
		}
	}
	
	public boolean isNeverHide() {
		return myNeverHide;
	}
	
	private void hideIfEmpty(){
		boolean hasSomething = hasText() || hasIcons();
		boolean visible = myNeverHide || hasSomething;
		setVisible(visible);
	}

}
