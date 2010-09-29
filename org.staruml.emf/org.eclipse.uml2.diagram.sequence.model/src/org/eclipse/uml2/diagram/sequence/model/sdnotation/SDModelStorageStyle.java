/**
 * <copyright>
 * </copyright>
 *
 * $Id: SDModelStorageStyle.java,v 1.1 2010/09/24 00:18:38 administrator Exp $
 */
package org.eclipse.uml2.diagram.sequence.model.sdnotation;

import org.eclipse.gmf.runtime.notation.Style;

import org.eclipse.uml2.diagram.sequence.model.sequenced.SDModel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SD Model Storage Style</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.uml2.diagram.sequence.model.sdnotation.SDModelStorageStyle#getVersion <em>Version</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.uml2.diagram.sequence.model.sdnotation.SDNotationPackage#getSDModelStorageStyle()
 * @model
 * @generated
 */
public interface SDModelStorageStyle extends Style {
	/**
	 * Returns the value of the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' attribute.
	 * @see #setVersion(int)
	 * @see org.eclipse.uml2.diagram.sequence.model.sdnotation.SDNotationPackage#getSDModelStorageStyle_Version()
	 * @model transient="true"
	 * @generated
	 */
	int getVersion();

	/**
	 * Sets the value of the '{@link org.eclipse.uml2.diagram.sequence.model.sdnotation.SDModelStorageStyle#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(int value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	SDModel getAttachedModel();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void invalidateModel();

} // SDModelStorageStyle
