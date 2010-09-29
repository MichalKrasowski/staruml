/**
 * <copyright>
 * </copyright>
 *
 * $Id: SDSimpleNodeImpl.java,v 1.1 2010/09/24 00:18:36 administrator Exp $
 */
package org.eclipse.uml2.diagram.sequence.model.sequenced.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.uml2.diagram.sequence.model.sequenced.SDPackage;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDSimpleNode;

import org.eclipse.uml2.uml.InteractionFragment;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Simple Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.uml2.diagram.sequence.model.sequenced.impl.SDSimpleNodeImpl#getUmlSimpleFragment <em>Uml Simple Fragment</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SDSimpleNodeImpl extends SDBracketImpl implements SDSimpleNode {
	/**
	 * The cached value of the '{@link #getUmlSimpleFragment() <em>Uml Simple Fragment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUmlSimpleFragment()
	 * @generated
	 * @ordered
	 */
	protected InteractionFragment umlSimpleFragment;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SDSimpleNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SDPackage.Literals.SD_SIMPLE_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InteractionFragment getUmlSimpleFragment() {
		if (umlSimpleFragment != null && ((EObject)umlSimpleFragment).eIsProxy()) {
			InternalEObject oldUmlSimpleFragment = (InternalEObject)umlSimpleFragment;
			umlSimpleFragment = (InteractionFragment)eResolveProxy(oldUmlSimpleFragment);
			if (umlSimpleFragment != oldUmlSimpleFragment) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SDPackage.SD_SIMPLE_NODE__UML_SIMPLE_FRAGMENT, oldUmlSimpleFragment, umlSimpleFragment));
			}
		}
		return umlSimpleFragment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InteractionFragment basicGetUmlSimpleFragment() {
		return umlSimpleFragment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUmlSimpleFragment(InteractionFragment newUmlSimpleFragment) {
		InteractionFragment oldUmlSimpleFragment = umlSimpleFragment;
		umlSimpleFragment = newUmlSimpleFragment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SDPackage.SD_SIMPLE_NODE__UML_SIMPLE_FRAGMENT, oldUmlSimpleFragment, umlSimpleFragment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SDPackage.SD_SIMPLE_NODE__UML_SIMPLE_FRAGMENT:
				if (resolve) return getUmlSimpleFragment();
				return basicGetUmlSimpleFragment();
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
			case SDPackage.SD_SIMPLE_NODE__UML_SIMPLE_FRAGMENT:
				setUmlSimpleFragment((InteractionFragment)newValue);
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
			case SDPackage.SD_SIMPLE_NODE__UML_SIMPLE_FRAGMENT:
				setUmlSimpleFragment((InteractionFragment)null);
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
			case SDPackage.SD_SIMPLE_NODE__UML_SIMPLE_FRAGMENT:
				return umlSimpleFragment != null;
		}
		return super.eIsSet(featureID);
	}
	
	@Override
	public final InteractionFragment getUmlFragment() {
		return getUmlSimpleFragment();
	}

} //SDSimpleNodeImpl
