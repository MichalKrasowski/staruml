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

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.uml2.diagram.sequence.model.sequenced.SDBracket;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDModel;

public class AnchorProcessorInputHolder {

	public AnchorProcessorInputHolder(SDModel specialInteraction, Set<SDBracket> ignoreBrackets) {
		myIgnoreBrackets = ignoreBrackets;
		mySpecialInteraction = specialInteraction;
	}

	public AnchorProcessorInput getAnchorProcessorInput(SDModel interactionEntity) {
		AnchorProcessorInput result = (AnchorProcessorInput) myInteraction2Input.get(interactionEntity);
		if (result == null) {
			Set<SDBracket> ignoreBrackets = mySpecialInteraction == interactionEntity ? myIgnoreBrackets : Collections.<SDBracket> emptySet();
			result = new AnchorProcessorInput(interactionEntity, ignoreBrackets);
			myInteraction2Input.put(interactionEntity, result);
		}
		return result;
	}

	private final Map<SDModel, AnchorProcessorInput> myInteraction2Input = new HashMap<SDModel, AnchorProcessorInput>(2);

	private final SDModel mySpecialInteraction;

	private final Set<SDBracket> myIgnoreBrackets;
}
