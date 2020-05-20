package org.supersymmetry.grid.tree;

import java.util.Map;

public class SAT3 implements SAT{

	
	
	private String v1;
	private String v2;
	private String v3;
	
		
	public SAT3(SAT3 sat3) {
		super();
		this.v1 = sat3.v1;
		this.v2 = sat3.v2;
		this.v3 = sat3.v3;
	}
	
	
	public SAT3(String v1, String v2, String v3) {
		super();
		this.v1 = v1;
		this.v2 = v2;
		this.v3 = v3;
	}



	@Override
	public Integer evaluate(Map variableMap) {
	
	 Integer a =  evaluateIndividualTerm(v1,variableMap);
	 Integer b =  evaluateIndividualTerm(v2,variableMap);
	 Integer c =  evaluateIndividualTerm(v3,variableMap);
	    
	if(a.equals(0) && b.equals(0) && c.equals(0)) {
	return 0;
	}
	else{
	return 1;
	}
	    
		
	}



	private  Integer evaluateIndividualTerm(String variable,Map<String,Integer> variableMap) {
	
		Integer value = variableMap.get(variable.replaceAll("-", ""));
		if(variable.contains("-")){
		return flip(value);
		}
		return value;
	}



	private Integer flip(Integer value) {
	
		if(value.equals(0)){
		return 1;
		}
		else if(value.equals(1)){
		return 0;
		}
		
		return null;
	}



	public String getV1() {
		return v1;
	}



	public void setV1(String v1) {
		this.v1 = v1;
	}



	public String getV2() {
		return v2;
	}



	public void setV2(String v2) {
		this.v2 = v2;
	}



	public String getV3() {
		return v3;
	}



	public void setV3(String v3) {
		this.v3 = v3;
	}

	public boolean containsVariable(String variable){
		
		if(this.v1.replaceAll("-", "").equalsIgnoreCase(variable)){
		return true;
		}
		
		if(this.v2.replaceAll("-", "").equalsIgnoreCase(variable)){
		return true;
		}
		
		if(this.v3.replaceAll("-", "").equalsIgnoreCase(variable)){
		return true;
		}
		
		return false;
		
	}


	@Override
	public String toString() {
		return "SAT3 [v1=" + v1 + ", v2=" + v2 + ", v3=" + v3 + "]";
	}
	
	
	
}
