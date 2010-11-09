package org.star.uml.designer.ui.diagram.action;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramCommandStack;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDiagramDocument;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.MetamodelType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.impl.DiagramImpl;
import org.eclipse.gmf.runtime.notation.impl.ShapeImpl;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.diagram.common.async.ApplySynchronizationCommand;
import org.eclipse.uml2.diagram.common.async.AsyncDiagramDeleteRequest;
import org.eclipse.uml2.diagram.common.async.SyncModelContext;
import org.eclipse.uml2.diagram.common.async.SyncModelNode;
import org.eclipse.uml2.diagram.usecase.edit.helpers.UMLBaseEditHelper;
import org.eclipse.uml2.diagram.usecase.edit.parts.ActorEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.PackageEditPart;
import org.eclipse.uml2.diagram.usecase.navigator.UMLNavigatorItem;
import org.eclipse.uml2.diagram.usecase.part.UMLDiagramUpdater;
import org.eclipse.uml2.diagram.usecase.part.UMLVisualIDRegistry;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.VisibilityKind;
import org.eclipse.uml2.uml.internal.impl.ActorImpl;
import org.eclipse.uml2.uml.internal.impl.BehavioredClassifierImpl;
import org.eclipse.uml2.uml.internal.impl.PackageImpl;
import org.eclipse.uml2.uml.internal.impl.UMLFactoryImpl;
import org.osgi.framework.Bundle;
import org.star.uml.designer.application.Activator;
import org.star.uml.designer.base.constance.GlobalConstants;
import org.star.uml.designer.base.utils.CommonUtil;
import org.star.uml.designer.base.utils.EclipseUtile;
import org.star.uml.designer.base.utils.XmlUtil;
import org.star.uml.designer.command.MoveShapeCommand;
import org.star.uml.designer.service.dao.PmsDao;
import org.star.uml.designer.ui.diagram.action.interfaces.IStarUMLModelAction;
import org.star.uml.designer.ui.factory.StarUMLCommandFactory;
import org.star.uml.designer.ui.factory.StarUMLEditHelperFactory;
import org.star.uml.designer.ui.views.StarPMSModelView;
import org.star.uml.designer.ui.views.StarPMSModelViewUtil;
import org.star.uml.designer.ui.views.StarPMSModelView.TreeObject;
import org.star.uml.designer.ui.views.StarPMSModelView.TreeParent;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DeleteDiagramAction extends Action implements IStarUMLModelAction{
	public static final String ACTION_ID = "DELETE DIATRAM";
	public static final String ACTION_URI = "";
	public static final String ACTION_TITLE ="Delete diagram";
	public static final String ACTION_TYPE ="";
	public static final String ICON_PATH = "/icons/logout.gif";
	
	private String selectedNodeName = "";
	private DiagramDocumentEditor editor = null;
	
	public DeleteDiagramAction() {  
		super();
		this.setText(ACTION_TITLE);     
		this.setImageDescriptor(getImageDescriptor());
	}
	
	@Override
	public void run() {
		IViewPart view_part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
												.findView(GlobalConstants.PluinID.STAR_PMS_MODEL_VIEW);
		StarPMSModelView modelView = (StarPMSModelView)view_part;
		// 선택된 Tree를 가져온다.
		TreeSelection treeSelection = (TreeSelection)modelView.getTreeViewer().getSelection();
		TreeObject parent = null;
		String folderPaht = null;
		try{
			parent = (TreeObject)treeSelection.getFirstElement();
			folderPaht = ResourcesPlugin.getWorkspace().getRoot().getProject("Root").getLocation().toString();
			File diagram = new File(folderPaht + "/" + parent.getData(GlobalConstants.StarMoedl.STAR_MODEL_FILE) + "." + parent.getData(GlobalConstants.StarMoedl.STAR_MODEL_EXTENSION));
			IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			IProgressMonitor monitor = new NullProgressMonitor();
			monitor.beginTask("Save content...", 1);
			if(page.getActiveEditor() != null){
				page.getActiveEditor().doSave(monitor);
			}
			if(diagram.isFile()){
				diagram.delete();
			}
			
			PmsDao pd = new PmsDao();
			if(parent.getData(GlobalConstants.StarMoedl.STAR_MODEL_EXTENSION).toString().equals(GlobalConstants.StarMoedl.STAR_EXTENSION_SEQUENCE_DIAGRAM)){
				pd.sequenceDelete(parent.getData(GlobalConstants.StarMoedl.STAR_MODEL_USECASE_SEQ).toString());
			}else if(parent.getData(GlobalConstants.StarMoedl.STAR_MODEL_EXTENSION).toString().equals(GlobalConstants.StarMoedl.STAR_EXTENSION_CLASS_DIAGRAM)){
				pd.clazzDelete(parent.getData(GlobalConstants.StarMoedl.STAR_MODEL_USECASE_SEQ).toString());
			}
		}catch(Exception e){e.printStackTrace();}
		selectedNodeName = (String)parent.getData(GlobalConstants.StarMoedl.STAR_MODEL_FILE);
		String modelPath = folderPaht+File.separator+GlobalConstants.DEFAULT_VIEW_MODEL_FILE;
		String domStr = null;
		Document modelDoc = null;
		try {
			domStr = XmlUtil.getXmlFileToString(modelPath);
			modelDoc = XmlUtil.getStringToDocument(domStr);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		NodeList nodes = modelDoc.getElementsByTagName("packagedElement");
		for(int i = 0; i < nodes.getLength(); i++){
			NamedNodeMap attMap = nodes.item(i).getAttributes();
			for(int a = 0; a < attMap.getLength(); a++){
				if(attMap.item(a).getNodeName().equals(GlobalConstants.StarMoedl.STAR_MODEL_ID) 
						&& attMap.item(a).getNodeValue().equals(parent.getData(GlobalConstants.StarMoedl.STAR_MODEL_ID))){
					nodes.item(i).getParentNode().removeChild(nodes.item(i));
				}
			}
		}
		try {
			XmlUtil.writeXmlFile(modelDoc, modelPath);
		} catch (Exception e) {
			e.printStackTrace();
		}
		parent.getParent().removeChild(parent);
		modelView.getTreeViewer().refresh();
		EclipseUtile.refreshProject("Root");
		
	}
	
	public URL getImageURL(){
		Bundle bundle = Platform.getBundle(Activator.PLUGIN_ID);
		return bundle.getEntry(ICON_PATH);
	}
	
	public ImageDescriptor getImageDescriptor(){
		return Activator.getImageDescriptor(ICON_PATH);
	}
}
