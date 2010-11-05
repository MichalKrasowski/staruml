package org.star.uml.designer.ui.diagram.action;

import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
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
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
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
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.diagram.common.async.ApplySynchronizationCommand;
import org.eclipse.uml2.diagram.common.async.AsyncDiagramDeleteRequest;
import org.eclipse.uml2.diagram.common.async.SyncModelContext;
import org.eclipse.uml2.diagram.common.async.SyncModelNode;
import org.eclipse.uml2.diagram.common.async.SynchronizeDiagramAction;
import org.eclipse.uml2.diagram.usecase.edit.helpers.UMLBaseEditHelper;
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
import org.eclipse.uml2.uml.internal.impl.UseCaseImpl;
import org.osgi.framework.Bundle;
import org.star.uml.designer.application.Activator;
import org.star.uml.designer.base.constance.GlobalConstants;
import org.star.uml.designer.base.utils.CommonUtil;
import org.star.uml.designer.base.utils.EclipseUtile;
import org.star.uml.designer.command.MoveShapeCommand;
import org.star.uml.designer.command.VisibleShapeCommand;
import org.star.uml.designer.ui.diagram.action.interfaces.IStarUMLModelAction;
import org.star.uml.designer.ui.factory.StarUMLCommandFactory;
import org.star.uml.designer.ui.factory.StarUMLEditHelperFactory;
import org.star.uml.designer.ui.views.StarPMSModelView;
import org.star.uml.designer.ui.views.StarPMSModelViewUtil;
import org.star.uml.designer.ui.views.StarPMSModelView.TreeObject;
import org.star.uml.designer.ui.views.StarPMSModelView.TreeParent;

public class UsecaseModelInsertAction extends Action implements IStarUMLModelAction{
	public static final String ACTION_ID = "USECASE INSERT";
	public static final String ACTION_URI = "";
	public static final String ACTION_TITLE ="Insert Usecase";
	public static final String ACTION_TYPE ="uml:UseCase";
	public static final String ICON_PATH = "/icons/diagram/UseCase.gif";
	
	private String selectedNodeName = "";
	private DiagramDocumentEditor editor = null;
	
	public UsecaseModelInsertAction() {
		super();
		this.setText(ACTION_TITLE);
		this.setImageDescriptor(getImageDescriptor());
	}
	
	@Override
	public void run() {
		try{
			// 모델 Tree에 Usecase를 추가한다.
			IViewPart view_part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
									.findView(GlobalConstants.PluinID.STAR_PMS_MODEL_VIEW);
			StarPMSModelView modelView = (StarPMSModelView)view_part;
			// 선택된 Tree를 가져온다.
			TreeSelection treeSelection = (TreeSelection)modelView.getTreeViewer().getSelection();
			TreeObject parent = (TreeObject)treeSelection.getFirstElement();
			selectedNodeName = (String)parent.getData(GlobalConstants.StarMoedl.STAR_MODEL_FILE);
			// 모델에 이미 Usecase가 추가되어 있기 때문에 모델과 Snyc가능한 Usecase중 원하는 것을 선택 한 후 추가한다.
			IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			if(page.getActiveEditor() !=null && page.getActiveEditor() instanceof org.eclipse.uml2.diagram.usecase.part.UMLDiagramEditor){
	        	org.eclipse.uml2.diagram.usecase.part.UMLDiagramEditor editor = 
	        		(org.eclipse.uml2.diagram.usecase.part.UMLDiagramEditor)page.getActiveEditor();
	        	// 다이어 그램을 수정하기 위한 환경 정보들을 가져온다.
	        	IDiagramDocument document = editor.getDiagramDocument();
	        	Diagram diagram = document.getDiagram();
	        	TransactionalEditingDomain editingDomain = editor.getEditingDomain();
	        	// 모델을 같이 사용하기 때문에 최초 Editor로드 시 않보이는 노드들이 생성 되는데 
	        	//  Visible 속성을 통해 보이고 않보이고를 정한다.
	        	boolean visilityFlag = true;
	        	for(int i=0; i<diagram.getTransientChildren().size(); i++){
	        		ShapeImpl shapeImple = (ShapeImpl)diagram.getTransientChildren().get(i);
	        		if(shapeImple.getElement() instanceof UseCaseImpl){
	        			UseCaseImpl imple = (UseCaseImpl)shapeImple.getElement();
	        			if(!shapeImple.isVisible()){
	        				if(selectedNodeName.equals(imple.getName())){
	        					VisibleShapeCommand viCmd = new VisibleShapeCommand();
	        					viCmd.setShapeImpl(shapeImple);
	        					editor.getEditingDomain().getCommandStack().execute(viCmd);
	        					visilityFlag = false;
	        				}
	        			}
	        		}
	        	}
	        	for(int i=0; i<diagram.getPersistedChildren().size(); i++){
	        		ShapeImpl shapeImple = (ShapeImpl)diagram.getPersistedChildren().get(i);
	        		if(shapeImple.getElement() instanceof UseCaseImpl){
	        			UseCaseImpl imple = (UseCaseImpl)shapeImple.getElement();
	        			if(!shapeImple.isVisible()){
	        				if(selectedNodeName.equals(imple.getName())){
	        					VisibleShapeCommand viCmd = new VisibleShapeCommand();
	        					viCmd.setShapeImpl(shapeImple);
	        					editor.getEditingDomain().getCommandStack().execute(viCmd);
	        					visilityFlag = false;
	        				}
	        			}
	        		}
	        	}
	        	// Visible 속성을 통하여 화면에 표시된 경우 지나간다.
	        	if(visilityFlag){
		        	// 모델 Sync를 위한 정보를 가져온다. 모델 파일과 Sync한 결과가 저장될 다이어그램을 생성한다.
		        	IGraphicalEditPart ep = (IGraphicalEditPart)editor.getDiagramGraphicalViewer().getContents();
		        	View myRootDiagramView = ep.getNotationView();
		        	Diagram syncDiagram = ViewService.createDiagram(document.getDiagram().getElement(),"UMLUseCase", ep.getDiagramPreferencesHint());
		    		UMLVisualIDRegistry myVisualIDRegistry = new UMLVisualIDRegistry();
		        	UMLDiagramUpdater myDiagramUpdater= new UMLDiagramUpdater();
		    		SyncModelContext context = 
		        		new SyncModelContext(myDiagramUpdater.TYPED_ADAPTER, myVisualIDRegistry.TYPED_ADAPTER, ep.getDiagramPreferencesHint(), editingDomain);
		        	// 트리에서 선택된 모델을 Sync 모델에서 찾는다.
		        	SyncModelNode result = new SyncModelNode(syncDiagram, myRootDiagramView, context);
		        	for(int i=1; i<result.getChildren().size(); i++){
		        		if(result.getChildren().get(i).getSyncModelView().getElement() instanceof UseCaseImpl){
			        		UseCaseImpl imple = (UseCaseImpl)result.getChildren().get(i).getSyncModelView().getElement();
			        		if(selectedNodeName.equals(imple.getName())){
			        			result.getChildren().get(i).setChecked(true);
			        		}
		        		}
		        	}
		        	ApplySynchronizationCommand cmd = new ApplySynchronizationCommand(result);
		        	context.runCommand(cmd);
		        	context.dispose();
	        	}
	        	// 표시된 Node를 화면 가운데로 이동한다.
	    		// 모델을 기본 위치에서 가운데로 이동한다.
	        	for(int i=0; i<diagram.getPersistedChildren().size(); i++){
	        		ShapeImpl shapeImple = (ShapeImpl)diagram.getPersistedChildren().get(i);
	        		if(shapeImple.getElement() instanceof UseCaseImpl){
	        			Location location= (Location) shapeImple.getLayoutConstraint();
	        			UseCaseImpl impl = (UseCaseImpl)shapeImple.getElement();
	        			String name = impl.getName();
	        			if(selectedNodeName.equals(name)){
	        				MoveShapeCommand cmd = (MoveShapeCommand) StarUMLCommandFactory.getCommand(MoveShapeCommand.ID);
	        				cmd.setShapeImpl(shapeImple);
	                    	// 0,0 위치에 있을 경우 기본 위치에 표시하고 , 기본위치에 다른 모델이 있는 경우 그 모델 다음에 표시한다.
	        				boolean locationFlag = true;
	        				int modelX = GlobalConstants.DEFAULT_MODEL_X;
	        				int modelY = GlobalConstants.DEFAULT_MODEL_Y;
	        				while(locationFlag){
		        				DiagramEditPart diagramEditPart = editor.getDiagramEditPart();
		        				Point defaultPoint = new Point(modelX,modelY);
		        				EditPart editPart = diagramEditPart.getViewer().findObjectAt(defaultPoint);
		        				if(editPart instanceof PackageEditPart){
		        					locationFlag = false;
		        				}else{
		        					modelX = modelX+10;
		        					modelY = modelY+10;
		        				}
	        				}
	        				// 위치를 지정한 후 모델을 이동한다.
	        				cmd.setLocation(modelX, modelY);
	        				editor.getEditingDomain().getCommandStack().execute(cmd);
	        			}
	        		}
	        	}
	        }
	       
		}catch(Exception e){e.printStackTrace();}
	}
	
	public URL getImageURL(){
		Bundle bundle = Platform.getBundle(Activator.PLUGIN_ID);
		return bundle.getEntry(ICON_PATH);
	}
	
	public ImageDescriptor getImageDescriptor(){
		return Activator.getImageDescriptor(ICON_PATH);
	}
}
