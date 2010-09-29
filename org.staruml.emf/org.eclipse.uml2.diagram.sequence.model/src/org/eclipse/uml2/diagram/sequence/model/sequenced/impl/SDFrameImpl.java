/**
 * <copyright>
 * </copyright>
 *
 * $Id: SDFrameImpl.java,v 1.1 2010/09/24 00:18:36 administrator Exp $
 */
package org.eclipse.uml2.diagram.sequence.model.sequenced.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDFrame;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDFrameContainer;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDLifeLine;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDMountingRegion;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDPackage;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.InteractionOperand;
import org.eclipse.uml2.uml.Lifeline;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Frame</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.uml2.diagram.sequence.model.sequenced.impl.SDFrameImpl#getFrameContainer <em>Frame Container</em>}</li>
 *   <li>{@link org.eclipse.uml2.diagram.sequence.model.sequenced.impl.SDFrameImpl#getRegions <em>Regions</em>}</li>
 *   <li>{@link org.eclipse.uml2.diagram.sequence.model.sequenced.impl.SDFrameImpl#getCoveredLifeLines <em>Covered Life Lines</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class SDFrameImpl extends SDFrameContainerImpl implements SDFrame {
	/**
	 * The cached value of the '{@link #getRegions() <em>Regions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegions()
	 * @generated
	 * @ordered
	 */
	protected EList<SDMountingRegion> regions;

	/**
	 * The cached value of the '{@link #getCoveredLifeLines() <em>Covered Life Lines</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCoveredLifeLines()
	 * @generated
	 * @ordered
	 */
	protected EList<SDLifeLine> coveredLifeLines;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SDFrameImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SDPackage.Literals.SD_FRAME;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SDFrameContainer getFrameContainer() {
		if (eContainerFeatureID != SDPackage.SD_FRAME__FRAME_CONTAINER) return null;
		return (SDFrameContainer)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SDMountingRegion> getRegions() {
		if (regions == null) {
			regions = new EObjectWithInverseResolvingEList<SDMountingRegion>(SDMountingRegion.class, this, SDPackage.SD_FRAME__REGIONS, SDPackage.SD_MOUNTING_REGION__FRAME);
		}
		return regions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SDLifeLine> getCoveredLifeLines() {
		if (coveredLifeLines == null) {
			coveredLifeLines = new EObjectResolvingEList<SDLifeLine>(SDLifeLine.class, this, SDPackage.SD_FRAME__COVERED_LIFE_LINES);
		}
		return coveredLifeLines;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public SDMountingRegion findRegionForUmlLifeLine(Lifeline umlLifeline) {
		for (SDMountingRegion nextRegion : getRegions()){
			SDLifeLine nextLifeLine = nextRegion.getCoveredLifeLine();
			if (umlLifeline == nextLifeLine.getUmlLifeline()){
				return nextRegion;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public SDMountingRegion findRegionForSDLifeLine(SDLifeLine sdLifeline) {
		for (SDMountingRegion nextRegion : getRegions()){
			SDLifeLine nextLifeLine = nextRegion.getCoveredLifeLine();
			if (sdLifeline == nextLifeLine){
				return nextRegion;
			}
		}
		return null;
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
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SDPackage.SD_FRAME__FRAME_CONTAINER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return eBasicSetContainer(otherEnd, SDPackage.SD_FRAME__FRAME_CONTAINER, msgs);
			case SDPackage.SD_FRAME__REGIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getRegions()).basicAdd(otherEnd, msgs);
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
			case SDPackage.SD_FRAME__FRAME_CONTAINER:
				return eBasicSetContainer(null, SDPackage.SD_FRAME__FRAME_CONTAINER, msgs);
			case SDPackage.SD_FRAME__REGIONS:
				return ((InternalEList<?>)getRegions()).basicRemove(otherEnd, msgs);
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
			case SDPackage.SD_FRAME__FRAME_CONTAINER:
				return eInternalContainer().eInverseRemove(this, SDPackage.SD_FRAME_CONTAINER__FRAMES, SDFrameContainer.class, msgs);
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
			case SDPackage.SD_FRAME__FRAME_CONTAINER:
				return getFrameContainer();
			case SDPackage.SD_FRAME__REGIONS:
				return getRegions();
			case SDPackage.SD_FRAME__COVERED_LIFE_LINES:
				return getCoveredLifeLines();
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
			case SDPackage.SD_FRAME__REGIONS:
				getRegions().clear();
				getRegions().addAll((Collection<? extends SDMountingRegion>)newValue);
				return;
			case SDPackage.SD_FRAME__COVERED_LIFE_LINES:
				getCoveredLifeLines().clear();
				getCoveredLifeLines().addAll((Collection<? extends SDLifeLine>)newValue);
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
			case SDPackage.SD_FRAME__REGIONS:
				getRegions().clear();
				return;
			case SDPackage.SD_FRAME__COVERED_LIFE_LINES:
				getCoveredLifeLines().clear();
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
			case SDPackage.SD_FRAME__FRAME_CONTAINER:
				return getFrameContainer() != null;
			case SDPackage.SD_FRAME__REGIONS:
				return regions != null && !regions.isEmpty();
			case SDPackage.SD_FRAME__COVERED_LIFE_LINES:
				return coveredLifeLines != null && !coveredLifeLines.isEmpty();
		}
		return super.eIsSet(featureID);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * The InteractionOperand is the only frame that has its own fragments list
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<InteractionFragment> getFragmentsList() {
		InteractionFragment fragment = getUmlFragment();
		if (fragment == null){
			return ECollections.<InteractionFragment>emptyEList();
		}
		InteractionOperand operand = fragment.getEnclosingOperand();
		if (operand != null){
			return operand.getFragments();
		}
		Interaction interaction = fragment.getEnclosingInteraction();
		return (interaction == null) ? ECollections.<InteractionFragment>emptyEList() : interaction.getFragments();
	}
	

} //SDFrameImpl
