package org.eclipse.uml2.diagram.common.async;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class SyncModelContentProvider implements ITreeContentProvider {
	private static final Object[] NOTHING = new Object[0];

	public Object[] getChildren(Object parentElement) {
		if (false == parentElement instanceof SyncModelNode){
			return NOTHING;
		}
		SyncModelNode parent = (SyncModelNode)parentElement;
		return parent.getChildren().toArray();
	}

	public Object getParent(Object element) {
		return element instanceof SyncModelNode ? ((SyncModelNode)element).getParent() : null;
	}

	public boolean hasChildren(Object element) {
		return element instanceof SyncModelNode && !((SyncModelNode)element).isKnownLeaf();
	}

	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof SyncModelNode){
			return new Object[] {inputElement};
		}
		if (inputElement instanceof SyncModelNode[]){
			return (SyncModelNode[])inputElement;
		}
		if (inputElement instanceof Collection){
			List<SyncModelNode> input = new ArrayList<SyncModelNode>(((Collection<?>)inputElement).size());
			for (Object next : (Collection<?>)inputElement){
				if (next instanceof SyncModelNode){
					input.add((SyncModelNode)next);
				}
			}
			return input.toArray();
		}
		return NOTHING;
	}

	public void dispose() {
		// TODO Auto-generated method stub
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		//
	}
}
