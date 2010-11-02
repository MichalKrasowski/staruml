/*
 * Copyright (c) 2008 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Michael Golubev (Borland) - initial API and implementation
 */
package org.eclipse.uml2.diagram.common.editpolicies;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest;

/**
 * @see #237059
 */
public class MoveRequestWithParentInfo extends MoveRequest {
	private final Map<EObject, EObject> myElement2ActualParent = new HashMap<EObject, EObject>();

	public MoveRequestWithParentInfo(TransactionalEditingDomain editingDomain, EObject targetContainer, EObject elementToMove) {
		super(editingDomain, targetContainer, elementToMove);
	}
	
	public void registerActualContainer(EObject elementToMove, EObject actualContainer){
		if (actualContainer != null){
			myElement2ActualParent.put(elementToMove, actualContainer);
		} else {
			myElement2ActualParent.remove(elementToMove);
		}
	}
	
	public EObject getActualContainer(EObject movedElement){
		return myElement2ActualParent.get(movedElement);
	}

}
