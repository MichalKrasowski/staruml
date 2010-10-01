/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Tatiana Fesenko (Borland) - initial API and implementation
 */

package org.eclipse.uml2.diagram.clazz.part;

import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.uml2.diagram.clazz.edit.helpers.DependencyEditHelper;
import org.eclipse.uml2.diagram.clazz.providers.UMLElementTypes;
import org.eclipse.uml2.diagram.common.part.CreateLinkToolBase;
import org.eclipse.uml2.uml.UMLPackage;

public class CreateDependencyLinkTool extends CreateLinkToolBase {
	private final EClass myDependencyEClass;

	public CreateDependencyLinkTool(EClass dependecyEClass) {
		super(Collections.singletonList(UMLElementTypes.Dependency_4002));
		myDependencyEClass = dependecyEClass;
	}
	
	@Override
	protected Map<String, ?> createAdditionalExtendedData() {
		return Collections.singletonMap(DependencyEditHelper.PARAMETER_DEPENDENCY_TYPE, myDependencyEClass);
	}
	
	public static class DEPENDENCY extends CreateDependencyLinkTool {
		public DEPENDENCY(){
			super(UMLPackage.eINSTANCE.getDependency());
		}
	}
	
	public static class ABSTRACTION extends CreateDependencyLinkTool {
		public ABSTRACTION(){
			super(UMLPackage.eINSTANCE.getAbstraction());
		}
	}
	
	public static class USAGE extends CreateDependencyLinkTool {
		public USAGE(){
			super(UMLPackage.eINSTANCE.getUsage());
		}
	}

	public static class SUBSTITUTION extends CreateDependencyLinkTool {
		public SUBSTITUTION(){
			super(UMLPackage.eINSTANCE.getSubstitution());
		}
	}
}
