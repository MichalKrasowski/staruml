package org.eclipse.uml2.diagram.csd.preferences;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.gmf.runtime.diagram.ui.preferences.AppearancePreferencePage;
import org.eclipse.jface.preference.ColorFieldEditor;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.uml2.diagram.common.preferences.UMLPreferencesConstants;
import org.eclipse.uml2.diagram.csd.part.UMLDiagramEditorPlugin;

/**
 * @generated
 */
public class DiagramAppearancePreferencePage extends AppearancePreferencePage {

	/**
	 * @NOT-generated
	 */
	private static final String HIGHLIGHT_COLOR_LABEL = "Highlight Color";

	/**
	 * @NOT-generated
	 */
	private ColorFieldEditor myHighlightColorEditor;

	/**
	 * @generated
	 */
	public DiagramAppearancePreferencePage() {
		setPreferenceStore(UMLDiagramEditorPlugin.getInstance().getPreferenceStore());
	}

	/**
	 * @NOT-generated
	 */
	@Override
	protected void addFontAndColorFields(Composite composite) {
		super.addFontAndColorFields(composite);
		myHighlightColorEditor = new ColorFieldEditor(UMLPreferencesConstants.HIGHLIGHT_COLOR, HIGHLIGHT_COLOR_LABEL, composite);
		addField(myHighlightColorEditor);
	}

	/**
	 * @NOT-generated
	 */
	public static void initDefaults(IPreferenceStore store) {
		AppearancePreferencePage.initDefaults(store);
		Color highlightColor = ColorConstants.red;
		PreferenceConverter.setDefault(store, UMLPreferencesConstants.HIGHLIGHT_COLOR, highlightColor.getRGB());
	}

}
