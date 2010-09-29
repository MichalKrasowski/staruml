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


public class InEntitySatisfyCondition implements LifelineSatisfyCondition {

	public InEntitySatisfyCondition(SDLifeLineElement entity, AnchorProcessorInput anchorProcessorInput) throws SDModelUtil.AlienElementException {
		myEntity = entity;

		SDLifeLine lifelineEntity = SDModelUtil.findEnclosingLifeline2(myEntity);
		int lifelinePos = anchorProcessorInput.getLifelineIndex(lifelineEntity);
		myLifeLine = (LifeLine) anchorProcessorInput.lifeLinesList().get(lifelinePos);
	}

	public InEntitySatisfyCondition(SDLifeLineElement entity, LifeLine lifeLine) {
		myEntity = entity;
		myLifeLine = lifeLine;
	}

	public boolean isSatisfied(LifelineElementTraceable elementTraceable) {
		return myEntity == elementTraceable.getEntityAfterElement();
	}

	public LifeLine getLifeline() {
		return myLifeLine;
	}

	public String toString() {
		return "InEntitySatisfyCondition-" + myEntity;
	}

	private final SDLifeLineElement myEntity;

	private final LifeLine myLifeLine;
}
