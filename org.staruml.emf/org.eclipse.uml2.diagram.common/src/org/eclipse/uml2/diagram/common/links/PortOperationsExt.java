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
package org.eclipse.uml2.diagram.common.links;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * The class repeats the functionality of
 * org.eclipse.uml2.uml.internal.operations.PortOperations class for
 * Provided and Required interfaces, providing additional info that required to
 * manage (create/delete/reorient) Provided/Required Interface links.
 * */

public class PortOperationsExt {

	public static ProvidedInterfaceLink getProvideds(Port port, Interface provided) {
		for (ProvidedInterfaceLink next : getProvideds(port)) {
			if (provided.equals(next.getTarget())) {
				return next;
			}
		}
		return null;
	}

	public static Collection<ProvidedInterfaceLink> getProvideds(Port port) {
		Set<ProvidedInterfaceLink> provideds = new HashSet<ProvidedInterfaceLink>();
		Type type = (Type) port.eGet(UMLPackage.Literals.TYPED_ELEMENT__TYPE, false);

		// if (type instanceof Interface) {
		// provideds.add((Interface) type);
		// } else
		if (type instanceof Classifier) {
			Classifier classifier = (Classifier) port.getType();
			provideds.addAll(ComponentOperationsExt.realizedInterfaces(null, classifier, false));

			for (Classifier parent : classifier.allParents()) {

				provideds.addAll(ComponentOperationsExt.realizedInterfaces(null, parent, false));
			}
		}

		return provideds;
	}

	public static RequiredInterfaceLink getRequireds(Port port, Interface required) {
		for (RequiredInterfaceLink next : getRequireds(port)) {
			if (required.equals(next.getTarget())) {
				return next;
			}
		}
		return null;
	}

	public static Collection<RequiredInterfaceLink> getRequireds(Port port) {
		Set<RequiredInterfaceLink> requireds = new HashSet<RequiredInterfaceLink>();
		Type type = (Type) port.eGet(UMLPackage.Literals.TYPED_ELEMENT__TYPE, false);

		if (type instanceof Classifier) {
			Classifier classifier = (Classifier) port.getType();
			requireds.addAll(ComponentOperationsExt.usedInterfaces(null, classifier, false));

			for (Classifier parent : classifier.allParents()) {
				requireds.addAll(ComponentOperationsExt.usedInterfaces(null, parent, false));
			}
		}

		return requireds;
	}

}
