package org.star.uml.designer.command;

import java.util.Collection;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.EReferenceImpl;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.impl.ShapeImpl;
import org.eclipse.uml2.uml.internal.impl.ActorImpl;
public class MoveShapeCommand extends AbstractCommand{
	
	public static final String ID="org.star.uml.designer.command.MoveShapeCommand";
	
	private ShapeImpl shapeImple;
	private Location location5002;
	private int new_x;
	private int new_y;
	private int old_x;
	private int old_y;
	
	public MoveShapeCommand() {
		this.setLabel("Insert Actor");
	}
	
	@Override
	public void execute() {
		location5002 = (Location) shapeImple.getLayoutConstraint();
		location5002.setX(new_x);
		location5002.setY(new_y);
	}

	@Override
	public void redo() {
		location5002.setX(new_x);
		location5002.setY(new_y);
	}
	
	@Override
	public void undo() {
//		location5002.setX(old_x);
//		location5002.setY(old_y);
	}
	
	@Override
	public boolean canExecute() {
		return true;
	}
	
	
	public void setShapeImpl(ShapeImpl shapeImple){
		this.shapeImple = shapeImple;
	}
	
	public void setLocation(int x, int y){
		this.new_x=x;
		this.new_y=y;
	}

}
