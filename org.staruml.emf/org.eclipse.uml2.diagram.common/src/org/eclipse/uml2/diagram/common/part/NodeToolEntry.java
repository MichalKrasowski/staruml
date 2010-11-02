package org.eclipse.uml2.diagram.common.part;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;


public class NodeToolEntry extends ToolEntry {

	private final List<IElementType> elementTypes;

	public NodeToolEntry(String title, String description, List<?> elementTypes) {
		super(title, description, null, null);
		this.elementTypes = filterElementTypes(elementTypes);
	}

	@Override
	public Tool createTool() {
		Tool tool = super.createTool();
		if (tool != null) {
			return tool;
		}
		tool = new UnspecifiedTypeCreationTool(elementTypes);
		tool.setProperties(getToolProperties());
		return tool;
	}
	
	public List<IElementType> getElementTypes() {		
		return elementTypes;
	}
	
	public static List<IElementType> filterElementTypes(List<?> list){
		if (list == null || list.isEmpty()){
			return Collections.emptyList();
		}
		ArrayList<IElementType> result = new ArrayList<IElementType>(list.size());
		for (Object next : list){
			if (next instanceof IElementType){
				result.add((IElementType)next);
			}
		}
		return result;
	}

}
