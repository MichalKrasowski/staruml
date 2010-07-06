package co.staruml.handler;

public class MouseEvent {
	
	public static final int BUTTON1 = 1;
	public static final int BUTTON2 = 2;
	public static final int BUTTON3 = 3;
	
	private int x;
	private int y;
	private int button;
	private int count;
	private boolean shiftDown;
	private boolean altDown;
	private boolean ctrlDown;

	public MouseEvent(int x, int y, int button, int count, 
			boolean shiftDown, boolean altDown, boolean ctrlDown) {
		this.x = x;
		this.y = y;
		this.button = button;
		this.count = count;
		this.shiftDown = shiftDown;
		this.altDown = altDown;
		this.ctrlDown = ctrlDown;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getButton() {
		return button;
	}
	
	public int getCount() {
		return count;
	}
	
	public boolean isShiftDown() {
		return shiftDown;
	}
	
	public boolean isAltDown() {
		return altDown;
	}
	
	public boolean isCtrlDown() {
		return ctrlDown;
	}
}
