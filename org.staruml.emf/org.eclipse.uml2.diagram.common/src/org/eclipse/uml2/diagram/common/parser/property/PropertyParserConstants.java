/* Generated By:JavaCC: Do not edit this line. PropertyParserConstants.java */
/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Michael Golubev (Borland) - initial API and implementation
 */
package org.eclipse.uml2.diagram.common.parser.property;

public interface PropertyParserConstants {

  int EOF = 0;
  int SLASH = 3;
  int COLON = 4;
  int EQUALS = 5;
  int LBRACKET = 6;
  int RBRACKET = 7;
  int LCURLY = 8;
  int RCURLY = 9;
  int COMMA = 10;
  int PLUS = 11;
  int MINUS = 12;
  int NUMBER_SIGN = 13;
  int TILDE = 14;
  int DOT = 15;
  int STAR = 16;
  int READ_ONLY = 17;
  int UNION = 18;
  int SUBSETS = 19;
  int REDEFINES = 20;
  int ORDERED = 21;
  int UNORDERED = 22;
  int UNIQUE = 23;
  int NON_UNIQUE = 24;
  int INTEGER_LITERAL = 25;
  int IDENTIFIER = 26;
  int LETTER = 27;
  int DIGIT = 28;

  int DEFAULT = 0;

  String[] tokenImage = {
    "<EOF>", //$NON-NLS-1$
    "\" \"", //$NON-NLS-1$
    "\"\\t\"", //$NON-NLS-1$
    "\"/\"", //$NON-NLS-1$
    "\":\"", //$NON-NLS-1$
    "\"=\"", //$NON-NLS-1$
    "\"[\"", //$NON-NLS-1$
    "\"]\"", //$NON-NLS-1$
    "\"{\"", //$NON-NLS-1$
    "\"}\"", //$NON-NLS-1$
    "\",\"", //$NON-NLS-1$
    "\"+\"", //$NON-NLS-1$
    "\"-\"", //$NON-NLS-1$
    "\"#\"", //$NON-NLS-1$
    "\"~\"", //$NON-NLS-1$
    "\".\"", //$NON-NLS-1$
    "\"*\"", //$NON-NLS-1$
    "\"readOnly\"", //$NON-NLS-1$
    "\"union\"", //$NON-NLS-1$
    "\"subsets\"", //$NON-NLS-1$
    "\"redefines\"", //$NON-NLS-1$
    "\"ordered\"", //$NON-NLS-1$
    "\"unordered\"", //$NON-NLS-1$
    "\"unique\"", //$NON-NLS-1$
    "\"nonunique\"", //$NON-NLS-1$
    "<INTEGER_LITERAL>", //$NON-NLS-1$
    "<IDENTIFIER>", //$NON-NLS-1$
    "<LETTER>", //$NON-NLS-1$
    "<DIGIT>", //$NON-NLS-1$
  };

}
