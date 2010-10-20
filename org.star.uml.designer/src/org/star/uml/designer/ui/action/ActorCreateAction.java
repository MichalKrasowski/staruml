package org.star.uml.designer.ui.action;

import java.net.URL;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.MetamodelType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.Action;
import org.eclipse.uml2.diagram.usecase.edit.commands.ActorCreateCommand;
import org.eclipse.uml2.diagram.usecase.edit.helpers.ActorEditHelper;
import org.eclipse.uml2.diagram.usecase.edit.helpers.UMLBaseEditHelper;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.internal.impl.ActorImpl;
import org.eclipse.uml2.uml.internal.impl.UMLFactoryImpl;
import org.osgi.framework.Bundle;
import org.star.uml.designer.base.utils.EclipseUtile;
import org.star.uml.designer.ui.factory.StarUMLCommandFactory;
import org.star.uml.designer.ui.factory.StarUMLEditHelperFactory;
import org.star.uml.designer.ui.factory.StarUMLImageFactory;

public class ActorCreateAction extends Action {
	public final String Action_ID = "Actor";
	public final String Action_URI = "org.eclipse.uml2.diagram.usecase.Actor_2002";
	public final String Action_Title ="Create Actor";
	
	public TransactionalEditingDomain domain = null;
	public DiagramDocumentEditor editor = null;
	public View view = null;
	
	public ActorCreateAction(DiagramDocumentEditor editor){
		this.editor = editor;
		this.domain = editor.getEditingDomain();
		this.view = (View)editor.getDiagramEditPart().getModel();
		this.setText(Action_Title);
	}
	
	@Override
	public void run() {
		super.run();
		URL fileURL = StarUMLImageFactory.getImageURL(Action_ID); 
		UMLBaseEditHelper helper = StarUMLEditHelperFactory.getEditHelper(Action_ID);
    	MetamodelType modelType = new MetamodelType(Action_URI,fileURL, Action_ID,null,helper);
    	
    	CreateElementRequest request = new CreateElementRequest(domain,view, modelType);
    	EObject eObj = createNode();
    	request.setNewElement(eObj);
    	request.setLabel(Action_ID);
    	
    	AbstractTransactionalCommand actorCmd = StarUMLCommandFactory.getCommand(request);
    	EObjectAdapter info = new EObjectAdapter(eObj);
    	EclipseUtile.runCommand(actorCmd, info);
	}
	
	public EObject createNode(){
		UMLFactory factoryImple = UMLFactoryImpl.init();
		final ActorImpl actor = (ActorImpl)factoryImple.createActor();
		actor.setName("Park Yong Cheon");
		return actor;
	}
}
