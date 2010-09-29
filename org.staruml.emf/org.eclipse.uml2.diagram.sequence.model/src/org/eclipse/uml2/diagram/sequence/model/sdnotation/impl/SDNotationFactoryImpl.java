/**
 * <copyright>
 * </copyright>
 *
 * $Id: SDNotationFactoryImpl.java,v 1.1 2010/09/24 00:18:36 administrator Exp $
 */
package org.eclipse.uml2.diagram.sequence.model.sdnotation.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.uml2.diagram.sequence.model.sdnotation.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SDNotationFactoryImpl extends EFactoryImpl implements SDNotationFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SDNotationFactory init() {
		try {
			SDNotationFactory theSDNotationFactory = (SDNotationFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/mdt/uml2tools/sequence-diagram/notation/2008"); 
			if (theSDNotationFactory != null) {
				return theSDNotationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SDNotationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SDNotationFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case SDNotationPackage.SD_MODEL_STORAGE_STYLE: return createSDModelStorageStyle();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SDModelStorageStyle createSDModelStorageStyle() {
		SDModelStorageStyleImpl sdModelStorageStyle = new SDModelStorageStyleImpl();
		return sdModelStorageStyle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SDNotationPackage getSDNotationPackage() {
		return (SDNotationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SDNotationPackage getPackage() {
		return SDNotationPackage.eINSTANCE;
	}

} //SDNotationFactoryImpl
