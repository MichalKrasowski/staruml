/**
 * <copyright>
 * </copyright>
 *
 * $Id: SDExecution.java,v 1.1 2010/09/24 00:18:36 administrator Exp $
 */
package org.eclipse.uml2.diagram.sequence.model.sequenced;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Execution</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDExecution#getInvocation <em>Invocation</em>}</li>
 *   <li>{@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDExecution#getIncomingMessage <em>Incoming Message</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.uml2.diagram.sequence.model.sequenced.SDPackage#getSDExecution()
 * @model
 * @generated
 */
public interface SDExecution extends SDBehaviorSpec {
	/**
	 * Returns the value of the '<em><b>Invocation</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDInvocation#getReceiveExecution <em>Receive Execution</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Invocation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Invocation</em>' reference.
	 * @see #setInvocation(SDInvocation)
	 * @see org.eclipse.uml2.diagram.sequence.model.sequenced.SDPackage#getSDExecution_Invocation()
	 * @see org.eclipse.uml2.diagram.sequence.model.sequenced.SDInvocation#getReceiveExecution
	 * @model opposite="receiveExecution" required="true"
	 * @generated
	 */
	SDInvocation getInvocation();

	/**
	 * Sets the value of the '{@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDExecution#getInvocation <em>Invocation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Invocation</em>' reference.
	 * @see #getInvocation()
	 * @generated
	 */
	void setInvocation(SDInvocation value);

	/**
	 * Returns the value of the '<em><b>Incoming Message</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDMessage#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming Message</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming Message</em>' reference.
	 * @see #setIncomingMessage(SDMessage)
	 * @see org.eclipse.uml2.diagram.sequence.model.sequenced.SDPackage#getSDExecution_IncomingMessage()
	 * @see org.eclipse.uml2.diagram.sequence.model.sequenced.SDMessage#getTarget
	 * @model opposite="target" required="true"
	 * @generated
	 */
	SDMessage getIncomingMessage();

	/**
	 * Sets the value of the '{@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDExecution#getIncomingMessage <em>Incoming Message</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Incoming Message</em>' reference.
	 * @see #getIncomingMessage()
	 * @generated
	 */
	void setIncomingMessage(SDMessage value);

} // SDExecution
