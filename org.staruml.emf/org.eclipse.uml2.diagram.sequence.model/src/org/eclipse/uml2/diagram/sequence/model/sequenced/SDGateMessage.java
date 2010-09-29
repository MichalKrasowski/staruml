/**
 * <copyright>
 * </copyright>
 *
 * $Id: SDGateMessage.java,v 1.1 2010/09/24 00:18:36 administrator Exp $
 */
package org.eclipse.uml2.diagram.sequence.model.sequenced;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gate Message</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDGateMessage#isFromNotToGate <em>From Not To Gate</em>}</li>
 *   <li>{@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDGateMessage#getGate <em>Gate</em>}</li>
 *   <li>{@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDGateMessage#getNormalEnd <em>Normal End</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.uml2.diagram.sequence.model.sequenced.SDPackage#getSDGateMessage()
 * @model
 * @generated
 */
public interface SDGateMessage extends SDAbstractMessage {
	/**
	 * Returns the value of the '<em><b>From Not To Gate</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From Not To Gate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From Not To Gate</em>' attribute.
	 * @see #setFromNotToGate(boolean)
	 * @see org.eclipse.uml2.diagram.sequence.model.sequenced.SDPackage#getSDGateMessage_FromNotToGate()
	 * @model default="false"
	 * @generated
	 */
	boolean isFromNotToGate();

	/**
	 * Sets the value of the '{@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDGateMessage#isFromNotToGate <em>From Not To Gate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From Not To Gate</em>' attribute.
	 * @see #isFromNotToGate()
	 * @generated
	 */
	void setFromNotToGate(boolean value);

	/**
	 * Returns the value of the '<em><b>Gate</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gate</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gate</em>' reference.
	 * @see #setGate(SDGate)
	 * @see org.eclipse.uml2.diagram.sequence.model.sequenced.SDPackage#getSDGateMessage_Gate()
	 * @model
	 * @generated
	 */
	SDGate getGate();

	/**
	 * Sets the value of the '{@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDGateMessage#getGate <em>Gate</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Gate</em>' reference.
	 * @see #getGate()
	 * @generated
	 */
	void setGate(SDGate value);

	/**
	 * Returns the value of the '<em><b>Normal End</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Normal End</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Normal End</em>' reference.
	 * @see #setNormalEnd(SDGateMessageEnd)
	 * @see org.eclipse.uml2.diagram.sequence.model.sequenced.SDPackage#getSDGateMessage_NormalEnd()
	 * @model
	 * @generated
	 */
	SDGateMessageEnd getNormalEnd();

	/**
	 * Sets the value of the '{@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDGateMessage#getNormalEnd <em>Normal End</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Normal End</em>' reference.
	 * @see #getNormalEnd()
	 * @generated
	 */
	void setNormalEnd(SDGateMessageEnd value);

} // SDGateMessage
