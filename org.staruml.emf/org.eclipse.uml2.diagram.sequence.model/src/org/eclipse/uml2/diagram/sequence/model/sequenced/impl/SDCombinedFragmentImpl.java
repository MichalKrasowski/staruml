/**
 * <copyright>
 * </copyright>
 *
 * $Id: SDCombinedFragmentImpl.java,v 1.1 2010/09/24 00:18:36 administrator Exp $
 */
package org.eclipse.uml2.diagram.sequence.model.sequenced.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.uml2.diagram.sequence.model.sequenced.SDCombinedFragment;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDPackage;

import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.InteractionFragment;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Combined Fragment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.uml2.diagram.sequence.model.sequenced.impl.SDCombinedFragmentImpl#getUmlCombinedFragment <em>Uml Combined Fragment</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SDCombinedFragmentImpl extends SDFrameImpl implements SDCombinedFragment {
	/**
	 * The cached value of the '{@link #getUmlCombinedFragment() <em>Uml Combined Fragment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUmlCombinedFragment()
	 * @generated
	 * @ordered
	 */
	protected CombinedFragment umlCombinedFragment;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SDCombinedFragmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SDPackage.Literals.SD_COMBINED_FRAGMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CombinedFragment getUmlCombinedFragment() {
		if (umlCombinedFragment != null && ((EObject)umlCombinedFragment).eIsProxy()) {
			InternalEObject oldUmlCombinedFragment = (InternalEObject)umlCombinedFragment;
			umlCombinedFragment = (CombinedFragment)eResolveProxy(oldUmlCombinedFragment);
			if (umlCombinedFragment != oldUmlCombinedFragment) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SDPackage.SD_COMBINED_FRAGMENT__UML_COMBINED_FRAGMENT, oldUmlCombinedFragment, umlCombinedFragment));
			}
		}
		return umlCombinedFragment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CombinedFragment basicGetUmlCombinedFragment() {
		return umlCombinedFragment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUmlCombinedFragment(CombinedFragment newUmlCombinedFragment) {
		CombinedFragment oldUmlCombinedFragment = umlCombinedFragment;
		umlCombinedFragment = newUmlCombinedFragment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SDPackage.SD_COMBINED_FRAGMENT__UML_COMBINED_FRAGMENT, oldUmlCombinedFragment, umlCombinedFragment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SDPackage.SD_COMBINED_FRAGMENT__UML_COMBINED_FRAGMENT:
				if (resolve) return getUmlCombinedFragment();
				return basicGetUmlCombinedFragment();
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
			case SDPackage.SD_COMBINED_FRAGMENT__UML_COMBINED_FRAGMENT:
				setUmlCombinedFragment((CombinedFragment)newValue);
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
			case SDPackage.SD_COMBINED_FRAGMENT__UML_COMBINED_FRAGMENT:
				setUmlCombinedFragment((CombinedFragment)null);
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
			case SDPackage.SD_COMBINED_FRAGMENT__UML_COMBINED_FRAGMENT:
				return umlCombinedFragment != null;
		}
		return super.eIsSet(featureID);
	}
	
	@Override
	public final InteractionFragment getUmlFragment() {
		return getUmlCombinedFragment();
	}

} //SDCombinedFragmentImpl
