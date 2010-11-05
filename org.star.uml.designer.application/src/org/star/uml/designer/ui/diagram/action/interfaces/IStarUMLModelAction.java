package org.star.uml.designer.ui.diagram.action.interfaces;

import java.net.URL;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.MetamodelType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.diagram.usecase.edit.helpers.UMLBaseEditHelper;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.internal.impl.ActorImpl;
import org.eclipse.uml2.uml.internal.impl.UMLFactoryImpl;
import org.osgi.framework.Bundle;
import org.star.uml.designer.application.Activator;
import org.star.uml.designer.base.utils.EclipseUtile;
import org.star.uml.designer.ui.factory.StarUMLCommandFactory;
import org.star.uml.designer.ui.factory.StarUMLEditHelperFactory;

public interface IStarUMLModelAction {
	
	public URL getImageURL();
	
	public ImageDescriptor getImageDescriptor();
	
}
