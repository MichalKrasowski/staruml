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

package org.eclipse.uml2.diagram.activity.providers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.AcceptEventAction;
import org.eclipse.uml2.uml.TimeEvent;
import org.eclipse.uml2.uml.Trigger;
import org.eclipse.uml2.uml.UMLFactory;

public class AcceptEventAction_2002_Initializer {
	public void init(EObject instance) {
		if (instance instanceof AcceptEventAction) {
			AcceptEventAction action = (AcceptEventAction) instance;
			org.eclipse.uml2.uml.Package pakkage = action.getNearestPackage();
			if (pakkage != null) {
				Trigger trigger = action.createTrigger(null);
				TimeEvent event = UMLFactory.eINSTANCE.createTimeEvent();
				pakkage.getPackagedElements().add(event);
				trigger.setEvent(event);
			}
		}
	}

}
