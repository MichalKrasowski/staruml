/**
 * <copyright>
 * </copyright>
 *
 * $Id: SDAbstractMessageImpl.java,v 1.1 2010/09/24 00:18:36 administrator Exp $
 */
package org.eclipse.uml2.diagram.sequence.model.sequenced.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.uml2.diagram.sequence.model.sequenced.SDAbstractMessage;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDModel;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDPackage;

import org.eclipse.uml2.uml.Message;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Message</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.uml2.diagram.sequence.model.sequenced.impl.SDAbstractMessageImpl#getUmlMessage <em>Uml Message</em>}</li>
 *   <li>{@link org.eclipse.uml2.diagram.sequence.model.sequenced.impl.SDAbstractMessageImpl#getModel <em>Model</em>}</li>
 *   <li>{@link org.eclipse.uml2.diagram.sequence.model.sequenced.impl.SDAbstractMessageImpl#getMessageNumber <em>Message Number</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class SDAbstractMessageImpl extends EObjectImpl implements SDAbstractMessage {
	/**
	 * The cached value of the '{@link #getUmlMessage() <em>Uml Message</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUmlMessage()
	 * @generated
	 * @ordered
	 */
	protected Message umlMessage;

	/**
	 * The default value of the '{@link #getMessageNumber() <em>Message Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessageNumber()
	 * @generated
	 * @ordered
	 */
	protected static final String MESSAGE_NUMBER_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getMessageNumber() <em>Message Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessageNumber()
	 * @generated
	 * @ordered
	 */
	protected String messageNumber = MESSAGE_NUMBER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SDAbstractMessageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SDPackage.Literals.SD_ABSTRACT_MESSAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Message getUmlMessage() {
		if (umlMessage != null && ((EObject)umlMessage).eIsProxy()) {
			InternalEObject oldUmlMessage = (InternalEObject)umlMessage;
			umlMessage = (Message)eResolveProxy(oldUmlMessage);
			if (umlMessage != oldUmlMessage) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SDPackage.SD_ABSTRACT_MESSAGE__UML_MESSAGE, oldUmlMessage, umlMessage));
			}
		}
		return umlMessage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Message basicGetUmlMessage() {
		return umlMessage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUmlMessage(Message newUmlMessage) {
		Message oldUmlMessage = umlMessage;
		umlMessage = newUmlMessage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SDPackage.SD_ABSTRACT_MESSAGE__UML_MESSAGE, oldUmlMessage, umlMessage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SDModel getModel() {
		if (eContainerFeatureID != SDPackage.SD_ABSTRACT_MESSAGE__MODEL) return null;
		return (SDModel)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMessageNumber() {
		return messageNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMessageNumber(String newMessageNumber) {
		String oldMessageNumber = messageNumber;
		messageNumber = newMessageNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SDPackage.SD_ABSTRACT_MESSAGE__MESSAGE_NUMBER, oldMessageNumber, messageNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SDPackage.SD_ABSTRACT_MESSAGE__MODEL:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return eBasicSetContainer(otherEnd, SDPackage.SD_ABSTRACT_MESSAGE__MODEL, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SDPackage.SD_ABSTRACT_MESSAGE__MODEL:
				return eBasicSetContainer(null, SDPackage.SD_ABSTRACT_MESSAGE__MODEL, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID) {
			case SDPackage.SD_ABSTRACT_MESSAGE__MODEL:
				return eInternalContainer().eInverseRemove(this, SDPackage.SD_MODEL__MESSAGES, SDModel.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SDPackage.SD_ABSTRACT_MESSAGE__UML_MESSAGE:
				if (resolve) return getUmlMessage();
				return basicGetUmlMessage();
			case SDPackage.SD_ABSTRACT_MESSAGE__MODEL:
				return getModel();
			case SDPackage.SD_ABSTRACT_MESSAGE__MESSAGE_NUMBER:
				return getMessageNumber();
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
			case SDPackage.SD_ABSTRACT_MESSAGE__UML_MESSAGE:
				setUmlMessage((Message)newValue);
				return;
			case SDPackage.SD_ABSTRACT_MESSAGE__MESSAGE_NUMBER:
				setMessageNumber((String)newValue);
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
			case SDPackage.SD_ABSTRACT_MESSAGE__UML_MESSAGE:
				setUmlMessage((Message)null);
				return;
			case SDPackage.SD_ABSTRACT_MESSAGE__MESSAGE_NUMBER:
				setMessageNumber(MESSAGE_NUMBER_EDEFAULT);
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
			case SDPackage.SD_ABSTRACT_MESSAGE__UML_MESSAGE:
				return umlMessage != null;
			case SDPackage.SD_ABSTRACT_MESSAGE__MODEL:
				return getModel() != null;
			case SDPackage.SD_ABSTRACT_MESSAGE__MESSAGE_NUMBER:
				return MESSAGE_NUMBER_EDEFAULT == null ? messageNumber != null : !MESSAGE_NUMBER_EDEFAULT.equals(messageNumber);
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
		result.append(" (messageNumber: ");
		result.append(messageNumber);
		result.append(')');
		return result.toString();
	}

} //SDAbstractMessageImpl
