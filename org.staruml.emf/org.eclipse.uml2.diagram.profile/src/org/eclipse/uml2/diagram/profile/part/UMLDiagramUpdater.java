package org.eclipse.uml2.diagram.profile.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.common.genapi.IDiagramUpdater;
import org.eclipse.uml2.diagram.common.genapi.IUpdaterLinkDescriptor;
import org.eclipse.uml2.diagram.common.genapi.IUpdaterNodeDescriptor;
import org.eclipse.uml2.diagram.profile.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.CommentEditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.Constraint2EditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.ConstraintConstrainedElementEditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.ConstraintEditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.ElementImport2EditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.ElementImportEditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.EnumerationEditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.EnumerationLiteralEditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.EnumerationLiteralsEditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.ExtensionEditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.GeneralizationEditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.ImageEditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.Profile2EditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.Profile3EditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.ProfileContentsEditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.ProfileEditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.ProfileProfileLabelsEditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.PropertyEditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.Stereotype2EditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.StereotypeAttributesEditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.StereotypeConstraintsEditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.StereotypeEditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.StereotypeImagesEditPart;
import org.eclipse.uml2.diagram.profile.providers.UMLElementTypes;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Extension;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.Image;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
@SuppressWarnings("unchecked")
public class UMLDiagramUpdater {

	/**
	 * @generated
	 */
	public static boolean isShortcutOrphaned(View view) {
		return !view.isSetElement() || view.getElement() == null || view.getElement().eIsProxy();
	}

	/**
	 * @generated
	 */
	public static List getSemanticChildren(View view) {
		switch (UMLVisualIDRegistry.getVisualID(view)) {
		case StereotypeAttributesEditPart.VISUAL_ID:
			return getStereotypeAttributes_7001SemanticChildren(view);
		case StereotypeConstraintsEditPart.VISUAL_ID:
			return getStereotypeConstraints_7002SemanticChildren(view);
		case StereotypeImagesEditPart.VISUAL_ID:
			return getStereotypeImages_7006SemanticChildren(view);
		case ProfileContentsEditPart.VISUAL_ID:
			return getProfileContents_7003SemanticChildren(view);
		case EnumerationLiteralsEditPart.VISUAL_ID:
			return getEnumerationLiterals_7004SemanticChildren(view);
		case ProfileProfileLabelsEditPart.VISUAL_ID:
			return getProfileProfile_imports_7005SemanticChildren(view);
		case ProfileEditPart.VISUAL_ID: {
			//We have "dummy" TopLevelNode (with vid = org.eclipse.uml2.diagram.profile.edit.parts.Profile3EditPart.VISUAL_ID). 
			//The only purpose for this node is to be a container for children (imports, etc)
			//of the "main" diagram figure (that one shown as Canvas).
			//Also we have modified the VisualIDRegistry#getNodeVisualID() to return
			//VID = org.eclipse.uml2.diagram.profile.edit.parts.Profile3EditPart.VISUAL_ID, 
			//for the case when top-level view is created for the same semantic element as the canvas view.

			List resultAndHeader = new LinkedList();
			resultAndHeader.add(new UMLNodeDescriptor(view.getElement(), Profile3EditPart.VISUAL_ID));
			resultAndHeader.addAll(getProfile_1000SemanticChildren(view));
			return resultAndHeader;
		}
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getStereotypeAttributes_7001SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Stereotype modelElement = (Stereotype) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == PropertyEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getStereotypeConstraints_7002SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Stereotype modelElement = (Stereotype) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getOwnedRules().iterator(); it.hasNext();) {
			Constraint childElement = (Constraint) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == ConstraintEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getStereotypeImages_7006SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Stereotype modelElement = (Stereotype) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getIcons().iterator(); it.hasNext();) {
			Image childElement = (Image) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == ImageEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getProfileContents_7003SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Profile modelElement = (Profile) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getPackagedElements().iterator(); it.hasNext();) {
			PackageableElement childElement = (PackageableElement) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == Stereotype2EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEnumerationLiterals_7004SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Enumeration modelElement = (Enumeration) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getOwnedLiterals().iterator(); it.hasNext();) {
			EnumerationLiteral childElement = (EnumerationLiteral) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == EnumerationLiteralEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getProfileProfile_imports_7005SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Profile modelElement = (Profile) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getElementImports().iterator(); it.hasNext();) {
			ElementImport childElement = (ElementImport) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == ElementImport2EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getProfile_1000SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Profile modelElement = (Profile) view.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getOwnedStereotypes().iterator(); it.hasNext();) {
			Stereotype childElement = (Stereotype) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == StereotypeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator it = modelElement.getPackagedElements().iterator(); it.hasNext();) {
			PackageableElement childElement = (PackageableElement) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == Profile2EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == Constraint2EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator it = modelElement.getOwnedTypes().iterator(); it.hasNext();) {
			Type childElement = (Type) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == EnumerationEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator it = modelElement.getMetaclassReferences().iterator(); it.hasNext();) {
			ElementImport childElement = (ElementImport) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == ElementImportEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator it = modelElement.getOwnedComments().iterator(); it.hasNext();) {
			Comment childElement = (Comment) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == CommentEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getContainedLinks(View view) {
		switch (UMLVisualIDRegistry.getVisualID(view)) {
		case ProfileEditPart.VISUAL_ID:
			return getProfile_1000ContainedLinks(view);
		case StereotypeEditPart.VISUAL_ID:
			return getStereotype_2001ContainedLinks(view);
		case Profile2EditPart.VISUAL_ID:
			return getProfile_2002ContainedLinks(view);
		case EnumerationEditPart.VISUAL_ID:
			return getEnumeration_2003ContainedLinks(view);
		case ElementImportEditPart.VISUAL_ID:
			return getElementImport_2006ContainedLinks(view);
		case Profile3EditPart.VISUAL_ID:
			return getProfile_2007ContainedLinks(view);
		case Constraint2EditPart.VISUAL_ID:
			return getConstraint_2008ContainedLinks(view);
		case CommentEditPart.VISUAL_ID:
			return getComment_2009ContainedLinks(view);
		case PropertyEditPart.VISUAL_ID:
			return getProperty_3001ContainedLinks(view);
		case ConstraintEditPart.VISUAL_ID:
			return getConstraint_3008ContainedLinks(view);
		case ImageEditPart.VISUAL_ID:
			return getImage_3010ContainedLinks(view);
		case Stereotype2EditPart.VISUAL_ID:
			return getStereotype_3003ContainedLinks(view);
		case EnumerationLiteralEditPart.VISUAL_ID:
			return getEnumerationLiteral_3005ContainedLinks(view);
		case ElementImport2EditPart.VISUAL_ID:
			return getElementImport_3009ContainedLinks(view);
		case GeneralizationEditPart.VISUAL_ID:
			return getGeneralization_4001ContainedLinks(view);
		case ExtensionEditPart.VISUAL_ID:
			return getExtension_4002ContainedLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIncomingLinks(View view) {
		switch (UMLVisualIDRegistry.getVisualID(view)) {
		case StereotypeEditPart.VISUAL_ID:
			return getStereotype_2001IncomingLinks(view);
		case Profile2EditPart.VISUAL_ID:
			return getProfile_2002IncomingLinks(view);
		case EnumerationEditPart.VISUAL_ID:
			return getEnumeration_2003IncomingLinks(view);
		case ElementImportEditPart.VISUAL_ID:
			return getElementImport_2006IncomingLinks(view);
		case Profile3EditPart.VISUAL_ID:
			return getProfile_2007IncomingLinks(view);
		case Constraint2EditPart.VISUAL_ID:
			return getConstraint_2008IncomingLinks(view);
		case CommentEditPart.VISUAL_ID:
			return getComment_2009IncomingLinks(view);
		case PropertyEditPart.VISUAL_ID:
			return getProperty_3001IncomingLinks(view);
		case ConstraintEditPart.VISUAL_ID:
			return getConstraint_3008IncomingLinks(view);
		case ImageEditPart.VISUAL_ID:
			return getImage_3010IncomingLinks(view);
		case Stereotype2EditPart.VISUAL_ID:
			return getStereotype_3003IncomingLinks(view);
		case EnumerationLiteralEditPart.VISUAL_ID:
			return getEnumerationLiteral_3005IncomingLinks(view);
		case ElementImport2EditPart.VISUAL_ID:
			return getElementImport_3009IncomingLinks(view);
		case GeneralizationEditPart.VISUAL_ID:
			return getGeneralization_4001IncomingLinks(view);
		case ExtensionEditPart.VISUAL_ID:
			return getExtension_4002IncomingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOutgoingLinks(View view) {
		switch (UMLVisualIDRegistry.getVisualID(view)) {
		case StereotypeEditPart.VISUAL_ID:
			return getStereotype_2001OutgoingLinks(view);
		case Profile2EditPart.VISUAL_ID:
			return getProfile_2002OutgoingLinks(view);
		case EnumerationEditPart.VISUAL_ID:
			return getEnumeration_2003OutgoingLinks(view);
		case ElementImportEditPart.VISUAL_ID:
			return getElementImport_2006OutgoingLinks(view);
		case Profile3EditPart.VISUAL_ID:
			return getProfile_2007OutgoingLinks(view);
		case Constraint2EditPart.VISUAL_ID:
			return getConstraint_2008OutgoingLinks(view);
		case CommentEditPart.VISUAL_ID:
			return getComment_2009OutgoingLinks(view);
		case PropertyEditPart.VISUAL_ID:
			return getProperty_3001OutgoingLinks(view);
		case ConstraintEditPart.VISUAL_ID:
			return getConstraint_3008OutgoingLinks(view);
		case ImageEditPart.VISUAL_ID:
			return getImage_3010OutgoingLinks(view);
		case Stereotype2EditPart.VISUAL_ID:
			return getStereotype_3003OutgoingLinks(view);
		case EnumerationLiteralEditPart.VISUAL_ID:
			return getEnumerationLiteral_3005OutgoingLinks(view);
		case ElementImport2EditPart.VISUAL_ID:
			return getElementImport_3009OutgoingLinks(view);
		case GeneralizationEditPart.VISUAL_ID:
			return getGeneralization_4001OutgoingLinks(view);
		case ExtensionEditPart.VISUAL_ID:
			return getExtension_4002OutgoingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getStereotype_2001ContainedLinks(View view) {
		Stereotype modelElement = (Stereotype) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getProfile_2002ContainedLinks(View view) {
		Profile modelElement = (Profile) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Extension_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEnumeration_2003ContainedLinks(View view) {
		Enumeration modelElement = (Enumeration) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getElementImport_2006ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getProfile_2007ContainedLinks(View view) {
		//no links to, from and inside the diagram header
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getConstraint_2008ContainedLinks(View view) {
		Constraint modelElement = (Constraint) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getComment_2009ContainedLinks(View view) {
		Comment modelElement = (Comment) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getProperty_3001ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getConstraint_3008ContainedLinks(View view) {
		Constraint modelElement = (Constraint) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getImage_3010ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getStereotype_3003ContainedLinks(View view) {
		Stereotype modelElement = (Stereotype) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEnumerationLiteral_3005ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getElementImport_3009ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getGeneralization_4001ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getExtension_4002ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getStereotype_2001IncomingLinks(View view) {
		Stereotype modelElement = (Stereotype) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4001(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4004(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getProfile_2002IncomingLinks(View view) {
		Profile modelElement = (Profile) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4004(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEnumeration_2003IncomingLinks(View view) {
		Enumeration modelElement = (Enumeration) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4001(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4004(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getElementImport_2006IncomingLinks(View view) {
		ElementImport modelElement = (ElementImport) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Extension_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4004(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getProfile_2007IncomingLinks(View view) {
		//no links to, from and inside the diagram header
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getConstraint_2008IncomingLinks(View view) {
		Constraint modelElement = (Constraint) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4004(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getComment_2009IncomingLinks(View view) {
		Comment modelElement = (Comment) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4004(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getProperty_3001IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getConstraint_3008IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getImage_3010IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getStereotype_3003IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getEnumerationLiteral_3005IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getElementImport_3009IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getGeneralization_4001IncomingLinks(View view) {
		Generalization modelElement = (Generalization) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4004(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getExtension_4002IncomingLinks(View view) {
		Extension modelElement = (Extension) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4001(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4004(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getStereotype_2001OutgoingLinks(View view) {
		Stereotype modelElement = (Stereotype) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Extension_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getProfile_2002OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getEnumeration_2003OutgoingLinks(View view) {
		Enumeration modelElement = (Enumeration) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getElementImport_2006OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getProfile_2007OutgoingLinks(View view) {
		//no links to, from and inside the diagram header
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getConstraint_2008OutgoingLinks(View view) {
		Constraint modelElement = (Constraint) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getComment_2009OutgoingLinks(View view) {
		Comment modelElement = (Comment) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getProperty_3001OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getConstraint_3008OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getImage_3010OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getStereotype_3003OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getEnumerationLiteral_3005OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getElementImport_3009OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getGeneralization_4001OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getExtension_4002OutgoingLinks(View view) {
		Extension modelElement = (Extension) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_Generalization_4001(Classifier container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getGeneralizations().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Generalization) {
				continue;
			}
			Generalization link = (Generalization) linkObject;
			if (GeneralizationEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Classifier dst = link.getGeneral();
			result.add(new UMLLinkDescriptor(container, dst, link, UMLElementTypes.Generalization_4001, GeneralizationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated NOT
	 */
	private static Collection getContainedTypeModelFacetLinks_Extension_4002(Package container) {
		if (false == container instanceof Profile) {
			return Collections.emptyList();
		}
		Profile profile = (Profile) container;

		Collection result = new LinkedList();
		for (Extension link : profile.getOwnedExtensions(false)) {
			if (ExtensionEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}

			Stereotype stereotype = link.getStereotype();
			Classifier metaclass = link.getMetaclass();
			ElementImport metaclassImport = profile.getElementImport(metaclass, false);
			if (stereotype != null && metaclassImport != null) {
				result.add(new UMLLinkDescriptor(stereotype, metaclassImport, link, UMLElementTypes.Extension_4002, ExtensionEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_Generalization_4001(Classifier target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getGeneralization_General() || false == setting.getEObject() instanceof Generalization) {
				continue;
			}
			Generalization link = (Generalization) setting.getEObject();
			if (GeneralizationEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			if (false == link.eContainer() instanceof Classifier) {
				continue;
			}
			Classifier container = (Classifier) link.eContainer();
			result.add(new UMLLinkDescriptor(container, target, link, UMLElementTypes.Generalization_4001, GeneralizationEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated NOT
	 */
	private static Collection getIncomingTypeModelFacetLinks_Extension_4002(ElementImport target, Map crossReferences) {
		if (false == target.getImportedElement() instanceof org.eclipse.uml2.uml.Class) {
			return Collections.emptyList();
		}

		org.eclipse.uml2.uml.Class metaclass = (org.eclipse.uml2.uml.Class) target.getImportedElement();
		if (!metaclass.isMetaclass()) {
			return Collections.emptyList();
		}

		Collection result = new LinkedList();
		for (Extension nextLink : metaclass.getExtensions()) {
			if (ExtensionEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(nextLink)) {
				continue;
			}
			Stereotype nextStereotype = nextLink.getStereotype();
			result.add(new UMLLinkDescriptor(nextStereotype, target, nextLink, UMLElementTypes.Extension_4002, ExtensionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(Element target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() == UMLPackage.eINSTANCE.getConstraint_ConstrainedElement()) {
				result.add(new UMLLinkDescriptor(setting.getEObject(), target, UMLElementTypes.ConstraintConstrainedElement_4003, ConstraintConstrainedElementEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4004(Element target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() == UMLPackage.eINSTANCE.getComment_AnnotatedElement()) {
				result.add(new UMLLinkDescriptor(setting.getEObject(), target, UMLElementTypes.CommentAnnotatedElement_4004, CommentAnnotatedElementEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated NOT
	 */
	private static Collection getOutgoingTypeModelFacetLinks_Extension_4002(Stereotype source) {
		Profile profile = source.getProfile();
		if (profile == null) {
			return Collections.EMPTY_LIST;
		}
		//we need link object, we can not just use source.getExtendedMetaclasses()
		Collection result = new LinkedList();
		for (Extension nextLink : profile.getOwnedExtensions(false)) {
			if (ExtensionEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(nextLink)) {
				continue;
			}
			if (!source.equals(nextLink.getStereotype())) {
				continue;
			}
			Classifier metaclass = nextLink.getMetaclass();
			ElementImport metaclassImport = profile.getElementImport(metaclass, false);
			if (metaclassImport != null) {
				result.add(new UMLLinkDescriptor(source, metaclassImport, nextLink, UMLElementTypes.Extension_4002, ExtensionEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(Constraint source) {
		Collection result = new LinkedList();
		for (Iterator destinations = source.getConstrainedElements().iterator(); destinations.hasNext();) {
			Element destination = (Element) destinations.next();
			result.add(new UMLLinkDescriptor(source, destination, UMLElementTypes.ConstraintConstrainedElement_4003, ConstraintConstrainedElementEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_4004(Comment source) {
		Collection result = new LinkedList();
		for (Iterator destinations = source.getAnnotatedElements().iterator(); destinations.hasNext();) {
			Element destination = (Element) destinations.next();
			result.add(new UMLLinkDescriptor(source, destination, UMLElementTypes.CommentAnnotatedElement_4004, CommentAnnotatedElementEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getProfile_1000ContainedLinks(View view) {
		Profile modelElement = (Profile) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Extension_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static final IDiagramUpdater TYPED_ADAPTER = new IDiagramUpdater() {

		/**
		 * @generated
		 */
		public List<IUpdaterNodeDescriptor> getSemanticChildren(View view) {
			return org.eclipse.uml2.diagram.profile.part.UMLDiagramUpdater.getSemanticChildren(view);
		}

		/**
		 * @generated
		 */
		public List<IUpdaterLinkDescriptor> getContainedLinks(View view) {
			return org.eclipse.uml2.diagram.profile.part.UMLDiagramUpdater.getContainedLinks(view);
		}

		/**
		 * @generated
		 */
		public List<IUpdaterLinkDescriptor> getIncomingLinks(View view) {
			return org.eclipse.uml2.diagram.profile.part.UMLDiagramUpdater.getIncomingLinks(view);
		}

		/**
		 * @generated
		 */
		public List<IUpdaterLinkDescriptor> getOutgoingLinks(View view) {
			return org.eclipse.uml2.diagram.profile.part.UMLDiagramUpdater.getOutgoingLinks(view);
		}
	};

}
