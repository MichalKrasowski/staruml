package org.eclipse.uml2.diagram.common.part;

import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;


public class LinkToolEntry extends ToolEntry {

	private final List<IElementType> relationshipTypes;

	public LinkToolEntry(String title, String description, List<?> relationshipTypes) {
		super(title, description, null, null);
		this.relationshipTypes = NodeToolEntry.filterElementTypes(relationshipTypes);
	}

	@Override
	public Tool createTool() {
		Tool tool = new UnspecifiedTypeConnectionTool(relationshipTypes);
		tool.setProperties(getToolProperties());
		return tool;
	}

	public List<IElementType> getElementTypes() {		
		return relationshipTypes;
	}

}
