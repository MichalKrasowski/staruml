package org.eclipse.uml2.diagram.csd.edit.policies;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.common.editpolicies.AbstractVisualEffectEditPolicy;
import org.eclipse.uml2.diagram.csd.edit.parts.PortIsBehavior2EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.PortIsBehaviorEditPart;
import org.eclipse.uml2.diagram.csd.part.UMLVisualIDRegistry;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.UMLPackage;

public class PortIsBehaviorVisualEffectEditPolicy extends AbstractVisualEffectEditPolicy {

	@Override
	protected void installVisualEffect() {
	}

	@Override
	protected void refreshVisualEffect() {
		EObject semanticHost = getSemanticHost();
		if (false == semanticHost instanceof Port) {
			return;
		}
		Port port = (Port) semanticHost;
		IGraphicalEditPart editPart = getHostImpl();
		View view = editPart.getNotationView();
		EList children = view.getChildren();
		for (Object obj : children) {
			View child = (View) obj;
			if (false == UMLVisualIDRegistry.getType(PortIsBehaviorEditPart.VISUAL_ID).equals(child.getType())
					&& false == UMLVisualIDRegistry.getType(PortIsBehavior2EditPart.VISUAL_ID).equals(child.getType())) {
				continue;
			}
			if (child.isVisible() != port.isBehavior()) {
				SetRequest request = new SetRequest(editPart.getEditingDomain(), child, NotationPackage.eINSTANCE.getView_Visible(), port.isBehavior());
				executeCommand(new ICommandProxy(new SetValueCommand(request)));
			}
		}
	}

	@Override
	protected boolean shouldHandleNotificationEvent(Notification event) {
		return UMLPackage.eINSTANCE.getPort_IsBehavior() == event.getFeature();
	}
}
