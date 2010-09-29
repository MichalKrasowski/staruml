/**
 * <copyright>
 * </copyright>
 *
 * $Id: SDMountingRegion.java,v 1.1 2010/09/24 00:18:36 administrator Exp $
 */
package org.eclipse.uml2.diagram.sequence.model.sequenced;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mounting Region</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDMountingRegion#getFrame <em>Frame</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.uml2.diagram.sequence.model.sequenced.SDPackage#getSDMountingRegion()
 * @model
 * @generated
 */
public interface SDMountingRegion extends SDBracket, SDBracketContainer {
	/**
	 * Returns the value of the '<em><b>Frame</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDFrame#getRegions <em>Regions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Frame</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Frame</em>' reference.
	 * @see #setFrame(SDFrame)
	 * @see org.eclipse.uml2.diagram.sequence.model.sequenced.SDPackage#getSDMountingRegion_Frame()
	 * @see org.eclipse.uml2.diagram.sequence.model.sequenced.SDFrame#getRegions
	 * @model opposite="regions" required="true"
	 * @generated
	 */
	SDFrame getFrame();

	/**
	 * Sets the value of the '{@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDMountingRegion#getFrame <em>Frame</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Frame</em>' reference.
	 * @see #getFrame()
	 * @generated
	 */
	void setFrame(SDFrame value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	SDMountingRegion findMountingRegionForSubFrame(SDFrame subFrame);

} // SDMountingRegion
