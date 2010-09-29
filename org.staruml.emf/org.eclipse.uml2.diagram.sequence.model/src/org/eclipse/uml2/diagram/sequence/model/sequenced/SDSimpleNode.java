/**
 * <copyright>
 * </copyright>
 *
 * $Id: SDSimpleNode.java,v 1.1 2010/09/24 00:18:36 administrator Exp $
 */
package org.eclipse.uml2.diagram.sequence.model.sequenced;

import org.eclipse.uml2.uml.InteractionFragment;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simple Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDSimpleNode#getUmlSimpleFragment <em>Uml Simple Fragment</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.uml2.diagram.sequence.model.sequenced.SDPackage#getSDSimpleNode()
 * @model
 * @generated
 */
public interface SDSimpleNode extends SDBracket {
	/**
	 * Returns the value of the '<em><b>Uml Simple Fragment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uml Simple Fragment</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uml Simple Fragment</em>' reference.
	 * @see #setUmlSimpleFragment(InteractionFragment)
	 * @see org.eclipse.uml2.diagram.sequence.model.sequenced.SDPackage#getSDSimpleNode_UmlSimpleFragment()
	 * @model type="org.eclipse.uml2.diagram.sequence.model.sequenced.UMLInteractionFragment"
	 * @generated
	 */
	InteractionFragment getUmlSimpleFragment();

	/**
	 * Sets the value of the '{@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDSimpleNode#getUmlSimpleFragment <em>Uml Simple Fragment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uml Simple Fragment</em>' reference.
	 * @see #getUmlSimpleFragment()
	 * @generated
	 */
	void setUmlSimpleFragment(InteractionFragment value);

} // SDSimpleNode
