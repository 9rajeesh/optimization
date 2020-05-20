package org.supersymmetry.integration;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class CNF3TableEvaluator {

	static Map<String,Integer> variableMap = new LinkedHashMap<String,Integer>();
	static List<String> vlist = new ArrayList<String>();
	static List<CNF3> clauses = new ArrayList<CNF3>();
	
	
	static Integer max = new Integer(0);
	private static int clauseCount = 500;
	private static double variables = 100;
	public static Integer calculatedMax = 0;
	
	public static void generate() {

		while (clauses.size() < clauseCount ) {
			Integer v1 = (int) (Math.random() * variables );
			Integer v2 = (int) (Math.random() * variables);
			Integer v3 = (int) (Math.random() * variables);
			
			if(Math.random()>0.5){
			v1 =-1*v1;
			}
			
			if(Math.random()>0.5){
			v2 =-1*v2;
			}
			
			if(Math.random()>0.5){
			v3 =-1*v3;
			}
			
			CNF3 cnf = new CNF3("v" + v1, "v" + v2, "v"+v3);

			if (v1 == v2 || v2==v3 || v1==v3) {
			continue;
			}

			if (clauses.contains(cnf)) {
			System.out.println("skipping");
			continue;
			}
			clauses.add(cnf);
		}
		clauses.forEach(clause -> System.out.println(clause));
	}
	
	
	public static void main(String[] args) throws IOException{
		
		init();
		generate();
		init();
		//clauses = CNFReader.generate();
		
		//clauses.add(new CNF3("v1","v2","v3"));
		
		//iterateDouble();
		//iterate();
		
		//calculateSingle();
		calculateRandom();
		for(int i=0;i<20;i++){
		CNF3Flipper.flip();
		}
		
		//calculateSingleAllPossible();
	
		//calculateMultiple();
		//calculateSquare();
		
		//calculateDouble();
		//calculateRandom();
		
		
	}
	
	
	public static void init(){
		 variableMap = new LinkedHashMap<String,Integer>();
		 vlist = new ArrayList<String>();
		 max = new Integer(0);
		 
	clauses.forEach((clause)->{
			variableMap.put(clause.getA1().replaceAll("-", ""),0);
			variableMap.put(clause.getA2().replaceAll("-", ""), 0);
			variableMap.put(clause.getA3().replaceAll("-", ""), 0);
		});
		
		variableMap.forEach((key,value)->{
			if(!vlist.contains(key)){
				vlist.add(key);
			}
		});
	}
	/*
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
	*/
	
	public static void calculateDouble() {
		init();
		Integer size = variableMap.size();
		
		CNF3Integrator cnf3Integrator = new CNF3Integrator();
		for(int i=0;i<size;i++){
			
			cnf3Integrator.evaluateOverDoubleClauses(vlist.get(i));
			
		}
		
		
			
		
		
		System.out.println("Single Maxima occured at:"+variableMap);
		//BigInteger max5 = evaluateSum();
		//System.out.println("Single Maiximum value is:"+max5);
	}
	
	public static void calculateMultiple() {
		init();
		Integer size = variableMap.size();
		
		CNF3Integrator cnf3Integrator = new CNF3Integrator();
		for(int i=0;i<size;i=i+8){
		cnf3Integrator.evaluateOverMultiClauses(vlist.get(i),vlist.get(i+1),vlist.get(i+2),vlist.get(i+3),
				                               vlist.get(i+4),vlist.get(i+5),vlist.get(i+6),vlist.get(i+7));
		}
		
		copyVariableMap(cnf3Integrator);
		
		System.out.println("Multi Maxima occured at:"+variableMap);
		Integer max5 = evaluateSum();
		System.out.println("Multi Maiximum value is:"+max5);
	}
	
	public static void calculateSingle() {
		init();
		Integer size = variableMap.size();
		
		CNF3Integrator cnf3Integrator = new CNF3Integrator();
		for(int i=0;i<size;i++){
		cnf3Integrator.evaluateOverSingleClauses(vlist.get(i));
		}
		
		copyVariableMap(cnf3Integrator);
		
		System.out.println("Single Maxima occured at:"+variableMap);
		Integer max5 = evaluateSum();
		System.out.println("Single Maiximum value is:"+max5);
		calculatedMax=max5;
	}
	
	public static void calculateSquare() {
		init();
		Integer size = variableMap.size();
		
		CNF3Integrator cnf3Integrator = new CNF3Integrator();
		for(int i=0;i<size;i++){
		cnf3Integrator.evaluateOverSquareClauses(vlist.get(i));
		}
		
		copyVariableMap(cnf3Integrator);
		
		System.out.println("Square Maxima occured at:"+variableMap);
		Integer max5 = evaluateSum();
		System.out.println("Square Maiximum value is:"+max5);
	}
	
	private static void copyVariableMap(CNF3Integrator cnf3Integrator) {
		
		cnf3Integrator.variables.forEach((key,value)->{
			if("0".equals(value)){
			variableMap.put(key, 0);
			}
			
			else{
			variableMap.put(key, 1);	
			}
			
		});
	}


	public static void calculateSingleAllPossible() {
	
	init();
	Integer size = variableMap.size();
		
	CNF3Integrator cnf3Integrator = new CNF3Integrator();
	
	for(int j=0;j<size;j++){
		for(int i=0;i<size;i++){
		
			String variable = vlist.get(i);
			
			if(cnf3Integrator.variables.get(variable)!=null && 
					(cnf3Integrator.variables.get(variable).equalsIgnoreCase("0")
					|| cnf3Integrator.variables.get(variable).equalsIgnoreCase("1"))){
				continue;
			}
			
		cnf3Integrator.evaluateOverSingleClausesAllPossibleValues(variable);
		}
		
		checkMaxDifferenceAndAssignValue(cnf3Integrator);
	}
	    copyVariableMap(cnf3Integrator);
		System.out.println("All Maxima occured at:"+variableMap);
		Integer max5 = evaluateSum();
		System.out.println("All Maiximum value is:"+max5);
	}
	
	
	private static void checkMaxDifferenceAndAssignValue(CNF3Integrator cNF3Integrator) {
		
		BigInteger max = new BigInteger("0");
		BigInteger currentDiff = new BigInteger("0");
		String currentVariable = "";
		
		for(Entry entry:CNF3Integrator.diffMap.entrySet()){
			
			String value = (String)entry.getKey();
			BigInteger diff = (BigInteger)entry.getValue();
			BigInteger diffsq = diff.multiply(diff);
			
			if(diffsq.compareTo(max) > 0){
				max = diffsq;
				currentDiff = diff;
				currentVariable = value;
				
			}
	    }
		
		if(currentDiff.compareTo(new BigInteger("0")) >0 ){
		cNF3Integrator.variables.put(currentVariable, "0");
		}
		else{
		cNF3Integrator.variables.put(currentVariable, "1");	
		}
		
		CNF3Integrator.diffMap= new HashMap<String,BigInteger>();
	}


	public static void calculateRandom(){
		
		variableMap.forEach((key,value)->{
			
			Integer value1 = 0;
			double a = Math.random();
			
			if(a>0.5){
			value1	= 1;
			}
			variableMap.put(key, value1);
		});
		Integer evaluatedValue = evaluateSum();
		System.out.println("Random sum is:"+evaluatedValue);
	}

	
	public static void iterate() {
		
		init();
		Integer size = variableMap.size();
		Long start = 0L;
		Long end = new Double(Math.pow(2, size)).longValue();
		CNF3Integrator cnf3Integrator = new CNF3Integrator();
		
		for(int i=0;i<size;i++){
		
			Integer zerosum =0;
			Integer onesum =  0;
			System.out.println("   ");
			Long count = 0L;
			for(long index=start; index<end; index++){
				
			
			String value = pad(Long.toBinaryString(index),size);
			variableMap = assignValues(value);
			Integer evaluatedValue = evaluateSum();
			//System.out.println("Value i at:"+value+ " is:"+evaluatedValue);
			
			if(evaluatedValue > max){
				max = evaluatedValue;
			}
			if(evaluatedValue>98){
				count = count + 1;
			}
			
			if(value.charAt(i)=='0'){
			zerosum=zerosum + (evaluatedValue);
			}
			else if(value.charAt(i)=='1'){
			onesum=onesum + (evaluatedValue);
			}
		   }
			System.out.println("Count  is:"+count);
			System.out.println("Max  is:"+max);
			System.out.println("zero sum is:"+zerosum);
			System.out.println("one sum is:"+onesum);
			
			
			cnf3Integrator.evaluateOverSingleClauses(vlist.get(i));
			//XORIntegrator.compute5(vlist.get(i));
			
			
			
		 if(zerosum.compareTo(onesum) > 0){
		 end = end -(end-start)/2;
		 }
		 else{
		 start = start + (end-start)/2;	 
		 }
		}
		
		
				
	}
	
public static void iterateDouble() {
		
		init();
		Integer size = variableMap.size();
		Long start = 0L;
		Long end = new Double(Math.pow(2, size)).longValue();
		CNF3Integrator cnf3Integrator = new CNF3Integrator();
		
		for(int i=0;i<size;i++){
		
			Long zerosum =0L;
			Long onesum =  0L;
			System.out.println("   ");
			Long count = 0L;
			for(long index=start; index<end; index++){
				
			
			String value = pad(Long.toBinaryString(index),size);
			variableMap = assignValues(value);
			Integer evaluatedValue = evaluateSum();
			//System.out.println("Value i at:"+value+ " is:"+evaluatedValue);
			
			if(evaluatedValue > max){
				max = evaluatedValue;
			}
			if(evaluatedValue>98){
				count = count + 1;
			}
			
			if(value.charAt(i)=='0'){
			zerosum=zerosum + (evaluatedValue*evaluatedValue);
			}
			else if(value.charAt(i)=='1'){
			onesum=onesum + (evaluatedValue*evaluatedValue);
			}
		   }
			System.out.println("Count  is:"+count);
			System.out.println("Max  is:"+max);
			System.out.println("zero sum is:"+zerosum);
			System.out.println("one sum is:"+onesum);
			
			
			cnf3Integrator.evaluateOverSquareClauses(vlist.get(i));
			//XORIntegrator.compute5(vlist.get(i));
			
			
			
		 if(zerosum.compareTo(onesum) > 0){
		 end = end -(end-start)/2;
		 }
		 else{
		 start = start + (end-start)/2;	 
		 }
		}
		
		
				
	}
	
	
	public  static  Integer  evaluateSum() {
		
		return   clauses
		        .stream()
		        .collect(Collectors.summingInt(CNF3::evaluate));
		         
			
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
