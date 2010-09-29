package org.eclipse.uml2.diagram.sequence.internal.layout.manage;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsLink;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsNode;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.gef.AbsDiagramGef;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.gef.AbsElementGef;
import org.eclipse.uml2.diagram.sequence.internal.layout.horizontal.SDHorizontalLayout;
import org.eclipse.uml2.diagram.sequence.internal.layout.model.JustReshapedState;
import org.eclipse.uml2.diagram.sequence.internal.layout.model.LmAlienElement;
import org.eclipse.uml2.diagram.sequence.internal.layout.model.LmObjectsResolver;
import org.eclipse.uml2.diagram.sequence.internal.layout.model.LmReshapable;
import org.eclipse.uml2.diagram.sequence.internal.layout.model.SDLayoutModel;
import org.eclipse.uml2.diagram.sequence.internal.layout.model.SdLayoutModelAccess;
import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.SDVerticalLayout;


/**
 * 
 */
public class SdGdeLayoutManager {
    SdGdeLayoutManager(EditPartViewer diagram) {
        //myAbsDiagramGef = new AbsDiagramGef(diagram);
        myAbsDiagramGef = new AbsDiagramGef(null);//TODO: find interaction EditPart        
        
        myEvents = new UpdateEventAccumulator(myAbsDiagramGef.getAbsElementFactory(), diagram.getContents());
        
        myLayoutModelHolder = new LayoutModelHolder();
        
        myHorizontalLayout = new SDHorizontalLayout(myLayoutModelHolder);

        
        
        SDVerticalLayout.Config verticalLayoutConfig = new SDVerticalLayout.Config() { 
        };
        myVerticalLayout = new SDVerticalLayout(myLayoutModelHolder, verticalLayoutConfig);
    }

    public Collection initialLayout() {
        processUpdates();
        
        //applyLayoutConstraints();
        return Collections.EMPTY_LIST;
    }

    public Collection fullLayout(boolean forPrinting, Dimension gridDimension, Collection except) {
        applyLayoutConstraints();
        return Collections.EMPTY_LIST;
    }

    public Collection innerLayout(GraphicalEditPart subdiagram) {
        // TODO Auto-generated method stub
        return null;
    }

    public Collection elementsReshaped(Collection elements) {
        myServer.incrementCode();
        
        JustReshapedState justReshapedState = new JustReshapedState(myServer);
        
        LmObjectsResolver resolver = myLayoutModelHolder.getLayoutModel().getLmObjectsResolver();
        for (Iterator it = elements.iterator(); it.hasNext();) {
        	IGraphicalEditPart editPart = (IGraphicalEditPart)it.next();
            Object lmObject = resolver.getLmObject(myAbsDiagramGef.getAbsElementFactory().createAbsElement(editPart));
            if (lmObject instanceof LmReshapable) {
                ((LmReshapable) lmObject).setJustReshaped(justReshapedState);
            }
        }
        
        applyLayoutConstraints();
        return elements;
    }

    public void elementsProperlyReshaped(Collection elements) {
        // TODO Auto-generated method stub
    }

    public void elementAdded(IGraphicalEditPart element) {
        myEvents.elementAdded(element);
    }

    public void elementRemoved(ConnectionEditPart element) {
        myEvents.elementRemoved(element);
    }

    public void processUpdates() {
        try {
            //myEvents.accept(myChecker);
            myEvents.accept(myLayoutModelHolder.getLayoutModel().newAddRemoveProcessor());
            applyLayoutConstraints();
        } finally {
            myEvents.clear();
        }
    }
    
    private void applyLayoutConstraints() {
        applyLayoutConstraintsImpl();
        
        assert assertLayoutDoesntMoveElementsNow();
    }

    /**
     * Returns true or fail assert inside
     */
    private boolean assertLayoutDoesntMoveElementsNow() {
        AbsDiagramGef.ChangePositionWatcher.ChangePositionListener nonexpectingChangePositionListener = new AbsDiagramGef.ChangePositionWatcher.ChangePositionListener() {
            public void positionIsChanged(AbsElementGef absElement, int coordCode) {
                assert false : "Positions are different second time"; //$NON-NLS-1$
            }
        };
        myAbsDiagramGef.getChangePositionWatcher().setListener(nonexpectingChangePositionListener);
        try {
            applyLayoutConstraintsImpl();
        } finally {
            myAbsDiagramGef.getChangePositionWatcher().setListener(null);
        }
        return true;
    }
    private void applyLayoutConstraintsImpl() {
        myVerticalLayout.doLayout(false, 0);
        myHorizontalLayout.applyConstraints(0, false);
    }

    
    private class LayoutModelHolder implements SdLayoutModelAccess {
        LayoutModelHolder() {
            createNewModelImpl(true);
        }
        public SDLayoutModel getLayoutModel() {
            return myLayoutModel;
        }
        void createAnotherModel() {
            createNewModelImpl(true);
        }
        private void createNewModelImpl(boolean secondary) {
            myLayoutModel = new SDLayoutModel(myAbsDiagramGef, secondary, myAlienElementfactory, new SDLayoutModel.Config() {}, null); 
        }
        private SDLayoutModel myLayoutModel;
    }

    private final AbsDiagramGef myAbsDiagramGef;
    private final LmAlienElement.Factory myAlienElementfactory = new LmAlienElement.Factory() {
        public LmAlienElement createAlienNode(AbsNode gdeNode) {
            // TODO
            return new LmAlienElement() {public void dispose() {}};
        }
        public LmAlienElement createAlienLink(AbsLink gdeLink) {
            // TODO
            return new LmAlienElement() {public void dispose() {}};
        }
    };
    
    private final LayoutModelHolder myLayoutModelHolder;
    
    private final SDHorizontalLayout myHorizontalLayout;
    private final SDVerticalLayout myVerticalLayout;
    final UpdateEventAccumulator myEvents;
    private final ReshapeServerImpl myServer = new ReshapeServerImpl();
    
    
    static class ReshapeServerImpl implements JustReshapedState.Server {
        public int getCurrentReshapeCode() {
            return myReshapeCode;
        }
        void incrementCode() {
            myReshapeCode++;
        }
        private int myReshapeCode = 0;
    }
}
