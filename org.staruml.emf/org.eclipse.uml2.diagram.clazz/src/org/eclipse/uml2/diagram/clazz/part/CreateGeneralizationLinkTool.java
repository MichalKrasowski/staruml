package org.eclipse.uml2.diagram.clazz.part;

import java.util.Arrays;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest.ConnectionViewDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest.ViewAndElementDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.clazz.edit.helpers.GeneralizationSetEditHelper;
import org.eclipse.uml2.diagram.clazz.edit.parts.Generalization2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.GeneralizationEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.GeneralizationGeneralEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.GeneralizationSetEditPart;
import org.eclipse.uml2.diagram.clazz.providers.UMLElementTypes;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.UMLPackage;

public class CreateGeneralizationLinkTool extends UnspecifiedTypeConnectionTool {

	public CreateGeneralizationLinkTool() {
		super(GENERALISATION_TYPES);
	}

	@Override
	protected Command getCommand() {
		if (getTargetEditPart() == null) {
			return null;
		}
		if (getTargetEditPart() instanceof GeneralizationEditPart) {
			return getCreateSetAndThenGeneralizationCommand();
		}
		if (getTargetEditPart() instanceof Generalization2EditPart) {
			Generalization2EditPart generalization2EditPart = (Generalization2EditPart) getTargetEditPart();
			EditPart generalizationSetEditPart = generalization2EditPart.getTarget();
			return generalizationSetEditPart.getCommand(getTargetRequest());
		}
		if (getTargetEditPart() instanceof GeneralizationGeneralEditPart) {
			GeneralizationGeneralEditPart generalizationGeneralEditPart = (GeneralizationGeneralEditPart) getTargetEditPart();
			EditPart generalizationSetEditPart = generalizationGeneralEditPart.getSource();
			return generalizationSetEditPart.getCommand(getTargetRequest());
		}
		return super.getCommand();
	}

	private Command getCreateSetAndThenGeneralizationCommand() {
		GeneralizationEditPart generalizationEditPart = (GeneralizationEditPart) getTargetEditPart();
		GraphicalEditPart packageEditPart = (GraphicalEditPart) generalizationEditPart.getRoot().getContents();

		View generalizationView = generalizationEditPart.getNotationView();
		Generalization generalization = (Generalization) generalizationView.getElement();
		View container = packageEditPart.getNotationView();

		CreateViewAndElementRequest createGeneralizationSetRequest = getCreateGeneralizationSetRequest(container, generalizationView);
		Command createGeneralizationSetCommand = packageEditPart.getCommand(createGeneralizationSetRequest);

		final ViewAndElementDescriptor created = getCreatedElement(createGeneralizationSetRequest);

		if (created == null) {
			return UnexecutableCommand.INSTANCE;
		}

		EditPart generalizationSource = generalizationEditPart.getSource();
		EditPart generalizationTarget = generalizationEditPart.getTarget();
		
		CompoundCommand result = new CompoundCommand();
		result.add(createGeneralizationSetCommand);
		result.add(getDeleteViewCommand(generalizationEditPart));

		result.add(getCreateGeneralizationCommand(packageEditPart, created));

		// restore existing generalization EditPart
		result.add(getCompleteCreateGeneralizationCommand(generalization, packageEditPart, generalizationSource, created));
//		result.add(getCreateGeneralizationGeneralCommand(packageEditPart, created, generalizationTarget));
		return result;
	}

	private ViewAndElementDescriptor getCreatedElement(CreateViewAndElementRequest createGeneralizationSetRequest) {
		List newObject = (List) createGeneralizationSetRequest.getNewObject();
		return (ViewAndElementDescriptor) ((List) newObject).get(0);
	}	


	private Command getCreateGeneralizationGeneralCommand(GraphicalEditPart packageEditPart, final ViewAndElementDescriptor created, final EditPart targetEditPart) {
		AbstractTransactionalCommand createGeneralizationGeneral = new AbstractTransactionalCommand(packageEditPart.getEditingDomain(), CustomMessages.CreateGeneralizationLinkTool_change_generalization_notation_command, null) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				View view = (View) created.getAdapter(View.class);
				EditPart sourceEditPart = (EditPart) getCurrentViewer().getEditPartRegistry().get(view);
				CreateConnectionRequest connectionRequest = getCreateConnectionViewRequest(UMLElementTypes.GeneralizationGeneral_4012, String.valueOf(GeneralizationGeneralEditPart.VISUAL_ID));
				createConnection(sourceEditPart, targetEditPart, connectionRequest);
				return CommandResult.newOKCommandResult();
			}
		};
		return new ICommandProxy(createGeneralizationGeneral);
	}
	
	private Command getCompleteCreateGeneralizationCommand(final EObject element, GraphicalEditPart packageEditPart, final EditPart sourceEditPart, final ViewAndElementDescriptor created) {
		AbstractTransactionalCommand createGeneralization = new AbstractTransactionalCommand(packageEditPart.getEditingDomain(), CustomMessages.CreateGeneralizationLinkTool_change_generalization_notation_command_2, null) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				View view = (View) created.getAdapter(View.class);
				EditPart targetEditPart = (EditPart) getCurrentViewer().getEditPartRegistry().get(view);
				CreateConnectionRequest connectionRequest = getCreateConnectionWithClassViewRequest(element, String.valueOf(Generalization2EditPart.VISUAL_ID));
				
				createConnection(sourceEditPart, targetEditPart, connectionRequest);

				return CommandResult.newOKCommandResult();
			}
		};
		return new ICommandProxy(createGeneralization);
	}
	
	private CreateConnectionRequest getCreateConnectionViewRequest(final IElementType elementType, String hint) {
		IAdaptable semanticAdapter = new IAdaptable() {

			public Object getAdapter(Class adapter) {
				if (IElementType.class.equals(adapter)) {
					return elementType;
				}
				return null;
			}
		};

		ConnectionViewDescriptor viewDescriptor = new ConnectionViewDescriptor(semanticAdapter, hint, getPreferencesHint());
		return new CreateConnectionViewRequest(viewDescriptor);
	}

	private CreateConnectionRequest getCreateConnectionWithClassViewRequest(EObject element, String hint) {
		ConnectionViewDescriptor viewDescriptor = new ConnectionViewDescriptor(new EObjectAdapter(element), hint, getPreferencesHint());
		return new CreateConnectionViewRequest(viewDescriptor);
	}
	
	private void createConnection(EditPart sourceEditPart, EditPart targetEditPart, CreateConnectionRequest connectionRequest) {
		connectionRequest.setTargetEditPart(sourceEditPart);
		connectionRequest.setType(RequestConstants.REQ_CONNECTION_START);
		connectionRequest.setLocation(new Point(0, 0));

		if (sourceEditPart.getCommand(connectionRequest) == null) {
			return;
		}

		connectionRequest.setSourceEditPart(sourceEditPart);
		connectionRequest.setTargetEditPart(targetEditPart);
		connectionRequest.setType(RequestConstants.REQ_CONNECTION_END);
		connectionRequest.setLocation(new Point(0, 0));

		Command createConnectionCmd = targetEditPart.getCommand(connectionRequest);
		if (createConnectionCmd.canExecute()) {
			createConnectionCmd.execute();
		}
	}

	private Command getCreateGeneralizationCommand(GraphicalEditPart packageEditPart, final ViewAndElementDescriptor created) {
		AbstractTransactionalCommand createGeneralization = new AbstractTransactionalCommand(packageEditPart.getEditingDomain(), CustomMessages.CreateGeneralizationLinkTool_change_generalization_notation_command_3, null) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				View view = (View) created.getAdapter(View.class);
				EditPart editPart = (EditPart) getCurrentViewer().getEditPartRegistry().get(view);

				Command createConnectionCmd = editPart.getCommand(getTargetRequest());
				if (createConnectionCmd.canExecute()) {
					createConnectionCmd.execute();
				}
				return CommandResult.newOKCommandResult();
			}
		};
		return new ICommandProxy(createGeneralization);
	}

	private CreateViewAndElementRequest getCreateGeneralizationSetRequest(View container, View generalization) {
		CreateElementRequest createElementRequest = new CreateElementRequest(container.getElement(), UMLElementTypes.GeneralizationSet_2012, UMLPackage.eINSTANCE.getPackage_PackagedElement());
		ViewAndElementDescriptor descriptor = new ViewAndElementDescriptor(new CreateElementRequestAdapter(createElementRequest), Node.class, Integer.toString(GeneralizationSetEditPart.VISUAL_ID),
				getPreferencesHint());
		CreateViewAndElementRequest createGeneralizationSetRequest = new CreateViewAndElementRequest(descriptor);
		createGeneralizationSetRequest.getExtendedData().put(GeneralizationSetEditHelper.PARAMETER_SET_GENERALIZATION, generalization.getElement());
		createGeneralizationSetRequest.setLocation(getLocation());
		return createGeneralizationSetRequest;
	}

	private Command getDeleteViewCommand(GeneralizationEditPart editPart) {
		View view = editPart.getNotationView();
		return new ICommandProxy(new DeleteCommand(view));
	}

	private static List<IElementType> GENERALISATION_TYPES = Arrays.asList(new IElementType[] { UMLElementTypes.Generalization_4001, UMLElementTypes.Generalization_4011, });

}
