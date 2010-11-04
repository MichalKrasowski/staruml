package org.eclipse.uml2.diagram.component.links;

import java.util.Collection;

import org.eclipse.uml2.diagram.common.genapi.IUpdaterLinkDescriptor;
import org.eclipse.uml2.diagram.common.links.InterfaceLinkManager;
import org.eclipse.uml2.diagram.component.part.UMLDiagramEditorPlugin;

public class UMLInterfaceLinkManager extends InterfaceLinkManager<IUpdaterLinkDescriptor> {

	public UMLInterfaceLinkManager(Collection<IUpdaterLinkDescriptor> linkDescriptors) {
		super(linkDescriptors, UMLDiagramEditorPlugin.getInstance().getPreferenceStore());
	}

	@Override
	protected void initFilters() {
		myLinkManagers.add(new RequiredInterfaceLinkFilter(ourHideDerived, ourHideReferencedGenuine));
		myLinkManagers.add(new ProvidedInterfaceLinkFilter(ourHideDerived, ourHideReferencedGenuine));
		myLinkManagers.add(new RegularLinkFilter(ourHideDerived, ourHideReferencedGenuine));
	}

}
