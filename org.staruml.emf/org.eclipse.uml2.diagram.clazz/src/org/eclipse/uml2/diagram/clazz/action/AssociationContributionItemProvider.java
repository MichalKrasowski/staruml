package org.eclipse.uml2.diagram.clazz.action;

import java.util.HashMap;

import org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.AbstractContributionItemProvider;
import org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor;
import org.eclipse.gmf.runtime.common.core.service.IProvider;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.uml2.diagram.clazz.part.CustomMessages;
import org.eclipse.uml2.uml.AggregationKind;


public class AssociationContributionItemProvider extends AbstractContributionItemProvider implements IProvider {
	
	@Override
	protected IAction createAction(String actionId, IWorkbenchPartDescriptor partDescriptor) {
		IWorkbenchPage workbenchPage = partDescriptor.getPartPage();
		AggregationKind aggregationKind = getActionIdToAssociationKindTable().get(actionId);
		if (aggregationKind != null) {
			return new ChangeAssociationKind(workbenchPage, aggregationKind);
		}
		return super.createAction(actionId, partDescriptor);
	}

	@Override
	protected IMenuManager createMenuManager(String menuId, IWorkbenchPartDescriptor partDescriptor) {
		if (menuId.equals(MENU_ASSOCIATION_GROUP))
			return new MenuManager(LABEL_ASSOCIATION_GROUP, MENU_ASSOCIATION_GROUP);
		if (menuId.equals(MENU_ASSOCIATION))
			return new MenuManager(LABEL_ASSOCIATION, MENU_ASSOCIATION);
		return super.createMenuManager(menuId, partDescriptor);
	}

	public static final String ACTION_RECTANGLE_INTERFACE_NOTATION = "rectangle_interface_notation"; //$NON-NLS-1$
	
	public static final String MENU_ASSOCIATION = "AssociationTypeMenu";	 //$NON-NLS-1$
	public static final String LABEL_ASSOCIATION = CustomMessages.AssociationContributionItemProvider_association_type_action;
	public static final String MENU_ASSOCIATION_GROUP = "AssociationTypeGroup";	 //$NON-NLS-1$
	public static final String LABEL_ASSOCIATION_GROUP = CustomMessages.AssociationContributionItemProvider_association_type_group;
	
	public static final String ACTION_CHANGE_ASSOCIATION_KIND_NONE = "change_association_type_none"; //$NON-NLS-1$
	public static final String ACTION_CHANGE_ASSOCIATION_KIND_COMPOSITE = "change_association_type_composite"; //$NON-NLS-1$
	public static final String ACTION_CHANGE_ASSOCIATION_KIND_SHARED = "change_association_type_shared"; //$NON-NLS-1$

	private HashMap<String, AggregationKind> actionIdToAssociationKind;
	private HashMap<String, AggregationKind> getActionIdToAssociationKindTable() {
		if (actionIdToAssociationKind == null) {			
			initIdToEClassTable();
		}
		return actionIdToAssociationKind;
	}

	private void initIdToEClassTable() {
		actionIdToAssociationKind = new HashMap<String, AggregationKind>();
		actionIdToAssociationKind.put(ACTION_CHANGE_ASSOCIATION_KIND_NONE, AggregationKind.NONE_LITERAL);
		actionIdToAssociationKind.put(ACTION_CHANGE_ASSOCIATION_KIND_COMPOSITE, AggregationKind.COMPOSITE_LITERAL);
		actionIdToAssociationKind.put(ACTION_CHANGE_ASSOCIATION_KIND_SHARED, AggregationKind.SHARED_LITERAL);
	}

}
