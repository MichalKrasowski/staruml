package org.eclipse.uml2.diagram.clazz.edit.commands;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest.ConnectionViewDescriptor;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.uml2.diagram.clazz.edit.parts.AssociationEditPart;
import org.eclipse.uml2.uml.Type;

public class CreateAssociationViewCommand extends Command {

	private EditPart mySourceEditPart;

	private EditPart myTargetEditPart;

	private IAdaptable mySemanticAdapter;

	private PreferencesHint myPreferencesHint;

	public CreateAssociationViewCommand(GraphicalEditPart propertyEditPart, Type associationSource, Type associationTarget, CreateRelationshipRequest semanticRequest,
			PreferencesHint preferencesHint) {
		EditPart root = propertyEditPart.getRoot().getContents();
		mySourceEditPart = propertyEditPart.findEditPart(root, associationSource);
		myTargetEditPart = propertyEditPart.findEditPart(root, associationTarget);
		mySemanticAdapter = new CreatedEObjectAdapter(semanticRequest);
		myPreferencesHint = preferencesHint;
	}

	@Override
	public void execute() {
		ConnectionViewDescriptor viewDescriptor = new ConnectionViewDescriptor(mySemanticAdapter, 
				String.valueOf(AssociationEditPart.VISUAL_ID),
				ViewUtil.APPEND, false, myPreferencesHint);
		
		CreateConnectionViewRequest createViewRequest = new CreateConnectionViewRequest(viewDescriptor);
		createViewRequest.setType(RequestConstants.REQ_CONNECTION_START);
		createViewRequest.setTargetEditPart(mySourceEditPart);
		mySourceEditPart.getCommand(createViewRequest);

		createViewRequest.setType(RequestConstants.REQ_CONNECTION_END);
		createViewRequest.setSourceEditPart(mySourceEditPart);
		createViewRequest.setTargetEditPart(myTargetEditPart);
		Command createViewCommand = myTargetEditPart.getCommand(createViewRequest);
		if (createViewCommand.canExecute()) {
			createViewCommand.execute();
		}
	}

	@Override
	public boolean canExecute() {
		if (mySourceEditPart == null || myTargetEditPart == null) {
			// TODO probably handle this situation and create association in
			// semantic model only
			return false;
		}
		// NOTE: When command is beeing constructured association element is not
		// yet created
		return true;
	}
	
	private static class CreatedEObjectAdapter implements IAdaptable {
		private final CreateRelationshipRequest myRequest;

		CreatedEObjectAdapter(CreateRelationshipRequest request) {
			myRequest = request;
		}

		public Object getAdapter(Class adapter) {
			if (adapter.isInstance(getCreatedObject())) {
				return getCreatedObject();
			}
			return null;
		}

		public Object getCreatedObject() {
			return myRequest.getNewElement();
		}
	}

}
