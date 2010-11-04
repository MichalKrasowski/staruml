package org.star.uml.designer.ui.action;

import java.net.URL;
import java.util.HashMap;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDiagramDocument;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.MetamodelType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.impl.DiagramImpl;
import org.eclipse.gmf.runtime.notation.impl.ShapeImpl;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.diagram.usecase.edit.helpers.UMLBaseEditHelper;
import org.eclipse.uml2.diagram.usecase.navigator.UMLNavigatorItem;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.VisibilityKind;
import org.eclipse.uml2.uml.internal.impl.ActorImpl;
import org.eclipse.uml2.uml.internal.impl.PackageImpl;
import org.eclipse.uml2.uml.internal.impl.UMLFactoryImpl;
import org.osgi.framework.Bundle;
import org.star.uml.designer.Activator;
import org.star.uml.designer.base.constance.GlobalConstants;
import org.star.uml.designer.base.utils.CommonUtil;
import org.star.uml.designer.base.utils.EclipseUtile;
import org.star.uml.designer.ui.diagram.action.interfaces.IStarUMLModelAction;
import org.star.uml.designer.ui.factory.StarUMLCommandFactory;
import org.star.uml.designer.ui.factory.StarUMLEditHelperFactory;
import org.star.uml.designer.ui.views.StarPMSBrowersView;
import org.star.uml.designer.ui.views.StarPMSModelView;
import org.star.uml.designer.ui.views.StarPMSModelViewUtil;
import org.star.uml.designer.ui.views.StarPMSModelView.TreeObject;
import org.star.uml.designer.ui.views.StarPMSModelView.TreeParent;

public class ViewReportAction extends Action{
	public static final String ACTION_ID = "VIEW_REPORT";
	public static final String ACTION_URI = "org.star.uml.designer.ui.action.ViewReportAction";
	public static final String ACTION_TITLE ="View Report";
	public static final String ICON_PATH = "/icons/login.gif";
	
	public TransactionalEditingDomain domain = null;
	public DiagramDocumentEditor editor = null;
	public View view = null;
	
	public ViewReportAction() {
		super();
		this.setText(ACTION_TITLE);
		this.setImageDescriptor(getImageDescriptor());
	}
	
	@Override
	public void run() {
		System.out.println("ViewReportAction Start~~!!!");
		IViewPart model_view_part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView("org.star.uml.designer.ui.views.StarPMSModelView");
		StarPMSModelView modelView = (StarPMSModelView)model_view_part;
		TreeSelection treeSelection = (TreeSelection)modelView.getTreeViewer().getSelection();
    	TreeObject chield = (TreeObject)treeSelection.getFirstElement();
    	String  req_usecase_seq = (String)chield.getData("parentSeq");
		IViewPart view_part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView("org.star.uml.designer.ui.views.StarPMSBrowersView");
        StarPMSBrowersView brower = (StarPMSBrowersView)view_part;
        String url = "http://192.168.10.193:8080/starPMS/processMgt/viewUseCaseReportSimple.do?usecaseSeq=";
        brower.setURL(url+req_usecase_seq);
        try {
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView("org.star.uml.designer.ui.views.StarPMSBrowersView");
		} catch (PartInitException e) {
			e.printStackTrace();
		}
	}
	
//	public EObject createNode(){
//		UMLFactory factoryImple = UMLFactoryImpl.init();
//		final ActorImpl actor = (ActorImpl)factoryImple.createActor();
//		actor.setName(nodeName);
//		return actor;
//	}

	public URL getImageURL(){
		Bundle bundle = Platform.getBundle(Activator.PLUGIN_ID);
		return bundle.getEntry(ICON_PATH);
	}
	
	public ImageDescriptor getImageDescriptor(){
		return Activator.getImageDescriptor(ICON_PATH);
	}

}
