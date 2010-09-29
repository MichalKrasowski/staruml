package org.eclipse.uml2.diagram.deploy.part;

import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.palette.IPaletteProvider;
import org.eclipse.ui.IEditorPart;

/**
 * @generated
 */

public class PaletteFactoryProvider extends AbstractProvider implements IPaletteProvider {

	/**
	 * @generated
	 */
	public void contributeToPalette(IEditorPart editor, Object content, PaletteRoot root, Map predefinedEntries) {
		new UMLPaletteFactory().fillPalette(root);
	}

	/**
	 * @generated
	 */
	public void setContributions(IConfigurationElement configElement) {
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		return false;
	}
}
