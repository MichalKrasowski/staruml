/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Michael Golubev (Borland) - initial API and implementation
 */

package org.eclipse.uml2.diagram.profile.parser.metaclass;


import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.Extension;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;

public class ReplaceReferencedMetaclassCommand extends SetValueCommand {
	private final List<Extension> myAffectedExtensions;
	private final Class myNewMetaclass;
	
	public ReplaceReferencedMetaclassCommand(ElementImport elementImport, org.eclipse.uml2.uml.Class newMetaclass) { 
		super(new SetRequest(elementImport, UMLPackage.eINSTANCE.getElementImport_ImportedElement(), newMetaclass));
		myNewMetaclass = newMetaclass;
		
		myAffectedExtensions = new LinkedList<Extension>();
		PackageableElement oldMetaclass = elementImport.getImportedElement();
		if (isImportedMetaclass(oldMetaclass) && elementImport.getImportingNamespace() instanceof Profile){
			Profile profile = (Profile)elementImport.getImportingNamespace();
			for (Object next : profile.getOwnedExtensions(false)){
				Extension nextExtension = (Extension)next;
				if (oldMetaclass.equals(nextExtension.getMetaclass())){
					myAffectedExtensions.add(nextExtension);
				}
			}
		}
	}
	
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		for (Extension next : myAffectedExtensions){
			replaceExtension(next, myNewMetaclass);
		}
		return super.doExecuteWithResult(monitor, info);
	}
	
	private void replaceExtension(Extension extension, org.eclipse.uml2.uml.Class newMetaclass){
		Stereotype stereotype = extension.getStereotype();
		if (stereotype == null){
			return;
		}
		
		Property metaclassEnd = extension.metaclassEnd();
		
		String newExtensionName = newMetaclass.getName() + "_" + stereotype.getName(); //$NON-NLS-1$
		String newPropertyName = Extension.METACLASS_ROLE_PREFIX + newMetaclass.getName();
		
		extension.setName(newExtensionName);
		metaclassEnd.setName(newPropertyName);
		metaclassEnd.setType(newMetaclass);
	}

	private static boolean isImportedMetaclass(PackageableElement oldImported){
		return (oldImported instanceof org.eclipse.uml2.uml.Class && ((org.eclipse.uml2.uml.Class)oldImported).isMetaclass());
	}
	
}
