package org.eclipse.uml2.diagram.common.sheet.chooser;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.FilteredList;
import org.eclipse.ui.dialogs.FilteredList.FilterMatcher;

/*
 * This control repeats functionality from org.eclipse.ui.dialogs.AbstractElementListSelectionDialog.
 * We don't need any dialog here, that's why we cannot use the original class, but copy the code instead.
 * See #263012 'Add FilterText composite to FilteredList'
 * See #263035 'Filtered List: Provide access to fList field'
 */
public class FilteredListControl extends Composite {

	private boolean fIgnoreCase = true;

	private boolean fIsMultipleSelection = false;

	private boolean fMatchEmptyString = true;

	private boolean fAllowDuplicates = true;

	private Text fFilterText;

	private List<Object> myInitialSelections = new ArrayList<Object>();

	private String fFilter = null;

	protected FilteredList fFilteredList;

	private final ILabelProvider fRenderer;

	private FilteredList myFilteredList;

	private TableViewer viewer;
	
	public FilteredListControl(Composite parent, ILabelProvider renderer) {
		super(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.marginWidth = 0;
		layout.marginHeight = 0;
		setLayout(layout);
		setLayoutData(new GridData(GridData.FILL_BOTH));
		fRenderer = renderer;
		createFilterText(this);
		myFilteredList = createFilteredList(this);
	}

	protected void setFilterMatcher(FilterMatcher filterMatcher) {
		myFilteredList.setFilterMatcher(filterMatcher);
	}

	public void setInitialSelections(Object[] selectedElements) {
		myInitialSelections = new ArrayList<Object>(selectedElements.length);
		for (int i = 0; i < selectedElements.length; i++) {
			myInitialSelections.add(selectedElements[i]);
		}
	}
	
	@Override
	public boolean setFocus() {
		if (myFilteredList != null) {
			return myFilteredList.setFocus();
		}
		return super.setFocus();
	}

	protected Text createFilterText(Composite parent) {
		Text text = new Text(parent, SWT.BORDER);

		GridData data = new GridData();
		data.grabExcessVerticalSpace = false;
		data.grabExcessHorizontalSpace = true;
		data.horizontalAlignment = GridData.FILL;
		data.verticalAlignment = GridData.BEGINNING;
		
		text.setLayoutData(data);
		text.setFont(parent.getFont());

		text.setText((fFilter == null ? "" : fFilter)); //$NON-NLS-1$

		Listener listener = new Listener() {

			public void handleEvent(Event e) {
				fFilteredList.setFilter(fFilterText.getText());
			}
		};
		text.addListener(SWT.Modify, listener);

		text.addKeyListener(new KeyListener() {

			public void keyPressed(KeyEvent e) {
				if (e.keyCode == SWT.ARROW_DOWN) {
					fFilteredList.setFocus();
				}
			}

			public void keyReleased(KeyEvent e) {
			}
		});

		fFilterText = text;

		return text;
	}

/* 
 * Hack to add Double-Click Listener
 * See #263035 'Filtered List: Provide access to fList field'
 */
	private Table getTable(FilteredList list) {
		try {
			Field field = list.getClass().getDeclaredField("fList"); //$NON-NLS-1$
			if (!field.isAccessible()) {
				field.setAccessible(true);
			}
			Object value = field.get(list);
			return (Table)value;
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null;
	}
	
	protected FilteredList createFilteredList(Composite parent) {
		int flags = SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL | (fIsMultipleSelection ? SWT.MULTI : SWT.SINGLE);

		FilteredList list = new FilteredList(parent, flags, fRenderer, fIgnoreCase, fAllowDuplicates, fMatchEmptyString);
		Table table = getTable(list);
		if (table!= null) {
			viewer = new TableViewer(table);
		}

		GridData data = new GridData();
		// data.widthHint = convertWidthInCharsToPixels(fWidth);
		// data.heightHint = convertHeightInCharsToPixels(fHeight);
		data.grabExcessVerticalSpace = true;
		data.grabExcessHorizontalSpace = true;
		data.horizontalAlignment = GridData.FILL;
		data.verticalAlignment = GridData.FILL;
		list.setLayoutData(data);
		list.setFont(parent.getFont());
		list.setFilter((fFilter == null ? "" : fFilter)); //$NON-NLS-1$		

		fFilteredList = list;

		return list;
	}

	protected void setListElements(Object[] elements) {
		Assert.isNotNull(fFilteredList);
		fFilteredList.setElements(elements);
	}

	/**
	 * Sets the filter pattern.
	 * 
	 * @param filter
	 *            the filter pattern.
	 */
	public void setFilter(String filter) {
		if (fFilterText == null) {
			fFilter = filter;
		} else {
			fFilterText.setText(filter);
		}
	}

	/**
	 * Returns the current filter pattern.
	 * 
	 * @return returns the current filter pattern or
	 *         <code>null<code> if filter was not set.
	 */
	public String getFilter() {
		if (fFilteredList == null) {
			return fFilter;
		} else {
			return fFilteredList.getFilter();
		}
	}

	/**
	 * Returns the indices referring the current selection. To be called within
	 * open().
	 * 
	 * @return returns the indices of the current selection.
	 */
	protected int[] getSelectionIndices() {
		Assert.isNotNull(fFilteredList);
		return fFilteredList.getSelectionIndices();
	}

	/**
	 * Returns an index referring the first current selection. To be called
	 * within open().
	 * 
	 * @return returns the indices of the current selection.
	 */
	protected int getSelectionIndex() {
		Assert.isNotNull(fFilteredList);
		return fFilteredList.getSelectionIndex();
	}

	/**
	 * Sets the selection referenced by an array of elements. Empty or null
	 * array removes selection. To be called within open().
	 * 
	 * @param selection
	 *            the indices of the selection.
	 */
	protected void setSelection(Object[] selection) {
		Assert.isNotNull(fFilteredList);
		fFilteredList.setSelection(selection);
	}

	/**
	 * Returns an array of the currently selected elements. To be called within
	 * or after open().
	 * 
	 * @return returns an array of the currently selected elements.
	 */
	protected Object[] getSelectedElements() {
		Assert.isNotNull(fFilteredList);
		return fFilteredList.getSelection();
	}

	/**
	 * Returns all elements which are folded together to one entry in the list.
	 * 
	 * @param index
	 *            the index selecting the entry in the list.
	 * @return returns an array of elements folded together.
	 */
	public Object[] getFoldedElements(int index) {
		Assert.isNotNull(fFilteredList);
		return fFilteredList.getFoldedElements(index);
	}

	public void addDoubleClickListener(IDoubleClickListener l) {
		viewer.addDoubleClickListener(l);
	}

	public void addSelectionListener(final ISelectionChangedListener l) {
		viewer.addSelectionChangedListener(l);
	}


}
