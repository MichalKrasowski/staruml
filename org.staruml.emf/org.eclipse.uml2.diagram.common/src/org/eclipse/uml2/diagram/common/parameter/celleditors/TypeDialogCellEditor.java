/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Tatiana Fesenko (Borland) - initial API and implementation
 */
package org.eclipse.uml2.diagram.common.parameter.celleditors;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.ui.celleditor.ExtendedDialogCellEditor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.diagram.common.UMLCommonPlugin;
import org.eclipse.uml2.diagram.common.sheet.chooser.ReferencedElementChooserDialog;
import org.eclipse.uml2.diagram.common.sheet.chooser.TabbedElementChooser;

public class TypeDialogCellEditor extends ExtendedDialogCellEditor {

	private final EStructuralFeature myFeature;

	private final AdapterFactory myAf;

	public TypeDialogCellEditor(Composite composite, AdapterFactory af, Object object, EStructuralFeature feature) {
		super(composite, new AdapterFactoryLabelProvider(af));
		myAf = af;
		myFeature = feature;
	}

	@Override
	protected Object openDialogBox(Control cellEditorWindow) {
		ReferencedElementChooserDialog myElementChooserDialog = new ReferencedElementChooserDialogEx(getControl().getShell(), UMLCommonPlugin.getInstance().getDialogSettings(), myAf,
				(EObject) doGetValue(), myFeature, (EObject) doGetValue()){
			
		};
		myElementChooserDialog.open();
		return myElementChooserDialog.getResult();
	}

	// #263278 'Unset' doesn't work
	@Override
	protected void doSetValue(Object value) {
		if (ReferencedElementChooserDialog.NULL_VALUE.equals(value)) {
			value = null;
		}
		super.doSetValue(value);
	}

	@Override
	protected Object doGetValue() {
		return super.doGetValue();
	}
	
	private class ReferencedElementChooserDialogEx extends ReferencedElementChooserDialog {

		public ReferencedElementChooserDialogEx(Shell shell, IDialogSettings settings, AdapterFactory itemProvidersAdapterFactory, EObject sourceObject, EStructuralFeature feature, final Object initialSelection) {
			super(shell, settings, itemProvidersAdapterFactory, sourceObject, feature);
			myChooser = new TabbedElementChooser(settings, itemProvidersAdapterFactory, sourceObject, feature, myEditingDomain) {
				@Override
				protected List<?> getInitialSelection() {
					return Collections.singletonList(initialSelection);
				}
			};
		}
		
	}
	


}
