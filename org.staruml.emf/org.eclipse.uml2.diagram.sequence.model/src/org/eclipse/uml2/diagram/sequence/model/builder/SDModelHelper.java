package org.eclipse.uml2.diagram.sequence.model.builder;

import org.eclipse.uml2.diagram.sequence.model.sequenced.SDAbstractMessage;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDBackedByFragment;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDGate;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDGateMessageEnd;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDLifeLine;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDModel;
import org.eclipse.uml2.diagram.sequence.model.sequenced.util.SDSwitch;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Gate;


public class SDModelHelper {
	public static final SDGate findGate(SDModel model, Gate umlGate){
		for (SDGate next : model.getGates()){
			if (umlGate == next.getUmlGate()){
				return next;
			}
		}
		return null;
	}
	
	public static final SDSwitch<Element> UML_ELEMENT_EXTRACTOR = new SDSwitch<Element>(){

		@Override
		public Element caseSDAbstractMessage(SDAbstractMessage object) {
			return object.getUmlMessage();
		}

		@Override
		public Element caseSDModel(SDModel object) {
			return object.getUmlInteraction();
		}

		@Override
		public Element caseSDGate(SDGate object) {
			return object.getUmlGate();
		}

		@Override
		public Element caseSDGateMessageEnd(SDGateMessageEnd object) {
			return object.getUmlMessageEnd();
		}

		@Override
		public Element caseSDLifeLine(SDLifeLine object) {
			return object.getUmlLifeline();
		}
		
		@Override
		public Element caseSDBackedByFragment(SDBackedByFragment object) {
			return object.getUmlFragment();
		}
	};
			
			
	
}
