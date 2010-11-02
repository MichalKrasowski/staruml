package org.eclipse.uml2.diagram.common.async;

import org.eclipse.gmf.runtime.notation.View;


public interface ICanonicalHelper {
	public static final ICanonicalHelper IMPLEMENTATION = new CanonicalHelper();
	
	public boolean shouldSyncNodes(View view);
	public boolean shouldSyncLinks(View view);
	
	public boolean isAutoSynchronized(View view);
	public void setAutoSynchronized(View view, boolean isAutoSync);
}
