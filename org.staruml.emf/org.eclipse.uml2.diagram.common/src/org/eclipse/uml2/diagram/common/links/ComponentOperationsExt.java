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
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.ComponentRealization;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.InterfaceRealization;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Realization;
import org.eclipse.uml2.uml.Usage;

/**
 * The class repeats the functionality of
 * org.eclipse.uml2.uml.internal.operations.ComponentOperations class
 * for Provided and Required interfaces, providing additional info that required
 * to manage (create/delete/reorient) Provided/Required interface links.
 **/

public class ComponentOperationsExt {

	public static List<ProvidedInterfaceLink> realizedInterfaces(Component component, Classifier classifier) {
		return Collections.unmodifiableList(realizedInterfaces(component, classifier, true));
	}

	protected static List<ProvidedInterfaceLink> realizedInterfaces(Component component, Classifier classifier, boolean resolve) {
		List<ProvidedInterfaceLink> realizedInterfaces = new LinkedList<ProvidedInterfaceLink>();
		for (Dependency clientDependency : classifier.getClientDependencies()) {

			if (clientDependency instanceof Realization) {
				Iterator<NamedElement> suppliers = resolve ? clientDependency.getSuppliers().iterator() : ((InternalEList<NamedElement>) clientDependency.getSuppliers()).basicIterator();

				while (suppliers.hasNext()) {
					NamedElement supplier = suppliers.next();

					if (supplier instanceof Interface) {
						realizedInterfaces.add(new ProvidedInterfaceLink((InterfaceRealization) clientDependency, classifier, (Interface) supplier));
						continue;
					}
				}
			}
		}

		return realizedInterfaces;
	}

	protected static Collection<RequiredInterfaceLink> usedInterfaces(Component component, Classifier classifier, boolean resolve) {
		Set<RequiredInterfaceLink> usedInterfaces = new HashSet<RequiredInterfaceLink>();
		for (Dependency clientDependency : classifier.getClientDependencies()) {

			if (clientDependency instanceof Usage) {
				Iterator<NamedElement> suppliers = resolve ? clientDependency.getSuppliers().iterator() : ((InternalEList<NamedElement>) clientDependency.getSuppliers()).basicIterator();

				while (suppliers.hasNext()) {
					NamedElement supplier = suppliers.next();

					if (supplier instanceof Interface) {
						usedInterfaces.add(new RequiredInterfaceLink((Usage) clientDependency, classifier, (Interface) supplier));
					}
				}
			}
		}

		return usedInterfaces;
	}

	public static Collection<RequiredInterfaceLink> getRequireds(Component component) {
		Set<RequiredInterfaceLink> requireds = new HashSet<RequiredInterfaceLink>();
		requireds.addAll(usedInterfaces(component, component, false));

		for (ComponentRealization realization : component.getRealizations()) {

			for (Classifier realizingClassifier : realization.getRealizingClassifiers()) {
				if (realizingClassifier != null) {
					requireds.addAll(usedInterfaces(component, realizingClassifier, false));

					for (Classifier parent : realizingClassifier.allParents()) {
						requireds.addAll(usedInterfaces(component, parent, false));
					}
				}
			}
		}

		for (Port ownedPort : component.getOwnedPorts()) {
			requireds.addAll(PortOperationsExt.getRequireds(ownedPort));
		}

		return requireds;
	}


	protected static EList<Interface> realizedInterfaces(Component component,
			Classifier classifier, boolean resolve,
			EList<Interface> realizedInterfaces) {

		for (Dependency clientDependency : classifier.getClientDependencies()) {

			if (clientDependency instanceof Realization) {
				Iterator<NamedElement> suppliers = resolve
					? clientDependency.getSuppliers().iterator()
					: ((InternalEList<NamedElement>) clientDependency
						.getSuppliers()).basicIterator();

				while (suppliers.hasNext()) {
					NamedElement supplier = suppliers.next();

					if (supplier instanceof Interface) {
						realizedInterfaces.add((Interface) supplier);
					}
				}
			}
		}

		return realizedInterfaces;
	}

}
