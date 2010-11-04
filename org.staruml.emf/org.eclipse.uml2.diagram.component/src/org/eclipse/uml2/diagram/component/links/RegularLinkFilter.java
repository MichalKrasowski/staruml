package org.eclipse.uml2.diagram.component.links;

import java.util.Collection;
import java.util.LinkedList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.diagram.common.genapi.IUpdaterLinkDescriptor;
import org.eclipse.uml2.diagram.common.links.InterfaceLinkFilter;
import org.eclipse.uml2.diagram.component.edit.parts.InterfaceRealizationEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.PortProvidedEditPart;
import org.eclipse.uml2.diagram.component.edit.parts.PortRequiredEditPart;

public class RegularLinkFilter extends InterfaceLinkFilter<IUpdaterLinkDescriptor> {

	private final Collection<IUpdaterLinkDescriptor> myRegularLinks = new LinkedList<IUpdaterLinkDescriptor>();

	public RegularLinkFilter(boolean hideDerived, boolean hideReferencedGenuine) {
		super(hideDerived, hideReferencedGenuine);
	}

	@Override
	public void visit(IUpdaterLinkDescriptor link) {
		if (isRegularLink(link)) {
			myRegularLinks.add(link);
		}
	}

	private boolean isRegularLink(IUpdaterLinkDescriptor link) {
		int vid = link.getVisualID();
		return PortProvidedEditPart.VISUAL_ID != vid && InterfaceRealizationEditPart.VISUAL_ID != vid && PortRequiredEditPart.VISUAL_ID != vid;
	}

	@Override
	public Collection<IUpdaterLinkDescriptor> getFilteredLinks() {
		return myRegularLinks;
	}

	@Override
	protected EObject getSource(IUpdaterLinkDescriptor link) {
		return link.getSource();
	}
}
