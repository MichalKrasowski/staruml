package org.eclipse.uml2.diagram.activity.view.factories;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.view.factories.AbstractShapeViewFactory;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.activity.edit.parts.ActivityPartition_CentralBufferNodeEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ActivityPartition_CentralBufferNodeInStateEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ActivityPartition_CentralBufferNodeNameEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ActivityPartition_CentralBufferNodeOrderingEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ActivityPartition_CentralBufferNodeStereotypeEditPart;
import org.eclipse.uml2.diagram.activity.part.UMLVisualIDRegistry;

/**
 * @generated
 */

public class ActivityPartition_CentralBufferNodeViewFactory extends AbstractShapeViewFactory {

	/**
	 * @generated
	 */
	protected List createStyles(View view) {
		List styles = new ArrayList();
		styles.add(NotationFactory.eINSTANCE.createShapeStyle());
		return styles;
	}

	/**
	 * @generated
	 */
	protected void decorateView(View containerView, View view, IAdaptable semanticAdapter, String semanticHint, int index, boolean persisted) {
		if (semanticHint == null) {
			semanticHint = UMLVisualIDRegistry.getType(ActivityPartition_CentralBufferNodeEditPart.VISUAL_ID);
			view.setType(semanticHint);
		}
		super.decorateView(containerView, view, semanticAdapter, semanticHint, index, persisted);
		IAdaptable eObjectAdapter = null;
		EObject eObject = (EObject) semanticAdapter.getAdapter(EObject.class);
		if (eObject != null) {
			eObjectAdapter = new EObjectAdapter(eObject);
		}
		getViewService().createNode(eObjectAdapter, view, UMLVisualIDRegistry.getType(ActivityPartition_CentralBufferNodeNameEditPart.VISUAL_ID), ViewUtil.APPEND, true, getPreferencesHint());
		getViewService().createNode(eObjectAdapter, view, UMLVisualIDRegistry.getType(ActivityPartition_CentralBufferNodeInStateEditPart.VISUAL_ID), ViewUtil.APPEND, true, getPreferencesHint());
		getViewService().createNode(eObjectAdapter, view, UMLVisualIDRegistry.getType(ActivityPartition_CentralBufferNodeOrderingEditPart.VISUAL_ID), ViewUtil.APPEND, true, getPreferencesHint());
		getViewService().createNode(eObjectAdapter, view, UMLVisualIDRegistry.getType(ActivityPartition_CentralBufferNodeStereotypeEditPart.VISUAL_ID), ViewUtil.APPEND, true, getPreferencesHint());
	}

}
