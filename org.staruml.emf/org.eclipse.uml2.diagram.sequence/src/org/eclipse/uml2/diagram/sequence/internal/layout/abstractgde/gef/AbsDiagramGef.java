package org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.gef;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramGraphicalViewer;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.sequence.edit.parts.InteractionEditPart;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsDiagram;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsLink;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsLinkEnumeration;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsNode;
import org.eclipse.uml2.uml.Interaction;


/**
 * 
 */
public class AbsDiagramGef implements AbsDiagram {
    public AbsDiagramGef(InteractionEditPart interactionNodeEditPart) {
        myInteractionNodeEditPart = interactionNodeEditPart;
        
        EditPartViewer editPartViewer = interactionNodeEditPart.getViewer();
        if (! (editPartViewer instanceof DiagramGraphicalViewer)) {
            throw new IllegalArgumentException("editPartViewer is expected to be a DiagramGraphicalViewer"); //$NON-NLS-1$
        }
            
        myEditPartViewer = (DiagramGraphicalViewer) editPartViewer;
        myRootModelPart = (DiagramEditPart)myEditPartViewer.getContents();
    }

    public AbsNode getRootNode() {
        return myFactory.createAbsNode(myRootModelPart);
    }

    public AbsLinkEnumeration links() {
    	List<ConnectionEditPart> links = new LinkedList<ConnectionEditPart>();
    	for (Object nextEP : myEditPartViewer.getEditPartRegistry().values()){
    		if (nextEP instanceof ConnectionEditPart){
    			links.add((ConnectionEditPart)nextEP);
    		}
    	}
    	
        final Iterator<ConnectionEditPart> it = links.iterator();
        return new AbsLinkEnumeration() {
            public boolean hasMoreElements() {
                return it.hasNext();
            }

            public AbsLink nextGdeLink() {
                ConnectionEditPart nextLink = it.next();
                return myFactory.createAbsLink(nextLink);
            }
            
            public Object nextElement() {
                return nextGdeLink();
            }
        };
    }
    
    public AbsElementFactory getAbsElementFactory() {
        return myFactory;
    }
    
    public ChangePositionWatcher getChangePositionWatcher() {
        return myChangePositionWatcher;
    }
    
    public Interaction getInteraction() {
    	return (Interaction) myInteractionNodeEditPart.resolveSemanticElement();
    }
    
    public View getInteractionView() {
    	return myInteractionNodeEditPart.getNotationView();
    }

    public AbsNode getInteractionAbsNode() {
        return getAbsElementFactory().createAbsNode(myInteractionNodeEditPart);
    }

    private final InteractionEditPart myInteractionNodeEditPart;
    private final DiagramGraphicalViewer myEditPartViewer;
    private final DiagramEditPart myRootModelPart;
    private final AbsElementFactory myFactory = new AbsElementFactory();
    private final ChangePositionWatcher myChangePositionWatcher = new ChangePositionWatcher(); 
    
    public class AbsElementFactory {
        public AbsNodeGef createAbsNode(GraphicalEditPart nodeEditPart) {
            AbsNodeGef result = (AbsNodeGef)myInstances.get(nodeEditPart);
            if (result == null) {
                result = createAbsNodeImpl(nodeEditPart);
                myInstances.put(nodeEditPart, result);
            }
            return result;
        }
        public AbsLinkGef createAbsLink(ConnectionEditPart linkEditPart) {
            AbsLinkGef result = (AbsLinkGef)myInstances.get(linkEditPart);
            if (result == null) {
                result = new AbsLinkGef(linkEditPart, AbsDiagramGef.this);
                myInstances.put(linkEditPart, result);
            }
            return result;
        }
        
        /**
         * convenience method
         */
        public AbsElementGef createAbsElement(IGraphicalEditPart editPart) {
            AbsElementGef result = (AbsElementGef)myInstances.get(editPart);
            if (result == null) {
                if (editPart instanceof ShapeNodeEditPart) {
                    result = createAbsNodeImpl((ShapeNodeEditPart)editPart);
                } else if (editPart instanceof ConnectionEditPart) {
                    result = new AbsLinkGef((ConnectionEditPart)editPart, AbsDiagramGef.this);
                } else {
                    throw new IllegalArgumentException();
                }
                myInstances.put(editPart, result);
            }
            return result;
        }
        private final WeakValueHashMap myInstances = new WeakValueHashMap(); 
    }
    
    protected AbsNodeGef createAbsNodeImpl(GraphicalEditPart nodeEditPart) {
        return new AbsNodeGef(nodeEditPart, this, nodeEditPart == myInteractionNodeEditPart);
    }
    

    /**
     * This watcher is added for debug/assert purposes
     * 
     */
    public static class ChangePositionWatcher {
        /**
         * 'Is changed' here means, that coordinates have been change in layout and now
         * are going to be saved to gef
         */
        void linkPointsAreChanged(AbsLinkGef absLink) {
            if (myChangePositionListener == null) {
                throw new IllegalStateException("Change position listener isn't set"); //$NON-NLS-1$
            }
            myChangePositionListener.positionIsChanged(absLink, 0);
        }

        void nodeBoundsAreChanged(AbsNodeGef absNode, int coordCode) {
            if (myChangePositionListener == null) {
                throw new IllegalStateException("Change position listener isn't set"); //$NON-NLS-1$
            }
            myChangePositionListener.positionIsChanged(absNode, coordCode);
        }
        
        public void setListener(ChangePositionListener changePositionListener) {
            if (changePositionListener != null && myChangePositionListener != null) {
                throw new IllegalStateException("Listener is already set"); //$NON-NLS-1$
            }
            myChangePositionListener = changePositionListener;
        }
        private ChangePositionListener myChangePositionListener = null;

        
        public interface ChangePositionListener {
            /**
             * 'Is changed' here means, that coordinates have been change in layout and now
             * are going to be saved to gef
             * @param absElement TODO
             */
            void positionIsChanged(AbsElementGef absElement, int coordCode);
            
            int Y = 1;
            int HEIGHT = 2;
            int X = 3;
            int WIDTH = 4;
            
            int ALL = 5;
        }

    }
    
    //TODO: move it somewhere else?
    static {
        new AbsElementPropertyAccessU2T();
    }
}
