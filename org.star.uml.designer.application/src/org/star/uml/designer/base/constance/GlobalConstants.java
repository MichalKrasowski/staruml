package org.star.uml.designer.base.constance;

public class GlobalConstants {
	
	//Default Node Name
	public static final String[] NODE_NAMES = {"Park,Yong Cheon","Lee,Kung Chul","Kim,Sung Sik","Park,Hee Chul"};
	
	public static final String STAR_USER_ID = "userId";
	public static final String STAR_USER_PASS = "password";
	
	//Default File Name
	public static final String DEFAULT_MODEL_FILE = "default.uml";
	public static final String DEFAULT_VIEW_MODEL_FILE = "model.xml";
	
	// Eclipse Attribute
	public static final String PATH_PREFIX = "platform:/resource";
	
	// variable
	public static final String TREE_PATH = "path";
	public static final int DEFAULT_MODEL_X = 200;
	public static final int DEFAULT_MODEL_Y = 200;
	
	// parameter 
	public static final String PARAM_DIAGRAM_NAME = "diagramName";
	public static final String PARAM_NEW_NODE_LIST = "newNameList";
	
	// Share Image
	public static final String IMG_ICONS_PATH = "icons/full/"; // Eclipse 플렛폼 아이콘 패스
	public static final String IMG_PROJECT_OPEN = IMG_ICONS_PATH+"obj16/prj_obj.gif"; // 프로잭트 열린 이미지
	public static final String IMG_PROJECT_CLOSEED = IMG_ICONS_PATH+"obj16/cprj_obj.gif"; // 프로잭트 닫힌 이미지
	
	//Policy
	public class StarPMSModelViewPopupPolicy{
		public static final int POLICY_1 = 1; // Tree not selected
		public static final int POLICY_2 = 2; // Tree login status 
		public static final int POLICY_3 = 3; // Tree logout status
		public static final int POLICY_4 = 4; // Tree root selected
		public static final int POLICY_5 = 5; // Tree diagramModel selected
		public static final int POLICY_6 = 6; // Tree diagram selected
		public static final int POLICY_7 = 7; // Tree analysisModel selected
		public static final int POLICY_8 = 8; // Tree designModel selected
		public static final int POLICY_9 = 9; // Tree implementationModel selected
		public static final int POLICY_10 = 10; // Tree deploymentModel selected
		public static final int POLICY_11 = 11; // Tree sequence diagram selected
	}
	
	// Star Model
	public class StarMoedl{
		// Star Model Attribute
		public static final String STAR_MODEL_CATEGORY = "star:category";
		public static final String STAR_MODEL_FILE = "star:file";
		public static final String STAR_MODEL_EXTENSION = "star:extension";
		public static final String STAR_MODEL_USECASE_SEQ = "star:seq";
		public static final String STAR_MODEL_USECASE_PARENT_SEQ = "star:parentseq";
		public static final String STAR_MODEL_ID = "xmi:id";
		public static final String STAR_MODEL_TYPE = "xmi:type";
		public static final String STAR_MODEL_NAME = "name";
		
		// Star Model Cetegory
		public static final String STAR_CATEGORY_ROOT = "pkgRoot";
		public static final String STAR_CATEGORY_MODEL_ROOT = "rootModel";
		public static final String STAR_CATEGORY_DIAGRAM = "diagram";
		public static final String STAR_CATEGORY_DIAGRAM_MODEL = "diagramModel";
		
		// Star Model Name
		public static final String STAR_NAME_ANALYSIS_MODEL = "<<analysisModel>>Analysis Model";
		public static final String STAR_NAME_DESIGN_MODEL = "<<designModel>>Design Model";
		public static final String STAR_NAME_IMPLEMENTATION_MODEL = "<<implementationModel>>Implementation Model";
		public static final String STAR_NAME_DEPLOYMENT_MODEL = "<<deploymentModel>>Deployment Model";
		
		// Star Diagram extension
		public static final String STAR_EXTENSION_USECASE_DIAGRAM = "umlusc";
		public static final String STAR_EXTENSION_SEQUENCE_DIAGRAM = "umlseq";
		public static final String STAR_EXTENSION_CLASS_DIAGRAM = "umlclass";
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
		
		// Model Type
		public static final String UML_MODEL_TYPE_ACTOR = "uml:Actor";
		public static final String UML_MODEL_TYPE_USECASE = "uml:UseCase";
	}
	
	//PluinID
	public class PluinID{
		public static final String STAR_PMS_MODEL_VIEW = "org.star.uml.designer.ui.views.StarPMSModelView";
	}
	
}
