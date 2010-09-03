package co.staruml.views;

import java.util.Vector;

import co.staruml.core.NodeView;
import co.staruml.graphics.*;
import co.staruml.uml.UML;


/*
actor
usecase
class
interface
component
node
enumeration
signal
exception
collaboration
object
package
model
subsystem
*/

public class UMLGeneralNodeView extends NodeView {

	protected static final int
			COMPARTMENT_INTERVAL = 8,		
			COMPARTMENTSAREA_LEFT_MARGIN = 5,
			COMPARTMENTSAREA_RIGHT_MARGIN = 5,
			COMPARTMENTSAREA_TOP_MARGIN = 5,
			COMPARTMENTSAREA_BOTTOM_MARGIN = 10,
			
			ICON_WIDTH = 16,
			ICON_HEIGHT = 16,
			NAMECOMPARTMENT_ICON_RIGHT_MARGIN = 5,
			
			DECORATION_ICON_WIDTH = 28,
			DECORATION_ICON_HEIGHT = 28;
	
	
	protected String stereotype = "";
	protected String name ;
	protected String namespace = "";
	protected String property = "";
	protected String icon = "";;
	protected UMLCompartment templateCompartment;
	protected Vector<UMLCompartment> compartments;
	protected int stereotypeDisplay;
	protected boolean showNamespace;
	protected boolean showProperty;
	protected boolean showShadow;
	protected boolean showGradation;
	protected boolean showIcon;
	
	protected Point namePt;
	protected int attributeHeight;
	
	public UMLGeneralNodeView() {
		templateCompartment = new UMLCompartment("template");
		compartments = new Vector<UMLCompartment>();
		
		lineColor = Color.GRAY;
		fillColor = Color.CYAN;
		font = new Font("Tahoma", Font.NORMAL, 8);
		
//		stereotypeDisplay = UML.SD_DECORATION;
//		stereotype = "stereotype : <<ClassDiagram>>";
//		namespace = "namespace : org.mk.graphics";
//		property = "{transient,\nok=true,\nGUI=false}";
		name = "Prak, YongCheon";
		
		showNamespace = false;
		showProperty = false;
		showShadow = true;
		showGradation = true;
		showIcon = false;
	}

	// ------------------------------------------------------------------------
	
	protected Point getNameCompartmentSize(Canvas canvas, boolean _showStereotype,
			boolean _showIcon, boolean _showNamespace, boolean _showProperty,
			boolean _showDecorationIcon) {
		int w = 0;
		int h = 0;
		Point sz = null;
		if (_showStereotype) {
			sz = canvas.textExtent(stereotype);
			w = Math.max(w, sz.getX());
			h = h + sz.getY();
		}
		sz = canvas.textExtent(name);
		int _w = sz.getX();
		if (showIcon) _w = _w + ICON_WIDTH + NAMECOMPARTMENT_ICON_RIGHT_MARGIN;
		w = Math.max(w, _w);
		h = h + Math.max(ICON_HEIGHT, sz.getY());
		if (_showNamespace) {
			sz = canvas.textExtent(namespace);
			w = Math.max(w, sz.getX());
			h = h + sz.getY();
		}
		if (_showProperty) {
			sz = canvas.textExtent(property);
			w = Math.max(w, sz.getX());
			h = h + sz.getY();
		}
		if (_showDecorationIcon)
			w = Math.max(w, w + DECORATION_ICON_WIDTH);
		namePt = new Point(w+COMPARTMENTSAREA_LEFT_MARGIN+COMPARTMENTSAREA_RIGHT_MARGIN, 
						   h+COMPARTMENTSAREA_TOP_MARGIN+COMPARTMENTSAREA_BOTTOM_MARGIN);
		return  new Point(w, h);
	}
	
	protected Point getCompartmentSize(Canvas canvas, UMLCompartment compartment) {
		int w = 0;
		int h = 0;
		if (compartment != null) {
			UMLCompartmentItem[] items = compartment.getItems();
			if (items != null) {
				h = Math.max(ICON_HEIGHT, items.length * canvas.textExtent("^_").getY());
				for (int i = 0; i < items.length; i++) {
					int _w = canvas.textExtent(items[i].getText()).getX();
					if (showIcon) _w = _w + ICON_WIDTH;
					w = Math.max(w, _w);
				}
			}
		}
		return new Point(w, h);
	}
	
	protected Point getCompartmentsAreaSize(Canvas canvas,
			boolean _showStereotype, boolean _showDecorationIcon) {
		int w = 0;
		int h = 0;
		Point sz = null;
		sz = getNameCompartmentSize(canvas, _showStereotype, showIcon, 
				showNamespace, showProperty, _showDecorationIcon);
		w = Math.max(w, sz.getX());
		h = h + sz.getY();
		
		for (int i = 0; i < compartments.size(); i++) {
			sz = getCompartmentSize(canvas, compartments.elementAt(i));
			w = Math.max(w, sz.getX());
			h = h + COMPARTMENT_INTERVAL + sz.getY();
			if(i == 0){ // set attribute height
				attributeHeight = sz.getY(); 
			}
		}
		return new Point(
				w + COMPARTMENTSAREA_LEFT_MARGIN + COMPARTMENTSAREA_RIGHT_MARGIN,
				h + COMPARTMENTSAREA_TOP_MARGIN + COMPARTMENTSAREA_BOTTOM_MARGIN);
	}

	// ------------------------------------------------------------------------

	protected void drawDecorationIcon(Canvas canvas, Rect rect) {
		// TODO StereotypeIcon�?NotationIcon??구분?�고, 각각????�� draw 메소?��? ?�요????
		// canvas.rectangle(x, y, x + DECORATION_ICON_WIDTH, y + DECORATION_ICON_HEIGHT);
		canvas.rectangle(rect.getX1(), rect.getY1(), rect.getX2(), rect.getY2());
	}
	
	protected void drawNameCompartment(Canvas canvas, int x1, int x2, int y,
			boolean _showStereotype, boolean _showIcon, boolean _showNamespace, 
			boolean _showProperty, boolean _showDecorationIcon) {
		Rect rect = new Rect();
		Point sz = null;
		int _x1 = x1;
		int _x2 = x2;
		int _y = y;
		if (_showDecorationIcon) {
			_x2 = x2 - COMPARTMENTSAREA_RIGHT_MARGIN - DECORATION_ICON_WIDTH;
			drawDecorationIcon(canvas, new Rect(_x2, _y, 
					_x2 + DECORATION_ICON_WIDTH, _y + DECORATION_ICON_HEIGHT));
		}
		if (_showStereotype) {
			sz = canvas.textExtent(stereotype);
			rect.setRect(_x1, _y, _x2, _y + sz.getY());
			canvas.textOut(rect, stereotype, Canvas.AL_CENTER, Canvas.AL_TOP);
			_y = _y + sz.getY();
		}
		sz = canvas.textExtent(name);
		rect.setRect(_x1, _y, _x2, Math.max(ICON_HEIGHT, _y + sz.getY()));
		Font f = new Font(canvas.getFont());
		f.setStyle(Font.BOLD); canvas.setFont(f);
		canvas.textOut(rect, name, Canvas.AL_CENTER, Canvas.AL_MIDDLE);
		if (_showIcon) {
			int _icon_x = ((_x1 + _x2) / 2) - (sz.getX() / 2) - ICON_WIDTH - NAMECOMPARTMENT_ICON_RIGHT_MARGIN;
			canvas.drawImage(_icon_x, _y, icon);
		}
		f.setStyle(Font.NORMAL); canvas.setFont(f);
		_y = _y + sz.getY();
		if (_showNamespace) {
			sz = canvas.textExtent(namespace);
			rect.setRect(_x1, _y, _x2, _y + sz.getY());
			canvas.textOut(rect, namespace, Canvas.AL_CENTER, Canvas.AL_TOP);
			_y = _y + sz.getY();
		}
		if (_showProperty) {
			sz = canvas.textExtent(property);
			rect.setRect(_x1, _y, _x2, _y + sz.getY());
			canvas.textOut(rect, property, Canvas.AL_RIGHT, Canvas.AL_TOP);
			_y = _y + sz.getY();
		}
	}

	protected void drawTemplateCompartment(Canvas canvas) {
		// TODO TemplateParameter 처리 (drawTemplateCompartment??별로 메소?�로 분리)
	}
	
	protected void drawCompartment(Canvas canvas, int x1, int x2, int y, UMLCompartment compartment) {
		UMLCompartmentItem[] items = compartment.getItems();
		if (items != null) {
			int _x1 = x1 + COMPARTMENTSAREA_LEFT_MARGIN;
			int _x2 = x2 - COMPARTMENTSAREA_RIGHT_MARGIN;
			int _y = y;
			Rect rect = new Rect();
			for (int i = 0; i < items.length; i++) {
				Point sz = canvas.textExtent(items[i].getText());
				rect.setRect(_x1, _y, _x2, _y + sz.getY());
				if (showIcon) {
					canvas.drawImage(_x1 - 2, _y, items[i].getIcon());
					canvas.textOut(_x1 + ICON_WIDTH, _y, items[i].getText());
				} else {
					canvas.textOut(_x1, _y, items[i].getText());
				}
				_y = _y + Math.max(ICON_HEIGHT, sz.getY());
			}
		}
	}
	
	protected void drawCompartmentsArea(Canvas canvas, int x1, int x2, int y, 
			boolean _showStereotype, boolean _showDecorationIcon) {
		int _x1 = x1 + COMPARTMENTSAREA_LEFT_MARGIN;
		int _x2 = x2 - COMPARTMENTSAREA_RIGHT_MARGIN;
		int _y = y + COMPARTMENTSAREA_TOP_MARGIN;
		Point sz = null;
		Rect rect = new Rect();
		sz = getNameCompartmentSize(canvas, _showStereotype || _showDecorationIcon, 
				showIcon, showNamespace, showProperty, _showDecorationIcon);
		drawNameCompartment(canvas, _x1, _x2, _y, _showStereotype || _showDecorationIcon,
				showIcon, showNamespace, showProperty, _showDecorationIcon);
		_y = _y + sz.getY();
		_x1 = x1 + COMPARTMENTSAREA_LEFT_MARGIN;
		_x2 = x2 - COMPARTMENTSAREA_RIGHT_MARGIN;
		for (int i = 0; i < compartments.size(); i++) {
			UMLCompartment comp = compartments.elementAt(i);
			if (comp.isVisible()) {
				_y = _y + COMPARTMENT_INTERVAL;
				sz = getCompartmentSize(canvas, comp);
				canvas.line(x1, _y, x2, _y);
				drawCompartment(canvas, x1, x2, _y, comp);
				_y = _y + sz.getY();
			}
		}
	}	
	
	protected void drawShadow(Canvas canvas) {
		assignStyleToCanvas(canvas);
		canvas.storeState();
		canvas.setAlpha(100);
		canvas.setFillColor(Color.LIGHT_GRAY);
		canvas.fillRect(left + 5, top + 5, getRight() + 5, getBottom()+ 5);
		canvas.restoreState();
	}
	
	protected void drawObjectBackground(Canvas canvas) {
		if (showShadow)
			drawShadow(canvas);
		canvas.fillRect(left, top, getRight(), getBottom());
		if (showGradation) {
			canvas.setPattern(new GradientPattern(left, top, left, getBottom(), 
					fillColor, Color.WHITE));
			canvas.fillRect(left, top, getRight(), getBottom());
			canvas.setPattern(null);
		}
		canvas.rectangle(left, top, getRight(), getBottom());
	}
	
	protected void drawAsCanonicalForm(Canvas canvas, boolean _showStereotype) {
		drawObjectBackground(canvas);
		drawCompartmentsArea(canvas, left, getRight(), top, _showStereotype, false);
	}
	
	protected void drawAsDecorationForm(Canvas canvas) {
		drawObjectBackground(canvas);
		drawCompartmentsArea(canvas, left, getRight(), top, true, true);
	}
	
	protected void drawAsIconicForm(Canvas canvas) {
		
	}
	
	protected void drawObject(Canvas canvas) {
		switch (stereotypeDisplay) {
		case UML.SD_NONE:
			drawAsCanonicalForm(canvas, false);
			break;
		case UML.SD_LABEL:
			drawAsCanonicalForm(canvas, true);
			break;
		case UML.SD_DECORATION:
			drawAsDecorationForm(canvas);
			break;
		case UML.SD_ICON:
			drawAsIconicForm(canvas);
		}
	}
	
	// ------------------------------------------------------------------------

	protected void arrangeAsCanonicalForm(Canvas canvas, boolean _showStereotype) {
		Point sz = getCompartmentsAreaSize(canvas, _showStereotype, false);
		minWidth = sz.getX();
		minHeight = sz.getY();
	}

	protected void arrangeAsDecorationForm(Canvas canvas) {
		Point sz = getCompartmentsAreaSize(canvas, true, true);
		minWidth = sz.getX();
		minHeight = sz.getY();
	}

	protected void arrangeAsIconicForm(Canvas canvas) {
		
	}

	protected void arrangeObject(Canvas canvas) {
		assignStyleToCanvas(canvas);
		switch (stereotypeDisplay) {
		case UML.SD_NONE:
			arrangeAsCanonicalForm(canvas, false);
			break;
		case UML.SD_LABEL:
			arrangeAsCanonicalForm(canvas, true);
			break;
		case UML.SD_DECORATION:
			arrangeAsDecorationForm(canvas);
			break;
		case UML.SD_ICON:
			arrangeAsIconicForm(canvas);
		}
		super.arrangeObject(canvas);
	}

	// ------------------------------------------------------------------------

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNamespace() {
		return namespace;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	public String getStereotype() {
		return stereotype;
	}

	public void setStereotype(String stereotype) {
		this.stereotype = stereotype;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public int getStereotypeDisplay() {
		return stereotypeDisplay;
	}

	public void setStereotypeDisplay(int stereotypeDisplay) {
		this.stereotypeDisplay = stereotypeDisplay;
	}
	
	public Point getClassAreaPoint(Canvas canvas){
		return namePt;
	}
	
	public int getAttributereaHeight(Canvas canvas){
		return attributeHeight;
	}
}
