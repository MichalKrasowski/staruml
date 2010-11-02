package org.eclipse.uml2.diagram.common.preferences;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.gmf.runtime.common.ui.preferences.AbstractPreferencePage;
import org.eclipse.gmf.runtime.common.ui.preferences.CheckBoxFieldEditor;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.RadioGroupFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.forms.events.ExpansionAdapter;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.uml2.diagram.common.Messages;

public abstract class IconStylePreferencePage extends AbstractPreferencePage {
	
	public static String getConnectionLabelPreference(int visualId) {
		return UMLPreferencesConstants.PREF_LABELS_SHOW_VISUAL_ID_PREFIX + visualId;
	}

	private CheckBoxFieldEditor myShowStereotypeIconOnly;

	@Override
	protected void addFields(Composite parent) {
		Composite main = new Composite(parent, SWT.NULL);
		main.setLayout(new GridLayout());
		main.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_FILL));
		createIconStyleGroup(main);
		createShowHideMetaclassIconGroup(main);
	}

	protected void createIconStyleGroup(Composite parent) {
		String[][] choices = new String[][] { //
		//
				{ ALTERNATIVE_STYLE_ICON_LABEL, UMLPreferencesConstants.PREF_ICON_STYLE_CHEERFUL }, //
				{ ECLIPSE_STYLE_ICON_LABEL, UMLPreferencesConstants.PREF_ICON_STYLE_STANDARD } };
		myIconStyleFieldEditor = new RadioGroupFieldEditor(UMLPreferencesConstants.PREF_ICON_STYLE, ICONSTYLE_GROUPBOX_LABEL, 1, choices, parent, true);
		addField(myIconStyleFieldEditor);
	}

	protected void createShowHideMetaclassIconGroup(Composite parent) {
        Group group = new Group(parent, SWT.NONE);
        group.setFont(parent.getFont());
		group.setText(LABEL_SHOW_HIDE_STEREOTYPE_GROUP);
        group.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		myShowStereotypeIconOnly = new CheckBoxFieldEditor(UMLPreferencesConstants.PREF_ICONS_SHOW_STEREOTYPE_ICON_MODE, LABEL_SHOW_HIDE_STEREOTYPE_MODE, group);
		//set layout after CheckBoxFieldEditor creation, because FieldEditor#createControl() sets GridLayout with empty margins
        group.setLayout(new GridLayout());
		addField(myShowStereotypeIconOnly);
	}

	public static void initDefaults(IPreferenceStore store) {
		store.setDefault(UMLPreferencesConstants.PREF_ICON_STYLE, UMLPreferencesConstants.PREF_ICON_STYLE_STANDARD);
		store.setDefault(UMLPreferencesConstants.PREF_ICONS_SHOW_HIDE_MODE, UMLPreferencesConstants.VALUE_ICONS_SHOW_ALL);
		store.setDefault(UMLPreferencesConstants.PREF_ICONS_SHOW_STEREOTYPE_ICON_MODE, true);
	}

	@Override
	protected Composite getFieldEditorParent() {
		Composite parent = super.getFieldEditorParent();
		ScrolledComposite s = createScrolledComposite(parent);
		Composite sbody = createComposite(s);
		s.setContent(sbody);
		return sbody;
	}

	/*
	 * Creates ExpandableComposite as it was done in
	 * <code>PDECompilersConfigurationBlock</code>
	 */
	protected Composite createExpansibleComposite(Composite parent, String title) {
		ExpandableComposite ecomp = new ExpandableComposite(parent, SWT.NONE, ExpandableComposite.TWISTIE | ExpandableComposite.CLIENT_INDENT);
		ecomp.setText(title);
		// ecomp.setFont(JFaceResources.getFontRegistry().getBold(JFaceResources.DIALOG_FONT));
		ecomp.setLayoutData(new GridData());
		ecomp.addExpansionListener(new ExpansionAdapter() {

			@Override
			public void expansionStateChanged(ExpansionEvent e) {
				Object obj = e.getSource();
				handleExpand(getScrollingParent(obj));
			}
		});
		// ecomp.setFont(JFaceResources.getFontRegistry().getBold(JFaceResources.DIALOG_FONT));
		Composite client = createComposite(ecomp);
		ecomp.setClient(client);
		return client;
	}

	protected static Composite createComposite(Composite parent) {
		Composite g = new Composite(parent, SWT.NONE);
		g.setLayout(new GridLayout());
		g.setFont(parent.getFont());
		g.setLayoutData(new GridData(GridData.FILL_BOTH));
		return g;
	}

	private ScrolledComposite getScrollingParent(Object obj) {
		if (obj instanceof ExpandableComposite) {
			ExpandableComposite ecomp = (ExpandableComposite) obj;
			Composite parent = ecomp.getParent();
			while (parent != null && !(parent instanceof ScrolledComposite)) {
				parent = parent.getParent();
			}
			if (parent != null) {
				return (ScrolledComposite) parent;
			}
		}
		if (obj instanceof ScrolledComposite) {
			return (ScrolledComposite) obj;
		}
		return null;
	}

	private void handleExpand(ScrolledComposite composite) {
		if (composite == null) {
			return;
		}
		try {
			composite.setRedraw(false);
			Composite c = (Composite) composite.getContent();
			if (c == null) {
				return;
			}
			Point newSize = c.computeSize(SWT.DEFAULT, SWT.DEFAULT);
			composite.setMinSize(newSize);
			c.layout(true);
		} finally {
			composite.setRedraw(true);
		}
	}

	private ScrolledComposite createScrolledComposite(Composite parent) {
		ScrolledComposite scomp = new ScrolledComposite(parent, SWT.H_SCROLL | SWT.V_SCROLL);
		scomp.setExpandHorizontal(true);
		scomp.setExpandVertical(true);
		scomp.setLayout(new GridLayout());
		scomp.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		scomp.addListener(SWT.Resize, new Listener() {

			public void handleEvent(Event event) {
				handleExpand(getScrollingParent(event.widget));
			}
		});
		return scomp;
	}
	
	protected class ShowHideConnectorLabelGroup {

		private final List<CheckBoxFieldEditor> myConnectorLabelsByVisualIdEditors = new ArrayList<CheckBoxFieldEditor>();

		public ShowHideConnectorLabelGroup() {
		}

		public Composite createShowHideConnectorLabelGroup(Composite parent, Map<String, Integer> fields) {
			Composite result = new Composite(parent, SWT.NULL);
			result.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_FILL));
			result.setLayout(new GridLayout());

			Group group = new Group(result, SWT.NONE);
			group.setFont(result.getFont());
			group.setText(Messages.IconStylePreferencePage_group_show_hide_connector_labels);
			group.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			group.setLayout(new GridLayout());

			Composite checkBoxesPanel = createCheckboxesPanel(group);
			addAllFields(checkBoxesPanel, fields);

			createButtonsPanel(group);
			return result;
		}

		private Composite createCheckboxesPanel(Composite parent) {
			Composite e = createExpansibleComposite(parent, Messages.IconStylePreferencePage_composite_connector_labels);
			Composite checkBoxesPanel = new Composite(e, SWT.NULL);
			checkBoxesPanel.setLayout(new GridLayout());
			checkBoxesPanel.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_FILL));
			return checkBoxesPanel;
		}

		private Composite createButtonsPanel(Composite parent) {
			Composite buttonsPanel = new Composite(parent, SWT.NULL);
			buttonsPanel.setLayout(new GridLayout(2, true));
			buttonsPanel.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_FILL));
			Button selectAll = addSelectAllButton(buttonsPanel, true);
			selectAll.setText(Messages.IconStylePreferencePage_button_select_all);
			Button deselectAll = addSelectAllButton(buttonsPanel, false);
			deselectAll.setText(Messages.IconStylePreferencePage_button_deselect_all);
			return buttonsPanel;
		}

		private void addAllFields(Composite parent, Map<String, Integer> fields) {
			List<String> sortedLabels = new ArrayList<String>(fields.keySet());
			Collections.sort(sortedLabels);
			for (String label : sortedLabels) {
				addCheckBoxForLabelVisualIds(parent, label, fields.get(label));
			}

		}

		private CheckBoxFieldEditor addCheckBoxForLabelVisualIds(Composite parent, String commonLabel, int visualId) {
			CheckBoxFieldEditor result = new CheckBoxFieldEditor(IconStylePreferencePage.getConnectionLabelPreference(visualId), commonLabel, parent);
			myConnectorLabelsByVisualIdEditors.add(result);
			addField(result);
			return result;
		}

		private Button addSelectAllButton(Composite parent, final boolean selectNotDeselect) {
			Button selectButton = new Button(parent, SWT.PUSH);
			selectButton.addSelectionListener(new SelectionAdapter() {

				@Override
				public void widgetSelected(SelectionEvent e) {
					for (CheckBoxFieldEditor next : myConnectorLabelsByVisualIdEditors) {
						next.getCheckbox().setSelection(selectNotDeselect);
					}
				}
			});
			int widthHint = convertHorizontalDLUsToPixels(IDialogConstants.BUTTON_WIDTH);
			Dialog.applyDialogFont(selectButton);
			GridData data = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
			Point minButtonSize = selectButton.computeSize(SWT.DEFAULT, SWT.DEFAULT, true);
			data.widthHint = Math.max(widthHint, minButtonSize.x);
			selectButton.setLayoutData(data);
			return selectButton;
		}
	}

	private static final String ICONSTYLE_GROUPBOX_LABEL = Messages.IconStylePreferencePage_icon_style_group;

	private static final String ALTERNATIVE_STYLE_ICON_LABEL = Messages.IconStylePreferencePage_cheerful_style;

	private static final String ECLIPSE_STYLE_ICON_LABEL = Messages.IconStylePreferencePage_eclipse_style;

	protected static final String LABEL_SHOW_HIDE_STEREOTYPE_GROUP = Messages.IconStylePreferencePage_group_stereotype_images;

	protected static final String LABEL_SHOW_HIDE_STEREOTYPE_MODE = Messages.IconStylePreferencePage_label_show_stereotype;

	protected static final String LABEL_SHOW_HIDE_MODE = Messages.IconStylePreferencePage_group_metaclass_images;

	protected static final String LABEL_HIDE_ALL = Messages.IconStylePreferencePage_label_hide_all;

	protected static final String LABEL_SHOW_ALL = Messages.IconStylePreferencePage_label_show_all;

	protected static final String LABEL_SHOW_BY_VISUAL_ID = Messages.IconStylePreferencePage_label_show_for_selected;

	private RadioGroupFieldEditor myIconStyleFieldEditor;

}
