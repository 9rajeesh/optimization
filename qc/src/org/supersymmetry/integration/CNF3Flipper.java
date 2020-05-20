package org.supersymmetry.integration;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CNF3Flipper {

	
	
	
	
	
	public static List<CNF3> getUnsatifiedClauses(){
		
		List<CNF3> cnf3UnsatisfiedList = new ArrayList<CNF3>(); 
		CNF3TableEvaluator.clauses.forEach(cnf->{
			
			if(cnf.evaluate().equals(0)){
				cnf3UnsatisfiedList.add(cnf);
			}
		});;
		
		
		return cnf3UnsatisfiedList;
	}
	
	
    public static void flip(){
		
    	List<CNF3> cnfs = getUnsatifiedClauses();
    	Set<String> uniqueVatriables = new HashSet();
    	
    	cnfs.forEach(cnf->{
    		
    		uniqueVatriables.add((cnf.getA1().replaceAll("-", "")));
    		uniqueVatriables.add((cnf.getA2().replaceAll("-", "")));
    		uniqueVatriables.add((cnf.getA3().replaceAll("-", "")));
    	});
    	
    	uniqueVatriables.forEach(variable->{
    		flipAndEvaluate(variable);
    	});
    	
    	Integer sum = CNF3TableEvaluator.evaluateSum();
    	System.out.println("Value after last flipping: is:"+sum);
    	
		
	}
	
    public static void flipAndEvaluate(String variable){
		
    	Integer value = CNF3TableEvaluator.variableMap.get(variable);
    	
    	if(value.equals(0)){
    	CNF3TableEvaluator.variableMap.put(variable,new Integer(1));	
    	}
    	
    	else if(value.equals(1)){
    	CNF3TableEvaluator.variableMap.put(variable,new Integer(0));	
    	}
    	
    	Integer sum = CNF3TableEvaluator.evaluateSum();
    	System.out.println("Value after flipping:"+variable +" is:"+sum);
    	
    	if(sum > CNF3TableEvaluator.calculatedMax){
    		CNF3TableEvaluator.calculatedMax = sum;
    	}
    	
    	
    	if(! (sum>=CNF3TableEvaluator.calculatedMax)){
    	System.out.println("Bad flip reverting back");
    	CNF3TableEvaluator.variableMap.put(variable,value);
    	}
    	
		
	}
	
}
