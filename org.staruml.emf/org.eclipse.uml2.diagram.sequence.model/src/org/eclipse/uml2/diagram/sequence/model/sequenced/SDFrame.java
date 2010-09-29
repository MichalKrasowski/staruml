/**
 * <copyright>
 * </copyright>
 *
 * $Id: SDFrame.java,v 1.1 2010/09/24 00:18:36 administrator Exp $
 */
package org.eclipse.uml2.diagram.sequence.model.sequenced;

import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.Lifeline;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Frame</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDFrame#getFrameContainer <em>Frame Container</em>}</li>
 *   <li>{@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDFrame#getRegions <em>Regions</em>}</li>
 *   <li>{@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDFrame#getCoveredLifeLines <em>Covered Life Lines</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.uml2.diagram.sequence.model.sequenced.SDPackage#getSDFrame()
 * @model abstract="true"
 * @generated
 */
public interface SDFrame extends SDFrameContainer, SDBackedByFragment, SDEntity {
	/**
	 * Returns the value of the '<em><b>Frame Container</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDFrameContainer#getFrames <em>Frames</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Frame Container</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Frame Container</em>' container reference.
	 * @see org.eclipse.uml2.diagram.sequence.model.sequenced.SDPackage#getSDFrame_FrameContainer()
	 * @see org.eclipse.uml2.diagram.sequence.model.sequenced.SDFrameContainer#getFrames
	 * @model opposite="frames" required="true" transient="false" changeable="false"
	 * @generated
	 */
	SDFrameContainer getFrameContainer();

	/**
	 * Returns the value of the '<em><b>Regions</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDMountingRegion}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDMountingRegion#getFrame <em>Frame</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Regions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Regions</em>' reference list.
	 * @see org.eclipse.uml2.diagram.sequence.model.sequenced.SDPackage#getSDFrame_Regions()
	 * @see org.eclipse.uml2.diagram.sequence.model.sequenced.SDMountingRegion#getFrame
	 * @model opposite="frame"
	 * @generated
	 */
	EList<SDMountingRegion> getRegions();

	/**
	 * Returns the value of the '<em><b>Covered Life Lines</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDLifeLine}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Covered Life Lines</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Covered Life Lines</em>' reference list.
	 * @see org.eclipse.uml2.diagram.sequence.model.sequenced.SDPackage#getSDFrame_CoveredLifeLines()
	 * @model
	 * @generated
	 */
	EList<SDLifeLine> getCoveredLifeLines();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model umlLifelineType="org.eclipse.uml2.diagram.sequence.model.sequenced.UMLLifeline"
	 * @generated
	 */
	SDMountingRegion findRegionForUmlLifeLine(Lifeline umlLifeline);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	SDMountingRegion findRegionForSDLifeLine(SDLifeLine sdLifeline);

} // SDFrame
