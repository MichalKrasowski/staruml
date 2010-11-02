package org.eclipse.uml2.diagram.common.sheet.chooser;

import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.diagram.common.Messages;
import org.eclipse.uml2.diagram.common.sheet.chooser.ElementChooserPage.Validator;

public class ReferencedElementChooserDialog extends TrayDialog {

	//#263278 'Unset' doesn't work
	public final static Object NULL_VALUE = new String(Messages.ReferencedElementChooserDialog_null_eobject); 
	
	private final static int UNSET_BUTTON_ID = IDialogConstants.NO_TO_ALL_ID + 1;	

	public Object myResult;

	private final EStructuralFeature myFeature;

	private AdapterFactoryLabelProvider labelProvider;

	private final EObject mySourceObject;
	
	protected TabbedElementChooser myChooser;
	
	protected final TransactionalEditingDomain myEditingDomain;

	public ReferencedElementChooserDialog(Shell shell, IDialogSettings settings, AdapterFactory itemProvidersAdapterFactory, EObject sourceObject, EStructuralFeature feature) {
		super(shell);
		mySourceObject = sourceObject;
		myFeature = feature;
		labelProvider = new AdapterFactoryLabelProvider(itemProvidersAdapterFactory);
		myEditingDomain = TransactionUtil.getEditingDomain(sourceObject);
		myChooser = new TabbedElementChooser(settings, itemProvidersAdapterFactory, sourceObject, feature, myEditingDomain);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		final Composite composite = (Composite) super.createDialogArea(parent);
		myChooser.createDialogArea(composite);
		myChooser.addSelectionListener(new OkButtonEnabler());
		return composite;
	}

	@Override
	public void create() {
		super.create();
		myChooser.initSelection();
	}

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		// create OK and Cancel buttons by default
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		createButton(parent, UNSET_BUTTON_ID, Messages.ReferencedElementChooserDialog_button_unset, false);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
	}

	@Override
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText(NLS.bind(Messages.ReferencedElementChooserDialog_dialog_choose_element, new Object[]{myFeature.getName(), labelProvider.getText(mySourceObject)}));
		shell.setImage(labelProvider.getImage(mySourceObject));
	}

	@Override
	protected void buttonPressed(int buttonId) {
		if (UNSET_BUTTON_ID == buttonId) {
			unsetPressed();
		} else {
			super.buttonPressed(buttonId);
		}
	}

	private void unsetPressed() {
		myResult = NULL_VALUE;
		close();
	}

	@Override
	protected void okPressed() {
		List<?> selection = myChooser.getSelection();
		if (!selection.isEmpty()) {
			URI uri = EcoreUtil.getURI((EObject) selection.get(0));
			myResult = myEditingDomain.getResourceSet().getEObject(uri, true);
		}
		super.okPressed();
	}

	public Object getResult() {
		return myResult;
	}

	private void setOkButtonEnabled(boolean enabled) {
		getButton(IDialogConstants.OK_ID).setEnabled(enabled);
	}

	private class OkButtonEnabler implements ISelectionChangedListener {

		Validator myValidator = myChooser.getValidator();

		public void selectionChanged(SelectionChangedEvent event) {
			List<?> selection = myChooser.getSelection();
			if (selection.size() == 1) {
				Object firstSelected = selection.get(0);
				setOkButtonEnabled(myValidator.validate(firstSelected) != null);
			} else {
				setOkButtonEnabled(false);
			}
		}
	}

}
