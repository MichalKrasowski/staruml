/**
 * <copyright>
 * </copyright>
 *
 * $Id: SDNotationPackage.java,v 1.1 2010/09/24 00:18:38 administrator Exp $
 */
package org.eclipse.uml2.diagram.sequence.model.sdnotation;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.gmf.runtime.notation.NotationPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.uml2.diagram.sequence.model.sdnotation.SDNotationFactory
 * @model kind="package"
 * @generated
 */
public interface SDNotationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "sdnotation";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/mdt/uml2tools/sequence-diagram/notation/2008";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "uml2t.seqd.notation";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SDNotationPackage eINSTANCE = org.eclipse.uml2.diagram.sequence.model.sdnotation.impl.SDNotationPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.uml2.diagram.sequence.model.sdnotation.impl.SDModelStorageStyleImpl <em>SD Model Storage Style</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.diagram.sequence.model.sdnotation.impl.SDModelStorageStyleImpl
	 * @see org.eclipse.uml2.diagram.sequence.model.sdnotation.impl.SDNotationPackageImpl#getSDModelStorageStyle()
	 * @generated
	 */
	int SD_MODEL_STORAGE_STYLE = 0;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SD_MODEL_STORAGE_STYLE__VERSION = NotationPackage.STYLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>SD Model Storage Style</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SD_MODEL_STORAGE_STYLE_FEATURE_COUNT = NotationPackage.STYLE_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link org.eclipse.uml2.diagram.sequence.model.sdnotation.SDModelStorageStyle <em>SD Model Storage Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SD Model Storage Style</em>'.
	 * @see org.eclipse.uml2.diagram.sequence.model.sdnotation.SDModelStorageStyle
	 * @generated
	 */
	EClass getSDModelStorageStyle();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.uml2.diagram.sequence.model.sdnotation.SDModelStorageStyle#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see org.eclipse.uml2.diagram.sequence.model.sdnotation.SDModelStorageStyle#getVersion()
	 * @see #getSDModelStorageStyle()
	 * @generated
	 */
	EAttribute getSDModelStorageStyle_Version();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SDNotationFactory getSDNotationFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.uml2.diagram.sequence.model.sdnotation.impl.SDModelStorageStyleImpl <em>SD Model Storage Style</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.uml2.diagram.sequence.model.sdnotation.impl.SDModelStorageStyleImpl
		 * @see org.eclipse.uml2.diagram.sequence.model.sdnotation.impl.SDNotationPackageImpl#getSDModelStorageStyle()
		 * @generated
		 */
		EClass SD_MODEL_STORAGE_STYLE = eINSTANCE.getSDModelStorageStyle();
		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SD_MODEL_STORAGE_STYLE__VERSION = eINSTANCE.getSDModelStorageStyle_Version();

	}

} //SDNotationPackage
