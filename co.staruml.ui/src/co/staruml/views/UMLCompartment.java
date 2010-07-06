package co.staruml.views;

import java.util.Vector;

public class UMLCompartment {

	private String name;
	private boolean visible;
	private Vector<UMLCompartmentItem> items;
	
	public UMLCompartment(String name) {
		this.name = name;
		visible = true;
		items = new Vector<UMLCompartmentItem>();
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isVisible() {
		return visible;
	}
	
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	public void clearItems() {
		items.clear();
	}
	
	public void addItem(UMLCompartmentItem item) {
		items.add(item);
	}
	
	public void removeItem(UMLCompartmentItem item) {
		items.remove(item);
	}
	
	public UMLCompartmentItem[] getItems() {
		return items.toArray(new UMLCompartmentItem[0]);
	}
	
	public int count() {
		return items.size();
	}
	
}
