package org.eclipse.uml2.diagram.common.editpolicies;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramColorRegistry;
import org.eclipse.gmf.runtime.notation.LineStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.uml2.diagram.common.preferences.UMLPreferencesConstants;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.UMLPackage;


public class PortVisualEffectEditPolicy extends AbstractVisualEffectEditPolicy {

	@Override
	protected boolean shouldHandleNotificationEvent(Notification event) {
		return UMLPackage.eINSTANCE.getTypedElement_Type() == event.getFeature();
	}
	
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
		boolean hasType = port.getType() != null;
		if (!hasType) {
			IPreferenceStore store = (IPreferenceStore) editPart.getDiagramPreferencesHint().getPreferenceStore();
			editPart.getContentPane().setForegroundColor(getHighlightColor(store));
		} else {// has type
			LineStyle style = (LineStyle) editPart.getPrimaryView().getStyle(NotationPackage.Literals.LINE_STYLE);
			if (style != null) {
				editPart.getContentPane().setForegroundColor(DiagramColorRegistry.getInstance().getColor(new Integer(style.getLineColor())));
			}
		}
	}
	
	private Color getHighlightColor(IPreferenceStore store) {
		RGB rgb = PreferenceConverter.getColor(store, UMLPreferencesConstants.HIGHLIGHT_COLOR);
		return DiagramColorRegistry.getInstance().getColor(rgb);
	}

}
