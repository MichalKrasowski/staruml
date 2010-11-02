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

import org.eclipse.uml2.uml.Actor;
import org.eclipse.uml2.uml.Artifact;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.UseCase;


public class ClassifierAppliedStereotypeParser extends AppliedStereotypeParser {
	private static final String INTERFACE_LABEL = "interface"; //$NON-NLS-1$
	private static final String DATATYPE_LABEL = "dataType"; //$NON-NLS-1$
	private static final String PRIMITIVETYPE_LABEL = "primitive"; //$NON-NLS-1$
	private static final String ENUMERATION_LABEL = "enumeration"; //$NON-NLS-1$
	private static final String COMPONENT_LABEL = "component"; //$NON-NLS-1$
	private static final String ARTIFACT_LABEL = "artifact"; //$NON-NLS-1$
	private static final String USECASE_LABEL = "usecase"; //$NON-NLS-1$
	private static final String ACTOR_LABEL = "actor"; //$NON-NLS-1$

	@Override
	protected String getElementLabel(Element element) {
		if (element instanceof Interface) {
			return INTERFACE_LABEL;
		}
		if (element instanceof PrimitiveType) {
			return PRIMITIVETYPE_LABEL;
		}
		if (element instanceof Enumeration) {
			return ENUMERATION_LABEL;
		}
		if (element instanceof DataType) {
			return DATATYPE_LABEL;
		}
		if (element instanceof Component) {
			return COMPONENT_LABEL;
		}
		if (element instanceof Artifact) {
			return ARTIFACT_LABEL;
		}
		if (element instanceof UseCase) {
			return USECASE_LABEL;
		}
		if (element instanceof Actor) {
			return ACTOR_LABEL;
		}
		return null;
	}

}
