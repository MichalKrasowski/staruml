package org.eclipse.uml2.diagram.sequence.draw2d;

import java.util.Iterator;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;


public class YOnlyLayout extends XYLayout {

	public void layout(IFigure parent) {
		Rectangle clientArea = parent.getClientArea();
		Iterator<?> children = parent.getChildren().iterator();
		Point offset = getOrigin(parent);
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
			center(bounds, clientArea);
			f.setBounds(bounds);
		}
	}
	
	private void center(Rectangle subject, Rectangle area){
		int centeredX = (area.x + area.width / 2) - subject.width / 2;
		subject.translate(centeredX - subject.x, 0);
	}
}
