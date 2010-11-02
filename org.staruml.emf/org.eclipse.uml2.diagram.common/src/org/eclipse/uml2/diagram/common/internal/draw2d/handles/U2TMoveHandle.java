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

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.handles.MoveHandle;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.tools.DragEditPartsTrackerEx;

public class U2TMoveHandle extends MoveHandle {
    final Insets myFrameInsets;

    public U2TMoveHandle(IGraphicalEditPart owner) {
        this(owner, new Insets(0, 0, 0, 0));
    }
    public U2TMoveHandle(IGraphicalEditPart owner, Insets frameInsets) {
        super(owner);
        myFrameInsets = new Insets(frameInsets);
        this.setForegroundColor(U2THandleKit.SELECTION_COLOR);
        setCursor(null);
    }

    protected void initialize() {
    	super.initialize();
    	setBorder(null);
    }
    
    public void paintFigure(Graphics g) {
        Rectangle b = new Rectangle(this.getClientArea()).expand(myFrameInsets);
        g.setLineStyle(Graphics.LINE_DOT);
        g.drawRectangle(b.x, b.y, b.width - 1, b.height - 1);
    }

    private static Insets ourInsets = new Insets();
    public Insets getInsets() {
        ourInsets.left = myFrameInsets.left;
        ourInsets.top = myFrameInsets.top;
        ourInsets.right = Math.max(myFrameInsets.right, BUFFER_GAP);
        ourInsets.bottom = myFrameInsets.bottom;
        return ourInsets;
    }

public boolean containsPoint(int x, int y) {
        if (!getBounds().contains(x, y)) {
            return false;
        }
        Rectangle.SINGLETON.setBounds(getBounds());
        Rectangle.SINGLETON.width -= BUFFER_GAP;
        return !Rectangle.SINGLETON.contains(x, y);
    }

    protected DragTracker createDragTracker() {
        DragEditPartsTrackerEx tracker = new DragEditPartsTrackerEx(getOwner());
        return tracker;
    }
    
    public Point getAccessibleLocation() {
//        return super.getAccessibleLocation();
        Point p = getBounds().getTopRight().translate(-BUFFER_GAP/2, getBounds().height / 4);
        translateToAbsolute(p);
        return p;
    }
    
    private static final int BUFFER_GAP = 5;
}