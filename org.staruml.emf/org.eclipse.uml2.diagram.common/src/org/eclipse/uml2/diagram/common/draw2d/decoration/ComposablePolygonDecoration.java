package org.eclipse.uml2.diagram.common.draw2d.decoration;

import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Transform;

public class ComposablePolygonDecoration extends PolygonDecoration implements ComposableRotatableDecoration {

	// duplicates PolylineDecoration#transform field
	// created to calculate EndPoint
	private Transform endPointTransform = new Transform();
	
	private Point myBoundPoint;

	public ComposablePolygonDecoration() {
		setScaleEx(7, 3);
		setLineWidth(1);
	}

	public Point getBoundPoint() {
		return endPointTransform.getTransformed(myBoundPoint);
	}

	@Override
	public void setLocation(Point p) {
		super.setLocation(p);
		endPointTransform.setTranslation(p.x, p.y);
	}

	public void setBoundPoint(Point point) {
		myBoundPoint = point;
	}

	@Override
	public void setScale(double x, double y) {
		super.setScale(x, y);
		setScaleEx(x, y);
	}

	@Override
	public void setRotation(double angle) {
		super.setRotation(angle);
		setRotationEx(angle);
	}

	public void setRotationEx(double angle) {
		endPointTransform.setRotation(angle);
	}
	
	public void setScaleEx(double x, double y) {
		if (endPointTransform == null) {
			endPointTransform = new Transform();
		}
		endPointTransform.setScale(x, y);
	}

}
