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
import org.star.uml.designer.ui.diagram.action.interfaces.IStarUMLModelAction;
import org.star.uml.designer.ui.factory.StarUMLCommandFactory;
import org.star.uml.designer.ui.factory.StarUMLEditHelperFactory;
import org.star.uml.designer.ui.views.StarPMSModelView;
import org.star.uml.designer.ui.views.StarPMSModelViewUtil;
import org.star.uml.designer.ui.views.StarPMSModelView.TreeObject;
import org.star.uml.designer.ui.views.StarPMSModelView.TreeParent;

public class PackageModelCreateAction extends Action implements IStarUMLModelAction{
	public static final String ACTION_ID = "PACKAGE";
	public static final String ACTION_URI = "org.eclipse.uml2.diagram.usecase.createPackage_2001";
	public static final String ACTION_TITLE ="Create Package";
	public static final String ACTION_TYPE ="uml:Package";
	public static final String ICON_PATH = "/icons/diagram/Package.gif";
	public String nodeName = "";
	
	public TransactionalEditingDomain domain = null;
	public DiagramDocumentEditor editor = null;
	public View view = null;
	
	public PackageModelCreateAction() {
		super();
		this.setText(ACTION_TITLE);
		this.setImageDescriptor(getImageDescriptor());
	}
	
	@Override
	public void run() {
		// 모델 Tree에 Package를 추가한다.
		IViewPart view_part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
								.findView(GlobalConstants.PluinID.STAR_PMS_MODEL_VIEW);
		StarPMSModelView modelView = (StarPMSModelView)view_part;
		// 선택된 Tree를 가져온다.
		TreeSelection treeSelection = (TreeSelection)modelView.getTreeViewer().getSelection();
		TreeParent parent = (TreeParent)treeSelection.getFirstElement();
		String parentId = (String)parent.getData(GlobalConstants.StarMoedl.STAR_MODEL_ID);
		// ID를 생성한다.
		String objId = "_" + CommonUtil.randomKey() + "-Lwa6bV0dVcA";
		// 이름을 생성한다.
		nodeName = StarPMSModelViewUtil.genNodeName(parent);
		// 추가된 Node에 필요한 값들을 설정한다.
		TreeObject treeObject = parent.appendChield(parent,nodeName+"("+ACTION_ID+")",
					GlobalConstants.StarMoedl.STAR_MODEL_CATEGORY, 
					GlobalConstants.StarMoedl.STAR_CATEGORY_DIAGRAM_MODEL					);
		treeObject.setData(GlobalConstants.StarMoedl.STAR_MODEL_FILE, nodeName);
		treeObject.setData(GlobalConstants.StarMoedl.STAR_MODEL_EXTENSION, ACTION_TYPE);
		treeObject.setData(GlobalConstants.StarMoedl.STAR_MODEL_ID, objId);
		modelView.getTreeViewer().refresh();
		// Model.xml 파일에 노드를 추가한다.
		StarPMSModelViewUtil.addDiagramToModel("Root",parentId,nodeName,ACTION_TYPE,
							  			GlobalConstants.StarMoedl.STAR_CATEGORY_DIAGRAM_MODEL,ACTION_ID,objId,ACTION_TYPE,"","");
		// Default.xml 파일에 노드를 추가한다.
		StarPMSModelViewUtil.addModelToUML("Root",objId,ACTION_TYPE,nodeName);
		EclipseUtile.refreshProject("Root");
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
