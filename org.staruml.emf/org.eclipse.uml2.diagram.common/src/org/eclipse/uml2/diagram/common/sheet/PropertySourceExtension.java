package org.eclipse.uml2.diagram.common.sheet;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.ui.provider.PropertySource;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.uml2.diagram.common.UMLCommonPlugin;

public class PropertySourceExtension extends PropertySource {

	private final AdapterFactory myItemProvidersAdapterFactory;

	private final IDialogSettings myDialogSettings = UMLCommonPlugin.getInstance().getDialogSettings();

	private final IPreferenceStore myPreferenceStore = UMLCommonPlugin.getInstance().getPreferenceStore();

	public PropertySourceExtension(Object object, IItemPropertySource itemPropertySource, AdapterFactory itemProvidersAdapterFactory) {
		super(object, itemPropertySource);
		myItemProvidersAdapterFactory = itemProvidersAdapterFactory;
	}

	@Override
	protected IPropertyDescriptor createPropertyDescriptor(IItemPropertyDescriptor itemPropertyDescriptor) {
		return new ReferencePropertyDescriptor(object, itemPropertyDescriptor, myItemProvidersAdapterFactory, myDialogSettings, myPreferenceStore);
	}

}
