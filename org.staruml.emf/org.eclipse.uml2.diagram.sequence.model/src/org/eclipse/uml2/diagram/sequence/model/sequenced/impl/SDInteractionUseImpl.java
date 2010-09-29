/**
 * <copyright>
 * </copyright>
 *
 * $Id: SDInteractionUseImpl.java,v 1.1 2010/09/24 00:18:36 administrator Exp $
 */
package org.eclipse.uml2.diagram.sequence.model.sequenced.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.uml2.diagram.sequence.model.sequenced.SDInteractionUse;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDPackage;

import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.InteractionUse;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Interaction Use</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.uml2.diagram.sequence.model.sequenced.impl.SDInteractionUseImpl#getUmlInteractionUse <em>Uml Interaction Use</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SDInteractionUseImpl extends SDFrameImpl implements SDInteractionUse {
	/**
	 * The cached value of the '{@link #getUmlInteractionUse() <em>Uml Interaction Use</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUmlInteractionUse()
	 * @generated
	 * @ordered
	 */
	protected InteractionUse umlInteractionUse;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SDInteractionUseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SDPackage.Literals.SD_INTERACTION_USE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InteractionUse getUmlInteractionUse() {
		if (umlInteractionUse != null && ((EObject)umlInteractionUse).eIsProxy()) {
			InternalEObject oldUmlInteractionUse = (InternalEObject)umlInteractionUse;
			umlInteractionUse = (InteractionUse)eResolveProxy(oldUmlInteractionUse);
			if (umlInteractionUse != oldUmlInteractionUse) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SDPackage.SD_INTERACTION_USE__UML_INTERACTION_USE, oldUmlInteractionUse, umlInteractionUse));
			}
		}
		return umlInteractionUse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InteractionUse basicGetUmlInteractionUse() {
		return umlInteractionUse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUmlInteractionUse(InteractionUse newUmlInteractionUse) {
		InteractionUse oldUmlInteractionUse = umlInteractionUse;
		umlInteractionUse = newUmlInteractionUse;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SDPackage.SD_INTERACTION_USE__UML_INTERACTION_USE, oldUmlInteractionUse, umlInteractionUse));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SDPackage.SD_INTERACTION_USE__UML_INTERACTION_USE:
				if (resolve) return getUmlInteractionUse();
				return basicGetUmlInteractionUse();
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
			case SDPackage.SD_INTERACTION_USE__UML_INTERACTION_USE:
				setUmlInteractionUse((InteractionUse)newValue);
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
			case SDPackage.SD_INTERACTION_USE__UML_INTERACTION_USE:
				setUmlInteractionUse((InteractionUse)null);
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
			case SDPackage.SD_INTERACTION_USE__UML_INTERACTION_USE:
				return umlInteractionUse != null;
		}
		return super.eIsSet(featureID);
	}
	
	@Override
	public final InteractionFragment getUmlFragment() {
		return getUmlInteractionUse();
	}

} //SDInteractionUseImpl
