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

import org.eclipse.draw2d.Cursors;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Locator;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.handles.AbstractHandle;
import org.eclipse.gef.tools.ResizeTracker;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;

public class ResizeFrameSideHandle extends AbstractHandle implements Locator {

	public ResizeFrameSideHandle(IGraphicalEditPart owner, int direction) {
		this(owner, direction, DEFAULT_SIZE, DEFAULT_INSET);
	}

	public ResizeFrameSideHandle(IGraphicalEditPart owner, int direction, int size, int inset) {
		assert (direction == PositionConstants.NORTH || direction == PositionConstants.SOUTH //
				|| direction == PositionConstants.EAST || direction == PositionConstants.WEST);
		setOwner(owner);
		setLocator(this);
		mySize = size;
		myInset = inset;
		myDirection = direction;
		setOpaque(false);
		setCursor(Cursors.getDirectionalCursor(direction));
	}

	protected DragTracker createDragTracker() {
		return new ResizeTracker(getOwner(), myDirection);
	}

	public Point getAccessibleLocation() {
		Point p = getBounds().getCenter();
		translateToAbsolute(p);
		return p;
	}

	public void relocate(IFigure target) {
		IFigure figure = getOwnerFigure();

		Rectangle figureBounds = figure.getBounds();
		figureBounds = new PrecisionRectangle(figureBounds);
		figure.translateToAbsolute(figureBounds);
		target.translateToRelative(figureBounds);

		Rectangle handleBounds = null;
		switch (myDirection) {
		case PositionConstants.WEST:
			handleBounds = new Rectangle(figureBounds.x - myInset - mySize, figureBounds.y - myInset, mySize, figureBounds.height + myInset * 2);
			break;
		case PositionConstants.EAST:
			handleBounds = new Rectangle(figureBounds.x + figureBounds.width + myInset, figureBounds.y - myInset, mySize, figureBounds.height + myInset * 2);
			break;
		case PositionConstants.NORTH:
			handleBounds = new Rectangle(figureBounds.x - myInset, figureBounds.y - myInset - mySize, figureBounds.width + myInset * 2, mySize);
			break;
		case PositionConstants.SOUTH:
			handleBounds = new Rectangle(figureBounds.x - myInset, figureBounds.y + figureBounds.height + myInset, figureBounds.width + myInset * 2, mySize);
			break;
		default:
			throw new IllegalStateException();
		}
		target.setBounds(handleBounds);
	}

	public static final int DEFAULT_SIZE = 4;

	public static final int DEFAULT_INSET = 1;

	private final int mySize;

	private final int myInset;

	private final int myDirection;
}
