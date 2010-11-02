package org.eclipse.uml2.diagram.common.sheet.chooser;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ItemProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.uml2.diagram.common.Messages;
import org.eclipse.uml2.diagram.common.sheet.chooser.ElementChooserPage.Validator;

public class MultiReferenceElementChooserDialog extends TrayDialog {

	protected EList<Object> result;

	protected ItemProvider values;

	private AdapterFactoryLabelProvider labelProvider;

	private final AdapterFactory myItemProvidersAdapterFactory;

	private final EObject mySourceObject;

	private final EStructuralFeature myFeature;

	private final TabbedElementChooser myChooser;
	
	private final TransactionalEditingDomain myEditingDomain;

	public MultiReferenceElementChooserDialog(Shell parent, IDialogSettings settings, AdapterFactory itemProvidersAdapterFactory, EObject sourceObject, EStructuralFeature feature) {
		super(parent);
		myItemProvidersAdapterFactory = itemProvidersAdapterFactory;
		mySourceObject = sourceObject;
		myFeature = feature;
		setShellStyle(getShellStyle() | SWT.RESIZE | SWT.MAX);

		List<?> currentValues = (List<?>) sourceObject.eGet(feature);
		values = new ItemProvider(itemProvidersAdapterFactory, currentValues);
		labelProvider = new AdapterFactoryLabelProvider(myItemProvidersAdapterFactory);
		myEditingDomain = TransactionUtil.getEditingDomain(sourceObject);
		myChooser = new TabbedElementChooser(settings, itemProvidersAdapterFactory, sourceObject, feature, myEditingDomain);

	}

	@Override
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText(NLS.bind(Messages.MultiReferenceElementChooserDialog_dialod_choose_element, new Object[]{myFeature.getName(), labelProvider.getText(mySourceObject)}));
		shell.setImage(labelProvider.getImage(mySourceObject));
	}

	@Override
	public void create() {
		super.create();
		myChooser.initSelection();
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite contents = (Composite) super.createDialogArea(parent);

		GridLayout contentsGridLayout = (GridLayout) contents.getLayout();
		contentsGridLayout.numColumns = 3;

		GridData contentsGridData = (GridData) contents.getLayoutData();
		contentsGridData.horizontalAlignment = SWT.FILL;
		contentsGridData.verticalAlignment = SWT.FILL;

		Composite choiceComposite = new Composite(contents, SWT.NONE);
		{
			GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
			data.horizontalAlignment = SWT.END;
			choiceComposite.setLayoutData(data);

			GridLayout layout = new GridLayout();
			data.horizontalAlignment = SWT.FILL;
			layout.marginHeight = 0;
			layout.marginWidth = 0;
			layout.numColumns = 1;
			choiceComposite.setLayout(layout);
		}

		Label choiceLabel = new Label(choiceComposite, SWT.NONE);
		choiceLabel.setText(NLS.bind(Messages.MultiReferenceElementChooserDialog_label_choose_element, new Object[]{myFeature.getEType().getName()}));
		GridData choiceLabelGridData = new GridData();
		choiceLabelGridData.verticalAlignment = SWT.FILL;
		choiceLabelGridData.horizontalAlignment = SWT.FILL;
		choiceLabel.setLayoutData(choiceLabelGridData);

		// UML2 Tools tabbed chooser
		Control choiceTable = myChooser.createDialogArea(choiceComposite); 
		{
	      GridData choiceTableGridData = new GridData();
	      choiceTableGridData.widthHint = Display.getCurrent().getBounds().width / 5;
	      choiceTableGridData.heightHint = Display.getCurrent().getBounds().height / 3;
	      choiceTableGridData.verticalAlignment = SWT.FILL;
	      choiceTableGridData.horizontalAlignment = SWT.FILL;
	      choiceTableGridData.grabExcessHorizontalSpace= true;
	      choiceTableGridData.grabExcessVerticalSpace= true;
	      choiceTable.setLayoutData(choiceTableGridData);
		}


		// We use multi even for a single line because we want to respond to the
		// enter key.
		//
		Composite controlButtons = new Composite(contents, SWT.NONE);
		GridData controlButtonsGridData = new GridData();
		controlButtonsGridData.verticalAlignment = SWT.FILL;
		controlButtonsGridData.horizontalAlignment = SWT.FILL;
		controlButtons.setLayoutData(controlButtonsGridData);

		GridLayout controlsButtonGridLayout = new GridLayout();
		controlButtons.setLayout(controlsButtonGridLayout);

		new Label(controlButtons, SWT.NONE);

		final Button addButton = new Button(controlButtons, SWT.PUSH);
		addButton.setText(Messages.MultiReferenceElementChooserDialog_button_add);
		GridData addButtonGridData = new GridData();
		addButtonGridData.verticalAlignment = SWT.FILL;
		addButtonGridData.horizontalAlignment = SWT.FILL;
		addButton.setLayoutData(addButtonGridData);

		final Button removeButton = new Button(controlButtons, SWT.PUSH);
		removeButton.setText(Messages.MultiReferenceElementChooserDialog_button_remove);
		GridData removeButtonGridData = new GridData();
		removeButtonGridData.verticalAlignment = SWT.FILL;
		removeButtonGridData.horizontalAlignment = SWT.FILL;
		removeButton.setLayoutData(removeButtonGridData);

		Label spaceLabel = new Label(controlButtons, SWT.NONE);
		GridData spaceLabelGridData = new GridData();
		spaceLabelGridData.verticalSpan = 2;
		spaceLabel.setLayoutData(spaceLabelGridData);

		final Button upButton = new Button(controlButtons, SWT.PUSH);
		upButton.setText(Messages.MultiReferenceElementChooserDialog_button_up);
		GridData upButtonGridData = new GridData();
		upButtonGridData.verticalAlignment = SWT.FILL;
		upButtonGridData.horizontalAlignment = SWT.FILL;
		upButton.setLayoutData(upButtonGridData);

		final Button downButton = new Button(controlButtons, SWT.PUSH);
		downButton.setText(Messages.MultiReferenceElementChooserDialog_button_down);
		GridData downButtonGridData = new GridData();
		downButtonGridData.verticalAlignment = SWT.FILL;
		downButtonGridData.horizontalAlignment = SWT.FILL;
		downButton.setLayoutData(downButtonGridData);

		Composite featureComposite = new Composite(contents, SWT.NONE);
		{
			GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
			data.horizontalAlignment = SWT.END;
			featureComposite.setLayoutData(data);

			GridLayout layout = new GridLayout();
			data.horizontalAlignment = SWT.FILL;
			layout.marginHeight = 0;
			layout.marginWidth = 0;
			layout.numColumns = 1;
			featureComposite.setLayout(layout);
		}

		Label featureLabel = new Label(featureComposite, SWT.NONE);
		featureLabel.setText(Messages.MultiReferenceElementChooserDialog_label_selected_elements);
		GridData featureLabelGridData = new GridData();
		featureLabelGridData.horizontalSpan = 2;
		featureLabelGridData.horizontalAlignment = SWT.FILL;
		featureLabelGridData.verticalAlignment = SWT.FILL;
		featureLabel.setLayoutData(featureLabelGridData);

		final Table featureTable = new Table(featureComposite, SWT.MULTI | SWT.BORDER);
		GridData featureTableGridData = new GridData();
		featureTableGridData.widthHint = Display.getCurrent().getBounds().width / 5;
		featureTableGridData.heightHint = Display.getCurrent().getBounds().height / 3;
		featureTableGridData.verticalAlignment = SWT.FILL;
		featureTableGridData.horizontalAlignment = SWT.FILL;
		featureTableGridData.grabExcessHorizontalSpace = true;
		featureTableGridData.grabExcessVerticalSpace = true;
		featureTable.setLayoutData(featureTableGridData);

		final TableViewer featureTableViewer = new TableViewer(featureTable);
		IContentProvider contentProvider = new AdapterFactoryContentProvider(myItemProvidersAdapterFactory);
		featureTableViewer.setContentProvider(contentProvider);
		featureTableViewer.setLabelProvider(labelProvider);
		featureTableViewer.setInput(values);
		if (!values.getChildren().isEmpty()) {
			featureTableViewer.setSelection(new StructuredSelection(values.getChildren().get(0)));
		}

		if (myChooser != null) {
			myChooser.addDoubleClickListener(new IDoubleClickListener() {

				public void doubleClick(DoubleClickEvent event) {
					if (addButton.isEnabled()) {
						addButton.notifyListeners(SWT.Selection, null);
					}
				}
			});

			featureTableViewer.addDoubleClickListener(new IDoubleClickListener() {

				public void doubleClick(DoubleClickEvent event) {
					if (removeButton.isEnabled()) {
						removeButton.notifyListeners(SWT.Selection, null);
					}
				}
			});
		}

		upButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent event) {
				IStructuredSelection selection = (IStructuredSelection) featureTableViewer.getSelection();
				int minIndex = 0;
				for (Iterator<?> i = selection.iterator(); i.hasNext();) {
					Object value = i.next();
					int index = values.getChildren().indexOf(value);
					values.getChildren().move(Math.max(index - 1, minIndex++), value);
				}
			}
		});

		downButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent event) {
				IStructuredSelection selection = (IStructuredSelection) featureTableViewer.getSelection();
				int maxIndex = values.getChildren().size() - selection.size();
				for (Iterator<?> i = selection.iterator(); i.hasNext();) {
					Object value = i.next();
					int index = values.getChildren().indexOf(value);
					values.getChildren().move(Math.min(index + 1, maxIndex++), value);
				}
			}
		});

		addButton.addSelectionListener(new SelectionAdapter() {

			// event is null when choiceTableViewer is double clicked
			@Override
			public void widgetSelected(SelectionEvent event) {
				if (myChooser != null) {
					List<?> selection = myChooser.getSelection();
					for (Iterator<?> i = selection.iterator(); i.hasNext();) {
						Object value = i.next();
						if (!values.getChildren().contains(value)) {
							values.getChildren().add(value);
						}
					}
					featureTableViewer.setSelection(new StructuredSelection(selection));
				}
			}
		});

		removeButton.addSelectionListener(new SelectionAdapter() {

			// event is null when featureTableViewer is double clicked
			@Override
			public void widgetSelected(SelectionEvent event) {
				IStructuredSelection selection = (IStructuredSelection) featureTableViewer.getSelection();
				Object firstValue = null;
				for (Iterator<?> i = selection.iterator(); i.hasNext();) {
					Object value = i.next();
					if (firstValue == null) {
						firstValue = value;
					}
					values.getChildren().remove(value);
				}

				if (!values.getChildren().isEmpty()) {
					featureTableViewer.setSelection(new StructuredSelection(values.getChildren().get(0)));
				}

				if (myChooser != null) {
					myChooser.setSelection(selection.toList());
				}
			}
		});

		final Validator validator = myChooser.getValidator();
		myChooser.addSelectionListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				boolean isEnabled = true;
				for (Object firstSelected : myChooser.getSelection()) {
					isEnabled &= validator.validate(firstSelected) != null;
				}
				addButton.setEnabled(isEnabled);
			}
		});
		return contents;
	}

	@Override
	protected void okPressed() {
		result = new BasicEList<Object>();
		for (Object next : values.getChildren()) {
			URI uri = EcoreUtil.getURI((EObject) next);
			result.add(myEditingDomain.getResourceSet().getEObject(uri, true));
		}
		super.okPressed();
	}

	@Override
	public boolean close() {
		// contentProvider.dispose();
		return super.close();
	}

	public EList<Object> getResult() {
		return result;
	}
}
