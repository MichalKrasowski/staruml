package org.eclipse.uml2.diagram.common.sheet.chooser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.uml2.diagram.common.Messages;
import org.eclipse.uml2.diagram.common.sheet.chooser.ElementChooserPage.Validator;
import org.eclipse.uml2.uml.ElementImport;

public class TabbedElementChooser {

	private final AdapterFactory myItemProvidersAdapterFactory;

	private final EObject mySourceObject;

	private final EStructuralFeature myFeature;

	private final IDialogSettings myDialogSettings;

	private ElementChooserPage myCurrentPage;

	private final String mySettingsKeyLastFocus = "ReferencedElementDialog.KeyLastFocus"; //$NON-NLS-1$

	private TabFolder myTabFolder;
	
	private CLabel myDetailLabel;

	private LabelProviderWithContext myDetailLabelProvider;
	
	private final Validator myValidator;

	private ElementTreeChooser myTreeChooserTab;

	private ElementFilteredListChooser myListChooserPage;

	private final TransactionalEditingDomain myEditingDomain;
	

	public TabbedElementChooser(IDialogSettings settings, AdapterFactory itemProvidersAdapterFactory, EObject sourceObject, EStructuralFeature feature, TransactionalEditingDomain editingDomain) {
		myDialogSettings = settings;
		myItemProvidersAdapterFactory = itemProvidersAdapterFactory;
		mySourceObject = sourceObject;
		myFeature = feature;
		myEditingDomain = editingDomain;
		myValidator = new FeatureValueValidator(feature);
		myDetailLabelProvider = getDetailLabelProvider();
	}

	public Control createDialogArea(Composite composite) {
		Composite plate = new Composite(composite, SWT.NONE);
		GridLayout layout = new GridLayout();
		plate.setLayout(layout);
		
		createTabFolder(plate);
		myTreeChooserTab = new ElementTreeChooser(myItemProvidersAdapterFactory, mySourceObject, myFeature, myEditingDomain);
		addTabPage(Messages.TabbedElementChooser_tab_choose_from_a_tree, myTabFolder, myTreeChooserTab);
		myListChooserPage = new ElementFilteredListChooser(myItemProvidersAdapterFactory, mySourceObject, myFeature, myValidator, myEditingDomain);
		addTabPage(Messages.TabbedElementChooser_tab_choose_from_a_list, myTabFolder, myListChooserPage);

		myCurrentPage = (ElementChooserPage) myTabFolder.getSelection()[0].getData();
		myTabFolder.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				tabChanged((TabItem) e.item);
				myDialogSettings.put(mySettingsKeyLastFocus, myTabFolder.getSelectionIndex());
			}
		});

		createDetailLabel(plate);		
		// XXX set context
//		myDetailLabelProvider.setContext(context);
		return plate;
	}

	private void createTabFolder(Composite plate) {
		myTabFolder = new TabFolder(plate, SWT.NONE);
		myTabFolder.setFont(plate.getFont());
		GridData layoutData = new GridData(GridData.FILL_BOTH);
		layoutData.widthHint = 400;		
		layoutData.heightHint = 400; 
		myTabFolder.setLayoutData(layoutData);
	}
	
	protected LabelProviderWithContext getDetailLabelProvider() {
		return new QualifiedNameLabelProvider(new AdapterFactoryLabelProvider(myItemProvidersAdapterFactory));
	}

	private void createDetailLabel(Composite parent) {
		GridData layoutData = new GridData();
		layoutData.grabExcessVerticalSpace = false;
		layoutData.grabExcessHorizontalSpace = true;
		layoutData.horizontalAlignment = GridData.FILL;
		layoutData.verticalAlignment = GridData.BEGINNING;
		Composite plate = new Composite(parent, SWT.BORDER | SWT.FLAT);
		plate.setLayoutData(layoutData);
		plate.setLayout(new FillLayout());
		myDetailLabel = new CLabel(plate, SWT.NONE);

		addSelectionListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				List<?> selection = getSelection();
				if (selection.size() == 1) {
					Object selected = selection.get(0);
					String text = myDetailLabelProvider.getText(selected);
					if (text == null) {
						text = StringStatics.BLANK;
					}
					myDetailLabel.setText(text);
					Image image = myDetailLabelProvider.getImage(selected);
					myDetailLabel.setImage(image);
				}
			}
		});
	}

	public Validator getValidator() {
		return myValidator;
	}

	private static void addTabPage(String title, TabFolder myTabFolder, ElementChooserPage tabPage) {
		final TabItem tabItem = new TabItem(myTabFolder, SWT.NONE);
		// applyDialogFont(tabItem.getControl());
		tabItem.setText(title);
		tabItem.setData(tabPage);
		tabItem.setControl(tabPage.createControl(myTabFolder));
	}

	private void tabChanged(TabItem tabItem) {
		ElementChooserPage newPage = (ElementChooserPage) tabItem.getData();
		tabItem.getControl().setFocus();
		if (myCurrentPage != null) {
			newPage.setSelection(myCurrentPage.getSelection());
		}
		myCurrentPage = newPage;
	}

	public void initSelection() {
		int lastFocusNr = 0;
		try {
			lastFocusNr = myDialogSettings.getInt(mySettingsKeyLastFocus);
			if (lastFocusNr < 0 || lastFocusNr > myTabFolder.getItemCount()) {
				lastFocusNr = 0;
			}
		} catch (NumberFormatException x) {
			lastFocusNr = 0;
		}

		myTabFolder.setSelection(lastFocusNr);
		myCurrentPage = (ElementChooserPage) myTabFolder.getSelection()[0].getData();
		myCurrentPage.setSelection(getInitialSelection());
	}

	
	protected List<?> getInitialSelection() {
		Object featureValue = mySourceObject.eGet(myFeature);
		if (myFeature.isMany()) {
			@SuppressWarnings("unchecked") 
			Collection<Object> a = (Collection)featureValue;
			return new ArrayList<Object>(a);
		}
		return Collections.singletonList(featureValue);
	}

	public List<?> getSelection() {
		return myCurrentPage.getSelection();
	}

	public void setSelection(List<?> selection) {
		myCurrentPage.setSelection(selection);
	}

	public void addDoubleClickListener(IDoubleClickListener listener) {
		myListChooserPage.addDoubleClickListener(listener);
		myTreeChooserTab.addDoubleClickListener(listener);
	}

	public void addSelectionListener(ISelectionChangedListener listener) {
		myListChooserPage.addSelectionListener(listener);
		myTreeChooserTab.addSelectionListener(listener);
	}
	
	public interface LabelProviderWithContext extends ILabelProvider {
		void setContext(Object... context);
	}
	
	private static class FeatureValueValidator implements Validator {
		private final EStructuralFeature myFeature;

		public FeatureValueValidator(EStructuralFeature feature) {
			myFeature = feature;
		}

		public EObject validate(Object object) {
			if (false == object instanceof EObject) {
				return null;
			}
			EObject eobject = (EObject) object;
			if (eobject instanceof ElementImport) {
				ElementImport _import = (ElementImport) eobject;
				eobject = _import.getImportedElement();
			}
			if (eobject != null && myFeature.getEType().isInstance(eobject)) {
				return eobject;
			}
			return null;
		}

	}

}
