package org.eclipse.uml2.diagram.activity.preferences;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.gmf.runtime.diagram.ui.preferences.AppearancePreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.swt.graphics.Color;
import org.eclipse.uml2.diagram.activity.part.UMLDiagramEditorPlugin;
import org.eclipse.uml2.diagram.common.preferences.UMLPreferencesConstants;

/**
 * @generated
 */

public class DiagramAppearancePreferencePage extends AppearancePreferencePage {

	/**
	 * @NOT-generated
	 */
	private static final Color HIGHLIGHT_COLOR = ColorConstants.red;

	/**
	 * @generated
	 */
	public DiagramAppearancePreferencePage() {
		setPreferenceStore(UMLDiagramEditorPlugin.getInstance().getPreferenceStore());
	}

	/**
	 * @NOT-generated
	 */
	public static void initDefaults(IPreferenceStore store) {
		AppearancePreferencePage.initDefaults(store);
		PreferenceConverter.setDefault(store, UMLPreferencesConstants.HIGHLIGHT_COLOR, HIGHLIGHT_COLOR.getRGB());
	}
}
