package org.eclipse.uml2.diagram.clazz.action;

import java.util.HashMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.gmf.runtime.common.core.service.IProvider;
import org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.AbstractContributionItemProvider;
import org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.uml2.diagram.clazz.part.CustomMessages;
import org.eclipse.uml2.uml.UMLPackage;

public class DependencyContributionItemProvider extends AbstractContributionItemProvider implements IProvider {
	public static final String ACTION_CHANGE_DEPENDENCY_TYPE_USAGE = "change_dependency_type_usage"; //$NON-NLS-1$
	public static final String ACTION_CHANGE_DEPENDENCY_TYPE_ABSTRACTION = "change_dependency_type_abstraction"; //$NON-NLS-1$
	public static final String ACTION_CHANGE_DEPENDENCY_TYPE_DEPENDENCY = "change_dependency_type_dependency"; //$NON-NLS-1$
	public static final String ACTION_CHANGE_DEPENDENCY_TYPE_SUBSTITUTION = "change_dependency_type_substitution"; //$NON-NLS-1$	
	public static final String MENU_DEPENDENCY = "DependencyTypeMenu"; //$NON-NLS-1$
	public static final String LABEL_DEPENDENCY = CustomMessages.DependencyContributionItemProvider_dependency_type_action_label;
	public static final String MENU_DEPENDENCY_GROUP = "DependencyTypeGroup"; //$NON-NLS-1$
	public static final String LABEL_DEPENDENCY_GROUP = CustomMessages.DependencyContributionItemProvider_dependency_type_group_label;
	
	protected IAction createAction(String actionId, IWorkbenchPartDescriptor partDescriptor) {
		IWorkbenchPage workbenchPage = partDescriptor.getPartPage();
		EClass eclass = getIdToEClassTable().get(actionId);
		if (eclass != null) {
			return new ChangeDependencyType(workbenchPage, eclass, actionId);
		}
		return super.createAction(actionId, partDescriptor);
	}

	protected IMenuManager createMenuManager(String menuId, IWorkbenchPartDescriptor partDescriptor) {
		if (menuId.equals(MENU_DEPENDENCY_GROUP))
			return new MenuManager(LABEL_DEPENDENCY_GROUP, MENU_DEPENDENCY_GROUP);
		if (menuId.equals(MENU_DEPENDENCY))
			return new MenuManager(LABEL_DEPENDENCY, MENU_DEPENDENCY);
		return super.createMenuManager(menuId, partDescriptor);
	}

	private HashMap<String, EClass> idToEClass;

	private HashMap<String, EClass> getIdToEClassTable() {
		if (idToEClass == null) {
			initIdToEClassTable();
		}
		return idToEClass;
	}

	private void initIdToEClassTable() {
		idToEClass = new HashMap<String, EClass>();
		idToEClass.put(ACTION_CHANGE_DEPENDENCY_TYPE_ABSTRACTION, UMLPackage.eINSTANCE.getAbstraction());
		idToEClass.put(ACTION_CHANGE_DEPENDENCY_TYPE_DEPENDENCY, UMLPackage.eINSTANCE.getDependency());
		idToEClass.put(ACTION_CHANGE_DEPENDENCY_TYPE_SUBSTITUTION, UMLPackage.eINSTANCE.getSubstitution());
		idToEClass.put(ACTION_CHANGE_DEPENDENCY_TYPE_USAGE, UMLPackage.eINSTANCE.getUsage());
	}

}
