package org.eclipse.uml2.diagram.common.draw2d;

import org.eclipse.gmf.runtime.diagram.ui.label.ILabelDelegate;

/**
 * Very limited set of ILabelDelegate methods is actually supported.
 */
public class RotatedImageOfStringLabelDelegate extends ILabelDelegate.Stub {
	private final RotatedImageOfString myLabel;

	public RotatedImageOfStringLabelDelegate(RotatedImageOfString label){
		myLabel = label;
	}
	
	@Override
	public String getText() {
		return myLabel.getText();
	}
	
	@Override
	public void setText(String text) {
		myLabel.setText(text);
	}
}