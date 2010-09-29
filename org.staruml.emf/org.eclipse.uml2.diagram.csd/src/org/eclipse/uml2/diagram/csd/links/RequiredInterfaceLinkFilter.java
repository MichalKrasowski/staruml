package org.eclipse.uml2.diagram.csd.links;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.diagram.common.genapi.IUpdaterLinkDescriptor;
import org.eclipse.uml2.diagram.common.links.InterfaceLinkFilter;
import org.eclipse.uml2.diagram.csd.edit.parts.PortRequiredEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.UsageEditPart;

public class RequiredInterfaceLinkFilter extends InterfaceLinkFilter<IUpdaterLinkDescriptor> {

	public RequiredInterfaceLinkFilter(boolean hideDerived, boolean hideReferencedGenuine) {
		super(hideDerived, hideReferencedGenuine);
	}

	@Override
	protected boolean isInterfaceLink(IUpdaterLinkDescriptor link) {
		return PortRequiredEditPart.VISUAL_ID == link.getVisualID() || UsageEditPart.VISUAL_ID == link.getVisualID();
	}

	@Override
	protected EObject getSource(IUpdaterLinkDescriptor link) {
		return link.getSource();
	}
}
