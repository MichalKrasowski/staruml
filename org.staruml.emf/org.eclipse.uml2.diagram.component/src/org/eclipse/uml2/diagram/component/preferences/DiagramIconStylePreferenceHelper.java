package org.eclipse.uml2.diagram.component.preferences;

import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.uml2.diagram.common.preferences.UMLPreferencesConstants;
import org.eclipse.uml2.diagram.component.edit.parts.ArtifactName2EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ArtifactName3EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ArtifactNameEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.Class3EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ClassDiagramNotationClassNameEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ClassDiagramNotationInnerClassEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ClassDiagramNotationOperationEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ClassDiagramNotationPropertyEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.CommentBodyEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.Component3EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ComponentName2EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ComponentNameEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.ElementImportEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.Package4EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.PackageName2EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.PackageStereo2EditPart;
import org.eclipse.uml2.diagram.component.edit.parts.PropertyNameEditPart;

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
			case ArtifactName2EditPart.VISUAL_ID:
			case ArtifactNameEditPart.VISUAL_ID:
			case ArtifactName3EditPart.VISUAL_ID:
				return store.getBoolean(UMLPreferencesConstants.PREF_ICONS_SHOW_VISUAL_ID_PREFIX + ".5004.5006.5016");
			case ClassDiagramNotationClassNameEditPart.VISUAL_ID:
			case Class3EditPart.VISUAL_ID:
			case ClassDiagramNotationInnerClassEditPart.VISUAL_ID:
				return store.getBoolean(UMLPreferencesConstants.PREF_ICONS_SHOW_VISUAL_ID_PREFIX + ".5014.3009.3013");
			case CommentBodyEditPart.VISUAL_ID:
				return store.getBoolean(UMLPreferencesConstants.PREF_ICONS_SHOW_VISUAL_ID_PREFIX + ".5022");
			case ComponentName2EditPart.VISUAL_ID:
			case ComponentNameEditPart.VISUAL_ID:
			case Component3EditPart.VISUAL_ID:
				return store.getBoolean(UMLPreferencesConstants.PREF_ICONS_SHOW_VISUAL_ID_PREFIX + ".5001.5002.3010");
			case ElementImportEditPart.VISUAL_ID:
				return store.getBoolean(UMLPreferencesConstants.PREF_ICONS_SHOW_VISUAL_ID_PREFIX + ".3007");
			case ClassDiagramNotationOperationEditPart.VISUAL_ID:
				return store.getBoolean(UMLPreferencesConstants.PREF_ICONS_SHOW_VISUAL_ID_PREFIX + ".3012");
			case PackageStereo2EditPart.VISUAL_ID:
			case PackageName2EditPart.VISUAL_ID:
			case Package4EditPart.VISUAL_ID:
				return store.getBoolean(UMLPreferencesConstants.PREF_ICONS_SHOW_VISUAL_ID_PREFIX + ".5023.5012.3008");
			case PropertyNameEditPart.VISUAL_ID:
			case ClassDiagramNotationPropertyEditPart.VISUAL_ID:
				return store.getBoolean(UMLPreferencesConstants.PREF_ICONS_SHOW_VISUAL_ID_PREFIX + ".5010.3011");
			default:
				return false;
			}
		}
		return false;
	}

}
