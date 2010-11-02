package org.eclipse.uml2.diagram.common.async;

import org.eclipse.jface.resource.FontRegistry;
import org.eclipse.jface.viewers.BaseLabelProvider;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.IFontProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;


public class SyncModelLabelProvider extends BaseLabelProvider implements ILabelProvider, IFontProvider {
	private final ILabelProvider myDelegate;
	private final FontRegistry myFontRegistry = new FontRegistry();
	protected static final String TREE_FONT = "TreeFont"; //$NON-NLS-1$
	
	public SyncModelLabelProvider(ILabelProvider pluginSpecificDelegate){
		myDelegate = pluginSpecificDelegate;
	}
	
	public Image getImage(Object element) {
		if (false == element instanceof SyncModelNode){
			return null;
		}
		SyncModelNode node = (SyncModelNode) element;
		return myDelegate.getImage(node);
	}
	
	public String getText(Object element) {
		if (false == element instanceof SyncModelNode){
			return null;
		}
		SyncModelNode node = (SyncModelNode) element;
		String text = myDelegate.getText(node);
		return text;
	}
	
	public Font getFont(Object element) {
		if (false == element instanceof SyncModelNode){
			return null;
		}
		SyncModelNode node = (SyncModelNode) element;
		return node.isAutoSynchronized() ? myFontRegistry.getBold(TREE_FONT) : myFontRegistry.get(TREE_FONT);
	}
	
	protected void hookTreeViewer(CheckboxTreeViewer syncUI){
		myFontRegistry.put(TREE_FONT, syncUI.getTree().getFont().getFontData());
	}
	
	protected final FontRegistry getFontRegistry(){
		return myFontRegistry;
	}
	
}
