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

import org.eclipse.draw2d.PositionConstants;


public class Position2Direction {

    public static int getShiftCoeffX(int dir) {
        switch (dir & PositionConstants.EAST_WEST) {
            case PositionConstants.WEST:
                return -1;
            case PositionConstants.EAST:
                return 1;
            default:
                return 0;
        }
    }

    public static int getShiftCoeffY(int dir) {
        switch (dir & PositionConstants.NORTH_SOUTH) {
            case PositionConstants.NORTH:
                return -1;
            case PositionConstants.SOUTH:
                return 1;
            default:
                return 0;
        }
    }
}
