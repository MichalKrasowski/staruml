package org.eclipse.uml2.diagram.profile.edit.parts;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DiagramDragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.diagram.common.editpolicies.CreationEditPolicyWithCustomReparent;
import org.eclipse.uml2.diagram.common.editpolicies.XYLayoutEditPolicyWithMovableLabels;
import org.eclipse.uml2.diagram.profile.edit.commands.UMLCreateShortcutDecorationsCommand;
import org.eclipse.uml2.diagram.profile.edit.policies.ProfileCanonicalEditPolicy;
import org.eclipse.uml2.diagram.profile.edit.policies.ProfileItemSemanticEditPolicy;
import org.eclipse.uml2.diagram.profile.part.UMLDiagramEditor;
import org.eclipse.uml2.diagram.profile.part.UMLDiagramUpdateCommand;
import org.eclipse.uml2.diagram.profile.part.UMLVisualIDRegistry;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class ProfileEditPart extends DiagramEditPart {

	/**
	 * @generated
	 */
	public final static String MODEL_ID = "UMLProfile"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 1000;

	/**
	 * @generated
	 */
	public ProfileEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ProfileItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new ProfileCanonicalEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DiagramDragDropEditPolicy() {

			public Command getDropObjectsCommand(DropObjectsRequest dropRequest) {
				List viewDescriptors = new ArrayList();
				for (Iterator it = dropRequest.getObjects().iterator(); it.hasNext();) {
					Object nextObject = it.next();
					if (false == nextObject instanceof EObject) {
						continue;
					}
					viewDescriptors.add(new CreateViewRequest.ViewDescriptor(new EObjectAdapter((EObject) nextObject), Node.class, null, getDiagramPreferencesHint()));
				}
				return createShortcutsCommand(dropRequest, viewDescriptors);
			}

			private Command createShortcutsCommand(DropObjectsRequest dropRequest, List viewDescriptors) {
				Command command = createViewsAndArrangeCommand(dropRequest, viewDescriptors);
				if (command != null) {
					return command.chain(new ICommandProxy(new UMLCreateShortcutDecorationsCommand(getEditingDomain(), (View) getModel(), viewDescriptors)));
				}
				return null;
			}
		});
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.POPUPBAR_ROLE);

		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicyWithCustomReparent(UMLVisualIDRegistry.TYPED_ADAPTER));
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new XYLayoutEditPolicyWithMovableLabels()); //replace with U2T specific version
	}

	/**
	 * @generated
	 */
	public void refreshDiagram() {
		UMLDiagramUpdateCommand.performCanonicalUpdate(getDiagramView().getElement());
	}

	/**
	 * @generated
	 */
	protected void addSemanticListeners() {
		super.addSemanticListeners();
		Package pakkage = (Package) resolveSemanticElement();
		addListenerFilter("SemanticModel", this, pakkage, UMLPackage.eINSTANCE.getPackage_ProfileApplication());
	}

	/**
	 * @generated
	 */
	protected void handleNotificationEvent(Notification notification) {
		super.handleNotificationEvent(notification);
		if (UMLPackage.eINSTANCE.getPackage_ProfileApplication().equals(notification.getFeature())) {
			UMLDiagramEditor editor = (UMLDiagramEditor) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
			editor.refreshPalette();
		}
	}

}
