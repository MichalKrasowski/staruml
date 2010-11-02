package org.eclipse.uml2.diagram.common.layered;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderedNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.uml2.diagram.common.editparts.PrimaryShapeEditPart;

/**
 * @author Yury Semikhatsky
 */
public class MultilayeredSupportImpl implements MultilayeredSupport {

	private final Map<String, IFigure> myLayerToFigure = new HashMap<String, IFigure>();

	private final Map<String, IFigure> myLayerToContentPane = new HashMap<String, IFigure>();

	private MultilayeredSupport myParent;

	private IFigure myParentDefaultContentPane;

	public MultilayeredSupportImpl() {
		myParent = null;
		myParentDefaultContentPane = null;
	}

	public MultilayeredSupportImpl(GraphicalEditPart parentEditPart) {
		setParentFromParentEditPart(parentEditPart);
	}

	public void setParentFromParentEditPart(GraphicalEditPart parentEditPart) {
		IFigure parentFigure = getPrimaryFigure(parentEditPart);
		if (parentFigure instanceof MultilayeredFigure) {
			myParent = ((MultilayeredFigure) parentFigure).getMultilayeredSupport();
		} else {
			myParent = null;
		}
		myParentDefaultContentPane = parentEditPart.getContentPane();
	}

	private IFigure getPrimaryFigure(GraphicalEditPart editPart) {
		if (editPart instanceof PrimaryShapeEditPart) {
			return ((PrimaryShapeEditPart) editPart).getPrimaryShape();
		} else {
			return editPart.getFigure();
		}
	}

	public void addToLayers(MultiLayeredContainer container) {
		for (Map.Entry<String, IFigure> nextEntry : myLayerToFigure.entrySet()) {
			String layerKey = nextEntry.getKey();
			IFigure parent = getContentPane(container, layerKey);
			IFigure figure = nextEntry.getValue();
			figure = getDecorated(figure);
			parent.add(figure);
		}
	}

	public void removeFromLayers(MultiLayeredContainer container) {
		for (Map.Entry<String, IFigure> e : myLayerToFigure.entrySet()) {
			String layerKey = e.getKey();

			IFigure parent = getContentPane(container, layerKey);
			IFigure figure = e.getValue();
			figure = getDecorated(figure);
			parent.remove(figure);
		}
	}

	public IFigure getContentPaneOn(String layerKey) {
		return myLayerToContentPane.get(layerKey);
	}

	public void setLayerToFigure(String layerKey, IFigure figure) {
		assert !myLayerToFigure.containsKey(layerKey);
		assert figure != null;
		myLayerToFigure.put(layerKey, figure);
	}

	public void setLayerToContentPane(String layerKey, IFigure contentPane) {
		assert !myLayerToContentPane.containsKey(layerKey);
		assert contentPane != null;
		myLayerToContentPane.put(layerKey, contentPane);
	}

	private IFigure getContentPane(MultiLayeredContainer container, String layerKey) {
		IFigure parent = null;
		if (myParent != null) {
			parent = myParent.getContentPaneOn(layerKey);
		}

		if (parent == null && MultiLayeredContainer.MIDDLE_LAYER.equals(layerKey)) {
			parent = myParentDefaultContentPane;
		}

		if (parent == null) {
			parent = container.getLayerContentPane(layerKey);
			if (parent == null) {
				throw new IllegalStateException("Unexpected layer key: " + layerKey); //$NON-NLS-1$
			}
		}

		return parent;
	}

	private static IFigure getDecorated(IFigure figure) {
		if (figure.getParent() instanceof DefaultSizeNodeFigure) {
			figure = figure.getParent();
		}
		if (figure.getParent() instanceof BorderedNodeFigure) {
			figure = figure.getParent();
		}
		return figure;
	}

}
