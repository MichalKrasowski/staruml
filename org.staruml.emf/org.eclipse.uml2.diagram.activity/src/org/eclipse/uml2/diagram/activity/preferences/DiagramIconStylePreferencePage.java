package org.eclipse.uml2.diagram.activity.preferences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.eclipse.gmf.runtime.common.ui.preferences.CheckBoxFieldEditor;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.RadioGroupFieldEditor;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbench;
import org.eclipse.uml2.diagram.activity.edit.parts.ControlFlowName2EditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ControlFlowName3EditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ControlFlowNameEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ExceptionHandlerLink_fixed_iconEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ObjectFlowName2EditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ObjectFlowName3EditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ObjectFlowNameEditPart;
import org.eclipse.uml2.diagram.activity.part.Messages;
import org.eclipse.uml2.diagram.activity.part.UMLDiagramEditor;
import org.eclipse.uml2.diagram.activity.part.UMLDiagramEditorPlugin;
import org.eclipse.uml2.diagram.activity.providers.UMLElementTypes;
import org.eclipse.uml2.diagram.common.preferences.IconStylePreferencePage;
import org.eclipse.uml2.diagram.common.preferences.UMLPreferencesConstants;

/**
 * @generated
 */

public class DiagramIconStylePreferencePage extends IconStylePreferencePage {

	/**
	 * @generated
	 */
	private static Map<String, Integer> ourConnectorLabels2Vids = new HashMap<String, Integer>();

	/**
	 * @generated
	 */
	static {
		ourConnectorLabels2Vids.put(Messages.DiagramIconStylePreferencePage_LinkLabelsFilter_ControlFlowName_6003, ControlFlowNameEditPart.VISUAL_ID);
		ourConnectorLabels2Vids.put(Messages.DiagramIconStylePreferencePage_LinkLabelsFilter_ControlFlowName_6005, ControlFlowName2EditPart.VISUAL_ID);
		ourConnectorLabels2Vids.put(Messages.DiagramIconStylePreferencePage_LinkLabelsFilter_ControlFlowName_6007, ControlFlowName3EditPart.VISUAL_ID);
		ourConnectorLabels2Vids.put(Messages.DiagramIconStylePreferencePage_LinkLabelsFilter_ObjectFlowName_6004, ObjectFlowNameEditPart.VISUAL_ID);
		ourConnectorLabels2Vids.put(Messages.DiagramIconStylePreferencePage_LinkLabelsFilter_ObjectFlowName_6006, ObjectFlowName2EditPart.VISUAL_ID);
		ourConnectorLabels2Vids.put(Messages.DiagramIconStylePreferencePage_LinkLabelsFilter_ObjectFlowName_6008, ObjectFlowName3EditPart.VISUAL_ID);
		ourConnectorLabels2Vids.put(Messages.DiagramIconStylePreferencePage_LinkLabelsFilter_ExceptionHandlerLabel_6002, ExceptionHandlerLink_fixed_iconEditPart.VISUAL_ID);
	}

	/**
	 * @generated
	 */
	public static void initConnectorLabelDefaults(IPreferenceStore store) {
		for (Integer visualId : ourConnectorLabels2Vids.values()) {
			store.setDefault(org.eclipse.uml2.diagram.activity.preferences.DiagramIconStylePreferencePage.getConnectionLabelPreference(visualId), true);
		}
	}

	/**
	 * @generated
	 */
	private final List<CheckBoxFieldEditor> myByVisualIdEditors = new ArrayList<CheckBoxFieldEditor>();

	/**
	 * @generated
	 */
	private RadioGroupFieldEditor myModeEditor;

	/**
	 * @generated
	 */
	private Composite myCheckBoxesPanel;

	/**
	 * @generated
	 */
	private IWorkbench myWorkbench;

	/**
	 * @generated
	 */
	public DiagramIconStylePreferencePage() {
		setPreferenceStore(UMLDiagramEditorPlugin.getInstance().getPreferenceStore());
	}

	/**
	 * @generated
	 */
	@Override
	public void init(IWorkbench workbench) {
		super.init(workbench);
		myWorkbench = workbench;
	}

	/**
	 * @generated
	 */
	@Override
	public boolean performOk() {
		super.performOk();
		UMLElementTypes.refreshImageRegistry();
		refreshDiagramEditors();
		return true;
	}

	/**
	 * @generated
	 */
	private void refreshDiagramEditors() {
		IEditorReference[] editors = myWorkbench.getActiveWorkbenchWindow().getActivePage().getEditorReferences();
		for (int i = 0; i < editors.length; i++) {
			IEditorPart editor = editors[i].getEditor(false);
			if (editor != null && editor instanceof UMLDiagramEditor) {
				((UMLDiagramEditor) editor).refresh();
			}
		}
	}

	/**
	 * @generated
	 */
	@Override
	protected void initHelp() {
		// TODO Auto-generated method stub
	}

	/**
	 * @generated
	 */
	@Override
	protected void addFields(Composite parent) {
		super.addFields(parent);
		createShowHideIconsGroup(parent);
		createShowHideConnectorIconsGroup(parent);
	}

	/**
	 * @generated
	 */
	protected CheckBoxFieldEditor addCheckBoxForVisualIds(Composite parent, String commonLabel, int... visualIds) {
		StringBuffer propertyName = new StringBuffer(UMLPreferencesConstants.PREF_ICONS_SHOW_VISUAL_ID_PREFIX);
		for (int nextVID : visualIds) {
			propertyName.append('.').append(nextVID);
		}
		CheckBoxFieldEditor result = new CheckBoxFieldEditor(propertyName.toString(), commonLabel, parent);

		addField(result);
		myByVisualIdEditors.add(result);
		return result;
	}

	/**
	 * @generated
	 */
	@Override
	protected void initialize() {
		super.initialize();
		boolean stateShowSelected = UMLPreferencesConstants.VALUE_ICONS_SHOW_SELECTED_VISUAL_IDS.equals(getPreferenceStore().getString(UMLPreferencesConstants.PREF_ICONS_SHOW_HIDE_MODE));
		enableVisualIdChoices(stateShowSelected);
	}

	/**
	 * @generated
	 */
	@Override
	public void propertyChange(PropertyChangeEvent event) {
		super.propertyChange(event);
		if (FieldEditor.VALUE.equals(event.getProperty())) {
			boolean nowConfigurable = UMLPreferencesConstants.VALUE_ICONS_SHOW_SELECTED_VISUAL_IDS.equals(event.getNewValue());
			boolean wasConfigurable = UMLPreferencesConstants.VALUE_ICONS_SHOW_SELECTED_VISUAL_IDS.equals(event.getOldValue());

			if (nowConfigurable || wasConfigurable) {
				enableVisualIdChoices(nowConfigurable);
			}
		}
	}

	/**
	 * @generated
	 */
	private void enableVisualIdChoices(boolean enabled) {
		for (CheckBoxFieldEditor next : myByVisualIdEditors) {
			next.setEnabled(enabled, myCheckBoxesPanel);
		}
	}

	/**
	 * @generated
	 */
	private Composite createShowHideIconsGroup(Composite parent) {
		Composite showHideIconsGroup = new Composite(parent, SWT.NULL);
		showHideIconsGroup.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_FILL));
		GridLayout layout = new GridLayout();
		showHideIconsGroup.setLayout(layout);

		String[][] choices = new String[][] {//
		//
				{ LABEL_HIDE_ALL, UMLPreferencesConstants.VALUE_ICONS_HIDE_ALL }, //
				{ LABEL_SHOW_ALL, UMLPreferencesConstants.VALUE_ICONS_SHOW_ALL }, //
				{ LABEL_SHOW_BY_VISUAL_ID, UMLPreferencesConstants.VALUE_ICONS_SHOW_SELECTED_VISUAL_IDS }, //
		};

		myModeEditor = new RadioGroupFieldEditor(//
				UMLPreferencesConstants.PREF_ICONS_SHOW_HIDE_MODE, //
				LABEL_SHOW_HIDE_MODE, //
				1, choices, showHideIconsGroup, true);

		addField(myModeEditor);

		Composite e = createExpansibleComposite(myModeEditor.getRadioBoxControl(showHideIconsGroup), "Elements");
		myCheckBoxesPanel = new Composite(e, SWT.NULL);
		myCheckBoxesPanel.setLayout(new GridLayout());
		myCheckBoxesPanel.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_FILL));

		addAllCheckBoxes(myCheckBoxesPanel);

		enableVisualIdChoices(false);

		return showHideIconsGroup;
	}

	/**
	 * @generated
	 */
	private void addAllCheckBoxes(Composite parent) {
		addCheckBoxForVisualIds(parent, Messages.DiagramIconStylePreferencePage_label_for_Activity, 5030);
		addCheckBoxForVisualIds(parent, Messages.DiagramIconStylePreferencePage_label_for_ActivityParameterNode, 5031);
		addCheckBoxForVisualIds(parent, Messages.DiagramIconStylePreferencePage_label_for_AddStructuralFeatureValueAction, 5026, 5020, 5077);
		addCheckBoxForVisualIds(parent, Messages.DiagramIconStylePreferencePage_label_for_CallBehaviorAction, 5027, 5018, 5078);
		addCheckBoxForVisualIds(parent, Messages.DiagramIconStylePreferencePage_label_for_CallOperationAction, 5028, 5019, 5079);
		addCheckBoxForVisualIds(parent, Messages.DiagramIconStylePreferencePage_label_for_CentralBufferNode, 5032, 5033, 5070);
		addCheckBoxForVisualIds(parent, Messages.DiagramIconStylePreferencePage_label_for_ConditionalNode, 5147, 5115, 5092);
		addCheckBoxForVisualIds(parent, Messages.DiagramIconStylePreferencePage_label_for_CreateObjectAction, 5025, 5017, 5076);
		addCheckBoxForVisualIds(parent, Messages.DiagramIconStylePreferencePage_label_for_DataStoreNode, 5034, 5035, 5067);
		addCheckBoxForVisualIds(parent, Messages.DiagramIconStylePreferencePage_label_for_InputPin, 5047, 5081);
		addCheckBoxForVisualIds(parent, Messages.DiagramIconStylePreferencePage_label_for_LiteralString, 3049, 3051);
		addCheckBoxForVisualIds(parent, Messages.DiagramIconStylePreferencePage_label_for_LoopNode, 5117, 5091);
		addCheckBoxForVisualIds(parent, Messages.DiagramIconStylePreferencePage_label_for_OpaqueAction, 5023, 5015, 5073);
		addCheckBoxForVisualIds(parent, Messages.DiagramIconStylePreferencePage_label_for_OutputPin, 5048, 5083);
		addCheckBoxForVisualIds(parent, Messages.DiagramIconStylePreferencePage_label_for_Pin, 5024, 5016, 5074);
		addCheckBoxForVisualIds(parent, Messages.DiagramIconStylePreferencePage_label_for_StructuredActivityNode, 5090, 5089, 5122, 5121);
		addCheckBoxForVisualIds(parent, Messages.DiagramIconStylePreferencePage_label_for_ValueSpecificationAction, 5133, 5135);

	}

	/**
	 * @generated
	 */
	private Composite createShowHideConnectorIconsGroup(Composite parent) {
		IconStylePreferencePage.ShowHideConnectorLabelGroup builder = new IconStylePreferencePage.ShowHideConnectorLabelGroup();
		return builder.createShowHideConnectorLabelGroup(parent, ourConnectorLabels2Vids);
	}

}
