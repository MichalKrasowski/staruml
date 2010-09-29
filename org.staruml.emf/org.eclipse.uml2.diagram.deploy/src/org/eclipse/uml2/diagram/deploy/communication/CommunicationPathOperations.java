package org.eclipse.uml2.diagram.deploy.communication;

import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Artifact;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.AssociationClass;
import org.eclipse.uml2.uml.CommunicationPath;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.StructuredClassifier;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.util.UMLSwitch;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * In contrast to Associations, UML2 API does not contain any helpers for
 * creation of the Communication paths.
 * 
 * We have to mimic the logic for their creation from the UML2 Association
 * helpers.
 * 
 * @see TypeOperation
 */
public class CommunicationPathOperations extends UMLUtil {

	/**
	 * Its almost exact copy of the TypeOperations#createAssociation helper,
	 * except the only difference -- instead of Association we are creating more
	 * specific instance of CommunicationPath
	 */
	public static CommunicationPath createCommunicationPath(Type type, boolean end1IsNavigable, AggregationKind end1Aggregation, String end1Name, int end1Lower, int end1Upper, Type end1Type,
			boolean end2IsNavigable, AggregationKind end2Aggregation, String end2Name, int end2Lower, int end2Upper) {

		org.eclipse.uml2.uml.Package package_ = type.getNearestPackage();

		if (package_ == null) {
			throw new IllegalStateException();
		}

		if (end1Aggregation == null) {
			throw new IllegalArgumentException(String.valueOf(end1Aggregation));
		}

		if (end2Aggregation == null) {
			throw new IllegalArgumentException(String.valueOf(end2Aggregation));
		}

		/*
		 * The only difference is here -- see literal
		 */
		CommunicationPath association = (CommunicationPath) package_.createOwnedType(null, UMLPackage.Literals.COMMUNICATION_PATH);

		createAssociationEnd(type, association, end1IsNavigable, end1Aggregation, end1Name, end1Lower, end1Upper, end1Type);

		createAssociationEnd(end1Type, association, end2IsNavigable, end2Aggregation, end2Name, end2Lower, end2Upper, type);

		return association;
	}

	protected static Property createAssociationEnd(Type type, Association association, boolean isNavigable, AggregationKind aggregation, String name, int lower, int upper, Type endType) {
		EList<Property> ownedAttributes = getOwnedAttributes(type);
		Property associationEnd = createOwnedProperty(ownedAttributes == null || !isNavigable ? association : type, name, endType, lower, upper);

		associationEnd.setAggregation(aggregation);

		if (isNavigable) {

			if (ownedAttributes == null) {
				association.getNavigableOwnedEnds().add(associationEnd);
			} else {
				association.getMemberEnds().add(associationEnd);
			}
		}

		return associationEnd;
	}

	private static Property createOwnedProperty(Type type, final String name, final Type propertyType, int lower, int upper) {
		Property ownedProperty = new UMLSwitch<Property>() {

			@Override
			public Property caseArtifact(Artifact artifact) {
				return artifact.createOwnedAttribute(name, propertyType);
			}

			@Override
			public Property caseAssociation(Association association) {
				return association.createOwnedEnd(name, propertyType);
			}

			@Override
			public Property caseAssociationClass(AssociationClass associationClass) {
				return associationClass.createOwnedAttribute(name, propertyType);
			}

			@Override
			public Property caseDataType(DataType dataType) {
				return dataType.createOwnedAttribute(name, propertyType);
			}

			@Override
			public Property caseInterface(Interface interface_) {
				return interface_.createOwnedAttribute(name, propertyType);
			}

			@Override
			public Property caseSignal(Signal signal) {
				return signal.createOwnedAttribute(name, propertyType);
			}

			@Override
			public Property caseStructuredClassifier(StructuredClassifier structuredClassifier) {
				return structuredClassifier.createOwnedAttribute(name, propertyType);
			}
		}.doSwitch(type);

		ownedProperty.setLower(lower);
		ownedProperty.setUpper(upper);

		return ownedProperty;
	}

}
