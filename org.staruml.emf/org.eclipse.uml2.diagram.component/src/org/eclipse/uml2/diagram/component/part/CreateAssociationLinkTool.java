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
 *    Tatiana Fesenko (Borland) - initial API and implementation
 */

package org.eclipse.uml2.diagram.component.part;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.uml2.diagram.common.part.CreateLinkToolBase;
import org.eclipse.uml2.diagram.component.edit.helpers.AssociationEditHelper;
import org.eclipse.uml2.diagram.component.providers.UMLElementTypes;
import org.eclipse.uml2.uml.AggregationKind;

public class CreateAssociationLinkTool extends CreateLinkToolBase {

	private final AggregationKind myKind;

	public CreateAssociationLinkTool(AggregationKind kind) {
		super(Collections.singletonList(UMLElementTypes.Association_4011));
		myKind = kind;
	}
	
	@Override
	protected Map<String, Object> createAdditionalExtendedData() {
		HashMap<String, Object> result = new HashMap<String, Object>();
		result.put(AssociationEditHelper.PARAMETER_CONFIGURE_AGGREGATION_KIND, myKind);
		return result;
	}
	
	public static class NONE extends CreateAssociationLinkTool {
		public NONE(){
			super(AggregationKind.NONE_LITERAL);
		}
	}
	
	public static class COMPOSITE extends CreateAssociationLinkTool {
		public COMPOSITE(){
			super(AggregationKind.COMPOSITE_LITERAL);
		}
	}
	
	public static class SHARED extends CreateAssociationLinkTool {
		public SHARED(){
			super(AggregationKind.SHARED_LITERAL);
		}
	}
	public static class NAVIGABLE extends CreateAssociationLinkTool {
		public NAVIGABLE(){
			super(AggregationKind.NONE_LITERAL);
		}
		@Override
		protected Map<String, Object> createAdditionalExtendedData() {
			Map<String, Object> result = super.createAdditionalExtendedData();
			result.put(AssociationEditHelper.PARAMETER_SET_TARGET_NAVIGABILITY, Boolean.TRUE);
			return result;
		}
	}

}
