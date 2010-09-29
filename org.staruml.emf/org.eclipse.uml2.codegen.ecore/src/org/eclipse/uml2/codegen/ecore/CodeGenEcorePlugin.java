/*
 * Copyright (c) 2005, 2006 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - initial API and implementation
 *
 * $Id: CodeGenEcorePlugin.java,v 1.1 2010/09/17 05:33:35 administrator Exp $
 */
package org.eclipse.uml2.codegen.ecore;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.ResourceLocator;

/**
 * The <b>Plugin </b> for the UML2.CodeGen.Ecore library.
 */
public final class CodeGenEcorePlugin
		extends EMFPlugin {

	/**
	 * The singleton instance of the plugin.
	 */
	public static final CodeGenEcorePlugin INSTANCE = new CodeGenEcorePlugin();

	/**
	 * The one instance of this class.
	 */
	private static Implementation plugin;

	/**
	 * Creates the singleton instance.
	 */
	private CodeGenEcorePlugin() {
		super(
			new ResourceLocator[]{org.eclipse.emf.codegen.ecore.CodeGenEcorePlugin.INSTANCE});
	}

	@Override
	public ResourceLocator getPluginResourceLocator() {
		return plugin;
	}

	/**
	 * Returns the singleton instance of the Eclipse plugin.
	 * 
	 * @return the singleton instance.
	 */
	public static Implementation getPlugin() {
		return plugin;
	}

	/**
	 * The actual implementation of the Eclipse <b>Plugin </b>.
	 */
	public static class Implementation
			extends EMFPlugin.EclipsePlugin {

		/**
		 * Creates an instance.
		 */
		public Implementation() {
			super();

			// Remember the static instance.
			//
			plugin = this;
		}
	}
}
