/*
 * Copyright (c) 2009 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 */
package org.eclipse.uml2.diagram.common.editpolicies;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.gef.Handle;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableShapeEditPolicy;
import org.eclipse.uml2.diagram.common.internal.draw2d.handles.U2THandleKit;


public class U2TResizableShapeEditPolicy extends ResizableShapeEditPolicy {
	private int myDirections = PositionConstants.NSEW;

	@Override
	protected List<?> createSelectionHandles() {
		List<Handle> result = new ArrayList<Handle>();
		result.add(U2THandleKit.createMoveHandle(getHostImpl()));
		U2THandleKit.addMoveCornerHandles(getHostImpl(), result);
		if (myDirections != -1){
			U2THandleKit.addResizableHandles(getHostImpl(), result, myDirections);
		}
		return result;
	}
	
	@Override
	public void setResizeDirections(int newDirections) {
		myDirections = newDirections;
		super.setResizeDirections(newDirections);
	}
	
	private IGraphicalEditPart getHostImpl(){
		return (IGraphicalEditPart)getHost();
	}
	
}
