/*
 * Copyright (c) 2009 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Tatiana Fesenko (Borland) - initial API and implementation
 */
package org.eclipse.uml2.diagram.common.stereo;

import java.net.URL;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.diagram.common.UMLCommonPlugin;
import org.eclipse.uml2.diagram.common.providers.ImageUtils;
import org.eclipse.uml2.uml.Image;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.util.UMLUtil;

public class StereotypeImages {

	private static final ImageDescriptor CORRUPTED_ICON = PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_OBJS_WARN_TSK);

	public static ImageDescriptor getImageDescriptorForStereotypeApplication(EObject stereotypeApplication, ImageDescriptor metaclassImage) {
		String key = getImageRegistryKey(stereotypeApplication);
		Stereotype stereo = UMLUtil.getStereotype(stereotypeApplication);
		return getImageDescriptorForStereotype(stereo, metaclassImage, key);
	}

	public static ImageDescriptor getImageDescriptor(Stereotype stereo, ImageDescriptor metaclassImage) {
		String key = getImageRegistryKey(stereo);
		return getImageDescriptorForStereotype(stereo, metaclassImage, key);
	}

	private static ImageDescriptor getImageDescriptorForStereotype(Stereotype stereo, ImageDescriptor metaclassImage, String imgRegistryKey) {
		ImageDescriptor imageDescriptor = getImageRegistry().getDescriptor(imgRegistryKey);
		if (imageDescriptor == null) {
			imageDescriptor = getProvidedImageDescriptor(stereo, metaclassImage);
			if (imageDescriptor == null) {
				return null;
			}
			getImageRegistry().put(imgRegistryKey, imageDescriptor);
		}
		return imageDescriptor;
	}

	private static ImageDescriptor getProvidedImageDescriptor(Stereotype appliedStereotype, ImageDescriptor metaclassImage) {
		Resource eResource = appliedStereotype.eResource();
		if (eResource == null || eResource.getResourceSet() == null) {
			return null;
		}
		for (Image icon : appliedStereotype.getIcons()) {
			URIConverter uriConverter = eResource.getResourceSet().getURIConverter();
			URI normalizedURI = uriConverter.normalize(eResource.getURI());
			String location = icon.getLocation();
			ImageDescriptor imgDescriptor = getProvidedImageDescriptor(location, uriConverter, normalizedURI);
			if (imgDescriptor != null) {
				if (metaclassImage != null && location.indexOf("ovr16") != -1) { //$NON-NLS-1$
					return ImageUtils.overlay(metaclassImage, imgDescriptor);
				}
				return imgDescriptor;
			}
		}
		return null;
	}

	private static ImageDescriptor getProvidedImageDescriptor(String location, URIConverter uriConverter, URI normalizedURI) {
		if (!UML2Util.isEmpty(location)) {
			URI uri = URI.createURI(location).resolve(normalizedURI);
			try {
				URL url = new URL(uriConverter.normalize(uri).toString());
				url.openStream().close();
				return ImageDescriptor.createFromURL(url);
			} catch (Exception e) {
				return CORRUPTED_ICON;
			}
		}
		return null;
	}
	
	private static String getImageRegistryKey(EObject stereotypeApplicationOrStereotype) {
		// we try to use stereotypeApplication in order to handle changes of its 'images' property wherever it is possible
		// when stereotypeApplication is not accessible, we use Stereotype
		return EcoreUtil.getURI(stereotypeApplicationOrStereotype).toString();
	}

	private static ImageRegistry getImageRegistry() {
		return UMLCommonPlugin.getInstance().getImageRegistry();
	}

}