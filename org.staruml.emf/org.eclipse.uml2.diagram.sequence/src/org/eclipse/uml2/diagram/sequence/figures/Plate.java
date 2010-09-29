package org.eclipse.uml2.diagram.sequence.figures;

import java.util.List;

import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Layer;
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;

/**
 * Container figure for a single child.
 * May be used to decorate child but
 * generally it is a bad practice due
 * to the additional object instance
 * required.
 * 
 * @author dstadnik
 */
public class Plate extends Layer {

	public Plate() {
		super.setLayoutManager(new BorderLayout());
	}

	/**
	 * @throws UnsupportedOperationException
	 */
	public void setLayoutManager(LayoutManager lm) {
		throw new UnsupportedOperationException();
	}

	protected void layout() {
        if (getChild() == null) {
            return;
        }
        Rectangle b = new Rectangle(bounds);
        b.width -= getInsets().getWidth();
        b.height -= getInsets().getHeight();
        getChild().setBounds(b);
	}

	public void setBounds(Rectangle bounds) {
		super.setBounds(bounds);
        if (getChild() == null) {
            return;
        }
        Rectangle b = new Rectangle(bounds);
        b.width -= getInsets().getWidth();
        b.height -= getInsets().getHeight();
        getChild().setBounds(b);
	}

	public void setPreferredSize(Dimension bounds) {
		super.setPreferredSize(bounds);
        if (getChild() == null) {
            return;
        }
		getChild().setPreferredSize(new Dimension(bounds));
	}

	public Dimension getMinimumSize(int wHint, int hHint) {
        if (getChild() == null) {
            return super.getMinimumSize(wHint, hHint);
        }
		return getChild().getMinimumSize(wHint, hHint);
	}

	public Dimension getMaximumSize() {
        if (getChild() == null) {
            return super.getMaximumSize();
        }
		return getChild().getMaximumSize();
	}

	public boolean isOpaque() {
	    if (getChild() == null) {
	        return super.isOpaque();
        }
		return getChild().isOpaque();
	}

	public void setOpaque(boolean opaque) {
        super.setOpaque(opaque);
        if (getChild() != null) {
            getChild().setOpaque(opaque);
        }
	}

	/**
	 * Allows addition of only one figure.
	 */
	public void add(IFigure figure, Object constraint, int index) {
		if (getChildren().size() > 0) {
			throw new IllegalStateException();
		}
		super.add(figure, BorderLayout.CENTER, index);
	}

	/**
	 * Retrieves first child or null if none were added.
	 */
	public IFigure getChild() {
		List<?> children = getChildren();
		if (children.isEmpty()) {
			return null;
		}
		return (IFigure) children.get(0);
	}

	public Color getBackgroundColor() {
        if (getChild() != null) {
    		if (!myColourLock) {
    			myColourLock = true;
    			try {
    				return getChild().getBackgroundColor();
    			} finally {
    				myColourLock = false;
    			}
    		}
        }
		return super.getBackgroundColor();
	}

	public Color getForegroundColor() {
        if (getChild() != null) {
    		if (!myColourLock) {
    			myColourLock = true;
    			try {
    				return getChild().getForegroundColor();
    			} finally {
    				myColourLock = false;
    			}
    		}
        }
		return super.getForegroundColor();
	}

	private boolean myColourLock;
}