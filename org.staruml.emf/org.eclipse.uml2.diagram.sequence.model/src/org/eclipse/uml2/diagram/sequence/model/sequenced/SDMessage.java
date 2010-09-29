/**
 * <copyright>
 * </copyright>
 *
 * $Id: SDMessage.java,v 1.1 2010/09/24 00:18:36 administrator Exp $
 */
package org.eclipse.uml2.diagram.sequence.model.sequenced;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Message</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDMessage#getSource <em>Source</em>}</li>
 *   <li>{@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDMessage#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.uml2.diagram.sequence.model.sequenced.SDPackage#getSDMessage()
 * @model
 * @generated
 */
public interface SDMessage extends SDAbstractMessage {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDInvocation#getOutgoingMessage <em>Outgoing Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(SDInvocation)
	 * @see org.eclipse.uml2.diagram.sequence.model.sequenced.SDPackage#getSDMessage_Source()
	 * @see org.eclipse.uml2.diagram.sequence.model.sequenced.SDInvocation#getOutgoingMessage
	 * @model opposite="outgoingMessage"
	 * @generated
	 */
	SDInvocation getSource();

	/**
	 * Sets the value of the '{@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDMessage#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(SDInvocation value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDExecution#getIncomingMessage <em>Incoming Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(SDExecution)
	 * @see org.eclipse.uml2.diagram.sequence.model.sequenced.SDPackage#getSDMessage_Target()
	 * @see org.eclipse.uml2.diagram.sequence.model.sequenced.SDExecution#getIncomingMessage
	 * @model opposite="incomingMessage"
	 * @generated
	 */
	SDExecution getTarget();

	/**
	 * Sets the value of the '{@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDMessage#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(SDExecution value);

} // SDMessage
