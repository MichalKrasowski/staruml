/**
 * <copyright>
 * </copyright>
 *
 * $Id: SDBracketContainer.java,v 1.1 2010/09/24 00:18:36 administrator Exp $
 */
package org.eclipse.uml2.diagram.sequence.model.sequenced;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bracket Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDBracketContainer#getBrackets <em>Brackets</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.uml2.diagram.sequence.model.sequenced.SDPackage#getSDBracketContainer()
 * @model abstract="true"
 * @generated
 */
public interface SDBracketContainer extends SDLifeLineElement {
	/**
	 * Returns the value of the '<em><b>Brackets</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDBracket}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDBracket#getBracketContainer <em>Bracket Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Brackets</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Brackets</em>' containment reference list.
	 * @see org.eclipse.uml2.diagram.sequence.model.sequenced.SDPackage#getSDBracketContainer_Brackets()
	 * @see org.eclipse.uml2.diagram.sequence.model.sequenced.SDBracket#getBracketContainer
	 * @model opposite="bracketContainer" containment="true"
	 * @generated
	 */
	EList<SDBracket> getBrackets();

} // SDBracketContainer
