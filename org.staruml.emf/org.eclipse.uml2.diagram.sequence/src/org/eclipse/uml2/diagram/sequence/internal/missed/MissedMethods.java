package org.eclipse.uml2.diagram.sequence.internal.missed;

import java.util.List;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsElement;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsLink;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDExecution;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDInvocation;
import org.eclipse.uml2.uml.ExecutionSpecification;
import org.eclipse.uml2.uml.MessageSort;


/*
 * [U2T]
 */
public class MissedMethods {
	public static interface DifferentSemanticInArcasAndGMF {
		//marker only
	}
	
	public static interface _GraphicalEditPart {
		public Rectangle getBounds(IGraphicalEditPart nodeEP);	
		public void setBounds(IGraphicalEditPart nodeEP, Rectangle bounds);
		
//		public boolean isUserMoved(GraphicalEditPart ep);
//		public void setUserMoved(GraphicalEditPart ep, boolean moved);

		public boolean isUserResized(GraphicalEditPart ep);
		public void markUserResized(GraphicalEditPart ep);
	}
	
	public static interface _ConnectionEditPart {
		public Point getSourcePoint(ConnectionEditPart linkEP);
		public Point getTargetPoint(ConnectionEditPart linkEP);
		public List getBendpoints(ConnectionEditPart linkEP);
		
		public void setupBendpoints(ConnectionEditPart linkEP, Point sourcePoint, Point targetPoint, List bendpoints);
	}
	
	public static interface _IGraphicalEditPart {
		public void setBackgroundColor(IGraphicalEditPart ep, RGB rgb);
		public void setForegroundColor(IGraphicalEditPart ep, RGB rgb);
		
	}
	
	public static interface _ExecutionSpecification {
		public boolean isDestruction(View specView);
		public boolean isCreation(View specView);
		public boolean isDestruction(SDExecution execution);
		public boolean isCreation(SDExecution execution);
		public boolean isHideFoundMessage(View specView);
		
		public boolean isAsynchronousInvocation(SDInvocation invocation);
	}
	
	public static interface _ArcasMetamodelSpecific {
		public List<EObject> getArcasMetamodelChildren(View containerView);
		public boolean isFoundMessageInvocation(EObject eObject);
		public boolean isFrame(EObject eObject);

		public boolean isAsynchonousMessage(AbsLink absElement);
		public boolean isAsynchonousMessageSort(MessageSort messageSort);
		
		public boolean isMountingLink(AbsElement absElement);
		public boolean isMessageLink(AbsElement absElement);
		public boolean isAlienLink(AbsLink link);
		
		public boolean isArcasExecution(View reference, ExecutionSpecification entity);
		public boolean isArcasInvocation(View reference, ExecutionSpecification entity);
		
		public boolean isNoDuration(ExecutionSpecification spec);
	}
	
	public static _GraphicalEditPart _graphicalEditPart(){
		return ourIGraphicalEditPart;
	}
	
	public static _ConnectionEditPart _connectionEditPart() {
		return ourConnectionEditPartImpl;
	}
	
	public static _ExecutionSpecification _executionSpecification(){
		return ourExecutionSpecificationImpl;
	}
	
	public static _ArcasMetamodelSpecific _arcasMetamodelSpecific(){
		return ourArcasMetamodelSpecificImpl;
	}
	
	public static _IGraphicalEditPart _iGraphicalEditPart() {
		return ourIGraphicalEditPart;
	}
	
	private static final MissedMethodsImpl.MissedArcasMetamodelSpecificImpl ourArcasMetamodelSpecificImpl = new MissedMethodsImpl.MissedArcasMetamodelSpecificImpl();
	private static final MissedMethodsImpl.MissedConnectionEditPartImpl ourConnectionEditPartImpl = new MissedMethodsImpl.MissedConnectionEditPartImpl();
	private static final MissedMethodsImpl.MissedExecutionSpecificationImpl ourExecutionSpecificationImpl = new MissedMethodsImpl.MissedExecutionSpecificationImpl();
	private static final MissedMethodsImpl.MissedGraphicalEditPartImpl ourIGraphicalEditPart = new MissedGraphicalEditPart2();
}
