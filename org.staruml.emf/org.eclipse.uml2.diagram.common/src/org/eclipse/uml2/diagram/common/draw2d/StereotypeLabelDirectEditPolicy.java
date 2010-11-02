/*
 * Copyright (c) 2009 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Michael Golubev (Borland) - initial API and implementation
 */
package org.eclipse.uml2.diagram.common.draw2d;

import org.eclipse.gef.Request;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.uml2.diagram.parser.SemanticLabelDirectEditPolicy;

public class StereotypeLabelDirectEditPolicy extends SemanticLabelDirectEditPolicy {
	@Override
	protected void showDirectEditFeedback(DirectEditRequest request) {
		if (getHostFigure() instanceof StereotypeLabel2){
			((StereotypeLabel2)getHostFigure()).setNeverHide(true);
		}
		super.showDirectEditFeedback(request);
	}
	
	@Override
	public void eraseSourceFeedback(Request request) {
		if (getHostFigure() instanceof StereotypeLabel2){
			((StereotypeLabel2)getHostFigure()).setNeverHide(false);
		}
		super.eraseSourceFeedback(request);
	}
}
