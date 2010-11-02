package org.eclipse.uml2.diagram.common.compartments;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Locator;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.TreeSearch;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw2d.geometry.Translatable;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.Handle;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableCompartmentEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.handles.CompartmentCollapseHandle;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.gmf.runtime.notation.DrawerStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.common.UMLCommonPlugin;

public class U2TResizableCompartmentEditPolicy extends ResizableCompartmentEditPolicy {

	@SuppressWarnings("unchecked")
	@Override
	protected List createCollapseHandles() {
		IGraphicalEditPart part = (IGraphicalEditPart) getHost();

		List<Handle> collapseHandles = new ArrayList<Handle>();
		collapseHandles.add(new U2TCollapseHandle(part));
		return collapseHandles;
	}
	protected static class U2TCollapseHandle extends CompartmentCollapseHandle implements IMapMode /*, IMapModeHolder */{

		private CollapsingLabel myCompartmentLabel;

		private IMapMode myOwnerMapMode;

		public U2TCollapseHandle(IGraphicalEditPart owner) {
			super(owner);
			if (getOwnerFigure() instanceof U2TCompartmentFigure) {
				U2TCompartmentFigure hostFigure = (U2TCompartmentFigure) getOwnerFigure();
				remove(collapseFigure);
				collapseFigure.setVisible(false);
				add(myCompartmentLabel = createCompartmentLabel(hostFigure));
				setLocator(new U2THandleLocator());
				myCompartmentLabel.setCollapsed(isStyleCollapsed());
			}
		}
		
		@SuppressWarnings("restriction")
		public void propertyChange(PropertyChangeEvent evt) {
			//relying on the super implementation
			myCompartmentLabel.setCollapsed(collapseFigure.isCollapsed());
		}
		
		public void notifyChanged(Notification notification) {
			if (NotationPackage.eINSTANCE.getDrawerStyle_Collapsed()==notification.getFeature())
				myCompartmentLabel.setCollapsed(notification.getNewBooleanValue());
		}
		
		@Override
		public IFigure findFigureAt(int x, int y, TreeSearch search) {
			IFigure found = super.findFigureAt(x, y, search);
			if (myCompartmentLabel != null && found != null){
				return this;
			}
			return found;
		}

		public int DPtoLP(int deviceUnit) {
			return getOwnerMapMode().DPtoLP(deviceUnit);
		}

		public Translatable DPtoLP(Translatable t) {
			return getOwnerMapMode().DPtoLP(t);
		}

		public int LPtoDP(int logicalUnit) {
			return getOwnerMapMode().LPtoDP(logicalUnit);
		}

		public Translatable LPtoDP(Translatable t) {
			return getOwnerMapMode().LPtoDP(t);
		}

		private CollapsingLabel createCompartmentLabel(U2TCompartmentFigure hostFigure) {
			CollapsingLabel result = new CollapsingLabel(hostFigure.getTitleNotNull());
			result.setFont(hostFigure.getFont());
			return result;
		}

		private IGraphicalEditPart getOwnerImpl() {
			return (IGraphicalEditPart) getOwner();
		}

		private IMapMode getOwnerMapMode() {
			if (myOwnerMapMode == null) {
				myOwnerMapMode = MapModeUtil.getMapMode(getOwnerFigure());
			}
			return myOwnerMapMode;
		}

		private boolean isStyleCollapsed() {
			View view = getOwnerImpl().getNotationView();
			if (view != null) {
				DrawerStyle style = (DrawerStyle) view.getStyle(NotationPackage.eINSTANCE.getDrawerStyle());
				return style != null && style.isCollapsed();
			}
			return false;
		}

		protected class U2THandleLocator implements Locator {
			private static final int LABEL_LINE_GAP = 6;

			public void relocate(IFigure target) {
				if (getOwnerFigure() instanceof U2TCompartmentFigure) {
					U2TCompartmentFigure figureImpl = (U2TCompartmentFigure) getOwnerFigure();
					Rectangle theBounds = figureImpl.getTextPaneBounds().getCopy();
					getOwnerFigure().translateToAbsolute(theBounds);
					target.translateToRelative(theBounds);
					
					Dimension actualTextBounds = myCompartmentLabel.getPreferredSize(-1, -1);
					theBounds.width = Math.min(theBounds.width, actualTextBounds.width + 2 * LABEL_LINE_GAP);
					theBounds.translate(LABEL_LINE_GAP, 0);

					target.setBounds(theBounds);
				}
			}
		}
		
		protected static class CollapsingLabel extends WrappingLabel {
			private Boolean myIsCollapsed;

			public CollapsingLabel(String text){
				super(text);
				
				setOpaque(true);
				setTextPlacement(PositionConstants.EAST);
				setIconAlignment(PositionConstants.BOTTOM);
				setTextAlignment(PositionConstants.BOTTOM);
				setAlignment(PositionConstants.CENTER);
			}
			
			public void setCollapsed(boolean isCollapsed){
				if (myIsCollapsed != null && myIsCollapsed.booleanValue() == isCollapsed){
					return;
				}
				myIsCollapsed = Boolean.valueOf(isCollapsed);
				setIcon(UMLCommonPlugin.getInstance().getImageRegistry().get(//
						isCollapsed ? UMLCommonPlugin.IMAGE_PLUS : UMLCommonPlugin.IMAGE_MINUS));
				revalidate();
				repaint();
			}
			
		}

	}
}
