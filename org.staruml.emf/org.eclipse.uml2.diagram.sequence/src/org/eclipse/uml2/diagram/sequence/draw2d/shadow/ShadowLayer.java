package org.eclipse.uml2.diagram.sequence.draw2d.shadow;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Layer;
import org.eclipse.draw2d.geometry.Dimension;

/**
 * Shadow of the figures added to it.
 * 
 * @author dstadnik
 */
public class ShadowLayer extends Layer {
	public ShadowLayer() {
		myShadowMaster = createShadowMaster();
	}

	protected ShadowMaster createShadowMaster() {
		return new ShadowMaster();
	}

	public void addClient(IFigure figure) {
		myShadowMaster.addClient(figure);
	}

	protected void paintFigure(Graphics g) {
		myShadowMaster.paintFigure(g);
	}

	public Dimension getPreferredSize(int wHint, int hHint) {
		return myShadowMaster.getPreferredSize(wHint, hHint);
	}

	private ShadowMaster myShadowMaster;
}