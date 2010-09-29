/*
 * Copyright (c) 2005, 2009 IBM Corporation, Embarcadero Technologies, and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - initial API and implementation
 *   Kenn Hussey (Embarcadero Technologies) - 247980
 *
 * $Id: GenPackageImpl.java,v 1.1 2010/09/17 05:33:34 administrator Exp $
 */
package org.eclipse.uml2.codegen.ecore.genmodel.impl;

import org.eclipse.emf.codegen.ecore.genmodel.GenResourceKind;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.uml2.codegen.ecore.genmodel.GenBase;
import org.eclipse.uml2.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.uml2.codegen.ecore.genmodel.GenPackage;
import org.eclipse.uml2.codegen.ecore.genmodel.util.UML2GenModelUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gen Package</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.uml2.codegen.ecore.genmodel.impl.GenPackageImpl#isResourceInterfaces <em>Resource Interfaces</em>}</li>
 *   <li>{@link org.eclipse.uml2.codegen.ecore.genmodel.impl.GenPackageImpl#getOperationsPackage <em>Operations Package</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GenPackageImpl
		extends org.eclipse.emf.codegen.ecore.genmodel.impl.GenPackageImpl
		implements GenPackage {

	/**
	 * The default value of the '{@link #isResourceInterfaces() <em>Resource Interfaces</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isResourceInterfaces()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RESOURCE_INTERFACES_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isResourceInterfaces() <em>Resource Interfaces</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isResourceInterfaces()
	 * @generated
	 * @ordered
	 */
	protected static final int RESOURCE_INTERFACES_EFLAG = 1 << 8;

	/**
	 * The default value of the '{@link #getOperationsPackage() <em>Operations Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperationsPackage()
	 * @generated
	 * @ordered
	 */
	protected static final String OPERATIONS_PACKAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOperationsPackage() <em>Operations Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperationsPackage()
	 * @generated
	 * @ordered
	 */
	protected String operationsPackage = OPERATIONS_PACKAGE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int EOFFSET_CORRECTION = GenModelPackage.Literals.GEN_PACKAGE
		.getFeatureID(GenModelPackage.Literals.GEN_PACKAGE__RESOURCE_INTERFACES)
		- GenModelPackage.GEN_PACKAGE__RESOURCE_INTERFACES;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenPackageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GenModelPackage.Literals.GEN_PACKAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isResourceInterfaces() {
		return (eFlags & RESOURCE_INTERFACES_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceInterfaces(boolean newResourceInterfaces) {
		boolean oldResourceInterfaces = (eFlags & RESOURCE_INTERFACES_EFLAG) != 0;
		if (newResourceInterfaces)
			eFlags |= RESOURCE_INTERFACES_EFLAG;
		else
			eFlags &= ~RESOURCE_INTERFACES_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				GenModelPackage.GEN_PACKAGE__RESOURCE_INTERFACES
					+ EOFFSET_CORRECTION, oldResourceInterfaces,
				newResourceInterfaces));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOperationsPackage() {
		return operationsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperationsPackage(String newOperationsPackage) {
		String oldOperationsPackage = operationsPackage;
		operationsPackage = newOperationsPackage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				GenModelPackage.GEN_PACKAGE__OPERATIONS_PACKAGE
					+ EOFFSET_CORRECTION, oldOperationsPackage,
				operationsPackage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID - EOFFSET_CORRECTION) {
			case GenModelPackage.GEN_PACKAGE__RESOURCE_INTERFACES :
				return isResourceInterfaces();
			case GenModelPackage.GEN_PACKAGE__OPERATIONS_PACKAGE :
				return getOperationsPackage();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID - EOFFSET_CORRECTION) {
			case GenModelPackage.GEN_PACKAGE__RESOURCE_INTERFACES :
				setResourceInterfaces((Boolean) newValue);
				return;
			case GenModelPackage.GEN_PACKAGE__OPERATIONS_PACKAGE :
				setOperationsPackage((String) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID - EOFFSET_CORRECTION) {
			case GenModelPackage.GEN_PACKAGE__RESOURCE_INTERFACES :
				setResourceInterfaces(RESOURCE_INTERFACES_EDEFAULT);
				return;
			case GenModelPackage.GEN_PACKAGE__OPERATIONS_PACKAGE :
				setOperationsPackage(OPERATIONS_PACKAGE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID - EOFFSET_CORRECTION) {
			case GenModelPackage.GEN_PACKAGE__RESOURCE_INTERFACES :
				return ((eFlags & RESOURCE_INTERFACES_EFLAG) != 0) != RESOURCE_INTERFACES_EDEFAULT;
			case GenModelPackage.GEN_PACKAGE__OPERATIONS_PACKAGE :
				return OPERATIONS_PACKAGE_EDEFAULT == null
					? operationsPackage != null
					: !OPERATIONS_PACKAGE_EDEFAULT.equals(operationsPackage);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == GenBase.class) {
			switch (baseFeatureID) {
				default :
					return -1;
			}
		}
		if (baseClass == GenPackage.class) {
			switch (baseFeatureID - EOFFSET_CORRECTION) {
				case GenModelPackage.GEN_PACKAGE__RESOURCE_INTERFACES :
					return GenModelPackage.GEN_PACKAGE__RESOURCE_INTERFACES
						+ EOFFSET_CORRECTION;
				case GenModelPackage.GEN_PACKAGE__OPERATIONS_PACKAGE :
					return GenModelPackage.GEN_PACKAGE__OPERATIONS_PACKAGE
						+ EOFFSET_CORRECTION;
				default :
					return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (resourceInterfaces: "); //$NON-NLS-1$
		result.append((eFlags & RESOURCE_INTERFACES_EFLAG) != 0);
		result.append(", operationsPackage: "); //$NON-NLS-1$
		result.append(operationsPackage);
		result.append(')');
		return result.toString();
	}

	public String getOperationsPackageName() {
		String operationsPackageName = getOperationsPackage();

		return isBlank(operationsPackageName)
			? getClassPackageName() + ".operations" //$NON-NLS-1$
			: operationsPackageName;
	}

	public boolean isOperationsClasses() {
		return !isBlank(getOperationsPackage());
	}

	public String getResourceInterfaceName() {
		return getPrefixedName("Resource"); //$NON-NLS-1$
	}

	public String getQualifiedResourceInterfaceName() {
		return getUtilitiesPackageName() + "." + getResourceInterfaceName(); //$NON-NLS-1$
	}

	public String getImportedResourceInterfaceName() {
		return getGenModel().getImportedName(
			getQualifiedResourceInterfaceName());
	}

	public String getImportedResourceBaseInterfaceName() {
		switch (getResource().getValue()) {
			case GenResourceKind.XML :
				return getGenModel().getImportedName(
					"org.eclipse.emf.ecore.xmi.XMLResource"); //$NON-NLS-1$
			case GenResourceKind.XMI :
				return getGenModel().getImportedName(
					"org.eclipse.emf.ecore.xmi.XMIResource"); //$NON-NLS-1$
			default :
				return getGenModel().getImportedName(
					"org.eclipse.emf.ecore.resource.Resource"); //$NON-NLS-1$
		}
	}

	public String getImportedResourceFactoryInterfaceName() {
		return getImportedResourceInterfaceName() + ".Factory"; //$NON-NLS-1$
	}

	public String getImportedResourceFactoryBaseInterfaceName() {
		return getGenModel().getImportedName(
			"org.eclipse.emf.ecore.resource.Resource") //$NON-NLS-1$
			+ ".Factory"; //$NON-NLS-1$
	}

	@Override
	public String getImportedResourceBaseClassName() {
		return isResourceInterfaces()
			? super.getImportedResourceBaseClassName() + " implements " //$NON-NLS-1$
				+ getImportedResourceInterfaceName()
			: super.getImportedResourceBaseClassName();
	}

	@Override
	public String getImportedResourceFactoryBaseClassName() {
		return isResourceInterfaces()
			? super.getImportedResourceFactoryBaseClassName() + " implements " //$NON-NLS-1$
				+ getImportedResourceFactoryInterfaceName()
			: super.getImportedResourceFactoryBaseClassName();
	}

	public boolean isXMLResource() {
		switch (getResource().getValue()) {
			case GenResourceKind.XMI :
			case GenResourceKind.XML :
				return true;
			default :
				return false;
		}
	}

	@Override
	protected void reconcileSettings(
			org.eclipse.emf.codegen.ecore.genmodel.GenPackage oldGenPackageVersion) {
		super.reconcileSettings(oldGenPackageVersion);

		setOperationsPackage(UML2GenModelUtil
			.getOperationsPackage(oldGenPackageVersion));
		setResourceInterfaces(UML2GenModelUtil
			.isResourceInterfaces(oldGenPackageVersion));
	}

} // GenPackageImpl
