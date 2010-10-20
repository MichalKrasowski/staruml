package org.star.uml.designer.ui.factory;

import java.net.URL;

import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.jface.action.Action;
import org.eclipse.uml2.diagram.usecase.edit.commands.ActorCreateCommand;
import org.eclipse.uml2.diagram.usecase.edit.helpers.ActorEditHelper;
import org.eclipse.uml2.uml.internal.impl.ActorImpl;

public class StarUMLCommandFactory {
	
	public static AbstractTransactionalCommand getCommand(CreateElementRequest request){
		
		if(request.getNewElement() instanceof ActorImpl){
			return new ActorCreateCommand(request);
		}
		return null;
	}
}
