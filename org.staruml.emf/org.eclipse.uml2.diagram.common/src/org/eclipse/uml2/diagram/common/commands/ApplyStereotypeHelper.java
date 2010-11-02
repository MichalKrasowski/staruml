package org.eclipse.uml2.diagram.common.commands;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.uml2.diagram.common.Messages;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

public class ApplyStereotypeHelper {

	public static ICommand getCommand(Element subject, List<String> toApply) {
		List<String> applicables = new ArrayList<String>();
		for (Stereotype stereo : subject.getApplicableStereotypes()) {
			applicables.add(stereo.getName());
		}
		for (String str : toApply) {
			if (false == applicables.contains(str)) {
				return UnexecutableCommand.INSTANCE; 
			}
		}

		CompositeCommand command = new CompositeCommand(Messages.ApplyStereotypeHelper_command_manage_stereotypes);
		for (Stereotype applied : subject.getAppliedStereotypes()) {
			if (false == toApply.contains(applied.getName())) {
				command.add(new ApplyOrUnapplyStereotypeCommand(new ApplyOrUnapplyStereotypeCommand.ApplyOrUnapplyStereotypeRequest(subject, applied, false)));
			}
		}
		for (Stereotype applicable : subject.getApplicableStereotypes()) {
			if (toApply.contains(applicable.getName()) && (subject.getAppliedStereotype(applicable.getQualifiedName()) == null)) {
				command.add(new ApplyOrUnapplyStereotypeCommand(new ApplyOrUnapplyStereotypeCommand.ApplyOrUnapplyStereotypeRequest(subject, applicable, true)));
			}
		}
		return command;
	}

}
