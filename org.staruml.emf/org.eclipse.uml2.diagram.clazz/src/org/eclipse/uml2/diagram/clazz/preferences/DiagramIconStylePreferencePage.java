package org.eclipse.uml2.diagram.clazz.preferences;

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
import org.eclipse.uml2.diagram.clazz.edit.parts.AssociationInstanceSourceEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.AssociationInstanceTargetEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.AssociationName2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.AssociationName3EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.AssociationName4EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.AssociationName5EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.AssociationName6EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.AssociationName7EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.AssociationNameEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.AssociationStereotypeEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.DependencyName2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.DependencyName3EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.GeneralizationStereotype2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.GeneralizationStereotypeEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.InterfaceRealizationStereotypeEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.PropertyName2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.PropertyName3EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.PropertyNameEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.RealizationNameEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.RealizationStereotypeEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.TemplateBindingStereotypeEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.TemplateBinding_BindLabelEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.TemplateParameterSubstitutionEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.UsageStereotypeEditPart;
import org.eclipse.uml2.diagram.clazz.part.Messages;
import org.eclipse.uml2.diagram.clazz.part.UMLDiagramEditor;
import org.eclipse.uml2.diagram.clazz.part.UMLDiagramEditorPlugin;
import org.eclipse.uml2.diagram.clazz.providers.UMLElementTypes;
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
		ourConnectorLabels2Vids.put(Messages.DiagramIconStylePreferencePage_LinkLabelsFilter_GeneralizationQualifiedName_6018, GeneralizationStereotypeEditPart.VISUAL_ID);
		ourConnectorLabels2Vids.put(Messages.DiagramIconStylePreferencePage_LinkLabelsFilter_DependencyName_6001, DependencyName2EditPart.VISUAL_ID);
		ourConnectorLabels2Vids.put(Messages.DiagramIconStylePreferencePage_LinkLabelsFilter_DependencyName_6010, DependencyName3EditPart.VISUAL_ID);
		ourConnectorLabels2Vids.put(Messages.DiagramIconStylePreferencePage_LinkLabelsFilter_PropertyName_6002, PropertyNameEditPart.VISUAL_ID);
		ourConnectorLabels2Vids.put(Messages.DiagramIconStylePreferencePage_LinkLabelsFilter_PropertyName_6012, PropertyName2EditPart.VISUAL_ID);
		ourConnectorLabels2Vids.put(Messages.DiagramIconStylePreferencePage_LinkLabelsFilter_PropertyName_6017, PropertyName3EditPart.VISUAL_ID);
		ourConnectorLabels2Vids.put(Messages.DiagramIconStylePreferencePage_LinkLabelsFilter_AssociationName_6003, AssociationNameEditPart.VISUAL_ID);
		ourConnectorLabels2Vids.put(Messages.DiagramIconStylePreferencePage_LinkLabelsFilter_AssociationName_6004, AssociationName2EditPart.VISUAL_ID);
		ourConnectorLabels2Vids.put(Messages.DiagramIconStylePreferencePage_LinkLabelsFilter_AssociationName_6005, AssociationName3EditPart.VISUAL_ID);
		ourConnectorLabels2Vids.put(Messages.DiagramIconStylePreferencePage_LinkLabelsFilter_AssociationName_6006, AssociationName4EditPart.VISUAL_ID);
		ourConnectorLabels2Vids.put(Messages.DiagramIconStylePreferencePage_LinkLabelsFilter_AssociationName_6007, AssociationName5EditPart.VISUAL_ID);
		ourConnectorLabels2Vids.put(Messages.DiagramIconStylePreferencePage_LinkLabelsFilter_AssociationName_6008, AssociationName6EditPart.VISUAL_ID);
		ourConnectorLabels2Vids.put(Messages.DiagramIconStylePreferencePage_LinkLabelsFilter_AssociationName_6009, AssociationName7EditPart.VISUAL_ID);
		ourConnectorLabels2Vids.put(Messages.DiagramIconStylePreferencePage_LinkLabelsFilter_AssociationQualifiedName_6019, AssociationStereotypeEditPart.VISUAL_ID);
		ourConnectorLabels2Vids.put(Messages.DiagramIconStylePreferencePage_LinkLabelsFilter_InterfaceRealizationQualifiedName_6020, InterfaceRealizationStereotypeEditPart.VISUAL_ID);
		ourConnectorLabels2Vids.put(Messages.DiagramIconStylePreferencePage_LinkLabelsFilter_RealizationName_6011, RealizationNameEditPart.VISUAL_ID);
		ourConnectorLabels2Vids.put(Messages.DiagramIconStylePreferencePage_LinkLabelsFilter_RealizationQualifiedName_6021, RealizationStereotypeEditPart.VISUAL_ID);
		ourConnectorLabels2Vids.put(Messages.DiagramIconStylePreferencePage_LinkLabelsFilter_GeneralizationQualifiedName_6022, GeneralizationStereotype2EditPart.VISUAL_ID);
		ourConnectorLabels2Vids.put(Messages.DiagramIconStylePreferencePage_LinkLabelsFilter_UsageQualifiedName_6023, UsageStereotypeEditPart.VISUAL_ID);
		ourConnectorLabels2Vids.put(Messages.DiagramIconStylePreferencePage_LinkLabelsFilter_SlotLabel_6015, AssociationInstanceSourceEditPart.VISUAL_ID);
		ourConnectorLabels2Vids.put(Messages.DiagramIconStylePreferencePage_LinkLabelsFilter_SlotLabel_6016, AssociationInstanceTargetEditPart.VISUAL_ID);
		ourConnectorLabels2Vids.put(Messages.DiagramIconStylePreferencePage_LinkLabelsFilter_TemplateBindingLabel_6013, TemplateBinding_BindLabelEditPart.VISUAL_ID);
		ourConnectorLabels2Vids.put(Messages.DiagramIconStylePreferencePage_LinkLabelsFilter_TemplateBindingLabel_6014, TemplateParameterSubstitutionEditPart.VISUAL_ID);
		ourConnectorLabels2Vids.put(Messages.DiagramIconStylePreferencePage_LinkLabelsFilter_TemplateBindingQualifiedName_6024, TemplateBindingStereotypeEditPart.VISUAL_ID);
	}

	/**
	 * @generated
	 */
	public static void initConnectorLabelDefaults(IPreferenceStore store) {
		for (Integer visualId : ourConnectorLabels2Vids.values()) {
			store.setDefault(org.eclipse.uml2.diagram.clazz.preferences.DiagramIconStylePreferencePage.getConnectionLabelPreference(visualId), true);
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
		addCheckBoxForVisualIds(parent, Messages.DiagramIconStylePreferencePage_label_for_AssociationClass, 5009, 3012);
		addCheckBoxForVisualIds(parent, Messages.DiagramIconStylePreferencePage_label_for_Class, 5003, 5021, 3007, 3003, 3030);
		addCheckBoxForVisualIds(parent, Messages.DiagramIconStylePreferencePage_label_for_Comment, 5030);
		addCheckBoxForVisualIds(parent, Messages.DiagramIconStylePreferencePage_label_for_DataType, 5006, 5027, 3008);
		addCheckBoxForVisualIds(parent, Messages.DiagramIconStylePreferencePage_label_for_Dependency, 5011);
		addCheckBoxForVisualIds(parent, Messages.DiagramIconStylePreferencePage_label_for_ElementImport, 3031);
		addCheckBoxForVisualIds(parent, Messages.DiagramIconStylePreferencePage_label_for_Enumeration, 5005, 5023, 3011);
		addCheckBoxForVisualIds(parent, Messages.DiagramIconStylePreferencePage_label_for_EnumerationLiteral, 3016);
		addCheckBoxForVisualIds(parent, Messages.DiagramIconStylePreferencePage_label_for_Expression, 3040);
		addCheckBoxForVisualIds(parent, Messages.DiagramIconStylePreferencePage_label_for_InstanceSpecification, 5010, 5029, 5024, 3013);
		addCheckBoxForVisualIds(parent, Messages.DiagramIconStylePreferencePage_label_for_Interface, 5018, 3041);
		addCheckBoxForVisualIds(parent, Messages.DiagramIconStylePreferencePage_label_for_LiteralInteger, 3039);
		addCheckBoxForVisualIds(parent, Messages.DiagramIconStylePreferencePage_label_for_LiteralString, 3038);
		addCheckBoxForVisualIds(parent, Messages.DiagramIconStylePreferencePage_label_for_Operation, 3002, 3020, 3015, 3022, 3024, 3029);
		addCheckBoxForVisualIds(parent, Messages.DiagramIconStylePreferencePage_label_for_Package, 5004, 5041, 3006);
		addCheckBoxForVisualIds(parent, Messages.DiagramIconStylePreferencePage_label_for_PrimitiveType, 5007, 5028, 3009);
		addCheckBoxForVisualIds(parent, Messages.DiagramIconStylePreferencePage_label_for_Property, 3001, 3019, 3014, 3021, 3023, 3028);
		addCheckBoxForVisualIds(parent, Messages.DiagramIconStylePreferencePage_label_for_Slot, 3017);

	}

	/**
	 * @generated
	 */
	private Composite createShowHideConnectorIconsGroup(Composite parent) {
		IconStylePreferencePage.ShowHideConnectorLabelGroup builder = new IconStylePreferencePage.ShowHideConnectorLabelGroup();
		return builder.createShowHideConnectorLabelGroup(parent, ourConnectorLabels2Vids);
	}

}
