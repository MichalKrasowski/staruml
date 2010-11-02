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

import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.gef.Handle;
import org.eclipse.gef.SharedCursors;
import org.eclipse.gef.handles.ResizeHandle;
import org.eclipse.gef.tools.ResizeTracker;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

public class U2THandleKit {

	public static Color SELECTION_COLOR = new Color(Display.getDefault(), 21, 66, 111);

	private U2THandleKit() {
	}

	public static void addNonResizableHandles(IGraphicalEditPart part, List<Handle> handles) {
		addMoveCornerHandles(part, handles);
	}

	public static void addResizableHandles(IGraphicalEditPart part, List<Handle> handles, int directions) {
		addResizeCornerHandles(part, handles, directions);
	}

	private static void addResizeCornerHandles(IGraphicalEditPart part, List<Handle> handles, int directions) {
		if (checkDirection(directions, PositionConstants.WEST)){
			handles.add(new ResizeFrameSideHandle(part, PositionConstants.WEST));
			handles.add(createInaccessibleResizeHandle(part, PositionConstants.WEST));
		}
		if (checkDirection(directions, PositionConstants.EAST)){
			handles.add(new ResizeFrameSideHandle(part, PositionConstants.EAST, ResizeFrameSideHandle.DEFAULT_SIZE, -1));
			handles.add(createInaccessibleResizeHandle(part, PositionConstants.EAST));
		}
		if (checkDirection(directions, PositionConstants.NORTH)){
			handles.add(new ResizeFrameSideHandle(part, PositionConstants.NORTH));
			handles.add(createInaccessibleResizeHandle(part, PositionConstants.NORTH));
		}
		if (checkDirection(directions, PositionConstants.SOUTH)){
			handles.add(new ResizeFrameSideHandle(part, PositionConstants.SOUTH));
			handles.add(createInaccessibleResizeHandle(part, PositionConstants.SOUTH));
		}

		if (checkDirection(directions, PositionConstants.SOUTH_EAST)){
			handles.add(createResizeCornerHandle(part, PositionConstants.SOUTH_EAST));	
		}
		if (checkDirection(directions, PositionConstants.SOUTH_WEST)){
			handles.add(createResizeCornerHandle(part, PositionConstants.SOUTH_WEST));
		}
		if (checkDirection(directions, PositionConstants.NORTH_WEST)){
			handles.add(createResizeCornerHandle(part, PositionConstants.NORTH_WEST));
		}
		if (checkDirection(directions, PositionConstants.NORTH_EAST)){
			handles.add(createResizeCornerHandle(part, PositionConstants.NORTH_EAST));
		}
	}

	public static Handle createResizeCornerHandle(IGraphicalEditPart owner, int direction) {
		ResizeHandle handle;
		if (direction == PositionConstants.NORTH_WEST || direction == PositionConstants.NORTH_EAST || direction == PositionConstants.SOUTH_WEST || direction == PositionConstants.SOUTH_EAST) {
			handle = new ResizeCornerHandle(owner, direction);
			handle.setForegroundColor(SELECTION_COLOR);
		} else {
			handle = new U2TResizeHandle(owner, direction);
		}
		handle.setDragTracker(new ResizeTracker(owner, direction));
		return handle;
	}

	private static U2TResizeHandle createInaccessibleResizeHandle(IGraphicalEditPart owner, int direction) {
		U2TResizeHandle handle = new U2TResizeHandle(owner, direction);
		handle.setDragTracker(new ResizeTracker(owner, direction));
		handle.setAccessible(false);
		return handle;
	}

	public static Handle createMoveHandle(IGraphicalEditPart part) {
		return new U2TMoveHandle(part, new Insets(3));
	}

	public static void addMoveCornerHandles(IGraphicalEditPart part, List<Handle> handles) {
		handles.add(createMoveCornerHandle(part, PositionConstants.SOUTH_EAST));
		handles.add(createMoveCornerHandle(part, PositionConstants.SOUTH_WEST));
		handles.add(createMoveCornerHandle(part, PositionConstants.NORTH_WEST));
		handles.add(createMoveCornerHandle(part, PositionConstants.NORTH_EAST));
	}

	public static Handle createMoveCornerHandle(IGraphicalEditPart owner, int direction) {
		U2TResizeHandle handle = new U2TResizeHandle(owner, direction);
		handle.setCursor(SharedCursors.SIZEALL);
		//handle.setDragTracker(new DragEditPartsTracker(owner));
		return handle;
	}
	
	private static boolean checkDirection(int direction, int desired){
		return (direction & desired) == desired;
	}
	
    public static IFigure createFeedbackFigure(final IFigure original) {
        RectangleFigure r = new RectangleFigure() {
            protected void outlineShape(Graphics graphics) {
                if (getBounds().width > 0 && getBounds().height > 0) {
                	super.outlineShape(graphics);
                }
            };
        };
        r.setFill(false);
        r.setForegroundColor(ColorConstants.black);
        r.setLineStyle(Graphics.LINE_DOT);
        r.setLineWidth(1);
        return r;
    }
	
}