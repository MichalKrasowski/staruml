package org.eclipse.uml2.diagram.sequence.internal.layout.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.sequence.internal.layout.GeometryConstants;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsNode;
import org.eclipse.uml2.diagram.sequence.internal.layout.model.BracketMetaObject.Ruled.GetChildBracketLogic;
import org.eclipse.uml2.diagram.sequence.internal.missed.MissedMethods;
import org.eclipse.uml2.uml.ActionExecutionSpecification;
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.ExecutionSpecification;
import org.eclipse.uml2.uml.InteractionConstraint;
import org.eclipse.uml2.uml.InteractionOperand;
import org.eclipse.uml2.uml.InteractionUse;
import org.eclipse.uml2.uml.StateInvariant;

class LmBracketsMetamodel {
	
    final static BracketMetaObject LIFE_LINE_META_OBJECT;
    
    static {
        
        final BracketMetaObject stub = new BracketMetaObject.Adapter(5,5,5,false) {
			public BracketMetaObject getChildBracketMetaObject(View reference) {
                return null;
			}
			public LMLifeLineBracket createChildBracket(AbsNode gdeNode, LmOwner lmOwner) {
                return null;
			}
        };
        
        BracketMetaObject.Ruled lifeLine = new BracketMetaObject.Ruled(0,0,0, false) {
            public LMLifeLineBracket createChildBracket(AbsNode gdeNode, LmOwner lmOwner) {
                throw new UnsupportedOperationException();
            }
        };
        
        final BracketMetaObject.Ruled execution = new BracketMetaObject.Ruled(GeometryConstants.Execution.VERTICAL_IN_SPACE, GeometryConstants.Execution.VERTICAL_TOP_OUT_SPACE, GeometryConstants.Execution.VERTICAL_BOTTOM_OUT_SPACE, true) {
            public LMLifeLineBracket createChildBracket(AbsNode gdeNode, LmOwner lmOwner) {
                return new LMExecutionOccurence(gdeNode, this, lmOwner);
            }
        };
        final BracketMetaObject.Ruled executionNoDuration = new BracketMetaObject.Ruled(GeometryConstants.Execution.VERTICAL_IN_SPACE_NO_DURATION, GeometryConstants.Execution.VERTICAL_TOP_OUT_SPACE_NO_DURATION, GeometryConstants.Execution.VERTICAL_BOTTOM_OUT_SPACE_NO_DURATION, false) {
            public LMLifeLineBracket createChildBracket(AbsNode gdeNode, LmOwner lmOwner) {
                return new LMExecutionOccurence(gdeNode, this, lmOwner);
            }
            public boolean tieBottomToTop() {
                return true;
            }
        };
        
        final BracketMetaObject.Ruled invocation = new BracketMetaObject.Ruled(GeometryConstants.Invocation.VERTICAL_IN_SPACE, GeometryConstants.Invocation.VERTICAL_TOP_OUT_SPACE, GeometryConstants.Invocation.VERTICAL_BOTTOM_OUT_SPACE, false) {
            public LMLifeLineBracket createChildBracket(AbsNode gdeNode, LmOwner lmOwner) {
                return new LMInvocationOccurence(gdeNode, this, lmOwner);
            }
        };
        final BracketMetaObject.Ruled invocationNoDuration = new BracketMetaObject.Ruled(GeometryConstants.Invocation.VERTICAL_IN_SPACE_NO_DURATION, GeometryConstants.Invocation.VERTICAL_TOP_OUT_SPACE_NO_DURATION, GeometryConstants.Invocation.VERTICAL_BOTTOM_OUT_SPACE_NO_DURATION, false) {
            public LMLifeLineBracket createChildBracket(AbsNode gdeNode, LmOwner lmOwner) {
                return new LMInvocationOccurence(gdeNode, this, lmOwner);
            }
            public boolean tieBottomToTop() {
                return true;
            }
        };
        
        final BracketMetaObject.Ruled combinedFragmentMountingRegion = new BracketMetaObject.Ruled(GeometryConstants.CombinedFragmentMountingPoint.VERTICAL_IN_SPACE, GeometryConstants.CombinedFragmentMountingPoint.VERTICAL_OUT_SPACE, false) {
            public LMLifeLineBracket createChildBracket(AbsNode gdeNode, LmOwner lmOwner) {
                return new LmTileFloorMountingRegion(gdeNode, this, lmOwner);
            }
        };
        final BracketMetaObject.Ruled interactionOperandMountingRegion = new BracketMetaObject.Ruled(0,0, false) {
            public LMLifeLineBracket createChildBracket(AbsNode gdeNode, LmOwner lmOwner) {
                return new LmTileMountingRegion(gdeNode, this, lmOwner);
            }
        };
        final BracketMetaObject.Ruled interactionOccurenceMountingRegion = new BracketMetaObject.Ruled(GeometryConstants.InteractionOccurenceMountingPoint.VERTICAL_IN_SPACE, GeometryConstants.InteractionOccurenceMountingPoint.VERTICAL_OUT_SPACE, false) {
            public LMLifeLineBracket createChildBracket(AbsNode gdeNode, LmOwner lmOwner) {
                return new LmSimpleMountingRegion(gdeNode, this, lmOwner);
            }
        };
        final BracketMetaObject.Ruled simpleBracket = new BracketMetaObject.Ruled(0, GeometryConstants.SimpleBracket.VERTICAL_OUT_SPACE, false) {
            public LMLifeLineBracket createChildBracket(AbsNode gdeNode, LmOwner lmOwner) {
                boolean resizableVertically = gdeNode.getModelEntity() instanceof ActionExecutionSpecification;
                return new LMSimpleLifeLineBracket(gdeNode, this, lmOwner, resizableVertically);
            }
        };
        
        BracketMetaObject.Ruled.GetChildBracketLogic [] getChildBracketLogics = {
            	new BracketMetaObject.Ruled.GetChildBracketLogic() {
					public BracketMetaObject getChildBracketMetaObject(View reference) {
						EObject entity = reference.getElement();
						if (false == entity instanceof ExecutionSpecification){
							return null;
						}
						ExecutionSpecification spec = (ExecutionSpecification)entity;
                    	if (!MissedMethods._arcasMetamodelSpecific().isArcasExecution(reference, spec)){
                    		return null;
                    	}
						return isNoDuration(spec) ? executionNoDuration : execution;
					}
					
					private boolean isNoDuration(ExecutionSpecification spec){
						return MissedMethods._arcasMetamodelSpecific().isNoDuration(spec);
					}
					
            	},				
                new BracketMetaObject.Ruled.GetChildBracketLogic() {
                    public BracketMetaObject getChildBracketMetaObject(View reference) {
						EObject entity = reference.getElement();
                    	if (false == entity instanceof ExecutionSpecification){
                    		return null;
                    	}
                    	if (entity instanceof ActionExecutionSpecification){
                    		return null;
                    	}	
                    	ExecutionSpecification spec = (ExecutionSpecification)entity;
                    	if (!MissedMethods._arcasMetamodelSpecific().isArcasInvocation(reference, spec)){
                    		return null;
                    	}
                    	return isNoDuration(spec) ? invocationNoDuration : invocation;
                    }
            		private boolean isNoDuration(ExecutionSpecification spec){
            			return MissedMethods._arcasMetamodelSpecific().isNoDuration(spec);
            		}
            		
                },              
            	new BracketMetaObject.Ruled.GetChildBracketLogic() {
					public BracketMetaObject getChildBracketMetaObject(View reference) {
						EObject entity = reference.getElement();
						if (entity instanceof InteractionConstraint){
							return simpleBracket;
						}
						if (entity instanceof ActionExecutionSpecification){
							return simpleBracket;
						}
						if (entity instanceof StateInvariant){
							return simpleBracket;
						}
						return null;
					}
                }
            };


        abstract class MountingGetChildBracketLogic implements BracketMetaObject.Ruled.GetChildBracketLogic {
			public BracketMetaObject getChildBracketMetaObject(View reference) {
				EObject entity = reference.getElement();
				//in GMF-implementation, there are no explicit mounting regions, the same EObject is used as model for "mounting-region"-like views
				EObject referencedFrame = entity;
				if (referencedFrame != null){
					return getChildBracketImpl(referencedFrame);
				}
				return null;
			}
			
			abstract BracketMetaObject getChildBracketImpl(EObject referencedFrame);
        }
        
        BracketMetaObject.Ruled.GetChildBracketLogic mountingChildBracketInCombinedFragment = 
        	new MountingGetChildBracketLogic() {
                public BracketMetaObject getChildBracketMetaObject(View reference) {
                    BracketMetaObject result = super.getChildBracketMetaObject(reference);
                    if (result == null) {
                        // do not return normal bracket, cause only LmTileMountingRegion can be added to combined fragment region 
                        return stub;
                    } else {
                    	return result;
                    }
                }
				BracketMetaObject getChildBracketImpl(EObject referencedFrame) {
					if (referencedFrame instanceof InteractionOperand) {
						return interactionOperandMountingRegion;
					} else {
                        return null;
					}
				}
        	};				
        
        BracketMetaObject.Ruled.GetChildBracketLogic mountingChildBracketInCommon = 
        	new MountingGetChildBracketLogic() {
				BracketMetaObject getChildBracketImpl(EObject referencedFrame) {
					if (referencedFrame instanceof CombinedFragment) {
						return combinedFragmentMountingRegion;
					} else if (referencedFrame instanceof InteractionOperand) {
						return null;
					} else if (referencedFrame instanceof InteractionUse) {
						return interactionOccurenceMountingRegion;
					} else {
						return null;
					}
				}
        	};				
            
        List<GetChildBracketLogic> getChildBracketLogicsListCommon = new ArrayList<GetChildBracketLogic>();
        getChildBracketLogicsListCommon.add(mountingChildBracketInCommon);
        getChildBracketLogicsListCommon.addAll(Arrays.asList(getChildBracketLogics));
        
        
        
        lifeLine.addGetChildBracketLogics(getChildBracketLogicsListCommon);
        execution.addGetChildBracketLogics(getChildBracketLogicsListCommon);
        executionNoDuration.addGetChildBracketLogics(getChildBracketLogicsListCommon);
        invocation.addGetChildBracketLogics(getChildBracketLogicsListCommon);
        invocationNoDuration.addGetChildBracketLogics(getChildBracketLogicsListCommon);
        
        combinedFragmentMountingRegion.addGetChildBracketLogics(Collections.singletonList(mountingChildBracketInCombinedFragment));
        combinedFragmentMountingRegion.addGetChildBracketLogics(Arrays.asList(getChildBracketLogics));
        
        interactionOperandMountingRegion.addGetChildBracketLogics(getChildBracketLogicsListCommon);
        interactionOccurenceMountingRegion.addGetChildBracketLogics(getChildBracketLogicsListCommon);
        
        LIFE_LINE_META_OBJECT = lifeLine;
    }
}
