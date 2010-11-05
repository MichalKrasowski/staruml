package org.star.uml.designer.service.uvo;

import java.sql.Connection;
import java.util.Map;

import org.star.uml.designer.ui.newWiazrds.db.SqlParser;


public class LoginInfo {

	public static UserInfo userInfo;
	
	public static String path;

	public static Map<String, String> policy;

	public static Map<Integer, String> myPolicy;

	public static String projectPathFullPath;

	public static Connection conn;
	
	public static SqlParser sqlParser;

}
