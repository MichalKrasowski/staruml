/*
 * Copyright (c) 2008 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Tatiana Fesenko (Borland) - initial API and implementation
 */
package org.eclipse.uml2.diagram.common.sheet.chooser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.uml2.diagram.common.part.ModelElementsContentHelper;

public class ElementFilteredListChooser implements ElementChooserPage {

	private FilteredListControl myFilteredList;

	private final Validator myValidator;
	
	private Object[] myListElements;

	private final AdapterFactoryContentProvider myAdapterFctoryContentProvier;

	private final AdapterFactory myItemProvidersAdapterFactory;

	private final TransactionalEditingDomain myEditingDomain;	

	private final EObject mySourceObject;

	private final EStructuralFeature myFeature;

	public ElementFilteredListChooser(AdapterFactory itemProvidersAdapterFactory, EObject sourceObject, EStructuralFeature feature, Validator validator, TransactionalEditingDomain editingDomain) {
		myItemProvidersAdapterFactory = itemProvidersAdapterFactory;
		mySourceObject = sourceObject;
		myFeature = feature;
		myValidator = validator;
		myAdapterFctoryContentProvier = new AdapterFactoryContentProvider(itemProvidersAdapterFactory);
		myEditingDomain = editingDomain;
	}

	public Control createControl(Composite parent) {
		myFilteredList = new FilteredListControl(parent, new AdapterFactoryLabelProvider(myItemProvidersAdapterFactory));
		Object featureValue = mySourceObject.eGet(myFeature);
		if (featureValue != null) {
			myFilteredList.setInitialSelections(new Object[] { featureValue });
		}
		ILabelProvider labelProvider = new SimpleNamedElementLabelProvider(new AdapterFactoryLabelProvider(myItemProvidersAdapterFactory));
		myFilteredList.setFilterMatcher(new ConfigurableFilterMatcher(labelProvider));
		myListElements = collectElements(mySourceObject.eResource().getResourceSet());
		myFilteredList.setListElements(myListElements);
		return myFilteredList;
	}

	public final List<?> getSelection() {
        Object[] result = myFilteredList.getSelectedElements();
        return Arrays.asList(result);
	}

	public final void setSelection(List<?> selection) {
		if (selection == null || selection.isEmpty()) {
			myFilteredList.setSelection(null);
		} else {
			addMissingElements(selection);
			myFilteredList.setSelection(selection.toArray());			
		}
	}
	
	private void addMissingElements(List<?> selection) {
		List<Object> els = Arrays.asList(myListElements);
		if (els.containsAll(selection)) {
			return;
		}
		List<Object> elementsToAdd = new ArrayList<Object>(selection.size());
		for (Object next: selection) {
			next = myValidator.validate(next);
			if (next != null && !els.contains(next)) {
				elementsToAdd.add(next);
			}
		}
		addElements(elementsToAdd.toArray(new Object[elementsToAdd.size()]));		
	}
	
	private void addElements(Object[] elements) {
		myListElements = concatArrays(myListElements, elements);
		myFilteredList.setListElements(myListElements);
	}
	
	private Object[] concatArrays(Object[] first, Object[] second) {
		Object[] result = new Object[first.length + second.length];
		System.arraycopy(second, 0, result, 0, second.length);
		System.arraycopy(first, 0, result, second.length, first.length);
		return result;
	}
	
	protected EObject[] collectElements(Object inputElement) {
		List<EObject> result = new LinkedList<EObject>();
		for (Object next : getAllChildren(inputElement)) {
			if (next instanceof EObject) {
				EObject transformed = myValidator.validate((EObject) next);
				if (transformed != null) {
					result.add(transformed);
				}
			}
		}
		return result.toArray(new EObject[result.size()]);
	}

	protected Collection<EObject> getAllChildren(Object parentElement) {
		return ItemPropertyDescriptor.getReachableObjectsOfType(mySourceObject, myFeature.getEType());
//		List<Object> result = new LinkedList<Object>();
//		for (Object next : ModelElementsContentHelper.getChildren(parentElement, myAdapterFctoryContentProvier, myEditingDomain.getResourceSet())) {
//			result.add(next);
//			result.addAll(getAllChildren(next));
//		}
//		return result;
	}

	public void addDoubleClickListener(IDoubleClickListener l) {
		myFilteredList.addDoubleClickListener(l);
	}

	public void addSelectionListener(ISelectionChangedListener l) {
		myFilteredList.addSelectionListener(l);		
	}

}
