/**
 * <copyright>
 * </copyright>
 *
 * $Id: SDInteractionOperandImpl.java,v 1.1 2010/09/24 00:18:37 administrator Exp $
 */
package org.eclipse.uml2.diagram.sequence.model.sequenced.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDInteractionOperand;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDPackage;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.InteractionOperand;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Interaction Operand</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.uml2.diagram.sequence.model.sequenced.impl.SDInteractionOperandImpl#getUmlInteractionOperand <em>Uml Interaction Operand</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SDInteractionOperandImpl extends SDFrameImpl implements SDInteractionOperand {
	/**
	 * The cached value of the '{@link #getUmlInteractionOperand() <em>Uml Interaction Operand</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUmlInteractionOperand()
	 * @generated
	 * @ordered
	 */
	protected InteractionOperand umlInteractionOperand;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SDInteractionOperandImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SDPackage.Literals.SD_INTERACTION_OPERAND;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InteractionOperand getUmlInteractionOperand() {
		if (umlInteractionOperand != null && ((EObject)umlInteractionOperand).eIsProxy()) {
			InternalEObject oldUmlInteractionOperand = (InternalEObject)umlInteractionOperand;
			umlInteractionOperand = (InteractionOperand)eResolveProxy(oldUmlInteractionOperand);
			if (umlInteractionOperand != oldUmlInteractionOperand) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SDPackage.SD_INTERACTION_OPERAND__UML_INTERACTION_OPERAND, oldUmlInteractionOperand, umlInteractionOperand));
			}
		}
		return umlInteractionOperand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InteractionOperand basicGetUmlInteractionOperand() {
		return umlInteractionOperand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUmlInteractionOperand(InteractionOperand newUmlInteractionOperand) {
		InteractionOperand oldUmlInteractionOperand = umlInteractionOperand;
		umlInteractionOperand = newUmlInteractionOperand;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SDPackage.SD_INTERACTION_OPERAND__UML_INTERACTION_OPERAND, oldUmlInteractionOperand, umlInteractionOperand));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SDPackage.SD_INTERACTION_OPERAND__UML_INTERACTION_OPERAND:
				if (resolve) return getUmlInteractionOperand();
				return basicGetUmlInteractionOperand();
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
			case SDPackage.SD_INTERACTION_OPERAND__UML_INTERACTION_OPERAND:
				setUmlInteractionOperand((InteractionOperand)newValue);
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
			case SDPackage.SD_INTERACTION_OPERAND__UML_INTERACTION_OPERAND:
				setUmlInteractionOperand((InteractionOperand)null);
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
			case SDPackage.SD_INTERACTION_OPERAND__UML_INTERACTION_OPERAND:
				return umlInteractionOperand != null;
		}
		return super.eIsSet(featureID);
	}
	
	@Override
	public final InteractionFragment getUmlFragment() {
		return getUmlInteractionOperand();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * The InteractionOperand is the only frame that has its own fragments list
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<InteractionFragment> getFragmentsList() {
		InteractionOperand operand = getUmlInteractionOperand();
		return (operand == null) ? ECollections.<InteractionFragment>emptyEList() : operand.getFragments();
	}

} //SDInteractionOperandImpl
