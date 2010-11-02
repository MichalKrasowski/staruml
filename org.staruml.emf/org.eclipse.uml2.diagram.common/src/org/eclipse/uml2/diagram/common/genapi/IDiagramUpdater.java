package org.eclipse.uml2.diagram.common.genapi;

import java.util.List;

import org.eclipse.gmf.runtime.notation.View;


public interface IDiagramUpdater {
	public List<IUpdaterNodeDescriptor> getSemanticChildren(View view);
	public List<IUpdaterLinkDescriptor> getContainedLinks(View view);
	public List<IUpdaterLinkDescriptor> getIncomingLinks(View view);
	public List<IUpdaterLinkDescriptor> getOutgoingLinks(View view);
}
