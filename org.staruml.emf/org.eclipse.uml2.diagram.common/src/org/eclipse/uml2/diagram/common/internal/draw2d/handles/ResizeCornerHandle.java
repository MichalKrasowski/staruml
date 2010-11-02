/*
 * Copyright (c) 2009 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 */
package org.eclipse.uml2.diagram.common.internal.draw2d.handles;

import java.awt.Point;
import java.awt.geom.AffineTransform;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.GraphicalEditPart;

public class ResizeCornerHandle extends U2TResizeHandle {
        public ResizeCornerHandle(GraphicalEditPart owner, int direction) {
			super(owner, direction, 0);
			myDirection = direction;
			int cornerThickness = CORNER_SIZE/3;
			int cornerBreadth = CORNER_SIZE - 1;
	        myCornerPoints[0] = new Point(0, 0);
	        myCornerPoints[1] = new Point(cornerBreadth, 0);
	        myCornerPoints[2] = new Point(cornerBreadth, cornerThickness);
	        myCornerPoints[3] = new Point(cornerThickness, cornerThickness);
	        myCornerPoints[4] = new Point(cornerThickness, cornerBreadth);
	        myCornerPoints[5] = new Point(0, cornerBreadth);

	        int defSize = DEFAULT_HANDLE_SIZE - 2;
	        mySquare = new Rectangle(0, 0, defSize, defSize);
		}        
                        
		protected void init() {
			setPreferredSize(CORNER_SIZE, CORNER_SIZE);
		}
		
		public void paintFigure(Graphics g) {
			Rectangle r = new Rectangle(getBounds());
	        AffineTransform transform = new AffineTransform();
	        if (myDirection == PositionConstants.NORTH_WEST) {
	        	transform.translate(r.x, r.y);
	        }
	        else if (myDirection == PositionConstants.NORTH_EAST) {
	            transform.translate(r.x + r.width-1, r.y);
	        	transform.rotate(Math.toRadians(90));
	        }
	        else if (myDirection == PositionConstants.SOUTH_EAST) {
	            transform.translate(r.x + r.width-1, r.y + r.height-1);
	        	transform.rotate(Math.toRadians(180));
	        }
	        else if (myDirection == PositionConstants.SOUTH_WEST) {
	            transform.translate(r.x, r.y + r.height-1);
	        	transform.rotate(Math.toRadians(270));
	        }
			if (hasUserBounds()) {
		        paintBoldCorner(g, transform);
			}
			else {
				paintSquare(g);
			}	        	
		}
	
		private void paintBoldCorner(Graphics g, AffineTransform transform) {
            transformToPolygonPoints(transform, myCornerPoints, myCornerPolygon);
			g.setBackgroundColor(getFillColor());
	        g.fillPolygon(myCornerPolygon);
			g.setForegroundColor(getBorderColor());
	        g.drawPolygon(myCornerPolygon);
		}

		private void paintSquare(Graphics g) {
            Rectangle b = getBounds();
			g.setBackgroundColor(getFillColor());
			mySquare.setLocation( //
			  b.x + b.width/2 - DEFAULT_HANDLE_SIZE/2 + Position2Direction.getShiftCoeffX(myDirection) * (DEFAULT_HANDLE_SIZE/2 - 1), // 
              b.y + b.height/2 - DEFAULT_HANDLE_SIZE/2 + Position2Direction.getShiftCoeffY(myDirection) * (DEFAULT_HANDLE_SIZE/2 - 1));
	        g.fillRectangle(mySquare);
			g.setForegroundColor(getBorderColor());
	        g.drawRectangle(mySquare);
		}
		
		private static void transformToPolygonPoints(AffineTransform transform, Point[] source, int[] target) {
			Point targetPoint = new Point();
			for (int i = 0; i < source.length; i++) {
				Point point = source[i];
				transform.transform(point, targetPoint);
				target[i*2+0] = targetPoint.x;
				target[i*2+1] = targetPoint.y;
			}			
		}

		private int myDirection;
		private Point[] myCornerPoints = new Point[6];
		private int[] myCornerPolygon = new int[myCornerPoints.length * 2];
		private Rectangle mySquare;
		private static final int CORNER_SIZE = 10;
}
