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
package org.eclipse.uml2.diagram.common.sheet;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.viewers.ICellEditorValidator;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.uml2.diagram.common.Messages;
import org.eclipse.uml2.diagram.common.sheet.chooser.ReferencedElementChooserDialog;
import org.eclipse.uml2.uml.NamedElement;

public class ReferenceDialogCellEditor extends TextAndDialogCellEditor {

	final private ReferencedElementChooserDialog myElementChooserDialog;

	private final Collection<?> myChoiceOfValues;

	private Map<String, NamedElement> myName2Elements;

	public ReferenceDialogCellEditor(Composite parent, ReferencedElementChooserDialog chooserDialog, Collection<?> choiceOfValues, final ILabelProvider labelProvider) {
		super(parent, labelProvider);
		myElementChooserDialog = chooserDialog;
		myChoiceOfValues = choiceOfValues;
		setValidator(new NamedElementValidator());
	}

	public ReferenceDialogCellEditor(Composite parent, ReferencedElementChooserDialog chooserDialog, ILabelProvider labelProvider) {
		super(parent, labelProvider);
		myElementChooserDialog = chooserDialog;
		myChoiceOfValues = null;
	}

	@Override
	protected Object openDialogBox(Control cellEditorWindow) {
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
		Object value = super.doGetValue();
		if (value != null && value instanceof String) {
			if (value.equals(labelProvider.getText(getObjectValue()))) {
				return getObjectValue();
			}
			return findElementByName((String) value);
		}
		return value;
	}

	private Object findElementByName(String name) {
		return getName2ElementMap().get(name);
	}

	private boolean elementsExists(String name) {
		return findElementByName(name) != null;
	}

	private Map<String, NamedElement> getName2ElementMap() {
		if (myName2Elements == null) {
			myName2Elements = buildName2ElementMap();
		}
		return myName2Elements;
	}

	private Map<String, NamedElement> buildName2ElementMap() {
		if (myChoiceOfValues == null) {
			return Collections.emptyMap();
		}
		HashMap<String, NamedElement> result = new HashMap<String, NamedElement>();
		for (Object next : myChoiceOfValues) {
			if (next instanceof NamedElement) {
				String name = ((NamedElement) next).getName();
				if (!result.containsKey(name)) {
					result.put(name, (NamedElement) next);
				}
			}
		}
		return result;
	}

	private class NamedElementValidator implements ICellEditorValidator {

		public String isValid(Object value) {
			if (value != null && value instanceof String) {
				if (value.equals(labelProvider.getText(getObjectValue()))) {
					return null;
				}
				if (!elementsExists((String) value)) {
					return Messages.ReferenceDialogCellEditor_message_cannot_find_element;
				}
			}
			return null;
		}

	}

}
