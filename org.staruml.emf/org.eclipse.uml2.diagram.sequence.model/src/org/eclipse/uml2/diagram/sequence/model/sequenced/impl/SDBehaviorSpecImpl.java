/**
 * <copyright>
 * </copyright>
 *
 * $Id: SDBehaviorSpecImpl.java,v 1.1 2010/09/24 00:18:37 administrator Exp $
 */
package org.eclipse.uml2.diagram.sequence.model.sequenced.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.uml2.diagram.sequence.model.sequenced.SDBehaviorSpec;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDBracket;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDBracketContainer;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDPackage;

import org.eclipse.uml2.uml.ExecutionSpecification;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.OccurrenceSpecification;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Behavior Spec</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.uml2.diagram.sequence.model.sequenced.impl.SDBehaviorSpecImpl#getBrackets <em>Brackets</em>}</li>
 *   <li>{@link org.eclipse.uml2.diagram.sequence.model.sequenced.impl.SDBehaviorSpecImpl#getUmlExecutionSpec <em>Uml Execution Spec</em>}</li>
 *   <li>{@link org.eclipse.uml2.diagram.sequence.model.sequenced.impl.SDBehaviorSpecImpl#getUmlStart <em>Uml Start</em>}</li>
 *   <li>{@link org.eclipse.uml2.diagram.sequence.model.sequenced.impl.SDBehaviorSpecImpl#getUmlFinish <em>Uml Finish</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class SDBehaviorSpecImpl extends SDBracketImpl implements SDBehaviorSpec {
	/**
	 * The cached value of the '{@link #getBrackets() <em>Brackets</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBrackets()
	 * @generated
	 * @ordered
	 */
	protected EList<SDBracket> brackets;

	/**
	 * The cached value of the '{@link #getUmlExecutionSpec() <em>Uml Execution Spec</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUmlExecutionSpec()
	 * @generated
	 * @ordered
	 */
	protected ExecutionSpecification umlExecutionSpec;

	/**
	 * The cached value of the '{@link #getUmlStart() <em>Uml Start</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUmlStart()
	 * @generated
	 * @ordered
	 */
	protected OccurrenceSpecification umlStart;

	/**
	 * The cached value of the '{@link #getUmlFinish() <em>Uml Finish</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUmlFinish()
	 * @generated
	 * @ordered
	 */
	protected OccurrenceSpecification umlFinish;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SDBehaviorSpecImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SDPackage.Literals.SD_BEHAVIOR_SPEC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SDBracket> getBrackets() {
		if (brackets == null) {
			brackets = new EObjectContainmentWithInverseEList<SDBracket>(SDBracket.class, this, SDPackage.SD_BEHAVIOR_SPEC__BRACKETS, SDPackage.SD_BRACKET__BRACKET_CONTAINER);
		}
		return brackets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionSpecification getUmlExecutionSpec() {
		if (umlExecutionSpec != null && ((EObject)umlExecutionSpec).eIsProxy()) {
			InternalEObject oldUmlExecutionSpec = (InternalEObject)umlExecutionSpec;
			umlExecutionSpec = (ExecutionSpecification)eResolveProxy(oldUmlExecutionSpec);
			if (umlExecutionSpec != oldUmlExecutionSpec) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SDPackage.SD_BEHAVIOR_SPEC__UML_EXECUTION_SPEC, oldUmlExecutionSpec, umlExecutionSpec));
			}
		}
		return umlExecutionSpec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionSpecification basicGetUmlExecutionSpec() {
		return umlExecutionSpec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUmlExecutionSpec(ExecutionSpecification newUmlExecutionSpec) {
		ExecutionSpecification oldUmlExecutionSpec = umlExecutionSpec;
		umlExecutionSpec = newUmlExecutionSpec;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SDPackage.SD_BEHAVIOR_SPEC__UML_EXECUTION_SPEC, oldUmlExecutionSpec, umlExecutionSpec));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OccurrenceSpecification getUmlStart() {
		if (umlStart != null && ((EObject)umlStart).eIsProxy()) {
			InternalEObject oldUmlStart = (InternalEObject)umlStart;
			umlStart = (OccurrenceSpecification)eResolveProxy(oldUmlStart);
			if (umlStart != oldUmlStart) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SDPackage.SD_BEHAVIOR_SPEC__UML_START, oldUmlStart, umlStart));
			}
		}
		return umlStart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OccurrenceSpecification basicGetUmlStart() {
		return umlStart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUmlStart(OccurrenceSpecification newUmlStart) {
		OccurrenceSpecification oldUmlStart = umlStart;
		umlStart = newUmlStart;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SDPackage.SD_BEHAVIOR_SPEC__UML_START, oldUmlStart, umlStart));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OccurrenceSpecification getUmlFinish() {
		if (umlFinish != null && ((EObject)umlFinish).eIsProxy()) {
			InternalEObject oldUmlFinish = (InternalEObject)umlFinish;
			umlFinish = (OccurrenceSpecification)eResolveProxy(oldUmlFinish);
			if (umlFinish != oldUmlFinish) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SDPackage.SD_BEHAVIOR_SPEC__UML_FINISH, oldUmlFinish, umlFinish));
			}
		}
		return umlFinish;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OccurrenceSpecification basicGetUmlFinish() {
		return umlFinish;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUmlFinish(OccurrenceSpecification newUmlFinish) {
		OccurrenceSpecification oldUmlFinish = umlFinish;
		umlFinish = newUmlFinish;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SDPackage.SD_BEHAVIOR_SPEC__UML_FINISH, oldUmlFinish, umlFinish));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SDPackage.SD_BEHAVIOR_SPEC__BRACKETS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getBrackets()).basicAdd(otherEnd, msgs);
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
			case SDPackage.SD_BEHAVIOR_SPEC__BRACKETS:
				return ((InternalEList<?>)getBrackets()).basicRemove(otherEnd, msgs);
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
			case SDPackage.SD_BEHAVIOR_SPEC__BRACKETS:
				return getBrackets();
			case SDPackage.SD_BEHAVIOR_SPEC__UML_EXECUTION_SPEC:
				if (resolve) return getUmlExecutionSpec();
				return basicGetUmlExecutionSpec();
			case SDPackage.SD_BEHAVIOR_SPEC__UML_START:
				if (resolve) return getUmlStart();
				return basicGetUmlStart();
			case SDPackage.SD_BEHAVIOR_SPEC__UML_FINISH:
				if (resolve) return getUmlFinish();
				return basicGetUmlFinish();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SDPackage.SD_BEHAVIOR_SPEC__BRACKETS:
				getBrackets().clear();
				getBrackets().addAll((Collection<? extends SDBracket>)newValue);
				return;
			case SDPackage.SD_BEHAVIOR_SPEC__UML_EXECUTION_SPEC:
				setUmlExecutionSpec((ExecutionSpecification)newValue);
				return;
			case SDPackage.SD_BEHAVIOR_SPEC__UML_START:
				setUmlStart((OccurrenceSpecification)newValue);
				return;
			case SDPackage.SD_BEHAVIOR_SPEC__UML_FINISH:
				setUmlFinish((OccurrenceSpecification)newValue);
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
			case SDPackage.SD_BEHAVIOR_SPEC__BRACKETS:
				getBrackets().clear();
				return;
			case SDPackage.SD_BEHAVIOR_SPEC__UML_EXECUTION_SPEC:
				setUmlExecutionSpec((ExecutionSpecification)null);
				return;
			case SDPackage.SD_BEHAVIOR_SPEC__UML_START:
				setUmlStart((OccurrenceSpecification)null);
				return;
			case SDPackage.SD_BEHAVIOR_SPEC__UML_FINISH:
				setUmlFinish((OccurrenceSpecification)null);
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
			case SDPackage.SD_BEHAVIOR_SPEC__BRACKETS:
				return brackets != null && !brackets.isEmpty();
			case SDPackage.SD_BEHAVIOR_SPEC__UML_EXECUTION_SPEC:
				return umlExecutionSpec != null;
			case SDPackage.SD_BEHAVIOR_SPEC__UML_START:
				return umlStart != null;
			case SDPackage.SD_BEHAVIOR_SPEC__UML_FINISH:
				return umlFinish != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == SDBracketContainer.class) {
			switch (derivedFeatureID) {
				case SDPackage.SD_BEHAVIOR_SPEC__BRACKETS: return SDPackage.SD_BRACKET_CONTAINER__BRACKETS;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == SDBracketContainer.class) {
			switch (baseFeatureID) {
				case SDPackage.SD_BRACKET_CONTAINER__BRACKETS: return SDPackage.SD_BEHAVIOR_SPEC__BRACKETS;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}
	
	@Override
	public final InteractionFragment getUmlFragment() {
		return getUmlExecutionSpec();
	}

} //SDBehaviorSpecImpl
