package org.star.uml.designer;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;

public class Action4 extends Action {

	public Action4() {
		System.out.println("Action4");
	}

	public Action4(String text) {
		super(text);
		System.out.println("Action44");
		// TODO Auto-generated constructor stub
	}

	public Action4(String text, ImageDescriptor image) {
		super(text, image);
		System.out.println("Action444");
		// TODO Auto-generated constructor stub
	}

	public Action4(String text, int style) {
		super(text, style);
		System.out.println("Action454");
		// TODO Auto-generated constructor stub
	}

}
