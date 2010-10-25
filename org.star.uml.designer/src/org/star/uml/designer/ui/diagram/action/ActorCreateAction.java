package org.star.uml.designer.ui.diagram.action;

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
import org.star.uml.designer.ui.factory.StarUMLCommandFactory;
import org.star.uml.designer.ui.factory.StarUMLEditHelperFactory;
import org.star.uml.designer.ui.views.StarPMSModelView;
import org.star.uml.designer.ui.views.StarPMSModelViewUtil;
import org.star.uml.designer.ui.views.StarPMSModelView.TreeObject;
import org.star.uml.designer.ui.views.StarPMSModelView.TreeParent;

public class ActorCreateAction extends Action implements IStarUMLAction{
	public static final String ACTION_ID = "ACTOR";
	public static final String ACTION_URI = "org.eclipse.uml2.diagram.usecase.Actor_2002";
	public static final String ACTION_TITLE ="Create Actor";
	public static final String ACTION_TYPE ="uml:Actor";
	public static final String ICON_PATH = "/icons/diagram/Actor.gif";
	public static final String[] ACTOR_NAMES= {"Park Yong Cheon","Kim Sung Sik"};
	
	public TransactionalEditingDomain domain = null;
	public DiagramDocumentEditor editor = null;
	public View view = null;
	
	public ActorCreateAction() {
		super();
		this.setText(ACTION_TITLE);
		this.setImageDescriptor(getImageDescriptor());
	}
	
	@Override
	public void run() {
		// 모델 Tree에 Actorfmf 추가한다.
		IViewPart view_part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
								.findView(GlobalConstants.PluinID.STAR_PMS_MODEL_VIEW);
		StarPMSModelView modelView = (StarPMSModelView)view_part;
		// 선택된 Tree를 가져온다.
		TreeSelection treeSelection = (TreeSelection)modelView.getTreeViewer().getSelection();
		TreeParent parent = (TreeParent)treeSelection.getFirstElement();
		String parentId = (String)parent.getData(GlobalConstants.StarMoedl.STAR_MODEL_ID);
		// ID를 생성한다.
		String objId = "_" + CommonUtil.randomKey() + "-GMK-em0Iv_Q";
		// 이름을 생성한다.
		String nodename = StarPMSModelViewUtil.genNodeName(parent);
		// 추가된 Node에 필요한 값들을 설정한다.
		TreeObject treeObject = parent.appendChield(parent,nodename+"("+ACTION_ID+")",
					GlobalConstants.StarMoedl.STAR_MODEL_CATEGORY, 
					GlobalConstants.StarMoedl.STAR_CATEGORY_DIAGRAM_MODEL					);
		treeObject.setData(GlobalConstants.StarMoedl.STAR_MODEL_FILE, nodename);
		treeObject.setData(GlobalConstants.StarMoedl.STAR_MODEL_EXTENSION, ACTION_ID);
		treeObject.setData(GlobalConstants.StarMoedl.STAR_MODEL_ID, objId);
		modelView.getTreeViewer().refresh();
		// Model.xml 파일에 노드를 추가한다.
		StarPMSModelViewUtil.addDiagramToModel("Root",parentId,nodename,ACTION_ID,
							  			GlobalConstants.StarMoedl.STAR_CATEGORY_DIAGRAM_MODEL,ACTION_ID,objId);
		// Default.xml 파일에 노드를 추가한다.
		StarPMSModelViewUtil.addModelToUML("Root",objId,ACTION_TYPE,nodename);
		EclipseUtile.refreshProject("Root");
	}
	
	public void insertNode(){
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
        if(page.getActiveEditor() !=null && page.getActiveEditor() instanceof org.eclipse.uml2.diagram.usecase.part.UMLDiagramEditor){
        	org.eclipse.uml2.diagram.usecase.part.UMLDiagramEditor editor = 
        		(org.eclipse.uml2.diagram.usecase.part.UMLDiagramEditor)page.getActiveEditor();
        	DiagramEditPart diagramEditPart = editor.getDiagramEditPart();
        	IDiagramDocument document = editor.getDiagramDocument();
        	Diagram diagram = document.getDiagram();
        	for(int i=0; i<diagram.getTransientChildren().size(); i++){
        		ShapeImpl shapeImple = (ShapeImpl)diagram.getTransientChildren().get(i);
            	System.out.println("getType : "+shapeImple.getType());
            	System.out.println("getElement : "+shapeImple.getElement());
        	}
        	
        	
        	IFile file = WorkspaceSynchronizer.getFile(diagram.eResource());
        	UMLNavigatorItem item = new UMLNavigatorItem(diagram, file, false);
			DiagramImpl diagramImpleImple = (DiagramImpl)item.getView();
			PackageImpl packageImple = (PackageImpl) diagramImpleImple.getElement();
			List list = packageImple.getMembers();
			for(int i=0; i<list.size(); i++){
				if(list.get(i) instanceof ActorImpl){
					ActorImpl actorImple = (ActorImpl)list.get(i);
//					System.out.println(i+" getLabel : "+actorImple.getLabel());
//					System.out.println(i+" getName : "+actorImple.getName());
//					System.out.println(i+" getOwner : "+actorImple.getOwner());
//					System.out.println(i+" getVisibility : "+actorImple.getVisibility());
//					System.out.println(i+" eContainerFeatureID : "+actorImple.eContainerFeatureID());
//					System.out.println(i+" eAdapters : "+actorImple.eAdapters().size());
//					System.out.println(i+" eAllContents : "+actorImple.eAllContents());
//					System.out.println(i+" eContainer : "+actorImple.eContainer());
//					System.out.println(i+" eContainingFeature : "+actorImple.eContainingFeature());
//					System.out.println(i+" eContainmentFeature : "+actorImple.eContainmentFeature());
//					System.out.println(i+" eContents : "+actorImple.eContents());
//					System.out.println(i+" eDirectResource : "+actorImple.eDirectResource());
				}
			}
        }
		// Node를 삽입하기 위한  정보를 가져온다.
//		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
//		this.editor = (DiagramDocumentEditor) page.getActiveEditor();
//		this.domain = editor.getEditingDomain();
//		this.view = (View)editor.getDiagramEditPart().getModel();
//		
//		URL fileURL = getImageURL(); 
//		UMLBaseEditHelper helper = StarUMLEditHelperFactory.getEditHelper(ACTION_ID);
//    	MetamodelType modelType = new MetamodelType(ACTION_URI,fileURL, ACTION_ID,null,helper);
//    	
//    	CreateElementRequest request = new CreateElementRequest(domain,view, modelType);
//    	EObject eObj = createNode();
//    	request.setNewElement(eObj);
//    	request.setLabel(ACTION_ID);
//    	
//    	AbstractTransactionalCommand actorCmd = StarUMLCommandFactory.getCommand(request);
//    	EObjectAdapter info = new EObjectAdapter(eObj);
//    	EclipseUtile.runCommand(actorCmd, info);
	}
	
	public EObject createNode(){
		UMLFactory factoryImple = UMLFactoryImpl.init();
		final ActorImpl actor = (ActorImpl)factoryImple.createActor();
		actor.setName(ACTOR_NAMES[0]);
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
