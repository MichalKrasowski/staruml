/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Michael Golubev (Borland) - initial API and implementation
 */

package org.eclipse.uml2.diagram.sequence.draw2d;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.uml2.diagram.common.draw2d.decoration.ComposablePolygonDecoration;
import org.eclipse.uml2.diagram.common.draw2d.decoration.CompositeDecoration;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageSort;

public class MessageDestinationDecoration extends CompositeDecoration {

	private static final PointList OPEN_ARROW = new PointList(new int[] { //
			//
					-2, 1, // 
					0, 0, //
					-2, -1, //
					0, 0, // 
					-2, 1, //
			});
	
	private static final PointList CLOSED_ARROW = new PointList(new int[] { //
			//
					-2, 1, // 
					0, 0, //
					-2, -1, //
			});
	
	private ComposablePolygonDecoration myOpenArrowDecoration;
	private ComposablePolygonDecoration myClosedArrowDecoration;

	public MessageDestinationDecoration() {
		initAggregationDecorations();
	}

	private void initAggregationDecorations() {
		myOpenArrowDecoration = new ComposablePolygonDecoration();
		myOpenArrowDecoration.setTemplate(OPEN_ARROW.getCopy());
		myOpenArrowDecoration.setFill(false);
		if (getParent() != null && getParent().getForegroundColor() != null) {
			myOpenArrowDecoration.setBackgroundColor(getParent().getForegroundColor());
		}
		myClosedArrowDecoration = new ComposablePolygonDecoration();
		myClosedArrowDecoration.setTemplate(CLOSED_ARROW.getCopy());
		myClosedArrowDecoration.setFill(true);
		if (getParent() != null && getParent().getForegroundColor() != null) {
			myClosedArrowDecoration.setBackgroundColor(getParent().getForegroundColor());
		}
	}

	public void updateMessageSort(MessageSort sort) {
		if (sort == MessageSort.ASYNCH_CALL_LITERAL || sort == MessageSort.ASYNCH_SIGNAL_LITERAL) {
			addDecoration(myClosedArrowDecoration);
			removeDecoration(myOpenArrowDecoration);
		} else { //if (sort == MessageSort.SYNCH_CALL_LITERAL) {
			addDecoration(myOpenArrowDecoration);
			removeDecoration(myClosedArrowDecoration);
		}  
	}
	
	public void updateReply(MessageSort sort) {
		PolylineConnectionEx connection = (PolylineConnectionEx) getParent();
		if (sort == MessageSort.REPLY_LITERAL) {
			connection.setLineStyle(Graphics.LINE_CUSTOM);
			connection.setLineDash(new int[] {5, 5, 5, 5});
		} else {
			connection.setLineStyle(Graphics.LINE_SOLID);
		}
	}

	public void update(Message message, IPreferenceStore store) {
		updateMessageSort(message.getMessageSort());
		updateReply(message.getMessageSort());
	}

}
