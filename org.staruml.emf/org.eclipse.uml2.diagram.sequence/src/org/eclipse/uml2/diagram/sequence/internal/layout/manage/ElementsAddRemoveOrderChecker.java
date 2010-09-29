package org.eclipse.uml2.diagram.sequence.internal.layout.manage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsLink;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsNode;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsNodeEnumeration;
import org.eclipse.uml2.diagram.sequence.internal.layout.model.SdLayoutModelAddRemoveProcessor;



class ElementsAddRemoveOrderChecker implements SdLayoutModelAddRemoveProcessor {
        public boolean processAddedGdeNode(AbsNode gdeNode) {
            myNodes.add(gdeNode);
            return true;
        }

        public boolean processRemovedGdeNode(AbsNode gdeNode) {
            myNodes.remove(gdeNode);
            List children = findChildren(gdeNode);
            if (!children.isEmpty()) {
                throw new RuntimeException();
            }
            return true;
        }

        public boolean processAddedGdeLink(AbsLink absLink) {
            if (!myNodes.contains(absLink.getSource())) {
//                Reference expected = absLink.getSource().getReference();
//                System.out.println("[ElementsAddRemoveOrderChecker] processAddedGdeLink expected ref = " + expected.getUniqueName());
//                for (Iterator it = myNodes.iterator(); it.hasNext();) {
//                    AbsNode node = (AbsNode)it.next();
//                    System.out.println("[ElementsAddRemoveOrderChecker] processAddedGdeLink actual = " + node.getReference().getUniqueName());
//                }
//                System.out.println("[ElementsAddRemoveOrderChecker] processAddedGdeLink <<<<");
                //Reference expected = absLink.getSource().getReference();
                //System.out.println("[ElementsAddRemoveOrderChecker] processAddedGdeLink expected ref = " + expected.getPropertyValue(Property.METACLASS)); //$NON-NLS-1$
                //for (Iterator it = myNodes.iterator(); it.hasNext();) {
                //    AbsNode node = (AbsNode)it.next();
                //    System.out.println("[ElementsAddRemoveOrderChecker] processAddedGdeLink actual = " + node.getReference().getPropertyValue(Property.METACLASS)); //$NON-NLS-1$
                //}
                //System.out.println("[ElementsAddRemoveOrderChecker] processAddedGdeLink <<<<"); //$NON-NLS-1$
                throw new RuntimeException();
            }
            if (!myNodes.contains(absLink.getDestination())) {
                //System.out.println("[ElementsAddRemoveOrderChecker] processAddedGdeLink link destination hasn't been added: link = " + absLink+"\n   destination = "+absLink.getDestination()); //$NON-NLS-1$ //$NON-NLS-2$
                throw new RuntimeException();
            }
            myLinks.add(absLink);
            return true;
        }

        public boolean processRemovedGdeLink(AbsLink absLink) {
            myLinks.remove(absLink);
            return true;
        }

        public void finish() {
//            myLinks.clear();
//            myNodes.clear();
        }
        
        List findChildren(AbsNode node) {
            ArrayList result = new ArrayList();
            for (AbsNodeEnumeration subnodes = node.subnodes(); subnodes.hasMoreElements(); ) {
                AbsNode next = subnodes.nextGdeNode();
                if (myNodes.contains(next)) {
                    result.add(next);
                }
            }
            
            for (Iterator it = myLinks.iterator(); it.hasNext();) {
                AbsLink next = (AbsLink)it.next();
                if (next.getSource() == node || next.getDestination() == node) {
                    result.add(next);
                }
            }
            return result;
        }
        
        final Set myLinks = new HashSet();
        final Set myNodes = new HashSet();
}