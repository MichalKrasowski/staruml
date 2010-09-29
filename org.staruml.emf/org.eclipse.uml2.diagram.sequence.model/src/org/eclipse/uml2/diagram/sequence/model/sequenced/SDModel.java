/**
 * <copyright>
 * </copyright>
 *
 * $Id: SDModel.java,v 1.1 2010/09/24 00:18:36 administrator Exp $
 */
package org.eclipse.uml2.diagram.sequence.model.sequenced;

import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.Interaction;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Frame</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDModel#getUmlInteraction <em>Uml Interaction</em>}</li>
 *   <li>{@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDModel#getLifelines <em>Lifelines</em>}</li>
 *   <li>{@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDModel#getMessages <em>Messages</em>}</li>
 *   <li>{@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDModel#getGates <em>Gates</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.uml2.diagram.sequence.model.sequenced.SDPackage#getSDModel()
 * @model
 * @generated
 */
public interface SDModel extends SDFrameContainer, SDEntity {
	/**
	 * Returns the value of the '<em><b>Uml Interaction</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uml Interaction</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uml Interaction</em>' reference.
	 * @see #setUmlInteraction(Interaction)
	 * @see org.eclipse.uml2.diagram.sequence.model.sequenced.SDPackage#getSDModel_UmlInteraction()
	 * @model type="org.eclipse.uml2.diagram.sequence.model.sequenced.UMLInteraction" required="true"
	 * @generated
	 */
	Interaction getUmlInteraction();

	/**
	 * Sets the value of the '{@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDModel#getUmlInteraction <em>Uml Interaction</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uml Interaction</em>' reference.
	 * @see #getUmlInteraction()
	 * @generated
	 */
	void setUmlInteraction(Interaction value);

	/**
	 * Returns the value of the '<em><b>Lifelines</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDLifeLine}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDLifeLine#getModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lifelines</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lifelines</em>' containment reference list.
	 * @see org.eclipse.uml2.diagram.sequence.model.sequenced.SDPackage#getSDModel_Lifelines()
	 * @see org.eclipse.uml2.diagram.sequence.model.sequenced.SDLifeLine#getModel
	 * @model opposite="model" containment="true"
	 * @generated
	 */
	EList<SDLifeLine> getLifelines();

	/**
	 * Returns the value of the '<em><b>Messages</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDAbstractMessage}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDAbstractMessage#getModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Messages</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Messages</em>' containment reference list.
	 * @see org.eclipse.uml2.diagram.sequence.model.sequenced.SDPackage#getSDModel_Messages()
	 * @see org.eclipse.uml2.diagram.sequence.model.sequenced.SDAbstractMessage#getModel
	 * @model opposite="model" containment="true"
	 * @generated
	 */
	EList<SDAbstractMessage> getMessages();

	/**
	 * Returns the value of the '<em><b>Gates</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDGate}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gates</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gates</em>' containment reference list.
	 * @see org.eclipse.uml2.diagram.sequence.model.sequenced.SDPackage#getSDModel_Gates()
	 * @model containment="true"
	 * @generated
	 */
	EList<SDGate> getGates();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" type="org.eclipse.uml2.diagram.sequence.model.sequenced.SDTrace"
	 * @generated
	 */
	SDTrace getUMLTracing();

} // SDFrame
