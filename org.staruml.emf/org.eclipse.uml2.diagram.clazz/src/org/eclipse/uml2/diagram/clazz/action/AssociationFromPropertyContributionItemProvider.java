package org.eclipse.uml2.diagram.clazz.action;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gmf.runtime.common.core.service.IProvider;
import org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.AbstractContributionItemProvider;
import org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.uml2.diagram.clazz.part.CustomMessages;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Property;

public class AssociationFromPropertyContributionItemProvider extends AbstractContributionItemProvider implements IProvider {
	public static final String ACTION_CREATE_ASSOSIATION = "create_association_from_property"; //$NON-NLS-1$
	public static final String MENU_CREATE_ASSOSIATION = "menu_create_association_from_property"; //$NON-NLS-1$
	
	protected IAction createAction(String actionId, IWorkbenchPartDescriptor partDescriptor) {
		IWorkbenchPage workbenchPage = partDescriptor.getPartPage();
		if (actionId.startsWith(ACTION_CREATE_ASSOSIATION)) {
			return new CreateAssociationFromProperty(workbenchPage);
		}
		return super.createAction(actionId, partDescriptor);
	}

	@Override
	protected IMenuManager createMenuManager(String menuId, IWorkbenchPartDescriptor partDescriptor) {
		if (!MENU_CREATE_ASSOSIATION.equals(menuId)) {
			return super.createMenuManager(menuId, partDescriptor);
		}
		MenuManager menuManager = new MenuManager(CustomMessages.AssociationFromPropertyContributionItemProvider_create_association_action);
		MenuBuilder builder = new MenuBuilder(partDescriptor);
		//XXX: build initial content -- otherwise menu is never shown
		builder.buildMenu(menuManager);

		menuManager.addMenuListener(builder);
		return menuManager;
	}

	private class MenuBuilder implements IMenuListener {
		private final IWorkbenchPartDescriptor myWorkbenchPart;

		public MenuBuilder(IWorkbenchPartDescriptor workbenchPart){
			myWorkbenchPart = workbenchPart;
		}
		
		public void menuAboutToShow(IMenuManager manager) {
			buildMenu(manager);
		}
		
		public void buildMenu(IMenuManager manager) {
			manager.removeAll();
			GraphicalEditPart selected = (GraphicalEditPart) getSelectedObject(myWorkbenchPart);
			Property property = (Property) selected.getNotationView().getElement();
			if (property.getType() == null){
				return;
			}
			List<Property> conjugatedProperties = getConjugatedProperties(property);
			//default action is cached
			IAction defaultAction = getAction(ACTION_CREATE_ASSOSIATION, myWorkbenchPart);
			manager.add(defaultAction);
			if (!conjugatedProperties.isEmpty()) {
				manager.add(new Separator());
				for (Property nextProperty : conjugatedProperties) {
					//no much sense to cache dynamic target specific actions
					CreateAssociationFromProperty action = new CreateAssociationFromProperty(getWorkbenchPage(), nextProperty);
					action.init();
					manager.add(action);
				}
			}
		}

		private List<Property> getConjugatedProperties(Property source) {
			ArrayList<Property> result = new ArrayList<Property>();
			Classifier sourceType = (Classifier) source.getType();
			for (Property property : sourceType.getAttributes()){
				if (property.getAssociation() != null){
					continue;
				}
				if (source.getClass_().equals(property.getType())) {
					// source and target ends of association should differ
					if (!source.equals(property)) {
						result.add(property);	
					}
				}
			}
			return result;
		}
		
		private IWorkbenchPage getWorkbenchPage(){
			return myWorkbenchPart.getPartPage();
		}
	}
}
