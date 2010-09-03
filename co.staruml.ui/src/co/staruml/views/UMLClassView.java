package co.staruml.views;

import co.staruml.uml.*;

public class UMLClassView extends UMLGeneralNodeView {

	private UMLCompartment attributes;
	private UMLCompartment operations;
	
	public static final int CLASS_NAME_AREA = 1,		
	                        CLASS_ATTRIBUTE_AREA = 2,
	                        CLASS_OPERATION_AREA = 3;
	public UMLClassView() {
		attributes = new UMLCompartment("attributes");
		operations = new UMLCompartment("operations");
		compartments.add(attributes);
		compartments.add(operations);
		
		attributes.addItem(new UMLCompartmentItem("Attribute1", UML.ICON_ATTRIBUTE_PUBLIC, 0));
		attributes.addItem(new UMLCompartmentItem("Attribute2", UML.ICON_ATTRIBUTE_PUBLIC, 0));
		attributes.addItem(new UMLCompartmentItem("Attribute3", UML.ICON_ATTRIBUTE_PUBLIC, 0));
//		operations.addItem(new UMLCompartmentItem("Operation1()", UML.ICON_OPERATION_PUBLIC, 0));
//		operations.addItem(new UMLCompartmentItem("Operation2()", UML.ICON_OPERATION_PUBLIC, 0));
	}
	
}
