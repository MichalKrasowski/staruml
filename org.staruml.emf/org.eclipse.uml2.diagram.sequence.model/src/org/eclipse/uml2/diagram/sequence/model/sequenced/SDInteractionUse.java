/**
 * <copyright>
 * </copyright>
 *
 * $Id: SDInteractionUse.java,v 1.1 2010/09/24 00:18:36 administrator Exp $
 */
package org.eclipse.uml2.diagram.sequence.model.sequenced;

import org.eclipse.uml2.uml.InteractionUse;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interaction Use</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDInteractionUse#getUmlInteractionUse <em>Uml Interaction Use</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.uml2.diagram.sequence.model.sequenced.SDPackage#getSDInteractionUse()
 * @model
 * @generated
 */
public interface SDInteractionUse extends SDFrame {
	/**
	 * Returns the value of the '<em><b>Uml Interaction Use</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uml Interaction Use</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uml Interaction Use</em>' reference.
	 * @see #setUmlInteractionUse(InteractionUse)
	 * @see org.eclipse.uml2.diagram.sequence.model.sequenced.SDPackage#getSDInteractionUse_UmlInteractionUse()
	 * @model type="org.eclipse.uml2.diagram.sequence.model.sequenced.UMLInteractionUse"
	 * @generated
	 */
	InteractionUse getUmlInteractionUse();

	/**
	 * Sets the value of the '{@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDInteractionUse#getUmlInteractionUse <em>Uml Interaction Use</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uml Interaction Use</em>' reference.
	 * @see #getUmlInteractionUse()
	 * @generated
	 */
	void setUmlInteractionUse(InteractionUse value);

} // SDInteractionUse
