package co.staruml.core;

import co.staruml.graphics.*;

public class LabelView extends NodeView {

	private String text;
	private int horizontalAlignment;
	private int verticalAlignment;

	public LabelView() {
		text = "";
		horizontalAlignment = Canvas.AL_CENTER;
		verticalAlignment = Canvas.AL_MIDDLE;
	}
	
	protected void drawObject(Canvas canvas) {
		assignStyleToCanvas(canvas);
		Rect r = new Rect(left, top, getRight(), getBottom());
		canvas.textOut(r, text, horizontalAlignment, verticalAlignment);
	}
	
	protected void arrangeObject(Canvas canvas) {
		assignStyleToCanvas(canvas);
		minWidth = canvas.textExtent(text).getX();
		minHeight = canvas.textExtent("^_").getY();
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public int getHorizontalAlignment() {
		return horizontalAlignment;
	}
	
	public void setHorizontalAlignment(int horizontalAlignment) {
		this.horizontalAlignment = horizontalAlignment;
	}
	
	public int getVerticalAlignment() {
		return verticalAlignment;
	}
	
	public void setVerticalAlignment(int verticalAlignment) {
		this.verticalAlignment = verticalAlignment;
	}
	
	
}
