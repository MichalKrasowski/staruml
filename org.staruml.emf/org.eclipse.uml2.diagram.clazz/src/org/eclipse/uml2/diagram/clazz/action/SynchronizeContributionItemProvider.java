package org.eclipse.uml2.diagram.clazz.action;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.IProvider;
import org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.AbstractContributionItemProvider;
import org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.uml2.diagram.clazz.part.CustomMessages;
import org.eclipse.uml2.diagram.common.stereo.ApplyStereotypeAction;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

public class SynchronizeContributionItemProvider  extends AbstractContributionItemProvider implements IProvider {
	public static final String MENU_SYNCHRONIZE = "menu_synchronize_selected"; //$NON-NLS-1$
	
	@Override
	protected IMenuManager createMenuManager(String menuId, IWorkbenchPartDescriptor partDescriptor) {
		if (!MENU_SYNCHRONIZE.equals(menuId)) {
			return super.createMenuManager(menuId, partDescriptor);
		}
		MenuManager menuManager = new MenuManager("Synchronize");
		SynchronizeMenuBuilder builder = new SynchronizeMenuBuilder(partDescriptor);
		//XXX: build initial content -- otherwise menu is never shown
		builder.buildMenu(menuManager);

		menuManager.addMenuListener(builder);
		return menuManager;
	}

	private class SynchronizeMenuBuilder implements IMenuListener {
		private final IWorkbenchPartDescriptor myWorkbenchPart;

		public SynchronizeMenuBuilder(IWorkbenchPartDescriptor workbenchPart){
			myWorkbenchPart = workbenchPart;
		}
		
		public void menuAboutToShow(IMenuManager manager) {
			buildMenu(manager);
		}
		
		public void buildMenu(IMenuManager manager) {
			manager.removeAll();
			IGraphicalEditPart selected = (IGraphicalEditPart) getSelectedObject(myWorkbenchPart);
			EObject selectedElement = selected.getNotationView().getElement();
			if (false == selectedElement instanceof Element) {
				return;
			}
			Element element = (Element)selectedElement ;
			EList<Stereotype> stereotypes = element.getApplicableStereotypes();
			for (Stereotype stereotype: stereotypes) {
				ApplyStereotypeAction action = new ApplyStereotypeAction(getWorkbenchPage(), element, stereotype);
				action.init();
				manager.add(action);
			}
		}

		private IWorkbenchPage getWorkbenchPage(){
			return myWorkbenchPart.getPartPage();
		}
	}

}
