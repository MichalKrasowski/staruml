/*
 * Copyright (c) 2006, 2008 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Tatiana Fesenko (Borland) - initial API and implementation
 */
package org.eclipse.uml2.diagram.common.parser.stereotype;

import org.eclipse.uml2.uml.Abstraction;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Substitution;
import org.eclipse.uml2.uml.Usage;

public class DependencyAppliedStereotypeParser extends AppliedStereotypeParser {

	private final static String LABEL_ABSTRACTION = "abstraction"; //$NON-NLS-1$
	private final static String LABEL_USAGE = "usage"; //$NON-NLS-1$
	private final static String LABEL_SUBSTITUTION = "substitute";	 //$NON-NLS-1$

	@Override
	protected String getElementLabel(Element element) {
		if (element instanceof Substitution) {
			return LABEL_SUBSTITUTION;
		}
		if (element instanceof Abstraction) {
			return LABEL_ABSTRACTION;
		}
		if (element instanceof Usage) {
			return LABEL_USAGE;
		}
		return null;
	}
}
