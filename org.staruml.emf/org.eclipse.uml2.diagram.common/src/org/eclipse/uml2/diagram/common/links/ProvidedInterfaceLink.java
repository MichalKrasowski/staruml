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

import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.InterfaceRealization;
import org.eclipse.uml2.uml.NamedElement;

public class ProvidedInterfaceLink {

	private final InterfaceRealization myRealization;

	private final NamedElement mySource;

	private final Interface myTarget;

	ProvidedInterfaceLink(InterfaceRealization realization, NamedElement source, Interface target) {
		myRealization = realization;
		mySource = source;
		myTarget = target;
	}

	public InterfaceRealization getRealization() {
		return myRealization;
	}

	public NamedElement getTarget() {
		return myTarget;
	}

	public NamedElement getSource() {
		return mySource;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (false == obj instanceof ProvidedInterfaceLink) {
			return false;
		}
		ProvidedInterfaceLink anotherLink = (ProvidedInterfaceLink) obj;
		return this.myRealization.equals(anotherLink.myRealization) && this.mySource.equals(anotherLink.mySource) && this.myTarget.equals(anotherLink.myTarget);
	}
	
	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append((myRealization != null) ? myRealization.getName() : null );
		result.append("("); //$NON-NLS-1$
		result.append((mySource != null) ? mySource.getName() : null );
		result.append(","); //$NON-NLS-1$
		result.append((myTarget != null) ? myTarget.getName() : null );
		result.append(")"); //$NON-NLS-1$
		return result.toString();
	}
	
}
