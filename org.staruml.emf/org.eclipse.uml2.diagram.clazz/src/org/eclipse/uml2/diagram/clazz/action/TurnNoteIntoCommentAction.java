package org.eclipse.uml2.diagram.clazz.action;

import org.eclipse.uml2.diagram.clazz.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.CommentEditPart;
import org.eclipse.uml2.diagram.clazz.providers.UMLElementTypes;
import org.eclipse.uml2.diagram.common.actions.ConvertCommentCommandBase;
import org.eclipse.uml2.diagram.common.actions.ConvertNoteToCommentAction;

/**
 * @generated
 */

public class TurnNoteIntoCommentAction extends ConvertNoteToCommentAction {

	/**
	 * @generated
	 */
	public TurnNoteIntoCommentAction() {
		super(new ConvertCommentCommandBase.ConfigImpl(CommentEditPart.VISUAL_ID, CommentAnnotatedElementEditPart.VISUAL_ID, UMLElementTypes.CommentAnnotatedElement_4019));
	}
}
