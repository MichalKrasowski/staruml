package org.eclipse.uml2.diagram.sequence.anchor;

import org.eclipse.uml2.diagram.sequence.model.sequenced.SDAbstractMessage;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDBackedByFragment;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDEntity;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDFrame;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDLifeLine;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDModel;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;

class DebugFormat {

	public static String debugFormatEntity(SDEntity entity) {
		if (entity == null) {
			return "null";
		}
		StringBuilder result = new StringBuilder(entity.eClass().getName());
		result.append(":");
		if (entity instanceof SDBackedByFragment) {
			SDFrame frame = (SDFrame) entity;
			result.append(safeGetName(frame.getUmlFragment()));
		} else if (entity instanceof SDModel) {
			SDModel model = (SDModel) entity;
			result.append(safeGetName(model.getUmlInteraction()));
		} else if (entity instanceof SDLifeLine) {
			SDLifeLine sdLifeLine = (SDLifeLine) entity;
			result.append(safeGetName(sdLifeLine.getUmlLifeline()));
		} else if (entity instanceof SDAbstractMessage) {
			SDAbstractMessage sdMessage = (SDAbstractMessage) entity;
			result.append(safeGetName(sdMessage.getUmlMessage()));
		} else {
			result.append(entity);
		}
		return result.toString();
	}

	private static String safeGetName(Element umlElement) {
		if (umlElement == null) {
			return "<null>";
		}
		if (umlElement instanceof NamedElement) {
			return ((NamedElement) umlElement).getName();
		}
		return umlElement.toString();
	}

}
