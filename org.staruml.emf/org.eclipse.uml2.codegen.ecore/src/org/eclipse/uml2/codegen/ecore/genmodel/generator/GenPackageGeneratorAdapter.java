/*
 * Copyright (c) 2006 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - initial API and implementation
 *
 * $Id: GenPackageGeneratorAdapter.java,v 1.1 2010/09/17 05:33:34 administrator Exp $
 */
package org.eclipse.uml2.codegen.ecore.genmodel.generator;

import org.eclipse.emf.codegen.ecore.generator.GeneratorAdapterFactory;
import org.eclipse.emf.codegen.jet.JETEmitter;
import org.eclipse.emf.codegen.jet.JETException;

/**
 * @since 1.2.0
 */
public class GenPackageGeneratorAdapter
		extends
		org.eclipse.emf.codegen.ecore.genmodel.generator.GenPackageGeneratorAdapter {

	private static JETEmitterDescriptor[] JET_EMITTER_DESCRIPTORS = null;

	@Override
	protected JETEmitterDescriptor[] getJETEmitterDescriptors() {

		if (JET_EMITTER_DESCRIPTORS == null) {
			JETEmitterDescriptor[] superJETEmitterDescriptors = super
				.getJETEmitterDescriptors();
			JET_EMITTER_DESCRIPTORS = new JETEmitterDescriptor[superJETEmitterDescriptors.length];

			System.arraycopy(superJETEmitterDescriptors, 0,
				JET_EMITTER_DESCRIPTORS, 0, superJETEmitterDescriptors.length);

			JET_EMITTER_DESCRIPTORS[RESOURCE_FACTORY_CLASS_ID] = new JETEmitterDescriptor(
				"model/ResourceFactoryClass.javajet", //$NON-NLS-1$
				"org.eclipse.uml2.codegen.ecore.templates.model.ResourceFactoryClass"); //$NON-NLS-1$
		}

		return JET_EMITTER_DESCRIPTORS;
	}

	public GenPackageGeneratorAdapter(
			GeneratorAdapterFactory generatorAdapterFactory) {
		super(generatorAdapterFactory);
	}

	@Override
	protected void addClasspathEntries(JETEmitter jetEmitter)
			throws JETException {
		super.addClasspathEntries(jetEmitter);

		UML2GenBaseGeneratorAdapter.addUML2ClasspathEntries(jetEmitter);
	}

}
