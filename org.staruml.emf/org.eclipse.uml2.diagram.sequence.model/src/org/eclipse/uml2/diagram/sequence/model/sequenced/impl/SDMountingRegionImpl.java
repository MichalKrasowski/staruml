/**
 * <copyright>
 * </copyright>
 *
 * $Id: SDMountingRegionImpl.java,v 1.1 2010/09/24 00:18:36 administrator Exp $
 */
package org.eclipse.uml2.diagram.sequence.model.sequenced.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.uml2.diagram.sequence.model.sequenced.SDBracket;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDBracketContainer;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDFrame;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDMountingRegion;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDPackage;
import org.eclipse.uml2.uml.InteractionFragment;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mounting Region</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.uml2.diagram.sequence.model.sequenced.impl.SDMountingRegionImpl#getBrackets <em>Brackets</em>}</li>
 *   <li>{@link org.eclipse.uml2.diagram.sequence.model.sequenced.impl.SDMountingRegionImpl#getFrame <em>Frame</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SDMountingRegionImpl extends SDBracketImpl implements SDMountingRegion {
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
	 * The cached value of the '{@link #getFrame() <em>Frame</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrame()
	 * @generated
	 * @ordered
	 */
	protected SDFrame frame;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SDMountingRegionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SDPackage.Literals.SD_MOUNTING_REGION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SDBracket> getBrackets() {
		if (brackets == null) {
			brackets = new EObjectContainmentWithInverseEList<SDBracket>(SDBracket.class, this, SDPackage.SD_MOUNTING_REGION__BRACKETS, SDPackage.SD_BRACKET__BRACKET_CONTAINER);
		}
		return brackets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SDFrame getFrame() {
		if (frame != null && frame.eIsProxy()) {
			InternalEObject oldFrame = (InternalEObject)frame;
			frame = (SDFrame)eResolveProxy(oldFrame);
			if (frame != oldFrame) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SDPackage.SD_MOUNTING_REGION__FRAME, oldFrame, frame));
			}
		}
		return frame;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SDFrame basicGetFrame() {
		return frame;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFrame(SDFrame newFrame, NotificationChain msgs) {
		SDFrame oldFrame = frame;
		frame = newFrame;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SDPackage.SD_MOUNTING_REGION__FRAME, oldFrame, newFrame);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFrame(SDFrame newFrame) {
		if (newFrame != frame) {
			NotificationChain msgs = null;
			if (frame != null)
				msgs = ((InternalEObject)frame).eInverseRemove(this, SDPackage.SD_FRAME__REGIONS, SDFrame.class, msgs);
			if (newFrame != null)
				msgs = ((InternalEObject)newFrame).eInverseAdd(this, SDPackage.SD_FRAME__REGIONS, SDFrame.class, msgs);
			msgs = basicSetFrame(newFrame, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SDPackage.SD_MOUNTING_REGION__FRAME, newFrame, newFrame));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public SDMountingRegion findMountingRegionForSubFrame(SDFrame subFrame) {
		SDFrame selfFrame = getFrame();
		if (selfFrame != subFrame.getFrameContainer()){
			throw new IllegalStateException("The frame " + subFrame + " is not sub-frame for my own frame: " + selfFrame);
		}
		for (SDBracket nextBracket : getBrackets()){
			if (nextBracket instanceof SDMountingRegion){
				SDMountingRegion nextSubRegion = (SDMountingRegion)nextBracket;
				if (nextSubRegion.getFrame() == subFrame){
					return nextSubRegion;
				}
			}
		}
		return null;
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
			case SDPackage.SD_MOUNTING_REGION__BRACKETS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getBrackets()).basicAdd(otherEnd, msgs);
			case SDPackage.SD_MOUNTING_REGION__FRAME:
				if (frame != null)
					msgs = ((InternalEObject)frame).eInverseRemove(this, SDPackage.SD_FRAME__REGIONS, SDFrame.class, msgs);
				return basicSetFrame((SDFrame)otherEnd, msgs);
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
			case SDPackage.SD_MOUNTING_REGION__BRACKETS:
				return ((InternalEList<?>)getBrackets()).basicRemove(otherEnd, msgs);
			case SDPackage.SD_MOUNTING_REGION__FRAME:
				return basicSetFrame(null, msgs);
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
			case SDPackage.SD_MOUNTING_REGION__BRACKETS:
				return getBrackets();
			case SDPackage.SD_MOUNTING_REGION__FRAME:
				if (resolve) return getFrame();
				return basicGetFrame();
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
			case SDPackage.SD_MOUNTING_REGION__BRACKETS:
				getBrackets().clear();
				getBrackets().addAll((Collection<? extends SDBracket>)newValue);
				return;
			case SDPackage.SD_MOUNTING_REGION__FRAME:
				setFrame((SDFrame)newValue);
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
			case SDPackage.SD_MOUNTING_REGION__BRACKETS:
				getBrackets().clear();
				return;
			case SDPackage.SD_MOUNTING_REGION__FRAME:
				setFrame((SDFrame)null);
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
			case SDPackage.SD_MOUNTING_REGION__BRACKETS:
				return brackets != null && !brackets.isEmpty();
			case SDPackage.SD_MOUNTING_REGION__FRAME:
				return frame != null;
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
				case SDPackage.SD_MOUNTING_REGION__BRACKETS: return SDPackage.SD_BRACKET_CONTAINER__BRACKETS;
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
				case SDPackage.SD_BRACKET_CONTAINER__BRACKETS: return SDPackage.SD_MOUNTING_REGION__BRACKETS;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}
	
	@Override
	public InteractionFragment getUmlFragment() {
		SDFrame frame = getFrame();
		if (frame == null){
			throw new IllegalStateException("Mounting region is not attached to Frame yet: " + this);
		}
		return frame.getUmlFragment();
	}

} //SDMountingRegionImpl
