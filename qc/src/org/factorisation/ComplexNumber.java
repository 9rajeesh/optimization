package org.factorisation;

import java.math.BigDecimal;

public class ComplexNumber {

	BigDecimal real;
	BigDecimal img;
	
	public ComplexNumber(BigDecimal real,BigDecimal img){
		
		this.real = real;
		this.img = img;
	}
	
    public ComplexNumber(ComplexNumber complex){
		
		this.real = complex.real;
		this.img = complex.img;
	}
	
	
   public static ComplexNumber multiply (ComplexNumber number1, ComplexNumber number2){
	   BigDecimal a =  number1.real.multiply(number2.real);
	   BigDecimal b =  number1.img.multiply(number2.img);
	   
	   BigDecimal c =  number1.real.multiply(number2.img);
	   BigDecimal d =  number1.img.multiply(number2.real);
	   
	   return new ComplexNumber(a.subtract(b),
			                    c.add(b));
	}
   
   public static ComplexNumber add (ComplexNumber number1, ComplexNumber number2){
		
		return new ComplexNumber(number1.real.add(number2.real), number1.img.add(number2.img));
	}
   
   public  BigDecimal getMagnitude (){
		
		return ((this.real.multiply(this.real)) .add(this.img.multiply(this.img)));
	}
  
   
}
