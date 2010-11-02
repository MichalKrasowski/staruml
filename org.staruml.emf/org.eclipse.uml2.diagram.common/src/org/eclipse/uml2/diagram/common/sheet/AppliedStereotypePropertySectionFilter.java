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
package org.eclipse.uml2.diagram.common.sheet;

import org.eclipse.uml2.uml.Element;

public class AppliedStereotypePropertySectionFilter extends UML2ToolsPropertyFilter {

	@Override
	protected boolean isValid(Object transformed) {
		return (transformed instanceof Element) && (false == ((Element)transformed).getAppliedStereotypes().isEmpty());
	}

}
