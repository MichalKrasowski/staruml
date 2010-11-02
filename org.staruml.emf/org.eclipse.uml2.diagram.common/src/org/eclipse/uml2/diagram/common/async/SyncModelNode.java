package org.eclipse.uml2.diagram.common.async;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.common.genapi.IDiagramUpdater;
import org.eclipse.uml2.diagram.common.genapi.IUpdaterNodeDescriptor;
import org.eclipse.uml2.diagram.common.genapi.IVisualIDRegistry;

public class SyncModelNode implements IAdaptable {

	private final SyncModelContext myContext;

	private final View mySyncModelView;

	private List<SyncModelNode> myChildren;

	private SyncModelNode myParent;

	private View mySyncModelCompartment;

	private View myDiagramView;

	private boolean myIsAutoSynchronized;

	private boolean myIsChecked;

	public SyncModelNode(View syncModelRoot, View diagramRoot, SyncModelContext context) {
		this(syncModelRoot, (SyncModelNode) null, context);
		if (syncModelRoot == null){
			throw new NullPointerException();
		}
		if (diagramRoot != null){
			if (diagramRoot.getElement() == null){
				throw new IllegalArgumentException("Diagram root should have an semantic element"); //$NON-NLS-1$
			}
			if (!diagramRoot.getElement().equals(syncModelRoot.getElement())){
				throw new IllegalArgumentException("Diagram root element : " + diagramRoot.getElement() + ", while SyncModel root element: " + syncModelRoot.getElement()); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}
		initWithDiagramView(diagramRoot);
	}

	protected SyncModelNode(View syncModelView, SyncModelNode parent) {
		this(syncModelView, parent, parent.getContext());
	}

	private SyncModelNode(View syncModelView, SyncModelNode parent, SyncModelContext context) {
		mySyncModelView = syncModelView;
		myParent = parent;
		if (myParent != null) {
			myParent.addChild(this);
		}
		myContext = context;
	}

	public boolean isRoot() {
		return getParent() == null;
	}

	public void setChecked(boolean isChecked) {
		myIsChecked = isChecked;
	}

	public boolean isChecked() {
		return myIsChecked;
	}

	public View getSyncModelView() {
		return mySyncModelView;
	}

	public View getDiagramView() {
		return myDiagramView;
	}

	public boolean isKnownLeaf() {
		int visualID = getContext().getRegistry().getVisualID(mySyncModelView);
		return getContext().getRegistry().isSemanticLeafVisualID(visualID);
	}

	public boolean isInCompartment() {
		return mySyncModelCompartment != null;
	}

	public View getSyncModelCompartment() {
		return mySyncModelCompartment;
	}

	public boolean isAutoSynchronized() {
		return myIsAutoSynchronized;
	}
	
	public void setAutoSynchronized(boolean isAutoSynchronized) {
		myIsAutoSynchronized = isAutoSynchronized;
	}

	public List<SyncModelNode> getChildren() {
		if (myChildren == null) {
			myChildren = new LinkedList<SyncModelNode>();
			createSyncModelChildren();
			if (myChildren.isEmpty()) {
				myChildren = Collections.emptyList();
			}
		}
		return myChildren;
	}

	public SyncModelNode getParent() {
		return myParent;
	}

	private void setCompartment(View compartment) {
		mySyncModelCompartment = compartment;
	}

	public SyncModelContext getContext() {
		return myContext;
	}

	private IDiagramUpdater getUpdater() {
		return myContext.getUpdater();
	}

	private PreferencesHint getPreferencesHint() {
		return myContext.getPreferencesHint();
	}

	private void addChild(SyncModelNode child) {
		myChildren.add(child);
	}

	private void createSyncModelChildren() {
		myContext.runCommand(new Runnable() {

			public void run() {
				doCreateSyncModelChildren();
			}
		});
	}

	private void doCreateSyncModelChildren() {
		List<View> directChildren = createChildViews(mySyncModelView);
		for (View nextDirect : directChildren) {
			SyncModelNode child = doCreateNodeView(nextDirect, this);
			View diagramCounterpart = findCounterpart(nextDirect, myDiagramView);
			child.initWithDiagramView(diagramCounterpart);
		}

		for (Object next : mySyncModelView.getChildren()) {
			View nextSyncCompartment = (View) next;
			if (isCompartment(nextSyncCompartment)) {
				View diagramCompartment = findCounterpart(nextSyncCompartment, myDiagramView);
				List<View> syncCompartmentChildren = createChildViews(nextSyncCompartment);
				for (View nextCompartmentChild : syncCompartmentChildren) {
					SyncModelNode nextResult = doCreateNodeView(nextCompartmentChild, this);
					nextResult.setCompartment(nextSyncCompartment);
					View diagramCounterpart = findCounterpart(nextCompartmentChild, diagramCompartment);
					nextResult.initWithDiagramView(diagramCounterpart);
				}
			}
		}
	}
	
	protected SyncModelNode doCreateNodeView(View syncModelView, SyncModelNode parent) {
		return new SyncModelNode(syncModelView, parent);
	}

	private boolean isCompartment(View view) {
		IVisualIDRegistry registry = getContext().getRegistry();
		int visualId = registry.getVisualID(view);
		return registry.isCompartmentVisualID(visualId);
	}

	private List<View> createChildViews(View syncModelParent) {
		List<?> descriptors = getUpdater().getSemanticChildren(syncModelParent);
		List<View> result = new LinkedList<View>();
		for (Object next : descriptors) {
			IUpdaterNodeDescriptor nextDescriptor = (IUpdaterNodeDescriptor) next;
			EObject nextSemanticChild = nextDescriptor.getModelElement();
			View nextView = ViewService.getInstance().createView(Node.class, //
					new EObjectAdapter(nextSemanticChild), syncModelParent, null, //
					ViewUtil.APPEND, true, getPreferencesHint());

			if (nextView != null) {
				result.add(nextView);
			}
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public Object getAdapter(Class adapter) {
		if (adapter.equals(View.class)) {
			return mySyncModelView;
		}
		if (adapter.isInstance(this)) {
			return this;
		}
		return null;
	}

	public static View findCounterpart(View syncChild, View diagramParent) {
		if (diagramParent == null) {
			return null;
		}
		for (Object nextChild : diagramParent.getChildren()) {
			View nextDiagramChild = (View) nextChild;
			if (isCounterparts(syncChild, nextDiagramChild)) {
				return nextDiagramChild;
			}
		}
		return null;
	}

	public static boolean isCounterparts(View syncView, View diagramView) {
		if (syncView.getType() == null || diagramView.getType() == null) {
			return false;
		}
		if (!syncView.getType().equals(diagramView.getType())) {
			return false;
		}
		if (syncView.getElement() == null) {
			//compartment
			return diagramView.getElement() == null;
		}
		return syncView.getElement().equals(diagramView.getElement());
	}
	
	public void applyCanonicalStyle(){
		checkHasDiagramView();
		applyCanonicalStyle(getDiagramView());
	}
	
	private void applyCanonicalStyle(View view){
		if (isKnownLeaf()){
			return;
		}
		doApplyCanonicalStyle(view);
		
		for (Object nextChild : view.getChildren()){
			View nextChildView = (View)nextChild;
			if (isCompartment(nextChildView)){
				doApplyCanonicalStyle(nextChildView);
			}
		}
	}

	private void doApplyCanonicalStyle(View target) {
		ICanonicalHelper.IMPLEMENTATION.setAutoSynchronized(target, isAutoSynchronized());
	}
	
	protected void initWithDiagramView(View diagramView) {
		myDiagramView = diagramView;
		if (myDiagramView != null){
			setChecked(true);
			myIsAutoSynchronized = ICanonicalHelper.IMPLEMENTATION.isAutoSynchronized(myDiagramView);
		} else {
			myIsAutoSynchronized = getContext().isDiagramInitialization();
			setChecked(getContext().isDiagramInitialization());
		}

		if (isKnownLeaf()){
			myIsAutoSynchronized = false;
		}
	}
	
	private void checkHasDiagramView(){
		if (getDiagramView() == null){
			throw new IllegalStateException("I am not associated with diagram view:" + getSyncModelView()); //$NON-NLS-1$
		}	
	}

	/*package*/ void associateWithDiagramView(View diagramView) {
		if (myDiagramView != null){
			throw new IllegalStateException("I have diagram view already: " + myDiagramView + ", cant be associated with: " + diagramView); //$NON-NLS-1$ //$NON-NLS-2$
		}
		myDiagramView = diagramView;
	}

}
