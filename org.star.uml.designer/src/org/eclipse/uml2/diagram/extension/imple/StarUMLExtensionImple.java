package org.eclipse.uml2.diagram.extension.imple;

import java.util.HashMap;
import org.eclipse.uml2.diagram.common.extension.StarUMLExtension;

public class StarUMLExtensionImple implements StarUMLExtension{

	@Override
	public void diagramSave(HashMap map) {
		System.out.println("diagramSave : ");
	}

	@Override
	public void fileSave(HashMap map) {
		System.out.println("fileSave : ");
	}

	@Override
	public void modelAdd(HashMap map) {
		System.out.println("modelAdd : ");
	}


}
