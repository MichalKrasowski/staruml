/**
 * <copyright>
 * </copyright>
 *
 * $Id: SDBehaviorSpec.java,v 1.1 2010/09/24 00:18:36 administrator Exp $
 */
package org.eclipse.uml2.diagram.sequence.model.sequenced;

import org.eclipse.uml2.uml.ExecutionSpecification;
import org.eclipse.uml2.uml.OccurrenceSpecification;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Behavior Spec</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDBehaviorSpec#getUmlExecutionSpec <em>Uml Execution Spec</em>}</li>
 *   <li>{@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDBehaviorSpec#getUmlStart <em>Uml Start</em>}</li>
 *   <li>{@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDBehaviorSpec#getUmlFinish <em>Uml Finish</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.uml2.diagram.sequence.model.sequenced.SDPackage#getSDBehaviorSpec()
 * @model abstract="true"
 * @generated
 */
public interface SDBehaviorSpec extends SDBracket, SDBracketContainer {
	/**
	 * Returns the value of the '<em><b>Uml Execution Spec</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uml Execution Spec</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uml Execution Spec</em>' reference.
	 * @see #setUmlExecutionSpec(ExecutionSpecification)
	 * @see org.eclipse.uml2.diagram.sequence.model.sequenced.SDPackage#getSDBehaviorSpec_UmlExecutionSpec()
	 * @model type="org.eclipse.uml2.diagram.sequence.model.sequenced.UMLExecutionSpecification"
	 * @generated
	 */
	ExecutionSpecification getUmlExecutionSpec();

	/**
	 * Sets the value of the '{@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDBehaviorSpec#getUmlExecutionSpec <em>Uml Execution Spec</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uml Execution Spec</em>' reference.
	 * @see #getUmlExecutionSpec()
	 * @generated
	 */
	void setUmlExecutionSpec(ExecutionSpecification value);

	/**
	 * Returns the value of the '<em><b>Uml Start</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uml Start</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uml Start</em>' reference.
	 * @see #setUmlStart(OccurrenceSpecification)
	 * @see org.eclipse.uml2.diagram.sequence.model.sequenced.SDPackage#getSDBehaviorSpec_UmlStart()
	 * @model type="org.eclipse.uml2.diagram.sequence.model.sequenced.UMLOccurrenceSpecification"
	 * @generated
	 */
	OccurrenceSpecification getUmlStart();

	/**
	 * Sets the value of the '{@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDBehaviorSpec#getUmlStart <em>Uml Start</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uml Start</em>' reference.
	 * @see #getUmlStart()
	 * @generated
	 */
	void setUmlStart(OccurrenceSpecification value);

	/**
	 * Returns the value of the '<em><b>Uml Finish</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uml Finish</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uml Finish</em>' reference.
	 * @see #setUmlFinish(OccurrenceSpecification)
	 * @see org.eclipse.uml2.diagram.sequence.model.sequenced.SDPackage#getSDBehaviorSpec_UmlFinish()
	 * @model type="org.eclipse.uml2.diagram.sequence.model.sequenced.UMLOccurrenceSpecification"
	 * @generated
	 */
	OccurrenceSpecification getUmlFinish();

	/**
	 * Sets the value of the '{@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDBehaviorSpec#getUmlFinish <em>Uml Finish</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uml Finish</em>' reference.
	 * @see #getUmlFinish()
	 * @generated
	 */
	void setUmlFinish(OccurrenceSpecification value);

} // SDBehaviorSpec
