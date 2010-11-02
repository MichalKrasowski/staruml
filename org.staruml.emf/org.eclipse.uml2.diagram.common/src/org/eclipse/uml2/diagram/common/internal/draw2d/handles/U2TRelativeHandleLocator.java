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

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.handles.RelativeHandleLocator;


public class U2TRelativeHandleLocator extends RelativeHandleLocator {
    protected int myLocation;
    private int myShift;

    public U2TRelativeHandleLocator(IFigure reference, int location, int shift) {
        super(reference, location);
        myLocation = location;
        myShift = shift;
    }
    
    public void relocate(IFigure target) {
        super.relocate(target);
        target.getBounds().x += Position2Direction.getShiftCoeffX(myLocation) * myShift;
        target.getBounds().y += Position2Direction.getShiftCoeffY(myLocation) * myShift;
    }
    
}