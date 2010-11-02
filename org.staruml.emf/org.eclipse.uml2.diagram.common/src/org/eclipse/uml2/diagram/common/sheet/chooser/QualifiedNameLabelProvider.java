package org.eclipse.uml2.diagram.common.sheet.chooser;

import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.diagram.common.sheet.chooser.TabbedElementChooser.LabelProviderWithContext;
import org.eclipse.uml2.uml.NamedElement;


public class QualifiedNameLabelProvider extends LabelProvider implements LabelProviderWithContext {
		
		private final ILabelProvider myImageProvider;

		public QualifiedNameLabelProvider(ILabelProvider imageProvider) {
			myImageProvider = imageProvider;			
		}

		public void setContext(Object... context) {
		}

		@Override
		public Image getImage(Object element) {
			return myImageProvider.getImage(element);
		}

		@Override
		public String getText(Object element) {
			if (element instanceof NamedElement) {
				return ((NamedElement)element).getQualifiedName();
			}
			return StringStatics.BLANK;
		}
		
		@Override
		public void dispose() {
			myImageProvider.dispose();
		}

	}
