package org.eclipse.uml2.diagram.clazz.edit.commands;

import java.util.Iterator;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.internal.commands.SetConnectionBendpointsCommand;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest.ConnectionViewAndElementDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest.ConnectionViewDescriptor;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.clazz.edit.helpers.DependencyEditHelper;
import org.eclipse.uml2.diagram.clazz.edit.parts.Dependency2EditPart;
import org.eclipse.uml2.diagram.clazz.part.CustomMessages;
import org.eclipse.uml2.diagram.clazz.providers.UMLElementTypes;
import org.eclipse.uml2.uml.Dependency;

public class ChangeDependencyTypeCommand extends CompoundCommand {

	private EClass dependencyType;
	private ConnectionEditPart editPart;

	private CreateConnectionViewAndElementRequest createViewRequest;

	public ChangeDependencyTypeCommand(ConnectionEditPart editPart, EClass dependencyType) {
		this(editPart, dependencyType, PreferencesHint.USE_DEFAULTS);
	}

	public ChangeDependencyTypeCommand(ConnectionEditPart editPart, EClass dependencyType, PreferencesHint preferencesHint) {
		super(CustomMessages.ChangeDependencyTypeCommand_command_label);
		this.dependencyType = dependencyType;
		this.editPart = editPart;
		add(getDeleteViewCommand());
		createViewRequest = getCreateViewRequest(preferencesHint);
		add(getCreateViewCommand());
	}

	public ConnectionViewDescriptor getElementDescriptor() {
		final Object newObject = createViewRequest.getNewObject();
		if (false == newObject instanceof ConnectionViewAndElementDescriptor) {
			return null;
		}
		return (ConnectionViewAndElementDescriptor) newObject;
	}

	private Command getDeleteViewCommand() {
		Request deleteViewRequest = new GroupRequest(RequestConstants.REQ_DELETE);
		Command command = editPart.getCommand(deleteViewRequest);
		return (command != null) ? command : UnexecutableCommand.INSTANCE;
	}

	private Command getCreateViewCommand() {
		if (createViewRequest == null) {
			return UnexecutableCommand.INSTANCE;
		}
		EditPart sourceEditPart = editPart.getSource();
		createViewRequest.setType(RequestConstants.REQ_CONNECTION_START);
		createViewRequest.setLocation(getSourceLocation(editPart));
		sourceEditPart.getCommand(createViewRequest);

		EditPart targetEditPart = editPart.getTarget();
		createViewRequest.setType(RequestConstants.REQ_CONNECTION_END);
		createViewRequest.setLocation(getTargetLocation(editPart));
		Command createViewCommand = targetEditPart.getCommand(createViewRequest);
		if (createViewCommand == null) {
			return UnexecutableCommand.INSTANCE;
		}
		processSetBendPointsCommand(createViewRequest);
		return createViewCommand;
	}

	private CreateConnectionViewAndElementRequest getCreateViewRequest(PreferencesHint preferencesHint) {
		View view = (View) editPart.getModel();
		if (view == null) {
			return null;
		}
		ConnectionViewAndElementDescriptor viewDescriptor = getConnectionViewDescriptor(preferencesHint);
		CreateConnectionViewAndElementRequest createViewRequest = new CreateConnectionViewAndElementRequest(viewDescriptor);
		createViewRequest.setSourceEditPart(editPart.getSource());
		createViewRequest.setTargetEditPart(editPart.getTarget());
		return createViewRequest;
	}

	private ConnectionViewAndElementDescriptor getConnectionViewDescriptor(PreferencesHint preferencesHint) {
		String semanticHint = String.valueOf(Dependency2EditPart.VISUAL_ID);
		CreateRelationshipRequest createElementRequest = new CreateRelationshipRequest(UMLElementTypes.Dependency_4002);
		createElementRequest.setSource(((View) editPart.getSource().getModel()).getElement());
		createElementRequest.setTarget(((View) editPart.getTarget().getModel()).getElement());
		createElementRequest.setParameter(DependencyEditHelper.PARAMETER_DEPENDENCY_TYPE, dependencyType);
		String name = ((Dependency)((View)editPart.getModel()).getElement()).getName(); 
		createElementRequest.setParameter(DependencyEditHelper.PARAMETER_DEPENDENCY_NAME, name);
		ConnectionViewAndElementDescriptor viewDescriptor = new ConnectionViewAndElementDescriptor(new CreateElementRequestAdapter(createElementRequest), semanticHint, preferencesHint);
		return viewDescriptor;
	}

	private Point getSourceLocation(ConnectionEditPart editPart) {
		return editPart.getConnectionFigure().getSourceAnchor().getReferencePoint();
	}

	private Point getTargetLocation(ConnectionEditPart editPart) {
		return editPart.getConnectionFigure().getTargetAnchor().getReferencePoint();
	}

	private void processSetBendPointsCommand(CreateConnectionRequest createConnectionRequest) {
		Point sourceRefPoint;
		Point targetRefPoint;
		ConnectionAnchor sourceAnchor = editPart.getConnectionFigure().getSourceAnchor();
		ConnectionAnchor targetAnchor = editPart.getConnectionFigure().getTargetAnchor();
		if (sourceAnchor == null) {
			return;
		}
		sourceRefPoint = sourceAnchor.getReferencePoint().getCopy();
		sourceAnchor.getOwner().translateToRelative(sourceRefPoint);
		if (targetAnchor == null) {
			return;
		}
		targetRefPoint = targetAnchor.getReferencePoint().getCopy();
		targetAnchor.getOwner().translateToRelative(targetRefPoint);
		PointList newPointList = editPart.getConnectionFigure().getPoints().getCopy();
		SetConnectionBendpointsCommand setConnectionBendpointsCommand = getSetConnectionBendpointsCommand(createConnectionRequest);
		if (setConnectionBendpointsCommand != null) {
			setConnectionBendpointsCommand.setNewPointList(newPointList, sourceRefPoint, targetRefPoint);
		}
	}

	private SetConnectionBendpointsCommand getSetConnectionBendpointsCommand(CreateConnectionRequest createConnectionRequest) {
		ICommandProxy proxy = (ICommandProxy) createConnectionRequest.getStartCommand();
		CompositeCommand cc = (CompositeCommand) proxy.getICommand();
		Iterator iterator = cc.iterator();
		while (iterator.hasNext()) {
			Object next = iterator.next();
			if (next instanceof SetConnectionBendpointsCommand) {
				return (SetConnectionBendpointsCommand) next;
			}
		}
		return null;
	}

}
