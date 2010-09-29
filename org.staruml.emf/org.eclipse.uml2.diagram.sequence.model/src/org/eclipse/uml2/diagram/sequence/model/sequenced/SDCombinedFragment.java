/**
 * <copyright>
 * </copyright>
 *
 * $Id: SDCombinedFragment.java,v 1.1 2010/09/24 00:18:36 administrator Exp $
 */
package org.eclipse.uml2.diagram.sequence.model.sequenced;

import org.eclipse.uml2.uml.CombinedFragment;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Combined Fragment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDCombinedFragment#getUmlCombinedFragment <em>Uml Combined Fragment</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.uml2.diagram.sequence.model.sequenced.SDPackage#getSDCombinedFragment()
 * @model
 * @generated
 */
public interface SDCombinedFragment extends SDFrame {
	/**
	 * Returns the value of the '<em><b>Uml Combined Fragment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uml Combined Fragment</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uml Combined Fragment</em>' reference.
	 * @see #setUmlCombinedFragment(CombinedFragment)
	 * @see org.eclipse.uml2.diagram.sequence.model.sequenced.SDPackage#getSDCombinedFragment_UmlCombinedFragment()
	 * @model type="org.eclipse.uml2.diagram.sequence.model.sequenced.UMLCombinedFragment"
	 * @generated
	 */
	CombinedFragment getUmlCombinedFragment();

	/**
	 * Sets the value of the '{@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDCombinedFragment#getUmlCombinedFragment <em>Uml Combined Fragment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uml Combined Fragment</em>' reference.
	 * @see #getUmlCombinedFragment()
	 * @generated
	 */
	void setUmlCombinedFragment(CombinedFragment value);

} // SDCombinedFragment
