package org.eclipse.uml2.diagram.clazz.preferences;

import org.eclipse.gmf.runtime.diagram.ui.preferences.DiagramsPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.RadioGroupFieldEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.uml2.diagram.clazz.part.CustomMessages;
import org.eclipse.uml2.diagram.clazz.part.UMLDiagramEditorPlugin;
import org.eclipse.uml2.diagram.common.preferences.UMLPreferencesConstants;

/**
 * @generated
 */
public class DiagramGeneralPreferencePage extends DiagramsPreferencePage {

	/**
	 * @generated
	 */
	public DiagramGeneralPreferencePage() {
		setPreferenceStore(UMLDiagramEditorPlugin.getInstance().getPreferenceStore());
	}

	/**
	 * @NOT-generated
	 */
	public static void initNavigationArrowsOptions(IPreferenceStore preferenceStore) {
		preferenceStore.setDefault(UMLPreferencesConstants.NAVIGATION_ARROWS_OPTION, UMLPreferencesConstants.SHOW_ONE_WAY_NAVIGABILITY);
	}

	/**
	 * @NOT-generated
	 */
	@Override
	protected void addFields(Composite parent) {
		super.addFields(parent);
		myNavigationArrowsOptions = new RadioGroupFieldEditor(UMLPreferencesConstants.NAVIGATION_ARROWS_OPTION, CustomMessages.DiagramGeneralPreferencePage_show_arrows_group, 1, new String[][] {
				{ LABEL_NAVIGATION_SHOW_ALL, UMLPreferencesConstants.SHOW_ALL_ARROWS }, { LABEL_NAVIGATION_SUPPRESS_ALL, UMLPreferencesConstants.SUPRESS_ALL_ARROWS },
				{ LABEL_NAVIGATION_SHOW_ONE_WAY, UMLPreferencesConstants.SHOW_ONE_WAY_NAVIGABILITY } }, parent, true);
		addField(myNavigationArrowsOptions);
	}

	private RadioGroupFieldEditor myNavigationArrowsOptions = null;

	private static final String LABEL_NAVIGATION_SHOW_ALL = CustomMessages.DiagramGeneralPreferencePage_show_all_arrowa_and_xs_option;

	private static final String LABEL_NAVIGATION_SUPPRESS_ALL = CustomMessages.DiagramGeneralPreferencePage_suppress_all_arrows_and_xs_option;

	private static final String LABEL_NAVIGATION_SHOW_ONE_WAY = CustomMessages.DiagramGeneralPreferencePage_show_oneway_navigability_option;

}
