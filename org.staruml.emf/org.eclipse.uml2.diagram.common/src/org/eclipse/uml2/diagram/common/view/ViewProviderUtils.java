package org.eclipse.uml2.diagram.common.view;

import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;


public class ViewProviderUtils {

	/**
	 * #233241 Comment is not implemented
	 * Comment should have the same color as Note node
	 */
	public static void initializeCommentColor(Node node, PreferencesHint preferencesHint) {
		IPreferenceStore store = (IPreferenceStore) preferencesHint.getPreferenceStore();
		org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(store, IPreferenceConstants.PREF_NOTE_FILL_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getFillStyle_FillColor(), FigureUtilities.RGBToInteger(fillRGB));
		org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(store, IPreferenceConstants.PREF_NOTE_LINE_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getLineStyle_LineColor(), FigureUtilities.RGBToInteger(lineRGB));
	}

}
