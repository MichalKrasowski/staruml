package co.staruml.views;

import co.staruml.graphics.Font;

public class UMLCompartmentItem {

	private String text;
	private String icon;
	private int fontStyle;
	
	public UMLCompartmentItem() {
		text = "";
		icon = "";
		fontStyle = Font.NORMAL;
	}
	
	public UMLCompartmentItem(String text, String icon, int fontStyle) {
		this.text = text;
		this.icon = icon;
		this.fontStyle = fontStyle;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public String getIcon() {
		return icon;
	}
	
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	public int getFontStyle() {
		return fontStyle;
	}
	
	public void setFontStyle(int fontStyle) {
		this.fontStyle = fontStyle;
	}
	
}
