package org.eclipse.uml2.diagram.clazz.edit.policies;

import java.util.Iterator;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.common.core.command.ICompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.clazz.edit.commands.AssociationCreateCommand;
import org.eclipse.uml2.diagram.clazz.edit.commands.AssociationReorientCommand;
import org.eclipse.uml2.diagram.clazz.edit.commands.CommentAnnotatedElementCreateCommand;
import org.eclipse.uml2.diagram.clazz.edit.commands.CommentAnnotatedElementReorientCommand;
import org.eclipse.uml2.diagram.clazz.edit.commands.ConstraintConstrainedElementCreateCommand;
import org.eclipse.uml2.diagram.clazz.edit.commands.ConstraintConstrainedElementReorientCommand;
import org.eclipse.uml2.diagram.clazz.edit.commands.DependencyClientCreateCommand;
import org.eclipse.uml2.diagram.clazz.edit.commands.DependencyClientReorientCommand;
import org.eclipse.uml2.diagram.clazz.edit.commands.DependencyLinkCreateCommand;
import org.eclipse.uml2.diagram.clazz.edit.commands.DependencyLinkReorientCommand;
import org.eclipse.uml2.diagram.clazz.edit.commands.DependencySupplierCreateCommand;
import org.eclipse.uml2.diagram.clazz.edit.commands.DependencySupplierReorientCommand;
import org.eclipse.uml2.diagram.clazz.edit.commands.Generalization2CreateCommand;
import org.eclipse.uml2.diagram.clazz.edit.commands.Generalization2ReorientCommand;
import org.eclipse.uml2.diagram.clazz.edit.commands.GeneralizationCreateCommand;
import org.eclipse.uml2.diagram.clazz.edit.commands.GeneralizationGeneralCreateCommand;
import org.eclipse.uml2.diagram.clazz.edit.commands.GeneralizationGeneralReorientCommand;
import org.eclipse.uml2.diagram.clazz.edit.commands.GeneralizationReorientCommand;
import org.eclipse.uml2.diagram.clazz.edit.commands.InterfaceRealizationCreateCommand;
import org.eclipse.uml2.diagram.clazz.edit.commands.InterfaceRealizationReorientCommand;
import org.eclipse.uml2.diagram.clazz.edit.commands.PortProvidedCreateCommand;
import org.eclipse.uml2.diagram.clazz.edit.commands.PortProvidedReorientCommand;
import org.eclipse.uml2.diagram.clazz.edit.commands.PortRequiredCreateCommand;
import org.eclipse.uml2.diagram.clazz.edit.commands.PortRequiredReorientCommand;
import org.eclipse.uml2.diagram.clazz.edit.commands.PropertyLinkCreateCommand;
import org.eclipse.uml2.diagram.clazz.edit.commands.PropertyLinkReorientCommand;
import org.eclipse.uml2.diagram.clazz.edit.commands.RealizationCreateCommand;
import org.eclipse.uml2.diagram.clazz.edit.commands.RealizationReorientCommand;
import org.eclipse.uml2.diagram.clazz.edit.commands.TemplateBindingCreateCommand;
import org.eclipse.uml2.diagram.clazz.edit.commands.TemplateBindingReorientCommand;
import org.eclipse.uml2.diagram.clazz.edit.commands.UsageCreateCommand;
import org.eclipse.uml2.diagram.clazz.edit.commands.UsageReorientCommand;
import org.eclipse.uml2.diagram.clazz.edit.parts.AssociationEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Class4EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.ConstraintConstrainedElementEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Dependency2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.DependencyClientEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.DependencySupplierEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Generalization2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.GeneralizationEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.GeneralizationGeneralEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.InterfaceAttributesEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.InterfaceClassesEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.InterfaceOperationsEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.InterfaceRealizationEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Operation6EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.PortProvidedEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.PortRequiredEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Property6EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Property7EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.RealizationEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.TemplateBindingEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.UsageEditPart;
import org.eclipse.uml2.diagram.clazz.part.UMLVisualIDRegistry;
import org.eclipse.uml2.diagram.clazz.providers.UMLElementTypes;

/**
 * @generated
 */
public class Interface2ItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public Interface2ItemSemanticEditPolicy() {
		super(UMLElementTypes.Interface_2013);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		View view = (View) getHost().getModel();
		CompositeTransactionalCommand cmd = new CompositeTransactionalCommand(getEditingDomain(), null);
		cmd.setTransactionNestingEnabled(false);
		for (Iterator it = view.getTargetEdges().iterator(); it.hasNext();) {
			Edge incomingLink = (Edge) it.next();
			if (UMLVisualIDRegistry.getVisualID(incomingLink) == GeneralizationEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (UMLVisualIDRegistry.getVisualID(incomingLink) == Dependency2EditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (UMLVisualIDRegistry.getVisualID(incomingLink) == Property7EditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (UMLVisualIDRegistry.getVisualID(incomingLink) == ConstraintConstrainedElementEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null, incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (UMLVisualIDRegistry.getVisualID(incomingLink) == AssociationEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (UMLVisualIDRegistry.getVisualID(incomingLink) == DependencySupplierEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null, incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (UMLVisualIDRegistry.getVisualID(incomingLink) == DependencyClientEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null, incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (UMLVisualIDRegistry.getVisualID(incomingLink) == InterfaceRealizationEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (UMLVisualIDRegistry.getVisualID(incomingLink) == RealizationEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (UMLVisualIDRegistry.getVisualID(incomingLink) == GeneralizationGeneralEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null, incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (UMLVisualIDRegistry.getVisualID(incomingLink) == UsageEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (UMLVisualIDRegistry.getVisualID(incomingLink) == TemplateBindingEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (UMLVisualIDRegistry.getVisualID(incomingLink) == PortProvidedEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null, incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (UMLVisualIDRegistry.getVisualID(incomingLink) == PortRequiredEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null, incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (UMLVisualIDRegistry.getVisualID(incomingLink) == CommentAnnotatedElementEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null, incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
		}
		for (Iterator it = view.getSourceEdges().iterator(); it.hasNext();) {
			Edge outgoingLink = (Edge) it.next();
			if (UMLVisualIDRegistry.getVisualID(outgoingLink) == GeneralizationEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (UMLVisualIDRegistry.getVisualID(outgoingLink) == Dependency2EditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (UMLVisualIDRegistry.getVisualID(outgoingLink) == AssociationEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (UMLVisualIDRegistry.getVisualID(outgoingLink) == RealizationEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (UMLVisualIDRegistry.getVisualID(outgoingLink) == Generalization2EditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (UMLVisualIDRegistry.getVisualID(outgoingLink) == UsageEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (UMLVisualIDRegistry.getVisualID(outgoingLink) == TemplateBindingEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
		}
		EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
		if (annotation == null) {
			// there are indirectly referenced children, need extra commands: false
			addDestroyChildNodesCommand(cmd);
			addDestroyShortcutsCommand(cmd, view);
			// delete host element
			cmd.add(new DestroyElementCommand(req));
		} else {
			cmd.add(new DeleteCommand(getEditingDomain(), view));
		}
		return getGEFWrapper(cmd.reduce());
	}

	/**
	 * @generated
	 */
	private void addDestroyChildNodesCommand(ICompositeCommand cmd) {
		View view = (View) getHost().getModel();
		for (Iterator nit = view.getChildren().iterator(); nit.hasNext();) {
			Node node = (Node) nit.next();
			switch (UMLVisualIDRegistry.getVisualID(node)) {
			case InterfaceAttributesEditPart.VISUAL_ID:
				for (Iterator cit = node.getChildren().iterator(); cit.hasNext();) {
					Node cnode = (Node) cit.next();
					switch (UMLVisualIDRegistry.getVisualID(cnode)) {
					case Property6EditPart.VISUAL_ID:
						cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), cnode.getElement(), false))); // directlyOwned: true
						// don't need explicit deletion of cnode as parent's view deletion would clean child views as well 
						// cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), cnode));
						break;
					}
				}
				break;
			case InterfaceOperationsEditPart.VISUAL_ID:
				for (Iterator cit = node.getChildren().iterator(); cit.hasNext();) {
					Node cnode = (Node) cit.next();
					switch (UMLVisualIDRegistry.getVisualID(cnode)) {
					case Operation6EditPart.VISUAL_ID:
						cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), cnode.getElement(), false))); // directlyOwned: true
						// don't need explicit deletion of cnode as parent's view deletion would clean child views as well 
						// cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), cnode));
						break;
					}
				}
				break;
			case InterfaceClassesEditPart.VISUAL_ID:
				for (Iterator cit = node.getChildren().iterator(); cit.hasNext();) {
					Node cnode = (Node) cit.next();
					switch (UMLVisualIDRegistry.getVisualID(cnode)) {
					case Class4EditPart.VISUAL_ID:
						cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), cnode.getElement(), false))); // directlyOwned: true
						// don't need explicit deletion of cnode as parent's view deletion would clean child views as well 
						// cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), cnode));
						break;
					}
				}
				break;
			}
		}
	}

	/**
	 * @generated
	 */
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
		Command command = req.getTarget() == null ? getStartCreateRelationshipCommand(req) : getCompleteCreateRelationshipCommand(req);
		return command != null ? command : super.getCreateRelationshipCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (UMLElementTypes.Generalization_4001 == req.getElementType()) {
			return getGEFWrapper(new GeneralizationCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Dependency_4002 == req.getElementType()) {
			return getGEFWrapper(new DependencyLinkCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Property_4003 == req.getElementType()) {
			return null;
		}
		if (UMLElementTypes.ConstraintConstrainedElement_4004 == req.getElementType()) {
			return null;
		}
		if (UMLElementTypes.Association_4005 == req.getElementType()) {
			return getGEFWrapper(new AssociationCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.DependencySupplier_4006 == req.getElementType()) {
			return null;
		}
		if (UMLElementTypes.DependencyClient_4007 == req.getElementType()) {
			return null;
		}
		if (UMLElementTypes.InterfaceRealization_4008 == req.getElementType()) {
			return null;
		}
		if (UMLElementTypes.Realization_4010 == req.getElementType()) {
			return getGEFWrapper(new RealizationCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Generalization_4011 == req.getElementType()) {
			return getGEFWrapper(new Generalization2CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.GeneralizationGeneral_4012 == req.getElementType()) {
			return null;
		}
		if (UMLElementTypes.Usage_4013 == req.getElementType()) {
			return getGEFWrapper(new UsageCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.TemplateBinding_4016 == req.getElementType()) {
			return getGEFWrapper(new TemplateBindingCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.PortProvided_4017 == req.getElementType()) {
			return null;
		}
		if (UMLElementTypes.PortRequired_4018 == req.getElementType()) {
			return null;
		}
		if (UMLElementTypes.CommentAnnotatedElement_4019 == req.getElementType()) {
			return null;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (UMLElementTypes.Generalization_4001 == req.getElementType()) {
			return getGEFWrapper(new GeneralizationCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Dependency_4002 == req.getElementType()) {
			return getGEFWrapper(new DependencyLinkCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Property_4003 == req.getElementType()) {
			return getGEFWrapper(new PropertyLinkCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.ConstraintConstrainedElement_4004 == req.getElementType()) {
			return getGEFWrapper(new ConstraintConstrainedElementCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Association_4005 == req.getElementType()) {
			return getGEFWrapper(new AssociationCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.DependencySupplier_4006 == req.getElementType()) {
			return getGEFWrapper(new DependencySupplierCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.DependencyClient_4007 == req.getElementType()) {
			return getGEFWrapper(new DependencyClientCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.InterfaceRealization_4008 == req.getElementType()) {
			return getGEFWrapper(new InterfaceRealizationCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Realization_4010 == req.getElementType()) {
			return getGEFWrapper(new RealizationCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Generalization_4011 == req.getElementType()) {
			return null;
		}
		if (UMLElementTypes.GeneralizationGeneral_4012 == req.getElementType()) {
			return getGEFWrapper(new GeneralizationGeneralCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Usage_4013 == req.getElementType()) {
			return getGEFWrapper(new UsageCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.TemplateBinding_4016 == req.getElementType()) {
			return getGEFWrapper(new TemplateBindingCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.PortProvided_4017 == req.getElementType()) {
			return getGEFWrapper(new PortProvidedCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.PortRequired_4018 == req.getElementType()) {
			return getGEFWrapper(new PortRequiredCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.CommentAnnotatedElement_4019 == req.getElementType()) {
			return getGEFWrapper(new CommentAnnotatedElementCreateCommand(req, req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * Returns command to reorient EClass based link. New link target or source
	 * should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {
		switch (getVisualID(req)) {
		case GeneralizationEditPart.VISUAL_ID:
			return getGEFWrapper(new GeneralizationReorientCommand(req));
		case Dependency2EditPart.VISUAL_ID:
			return getGEFWrapper(new DependencyLinkReorientCommand(req));
		case Property7EditPart.VISUAL_ID:
			return getGEFWrapper(new PropertyLinkReorientCommand(req));
		case AssociationEditPart.VISUAL_ID:
			return getGEFWrapper(new AssociationReorientCommand(req));
		case InterfaceRealizationEditPart.VISUAL_ID:
			return getGEFWrapper(new InterfaceRealizationReorientCommand(req));
		case RealizationEditPart.VISUAL_ID:
			return getGEFWrapper(new RealizationReorientCommand(req));
		case Generalization2EditPart.VISUAL_ID:
			return getGEFWrapper(new Generalization2ReorientCommand(req));
		case UsageEditPart.VISUAL_ID:
			return getGEFWrapper(new UsageReorientCommand(req));
		case TemplateBindingEditPart.VISUAL_ID:
			return getGEFWrapper(new TemplateBindingReorientCommand(req));
		}
		return super.getReorientRelationshipCommand(req);
	}

	/**
	 * Returns command to reorient EReference based link. New link target or source
	 * should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest req) {
		switch (getVisualID(req)) {
		case ConstraintConstrainedElementEditPart.VISUAL_ID:
			return getGEFWrapper(new ConstraintConstrainedElementReorientCommand(req));
		case DependencySupplierEditPart.VISUAL_ID:
			return getGEFWrapper(new DependencySupplierReorientCommand(req));
		case DependencyClientEditPart.VISUAL_ID:
			return getGEFWrapper(new DependencyClientReorientCommand(req));
		case GeneralizationGeneralEditPart.VISUAL_ID:
			return getGEFWrapper(new GeneralizationGeneralReorientCommand(req));
		case PortProvidedEditPart.VISUAL_ID:
			return getGEFWrapper(new PortProvidedReorientCommand(req));
		case PortRequiredEditPart.VISUAL_ID:
			return getGEFWrapper(new PortRequiredReorientCommand(req));
		case CommentAnnotatedElementEditPart.VISUAL_ID:
			return getGEFWrapper(new CommentAnnotatedElementReorientCommand(req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
