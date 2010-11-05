package org.star.uml.designer.ui.factory;

import org.eclipse.uml2.diagram.usecase.edit.helpers.ActorEditHelper;
import org.eclipse.uml2.diagram.usecase.edit.helpers.UMLBaseEditHelper;


public class StarUMLEditHelperFactory {
	
	public static UMLBaseEditHelper getEditHelper(String actionID){
		if(actionID.equals("Actor")){
			return new ActorEditHelper();
		}
		return null;
	}
}
