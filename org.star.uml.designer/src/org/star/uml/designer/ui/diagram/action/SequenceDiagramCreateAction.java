package org.star.uml.designer.ui.diagram.action;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.gmf.runtime.diagram.ui.render.internal.DiagramUIRenderPlugin;
import org.eclipse.gmf.runtime.diagram.ui.render.internal.DiagramUIRenderStatusCodes;
import org.eclipse.gmf.runtime.diagram.ui.render.internal.l10n.DiagramUIRenderMessages;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.osgi.framework.Bundle;
import org.star.uml.designer.Activator;
import org.star.uml.designer.base.constance.GlobalConstants;
import org.star.uml.designer.base.utils.CommonUtil;
import org.star.uml.designer.base.utils.EclipseUtile;
import org.star.uml.designer.service.dao.PmsDao;
import org.star.uml.designer.ui.diagram.action.interfaces.IStarUMLModelAction;
import org.star.uml.designer.ui.views.StarPMSModelView;
import org.star.uml.designer.ui.views.StarPMSModelViewUtil;
import org.star.uml.designer.ui.views.StarPMSRequestTableView;
import org.star.uml.designer.ui.views.StarPMSModelView.TreeObject;
import org.star.uml.designer.ui.views.StarPMSModelView.TreeParent;

public class SequenceDiagramCreateAction  extends Action implements IStarUMLModelAction{
	public static final String ACTION_ID = "SEQUENCE_DIAGRAM";
	public static final String ACTION_URI = "org.eclipse.uml2.diagram.sequence.SequenceDiagram";
	public static final String ACTION_TITLE ="Create Sequence Diagram";
	public static final String ICON_PATH = "/icons/16.gif";
	public static final String DIAGRAM_EXTENSION = "umlseq";
	public IViewPart view = null;
	
	public SequenceDiagramCreateAction() {
		super();
		this.setText(ACTION_TITLE);
		this.setImageDescriptor(getImageDescriptor());
	}
	
	@Override
	public void run() {
		
		Map inputData = new HashMap();
		IViewPart table_view_part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView("org.star.uml.designer.ui.views.StarPMSRequestTableView");
		StarPMSRequestTableView tableView = (StarPMSRequestTableView)table_view_part;
		Table table = tableView.getTable();
		int flagCnt = 0;
		for(int i = 0; i < table.getItemCount(); i++){
			TableItem item = table.getItem(i);
			if(item.getChecked()){
				String seq = (String)item.getData("seq");
				String name =  item.getText(2);
				inputData.put("parentSeq", seq);
				inputData.put("name", name);
				flagCnt++;
			}
		}
		
		if(flagCnt == 0){
			MessageDialog.openInformation(tableView.getViewSite().getShell(),"다이어그램 저장","Request Table에서 저장될 항목을 선택 해 주세요");
			return;
		}
//    	final MultiStatus status = new MultiStatus(DiagramUIRenderPlugin
//				.getPluginId(), DiagramUIRenderStatusCodes.OK,
//				DiagramUIRenderMessages.CopyToImageAction_Label, null);
//    	IRunnableWithProgress runnable = EclipseUtile.createImageRunnable(status);
//    	try {
//    		ProgressMonitorDialog progressMonitorDialog = new ProgressMonitorDialog(
//    				Display.getCurrent().getActiveShell());
//    		progressMonitorDialog.run(false, true, runnable);
//    		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView("org.star.uml.designer.ui.views.StarPMSRequestTableView");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		//String folderPaht = ResourcesPlugin.getWorkspace().getRoot().getProject("Root").getLocation().toString();
		//File img = new File(folderPaht + "/default.png");
		//inputData.put("img", img);
		IViewPart tree_view_part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView("org.star.uml.designer.ui.views.StarPMSModelView");
		StarPMSModelView treeView = (StarPMSModelView)tree_view_part;
		inputData.put("userId", treeView.getTreeParent().getData(GlobalConstants.STAR_USER_ID));
		try{
			PmsDao pd = new PmsDao();
			inputData.put("seq", pd.sequenceSeqMax());
			pd.analysis_insert(inputData);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		// "default" 다이어그램을 생성하기 위해 기존 "default" 이름을 사용하는 파일이 있는지 확인 한 후 
		// Index를 +1 해서 다이어 그램을 생성한다.  
		String fileName = "default"+EclipseUtile.getDefaultUMLIdx();
		String fileFullName = "default"+EclipseUtile.getDefaultUMLIdx()+"."+DIAGRAM_EXTENSION;
		URI diagramURI = URI.createDeviceURI(GlobalConstants.PATH_PREFIX+"/Root/"+fileFullName);
		URI modelURI = URI.createDeviceURI(GlobalConstants.PATH_PREFIX+"/Root/"+GlobalConstants.DEFAULT_MODEL_FILE);
		
		EclipseUtile.createDiagram("Root",diagramURI,modelURI,ACTION_ID);
		
		// 모델 Tree에 다이어그램을 추가한다.
		IViewPart view_part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
								.findView(GlobalConstants.PluinID.STAR_PMS_MODEL_VIEW);
		StarPMSModelView modelView = (StarPMSModelView)view_part;
		// 선택된 Tree를 가져온다.
		TreeSelection treeSelection = (TreeSelection)modelView.getTreeViewer().getSelection();
		TreeParent parent = (TreeParent)treeSelection.getFirstElement();
		String parentId = (String)parent.getData(GlobalConstants.StarMoedl.STAR_MODEL_ID);
		// ID를 생성한다.
		String objId = "_" + CommonUtil.randomKey() + "-GMK-em0Iv_Q";
		// 추가된 Node에 필요한 값들을 설정한다.
		TreeObject treeObject = parent.appendChield(parent,fileName+"("+ACTION_ID+")"
								,GlobalConstants.StarMoedl.STAR_MODEL_FILE, fileName);
		treeObject.setData(GlobalConstants.StarMoedl.STAR_MODEL_EXTENSION, DIAGRAM_EXTENSION);
		treeObject.setData(GlobalConstants.StarMoedl.STAR_MODEL_CATEGORY, 
					       GlobalConstants.StarMoedl.STAR_CATEGORY_DIAGRAM);
		treeObject.setData(GlobalConstants.StarMoedl.STAR_MODEL_ID, objId);
		treeObject.setData(GlobalConstants.StarMoedl.STAR_MODEL_USECASE_SEQ, inputData.get("seq"));
		treeObject.setData(GlobalConstants.StarMoedl.STAR_MODEL_USECASE_PARENT_SEQ, inputData.get("parentSeq"));
		modelView.getTreeViewer().refresh();
		// 모델 파일에 추가된 다이어 그램을 추가한다.
		StarPMSModelViewUtil.addDiagramToModel("Root",parentId,fileName,DIAGRAM_EXTENSION,
							  				   GlobalConstants.StarMoedl.STAR_CATEGORY_DIAGRAM,ACTION_ID,objId,GlobalConstants.UMLMoedl.UML_TYPE_PACKAGE_Element,(String)inputData.get("parentSeq"),(String)inputData.get("seq"));
	}
	
	public URL getImageURL(){
		Bundle bundle = Platform.getBundle(Activator.PLUGIN_ID);
		return bundle.getEntry(ICON_PATH);
	}
	
	public ImageDescriptor getImageDescriptor(){
		return Activator.getImageDescriptor(ICON_PATH);
	}
}
