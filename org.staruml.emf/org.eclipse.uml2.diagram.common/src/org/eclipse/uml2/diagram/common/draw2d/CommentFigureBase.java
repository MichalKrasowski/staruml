/*
 * Copyright (c) 2008 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Tatiana Fesenko (Borland) - initial API and implementation
 */
package org.eclipse.uml2.diagram.common.draw2d;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.figures.NoteFigure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.swt.graphics.Color;

public class CommentFigureBase extends NoteFigure {

	private static final Color CORNER_COLOR = new Color(null, 234, 234, 247);

	private WrappingLabel myBody;

	public CommentFigureBase() {
		this(100, 65, new Insets());
	}

	public CommentFigureBase(int width, int height, Insets insets) {
		super(width, height, insets);
		myBody = new WrappingLabel();
		myBody.setBorder(new MarginBorder(4, 4, 4, 4));
		
		myBody.setTextPlacement(PositionConstants.EAST);
		myBody.setTextAlignment(PositionConstants.TOP);
		myBody.setIconAlignment(PositionConstants.TOP);

		add(myBody);
	}

	@Override
	protected void paintFigure(Graphics g) {
		super.paintFigure(g);
		g.pushState();
		Rectangle r = getBounds();
		// if (withDanglingCorner) {
		PointList corner = new PointList();
		corner.addPoint(r.x + r.width - getClipWidthCopy(), r.y);
		corner.addPoint(r.x + r.width - getClipWidthCopy(), r.y + getClipHeightCopy());
		corner.addPoint(r.x + r.width, r.y + getClipHeightCopy());
		g.setBackgroundColor(CORNER_COLOR);
		g.fillPolygon(corner);
		// }
		g.popState();
	}

	private int getClipHeightCopy() {
		return MapModeUtil.getMapMode(this).DPtoLP(12);
	}

	private int getClipWidthCopy() {
		return getClipHeightCopy() + MapModeUtil.getMapMode(this).DPtoLP(1);
	}

	public WrappingLabel getBodyLabel() {
		return myBody;
	}

	protected void setTextLabelWrap(boolean wrap) {
		getBodyLabel().setTextWrap(wrap);
	}

}
