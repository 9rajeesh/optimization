package org.supersymmetry.simple.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class PGenerator {

	static int variable_count = 45;
	static int condition_count = 80;
	static int vpercond = 26;
	
	@Test
	public void generateVariables(){
				
		for(int i=1;i<=variable_count;i++){
		System.out.println("Variable v"+i+" = new Variable(\"v"+i+"\");");
		}
		
		List<String> variableList = new ArrayList<String>();
		for(int i=1;i<=variable_count;i++){
		variableList.add("v"+i);
		}
		
		
		for(int i=1;i<=condition_count;i++){
			List<String> condList = new ArrayList<String>();
			
			while(condList.size()<vpercond){
			
				for(String var:variableList){
				if(!condList.contains(var)){
					if(Math.random()<0.1){
					condList.add(var);
					}
				 }
			   } 
			
		    }
		System.out.println("Conditional a"+i+" =  createConditional ("+genCondiitional(condList)+");");	
			
			
			
		}
		
		
		System.out.println("PInstance pInstance = createPIntance("+generateCommaSeparatedCond()+");");
		//PInstance pInstance = createPIntance(a1,b1,c1,d1,e1,f1,g1,h1);
		System.out.println("pInstance.setVariables(Arrays.asList("+generateCommSeapratedVariables()+");");
		
	
		
	}

	private String generateCommSeapratedVariables() {
		String s = "";
		for(int i=1;i<=variable_count;i++){
			s= s+ "v"+i +",";
		}
		return s.substring(0,s.length()-1);
	}

	private String generateCommaSeparatedCond() {
		String s = "";
		for(int i=1;i<=condition_count;i++){
			s= s+ "a"+i +",";
		}
		return s.substring(0,s.length()-1);
	}

	private String genCondiitional(List<String> condList) {
	
		return condList.stream().collect(Collectors.joining(","));
		
	
	}
		
		
		
	
	
	
	
	
	
	
}
