package org.eclipse.uml2.diagram.deploy.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.common.conventions.AssociationEndConvention;
import org.eclipse.uml2.diagram.common.genapi.IDiagramUpdater;
import org.eclipse.uml2.diagram.common.genapi.IUpdaterLinkDescriptor;
import org.eclipse.uml2.diagram.common.genapi.IUpdaterNodeDescriptor;
import org.eclipse.uml2.diagram.deploy.edit.parts.Artifact2EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.Artifact3EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.Artifact4EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.ArtifactArtifactFigure_contents2EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.ArtifactArtifactFigure_contents3EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.ArtifactArtifactFigure_contentsEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.ArtifactEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.CommentEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.CommunicationPathEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.DependencyEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.DeploymentConfigurationEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.DeploymentEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.DeploymentSpecification2EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.DeploymentSpecificationEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.DeploymentSpecificationProperties2EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.DeploymentSpecificationPropertiesEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.Device2EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.DeviceDevicecontents2EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.DeviceDevicecontentsEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.DeviceEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.ElementImportEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.ExecutionEnvironment2EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.ExecutionEnvironmentArtifacts2EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.ExecutionEnvironmentArtifactsEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.ExecutionEnvironmentEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.ManifestationEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.Node2EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.NodeEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.Package2EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.PackageEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.PackageImportsEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.PropertyEditPart;
import org.eclipse.uml2.diagram.deploy.providers.UMLElementTypes;
import org.eclipse.uml2.uml.Artifact;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.CommunicationPath;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.DeployedArtifact;
import org.eclipse.uml2.uml.Deployment;
import org.eclipse.uml2.uml.DeploymentSpecification;
import org.eclipse.uml2.uml.DeploymentTarget;
import org.eclipse.uml2.uml.Device;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.ExecutionEnvironment;
import org.eclipse.uml2.uml.Manifestation;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Node;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Property;
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
		case PackageImportsEditPart.VISUAL_ID:
			return getPackageImports_7001SemanticChildren(view);
		case DeviceDevicecontentsEditPart.VISUAL_ID:
			return getDeviceDevicecontents_7004SemanticChildren(view);
		case DeviceDevicecontents2EditPart.VISUAL_ID:
			return getDeviceDevicecontents_7005SemanticChildren(view);
		case ArtifactArtifactFigure_contentsEditPart.VISUAL_ID:
			return getArtifactArtifactFigure_contents_7007SemanticChildren(view);
		case ArtifactArtifactFigure_contents2EditPart.VISUAL_ID:
			return getArtifactArtifactFigure_contents_7008SemanticChildren(view);
		case DeploymentSpecificationProperties2EditPart.VISUAL_ID:
			return getDeploymentSpecificationProperties_7010SemanticChildren(view);
		case ExecutionEnvironmentArtifacts2EditPart.VISUAL_ID:
			return getExecutionEnvironmentArtifacts_7006SemanticChildren(view);
		case ExecutionEnvironmentArtifactsEditPart.VISUAL_ID:
			return getExecutionEnvironmentArtifacts_7002SemanticChildren(view);
		case ArtifactArtifactFigure_contents3EditPart.VISUAL_ID:
			return getArtifactArtifactFigure_contents_7009SemanticChildren(view);
		case DeploymentSpecificationPropertiesEditPart.VISUAL_ID:
			return getDeploymentSpecificationProperties_7003SemanticChildren(view);
		case PackageEditPart.VISUAL_ID: {
			//We have "dummy" TopLevelNode (with vid = org.eclipse.uml2.diagram.deploy.edit.parts.Package2EditPart.VISUAL_ID). 
			//The only purpose for this node is to be a container for children (imports, etc)
			//of the "main" diagram figure (that one shown as Canvas).
			//Also we have modified the VisualIDRegistry#getNodeVisualID() to return
			//VID = org.eclipse.uml2.diagram.deploy.edit.parts.Package2EditPart.VISUAL_ID, 
			//for the case when top-level view is created for the same semantic element as the canvas view.

			List resultAndHeader = new LinkedList();
			resultAndHeader.add(new UMLNodeDescriptor(view.getElement(), Package2EditPart.VISUAL_ID));
			resultAndHeader.addAll(getPackage_1000SemanticChildren(view));
			return resultAndHeader;
		}
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getPackageImports_7001SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Package modelElement = (Package) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getElementImports().iterator(); it.hasNext();) {
			ElementImport childElement = (ElementImport) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == ElementImportEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDeviceDevicecontents_7004SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Device modelElement = (Device) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getNestedNodes().iterator(); it.hasNext();) {
			Node childElement = (Node) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == Device2EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ExecutionEnvironment2EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == Node2EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator it = modelElement.getNestedClassifiers().iterator(); it.hasNext();) {
			Classifier childElement = (Classifier) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == ArtifactEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDeviceDevicecontents_7005SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Device modelElement = (Device) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getNestedNodes().iterator(); it.hasNext();) {
			Node childElement = (Node) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == Device2EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ExecutionEnvironment2EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == Node2EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator it = modelElement.getNestedClassifiers().iterator(); it.hasNext();) {
			Classifier childElement = (Classifier) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == ArtifactEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getArtifactArtifactFigure_contents_7007SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Artifact modelElement = (Artifact) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getNestedArtifacts().iterator(); it.hasNext();) {
			Artifact childElement = (Artifact) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == Artifact4EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DeploymentSpecification2EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getArtifactArtifactFigure_contents_7008SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Artifact modelElement = (Artifact) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getNestedArtifacts().iterator(); it.hasNext();) {
			Artifact childElement = (Artifact) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == Artifact4EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DeploymentSpecification2EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDeploymentSpecificationProperties_7010SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		DeploymentSpecification modelElement = (DeploymentSpecification) containerView.getElement();
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
	public static List getExecutionEnvironmentArtifacts_7006SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		ExecutionEnvironment modelElement = (ExecutionEnvironment) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getNestedClassifiers().iterator(); it.hasNext();) {
			Classifier childElement = (Classifier) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == Artifact3EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getExecutionEnvironmentArtifacts_7002SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		ExecutionEnvironment modelElement = (ExecutionEnvironment) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getNestedClassifiers().iterator(); it.hasNext();) {
			Classifier childElement = (Classifier) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == Artifact3EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getArtifactArtifactFigure_contents_7009SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Artifact modelElement = (Artifact) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getNestedArtifacts().iterator(); it.hasNext();) {
			Artifact childElement = (Artifact) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == Artifact4EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DeploymentSpecification2EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDeploymentSpecificationProperties_7003SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		DeploymentSpecification modelElement = (DeploymentSpecification) containerView.getElement();
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
	public static List getPackage_1000SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Package modelElement = (Package) view.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getPackagedElements().iterator(); it.hasNext();) {
			PackageableElement childElement = (PackageableElement) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
		}
		for (Iterator it = modelElement.getOwnedTypes().iterator(); it.hasNext();) {
			Type childElement = (Type) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == DeviceEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == NodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ExecutionEnvironmentEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == Artifact2EditPart.VISUAL_ID) {
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
		Resource resource = modelElement.eResource();
		for (Iterator semanticIterator = getPhantomNodesIterator(resource); semanticIterator.hasNext();) {
			EObject childElement = (EObject) semanticIterator.next();
			if (childElement == modelElement) {
				continue;
			}
			if (UMLVisualIDRegistry.getNodeVisualID(view, childElement) == DeploymentSpecificationEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, DeploymentSpecificationEditPart.VISUAL_ID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Iterator getPhantomNodesIterator(Resource resource) {
		return resource.getAllContents();
	}

	/**
	 * @generated
	 */
	public static List getContainedLinks(View view) {
		switch (UMLVisualIDRegistry.getVisualID(view)) {
		case PackageEditPart.VISUAL_ID:
			return getPackage_1000ContainedLinks(view);
		case Package2EditPart.VISUAL_ID:
			return getPackage_2001ContainedLinks(view);
		case DeviceEditPart.VISUAL_ID:
			return getDevice_2003ContainedLinks(view);
		case NodeEditPart.VISUAL_ID:
			return getNode_2004ContainedLinks(view);
		case ExecutionEnvironmentEditPart.VISUAL_ID:
			return getExecutionEnvironment_2005ContainedLinks(view);
		case Artifact2EditPart.VISUAL_ID:
			return getArtifact_2006ContainedLinks(view);
		case DeploymentSpecificationEditPart.VISUAL_ID:
			return getDeploymentSpecification_2007ContainedLinks(view);
		case CommentEditPart.VISUAL_ID:
			return getComment_2008ContainedLinks(view);
		case ElementImportEditPart.VISUAL_ID:
			return getElementImport_3001ContainedLinks(view);
		case Device2EditPart.VISUAL_ID:
			return getDevice_3004ContainedLinks(view);
		case ArtifactEditPart.VISUAL_ID:
			return getArtifact_3002ContainedLinks(view);
		case Artifact4EditPart.VISUAL_ID:
			return getArtifact_3008ContainedLinks(view);
		case DeploymentSpecification2EditPart.VISUAL_ID:
			return getDeploymentSpecification_3009ContainedLinks(view);
		case PropertyEditPart.VISUAL_ID:
			return getProperty_3003ContainedLinks(view);
		case ExecutionEnvironment2EditPart.VISUAL_ID:
			return getExecutionEnvironment_3005ContainedLinks(view);
		case Artifact3EditPart.VISUAL_ID:
			return getArtifact_3006ContainedLinks(view);
		case Node2EditPart.VISUAL_ID:
			return getNode_3007ContainedLinks(view);
		case DeploymentEditPart.VISUAL_ID:
			return getDeployment_4001ContainedLinks(view);
		case ManifestationEditPart.VISUAL_ID:
			return getManifestation_4002ContainedLinks(view);
		case CommunicationPathEditPart.VISUAL_ID:
			return getCommunicationPath_4004ContainedLinks(view);
		case DependencyEditPart.VISUAL_ID:
			return getDependency_4005ContainedLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIncomingLinks(View view) {
		switch (UMLVisualIDRegistry.getVisualID(view)) {
		case Package2EditPart.VISUAL_ID:
			return getPackage_2001IncomingLinks(view);
		case DeviceEditPart.VISUAL_ID:
			return getDevice_2003IncomingLinks(view);
		case NodeEditPart.VISUAL_ID:
			return getNode_2004IncomingLinks(view);
		case ExecutionEnvironmentEditPart.VISUAL_ID:
			return getExecutionEnvironment_2005IncomingLinks(view);
		case Artifact2EditPart.VISUAL_ID:
			return getArtifact_2006IncomingLinks(view);
		case DeploymentSpecificationEditPart.VISUAL_ID:
			return getDeploymentSpecification_2007IncomingLinks(view);
		case CommentEditPart.VISUAL_ID:
			return getComment_2008IncomingLinks(view);
		case ElementImportEditPart.VISUAL_ID:
			return getElementImport_3001IncomingLinks(view);
		case Device2EditPart.VISUAL_ID:
			return getDevice_3004IncomingLinks(view);
		case ArtifactEditPart.VISUAL_ID:
			return getArtifact_3002IncomingLinks(view);
		case Artifact4EditPart.VISUAL_ID:
			return getArtifact_3008IncomingLinks(view);
		case DeploymentSpecification2EditPart.VISUAL_ID:
			return getDeploymentSpecification_3009IncomingLinks(view);
		case PropertyEditPart.VISUAL_ID:
			return getProperty_3003IncomingLinks(view);
		case ExecutionEnvironment2EditPart.VISUAL_ID:
			return getExecutionEnvironment_3005IncomingLinks(view);
		case Artifact3EditPart.VISUAL_ID:
			return getArtifact_3006IncomingLinks(view);
		case Node2EditPart.VISUAL_ID:
			return getNode_3007IncomingLinks(view);
		case DeploymentEditPart.VISUAL_ID:
			return getDeployment_4001IncomingLinks(view);
		case ManifestationEditPart.VISUAL_ID:
			return getManifestation_4002IncomingLinks(view);
		case CommunicationPathEditPart.VISUAL_ID:
			return getCommunicationPath_4004IncomingLinks(view);
		case DependencyEditPart.VISUAL_ID:
			return getDependency_4005IncomingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOutgoingLinks(View view) {
		switch (UMLVisualIDRegistry.getVisualID(view)) {
		case Package2EditPart.VISUAL_ID:
			return getPackage_2001OutgoingLinks(view);
		case DeviceEditPart.VISUAL_ID:
			return getDevice_2003OutgoingLinks(view);
		case NodeEditPart.VISUAL_ID:
			return getNode_2004OutgoingLinks(view);
		case ExecutionEnvironmentEditPart.VISUAL_ID:
			return getExecutionEnvironment_2005OutgoingLinks(view);
		case Artifact2EditPart.VISUAL_ID:
			return getArtifact_2006OutgoingLinks(view);
		case DeploymentSpecificationEditPart.VISUAL_ID:
			return getDeploymentSpecification_2007OutgoingLinks(view);
		case CommentEditPart.VISUAL_ID:
			return getComment_2008OutgoingLinks(view);
		case ElementImportEditPart.VISUAL_ID:
			return getElementImport_3001OutgoingLinks(view);
		case Device2EditPart.VISUAL_ID:
			return getDevice_3004OutgoingLinks(view);
		case ArtifactEditPart.VISUAL_ID:
			return getArtifact_3002OutgoingLinks(view);
		case Artifact4EditPart.VISUAL_ID:
			return getArtifact_3008OutgoingLinks(view);
		case DeploymentSpecification2EditPart.VISUAL_ID:
			return getDeploymentSpecification_3009OutgoingLinks(view);
		case PropertyEditPart.VISUAL_ID:
			return getProperty_3003OutgoingLinks(view);
		case ExecutionEnvironment2EditPart.VISUAL_ID:
			return getExecutionEnvironment_3005OutgoingLinks(view);
		case Artifact3EditPart.VISUAL_ID:
			return getArtifact_3006OutgoingLinks(view);
		case Node2EditPart.VISUAL_ID:
			return getNode_3007OutgoingLinks(view);
		case DeploymentEditPart.VISUAL_ID:
			return getDeployment_4001OutgoingLinks(view);
		case ManifestationEditPart.VISUAL_ID:
			return getManifestation_4002OutgoingLinks(view);
		case CommunicationPathEditPart.VISUAL_ID:
			return getCommunicationPath_4004OutgoingLinks(view);
		case DependencyEditPart.VISUAL_ID:
			return getDependency_4005OutgoingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getPackage_1000ContainedLinks(View view) {
		Package modelElement = (Package) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_CommunicationPath_4004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Dependency_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPackage_2001ContainedLinks(View view) {
		//no links to, from and inside the diagram header
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getDevice_2003ContainedLinks(View view) {
		Device modelElement = (Device) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Deployment_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getNode_2004ContainedLinks(View view) {
		Node modelElement = (Node) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Deployment_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getExecutionEnvironment_2005ContainedLinks(View view) {
		ExecutionEnvironment modelElement = (ExecutionEnvironment) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Deployment_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getArtifact_2006ContainedLinks(View view) {
		Artifact modelElement = (Artifact) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Manifestation_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDeploymentSpecification_2007ContainedLinks(View view) {
		DeploymentSpecification modelElement = (DeploymentSpecification) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Manifestation_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getComment_2008ContainedLinks(View view) {
		Comment modelElement = (Comment) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getElementImport_3001ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getDevice_3004ContainedLinks(View view) {
		Device modelElement = (Device) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Deployment_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getArtifact_3002ContainedLinks(View view) {
		Artifact modelElement = (Artifact) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Manifestation_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getArtifact_3008ContainedLinks(View view) {
		Artifact modelElement = (Artifact) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Manifestation_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDeploymentSpecification_3009ContainedLinks(View view) {
		DeploymentSpecification modelElement = (DeploymentSpecification) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Manifestation_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getExecutionEnvironment_3005ContainedLinks(View view) {
		ExecutionEnvironment modelElement = (ExecutionEnvironment) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Deployment_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getArtifact_3006ContainedLinks(View view) {
		Artifact modelElement = (Artifact) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Manifestation_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getNode_3007ContainedLinks(View view) {
		Node modelElement = (Node) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Deployment_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getProperty_3003ContainedLinks(View view) {
		Property modelElement = (Property) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Deployment_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDeployment_4001ContainedLinks(View view) {
		Deployment modelElement = (Deployment) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Deployment_Configuration_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getManifestation_4002ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getCommunicationPath_4004ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getDependency_4005ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getPackage_2001IncomingLinks(View view) {
		//no links to, from and inside the diagram header
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getDevice_2003IncomingLinks(View view) {
		Device modelElement = (Device) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_CommunicationPath_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4005(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getNode_2004IncomingLinks(View view) {
		Node modelElement = (Node) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_CommunicationPath_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4005(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getExecutionEnvironment_2005IncomingLinks(View view) {
		ExecutionEnvironment modelElement = (ExecutionEnvironment) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_CommunicationPath_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4005(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getArtifact_2006IncomingLinks(View view) {
		Artifact modelElement = (Artifact) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_CommunicationPath_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4005(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDeploymentSpecification_2007IncomingLinks(View view) {
		DeploymentSpecification modelElement = (DeploymentSpecification) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Deployment_Configuration_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_CommunicationPath_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4005(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getComment_2008IncomingLinks(View view) {
		Comment modelElement = (Comment) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getElementImport_3001IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getDevice_3004IncomingLinks(View view) {
		Device modelElement = (Device) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_CommunicationPath_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4005(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getArtifact_3002IncomingLinks(View view) {
		Artifact modelElement = (Artifact) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_CommunicationPath_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4005(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getArtifact_3008IncomingLinks(View view) {
		Artifact modelElement = (Artifact) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_CommunicationPath_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4005(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDeploymentSpecification_3009IncomingLinks(View view) {
		DeploymentSpecification modelElement = (DeploymentSpecification) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Deployment_Configuration_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_CommunicationPath_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4005(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getExecutionEnvironment_3005IncomingLinks(View view) {
		ExecutionEnvironment modelElement = (ExecutionEnvironment) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_CommunicationPath_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4005(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getArtifact_3006IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getNode_3007IncomingLinks(View view) {
		Node modelElement = (Node) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_CommunicationPath_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4005(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getProperty_3003IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getDeployment_4001IncomingLinks(View view) {
		Deployment modelElement = (Deployment) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4005(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getManifestation_4002IncomingLinks(View view) {
		Manifestation modelElement = (Manifestation) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4005(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getCommunicationPath_4004IncomingLinks(View view) {
		CommunicationPath modelElement = (CommunicationPath) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_CommunicationPath_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4005(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDependency_4005IncomingLinks(View view) {
		Dependency modelElement = (Dependency) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4005(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPackage_2001OutgoingLinks(View view) {
		//no links to, from and inside the diagram header
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getDevice_2003OutgoingLinks(View view) {
		Device modelElement = (Device) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_CommunicationPath_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getNode_2004OutgoingLinks(View view) {
		Node modelElement = (Node) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_CommunicationPath_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getExecutionEnvironment_2005OutgoingLinks(View view) {
		ExecutionEnvironment modelElement = (ExecutionEnvironment) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_CommunicationPath_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getArtifact_2006OutgoingLinks(View view) {
		Artifact modelElement = (Artifact) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Manifestation_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_CommunicationPath_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDeploymentSpecification_2007OutgoingLinks(View view) {
		DeploymentSpecification modelElement = (DeploymentSpecification) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Manifestation_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_CommunicationPath_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getComment_2008OutgoingLinks(View view) {
		Comment modelElement = (Comment) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getElementImport_3001OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getDevice_3004OutgoingLinks(View view) {
		Device modelElement = (Device) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_CommunicationPath_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getArtifact_3002OutgoingLinks(View view) {
		Artifact modelElement = (Artifact) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Manifestation_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_CommunicationPath_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getArtifact_3008OutgoingLinks(View view) {
		Artifact modelElement = (Artifact) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Manifestation_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_CommunicationPath_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDeploymentSpecification_3009OutgoingLinks(View view) {
		DeploymentSpecification modelElement = (DeploymentSpecification) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Manifestation_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_CommunicationPath_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getExecutionEnvironment_3005OutgoingLinks(View view) {
		ExecutionEnvironment modelElement = (ExecutionEnvironment) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_CommunicationPath_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getArtifact_3006OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getNode_3007OutgoingLinks(View view) {
		Node modelElement = (Node) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_CommunicationPath_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getProperty_3003OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getDeployment_4001OutgoingLinks(View view) {
		Deployment modelElement = (Deployment) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Deployment_Configuration_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getManifestation_4002OutgoingLinks(View view) {
		Manifestation modelElement = (Manifestation) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getCommunicationPath_4004OutgoingLinks(View view) {
		CommunicationPath modelElement = (CommunicationPath) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_CommunicationPath_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDependency_4005OutgoingLinks(View view) {
		Dependency modelElement = (Dependency) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_Deployment_4001(DeploymentTarget container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getDeployments().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Deployment) {
				continue;
			}
			Deployment link = (Deployment) linkObject;
			if (DeploymentEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getDeployedArtifacts();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if (false == theTarget instanceof DeployedArtifact) {
				continue;
			}
			DeployedArtifact dst = (DeployedArtifact) theTarget;
			DeploymentTarget src = link.getLocation();
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Deployment_4001, DeploymentEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_Manifestation_4002(Artifact container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getManifestations().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Manifestation) {
				continue;
			}
			Manifestation link = (Manifestation) linkObject;
			if (ManifestationEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			PackageableElement dst = link.getUtilizedElement();
			result.add(new UMLLinkDescriptor(container, dst, link, UMLElementTypes.Manifestation_4002, ManifestationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated NOT
	 */
	private static Collection getContainedTypeModelFacetLinks_CommunicationPath_4004(Package container) {
		Collection result = new LinkedList();
		for (PackageableElement linkObject : container.getPackagedElements()) {
			if (false == linkObject instanceof CommunicationPath) {
				continue;
			}
			CommunicationPath path = (CommunicationPath) linkObject;
			if (CommunicationPathEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(path)) {
				continue;
			}
			if (path.isBinary()) {
				Property sourceEnd = AssociationEndConvention.getSourceEnd(path);
				Property targetEnd = AssociationEndConvention.getTargetEnd(path);
				EObject gmfSource = sourceEnd.getType();
				EObject gmfTarget = targetEnd.getType();
				result.add(new UMLLinkDescriptor(gmfSource, gmfTarget, path, UMLElementTypes.CommunicationPath_4004, CommunicationPathEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_Dependency_4005(Package container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Dependency) {
				continue;
			}
			Dependency link = (Dependency) linkObject;
			if (DependencyEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getSuppliers();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if (false == theTarget instanceof NamedElement) {
				continue;
			}
			NamedElement dst = (NamedElement) theTarget;
			List sources = link.getClients();
			Object theSource = sources.size() == 1 ? sources.get(0) : null;
			if (false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement) theSource;
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Dependency_4005, DependencyEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_Deployment_4001(DeployedArtifact target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getDeployment_DeployedArtifact() || false == setting.getEObject() instanceof Deployment) {
				continue;
			}
			Deployment link = (Deployment) setting.getEObject();
			if (DeploymentEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			DeploymentTarget src = link.getLocation();
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.Deployment_4001, DeploymentEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_Manifestation_4002(PackageableElement target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getManifestation_UtilizedElement() || false == setting.getEObject() instanceof Manifestation) {
				continue;
			}
			Manifestation link = (Manifestation) setting.getEObject();
			if (ManifestationEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			if (false == link.eContainer() instanceof Artifact) {
				continue;
			}
			Artifact container = (Artifact) link.eContainer();
			result.add(new UMLLinkDescriptor(container, target, link, UMLElementTypes.Manifestation_4002, ManifestationEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_Deployment_Configuration_4003(DeploymentSpecification target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() == UMLPackage.eINSTANCE.getDeployment_Configuration()) {
				result.add(new UMLLinkDescriptor(setting.getEObject(), target, UMLElementTypes.DeploymentConfiguration_4003, DeploymentConfigurationEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated NOT
	 */
	private static Collection getIncomingTypeModelFacetLinks_CommunicationPath_4004(Type target, Map crossReferences) {
		return findRelatedCommunicationPaths(target, false);
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_Dependency_4005(NamedElement target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getDependency_Supplier() || false == setting.getEObject() instanceof Dependency) {
				continue;
			}
			Dependency link = (Dependency) setting.getEObject();
			if (DependencyEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List sources = link.getClients();
			Object theSource = sources.size() == 1 ? sources.get(0) : null;
			if (false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement) theSource;
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.Dependency_4005, DependencyEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(Element target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() == UMLPackage.eINSTANCE.getComment_AnnotatedElement()) {
				result.add(new UMLLinkDescriptor(setting.getEObject(), target, UMLElementTypes.CommentAnnotatedElement_4006, CommentAnnotatedElementEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_Deployment_4001(DeploymentTarget source) {
		DeploymentTarget container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof DeploymentTarget) {
				container = (DeploymentTarget) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getDeployments().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Deployment) {
				continue;
			}
			Deployment link = (Deployment) linkObject;
			if (DeploymentEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getDeployedArtifacts();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if (false == theTarget instanceof DeployedArtifact) {
				continue;
			}
			DeployedArtifact dst = (DeployedArtifact) theTarget;
			DeploymentTarget src = link.getLocation();
			if (src != source) {
				continue;
			}
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Deployment_4001, DeploymentEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_Deployment_Configuration_4003(Deployment source) {
		Collection result = new LinkedList();
		for (Iterator destinations = source.getConfigurations().iterator(); destinations.hasNext();) {
			DeploymentSpecification destination = (DeploymentSpecification) destinations.next();
			result.add(new UMLLinkDescriptor(source, destination, UMLElementTypes.DeploymentConfiguration_4003, DeploymentConfigurationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated NOT
	 */
	private static Collection getOutgoingTypeModelFacetLinks_CommunicationPath_4004(Type source) {
		return findRelatedCommunicationPaths(source, true);
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_Dependency_4005(NamedElement source) {
		Package container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof Package) {
				container = (Package) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Dependency) {
				continue;
			}
			Dependency link = (Dependency) linkObject;
			if (DependencyEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getSuppliers();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if (false == theTarget instanceof NamedElement) {
				continue;
			}
			NamedElement dst = (NamedElement) theTarget;
			List sources = link.getClients();
			Object theSource = sources.size() == 1 ? sources.get(0) : null;
			if (false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement) theSource;
			if (src != source) {
				continue;
			}
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Dependency_4005, DependencyEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(Comment source) {
		Collection result = new LinkedList();
		for (Iterator destinations = source.getAnnotatedElements().iterator(); destinations.hasNext();) {
			Element destination = (Element) destinations.next();
			result.add(new UMLLinkDescriptor(source, destination, UMLElementTypes.CommentAnnotatedElement_4006, CommentAnnotatedElementEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @NOT-GENERATED
	 */
	private static Collection findRelatedCommunicationPaths(Type type, boolean sourceNotTarget) {
		Package container = type.getNearestPackage();
		if (container == null) {
			return Collections.emptyList();
		}

		List<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		for (PackageableElement next : container.getPackagedElements()) {
			if (false == next instanceof Association) {
				continue;
			}
			if (CommunicationPathEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(next)) {
				continue;
			}
			Association link = (Association) next;
			Property sourceEnd = AssociationEndConvention.getSourceEnd(link);
			Property targetEnd = AssociationEndConvention.getTargetEnd(link);

			if (sourceEnd == null || targetEnd == null) {
				continue;
			}

			Property subjectEnd = sourceNotTarget ? sourceEnd : targetEnd;
			if (!type.equals(subjectEnd.getType())) {
				continue;
			}

			EObject gmfSource = sourceEnd.getType();
			EObject gmfTarget = targetEnd.getType();
			result.add(new UMLLinkDescriptor(gmfSource, gmfTarget, link, UMLElementTypes.CommunicationPath_4004, CommunicationPathEditPart.VISUAL_ID));
		}
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
			return org.eclipse.uml2.diagram.deploy.part.UMLDiagramUpdater.getSemanticChildren(view);
		}

		/**
		 * @generated
		 */
		public List<IUpdaterLinkDescriptor> getContainedLinks(View view) {
			return org.eclipse.uml2.diagram.deploy.part.UMLDiagramUpdater.getContainedLinks(view);
		}

		/**
		 * @generated
		 */
		public List<IUpdaterLinkDescriptor> getIncomingLinks(View view) {
			return org.eclipse.uml2.diagram.deploy.part.UMLDiagramUpdater.getIncomingLinks(view);
		}

		/**
		 * @generated
		 */
		public List<IUpdaterLinkDescriptor> getOutgoingLinks(View view) {
			return org.eclipse.uml2.diagram.deploy.part.UMLDiagramUpdater.getOutgoingLinks(view);
		}
	};

}
