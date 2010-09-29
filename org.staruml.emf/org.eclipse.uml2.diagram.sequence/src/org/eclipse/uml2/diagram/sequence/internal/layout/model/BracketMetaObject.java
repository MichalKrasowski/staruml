package org.eclipse.uml2.diagram.sequence.internal.layout.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsNode;


interface BracketMetaObject {
	BracketMetaObject getChildBracketMetaObject(View reference);
    LMLifeLineBracket createChildBracket(AbsNode gdeNode, LmOwner lmOwner);
	
	boolean needsOffsetRight();
	
	int getTopOutSpace();
	int getTopInSpace();
	int getBottomOutSpace();
	int getBottomInSpace();
    
	boolean tieBottomToTop();
	
	static abstract class Adapter implements BracketMetaObject {
		public Adapter(int verticalInSpace, int verticalTopOutSpace, int verticalBottomOutSpace, boolean needsOffsetRight) {
			myVerticalInSpace = verticalInSpace;
			myVerticalTopOutSpace = verticalTopOutSpace;
			myVerticalBottomOutSpace = verticalBottomOutSpace;
			myNeedsOffsetRight = needsOffsetRight;
		}
		public abstract BracketMetaObject getChildBracketMetaObject(View reference);
		
		public boolean needsOffsetRight() {
			return myNeedsOffsetRight;
		}
		public int getBottomInSpace() {
			return myVerticalInSpace;
		}
		public int getBottomOutSpace() {
			return myVerticalBottomOutSpace;
		}
		public int getTopInSpace() {
			return myVerticalInSpace;
		}
		public int getTopOutSpace() {
			return myVerticalTopOutSpace;
		}
        public boolean tieBottomToTop() {
            return false;
        }
		private final int myVerticalTopOutSpace;
		private final int myVerticalBottomOutSpace;
		private final int myVerticalInSpace;
		private final boolean myNeedsOffsetRight;
	}
	
	
	static abstract class Ruled extends Adapter {
		public Ruled(int verticalInSpace, int verticalOutSpace, boolean needsOffsetRight) {
			this(verticalInSpace, verticalOutSpace, verticalOutSpace, needsOffsetRight);
		}
		public Ruled(int verticalInSpace, int verticalTopOutSpace, int verticalBottomOutSpace, boolean needsOffsetRight) {
			super(verticalInSpace, verticalTopOutSpace, verticalBottomOutSpace, needsOffsetRight);
		}
		public BracketMetaObject getChildBracketMetaObject(View reference) {
			for (int i=0; i<myGetChildBracketLogics.size(); i++) {
				GetChildBracketLogic getChildBracketLogic = (GetChildBracketLogic)myGetChildBracketLogics.get(i);
				BracketMetaObject bracketMetaObject = getChildBracketLogic.getChildBracketMetaObject(reference);
				if (bracketMetaObject != null) {
					return bracketMetaObject;
				}
			}
			return null;
		}
		void addMetaclass(EClass metaclass, BracketMetaObject bracketMetaObject) {
			Rule rule = new Rule(metaclass, bracketMetaObject);
			addGetChildBracketLogic(new GetChildBracketLogicImpl(rule));
		}
		void addCondition(Condition condition, BracketMetaObject bracketMetaObject) {
			Rule rule = new Rule(condition, bracketMetaObject);
			addGetChildBracketLogic(new GetChildBracketLogicImpl(rule));
		}
		void addGetChildBracketLogics(Collection<GetChildBracketLogic> getChildBracketLogics) {
			myGetChildBracketLogics.addAll(getChildBracketLogics);
		}
		void addGetChildBracketLogic(GetChildBracketLogic getChildBracketLogic) {
			myGetChildBracketLogics.add(getChildBracketLogic);
		}
		
		private final List<GetChildBracketLogic> myGetChildBracketLogics = new ArrayList<GetChildBracketLogic>(4);
		
		interface GetChildBracketLogic {
			BracketMetaObject getChildBracketMetaObject(View reference);
		}
		static class GetChildBracketLogicImpl implements GetChildBracketLogic {
			GetChildBracketLogicImpl(EClass metaclass, BracketMetaObject bracketMetaObject) {
				this(new Rule(metaclass, bracketMetaObject));
			}
			GetChildBracketLogicImpl(Rule rule) {
				myRule = rule;
			}
			public BracketMetaObject getChildBracketMetaObject(View reference) {
				if (!myRule.getCondition().matches(reference)) {
					return null;
				}
				return myRule.getBracketMetaObject();
			}
			private final Rule myRule;
		}
		
		interface Condition {
			boolean matches(View reference);
		}
		
		static class EClassCondition implements Condition {
			private final EClass[] myEClasses;

			EClassCondition(EClass ...eClasses){
				myEClasses = eClasses;
			}
			
			public boolean matches(View reference) {
				EObject entity = reference.getElement();
				if (entity == null){
					return false;
				}
				for (EClass next : myEClasses){
					if (next.isInstance(entity)){
						return true;
					}
				}
				return false;
			}
		}
		
		static class Rule {
			Rule(EClass eClass, BracketMetaObject bracketMetaObject) {
				this(new EClassCondition(eClass), bracketMetaObject);
			}
			Rule(Condition condition, BracketMetaObject bracketMetaObject) {
				myCondition = condition;
				myBracketMetaObject = bracketMetaObject;
			}
			BracketMetaObject getBracketMetaObject() {
				return myBracketMetaObject;
			}
			Condition getCondition() {
				return myCondition;
			}
			private final Condition myCondition;
			private final BracketMetaObject myBracketMetaObject;
		}
	}
}
