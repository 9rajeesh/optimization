package org.supersymmetry.order.zero;

import org.supersymmetry.order.zero.model.Expression;
import org.supersymmetry.order.zero.model.Literal;
import org.supersymmetry.order.zero.model.Term;


public class ExpressionFactory {
	
	
	
	public static void create() {
		
		Literal a0 = new Literal("a0");
		Literal a1 = new Literal("a1");
		Literal a2 = new Literal("a2");
		
		Term term1 = new Term();
		term1.getMap().put(a0, 1);
		
		Term term2 = new Term();
		term2.getMap().put(a1, 1);
		
		Term term3 = new Term();
		term3.getMap().put(a2, 1);
		
		Expression exp = new Expression();
		exp.getTerms().add(term1);
		exp.getTerms().add(term2);
		exp.getTerms().add(term3);
		
		
		System.out.println("Terms are:"+exp);
		Expression exp3 = exp.multiply(exp, exp);
		exp3 = exp.mergeLikeTerms(exp3);
	    Expression exp5 = exp.multiply(exp3, exp3);
	    exp5 = exp.mergeLikeTerms(exp5);
		System.out.println("Terms are:"+exp5);
		
	}
	
	public static Expression createExpressionWithPower(int power,String... args) {
		
		Expression exp = new Expression();
		
		for(String s:args) {
		Literal a0 = new Literal(s);
		Term term1 = new Term();
		term1.getMap().put(a0, 1);
		exp.getTerms().add(term1);
		}
		
		Expression exp2 = exp;
		for(int i=0;i<power;i++) {
		exp2 = exp.multiply(exp2, exp);
	    exp2 = exp.mergeLikeTerms(exp2);	
		}
		System.out.println("Terms are:"+exp2);
		
		return exp2;
	}
	
	public static void main(String[] args) {
		createExpressionWithPower(26,"a0","a1","a2");
	}
	
	
	
	
	
	
	
	
}
