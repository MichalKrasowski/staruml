package org.eclipse.uml2.diagram.statemachine.edit.helpers;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.diagram.statemachine.edit.helpers.StateEditHelper.StateMachineWrapper;
import org.eclipse.uml2.diagram.statemachine.part.SelectConnectionPointsDialog;
import org.eclipse.uml2.diagram.statemachine.providers.UMLElementTypes;
import org.eclipse.uml2.uml.ConnectionPointReference;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.PseudostateKind;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class ConnectionPointReferenceEditHelper extends UMLBaseEditHelper {

	public static final String PARAMETER_CONFIGURE_CONNECTION_POINT_REFERENCE = StateEditHelper.class.getName() + ":ConfigureConnectionPointReference"; //$NON-NLS-1$

	/**
	 * @NOT generated
	 */
	@Override
	protected ICommand getConfigureCommand(ConfigureRequest req) {
		if (req.getElementToConfigure() instanceof ConnectionPointReference && req.getParameter(PARAMETER_CONFIGURE_CONNECTION_POINT_REFERENCE) instanceof List) {
			ConnectionPointReference pointReference = (ConnectionPointReference) req.getElementToConfigure();
			List<Pseudostate> connectionPoints = (List<Pseudostate>) req.getParameter(PARAMETER_CONFIGURE_CONNECTION_POINT_REFERENCE);
			if (!connectionPoints.isEmpty()) {
				CompositeCommand composite = new CompositeCommand(req.getLabel());
				boolean isEntry = connectionPoints.get(0).getKind() == PseudostateKind.ENTRY_POINT_LITERAL;
				EStructuralFeature feature = isEntry ? UMLPackage.eINSTANCE.getConnectionPointReference_Entry() : UMLPackage.eINSTANCE.getConnectionPointReference_Exit();
				for (Iterator<Pseudostate> iterator = connectionPoints.iterator(); iterator.hasNext();) {
					Pseudostate connectionPoint = iterator.next();
					SetRequest request = new SetRequest(pointReference, feature, connectionPoint);
					composite.add(new SetValueCommand(request));
				}
				return composite;
			}
		}

		return super.getConfigureCommand(req);
	}

	/**
	 * @NOT generated 
	 */
	public static class ConnectionPointReferencesWrapper {

		public void addConnectionPointReference(Pseudostate reference) {
			myConnectionPointReferences.add(reference);
		}

		public void addConnectionPointReference(Collection<Pseudostate> references) {
			myConnectionPointReferences.addAll(references);
		}

		public List<Pseudostate> getConnectionPointReferences() {
			return myConnectionPointReferences;
		}

		private List<Pseudostate> myConnectionPointReferences = new LinkedList<Pseudostate>();
	}
}
