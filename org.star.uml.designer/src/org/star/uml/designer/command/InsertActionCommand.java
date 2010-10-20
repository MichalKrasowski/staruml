package org.star.uml.designer.command;

import java.net.URL;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.command.OverrideableCommand;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramEditDomain;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IMetamodelTypeDescriptor;
import org.eclipse.gmf.runtime.emf.type.core.MetamodelType;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelper;
import org.eclipse.gmf.runtime.emf.type.core.internal.descriptors.MetamodelDescriptor;
import org.eclipse.gmf.runtime.emf.type.core.internal.descriptors.MetamodelTypeDescriptor;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.diagram.usecase.edit.commands.ActorCreateCommand;
import org.eclipse.uml2.diagram.usecase.edit.helpers.ActorEditHelper;
import org.eclipse.uml2.diagram.usecase.edit.parts.ActorEditPart;
import org.eclipse.uml2.diagram.usecase.part.UMLVisualIDRegistry;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.internal.impl.ActorImpl;
import org.eclipse.uml2.uml.internal.impl.UMLFactoryImpl;
import org.osgi.framework.Bundle;

public class InsertActionCommand extends AbstractTransactionalCommand{
	public TransactionalEditingDomain domain = null;
	public InsertActionCommand(TransactionalEditingDomain domain,String label, List affectedFiles) {
		super(domain, label, affectedFiles);
		this.domain = domain;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor,IAdaptable info) 
																					throws ExecutionException {
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		View view = null;
		if(page.getActiveEditor() !=null && page.getActiveEditor() instanceof org.eclipse.uml2.diagram.usecase.part.UMLDiagramEditor){
        	final org.eclipse.uml2.diagram.usecase.part.UMLDiagramEditor editor = 
        		(org.eclipse.uml2.diagram.usecase.part.UMLDiagramEditor)page.getActiveEditor();
        	UMLFactory factoryImple = UMLFactoryImpl.init();
			final ActorImpl actor = (ActorImpl)factoryImple.createActor();
			actor.setName("Park Yong Cheon");
        	PreferencesHint preferencesHint = new PreferencesHint("2002");
        	view = (View)editor.getDiagramEditPart().getModel();
        	TransactionalEditingDomain editingDomain = editor.getEditingDomain();
        	
//        	view.setElement(actor);
//			Shape node = NotationFactory.eINSTANCE.createShape();
//			node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
//			node.setType(UMLVisualIDRegistry.getType(ActorEditPart.VISUAL_ID));
//			node.setElement(actor);
//        	view.insertChild(node,false);
//        	MetamodelTypeDescriptor descriptor = new MetamodelTypeDescriptor();
        	ActorEditHelper helper = new ActorEditHelper();
        	Bundle bundle = Platform.getBundle("org.star.uml.designer");
        	URL fileURL = bundle.getEntry("icons/16.gif"); 
        	MetamodelType modelType = new MetamodelType("org.eclipse.uml2.diagram.usecase.Actor_2002", 
        												fileURL, "Actor",null, 
        												helper);
        	CreateElementRequest request = new CreateElementRequest(domain,view, modelType);
        	
        	request.setNewElement(actor);
        	request.setLabel("Actor");
        	System.out.println("request.getElementType() : "+request.getElementType());
        	ActorCreateCommand actorCmd = new ActorCreateCommand(request);
        	actorCmd.execute(monitor, new EObjectAdapter(actor));
//        	Node node = ViewService.getInstance().createNode(new EObjectAdapter(actor), view,"2002",-1, preferencesHint);
//        	editor.refresh();
		}
		return CommandResult.newOKCommandResult();
	}
	
}
