package org.star.uml.designer.ui.factory;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.*;


public class StarUMLDiagramCreationFactory {
	
	public static Resource getResource(String actionID,URI diagramURI,URI modelURI,IProgressMonitor monitor){
		Resource diagram = null;
		if(actionID.equals("UsecaseDiagram")){
			diagram = org.eclipse.uml2.diagram.usecase.part.UMLDiagramEditorUtil.createDiagram(diagramURI, modelURI, null, "UTF-8", monitor);
		}
		return diagram;
	}
}
