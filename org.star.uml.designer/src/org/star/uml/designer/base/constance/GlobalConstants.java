package org.star.uml.designer.base.constance;

public class GlobalConstants {
	
	//Default Node Name
	public static final String[] NODE_NAMES = {"Park,Yong Cheon","Lee,Kung Chul","Kim,Sung Sik","Park,Hee Chul"};
	
	//Default File Name
	public static final String DEFAULT_MODEL_FILE = "default.uml";
	public static final String DEFAULT_VIEW_MODEL_FILE = "model.xml";
	
	// Eclipse Attribute
	public static final String PATH_PREFIX = "platform:/resource";
	
	//variable
	public static final String TREE_PATH = "path";
	public static final int DEFAULT_MODEL_X = 200;
	public static final int DEFAULT_MODEL_Y = 200;
	
	//Policy
	public class StarPMSModelViewPopupPolicy{
		public static final int POLICY_1 = 1; // Tree not selected
		public static final int POLICY_2 = 2; // Tree login status 
		public static final int POLICY_3 = 3; // Tree logout status
		public static final int POLICY_4 = 4; // Tree rootModel selected
		public static final int POLICY_5 = 5; // Tree diagramModel selected
	}
	
	// Star Model
	public class StarMoedl{
		// Star Model Attribute
		public static final String STAR_MODEL_CATEGORY = "star:category";
		public static final String STAR_MODEL_FILE = "star:file";
		public static final String STAR_MODEL_EXTENSION = "star:extension";
		public static final String STAR_MODEL_ID = "xmi:id";
		public static final String STAR_MODEL_TYPE = "xmi:type";
		public static final String STAR_MODEL_NAME = "name";
		
		// Star Model Cetegory
		public static final String STAR_CATEGORY_ROOT = "pkgRoot";
		public static final String STAR_CATEGORY_MODEL_ROOT = "rootModel";
		public static final String STAR_CATEGORY_DIAGRAM = "diagram";
		public static final String STAR_CATEGORY_DIAGRAM_MODEL = "diagramModel";
	}
	
	// Star Model
	public class UMLMoedl{
		// Star Model Attribute
		public static final String UML_MODEL_ID = "xmi:id";
		public static final String UML_MODEL_TYPE = "xmi:type";
		public static final String UML_MODEL_NAME = "name";
		
		// Star Model Cetegory
		public static final String UML_TYPE_PACKAGE = "uml:Package";
		public static final String UML_TYPE_PACKAGE_Element = "packagedElement";
	}
	
	//PluinID
	public class PluinID{
		public static final String STAR_PMS_MODEL_VIEW = "org.star.uml.designer.ui.views.StarPMSModelView";
	}
	
}
