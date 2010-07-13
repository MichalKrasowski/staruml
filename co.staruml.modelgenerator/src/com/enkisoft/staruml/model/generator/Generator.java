package com.enkisoft.staruml.model.generator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.jawin.*;
import org.jawin.win32.*;

public class Generator {

	private static final String PACKAGE_NAME = "enkisoft.sobis.staruml.uml.model";

	public static void main(String[] args) {
		try {
			Ole32.CoInitialize();
			DispatchPtr app = new DispatchPtr("StarUML.StarUMLApplication");
			DispatchPtr projectManager = (DispatchPtr) app.get("ProjectManager");
			DispatchPtr project = (DispatchPtr) projectManager.get("Project");
			visit(project);
			Ole32.CoUninitialize();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void writeln(BufferedWriter out, String value) throws IOException {
		out.write(value);
		out.newLine();
	}

	public static void writeln(BufferedWriter out) throws IOException {
		out.newLine();
	}
	
	public static void visit(DispatchPtr ptr) throws COMException {
		Boolean isNamespace = (Boolean) ptr.invoke("IsKindOf", new String("UMLNamespace"));
		if (isNamespace) {
			Integer count = (Integer) ptr.invoke("GetOwnedElementCount");
			if (count != null) {
				for (int i = 0; i < count; i++) {
					DispatchPtr element = (DispatchPtr) ptr.invoke("GetOwnedElementAt", new Integer(i));
					Boolean isClass = (Boolean) element.invoke("IsKindOf", new String("UMLClass"));
					Boolean isEnum = (Boolean) element.invoke("IsKindOf", new String("UMLEnumeration"));
					if (isClass) {
						generateClass(element);
					} else if (isEnum) {
						generateEnumeration(element);
					} else {
						visit(element);
					}
				}
			}
		}
	}
	
	// ========================================================================
	//                               GENERATE CLASS
	// ========================================================================
	
	public static void generateClass(DispatchPtr ptr) throws COMException {
		String name = (String) ptr.get("Name");
		System.out.println(name);
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("generated/" + name + ".java"));
			writeln(out, "package " + PACKAGE_NAME + ";");
			writeln(out);
			writeln(out, "public class " + name + " {");
			writeln(out);
			generateAttributes(out, ptr);
			writeln(out);
			generateGettersSetters(out, ptr);
			writeln(out, "}");
			out.close();
		} catch (IOException e) {
			System.err.println(e);
			System.exit(1);
		}
	}

	public static void generateAttributes(BufferedWriter out, DispatchPtr ptr) throws COMException, IOException {
		Integer count = (Integer) ptr.invoke("GetAttributeCount");
		if (count != null) {
			for (int i = 0; i < count; i++) {
				DispatchPtr attr = (DispatchPtr) ptr.invoke("GetAttributeAt", new Integer(i));
				String attrName = (String) attr.get("Name");
				String attrType = convertType((String) attr.get("TypeExpression"));
				writeln(out, "\tprivate " + attrType + " " + convertIdent(attrName) + ";");
			}
		}
	}
	
	public static void generateGettersSetters(BufferedWriter out, DispatchPtr ptr) throws COMException, IOException {
		Integer count = (Integer) ptr.invoke("GetAttributeCount");
		if (count != null) {
			for (int i = 0; i < count; i++) {
				DispatchPtr attr = (DispatchPtr) ptr.invoke("GetAttributeAt", new Integer(i));
				String attrName = (String) attr.get("Name");
				String attrType = convertType((String) attr.get("TypeExpression"));
				// Getter
				writeln(out, "\tpublic " + attrType + " get" + attrName + "() {");
				writeln(out, "\t\treturn " + convertIdent(attrName) + ";");
				writeln(out, "\t}");
				writeln(out);
				// Setter
				writeln(out, "\tpublic void set" + attrName + "(" + attrType + " value" + ") {");
				writeln(out, "\t\tthis." + convertIdent(attrName) + " = value;");
				writeln(out, "\t}");
				writeln(out);
			}
		}
	}
	
	// ========================================================================
	//                           GENERATE ENUMERATION
	// ========================================================================
	
	public static void generateEnumeration(DispatchPtr ptr) throws COMException {
		String name = (String) ptr.get("Name");
		System.out.println(name);
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("generated/" + name + ".java"));
			writeln(out, "package " + PACKAGE_NAME + ";");
			writeln(out);
			writeln(out, "public interface " + name + " {");
			generateLiterals(out, ptr);
			writeln(out, "}");
			out.close();
		} catch (IOException e) {
			System.err.println(e);
			System.exit(1);
		}
	}

	public static void generateLiterals(BufferedWriter out, DispatchPtr ptr) throws COMException, IOException {
		Integer count = (Integer) ptr.invoke("GetLiteralCount");
		if (count != null) {
			for (int i = 0; i < count; i++) {
				DispatchPtr cons = (DispatchPtr) ptr.invoke("GetLiteralAt", new Integer(i));
				String consName = (String) cons.get("Name");
				writeln(out, "\tstatic final int " + consName + " = " + i + ";");
			}
		}
	}
	
	// ========================================================================
	//                                 UTILITIES
	// ========================================================================
	
	public static String convertIdent(String ident) {
		return ident.substring(0, 1).toLowerCase() + ident.substring(1);
	}
	
	public static String convertType(String type) {
		if (type.equals("Boolean")) {
			return "boolean";
		} else if (type.equals("Integer")) {
			return "int";
		} else if (type.equals("String")) {
			return "String";
		} else {
			System.out.println("\tNON-BUILTIN-TYPE: " + type);
			return "int";
		}
	}

}
