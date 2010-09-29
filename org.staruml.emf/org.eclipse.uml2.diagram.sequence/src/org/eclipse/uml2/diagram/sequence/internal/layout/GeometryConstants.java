package org.eclipse.uml2.diagram.sequence.internal.layout;

/**
 * 
 */
public interface GeometryConstants {
	interface Lifeline {
		int HEIGHT = 50;
		int MINIMUM_HEAD_WIDTH = 60;
        int MINIMUM_HEIGHT = 300;
		
		int SKIP_LIFELINE_FROM_TOP = 10;
		int UNDER_HEAD_SPACE = 10;
        int MINIMAL_HORIZONTAL_DISTANCE = 20;
    }
	interface Execution {
		int VERTICAL_TOP_OUT_SPACE = 16;
		int VERTICAL_BOTTOM_OUT_SPACE = 6;
		int VERTICAL_IN_SPACE = 12;
        
        int VERTICAL_TOP_OUT_SPACE_NO_DURATION = VERTICAL_BOTTOM_OUT_SPACE;
        int VERTICAL_BOTTOM_OUT_SPACE_NO_DURATION = 2;
        int VERTICAL_IN_SPACE_NO_DURATION = 4;
		
		int VERTICAL_TOP_OUT_SPACE_FOR_SELF_INVOKED = 3;
		
		int WIDTH = 20;
		int HORIZONTAL_OFFSET = WIDTH/2;
		int NO_TIME_HEIGHT = 1; 

        int VIEWMAP_MINIMAL_HEIGHT = 2*VERTICAL_IN_SPACE;
    }
	
	interface Invocation {
		int VERTICAL_TOP_OUT_SPACE = 14;
		int VERTICAL_BOTTOM_OUT_SPACE = 4;
		int VERTICAL_IN_SPACE = 8;
        
        int VERTICAL_TOP_OUT_SPACE_NO_DURATION = VERTICAL_BOTTOM_OUT_SPACE;
        int VERTICAL_BOTTOM_OUT_SPACE_NO_DURATION = 2;
        int VERTICAL_IN_SPACE_NO_DURATION = 4;
        
        int VIEWMAP_MINIMAL_HEIGHT = 2*VERTICAL_IN_SPACE;
	}
	
	interface CombinedFragmentMountingPoint {
		int VERTICAL_OUT_SPACE = 6;
		int VERTICAL_IN_SPACE = 0;
	}
	interface InteractionOpernadMountingPoint {
		int SELECTION_BAR_HEIGHT = 1;
		
		
		int VERTICAL_OUT_SPACE = 0;
		int VERTICAL_IN_SPACE = 10 /*+ SELECTION_BAR_HEIGHT*/;
		
		int VERTICAL_TOP_IN_SPACE = 20;
		int VERTICAL_BOTTOM_IN_SPACE = 10;
	}
	interface InteractionOccurenceMountingPoint {
		int VERTICAL_OUT_SPACE = 6;
		int VERTICAL_IN_SPACE = 20;
	}
	interface SimpleBracket {
		int VERTICAL_OUT_SPACE = 2;
        int MIN_HEIGHT = 15;
        int MIN_WIDTH = 3*MIN_HEIGHT;
	}
	
	interface Message {
		int SELF_MESSAGE_HORIZONTAL_RANGE = 30;

		int SELF_MESSAGE_HORIZONTAL_INDENT = 20;
        int SELF_RETURN_MESSAGE_HORIZONTAL_OFFSET = -3;
		
		int MIN_FOUND_MESSAGE_LENGTH = 35;
		int MAX_FOUND_MESSAGE_LENGTH = 80;

		int MIN_ASYNCHRONOUS_SLOPE_VALUE = 15;

		int FOUND_MESSAGE_SIBLING_VERTICAL_DISTANCE = 15;

		int ASYNCHRONOUS_SELF_MESSAGE_VERTICAL_SLOPE = 5;
	}
	
	interface Frames {
		int COMBINED_FRAGMENT_OUTER_SPACE_HORIZONTAL = 3;
		int INTERATCTION_OPERAND_OUTER_SPACE_HORIZONTAL = 0;
		int INTERATCTION_OPERAND_INNER_SPACE_HORIZONTAL = 10;
		int INTERACTION_OCCURENCE_OUTER_SPACE_HORIZONTAL = 3;
        int INTERACTION_OCCURENCE_INNER_SPACE_HORIZONTAL = INTERATCTION_OPERAND_INNER_SPACE_HORIZONTAL;
        
        int FIRST_INTERATCTION_OPERAND_TOP_OFFSET = 20;
        
        int UNTIED_FRAME_OUTER_SPACE_HORIZONTAL = 5;
        int PENTAGON_MIN_RIGHT_OUTER_SPACE = 5;
        
        int UNTIED_FRAME_MIN_HEIGHT = 10;
        
        int MINIMAL_SPACE_UNDER_PENTAGON = 5;
	}
    interface BadElement {
        int MIN_WIDTH = 30;
        int MIN_HEIGHT = 40;
    }

    interface Interaction {
        int TOP_INSET = 10;
        int BOTTOM_INSET = 10;
        int LEFT_INSET = 10;
        int RIGHT_INSET = 10;
    }

	
	int SPACE_BETWEEN_LIFE_LINES_HORIZONTAL = 20;
	
	
	int DIAGRAM_LEFT_BORDER_SPACE = 20;
}
