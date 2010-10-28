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
public class VisibleShapeCommand extends AbstractCommand{
	
	public static final String ID="org.star.uml.designer.command.VisibleShapeCommand";
	
	private ShapeImpl shapeImple;
	
	public VisibleShapeCommand() {
		this.setLabel("Insert Shape");
	}
	
	@Override
	public void execute() {
		if(shapeImple.isVisible()){
			shapeImple.setVisible(false);
		}else{
			shapeImple.setVisible(true);
		}
	}

	@Override
	public void redo() {
		if(shapeImple.isVisible()){
			shapeImple.setVisible(true);
		}else{
			shapeImple.setVisible(false);
		}
	}
	
	@Override
	public void undo() {
		if(shapeImple.isVisible()){
			shapeImple.setVisible(false);
		}else{
			shapeImple.setVisible(true);
		}
	}
	
	@Override
	public boolean canExecute() {
		return true;
	}
	
	
	public void setShapeImpl(ShapeImpl shapeImple){
		this.shapeImple = shapeImple;
	}
	
}
