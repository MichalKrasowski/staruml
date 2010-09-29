/**
 * <copyright>
 * </copyright>
 *
 * $Id: SDInvocation.java,v 1.1 2010/09/24 00:18:36 administrator Exp $
 */
package org.eclipse.uml2.diagram.sequence.model.sequenced;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Invocation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDInvocation#getReceiveExecution <em>Receive Execution</em>}</li>
 *   <li>{@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDInvocation#getOutgoingMessage <em>Outgoing Message</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.uml2.diagram.sequence.model.sequenced.SDPackage#getSDInvocation()
 * @model
 * @generated
 */
public interface SDInvocation extends SDBehaviorSpec {
	/**
	 * Returns the value of the '<em><b>Receive Execution</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDExecution#getInvocation <em>Invocation</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Receive Execution</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Receive Execution</em>' reference.
	 * @see #setReceiveExecution(SDExecution)
	 * @see org.eclipse.uml2.diagram.sequence.model.sequenced.SDPackage#getSDInvocation_ReceiveExecution()
	 * @see org.eclipse.uml2.diagram.sequence.model.sequenced.SDExecution#getInvocation
	 * @model opposite="invocation" required="true"
	 * @generated
	 */
	SDExecution getReceiveExecution();

	/**
	 * Sets the value of the '{@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDInvocation#getReceiveExecution <em>Receive Execution</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Receive Execution</em>' reference.
	 * @see #getReceiveExecution()
	 * @generated
	 */
	void setReceiveExecution(SDExecution value);

	/**
	 * Returns the value of the '<em><b>Outgoing Message</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDMessage#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing Message</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing Message</em>' reference.
	 * @see #setOutgoingMessage(SDMessage)
	 * @see org.eclipse.uml2.diagram.sequence.model.sequenced.SDPackage#getSDInvocation_OutgoingMessage()
	 * @see org.eclipse.uml2.diagram.sequence.model.sequenced.SDMessage#getSource
	 * @model opposite="source" required="true"
	 * @generated
	 */
	SDMessage getOutgoingMessage();

	/**
	 * Sets the value of the '{@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDInvocation#getOutgoingMessage <em>Outgoing Message</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Outgoing Message</em>' reference.
	 * @see #getOutgoingMessage()
	 * @generated
	 */
	void setOutgoingMessage(SDMessage value);

} // SDInvocation
