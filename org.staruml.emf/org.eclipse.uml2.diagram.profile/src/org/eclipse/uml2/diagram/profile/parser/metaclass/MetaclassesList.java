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

package org.eclipse.uml2.diagram.profile.parser.metaclass;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.uml2.diagram.common.parser.ElementProvider;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.resource.UMLResource;

public class MetaclassesList extends ElementProvider {
	private static final boolean YES_CACHING = true;
	
	public MetaclassesList(){
		super(YES_CACHING);
	}

	@Override
	public org.eclipse.uml2.uml.Class findElement(EObject context, String name) {
		return (org.eclipse.uml2.uml.Class)super.findElement(context, name);
	}

	@Override
	protected boolean isSuitable(Object object) {
		if (object instanceof org.eclipse.uml2.uml.Class) {
			org.eclipse.uml2.uml.Class umlClass = (org.eclipse.uml2.uml.Class) object;
			return umlClass.isMetaclass();
		}
		return false;
	}
	
	@Override
	protected List<NamedElement> loadAllElements(ResourceSet resourceSet) {
		preloadLibraries(resourceSet);
		return super.loadAllElements(resourceSet);
	}

	private void preloadLibraries(ResourceSet resourceSet) {
		resourceSet.getResource(URI.createURI(UMLResource.STANDARD_PROFILE_URI), true);
		resourceSet.getResource(URI.createURI(UMLResource.UML_PRIMITIVE_TYPES_LIBRARY_URI), true);
		resourceSet.getResource(URI.createURI(UMLResource.ECORE_PROFILE_URI), true);
		resourceSet.getResource(URI.createURI(UMLResource.ECORE_METAMODEL_URI), true);
		resourceSet.getResource(URI.createURI(UMLResource.UML_METAMODEL_URI), true);
	}

}
