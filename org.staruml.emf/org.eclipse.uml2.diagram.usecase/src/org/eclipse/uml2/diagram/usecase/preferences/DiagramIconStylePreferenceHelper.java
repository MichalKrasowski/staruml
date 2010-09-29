package org.eclipse.uml2.diagram.usecase.preferences;

import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.uml2.diagram.common.preferences.UMLPreferencesConstants;
import org.eclipse.uml2.diagram.usecase.edit.parts.CommentBodyEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.ElementImportEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.ExtensionPoint2EditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.ExtensionPointEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.PackageStereo2EditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.UseCaseName2EditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.UseCaseName3EditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.UseCaseName4EditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.UseCaseNameEditPart;

/**
 * @generated
 */

public class DiagramIconStylePreferenceHelper {

	/**
	 * @generated
	 */
	public static boolean shouldShowStereotypeIcon(PreferencesHint hint) {
		IPreferenceStore store = (IPreferenceStore) hint.getPreferenceStore();
		return store.getBoolean(UMLPreferencesConstants.PREF_ICONS_SHOW_STEREOTYPE_ICON_MODE);
	}

	/**
	 * @generated
	 */
	public static boolean shouldShowMetaclassIcon(int visualId, PreferencesHint hint) {
		boolean preferencesValue = getPreferencesValueFor(visualId, hint);
		return preferencesValue;
	}

	/**
	 * @generated
	 */
	public static boolean shouldShowLabel(int visualId, PreferencesHint hint) {
		return ((IPreferenceStore) hint.getPreferenceStore()).getBoolean(DiagramIconStylePreferencePage.getConnectionLabelPreference(visualId));
	}

	public static boolean shouldShowIcon(int visualId, PreferencesHint hint) {
		boolean preferencesValue = getPreferencesValueFor(visualId, hint);
		return preferencesValue;
	}

	/**
	 * @generated
	 */
	private static boolean getPreferencesValueFor(int visualId, PreferencesHint hint) {
		IPreferenceStore store = (IPreferenceStore) hint.getPreferenceStore();
		String mode = store.getString(UMLPreferencesConstants.PREF_ICONS_SHOW_HIDE_MODE);
		if (UMLPreferencesConstants.VALUE_ICONS_SHOW_ALL.equals(mode)) {
			return true;
		}
		if (UMLPreferencesConstants.VALUE_ICONS_HIDE_ALL.equals(mode)) {
			return false;
		}
		if (UMLPreferencesConstants.VALUE_ICONS_SHOW_SELECTED_VISUAL_IDS.equals(mode)) {
			switch (visualId) {
			case CommentBodyEditPart.VISUAL_ID:
				return store.getBoolean(UMLPreferencesConstants.PREF_ICONS_SHOW_VISUAL_ID_PREFIX + ".5015");
			case ElementImportEditPart.VISUAL_ID:
				return store.getBoolean(UMLPreferencesConstants.PREF_ICONS_SHOW_VISUAL_ID_PREFIX + ".3001");
			case ExtensionPointEditPart.VISUAL_ID:
			case ExtensionPoint2EditPart.VISUAL_ID:
				return store.getBoolean(UMLPreferencesConstants.PREF_ICONS_SHOW_VISUAL_ID_PREFIX + ".3002.3003");
			case PackageStereo2EditPart.VISUAL_ID:
				return store.getBoolean(UMLPreferencesConstants.PREF_ICONS_SHOW_VISUAL_ID_PREFIX + ".5016");
			case UseCaseNameEditPart.VISUAL_ID:
			case UseCaseName2EditPart.VISUAL_ID:
			case UseCaseName3EditPart.VISUAL_ID:
			case UseCaseName4EditPart.VISUAL_ID:
				return store.getBoolean(UMLPreferencesConstants.PREF_ICONS_SHOW_VISUAL_ID_PREFIX + ".5003.5004.5006.5010");
			default:
				return false;
			}
		}
		return false;
	}

}
