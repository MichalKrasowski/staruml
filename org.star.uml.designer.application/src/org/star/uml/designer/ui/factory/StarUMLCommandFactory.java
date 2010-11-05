package org.star.uml.designer.ui.factory;

import java.net.URL;

import org.eclipse.emf.common.command.AbstractCommand;
import org.star.uml.designer.command.MoveShapeCommand;
import org.star.uml.designer.ui.diagram.action.ActorInsertAction;

public class StarUMLCommandFactory {
	
	public static AbstractCommand getCommand(String actionID){
		
		if(actionID.equals(MoveShapeCommand.ID)){
			return new MoveShapeCommand();
		}
		return null;
	}
}
