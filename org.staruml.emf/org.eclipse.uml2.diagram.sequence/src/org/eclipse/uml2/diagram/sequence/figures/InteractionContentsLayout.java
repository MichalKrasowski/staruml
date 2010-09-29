package org.eclipse.uml2.diagram.sequence.figures;

import java.util.Iterator;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;


public class InteractionContentsLayout extends XYLayout {
	@Override
	public void layout(IFigure parent) {
		Iterator<?> children = parent.getChildren().iterator();
		Point offset = getOrigin(parent).getCopy();
		
		IFigure f;
		while (children.hasNext()) {
			f = (IFigure)children.next();
			Rectangle bounds = (Rectangle)getConstraint(f);
			if (bounds == null) continue;

			if (bounds.width == -1 || bounds.height == -1) {
				Dimension preferredSize = f.getPreferredSize(bounds.width, bounds.height);
				bounds = bounds.getCopy();
				if (bounds.width == -1)
					bounds.width = preferredSize.width;
				if (bounds.height == -1)
					bounds.height = preferredSize.height;
			}
			bounds = bounds.getTranslated(offset);
			f.setBounds(bounds);
		}
	}
	
	@Override
	public Point getOrigin(IFigure parent) {
		return super.getOrigin(parent);
	}

}
