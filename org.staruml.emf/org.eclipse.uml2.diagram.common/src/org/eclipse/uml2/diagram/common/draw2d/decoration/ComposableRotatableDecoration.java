package org.eclipse.uml2.diagram.common.draw2d.decoration;

import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.geometry.Point;


public interface ComposableRotatableDecoration extends RotatableDecoration {
	Point getBoundPoint();
}
