package org.eclipse.uml2.diagram.deploy.preferences;

import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.uml2.diagram.common.preferences.UMLPreferencesConstants;
import org.eclipse.uml2.diagram.deploy.edit.parts.Artifact3EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.ArtifactFileName2EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.ArtifactFileName3EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.ArtifactFileNameEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.CommentBodyEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.DeploymentSpecificationName2EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.DeploymentSpecificationNameEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.DeviceName2EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.DeviceNameEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.ElementImportEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.ExecutionEnvironmentName2EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.ExecutionEnvironmentNameEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.NodeName2EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.NodeNameEditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.PackageStereo2EditPart;
import org.eclipse.uml2.diagram.deploy.edit.parts.PropertyEditPart;

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
			case ArtifactFileNameEditPart.VISUAL_ID:
			case ArtifactFileName2EditPart.VISUAL_ID:
			case ArtifactFileName3EditPart.VISUAL_ID:
			case Artifact3EditPart.VISUAL_ID:
				return store.getBoolean(UMLPreferencesConstants.PREF_ICONS_SHOW_VISUAL_ID_PREFIX + ".5005.5007.5011.3006");
			case CommentBodyEditPart.VISUAL_ID:
				return store.getBoolean(UMLPreferencesConstants.PREF_ICONS_SHOW_VISUAL_ID_PREFIX + ".5024");
			case DeploymentSpecificationNameEditPart.VISUAL_ID:
			case DeploymentSpecificationName2EditPart.VISUAL_ID:
				return store.getBoolean(UMLPreferencesConstants.PREF_ICONS_SHOW_VISUAL_ID_PREFIX + ".5006.5012");
			case DeviceNameEditPart.VISUAL_ID:
			case DeviceName2EditPart.VISUAL_ID:
				return store.getBoolean(UMLPreferencesConstants.PREF_ICONS_SHOW_VISUAL_ID_PREFIX + ".5002.5010");
			case ElementImportEditPart.VISUAL_ID:
				return store.getBoolean(UMLPreferencesConstants.PREF_ICONS_SHOW_VISUAL_ID_PREFIX + ".3001");
			case ExecutionEnvironmentNameEditPart.VISUAL_ID:
			case ExecutionEnvironmentName2EditPart.VISUAL_ID:
				return store.getBoolean(UMLPreferencesConstants.PREF_ICONS_SHOW_VISUAL_ID_PREFIX + ".5004.5008");
			case NodeNameEditPart.VISUAL_ID:
			case NodeName2EditPart.VISUAL_ID:
				return store.getBoolean(UMLPreferencesConstants.PREF_ICONS_SHOW_VISUAL_ID_PREFIX + ".5003.5009");
			case PackageStereo2EditPart.VISUAL_ID:
				return store.getBoolean(UMLPreferencesConstants.PREF_ICONS_SHOW_VISUAL_ID_PREFIX + ".5025");
			case PropertyEditPart.VISUAL_ID:
				return store.getBoolean(UMLPreferencesConstants.PREF_ICONS_SHOW_VISUAL_ID_PREFIX + ".3003");
			default:
				return false;
			}
		}
		return false;
	}

}
