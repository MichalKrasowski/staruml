package org.eclipse.uml2.diagram.common.async;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.uml2.diagram.common.async.SyncModelContext;
import org.eclipse.uml2.diagram.common.async.SyncModelNode;

/**
 * Wraps {@link SyncModelContext} in order to push the user synchronization
 * changes into the new created diagram.
 */
public class NewDiagramSyncHelper {
	private static final String TEMP_DIAGRAM_RESOURCE_URI = "uri://" + NewDiagramSyncHelper.class.getName() + "/diagram.xml"; //$NON-NLS-1$ //$NON-NLS-2$

	private final String myDiagramModelId;
	
	private SyncModelContext myContext;
	
	private Resource myTempDiagramResource;
	
	private EObject mySemanticRoot;

	private Diagram myTempDiagram;
	
	private SyncModelNode myRootSyncNode;
	
	private boolean myIsDisposed;
	
	public NewDiagramSyncHelper(SyncModelContext context, String diagramModelId){
		myContext = context;
		myDiagramModelId = diagramModelId;
		myTempDiagramResource = context.getDomain().getResourceSet().createResource(URI.createURI(TEMP_DIAGRAM_RESOURCE_URI));
	}
	
	public void setSemanticRoot(EObject newRoot) {
		if (mySemanticRoot != newRoot) {
			if (mySemanticRoot != null) {
				unloadTempDiagram();
				myRootSyncNode = null;
			}
			loadTempDiagram(newRoot);
			
			final Diagram syncDiagram = ViewService.createDiagram(newRoot, myDiagramModelId, myContext.getPreferencesHint());
			myContext.runCommand(new Runnable() {
				public void run() {
					myContext.getSyncModelResource().getContents().clear();
					myContext.getSyncModelResource().getContents().add(syncDiagram);
				}
			});
			
			myRootSyncNode = createRootNode(myContext, syncDiagram, myTempDiagram);
			mySemanticRoot = newRoot;
		}
	}	
	
	protected SyncModelNode createRootNode(SyncModelContext context, Diagram syncDiagram, Diagram subjectDiagram) {
		return new SyncModelNode(syncDiagram, myTempDiagram, context);
	}
	
	public Diagram getNewDiagram() {
		return myTempDiagram;
	}
	
	public SyncModelNode getSyncRoot() {
		return myRootSyncNode;
	}
	
	private void unloadTempDiagram() {
		if (myTempDiagram == null || myTempDiagramResource == null) {
			return;
		}
		myContext.runCommand(new Runnable() {
			public void run() {
				myTempDiagramResource.getContents().remove(myTempDiagram);
				myTempDiagram = null;
			}
		});
	}
	
	private void loadTempDiagram(final EObject semanticRoot) {
		if (myTempDiagram != null) {
			throw new IllegalStateException();
		}
		myContext.runCommand(new Runnable() {

			public void run() {
				myTempDiagram = ViewService.createDiagram(semanticRoot, myDiagramModelId, myContext.getPreferencesHint());
				myTempDiagramResource.getContents().add(myTempDiagram);
			}
		});
	}
	
	private void disposeTempDiagramResource() {
		if (myTempDiagramResource != null) {
			myTempDiagramResource.unload();
			myContext.getDomain().getResourceSet().getResources().remove(myTempDiagramResource);
		}
	}
	
	public void dispose() {
		if (!myIsDisposed){
			myIsDisposed = true;
			myContext.dispose(); //this unloads sync-model resource only	
			disposeTempDiagramResource();
			
			myContext = null;
			myTempDiagramResource = null;
			myTempDiagram = null;
			myRootSyncNode = null;
		}
	}

}
