/*
 * Copyright (c) 2009 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Sergey Gribovsky (Borland) - initial API and implementation
 */
package org.eclipse.uml2.diagram.statemachine.part;

import org.eclipse.uml2.diagram.statemachine.providers.UMLElementTypes;
import org.eclipse.uml2.uml.PseudostateKind;

public class CreateExitConnectionPointReferenceTool extends CreateConnectionPointReferenceTool {
	public CreateExitConnectionPointReferenceTool() {
		super(UMLElementTypes.ConnectionPointReference_3018);
	}

	@Override
	protected PseudostateKind getKind() {
		return PseudostateKind.EXIT_POINT_LITERAL;
	}
}
