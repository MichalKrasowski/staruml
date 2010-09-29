package org.eclipse.uml2.diagram.sequence.internal.missed;

import java.util.Enumeration;


public class EmptyEnumeration<T> implements Enumeration<T> {
	public boolean hasMoreElements() {
		return false;
	}

	public T nextElement() {
		return null;
	}
	
	@SuppressWarnings("unchecked")
	private static final EmptyEnumeration INSTANCE = new EmptyEnumeration();
	
	@SuppressWarnings("unchecked")
	public static <T> Enumeration<T> getEnumeration(){
		return INSTANCE;
	}

}
