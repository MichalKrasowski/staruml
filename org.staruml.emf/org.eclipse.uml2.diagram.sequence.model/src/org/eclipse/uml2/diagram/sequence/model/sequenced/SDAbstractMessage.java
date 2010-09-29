/**
 * <copyright>
 * </copyright>
 *
 * $Id: SDAbstractMessage.java,v 1.1 2010/09/24 00:18:36 administrator Exp $
 */
package org.eclipse.uml2.diagram.sequence.model.sequenced;

import org.eclipse.uml2.uml.Message;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Message</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDAbstractMessage#getUmlMessage <em>Uml Message</em>}</li>
 *   <li>{@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDAbstractMessage#getModel <em>Model</em>}</li>
 *   <li>{@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDAbstractMessage#getMessageNumber <em>Message Number</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.uml2.diagram.sequence.model.sequenced.SDPackage#getSDAbstractMessage()
 * @model abstract="true"
 * @generated
 */
public interface SDAbstractMessage extends SDEntity {
	/**
	 * Returns the value of the '<em><b>Uml Message</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uml Message</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uml Message</em>' reference.
	 * @see #setUmlMessage(Message)
	 * @see org.eclipse.uml2.diagram.sequence.model.sequenced.SDPackage#getSDAbstractMessage_UmlMessage()
	 * @model type="org.eclipse.uml2.diagram.sequence.model.sequenced.UMLMessage"
	 * @generated
	 */
	Message getUmlMessage();

	/**
	 * Sets the value of the '{@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDAbstractMessage#getUmlMessage <em>Uml Message</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uml Message</em>' reference.
	 * @see #getUmlMessage()
	 * @generated
	 */
	void setUmlMessage(Message value);

	/**
	 * Returns the value of the '<em><b>Model</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDModel#getMessages <em>Messages</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model</em>' container reference.
	 * @see org.eclipse.uml2.diagram.sequence.model.sequenced.SDPackage#getSDAbstractMessage_Model()
	 * @see org.eclipse.uml2.diagram.sequence.model.sequenced.SDModel#getMessages
	 * @model opposite="messages" required="true" transient="false" changeable="false"
	 * @generated
	 */
	SDModel getModel();

	/**
	 * Returns the value of the '<em><b>Message Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Message Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Message Number</em>' attribute.
	 * @see #setMessageNumber(String)
	 * @see org.eclipse.uml2.diagram.sequence.model.sequenced.SDPackage#getSDAbstractMessage_MessageNumber()
	 * @model
	 * @generated
	 */
	String getMessageNumber();

	/**
	 * Sets the value of the '{@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDAbstractMessage#getMessageNumber <em>Message Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message Number</em>' attribute.
	 * @see #getMessageNumber()
	 * @generated
	 */
	void setMessageNumber(String value);

} // SDAbstractMessage
