/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Michael Golubev (Borland) - initial API and implementation
 */

package org.eclipse.uml2.diagram.profile.parser.property;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.uml2.diagram.common.parser.property.PropertyParser;
import org.eclipse.uml2.diagram.parser.BasicApplyStrategy;
import org.eclipse.uml2.diagram.parser.SemanticParserAdapter;
import org.eclipse.uml2.diagram.parser.lookup.DefaultOclLookups;
import org.eclipse.uml2.diagram.parser.lookup.LookupSuiteImpl;
import org.eclipse.uml2.diagram.parser.lookup.OCLLookup;
import org.eclipse.uml2.diagram.profile.expressions.UMLOCLFactory;
import org.eclipse.uml2.diagram.profile.providers.UMLElementTypes;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;


public class PropertyParserProvider extends AbstractProvider implements IParserProvider {
	private IParser myParser;

	public IParser getParser(IAdaptable hint) {
		if (myParser == null){
			myParser = createParser();
		}
		return myParser;
	}
	
	private IParser createParser(){
		LookupSuiteImpl lookupSuite = new LookupSuiteImpl();
		lookupSuite.addLookup(Type.class, new OCLLookup<Type>(UMLOCLFactory.getOCLLookupExpression(DefaultOclLookups.DEFAULT_TYPE_LOOKUP, UMLPackage.eINSTANCE.getNamedElement())));
		return new SemanticParserAdapter(
				new PropertyParser(lookupSuite), 
				new BasicApplyStrategy(), 
				new StereotypePropertyToString()
		);
	}

	public boolean provides(IOperation operation) {
		boolean result = false;
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			result = (hint != null) && (hint.getAdapter(IElementType.class) == UMLElementTypes.Property_3001); 
		}
		return result;
	}
	
	private static class StereotypePropertyToString extends org.eclipse.uml2.diagram.common.parser.property.PropertyToString.VIEW {
		@Override
		protected void appendIsDerived(StringBuffer result, Property property) {
			//derived properties do not make sense for stereotypes
		}
		
		@Override
		protected void appendPropertyModifiers(StringBuffer result, Property property) {
			//properties modifiers do not make sense for stereotypes
		}
	}
}
