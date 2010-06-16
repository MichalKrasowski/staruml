package enkisoft.sobis.staruml.swt;

import org.eclipse.swt.graphics.GC;

import enkisoft.sobis.staruml.graphics.Pattern;
import enkisoft.sobis.staruml.graphics.Point;

public class CanvasSWTState {
	GC gc;
	Point penPosition;
	org.eclipse.swt.graphics.Color color;
	org.eclipse.swt.graphics.Color fillColor;
	org.eclipse.swt.graphics.Color fontColor;
	org.eclipse.swt.graphics.Font font;
	int lineWidth;
	int lineStyle;
	boolean xorMode;
	int antialias;
	int textAntialias;
	int alpha;
	org.eclipse.swt.graphics.Pattern pattern;
	Pattern abstractPattern;
}
