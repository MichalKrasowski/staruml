package org.eclipse.uml2.diagram.csd.links;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.diagram.common.genapi.IUpdaterLinkDescriptor;
import org.eclipse.uml2.diagram.common.links.InterfaceLinkFilter;
import org.eclipse.uml2.diagram.csd.edit.parts.InterfaceRealizationEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.PortProvidedEditPart;


public class ProvidedInterfaceLinkFilter extends InterfaceLinkFilter<IUpdaterLinkDescriptor> {

	public ProvidedInterfaceLinkFilter(boolean hideDerived, boolean hideReferencedGenuine) {
		super(hideDerived, hideReferencedGenuine);
	}

	@Override
	protected boolean isInterfaceLink(IUpdaterLinkDescriptor link) {
		return PortProvidedEditPart.VISUAL_ID == link.getVisualID() || InterfaceRealizationEditPart.VISUAL_ID == link.getVisualID();
	}

	@Override
	protected EObject getSource(IUpdaterLinkDescriptor link) {
		return link.getSource();
	}

}
