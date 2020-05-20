package org.factorisation;

import java.math.BigDecimal;

public class Main {

	
	
	public static void main(String[] args){
		
		
		ComplexNumber result = new ComplexNumber(new BigDecimal("0.0"),new BigDecimal("0.0"));
		ComplexNumber c2 = new ComplexNumber(new BigDecimal("0.41"),new BigDecimal("0.30003"));
		
		for(int i=0;i<15;i++){
		result = ComplexNumber.multiply(result, result);
		result = ComplexNumber.add(result,c2);
		System.out.println(i + " Value is:"+result.getMagnitude().toEngineeringString());
		}
	}
	
	
	
	
}
