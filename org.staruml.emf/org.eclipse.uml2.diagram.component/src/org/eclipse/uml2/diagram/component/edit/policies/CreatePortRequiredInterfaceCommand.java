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

package org.eclipse.uml2.diagram.component.edit.policies;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateRelationshipCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.Usage;

/**
 * @NOT-GENERATED
 */
class CreatePortRequiredInterfaceCommand extends CreateRelationshipCommand {

	public CreatePortRequiredInterfaceCommand(CreateRelationshipRequest request) {
		super(request);
	}
	
	@Override
	public boolean canExecute() {
		Port port = (Port)getSource();
		Type portType = port.getType();
		if (portType instanceof Classifier){
			Classifier classifier = (Classifier)portType;
			return !classifier.getAllUsedInterfaces().contains(getTarget());
		}
		return false;
	}

	protected EObject doDefaultElementCreation() {
		Port port = (Port)getSource();
		Type portType = port.getType();
		Usage usage = null;
		if (portType instanceof Classifier){
			Classifier classifier = (Classifier)portType;
			org.eclipse.uml2.uml.Package pakkage = port.getNearestPackage();
			usage = (Usage) pakkage.createPackagedElement(null, UMLPackage.Literals.USAGE);
			usage.getClients().add(classifier);
			usage.getSuppliers().add((Interface)getTarget());
		}
		return usage;
	}

}
