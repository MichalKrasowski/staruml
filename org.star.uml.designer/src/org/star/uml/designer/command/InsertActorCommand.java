package org.star.uml.designer.command;

import java.util.Collection;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.impl.ShapeImpl;
import org.eclipse.uml2.uml.internal.impl.ActorImpl;

public class InsertActorCommand extends AbstractCommand{
	
	private ActorImpl actorImpl;
	private ShapeImpl shapeImple;
	
	public InsertActorCommand() {
		this.setLabel("Insert Actor");
	}
	
	@Override
	public void execute() {
		shapeImple.setVisible(true);
	}

	@Override
	public void redo() {
		shapeImple.setVisible(true);
	}
	
	@Override
	public void undo() {
		shapeImple.setVisible(false);
	}
	
	@Override
	public boolean canExecute() {
		return true;
	}
	
	public void setActorImpl(ActorImpl actorImpl){
		this.actorImpl = actorImpl;
	}
	
	public void setShapeImpl(ShapeImpl shapeImple){
		this.shapeImple = shapeImple;
	}

}
