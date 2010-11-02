package org.eclipse.uml2.diagram.common.preferences;

import org.eclipse.gmf.runtime.common.ui.preferences.AbstractPreferencePage;
import org.eclipse.gmf.runtime.common.ui.preferences.CheckBoxFieldEditor;
import org.eclipse.gmf.runtime.diagram.ui.preferences.ConnectionsPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.uml2.diagram.common.Messages;
import org.eclipse.uml2.diagram.common.preferences.UMLPreferencesConstants;

public class ViewFiltersPreferencePage extends AbstractPreferencePage {

	private static final String REQUIRED_INTERFACE_LINKS_GROUP_LABEL = Messages.ViewFiltersPreferencePage_group_manage_required_interface;

	private static final String HIDE_DERIVED_LABEL = Messages.ViewFiltersPreferencePage_label_hide_derived;
	
	private static final String HIDE_GENUINE_LABEL = Messages.ViewFiltersPreferencePage_label_hide_genuine;
	
	private CheckBoxFieldEditor myManageRequireds_hideDeriveds;

	private CheckBoxFieldEditor myManageRequireds_hideGenuine;

	@Override
	protected void addFields(Composite parent) {
		Composite composite = createPageLayout(parent);
		createManageRequiredLinksGroup(composite);
	}

	@Override
	protected void initHelp() {
	}
	
	protected Composite createPageLayout(Composite parent) {
		Composite main = new Composite(parent, SWT.NULL);
		main.setLayout(new GridLayout());
		main.setLayoutData(
			new GridData(
				GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_FILL));
		return main;
	}

	private Composite createManageRequiredLinksGroup(Composite parent) {    	
    	Group group = new Group(parent, SWT.NONE);
    	group.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
    	group.setLayout(new GridLayout(3, false));
    	Composite composite = new Composite(group, SWT.NONE);
    	GridLayout gridLayout = new GridLayout(3, false);
    	composite.setLayout(gridLayout);
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalSpan = 3;
		composite.setLayoutData(gridData);
		group.setText(REQUIRED_INTERFACE_LINKS_GROUP_LABEL);
    	
 		addManageRequiredLinksFields(composite);
		
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		layout.marginWidth = 0;
		layout.marginHeight = 0;
		layout.horizontalSpacing = 8;
		composite.setLayout(layout);               
    	
		return group;
	}

	protected void addManageRequiredLinksFields(Composite composite) {
		myManageRequireds_hideDeriveds = new CheckBoxFieldEditor(UMLPreferencesConstants.PREF_MANAGE_REQUIRED_LINKS_HIDE_DERIVED, HIDE_DERIVED_LABEL, composite);
		addField(myManageRequireds_hideDeriveds);
		myManageRequireds_hideGenuine = new CheckBoxFieldEditor(UMLPreferencesConstants.PREF_MANAGE_REQUIRED_LINKS_HIDE_GENUINE, HIDE_GENUINE_LABEL, composite);
		addField(myManageRequireds_hideGenuine);
	}

	public static void initDefaults(IPreferenceStore store) {
		ConnectionsPreferencePage.initDefaults(store);
		store.setDefault(UMLPreferencesConstants.PREF_MANAGE_REQUIRED_LINKS_HIDE_DERIVED, false);
		store.setDefault(UMLPreferencesConstants.PREF_MANAGE_REQUIRED_LINKS_HIDE_GENUINE, false);
	}

}
