package co.staruml.core;

public class Cursor {
	
	public static final int DEFAULT = 0; 
	public static final int CROSSHAIR = 1; 
	public static final int TEXT = 2;
	public static final int WAIT = 3;
	public static final int SW_RESIZE = 4;
	public static final int SE_RESIZE = 5;
	public static final int NW_RESIZE = 6; 
	public static final int NE_RESIZE = 7;
	public static final int N_RESIZE = 8; 
	public static final int S_RESIZE = 9; 
	public static final int W_RESIZE = 10; 
	public static final int E_RESIZE = 11; 
	public static final int HAND = 12; 
	public static final int MOVE = 13; 
	
	public static final Cursor PREDEFINED_DEFAULT = new Cursor(DEFAULT); 
	public static final Cursor PREDEFINED_CROSSHAIR = new Cursor(CROSSHAIR); 
	public static final Cursor PREDEFINED_TEXT = new Cursor(TEXT);
	public static final Cursor PREDEFINED_WAIT = new Cursor(WAIT);
	public static final Cursor PREDEFINED_SW_RESIZE = new Cursor(SW_RESIZE);
	public static final Cursor PREDEFINED_SE_RESIZE = new Cursor(SE_RESIZE);
	public static final Cursor PREDEFINED_NW_RESIZE = new Cursor(NW_RESIZE); 
	public static final Cursor PREDEFINED_NE_RESIZE = new Cursor(NE_RESIZE);
	public static final Cursor PREDEFINED_N_RESIZE = new Cursor(N_RESIZE); 
	public static final Cursor PREDEFINED_S_RESIZE = new Cursor(S_RESIZE); 
	public static final Cursor PREDEFINED_W_RESIZE = new Cursor(W_RESIZE); 
	public static final Cursor PREDEFINED_E_RESIZE = new Cursor(E_RESIZE); 
	public static final Cursor PREDEFINED_HAND = new Cursor(HAND); 
	public static final Cursor PREDEFINED_MOVE = new Cursor(MOVE); 
	
	private int type;
	
	public Cursor(int style) {
		this.type = style;
	}
	
	public int getType() {
		return type;
	}
}
