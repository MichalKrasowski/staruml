/**
 * <copyright>
 * </copyright>
 *
 * $Id: SDGateMessageImpl.java,v 1.1 2010/09/24 00:18:37 administrator Exp $
 */
package org.eclipse.uml2.diagram.sequence.model.sequenced.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.uml2.diagram.sequence.model.sequenced.SDGate;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDGateMessage;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDGateMessageEnd;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gate Message</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.uml2.diagram.sequence.model.sequenced.impl.SDGateMessageImpl#isFromNotToGate <em>From Not To Gate</em>}</li>
 *   <li>{@link org.eclipse.uml2.diagram.sequence.model.sequenced.impl.SDGateMessageImpl#getGate <em>Gate</em>}</li>
 *   <li>{@link org.eclipse.uml2.diagram.sequence.model.sequenced.impl.SDGateMessageImpl#getNormalEnd <em>Normal End</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SDGateMessageImpl extends SDAbstractMessageImpl implements SDGateMessage {
	/**
	 * The default value of the '{@link #isFromNotToGate() <em>From Not To Gate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFromNotToGate()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FROM_NOT_TO_GATE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isFromNotToGate() <em>From Not To Gate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFromNotToGate()
	 * @generated
	 * @ordered
	 */
	protected boolean fromNotToGate = FROM_NOT_TO_GATE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getGate() <em>Gate</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGate()
	 * @generated
	 * @ordered
	 */
	protected SDGate gate;

	/**
	 * The cached value of the '{@link #getNormalEnd() <em>Normal End</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNormalEnd()
	 * @generated
	 * @ordered
	 */
	protected SDGateMessageEnd normalEnd;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SDGateMessageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SDPackage.Literals.SD_GATE_MESSAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isFromNotToGate() {
		return fromNotToGate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFromNotToGate(boolean newFromNotToGate) {
		boolean oldFromNotToGate = fromNotToGate;
		fromNotToGate = newFromNotToGate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SDPackage.SD_GATE_MESSAGE__FROM_NOT_TO_GATE, oldFromNotToGate, fromNotToGate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SDGate getGate() {
		if (gate != null && gate.eIsProxy()) {
			InternalEObject oldGate = (InternalEObject)gate;
			gate = (SDGate)eResolveProxy(oldGate);
			if (gate != oldGate) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SDPackage.SD_GATE_MESSAGE__GATE, oldGate, gate));
			}
		}
		return gate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SDGate basicGetGate() {
		return gate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGate(SDGate newGate) {
		SDGate oldGate = gate;
		gate = newGate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SDPackage.SD_GATE_MESSAGE__GATE, oldGate, gate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SDGateMessageEnd getNormalEnd() {
		if (normalEnd != null && normalEnd.eIsProxy()) {
			InternalEObject oldNormalEnd = (InternalEObject)normalEnd;
			normalEnd = (SDGateMessageEnd)eResolveProxy(oldNormalEnd);
			if (normalEnd != oldNormalEnd) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SDPackage.SD_GATE_MESSAGE__NORMAL_END, oldNormalEnd, normalEnd));
			}
		}
		return normalEnd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SDGateMessageEnd basicGetNormalEnd() {
		return normalEnd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNormalEnd(SDGateMessageEnd newNormalEnd) {
		SDGateMessageEnd oldNormalEnd = normalEnd;
		normalEnd = newNormalEnd;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SDPackage.SD_GATE_MESSAGE__NORMAL_END, oldNormalEnd, normalEnd));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SDPackage.SD_GATE_MESSAGE__FROM_NOT_TO_GATE:
				return isFromNotToGate() ? Boolean.TRUE : Boolean.FALSE;
			case SDPackage.SD_GATE_MESSAGE__GATE:
				if (resolve) return getGate();
				return basicGetGate();
			case SDPackage.SD_GATE_MESSAGE__NORMAL_END:
				if (resolve) return getNormalEnd();
				return basicGetNormalEnd();
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
			case SDPackage.SD_GATE_MESSAGE__FROM_NOT_TO_GATE:
				setFromNotToGate(((Boolean)newValue).booleanValue());
				return;
			case SDPackage.SD_GATE_MESSAGE__GATE:
				setGate((SDGate)newValue);
				return;
			case SDPackage.SD_GATE_MESSAGE__NORMAL_END:
				setNormalEnd((SDGateMessageEnd)newValue);
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
			case SDPackage.SD_GATE_MESSAGE__FROM_NOT_TO_GATE:
				setFromNotToGate(FROM_NOT_TO_GATE_EDEFAULT);
				return;
			case SDPackage.SD_GATE_MESSAGE__GATE:
				setGate((SDGate)null);
				return;
			case SDPackage.SD_GATE_MESSAGE__NORMAL_END:
				setNormalEnd((SDGateMessageEnd)null);
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
			case SDPackage.SD_GATE_MESSAGE__FROM_NOT_TO_GATE:
				return fromNotToGate != FROM_NOT_TO_GATE_EDEFAULT;
			case SDPackage.SD_GATE_MESSAGE__GATE:
				return gate != null;
			case SDPackage.SD_GATE_MESSAGE__NORMAL_END:
				return normalEnd != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (fromNotToGate: ");
		result.append(fromNotToGate);
		result.append(')');
		return result.toString();
	}

} //SDGateMessageImpl
