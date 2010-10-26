package org.star.uml.designer.ui.diagram.action;

import java.net.URL;
import java.util.HashMap;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.command.Command;
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
import org.star.uml.designer.command.InsertActorCommand;
import org.star.uml.designer.ui.factory.StarUMLCommandFactory;
import org.star.uml.designer.ui.factory.StarUMLEditHelperFactory;
import org.star.uml.designer.ui.views.StarPMSModelView;
import org.star.uml.designer.ui.views.StarPMSModelViewUtil;
import org.star.uml.designer.ui.views.StarPMSModelView.TreeObject;
import org.star.uml.designer.ui.views.StarPMSModelView.TreeParent;

public class ActorInsertAction extends Action implements IStarUMLAction{
	public static final String ACTION_ID = "ACTOR INSERT";
	public static final String ACTION_URI = "";
	public static final String ACTION_TITLE ="Insert Actor";
	public static final String ACTION_TYPE ="";
	public static final String ICON_PATH = "/icons/diagram/Actor.gif";
	public String nodeName = "";
	
	public TransactionalEditingDomain domain = null;
	public DiagramDocumentEditor editor = null;
	public View view = null;
	
	public ActorInsertAction() {
		super();
		this.setText(ACTION_TITLE);
		this.setImageDescriptor(getImageDescriptor());
	}
	
	@Override
	public void run() {
			// 모델 Tree에 Actor를 추가한다.
			IViewPart view_part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
									.findView(GlobalConstants.PluinID.STAR_PMS_MODEL_VIEW);
			StarPMSModelView modelView = (StarPMSModelView)view_part;
			// 선택된 Tree를 가져온다.
			TreeSelection treeSelection = (TreeSelection)modelView.getTreeViewer().getSelection();
			TreeObject parent = (TreeObject)treeSelection.getFirstElement();
			String selectedNodeName = (String)parent.getData(GlobalConstants.StarMoedl.STAR_MODEL_FILE);
			// 모델에 이미 Actor가 추가되어 있기 때문에 모델에 선택 된 Actor하고 이름이 같은 것을 찾아서 Visility를 변경한다.
			IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
	        if(page.getActiveEditor() !=null && page.getActiveEditor() instanceof org.eclipse.uml2.diagram.usecase.part.UMLDiagramEditor){
	        	org.eclipse.uml2.diagram.usecase.part.UMLDiagramEditor editor = 
	        		(org.eclipse.uml2.diagram.usecase.part.UMLDiagramEditor)page.getActiveEditor();
	        	// 에디터에서 다이어그램이 그려진 영역을 가져온다.
	        	IDiagramDocument document = editor.getDiagramDocument();
	        	Diagram diagram = document.getDiagram();
	        	// 보이거나 , 보이지 않거나 다이어그램에 등록 된 모든 자식들을 가져온다.
	        	for(int i=0; i<diagram.getTransientChildren().size(); i++){
	        		ShapeImpl shapeImple = (ShapeImpl)diagram.getTransientChildren().get(i);
	        		// 보이지 않으면서 , 모델 뷰에서 선택된 Actor와 같은 이름의 노드가 등록되어 있으면 보이도록 변경한다.
	        		if(shapeImple.getElement() instanceof ActorImpl && !shapeImple.isVisible()){
	        			ActorImpl actorImpl = (ActorImpl)shapeImple.getElement();
	        			String name = actorImpl.getName();
	        			if(selectedNodeName.equals(name)){
	        				InsertActorCommand cmd = (InsertActorCommand) StarUMLCommandFactory.getCommand(ACTION_ID);
	        				cmd.setActorImpl(actorImpl);
	        				cmd.setShapeImpl(shapeImple);
	                    	editor.getEditingDomain().getCommandStack().execute(cmd);
	        			}
	        		}
	        	}
	        }
//			// Node를 삽입하기 위한  정보를 가져온다.
//			IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
//			this.editor = (DiagramDocumentEditor) page.getActiveEditor();
//			this.domain = editor.getEditingDomain();
//			this.view = (View)editor.getDiagramEditPart().getModel();
//			
//			URL fileURL = getImageURL(); 
//			UMLBaseEditHelper helper = StarUMLEditHelperFactory.getEditHelper(ACTION_ID);
//	    	MetamodelType modelType = new MetamodelType(ACTION_URI,fileURL, ACTION_ID,null,helper);
//	    	
//	    	CreateElementRequest request = new CreateElementRequest(domain,view, modelType);
//	    	EObject eObj = createNode();
//	    	request.setNewElement(eObj);
//	    	request.setLabel(ACTION_ID);
//	    	
//	    	AbstractTransactionalCommand actorCmd = StarUMLCommandFactory.getCommand(request);
//	    	EObjectAdapter info = new EObjectAdapter(eObj);
//	    	EclipseUtile.runCommand(actorCmd, info);
		
	}
	
	public EObject createNode(){
		UMLFactory factoryImple = UMLFactoryImpl.init();
		final ActorImpl actor = (ActorImpl)factoryImple.createActor();
		actor.setName(nodeName);
		return actor;
	}

	public URL getImageURL(){
		Bundle bundle = Platform.getBundle(Activator.PLUGIN_ID);
		return bundle.getEntry(ICON_PATH);
	}
	
	public ImageDescriptor getImageDescriptor(){
		return Activator.getImageDescriptor(ICON_PATH);
	}
}
