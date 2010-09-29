package org.eclipse.uml2.diagram.deploy.providers;

import java.util.ArrayList;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.providers.IViewProvider;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateDiagramViewOperation;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateEdgeViewOperation;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateNodeViewOperation;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateViewForKindOperation;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateViewOperation;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.CanonicalStyle;
import org.eclipse.gmf.runtime.notation.Connector;
import org.eclipse.gmf.runtime.notation.DecorationNode;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.DrawerStyle;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.FontStyle;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.MeasurementUnit;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.RelativeBendpoints;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.TitleStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.uml2.diagram.common.notation.u2tnotation.U2TDiagramCanonicalStyle;
import org.eclipse.uml2.diagram.common.notation.u2tnotation.U2TNotationFactory;
import org.eclipse.uml2.diagram.common.view.ViewProviderUtils;
import org.eclipse.uml2.diagram.deploy.edit.parts.Artifact2EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.Artifact3EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.Artifact4EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.ArtifactArtifactFigure_contents2EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.ArtifactArtifactFigure_contents3EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.ArtifactArtifactFigure_contentsEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.ArtifactEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.ArtifactFileName2EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.ArtifactFileName3EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.ArtifactFileNameEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.ArtifactStereo2EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.ArtifactStereo3EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.ArtifactStereoEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.CommentBodyEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.CommentEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.CommunicationPathEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.CommunicationPathNameEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.DependencyEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.DependencyNameEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.DeploymentConfigurationEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.DeploymentEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.DeploymentNameEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.DeploymentSpecification2EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.DeploymentSpecificationEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.DeploymentSpecificationName2EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.DeploymentSpecificationNameEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.DeploymentSpecificationProperties2EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.DeploymentSpecificationPropertiesEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.DeploymentSpecificationStereo3EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.DeploymentSpecificationStereo4EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.Device2EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.DeviceDevicecontents2EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.DeviceDevicecontentsEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.DeviceEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.DeviceName2EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.DeviceNameEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.DeviceStereo2EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.DeviceStereoEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.ElementImportEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.ExecutionEnvironment2EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.ExecutionEnvironmentArtifacts2EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.ExecutionEnvironmentArtifactsEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.ExecutionEnvironmentEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.ExecutionEnvironmentName2EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.ExecutionEnvironmentNameEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.ExecutionEnvironmentStereo2EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.ExecutionEnvironmentStereoEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.ManifestationEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.ManifestationNameEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.Node2EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.NodeEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.NodeName2EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.NodeNameEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.NodeStereo2EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.NodeStereoEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.Package2EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.PackageEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.PackageImportsEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.PackageNameEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.PackageStereo2EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.PropertyEditPart;
import org.eclipse.uml2.diagram.deploy.part.UMLVisualIDRegistry;

/**
 * @generated
 */
public class UMLViewProvider extends AbstractProvider implements IViewProvider {

	/**
	 * @generated
	 */
	public final boolean provides(IOperation operation) {
		if (operation instanceof CreateViewForKindOperation) {
			return provides((CreateViewForKindOperation) operation);
		}
		assert operation instanceof CreateViewOperation;
		if (operation instanceof CreateDiagramViewOperation) {
			return provides((CreateDiagramViewOperation) operation);
		} else if (operation instanceof CreateEdgeViewOperation) {
			return provides((CreateEdgeViewOperation) operation);
		} else if (operation instanceof CreateNodeViewOperation) {
			return provides((CreateNodeViewOperation) operation);
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean provides(CreateViewForKindOperation op) {
		/*
		 if (op.getViewKind() == Node.class)
		 return getNodeViewClass(op.getSemanticAdapter(), op.getContainerView(), op.getSemanticHint()) != null;
		 if (op.getViewKind() == Edge.class)
		 return getEdgeViewClass(op.getSemanticAdapter(), op.getContainerView(), op.getSemanticHint()) != null;
		 */
		return true;
	}

	/**
	 * @generated
	 */
	protected boolean provides(CreateDiagramViewOperation op) {
		return PackageEditPart.MODEL_ID.equals(op.getSemanticHint()) && UMLVisualIDRegistry.getDiagramVisualID(getSemanticElement(op.getSemanticAdapter())) != -1;
	}

	/**
	 * @generated
	 */
	protected boolean provides(CreateNodeViewOperation op) {
		if (op.getContainerView() == null) {
			return false;
		}
		IElementType elementType = getSemanticElementType(op.getSemanticAdapter());
		EObject domainElement = getSemanticElement(op.getSemanticAdapter());
		int visualID;
		if (op.getSemanticHint() == null) {
			// Semantic hint is not specified. Can be a result of call from CanonicalEditPolicy.
			// In this situation there should be NO elementType, visualID will be determined
			// by VisualIDRegistry.getNodeVisualID() for domainElement.
			if (elementType != null || domainElement == null) {
				return false;
			}
			visualID = UMLVisualIDRegistry.getNodeVisualID(op.getContainerView(), domainElement);
		} else {
			visualID = UMLVisualIDRegistry.getVisualID(op.getSemanticHint());
			if (elementType != null) {
				if (!UMLElementTypes.isKnownElementType(elementType) || (!(elementType instanceof IHintedType))) {
					return false; // foreign element type
				}
				String elementTypeHint = ((IHintedType) elementType).getSemanticHint();
				if (!op.getSemanticHint().equals(elementTypeHint)) {
					return false; // if semantic hint is specified it should be the same as in element type
				}
				if (domainElement != null && !UMLVisualIDRegistry.checkNodeVisualID(op.getContainerView(), domainElement, visualID)) {
					return false; // visual id for node EClass should match visual id from element type, or at least be substitutable for it
				}
			} else {
				if (!PackageEditPart.MODEL_ID.equals(UMLVisualIDRegistry.getModelID(op.getContainerView()))) {
					return false; // foreign diagram
				}
				switch (visualID) {
				case DeviceEditPart.VISUAL_ID:
				case CommentEditPart.VISUAL_ID:
				case ElementImportEditPart.VISUAL_ID:
				case ArtifactEditPart.VISUAL_ID:
				case DeploymentSpecification2EditPart.VISUAL_ID:
				case PropertyEditPart.VISUAL_ID:
				case ExecutionEnvironment2EditPart.VISUAL_ID:
				case Node2EditPart.VISUAL_ID:
				case Package2EditPart.VISUAL_ID:
				case NodeEditPart.VISUAL_ID:
				case ExecutionEnvironmentEditPart.VISUAL_ID:
				case Artifact2EditPart.VISUAL_ID:
				case DeploymentSpecificationEditPart.VISUAL_ID:
				case Device2EditPart.VISUAL_ID:
				case Artifact4EditPart.VISUAL_ID:
				case Artifact3EditPart.VISUAL_ID:
					if (domainElement == null || visualID != UMLVisualIDRegistry.getNodeVisualID(op.getContainerView(), domainElement)) {
						return false; // visual id in semantic hint should match visual id for domain element
					}
					break;
				default:
					return false;
				}
			}
		}
		return Package2EditPart.VISUAL_ID == visualID || DeviceEditPart.VISUAL_ID == visualID || NodeEditPart.VISUAL_ID == visualID || ExecutionEnvironmentEditPart.VISUAL_ID == visualID
				|| Artifact2EditPart.VISUAL_ID == visualID || DeploymentSpecificationEditPart.VISUAL_ID == visualID || CommentEditPart.VISUAL_ID == visualID
				|| ElementImportEditPart.VISUAL_ID == visualID || Device2EditPart.VISUAL_ID == visualID || ArtifactEditPart.VISUAL_ID == visualID || Artifact4EditPart.VISUAL_ID == visualID
				|| DeploymentSpecification2EditPart.VISUAL_ID == visualID || PropertyEditPart.VISUAL_ID == visualID || ExecutionEnvironment2EditPart.VISUAL_ID == visualID
				|| Artifact3EditPart.VISUAL_ID == visualID || Node2EditPart.VISUAL_ID == visualID;
	}

	/**
	 * @generated
	 */
	protected boolean provides(CreateEdgeViewOperation op) {
		IElementType elementType = getSemanticElementType(op.getSemanticAdapter());
		if (!UMLElementTypes.isKnownElementType(elementType) || (!(elementType instanceof IHintedType))) {
			return false; // foreign element type
		}
		String elementTypeHint = ((IHintedType) elementType).getSemanticHint();
		if (elementTypeHint == null || (op.getSemanticHint() != null && !elementTypeHint.equals(op.getSemanticHint()))) {
			return false; // our hint is visual id and must be specified, and it should be the same as in element type
		}
		int visualID = UMLVisualIDRegistry.getVisualID(elementTypeHint);
		EObject domainElement = getSemanticElement(op.getSemanticAdapter());
		if (domainElement != null && visualID != UMLVisualIDRegistry.getLinkWithClassVisualID(domainElement)) {
			return false; // visual id for link EClass should match visual id from element type
		}
		return true;
	}

	/**
	 * @generated
	 */
	public Diagram createDiagram(IAdaptable semanticAdapter, String diagramKind, PreferencesHint preferencesHint) {
		Diagram diagram = NotationFactory.eINSTANCE.createDiagram();
		diagram.getStyles().add(NotationFactory.eINSTANCE.createDiagramStyle());
		U2TDiagramCanonicalStyle canonicalStyle_Package_1000 = U2TNotationFactory.eINSTANCE.createU2TDiagramCanonicalStyle();
		canonicalStyle_Package_1000.setCanonical(true);
		canonicalStyle_Package_1000.setSyncNodes(true);
		canonicalStyle_Package_1000.setSyncLinks(true);
		diagram.getStyles().add(canonicalStyle_Package_1000);
		diagram.setType(PackageEditPart.MODEL_ID);
		diagram.setElement(getSemanticElement(semanticAdapter));
		diagram.setMeasurementUnit(MeasurementUnit.PIXEL_LITERAL);
		return diagram;
	}

	/**
	 * @generated
	 */
	public Node createNode(IAdaptable semanticAdapter, View containerView, String semanticHint, int index, boolean persisted, PreferencesHint preferencesHint) {
		final EObject domainElement = getSemanticElement(semanticAdapter);
		final int visualID;
		if (semanticHint == null) {
			visualID = UMLVisualIDRegistry.getNodeVisualID(containerView, domainElement);
		} else {
			visualID = UMLVisualIDRegistry.getVisualID(semanticHint);
		}
		switch (visualID) {
		case Package2EditPart.VISUAL_ID:
			return createPackage_2001(domainElement, containerView, index, persisted, preferencesHint);
		case DeviceEditPart.VISUAL_ID:
			return createDevice_2003(domainElement, containerView, index, persisted, preferencesHint);
		case NodeEditPart.VISUAL_ID:
			return createNode_2004(domainElement, containerView, index, persisted, preferencesHint);
		case ExecutionEnvironmentEditPart.VISUAL_ID:
			return createExecutionEnvironment_2005(domainElement, containerView, index, persisted, preferencesHint);
		case Artifact2EditPart.VISUAL_ID:
			return createArtifact_2006(domainElement, containerView, index, persisted, preferencesHint);
		case DeploymentSpecificationEditPart.VISUAL_ID:
			return createDeploymentSpecification_2007(domainElement, containerView, index, persisted, preferencesHint);
		case CommentEditPart.VISUAL_ID:
			return createComment_2008(domainElement, containerView, index, persisted, preferencesHint);
		case ElementImportEditPart.VISUAL_ID:
			return createElementImport_3001(domainElement, containerView, index, persisted, preferencesHint);
		case Device2EditPart.VISUAL_ID:
			return createDevice_3004(domainElement, containerView, index, persisted, preferencesHint);
		case ArtifactEditPart.VISUAL_ID:
			return createArtifact_3002(domainElement, containerView, index, persisted, preferencesHint);
		case Artifact4EditPart.VISUAL_ID:
			return createArtifact_3008(domainElement, containerView, index, persisted, preferencesHint);
		case DeploymentSpecification2EditPart.VISUAL_ID:
			return createDeploymentSpecification_3009(domainElement, containerView, index, persisted, preferencesHint);
		case PropertyEditPart.VISUAL_ID:
			return createProperty_3003(domainElement, containerView, index, persisted, preferencesHint);
		case ExecutionEnvironment2EditPart.VISUAL_ID:
			return createExecutionEnvironment_3005(domainElement, containerView, index, persisted, preferencesHint);
		case Artifact3EditPart.VISUAL_ID:
			return createArtifact_3006(domainElement, containerView, index, persisted, preferencesHint);
		case Node2EditPart.VISUAL_ID:
			return createNode_3007(domainElement, containerView, index, persisted, preferencesHint);
		}
		// can't happen, provided #provides(CreateNodeViewOperation) is correct
		return null;
	}

	/**
	 * @generated
	 */
	public Edge createEdge(IAdaptable semanticAdapter, View containerView, String semanticHint, int index, boolean persisted, PreferencesHint preferencesHint) {
		IElementType elementType = getSemanticElementType(semanticAdapter);
		String elementTypeHint = ((IHintedType) elementType).getSemanticHint();
		switch (UMLVisualIDRegistry.getVisualID(elementTypeHint)) {
		case DeploymentEditPart.VISUAL_ID:
			return createDeployment_4001(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case ManifestationEditPart.VISUAL_ID:
			return createManifestation_4002(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case DeploymentConfigurationEditPart.VISUAL_ID:
			return createDeploymentConfiguration_4003(containerView, index, persisted, preferencesHint);
		case CommunicationPathEditPart.VISUAL_ID:
			return createCommunicationPath_4004(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case DependencyEditPart.VISUAL_ID:
			return createDependency_4005(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case CommentAnnotatedElementEditPart.VISUAL_ID:
			return createCommentAnnotatedElement_4006(containerView, index, persisted, preferencesHint);
		}
		// can never happen, provided #provides(CreateEdgeViewOperation) is correct
		return null;
	}

	/**
	 * @generated
	 */
	public Node createPackage_2001(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(Package2EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_LINE_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getLineStyle_LineColor(), FigureUtilities.RGBToInteger(lineRGB));
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FILL_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getFillStyle_FillColor(), FigureUtilities.RGBToInteger(fillRGB));
		Node PackageName_5001 = createLabel(node, UMLVisualIDRegistry.getType(PackageNameEditPart.VISUAL_ID));
		Node PackageQualifiedName_5025 = createLabel(node, UMLVisualIDRegistry.getType(PackageStereo2EditPart.VISUAL_ID));

		Node PackageImports_7001 = createCompartment(node, UMLVisualIDRegistry.getType(PackageImportsEditPart.VISUAL_ID), true, false, true, true);
		CanonicalStyle canonicalStyle_PackageImports_7001 = NotationFactory.eINSTANCE.createCanonicalStyle();
		canonicalStyle_PackageImports_7001.setCanonical(true);
		PackageImports_7001.getStyles().add(canonicalStyle_PackageImports_7001);
		DrawerStyle drawerStyle = (DrawerStyle) PackageImports_7001.getStyle(NotationPackage.eINSTANCE.getDrawerStyle());
		if (drawerStyle != null) {
			//#216573 [SecondaryDiagramElement] Collapse imports compartment after creation
			drawerStyle.setCollapsed(true);
		}
		return node;
	}

	/**
	 * @generated
	 */
	public Node createDevice_2003(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(DeviceEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_LINE_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getLineStyle_LineColor(), FigureUtilities.RGBToInteger(lineRGB));
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FILL_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getFillStyle_FillColor(), FigureUtilities.RGBToInteger(fillRGB));
		Node DeviceName_5002 = createLabel(node, UMLVisualIDRegistry.getType(DeviceNameEditPart.VISUAL_ID));
		Node DeviceQualifiedName_5019 = createLabel(node, UMLVisualIDRegistry.getType(DeviceStereoEditPart.VISUAL_ID));

		Node DeviceDevicecontents_7004 = createCompartment(node, UMLVisualIDRegistry.getType(DeviceDevicecontentsEditPart.VISUAL_ID), false, false, false, false);
		CanonicalStyle canonicalStyle_DeviceDevicecontents_7004 = NotationFactory.eINSTANCE.createCanonicalStyle();
		canonicalStyle_DeviceDevicecontents_7004.setCanonical(true);
		DeviceDevicecontents_7004.getStyles().add(canonicalStyle_DeviceDevicecontents_7004);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createNode_2004(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(NodeEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_LINE_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getLineStyle_LineColor(), FigureUtilities.RGBToInteger(lineRGB));
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FILL_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getFillStyle_FillColor(), FigureUtilities.RGBToInteger(fillRGB));
		Node NodeName_5003 = createLabel(node, UMLVisualIDRegistry.getType(NodeNameEditPart.VISUAL_ID));
		Node NodeQualifiedName_5020 = createLabel(node, UMLVisualIDRegistry.getType(NodeStereoEditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createExecutionEnvironment_2005(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ExecutionEnvironmentEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_LINE_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getLineStyle_LineColor(), FigureUtilities.RGBToInteger(lineRGB));
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FILL_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getFillStyle_FillColor(), FigureUtilities.RGBToInteger(fillRGB));
		Node ExecutionEnvironmentName_5004 = createLabel(node, UMLVisualIDRegistry.getType(ExecutionEnvironmentNameEditPart.VISUAL_ID));
		Node ExecutionEnvironmentQualifiedName_5021 = createLabel(node, UMLVisualIDRegistry.getType(ExecutionEnvironmentStereoEditPart.VISUAL_ID));

		Node ExecutionEnvironmentArtifacts_7002 = createCompartment(node, UMLVisualIDRegistry.getType(ExecutionEnvironmentArtifactsEditPart.VISUAL_ID), true, true, true, true);
		CanonicalStyle canonicalStyle_ExecutionEnvironmentArtifacts_7002 = NotationFactory.eINSTANCE.createCanonicalStyle();
		canonicalStyle_ExecutionEnvironmentArtifacts_7002.setCanonical(true);
		ExecutionEnvironmentArtifacts_7002.getStyles().add(canonicalStyle_ExecutionEnvironmentArtifacts_7002);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createArtifact_2006(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(Artifact2EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_LINE_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getLineStyle_LineColor(), FigureUtilities.RGBToInteger(lineRGB));
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FILL_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getFillStyle_FillColor(), FigureUtilities.RGBToInteger(fillRGB));
		Node ArtifactFileName_5005 = createLabel(node, UMLVisualIDRegistry.getType(ArtifactFileNameEditPart.VISUAL_ID));
		Node ArtifactQualifiedName_5022 = createLabel(node, UMLVisualIDRegistry.getType(ArtifactStereoEditPart.VISUAL_ID));

		Node ArtifactArtifactFigure_contents_7009 = createCompartment(node, UMLVisualIDRegistry.getType(ArtifactArtifactFigure_contents3EditPart.VISUAL_ID), true, false, false, false);
		CanonicalStyle canonicalStyle_ArtifactArtifactFigure_contents_7009 = NotationFactory.eINSTANCE.createCanonicalStyle();
		canonicalStyle_ArtifactArtifactFigure_contents_7009.setCanonical(true);
		ArtifactArtifactFigure_contents_7009.getStyles().add(canonicalStyle_ArtifactArtifactFigure_contents_7009);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createDeploymentSpecification_2007(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createLineStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(DeploymentSpecificationEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_LINE_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getLineStyle_LineColor(), FigureUtilities.RGBToInteger(lineRGB));
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		Node DeploymentSpecificationName_5006 = createLabel(node, UMLVisualIDRegistry.getType(DeploymentSpecificationNameEditPart.VISUAL_ID));
		Node DeploymentSpecificationQualifiedName_5023 = createLabel(node, UMLVisualIDRegistry.getType(DeploymentSpecificationStereo3EditPart.VISUAL_ID));

		Node DeploymentSpecificationProperties_7003 = createCompartment(node, UMLVisualIDRegistry.getType(DeploymentSpecificationPropertiesEditPart.VISUAL_ID), true, true, true, true);
		CanonicalStyle canonicalStyle_DeploymentSpecificationProperties_7003 = NotationFactory.eINSTANCE.createCanonicalStyle();
		canonicalStyle_DeploymentSpecificationProperties_7003.setCanonical(true);
		DeploymentSpecificationProperties_7003.getStyles().add(canonicalStyle_DeploymentSpecificationProperties_7003);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createComment_2008Gen(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(CommentEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_LINE_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getLineStyle_LineColor(), FigureUtilities.RGBToInteger(lineRGB));
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FILL_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getFillStyle_FillColor(), FigureUtilities.RGBToInteger(fillRGB));
		Node CommentBody_5024 = createLabel(node, UMLVisualIDRegistry.getType(CommentBodyEditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated NOT
	 */
	public Node createComment_2008(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = createComment_2008Gen(domainElement, containerView, index, persisted, preferencesHint);
		ViewProviderUtils.initializeCommentColor(node, preferencesHint);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createElementImport_3001(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(ElementImportEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createDevice_3004(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(Device2EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_LINE_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getLineStyle_LineColor(), FigureUtilities.RGBToInteger(lineRGB));
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FILL_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getFillStyle_FillColor(), FigureUtilities.RGBToInteger(fillRGB));
		Node DeviceName_5010 = createLabel(node, UMLVisualIDRegistry.getType(DeviceName2EditPart.VISUAL_ID));
		Node DeviceQualifiedName_5018 = createLabel(node, UMLVisualIDRegistry.getType(DeviceStereo2EditPart.VISUAL_ID));

		Node DeviceDevicecontents_7005 = createCompartment(node, UMLVisualIDRegistry.getType(DeviceDevicecontents2EditPart.VISUAL_ID), false, false, false, false);
		CanonicalStyle canonicalStyle_DeviceDevicecontents_7005 = NotationFactory.eINSTANCE.createCanonicalStyle();
		canonicalStyle_DeviceDevicecontents_7005.setCanonical(true);
		DeviceDevicecontents_7005.getStyles().add(canonicalStyle_DeviceDevicecontents_7005);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createArtifact_3002(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ArtifactEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_LINE_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getLineStyle_LineColor(), FigureUtilities.RGBToInteger(lineRGB));
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FILL_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getFillStyle_FillColor(), FigureUtilities.RGBToInteger(fillRGB));
		Node ArtifactFileName_5007 = createLabel(node, UMLVisualIDRegistry.getType(ArtifactFileName2EditPart.VISUAL_ID));
		Node ArtifactQualifiedName_5015 = createLabel(node, UMLVisualIDRegistry.getType(ArtifactStereo2EditPart.VISUAL_ID));

		Node ArtifactArtifactFigure_contents_7007 = createCompartment(node, UMLVisualIDRegistry.getType(ArtifactArtifactFigure_contentsEditPart.VISUAL_ID), true, false, false, false);
		CanonicalStyle canonicalStyle_ArtifactArtifactFigure_contents_7007 = NotationFactory.eINSTANCE.createCanonicalStyle();
		canonicalStyle_ArtifactArtifactFigure_contents_7007.setCanonical(true);
		ArtifactArtifactFigure_contents_7007.getStyles().add(canonicalStyle_ArtifactArtifactFigure_contents_7007);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createArtifact_3008(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(Artifact4EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_LINE_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getLineStyle_LineColor(), FigureUtilities.RGBToInteger(lineRGB));
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FILL_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getFillStyle_FillColor(), FigureUtilities.RGBToInteger(fillRGB));
		Node ArtifactFileName_5011 = createLabel(node, UMLVisualIDRegistry.getType(ArtifactFileName3EditPart.VISUAL_ID));
		Node ArtifactQualifiedName_5014 = createLabel(node, UMLVisualIDRegistry.getType(ArtifactStereo3EditPart.VISUAL_ID));

		Node ArtifactArtifactFigure_contents_7008 = createCompartment(node, UMLVisualIDRegistry.getType(ArtifactArtifactFigure_contents2EditPart.VISUAL_ID), true, false, false, false);
		CanonicalStyle canonicalStyle_ArtifactArtifactFigure_contents_7008 = NotationFactory.eINSTANCE.createCanonicalStyle();
		canonicalStyle_ArtifactArtifactFigure_contents_7008.setCanonical(true);
		ArtifactArtifactFigure_contents_7008.getStyles().add(canonicalStyle_ArtifactArtifactFigure_contents_7008);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createDeploymentSpecification_3009(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(DeploymentSpecification2EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_LINE_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getLineStyle_LineColor(), FigureUtilities.RGBToInteger(lineRGB));
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FILL_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getFillStyle_FillColor(), FigureUtilities.RGBToInteger(fillRGB));
		Node DeploymentSpecificationName_5012 = createLabel(node, UMLVisualIDRegistry.getType(DeploymentSpecificationName2EditPart.VISUAL_ID));
		Node DeploymentSpecificationQualifiedName_5013 = createLabel(node, UMLVisualIDRegistry.getType(DeploymentSpecificationStereo4EditPart.VISUAL_ID));

		Node DeploymentSpecificationProperties_7010 = createCompartment(node, UMLVisualIDRegistry.getType(DeploymentSpecificationProperties2EditPart.VISUAL_ID), false, false, true, true);
		CanonicalStyle canonicalStyle_DeploymentSpecificationProperties_7010 = NotationFactory.eINSTANCE.createCanonicalStyle();
		canonicalStyle_DeploymentSpecificationProperties_7010.setCanonical(true);
		DeploymentSpecificationProperties_7010.getStyles().add(canonicalStyle_DeploymentSpecificationProperties_7010);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createProperty_3003(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(PropertyEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createExecutionEnvironment_3005(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ExecutionEnvironment2EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_LINE_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getLineStyle_LineColor(), FigureUtilities.RGBToInteger(lineRGB));
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FILL_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getFillStyle_FillColor(), FigureUtilities.RGBToInteger(fillRGB));
		Node ExecutionEnvironmentName_5008 = createLabel(node, UMLVisualIDRegistry.getType(ExecutionEnvironmentName2EditPart.VISUAL_ID));
		Node ExecutionEnvironmentQualifiedName_5016 = createLabel(node, UMLVisualIDRegistry.getType(ExecutionEnvironmentStereo2EditPart.VISUAL_ID));

		Node ExecutionEnvironmentArtifacts_7006 = createCompartment(node, UMLVisualIDRegistry.getType(ExecutionEnvironmentArtifacts2EditPart.VISUAL_ID), true, true, true, true);
		CanonicalStyle canonicalStyle_ExecutionEnvironmentArtifacts_7006 = NotationFactory.eINSTANCE.createCanonicalStyle();
		canonicalStyle_ExecutionEnvironmentArtifacts_7006.setCanonical(true);
		ExecutionEnvironmentArtifacts_7006.getStyles().add(canonicalStyle_ExecutionEnvironmentArtifacts_7006);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createArtifact_3006(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(Artifact3EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createNode_3007(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(Node2EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_LINE_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getLineStyle_LineColor(), FigureUtilities.RGBToInteger(lineRGB));
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FILL_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getFillStyle_FillColor(), FigureUtilities.RGBToInteger(fillRGB));
		Node NodeName_5009 = createLabel(node, UMLVisualIDRegistry.getType(NodeName2EditPart.VISUAL_ID));
		Node NodeQualifiedName_5017 = createLabel(node, UMLVisualIDRegistry.getType(NodeStereo2EditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Edge createDeployment_4001(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Edge edge = NotationFactory.eINSTANCE.createEdge();
		edge.getStyles().add(NotationFactory.eINSTANCE.createRoutingStyle());
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList points = new ArrayList(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(DeploymentEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		FontStyle edgeFontStyle = (FontStyle) edge.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (edgeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			edgeFontStyle.setFontName(fontData.getName());
			edgeFontStyle.setFontHeight(fontData.getHeight());
			edgeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			edgeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			edgeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		Node DeploymentName_6001 = createLabel(edge, UMLVisualIDRegistry.getType(DeploymentNameEditPart.VISUAL_ID));
		DeploymentName_6001.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6001 = (Location) DeploymentName_6001.getLayoutConstraint();
		location6001.setX(0);
		location6001.setY(20);
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createManifestation_4002(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Edge edge = NotationFactory.eINSTANCE.createEdge();
		edge.getStyles().add(NotationFactory.eINSTANCE.createRoutingStyle());
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList points = new ArrayList(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(ManifestationEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		FontStyle edgeFontStyle = (FontStyle) edge.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (edgeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			edgeFontStyle.setFontName(fontData.getName());
			edgeFontStyle.setFontHeight(fontData.getHeight());
			edgeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			edgeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			edgeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		Node ManifestationName_6002 = createLabel(edge, UMLVisualIDRegistry.getType(ManifestationNameEditPart.VISUAL_ID));
		ManifestationName_6002.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6002 = (Location) ManifestationName_6002.getLayoutConstraint();
		location6002.setX(0);
		location6002.setY(20);
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createDeploymentConfiguration_4003(View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Edge edge = NotationFactory.eINSTANCE.createEdge();
		edge.getStyles().add(NotationFactory.eINSTANCE.createRoutingStyle());
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList points = new ArrayList(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(DeploymentConfigurationEditPart.VISUAL_ID));
		edge.setElement(null);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		FontStyle edgeFontStyle = (FontStyle) edge.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (edgeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			edgeFontStyle.setFontName(fontData.getName());
			edgeFontStyle.setFontHeight(fontData.getHeight());
			edgeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			edgeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			edgeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createCommunicationPath_4004(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Edge edge = NotationFactory.eINSTANCE.createEdge();
		edge.getStyles().add(NotationFactory.eINSTANCE.createRoutingStyle());
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList points = new ArrayList(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(CommunicationPathEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		FontStyle edgeFontStyle = (FontStyle) edge.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (edgeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			edgeFontStyle.setFontName(fontData.getName());
			edgeFontStyle.setFontHeight(fontData.getHeight());
			edgeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			edgeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			edgeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		Node CommunicationPathName_6003 = createLabel(edge, UMLVisualIDRegistry.getType(CommunicationPathNameEditPart.VISUAL_ID));
		CommunicationPathName_6003.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6003 = (Location) CommunicationPathName_6003.getLayoutConstraint();
		location6003.setX(0);
		location6003.setY(20);
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createDependency_4005(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Edge edge = NotationFactory.eINSTANCE.createEdge();
		edge.getStyles().add(NotationFactory.eINSTANCE.createRoutingStyle());
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList points = new ArrayList(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		FontStyle edgeFontStyle = (FontStyle) edge.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (edgeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			edgeFontStyle.setFontName(fontData.getName());
			edgeFontStyle.setFontHeight(fontData.getHeight());
			edgeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			edgeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			edgeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		Node DependencyName_6004 = createLabel(edge, UMLVisualIDRegistry.getType(DependencyNameEditPart.VISUAL_ID));
		DependencyName_6004.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6004 = (Location) DependencyName_6004.getLayoutConstraint();
		location6004.setX(0);
		location6004.setY(40);
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createCommentAnnotatedElement_4006(View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList points = new ArrayList(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
		edge.setElement(null);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_LINE_COLOR);
		ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getLineStyle_LineColor(), FigureUtilities.RGBToInteger(lineRGB));
		FontStyle edgeFontStyle = (FontStyle) edge.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (edgeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			edgeFontStyle.setFontName(fontData.getName());
			edgeFontStyle.setFontHeight(fontData.getHeight());
			edgeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			edgeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			edgeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		return edge;
	}

	/**
	 * @generated
	 */
	private void stampShortcut(View containerView, Node target) {
		if (!PackageEditPart.MODEL_ID.equals(UMLVisualIDRegistry.getModelID(containerView))) {
			EAnnotation shortcutAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			shortcutAnnotation.setSource("Shortcut"); //$NON-NLS-1$
			shortcutAnnotation.getDetails().put("modelID", PackageEditPart.MODEL_ID); //$NON-NLS-1$
			target.getEAnnotations().add(shortcutAnnotation);
		}
	}

	/**
	 * @generated
	 */
	private Node createLabel(View owner, String hint) {
		DecorationNode rv = NotationFactory.eINSTANCE.createDecorationNode();
		rv.setType(hint);
		ViewUtil.insertChildView(owner, rv, ViewUtil.APPEND, true);
		return rv;
	}

	/**
	 * @generated
	 */
	private Node createCompartment(View owner, String hint, boolean canCollapse, boolean hasTitle, boolean canSort, boolean canFilter) {
		//SemanticListCompartment rv = NotationFactory.eINSTANCE.createSemanticListCompartment();
		//rv.setShowTitle(showTitle);
		//rv.setCollapsed(isCollapsed);
		Node rv;
		if (canCollapse) {
			rv = NotationFactory.eINSTANCE.createBasicCompartment();
		} else {
			rv = NotationFactory.eINSTANCE.createDecorationNode();
		}
		if (hasTitle) {
			TitleStyle ts = NotationFactory.eINSTANCE.createTitleStyle();
			ts.setShowTitle(true);
			rv.getStyles().add(ts);
		}
		if (canSort) {
			rv.getStyles().add(NotationFactory.eINSTANCE.createSortingStyle());
		}
		if (canFilter) {
			rv.getStyles().add(NotationFactory.eINSTANCE.createFilteringStyle());
		}
		rv.setType(hint);
		ViewUtil.insertChildView(owner, rv, ViewUtil.APPEND, true);
		return rv;
	}

	/**
	 * @generated
	 */
	private EObject getSemanticElement(IAdaptable semanticAdapter) {
		if (semanticAdapter == null) {
			return null;
		}
		EObject eObject = (EObject) semanticAdapter.getAdapter(EObject.class);
		if (eObject != null) {
			return EMFCoreUtil.resolve(TransactionUtil.getEditingDomain(eObject), eObject);
		}
		return null;
	}

	/**
	 * @generated
	 */
	private IElementType getSemanticElementType(IAdaptable semanticAdapter) {
		if (semanticAdapter == null) {
			return null;
		}
		return (IElementType) semanticAdapter.getAdapter(IElementType.class);
	}

}
