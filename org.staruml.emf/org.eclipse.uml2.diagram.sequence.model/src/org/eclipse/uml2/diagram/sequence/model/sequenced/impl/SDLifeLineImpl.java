/**
 * <copyright>
 * </copyright>
 *
 * $Id: SDLifeLineImpl.java,v 1.1 2010/09/24 00:18:37 administrator Exp $
 */
package org.eclipse.uml2.diagram.sequence.model.sequenced.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDLifeLine;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDModel;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDPackage;
import org.eclipse.uml2.uml.Lifeline;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Life Line</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.uml2.diagram.sequence.model.sequenced.impl.SDLifeLineImpl#getUmlLifeline <em>Uml Lifeline</em>}</li>
 *   <li>{@link org.eclipse.uml2.diagram.sequence.model.sequenced.impl.SDLifeLineImpl#getModel <em>Model</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SDLifeLineImpl extends SDBracketContainerImpl implements SDLifeLine {
	/**
	 * The cached value of the '{@link #getUmlLifeline() <em>Uml Lifeline</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUmlLifeline()
	 * @generated
	 * @ordered
	 */
	protected Lifeline umlLifeline;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SDLifeLineImpl() {
		super();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public SDLifeLine getCoveredLifeLine() {
		return this;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SDPackage.Literals.SD_LIFE_LINE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Lifeline getUmlLifeline() {
		if (umlLifeline != null && ((EObject)umlLifeline).eIsProxy()) {
			InternalEObject oldUmlLifeline = (InternalEObject)umlLifeline;
			umlLifeline = (Lifeline)eResolveProxy(oldUmlLifeline);
			if (umlLifeline != oldUmlLifeline) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SDPackage.SD_LIFE_LINE__UML_LIFELINE, oldUmlLifeline, umlLifeline));
			}
		}
		return umlLifeline;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Lifeline basicGetUmlLifeline() {
		return umlLifeline;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUmlLifeline(Lifeline newUmlLifeline) {
		Lifeline oldUmlLifeline = umlLifeline;
		umlLifeline = newUmlLifeline;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SDPackage.SD_LIFE_LINE__UML_LIFELINE, oldUmlLifeline, umlLifeline));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SDModel getModel() {
		if (eContainerFeatureID != SDPackage.SD_LIFE_LINE__MODEL) return null;
		return (SDModel)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SDPackage.SD_LIFE_LINE__MODEL:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return eBasicSetContainer(otherEnd, SDPackage.SD_LIFE_LINE__MODEL, msgs);
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
			case SDPackage.SD_LIFE_LINE__MODEL:
				return eBasicSetContainer(null, SDPackage.SD_LIFE_LINE__MODEL, msgs);
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
			case SDPackage.SD_LIFE_LINE__MODEL:
				return eInternalContainer().eInverseRemove(this, SDPackage.SD_MODEL__LIFELINES, SDModel.class, msgs);
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
			case SDPackage.SD_LIFE_LINE__UML_LIFELINE:
				if (resolve) return getUmlLifeline();
				return basicGetUmlLifeline();
			case SDPackage.SD_LIFE_LINE__MODEL:
				return getModel();
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
			case SDPackage.SD_LIFE_LINE__UML_LIFELINE:
				setUmlLifeline((Lifeline)newValue);
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
			case SDPackage.SD_LIFE_LINE__UML_LIFELINE:
				setUmlLifeline((Lifeline)null);
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
			case SDPackage.SD_LIFE_LINE__UML_LIFELINE:
				return umlLifeline != null;
			case SDPackage.SD_LIFE_LINE__MODEL:
				return getModel() != null;
		}
		return super.eIsSet(featureID);
	}

} //SDLifeLineImpl
