/*
 * Copyright (c) 2009 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Michael Golubev (Borland)
 */
package org.eclipse.uml2.diagram.sequence.anchor;

import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.input.LifeLine;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDLifeLine;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDLifeLineElement;


public class InEntityNeighbourhoodSatisfyCondition implements LifelineSatisfyCondition {

	public InEntityNeighbourhoodSatisfyCondition(SDLifeLineElement entity, AnchorProcessorInput anchorProcessorInput, boolean isBeforeOk, boolean isInsideOk, boolean isAfterOk)
			throws SDModelUtil.AlienElementException {
		myLifeLineElement = entity;
		SDLifeLine lifelineEntity = SDModelUtil.findEnclosingLifeline2(myLifeLineElement);
		int lifelinePos = anchorProcessorInput.getLifelineIndex(lifelineEntity);
		myLifeLine = (LifeLine) anchorProcessorInput.lifeLinesList().get(lifelinePos);

		myIsBeforeOk = isBeforeOk;
		myIsInsideOk = isInsideOk;
		myIsAfterOk = isAfterOk;
	}

	public boolean isSatisfied(LifelineElementTraceable elementTraceable) {
		if (myIsInsideOk && myLifeLineElement == elementTraceable.getEntityAfterElement()) {
			return true;
		}
		if (myIsAfterOk && !elementTraceable.isTopNotBottom() && elementTraceable.getPreviousElement().getEntityAfterElement() == myLifeLineElement) {
			return true;
		}
		LifelineElementTraceable nextTraceable = elementTraceable.getNextElement();
		if (myIsBeforeOk && nextTraceable != null && nextTraceable.isTopNotBottom() && nextTraceable.getEntityAfterElement() == myLifeLineElement) {
			return true;
		}
		return false;
	}

	public LifeLine getLifeline() {
		return myLifeLine;
	}

	public String toString() {
		return "InEntityNeighboudhoodSatisfyCondition for " + myLifeLineElement;
	}

	private final SDLifeLineElement myLifeLineElement;

	private final LifeLine myLifeLine;

	private final boolean myIsBeforeOk;

	private final boolean myIsInsideOk;

	private final boolean myIsAfterOk;
}
