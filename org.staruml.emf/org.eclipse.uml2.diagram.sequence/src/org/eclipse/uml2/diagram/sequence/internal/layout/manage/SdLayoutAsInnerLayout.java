package org.eclipse.uml2.diagram.sequence.internal.layout.manage;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.sequence.edit.parts.InteractionEditPart;
import org.eclipse.uml2.diagram.sequence.internal.layout.GeometryConstants;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsElement;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsElementPropertyAccess;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsNode;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.gef.AbsDiagramGef;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.gef.AbsElementGef;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.gef.AbsNodeGef;
import org.eclipse.uml2.diagram.sequence.internal.layout.alien.AlienElementFactoryImpl;
import org.eclipse.uml2.diagram.sequence.internal.layout.alien.DummyAlienElementsLayout;
import org.eclipse.uml2.diagram.sequence.internal.layout.alien.IAlienElementsLayout;
import org.eclipse.uml2.diagram.sequence.internal.layout.horizontal.LifelineCoveringFramesCache;
import org.eclipse.uml2.diagram.sequence.internal.layout.horizontal.SDHorizontalLayout;
import org.eclipse.uml2.diagram.sequence.internal.layout.model.JustReshapedState;
import org.eclipse.uml2.diagram.sequence.internal.layout.model.LmAlienElement;
import org.eclipse.uml2.diagram.sequence.internal.layout.model.LmObjectsResolver;
import org.eclipse.uml2.diagram.sequence.internal.layout.model.LmReshapable;
import org.eclipse.uml2.diagram.sequence.internal.layout.model.SDLayoutModel;
import org.eclipse.uml2.diagram.sequence.internal.layout.model.SdLayoutModelAccess;
import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.SDVerticalLayout;
import org.eclipse.uml2.uml.Interaction;


/**
 * 
 */
public class SdLayoutAsInnerLayout implements LifelineMotionListener /*, NestedLayout*/ {
	public SdLayoutAsInnerLayout(InteractionEditPart modelNodeEditPart) {
		this(modelNodeEditPart, (Interaction)modelNodeEditPart.resolveSemanticElement());
	}
	
    public SdLayoutAsInnerLayout(InteractionEditPart modelNodeEditPart, Interaction interactionEntity) {
        myAbsDiagramWithRootNode = new AbsDiagramGef(modelNodeEditPart);
        
        myInteractionEntity = interactionEntity;
        myInteractionView = modelNodeEditPart.getNotationView();
        
        myEvents = new UpdateEventAccumulator(myAbsDiagramWithRootNode.getAbsElementFactory(), modelNodeEditPart);
        
        myLayoutModelHolder = new LayoutModelHolder(false);
        
        myHorizontalLayout = new SDHorizontalLayout(myLayoutModelHolder);

        
        
        SDVerticalLayout.Config verticalLayoutConfig = new SDVerticalLayout.Config() { 
        };
        myVerticalLayout = new SDVerticalLayout(myLayoutModelHolder, verticalLayoutConfig);
        

        //[U2T] in Arcas was: 
        //myAlienElementsLayout = new AlienElementsLayout(myLayoutModelHolder, myAbsDiagramWithRootNode, new AbsLayoutAccessGef(modelNodeEditPart.getViewer()));        
        myAlienElementsLayout = new DummyAlienElementsLayout();
    }

    private void elementAdded(IGraphicalEditPart element) {
        myEvents.elementAdded(element);
    }

    private void elementRemoved(IGraphicalEditPart element) {
        myEvents.elementRemoved(element);
    }
    
    public void nodeAdded(GraphicalEditPart modelNodeEditPart) {
        elementAdded(modelNodeEditPart);
    }

    public void nodeRemoved(GraphicalEditPart modelNodeEditPart) {
        elementRemoved(modelNodeEditPart);
    }

    public void linkAdded(ConnectionEditPart modelLinkEditPart) {
        elementAdded(modelLinkEditPart);
        myInteractionLinksProvider.add(modelLinkEditPart);
    }

    public void linkRemoved(ConnectionEditPart modelLinkEditPart) {
        elementRemoved(modelLinkEditPart);
        myInteractionLinksProvider.remove(modelLinkEditPart);
    }

    public void elementReshaped(IGraphicalEditPart modelElementEditPart) {
        JustReshapedState justReshapedState = new JustReshapedState(myServer);
        
        
        AbsElement absElement = myAbsDiagramWithRootNode.getAbsElementFactory().createAbsElement(modelElementEditPart);
        
        myAlienElementProcessor.elementReshaped(absElement);
        
        LmObjectsResolver resolver = myLayoutModelHolder.getLayoutModel().getLmObjectsResolver();
        Object lmObject = resolver.getLmObject(absElement);
        
        if (lmObject instanceof LmReshapable) {
        
            startAdditionalReshapingListening();
            try {
                ((LmReshapable) lmObject).setJustReshaped(justReshapedState);
            } finally {
                stopAdditionalReshapingListening();
            }
            
        }
    }
    public Collection performLayout() {
        Collection result = performLayout(false);
        result.addAll(myAdditionalReshapeElements);
        myAdditionalReshapeElements.clear();
        return result;
    }
    public Collection performFullLayout() {
        if (!myAdditionalReshapeElements.isEmpty()) {
            throw new IllegalStateException();
        }
        return performLayout(true);
    }


    public void lifelineMoved(int horizontalDelta, GraphicalEditPart lifelineEditPart) {
        LifelineCoveringFramesCache cache = myHorizontalLayout.getLifelineCoveringFramesCache();
        if (cache == null) {
            assert false;
            return;
        }
        LifelineCoveringFramesCache.LifelineCoveringFramesMover mover = cache.getLifelineCoveringFramesMover(myAbsDiagramWithRootNode.getAbsElementFactory().createAbsNode(lifelineEditPart));
        if (mover != null) {
            startAdditionalReshapingListening();
            try {
                mover.lifelineMoved(horizontalDelta);
            } finally {
                stopAdditionalReshapingListening();
            }
        }
    }
    
    public InteractionLinksProvider getInteractionLilnksProvider() {
        return myInteractionLinksProvider;
    }
    
    private Collection performLayout(boolean fullLayout) {
        Collection result;
        
        try {
            //myEvents.accept(myChecker);
            myEvents.accept(myLayoutModelHolder.getLayoutModel().newAddRemoveProcessor());
            myEvents.accept(myAlienElementProcessor);
            result = performSdLayout(fullLayout);
        } finally {
            myEvents.clear();
            myAlienElementProcessor = new AlienElementProcessor();
        }
        
        myServer.incrementCode();
        
        return result;
    }
    
    private static abstract class DebugPositionWatcherGate {
        abstract void positionIsChanged(AbsElementGef absElement, int coordCode);
        abstract void finish();

        static final DebugPositionWatcherGate TRIVIAL = new DebugPositionWatcherGate() {
            void positionIsChanged(AbsElementGef absElement, int coordCode) {}
            void finish() {}
        };
    }
    
    private static class DebugPositionWatcher extends DebugPositionWatcherGate {
        void positionIsChanged(AbsElementGef absElement, int coordCode) {
            validateAll();
            if (coordCode == 0) {
                return;
            }
            final AbsNodeGef node = (AbsNodeGef) absElement;
            
            final PositionHolder holder; // initialize once
            
            switch (coordCode) {
            case AbsDiagramGef.ChangePositionWatcher.ChangePositionListener.X:
                holder = new PositionHolder() {
                    int myX = node.getX();
                    void validate() {
                        assert node.getX() == myX;
                    }
                };
                break;
            case AbsDiagramGef.ChangePositionWatcher.ChangePositionListener.Y:
                holder = new PositionHolder() {
                    int myY = node.getY();
                    void validate() {
                        assert node.getY() == myY;
                    }
                };
                break;
            case AbsDiagramGef.ChangePositionWatcher.ChangePositionListener.WIDTH:
                holder = new PositionHolder() {
                    int myWidth = node.getWidth();
                    void validate() {
                        if (node.getWidth() != myWidth) {
                            throw new RuntimeException("Wrong width", getTrace()); //$NON-NLS-1$
                        }
                    }
                };
                break;
            case AbsDiagramGef.ChangePositionWatcher.ChangePositionListener.HEIGHT:
                holder = new PositionHolder() {
                    int myHeight = node.getHeight();
                    void validate() {
                        if (node.getHeight() != myHeight) {
                            throw new RuntimeException("Wrong height", getTrace()); //$NON-NLS-1$
                        }
                    }
                };
                break;
            case AbsDiagramGef.ChangePositionWatcher.ChangePositionListener.ALL:
                return;
            default:
                throw new RuntimeException("Unknown coord code"); //$NON-NLS-1$
            }
            myHolders.add(holder);
            holder.validate();
        }
        void finish() {
            validateAll();
        }
        
        private void validateAll() {
            for (Iterator it = myHolders.iterator(); it.hasNext(); ) {
                PositionHolder holder = (PositionHolder) it.next();
                holder.validate();
            }
        }
        
        private final List myHolders = new ArrayList();
        
        abstract class PositionHolder {
            abstract void validate();
            Exception getTrace() {
                return myTrace;
            }
            private final Exception myTrace = new Exception();
        }
    }
    
    
    private Collection performSdLayout(boolean fullLayout) {
        final Collection result = new HashSet();
        
        final DebugPositionWatcherGate positionWatcher = ourNeedAsserter ? new DebugPositionWatcher() : DebugPositionWatcherGate.TRIVIAL;
        
        AbsDiagramGef.ChangePositionWatcher.ChangePositionListener changePositionListener 
            = new AbsDiagramGef.ChangePositionWatcher.ChangePositionListener() 
            {
                public void positionIsChanged(AbsElementGef absElement, int coordCode) {
                    result.add(absElement.getEditPart());
                    positionWatcher.positionIsChanged(absElement, coordCode);
                }
            };
        
        myAbsDiagramWithRootNode.getChangePositionWatcher().setListener(changePositionListener);
        try {
            performSdLayoutImpl(fullLayout);
        } finally {
            myAbsDiagramWithRootNode.getChangePositionWatcher().setListener(null);
        }
        
        positionWatcher.finish();
        
        
        assert assertLayoutDoesntMoveElementsNow(fullLayout);
        
        return result;
    }

    /**
     * Returns true or fail assert inside
     */
    private boolean assertLayoutDoesntMoveElementsNow(boolean fullLayout) {
        AbsDiagramGef.ChangePositionWatcher.ChangePositionListener nonexpectingChangePositionListener = new AbsDiagramGef.ChangePositionWatcher.ChangePositionListener() {
            public void positionIsChanged(AbsElementGef absElement, int coordCode) {
                assert false : "Positions are different second time"; //$NON-NLS-1$
            }
        };
        myAbsDiagramWithRootNode.getChangePositionWatcher().setListener(nonexpectingChangePositionListener);
        try {
            performSdLayoutImpl(fullLayout);
        } finally {
            myAbsDiagramWithRootNode.getChangePositionWatcher().setListener(null);
        }
        return true;
    }
    
    private void performSdLayoutImpl(boolean fullLayout) {
        AbsNode interactionNode = myAbsDiagramWithRootNode.getInteractionAbsNode();
        
        InteractionLayouter interactionLayouter = AbsElementPropertyAccess.getInstance().getInteractionLayouter(interactionNode); 
        int pentagonHeight = interactionLayouter.getPentagonPreferredHeight();
        
        int clientAreaTop = interactionNode.getY() + pentagonHeight;
        int clientAreaLeft = interactionNode.getX() + GeometryConstants.Interaction.LEFT_INSET;
        
        Dimension nativeElementsArea = performNativeLayoutImpl(clientAreaLeft, clientAreaTop, fullLayout);
        
        Dimension commonClientArea = performAlienLayoutImpl(clientAreaLeft, clientAreaTop, nativeElementsArea, fullLayout);
        
        if (interactionLayouter.isFullScreen()) {
            return;
        }
        
        int clientAreaWidth = commonClientArea.width;
        int clientAreaHeight = commonClientArea.height;
        
        clientAreaWidth = Math.max(clientAreaWidth, interactionLayouter.getPentagonPreferredWidth());
        
        int interactionWidth = GeometryConstants.Interaction.LEFT_INSET + clientAreaWidth + GeometryConstants.Interaction.RIGHT_INSET ;
        int interactionHeight = pentagonHeight + clientAreaHeight + GeometryConstants.Interaction.BOTTOM_INSET;
        
        if (interactionNode.getWidth() < interactionWidth) {
            interactionNode.setWidth(interactionWidth);
        }
        if (interactionNode.getHeight() < interactionHeight) {
            interactionNode.setHeight(interactionHeight);
        }
    }

    private Dimension performNativeLayoutImpl(int clientAreaLeft, int clientAreaTop, boolean fullLayout) {
        int bottomPos = myVerticalLayout.doLayout(fullLayout, clientAreaTop);
        int rightPos = myHorizontalLayout.applyConstraints(clientAreaLeft, fullLayout);
        
        int width = rightPos - clientAreaLeft;
        int height = bottomPos - clientAreaTop;
        return new Dimension(width, height);
    }
    
    private Dimension performAlienLayoutImpl(int clientAreaLeft, int clientAreaTop, Dimension nativeElementsArea, boolean fullLayout) {
        Dimension alienElementsArea;
        if (fullLayout) {
            int alienElementsAreaLeft = clientAreaLeft + nativeElementsArea.width;
            int alienElementsAreaTop = clientAreaTop + GeometryConstants.Lifeline.SKIP_LIFELINE_FROM_TOP;
            
            alienElementsArea = myAlienElementsLayout.fullLayout(alienElementsAreaLeft, alienElementsAreaTop);
            
            alienElementsArea.width += nativeElementsArea.width;
        } else {
            Collection reshapedElements = myAlienElementProcessor.getReshapedGdeElements();
            alienElementsArea = myAlienElementsLayout.layoutReshaped(reshapedElements, clientAreaLeft, clientAreaTop);
        }
        
        alienElementsArea.width = Math.max(alienElementsArea.width, nativeElementsArea.width);
        alienElementsArea.height = Math.max(alienElementsArea.height, nativeElementsArea.height);
        
        return alienElementsArea;
    }
    
    private static class InteractionLinksProviderImpl implements InteractionLinksProvider {
        public Iterator linkEditParts() {
            return myLinkEditParts.iterator();
        }
        
        void add(ConnectionEditPart linkEditPart) {
            assert ! myLinkEditParts.contains(linkEditPart);
            myLinkEditParts.add(linkEditPart);
        }
        
        void remove(ConnectionEditPart linkEditPart) {
            assert myLinkEditParts.contains(linkEditPart);
            myLinkEditParts.remove(linkEditPart);
        }
        
        private final Set myLinkEditParts = new HashSet();
    }
    
    private class LayoutModelHolder implements SdLayoutModelAccess {
        LayoutModelHolder(boolean readInitialState) {
            createNewModelImpl(readInitialState);
        }
        public SDLayoutModel getLayoutModel() {
            return myLayoutModel;
        }
        void createAnotherModel() {
            createNewModelImpl(true);
        }
        private void createNewModelImpl(boolean secondary) {
            SDLayoutModel.RootElementsGetter interactionEntityGetter 
                = new SDLayoutModel.RootElementsGetter() {
                    public Interaction getInteractionEntity() {
                        return myInteractionEntity; 
                    }
                    
                    public View getInteractionView() {
                    	return myInteractionView;
                    }

                    public AbsNode getRootNode() {
                        return myRootNode;
                    }
                    private final AbsNode myRootNode = myAbsDiagramWithRootNode.getInteractionAbsNode();
            };
            
            myLayoutModel = new SDLayoutModel(myAbsDiagramWithRootNode, secondary, myAlienElementfactory, new SDLayoutModel.Config() {}, interactionEntityGetter ); 
        }
        private SDLayoutModel myLayoutModel;
    }
    
    private void startAdditionalReshapingListening() {
        myAbsDiagramWithRootNode.getChangePositionWatcher().setListener(myAdditionalReshapeListener);
    }
    private void stopAdditionalReshapingListening() {
        myAbsDiagramWithRootNode.getChangePositionWatcher().setListener(null);
    }
    
    private final InteractionLinksProviderImpl myInteractionLinksProvider = new InteractionLinksProviderImpl();
    
    private final AbsDiagramGef myAbsDiagramWithRootNode;
    private final LmAlienElement.Factory myAlienElementfactory = new AlienElementFactoryImpl();
    
    private final LayoutModelHolder myLayoutModelHolder;
    
    private final SDHorizontalLayout myHorizontalLayout;
    private final SDVerticalLayout myVerticalLayout;
    private final UpdateEventAccumulator myEvents;
    private final ReshapeServerImpl myServer = new ReshapeServerImpl();
    private final Interaction myInteractionEntity;
    private final View myInteractionView;
    
    private AlienElementProcessor myAlienElementProcessor = new AlienElementProcessor();
    private final IAlienElementsLayout myAlienElementsLayout;

    private final Collection myAdditionalReshapeElements = new HashSet(); 
    private final AbsDiagramGef.ChangePositionWatcher.ChangePositionListener myAdditionalReshapeListener 
        = new AbsDiagramGef.ChangePositionWatcher.ChangePositionListener() 
        {
            public void positionIsChanged(AbsElementGef absElement, int coordCode) {
                myAdditionalReshapeElements.add(absElement.getEditPart());
            }
        };
    
    //private final ElementsAddRemoveOrderChecker myChecker = new ElementsAddRemoveOrderChecker();
    
    static class ReshapeServerImpl implements JustReshapedState.Server {
        public int getCurrentReshapeCode() {
            return myReshapeCode;
        }
        void incrementCode() {
            myReshapeCode++;
        }
        private int myReshapeCode = 0;
    }
    private static final boolean ourNeedAsserter;
    static {
        boolean b = false;
        assert b = true; //b will be true, if assert executed
        ourNeedAsserter = b;
    }
}
