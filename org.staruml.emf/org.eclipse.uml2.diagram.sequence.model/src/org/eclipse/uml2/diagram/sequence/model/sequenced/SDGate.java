/**
 * <copyright>
 * </copyright>
 *
 * $Id: SDGate.java,v 1.1 2010/09/24 00:18:36 administrator Exp $
 */
package org.eclipse.uml2.diagram.sequence.model.sequenced;

import org.eclipse.uml2.uml.Gate;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gate</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDGate#getUmlGate <em>Uml Gate</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.uml2.diagram.sequence.model.sequenced.SDPackage#getSDGate()
 * @model
 * @generated
 */
public interface SDGate extends SDEntity {
	/**
	 * Returns the value of the '<em><b>Uml Gate</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uml Gate</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uml Gate</em>' reference.
	 * @see #setUmlGate(Gate)
	 * @see org.eclipse.uml2.diagram.sequence.model.sequenced.SDPackage#getSDGate_UmlGate()
	 * @model type="org.eclipse.uml2.diagram.sequence.model.sequenced.UMLGate"
	 * @generated
	 */
	Gate getUmlGate();

	/**
	 * Sets the value of the '{@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDGate#getUmlGate <em>Uml Gate</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uml Gate</em>' reference.
	 * @see #getUmlGate()
	 * @generated
	 */
	void setUmlGate(Gate value);

} // SDGate
