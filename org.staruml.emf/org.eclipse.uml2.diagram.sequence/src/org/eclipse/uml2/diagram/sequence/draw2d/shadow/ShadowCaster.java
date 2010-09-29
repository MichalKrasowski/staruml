package org.eclipse.uml2.diagram.sequence.draw2d.shadow;

import org.eclipse.draw2d.IFigure;

/**
 * Figures implementing this interface will cast shadows.
 * 
 * @author dstadnik
 */
public interface ShadowCaster extends IFigure {

	public boolean isShadowVisible();

	/**
	 * Shadow detail level.
	 * 
	 * Simple shadow (default setting) means that only direct children cast
	 * the shadow (though there is a special case of InvisibleRectangle
	 * that has a shadow cast by it's children). If shadow is set to be not
	 * simple then the whole figures tree is walked down to calculate
	 * a precise shadow.
	 */
	public boolean isSimpleShadow();
	
	public static final int SHADOW_SIZE = 3;
}