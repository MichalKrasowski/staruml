package org.eclipse.uml2.diagram.statemachine.preferences;

import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.uml2.diagram.common.preferences.UMLPreferencesConstants;
import org.eclipse.uml2.diagram.statemachine.edit.parts.CompositeStateNameEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.DoActivityEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.EntryActivityEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.ExitActivityEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.InternalTransitionEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.SimpleStateNameEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.StateMachineNameEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.SubmachineStateNameEditPart;

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
			case EntryActivityEditPart.VISUAL_ID:
			case ExitActivityEditPart.VISUAL_ID:
			case DoActivityEditPart.VISUAL_ID:
				return store.getBoolean(UMLPreferencesConstants.PREF_ICONS_SHOW_VISUAL_ID_PREFIX + ".3019.3020.3021");
			case SimpleStateNameEditPart.VISUAL_ID:
			case CompositeStateNameEditPart.VISUAL_ID:
			case SubmachineStateNameEditPart.VISUAL_ID:
				return store.getBoolean(UMLPreferencesConstants.PREF_ICONS_SHOW_VISUAL_ID_PREFIX + ".5001.5004.5008");
			case StateMachineNameEditPart.VISUAL_ID:
				return store.getBoolean(UMLPreferencesConstants.PREF_ICONS_SHOW_VISUAL_ID_PREFIX + ".5011");
			case InternalTransitionEditPart.VISUAL_ID:
				return store.getBoolean(UMLPreferencesConstants.PREF_ICONS_SHOW_VISUAL_ID_PREFIX + ".3022");
			default:
				return false;
			}
		}
		return false;
	}

}
