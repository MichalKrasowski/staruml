package org.eclipse.uml2.diagram.common.sheet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.ui.provider.PropertySource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.properties.sections.AdvancedPropertySection;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.IPropertySourceProvider;
import org.eclipse.uml2.uml.edit.providers.ElementItemProvider;

public class UMLStereotypePropertySection extends AdvancedPropertySection implements IPropertySourceProvider {

	public IPropertySource getPropertySource(Object object) {
		if (object instanceof IPropertySource) {
			return (IPropertySource) object;
		}
		AdapterFactory af = getAdapterFactory(object);
		if (af != null) {
			IItemPropertySource ips = (IItemPropertySource) af.adapt(object, IItemPropertySource.class);
			if (ips != null) {
				return new UMLStereotypePropertySource(object, ips);					
			}
		}
		if (object instanceof IAdaptable) {
			return (IPropertySource) ((IAdaptable) object).getAdapter(IPropertySource.class);
		}
		return null;
	}

	@Override
	protected IPropertySourceProvider getPropertySourceProvider() {
		return this;
	}

	protected Object transformSelection(Object selected) {

		if (selected instanceof EditPart) {
			Object model = ((EditPart) selected).getModel();
			return model instanceof View ? ((View) model).getElement() : null;
		}
		if (selected instanceof View) {
			return ((View) selected).getElement();
		}
		if (selected instanceof IAdaptable) {
			View view = (View) ((IAdaptable) selected).getAdapter(View.class);
			if (view != null) {
				return view.getElement();
			}
		}
		return selected;
	}

	@Override
	public void setInput(IWorkbenchPart part, ISelection selection) {
		if (selection.isEmpty() || false == selection instanceof StructuredSelection) {
			super.setInput(part, selection);
			return;
		}
		final StructuredSelection structuredSelection = ((StructuredSelection) selection);
		ArrayList<Object> transformedSelection = new ArrayList<Object>(structuredSelection.size());
		for (Iterator<?> it = structuredSelection.iterator(); it.hasNext();) {
			Object r = transformSelection(it.next());
			if (r != null) {
				transformedSelection.add(r);
			}
		}
		super.setInput(part, new StructuredSelection(transformedSelection));
	}

	protected AdapterFactory getAdapterFactory(Object object) {
		if (getEditingDomain() instanceof AdapterFactoryEditingDomain) {
			return ((AdapterFactoryEditingDomain) getEditingDomain()).getAdapterFactory();
		}
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(object);
		if (editingDomain != null) {
			return ((AdapterFactoryEditingDomain) editingDomain).getAdapterFactory();
		}
		return null;
	}

	private static class UMLStereotypePropertySource extends PropertySource {

		protected List<IItemPropertyDescriptor> stereotypeApplicationItemPropertyDescriptors = null;

		protected UMLStereotypePropertySource(Object object, IItemPropertySource itemPropertySource) {
			super(object, itemPropertySource);
		}

		@Override
		public IPropertyDescriptor[] getPropertyDescriptors() {
			List<IPropertyDescriptor> propertyDescriptors = new ArrayList<IPropertyDescriptor>();
			if (itemPropertySource instanceof ElementItemProvider) {
				ElementItemProvider elementItemProvider = (ElementItemProvider) itemPropertySource;
				stereotypeApplicationItemPropertyDescriptors = elementItemProvider.getStereotypeApplicationPropertyDescriptors(object);

				if (stereotypeApplicationItemPropertyDescriptors != null) {

					for (IItemPropertyDescriptor itemPropertyDescriptor : stereotypeApplicationItemPropertyDescriptors) {
						propertyDescriptors.add(createPropertyDescriptor(itemPropertyDescriptor));
					}
				}
			}

			return propertyDescriptors.toArray(new IPropertyDescriptor[propertyDescriptors.size()]);
		}

		protected IItemPropertyDescriptor getItemPropertyDescriptor(Object propertyId) {
			IItemPropertyDescriptor itemPropertyDescriptor = itemPropertySource.getPropertyDescriptor(object, propertyId);

			return itemPropertyDescriptor == null && itemPropertySource instanceof ElementItemProvider ? ((ElementItemProvider) itemPropertySource).getStereotypeApplicationPropertyDescriptor(object,
					propertyId) : itemPropertyDescriptor;
		}

		@Override
		public Object getPropertyValue(Object propertyId) {
			return getItemPropertyDescriptor(propertyId).getPropertyValue(object);
		}

		@Override
		public boolean isPropertySet(Object propertyId) {
			return getItemPropertyDescriptor(propertyId).isPropertySet(object);
		}

		@Override
		public void resetPropertyValue(Object propertyId) {
			getItemPropertyDescriptor(propertyId).resetPropertyValue(object);
		}

		@Override
		public void setPropertyValue(Object propertyId, Object value) {
			getItemPropertyDescriptor(propertyId).setPropertyValue(object, value);
		}

	}
}
