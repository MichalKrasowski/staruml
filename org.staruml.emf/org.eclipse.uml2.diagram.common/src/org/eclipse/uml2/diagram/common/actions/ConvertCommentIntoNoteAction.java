/*
 * Copyright (c) 2008 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Tatiana Fesenko (Borland) - initial API and implementation
 *    Michael Golubev (Borland) - initial API and implementation
 */
package org.eclipse.uml2.diagram.common.actions;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.DescriptionStyle;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.common.Messages;
import org.eclipse.uml2.diagram.common.actions.ConvertCommentCommandBase.Config;
import org.eclipse.uml2.uml.Comment;

public class ConvertCommentIntoNoteAction extends UMLDiagramAction {

	private final Config myConfig;

	public ConvertCommentIntoNoteAction(Config config) {
		myConfig = config;
	}

	@Override
	protected Command getCommand(IGraphicalEditPart editPart) {
		final IGraphicalEditPart parentEP = (IGraphicalEditPart) editPart.getParent();
		// select
		if (editPart == null) {
			return UnexecutableCommand.INSTANCE;
		}
		PreferencesHint preferencesHint = editPart.getDiagramPreferencesHint();
		TransactionalEditingDomain domain = editPart.getEditingDomain();

		Node commentNode = (Node) editPart.getNotationView();
		CompositeTransactionalCommand result = new CompositeTransactionalCommand(editPart.getEditingDomain(), Messages.ConvertCommentIntoNoteAction_command_convert_comment_into_note);
		CreateNoteCommand createNote = new CreateNoteCommand(domain, commentNode, parentEP.getNotationView(), preferencesHint, myConfig);
		result.compose(createNote);
		DeleteCommand deleteView = new DeleteCommand(commentNode);
		result.compose(deleteView);
		DestroyElementCommand destroyComment = new DestroyElementCommand(new DestroyElementRequest(commentNode.getElement(), false));
		result.compose(destroyComment);
		return new ICommandProxy(result);
	}

	private static class CreateNoteCommand extends ConvertCommentCommandBase {

		private final Node myToConvert;

		private final View myParent;

		private final PreferencesHint myPreferenceHint;

		private final Config myConfig;

		public CreateNoteCommand(TransactionalEditingDomain domain, Node toConvert, View parent, PreferencesHint preferenceHint, Config config) {
			super(domain, Messages.ConvertCommentIntoNoteAction_command_create_note, getWorkspaceFiles(toConvert));
			myToConvert = toConvert;
			myParent = parent;
			myPreferenceHint = preferenceHint;
			myConfig = config;
		}
		
		@Override
		public boolean canExecute() {
			return super.canExecute();
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			Node newNote = createNote();
			replaceAllLinks(newNote);
			return CommandResult.newOKCommandResult();
		}
		
		private Node createNote() {
			Node newNote = ViewService.createNode(myParent, myConfig.getNoteVisualId(), myPreferenceHint);
			migrateNode(myToConvert, newNote);
			setName(myToConvert, newNote);
			return newNote;
		}
		
		private void replaceAllLinks(Node newNote) {
			for (Edge next: getAnnotatedElementLinks()) {
				Edge created = ViewService.createEdge(newNote, next.getTarget(), myConfig.getNoteAttachmentVisualID(), myPreferenceHint);
				migrateLink(next, created);
			}
		}
		
		private List<Edge> getAnnotatedElementLinks() {
			List<Edge> result = new LinkedList<Edge>();
			for (Object next: myToConvert.getSourceEdges()) {
				Edge nextEdge = (Edge)next;
				if (String.valueOf(myConfig.getAnnotatedElementVisualID()).equals(nextEdge.getType())) {
					result.add(nextEdge);
				}
			}
			return result;
		}
		
		private void setName(View oldView, Node newView) {
			String description = ((Comment)oldView.getElement()).getBody();
			DescriptionStyle style = (DescriptionStyle) newView.getStyle(NotationPackage.eINSTANCE.getDescriptionStyle());
			if (style == null) {
				style = (DescriptionStyle) newView.createStyle(NotationPackage.eINSTANCE.getDescriptionStyle());
			}
			style.setDescription(description);
		}
		
	}

}
