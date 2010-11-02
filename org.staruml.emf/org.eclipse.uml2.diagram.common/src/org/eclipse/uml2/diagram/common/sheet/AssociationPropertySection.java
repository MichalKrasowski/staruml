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

import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.uml2.diagram.common.conventions.AssociationEndConvention;
import org.eclipse.uml2.uml.Association;

public class AssociationPropertySection {
	public static class AssociationPropertySectionFilter extends UML2ToolsPropertyFilter {

		@Override
		protected boolean isValid(Object transformed) {
			return (transformed instanceof Association) && ((Association)transformed).getMemberEnds().size() == 2;
		}

	}

	public static class SourcePropertySection extends UMLPropertySection {

		@Override
		public IPropertySource getPropertySource(Object object) {
			if (object instanceof Association) {
				object = AssociationEndConvention.getSourceEnd((Association) object);
			}
			return super.getPropertySource(object);
		}
	}
	
	public static class TargetPropertySection extends UMLPropertySection {

		@Override
		public IPropertySource getPropertySource(Object object) {
			if (object instanceof Association) {
				object = AssociationEndConvention.getTargetEnd((Association) object);
			}
			return super.getPropertySource(object);
		}
	}


}
