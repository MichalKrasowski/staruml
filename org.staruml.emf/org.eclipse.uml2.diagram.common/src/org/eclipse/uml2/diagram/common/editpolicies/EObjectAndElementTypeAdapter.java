package org.eclipse.uml2.diagram.common.editpolicies;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;


public class EObjectAndElementTypeAdapter extends EObjectAdapter {
	private final IElementType myElementType;

	public EObjectAndElementTypeAdapter(EObject subject, IElementType elementType){
		super(subject);
		myElementType = elementType;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Object getAdapter(Class adapter) {
		if (adapter.isInstance(myElementType)) {
			return myElementType;
		}
		return super.getAdapter(adapter);
	}
}
