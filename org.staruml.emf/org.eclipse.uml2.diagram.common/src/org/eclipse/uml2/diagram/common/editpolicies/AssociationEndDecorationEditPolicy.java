package org.eclipse.uml2.diagram.common.editpolicies;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.uml2.diagram.common.conventions.AssociationEndConvention;
import org.eclipse.uml2.diagram.common.draw2d.AssociationLinkFigureBase;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;


public class AssociationEndDecorationEditPolicy extends AbstractVisualEffectEditPolicy {

		@Override
		protected boolean shouldHandleNotificationEvent(Notification event) {
			return UMLPackage.eINSTANCE.getProperty().isInstance(event.getNotifier());
		}

		@Override
		protected void refreshVisualEffect() {
			ConnectionNodeEditPart editPart = (ConnectionNodeEditPart)getHostImpl();
			refreshDecorations((AssociationLinkFigureBase)editPart.getConnectionFigure(), (IPreferenceStore) editPart.getDiagramPreferencesHint().getPreferenceStore());
		}

		@Override
		protected void installVisualEffect() {
		}
		
		private void refreshDecorations(AssociationLinkFigureBase linkFigure, IPreferenceStore store) {
			Association association = (Association) resolveSemanticElement();
			if (association == null || !association.isBinary()) {
				return;
			}
			Property sourceEnd = AssociationEndConvention.getSourceEnd(association);
			Property targetEnd = AssociationEndConvention.getTargetEnd(association);

			linkFigure.getSourceDecorationImpl().update(association, sourceEnd, targetEnd, store);
			linkFigure.getTargetDecorationImpl().update(association, targetEnd, sourceEnd, store);
		}
}
