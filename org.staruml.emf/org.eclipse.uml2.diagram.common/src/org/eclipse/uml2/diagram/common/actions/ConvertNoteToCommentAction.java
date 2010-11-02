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
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.DescriptionStyle;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.common.Messages;
import org.eclipse.uml2.diagram.common.actions.ConvertCommentCommandBase.Config;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Element;

public class ConvertNoteToCommentAction extends UMLDiagramAction {

	private final Config myConfig;

	public ConvertNoteToCommentAction(Config config) {
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

		ConvertNoteToCommentCommand result = new ConvertNoteToCommentCommand(domain, (Node) editPart.getNotationView(), parentEP.getNotationView(), preferencesHint, myConfig);
		return new ICommandProxy(result);
	}

	private static class ConvertNoteToCommentCommand extends ConvertCommentCommandBase {

		private final Node myToConvert;

		private final View myParent;

		private final PreferencesHint myPreferenceHint;

		private final Config myConfig;

		private List<Edge> myAnnotatedElements;

		public ConvertNoteToCommentCommand(TransactionalEditingDomain domain, Node toConvert, View parent, PreferencesHint preferenceHint, Config config) {
			super(domain, Messages.ConvertNoteToCommentAction_command_convert_note_into_comment, getWorkspaceFiles(toConvert));
			myToConvert = toConvert;
			myParent = parent;
			myPreferenceHint = preferenceHint;
			myConfig = config;
		}

		private List<Edge> getNoteAttachments() {
			if (myAnnotatedElements == null) {
				myAnnotatedElements = new LinkedList<Edge>();
				for (Object next : myToConvert.getSourceEdges()) {
					Edge nextEdge = (Edge) next;
					if (myConfig.getNoteAttachmentVisualID().equals(nextEdge.getType())) {
						myAnnotatedElements.add(nextEdge);
					}
				}
				for (Object next : myToConvert.getTargetEdges()) {
					Edge nextEdge = (Edge) next;
					if (myConfig.getNoteAttachmentVisualID().equals(nextEdge.getType())) {
						myAnnotatedElements.add(nextEdge);
					}
				}
			}
			return myAnnotatedElements;

		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			Element semanticParent = (Element) myParent.getElement();
			Comment comment = createSemanticComment(semanticParent);
			Node commentNode = createCommentView(comment);
			for (Edge next : getNoteAttachments()) {
				createUMLLink(next, commentNode);
			}
			destroyNoteAndItsLinks();
			return CommandResult.newOKCommandResult();
		}

		private void destroyNoteAndItsLinks() {
//			for (Edge next : getNoteAttachments()) {
//				ViewUtil.destroy(next);
//			}
			ViewUtil.destroy(myToConvert);
		}

		private Comment createSemanticComment(Element semanticParent) {
			Comment comment = semanticParent.createOwnedComment();
			setName(myToConvert, comment);
			List<Element> annotated = new LinkedList<Element>();
			for (Edge noteLink : getNoteAttachments()) {
				View target = noteLink.getSource() == myToConvert ? noteLink.getTarget() : noteLink.getSource();
				if (target.getElement() instanceof Element) {
					annotated.add((Element) target.getElement());
				}
			}
			comment.getAnnotatedElements().addAll(annotated);
			return comment;
		}

		private Node createCommentView(Comment c) {
			String semanticHint = String.valueOf(myConfig.getCommentVisualID());
			Node commentView = ViewService.getInstance().createNode(new EObjectAdapter(c), myParent, semanticHint, ViewUtil.APPEND, false, myPreferenceHint);
			migrateNode(myToConvert, commentView);
			return commentView;
		}

		private Edge createUMLLink(Edge noteLink, View commentNode) {
			View target = noteLink.getSource() == myToConvert ? noteLink.getTarget() : noteLink.getSource();
			if (false == target.getElement() instanceof Element) {
				return null;
			}
			String linkHint = String.valueOf(myConfig.getAnnotatedElementVisualID());
			IAdaptable elementTypeAdapter = new IAdaptable() {

				@SuppressWarnings("unchecked")
				public Object getAdapter(Class adapter) {
					if (IElementType.class.equals(adapter)) {
						return myConfig.getAnnotatedElementElementType();
					}
					return null;
				}
			};
			Edge result = (Edge) ViewService.getInstance().createEdge(elementTypeAdapter, myToConvert.getDiagram(), linkHint, ViewUtil.APPEND, myPreferenceHint);
			if (result != null) {
				result.setSource(commentNode);
				result.setTarget(target);
				migrateLink(noteLink, result);
			}
			return result;

		}
		
		private void setName(View oldNote, Comment newComment) {
			DescriptionStyle style = (DescriptionStyle) oldNote.getStyle(NotationPackage.eINSTANCE.getDescriptionStyle());
			if (style != null) {
				String description = style.getDescription();
				if (description != null && description.length() > 0) {
					newComment.setBody(description);
				}
			}
		}

		@Override
		public boolean canExecute() {
			return (myParent.getElement() instanceof Element);
		}

	}

}
