/*
 * Copyright (c) 2008 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Sergey Gribovsky (Borland) - initial API and implementation
 */

package org.eclipse.uml2.diagram.common.links;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.draw2d.ui.figures.BaseSlidableAnchor;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.IdentityAnchor;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.RelativeBendpoints;
import org.eclipse.gmf.runtime.notation.RoutingStyle;
import org.eclipse.gmf.runtime.notation.Smoothness;
import org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint;


public class ConnectionRoutingHelper {
	public static void setConnectionAnchors(Edge connection, Point sourceAnchorPoint, Rectangle sourceBounds, 
			Point targetAnchorPoint, Rectangle targetBounds) {
		setConnectionSourceAnchor(connection, sourceAnchorPoint, sourceBounds);
		setConnectionTargetAnchor(connection, targetAnchorPoint, targetBounds);
	}
	
	public static void setConnectionSourceAnchor(Edge connection, Point sourceAnchorPoint, Rectangle sourceBounds) {
		IdentityAnchor sourceAnchor = (IdentityAnchor) connection.getSourceAnchor();
		if (sourceAnchor == null)
			sourceAnchor = NotationFactory.eINSTANCE.createIdentityAnchor();
		sourceAnchor.setId(getAnchorTerminal(sourceAnchorPoint, sourceBounds));
		connection.setSourceAnchor(sourceAnchor);
	}
	
	public static void setConnectionTargetAnchor(Edge connection, Point targetAnchorPoint, Rectangle targetBounds) {
		IdentityAnchor targetAnchor = (IdentityAnchor) connection.getTargetAnchor();
		if (targetAnchor == null)
			targetAnchor = NotationFactory.eINSTANCE.createIdentityAnchor();
		targetAnchor.setId(getAnchorTerminal(targetAnchorPoint, targetBounds));
		connection.setTargetAnchor(targetAnchor);
	}
	
	public static void setConnectionBendPoints(Edge connection, List<Point> bendPoints, 
			Point sourceRefPoint, Point targetRefPoint, boolean isSmooth) {
		List<RelativeBendpoint> newBendpoints = new ArrayList<RelativeBendpoint>();
		
		for (Iterator<Point> bendPointsIterator = bendPoints.iterator(); bendPointsIterator.hasNext();) {
			Point bendPoint = bendPointsIterator.next();
			newBendpoints.add(new RelativeBendpoint(bendPoint.x - (int) sourceRefPoint.preciseX(), bendPoint.y - (int) sourceRefPoint.preciseY(),
					bendPoint.x - (int) targetRefPoint.preciseX(), bendPoint.y - (int) targetRefPoint.preciseY()));
		}
		if (isSmooth) {
			RoutingStyle umlRoutingStyle = 
				(RoutingStyle) connection.getStyle(NotationPackage.Literals.ROUTING_STYLE);
			if (umlRoutingStyle == null) {
				umlRoutingStyle = NotationFactory.eINSTANCE.createRoutingStyle();
			}
			umlRoutingStyle.setSmoothness(Smoothness.NORMAL_LITERAL);
		}

		RelativeBendpoints umlBendpoints = (RelativeBendpoints) connection.getBendpoints();
		umlBendpoints.setPoints(newBendpoints);
	}

	private static String getAnchorTerminal(Point point, Rectangle participantBounds) {
		return composeTerminalString(BaseSlidableAnchor.getAnchorRelativeLocation(point, participantBounds));
	}

	/**
	 * COPY/PASTE from BaseSlidableAnchor.composeTerminalString(...)
	 */
	private static String composeTerminalString(PrecisionPoint p) {
		StringBuffer s = new StringBuffer(24);
		s.append('(');				 		// 1 char
		s.append((float)p.preciseX);		// 10 chars
		s.append(',');						// 1 char
		s.append((float)p.preciseY);		// 10 chars
		s.append(')');						// 1 char
		return s.toString();				// 24 chars max (+1 for safety, i.e. for string termination)
	}
}
