package co.staruml.ui.wizard;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;

public class Project extends Wizard implements INewWizard {

	private WizardNewProjectCreationPage mainPage;
	private IProject newProject;
	private boolean traceEnabled = false;

	public Project() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean performFinish() {
		createNewProject();
		return true;
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
	}

	@Override
	public void addPages() {
		mainPage = new WizardNewProjectCreationPage("Create StarUML Project");
		mainPage.setDescription("Create a new StarUML Project with CustomNature.");
		mainPage.setTitle("New StarUML Project");
		addPage(mainPage);

	}

	public IProject createNewProject() {
		if (newProject != null)
			return newProject;
		final IProject newProjectHandle = mainPage.getProjectHandle();
		IPath defaultPath = Platform.getLocation();
		IPath newPath = mainPage.getLocationPath();
		if (defaultPath.equals(newPath))
			newPath = null;
		IWorkspace workspace = getWorkspace();
		final IProjectDescription description = workspace
				.newProjectDescription(newProjectHandle.getName());
		description.setLocation(newPath);
		
		Image folderImg = PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FOLDER);
		
		WorkspaceModifyOperation op = new WorkspaceModifyOperation() {
			protected void execute(IProgressMonitor monitor)throws CoreException {
				createProject(description, newProjectHandle, monitor);
			}
		};
		try {
			getContainer().run(false, true, op);
		} catch (InterruptedException e) {
			return null;
		} catch (InvocationTargetException e) {
			resultError("Create Project with CustomNature Request","Project creation failed");
			e.printStackTrace();
			return null;
		}
		newProject = newProjectHandle;
		return newProject;
	}

	public void createProject(IProjectDescription description,
			IProject projectHandle, IProgressMonitor monitor)
			throws CoreException, OperationCanceledException {
		try {
			monitor.beginTask("", 2000);
			projectHandle.create(description, new SubProgressMonitor(monitor,1000));

			if (monitor.isCanceled())
				throw new OperationCanceledException();

			projectHandle.open(new SubProgressMonitor(monitor, 1000));

		} finally {
			monitor.done();
		}
	}

	protected void resultError(String title, String msg) {
		if (traceEnabled)
			System.out.println(title + msg);
		else
			MessageDialog.openError(getShell(), title, msg);

	}

	public static IWorkspace getWorkspace() {
		return org.eclipse.core.resources.ResourcesPlugin.getWorkspace();
	}

	public IProject getNewProject() {
		return newProject;
	}

}
