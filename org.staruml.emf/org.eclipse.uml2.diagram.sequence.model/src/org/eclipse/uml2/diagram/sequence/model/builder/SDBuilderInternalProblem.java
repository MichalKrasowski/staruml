package org.eclipse.uml2.diagram.sequence.model.builder;


@SuppressWarnings("serial")
public class SDBuilderInternalProblem extends RuntimeException {

	public SDBuilderInternalProblem(String message) {
		super(message);
	}

	public SDBuilderInternalProblem(Throwable cause) {
		super(cause);
	}

	public SDBuilderInternalProblem(String message, Throwable cause) {
		super(message, cause);
	}

}
