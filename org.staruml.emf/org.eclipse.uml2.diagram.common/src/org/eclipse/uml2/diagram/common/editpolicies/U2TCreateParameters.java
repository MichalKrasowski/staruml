package org.eclipse.uml2.diagram.common.editpolicies;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gmf.runtime.notation.View;

public interface U2TCreateParameters {

	public View getParentView();

	public Point getRelativeLocation();

	public View getAnchorSibling();

	public boolean isBeforeNotAfterAnchor();
}