/**
 * <copyright>
 * </copyright>
 *
 * $Id: SDExecutionImpl.java,v 1.1 2010/09/24 00:18:37 administrator Exp $
 */
package org.eclipse.uml2.diagram.sequence.model.sequenced.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.uml2.diagram.sequence.model.sequenced.SDExecution;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDInvocation;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDMessage;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Execution</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.uml2.diagram.sequence.model.sequenced.impl.SDExecutionImpl#getInvocation <em>Invocation</em>}</li>
 *   <li>{@link org.eclipse.uml2.diagram.sequence.model.sequenced.impl.SDExecutionImpl#getIncomingMessage <em>Incoming Message</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SDExecutionImpl extends SDBehaviorSpecImpl implements SDExecution {
	/**
	 * The cached value of the '{@link #getInvocation() <em>Invocation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInvocation()
	 * @generated
	 * @ordered
	 */
	protected SDInvocation invocation;

	/**
	 * The cached value of the '{@link #getIncomingMessage() <em>Incoming Message</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncomingMessage()
	 * @generated
	 * @ordered
	 */
	protected SDMessage incomingMessage;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SDExecutionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SDPackage.Literals.SD_EXECUTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SDInvocation getInvocation() {
		if (invocation != null && invocation.eIsProxy()) {
			InternalEObject oldInvocation = (InternalEObject)invocation;
			invocation = (SDInvocation)eResolveProxy(oldInvocation);
			if (invocation != oldInvocation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SDPackage.SD_EXECUTION__INVOCATION, oldInvocation, invocation));
			}
		}
		return invocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SDInvocation basicGetInvocation() {
		return invocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInvocation(SDInvocation newInvocation, NotificationChain msgs) {
		SDInvocation oldInvocation = invocation;
		invocation = newInvocation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SDPackage.SD_EXECUTION__INVOCATION, oldInvocation, newInvocation);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInvocation(SDInvocation newInvocation) {
		if (newInvocation != invocation) {
			NotificationChain msgs = null;
			if (invocation != null)
				msgs = ((InternalEObject)invocation).eInverseRemove(this, SDPackage.SD_INVOCATION__RECEIVE_EXECUTION, SDInvocation.class, msgs);
			if (newInvocation != null)
				msgs = ((InternalEObject)newInvocation).eInverseAdd(this, SDPackage.SD_INVOCATION__RECEIVE_EXECUTION, SDInvocation.class, msgs);
			msgs = basicSetInvocation(newInvocation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SDPackage.SD_EXECUTION__INVOCATION, newInvocation, newInvocation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SDMessage getIncomingMessage() {
		if (incomingMessage != null && incomingMessage.eIsProxy()) {
			InternalEObject oldIncomingMessage = (InternalEObject)incomingMessage;
			incomingMessage = (SDMessage)eResolveProxy(oldIncomingMessage);
			if (incomingMessage != oldIncomingMessage) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SDPackage.SD_EXECUTION__INCOMING_MESSAGE, oldIncomingMessage, incomingMessage));
			}
		}
		return incomingMessage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SDMessage basicGetIncomingMessage() {
		return incomingMessage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIncomingMessage(SDMessage newIncomingMessage, NotificationChain msgs) {
		SDMessage oldIncomingMessage = incomingMessage;
		incomingMessage = newIncomingMessage;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SDPackage.SD_EXECUTION__INCOMING_MESSAGE, oldIncomingMessage, newIncomingMessage);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIncomingMessage(SDMessage newIncomingMessage) {
		if (newIncomingMessage != incomingMessage) {
			NotificationChain msgs = null;
			if (incomingMessage != null)
				msgs = ((InternalEObject)incomingMessage).eInverseRemove(this, SDPackage.SD_MESSAGE__TARGET, SDMessage.class, msgs);
			if (newIncomingMessage != null)
				msgs = ((InternalEObject)newIncomingMessage).eInverseAdd(this, SDPackage.SD_MESSAGE__TARGET, SDMessage.class, msgs);
			msgs = basicSetIncomingMessage(newIncomingMessage, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SDPackage.SD_EXECUTION__INCOMING_MESSAGE, newIncomingMessage, newIncomingMessage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SDPackage.SD_EXECUTION__INVOCATION:
				if (invocation != null)
					msgs = ((InternalEObject)invocation).eInverseRemove(this, SDPackage.SD_INVOCATION__RECEIVE_EXECUTION, SDInvocation.class, msgs);
				return basicSetInvocation((SDInvocation)otherEnd, msgs);
			case SDPackage.SD_EXECUTION__INCOMING_MESSAGE:
				if (incomingMessage != null)
					msgs = ((InternalEObject)incomingMessage).eInverseRemove(this, SDPackage.SD_MESSAGE__TARGET, SDMessage.class, msgs);
				return basicSetIncomingMessage((SDMessage)otherEnd, msgs);
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
			case SDPackage.SD_EXECUTION__INVOCATION:
				return basicSetInvocation(null, msgs);
			case SDPackage.SD_EXECUTION__INCOMING_MESSAGE:
				return basicSetIncomingMessage(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SDPackage.SD_EXECUTION__INVOCATION:
				if (resolve) return getInvocation();
				return basicGetInvocation();
			case SDPackage.SD_EXECUTION__INCOMING_MESSAGE:
				if (resolve) return getIncomingMessage();
				return basicGetIncomingMessage();
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
			case SDPackage.SD_EXECUTION__INVOCATION:
				setInvocation((SDInvocation)newValue);
				return;
			case SDPackage.SD_EXECUTION__INCOMING_MESSAGE:
				setIncomingMessage((SDMessage)newValue);
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
			case SDPackage.SD_EXECUTION__INVOCATION:
				setInvocation((SDInvocation)null);
				return;
			case SDPackage.SD_EXECUTION__INCOMING_MESSAGE:
				setIncomingMessage((SDMessage)null);
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
			case SDPackage.SD_EXECUTION__INVOCATION:
				return invocation != null;
			case SDPackage.SD_EXECUTION__INCOMING_MESSAGE:
				return incomingMessage != null;
		}
		return super.eIsSet(featureID);
	}

} //SDExecutionImpl
