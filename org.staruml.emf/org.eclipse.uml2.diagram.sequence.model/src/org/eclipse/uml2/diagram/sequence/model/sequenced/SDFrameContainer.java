/**
 * <copyright>
 * </copyright>
 *
 * $Id: SDFrameContainer.java,v 1.1 2010/09/24 00:18:36 administrator Exp $
 */
package org.eclipse.uml2.diagram.sequence.model.sequenced;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.InteractionFragment;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Frame Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDFrameContainer#getFrames <em>Frames</em>}</li>
 *   <li>{@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDFrameContainer#getFragmentsList <em>Fragments List</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.uml2.diagram.sequence.model.sequenced.SDPackage#getSDFrameContainer()
 * @model abstract="true"
 * @generated
 */
public interface SDFrameContainer extends EObject {
	/**
	 * Returns the value of the '<em><b>Frames</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDFrame}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDFrame#getFrameContainer <em>Frame Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Frames</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Frames</em>' containment reference list.
	 * @see org.eclipse.uml2.diagram.sequence.model.sequenced.SDPackage#getSDFrameContainer_Frames()
	 * @see org.eclipse.uml2.diagram.sequence.model.sequenced.SDFrame#getFrameContainer
	 * @model opposite="frameContainer" containment="true"
	 * @generated
	 */
	EList<SDFrame> getFrames();

	/**
	 * Returns the value of the '<em><b>Fragments List</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.uml2.uml.InteractionFragment}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fragments List</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fragments List</em>' reference list.
	 * @see org.eclipse.uml2.diagram.sequence.model.sequenced.SDPackage#getSDFrameContainer_FragmentsList()
	 * @model type="org.eclipse.uml2.diagram.sequence.model.sequenced.UMLInteractionFragment" resolveProxies="false" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	EList<InteractionFragment> getFragmentsList();

} // SDFrameContainer
