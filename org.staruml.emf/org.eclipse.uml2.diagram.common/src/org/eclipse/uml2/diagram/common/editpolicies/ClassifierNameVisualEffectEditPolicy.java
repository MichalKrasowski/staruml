/*
 * Copyright (c) 2008 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Michael Golubev (Borland) - initial API and implementation
 */
package org.eclipse.uml2.diagram.common.editpolicies;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.notation.FontStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.UMLPackage;

public class ClassifierNameVisualEffectEditPolicy extends AbstractVisualEffectEditPolicy {

	@Override
	protected boolean shouldHandleNotificationEvent(Notification event) {
		return UMLPackage.eINSTANCE.getClassifier_IsAbstract() == event.getFeature();
	}

	@Override
	protected void refreshVisualEffect() {
		EObject semanticHost = getSemanticHost();
		if (false == semanticHost instanceof Classifier) {
			return;
		}
		Classifier classifier = (Classifier) semanticHost;
		IGraphicalEditPart editPart = getHostImpl();
		View view = editPart.getNotationView();
		FontStyle fontStyle = (FontStyle) view.getStyle(NotationPackage.eINSTANCE.getFontStyle());
		if (fontStyle != null && fontStyle.isItalic() != classifier.isAbstract()) {
			SetRequest request = new SetRequest(editPart.getEditingDomain(), fontStyle, NotationPackage.eINSTANCE.getFontStyle_Italic(), classifier.isAbstract());
			executeCommand(new ICommandProxy(new SetValueCommand(request)));
		}
	}

	@Override
	protected void installVisualEffect() {
		ensureHasStyle(NotationPackage.eINSTANCE.getFontStyle());
		ensureHasBoldType();
	}

	private void ensureHasBoldType() {
		IGraphicalEditPart editPart = getHostImpl();
		View view = editPart.getNotationView();
		FontStyle fontStyle = (FontStyle) view.getStyle(NotationPackage.eINSTANCE.getFontStyle());
		if (false == fontStyle.isBold()){
			SetRequest request = new SetRequest(editPart.getEditingDomain(), fontStyle, NotationPackage.eINSTANCE.getFontStyle_Bold(), true);
			executeCommand(new ICommandProxy(new SetValueCommand(request)));
		}
	}
}
