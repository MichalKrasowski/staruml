package org.eclipse.uml2.diagram.statemachine.part;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IWrapperItemProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;


public class SelectStateMachineDialog extends Dialog {
	public SelectStateMachineDialog(Shell parentShell) {
		super(parentShell);
		setShellStyle(getShellStyle() | SWT.RESIZE);
	}
	
	@Override
	protected Control createDialogArea(Composite parent) {		
		getShell().setText(CustomMessages.SelectStateMachineDialog_Title);
		createViewer(parent);				
		return parent;
	}

	@Override
	protected Control createButtonBar(Composite parent) {
		Control buttonBar = super.createButtonBar(parent);
		setOkButtonEnabled(false);
		return buttonBar;
	}

	public URI getSelectedModelElementURI() {
		Resource resource = mySelectedModelElement.eResource();
		return resource.getURI().appendFragment(resource.getURIFragment(mySelectedModelElement));
	}

	private void createViewer(Composite parent) {
		treeViewer = new TreeViewer(parent, SWT.SINGLE | SWT.V_SCROLL | SWT.BORDER);
		GridData layoutData = new GridData(GridData.FILL_BOTH);
		layoutData.heightHint = 300;
		layoutData.widthHint = 300;
		treeViewer.getTree().setLayoutData(layoutData);
		treeViewer.setContentProvider(new ModelElementsTreeContentProvider());
		treeViewer.setLabelProvider(new ModelElementsTreeLabelProvider());
		treeViewer.setInput(ResourcesPlugin.getWorkspace().getRoot());
		treeViewer.addFilter(new ModelFilesFilter());
		treeViewer.addSelectionChangedListener(new OkButtonEnabler());

		Tree tree = treeViewer.getTree();
		MenuManager menuManager = new MenuManager();
        Menu menu = menuManager.createContextMenu(tree);
        menuManager.addMenuListener(new IMenuListener(){
			public void menuAboutToShow(IMenuManager manager) {
                NewStateMachineAction newStateMachineAction = new NewStateMachineAction();
                if (!(mySelectedModelElement instanceof Package)) {
                	newStateMachineAction.setEnabled(false);
                }
				manager.add(newStateMachineAction);
			}
		});
		menuManager.setRemoveAllWhenShown(true);
        tree.setMenu(menu);
	}

	private void setOkButtonEnabled(boolean enabled) {
		getButton(IDialogConstants.OK_ID).setEnabled(enabled);
	}

	private boolean isValidModelFile(IFile file) {
		String fileExtension = file.getFullPath().getFileExtension();
		return "uml".equals(fileExtension); //$NON-NLS-1$
	}
	
	private EObject mySelectedModelElement;
	private EditingDomain myEditingDomain = GMFEditingDomainFactory.INSTANCE.createEditingDomain();
	private TreeViewer treeViewer;
	
	private class NewStateMachineAction extends Action {
		public NewStateMachineAction() {
			super(CustomMessages.SelectStateMachineDialog_CreateStateMachineAction_Title);
		}
		
		@Override
		public void run() {
			Command addCommand = AddCommand.create(myEditingDomain, mySelectedModelElement, UMLPackage.Literals.PACKAGE__PACKAGED_ELEMENT, UMLFactory.eINSTANCE.createStateMachine(), CommandParameter.NO_INDEX);
			myEditingDomain.getCommandStack().execute(addCommand);
			Collection<?> result = addCommand.getResult();
			if (result.isEmpty()) {
				return;
			}
			Object createdElement = result.iterator().next();
			Command setCommand = SetCommand.create(myEditingDomain, createdElement, UMLPackage.Literals.NAMED_ELEMENT__NAME, CustomMessages.SelectStateMachineDialog_CreateStateMachineAction_DefaultName);
			myEditingDomain.getCommandStack().execute(setCommand);
			
			treeViewer.setSelection(new StructuredSelection(createdElement), true);
			try {
				mySelectedModelElement.eResource().save(null);
			} catch (IOException ioe) {
				UMLDiagramEditorPlugin.getInstance().logError("Unable to save modified model: " + mySelectedModelElement.eResource().getURI().toString(), ioe); //$NON-NLS-1$
				ioe.printStackTrace();
			}
		};
	}

	private class OkButtonEnabler implements ISelectionChangedListener {
		public void selectionChanged(SelectionChangedEvent event) {
			if (event.getSelection() instanceof IStructuredSelection) {
				IStructuredSelection selection = (IStructuredSelection) event.getSelection();
				if (selection.size() == 1) {
					Object selectedElement = selection.getFirstElement();
					if (selectedElement instanceof IWrapperItemProvider) {
						selectedElement = ((IWrapperItemProvider) selectedElement).getValue();
					}
					if (selectedElement instanceof FeatureMap.Entry) {
						selectedElement = ((FeatureMap.Entry) selectedElement).getValue();
					}
					if (selectedElement instanceof EObject) {
						mySelectedModelElement = (EObject) selectedElement;
						setOkButtonEnabled(mySelectedModelElement != null && 
								mySelectedModelElement.eClass() == UMLPackage.Literals.STATE_MACHINE);
						return;
					}
				}
			}
			mySelectedModelElement = null;
			setOkButtonEnabled(false);
		}
	}

	private class ModelElementsTreeContentProvider implements ITreeContentProvider {
		public Object[] getChildren(Object parentElement) {
			Object[] result = myWorkbenchContentProvider.getChildren(parentElement);
			if (result != null && result.length > 0) {
				return result;
			}
			if (parentElement instanceof IFile) {
				IFile modelFile = (IFile) parentElement;
				IPath resourcePath = modelFile.getFullPath();
				ResourceSet resourceSet = myEditingDomain.getResourceSet();
				try {
					Resource modelResource = resourceSet.getResource(URI.createPlatformResourceURI(resourcePath.toString(), true), true);
					return myAdapterFctoryContentProvier.getChildren(modelResource);
				} catch (WrappedException e) {
					UMLDiagramEditorPlugin.getInstance().logError("Unable to load resource: " + resourcePath.toString(), e); //$NON-NLS-1$
				}
				return Collections.EMPTY_LIST.toArray();
			}
			return myAdapterFctoryContentProvier.getChildren(parentElement);
		}

		public Object getParent(Object element) {
			Object parent = myWorkbenchContentProvider.getParent(element);
			if (parent != null) {
				return parent;
			}
			if (element instanceof EObject) {
				EObject eObject = (EObject) element;
				if (eObject.eContainer() == null && eObject.eResource().getURI().isFile()) {
					String path = eObject.eResource().getURI().path();
					return ResourcesPlugin.getWorkspace().getRoot().getFileForLocation(new Path(path));
				}
				return myAdapterFctoryContentProvier.getParent(eObject);
			}
			return null;
		}

		public boolean hasChildren(Object element) {
			if (element instanceof IFile) {
				return isValidModelFile((IFile) element);
			}
			return myWorkbenchContentProvider.hasChildren(element) || myAdapterFctoryContentProvier.hasChildren(element);
		}

		public Object[] getElements(Object inputElement) {
			Object[] elements = myWorkbenchContentProvider.getElements(inputElement);
			return elements;
		}

		public void dispose() {
			myWorkbenchContentProvider.dispose();
			myAdapterFctoryContentProvier.dispose();
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			myWorkbenchContentProvider.inputChanged(viewer, oldInput, newInput);
			myAdapterFctoryContentProvier.inputChanged(viewer, oldInput, newInput);
		}

		private ITreeContentProvider myWorkbenchContentProvider = new WorkbenchContentProvider();
		private AdapterFactoryContentProvider myAdapterFctoryContentProvier = new AdapterFactoryContentProvider(UMLDiagramEditorPlugin.getInstance().getItemProvidersAdapterFactory());
	}

	private class ModelElementsTreeLabelProvider implements ILabelProvider {
		public Image getImage(Object element) {
			Image result = myWorkbenchLabelProvider.getImage(element);
			return result != null ? result : myAdapterFactoryLabelProvider.getImage(element);
		}

		public String getText(Object element) {
			String result = myWorkbenchLabelProvider.getText(element);
			return result != null && result.length() > 0 ? result : myAdapterFactoryLabelProvider.getText(element);
		}

		public void addListener(ILabelProviderListener listener) {
			myWorkbenchLabelProvider.addListener(listener);
			myAdapterFactoryLabelProvider.addListener(listener);
		}

		public void dispose() {
			myWorkbenchLabelProvider.dispose();
			myAdapterFactoryLabelProvider.dispose();
		}

		public boolean isLabelProperty(Object element, String property) {
			return myWorkbenchLabelProvider.isLabelProperty(element, property) || myAdapterFactoryLabelProvider.isLabelProperty(element, property);
		}

		public void removeListener(ILabelProviderListener listener) {
			myWorkbenchLabelProvider.removeListener(listener);
			myAdapterFactoryLabelProvider.removeListener(listener);
		}

		private WorkbenchLabelProvider myWorkbenchLabelProvider = new WorkbenchLabelProvider();
		private AdapterFactoryLabelProvider myAdapterFactoryLabelProvider = new AdapterFactoryLabelProvider(UMLDiagramEditorPlugin.getInstance().getItemProvidersAdapterFactory());
	}

	private class ModelFilesFilter extends ViewerFilter {
		@Override
		public boolean select(Viewer viewer, Object parentElement, Object element) {
			if (element instanceof IContainer) {
				return true;
			}
			if (element instanceof IFile) {
				IFile file = (IFile) element;
				return isValidModelFile(file);
			}
			return true;
		}
	}
}
