/**
 * <copyright>
 * </copyright>
 *
 * $Id: SDInvocationImpl.java,v 1.1 2010/09/24 00:18:37 administrator Exp $
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
 * An implementation of the model object '<em><b>Invocation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.uml2.diagram.sequence.model.sequenced.impl.SDInvocationImpl#getReceiveExecution <em>Receive Execution</em>}</li>
 *   <li>{@link org.eclipse.uml2.diagram.sequence.model.sequenced.impl.SDInvocationImpl#getOutgoingMessage <em>Outgoing Message</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SDInvocationImpl extends SDBehaviorSpecImpl implements SDInvocation {
	/**
	 * The cached value of the '{@link #getReceiveExecution() <em>Receive Execution</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReceiveExecution()
	 * @generated
	 * @ordered
	 */
	protected SDExecution receiveExecution;

	/**
	 * The cached value of the '{@link #getOutgoingMessage() <em>Outgoing Message</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutgoingMessage()
	 * @generated
	 * @ordered
	 */
	protected SDMessage outgoingMessage;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SDInvocationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SDPackage.Literals.SD_INVOCATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SDExecution getReceiveExecution() {
		if (receiveExecution != null && receiveExecution.eIsProxy()) {
			InternalEObject oldReceiveExecution = (InternalEObject)receiveExecution;
			receiveExecution = (SDExecution)eResolveProxy(oldReceiveExecution);
			if (receiveExecution != oldReceiveExecution) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SDPackage.SD_INVOCATION__RECEIVE_EXECUTION, oldReceiveExecution, receiveExecution));
			}
		}
		return receiveExecution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SDExecution basicGetReceiveExecution() {
		return receiveExecution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReceiveExecution(SDExecution newReceiveExecution, NotificationChain msgs) {
		SDExecution oldReceiveExecution = receiveExecution;
		receiveExecution = newReceiveExecution;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SDPackage.SD_INVOCATION__RECEIVE_EXECUTION, oldReceiveExecution, newReceiveExecution);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReceiveExecution(SDExecution newReceiveExecution) {
		if (newReceiveExecution != receiveExecution) {
			NotificationChain msgs = null;
			if (receiveExecution != null)
				msgs = ((InternalEObject)receiveExecution).eInverseRemove(this, SDPackage.SD_EXECUTION__INVOCATION, SDExecution.class, msgs);
			if (newReceiveExecution != null)
				msgs = ((InternalEObject)newReceiveExecution).eInverseAdd(this, SDPackage.SD_EXECUTION__INVOCATION, SDExecution.class, msgs);
			msgs = basicSetReceiveExecution(newReceiveExecution, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SDPackage.SD_INVOCATION__RECEIVE_EXECUTION, newReceiveExecution, newReceiveExecution));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SDMessage getOutgoingMessage() {
		if (outgoingMessage != null && outgoingMessage.eIsProxy()) {
			InternalEObject oldOutgoingMessage = (InternalEObject)outgoingMessage;
			outgoingMessage = (SDMessage)eResolveProxy(oldOutgoingMessage);
			if (outgoingMessage != oldOutgoingMessage) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SDPackage.SD_INVOCATION__OUTGOING_MESSAGE, oldOutgoingMessage, outgoingMessage));
			}
		}
		return outgoingMessage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SDMessage basicGetOutgoingMessage() {
		return outgoingMessage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutgoingMessage(SDMessage newOutgoingMessage, NotificationChain msgs) {
		SDMessage oldOutgoingMessage = outgoingMessage;
		outgoingMessage = newOutgoingMessage;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SDPackage.SD_INVOCATION__OUTGOING_MESSAGE, oldOutgoingMessage, newOutgoingMessage);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutgoingMessage(SDMessage newOutgoingMessage) {
		if (newOutgoingMessage != outgoingMessage) {
			NotificationChain msgs = null;
			if (outgoingMessage != null)
				msgs = ((InternalEObject)outgoingMessage).eInverseRemove(this, SDPackage.SD_MESSAGE__SOURCE, SDMessage.class, msgs);
			if (newOutgoingMessage != null)
				msgs = ((InternalEObject)newOutgoingMessage).eInverseAdd(this, SDPackage.SD_MESSAGE__SOURCE, SDMessage.class, msgs);
			msgs = basicSetOutgoingMessage(newOutgoingMessage, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SDPackage.SD_INVOCATION__OUTGOING_MESSAGE, newOutgoingMessage, newOutgoingMessage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SDPackage.SD_INVOCATION__RECEIVE_EXECUTION:
				if (receiveExecution != null)
					msgs = ((InternalEObject)receiveExecution).eInverseRemove(this, SDPackage.SD_EXECUTION__INVOCATION, SDExecution.class, msgs);
				return basicSetReceiveExecution((SDExecution)otherEnd, msgs);
			case SDPackage.SD_INVOCATION__OUTGOING_MESSAGE:
				if (outgoingMessage != null)
					msgs = ((InternalEObject)outgoingMessage).eInverseRemove(this, SDPackage.SD_MESSAGE__SOURCE, SDMessage.class, msgs);
				return basicSetOutgoingMessage((SDMessage)otherEnd, msgs);
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
			case SDPackage.SD_INVOCATION__RECEIVE_EXECUTION:
				return basicSetReceiveExecution(null, msgs);
			case SDPackage.SD_INVOCATION__OUTGOING_MESSAGE:
				return basicSetOutgoingMessage(null, msgs);
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
			case SDPackage.SD_INVOCATION__RECEIVE_EXECUTION:
				if (resolve) return getReceiveExecution();
				return basicGetReceiveExecution();
			case SDPackage.SD_INVOCATION__OUTGOING_MESSAGE:
				if (resolve) return getOutgoingMessage();
				return basicGetOutgoingMessage();
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
			case SDPackage.SD_INVOCATION__RECEIVE_EXECUTION:
				setReceiveExecution((SDExecution)newValue);
				return;
			case SDPackage.SD_INVOCATION__OUTGOING_MESSAGE:
				setOutgoingMessage((SDMessage)newValue);
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
			case SDPackage.SD_INVOCATION__RECEIVE_EXECUTION:
				setReceiveExecution((SDExecution)null);
				return;
			case SDPackage.SD_INVOCATION__OUTGOING_MESSAGE:
				setOutgoingMessage((SDMessage)null);
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
			case SDPackage.SD_INVOCATION__RECEIVE_EXECUTION:
				return receiveExecution != null;
			case SDPackage.SD_INVOCATION__OUTGOING_MESSAGE:
				return outgoingMessage != null;
		}
		return super.eIsSet(featureID);
	}

} //SDInvocationImpl
