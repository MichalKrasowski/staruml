package org.eclipse.uml2.diagram.sequence.model.builder;


@SuppressWarnings("serial")
public class UMLModelProblem extends RuntimeException {

	public UMLModelProblem(String message) {
		super(message);
	}

	public UMLModelProblem(Throwable cause) {
		super(cause);
	}

	public UMLModelProblem(String message, Throwable cause) {
		super(message, cause);
	}

}
