/*
 * Copyright (c) 2005, 2006 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - initial API and implementation
 *
 * $Id: GenTypedElementImpl.java,v 1.1 2010/09/17 05:33:34 administrator Exp $
 */
package org.eclipse.uml2.codegen.ecore.genmodel.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.uml2.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.uml2.codegen.ecore.genmodel.GenTypedElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gen Typed Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class GenTypedElementImpl
		extends org.eclipse.emf.codegen.ecore.genmodel.impl.GenTypedElementImpl
		implements GenTypedElement {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenTypedElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GenModelPackage.Literals.GEN_TYPED_ELEMENT;
	}

} //GenTypedElementImpl
