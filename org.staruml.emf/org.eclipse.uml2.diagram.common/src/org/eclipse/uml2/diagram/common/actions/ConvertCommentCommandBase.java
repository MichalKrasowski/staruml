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

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.core.util.ViewType;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.Anchor;
import org.eclipse.gmf.runtime.notation.Bendpoints;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.LayoutConstraint;
import org.eclipse.gmf.runtime.notation.Node;


public abstract  class ConvertCommentCommandBase extends AbstractTransactionalCommand {

	public ConvertCommentCommandBase(TransactionalEditingDomain domain, String label, List<?> affectedFiles) {
		super(domain, label, affectedFiles);
	}

	protected void migrateLink(Edge noteLink, Edge result) {
		Bendpoints bendpoints = noteLink.getBendpoints();
		if (bendpoints != null) {
			result.setBendpoints(makeCopy(bendpoints));
		}
		Anchor sourceAnchor = noteLink.getSourceAnchor();
		if (sourceAnchor != null) {
			result.setSourceAnchor(makeCopy(sourceAnchor));
		}
		Anchor targetAnchor = noteLink.getTargetAnchor();
		if (targetAnchor != null) {
			result.setTargetAnchor(makeCopy(targetAnchor));
		}
	}

	protected void migrateNode(Node originalNode, Node convertedNode) {
		LayoutConstraint layoutConstraint = originalNode.getLayoutConstraint();
		if (layoutConstraint != null) {
			convertedNode.setLayoutConstraint(makeCopy(layoutConstraint));
		}
	}
	
	@SuppressWarnings("unchecked")
	private static <T extends EObject> T makeCopy(T original){
		return (T) EcoreUtil.copy(original);
	}

	public static interface Config {
		public int getCommentVisualID();
		public int getAnnotatedElementVisualID();
		public IElementType getAnnotatedElementElementType();
		public String getNoteAttachmentVisualID();
		public String getNoteVisualId();
	}
	
	public static class ConfigImpl implements Config {
		private final int myCommentNodeVID;
		private final IElementType myCommentLinkElementType;
		private final int myCommentLinkVID;

		public ConfigImpl(int commentNodeVID, int commentLinkVID, IElementType commentLinkElementType){
			myCommentNodeVID = commentNodeVID;
			myCommentLinkVID = commentLinkVID;
			myCommentLinkElementType = commentLinkElementType;
		}
		
		public String getNoteAttachmentVisualID() {
			return ViewType.NOTEATTACHMENT;
		}

		public String getNoteVisualId() {
			return ViewType.NOTE;
		}
		
		public IElementType getAnnotatedElementElementType() {
			return myCommentLinkElementType;
		}
		
		public int getCommentVisualID() {
			return myCommentNodeVID;
		}
		
		public int getAnnotatedElementVisualID() {
			return myCommentLinkVID;
		}
	}

}
