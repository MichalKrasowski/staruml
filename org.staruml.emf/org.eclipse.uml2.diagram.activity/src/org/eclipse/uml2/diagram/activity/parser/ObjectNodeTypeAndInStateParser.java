/*
 * Copyright (c) 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Sergey Gribovsky (Borland) - initial API and implementation
 */

package org.eclipse.uml2.diagram.activity.parser;

import java.util.Iterator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.ObjectNode;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.UMLPackage;

public class ObjectNodeTypeAndInStateParser extends ObjectNodeTypeParser {
	@Override
	public String getPrintString(IAdaptable element, int flags) {
		EObject eObject = (EObject)element.getAdapter(EObject.class);
		if (eObject instanceof ObjectNode) {
			EList<State> states = ((ObjectNode) eObject).getInStates();
			if (!states.isEmpty()) {
				StringBuffer printStringBuffer = new StringBuffer(super.getPrintString(element, flags));
				printStringBuffer.append("\n");
				printStringBuffer.append('[');
				for (Iterator<State> statesIterator = states.iterator(); statesIterator.hasNext();) {
					printStringBuffer.append(statesIterator.next().getName());
					if (statesIterator.hasNext()) {
						printStringBuffer.append(", "); //$NON-NLS-1$
					}
				}
				printStringBuffer.append(']');
				return printStringBuffer.toString();
			}
		}
		return super.getPrintString(element, flags);
	}

	public boolean isAffectingEvent(Object event, int flags) {
		if (event instanceof Notification) {
			Object feature = ((Notification) event).getFeature();
			return UMLPackage.eINSTANCE.getObjectNode_InState().equals(feature) ||
				super.isAffectingEvent(event, flags);
		}
		return false;
	}
}
