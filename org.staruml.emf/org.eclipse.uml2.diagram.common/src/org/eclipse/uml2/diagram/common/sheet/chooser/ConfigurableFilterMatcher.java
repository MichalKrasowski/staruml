package org.eclipse.uml2.diagram.common.sheet.chooser;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.ui.dialogs.FilteredList.FilterMatcher;
import org.eclipse.ui.internal.misc.StringMatcher;

public class ConfigurableFilterMatcher implements FilterMatcher {

	private final ILabelProvider myLabelProvider;

	private StringMatcher myMatcher;

	public ConfigurableFilterMatcher(ILabelProvider provider) {
		myLabelProvider = provider;
	}

	public void setFilter(String pattern, boolean ignoreCase, boolean ignoreWildCards) {
		myMatcher = new StringMatcher(pattern + '*', ignoreCase, ignoreWildCards);
	}

	public boolean match(Object element) {
		return myMatcher.match(myLabelProvider.getText(element));
	}
}
