package org.eclipse.uml2.diagram.sequence.edit.helpers;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;

/**
 * @generated
 */
public class LayeredInteractionUseEditHelperAdvice extends AbstractEditHelperAdvice {
	
	public LayeredInteractionUseEditHelperAdvice(){
		System.out.println("LayeredInteractionUseEditHelperAdvice.LayeredInteractionUseEditHelperAdvice()");
	}

	@Override
	protected ICommand getAfterConfigureCommand(ConfigureRequest request) {
		//CompositeCommand result = new CompositeCommand(request.getLabel());
		//result.add(CoveredLifelineConfigurer.configure(request));
		return CoveredLifelineConfigurer.configure(request);
	}
}
