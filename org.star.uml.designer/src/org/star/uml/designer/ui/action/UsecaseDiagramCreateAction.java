package org.star.uml.designer.ui.action;

import java.net.URL;
import java.util.HashMap;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.MetamodelType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.diagram.usecase.edit.commands.ActorCreateCommand;
import org.eclipse.uml2.diagram.usecase.edit.helpers.ActorEditHelper;
import org.eclipse.uml2.diagram.usecase.edit.helpers.UMLBaseEditHelper;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.internal.impl.ActorImpl;
import org.eclipse.uml2.uml.internal.impl.UMLFactoryImpl;
import org.osgi.framework.Bundle;
import org.star.uml.designer.Activator;
import org.star.uml.designer.base.utils.EclipseUtile;
import org.star.uml.designer.ui.factory.StarUMLCommandFactory;
import org.star.uml.designer.ui.factory.StarUMLEditHelperFactory;
import org.star.uml.designer.ui.views.StarPMSModelView;
import org.star.uml.designer.ui.views.StarPMSModelView.TreeParent;

public class UsecaseDiagramCreateAction implements IViewActionDelegate {
	public final String ACTION_ID = "UsecaseDiagram";
	public final String ACTION_URI = "org.eclipse.uml2.diagram.usecase.UsecaseDiagram";
	public final String ACTION_TITLE ="Create UsecaseDiagram";
	public final String ICON_PATH = "/icons/login.gif";
	public IViewPart view = null;
	
	@Override
	public void init(IViewPart view) {
		this.view = view;
	}
	@Override
	public void run(IAction action) {
		action.setText(ACTION_TITLE);
		action.setImageDescriptor(getImageDescriptor());
		
		String fileName = "default"+EclipseUtile.getDefaultUMLIdx()+".umlusc";
		URI diagramURI = URI.createDeviceURI("platform:/resource/Root/"+fileName);
		URI modelURI = URI.createDeviceURI("platform:/resource/Root/default.uml");
		EclipseUtile.createDiagram("Root",diagramURI,modelURI,ACTION_ID);
		try{
		IViewPart view_part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView("org.star.uml.designer.ui.views.StarPMSModelView");
		StarPMSModelView modelView = (StarPMSModelView)view_part;
//		StarPMSModelView modelView = (StarPMSModelView)view;
		System.out.println("1 : "+modelView.viewer.getSelection());
		TreeSelection treeSelection = (TreeSelection)modelView.viewer.getSelection();
		TreeParent parent = (TreeParent)treeSelection.getFirstElement();
		String parentPath = (String)parent.getData("path");
		HashMap map = new HashMap();
		map.put("path",parent.toString()+"/diagram");
		parent.appendChield(parent, fileName, map);
		modelView.addChildXml("packagedElement",parent.getData("key").toString(),fileName);
		}catch(Exception e){e.printStackTrace();}
	}
	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		
	}
	
	public URL getImageURL(){
		Bundle bundle = Platform.getBundle(Activator.PLUGIN_ID);
		return bundle.getEntry(ICON_PATH);
	}
	
	public ImageDescriptor getImageDescriptor(){
		return Activator.getImageDescriptor(ICON_PATH);
	}
	
	
}
