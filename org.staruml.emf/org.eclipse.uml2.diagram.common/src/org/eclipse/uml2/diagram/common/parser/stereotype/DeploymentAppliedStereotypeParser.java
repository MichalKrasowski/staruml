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

import org.eclipse.uml2.uml.DeploymentSpecification;
import org.eclipse.uml2.uml.Device;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ExecutionEnvironment;
import org.eclipse.uml2.uml.Node;


public class DeploymentAppliedStereotypeParser extends ClassifierAppliedStereotypeParser {
	private static final String DEVICE_LABEL = "device"; //$NON-NLS-1$
	private static final String EXECUTION_ENVIRONMENT_LABEL = "executionEnvironment"; //$NON-NLS-1$
	private static final String DEPLOYMENT_SPECIFICATION_LABEL = "deployment spec"; //$NON-NLS-1$
	private static final String NODE_LABEL = null;

	@Override
	protected String getElementLabel(Element element) {
		if (element instanceof Device) {
			return DEVICE_LABEL;
		}
		if (element instanceof DeploymentSpecification) {
			return DEPLOYMENT_SPECIFICATION_LABEL;
		}
		if (element instanceof ExecutionEnvironment) {
			return EXECUTION_ENVIRONMENT_LABEL;
		}
		if (element instanceof Node) {
			return NODE_LABEL;
		}
		return super.getElementLabel(element);
	}

}
