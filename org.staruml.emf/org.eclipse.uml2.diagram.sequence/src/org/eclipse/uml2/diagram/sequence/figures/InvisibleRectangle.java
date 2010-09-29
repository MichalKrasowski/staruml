package org.eclipse.uml2.diagram.sequence.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.RectangleFigure;

public class InvisibleRectangle extends RectangleFigure {

	public void paintFigure(Graphics g) {
		if (!isHidden()) {
			super.paintFigure(g);
		}
	}

	public void setHidden(boolean hidden) {
		myHidden = hidden;
		// DO NOT REPAINT - see ShadowPlate
	}

	public boolean isHidden() {
		return myHidden;
	}

	protected boolean myHidden = true;
}