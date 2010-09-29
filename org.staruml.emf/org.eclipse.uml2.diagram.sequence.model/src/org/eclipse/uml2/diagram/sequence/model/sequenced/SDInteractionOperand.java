/**
 * <copyright>
 * </copyright>
 *
 * $Id: SDInteractionOperand.java,v 1.1 2010/09/24 00:18:36 administrator Exp $
 */
package org.eclipse.uml2.diagram.sequence.model.sequenced;

import org.eclipse.uml2.uml.InteractionOperand;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interaction Operand</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDInteractionOperand#getUmlInteractionOperand <em>Uml Interaction Operand</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.uml2.diagram.sequence.model.sequenced.SDPackage#getSDInteractionOperand()
 * @model
 * @generated
 */
public interface SDInteractionOperand extends SDFrame {
	/**
	 * Returns the value of the '<em><b>Uml Interaction Operand</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uml Interaction Operand</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uml Interaction Operand</em>' reference.
	 * @see #setUmlInteractionOperand(InteractionOperand)
	 * @see org.eclipse.uml2.diagram.sequence.model.sequenced.SDPackage#getSDInteractionOperand_UmlInteractionOperand()
	 * @model type="org.eclipse.uml2.diagram.sequence.model.sequenced.UMLInteractionOperand"
	 * @generated
	 */
	InteractionOperand getUmlInteractionOperand();

	/**
	 * Sets the value of the '{@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDInteractionOperand#getUmlInteractionOperand <em>Uml Interaction Operand</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uml Interaction Operand</em>' reference.
	 * @see #getUmlInteractionOperand()
	 * @generated
	 */
	void setUmlInteractionOperand(InteractionOperand value);

} // SDInteractionOperand
