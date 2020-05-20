package org.supersymmetry.order.zero;

import java.math.BigDecimal;

import org.supersymmetry.order.zero.model.Expression;



public class XOR {

	
	private static int max = 11;

	
	public static void main(String[] args) {
		
		Expression e = createSine("a0","a1","a2");
		System.out.println("Expression is:"+e);
		System.out.println("Value is:"+e.evaluate("", 5));
	}
	
	
	public static Expression createXOR(String...args) {
		Expression sine = createSine(args);
		sine = sine.multiply(sine, sine);
		return sine;
	}
	
	
	
	public static Expression createSine(String... args) {
		
		int initial = 1;
		Expression sum = new Expression();
		int count = 0;
		for(initial=1;initial<=max;initial = initial + 2) {
		Double scale = getScale(initial)*Math.pow(-1,count);
		Expression e = ExpressionFactory.createExpressionWithPower(initial-1,args);
		e.setScale(scale);
		sum = sum.add(e);
		//sum =e;
		count++;
		}
		
	return sum;
	}

	private static Double getScale(int initial) {
	return 1.0/((factorial(initial)));
	}



	private static Long factorial(int i) {
		Long factorial = 1L;
		Long num = 1L;
		while(num<=i) {
			factorial =	factorial*num;
			num++;
		}
		return factorial;
	}
	
	
	
	
	
}
