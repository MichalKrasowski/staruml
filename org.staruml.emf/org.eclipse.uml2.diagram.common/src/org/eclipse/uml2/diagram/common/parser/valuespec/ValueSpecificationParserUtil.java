/*
 * Copyright (c) 2009 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Sergey Gribovsky (Borland) - initial API and implementation
 */
package org.eclipse.uml2.diagram.common.parser.valuespec;

import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.uml2.diagram.common.Messages;
import org.eclipse.uml2.uml.Duration;
import org.eclipse.uml2.uml.Expression;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.Interval;
import org.eclipse.uml2.uml.LiteralBoolean;
import org.eclipse.uml2.uml.LiteralInteger;
import org.eclipse.uml2.uml.LiteralNull;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.LiteralUnlimitedNatural;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.TimeExpression;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.util.UMLSwitch;

public class ValueSpecificationParserUtil {
	public static String getEditString(ValueSpecification valueSpecification) {
		UMLSwitch<String> valueSpecificationSwitch = new UMLSwitch<String>() {
			@Override
			public String caseDuration(Duration duration) {
				return ValueSpecificationParserUtil.getEditString(duration.getExpr());
			}
			
			@Override
			public String caseExpression(Expression expression) {
				StringBuffer expressionDenotation = new StringBuffer();
				String symbol = expression.getSymbol();
				if (symbol != null) {
					expressionDenotation.append(symbol);
				}
				EList<ValueSpecification> operands = expression.getOperands();
				if (!operands.isEmpty()) {
					expressionDenotation.append('(');
					for (Iterator<ValueSpecification> operandsIterator = operands.iterator(); operandsIterator.hasNext();) {
						ValueSpecification operand = operandsIterator.next();
						expressionDenotation.append(ValueSpecificationParserUtil.getEditString(operand));
						if (operandsIterator.hasNext()) {
							expressionDenotation.append(',');
						}
					}
					expressionDenotation.append('(');
				}
				return expressionDenotation.toString();
			}
			
			@Override
			public String caseInstanceValue(InstanceValue instanceValue) {
				InstanceSpecification instanceSpecification = instanceValue.getInstance();
				if (instanceSpecification == null) {
					return StringStatics.BLANK;
				}
				return instanceSpecification.getName();
			}
			
			@Override
			public String caseInterval(Interval interval) {
				ValueSpecification min = interval.getMin();
				ValueSpecification max = interval.getMax();
				if (min == null && max == null) {
					return StringStatics.BLANK;
				}
				StringBuffer intervalDenotation = new StringBuffer();
				if (min != null) {
					intervalDenotation.append(ValueSpecificationParserUtil.getEditString(min));
				}
				intervalDenotation.append(".."); //$NON-NLS-1$
				if (max != null) {
					intervalDenotation.append(ValueSpecificationParserUtil.getEditString(max));
				}
				return super.caseInterval(interval);
			}
			
			@Override
			public String caseLiteralBoolean(LiteralBoolean literalBoolean) {
				return literalBoolean.isValue() ? Boolean.TRUE.toString() : Boolean.FALSE.toString();
			}
			
			@Override
			public String caseLiteralInteger(LiteralInteger literalInteger) {
				return Integer.toString(literalInteger.getValue());
			}
			
			@Override
			public String caseLiteralNull(LiteralNull literalNull) {
				return Messages.ValueSpecificationParserUtil_literal_null;
			}
			
			@Override
			public String caseLiteralString(LiteralString literalString) {
				String value = literalString.getValue();
				return value != null ? value : StringStatics.BLANK;
			}
			
			@Override
			public String caseLiteralUnlimitedNatural(LiteralUnlimitedNatural literalUnlimitedNatural) {
				return "*"; //$NON-NLS-1$
			}
			
			@Override
			public String caseOpaqueExpression(OpaqueExpression opaqueExpression) {
				StringBuffer opaqueExpressionDenotation = new StringBuffer();
				EList<String> languages = opaqueExpression.getLanguages();
				if (!languages.isEmpty()) {
					opaqueExpressionDenotation.append('{');
					for (Iterator<String> languagesIterator = languages.iterator(); languagesIterator.hasNext();) {
						opaqueExpressionDenotation.append(languagesIterator.next());
					}
					opaqueExpressionDenotation.append('}');
				}
				EList<String> bodies = opaqueExpression.getBodies();
				for (Iterator<String> bodiesIterator = bodies.iterator(); bodiesIterator.hasNext();) {
					opaqueExpressionDenotation.append(bodiesIterator.next());
					if (bodiesIterator.hasNext()) {
						opaqueExpressionDenotation.append(' ');
					}
				}				
				return opaqueExpressionDenotation.toString();
			}
			
			@Override
			public String caseTimeExpression(TimeExpression timeExpression) {
				return ValueSpecificationParserUtil.getEditString(timeExpression.getExpr());
			}
		};
		return valueSpecificationSwitch.doSwitch(valueSpecification);
	}
}
