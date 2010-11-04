package org.eclipse.uml2.diagram.component.edit.policies;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.component.edit.commands.AssociationCreateCommand;
import org.eclipse.uml2.diagram.component.edit.commands.AssociationReorientCommand;
import org.eclipse.uml2.diagram.component.edit.commands.DependencyCreateCommand;
import org.eclipse.uml2.diagram.component.edit.commands.DependencyReorientCommand;
import org.eclipse.uml2.diagram.component.edit.commands.InterfaceRealizationCreateCommand;
import org.eclipse.uml2.diagram.component.edit.commands.InterfaceRealizationReorientCommand;
import org.eclipse.uml2.diagram.component.edit.parts.AssociationEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.DependencyEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.InterfaceRealizationEditPart;
import org.eclipse.uml2.diagram.component.providers.UMLElementTypes;

/**
 * @generated
 */
public class Class3ItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public Class3ItemSemanticEditPolicy() {
		super(UMLElementTypes.Class_3009);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		View view = (View) getHost().getModel();
		CompositeTransactionalCommand cmd = new CompositeTransactionalCommand(getEditingDomain(), null);
		cmd.setTransactionNestingEnabled(false);
		EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
		if (annotation == null) {
			// there are indirectly referenced children, need extra commands: false
			addDestroyShortcutsCommand(cmd, view);
			// delete host element
			cmd.add(new DestroyElementCommand(req));
		} else {
			cmd.add(new DeleteCommand(getEditingDomain(), view));
		}
		return getGEFWrapper(cmd.reduce());
	}

}
