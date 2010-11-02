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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.resource.CompositeImageDescriptor;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Extension;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.ProfileApplication;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.util.UMLUtil;

// Extend UMLUtil in order to use  protected static method #getEClassifier() 
public class StereotypeOperationsEx extends UMLUtil {

	public static org.eclipse.swt.graphics.Image getAppliedStereotypeImage(Element element) {
		return getAppliedStereotypeImage(element, null);
	}

	public static org.eclipse.swt.graphics.Image getAppliedStereotypeImage(Element element, ImageDescriptor metaclassImage) {
		if (element.getStereotypeApplications().isEmpty()) {
			return null;
		}
		List<ImageDescriptor> result = getListOfAppliedStereotypeImages(element, metaclassImage);
		if (result.isEmpty()) {
			return null;
		}
		StereotypeImageDescriptor im = new StereotypeImageDescriptor(result.toArray(new ImageDescriptor[result.size()]));
		return im.createImage();
	}

	public static ImageDescriptor getImage(Stereotype stereo) {
		return StereotypeImages.getImageDescriptor(stereo, null);
	}
	
	public static ImageDescriptor getImage(Stereotype stereo, ImageDescriptor metaclassImage) {
		return StereotypeImages.getImageDescriptor(stereo, metaclassImage);
	}

	private static List<ImageDescriptor> getListOfAppliedStereotypeImages(Element element, ImageDescriptor metaclassImage) {
		EList<EObject> stereoApplications = element.getStereotypeApplications();
		List<ImageDescriptor> result = new ArrayList<ImageDescriptor>(stereoApplications.size());
		for (EObject stereoApplication: stereoApplications) {
			ImageDescriptor imageDescriptor = StereotypeImages.getImageDescriptorForStereotypeApplication(stereoApplication, metaclassImage);
			if (imageDescriptor == null) {
				continue;
			}
			result.add(imageDescriptor);
		}
		return result;
	}
	
// Almost copy of ElementOperations#getApplicableStereotypes()
// But we operate with metaclass of the element, not with the element itself
	public static EList<Stereotype> getApplicableStereotypes(org.eclipse.uml2.uml.Package package_, EClassifier elementMetaclass) {
		if (package_ != null) {
			EList<Stereotype> applicableStereotypes = new UniqueEList.FastCompare<Stereotype>();

			for (ProfileApplication profileApplication : package_.getAllProfileApplications()) {

				Profile appliedProfile = profileApplication.getAppliedProfile();

				if (appliedProfile != null) {

					for (Stereotype stereotype : appliedProfile.getOwnedStereotypes()) {

						ENamedElement appliedDefinition = profileApplication.getAppliedDefinition(stereotype);

						if (appliedDefinition instanceof EClass && !((EClass) appliedDefinition).isAbstract() && getExtension(elementMetaclass, stereotype) != null) {

							applicableStereotypes.add(stereotype);
						}
					}
				}
			}

			return ECollections.unmodifiableEList(applicableStereotypes);
		}

		return ECollections.emptyEList();
	}

	// Almost copy of ElementOperations#getExtension()
	protected static Extension getExtension(EClassifier elementMetaclass, Stereotype stereotype) {

		for (Property attribute : stereotype.getAllAttributes()) {
			Association association = attribute.getAssociation();

			if (association instanceof Extension) {
				String name = attribute.getName();

				if (!isEmpty(name) && name.startsWith(Extension.METACLASS_ROLE_PREFIX)) {

					Type type = attribute.getType();

					if (type instanceof org.eclipse.uml2.uml.Class) {
						EClassifier eClassifier = getEClassifier((org.eclipse.uml2.uml.Class) type);

						//
						// Almost copy of ElementOperations#getExtension()
						// diff is here
						if (eClassifier != null && ((EClass)eClassifier).isSuperTypeOf((EClass) elementMetaclass)) {

							return (Extension) association;
						}
					}
				}
			}
		}

		return null;
	}
	
	private static class StereotypeImageDescriptor extends CompositeImageDescriptor {
		
		private ImageDescriptor[] myImages;
		
		private StereotypeImageDescriptor(ImageDescriptor... images) {
			myImages = images;
		}

		@Override
		protected void drawCompositeImage(int width, int height) {
			int ox = 0;
			int oy = 0;
			for (ImageDescriptor image: myImages) {
				ImageData imageData = image.getImageData();
				drawImage(imageData, ox, oy);
				ox += imageData.width;
			}
		}

		@Override
		protected Point getSize() {
			int ox = 0;
			int oy = 0;
			for (ImageDescriptor image: myImages) {
				ImageData imageData = image.getImageData();
				ox += imageData.width;
				oy = Math.max(oy, imageData.height);
			}
			return new Point(ox, oy);
		}
		
	}

}
