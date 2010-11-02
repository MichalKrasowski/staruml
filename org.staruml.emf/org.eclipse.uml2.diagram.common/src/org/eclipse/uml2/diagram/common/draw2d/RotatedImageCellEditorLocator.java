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
package org.eclipse.uml2.diagram.common.draw2d;

import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;


public class RotatedImageCellEditorLocator implements CellEditorLocator {

	private RotatedImageOfString rotatedImage;

	public RotatedImageCellEditorLocator(RotatedImageOfString rotatedImage) {
		this.rotatedImage = rotatedImage;
	}

	public void relocate(CellEditor celleditor) {
		Text text = (Text) celleditor.getControl();
		Rectangle rect = rotatedImage.getBounds().getCopy();
		rotatedImage.translateToAbsolute(rect);
		int avr = FigureUtilities.getFontMetrics(text.getFont()).getAverageCharWidth();
		Dimension textSize = new Dimension(text.computeSize(SWT.DEFAULT, SWT.DEFAULT)).expand(avr * 2, 0);
		rect.x = rect.x + 3;
		rect.y = rect.y + rect.height / 2 - textSize.height / 2;
		rect.setSize(textSize);
		if (!rect.equals(new Rectangle(text.getBounds()))) {
			text.setBounds(rect.x, rect.y, rect.width, rect.height);
		}
	}
}