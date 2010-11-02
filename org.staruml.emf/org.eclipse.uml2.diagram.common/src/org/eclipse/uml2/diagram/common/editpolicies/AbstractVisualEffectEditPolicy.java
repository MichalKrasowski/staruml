package org.eclipse.uml2.diagram.common.editpolicies;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.Style;
import org.eclipse.gmf.runtime.notation.View;

public abstract class AbstractVisualEffectEditPolicy extends CanonicalEditPolicy {

	protected abstract void refreshVisualEffect();
	protected abstract void installVisualEffect();

	@Override
	protected void handleNotificationEvent(Notification event) {
		if (shouldHandleNotificationEvent(event)) {
			refreshVisualEffect();
		}
	}

	@Override
	protected void refreshOnActivate() {
		installVisualEffect();
		refreshVisualEffect();
	}

	protected final void executeICommand(ICommand command) {
		executeCommand(new ICommandProxy(command));
	}

	protected final IGraphicalEditPart getHostImpl() {
		return (IGraphicalEditPart) getHost();
	}

	/**
	 * We are using CanonicalEditPolicy infrastructure for listening to the
	 * model, executing commands, etc. However, we are not going to
	 * install/remove any new children from view-tree.
	 */
	@Override
	protected final List<EObject> getSemanticChildrenList() {
		return Collections.emptyList();
	}
	
	protected final void ensureHasStyle(EClass styleClass){
		if (!NotationPackage.eINSTANCE.getStyle().isSuperTypeOf(styleClass)){
			throw new IllegalArgumentException("Notation Style expected:" + styleClass); //$NON-NLS-1$
		}
		IGraphicalEditPart editPart = getHostImpl();
		View view = editPart.getNotationView();
		Style style = view.getStyle(styleClass);
		if (style == null){
			style = (Style) styleClass.getEPackage().getEFactoryInstance().create(styleClass); 
			SetRequest request = new SetRequest(editPart.getEditingDomain(), view, NotationPackage.eINSTANCE.getView_Styles(), style);
			executeICommand(new SetValueCommand(request));
		}
	}

}
