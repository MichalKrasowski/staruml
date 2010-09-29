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

public class CannotAlignElementsException extends EvaluatingException {

	private static final long serialVersionUID = 1L;

	protected CannotAlignElementsException() {
		super();
	}

	protected CannotAlignElementsException(String message) {
		super(message);
	}

	protected CannotAlignElementsException(String message, Throwable cause) {
		super(message, cause);
	}

	protected CannotAlignElementsException(Throwable cause) {
		super(cause);
	}
}