package org.star.uml.designer.ui.diagram.action;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramCommandStack;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Platform;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.gef.commands.Command;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDiagramDocument;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.MetamodelType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
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
import org.star.uml.designer.ui.diagram.action.interfaces.IStarUMLModelAction;
import org.star.uml.designer.ui.factory.StarUMLCommandFactory;
import org.star.uml.designer.ui.factory.StarUMLEditHelperFactory;
import org.star.uml.designer.ui.views.StarPMSModelView;
import org.star.uml.designer.ui.views.StarPMSModelViewUtil;
import org.star.uml.designer.ui.views.StarPMSModelView.TreeObject;
import org.star.uml.designer.ui.views.StarPMSModelView.TreeParent;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

public class DeleteFromModelAction extends Action implements IStarUMLModelAction{
	public static final String ACTION_ID = "DELETE FROM MOEL";
	public static final String ACTION_URI = "";
	public static final String ACTION_TITLE ="Delete from Model";
	public static final String ACTION_TYPE ="";
	public static final String ICON_PATH = "/icons/logout.gif";
	
	private String selectedNodeName = "";
	private DiagramDocumentEditor editor = null;
	
	public DeleteFromModelAction() {
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
			TreeObject selectedTree = (TreeObject)treeSelection.getFirstElement();
			selectedNodeName = (String)selectedTree.getData(GlobalConstants.StarMoedl.STAR_MODEL_FILE);
			// 열린 화면 중에 Usecase Diagram Editor가 있는 지 확인 하고 있을 경우 모델이 그려져 있으면 삭제한다.
			IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			if(page.getActiveEditor() !=null && page.getActiveEditor() instanceof DiagramDocumentEditor){
				DiagramDocumentEditor editor = (DiagramDocumentEditor)page.getActiveEditor();
	        	// 다이어 그램을 수정하기 위한 환경 정보들을 가져온다.
	        	IDiagramDocument document = editor.getDiagramDocument();
	        	Diagram diagram = document.getDiagram();
	        	TransactionalEditingDomain editingDomain = editor.getEditingDomain();
	        	IGraphicalEditPart ep = (IGraphicalEditPart)editor.getDiagramGraphicalViewer().getContents();
	    		// Editor에 있는 모델 중 선택된 모델과 같은 것이 있는 지 확인한 후 삭제한다.
	        	for(int i=0; i<diagram.getPersistedChildren().size(); i++){
	        		ShapeImpl shapeImple = (ShapeImpl)diagram.getPersistedChildren().get(i);
	        		BehavioredClassifierImpl beImple = null;
	        		if(shapeImple.getElement() instanceof BehavioredClassifierImpl){
	        			beImple = (BehavioredClassifierImpl)shapeImple.getElement();
	        			if(selectedNodeName.equals(beImple.getName())){
	        				// Shape의 좌표를 통해 EditorPart를 얻어온다.
	        				Location location = (Location)shapeImple.getLayoutConstraint();
	        				DiagramEditPart diagramEditPart = editor.getDiagramEditPart();
	        				Point point = new Point(location.getX(),location.getY());
	        				EditPart editPart = diagramEditPart.getViewer().findObjectAt(point);
	        				// 삭제 Command를 작성한다.
	        				EditCommandRequestWrapper targetRequest = new EditCommandRequestWrapper(new DestroyElementRequest(editingDomain, false));
	        		        Command curCommand = editPart.getCommand(targetRequest);
	        		        CompositeTransactionalCommand command = new CompositeTransactionalCommand(editingDomain, DiagramUIMessages.DiagramEditor_Delete_from_Model);
	        		        command.compose(new CommandProxy(curCommand));
	        		        ICommandProxy icmdPoxy = new ICommandProxy(command);
	        		        editor.getDiagramEditDomain().getDiagramCommandStack().execute(icmdPoxy);
	        			}
	        		}else if(shapeImple.getElement() instanceof PackageImpl){
	        			PackageImpl imple = (PackageImpl)shapeImple.getElement();
	        			if(selectedNodeName.equals(imple.getName())){
	        				// Shape의 좌표를 통해 EditorPart를 얻어온다.
	        				Location location = (Location)shapeImple.getLayoutConstraint();
	        				DiagramEditPart diagramEditPart = editor.getDiagramEditPart();
	        				Point point = new Point(location.getX(),location.getY());
	        				EditPart editPart = diagramEditPart.getViewer().findObjectAt(point);
	        				// 삭제 Command를 작성한다.
	        				EditCommandRequestWrapper targetRequest = new EditCommandRequestWrapper(new DestroyElementRequest(editingDomain, false));
	        		        Command curCommand = editPart.getCommand(targetRequest);
	        		        CompositeTransactionalCommand command = new CompositeTransactionalCommand(editingDomain, DiagramUIMessages.DiagramEditor_Delete_from_Model);
	        		        command.compose(new CommandProxy(curCommand));
	        		        ICommandProxy icmdPoxy = new ICommandProxy(command);
	        		        editor.getDiagramEditDomain().getDiagramCommandStack().execute(icmdPoxy);
	        			}
	        		}
	        	}
	        }else{
	        	// 에디터가 열려 있지 않다면 UML 파일에서 직접 삭제한다.
	        	Document modelDoc = null;
				String modelPath = "";
				// 삭제할 노드 ID를 가져온다.
				String id = (String)selectedTree.getData(GlobalConstants.StarMoedl.STAR_MODEL_ID);
				try {
					IProject rootProject = ResourcesPlugin.getWorkspace().getRoot().getProject("Root");
					String projectPath = rootProject.getLocation().toOSString();
					modelPath =  projectPath+File.separator+GlobalConstants.DEFAULT_MODEL_FILE;
					String domStr = XmlUtil.getXmlFileToString(modelPath);
					modelDoc = XmlUtil.getStringToDocument(domStr);
				} catch (Exception e) {
					e.printStackTrace();
				}
				// 노드 리스트에서 ID가 같은 노드를 찾아 삭제한다.
				NodeList nodeList = modelDoc.getElementsByTagName("packagedElement");
				for(int i=0; i<nodeList.getLength(); i++){
					NamedNodeMap appMap = nodeList.item(i).getAttributes();
					String attId = (String)appMap.getNamedItem(GlobalConstants.StarMoedl.STAR_MODEL_ID).getNodeValue();
					if(id.equals(attId)){
						nodeList.item(i).getParentNode().removeChild(nodeList.item(i));
					}
				}
				// 변경된 XML를 다시 저장한다.
				try {
					XmlUtil.writeXmlFile(modelDoc,modelPath);
				} catch (Exception e) {
					e.printStackTrace();
				}
	        }
			// Model Tree에서 Model를 삭제한다.
			selectedTree.getParent().removeChild(selectedTree);
			// Model Tree XML에서 모델을 삭제한다.
			// 삭제할 노드 ID를 가져온다.
			String id = (String)selectedTree.getData(GlobalConstants.StarMoedl.STAR_MODEL_ID);
			IProject rootProject = ResourcesPlugin.getWorkspace().getRoot().getProject("Root");
			// Model Tree XML를 Document를 변환 한다.
			Document modelDoc = null;
			String modelPath = "";
			try {
				String projectPath = rootProject.getLocation().toOSString();
				modelPath =  projectPath+File.separator+GlobalConstants.DEFAULT_VIEW_MODEL_FILE;
				String domStr = XmlUtil.getXmlFileToString(modelPath);
				modelDoc = XmlUtil.getStringToDocument(domStr);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 노드 리스트에서 ID가 같은 노드를 찾아 삭제한다.
			NodeList nodeList = modelDoc.getElementsByTagName("packagedElement");
			for(int i=0; i<nodeList.getLength(); i++){
				NamedNodeMap appMap = nodeList.item(i).getAttributes();
				String attId = (String)appMap.getNamedItem(GlobalConstants.StarMoedl.STAR_MODEL_ID).getNodeValue();
				if(id.equals(attId)){
					nodeList.item(i).getParentNode().removeChild(nodeList.item(i));
				}
			}
			// 변경된 XML를 다시 저장한다.
			try {
				XmlUtil.writeXmlFile(modelDoc,modelPath);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 프로잭트를 Represh해서 변경사항을 저장한다.
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
