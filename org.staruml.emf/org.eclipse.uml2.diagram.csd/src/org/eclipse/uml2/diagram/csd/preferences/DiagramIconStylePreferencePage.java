package org.eclipse.uml2.diagram.csd.preferences;

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
import org.eclipse.uml2.diagram.csd.edit.parts.AssociationInstanceSourceEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.AssociationInstanceTargetEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.AssociationName2EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.AssociationName3EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.AssociationName4EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.AssociationName5EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.AssociationName6EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.AssociationName7EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.AssociationNameEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.ConnectorName2EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.ConnectorName3EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.ConnectorName4EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.ConnectorName5EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.ConnectorName6EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.ConnectorName7EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.ConnectorNameEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.DependencyNameEditPart;
import org.eclipse.uml2.diagram.csd.part.Messages;
import org.eclipse.uml2.diagram.csd.part.UMLDiagramEditor;
import org.eclipse.uml2.diagram.csd.part.UMLDiagramEditorPlugin;
import org.eclipse.uml2.diagram.csd.providers.UMLElementTypes;

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
		ourConnectorLabels2Vids.put(Messages.DiagramIconStylePreferencePage_LinkLabelsFilter_ConnectorName_6009, ConnectorNameEditPart.VISUAL_ID);
		ourConnectorLabels2Vids.put(Messages.DiagramIconStylePreferencePage_LinkLabelsFilter_ConnectorName_6010, ConnectorName2EditPart.VISUAL_ID);
		ourConnectorLabels2Vids.put(Messages.DiagramIconStylePreferencePage_LinkLabelsFilter_ConnectorName_6011, ConnectorName3EditPart.VISUAL_ID);
		ourConnectorLabels2Vids.put(Messages.DiagramIconStylePreferencePage_LinkLabelsFilter_ConnectorName_6012, ConnectorName4EditPart.VISUAL_ID);
		ourConnectorLabels2Vids.put(Messages.DiagramIconStylePreferencePage_LinkLabelsFilter_ConnectorName_6013, ConnectorName5EditPart.VISUAL_ID);
		ourConnectorLabels2Vids.put(Messages.DiagramIconStylePreferencePage_LinkLabelsFilter_ConnectorName_6014, ConnectorName6EditPart.VISUAL_ID);
		ourConnectorLabels2Vids.put(Messages.DiagramIconStylePreferencePage_LinkLabelsFilter_ConnectorName_6015, ConnectorName7EditPart.VISUAL_ID);
		ourConnectorLabels2Vids.put(Messages.DiagramIconStylePreferencePage_LinkLabelsFilter_DependencyName_6001, DependencyNameEditPart.VISUAL_ID);
		ourConnectorLabels2Vids.put(Messages.DiagramIconStylePreferencePage_LinkLabelsFilter_AssociationName_6002, AssociationNameEditPart.VISUAL_ID);
		ourConnectorLabels2Vids.put(Messages.DiagramIconStylePreferencePage_LinkLabelsFilter_AssociationName_6003, AssociationName2EditPart.VISUAL_ID);
		ourConnectorLabels2Vids.put(Messages.DiagramIconStylePreferencePage_LinkLabelsFilter_AssociationName_6004, AssociationName3EditPart.VISUAL_ID);
		ourConnectorLabels2Vids.put(Messages.DiagramIconStylePreferencePage_LinkLabelsFilter_AssociationName_6005, AssociationName4EditPart.VISUAL_ID);
		ourConnectorLabels2Vids.put(Messages.DiagramIconStylePreferencePage_LinkLabelsFilter_AssociationName_6006, AssociationName5EditPart.VISUAL_ID);
		ourConnectorLabels2Vids.put(Messages.DiagramIconStylePreferencePage_LinkLabelsFilter_AssociationName_6007, AssociationName6EditPart.VISUAL_ID);
		ourConnectorLabels2Vids.put(Messages.DiagramIconStylePreferencePage_LinkLabelsFilter_AssociationName_6008, AssociationName7EditPart.VISUAL_ID);
		ourConnectorLabels2Vids.put(Messages.DiagramIconStylePreferencePage_LinkLabelsFilter_SlotLabel_6016, AssociationInstanceSourceEditPart.VISUAL_ID);
		ourConnectorLabels2Vids.put(Messages.DiagramIconStylePreferencePage_LinkLabelsFilter_SlotLabel_6017, AssociationInstanceTargetEditPart.VISUAL_ID);
	}

	/**
	 * @generated
	 */
	public static void initConnectorLabelDefaults(IPreferenceStore store) {
		for (Integer visualId : ourConnectorLabels2Vids.values()) {
			store.setDefault(org.eclipse.uml2.diagram.csd.preferences.DiagramIconStylePreferencePage.getConnectionLabelPreference(visualId), true);
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
		addCheckBoxForVisualIds(parent, Messages.DiagramIconStylePreferencePage_label_for_Class, 5013, 5018);
		addCheckBoxForVisualIds(parent, Messages.DiagramIconStylePreferencePage_label_for_Collaboration, 5009);
		addCheckBoxForVisualIds(parent, Messages.DiagramIconStylePreferencePage_label_for_CollaborationUse, 5002);
		addCheckBoxForVisualIds(parent, Messages.DiagramIconStylePreferencePage_label_for_Comment, 5032);
		addCheckBoxForVisualIds(parent, Messages.DiagramIconStylePreferencePage_label_for_ElementImport, 3004);
		addCheckBoxForVisualIds(parent, Messages.DiagramIconStylePreferencePage_label_for_InstanceSpecification, 5022);
		addCheckBoxForVisualIds(parent, Messages.DiagramIconStylePreferencePage_label_for_Operation, 3009);
		addCheckBoxForVisualIds(parent, Messages.DiagramIconStylePreferencePage_label_for_Package, 5033);
		addCheckBoxForVisualIds(parent, Messages.DiagramIconStylePreferencePage_label_for_Port, 5026, 5028);
		addCheckBoxForVisualIds(parent, Messages.DiagramIconStylePreferencePage_label_for_Property, 5011, 5017, 3008);
		addCheckBoxForVisualIds(parent, Messages.DiagramIconStylePreferencePage_label_for_Slot, 3015);

	}

	/**
	 * @generated
	 */
	private Composite createShowHideConnectorIconsGroup(Composite parent) {
		IconStylePreferencePage.ShowHideConnectorLabelGroup builder = new IconStylePreferencePage.ShowHideConnectorLabelGroup();
		return builder.createShowHideConnectorLabelGroup(parent, ourConnectorLabels2Vids);
	}

}
