package org.star.uml.designer.ui.factory;

import java.net.URL;

import org.eclipse.emf.common.command.AbstractCommand;
import org.star.uml.designer.command.InsertActorCommand;
import org.star.uml.designer.ui.diagram.action.ActorInsertAction;

public class StarUMLCommandFactory {
	
	public static AbstractCommand getCommand(String actionID){
		
		if(actionID.equals(ActorInsertAction.ACTION_ID)){
			return new InsertActorCommand();
		}
		return null;
	}
}
