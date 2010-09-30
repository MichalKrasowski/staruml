/*
 * Copyright (c) 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Sergey Gribovsky (Borland) - initial API and implementation
 */

package org.eclipse.uml2.diagram.activity.draw2d;

import java.util.Iterator;
import java.util.Map;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.uml2.diagram.activity.edit.parts.ActivityPartition_ActivityPartitionEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ActivityPartitionEditPart;


public class PartitionLayout extends XYLayout {
	public static int HORIZONTAL = 0;
	public static int VERTICAL = 1;

	private int partitionOrientation;
	private Map<?,?> visualPartMap;

	public PartitionLayout() {
		this(HORIZONTAL);
	}
	
	public PartitionLayout(int orientation) {
		partitionOrientation = orientation;
	}
	
	public int getPartitionOrientation() {
		return partitionOrientation;
	}
	
	public void setViewer(EditPartViewer viewer) {
		visualPartMap = viewer.getVisualPartMap();
	}

	@Override
	public void layout(IFigure parent) {
		Iterator<?> children = parent.getChildren().iterator();
		Dimension clientAreaSize = parent.getClientArea().getSize();
		Point offset = getOrigin(parent);
		IFigure f;
		while (children.hasNext()) {
			f = (IFigure)children.next();
			Rectangle bounds = (Rectangle)getConstraint(f);
			if (bounds == null) continue;

			if (bounds.width == -1 || bounds.height == -1) {
				Dimension preferredSize = f.getPreferredSize(bounds.width, bounds.height);
				bounds = bounds.getCopy();
				if (bounds.width == -1)
					bounds.width = preferredSize.width;
				if (bounds.height == -1)
					bounds.height = preferredSize.height;
			}
			
			if (isPartition(f)) {
				if (getPartitionOrientation() == HORIZONTAL) {
					bounds.x = 0;
					bounds.width = clientAreaSize.width;
				} else {
					bounds.y = 0;
					bounds.height = clientAreaSize.height;
				}
			}
			
			bounds = bounds.getTranslated(offset);
			f.setBounds(bounds);
		}
	}
	
	private boolean isPartition(IFigure figure) {
		if (visualPartMap == null) {
			return false;
		}
		
		EditPart editPart = (EditPart) visualPartMap.get(figure);
		if (editPart == null) { 
			return false;
		}
		return editPart instanceof ActivityPartitionEditPart ||
			editPart instanceof ActivityPartition_ActivityPartitionEditPart;
	}
}
