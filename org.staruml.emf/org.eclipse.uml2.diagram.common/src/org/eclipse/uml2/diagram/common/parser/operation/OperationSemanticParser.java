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
package org.eclipse.uml2.diagram.common.parser.operation;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.diagram.parser.BasicApplyStrategy;
import org.eclipse.uml2.diagram.parser.SemanticParserAdapter;
import org.eclipse.uml2.diagram.parser.lookup.LookupSuiteImpl;


public class OperationSemanticParser extends SemanticParserAdapter {
	
	protected final LookupSuiteImpl myLookupSuite;
	
	public OperationSemanticParser(LookupSuiteImpl lookupSuite) {
		super(new OperationParser(lookupSuite), new BasicApplyStrategy(), new OperationToString.VIEW(), new OperationToString.EDIT());
		myLookupSuite = lookupSuite;
	}

	protected final EObject doAdapt(IAdaptable adaptable) {
		EObject element = (EObject) adaptable.getAdapter(EObject.class);
		return element;
	}
	
}
