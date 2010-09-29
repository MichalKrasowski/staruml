package org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.gef;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class WeakValueHashMap implements Map {
    public int size() {
        cleanRefs();
        return myHashMap.size();
    }

    public boolean isEmpty() {
        cleanRefs();
        return myHashMap.isEmpty();
    }

    public boolean containsKey(Object key) {
        cleanRefs();
        return myHashMap.containsKey(key);
    }

    public boolean containsValue(Object val) {
        throw new UnsupportedOperationException();
    }

    public Object get(Object key) {
        cleanRefs();
        RefWithUin ref = (RefWithUin)myHashMap.get(key);
        if (ref==null) {
            return null;
        } else {
            return ref.get();
        }
    }

    public Object put(Object key, Object value) {
        cleanRefs();
        RefWithUin ref = new RefWithUin(value, key);
        RefWithUin oldRef = (RefWithUin)myHashMap.put(key, ref);
        if (oldRef == null) {
            return null;
        } else {
            return oldRef.get();
        }
    }

    public Object remove(Object key) {
        cleanRefs();
        RefWithUin oldRef = (RefWithUin)myHashMap.remove(key);
        if (oldRef == null) {
            return null;
        } else {
            return oldRef.get();
        }
    }

    public void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        myHashMap.clear();
    }

    public Set keySet() {
        cleanRefs();
        return myHashMap.keySet();
    }

    public Collection values() {
        throw new UnsupportedOperationException();
    }

    public Set entrySet() {
        throw new UnsupportedOperationException();
    }

    ///////////////////////////////////////////////////////////////////////////
    ///  Implementation
    protected void cleanRefs() {
        for (RefWithUin ref = (RefWithUin)myQueue.poll(); ref != null; ref = (RefWithUin)myQueue.poll()) {
            Object value = myHashMap.get(ref.getKey());
            if (value == ref) {
                myHashMap.remove(ref.getKey());
            }
        }
    }

    private class RefWithUin extends WeakReference {
        public RefWithUin(Object obj, Object key) {
            super(obj, myQueue);
            myKey = key;
        }

        public Object getKey() {
            return myKey;
        }

        private final Object myKey;
    }


    private final HashMap myHashMap = new HashMap();
    private final ReferenceQueue myQueue = new ReferenceQueue();
}
