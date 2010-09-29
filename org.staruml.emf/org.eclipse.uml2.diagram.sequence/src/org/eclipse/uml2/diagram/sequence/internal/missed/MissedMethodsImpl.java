package org.eclipse.uml2.diagram.sequence.internal.missed;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.draw2d.AbsoluteBendpoint;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.IntListValueStyle;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.Size;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint;
import org.eclipse.jface.resource.ColorRegistry;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.uml2.diagram.common.editparts.PrimaryShapeEditPart;
import org.eclipse.uml2.diagram.common.links.ConnectionRoutingHelper;
import org.eclipse.uml2.diagram.sequence.anchor.SDModelUtil;
import org.eclipse.uml2.diagram.sequence.edit.parts.InnerMountingLinkEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.MessageEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.MountingLinkEditPart;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsElement;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsLink;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.gef.AbsLinkGef;
import org.eclipse.uml2.diagram.sequence.internal.missed.MissedMethods._ArcasMetamodelSpecific;
import org.eclipse.uml2.diagram.sequence.internal.missed.MissedMethods._ConnectionEditPart;
import org.eclipse.uml2.diagram.sequence.internal.missed.MissedMethods._ExecutionSpecification;
import org.eclipse.uml2.diagram.sequence.internal.missed.MissedMethods._GraphicalEditPart;
import org.eclipse.uml2.diagram.sequence.internal.missed.MissedMethods._IGraphicalEditPart;
import org.eclipse.uml2.diagram.sequence.model.SDModelAccess;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDBehaviorSpec;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDBracket;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDExecution;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDInvocation;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDLifeLine;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDMessage;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDModel;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDTrace;
import org.eclipse.uml2.diagram.sequence.part.UMLDiagramUpdater;
import org.eclipse.uml2.diagram.sequence.part.UMLNodeDescriptor;
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.ExecutionSpecification;
import org.eclipse.uml2.uml.InteractionOperand;
import org.eclipse.uml2.uml.InteractionUse;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageSort;


public class MissedMethodsImpl {
	static abstract class MissedGraphicalEditPartImpl implements _IGraphicalEditPart, _GraphicalEditPart {
		public void setBackgroundColor(IGraphicalEditPart ep, RGB rgb) {
			IFigure shape = getColorTargetFigure(ep);
			Color color = getColor(rgb);
			if (shape != null && color != null){
				shape.setBackgroundColor(color);
			}
		}

		public void setForegroundColor(IGraphicalEditPart ep, RGB rgb) {
			IFigure shape = getColorTargetFigure(ep);
			Color color = getColor(rgb);
			if (shape != null && color != null){
				shape.setForegroundColor(color);
			}
		}
		
		private Color getColor(RGB rgb){
			String symbolic = toSymbolicName(rgb);
			Color result = myColorRegistry.get(symbolic);
			if (result == null){
				myColorRegistry.put(symbolic, rgb);
				result = myColorRegistry.get(symbolic);
			}
			return result;
		}
		
		public boolean isUserResized(GraphicalEditPart ep) {
			View view = ep.getNotationView();
			if (view instanceof Node){
				Node node = (Node)view;
				if (node.getLayoutConstraint() instanceof Size){
					Size size = (Size)node.getLayoutConstraint();
					return size.eIsSet(NotationPackage.eINSTANCE.getSize_Height()) && size.eIsSet(NotationPackage.eINSTANCE.getSize_Width());
				}
			}
			System.err.println("isUserResized asked for incompatible editpart " + ep );
			return false;
		}
		
		public void markUserResized(GraphicalEditPart ep) {
			if (isUserResized(ep)){
				return;
			}
			View view = ep.getNotationView();
			if (view instanceof Node){
				Node node = (Node)view;
				if (node.getLayoutConstraint() instanceof Size){
					Size size = (Size)node.getLayoutConstraint();
					//expected to be changed soon by actual layout
					System.err.println("Temporary set width 999 for : " + ep);
					size.setWidth(999);
				}
			}
		}
		
		private String toSymbolicName(RGB rgb){
			return "RGB[" + rgb.red + "," + rgb.green + "," + rgb.blue + "]";
		}
		
		private IFigure getColorTargetFigure(IGraphicalEditPart editPart){ 
			if (editPart instanceof PrimaryShapeEditPart){
				return ((PrimaryShapeEditPart)editPart).getPrimaryShape();
			}
			return editPart.getFigure();
		}
		
		private final ColorRegistry myColorRegistry = new ColorRegistry();	
	}
	
	static class MissedArcasMetamodelSpecificImpl implements _ArcasMetamodelSpecific {
		public boolean isFrame(EObject eObject) {
			return 
				eObject instanceof CombinedFragment || 
				eObject instanceof InteractionOperand || 
				eObject instanceof InteractionUse;
		}
		
		public boolean isMountingLink(AbsElement absElement) {
			AbsLinkGef impl = (AbsLinkGef)absElement;
			IGraphicalEditPart editPart = impl.getEditPart();
			return editPart instanceof MountingLinkEditPart || editPart instanceof InnerMountingLinkEditPart;
		}
		
		public boolean isNoDuration(ExecutionSpecification spec) {
			return false;
		}
		
		public boolean isArcasExecution(View reference, ExecutionSpecification entity) {
			SDModel sdModel = SDModelAccess.findSDModel(reference);
			return sdModel != null && sdModel.getUMLTracing().findBehaviorSpec(entity) instanceof SDExecution;
		}
		
		public boolean isArcasInvocation(View reference, ExecutionSpecification entity) {
			SDModel sdModel = SDModelAccess.findSDModel(reference);
			return sdModel != null && sdModel.getUMLTracing().findBehaviorSpec(entity) instanceof SDInvocation;
		}
		
		public boolean isAlienLink(AbsLink link){
			if (isMountingLink(link)){
				return false;
			}
			if (isMessageLink(link)){
				return false;
			}
			return true; 
		}
		
		public boolean isMessageLink(AbsElement absElement) {
			AbsLinkGef impl = (AbsLinkGef)absElement;
			return impl.getEditPart() instanceof MessageEditPart;
		}
		
		public boolean isAsynchonousMessage(AbsLink link) {
			View reference = link.getReference();
			if (reference == null || false == reference.getElement() instanceof Message){
				//wow
				return false;
			}
			Message message = (Message) reference.getElement();
			MessageSort messageSort = message.getMessageSort();
			return isAsynchonousMessageSort(messageSort);
		}
		
		public boolean isAsynchonousMessageSort(MessageSort messageSort) {
			return SDModelUtil.isAsynchonousMessageSort(messageSort);
		}
		
		
		
		public boolean isFoundMessageInvocation(EObject object) {
			// TODO Auto-generated method stub
			return false;
		}
		
		public List<EObject> getArcasMetamodelChildren(View containerView) {
			List<EObject> result = new LinkedList<EObject>();
			for (Object next : UMLDiagramUpdater.getSemanticChildren(containerView)){
				UMLNodeDescriptor nextDescriptor = (UMLNodeDescriptor)next;
				result.add(nextDescriptor.getModelElement());
			}
			return result;
		}
	}
	
	static class MissedConnectionEditPartImpl implements _ConnectionEditPart {
		private static final String SOURCE_ANCHOR_STYLE = "SourceAnchor";
		private static final String TARGET_ANCHOR_STYLE = "TargetAnchor";
		private static final String BENDPOINTS_LIST_STYLE = "BendpointsList";
		
		@SuppressWarnings("unchecked")
		public List getBendpoints(ConnectionEditPart linkEP) {
			List result = new ArrayList(8);
			loadPointListFromStyle((Edge)linkEP.getNotationView(), BENDPOINTS_LIST_STYLE, result);
			return result;
		}
		
		public Point getSourcePoint(ConnectionEditPart linkEP) {
			Point fromStyle = loadPointFromStyle((Edge)linkEP.getNotationView(), SOURCE_ANCHOR_STYLE);
			if (fromStyle != null){
				return fromStyle; 
			}

			PolylineConnection connection = (PolylineConnection) linkEP.getFigure();
			Point result = connection.getSourceAnchor().getReferencePoint();
			if (result.x == 0 && result.y == 0){
				GraphicalEditPart sourceEP = (GraphicalEditPart) linkEP.getSource();
				Rectangle sourceBounds = MissedMethods._graphicalEditPart().getBounds(sourceEP);
				if (sourceBounds != null){
					result = sourceBounds.getCenter();
				}
			}
			return result;
		}
		
		public Point getTargetPoint(ConnectionEditPart linkEP) {
			Point fromStyle = loadPointFromStyle((Edge)linkEP.getNotationView(), TARGET_ANCHOR_STYLE);
			if (fromStyle != null){
				return fromStyle; 
			}
			
			PolylineConnection connection = (PolylineConnection) linkEP.getFigure();
			Point result = connection.getTargetAnchor().getReferencePoint();
			if (result.x == 0 && result.y == 0){
				GraphicalEditPart targetEP = (GraphicalEditPart) linkEP.getTarget();
				Rectangle targetBounds = MissedMethods._graphicalEditPart().getBounds(targetEP);
				if (targetBounds != null){
					result = targetBounds.getCenter();
				}
			}
			return result;
		}
		
		private Point loadPointFromStyle(Edge edge, String styleName){
			IntListValueStyle style = (IntListValueStyle) edge.getNamedStyle(NotationPackage.eINSTANCE.getIntListValueStyle(), styleName);
			if (style == null){
				return null;
			}
			Integer x = (Integer) style.getIntListValue().get(0);
			Integer y = (Integer) style.getIntListValue().get(1);
			return new Point(x, y);
		}
		
		private void loadPointListFromStyle(Edge edge, String styleName, List<AbsoluteBendpoint> output){
			IntListValueStyle style = (IntListValueStyle) edge.getNamedStyle(NotationPackage.eINSTANCE.getIntListValueStyle(), styleName);
			if (style == null){
				return;
			}
			for (Iterator<Integer> ints = style.getIntListValue().iterator(); ints.hasNext();){
				int x = ints.next();
				if (!ints.hasNext()){
					System.err.println("Odd number of integers, points List expected: " + style + ", \n for edge: " + edge);
					break;
				}
				int y = ints.next();
				output.add(new AbsoluteBendpoint(x, y));
			}
		}
		
		@SuppressWarnings("unchecked")
		private void savePointListAsStyle(Edge edge, String styleName, List points){
			IntListValueStyle style = (IntListValueStyle) edge.getNamedStyle(NotationPackage.eINSTANCE.getIntListValueStyle(), styleName);
			if (style == null){
				style = (IntListValueStyle) edge.createStyle(NotationPackage.eINSTANCE.getIntListValueStyle());
				style.setName(styleName);
			}
			List intList = style.getIntListValue();
			intList.clear();
			for (Object next : points){
				Point nextPoint = (Point)next;
				intList.add(Integer.valueOf(nextPoint.x));
				intList.add(Integer.valueOf(nextPoint.y));
			}
		}
		
		private void savePointAsStyle(Edge edge, Point point, String styleName){
			IntListValueStyle style = (IntListValueStyle) edge.getNamedStyle(NotationPackage.eINSTANCE.getIntListValueStyle(), styleName);
			if (style == null){
				style = (IntListValueStyle) edge.createStyle(NotationPackage.eINSTANCE.getIntListValueStyle());
				style.setName(styleName);
			}
			style.getIntListValue().clear();
			style.getIntListValue().add(Integer.valueOf(point.x));
			style.getIntListValue().add(Integer.valueOf(point.y));
		}
		
		public void setupBendpoints(ConnectionEditPart linkEP, Point sourcePoint, Point targetPoint, List bendpoints) {
			Edge edge = (Edge) linkEP.getNotationView();
			GraphicalEditPart sourceEP = (GraphicalEditPart) linkEP.getSource();
			Rectangle sourceBounds = MissedMethods._graphicalEditPart().getBounds(sourceEP);
			ConnectionRoutingHelper.setConnectionSourceAnchor(edge, sourcePoint, sourceBounds);
			savePointAsStyle(edge, sourcePoint, SOURCE_ANCHOR_STYLE);
			
			GraphicalEditPart targetEP = (GraphicalEditPart) linkEP.getTarget();
			Rectangle targetBounds = MissedMethods._graphicalEditPart().getBounds(targetEP);
			ConnectionRoutingHelper.setConnectionTargetAnchor(edge, targetPoint, targetBounds);
			savePointAsStyle(edge, targetPoint, TARGET_ANCHOR_STYLE);
			
			if (!bendpoints.isEmpty()){
				List forHelper = new ArrayList(bendpoints.size() + 2);
				forHelper.add(new AbsoluteBendpoint(sourcePoint));
				forHelper.addAll(bendpoints);
				forHelper.add(new AbsoluteBendpoint(targetPoint));
				ConnectionRoutingHelper.setConnectionBendPoints(edge, forHelper, sourcePoint, targetPoint, false);
				savePointListAsStyle(edge, BENDPOINTS_LIST_STYLE, bendpoints);
			}
		}

		public RelativeBendpoint convert(ConnectionEditPart linkEP, Point point) {
			Connection connection = linkEP.getConnectionFigure();
			Point mySourceRef = connection.getSourceAnchor().getReferencePoint().getCopy();
			connection.translateToRelative(mySourceRef);
			Point myTargetRef = connection.getTargetAnchor().getReferencePoint().getCopy();
			connection.translateToRelative(myTargetRef);

			connection.translateToRelative(point);
			Dimension s = point.getDifference(mySourceRef);
			Dimension t = point.getDifference(myTargetRef);
			return new RelativeBendpoint(s.width, s.height, t.width, t.height);
		}

	
	}
	
	static class MissedExecutionSpecificationImpl implements _ExecutionSpecification{
		public boolean isCreation(View specView) {
			return isCreationDestruction(specView, true);
		}
		
		public boolean isDestruction(View specView) {
			return isCreationDestruction(specView, false);
		}
		
		public boolean isCreation(SDExecution execution) {
			return isCreationDestruction(execution, true);
		}
		
		public boolean isDestruction(SDExecution execution) {
			return isCreationDestruction(execution, false);
		}
		
		public boolean isAsynchronousInvocation(SDInvocation invocation) {
			SDMessage sdMessage = invocation.getOutgoingMessage();
			if (sdMessage == null){
				return false;
			}
			Message umlMessage = sdMessage.getUmlMessage();
			return umlMessage != null && MissedMethods._arcasMetamodelSpecific().isAsynchonousMessageSort(umlMessage.getMessageSort());
		}
		
		private boolean isCreationDestruction(View specView, boolean creationNotDectruction){
			EObject entity = specView.getElement();
			if (false == entity instanceof ExecutionSpecification){
				return false;
			}
			SDModel sdModel = SDModelAccess.findSDModel(specView);
			if (sdModel == null){
				return false;
			}
			
			SDTrace tracing = sdModel.getUMLTracing();
			SDBehaviorSpec sdSpec = tracing.findBehaviorSpec((ExecutionSpecification)entity);
			if (false == sdSpec instanceof SDExecution){
				return false;
			}
			
			return isCreationDestruction((SDExecution)sdSpec, creationNotDectruction);
		}
		
		private boolean isCreationDestruction(SDExecution sdExecution, boolean creationNotDectruction){
			if (false == sdExecution.getBracketContainer() instanceof SDLifeLine){
				return false;
			}
			SDMessage incomingMessage = sdExecution.getIncomingMessage();
			if (incomingMessage == null){
				return false;
			}
			
			MessageSort desired = creationNotDectruction ? MessageSort.CREATE_MESSAGE_LITERAL : MessageSort.DELETE_MESSAGE_LITERAL;
			if (incomingMessage.getUmlMessage().getMessageSort() != desired){
				return false;
			}
			
			List<SDBracket> brackets = sdExecution.getBracketContainer().getBrackets();
			int desiredIndex = creationNotDectruction ? 0 : brackets.size() - 1;
			boolean result = brackets.indexOf(sdExecution) == desiredIndex;
			return result;

		}
		
		public boolean isHideFoundMessage(View specView) {
			// TODO Auto-generated method stub
			return false;
		}
	}

}
