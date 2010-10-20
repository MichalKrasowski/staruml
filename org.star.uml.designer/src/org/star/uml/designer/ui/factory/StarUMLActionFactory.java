package org.star.uml.designer.ui.factory;

import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IViewActionDelegate;
import org.star.uml.designer.Activator;
import org.star.uml.designer.ui.action.ActorCreateAction;

public class StarUMLActionFactory {
	
	public static IViewActionDelegate getAction(DiagramDocumentEditor editor , String actionID){
		if(actionID.equals("Actor")){
			return new ActorCreateAction(editor);
		}
		return null;
	}
}
