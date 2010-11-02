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

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Cursors;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.handles.RelativeHandleLocator;
import org.eclipse.gef.handles.ResizeHandle;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.Size;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Cursor;

public class U2TResizeHandle extends ResizeHandle {
    public U2TResizeHandle(GraphicalEditPart owner, RelativeHandleLocator locator, Cursor cursor) {
        super(owner, locator, cursor);
    }
    
    public U2TResizeHandle(GraphicalEditPart owner, int direction) {
        this(owner, direction, 3); 
    }

    public U2TResizeHandle(GraphicalEditPart owner, int direction, int shift) {
        this(owner, new U2TRelativeHandleLocator(owner.getFigure(), direction, shift), 
        Cursors.getDirectionalCursor(direction));
    }

    protected Color getBorderColor() {
        return (isPrimary())
        ? ColorConstants.white
        : U2THandleKit.SELECTION_COLOR;
    }
    
    protected Color getFillColor() {
        return (isPrimary())
            ? U2THandleKit.SELECTION_COLOR
            : ColorConstants.white;
    }
   
    public void setAccessible(boolean b) {
        myIsAccessible = b;
    }

    public Point getAccessibleLocation() {
        if (!myIsAccessible) {
            return null;
        }
        return super.getAccessibleLocation();
    }
    
    protected boolean hasUserBounds(){
    	IGraphicalEditPart ownerImpl = (IGraphicalEditPart) getOwner();
    	View view = ownerImpl.getNotationView();
    	if (view instanceof Node){
    		Node node = (Node)view;
    		if (node.getLayoutConstraint() instanceof Size){
    			Size size = (Size)node.getLayoutConstraint();
    			return size.eIsSet(NotationPackage.eINSTANCE.getSize_Width()) || size.eIsSet(NotationPackage.eINSTANCE.getSize_Height());
    		}
    	}
    	return false;
    }
    
    private boolean myIsAccessible = true;
}
