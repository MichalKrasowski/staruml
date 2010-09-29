package org.eclipse.uml2.diagram.csd.preferences;

import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.uml2.diagram.common.preferences.UMLPreferencesConstants;
import org.eclipse.uml2.diagram.csd.edit.parts.ClassName2EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.ClassNameEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.CollaborationNameEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.CollaborationUseName2EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.CommentBodyEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.ElementImportEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.InstanceSpecificationNameEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.OperationEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.PackageStereo2EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.PortIsBehavior2EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.PortIsBehaviorEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.Property2EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.PropertyName2EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.PropertyNameEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.SlotEditPart;

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
			case ClassNameEditPart.VISUAL_ID:
			case ClassName2EditPart.VISUAL_ID:
				return store.getBoolean(UMLPreferencesConstants.PREF_ICONS_SHOW_VISUAL_ID_PREFIX + ".5013.5018");
			case CollaborationNameEditPart.VISUAL_ID:
				return store.getBoolean(UMLPreferencesConstants.PREF_ICONS_SHOW_VISUAL_ID_PREFIX + ".5009");
			case CollaborationUseName2EditPart.VISUAL_ID:
				return store.getBoolean(UMLPreferencesConstants.PREF_ICONS_SHOW_VISUAL_ID_PREFIX + ".5002");
			case CommentBodyEditPart.VISUAL_ID:
				return store.getBoolean(UMLPreferencesConstants.PREF_ICONS_SHOW_VISUAL_ID_PREFIX + ".5032");
			case ElementImportEditPart.VISUAL_ID:
				return store.getBoolean(UMLPreferencesConstants.PREF_ICONS_SHOW_VISUAL_ID_PREFIX + ".3004");
			case InstanceSpecificationNameEditPart.VISUAL_ID:
				return store.getBoolean(UMLPreferencesConstants.PREF_ICONS_SHOW_VISUAL_ID_PREFIX + ".5022");
			case OperationEditPart.VISUAL_ID:
				return store.getBoolean(UMLPreferencesConstants.PREF_ICONS_SHOW_VISUAL_ID_PREFIX + ".3009");
			case PackageStereo2EditPart.VISUAL_ID:
				return store.getBoolean(UMLPreferencesConstants.PREF_ICONS_SHOW_VISUAL_ID_PREFIX + ".5033");
			case PortIsBehaviorEditPart.VISUAL_ID:
			case PortIsBehavior2EditPart.VISUAL_ID:
				return store.getBoolean(UMLPreferencesConstants.PREF_ICONS_SHOW_VISUAL_ID_PREFIX + ".5026.5028");
			case PropertyNameEditPart.VISUAL_ID:
			case PropertyName2EditPart.VISUAL_ID:
			case Property2EditPart.VISUAL_ID:
				return store.getBoolean(UMLPreferencesConstants.PREF_ICONS_SHOW_VISUAL_ID_PREFIX + ".5011.5017.3008");
			case SlotEditPart.VISUAL_ID:
				return store.getBoolean(UMLPreferencesConstants.PREF_ICONS_SHOW_VISUAL_ID_PREFIX + ".3015");
			default:
				return false;
			}
		}
		return false;
	}

}
