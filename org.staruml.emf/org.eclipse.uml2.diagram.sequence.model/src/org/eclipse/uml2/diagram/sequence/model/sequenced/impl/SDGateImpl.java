/**
 * <copyright>
 * </copyright>
 *
 * $Id: SDGateImpl.java,v 1.1 2010/09/24 00:18:36 administrator Exp $
 */
package org.eclipse.uml2.diagram.sequence.model.sequenced.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.uml2.diagram.sequence.model.sequenced.SDGate;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDPackage;

import org.eclipse.uml2.uml.Gate;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gate</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.uml2.diagram.sequence.model.sequenced.impl.SDGateImpl#getUmlGate <em>Uml Gate</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SDGateImpl extends EObjectImpl implements SDGate {
	/**
	 * The cached value of the '{@link #getUmlGate() <em>Uml Gate</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUmlGate()
	 * @generated
	 * @ordered
	 */
	protected Gate umlGate;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SDGateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SDPackage.Literals.SD_GATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Gate getUmlGate() {
		if (umlGate != null && ((EObject)umlGate).eIsProxy()) {
			InternalEObject oldUmlGate = (InternalEObject)umlGate;
			umlGate = (Gate)eResolveProxy(oldUmlGate);
			if (umlGate != oldUmlGate) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SDPackage.SD_GATE__UML_GATE, oldUmlGate, umlGate));
			}
		}
		return umlGate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Gate basicGetUmlGate() {
		return umlGate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUmlGate(Gate newUmlGate) {
		Gate oldUmlGate = umlGate;
		umlGate = newUmlGate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SDPackage.SD_GATE__UML_GATE, oldUmlGate, umlGate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SDPackage.SD_GATE__UML_GATE:
				if (resolve) return getUmlGate();
				return basicGetUmlGate();
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
		switch (featureID) {
			case SDPackage.SD_GATE__UML_GATE:
				setUmlGate((Gate)newValue);
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
		switch (featureID) {
			case SDPackage.SD_GATE__UML_GATE:
				setUmlGate((Gate)null);
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
		switch (featureID) {
			case SDPackage.SD_GATE__UML_GATE:
				return umlGate != null;
		}
		return super.eIsSet(featureID);
	}

} //SDGateImpl
