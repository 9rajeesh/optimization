package org.supersymmetry.simple.sum;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class Utility {

	
	private static Map<Integer,BigDecimal> factorialCache = new HashMap<Integer,BigDecimal>();
	private static Map<Integer,Double> factorialDoubleCache = new HashMap<Integer,Double>();
	private static Map<String,BigDecimal> combCache = new HashMap<String,BigDecimal>();
	private static Map<String,BigDecimal> powIntCache = new HashMap<String,BigDecimal>();
	private static Map<String,BigDecimal> powDoubleCache = new HashMap<String,BigDecimal>();
	
	
	public static Integer factorial1(Integer factorial) {
		Integer value = 1;
		
		if(factorial.equals(0) || factorial.equals(1)){
		return 1;
		}
		
    	while(factorial>=1){
    	value=value*factorial;	
    	factorial=factorial-1;	
    	}
    	
		return value;
	}
	
	public static BigDecimal factorial(Integer factorial) {
		
		Integer factorialOriginal = new Integer(factorial);
		
		BigDecimal value = new BigDecimal(1.0);
		
		if(factorialCache.containsKey(factorial)){
		return factorialCache.get(factorial);
		}
		
		else if(factorialCache.containsKey(factorial-1)){
		value =  factorialCache.get(factorial-1).multiply(new BigDecimal(factorialOriginal));
		factorialCache.put(factorialOriginal, value);
		return value;
		}
		
		if(factorial.equals(0) || factorial.equals(1)){
		return value;
		}
		
    	while(factorial>=1){
    	value=value.multiply(new BigDecimal(factorial));	
    	factorial=factorial-1;	
    	}
    	
    	factorialCache.put(factorialOriginal, value);
		return value;
	}
	
	public static Double factorial_double(Integer factorial) {
		Double value = new Double(1.0);
		
		if(factorialDoubleCache.containsKey(factorial)){
		return factorialDoubleCache.get(factorial);
		}
		
		if(factorial.equals(0) || factorial.equals(1)){
		return value;
		}
		
    	while(factorial>=1){
    	value=value*factorial;	
    	factorial=factorial-1;	
    	}
    	factorialDoubleCache.put(factorial, value);
		return value;
	}
	/*
	public static Double comb(Integer n, Integer r) {
		if(r.equals(0)){
			return 1.0;
		}
		
		return (factorial(n)+0.0)/(factorial(r)*factorial(n-r));
	}
	*/
	
	public static BigDecimal comb(Integer n, Integer r) {
		if(r.equals(0)){
			return new BigDecimal(1.0);
		}
		
		if(combCache.containsKey(n+",C," +r)){
		return combCache.get(n+",C," +r);
		}
		
		BigDecimal value = factorial(n)
				.divide(
				(factorial(r) .multiply (factorial(n-r)))
				);
		
		combCache.put(n+",C," +r, value);
		return value;
	}

	public static BigDecimal pow(int i, int j) {
		
		Integer i1 = new Integer(i);
		Integer j1 = new Integer(j);
		
		if(powIntCache.containsKey(i1+"P"+j1)){
		return powIntCache.get(i1+"P"+j1);
		}
		
		
		if(j==0){
		return new BigDecimal(1.0);
		}
		
		BigDecimal value = new BigDecimal(i);
		BigDecimal pow = new BigDecimal(i);
		
		while(j>1){
		pow=pow.multiply(value);
		j=j-1;
		}
		
		powIntCache.put(i1+"P"+j1,pow);
		return pow;
	}
	
   public static BigDecimal pow(double i, int j) {
		
	    Double i1 = new Double(i);
		Integer j1 = new Integer(j);
		
		if(powDoubleCache.containsKey(i1+"P"+j1)){
		return powDoubleCache.get(i1+"P"+j1);
		}
		
		if(j==0){
		return new BigDecimal(1.0);
		}
		
		BigDecimal value = new BigDecimal(i);
		BigDecimal pow = new BigDecimal(i);
		
		while(j>1){
		pow=pow.multiply(value,Conditional.getMathContext());
		j=j-1;
		}
		
		powDoubleCache.put(i1+"P"+j1,pow);
		return pow;
	}
	
}
