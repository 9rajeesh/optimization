package org.supersymmetry.order.zero;

import org.supersymmetry.order.zero.model.Expression;

public class Container {

	
	public void createXORs() {
		
	 Expression e1 = XOR.createXOR("a0","a1","a2");
	 Expression e2 = XOR.createXOR("a1","a2","a3");
	 Expression e3=  XOR.createXOR("a0","a1","a3");
	 
	 Expression cubed = cube(e1.add(e2).add(e3));
	
	 
	 cubed.evaluate("a1",0);
	 cubed.evaluate("a1", 1);
	 
	 
	 
	}

	private Expression cube(Expression e1) {
	
		return null;
	}
	
	
	
	
}
