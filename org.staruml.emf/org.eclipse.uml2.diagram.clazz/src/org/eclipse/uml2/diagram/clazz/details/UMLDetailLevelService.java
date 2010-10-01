package org.eclipse.uml2.diagram.clazz.details;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.FilteringStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.clazz.part.CustomMessages;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.VisibilityKind;

public class UMLDetailLevelService {

	public static final String SORT_BY_VISIBILITY = "org.eclipse.uml2.diagram.clazz.sort.visibility"; //$NON-NLS-1$

	public static final String FILTER_BY_VISIBILITY = "org.eclipse.uml2.diagram.clazz.filter.visibility"; //$NON-NLS-1$

	public static UMLDetailLevel getLevel(View view) {
		Diagram diagram = view.getDiagram();
		if (diagram == null){
			// XXX: workaround for 186343
			// it is unclear why notification goes to 
			// edit part for just deleted view
			return DEFAULT_LEVEL;
		}
		FilteringStyle style = (FilteringStyle) diagram.getStyle(NotationPackage.eINSTANCE.getFilteringStyle());
		if (style == null) {
			return DEFAULT_LEVEL;
		}
		List<String> keys = getFilteringKeysImpl(style);
		return keys.isEmpty() ? DEFAULT_LEVEL : getLevel(keys.get(0));
	}

	public static UMLDetailLevel getLevel(String id) {
		if (ID_DETAIL_LEVEL_ANALYSIS.equals(id)) {
			return ANALYSIS_LEVEL;
		}
		if (ID_DETAIL_LEVEL_DETAILS_SUPPRESSED.equals(id)) {
			return DETAILS_SUPPRESSED_LEVEL;
		}
		if (ID_DETAIL_LEVEL_IMPLEMENTATION.equals(id)) {
			return IMPLEMENTATION_LEVEL;
		}
		return EMPTY_LEVEL;
	}

	public static List<View> filterChildrenByVisibility(View view) {
		if (view == null) {
			return Collections.emptyList();
		}
		EList<?> visibleChildren = view.getVisibleChildren();
		List<View> result = new ArrayList<View>();
		for (Object child : visibleChildren) {
			if (child instanceof View) {
				EObject childElement = ((View) child).getElement();
				if (childElement instanceof NamedElement && ((NamedElement) childElement).getVisibility() != VisibilityKind.PUBLIC_LITERAL) {
					result.add((View)child);
				}
			}
		}
		return result;
	}

	public static final UMLDetailLevel DETAILS_SUPPRESSED_LEVEL = new DetailsSuppressedLevel();

	public static final UMLDetailLevel IMPLEMENTATION_LEVEL = new ImplementationLevel();

	public static final UMLDetailLevel ANALYSIS_LEVEL = new AnalysisLevel();

	public static final UMLDetailLevel DEFAULT_LEVEL = IMPLEMENTATION_LEVEL;

	public static final String ID_DETAIL_LEVEL_IMPLEMENTATION = ImplementationLevel.ID;

	public static final String ID_DETAIL_LEVEL_ANALYSIS = AnalysisLevel.ID;

	public static final String ID_DETAIL_LEVEL_DETAILS_SUPPRESSED = DetailsSuppressedLevel.ID;

	public static final UMLDetailLevel EMPTY_LEVEL = new UMLDetailLevel(){
		@Override
		public void init(View view) {
			// nothing to do
		}
	};
	
	@SuppressWarnings("unchecked") //$NON-NLS-1$
	private static List<String> getFilteringKeysImpl(FilteringStyle style){
		return style.getFilteringKeys();
	}

}
