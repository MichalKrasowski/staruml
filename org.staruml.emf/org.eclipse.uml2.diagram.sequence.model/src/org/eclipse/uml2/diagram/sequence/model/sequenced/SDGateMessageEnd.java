/**
 * <copyright>
 * </copyright>
 *
 * $Id: SDGateMessageEnd.java,v 1.1 2010/09/24 00:18:36 administrator Exp $
 */
package org.eclipse.uml2.diagram.sequence.model.sequenced;

import org.eclipse.uml2.uml.OccurrenceSpecification;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gate Message End</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDGateMessageEnd#getUmlMessageEnd <em>Uml Message End</em>}</li>
 *   <li>{@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDGateMessageEnd#isIsStartNotFinish <em>Is Start Not Finish</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.uml2.diagram.sequence.model.sequenced.SDPackage#getSDGateMessageEnd()
 * @model
 * @generated
 */
public interface SDGateMessageEnd extends SDBracket {
	/**
	 * Returns the value of the '<em><b>Uml Message End</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uml Message End</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uml Message End</em>' reference.
	 * @see #setUmlMessageEnd(OccurrenceSpecification)
	 * @see org.eclipse.uml2.diagram.sequence.model.sequenced.SDPackage#getSDGateMessageEnd_UmlMessageEnd()
	 * @model type="org.eclipse.uml2.diagram.sequence.model.sequenced.UMLOccurrenceSpecification"
	 * @generated
	 */
	OccurrenceSpecification getUmlMessageEnd();

	/**
	 * Sets the value of the '{@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDGateMessageEnd#getUmlMessageEnd <em>Uml Message End</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uml Message End</em>' reference.
	 * @see #getUmlMessageEnd()
	 * @generated
	 */
	void setUmlMessageEnd(OccurrenceSpecification value);

	/**
	 * Returns the value of the '<em><b>Is Start Not Finish</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Start Not Finish</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Start Not Finish</em>' attribute.
	 * @see #setIsStartNotFinish(boolean)
	 * @see org.eclipse.uml2.diagram.sequence.model.sequenced.SDPackage#getSDGateMessageEnd_IsStartNotFinish()
	 * @model default="true"
	 * @generated
	 */
	boolean isIsStartNotFinish();

	/**
	 * Sets the value of the '{@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDGateMessageEnd#isIsStartNotFinish <em>Is Start Not Finish</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Start Not Finish</em>' attribute.
	 * @see #isIsStartNotFinish()
	 * @generated
	 */
	void setIsStartNotFinish(boolean value);

} // SDGateMessageEnd
