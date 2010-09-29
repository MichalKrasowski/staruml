package org.eclipse.uml2.diagram.sequence.draw2d.shadow;

import org.eclipse.uml2.diagram.sequence.figures.Plate;

/**
 * Figure that provides shadow for it's child.
 * 
 * @author dstadnik
 */
public class ShadowPlate extends Plate implements ShadowCaster {

	/**
	 * Thikness of child shadow.
	 * Use with caution since it may be refactored to be
	 * a configurable value.
	 */
	public static final int SHADOW_SIZE = 3;

	/**
	 * Returns configured shadow size (even if it is currently not visible).
	 */
	public final int getShadowSize() {
		return SHADOW_SIZE;
	}

	public final boolean isShadowVisible() {
		return myShadowVisible;
	}

	public void setShadowVisible(boolean visible) {
		if (myShadowVisible == visible) {
			return;
		}
		myShadowVisible = visible;
		repaint();
	}

	public final boolean isSimpleShadow() {
		return mySimpleShadow;
	}

	public void setSimpleShadow(boolean simple) {
		if (mySimpleShadow == simple) {
			return;
		}
		mySimpleShadow = simple;
		repaint();
	}

	private boolean myShadowVisible = true;
	private boolean mySimpleShadow = true;
}