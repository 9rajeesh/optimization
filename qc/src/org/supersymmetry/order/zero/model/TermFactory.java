package org.supersymmetry.order.zero.model;

import java.util.ArrayList;
import java.util.List;

public class TermFactory {

	public static void createTerms() {
		
		Term a1 = new Term();
		Literal a = new Literal("a");
		a1.getMap().put(a, 1);
				
		Term b1 = new Term();
		Literal b = new Literal("b");
		b1.getMap().put(b, 1);
		
		
		Term c1 = new Term();
		Literal c = new Literal("c");
		c1.getMap().put(c, 1);
		
		List<Term> terms1 = new ArrayList<Term>();
		terms1.add(a1);
		terms1.add(b1);
		terms1.add(c1);
		
		Expression e = new Expression(terms1);
		
		
		
		
		
	}
	
	
	
	
}
