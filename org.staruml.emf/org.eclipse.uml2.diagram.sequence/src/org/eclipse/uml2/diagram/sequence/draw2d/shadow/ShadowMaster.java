package org.eclipse.uml2.diagram.sequence.draw2d.shadow;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.jface.resource.ColorRegistry;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.uml2.diagram.sequence.figures.InvisibleRectangle;


/**
 * Shadow of the figures added to it.
 * 
 * @author dstadnik
 */
public class ShadowMaster {
	public static final int SHADOW_SIZE = ShadowCaster.SHADOW_SIZE;
	protected static final String SHADOW_COLOR_KEY = "ShadowColor"; //$NON-NLS-1$

	private static ColorRegistry ourColorRegistry;
	private List<IFigure> myClients;

	/**
	 * Register figure that will cast shadow on this layer.
	 */
	public void addClient(IFigure figure) {
		if (figure == null) {
			throw new NullPointerException();
		}
		if (myClients == null) {
			myClients = new ArrayList<IFigure>();
		}
		myClients.add(figure);
	}

	public void paintFigure(Graphics g) {
		paintFigures(myClients, g);
	}

	protected void paintFigures(List<?> figures, Graphics g) {
		if (figures == null || figures.isEmpty()) {
			return;
		}
		for (int i = 0; i < figures.size(); i++) {
			IFigure child = (IFigure) figures.get(i);
			if (child instanceof ShadowCaster) {
				ShadowCaster caster = (ShadowCaster) child;
				if (!caster.isShadowVisible()) {
					continue;
				}
				if (caster instanceof ShadowPlate) {
					child = ((ShadowPlate) caster).getChild();
					if (child == null) {
						continue;
					}
				}
				paintShadow(caster.isSimpleShadow(), child, g);
			} else {
				paintFigures(child.getChildren(), g);
			}
		}
	}

	protected void paintShadow(boolean simpleShadow, IFigure figure, Graphics g) {
		g.pushState();
		try {
			g.translate(SHADOW_SIZE, SHADOW_SIZE);
			Color shadowColor = getShadowColor();
			g.setForegroundColor(shadowColor);
			g.setBackgroundColor(shadowColor);
			g.clipRect(new Rectangle(figure.getBounds()));

			// Shadow of InvisibleRectangle is a shadow
			// of it's children and a border.
			if (figure instanceof InvisibleRectangle) {
				paintChildrenShadow(simpleShadow, figure, g);
			} else {
				if (figure instanceof Shape) {
					((Shape) figure).paintFigure(g);
				}
				if (!simpleShadow) {
					paintChildrenShadow(false, figure, g);
				}
			}
			Border border = figure.getBorder();
			if (border != null) {
				border.paint(figure, g, IFigure.NO_INSETS);
			}
		} finally {
			g.popState();
		}
	}

	protected void paintChildrenShadow(boolean simpleShadow, IFigure figure,
			Graphics g) {
		Rectangle clip = Rectangle.SINGLETON;
		List<?> children = figure.getChildren();
		for (int i = children.size() - 1; i >= 0; i--) {
			IFigure child = (IFigure) children.get(i);
			if (child instanceof ShadowStealth) {
				continue;
			}
			if (child instanceof ShadowCaster) {
				ShadowCaster caster = (ShadowCaster) child;
				if (!caster.isShadowVisible()) {
					continue;
				}
				if (caster instanceof ShadowPlate) {
					child = ((ShadowPlate) caster).getChild();
					if (child == null) {
						continue;
					}
				}
				simpleShadow |= caster.isSimpleShadow();
			}
			if (child instanceof Shape) {
				Shape shape = (Shape) child;
				if (shape.isVisible() && shape.intersects(g.getClip(clip))) {
					g.pushState();
					try {
						g.clipRect(new Rectangle(shape.getBounds()));
						shape.paintFigure(g);
						Border border = shape.getBorder();
						if (border != null) {
							border.paint(shape, g, IFigure.NO_INSETS);
						}
					} finally {
						g.popState();
					}
				}
			}
			if (!simpleShadow) {
				paintChildrenShadow(simpleShadow, child, g);
			}
		}
	}

	public Dimension getPreferredSize(int wHint, int hHint) {
		Dimension size = new Dimension();
		if (myClients == null) {
			return size;
		}
		for (int i = myClients.size() - 1; i >= 0; i--) {
			IFigure client = (IFigure) myClients.get(i);
			size.union(client.getPreferredSize());
		}
		size.width += SHADOW_SIZE;
		size.height += SHADOW_SIZE;
		return size;
	}
	
	private Color getShadowColor(){
		return getColorRegistry().get(SHADOW_COLOR_KEY);
	}
	
	private static ColorRegistry createColorRegistry(){
		ColorRegistry registry = new ColorRegistry();
		registry.put(SHADOW_COLOR_KEY, new RGB(153, 153, 153));
		return registry;
	}
	
	private static ColorRegistry getColorRegistry(){
		if (ourColorRegistry == null){
			ourColorRegistry = createColorRegistry();
		}
		return ourColorRegistry;
	}
	

}