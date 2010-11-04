package org.star.uml.designer.ui.diagram.action;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.ui.render.internal.DiagramUIRenderPlugin;
import org.eclipse.gmf.runtime.diagram.ui.render.internal.DiagramUIRenderStatusCodes;
import org.eclipse.gmf.runtime.diagram.ui.render.internal.l10n.DiagramUIRenderMessages;
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
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
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
import org.star.uml.designer.service.dao.PmsDao;
import org.star.uml.designer.ui.diagram.action.interfaces.IStarUMLModelAction;
import org.star.uml.designer.ui.factory.StarUMLCommandFactory;
import org.star.uml.designer.ui.factory.StarUMLEditHelperFactory;
import org.star.uml.designer.ui.views.StarPMSModelView;
import org.star.uml.designer.ui.views.StarPMSModelViewUtil;
import org.star.uml.designer.ui.views.StarPMSRequestTableView;
import org.star.uml.designer.ui.views.StarPMSModelView.TreeObject;
import org.star.uml.designer.ui.views.StarPMSModelView.TreeParent;

public class ClazzDiagramSaveAction extends Action{
	public static final String ACTION_ID = "CLAZZDIAGRAMSAVE";
	public static final String ACTION_URI = "org.eclipse.uml2.diagram.ClazzDiagramSaveAction";
	public static final String ACTION_TITLE ="Class Diagram Save";
	public static final String ACTION_TYPE ="";
	public static final String ICON_PATH = "/icons/diagram/Actor.gif";
	public Map map;
	
	public TransactionalEditingDomain domain = null;
	public DiagramDocumentEditor editor = null;
	public View view = null;
	
	public ClazzDiagramSaveAction() {
		super();
		this.setText(ACTION_TITLE);
		this.setImageDescriptor(getImageDescriptor());
		
	}
	
	@Override
	public void run() {
		String fileName = (String)map.get("fileName");
		Map inputData = new HashMap();
		final MultiStatus status = new MultiStatus(DiagramUIRenderPlugin
				.getPluginId(), DiagramUIRenderStatusCodes.OK,
				DiagramUIRenderMessages.CopyToImageAction_Label, null);
    	IRunnableWithProgress runnable = EclipseUtile.createImageRunnable(status);
    	try {
    		ProgressMonitorDialog progressMonitorDialog = new ProgressMonitorDialog(
    				Display.getCurrent().getActiveShell());
    		progressMonitorDialog.run(false, true, runnable);
    		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView("org.star.uml.designer.ui.views.StarPMSRequestTableView");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String folderPaht = ResourcesPlugin.getWorkspace().getRoot().getProject("Root").getLocation().toString();
		File img = new File(folderPaht + "/default.png");
		
		IViewPart view_part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView("org.star.uml.designer.ui.views.StarPMSModelView");
		StarPMSModelView modelView = (StarPMSModelView)view_part;
		TreeParent parent = modelView.getTreeParent();
		
		TreeObject[] objects = ((TreeParent)parent.getChildren()[2]).getChildren();
		for(int i = 0; i < objects.length; i++){
			TreeObject object = objects[i];
			System.out.println("STAR_MODEL_FILE === " + object.getData(GlobalConstants.StarMoedl.STAR_MODEL_FILE) );
			System.out.println("fileName === " + fileName.substring(0,fileName.lastIndexOf(".")) );
			if(object.getData(GlobalConstants.StarMoedl.STAR_MODEL_FILE) != null && object.getData(GlobalConstants.StarMoedl.STAR_MODEL_FILE).equals(fileName.substring(0,fileName.lastIndexOf(".")))){
				inputData.put("userId", parent.getData(GlobalConstants.STAR_USER_ID));
				inputData.put("seq", object.getData(GlobalConstants.StarMoedl.STAR_MODEL_USECASE_SEQ));
				inputData.put("img", img);
				inputData.put("name", object.getData(GlobalConstants.StarMoedl.STAR_MODEL_FILE));
			}
		}
		
		try{
			PmsDao pd = new PmsDao();
			pd.clazzUpdate(inputData);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public URL getImageURL(){
		Bundle bundle = Platform.getBundle(Activator.PLUGIN_ID);
		return bundle.getEntry(ICON_PATH);
	}
	
	public ImageDescriptor getImageDescriptor(){
		return Activator.getImageDescriptor(ICON_PATH);
	}

}
