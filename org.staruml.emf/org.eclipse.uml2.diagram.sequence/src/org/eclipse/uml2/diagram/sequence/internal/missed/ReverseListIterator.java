package org.eclipse.uml2.diagram.sequence.internal.missed;

import java.util.List;
import java.util.ListIterator;


/**
 * 
 */
public class ReverseListIterator implements ListIterator {
    public ReverseListIterator(List list) {
        this(list.listIterator(list.size()));
    }
    public ReverseListIterator(ListIterator listIterator) {
        myListIterator = listIterator;
    }
    public boolean hasNext() {
        return myListIterator.hasPrevious();
    }
    public Object next() {
        return myListIterator.previous();
    }
    public void remove() {
        myListIterator.remove();
    }
    
    public void add(Object o) {
        myListIterator.add(o);
        myListIterator.previous();
    }
    public boolean hasPrevious() {
        return myListIterator.hasNext();
    }
    public int nextIndex() {
        return myListIterator.previousIndex();
    }
    public Object previous() {
        return myListIterator.next();
    }
    public int previousIndex() {
        return myListIterator.nextIndex();
    }
    public void set(Object o) {
        myListIterator.set(o);
    }
    
    private final ListIterator myListIterator;
}
