package org.eclipse.uml2.diagram.sequence.view.factories;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gmf.runtime.diagram.ui.view.factories.BasicNodeViewFactory;
import org.eclipse.gmf.runtime.notation.FontStyle;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.Style;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */

public class CombinedFragmentInteractionOperatorViewFactory extends BasicNodeViewFactory {

	/**
	 * @generated NOT
	 */
	protected List<?> createStyles(View view) {
		List<Style> styles = new ArrayList<Style>();
		FontStyle fontStyle = NotationFactory.eINSTANCE.createFontStyle();
		fontStyle.setBold(true);
		styles.add(fontStyle);
		return styles;
	}
}
