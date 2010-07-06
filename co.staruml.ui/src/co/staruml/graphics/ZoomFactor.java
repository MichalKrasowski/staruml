package co.staruml.graphics;

public class ZoomFactor {
	
	private int numer;
	private int denom;
	
	public ZoomFactor(int numer, int denom) {
		setZoomFactor(numer, denom);
	}
	
	public void setZoomFactor(int numer, int denom) {
		this.numer = numer;
		this.denom = denom;
	}
	
	public int getNumer() {
		return numer;
	}
	
	public int getDenom() {
		return denom;
	}
	
}
