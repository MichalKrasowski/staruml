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

import org.eclipse.osgi.util.NLS;
import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.input.LifeLine;

public class CompositeLifelineSatisfyCondition implements LifelineSatisfyCondition {

	public CompositeLifelineSatisfyCondition(LifelineSatisfyCondition firstCondition, LifelineSatisfyCondition secondCondition) {
		myFirstCondition = firstCondition;
		mySecondCondition = secondCondition;
		if (myFirstCondition.getLifeline() != mySecondCondition.getLifeline()) {
			throw new IllegalArgumentException("Incompatible lifelines");
		}
	}

	public boolean isSatisfied(LifelineElementTraceable elementTraceable) {
		return myFirstCondition.isSatisfied(elementTraceable) && mySecondCondition.isSatisfied(elementTraceable);
	}

	public LifeLine getLifeline() {
		return myFirstCondition.getLifeline();
	}

	public String toString() {
		return NLS.bind("Comp: {0} + {1}", new Object[] { myFirstCondition, mySecondCondition });
	}

	private final LifelineSatisfyCondition myFirstCondition;

	private final LifelineSatisfyCondition mySecondCondition;

	public static LifelineSatisfyCondition add(LifelineSatisfyCondition first, LifelineSatisfyCondition second) {
		if (first == null) {
			return second;
		} else if (second == null) {
			return first;
		} else {
			return new CompositeLifelineSatisfyCondition(first, second);
		}
	}

	public static LifelineSatisfyCondition[] add(LifelineSatisfyCondition[] first, LifelineSatisfyCondition[] second) {
		if (first.length != second.length) {
			throw new IllegalArgumentException();
		}

		LifelineSatisfyCondition[] result = new LifelineSatisfyCondition[first.length];
		for (int i = 0; i < first.length; i++) {
			result[i] = add(first[i], second[i]);
		}

		return result;
	}
}
