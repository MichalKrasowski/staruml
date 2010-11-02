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

import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;


public class ProfileAppliedStereotypeParser extends ClassifierAppliedStereotypeParser {
	private static final String PROFILE_LABEL = "profile"; //$NON-NLS-1$
	private static final String STEREOTYPE_LABEL = "stereotype"; //$NON-NLS-1$

	@Override
	protected String getElementLabel(Element element) {
		if (element instanceof Profile) {
			return PROFILE_LABEL;
		}
		if (element instanceof Stereotype) {
			return STEREOTYPE_LABEL;
		}
		return super.getElementLabel(element);
	}

}
