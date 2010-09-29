/**
 * <copyright>
 * </copyright>
 *
 * $Id: SDGateMessageEndImpl.java,v 1.1 2010/09/24 00:18:37 administrator Exp $
 */
package org.eclipse.uml2.diagram.sequence.model.sequenced.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.uml2.diagram.sequence.model.sequenced.SDGateMessageEnd;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDPackage;

import org.eclipse.uml2.uml.OccurrenceSpecification;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gate Message End</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.uml2.diagram.sequence.model.sequenced.impl.SDGateMessageEndImpl#getUmlMessageEnd <em>Uml Message End</em>}</li>
 *   <li>{@link org.eclipse.uml2.diagram.sequence.model.sequenced.impl.SDGateMessageEndImpl#isIsStartNotFinish <em>Is Start Not Finish</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SDGateMessageEndImpl extends SDBracketImpl implements SDGateMessageEnd {
	/**
	 * The cached value of the '{@link #getUmlMessageEnd() <em>Uml Message End</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUmlMessageEnd()
	 * @generated
	 * @ordered
	 */
	protected OccurrenceSpecification umlMessageEnd;

	/**
	 * The default value of the '{@link #isIsStartNotFinish() <em>Is Start Not Finish</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsStartNotFinish()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_START_NOT_FINISH_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isIsStartNotFinish() <em>Is Start Not Finish</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsStartNotFinish()
	 * @generated
	 * @ordered
	 */
	protected boolean isStartNotFinish = IS_START_NOT_FINISH_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SDGateMessageEndImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SDPackage.Literals.SD_GATE_MESSAGE_END;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OccurrenceSpecification getUmlMessageEnd() {
		if (umlMessageEnd != null && ((EObject)umlMessageEnd).eIsProxy()) {
			InternalEObject oldUmlMessageEnd = (InternalEObject)umlMessageEnd;
			umlMessageEnd = (OccurrenceSpecification)eResolveProxy(oldUmlMessageEnd);
			if (umlMessageEnd != oldUmlMessageEnd) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SDPackage.SD_GATE_MESSAGE_END__UML_MESSAGE_END, oldUmlMessageEnd, umlMessageEnd));
			}
		}
		return umlMessageEnd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OccurrenceSpecification basicGetUmlMessageEnd() {
		return umlMessageEnd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUmlMessageEnd(OccurrenceSpecification newUmlMessageEnd) {
		OccurrenceSpecification oldUmlMessageEnd = umlMessageEnd;
		umlMessageEnd = newUmlMessageEnd;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SDPackage.SD_GATE_MESSAGE_END__UML_MESSAGE_END, oldUmlMessageEnd, umlMessageEnd));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsStartNotFinish() {
		return isStartNotFinish;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsStartNotFinish(boolean newIsStartNotFinish) {
		boolean oldIsStartNotFinish = isStartNotFinish;
		isStartNotFinish = newIsStartNotFinish;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SDPackage.SD_GATE_MESSAGE_END__IS_START_NOT_FINISH, oldIsStartNotFinish, isStartNotFinish));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SDPackage.SD_GATE_MESSAGE_END__UML_MESSAGE_END:
				if (resolve) return getUmlMessageEnd();
				return basicGetUmlMessageEnd();
			case SDPackage.SD_GATE_MESSAGE_END__IS_START_NOT_FINISH:
				return isIsStartNotFinish() ? Boolean.TRUE : Boolean.FALSE;
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
			case SDPackage.SD_GATE_MESSAGE_END__UML_MESSAGE_END:
				setUmlMessageEnd((OccurrenceSpecification)newValue);
				return;
			case SDPackage.SD_GATE_MESSAGE_END__IS_START_NOT_FINISH:
				setIsStartNotFinish(((Boolean)newValue).booleanValue());
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
			case SDPackage.SD_GATE_MESSAGE_END__UML_MESSAGE_END:
				setUmlMessageEnd((OccurrenceSpecification)null);
				return;
			case SDPackage.SD_GATE_MESSAGE_END__IS_START_NOT_FINISH:
				setIsStartNotFinish(IS_START_NOT_FINISH_EDEFAULT);
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
			case SDPackage.SD_GATE_MESSAGE_END__UML_MESSAGE_END:
				return umlMessageEnd != null;
			case SDPackage.SD_GATE_MESSAGE_END__IS_START_NOT_FINISH:
				return isStartNotFinish != IS_START_NOT_FINISH_EDEFAULT;
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
		result.append(" (isStartNotFinish: ");
		result.append(isStartNotFinish);
		result.append(')');
		return result.toString();
	}

} //SDGateMessageEndImpl
