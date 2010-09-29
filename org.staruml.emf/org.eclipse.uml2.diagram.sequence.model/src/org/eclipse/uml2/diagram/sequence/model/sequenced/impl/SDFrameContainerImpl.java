/**
 * <copyright>
 * </copyright>
 *
 * $Id: SDFrameContainerImpl.java,v 1.1 2010/09/24 00:18:36 administrator Exp $
 */
package org.eclipse.uml2.diagram.sequence.model.sequenced.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.uml2.diagram.sequence.model.sequenced.SDFrame;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDFrameContainer;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDPackage;
import org.eclipse.uml2.uml.InteractionFragment;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Frame Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.uml2.diagram.sequence.model.sequenced.impl.SDFrameContainerImpl#getFrames <em>Frames</em>}</li>
 *   <li>{@link org.eclipse.uml2.diagram.sequence.model.sequenced.impl.SDFrameContainerImpl#getFragmentsList <em>Fragments List</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class SDFrameContainerImpl extends EObjectImpl implements SDFrameContainer {
	/**
	 * The cached value of the '{@link #getFrames() <em>Frames</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrames()
	 * @generated
	 * @ordered
	 */
	protected EList<SDFrame> frames;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SDFrameContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SDPackage.Literals.SD_FRAME_CONTAINER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SDFrame> getFrames() {
		if (frames == null) {
			frames = new EObjectContainmentWithInverseEList<SDFrame>(SDFrame.class, this, SDPackage.SD_FRAME_CONTAINER__FRAMES, SDPackage.SD_FRAME__FRAME_CONTAINER);
		}
		return frames;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<InteractionFragment> getFragmentsList() {
		throw new IllegalStateException("This method should be redefined in subclass, but it is not for: " + this);
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
			case SDPackage.SD_FRAME_CONTAINER__FRAMES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getFrames()).basicAdd(otherEnd, msgs);
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
			case SDPackage.SD_FRAME_CONTAINER__FRAMES:
				return ((InternalEList<?>)getFrames()).basicRemove(otherEnd, msgs);
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
			case SDPackage.SD_FRAME_CONTAINER__FRAMES:
				return getFrames();
			case SDPackage.SD_FRAME_CONTAINER__FRAGMENTS_LIST:
				return getFragmentsList();
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
			case SDPackage.SD_FRAME_CONTAINER__FRAMES:
				getFrames().clear();
				getFrames().addAll((Collection<? extends SDFrame>)newValue);
				return;
			case SDPackage.SD_FRAME_CONTAINER__FRAGMENTS_LIST:
				getFragmentsList().clear();
				getFragmentsList().addAll((Collection<? extends InteractionFragment>)newValue);
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
			case SDPackage.SD_FRAME_CONTAINER__FRAMES:
				getFrames().clear();
				return;
			case SDPackage.SD_FRAME_CONTAINER__FRAGMENTS_LIST:
				getFragmentsList().clear();
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
			case SDPackage.SD_FRAME_CONTAINER__FRAMES:
				return frames != null && !frames.isEmpty();
			case SDPackage.SD_FRAME_CONTAINER__FRAGMENTS_LIST:
				return !getFragmentsList().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SDFrameContainerImpl
