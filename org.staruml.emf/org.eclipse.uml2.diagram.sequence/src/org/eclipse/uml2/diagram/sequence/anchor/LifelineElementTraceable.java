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

import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.input.LifeLineElement;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDLifeLineElement;

interface LifelineElementTraceable extends LifeLineElement {

	SDLifeLineElement getEntityAfterElement();

	int getNumber();

	LifelineElementTraceable getPreviousElement();

	LifelineElementTraceable getNextElement();

	boolean isTopNotBottom();
}
