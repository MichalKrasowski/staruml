package org.eclipse.uml2.diagram.common.draw2d.decoration;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.uml2.diagram.common.draw2d.RequiredInterfaceDecoration;


public class DotDecoration extends RequiredInterfaceDecoration implements ComposableRotatableDecoration {

	public Point getBoundPoint() {
		Rectangle bounds = getBounds();
		return new Point(bounds.x + bounds.width / 2, bounds.y + bounds.height / 2);
	}
	
	public void setRadius(int radius){
		super.setRadius(radius);
		setTemplate(new PointList(new int[] {radius, 0} ));
	}
	
	@Override
	protected void outlineShape(Graphics g) {
		g.drawOval(getBounds());
	}

	@Override
	protected void fillShape(Graphics g) {
		g.fillOval(getBounds());
	}
}
