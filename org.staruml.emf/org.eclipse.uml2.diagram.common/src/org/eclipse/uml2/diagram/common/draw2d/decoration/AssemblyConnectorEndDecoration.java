package org.eclipse.uml2.diagram.common.draw2d.decoration;

import org.eclipse.uml2.diagram.common.conventions.ConnectorEndConvention;
import org.eclipse.uml2.diagram.common.draw2d.RequiredInterfaceDecoration;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;


public class AssemblyConnectorEndDecoration extends RequiredInterfaceDecoration {
	public void updateWithEnd(Connector connector, ConnectableElement diagramEnd){
		ConnectorEnd sourceEnd = ConnectorEndConvention.getConnectorEnd(connector, true);
		boolean forSourceEnd = diagramEnd != null && diagramEnd.equals(sourceEnd.getRole());
		setVisible(forSourceEnd);
	}
}
