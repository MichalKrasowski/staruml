package co.staruml.graphics;

// TODO Underline ?��??�에 ??�� 처리�??�요????

public class Font {

	public static final int NORMAL = 0;
	public static final int BOLD = 1;
	public static final int ITALIC = 2;
	
	private String name;
	private int style;
	private int size;
	
	public Font() {
		name = "Arial";
		style = NORMAL;
		size = 10;
	}
	
	public Font(String name, int style, int size) {
		this.name = name;
		this.style = style;
		this.size = size;
	}
	
	public Font(Font f) {
		this.name = f.getName();
		this.style = f.getStyle();
		this.size = f.getSize();
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getStyle() {
		return style;
	}
	
	public void setStyle(int style) {
		this.style = style;
	}
	
	public int getSize() {
		return size;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
}
