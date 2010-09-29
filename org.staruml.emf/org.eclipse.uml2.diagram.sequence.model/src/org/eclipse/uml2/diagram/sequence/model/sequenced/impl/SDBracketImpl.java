/**
 * <copyright>
 * </copyright>
 *
 * $Id: SDBracketImpl.java,v 1.1 2010/09/24 00:18:36 administrator Exp $
 */
package org.eclipse.uml2.diagram.sequence.model.sequenced.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDBracket;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDBracketContainer;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDLifeLine;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDPackage;
import org.eclipse.uml2.uml.InteractionFragment;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bracket</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.uml2.diagram.sequence.model.sequenced.impl.SDBracketImpl#getBracketContainer <em>Bracket Container</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class SDBracketImpl extends SDLifeLineElementImpl implements SDBracket {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SDBracketImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SDPackage.Literals.SD_BRACKET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SDBracketContainer getBracketContainer() {
		if (eContainerFeatureID != SDPackage.SD_BRACKET__BRACKET_CONTAINER) return null;
		return (SDBracketContainer)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public InteractionFragment getUmlFragment() {
		throw new IllegalStateException("This method should be overridden in subclass, but it is not for: " + this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public SDLifeLine getCoveredLifeLine() {
		SDBracketContainer container = getBracketContainer();
		if (container == null){
			throw new IllegalStateException("SDBracket is not attached, cant find covered lifeline for " + this);
		}
		return container.getCoveredLifeLine();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SDPackage.SD_BRACKET__BRACKET_CONTAINER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return eBasicSetContainer(otherEnd, SDPackage.SD_BRACKET__BRACKET_CONTAINER, msgs);
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
			case SDPackage.SD_BRACKET__BRACKET_CONTAINER:
				return eBasicSetContainer(null, SDPackage.SD_BRACKET__BRACKET_CONTAINER, msgs);
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
			case SDPackage.SD_BRACKET__BRACKET_CONTAINER:
				return eInternalContainer().eInverseRemove(this, SDPackage.SD_BRACKET_CONTAINER__BRACKETS, SDBracketContainer.class, msgs);
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
			case SDPackage.SD_BRACKET__BRACKET_CONTAINER:
				return getBracketContainer();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SDPackage.SD_BRACKET__BRACKET_CONTAINER:
				return getBracketContainer() != null;
		}
		return super.eIsSet(featureID);
	}

} //SDBracketImpl
