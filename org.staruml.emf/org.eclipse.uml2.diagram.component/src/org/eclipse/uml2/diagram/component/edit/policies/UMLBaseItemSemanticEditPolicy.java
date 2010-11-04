package org.eclipse.uml2.diagram.component.edit.policies;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.ICompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.SemanticEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IEditHelperContext;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.GetEditContextRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.component.edit.helpers.UMLBaseEditHelper;
import org.eclipse.uml2.diagram.component.expressions.UMLAbstractExpression;
import org.eclipse.uml2.diagram.component.expressions.UMLOCLFactory;
import org.eclipse.uml2.diagram.component.part.UMLDiagramEditorPlugin;
import org.eclipse.uml2.diagram.component.part.UMLVisualIDRegistry;
import org.eclipse.uml2.diagram.component.providers.UMLElementTypes;
import org.eclipse.uml2.uml.BehavioredClassifier;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.StructuredClassifier;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class UMLBaseItemSemanticEditPolicy extends SemanticEditPolicy {

	/**
	 * Extended request data key to hold editpart visual id.
	 * 
	 * @generated
	 */
	public static final String VISUAL_ID_KEY = "visual_id"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final IElementType myElementType;

	/**
	 * @generated
	 */
	protected UMLBaseItemSemanticEditPolicy(IElementType elementType) {
		myElementType = elementType;
	}

	/**
	 * Add visual id of edited editpart to extended data of the request
	 * so command switch can decide what kind of diagram element is being edited.
	 * It is done in those cases when it's not possible to deduce diagram
	 * element kind from domain element.
	 * 
	 * @generated
	 */
	public Command getCommand(Request request) {
		if (request instanceof ReconnectRequest) {
			Object view = ((ReconnectRequest) request).getConnectionEditPart().getModel();
			if (view instanceof View) {
				Integer id = new Integer(UMLVisualIDRegistry.getVisualID((View) view));
				request.getExtendedData().put(VISUAL_ID_KEY, id);
			}
		}
		return super.getCommand(request);
	}

	/**
	 * Returns visual id from request parameters.
	 * 
	 * @generated
	 */
	protected int getVisualID(IEditCommandRequest request) {
		Object id = request.getParameter(VISUAL_ID_KEY);
		return id instanceof Integer ? ((Integer) id).intValue() : -1;
	}

	/**
	 * @generated
	 */
	protected Command getSemanticCommand(IEditCommandRequest request) {
		IEditCommandRequest completedRequest = completeRequest(request);
		Command semanticCommand = getSemanticCommandSwitch(completedRequest);
		semanticCommand = getEditHelperCommand(completedRequest, semanticCommand);
		if (completedRequest instanceof DestroyRequest) {
			DestroyRequest destroyRequest = (DestroyRequest) completedRequest;
			return shouldProceed(destroyRequest) ? addDeleteViewCommand(semanticCommand, destroyRequest) : null;
		}
		return semanticCommand;
	}

	/**
	 * @generated
	 */
	protected Command addDeleteViewCommand(Command mainCommand, DestroyRequest completedRequest) {
		Command deleteViewCommand = getGEFWrapper(new DeleteCommand(getEditingDomain(), (View) getHost().getModel()));
		return mainCommand == null ? deleteViewCommand : mainCommand.chain(deleteViewCommand);
	}

	/**
	 * @generated
	 */
	private Command getEditHelperCommand(IEditCommandRequest request, Command editPolicyCommand) {
		if (editPolicyCommand != null) {
			ICommand command = editPolicyCommand instanceof ICommandProxy ? ((ICommandProxy) editPolicyCommand).getICommand() : new CommandProxy(editPolicyCommand);
			request.setParameter(UMLBaseEditHelper.EDIT_POLICY_COMMAND, command);
		}
		IElementType requestContextElementType = getContextElementType(request);
		request.setParameter(UMLBaseEditHelper.CONTEXT_ELEMENT_TYPE, requestContextElementType);
		ICommand command = requestContextElementType.getEditCommand(request);
		request.setParameter(UMLBaseEditHelper.EDIT_POLICY_COMMAND, null);
		request.setParameter(UMLBaseEditHelper.CONTEXT_ELEMENT_TYPE, null);
		if (command != null) {
			if (!(command instanceof CompositeTransactionalCommand)) {
				command = new CompositeTransactionalCommand(getEditingDomain(), command.getLabel()).compose(command);
			}
			return new ICommandProxy(command);
		}
		return editPolicyCommand;
	}

	/**
	 * @generated
	 */
	private IElementType getContextElementType(IEditCommandRequest request) {
		IElementType requestContextElementType = UMLElementTypes.getElementType(getVisualID(request));
		return requestContextElementType != null ? requestContextElementType : myElementType;
	}

	/**
	 * @generated
	 */
	protected Command getSemanticCommandSwitch(IEditCommandRequest req) {
		if (req instanceof CreateRelationshipRequest) {
			return getCreateRelationshipCommand((CreateRelationshipRequest) req);
		} else if (req instanceof CreateElementRequest) {
			return getCreateCommand((CreateElementRequest) req);
		} else if (req instanceof ConfigureRequest) {
			return getConfigureCommand((ConfigureRequest) req);
		} else if (req instanceof DestroyElementRequest) {
			return getDestroyElementCommand((DestroyElementRequest) req);
		} else if (req instanceof DestroyReferenceRequest) {
			return getDestroyReferenceCommand((DestroyReferenceRequest) req);
		} else if (req instanceof DuplicateElementsRequest) {
			return getDuplicateCommand((DuplicateElementsRequest) req);
		} else if (req instanceof GetEditContextRequest) {
			return getEditContextCommand((GetEditContextRequest) req);
		} else if (req instanceof MoveRequest) {
			return getMoveCommand((MoveRequest) req);
		} else if (req instanceof ReorientReferenceRelationshipRequest) {
			return getReorientReferenceRelationshipCommand((ReorientReferenceRelationshipRequest) req);
		} else if (req instanceof ReorientRelationshipRequest) {
			return getReorientRelationshipCommand((ReorientRelationshipRequest) req);
		} else if (req instanceof SetRequest) {
			return getSetCommand((SetRequest) req);
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getConfigureCommand(ConfigureRequest req) {
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getSetCommand(SetRequest req) {
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getEditContextCommand(GetEditContextRequest req) {
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getDuplicateCommand(DuplicateElementsRequest req) {
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getMoveCommand(MoveRequest req) {
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest req) {
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * @generated
	 */
	protected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * @generated
	 */
	protected final Command getGEFWrapper(ICommand cmd) {
		return new ICommandProxy(cmd);
	}

	/**
	 * Returns editing domain from the host edit part.
	 * 
	 * @generated
	 */
	protected TransactionalEditingDomain getEditingDomain() {
		return ((IGraphicalEditPart) getHost()).getEditingDomain();
	}

	/**
	 * Clean all shortcuts to the host element from the same diagram
	 * @generated
	 */
	protected void addDestroyShortcutsCommand(ICompositeCommand cmd, View view) {
		assert view.getEAnnotation("Shortcut") == null;
		for (Iterator it = view.getDiagram().getChildren().iterator(); it.hasNext();) {
			View nextView = (View) it.next();
			if (nextView.getEAnnotation("Shortcut") == null || !nextView.isSetElement() || nextView.getElement() != view.getElement()) { //$NON-NLS-1$
				continue;
			}
			cmd.add(new DeleteCommand(getEditingDomain(), nextView));
		}
	}

	/**
	 * @generated 
	 */
	public static class LinkConstraints {

		/**
		 * @generated 
		 */
		private static final String OPPOSITE_END_VAR = "oppositeEnd"; //$NON-NLS-1$

		/**
		 * @generated 
		 */
		private static UMLAbstractExpression InterfaceRealization_4001_SourceExpression;

		/**
		 * @generated 
		 */
		private static UMLAbstractExpression PortProvided_4006_SourceExpression;

		/**
		 * @generated 
		 */
		private static UMLAbstractExpression PortRequired_4004_SourceExpression;

		/**
		 * @generated
		 */
		private static UMLAbstractExpression Dependency_4009_TargetExpression;

		/**
		 * @generated
		 */
		private static UMLAbstractExpression ConnectorEndRole_4010_SourceExpression;

		/**
		 * @generated 
		 */
		public static boolean canCreateInterfaceRealization_4001(BehavioredClassifier container, BehavioredClassifier source, Interface target) {
			return canExistInterfaceRealization_4001(container, source, target);
		}

		/**
		 * @generated 
		 */
		public static boolean canCreatePortProvided_4006(Port source, Interface target) {
			if (source != null) {
				if (source.getProvideds().contains(target)) {
					return false;
				}
			}

			return canExistPortProvided_4006(source, target);
		}

		/**
		 * @generated 
		 */
		public static boolean canCreatePortRequired_4004(Port source, Interface target) {
			if (source != null) {
				if (source.getRequireds().contains(target)) {
					return false;
				}
			}

			return canExistPortRequired_4004(source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canCreateComponentRequired_4007(Component source, Interface target) {
			if (source != null) {
				if (source.getRequireds().contains(target)) {
					return false;
				}
			}

			return canExistComponentRequired_4007(source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canCreateConnector_4008(StructuredClassifier container, ConnectableElement source, ConnectableElement target) {
			return canExistConnector_4008(container, source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canCreateDependency_4009(Package container, NamedElement source, NamedElement target) {
			return canExistDependency_4009(container, source, target);
		}

		/**
		 * 
		 * @generated
		 */
		public static boolean canCreateConnectorEndRole_4010(ConnectorEnd source, ConnectableElement target) {
			if (source != null) {
				if (source.getRole() != null) {
					return false;
				}
			}

			return canExistConnectorEndRole_4010(source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canCreateAssociation_4011(Package container, Type source, Type target) {
			return canExistAssociation_4011(container, source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canCreateCommentAnnotatedElement_4012(Comment source, Element target) {
			if (source != null) {
				if (source.getAnnotatedElements().contains(target)) {
					return false;
				}
			}

			return canExistCommentAnnotatedElement_4012(source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canExistInterfaceRealization_4001(BehavioredClassifier container, BehavioredClassifier source, Interface target) {
			try {
				if (source == null) {
					return true;
				}
				if (InterfaceRealization_4001_SourceExpression == null) {
					Map env = Collections.singletonMap(OPPOSITE_END_VAR, UMLPackage.eINSTANCE.getInterface());
					InterfaceRealization_4001_SourceExpression = UMLOCLFactory.getExpression("self.oclIsKindOf(uml::Component)", UMLPackage.eINSTANCE.getBehavioredClassifier(), env); //$NON-NLS-1$
				}
				Object sourceVal = InterfaceRealization_4001_SourceExpression.evaluate(source, Collections.singletonMap(OPPOSITE_END_VAR, target));
				if (false == sourceVal instanceof Boolean || !((Boolean) sourceVal).booleanValue()) {
					return false;
				} // else fall-through
				return true;
			} catch (Exception e) {
				UMLDiagramEditorPlugin.getInstance().logError("Link constraint evaluation error", e); //$NON-NLS-1$
				return false;
			}
		}

		/**
		 * @generated
		 */
		public static boolean canExistPortProvided_4006(Port source, Interface target) {
			try {
				if (source == null) {
					return true;
				}
				if (PortProvided_4006_SourceExpression == null) {
					Map env = Collections.singletonMap(OPPOSITE_END_VAR, UMLPackage.eINSTANCE.getInterface());
					PortProvided_4006_SourceExpression = UMLOCLFactory
							.getExpression(
									"self.oclIsKindOf(uml::Port) and (self.oclAsType(uml::Port).type.oclIsUndefined() or self.oclAsType(uml::Port).type.oclIsKindOf(uml::Classifier))", UMLPackage.eINSTANCE.getPort(), env); //$NON-NLS-1$
				}
				Object sourceVal = PortProvided_4006_SourceExpression.evaluate(source, Collections.singletonMap(OPPOSITE_END_VAR, target));
				if (false == sourceVal instanceof Boolean || !((Boolean) sourceVal).booleanValue()) {
					return false;
				} // else fall-through
				return true;
			} catch (Exception e) {
				UMLDiagramEditorPlugin.getInstance().logError("Link constraint evaluation error", e); //$NON-NLS-1$
				return false;
			}
		}

		/**
		 * @generated
		 */
		public static boolean canExistPortRequired_4004(Port source, Interface target) {
			try {
				if (source == null) {
					return true;
				}
				if (PortRequired_4004_SourceExpression == null) {
					Map env = Collections.singletonMap(OPPOSITE_END_VAR, UMLPackage.eINSTANCE.getInterface());
					PortRequired_4004_SourceExpression = UMLOCLFactory.getExpression("self.oclIsKindOf(uml::Port)", UMLPackage.eINSTANCE.getPort(), env); //$NON-NLS-1$
				}
				Object sourceVal = PortRequired_4004_SourceExpression.evaluate(source, Collections.singletonMap(OPPOSITE_END_VAR, target));
				if (false == sourceVal instanceof Boolean || !((Boolean) sourceVal).booleanValue()) {
					return false;
				} // else fall-through
				return true;
			} catch (Exception e) {
				UMLDiagramEditorPlugin.getInstance().logError("Link constraint evaluation error", e); //$NON-NLS-1$
				return false;
			}
		}

		/**
		 * @generated
		 */
		public static boolean canExistComponentRequired_4007(Component source, Interface target) {
			return true;
		}

		/**
		 * @generated
		 */
		public static boolean canExistConnector_4008(StructuredClassifier container, ConnectableElement source, ConnectableElement target) {
			return true;
		}

		/**
		 * @generated
		 */
		public static boolean canExistDependency_4009(Package container, NamedElement source, NamedElement target) {
			try {
				if (target == null) {
					return true;
				}
				if (Dependency_4009_TargetExpression == null) {
					Map env = Collections.singletonMap(OPPOSITE_END_VAR, UMLPackage.eINSTANCE.getNamedElement());
					Dependency_4009_TargetExpression = UMLOCLFactory.getExpression("not self.oclIsKindOf(uml::Interface)\r\n", UMLPackage.eINSTANCE.getNamedElement(), env); //$NON-NLS-1$
				}
				Object targetVal = Dependency_4009_TargetExpression.evaluate(target, Collections.singletonMap(OPPOSITE_END_VAR, source));
				if (false == targetVal instanceof Boolean || !((Boolean) targetVal).booleanValue()) {
					return false;
				} // else fall-through
				return true;
			} catch (Exception e) {
				UMLDiagramEditorPlugin.getInstance().logError("Link constraint evaluation error", e); //$NON-NLS-1$
				return false;
			}
		}

		/**
		 * @generated
		 */
		public static boolean canExistConnectorEndRole_4010(ConnectorEnd source, ConnectableElement target) {
			try {
				if (source == null) {
					return true;
				}
				if (ConnectorEndRole_4010_SourceExpression == null) {
					Map env = Collections.singletonMap(OPPOSITE_END_VAR, UMLPackage.eINSTANCE.getConnectableElement());
					ConnectorEndRole_4010_SourceExpression = UMLOCLFactory.getExpression(
							"self.oclIsKindOf(uml::Connector) and (self.oclAsType(uml::Connector).kind = ConnectorKind::assembly)", UMLPackage.eINSTANCE.getConnectorEnd(), env); //$NON-NLS-1$
				}
				Object sourceVal = ConnectorEndRole_4010_SourceExpression.evaluate(source, Collections.singletonMap(OPPOSITE_END_VAR, target));
				if (false == sourceVal instanceof Boolean || !((Boolean) sourceVal).booleanValue()) {
					return false;
				} // else fall-through
				return true;
			} catch (Exception e) {
				UMLDiagramEditorPlugin.getInstance().logError("Link constraint evaluation error", e); //$NON-NLS-1$
				return false;
			}
		}

		/**
		 * @generated
		 */
		public static boolean canExistAssociation_4011(Package container, Type source, Type target) {
			return true;
		}

		/**
		 * @generated
		 */
		public static boolean canExistCommentAnnotatedElement_4012(Comment source, Element target) {
			return true;
		}
	}

}