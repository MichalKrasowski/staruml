package org.eclipse.uml2.diagram.clazz.edit.policies;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.notation.FontStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.common.editpolicies.AbstractVisualEffectEditPolicy;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;

public class StaticPropertyVisualEffectEditPolicy extends AbstractVisualEffectEditPolicy {
	@Override
	protected void installVisualEffect() {
		ensureHasStyle(NotationPackage.eINSTANCE.getFontStyle());
	}
	
	@Override
	protected void refreshVisualEffect() {
		EObject semanticHost = getSemanticHost();
		if (false == semanticHost instanceof Property){
			return;
		}
		Property property = (Property)getSemanticHost();
		IGraphicalEditPart editPart = getHostImpl();
		View view = editPart.getNotationView();
		FontStyle fontStyle = (FontStyle)view.getStyle(NotationPackage.eINSTANCE.getFontStyle());
		if (fontStyle != null && fontStyle.isUnderline() != property.isStatic()){
			SetRequest request = new SetRequest(editPart.getEditingDomain(), fontStyle, NotationPackage.eINSTANCE.getFontStyle_Underline(), property.isStatic());
			executeICommand(new SetValueCommand(request));
		}
	}
	
	@Override
	protected boolean shouldHandleNotificationEvent(Notification event) {
		return UMLPackage.eINSTANCE.getFeature_IsStatic() == event.getFeature();
	}
}
