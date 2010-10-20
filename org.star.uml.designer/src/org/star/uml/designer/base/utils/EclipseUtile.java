package org.star.uml.designer.base.utils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;

import org.eclipse.core.internal.resources.Project;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.image.ImageFileFormat;
import org.eclipse.gmf.runtime.diagram.ui.render.clipboard.DiagramGenerator;
import org.eclipse.gmf.runtime.diagram.ui.render.clipboard.DiagramImageGenerator;
import org.eclipse.gmf.runtime.diagram.ui.render.internal.DiagramUIRenderPlugin;
import org.eclipse.gmf.runtime.diagram.ui.render.internal.DiagramUIRenderStatusCodes;
import org.eclipse.gmf.runtime.diagram.ui.render.internal.l10n.DiagramUIRenderMessages;
import org.eclipse.gmf.runtime.diagram.ui.render.util.CopyToImageUtil;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.uml2.diagram.usecase.part.UMLDiagramEditor;
import org.eclipse.uml2.diagram.usecase.part.UMLDiagramEditorUtil;
import org.eclipse.uml2.uml.internal.impl.ActorImpl;
import org.star.uml.designer.command.InsertActionCommand;
import org.w3c.dom.Document;
import org.w3c.dom.Document;

public class EclipseUtile {
	
	public static IProject createNewProject(String projectName,Document modelDoc,Document umlDoc) {
		final MultiStatus status = new MultiStatus(DiagramUIRenderPlugin
				.getPluginId(), DiagramUIRenderStatusCodes.OK,
				DiagramUIRenderMessages.CopyToImageAction_Label, null);
		final IProject newProjectHandle =  ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
    	IRunnableWithProgress runnable = createNewProjectRunable(status,newProjectHandle,modelDoc,umlDoc);
    	try {
    		ProgressMonitorDialog progressMonitorDialog = new ProgressMonitorDialog(
    				Display.getCurrent().getActiveShell());
    		progressMonitorDialog.run(false, true, runnable);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newProjectHandle;
	}
	
	private static IRunnableWithProgress createNewProjectRunable(final MultiStatus status,final IProject projectHandle,final Document modelDoc,final Document umlDoc) {
		return new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) {
				try {
					projectHandle.create(monitor);
			    	monitor.beginTask("", 6); 
					monitor.worked(1);
					monitor.setTaskName("모델을 생성 합니다.");
					projectHandle.open(monitor);
					String projectPath = projectHandle.getLocation().toOSString();
					XmlUtil.writeXmlFile(modelDoc, projectPath+File.separator+"model.xml");
					XmlUtil.writeXmlFile(umlDoc, projectPath+File.separator+"default.uml");
					IFile file = projectHandle.getFile("custom-messages.properties");
					file.create(new ByteArrayInputStream("".getBytes()), true, monitor);
					projectHandle.refreshLocal(IProject.DEPTH_INFINITE, monitor);
				} catch (CoreException e) {
					e.printStackTrace();
					status.add(e.getStatus());
				}catch (Exception e1) {
					e1.printStackTrace();
				} finally {
					monitor.done();
				}
			}
		};
	}

	public static IProject createDiagram(String projectName,String fileExtension) {
		final MultiStatus status = new MultiStatus(DiagramUIRenderPlugin
				.getPluginId(), DiagramUIRenderStatusCodes.OK,
				DiagramUIRenderMessages.CopyToImageAction_Label, null);
		final IProject projectHandle =  ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
    	IRunnableWithProgress runnable = createDiagramRunable(status,projectHandle,fileExtension);
    	try {
    		ProgressMonitorDialog progressMonitorDialog = new ProgressMonitorDialog(
    				Display.getCurrent().getActiveShell());
    		progressMonitorDialog.run(false, true, runnable);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return projectHandle;
	}
	
	private static IRunnableWithProgress createDiagramRunable(final MultiStatus status,final IProject projectHandle,final String fileExtension) {
		return new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) {
				String fileName = "default"+getDefaultUMLIdx()+"."+fileExtension;
				URI diagramURI = URI.createDeviceURI("platform:/resource/Root/"+fileName);
				URI modelURI = URI.createDeviceURI("platform:/resource/Root/default.uml");
				Resource diagram = org.eclipse.uml2.diagram.usecase.part.UMLDiagramEditorUtil.createDiagram(diagramURI, modelURI, null, "UTF-8", monitor);
				System.out.println("diagram : "+diagram);
				try {
					UMLDiagramEditorUtil.openDiagram(diagram);
				} catch (PartInitException e) {
					e.printStackTrace();
				}
				String projectPath = projectHandle.getLocation().toOSString();
				java.io.File proFile = new java.io.File(projectPath+"/custom-messages.properties");
				Properties props = new Properties();
				try {
					props.load(new FileInputStream(proFile));
					props.put("diagramName", fileName);
					props.store(new FileOutputStream(proFile), "");
					projectHandle.refreshLocal(IProject.DEPTH_ONE, monitor);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		
	}
	
	public static void openDiagram(String path){
		try{
			IResource workspaceResource = ResourcesPlugin.getWorkspace().getRoot().findMember(new Path(path));
			if (workspaceResource instanceof IFile) {
				IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				page.openEditor(new FileEditorInput((IFile) workspaceResource), UMLDiagramEditor.ID);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static String getDefaultUMLIdx(){
		IProject projectHandle =  ResourcesPlugin.getWorkspace().getRoot().getProject("Root");
		String projectPath = projectHandle.getLocation().toOSString();
		java.io.File folder = new java.io.File(projectPath);
		int defaultIdx = 1;
		for(int i=0; i<folder.list().length; i++){
			String fullFileName = folder.list()[i];
			int endIdx = fullFileName.indexOf(".");
			if(fullFileName.contains("default") && endIdx > 7){
				int startIdx = 7;
				String idx = fullFileName.substring(startIdx,endIdx);
				Integer intIdx = new Integer(idx);
				defaultIdx = intIdx.intValue()+1;
			}
		}
		return String.valueOf(defaultIdx);
	}
	
	public static void runCommand(AbstractTransactionalCommand actorCmd,EObjectAdapter info) {
		final MultiStatus status = new MultiStatus(DiagramUIRenderPlugin
				.getPluginId(), DiagramUIRenderStatusCodes.OK,
				DiagramUIRenderMessages.CopyToImageAction_Label, null);
    	IRunnableWithProgress runnable = createActionCommandRunable(actorCmd,info);
    	try {
    		ProgressMonitorDialog progressMonitorDialog = new ProgressMonitorDialog(
    				Display.getCurrent().getActiveShell());
    		progressMonitorDialog.run(false, true, runnable);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static IRunnableWithProgress createActionCommandRunable(final AbstractTransactionalCommand actorCmd,final EObjectAdapter info) {
		return new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) {
				try {
			    	monitor.beginTask("", 6); 
					monitor.worked(1);
					monitor.setTaskName("모델을 생성 합니다.");
					actorCmd.execute(monitor, info);
				} catch (Exception e1) {
					e1.printStackTrace();
				} finally {
					monitor.done();
				}
			}
		};
	}
}
