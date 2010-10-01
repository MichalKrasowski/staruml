/*
 * Copyright (c) 2008 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Sergey Gribovsky (Borland) - initial API and implementation
 */
package org.eclipse.uml2.diagram.activity.edit.policies;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramColorRegistry;
import org.eclipse.gmf.runtime.notation.LineStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.uml2.diagram.common.editpolicies.AbstractVisualEffectEditPolicy;
import org.eclipse.uml2.diagram.common.preferences.UMLPreferencesConstants;
import org.eclipse.uml2.uml.ValueSpecificationAction;


public class ValueSpecificationActionVisualEffectEditPolicy extends AbstractVisualEffectEditPolicy {
	@Override
	protected void installVisualEffect() {
	}

	@Override
	protected void refreshVisualEffect() {
		EObject semanticHost = getSemanticHost();
		if (false == semanticHost instanceof ValueSpecificationAction) {
			return;
		}
		ValueSpecificationAction action = (ValueSpecificationAction) semanticHost;
		IGraphicalEditPart editPart = getHostImpl();
		if (isValid(action)) {
			LineStyle style = (LineStyle) editPart.getPrimaryView().getStyle(NotationPackage.Literals.LINE_STYLE);
			if (style != null) {
				editPart.getContentPane().setForegroundColor(DiagramColorRegistry.getInstance().getColor(new Integer(style.getLineColor())));
			}
		} else {
			IPreferenceStore store = (IPreferenceStore) editPart.getDiagramPreferencesHint().getPreferenceStore();
			editPart.getContentPane().setForegroundColor(getHighlightColor(store));
		}
	}
	
	private boolean isValid(ValueSpecificationAction action) {
		if (action.getValue() == null) {
			return false;
		}
		
		if (action.getResult() == null) {
			return false;
		}
		
		return true;
	}
	
	private Color getHighlightColor(IPreferenceStore store) {
		RGB rgb = PreferenceConverter.getColor(store, UMLPreferencesConstants.HIGHLIGHT_COLOR);
		return DiagramColorRegistry.getInstance().getColor(rgb);
	}
}
