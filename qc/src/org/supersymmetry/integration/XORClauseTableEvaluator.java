package org.supersymmetry.integration;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class XORClauseTableEvaluator {

	static Map<String,Integer> variableMap = new LinkedHashMap<String,Integer>();
	static List<String> vlist = new ArrayList<String>();
	
	
	static BigInteger max = new BigInteger("0");
	
	
	public static void main(String[] args){
		
		List<XORClause> xorclauses = new ArrayList<XORClause>();
		xorclauses.add(new XORClause("v8","v0"));
		xorclauses.add(new XORClause("v0","v7"));
		xorclauses.add(new XORClause("v1","v0"));
		xorclauses.add(new XORClause("v3","v0"));
		xorclauses.add(new XORClause("v6","v3"));
		xorclauses.add(new XORClause("v9","v3"));
		
		xorclauses.add(new XORClause("v0","v4"));
		xorclauses.add(new XORClause("v9","v0"));
		xorclauses.add(new XORClause("v1","v4"));
		xorclauses.add(new XORClause("v2","v0"));
		xorclauses.add(new XORClause("v2","v7"));
		xorclauses.add(new XORClause("v8","v1"));
		
		
		xorclauses.add(new XORClause("v2","v6"));
		xorclauses.add(new XORClause("v9","v6"));
		xorclauses.add(new XORClause("v1","v6"));
		
				
		XORClauseGenerator.xorcluses=xorclauses;
		
		iterate();
		
	}
	
	
	public static void init(){
		 variableMap = new LinkedHashMap<String,Integer>();
		 vlist = new ArrayList<String>();
		 max = new BigInteger("0");
		 
		XORClauseGenerator.xorcluses.forEach((clause)->{
			variableMap.put(clause.getV1(), 0);
			variableMap.put(clause.getV2(), 0);
		});
		
		variableMap.forEach((key,value)->{
			if(!vlist.contains(key)){
				vlist.add(key);
			}
		});
	}
	
	public static void tree() {
		init();
		Integer size = variableMap.size();
		Long start = 0L;
		Long end = new Double(Math.pow(2, size)).longValue();
		
		for(long index=start; index<end; index++){
			
			String value = pad(Long.toBinaryString(index),size);
			variableMap = assignValues(value);
			BigInteger evaluatedValue = evaluateSum();
			
			//System.out.println("Value at:"+value+ " is:"+evaluatedValue);
			
			if(evaluatedValue.compareTo(max) > 0 ){
			max = evaluatedValue;
			}
		}
		
		System.out.println("5 Original Max is:"+max);
		
		
	}
	
	public static void calculateSingleSquare() {
		init();
		Integer size = variableMap.size();
		
		XORIntegrator XORIntegrator = new XORIntegrator();
		for(int i=0;i<size;i++){
			
			XORIntegrator.evaluateOverSingleClausesSquare(vlist.get(i));
			
		}
		
		XORIntegrator.variables.forEach((key,value)->{
			
			variableMap.put(key, Integer.parseInt(value));
		});
		System.out.println("Single square Maxima occured at:"+variableMap);
		BigInteger max5 = evaluateSum();
		System.out.println("Single sqaure Maiximum value is:"+max5);
	}
	
	public static void calculateSingle() {
		init();
		Integer size = variableMap.size();
		
		XORIntegrator XORIntegrator = new XORIntegrator();
		for(int i=0;i<size;i++){
			
			XORIntegrator.evaluateOverSingleClauses(vlist.get(i));
			
		}
		
		XORIntegrator.variables.forEach((key,value)->{
			
			variableMap.put(key, Integer.parseInt(value));
		});
		System.out.println("Single Maxima occured at:"+variableMap);
		BigInteger max5 = evaluateSum();
		System.out.println("Single Maiximum value is:"+max5);
	}

	public static void calculate() {
		init();
		Integer size = variableMap.size();
		
		XORIntegrator XORIntegrator = new XORIntegrator();
		for(int i=0;i<size;i++){
			
			XORIntegrator.evaluateOverMultipleClauses(vlist.get(i));
			
		}
		
		XORIntegrator.variables.forEach((key,value)->{
			
			variableMap.put(key, Integer.parseInt(value));
		});
		System.out.println("Maxima occured at:"+variableMap);
		BigInteger max5 = evaluateSum();
		System.out.println("Maiximum value is:"+max5);
	}
	


	public static void iterate() {
		
		init();
		Integer size = variableMap.size();
		Long start = 0L;
		Long end = new Double(Math.pow(2, size)).longValue();
		XORIntegrator XORIntegrator = new XORIntegrator();
		
		for(int i=0;i<size;i++){
		
			BigInteger zerosum = new BigInteger("0");
			BigInteger onesum =  new BigInteger("0");
			System.out.println("   ");
		
			for(long index=start; index<end; index++){
			String value = pad(Long.toBinaryString(index),size);
			variableMap = assignValues(value);
			BigInteger evaluatedValue = evaluateSum();
			//System.out.println("Value i at:"+value+ " is:"+evaluatedValue);
			
			if(value.charAt(i)=='0'){
			zerosum=zerosum.add(evaluatedValue);
			}
			else if(value.charAt(i)=='1'){
			onesum=onesum.add(evaluatedValue);
			}
		   }
			
			System.out.println("zero sum is:"+zerosum);
			System.out.println("one sum is:"+onesum);
			
			
			//XORIntegrator.compute5(vlist.get(i));
			
			
			
		 if(zerosum.compareTo(onesum) > 0){
		 end = end -(end-start)/2;
		 }
		 else{
		 start = start + (end-start)/2;	 
		 }
		}
		
		
				
	}
	
	
	private  static  BigInteger  evaluateSum() {
		
		return   XORClauseGenerator.xorcluses
		        .stream()
		        .map(clause -> clause.evaluate())
		        .reduce(BigInteger::add).get();
			
	}

	private  static  BigInteger  evaluate() {
	
		return   XORClauseGenerator.xorcluses
		        .stream()
		        .map(clause -> clause.evaluate())
		        .reduce(BigInteger::multiply).get();
			
	}
		
		
		
	

	private static Map<String, Integer> assignValues(String value) {
		
	
		
		for(int i=0;i<value.length();i++){
			char c = value.charAt(i);
	
			if(c=='0'){
			variableMap.put(vlist.get(i),0);	
			}
			
			if(c=='1'){
			variableMap.put(vlist.get(i),1);	
			}
		}
		
		return variableMap;
	}

	private static String pad(String binaryString, Integer size) {
		
		while(binaryString.length()<size){
		binaryString="0"+binaryString;
		}
		
		return binaryString;
	}
	
	
   }
