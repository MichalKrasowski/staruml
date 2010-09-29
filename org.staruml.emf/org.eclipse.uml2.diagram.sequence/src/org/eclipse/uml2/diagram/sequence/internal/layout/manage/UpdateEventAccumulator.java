package org.eclipse.uml2.diagram.sequence.internal.layout.manage;

import java.util.ArrayList;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsLink;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsNode;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.gef.AbsDiagramGef;
import org.eclipse.uml2.diagram.sequence.internal.layout.model.SdLayoutModelAddRemoveProcessor;



class UpdateEventAccumulator {
    public UpdateEventAccumulator(AbsDiagramGef.AbsElementFactory absElementFactory, EditPart rootEditPart) {
        myAbsElementFactory = absElementFactory;
        //assert assertAsserterSwitched(rootEditPart);
    }
    
    abstract class UpdateEvent {
        abstract public void process(SdLayoutModelAddRemoveProcessor processor);
    }
    
    class AddNode extends UpdateEvent {
        AddNode(GraphicalEditPart editPart) {
            myNode = myAbsElementFactory.createAbsNode(editPart);
        }
        public void process(SdLayoutModelAddRemoveProcessor processor) {
            processor.processAddedGdeNode(myNode);
        }
        final AbsNode myNode; 
    }
    class RemoveNode extends UpdateEvent {
        RemoveNode(GraphicalEditPart editPart) {
            myNode = myAbsElementFactory.createAbsNode(editPart);
        }
        public void process(SdLayoutModelAddRemoveProcessor processor) {
            processor.processRemovedGdeNode(myNode);
        }
        final AbsNode myNode; 
    }
    class AddLink extends UpdateEvent {
        AddLink(ConnectionEditPart editPart) {
            myLink = myAbsElementFactory.createAbsLink(editPart);
        }
        public void process(SdLayoutModelAddRemoveProcessor processor) {
            processor.processAddedGdeLink(myLink);
        }
        final AbsLink myLink; 
    }
    class RemoveLink extends UpdateEvent {
        RemoveLink(ConnectionEditPart editPart) {
            myLink = myAbsElementFactory.createAbsLink(editPart);
        }
        public void process(SdLayoutModelAddRemoveProcessor processor) {
            processor.processRemovedGdeLink(myLink);
        }
        final AbsLink myLink; 
    }
    
    
    public void elementAdded(IGraphicalEditPart element) {
        if (isUnsupported(element)) {
            return;
        }
        if (element instanceof ConnectionEditPart) {
            myEvents.add(new AddLink((ConnectionEditPart)element));
        } else if (element instanceof GraphicalEditPart) {
            GraphicalEditPart modelNodeEditPart = (GraphicalEditPart)element;
            myAsserterRunner.nodeAdded(modelNodeEditPart);
            myEvents.add(new AddNode(modelNodeEditPart));
        } 
    }
    
    public void elementRemoved(IGraphicalEditPart element) {
        if (isUnsupported(element)) {
            return;
        }
        if (element instanceof ConnectionEditPart) {
            myEvents.add(new RemoveLink((ConnectionEditPart)element));
        } else if (element instanceof GraphicalEditPart) {
            GraphicalEditPart modelNodeEditPart = (GraphicalEditPart)element;
            myAsserterRunner.nodeRemoved(modelNodeEditPart);
            myEvents.add(new RemoveNode(modelNodeEditPart));
        } 
    }
    
    /**
     * All except diagram and interaction
     */
    boolean isUnsupported(IGraphicalEditPart element) {
    	return element instanceof DiagramEditPart || element instanceof ITextAwareEditPart;
    }

    public void accept(SdLayoutModelAddRemoveProcessor processor) {
        try {
            for (int i=0; i<myEvents.size(); i++) {
                ((UpdateEvent)myEvents.get(i)).process(processor);
            }
        } finally {
            processor.finish();
        }
    }

    public void clear() {
        myEvents.clear();
    }
    
//    /**
//     * This method will be invoked if asserts are enabled. Doesn't actually assert anything.
//     */
//    private boolean assertAsserterSwitched(final EditPart rootEditPart) {
//        myAsserterRunner = new AsserterRunner() {
//            final UpdateConsistencyAsserter myAsserter = new UpdateConsistencyAsserter(rootEditPart);
//            void nodeAdded(GraphicalEditPart nodeEditPart) {
//                myAsserter.nodeAdded(nodeEditPart);
//            }
//            void nodeRemoved(GraphicalEditPart nodeEditPart) {
//                myAsserter.nodeRemoved(nodeEditPart);
//            }
//        };
//        return true;
//    }
    
    private final AbsDiagramGef.AbsElementFactory myAbsElementFactory;  
    private final ArrayList myEvents = new ArrayList();
    private AsserterRunner myAsserterRunner = AsserterRunner.STUB; 
    
    private static abstract class AsserterRunner {
        abstract void nodeAdded(GraphicalEditPart nodeEditPart);
        abstract void nodeRemoved(GraphicalEditPart nodeEditPart);
        
        static final AsserterRunner STUB = new AsserterRunner() {
            void nodeAdded(GraphicalEditPart nodeEditPart) {}
            void nodeRemoved(GraphicalEditPart nodeEditPart) {}
        };
    }
}