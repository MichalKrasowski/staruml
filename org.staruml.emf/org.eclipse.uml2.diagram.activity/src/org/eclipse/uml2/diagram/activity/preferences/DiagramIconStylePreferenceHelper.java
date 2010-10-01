package org.eclipse.uml2.diagram.activity.preferences;

import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.uml2.diagram.activity.edit.parts.ActivityNameEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ActivityParameterNodeNameEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ActivityPartition_AddStructuralFeatureValueActionNameEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ActivityPartition_CallBehaviorActionNameEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ActivityPartition_CallOperationActionNameEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ActivityPartition_CentralBufferNodeNameEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ActivityPartition_ConditionalNodeNameEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ActivityPartition_CreateObjectActionNameEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ActivityPartition_DataStoreNodeNameEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ActivityPartition_LoopNodeNameEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ActivityPartition_OpaqueActionNameEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ActivityPartition_PinNameEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ActivityPartition_StructuredActivityNodeNameEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ActivityPartition_StructuredActivityNode_StructuredActivityNodeStereotypeEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ActivityPartition_ValueSpecificationActionNameEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.AddStructuralFeatureValueActionNameEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.CallBehaviorActionNameEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.CallOperationActionNameEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.CentralBufferNodeNameEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ConditionalNodeNameEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.CreateObjectActionNameEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.DataStoreNodeNameEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.LocalPostcondition_LiteralStringEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.LocalPrecondition_LiteralStringEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.LoopNodeNameEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.OpaqueActionNameEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.PinNameEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.StructuredActivityNodeNameEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.StructuredActivityNode_AddStructuralFeatureValueActionNameEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.StructuredActivityNode_CallBehaviorActionNameEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.StructuredActivityNode_CallOperationActionNameEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.StructuredActivityNode_CentralBufferNodeNameEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.StructuredActivityNode_ConditionalNodeNameEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.StructuredActivityNode_CreateObjectActionNameEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.StructuredActivityNode_DataStoreNodeNameEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.StructuredActivityNode_InputPinNameEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.StructuredActivityNode_OpaqueActionNameEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.StructuredActivityNode_OutputPinNameEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.StructuredActivityNode_PinNameEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.StructuredActivityNode_StructuredActivityNodeNameEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.StructuredActivityNode_StructuredActivityNode_InputPinNameEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.StructuredActivityNode_StructuredActivityNode_OutputPinNameEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ValueSpecificationActionNameEditPart;
import org.eclipse.uml2.diagram.common.preferences.UMLPreferencesConstants;

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
			case ActivityNameEditPart.VISUAL_ID:
				return store.getBoolean(UMLPreferencesConstants.PREF_ICONS_SHOW_VISUAL_ID_PREFIX + ".5030");
			case ActivityParameterNodeNameEditPart.VISUAL_ID:
				return store.getBoolean(UMLPreferencesConstants.PREF_ICONS_SHOW_VISUAL_ID_PREFIX + ".5031");
			case AddStructuralFeatureValueActionNameEditPart.VISUAL_ID:
			case StructuredActivityNode_AddStructuralFeatureValueActionNameEditPart.VISUAL_ID:
			case ActivityPartition_AddStructuralFeatureValueActionNameEditPart.VISUAL_ID:
				return store.getBoolean(UMLPreferencesConstants.PREF_ICONS_SHOW_VISUAL_ID_PREFIX + ".5026.5020.5077");
			case CallBehaviorActionNameEditPart.VISUAL_ID:
			case StructuredActivityNode_CallBehaviorActionNameEditPart.VISUAL_ID:
			case ActivityPartition_CallBehaviorActionNameEditPart.VISUAL_ID:
				return store.getBoolean(UMLPreferencesConstants.PREF_ICONS_SHOW_VISUAL_ID_PREFIX + ".5027.5018.5078");
			case CallOperationActionNameEditPart.VISUAL_ID:
			case StructuredActivityNode_CallOperationActionNameEditPart.VISUAL_ID:
			case ActivityPartition_CallOperationActionNameEditPart.VISUAL_ID:
				return store.getBoolean(UMLPreferencesConstants.PREF_ICONS_SHOW_VISUAL_ID_PREFIX + ".5028.5019.5079");
			case CentralBufferNodeNameEditPart.VISUAL_ID:
			case StructuredActivityNode_CentralBufferNodeNameEditPart.VISUAL_ID:
			case ActivityPartition_CentralBufferNodeNameEditPart.VISUAL_ID:
				return store.getBoolean(UMLPreferencesConstants.PREF_ICONS_SHOW_VISUAL_ID_PREFIX + ".5032.5033.5070");
			case StructuredActivityNode_ConditionalNodeNameEditPart.VISUAL_ID:
			case ActivityPartition_ConditionalNodeNameEditPart.VISUAL_ID:
			case ConditionalNodeNameEditPart.VISUAL_ID:
				return store.getBoolean(UMLPreferencesConstants.PREF_ICONS_SHOW_VISUAL_ID_PREFIX + ".5147.5115.5092");
			case CreateObjectActionNameEditPart.VISUAL_ID:
			case StructuredActivityNode_CreateObjectActionNameEditPart.VISUAL_ID:
			case ActivityPartition_CreateObjectActionNameEditPart.VISUAL_ID:
				return store.getBoolean(UMLPreferencesConstants.PREF_ICONS_SHOW_VISUAL_ID_PREFIX + ".5025.5017.5076");
			case DataStoreNodeNameEditPart.VISUAL_ID:
			case StructuredActivityNode_DataStoreNodeNameEditPart.VISUAL_ID:
			case ActivityPartition_DataStoreNodeNameEditPart.VISUAL_ID:
				return store.getBoolean(UMLPreferencesConstants.PREF_ICONS_SHOW_VISUAL_ID_PREFIX + ".5034.5035.5067");
			case StructuredActivityNode_InputPinNameEditPart.VISUAL_ID:
			case StructuredActivityNode_StructuredActivityNode_InputPinNameEditPart.VISUAL_ID:
				return store.getBoolean(UMLPreferencesConstants.PREF_ICONS_SHOW_VISUAL_ID_PREFIX + ".5047.5081");
			case LocalPrecondition_LiteralStringEditPart.VISUAL_ID:
			case LocalPostcondition_LiteralStringEditPart.VISUAL_ID:
				return store.getBoolean(UMLPreferencesConstants.PREF_ICONS_SHOW_VISUAL_ID_PREFIX + ".3049.3051");
			case ActivityPartition_LoopNodeNameEditPart.VISUAL_ID:
			case LoopNodeNameEditPart.VISUAL_ID:
				return store.getBoolean(UMLPreferencesConstants.PREF_ICONS_SHOW_VISUAL_ID_PREFIX + ".5117.5091");
			case OpaqueActionNameEditPart.VISUAL_ID:
			case StructuredActivityNode_OpaqueActionNameEditPart.VISUAL_ID:
			case ActivityPartition_OpaqueActionNameEditPart.VISUAL_ID:
				return store.getBoolean(UMLPreferencesConstants.PREF_ICONS_SHOW_VISUAL_ID_PREFIX + ".5023.5015.5073");
			case StructuredActivityNode_OutputPinNameEditPart.VISUAL_ID:
			case StructuredActivityNode_StructuredActivityNode_OutputPinNameEditPart.VISUAL_ID:
				return store.getBoolean(UMLPreferencesConstants.PREF_ICONS_SHOW_VISUAL_ID_PREFIX + ".5048.5083");
			case PinNameEditPart.VISUAL_ID:
			case StructuredActivityNode_PinNameEditPart.VISUAL_ID:
			case ActivityPartition_PinNameEditPart.VISUAL_ID:
				return store.getBoolean(UMLPreferencesConstants.PREF_ICONS_SHOW_VISUAL_ID_PREFIX + ".5024.5016.5074");
			case StructuredActivityNodeNameEditPart.VISUAL_ID:
			case StructuredActivityNode_StructuredActivityNodeNameEditPart.VISUAL_ID:
			case ActivityPartition_StructuredActivityNodeNameEditPart.VISUAL_ID:
			case ActivityPartition_StructuredActivityNode_StructuredActivityNodeStereotypeEditPart.VISUAL_ID:
				return store.getBoolean(UMLPreferencesConstants.PREF_ICONS_SHOW_VISUAL_ID_PREFIX + ".5090.5089.5122.5121");
			case ActivityPartition_ValueSpecificationActionNameEditPart.VISUAL_ID:
			case ValueSpecificationActionNameEditPart.VISUAL_ID:
				return store.getBoolean(UMLPreferencesConstants.PREF_ICONS_SHOW_VISUAL_ID_PREFIX + ".5133.5135");
			default:
				return false;
			}
		}
		return false;
	}

}
