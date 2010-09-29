package org.eclipse.uml2.diagram.sequence.preferences;

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
import org.eclipse.uml2.diagram.common.preferences.IconStylePreferencePage;
import org.eclipse.uml2.diagram.common.preferences.UMLPreferencesConstants;
import org.eclipse.uml2.diagram.sequence.edit.parts.MessageNameEditPart;
import org.eclipse.uml2.diagram.sequence.part.Messages;
import org.eclipse.uml2.diagram.sequence.part.UMLDiagramEditor;
import org.eclipse.uml2.diagram.sequence.part.UMLDiagramEditorPlugin;
import org.eclipse.uml2.diagram.sequence.providers.UMLElementTypes;

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
		ourConnectorLabels2Vids.put(Messages.DiagramIconStylePreferencePage_LinkLabelsFilter_MessageName_6001, MessageNameEditPart.VISUAL_ID);
	}

	/**
	 * @generated
	 */
	public static void initConnectorLabelDefaults(IPreferenceStore store) {
		for (Integer visualId : ourConnectorLabels2Vids.values()) {
			store.setDefault(org.eclipse.uml2.diagram.sequence.preferences.DiagramIconStylePreferencePage.getConnectionLabelPreference(visualId), true);
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
		addCheckBoxForVisualIds(parent, Messages.DiagramIconStylePreferencePage_label_for_Interaction, 5002);
		addCheckBoxForVisualIds(parent, Messages.DiagramIconStylePreferencePage_label_for_InteractionUse, 5007);

	}

	/**
	 * @generated
	 */
	private Composite createShowHideConnectorIconsGroup(Composite parent) {
		IconStylePreferencePage.ShowHideConnectorLabelGroup builder = new IconStylePreferencePage.ShowHideConnectorLabelGroup();
		return builder.createShowHideConnectorLabelGroup(parent, ourConnectorLabels2Vids);
	}

}
