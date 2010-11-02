/*
 * Copyright (c) 2006, 2008 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Tatiana Fesenko (Borland) - initial API and implementation
 */
package org.eclipse.uml2.diagram.common.parser.stereotype;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.uml2.diagram.common.notation.u2tnotation.U2TNotationPackage;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;

public class PackageAppliedStereotypeParser extends ClassifierAppliedStereotypeParser {

	private static final String PACKAGE_LABEL = "package"; //$NON-NLS-1$

	private static final String MODEL_LABEL = "model"; //$NON-NLS-1$

	@Override
	protected String getElementLabel(Element element) {
		if (element instanceof Model) {
			return MODEL_LABEL;
		}
		return PACKAGE_LABEL;
	}

	//#265174 Visual distinction between Synchronized and Non-Sync diagrams
	//Refresh icon label, when diagram status is changed 
	@Override	
	public boolean isAffectingEvent(Object event, int flags) {
		if (super.isAffectingEvent(event, flags)) {
			return true;
		}
		if (event instanceof Notification) {
			Object feature = ((Notification) event).getFeature();
			EAttribute u2tfeature = U2TNotationPackage.eINSTANCE.getU2TDiagramCanonicalStyle_SyncNodes();
			return (feature == u2tfeature);
		}
		return false;
	}

}
