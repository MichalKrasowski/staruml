package org.eclipse.uml2.diagram.deploy.edit.policies;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.common.genapi.IUpdaterNodeDescriptor;
import org.eclipse.uml2.diagram.deploy.edit.parts.Artifact2EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.Artifact3EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.Artifact4EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.ArtifactEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.CommentEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.DeploymentSpecification2EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.DeploymentSpecificationEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.Device2EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.DeviceEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.ElementImportEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.ExecutionEnvironment2EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.ExecutionEnvironmentEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.Node2EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.NodeEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.Package2EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.PropertyEditPart;
import org.eclipse.uml2.diagram.deploy.part.UMLDiagramUpdater;
import org.eclipse.uml2.diagram.deploy.part.UMLVisualIDRegistry;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class ExecutionEnvironmentArtifactsCanonicalEditPolicy extends CanonicalEditPolicy {

	/**
	 * @generated
	 */
	Set myFeaturesToSynchronize;

	/**
	 * @generated
	 */
	protected List getSemanticChildrenList() {
		View viewObject = (View) getHost().getModel();
		List result = new LinkedList();
		for (Iterator it = UMLDiagramUpdater.getExecutionEnvironmentArtifacts_7002SemanticChildren(viewObject).iterator(); it.hasNext();) {
			result.add(((IUpdaterNodeDescriptor) it.next()).getModelElement());
		}
		return result;
	}

	/**
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	protected boolean isOrphaned(Collection semanticChildren, final View view) {
		int visualID = UMLVisualIDRegistry.getVisualID(view);
		switch (visualID) {
		case Package2EditPart.VISUAL_ID:
		case DeviceEditPart.VISUAL_ID:
		case NodeEditPart.VISUAL_ID:
		case ExecutionEnvironmentEditPart.VISUAL_ID:
		case Artifact2EditPart.VISUAL_ID:
		case DeploymentSpecificationEditPart.VISUAL_ID:
		case CommentEditPart.VISUAL_ID:
		case ElementImportEditPart.VISUAL_ID:
		case Device2EditPart.VISUAL_ID:
		case ArtifactEditPart.VISUAL_ID:
		case Artifact4EditPart.VISUAL_ID:
		case DeploymentSpecification2EditPart.VISUAL_ID:
		case PropertyEditPart.VISUAL_ID:
		case ExecutionEnvironment2EditPart.VISUAL_ID:
		case Node2EditPart.VISUAL_ID:
			return true;
		case Artifact3EditPart.VISUAL_ID:
			if (!semanticChildren.contains(view.getElement())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected String getDefaultFactoryHint() {
		return null;
	}

	/**
	 * @generated
	 */
	protected Set getFeaturesToSynchronize() {
		if (myFeaturesToSynchronize == null) {
			myFeaturesToSynchronize = new HashSet();
			myFeaturesToSynchronize.add(UMLPackage.eINSTANCE.getClass_NestedClassifier());
		}
		return myFeaturesToSynchronize;
	}

	/**
	 * @generated
	 */
	@Override
	protected String getFactoryHint(IAdaptable elementAdapter) {
		EObject domainModelElment = (EObject) elementAdapter.getAdapter(EObject.class);
		View containerView = ((IGraphicalEditPart) getHost()).getNotationView();
		int hint = UMLVisualIDRegistry.getNodeVisualID(containerView, domainModelElment);
		return (hint != -1) ? UMLVisualIDRegistry.getType(hint) : super.getFactoryHint(elementAdapter);
	}

}
