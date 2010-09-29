package org.eclipse.uml2.diagram.usecase.async;

import org.eclipse.uml2.diagram.common.async.ByVisualIDViewerFilter;
import org.eclipse.uml2.diagram.usecase.edit.parts.DiagramHeaderEditPart;
import org.eclipse.uml2.diagram.usecase.part.UMLVisualIDRegistry;

/**
 * @generated
 */
public class UMLUseCaseDiagramHeaderFilter extends ByVisualIDViewerFilter {

	/**
	 * @generated
	 */
	public static final UMLUseCaseDiagramHeaderFilter SHARED_INSTANCE = new UMLUseCaseDiagramHeaderFilter();

	/**
	 * @generated
	 */
	public UMLUseCaseDiagramHeaderFilter() {
		super(UMLVisualIDRegistry.TYPED_ADAPTER, DiagramHeaderEditPart.VISUAL_ID);
	}
}
