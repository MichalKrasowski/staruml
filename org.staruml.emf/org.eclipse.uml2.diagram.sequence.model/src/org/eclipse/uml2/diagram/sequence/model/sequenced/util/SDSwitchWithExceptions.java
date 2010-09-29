package org.eclipse.uml2.diagram.sequence.model.sequenced.util;

import org.eclipse.emf.ecore.EObject;

public class SDSwitchWithExceptions<T, E extends Exception> extends SDSwitch<T> {

	private EObject myCurrentInput;

	@SuppressWarnings("unchecked")
	public T doSwitchWithException(EObject theEObject) throws E {
		myCurrentInput = theEObject;
		try {
			return doSwitch(theEObject);
		} catch (SoftExceptionToUnwrap e) {
			throw (E) e.getCause();
		} finally {
			myCurrentInput = null;
		}
	}
	
	protected void doThrow(E e) {
		throw new SoftExceptionToUnwrap(e);
	}

	protected EObject getCurrentInput() {
		return myCurrentInput;
	}

	private static class SoftExceptionToUnwrap extends RuntimeException {

		private static final long serialVersionUID = 1L;

		public SoftExceptionToUnwrap(Exception e) {
			super(e);
		}
	}

}
